package com.pines.student.meal.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.MealEvaluation;
import com.pines.student.common.vo.MealsEvaluations;
import com.pines.student.common.vo.TodayMealSchedule;
import com.pines.student.meal.schedule.vo.AddMealScheduleRequest;
import com.pines.student.meal.schedule.vo.BreakfastEvaluationRequest;
import com.pines.student.meal.schedule.vo.ChangeMealScheduleRequest;
import com.pines.student.meal.schedule.vo.DinnerEvaluationRequest;
import com.pines.student.meal.schedule.vo.LunchEvaluationRequest;
import com.pines.student.meal.schedule.vo.MealEvaluationResponse;
import com.pines.student.meal.schedule.vo.MealScheduleResponse;
import com.pines.student.meal.schedule.vo.MealsEvaluationsResponse;
import com.pines.student.meal.schedule.vo.TodayMealScheduleResponse;

@RestController
public class MealScheduleController {

	@Autowired
	MealScheduleDao mealScheduleDao;

	@GetMapping("/branches/{branchSeq}/meals/today")
	public CommonResponseResult getTodayMeal(@PathVariable(value = "branchSeq", required = true) int branchSeq, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();

		Integer integer = Tools.getIntegerHttpSessionAttribute(httpSession, "LONGIN-USER-LANGUAGESEQ", 2);
		int languageSeq = Tools.getInt(integer);

		TodayMealSchedule mealSchedule = mealScheduleDao.getTodayMeal(branchSeq, languageSeq);
		CommonResponseBody body = new CommonResponseBody();
		if (mealSchedule.getMealSeq() > 0) {
			body.setTotalCount(1);
			body.setData(new TodayMealScheduleResponse(mealSchedule));
		} else {
			body.setEmpty();
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PostMapping("/branches/{branchSeq}/meals/{mealSeq}/breakfasts/{breakfastSeq}/evaluate")
	public CommonResponseResult evaluateBreakfast(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq, @PathVariable(value = "breakfastSeq", required = true) int breakfastSeq,
			@RequestBody BreakfastEvaluationRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		request.setBranchSeq(branchSeq);
		request.setMealSeq(mealSeq);
		request.setBreakfastSeq(breakfastSeq);
		request.setWriterId((String) httpSession.getAttribute("LONGIN-USER"));

		if (Tools.isEmpty(request.getWriterId())) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = mealScheduleDao.evaluateMeal(request.getEvaluation());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/branches/{branchSeq}/meals/{mealSeq}/lunches/{luncheSeq}/evaluate")
	public CommonResponseResult evaluateLunch(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq, @PathVariable(value = "luncheSeq", required = true) int luncheSeq,
			@RequestBody LunchEvaluationRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		request.setBranchSeq(branchSeq);
		request.setMealSeq(mealSeq);
		request.setLunchSeq(luncheSeq);
		request.setWriterId((String) httpSession.getAttribute("LONGIN-USER"));

		if (Tools.isEmpty(request.getWriterId())) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = mealScheduleDao.evaluateMeal(request.getEvaluation());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/branches/{branchSeq}/meals/{mealSeq}/dinners/{dinnerSeq}/evaluate")
	public CommonResponseResult evaluateDinner(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq, @PathVariable(value = "dinnerSeq", required = true) int dinnerSeq,
			@RequestBody DinnerEvaluationRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		request.setBranchSeq(branchSeq);
		request.setMealSeq(mealSeq);
		request.setDinnerSeq(dinnerSeq);
		request.setWriterId((String) httpSession.getAttribute("LONGIN-USER"));

		if (Tools.isEmpty(request.getWriterId())) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = mealScheduleDao.evaluateMeal(request.getEvaluation());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/meals")
	public CommonResponseResult getMeals(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam(value = "selectedPage", required = true) int selectedPage, @RequestParam(value = "offset", required = true) int offset) {
		CommonResponseResult result = new CommonResponseResult();

		List<MealsEvaluations> mealsEvaluations = mealScheduleDao.getMeals(branchSeq, Tools.getStartIndex(selectedPage, offset), offset);
		List<MealsEvaluationsResponse> response = new ArrayList<MealsEvaluationsResponse>();
		MealsEvaluationsResponse mealsEvaluationsResponse = null;
		for (MealsEvaluations meals : mealsEvaluations) {
			mealsEvaluationsResponse = new MealsEvaluationsResponse();
			mealsEvaluationsResponse.setMealSeq(meals.getMealSeq());
			mealsEvaluationsResponse.setWriter(Tools.blankInsteadOfNull(meals.getWriter()));
			mealsEvaluationsResponse.setMenuDate(Tools.blankInsteadOfNull(meals.getFormMealDate()));
			mealsEvaluationsResponse.setRegisterDate(Tools.blankInsteadOfNull(meals.getFormRegisterDate()));
			mealsEvaluationsResponse.setSatisfactionGoodCount(meals.getGoodCount());
			mealsEvaluationsResponse.setSatisfactionFineCount(meals.getFineCount());
			mealsEvaluationsResponse.setSatisfactionNoGoodCount(meals.getNogoodCount());
			mealsEvaluationsResponse.setSatisfactionTotalCount(meals.getEvaluationTotal());
			mealsEvaluationsResponse.setDetailCount(meals.getDetailsCount());
			response.add(mealsEvaluationsResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		if (mealsEvaluations.size() > 0) {
			body.setTotalCount(mealsEvaluations.get(0).getTotalCount());
			body.setData(response);
		} else {
			body.setEmpty();
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/meals/{mealSeq}")
	public CommonResponseResult getMealSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq) {
		CommonResponseResult result = new CommonResponseResult();
		MealScheduleResponse response = new MealScheduleResponse(mealScheduleDao.getMealSchedule(branchSeq, mealSeq));
		CommonResponseBody body = new CommonResponseBody();
		if (Tools.isNotNull(response.getMenuDate())) {
			body.setTotalCount(1);
			body.setData(response);
		} else {
			body.setEmpty();
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/meals/{mealSeq}/evaluations")
	public CommonResponseResult getEvaluation(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq, HttpSession httpSession) {
		Integer integer = Tools.getIntegerHttpSessionAttribute(httpSession, "LONGIN-USER-LANGUAGESEQ", 2);
		int languageSeq = Tools.getInt(integer);

		MealEvaluation evaluation = mealScheduleDao.getEvaluation(branchSeq, mealSeq, languageSeq);

		CommonResponseResult result = new CommonResponseResult();
		CommonResponseBody body = new CommonResponseBody();
		if (Tools.isNotNull(evaluation.getWriter())) {
			body.setTotalCount(1);
			body.setData(new MealEvaluationResponse(evaluation));
		} else {
			body.setEmpty();
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/meals")
	public CommonResponseResult addMealSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestBody AddMealScheduleRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		request.setBranchSeq(branchSeq);
		request.setWriterId((String) httpSession.getAttribute("LONGIN-USER"));

		boolean isSuccessed = mealScheduleDao.addMealSchedule(request.getMealSchedule());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/meals/{mealSeq}")
	public CommonResponseResult changeMealSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq, @RequestBody ChangeMealScheduleRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		request.setBranchSeq(branchSeq);
		request.setMealSeq(mealSeq);
		request.setWriterId((String) httpSession.getAttribute("LONGIN-USER"));

		boolean isSuccessed = mealScheduleDao.changeMealSchedule(request.getMealSchedule());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/meals/{mealSeq}")
	public CommonResponseResult removeMealSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "mealSeq", required = true) int mealSeq, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = mealScheduleDao.removeMealSchedule(branchSeq, mealSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
