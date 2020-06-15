package com.pines.student.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;

public class PIABasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

		CommonResponseResult result = new CommonResponseResult();
		result.setFailureHead(ResultCode.STATUS_401);
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(result);
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("MY_TEST_REALM");
		super.afterPropertiesSet();
	}
}