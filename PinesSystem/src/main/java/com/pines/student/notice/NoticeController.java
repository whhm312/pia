package com.pines.student.notice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Notice;
import com.pines.student.common.vo.UploadFile;
import com.pines.student.notice.vo.AddNoticeRequest;
import com.pines.student.notice.vo.AddNoticeResponse;
import com.pines.student.notice.vo.ChangeNoticeRequest;
import com.pines.student.notice.vo.NoticeResponse;
import com.pines.student.notice.vo.NoticesByLanguageResponse;
import com.pines.student.notice.vo.NoticesRequest;
import com.pines.student.notice.vo.NoticesResponse;

@RestController
public class NoticeController {

	@Autowired
	NoticeDao noticeDao;

	@Value("${pia.file.upload.path}")
	String FILE_UPLOAD_PATH;

	@Value("${pia.notice.path}")
	String STUDENT_PICTURE_PATH;

	@GetMapping("/branches/{branchSeq}/notices/languages/{languageSeq}")
	public CommonResponseResult getNoticesByLanguage(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "languageSeq", required = true) int languageSeq, @RequestParam(value = "selectedPage", required = true) int selectedPage,
			@RequestParam(value = "offset", required = true) int offset) {
		CommonResponseResult result = new CommonResponseResult();

		List<Notice> notices = noticeDao.getNotices(branchSeq, languageSeq, Tools.getStartIndex(selectedPage, offset), offset);
		List<NoticesByLanguageResponse> response = new ArrayList<NoticesByLanguageResponse>();
		NoticesByLanguageResponse noticeResponse = null;
		for (Notice notice : notices) {
			noticeResponse = new NoticesByLanguageResponse();
			noticeResponse.setNoticeSeq(notice.getNoticeSeq());
			noticeResponse.setTitle(Tools.blankInsteadOfNull(notice.getTitle()));
			noticeResponse.setWriter(Tools.blankInsteadOfNull(notice.getWriter()));
			noticeResponse.setHasAttachment(notice.hasAttachment());
			noticeResponse.setTopOfList(notice.getIsTopOfList());
			noticeResponse.setRegisterDate(Tools.blankInsteadOfNull(notice.getFormRegisterDate()));
			noticeResponse.setShortRegisterDate(Tools.blankInsteadOfNull(notice.getFormShortRegisterDate()));
			response.add(noticeResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (notices.size() > 0) {
			body.setTotalCount(notices.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@GetMapping("/branches/{branchSeq}/notices/{noticeSeq}")
	public CommonResponseResult getNotice(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "noticeSeq", required = true) int noticeSeq) {
		CommonResponseResult result = new CommonResponseResult();

		Notice notice = noticeDao.getNotice(branchSeq, noticeSeq);
		CommonResponseBody body = new CommonResponseBody();
		if (notice.getNoticeSeq() < 1) {
			body.setEmpty();
		} else {
			body.setData(new NoticeResponse(notice));
			body.setTotalCount(1);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/notices")
	public CommonResponseResult getNotices(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters, @RequestParam(name = "languageSeqs[]", required = false) List<Integer> languageSeqs) throws UnsupportedEncodingException {
		CommonResponseResult result = new CommonResponseResult();

		NoticesRequest request = new NoticesRequest(branchSeq, parameters, languageSeqs);
		List<Notice> notices = noticeDao.getNotices(request.getConditions());
		List<NoticesResponse> response = new ArrayList<NoticesResponse>();
		NoticesResponse noticeResponse = null;
		for (Notice notice : notices) {
			noticeResponse = new NoticesResponse();
			noticeResponse.setNoticeSeq(notice.getNoticeSeq());
			noticeResponse.setBranch(Tools.blankInsteadOfNull(notice.getBranch()));
			noticeResponse.setLanguage(Tools.blankInsteadOfNull(notice.getLanguage()));
			noticeResponse.setType(Tools.blankInsteadOfNull(notice.getType()));
			noticeResponse.setTitle(Tools.blankInsteadOfNull(notice.getTitle()));
			noticeResponse.setWriter(Tools.blankInsteadOfNull(notice.getWriter()));
			noticeResponse.setHasAttachment(notice.hasAttachment());
			noticeResponse.setIsTopOfList(notice.getIsTopOfList());
			noticeResponse.setTopOfList(Tools.blankInsteadOfNull(notice.getTopOfList()));
			noticeResponse.setRegisterDate(Tools.blankInsteadOfNull(notice.getFormRegisterDate()));
			noticeResponse.setIsForAll(notice.getIsForAll());
			response.add(noticeResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (notices.size() > 0) {
			body.setTotalCount(notices.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/notices")
	public CommonResponseResult addNotice(@PathVariable(value = "branchSeq", required = true) int branchSeq, AddNoticeRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.setWriterId(authentication.getName());
		request.setBranchSeq(branchSeq);

		CommonResponseResult result = new CommonResponseResult();
		MultipartFile multipartFile = request.getAttachment();
		if (request.isHasAttachment() && (multipartFile == null || multipartFile.isEmpty())) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		UploadFile uploadFile = null;
		try {
			uploadFile = FileTools.upload(multipartFile, FILE_UPLOAD_PATH + STUDENT_PICTURE_PATH);
			if (request.isHasAttachment() && uploadFile.getFile() != null) {
				multipartFile.transferTo(uploadFile.getFile());
				uploadFile.setFileSize(multipartFile.getSize());
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
		}

		int noticeSeq = noticeDao.addNotice(request.getNotice(), uploadFile.getAttachment());
		if (noticeSeq > 0) {
			AddNoticeResponse response = new AddNoticeResponse();
			response.setNoticeSeq(noticeSeq);

			result.setSuccessHead();
			result.setBody(new CommonResponseBody(1, response));
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/notices/{noticeSeq}")
	public CommonResponseResult changeNotice(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "noticeSeq", required = true) int noticeSeq, ChangeNoticeRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.setWriterId(authentication.getName());
		request.setBranchSeq(branchSeq);
		request.setNoticeSeq(noticeSeq);

		CommonResponseResult result = new CommonResponseResult();
		boolean isVaildWriter = noticeDao.isValidWriter(branchSeq, noticeSeq, request.getWriterId());
		if (!isVaildWriter) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		MultipartFile multipartFile = request.getAttachment();
		if (request.isHasAttachment() && (multipartFile == null || multipartFile.isEmpty())) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String filePath = null;
		UploadFile uploadFile = null;

		try {
			uploadFile = FileTools.upload(multipartFile, FILE_UPLOAD_PATH + STUDENT_PICTURE_PATH);
			if (request.isHasAttachment() && uploadFile.getFile() != null) {
				multipartFile.transferTo(uploadFile.getFile());
				uploadFile.setFileSize(multipartFile.getSize());
			}

			if (request.getIsDeleteAttachment()) {
				filePath = noticeDao.getDeleteAttachmentPath(noticeSeq);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
		}

		boolean isSuccessed = noticeDao.changeNotice(request.getNotice(), uploadFile.getAttachment());
		if (isSuccessed) {
			if (request.getIsDeleteAttachment()) {
				FileTools.deleteFile(filePath);
			}

			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/notices/{noticeSeq}")
	public CommonResponseResult removeNotice(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "noticeSeq", required = true) int noticeSeq) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();
		boolean isVaildWriter = noticeDao.isValidWriter(branchSeq, noticeSeq, authentication.getName());
		if (!isVaildWriter) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = noticeDao.removeNotice(branchSeq, noticeSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
