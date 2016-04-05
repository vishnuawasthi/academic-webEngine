package com.academic.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor*/
public class UserRoleDTO {

	private Long id;
	private String roleName;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserRoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
