package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class TestController_POJO implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("여기까지 오는지 확인..");
		
		ModelAndView mv1 = new ModelAndView("test");//모델과 뷰
		mv1.addObject("data1", "스프링 MVC의 모델이에요!~");//data1은 모델 임.
		//mv1.setViewName("/WEB-INF/view/test.jsp");//test.jsp는 뷰
		InternalResourceViewResolver reselver1;
		
		return mv1;
	}

}
