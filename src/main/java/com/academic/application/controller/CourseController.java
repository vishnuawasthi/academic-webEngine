package com.academic.application.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academic.application.dto.CourseDTO;
import com.academic.application.dto.CourseSearchCriteria;
import com.academic.application.exception.ResourceNotFoundException;
import com.academic.application.form.AssignmentForm;
import com.academic.application.form.CourseForm;
import com.academic.application.service.CourseService;

@Controller
public class CourseController {

	private final static Logger log = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ModelAndView showCourseForm() {
		log.info("showCourseForm() - start ");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courseForm", new CourseForm());
		modelAndView.setViewName("addCourse");
		log.info("showCourseForm() - end ");
		return modelAndView;
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public ModelAndView addCourse(@ModelAttribute("courseForm") CourseForm courseForm, BindingResult result) {
		log.info("addCourse() - start ");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addCourse");
		if (result.hasErrors()) {
			modelAndView.addObject("courseForm", courseForm);
			return modelAndView;
		}
		courseService.save(courseForm);
		modelAndView.addObject("courseForm", new CourseForm());
		log.info("addCourse() - end ");
		return modelAndView;
	}

	@RequestMapping(value = "/listCourse", method = RequestMethod.GET)
	public ModelAndView listCourses() {
		log.info("showCourseForm() - start ");
		ModelAndView modelAndView = new ModelAndView();
		CourseSearchCriteria criteria = new CourseSearchCriteria();
		criteria.setColumnName("id");
		criteria.setSortOrder("ASC");
		List<CourseDTO> courseList = courseService.getAll(criteria);
		modelAndView.addObject("courseList", courseList);
		modelAndView.setViewName("listCourse");
		log.info("showCourseForm() - end ");
		return modelAndView;
	}

	@RequestMapping(value = "/assignment", method = RequestMethod.GET)
	public ModelAndView assignment(@RequestParam(value="id",required=true)Long courseId) {
		log.info("assignment() - start ");
		ModelAndView modelAndView = new ModelAndView();
		AssignmentForm assignmentForm = new AssignmentForm();
		assignmentForm.setCourseId(courseId);
		modelAndView.addObject("assignmentForm",assignmentForm);
		modelAndView.setViewName("addAssignment");
		log.info("assignment() - end ");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
	public ModelAndView addAssignment(@ModelAttribute("assignmentForm") AssignmentForm assignmentForm,BindingResult result) {
		log.info("assignment() - start ");
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			modelAndView.setViewName("addAssignment");
			modelAndView.addObject("assignmentForm", assignmentForm);
			return modelAndView;
		}
		
		try {
			courseService.addAssignment(assignmentForm);
		} catch (ResourceNotFoundException e) {
			log.error("Some thing went wrong while saving data : "+e.getMessage());
			e.printStackTrace();
		}
		
		modelAndView.setViewName("redirect:listCourse");
		log.info("assignment() - end ");
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewAssignment", method = RequestMethod.GET)
	public ModelAndView viewAssignment(@RequestParam(value="id",required=true)Long courseId) {
		log.info("viewAssignment() - start ");
		ModelAndView modelAndView = new ModelAndView();
		CourseDTO courseDTO =  courseService.getOne(courseId);
		modelAndView.addObject("courseDTO", courseDTO);
		modelAndView.setViewName("listAssignment");
		log.info("viewAssignment() - end ");
		return modelAndView;
	}

}
