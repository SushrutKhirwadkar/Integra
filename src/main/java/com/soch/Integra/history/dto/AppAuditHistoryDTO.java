package com.soch.Integra.history.dto;

import java.util.Date;
import java.util.List;

import com.soch.Integra.dto.AuditPolicyDTO;

public class AppAuditHistoryDTO {
	private int appAuditId;
	private int applicationID;
	private String auditName;
	private String auditBy;
	private Date auditDate;
	private String auditType;
	private String auditDetails;
	private String auditFindings;
	private String recomendations;
	private String actionPlan;
	private double budget;
	private String status;
	private Date nextAuditDate;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date upadateTs;
	private String managementReponse;
	private String businessRisks;
	private String securityRisks;
	private String auditTypeName;
	private List<AppAuditFileHistoryDTO> appAuditFileDTOs;
	private List<AuditPolicyDTO> auditPolicyDTOs;
	private int applicationId;
	private String appAcronym;
	
	private String typeOfFindings;
	private String overallRiskLevel;
	private String findingComments;
	private String responsibleParty;
	private String recomendedBy;
	private Date estimatedCompletionDt;
	private String responseBy;
	private Date responseDt;
	private Date actionPlanStartDt;
	private Date actionPlanEndDt;
	private String actionPlanAssignedTo;
	private String actionPlanSummary;
	private String actionPlanTasks;
	private String actionPlanCloseoutComments;
	private String budgetDescriptionHTML;
	
	
	private String policyName;
	private String policyGrpName;
	
	public int getAppAuditId() {
		return appAuditId;
	}
	public void setAppAuditId(int appAuditId) {
		this.appAuditId = appAuditId;
	}
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	public String getAuditBy() {
		return auditBy;
	}
	public void setAuditBy(String auditBy) {
		this.auditBy = auditBy;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public String getAuditDetails() {
		return auditDetails;
	}
	public void setAuditDetails(String auditDetails) {
		this.auditDetails = auditDetails;
	}
	public String getAuditFindings() {
		return auditFindings;
	}
	public void setAuditFindings(String auditFindings) {
		this.auditFindings = auditFindings;
	}
	public String getRecomendations() {
		return recomendations;
	}
	public void setRecomendations(String recomendations) {
		this.recomendations = recomendations;
	}
	public String getActionPlan() {
		return actionPlan;
	}
	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getNextAuditDate() {
		return nextAuditDate;
	}
	public void setNextAuditDate(Date nextAuditDate) {
		this.nextAuditDate = nextAuditDate;
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
	public Date getUpadateTs() {
		return upadateTs;
	}
	public void setUpadateTs(Date upadateTs) {
		this.upadateTs = upadateTs;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public String getManagementReponse() {
		return managementReponse;
	}
	public void setManagementReponse(String managementReponse) {
		this.managementReponse = managementReponse;
	}
	public String getBusinessRisks() {
		return businessRisks;
	}
	public void setBusinessRisks(String businessRisks) {
		this.businessRisks = businessRisks;
	}
	public String getSecurityRisks() {
		return securityRisks;
	}
	public void setSecurityRisks(String securityRisks) {
		this.securityRisks = securityRisks;
	}
	public String getAuditTypeName() {
		return auditTypeName;
	}
	public void setAuditTypeName(String auditTypeName) {
		this.auditTypeName = auditTypeName;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getAppAcronym() {
		return appAcronym;
	}
	public void setAppAcronym(String appAcronym) {
		this.appAcronym = appAcronym;
	}
	public List<AppAuditFileHistoryDTO> getAppAuditFileDTOs() {
		return appAuditFileDTOs;
	}
	public void setAppAuditFileDTOs(List<AppAuditFileHistoryDTO> appAuditFileDTOs) {
		this.appAuditFileDTOs = appAuditFileDTOs;
	}
	public List<AuditPolicyDTO> getAuditPolicyDTOs() {
		return auditPolicyDTOs;
	}
	public void setAuditPolicyDTOs(List<AuditPolicyDTO> auditPolicyDTOs) {
		this.auditPolicyDTOs = auditPolicyDTOs;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getTypeOfFindings() {
		return typeOfFindings;
	}
	public void setTypeOfFindings(String typeOfFindings) {
		this.typeOfFindings = typeOfFindings;
	}
	public String getOverallRiskLevel() {
		return overallRiskLevel;
	}
	public void setOverallRiskLevel(String overallRiskLevel) {
		this.overallRiskLevel = overallRiskLevel;
	}
	public String getFindingComments() {
		return findingComments;
	}
	public void setFindingComments(String findingComments) {
		this.findingComments = findingComments;
	}
	public String getResponsibleParty() {
		return responsibleParty;
	}
	public void setResponsibleParty(String responsibleParty) {
		this.responsibleParty = responsibleParty;
	}
	public String getRecomendedBy() {
		return recomendedBy;
	}
	public void setRecomendedBy(String recomendedBy) {
		this.recomendedBy = recomendedBy;
	}
	public Date getEstimatedCompletionDt() {
		return estimatedCompletionDt;
	}
	public void setEstimatedCompletionDt(Date estimatedCompletionDt) {
		this.estimatedCompletionDt = estimatedCompletionDt;
	}
	public String getResponseBy() {
		return responseBy;
	}
	public void setResponseBy(String responseBy) {
		this.responseBy = responseBy;
	}
	public Date getResponseDt() {
		return responseDt;
	}
	public void setResponseDt(Date responseDt) {
		this.responseDt = responseDt;
	}
	public Date getActionPlanStartDt() {
		return actionPlanStartDt;
	}
	public void setActionPlanStartDt(Date actionPlanStartDt) {
		this.actionPlanStartDt = actionPlanStartDt;
	}
	public Date getActionPlanEndDt() {
		return actionPlanEndDt;
	}
	public void setActionPlanEndDt(Date actionPlanEndDt) {
		this.actionPlanEndDt = actionPlanEndDt;
	}
	public String getActionPlanAssignedTo() {
		return actionPlanAssignedTo;
	}
	public void setActionPlanAssignedTo(String actionPlanAssignedTo) {
		this.actionPlanAssignedTo = actionPlanAssignedTo;
	}
	public String getActionPlanSummary() {
		return actionPlanSummary;
	}
	public void setActionPlanSummary(String actionPlanSummary) {
		this.actionPlanSummary = actionPlanSummary;
	}
	public String getActionPlanTasks() {
		return actionPlanTasks;
	}
	public void setActionPlanTasks(String actionPlanTasks) {
		this.actionPlanTasks = actionPlanTasks;
	}
	public String getActionPlanCloseoutComments() {
		return actionPlanCloseoutComments;
	}
	public void setActionPlanCloseoutComments(String actionPlanCloseoutComments) {
		this.actionPlanCloseoutComments = actionPlanCloseoutComments;
	}
	public String getBudgetDescriptionHTML() {
		return budgetDescriptionHTML;
	}
	public void setBudgetDescriptionHTML(String budgetDescriptionHTML) {
		this.budgetDescriptionHTML = budgetDescriptionHTML;
	}
	public String getPolicyGrpName() {
		return policyGrpName;
	}
	public void setPolicyGrpName(String policyGrpName) {
		this.policyGrpName = policyGrpName;
	}
	
}
