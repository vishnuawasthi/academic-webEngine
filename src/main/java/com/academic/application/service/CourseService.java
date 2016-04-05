package com.academic.application.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.academic.application.dto.CourseDTO;
import com.academic.application.dto.CourseSearchCriteria;
import com.academic.application.entity.Assignment;
import com.academic.application.entity.Course;
import com.academic.application.exception.ResourceNotFoundException;
import com.academic.application.form.AssignmentForm;
import com.academic.application.form.CourseForm;
import com.academic.application.repository.AssignmentRepository;
import com.academic.application.repository.CommonSortUtility;
import com.academic.application.repository.CourseRepository;
import com.academic.application.utils.CollectionUtility;

public interface CourseService {
	public Serializable save(CourseForm courseForm);

	public void update(CourseForm courseForm) throws ResourceNotFoundException;

	public void delete(Long id);

	public CourseDTO getOne(Long id);

	public List<CourseDTO> getAll(String sortOrder);

	public List<CourseDTO> getAll(CourseSearchCriteria criteria);

	public Long addAssignment(AssignmentForm assignmentForm) throws ResourceNotFoundException;

	@Service
	public class Impl implements CourseService {

		private static final Logger log = Logger.getLogger(Impl.class);

		@Autowired
		private CourseRepository courseRepository;

		@Autowired
		private AssignmentRepository assignmentRepository;

		@Override
		public Serializable save(CourseForm courseForm) {
			log.info("save() - start");
			log.info("save() - end");
			return courseRepository.save(formToEntity(courseForm));
		}

		private Course formToEntity(CourseForm courseForm) {
			Course entity = new Course();
			entity.setId(courseForm.getId());
			entity.setCourseName(courseForm.getCourseName());
			entity.setDescription(courseForm.getDescription());
			entity.setStartDate(courseForm.getStartDate());
			entity.setEndDate(courseForm.getEndDate());
			entity.setExtraCharges(courseForm.getExtraCharges());
			entity.setFee(courseForm.getFee());
			entity.setPrerequisite(courseForm.getPrerequisite());
			return entity;
		}

		@Override
		public void update(CourseForm courseForm) throws ResourceNotFoundException {
			log.info("update() - start");
			Course entity = courseRepository.findOne(courseForm.getId());

			if (StringUtils.isEmpty(entity))
				throw new ResourceNotFoundException("Course entity not found with given id " + courseForm.getId());

			if (!StringUtils.isEmpty(courseForm.getCourseName())) {
				entity.setCourseName(courseForm.getCourseName());
			}

			if (!StringUtils.isEmpty(courseForm.getDescription())) {
				entity.setDescription(courseForm.getDescription());
			}

			if (!StringUtils.isEmpty(courseForm.getEndDate())) {
				entity.setEndDate(courseForm.getEndDate());
			}

			if (!StringUtils.isEmpty(courseForm.getStartDate())) {
				entity.setStartDate(courseForm.getStartDate());
			}

			if (!StringUtils.isEmpty(courseForm.getExtraCharges())) {
				entity.setExtraCharges(courseForm.getExtraCharges());
			}

			if (!StringUtils.isEmpty(courseForm.getFee())) {
				entity.setFee(courseForm.getFee());
			}

			courseRepository.save(entity);
			log.info("update() - end");
		}

		@Override
		public void delete(Long id) {
			log.info("delete() - start");
			courseRepository.delete(id);
			log.info("delete() - end");
		}

		@Override
		public CourseDTO getOne(Long id) {
			return entityToDTO(courseRepository.findOne(id));
		}

		private CourseDTO entityToDTO(Course entity) {
			CourseDTO dto = new CourseDTO();
			if (entity != null) {
				dto.setId(entity.getId());
				dto.setCourseName(entity.getCourseName());
				dto.setDescription(entity.getDescription());
				dto.setStartDate(entity.getStartDate());
				dto.setEndDate(entity.getEndDate());
				dto.setExtraCharges(entity.getExtraCharges());
				dto.setFee(entity.getFee());
				dto.setPrerequisite(entity.getPrerequisite());
				dto.setAssignments(entity.getAssignments());
			}
			return dto;
		}

		@Override
		public List<CourseDTO> getAll(String sortOrder) {
			// List <Course> dbContent = courseRepository.f
			// Page<Course> page =
			// courseRepository.findAll(CommonSortUtility.createPageRequest(page,
			// size, CommonSortUtility.sort(null, null)));

			// Page< Course> page = courseRepository.findAll(pageable)

			List<CourseDTO> dtoList = new ArrayList<CourseDTO>();
			Iterable<Course> dbContent = courseRepository.findAll();
			for (Course entity : CollectionUtility.emptyIfNull(dbContent)) {
				dtoList.add(entityToDTO(entity));
			}
			return dtoList;
		}

		@Override
		public List<CourseDTO> getAll(CourseSearchCriteria criteria) {
			log.info("getAll() - start");
			List<CourseDTO> dtoList = new ArrayList<CourseDTO>();
			Iterable<Course> dbContent = null;
			dbContent = courseRepository.findAll(CommonSortUtility.sort(criteria.getSortOrder(),
					criteria.getColumnName()));

			for (Course entity : CollectionUtility.emptyIfNull(dbContent)) {
				dtoList.add(entityToDTO(entity));
			}
			log.info("getAll() - end");
			return dtoList;
		}

		@Override
		public Long addAssignment(AssignmentForm assignmentForm) throws ResourceNotFoundException {
			log.info("addAssignment() - start");
			Assignment entity = new Assignment();
			Course course = courseRepository.findOne(assignmentForm.getCourseId());
			if (StringUtils.isEmpty(course)) {
				throw new ResourceNotFoundException("Course entity not found with given id ="
						+ assignmentForm.getCourseId());
			}
			entity.setCourse(course);
			entity.setDescription(assignmentForm.getDescription());
			entity.setNotice(assignmentForm.getNotice());
			// TODO - Need to save it
			assignmentRepository.save(entity);
			log.info("addAssignment() - end");
			return entity.getId();
		}

	}

}
