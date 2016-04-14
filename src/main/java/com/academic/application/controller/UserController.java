package com.academic.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academic.application.dto.UserDTO;
import com.academic.application.exception.ResourceNotFoundException;
import com.academic.application.form.RegistrationForm;
import com.academic.application.service.UserRoleService;
import com.academic.application.service.UserService;

@Controller
public class UserController {
	public static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private UserService userService;

	private String HTTP_METHOD = "httpMethod";
	
	private  static final String  REGISTRATION_URI = "/register";
	
	private static final String CHANGE_PASSWORD_URI="/changePassword";

	private String POST = "POST";

	private String GET = "GET";

	private String PUT = "PUT";

	@RequestMapping(value = REGISTRATION_URI, method = RequestMethod.GET)
	public ModelAndView registerForm() {
		log.info("registerForm() - start");
		ModelAndView modelAndView = new ModelAndView();
		List<String> userRoles = userRoleService.getAllRoleNames();
		modelAndView.addObject("userRoles", userRoles);
		modelAndView.addObject("registrationForm", new RegistrationForm());
		modelAndView.addObject(HTTP_METHOD, POST);
		modelAndView.setViewName("userRegistrationForm");
		log.info("registerForm() - end");
		return modelAndView;
	}

	@RequestMapping(value =REGISTRATION_URI, method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result) {
		log.info("register() - start");
		Long id = null;
		ModelAndView modelAndView = new ModelAndView();
		List<String> userRoles = userRoleService.getAllRoleNames();
		modelAndView.addObject("userRoles", userRoles);
		if (result.hasErrors()) {
			modelAndView.addObject("registrationForm", registrationForm);
			modelAndView.setViewName("userRegistrationForm");
			return modelAndView;
		}
		try {
			id = userService.save(registrationForm);
		} catch (ResourceNotFoundException e) {
			log.error(e.getMessage());
			modelAndView.addObject("failure", "There is not such role as named  " + registrationForm.getRole()
					+ " , Please try with some other role.");
		}
		if (id != null) {
			modelAndView.addObject("success", "Your Registration has been done successfully");
		}
		modelAndView.addObject("registrationForm", new RegistrationForm());
		modelAndView.setViewName("userRegistrationForm");
		log.info("register() - end");
		return modelAndView;
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.GET)
	public ModelAndView showUpdateUser(@RequestParam("id") Long id) {
		log.info("showUpdateUser() - start");
		ModelAndView modelAndView = new ModelAndView();
		UserDTO userDTO = userService.getOne(id);
		RegistrationForm registrationForm = dtoToForm(userDTO);
		modelAndView.addObject("registrationForm", registrationForm);
		modelAndView.addObject(HTTP_METHOD, PUT);
		List<String> userRoles = userRoleService.getAllRoleNames();
		modelAndView.addObject("userRoles", userRoles);
		modelAndView.setViewName("userRegistrationForm");
		log.info("showUpdateUser() - end");
		return modelAndView;
	}

	private RegistrationForm dtoToForm(UserDTO dto) {
		if (dto != null) {
			RegistrationForm registrationForm = new RegistrationForm();
			registrationForm.setId(dto.getId());
			registrationForm.setFirstName(dto.getFirstName());
			registrationForm.setLastName(dto.getLastName());
			registrationForm.setMobile(dto.getMobile());
			registrationForm.setPhone(dto.getPhone());
			registrationForm.setAddressLine1(dto.getAddressLine1());
			registrationForm.setAddressLine2(dto.getAddressLine2());
			registrationForm.setEmail(dto.getEmail());
			registrationForm.setPincode(dto.getPincode());
			registrationForm.setCity(dto.getCity());
			registrationForm.setState(dto.getState());
			registrationForm.setCountry(dto.getCountry());
			registrationForm.setProfilePictureURL(dto.getProfilePictureURL());
			registrationForm.setUsername(dto.getUsername());
			registrationForm.setPassword(dto.getPassword());
			registrationForm.setRole(dto.getRoleName());
			return registrationForm;
		}
		return null;
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.PUT)
	public ModelAndView updateUser(@ModelAttribute("registerForm") RegistrationForm registrationForm,
			BindingResult result) {
		log.info("updateUser() - start");
		ModelAndView modelAndView = new ModelAndView();
		List<String> userRoles = userRoleService.getAllRoleNames();
		modelAndView.addObject("userRoles", userRoles);
		if (result.hasErrors()) {
			modelAndView.addObject("registrationForm", registrationForm);
			modelAndView.setViewName("userRegistrationForm");
			return modelAndView;
		}
		try {
			userService.update(registrationForm);
			modelAndView.addObject("success", "Your imformation has been updated successfullly.");
		} catch (ResourceNotFoundException e) {
			log.error(e.getMessage());
			modelAndView.addObject("failure", "There is not such role named as   " + registrationForm.getRole()
					+ " , Please try with some other role.");
		}
		modelAndView.addObject("registrationForm", new RegistrationForm());
		modelAndView.setViewName("userRegistrationForm");
		log.info("updateUser() - end");
		return modelAndView;
	}

	@RequestMapping(value = { "contact-us" }, method = RequestMethod.GET)
	public ModelAndView contactus() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact-us");
		return modelAndView;
	}

	@RequestMapping(value = "/viewUserDetails", method = RequestMethod.GET)
	public ModelAndView showUserDetails() {
		log.info("showUserDetails Start");
		ModelAndView modelAndView = new ModelAndView();
		Long id = 2L;
		UserDTO dto = userService.getOne(id);
		modelAndView.addObject("userDetals", dto);
		modelAndView.setViewName("viewUserDetail");
		log.info(" showUserDetails end");
		return modelAndView;

	}

	@RequestMapping(value = "editUserDetail", method = RequestMethod.GET)
	public ModelAndView editUserDetail(@RequestParam(value = "id", required = true) Long id)

	{
		ModelAndView modelAndView = new ModelAndView();

		RegistrationForm registrationForm = new RegistrationForm();
		log.info("editUserDetial() strat");
		// Long id=registrationForm.getId();
		UserDTO dto = userService.getOne(id);

		registrationForm = dtoToForm(dto);

		modelAndView.addObject("registrationForm", registrationForm);
		modelAndView.setViewName("editUserDetial");

		log.info("editUserDetial() end");

		return modelAndView;
	}

	@RequestMapping(value = "updateUserDetail", method = RequestMethod.POST)
	public ModelAndView updateUserDetail(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result)

	{
		ModelAndView modelAndView = new ModelAndView();
		log.info("updateUserDetail() strat");
		if (result.hasErrors()) {
			System.out.println("Error Block is Coming");
			Long id = registrationForm.getId();
			UserDTO dto = userService.getOne(id);

			// modelAndView.addObject("userDetail",dto);
			// modelAndView.addObject(registrationForm);

			modelAndView.addObject("registrationForm", registrationForm);
			modelAndView.setViewName("editUserDetial");
			return modelAndView;
		}

		try {
			userService.update(registrationForm);
		} catch (ResourceNotFoundException e) {
			modelAndView.addObject("failure", "There is not such role named as   " + registrationForm.getRole()
					+ " , Please try with some other role.");
			log.error(e.getMessage());

		}
		modelAndView.addObject("success", "Your imformation has been updated successfullly.");
		modelAndView.addObject("registrationForm", new RegistrationForm());
		modelAndView.setViewName("editUserDetial");

		log.info("updateUserDetail() end");

		return modelAndView;
	}

	@RequestMapping(value=CHANGE_PASSWORD_URI , method=RequestMethod.GET)
	public ModelAndView changePassword()
	
	{
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName("change-password");
		return modelAndView;
	}
	
}
