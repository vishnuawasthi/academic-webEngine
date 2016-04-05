package com.academic.application.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.academic.application.form.QuestionForm;

@Controller
public class OnlineExamController {

	public static final Logger log = Logger.getLogger(OnlineExamController.class);

	public static final String ONLINE_EXAM_URI = "/online-exam";

	public static final String ADD_QUESTION_URI = "/addQuestion";

	public static final String ADD_QUESTION_VIEW = "/addQuestion";

	public static final String ONLINE_EXAM_VIEW = "online-test";

	@RequestMapping(value = ONLINE_EXAM_URI)
	public ModelAndView showOnlineExam() {
		log.info("showOnlineExam() - start");
		ModelAndView modelAndView = new ModelAndView();
		QuestionForm examForm = new QuestionForm();
		examForm.setId(1l);
		examForm.setQuestion("When India got the freedom from british ?");
		examForm.setOptionA("1998");
		examForm.setOptionB("1947");
		examForm.setOptionC("1946");
		examForm.setOptionD("1977");
		examForm.setQuestionType("SINGLE_CHOICE");
		examForm.setAnswer("B");
		modelAndView.addObject("examForm", examForm);
		modelAndView.setViewName(ONLINE_EXAM_VIEW);
		log.info("showOnlineExam() - end");
		return modelAndView;
	}

	@RequestMapping(value = ADD_QUESTION_URI, method = RequestMethod.POST)
	public ModelAndView addQuestion(@ModelAttribute("questionForm") QuestionForm questionForm, BindingResult result) {
		log.info("addQuestion() - start");
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.addObject("questionForm", questionForm);
			modelAndView.setViewName(ADD_QUESTION_URI);
			return modelAndView;

		}
		modelAndView.addObject("questionForm", new QuestionForm());
		modelAndView.setViewName(ADD_QUESTION_URI);
		log.info("addQuestion() - end");
		return modelAndView;
	}

}
