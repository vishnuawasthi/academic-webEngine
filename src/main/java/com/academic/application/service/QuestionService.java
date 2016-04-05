package com.academic.application.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.academic.application.constant.QuestionType;
import com.academic.application.dto.QuestionDTO;
import com.academic.application.dto.QuestionSearchCriteria;
import com.academic.application.entity.Question;
import com.academic.application.exception.ResourceNotFoundException;
import com.academic.application.form.QuestionForm;
import com.academic.application.repository.CommonSortUtility;
import com.academic.application.repository.QuestionRepository;
import com.academic.application.utils.CollectionUtility;

public interface QuestionService {

	public Serializable submitQuestion(QuestionForm examForm);

	public Serializable createQuestion(QuestionForm examForm);

	public void updateQuestion(QuestionForm examForm) throws ResourceNotFoundException;

	public void delete(Long id);

	public QuestionDTO getOne(Long id);

	public List<QuestionDTO> getAll();

	public List<QuestionDTO> getAll(QuestionSearchCriteria criteria);

	@Service
	public class Impl implements QuestionService {
		private static final Logger log = Logger.getLogger(Impl.class);

		@Autowired
		private QuestionRepository repository;

		@Override
		public Serializable submitQuestion(QuestionForm examForm) {
			log.info("submitQuestion() - start");
			Question entity = formToEntity(examForm);
			repository.save(entity);
			log.info("submitQuestion() - end");
			return entity.getId();
		}

		private Question formToEntity(QuestionForm examForm) {
			Question question = new Question();
			question.setId(examForm.getId());
			question.setQuestion(examForm.getQuestion());
			question.setOptionA(examForm.getOptionA());
			question.setOptionB(examForm.getOptionB());
			question.setOptionC(examForm.getOptionC());
			question.setOptionD(examForm.getOptionD());
			question.setQuestionType(QuestionType.valueOf(examForm.getQuestionType()));
			question.setAnswer(examForm.getAnswer());
			return question;
		}

		@Override
		public Serializable createQuestion(QuestionForm examForm) {
			log.info("createQuestion() - start");
			Question entity = formToEntity(examForm);
			repository.save(entity);
			log.info("createQuestion() - end");
			return entity.getId();
		}

		@Override
		public void updateQuestion(QuestionForm questionForm) throws ResourceNotFoundException {
			log.info("updateQuestion() - start");
			Question entity = repository.findOne(questionForm.getId());
			if (StringUtils.isEmpty(entity)) {
				throw new ResourceNotFoundException("Question entity not found with given id" + questionForm.getId());
			}

			if (!StringUtils.isEmpty(questionForm.getOptionA()))
				entity.setOptionA(questionForm.getOptionA());

			if (!StringUtils.isEmpty(questionForm.getOptionB()))
				entity.setOptionB(questionForm.getOptionB());

			if (!StringUtils.isEmpty(questionForm.getOptionC()))
				entity.setOptionC(questionForm.getOptionC());

			if (!StringUtils.isEmpty(questionForm.getOptionD()))
				entity.setOptionD(questionForm.getOptionD());

			if (!StringUtils.isEmpty(questionForm.getAnswer()))
				entity.setAnswer(questionForm.getAnswer());

			if (!StringUtils.isEmpty(questionForm.getQuestionType()))
				entity.setQuestionType(QuestionType.valueOf(questionForm.getQuestionType()));

			repository.save(entity);
			log.info("updateQuestion() - end");
		}

		@Override
		public void delete(Long id) {
			log.info("delete() - start");
			repository.delete(id);
			log.info("delete() - end");
		}

		@Override
		public QuestionDTO getOne(Long id) {
			Question entity =repository.findOne(id);
			return entityToDTO(entity);
		}

		private QuestionDTO entityToDTO(Question entity) {
			if (entity != null) {
				QuestionDTO dto = new QuestionDTO();
				dto.setId(entity.getId());
				dto.setQuestion(entity.getQuestion());
				dto.setOptionA(entity.getOptionA());
				dto.setOptionB(entity.getOptionB());
				dto.setOptionC(entity.getOptionC());
				dto.setOptionD(entity.getOptionD());
				dto.setQuestionType(entity.getQuestionType().name());
				dto.setAnswer(entity.getAnswer());
				return dto;
			}
			return null;
		}

		@Override
		public List<QuestionDTO> getAll() {
			log.info("getAll() - start");
			List<QuestionDTO> dtos = new ArrayList<QuestionDTO>();
			Iterable <Question> questions = repository.findAll(CommonSortUtility.sort(null, null));
			for( Question entity  : CollectionUtility.emptyIfNull(questions)  ){
				dtos.add(entityToDTO(entity));
			}
			log.info("getAll() - end");
			return dtos;
		}

		@Override
		public List<QuestionDTO> getAll(QuestionSearchCriteria criteria) {
			log.info("getAll() - start");
			List<QuestionDTO> dtos = new ArrayList<QuestionDTO>();
			Iterable <Question> questions = repository.findAll(CommonSortUtility.sort(criteria.getSortOrder(), criteria.getColumnName()));
			for( Question entity  : CollectionUtility.emptyIfNull(questions)  ){
				dtos.add(entityToDTO(entity));
			}
			log.info("getAll() - end");
			return dtos;
		}

	}

}
