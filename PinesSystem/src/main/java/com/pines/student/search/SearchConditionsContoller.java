package com.pines.student.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Branch;
import com.pines.student.common.vo.Campus;
import com.pines.student.common.vo.Entrance;
import com.pines.student.common.vo.Language;
import com.pines.student.common.vo.Level;
import com.pines.student.common.vo.Nationality;
import com.pines.student.common.vo.StudentGroup;
import com.pines.student.common.vo.Term;
import com.pines.student.common.vo.TermDetail;
import com.pines.student.common.vo.Timetable;
import com.pines.student.login.vo.CookieDataResponse;

@RestController
public class SearchConditionsContoller {

	@Autowired
	SearchConditionsDao searchConditionsDao;

	@GetMapping("/conditions/branches")
	public CommonResponseResult getBranches() {
		CommonResponseResult result = new CommonResponseResult();
		List<Branch> branches = searchConditionsDao.getBranches();
		if (!branches.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Branch branch : branches) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(branch.getBranchSeq());
				cookieDataResponse.setName(branch.getBranchName());
				cookieDatasResponse.add(cookieDataResponse);
			}

			CommonResponseBody body = new CommonResponseBody(branches.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/languages")
	public CommonResponseResult getLanguages() {
		CommonResponseResult result = new CommonResponseResult();
		List<Language> languages = searchConditionsDao.getLanguages();
		if (!languages.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Language language : languages) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(language.getLanguageSeq());
				cookieDataResponse.setName(language.getLanguageName());
				cookieDatasResponse.add(cookieDataResponse);
			}

			CommonResponseBody body = new CommonResponseBody(languages.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/nationalities")
	public CommonResponseResult getNationalities() {
		CommonResponseResult result = new CommonResponseResult();
		List<Nationality> notianlities = searchConditionsDao.getNationalities();
		if (!notianlities.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Nationality notianlity : notianlities) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(notianlity.getNationalitySeq());
				cookieDataResponse.setName(notianlity.getNationality());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(notianlities.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/groups")
	public CommonResponseResult getStudentGroups(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<StudentGroup> studentGroups = searchConditionsDao.getStudentGroups(branchSeq);
		if (!studentGroups.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (StudentGroup studentGroup : studentGroups) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(studentGroup.getStudentGroupSeq());
				cookieDataResponse.setName(studentGroup.getGroupName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(studentGroups.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/campuses")
	public CommonResponseResult getCampuses(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Campus> selectResults = searchConditionsDao.getCampuses(branchSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Campus data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getCampusSeq());
				cookieDataResponse.setName(data.getCampusName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/terms")
	public CommonResponseResult getTerms(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Term> selectResults = searchConditionsDao.getTerms(branchSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Term data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getTermSeq());
				cookieDataResponse.setName(data.getTerm());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/terms/details")
	public CommonResponseResult getTermDetails(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<TermDetail> selectResults = searchConditionsDao.getTermDetails(branchSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (TermDetail data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getTermDetailSeq());
				cookieDataResponse.setName(data.getTermName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/levels")
	public CommonResponseResult getLevels(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Level> selectResults = searchConditionsDao.getLevels(branchSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Level data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getLevelSeq());
				cookieDataResponse.setName(data.getLevelName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/campuses/{campusSeq}/levels")
	public CommonResponseResult getLevelsPerCampus(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Level> selectResults = searchConditionsDao.getLevels(branchSeq, campusSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Level data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getLevelSeq());
				cookieDataResponse.setName(data.getLevelName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/campuses/{campusSeq}/levels/{levelSeq}/timetable")
	public CommonResponseResult getTimetableByLevel(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "levelSeq", required = true) int levelSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Timetable> selectResults = searchConditionsDao.getTimetable(branchSeq, campusSeq, levelSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Timetable data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getTimetableSeq());
				cookieDataResponse.setName(data.getStudyTime());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/entrances/campuses")
	public CommonResponseResult getCampusEachEntrances(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Campus> selectResults = searchConditionsDao.getCampusEachEntrances(branchSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Campus data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getCampusSeq());
				cookieDataResponse.setName(data.getCampusName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@GetMapping("/conditions/{branchSeq}/campuses/{campusSeq}/entrances")
	public CommonResponseResult getEntrances(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Entrance> selectResults = searchConditionsDao.getEntrances(branchSeq, campusSeq);
		if (!selectResults.isEmpty()) {
			CookieDataResponse cookieDataResponse = null;
			List<CookieDataResponse> cookieDatasResponse = new ArrayList<CookieDataResponse>();
			for (Entrance data : selectResults) {
				cookieDataResponse = new CookieDataResponse();
				cookieDataResponse.setSeq(data.getEntranceSeq());
				cookieDataResponse.setName(data.getName());
				cookieDatasResponse.add(cookieDataResponse);
			}
			CommonResponseBody body = new CommonResponseBody(selectResults.size(), cookieDatasResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}
}
