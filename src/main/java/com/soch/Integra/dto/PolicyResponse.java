package com.soch.Integra.dto;

import java.util.List;


public class PolicyResponse extends APMBaseResponse{

	private List<PolicyDTO> policyDTOs;
	
	private List<AuditPolicyDTO> auditPolicyDTOs;
	
	List<PolicyReviewDTO> policyReviewDTOs;
	
	private List<PolicyDocumentsDTO> policyDocumentsDTOs;
	
	private List<ApplicationDTO> applicationDTOs;
	
	private PolicyReviewDTO policyReviewDTO;
	
	private PolicyGrpDTO policyGrpDTO;
	

	public List<PolicyDTO> getPolicyDTOs() {
		return policyDTOs;
	}

	public void setPolicyDTOs(List<PolicyDTO> policyDTOs) {
		this.policyDTOs = policyDTOs;
	}

	public List<AuditPolicyDTO> getAuditPolicyDTOs() {
		return auditPolicyDTOs;
	}

	public void setAuditPolicyDTOs(List<AuditPolicyDTO> auditPolicyDTOs) {
		this.auditPolicyDTOs = auditPolicyDTOs;
	}

	public List<PolicyReviewDTO> getPolicyReviewDTOs() {
		return policyReviewDTOs;
	}

	public void setPolicyReviewDTOs(List<PolicyReviewDTO> policyReviewDTOs) {
		this.policyReviewDTOs = policyReviewDTOs;
	}

	public PolicyReviewDTO getPolicyReviewDTO() {
		return policyReviewDTO;
	}

	public void setPolicyReviewDTO(PolicyReviewDTO policyReviewDTO) {
		this.policyReviewDTO = policyReviewDTO;
	}

	public List<PolicyDocumentsDTO> getPolicyDocumentsDTOs() {
		return policyDocumentsDTOs;
	}

	public void setPolicyDocumentsDTOs(List<PolicyDocumentsDTO> policyDocumentsDTOs) {
		this.policyDocumentsDTOs = policyDocumentsDTOs;
	}

	public PolicyGrpDTO getPolicyGrpDTO() {
		return policyGrpDTO;
	}

	public void setPolicyGrpDTO(PolicyGrpDTO policyGrpDTO) {
		this.policyGrpDTO = policyGrpDTO;
	}

	public List<ApplicationDTO> getApplicationDTOs() {
		return applicationDTOs;
	}

	public void setApplicationDTOs(List<ApplicationDTO> applicationDTOs) {
		this.applicationDTOs = applicationDTOs;
	}
	
}
