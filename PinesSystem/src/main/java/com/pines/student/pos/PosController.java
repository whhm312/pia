package com.pines.student.pos;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.PosTransaction;
import com.pines.student.common.vo.SearchCondition;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.StudentIdCard;
import com.pines.student.common.vo.StudentPosBalance;
import com.pines.student.pos.vo.ChangeStudentPosInformationRequest;
import com.pines.student.pos.vo.PosStatementExcelView;
import com.pines.student.pos.vo.RegisterStudentsResponse;
import com.pines.student.pos.vo.StudentPosBalanceResponse;
import com.pines.student.student.admin.StudentForAdminDao;

@RestController
public class PosController {
	@Autowired
	PosDao posDao;

	@Autowired
	StudentForAdminDao studentForAdminDao;

	@GetMapping("/pos/students/{studentId}/balnace")
	public CommonResponseResult getBalance(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		StudentPosBalance studentPosBalance = posDao.getBalance(studentId);

		StudentPosBalanceResponse response = new StudentPosBalanceResponse();
		response.setBalance(Tools.getPesoFormat(studentPosBalance.getBalance()));

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		body.setTotalCount(1);

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@GetMapping("/pos/students/{studentId}/statement/download")
	public ModelAndView getPosStatementDownload(@PathVariable(value = "studentId", required = true) String studentId, HttpServletResponse response) throws UnsupportedEncodingException {
		List<PosTransaction> posTransactions = posDao.getPosTransactions(studentId);
		List<PosTransaction> posTransactionsWithOrders = posDao.getPosTransactionsWithOrders(studentId);
		StudentPosBalance studentPosBalance = posDao.getBalance(studentId);

		String filename = "PosStatement" + "_" + Tools.getTodayStringType("yyyy-MM-dd_HH:mm") + ".xls";
		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("posTransactions", posTransactions);
		model.put("posTransactionsWithOrders", posTransactionsWithOrders);
		model.put("posBalance", studentPosBalance);
		return new ModelAndView(new PosStatementExcelView(), model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/pos/branches/{branchSeq}/students")
	public CommonResponseResult registerStudents(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		try {

			SearchCondition condition = new SearchCondition();
			condition.setBranchSeq(branchSeq);

			List<String> statuses = new ArrayList<String>();
			statuses.add("PROGRESS");
			condition.setStatuses(statuses);

			List<Student> students = studentForAdminDao.getStudents(condition);
			int totalStudentSize = students.size();
			if (totalStudentSize < 1) {
				result.setFailureHead(ResultCode.STATUS_204);
				return result;
			}

			StudentIdCard studentIdCard = null;
			boolean isSuccessed = false;
			int successStudentCount = 0;
			int failureStudentCount = 0;
			for (Student student : students) {
				studentIdCard = new StudentIdCard();
				studentIdCard.setStudentName(student.getName());
				studentIdCard.setStudentId(student.getStudentId());
				studentIdCard.setIdCardSerialNumber(student.getIdCardSerialNumber());
				isSuccessed = posDao.registerStudent(studentIdCard);
				if (isSuccessed) {
					successStudentCount++;
				} else {
					failureStudentCount++;
				}
			}

			RegisterStudentsResponse response = new RegisterStudentsResponse();
			response.setTotalStudentSize(totalStudentSize);
			response.setSuccessStudentCount(successStudentCount);
			response.setFailureStudentCount(failureStudentCount);

			result.setSuccessHead();
			result.setBody(new CommonResponseBody(1, response));
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500, e.getMessage());
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/pos/students/{studentId}")
	public CommonResponseResult registerStudent(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();
		try {
			Student student = studentForAdminDao.getStudent(studentId);
			if (Tools.isEmpty(student.getStudentId())) {
				result.setFailureHead(ResultCode.STATUS_204);
				return result;
			}
			if (Tools.isEmpty(student.getIdCardSerialNumber())) {
				result.setFailureHead(ResultCode.STATUS_10009);
				return result;
			}

			StudentIdCard studentIdCard = new StudentIdCard();
			studentIdCard.setStudentName(student.getName());
			studentIdCard.setStudentId(student.getStudentId());
			studentIdCard.setIdCardSerialNumber(student.getIdCardSerialNumber());

			boolean isSuccessed = posDao.registerStudent(studentIdCard);
			if (isSuccessed) {
				result.setSuccessHead();
				result.setSuccessBody();
			} else {
				result.setFailureHead(ResultCode.STATUS_500);
			}
		} catch (Exception e) {
			result.setFailureHead(ResultCode.STATUS_500, e.getMessage());
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/pos/students/{studentId}")
	public CommonResponseResult changeStudent(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody ChangeStudentPosInformationRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		try {
			Student student = studentForAdminDao.getStudent(studentId);
			if (Tools.isEmpty(student.getStudentId())) {
				result.setFailureHead(ResultCode.STATUS_204);
				return result;
			}
			if (Tools.isEmpty(student.getIdCardSerialNumber())) {
				result.setFailureHead(ResultCode.STATUS_10009);
				return result;
			}

			boolean isSuccessed = posDao.updatePosSystem(request.getStudentIdCard(studentId, student.getName()));
			if (isSuccessed) {
				result.setSuccessHead();
				result.setSuccessBody();
			} else {
				result.setFailureHead(ResultCode.STATUS_500);
			}
		} catch (Exception e) {
			result.setFailureHead(ResultCode.STATUS_500, e.getMessage());
		}

		return result;
	}
}
