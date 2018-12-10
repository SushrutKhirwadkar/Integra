package com.soch.Integra.dto;

import java.util.Set;

import com.soch.Integra.vendors.dto.AppSolutionDevicesDTO;
import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;

public class ApplicationResp extends APMBaseResponse{
	
	private ApplicationDTO applicationDTO;
	private ApplicationViewDTO applicationViewDTO;
	private DivisionDTO divisionDTO; 
	private ApplicationSolutionDTO applicationSolutionDTO;
	private AppSolutionDevicesDTO appSolutionDeviceDTO;
	public ApplicationDTO getApplicationDTO() {
		return applicationDTO;
	}

	public void setApplicationDTO(ApplicationDTO applicationDTO) {
		this.applicationDTO = applicationDTO;
	}

	public DivisionDTO getDivisionDTO() {
		return divisionDTO;
	}

	public void setDivisionDTO(DivisionDTO divisionDTO) {
		this.divisionDTO = divisionDTO;
	}

	public ApplicationDTO saveApplicationDTO() {
		return applicationDTO;
	}

	public ApplicationViewDTO getApplicationViewDTO() {
		return applicationViewDTO;
	}

	public void setApplicationViewDTO(ApplicationViewDTO applicationViewDTO) {
		this.applicationViewDTO = applicationViewDTO;
	}

	public ApplicationSolutionDTO getApplicationSolutionDTO() {
		return applicationSolutionDTO;
	}

	public void setApplicationSolutionDTO(ApplicationSolutionDTO applicationSolutionDTO) {
		this.applicationSolutionDTO = applicationSolutionDTO;
	}

	public AppSolutionDevicesDTO getAppSolutionDeviceDTO() {
		return appSolutionDeviceDTO;
	}

	public void setAppSolutionDeviceDTO(AppSolutionDevicesDTO appSolutionDeviceDTO) {
		this.appSolutionDeviceDTO = appSolutionDeviceDTO;
	}
	
	
	
	
		
	}
	
	
