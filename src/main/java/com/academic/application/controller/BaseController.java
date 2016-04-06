package com.academic.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	
	private static final String BASE_URI = "/";
	
	private static final String WELCOME_URI = "/index";
	
	
	@RequestMapping(value ={BASE_URI,WELCOME_URI}, method = RequestMethod.GET)
	public ModelAndView index() {
		
		
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
