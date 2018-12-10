package com.soch.Integra.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.soch.Integra.entities.PolicyGrpEntity;

public class PolicyDTO {

	private Integer policyId;
	private String controlNumber;
	private String policyName;
	private String description;
	private String policyVal;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private String priority;
	private String procedures;
	private String guidelines;
	private String familyName;
	private String classType;
	private String assignedTo;
	private String assignedBy;
	private Date startDate;
	private Date endDate;
	private Date reviewDate;
	private boolean status;
	
	private boolean linked;
	
	private String linkType;
	
	private String isDesignDocument;
	private String configBaseline;
	private String auditRecords;
	private String artifacts;
	private String nonCov;
	private String securityPlan;
	private String isConfigSettings;
	private List<SubPolicyDTO> subPolicyDTOs;
	private int policyGrpId;
	private String comments;
	
	private List<PolicyDTO> linkedPolicies;
	
	private String linkedPoliciesString;
	
	private List<PolicyDocumentsDTO> policyDocumentsDTOs;
	
	
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPolicyVal() {
		return policyVal;
	}
	public void setPolicyVal(String policyVal) {
		this.policyVal = policyVal;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	public int getPolicyGrpId() {
		return policyGrpId;
	}
	public void setPolicyGrpId(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public String getGuidelines() {
		return guidelines;
	}
	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getIsDesignDocument() {
		return isDesignDocument;
	}
	public void setIsDesignDocument(String isDesignDocument) {
		this.isDesignDocument = isDesignDocument;
	}
	public String getConfigBaseline() {
		return configBaseline;
	}
	public void setConfigBaseline(String configBaseline) {
		this.configBaseline = configBaseline;
	}
	public String getAuditRecords() {
		return auditRecords;
	}
	public void setAuditRecords(String auditRecords) {
		this.auditRecords = auditRecords;
	}
	public String getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(String artifacts) {
		this.artifacts = artifacts;
	}
	public String getNonCov() {
		return nonCov;
	}
	public void setNonCov(String nonCov) {
		this.nonCov = nonCov;
	}
	public String getSecurityPlan() {
		return securityPlan;
	}
	public void setSecurityPlan(String securityPlan) {
		this.securityPlan = securityPlan;
	}
	public String getIsConfigSettings() {
		return isConfigSettings;
	}
	public void setIsConfigSettings(String isConfigSettings) {
		this.isConfigSettings = isConfigSettings;
	}
	
	public List<PolicyDocumentsDTO> getPolicyDocumentsDTOs() {
		return policyDocumentsDTOs;
	}
	public void setPolicyDocumentsDTOs(List<PolicyDocumentsDTO> policyDocumentsDTOs) {
		this.policyDocumentsDTOs = policyDocumentsDTOs;
	}
	public List<PolicyDTO> getLinkedPolicies() {
		return linkedPolicies;
	}
	public void setLinkedPolicies(List<PolicyDTO> linkedPolicies) {
		this.linkedPolicies = linkedPolicies;
	}
	
	public boolean isLinked() {
		return linked;
	}
	public void setLinked(boolean linked) {
		this.linked = linked;
	}
	public String getLinkedPoliciesString() {
		return linkedPoliciesString;
	}
	public void setLinkedPoliciesString(String linkedPoliciesString) {
		this.linkedPoliciesString = linkedPoliciesString;
	}
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	public List<SubPolicyDTO> getSubPolicyDTOs() {
		return subPolicyDTOs;
	}
	public void setSubPolicyDTOs(List<SubPolicyDTO> subPolicyDTOs) {
		this.subPolicyDTOs = subPolicyDTOs;
	}
	
	
	
	
	
	
}
