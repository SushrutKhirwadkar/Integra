package com.soch.Integra.dto;

import java.util.Date;

import com.soch.Integra.entities.ApplicationEntity;

public class WorkHoursDTO {
	
	private Integer workHoursId;
	private ApplicationEntity applicationEntity;
	private String openTm;
	private String closeTm;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private String day;
	
	
	
	public Integer getWorkHoursId() {
		return workHoursId;
	}
	public void setWorkHoursId(Integer workHoursId) {
		this.workHoursId = workHoursId;
	}
	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}
	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}
	public String getOpenTm() {
		return openTm;
	}
	public void setOpenTm(String openTm) {
		this.openTm = openTm;
	}
	public String getCloseTm() {
		return closeTm;
	}
	public void setCloseTm(String closeTm) {
		this.closeTm = closeTm;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}
