package com.comingo.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import com.comingo.domain.Test;
import com.comingo.service.TestService;

@Controller
public class TestController extends BaseController {
	@Resource
	TestService testService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody
	String sayGET(Serializable id) {
		Test test = testService.get(id);
		System.out.println(test.getUsername());
		return "GET Success" + test.getUsername();
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody
	String sayPOST(Test test){
		testService.insert(test);
		return "POST Success";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.DELETE)
	public @ResponseBody
	String sayDEL(Serializable id){
		testService.deleteById(id);
		return "DELETE Success";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.PUT)
	public @ResponseBody
	String sayPUT(Test test){
		testService.update(test);
		return "PUT Success";
	}
}	
