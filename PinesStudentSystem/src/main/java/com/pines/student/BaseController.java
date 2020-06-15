package com.pines.student;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	@RequestMapping("/freshman")
	public String freshmanWelcome(Map<String, Object> model) {
		return "/01_01_signin.html";
	}
	
	@RequestMapping("/finish")
	public String greduateWelcome(Map<String, Object> model) {
		return "/03_00_signin.html";
	}

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "/02_00_signin.html";
	}
}
