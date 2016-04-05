package com.academic.application.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	private static final Logger log = Logger.getLogger(AdminController.class);

	private static final String TIME_TABLE_VIEW = "time-table";

	@RequestMapping(value = "/time-table", method = RequestMethod.GET)
	public ModelAndView timeTable() {
		log.info("timeTable() - start");
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName(TIME_TABLE_VIEW);
	//	modelAndView.addObject("timeTableList", attributeValue)
		log.info("timeTable() - end");
		return modelAndView;
	}

}
