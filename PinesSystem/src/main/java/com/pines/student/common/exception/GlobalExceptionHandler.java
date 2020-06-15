package com.pines.student.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public CommonResponseResult handleException(Exception e) {
		CommonResponseResult results = new CommonResponseResult();

		e.printStackTrace();

		if (e instanceof org.springframework.web.HttpRequestMethodNotSupportedException) {
			results.setFailureHead(ResultCode.STATUS_405, e.getMessage());
			return results;
		} else if (e instanceof org.springframework.web.bind.MissingServletRequestParameterException) {
			results.setFailureHead(ResultCode.STATUS_400, e.getMessage());
			return results;
		} else if (e instanceof org.springframework.security.access.AccessDeniedException) {
			results.setFailureHead(ResultCode.STATUS_403, e.getMessage());
			return results;
		} else if (e instanceof org.springframework.web.HttpMediaTypeNotSupportedException) {
			results.setFailureHead(ResultCode.STATUS_406, e.getMessage());
			return results;
		} else if (e instanceof org.springframework.web.multipart.MultipartException) {
			if (e.getMessage().indexOf("FileSizeLimitExceededException") > -1) {
				results.setFailureHead(ResultCode.STATUS_413);
				return results;
			} else if (e.getCause() instanceof IllegalStateException) {
				results.setFailureHead(ResultCode.STATUS_413);
				return results;
			}
			
		} else if (e instanceof org.springframework.dao.DataAccessException) {
			results.setFailureHead(ResultCode.STATUS_500_DB);
			return results;
		}

		results.setFailureHead(ResultCode.STATUS_500, e.getMessage());
		return results;
	}
}
