package com.soch.Integra.dashboard.dto;

import java.util.List;

import com.soch.Integra.dto.AppAuditDTO;
import com.soch.Integra.dto.AssessmentDTO;
import com.soch.Integra.dto.PolicyDTO;
import com.soch.Integra.dto.PolicyGrpDTO;

public class DashboardAuditResponse {
	
	List<AppAuditDTO> upcomingAudits;
	List<AppAuditDTO> totalAudits;
	List<PolicyDTO> policyDTOs;
	List<PolicyGrpDTO> policyGrpDTOs;
	List<AssessmentDTO> assessmentDTOs;
	
	public List<AppAuditDTO> getUpcomingAudits() {
		return upcomingAudits;
	}
	public void setUpcomingAudits(List<AppAuditDTO> upcomingAudits) {
		this.upcomingAudits = upcomingAudits;
	}
	public List<AppAuditDTO> getTotalAudits() {
		return totalAudits;
	}
	public void setTotalAudits(List<AppAuditDTO> totalAudits) {
		this.totalAudits = totalAudits;
	}
	public List<PolicyDTO> getPolicyDTOs() {
		return policyDTOs;
	}
	public void setPolicyDTOs(List<PolicyDTO> policyDTOs) {
		this.policyDTOs = policyDTOs;
	}
	public List<PolicyGrpDTO> getPolicyGrpDTOs() {
		return policyGrpDTOs;
	}
	public void setPolicyGrpDTOs(List<PolicyGrpDTO> policyGrpDTOs) {
		this.policyGrpDTOs = policyGrpDTOs;
	}
	public List<AssessmentDTO> getAssessmentDTOs() {
		return assessmentDTOs;
	}
	public void setAssessmentDTOs(List<AssessmentDTO> assessmentDTOs) {
		this.assessmentDTOs = assessmentDTOs;
	}
	
}
