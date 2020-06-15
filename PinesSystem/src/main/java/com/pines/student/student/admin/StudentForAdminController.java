package com.pines.student.student.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.IdCardExcel;
import com.pines.student.common.vo.NewStudentExcel;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.StudentDetail;
import com.pines.student.common.vo.StudentNameExcel;
import com.pines.student.student.StudentDao;
import com.pines.student.student.admin.vo.AddStudentRequest;
import com.pines.student.student.admin.vo.ChangePeriodRequest;
import com.pines.student.student.admin.vo.ChangeStudentNameRequest;
import com.pines.student.student.admin.vo.ChangeStudentNameResultResponse;
import com.pines.student.student.admin.vo.ChangeStudentRequest;
import com.pines.student.student.admin.vo.RegisterIdCardsResultResponse;
import com.pines.student.student.admin.vo.RegisterStudentIdCardRequest;
import com.pines.student.student.admin.vo.StudentDetailResponse;
import com.pines.student.student.admin.vo.StudentsByLevelResponse;
import com.pines.student.student.admin.vo.StudentsExcelView;
import com.pines.student.student.admin.vo.StudentsRequest;
import com.pines.student.student.admin.vo.StudentsResponse;
import com.pines.student.student.vo.ChangeStudentPasswordRequest;

@RestController
public class StudentForAdminController {

	@Autowired
	StudentForAdminDao studentForAdminDao;

	@Autowired
	StudentDao studentDao;

	@Autowired
	NewStudentExcelUploadService newStudentExcelUploadService;

	@Autowired
	IdCardExcelUploadService idCardExcelUploadService;

	@Autowired
	ChangStudentNameExcelUploadService changStudentNameExcelUploadService;

	@Value("${pia.file.upload.path}")
	private String FILE_UPLOAD_PATH;

	@Value("${pia.student.profile.picture.path}")
	private String STUDENT_PICTURE_PATH;

	@Value("${pia.upload.freshmen.path}")
	private String UPLOAD_FRESHMEN_PATH;

	@Value("${pia.upload.idcard.path}")
	private String UPLOAD_IDCARD_PATH;

	@Value("${pia.upload.changename.path}")
	private String UPLOAD_CHANGENAME_PATH;

	@Value("${pia.file.download.path}")
	private String FILE_DOWNLOAD_PATH;

	@Value("${pia.download.freshman.path}")
	private String DOWNLOAD_FRESHMAN_PATH;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/students")
	public CommonResponseResult getStudents(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters, @RequestParam(name = "campusSeqs[]", required = false) List<Integer> campusSeqs,
			@RequestParam(name = "nationalitySeqs[]", required = false) List<Integer> nationalitySeqs, @RequestParam(name = "status[]", required = false) List<String> statuses) {
		CommonResponseResult result = new CommonResponseResult();
		StudentsRequest request = new StudentsRequest(branchSeq, parameters, campusSeqs, nationalitySeqs, statuses);

		List<Student> students = studentForAdminDao.getStudents(request.getConditions());
		List<StudentsResponse> response = new ArrayList<StudentsResponse>();
		StudentsResponse studentResponse = null;
		for (Student student : students) {
			studentResponse = new StudentsResponse();
			studentResponse.setBranchSeq(student.getBranchSeq());
			studentResponse.setStudentId(student.getStudentId());
			studentResponse.setBranch(Tools.blankInsteadOfNull(student.getBranch()));
			studentResponse.setCampus(Tools.blankInsteadOfNull(student.getCampus()));
			studentResponse.setGroup(Tools.blankInsteadOfNull(student.getGroup()));
			studentResponse.setTerm(Tools.blankInsteadOfNull(student.getTerm()));
			studentResponse.setNationality(Tools.blankInsteadOfNull(student.getNationalityCode()));
			studentResponse.setInDate(Tools.blankInsteadOfNull(student.getFormDateOfStartContract()));
			studentResponse.setOutDate(Tools.blankInsteadOfNull(student.getFormDateOfEndContract()));
			studentResponse.setName(Tools.blankInsteadOfNull(student.getStrName()));
			studentResponse.setDayOfBirth(Tools.blankInsteadOfNull(student.getFormDateOfBirth()));
			studentResponse.setRoom(Tools.blankInsteadOfNull(student.getRoom()));
			studentResponse.setSex(Tools.blankInsteadOfNull(student.getSex()));
			studentResponse.setLevel(Tools.blankInsteadOfNull(student.getLevel()));
			studentResponse.setCourse(Tools.blankInsteadOfNull(student.getCourse()));
			studentResponse.setRequestCourse(Tools.blankInsteadOfNull(student.getRequestCourse()));

			response.add(studentResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (students.size() > 0) {
			body.setTotalCount(students.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/students/{studentId}")
	public CommonResponseResult getStudent(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		StudentDetail student = studentForAdminDao.getStudent(branchSeq, studentId);
		if (student == null) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(new StudentDetailResponse(student));
		body.setTotalCount(1);
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/{studentId}/change")
	public CommonResponseResult changeBasicInformation(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
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

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/{studentId}/state/block")
	public CommonResponseResult blockStudent(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isSuccessed = studentForAdminDao.blockStudent(studentId);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/{studentId}/state/unblock")
	public CommonResponseResult unblockStudent(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isSuccessed = studentForAdminDao.unblockStudent(studentId);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/students/{studentId}")
	public CommonResponseResult removeStudent(@PathVariable(value = "studentId", required = true) String studentId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidStudent = studentForAdminDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		String staffId = authentication.getName();
		boolean isSuccessed = studentForAdminDao.removeStudent(staffId, studentId);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students")
	public CommonResponseResult addStudent(@RequestBody AddStudentRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = studentForAdminDao.addStudent(request.getStudent());
		if (isSuccessed) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/freshmen/upload")
	public CommonResponseResult registerFreshmen(MultipartHttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile excelFile = request.getFile("students");
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
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_FRESHMEN_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_FRESHMEN_PATH + FileTools.getUploadFilename(staffId, fileExtension));
		List<NewStudentExcel> freshmen = null;
		try {
			excelFile.transferTo(destFile);
			freshmen = newStudentExcelUploadService.getFreshmen(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		try {
			Map<String, List<NewStudentExcel>> separateStudents = studentForAdminDao.seperateFreshmen(staffId, freshmen);
			List<NewStudentExcel> enrolledStudents = separateStudents.get("enrolledStudents");
			List<NewStudentExcel> newStudents = separateStudents.get("newStudents");
			List<NewStudentExcel> duplicatedStudents = separateStudents.get("duplicationStudents");
			List<NewStudentExcel> errorStudents = separateStudents.get("errorStudents");

			List<NewStudentExcel> updateFailedStudents = studentForAdminDao.updateFreshmen(staffId, enrolledStudents);
			List<NewStudentExcel> insertFailedStudents = studentForAdminDao.addFreshmen(staffId, newStudents);

			String failedFilePath = makeResultFile(separateStudents, enrolledStudents, newStudents, duplicatedStudents, errorStudents, updateFailedStudents, insertFailedStudents);

			if (separateStudents.isEmpty()) {
				result.setFailureHead(ResultCode.STATUS_204, ResultCode.STATUS_204.getMessage());
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

	private String makeResultFile(Map<String, List<NewStudentExcel>> separateStudents, List<NewStudentExcel> enrolledStudents, List<NewStudentExcel> newStudents, List<NewStudentExcel> duplicatedStudents, List<NewStudentExcel> errorStudents,
			List<NewStudentExcel> updateFailedStudents, List<NewStudentExcel> insertFailedStudents) throws FileNotFoundException, UnsupportedEncodingException {
		String failedFilePath = FILE_DOWNLOAD_PATH + DOWNLOAD_FRESHMAN_PATH + "Results_of_freshman_registering.txt";
		FileTools.makeDirs(FILE_DOWNLOAD_PATH + DOWNLOAD_FRESHMAN_PATH);

		if (!separateStudents.isEmpty()) {

			PrintWriter writer = new PrintWriter(failedFilePath, "UTF-8");
			int num = 1;
			if (!errorStudents.isEmpty()) {
				writer.println("[ERROR!! START]");
				writer.println("");

				for (NewStudentExcel errorStudent : errorStudents) {
					writer.println((num++) + ". Name : " + errorStudent.getF_Name() + " : " + errorStudent.toString());
				}
				writer.println("[ERROR!! END]");
				writer.println("");
			}

			num = 1;
			if (!enrolledStudents.isEmpty() || !newStudents.isEmpty() || !duplicatedStudents.isEmpty()) {
				writer.println("[RESULT OF READ FRESHMAN EXCEL FILE]");
				writer.println("");
			}

			if (!enrolledStudents.isEmpty()) {
				writer.println("[**] Enrolled Students Start ======================================================================== ");
			}
			for (NewStudentExcel enrolledStudent : enrolledStudents) {
				writer.println((num++) + ". Name : " + enrolledStudent.getF_Name() + ", Birthday : " + enrolledStudent.getK_Birthday());
			}
			if (!enrolledStudents.isEmpty()) {
				writer.println("[**] Enrolled Students End ========================================================================== ");
				writer.println("");
			}

			num = 1;
			if (!newStudents.isEmpty()) {
				writer.println("[**] Freshman Start ======================================================================== ");
			}
			for (NewStudentExcel newStudent : newStudents) {
				writer.println((num++) + ". Name : " + newStudent.getF_Name() + ", Birthday : " + newStudent.getK_Birthday() + ", HINT : " + Tools.blankInsteadOfNull(newStudent.getErrorHint()));
			}
			if (!newStudents.isEmpty()) {
				writer.println("[**] Freshman End ========================================================================== ");
				writer.println("");
			}

			num = 1;
			if (!duplicatedStudents.isEmpty()) {
				writer.println("[**] Already Registered Freshman Start ======================================================================== ");
			}
			for (NewStudentExcel duplicatedStudent : duplicatedStudents) {
				writer.println((num++) + ". Name : " + duplicatedStudent.getF_Name() + ", Birthday : " + duplicatedStudent.getK_Birthday());
			}
			if (!duplicatedStudents.isEmpty()) {
				writer.println("[**] Already Registered Freshman End ========================================================================== ");
				writer.println("");
			}

			writer.println("");
			writer.println("[RESULT OF REGISTER FRESHMAN AND RE-ENROLL STUDENTS]");

			num = 1;
			if (!updateFailedStudents.isEmpty()) {
				writer.println("");
				writer.println("[**] Failed Re-Enroll Students Start ======================================================================== ");
			} else if (!enrolledStudents.isEmpty() && updateFailedStudents.isEmpty()) {
				writer.println("");
				writer.println("[**] Succeeded Re-Enroll Students ======================================================================== ");
			}
			for (NewStudentExcel updateFailedStudent : updateFailedStudents) {
				writer.println((num++) + ". Name : " + updateFailedStudent.getF_Name() + ", Birthday : " + updateFailedStudent.getK_Birthday() + ", HINT : " + updateFailedStudent.getErrorHint());
			}
			if (!updateFailedStudents.isEmpty()) {
				writer.println("[**] Failed Re-Enroll Students End ========================================================================== ");
				writer.println("");
			}

			num = 1;
			if (!insertFailedStudents.isEmpty()) {
				writer.println("");
				writer.println("[**] Failed Register freshman Start ======================================================================== ");
			} else if (!newStudents.isEmpty() && insertFailedStudents.isEmpty()) {
				writer.println("");
				writer.println("[**] Succeeded Register freshman ======================================================================== ");
			}
			for (NewStudentExcel updateFailedStudent : insertFailedStudents) {
				writer.println((num++) + ". Name : " + updateFailedStudent.getF_Name() + ", Birthday : " + updateFailedStudent.getK_Birthday() + ", HINT : " + updateFailedStudent.getErrorHint());
			}
			if (!insertFailedStudents.isEmpty()) {
				writer.println("[**] Failed Register freshman End ========================================================================== ");
				writer.println("");
			}

			writer.close();
		}
		return failedFilePath;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/students/levels/{levelSeq}")
	public CommonResponseResult getStudentsByLevel(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "levelSeq", required = true) int levelSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Student> students = studentForAdminDao.getStudentsByLevel(branchSeq, campusSeq, levelSeq);
		List<StudentsByLevelResponse> response = new ArrayList<StudentsByLevelResponse>();
		StudentsByLevelResponse studentResponse = null;
		for (Student student : students) {
			studentResponse = new StudentsByLevelResponse();
			studentResponse.setStudentId(student.getStudentId());
			studentResponse.setName(Tools.blankInsteadOfNull(student.getStrName()));
			studentResponse.setDayOfBirth(Tools.blankInsteadOfNull(student.getFormDateOfBirth()));
			response.add(studentResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (students.size() > 0) {
			body.setTotalCount(students.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@GetMapping("/branches/{branchSeq}/students/download")
	public ModelAndView getStudentsDownload(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters, @RequestParam(name = "campusSeqs[]", required = false) List<Integer> campusSeqs,
			@RequestParam(name = "nationalitySeqs[]", required = false) List<Integer> nationalitySeqs, @RequestParam(name = "status[]", required = false) List<String> statuses, HttpServletResponse response) {
		StudentsRequest request = new StudentsRequest(branchSeq, parameters, campusSeqs, nationalitySeqs, statuses);
		request.setOffset(-1);
		List<Student> students = studentForAdminDao.getStudents(request.getConditions());

		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=Students.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", students);
		return new ModelAndView(new StudentsExcelView(), model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/students/{studentId}/change/name")
	public CommonResponseResult changeStudentName(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentNameRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		if (Tools.isEmpty(request.getStudentName())) {
			result.setFailureHead(ResultCode.STATUS_400);
			return result;
		}

		boolean isSuccessed = studentForAdminDao.changeStudentName(studentId, request.getStudentName());

		if (isSuccessed) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/students/{studentId}/change/idcard")
	public CommonResponseResult registerStudentIdCard(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody RegisterStudentIdCardRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		if (Tools.isEmpty(request.getIdCardSerialNumber())) {
			result.setFailureHead(ResultCode.STATUS_400);
			return result;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = false;
		try {
			isSuccessed = studentForAdminDao.registerStudentIdCard(request.getStudentIdCard(authentication.getName(), studentId));
		} catch (Exception e) {
			result.setFailureHead(ResultCode.STATUS_10007);
			return result;
		}

		if (isSuccessed) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/students/{studentId}/change/period")
	public CommonResponseResult changePeriod(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangePeriodRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = studentForAdminDao.changePeriod(request.getNewPeriod(authentication.getName(), studentId));
		if (isSuccessed) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/{studentId}/change/password")
	public CommonResponseResult changePassword(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentPasswordRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = studentDao.changeStudentPassword(studentId, request.getNewPassword());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/{studentId}/upload/profile")
	public CommonResponseResult registerProfilePicture(@PathVariable(value = "studentId", required = true) String studentId, MultipartHttpServletRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile profileFile = request.getFile("profile");
		if (profileFile == null || profileFile.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String originalFilename = profileFile.getOriginalFilename();
		String fileExtension = FileTools.getFileExtension(originalFilename);
		if (Tools.isEmpty(fileExtension)) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String studentName = request.getParameter("studentName");
		studentName = Tools.removeAllSpaces(studentName);
		String term = request.getParameter("term");
		FileTools.makeDirs(FILE_UPLOAD_PATH + STUDENT_PICTURE_PATH + term + "/");
		File destFile = new File(FILE_UPLOAD_PATH + STUDENT_PICTURE_PATH + term + "/" + FileTools.getUploadFilename(studentName, fileExtension));

		try {
			profileFile.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean isSuccessed = studentForAdminDao.registerProfilePicture(studentId, originalFilename, destFile);
		if (isSuccessed) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/idcard/upload")
	public CommonResponseResult registerIdCards(MultipartHttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile excelFile = request.getFile("students");
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
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_IDCARD_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_IDCARD_PATH + FileTools.getUploadFilename(staffId, fileExtension));
		List<IdCardExcel> idCardExcels = null;
		try {
			excelFile.transferTo(destFile);
			idCardExcels = idCardExcelUploadService.getIdCards(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		try {
			List<IdCardExcel> updateFailedStudents = studentForAdminDao.registerIdCards(staffId, idCardExcels);

			RegisterIdCardsResultResponse response = new RegisterIdCardsResultResponse();
			response.setUpdateFailedStudents(updateFailedStudents);

			if (updateFailedStudents.isEmpty()) {
				result.setSuccessBody();
				result.setSuccessHead();
			} else {
				result.setBody(new CommonResponseBody(updateFailedStudents.size(), response));
				result.setSuccessHead();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_400, e.getCause().toString());
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/names/upload")
	public CommonResponseResult changeStudentName(MultipartHttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile excelFile = request.getFile("students");
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
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_CHANGENAME_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_CHANGENAME_PATH + FileTools.getUploadFilename(staffId, fileExtension));
		List<StudentNameExcel> excelContents = null;
		try {
			excelFile.transferTo(destFile);
			excelContents = changStudentNameExcelUploadService.getContentInExcel(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		try {
			List<StudentNameExcel> updateFailedStudents = studentForAdminDao.changeStudentNames(staffId, excelContents);

			ChangeStudentNameResultResponse response = new ChangeStudentNameResultResponse();
			response.setUpdateFailedStudents(updateFailedStudents);

			if (updateFailedStudents.isEmpty()) {
				result.setSuccessBody();
				result.setSuccessHead();
			} else {
				result.setBody(new CommonResponseBody(updateFailedStudents.size(), response));
				result.setSuccessHead();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_400, e.getCause().toString());
		}
		return result;
	}
}
