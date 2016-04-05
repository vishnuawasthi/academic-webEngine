package com.academic.application.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school_profile")
public class SchoolProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 854452547600969732L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "establishment_year")
	private Date establishmentYear;

	@Column(name = "license_number")
	private String licenseNumber;
	
	@Column(name="description",length=3000)
	private String description;
	
	@Column(name="logo_url")
	private String logoURL;

}
