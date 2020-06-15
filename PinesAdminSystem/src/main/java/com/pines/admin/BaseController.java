package com.pines.admin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "/index.jsp";
	}
}
