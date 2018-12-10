package com.soch.Integra.dto;

import java.util.List;

public class UserReportResponse extends APMBaseResponse{
	
	private List<ApplicationDTO> applicationDTOs;

	public List<ApplicationDTO> getApplicationDTOs() {
		return applicationDTOs;
	}

	public void setApplicationDTOs(List<ApplicationDTO> applicationDTOs) {
		this.applicationDTOs = applicationDTOs;
	}
	
	
	

}
