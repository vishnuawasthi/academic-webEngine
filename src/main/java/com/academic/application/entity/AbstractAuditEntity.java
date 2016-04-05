package com.academic.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

public abstract class AbstractAuditEntity {

	@DateTimeFormat(pattern = "yyyy-DD-mm Thh:mm:ss")
	@Column(name = "created")
	private Date created;

	@DateTimeFormat(pattern = "yyyy-DD-mm Thh:mm:ss")
	@Column(name = "updated")
	private Date updated;

	@Version
	@Column(name = "version")
	private Integer version;

	@PrePersist
	public void onSave() {
		created = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		updated = new Date();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
