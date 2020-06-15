package com.pines.student.exam.result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.ExamResult;
import com.pines.student.common.vo.UploadFile;
import com.pines.student.exam.result.vo.AddExamResultResponse;
import com.pines.student.exam.result.vo.AddExamResultsRequest;
import com.pines.student.exam.result.vo.StduentExamResultResponse;

@RestController
public class ExamResultController {

	@Autowired
	ExamResultDao examResultDao;

	@Value("${pia.file.upload.path}")
	String FILE_UPLOAD_PATH;

	@Value("${pia.exam.result.path}")
	String EXAM_RESULT_PATH;

	@GetMapping("/students/{studentId}/exams/results")
	public CommonResponseResult getExamResults(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		List<ExamResult> examResults = examResultDao.getExamResults(studentId);

		List<StduentExamResultResponse> response = new ArrayList<StduentExamResultResponse>();
		StduentExamResultResponse stduentExamResultResponse = null;
		for (ExamResult examResult : examResults) {
			stduentExamResultResponse = new StduentExamResultResponse();
			stduentExamResultResponse.setExamType(Tools.blankInsteadOfNull(examResult.getExamType()));
			stduentExamResultResponse.setExamStartDate(Tools.blankInsteadOfNull(examResult.getExamStartDate()));
			stduentExamResultResponse.setExamEndDate(Tools.blankInsteadOfNull(examResult.getExamEndDate()));
			stduentExamResultResponse.setTerm(Tools.blankInsteadOfNull(examResult.getTerm()));
			stduentExamResultResponse.setFileName(stduentExamResultResponse.getTerm() + " " + stduentExamResultResponse.getExamType() + " " + Tools.blankInsteadOfNull(examResult.getStudentName()));
			stduentExamResultResponse.setFilePath(Tools.blankInsteadOfNull(examResult.getResultFilePath()));
			response.add(stduentExamResultResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		if (examResults.isEmpty()) {
			body.setEmpty();
		} else {
			body.setTotalCount(examResults.get(0).getTotalCount());
			body.setData(response);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/exams/{examSeq}/results")
	public CommonResponseResult addExamResults(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termSeq", required = true) int termSeq,
			@PathVariable(value = "examSeq", required = true) int examSeq, AddExamResultsRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile multipartFile = request.getFile();
		if (multipartFile == null || multipartFile.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		UploadFile uploadFile = null;
		String detailPath = examResultDao.getPath(branchSeq, campusSeq, termSeq, examSeq);
		detailPath = FileTools.replaceAllBlankToUnderbar(detailPath);
		String filePath = FILE_UPLOAD_PATH + EXAM_RESULT_PATH + detailPath;
		try {
			uploadFile = FileTools.upload(multipartFile, filePath);
			if (uploadFile.getFile() != null) {
				multipartFile.transferTo(uploadFile.getFile());
				uploadFile.setFileSize(multipartFile.getSize());
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ExamResult requestExamResult = request.getExamResult(examSeq, authentication.getName(), uploadFile.getFileDownloadUrl());
		int resultSeq = examResultDao.addExamResults(requestExamResult);
		if (resultSeq > 0) {
			result.setSuccessHead();

			AddExamResultResponse response = new AddExamResultResponse();
			response.setResultSeq(resultSeq);
			result.setBody(new CommonResponseBody(1, response));
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/exams/{examSeq}/results/{resultSeq}")
	public CommonResponseResult removeExamResults(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termSeq", required = true) int termSeq,
			@PathVariable(value = "examSeq", required = true) int examSeq, @PathVariable(value = "resultSeq", required = true) int resultSeq) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String resultFilePath = examResultDao.removeExamResult(examSeq, resultSeq, authentication.getName());
		if (Tools.isNotEmpty(resultFilePath)) {
			FileTools.deleteFile(resultFilePath);

			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

}
