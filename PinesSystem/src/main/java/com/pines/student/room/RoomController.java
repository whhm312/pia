package com.pines.student.room;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.StudentIdentify;
import com.pines.student.common.vo.StudentRoom;
import com.pines.student.room.vo.RegisterStudentRoomsResultResponse;

@RestController
public class RoomController {

	@Autowired
	RoomDao roomDao;

	@Autowired
	RoomExcelUploadService roomExcelUploadService;

	@Value("${pia.file.download.path}")
	String FILE_DOWNLOAD_PATH;

	@Value("${pia.download.room.path}")
	String DOWNLOAD_ROOM_PATH;

	@Value("${pia.file.upload.path}")
	String FILE_UPLOAD_PATH;

	@Value("${pia.upload.room.path}")
	String UPLOAD_ROOM_PATH;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/students/{studentId}/rooms/{roomName}")
	public CommonResponseResult updateRoomSetting(@PathVariable(value = "studentId", required = true) String studentId, @PathVariable(value = "roomName", required = true) String roomName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = roomDao.updateStudentRoom(authentication.getName(), roomName, studentId);
		if (isSuccessed) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500_DB);
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/rooms/upload")
	public CommonResponseResult registerRoomSettings(MultipartHttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile excelFile = request.getFile("rooms");
		if (excelFile == null || excelFile.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String originalFilename = excelFile.getOriginalFilename();
		String fileExtension = FileTools.getFileExtension(originalFilename);
		if (Tools.isEmpty(fileExtension)) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String staffId = authentication.getName();
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_ROOM_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_ROOM_PATH + FileTools.getUploadFilename(staffId, fileExtension));
		List<StudentRoom> studentRooms = null;
		try {
			excelFile.transferTo(destFile);
			studentRooms = roomExcelUploadService.getRoomSettings(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		try {
			List<RegisterStudentRoomsResultResponse> response = new ArrayList<RegisterStudentRoomsResultResponse>();
			RegisterStudentRoomsResultResponse registerFailedStudentResult = null;

			List<StudentRoom> registerFailedStudents = roomDao.registerRoomSettings(staffId, studentRooms);
			for (StudentRoom studentRoom : registerFailedStudents) {
				registerFailedStudentResult = new RegisterStudentRoomsResultResponse();
				registerFailedStudentResult.setRoom(studentRoom.getRoom());
				for (StudentIdentify studentIdentify : studentRoom.getStudents()) {
					registerFailedStudentResult.addStudent(studentIdentify.getName());
				}
				response.add(registerFailedStudentResult);
			}

			String failedFilePath = null;
			if (!response.isEmpty()) {
				FileTools.makeDirs(FILE_DOWNLOAD_PATH + DOWNLOAD_ROOM_PATH);

				String fileName = "Roomsetting_failed_list";
				failedFilePath = FILE_DOWNLOAD_PATH + DOWNLOAD_ROOM_PATH + FileTools.getUploadFilename(fileName, ".txt");
				PrintWriter writer = new PrintWriter(failedFilePath, "UTF-8");
				int num = 1;
				for (RegisterStudentRoomsResultResponse failedStudent : response) {
					writer.println((num++) + ". " + failedStudent);
				}
				writer.close();
			}

			if (response.isEmpty()) {
				result.setSuccessBody();
				result.setSuccessHead();
			} else {
				result.setBody(new CommonResponseBody(1, failedFilePath));
				result.setSuccessHead();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_400, e.getCause().toString());
		}
		return result;
	}
}
