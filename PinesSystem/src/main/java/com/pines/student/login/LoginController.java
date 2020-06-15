package com.pines.student.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Branch;
import com.pines.student.common.vo.Campus;
import com.pines.student.common.vo.Language;
import com.pines.student.login.vo.CookieDataResponse;
import com.pines.student.login.vo.LoginCampusResponse;
import com.pines.student.login.vo.StaffLoginDetailsVO;
import com.pines.student.login.vo.StaffLoginRequest;
import com.pines.student.login.vo.StaffLoginResponse;
import com.pines.student.login.vo.StudentAutoLogin;
import com.pines.student.login.vo.StudentAutoLoginResponse;
import com.pines.student.login.vo.StudentLoginDetailsVO;
import com.pines.student.login.vo.StudentLoginRequest;
import com.pines.student.login.vo.StudentLoginResponse;

@RestController
public class LoginController {

	@Autowired
	LoginDao loginDao;

	@PostMapping("/login")
	public CommonResponseResult login(@RequestBody StudentLoginRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		StudentLoginDetailsVO student = loginDao.login(request.getStudentId());
		if (Tools.isEmpty(student.getStudentId())) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		boolean isSuccessedLogin = request.getPassword().equals(student.getPassword());
		if (isSuccessedLogin) {
			StudentLoginResponse response = new StudentLoginResponse(student);
			response.setName(student.getName());
			response.setNationalitySeq(student.getNationalitySeq());
			response.setBranchSeq(student.getBranchSeq());
			response.setIsTraveling(student.getIsTraveling());
			response.setIsBlocked(student.getIsBlocked());
			response.setActivities(loginDao.getLoginActivities(student.getStudentId()));
			response.setAlarms(loginDao.getLoginAlarms(student.getStudentId()));
			response.setEmergencyContacts(loginDao.getLoginEmergencyContacts(student.getStudentId()));
			response.setNotices(loginDao.getLoginNotices(student.getStudentId()));
			response.setLanguageSeq(student.getLanguageSeq());

			loginDao.setLastLoginDate(request.getStudentId());
			CommonResponseBody body = new CommonResponseBody(1, response);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_10006);
		}
		return result;
	}

	@PostMapping("/login/auto")
	public CommonResponseResult loginAuto(@RequestBody StudentLoginRequest request) {
		StudentAutoLogin student = loginDao.loginAuto(request.getStudentId());
		boolean isSuccessedLogin = request.getPassword().equals(student.getPassword());

		CommonResponseResult result = new CommonResponseResult();
		if (isSuccessedLogin) {
			StudentAutoLoginResponse response = new StudentAutoLoginResponse();
			response.setIsTraveling(student.getIsTraveling());
			response.setIsBlocked(student.getIsBlocked());
			response.setActivities(loginDao.getLoginActivities(student.getStudentId()));
			response.setAlarms(loginDao.getLoginAlarms(student.getStudentId()));
			response.setEmergencyContacts(loginDao.getLoginEmergencyContacts(student.getStudentId()));
			response.setNotices(loginDao.getLoginNotices(student.getStudentId()));

			loginDao.setLastLoginDate(request.getStudentId());
			CommonResponseBody body = new CommonResponseBody(1, response);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@PostMapping("/login/staff")
	public CommonResponseResult loginStaff(@RequestBody StaffLoginRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessedLogin = false;
		StaffLoginDetailsVO staff = loginDao.getStaff(request.getStaffId());
		if (Tools.isEmpty(staff.getPassword())) {
			isSuccessedLogin = false;
		} else {
			isSuccessedLogin = staff.getPassword().equals(request.getPassword());
		}

		if (isSuccessedLogin) {
			result.setSuccessHead();

			StaffLoginResponse response = new StaffLoginResponse();
			response.setSiteAuthorization(staff.getSiteAuthorization());
			response.setBranchSeq(staff.getBranchSeq());
			response.setStaffName(Tools.blankInsteadOfNull(staff.getStaffName()));

			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Branch branch : staff.getBranches()) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setName(branch.getBranchName());
				cookieDataResponse.setSeq(branch.getBranchSeq());
				cookieDatasResponse.add(cookieDataResponse);
			}
			response.setBranches(cookieDatasResponse);

			cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Language language : staff.getLanguages()) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setName(language.getLanguageName());
				cookieDataResponse.setSeq(language.getLanguageSeq());
				cookieDatasResponse.add(cookieDataResponse);
			}
			response.setLanguages(cookieDatasResponse);

			LoginCampusResponse campusResponse = null;
			List<LoginCampusResponse> campuses = new ArrayList<LoginCampusResponse>();
			for (Campus campus : staff.getCampuses()) {
				campusResponse = new LoginCampusResponse();
				campusResponse.setBranchSeq(campus.getBranchSeq());
				campusResponse.setCampusName(campus.getCampusName());
				campusResponse.setCampusSeq(campus.getCampusSeq());
				campuses.add(campusResponse);
			}
			response.setCampuses(campuses);

			CommonResponseBody body = new CommonResponseBody(1, response);
			result.setBody(body);

		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}
}
