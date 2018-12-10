package com.soch.Integra.dto;

import java.util.List;

public class DashboardChartDTO {
	
	private List<AuditDashBoardDTO> auditDashBoardDTOs ;
	private List<AuditTypeDashBoardDTO> auditTypeDashBoardDTOs ;
	
	public List<AuditDashBoardDTO> getAuditDashBoardDTOs() {
		return auditDashBoardDTOs;
	}
	public void setAuditDashBoardDTOs(List<AuditDashBoardDTO> auditDashBoardDTOs) {
		this.auditDashBoardDTOs = auditDashBoardDTOs;
	}
	public List<AuditTypeDashBoardDTO> getAuditTypeDashBoardDTOs() {
		return auditTypeDashBoardDTOs;
	}
	public void setAuditTypeDashBoardDTOs(List<AuditTypeDashBoardDTO> auditTypeDashBoardDTOs) {
		this.auditTypeDashBoardDTOs = auditTypeDashBoardDTOs;
	}
	
	
}
