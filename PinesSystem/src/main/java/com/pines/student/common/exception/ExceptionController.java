package com.pines.student.common.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;

@RestController
public class ExceptionController {

	@GetMapping("/exception/{status}")
	public CommonResponseResult getTerms(@PathVariable(value = "status", required = true) int status) {
		CommonResponseResult result = new CommonResponseResult();
		switch (status) {
		case 400:
			result.setFailureHead(ResultCode.STATUS_400);
			return result;
		case 401:
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		case 404:
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		case 405:
			result.setFailureHead(ResultCode.STATUS_405);
			return result;
		case 406:
			result.setFailureHead(ResultCode.STATUS_406);
			return result;
		case 413:
			result.setFailureHead(ResultCode.STATUS_413);
			return result;
		case 500:
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		return result;
	}
}
