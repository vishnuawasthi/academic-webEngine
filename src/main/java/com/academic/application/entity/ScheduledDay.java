package com.academic.application.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="scheduled_day")
public class ScheduledDay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="day_name",unique=true)
	private String dayName;

	@OneToMany(mappedBy = "scheduledDay")
	private Set<ScheduledTime> scheduledTimes = new HashSet<ScheduledTime>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public Set<ScheduledTime> getScheduledTimes() {
		return scheduledTimes;
	}

	public void setScheduledTimes(Set<ScheduledTime> scheduledTimes) {
		this.scheduledTimes = scheduledTimes;
	}
	
	

}
