package com.academic.application.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academic.application.dto.UserDTO;
import com.academic.application.service.UserService;

@Controller
public class BaseController {
	
	public static final Logger log = Logger.getLogger(BaseController.class);
	
	private static final String BASE_URI = "/";

	private static final String WELCOME_URI = "/index";

	private static final String  LANDING_URI = "landing";

	@Autowired
	private UserService userService;

	@RequestMapping(value = { BASE_URI, WELCOME_URI }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	

	@RequestMapping(value = { LANDING_URI }, method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView performLogin() {
		log.info("performLogin() - start");
		ModelAndView modelAndView = new ModelAndView();
		UserDTO userDTO = userService.getCurrentUser();
		System.out.println("UserDTO"  +userDTO);
		modelAndView.addObject("userDetails", userDTO);
		modelAndView.setViewName("index");
		log.info("performLogin() - end");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
			ModelMap modelMap) {
		log.info("login() - start");
		System.out.println("error ::::::: "+error);
		
		if (error != null) {
			modelMap.put("error", "Invalid username and password!");
		}
		if (logout != null) {
			modelMap.put("msg", "You've been logged out successfully.");
		}
		log.info("login() - end");
		return new ModelAndView("login", modelMap);
	}

	@RequestMapping(value = "/403",method=RequestMethod.GET)
	public ModelAndView accessDenied(ModelMap modelMap) {
		log.info("accessDenied() - start");
		modelMap.put("AccessDenied ", "Sorry,You don't have previliges to access this content");
		log.info("accessDenied() - end");
		return new ModelAndView("403", modelMap);
	}
}
