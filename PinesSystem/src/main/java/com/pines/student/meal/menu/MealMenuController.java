package com.pines.student.meal.menu;

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
import com.pines.student.common.vo.MealMenu;
import com.pines.student.meal.menu.vo.AddMealMenuRequest;
import com.pines.student.meal.menu.vo.ChangeMealMenuRequest;
import com.pines.student.meal.menu.vo.MealMenusResponse;

@RestController
public class MealMenuController {

	@Autowired
	MealMenuDao mealMenuDao;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/menus")
	public CommonResponseResult getMenus(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam(value = "selectedPage", required = true) int selectedPage, @RequestParam(value = "offset", required = true) int offset) {
		CommonResponseResult result = new CommonResponseResult();

		List<MealMenu> guides = mealMenuDao.getMenus(branchSeq, Tools.getStartIndex(selectedPage, offset), offset);
		List<MealMenusResponse> response = new ArrayList<MealMenusResponse>();
		MealMenusResponse guidesResponse = null;
		for (MealMenu guide : guides) {
			guidesResponse = new MealMenusResponse();
			guidesResponse.setMenuSeq(guide.getMealMenuSeq());
			guidesResponse.setIsSpicy(guide.getIsSpicy());
			guidesResponse.setMenuType(guide.getMenuType());
			guidesResponse.setMenuKorName(Tools.blankInsteadOfNull(guide.getMenuKorName()));
			guidesResponse.setMenuEngName(Tools.blankInsteadOfNull(guide.getMenuEngName()));
			guidesResponse.setIsUsed(guide.getIsUsed());
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
	@GetMapping("/branches/{branchSeq}/menus/{menuType}")
	public CommonResponseResult getMenusByMenuType(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "menuType", required = true) String menuType) {
		CommonResponseResult result = new CommonResponseResult();

		List<MealMenu> guides = mealMenuDao.getMenus(branchSeq, menuType);
		List<MealMenusResponse> response = new ArrayList<MealMenusResponse>();
		MealMenusResponse guidesResponse = null;
		for (MealMenu guide : guides) {
			guidesResponse = new MealMenusResponse();
			guidesResponse.setMenuSeq(guide.getMealMenuSeq());
			guidesResponse.setIsSpicy(guide.getIsSpicy());
			guidesResponse.setMenuType(guide.getMenuType());
			guidesResponse.setMenuKorName(Tools.blankInsteadOfNull(guide.getMenuKorName()));
			guidesResponse.setMenuEngName(Tools.blankInsteadOfNull(guide.getMenuEngName()));
			guidesResponse.setIsUsed(guide.getIsUsed());
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
	@PostMapping("/branches/{branchSeq}/menus/{menuType}")
	public CommonResponseResult addMealMenu(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "menuType", required = true) String menuType, @RequestBody AddMealMenuRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		if (!isValidMenuType(menuType)) {
			result.setFailureHead(ResultCode.STATUS_400);
			return result;
		}

		request.setBranchSeq(branchSeq);
		request.setMenuType(menuType);

		boolean isSuccessed = mealMenuDao.addMealMenu(request.getMealMenu());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/menus/{menuType}/{menuSeq}")
	public CommonResponseResult changeMealMenu(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "menuType", required = true) String menuType, @PathVariable(value = "menuSeq", required = true) int menuSeq,
			@RequestBody ChangeMealMenuRequest request, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		if (!isValidMenuType(menuType)) {
			result.setFailureHead(ResultCode.STATUS_400);
			return result;
		}

		request.setBranchSeq(branchSeq);
		request.setMenuType(menuType);
		request.setMenuSeq(menuSeq);

		boolean isSuccessed = mealMenuDao.changeMealMenu(request.getMealMenu());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/menus/{menuSeq}")
	public CommonResponseResult removeMealMenu(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "menuSeq", required = true) int menuSeq, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = mealMenuDao.removeMealMenu(branchSeq, menuSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	private boolean isValidMenuType(String menuType) {
		return "|PORRIDGE|RICE|SOUP|MAINDISH|SIDEDISH|BREAD|ETC|".indexOf(menuType) > 0;
	}
}
