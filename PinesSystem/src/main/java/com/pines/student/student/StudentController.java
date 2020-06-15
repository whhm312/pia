package com.pines.student.student;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.UploadFile;
import com.pines.student.login.vo.StudentLoginDetailsVO;
import com.pines.student.request.RequestDao;
import com.pines.student.student.admin.StudentForAdminDao;
import com.pines.student.student.admin.vo.ChangeStudentRequest;
import com.pines.student.student.vo.ChangeExtraInformationRequest;
import com.pines.student.student.vo.ChangeStudentLanguageRequest;
import com.pines.student.student.vo.ChangeStudentPasswordRequest;
import com.pines.student.student.vo.RequestBasicInformationRequest;
import com.pines.student.student.vo.ResponseResetPassword;
import com.pines.student.student.vo.StudentCurriculumResponse;
import com.pines.student.student.vo.StudentResponse;

@RestController
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private RequestDao requestDao;

	@Autowired
	private StudentForAdminDao studentForAdminDao;

	@Value("${pia.file.upload.path}")
	private String FILE_UPLOAD_PATH;

	@Value("${pia.student.profile.picture.path}")
	private String STUDENT_PICTURE_PATH;

	@GetMapping("/students/{studentId}")
	public CommonResponseResult getStudent(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		Student student = studentDao.getStudent(studentId);
		if (student == null) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(new StudentResponse(student));
		body.setTotalCount(1);
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@GetMapping("/students/{studentId}/curriculum")
	public CommonResponseResult getCurriculum(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		Student student = studentDao.getStudent(studentId);
		if (student == null) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(new StudentCurriculumResponse(student));
		body.setTotalCount(1);
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PostMapping("/students/{studentId}/password/reset")
	public CommonResponseResult resetStudentPassword(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		Student student = studentDao.getStudent(studentId);
		if (student == null) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		String birthday = studentDao.resetStudentPassword(studentId);
		if (Tools.isNotEmpty(birthday)) {
			ResponseResetPassword response = new ResponseResetPassword();
			response.setBirthday(birthday);
			result.setSuccessHead();
			result.setBody(new CommonResponseBody(1, response));
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/students/{studentId}/password/change")
	public CommonResponseResult changeStudentPassword(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentPasswordRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		CommonResponseResult result = new CommonResponseResult();
		boolean isValidStudent = studentId.equals(authentication.getName());
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		isValidStudent = studentForAdminDao.isValidStudent(studentId, request.getCurrentPassword());
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isSuccessed = studentDao.changeStudentPassword(studentId, request.getNewPassword());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/students/{studentId}/language/change")
	public CommonResponseResult changeStudentLanguage(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentLanguageRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		CommonResponseResult result = new CommonResponseResult();
		boolean isValidStudent = studentForAdminDao.isValidStudent(authentication.getName());
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = studentDao.changeStudentLanguage(studentId, request.getLanguageSeq());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PutMapping("/students/{studentId}")
	public CommonResponseResult changeInformation(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();
		boolean isValidStudent = studentForAdminDao.isValidStudent(authentication.getName());
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}
		if (!studentId.equals(authentication.getName())) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = studentForAdminDao.changeInformation(request.getStudent(studentId));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PutMapping("/students/{studentId}/extra")
	public CommonResponseResult changeExtraInformation(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeExtraInformationRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isSuccessed = studentDao.changeExtraInformation(studentId, request.getStudent());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/students/{studentId}/picture")
	public CommonResponseResult registerStudentPicture(@PathVariable(value = "studentId", required = true) String studentId, MultipartHttpServletRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		MultipartFile multipartFile = request.getFile("image");
		if (multipartFile == null || multipartFile.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		try {
			UploadFile uploadFile = FileTools.upload(multipartFile, FILE_UPLOAD_PATH + STUDENT_PICTURE_PATH);
			multipartFile.transferTo(uploadFile.getFile());

			boolean isSuccessed = studentDao.registerStudentPicture(studentId, uploadFile);
			if (isSuccessed) {
				result.setSuccessHead();
				result.setSuccessBody();
			} else {
				result.setFailureHead(ResultCode.STATUS_500);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PostMapping("/students/{studentId}/basic/request")
	public CommonResponseResult requestBasicInformation(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody RequestBasicInformationRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		StudentLoginDetailsVO vo = (StudentLoginDetailsVO) authentication.getPrincipal();
		
		boolean isSuccessed = requestDao.addRequest(request.getRequest(vo.getBranchSeq(), studentId));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
