package com.soch.Integra.vendors.dto;

import java.util.List;

import com.soch.Integra.dto.APMBaseResponse;

public class SolutionTypeResp extends APMBaseResponse {
	
	List<SolutionTypeDTO> solutionTypeDTOs;

	public List<SolutionTypeDTO> getSolutionTypeDTOs() {
		return solutionTypeDTOs;
	}

	public void setSolutionTypeDTOs(List<SolutionTypeDTO> solutionTypeDTOs) {
		this.solutionTypeDTOs = solutionTypeDTOs;
	}
	
}
