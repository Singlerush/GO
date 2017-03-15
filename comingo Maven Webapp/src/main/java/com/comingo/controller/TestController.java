package com.comingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import com.comingo.domain.Test;
import com.comingo.service.TestService;

@Controller
public class TestController extends BaseController {
	@Resource
	TestService testService;
	
	@RequestMapping("/insert.action")
	public String insert(Test test){
		testService.insert(test);
		return "redirect:/success.jsp";
	}
}	
