package com.comingo.controller;

import java.io.Serializable;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import com.comingo.domain.Test;
import com.comingo.exception.ParamsErrorException;
import com.comingo.service.TestService;

@Controller
public class TestController extends BaseController {
	@Resource
	TestService testService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody
	Test sayGET(String id) throws Exception {
		Test test = null;
		if(id==null) throw new ParamsErrorException();
		test = testService.get(id);
		System.out.println(test.getUsername());
		return test;
	} 

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody
	String sayPOST(Test test){
		testService.insert(test);
		return "";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.DELETE)
	public @ResponseBody
	String sayDEL(String id){
		testService.deleteById(id);
		return "";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.PUT)
	public @ResponseBody
	String sayPUT(Test test){
		testService.update(test);
		return "";
	}
}	
