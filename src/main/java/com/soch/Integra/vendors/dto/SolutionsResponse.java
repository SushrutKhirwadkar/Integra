package com.soch.Integra.vendors.dto;

import java.util.List;

import com.soch.Integra.dto.APMBaseResponse;

public class SolutionsResponse extends APMBaseResponse{
	
	private List<SolutionsDTO> solutionsDTOs;

	public List<SolutionsDTO> getSolutionsDTOs() {
		return solutionsDTOs;
	}

	public void setSolutionsDTOs(List<SolutionsDTO> solutionsDTOs) {
		this.solutionsDTOs = solutionsDTOs;
	}
	
}
