package com.soch.Integra.report.dto;

import java.util.Set;

public class FullReportDTO {
	
	public String name;
	
	public Set<DivisionReportDTO> divisionReportDTOs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DivisionReportDTO> getDivisionReportDTOs() {
		return divisionReportDTOs;
	}

	public void setDivisionReportDTOs(Set<DivisionReportDTO> divisionReportDTOs) {
		this.divisionReportDTOs = divisionReportDTOs;
	}
	
	

}
