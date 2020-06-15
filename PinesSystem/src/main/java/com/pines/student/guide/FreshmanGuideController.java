package com.pines.student.guide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.pines.student.common.vo.FreshmanGuide;
import com.pines.student.common.vo.UploadFile;
import com.pines.student.guide.vo.AddFreshmanGuideRequest;
import com.pines.student.guide.vo.AddFreshmanGuideResponse;
import com.pines.student.guide.vo.ChangeFreshmanGuideRequest;
import com.pines.student.guide.vo.FreshmanGuideResponse;
import com.pines.student.guide.vo.FreshmanGuidesRequest;
import com.pines.student.guide.vo.FreshmanGuidesResponse;

@RestController
public class FreshmanGuideController {

	@Autowired
	FreshmanGuideDao guideDao;

	@Value("${pia.file.upload.path}")
	String FILE_UPLOAD_PATH;

	@Value("${pia.guide.freshman.path}")
	String FRESHMAN_GUIDE_PATH;

	@GetMapping("/branches/{branchSeq}/freshman/guides/nationalities/{nationalitySeq}")
	public CommonResponseResult getFreshmanGuidesByNationality(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "nationalitySeq", required = true) int nationalitySeq, @RequestParam(value = "selectedPage", required = true) int selectedPage,
			@RequestParam(value = "offset", required = true) int offset) {
		CommonResponseResult result = new CommonResponseResult();

		List<FreshmanGuide> guides = guideDao.getFreshmanGuides(branchSeq, nationalitySeq, Tools.getStartIndex(selectedPage, offset), offset);
		List<FreshmanGuidesResponse> response = new ArrayList<FreshmanGuidesResponse>();
		FreshmanGuidesResponse guidesResponse = null;
		for (FreshmanGuide guide : guides) {
			guidesResponse = new FreshmanGuidesResponse();
			guidesResponse.setGuideSeq(guide.getFreshmanGuideSeq());
			guidesResponse.setBranch(guide.getBranch());
			guidesResponse.setNationality(guide.getNationality());
			guidesResponse.setTitle(guide.getTitle());
			guidesResponse.setRegisterDate(guide.getShortFormRegisterDate());
			response.add(guidesResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (guides.size() > 0) {
			body.setTotalCount(guides.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@GetMapping("/branches/{branchSeq}/freshman/guides/{guideSeq}")
	public CommonResponseResult getFreshmanGuide(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "guideSeq", required = true) int guideSeq) {
		CommonResponseResult result = new CommonResponseResult();

		FreshmanGuide guide = guideDao.getFreshmanGuide(branchSeq, guideSeq);
		CommonResponseBody body = new CommonResponseBody();
		if (guide.getFreshmanGuideSeq() < 1) {
			body.setEmpty();
		} else {
			body.setData(new FreshmanGuideResponse(guide));
			body.setTotalCount(1);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/freshman/guides")
	public CommonResponseResult getFreshmanGuides(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam(name = "nationalitySeqs[]", required = false) List<Integer> nationalitySeqs, @RequestParam Map<String, String> parameters) {
		CommonResponseResult result = new CommonResponseResult();
		FreshmanGuidesRequest request = new FreshmanGuidesRequest(branchSeq, nationalitySeqs, parameters);

		List<FreshmanGuide> guides = guideDao.getFreshmanGuides(request.getConditions());
		List<FreshmanGuidesResponse> response = new ArrayList<FreshmanGuidesResponse>();
		FreshmanGuidesResponse guidesResponse = null;
		for (FreshmanGuide guide : guides) {
			guidesResponse = new FreshmanGuidesResponse();
			guidesResponse.setGuideSeq(guide.getFreshmanGuideSeq());
			guidesResponse.setBranchSeq(guide.getBranchSeq());
			guidesResponse.setBranch(Tools.blankInsteadOfNull(guide.getBranch()));
			guidesResponse.setNationality(Tools.blankInsteadOfNull(guide.getNationality()));
			guidesResponse.setGroup(Tools.blankInsteadOfNull(guide.getGroupName()));
			guidesResponse.setHasAttachment(guide.isHasAttachment());
			guidesResponse.setTitle(Tools.blankInsteadOfNull(guide.getTitle()));
			guidesResponse.setWriter(Tools.blankInsteadOfNull(guide.getWriter()));
			guidesResponse.setRegisterDate(Tools.blankInsteadOfNull(guide.getFormRegisterDate()));
			response.add(guidesResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (guides.size() > 0) {
			body.setTotalCount(guides.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/freshman/guides")
	public CommonResponseResult addFreshmanGuide(@PathVariable(value = "branchSeq", required = true) int branchSeq, AddFreshmanGuideRequest request) {
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
			uploadFile = FileTools.upload(multipartFile, FILE_UPLOAD_PATH + FRESHMAN_GUIDE_PATH);
			if (request.isHasAttachment() && uploadFile.getFile() != null) {
				multipartFile.transferTo(uploadFile.getFile());
				uploadFile.setFileSize(multipartFile.getSize());
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
		}

		int guideSeq = guideDao.addFreshmanGuide(request.getFreshmanGuide(), uploadFile.getAttachment());
		if (guideSeq > 0) {
			AddFreshmanGuideResponse response = new AddFreshmanGuideResponse();
			response.setGuideSeq(guideSeq);

			result.setSuccessHead();
			result.setBody(new CommonResponseBody(1, response));
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/freshman/guides/{guideSeq}")
	public CommonResponseResult changeFreshmanGuide(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "guideSeq", required = true) int guideSeq, ChangeFreshmanGuideRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.setWriterId(authentication.getName());
		request.setBranchSeq(branchSeq);
		request.setGuideSeq(guideSeq);

		CommonResponseResult result = new CommonResponseResult();
		boolean isVaildWriter = guideDao.isValidWriter(branchSeq, guideSeq, request.getWriterId());
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
			uploadFile = FileTools.upload(multipartFile, FILE_UPLOAD_PATH + FRESHMAN_GUIDE_PATH);
			if (request.isHasAttachment() && uploadFile.getFile() != null) {
				multipartFile.transferTo(uploadFile.getFile());
				uploadFile.setFileSize(multipartFile.getSize());
			}

			if (request.getIsDeleteAttachment()) {
				filePath = guideDao.getDeleteAttachmentPath(guideSeq);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
		}

		boolean isSuccessed = guideDao.changeFreshmanGuide(request.getFreshmanGuide(), uploadFile.getAttachment());
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
	@DeleteMapping("/branches/{branchSeq}/freshman/guides/{guideSeq}")
	public CommonResponseResult removeFreshmanGuide(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "guideSeq", required = true) int guideSeq) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		CommonResponseResult result = new CommonResponseResult();
		boolean isVaildWriter = guideDao.isValidWriter(branchSeq, guideSeq, authentication.getName());
		if (!isVaildWriter) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = guideDao.removeFreshmanGuide(branchSeq, guideSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@GetMapping("/branches/{branchSeq}/freshman/guides/{guideSeq}/download")
	public void download(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "guideSeq", required = true) int guideSeq, HttpServletResponse response) {
		// FreshmanGuide guide = guideDao.getFreshmanGuide(branchSeq, guideSeq);
		// String fileLocation = guide.getFileDownloadUrl();
	}

}
