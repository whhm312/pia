package com.pines.student.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pines.student.alarm.AlarmDao;
import com.pines.student.common.push.AndroidPushNotificationsService;
import com.pines.student.common.vo.Alarm;
import com.pines.student.common.vo.PushHistory;
import com.pines.student.common.vo.PushRequest;
import com.pines.student.common.vo.PushResponse;
import com.pines.student.common.vo.StudentDevice;
import com.pines.student.push.vo.PushCondition;

@Service
public class PushService {
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;

	@Autowired
	PushDao pushDao;

	@Autowired
	AlarmDao alarmDao;

	private final int MAXIMUM_SEDING_DEVICE_COUNT = 1000;

	public PushResponse pushes(PushRequest push, PushCondition condition) {
		List<StudentDevice> studentIosDevices = pushDao.pushStudents(PushRequest.DEVICE_TYPE.IOS, condition);
		List<StudentDevice> studentAndroidDevices = pushDao.pushStudents(PushRequest.DEVICE_TYPE.ANDROID, condition);

		if (studentIosDevices.size() < 1 && studentAndroidDevices.size() < 1) {
			return new PushResponse();
		}

		List<JSONObject> bodies = new ArrayList<JSONObject>();
		bodies.addAll(getBodies(PushRequest.DEVICE_TYPE.IOS, push, studentIosDevices));
		bodies.addAll(getBodies(PushRequest.DEVICE_TYPE.ANDROID, push, studentAndroidDevices));

		List<PushResponse> pushResponses = new ArrayList<PushResponse>();
		for (JSONObject body : bodies) {
			pushResponses.add(getPushResponse(send(body)));
		}

		// 결과 합산하기
		int success = 0;
		int failure = 0;
		for (PushResponse pushResponse : pushResponses) {
			success += pushResponse.getSuccess();
			failure += pushResponse.getFailure();
		}

		// 결과 리턴하기
		PushResponse result = new PushResponse();
		result.setSuccess(success);
		result.setFailure(failure);

		return result;
	}

	public PushResponse push(PushRequest push, PushCondition condition) {
		return pushes(push, condition);
	}

	public boolean saveAlarm(String staffId, PushRequest push, PushCondition condition) {
		Alarm alarm = new Alarm();
		alarm.setMessage(push.getMessage());
		alarm.setReceiveId(condition.getStudentId());
		alarm.setSendId(staffId);
		return alarmDao.send(alarm);
	}

	public boolean savePushHistory(String staffId, PushRequest push, PushCondition condition, PushResponse rushResponse) {
		PushHistory history = new PushHistory();
		history.setReceiverStudentId(condition.getStudentId());
		history.setReceiverStudySeq(condition.getStudySeq());
		history.setReceiverNoticeSeq(condition.getNoticeSeq());
		history.setReceiverExamSeq(condition.getExamSeq());
		history.setReceiverRequestSeq(condition.getRequestSeq());
		history.setSendTotalCount(rushResponse.getSuccess() + rushResponse.getFailure());
		history.setSenderStaffId(staffId);
		history.setSendMenu(condition.getMenu());
		history.setMessage(push.getMessage());
		history.setTitle(push.getTitle());
		history.setImageUrl(push.getImageUrl());
		history.setSite(push.getSite());
		return pushDao.savePushHistory(history);
	}

	private List<JSONObject> getBodies(PushRequest.DEVICE_TYPE deviceType, PushRequest push, List<StudentDevice> studentDevices) {
		if (studentDevices.size() < 1) {
			return new ArrayList<JSONObject>();
		}

		List<JSONObject> bodies = new ArrayList<JSONObject>();
		if (studentDevices.size() <= MAXIMUM_SEDING_DEVICE_COUNT) {
			JSONObject body = null;
			if (deviceType == PushRequest.DEVICE_TYPE.ANDROID) {
				body = getAndroidJSONBody(push);
			} else {
				body = getIosJSONBody(push);
			}

			body.put("registration_ids", getRegisterationIds(studentDevices));
			bodies.add(body);
		} else {
			int totalStudentDevicesSize = studentDevices.size();
			List<List<StudentDevice>> dividedLists = new ArrayList<List<StudentDevice>>();
			int loofCount = totalStudentDevicesSize / MAXIMUM_SEDING_DEVICE_COUNT;
			int startIndex = 0;
			int endIndex = 0;

			// MAXIMUM_SEDING_DEVICE_COUNT 로 나눠서 담기,
			for (int i = 1; i <= loofCount; i++) {
				endIndex = (MAXIMUM_SEDING_DEVICE_COUNT * i);

				dividedLists.add(studentDevices.subList(startIndex, endIndex));

				startIndex = endIndex;
			}

			// MAXIMUM_SEDING_DEVICE_COUNT 로 나눈 나머지도 담기,
			if (totalStudentDevicesSize % MAXIMUM_SEDING_DEVICE_COUNT > 0) {
				int lastIndex = studentDevices.size();
				dividedLists.add(studentDevices.subList(endIndex, lastIndex));
			}

			JSONObject body = null;
			for (List<StudentDevice> dividedList : dividedLists) {
				if (deviceType == PushRequest.DEVICE_TYPE.ANDROID) {
					body = getAndroidJSONBody(push);
				} else {
					body = getIosJSONBody(push);
				}
				body.put("registration_ids", getRegisterationIds(dividedList));
				bodies.add(body);

				body = null;
			}
		}
		return bodies;
	}

	private JSONObject getAndroidJSONBody(PushRequest push) {
		JSONObject innerData = new JSONObject();
		innerData.put("title", push.getTitle());
		innerData.put("message", push.getMessage());
		innerData.put("image_url", push.getImageUrl());
		innerData.put("site", push.getSite());

		JSONObject outerData = new JSONObject();
		outerData.put("data", innerData);

		JSONObject body = new JSONObject();
		body.put("data", outerData);
		body.put("priority", "high");
		body.put("content-available", true);
		return body;
	}

	private JSONObject getIosJSONBody(PushRequest push) {
		JSONObject data = new JSONObject();
		data.put("goto", push.getSite());
		data.put("image-url", push.getImageUrl());

		JSONObject notification = new JSONObject();
		notification.put("title", push.getTitle());
		notification.put("body", push.getMessage());

		JSONObject aps = new JSONObject();
		aps.put("alert", "");

		JSONObject body = new JSONObject();
		body.put("data", data);
		body.put("notification", notification);
		body.put("aps", aps);
		body.put("priority", "high");
		body.put("mutable_content", true);
		body.put("content_available", true);
		body.put("image-url", "");
		return body;
	}

	private PushResponse getPushResponse(ResponseEntity<String> pushResult) {
		try {
			return new ObjectMapper().readValue(pushResult.getBody(), PushResponse.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			return new PushResponse();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new PushResponse();
		} catch (IOException e) {
			e.printStackTrace();
			return new PushResponse();
		}
	}

	private JSONArray getRegisterationIds(List<StudentDevice> studentDevices) {
		JSONArray registrationIds = new JSONArray();
		for (StudentDevice studentDevice : studentDevices) {
			registrationIds.put(studentDevice.getToken());
		}
		return registrationIds;
	}

	private ResponseEntity<String> send(JSONObject body) {
		try {
			HttpEntity<String> request = new HttpEntity<>(body.toString());
			CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
			CompletableFuture.allOf(pushNotification).join();
			String firebaseResponse = pushNotification.get();
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		} catch (ExecutionException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		} catch (JSONException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}
