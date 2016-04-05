package com.academic.application.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.academic.application.entity.Assignment;

/*
 @Setter
 @Getter
 @NoArgsConstructor
 @AllArgsConstructor
 @ToString*/
public class CourseDTO {
	private Long id;
	private String courseName;
	private String description;

	@DateTimeFormat(pattern = "yyyy-DD-MM")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-DD-MM")
	private Date endDate;
	private String prerequisite;
	private Double fee;
	private Double extraCharges;

	private Set<Assignment> assignments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(Double extraCharges) {
		this.extraCharges = extraCharges;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

}
