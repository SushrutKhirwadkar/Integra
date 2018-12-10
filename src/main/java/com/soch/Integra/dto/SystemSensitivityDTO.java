package com.soch.Integra.dto;

import java.util.Date;

import com.soch.Integra.entities.UserEntity;

public class SystemSensitivityDTO {
	
	private int systemSensitivityId;
	private String systemSensitivityValue;
	private String description;
	private Date createdTs;
	public int getSystemSensitivityId() {
		return systemSensitivityId;
	}
	public void setSystemSensitivityId(int systemSensitivityId) {
		this.systemSensitivityId = systemSensitivityId;
	}
	
	public String getSystemSensitivityValue() {
		return systemSensitivityValue;
	}
	public void setSystemSensitivityValue(String systemSensitivityValue) {
		this.systemSensitivityValue = systemSensitivityValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	
	

}
