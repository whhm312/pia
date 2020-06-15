package com.pines.student.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;

public class PIAAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		
		CommonResponseResult result = new CommonResponseResult();
		result.setFailureHead(ResultCode.STATUS_403);
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(result);
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}

}
