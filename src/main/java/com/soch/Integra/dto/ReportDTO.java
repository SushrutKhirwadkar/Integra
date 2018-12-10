package com.soch.Integra.dto;

import java.util.List;

public class ReportDTO {
	
	private int serverId;
	private int databaseId;
	private int technologyId;
	private int fyId;
	
	private List<ApplicationDTO> applicationDTOs;
	
	
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public int getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}
	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public int getFyId() {
		return fyId;
	}
	public void setFyId(int fyId) {
		this.fyId = fyId;
	}
	public List<ApplicationDTO> getApplicationDTOs() {
		return applicationDTOs;
	}
	public void setApplicationDTOs(List<ApplicationDTO> applicationDTOs) {
		this.applicationDTOs = applicationDTOs;
	}
	
	
	
}
