package com.soch.Integra.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "app_audit_tbl")
public class AppAuditEntity {
	
	private int appAuditId;
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
	private ApplicationEntity applicationEntity;
	private String managementReponse;
	private String businessRisks;
	private String securityRisks;
	//private AuditTypeEntity auditTypeEntity;
	private int auditTypeId;
	private PolicyGrpEntity policyGrpEntity;

    private String budgetDescriptionHTML;
	private List<AppAuditFileEntity> AppAuditFileEntities;
	private List<AppAuditPolicyEntity> appAuditPolicyEntities ;
	
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
	private String lessonsLearnedDescription;
	private String lessonsEnteredBy;

	private Date lessonsEnteredDate;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "AUDIT_ID", unique = true, nullable = false)
	public int getAppAuditId() {
		return appAuditId;
	}
	public void setAppAuditId(int appAuditId) {
		this.appAuditId = appAuditId;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "APPLICATION_ID")
	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}
	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}
	
	@Column(name = "AUDIT_NAME")
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	
	@Column(name = "AUDIT_BY")
	public String getAuditBy() {
		return auditBy;
	}
	public void setAuditBy(String auditBy) {
		this.auditBy = auditBy;
	}
	
	@Column(name = "AUDIT_DATE")
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	
	@Column(name = "AUDIT_TYPE")
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	
	@Column(name = "AUDIT_DETAILS")
	public String getAuditDetails() {
		return auditDetails;
	}
	public void setAuditDetails(String auditDetails) {
		this.auditDetails = auditDetails;
	}
	
	@Column(name = "AUDIT_FINDINGS")
	public String getAuditFindings() {
		return auditFindings;
	}
	public void setAuditFindings(String auditFindings) {
		this.auditFindings = auditFindings;
	}
	
	@Column(name = "RECOMENDATIONS")
	public String getRecomendations() {
		return recomendations;
	}
	public void setRecomendations(String recomendations) {
		this.recomendations = recomendations;
	}
	
	@Column(name = "ACTION_PLAN")
	public String getActionPlan() {
		return actionPlan;
	}
	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}
	
	@Column(name = "BUDGET")
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "NEXT_AUDIT_DATE")
	public Date getNextAuditDate() {
		return nextAuditDate;
	}
	public void setNextAuditDate(Date nextAuditDate) {
		this.nextAuditDate = nextAuditDate;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "CREATED_TS")
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "UPDATED_TS")
	public Date getUpadateTs() {
		return upadateTs;
	}
	public void setUpadateTs(Date upadateTs) {
		this.upadateTs = upadateTs;
	}
	
	@Column(name = "MENAGEMENT_RESPONSE")
	public String getManagementReponse() {
		return managementReponse;
	}
	public void setManagementReponse(String managementReponse) {
		this.managementReponse = managementReponse;
	}
	
	@Column(name = "BUSINESS_RISKS")
	public String getBusinessRisks() {
		return businessRisks;
	}
	public void setBusinessRisks(String businessRisks) {
		this.businessRisks = businessRisks;
	}
	
	@Column(name = "SECURITY_RISKS")
	public String getSecurityRisks() {
		return securityRisks;
	}
	public void setSecurityRisks(String securityRisks) {
		this.securityRisks = securityRisks;
	}
	
	/*@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "AUDIT_TYPE_ID")
	public AuditTypeEntity getAuditTypeEntity() {
		return auditTypeEntity;
	}
	public void setAuditTypeEntity(AuditTypeEntity auditTypeEntity) {
		this.auditTypeEntity = auditTypeEntity;
	}*/
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "POLICY_GRP_ID")
	public PolicyGrpEntity getPolicyGrpEntity() {
		return policyGrpEntity;
	}
	public void setPolicyGrpEntity(PolicyGrpEntity policyGrpEntity) {
		this.policyGrpEntity = policyGrpEntity;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appAuditEntity",cascade=CascadeType.ALL)
	public List<AppAuditFileEntity> getAppAuditFileEntities() {
		return AppAuditFileEntities;
	}
	public void setAppAuditFileEntities(List<AppAuditFileEntity> appAuditFileEntities) {
		AppAuditFileEntities = appAuditFileEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appAuditEntity",cascade=CascadeType.ALL)
	@OrderBy("appAuditPolicyId")
	public List<AppAuditPolicyEntity> getAppAuditPolicyEntities() {
		return appAuditPolicyEntities;
	}
	public void setAppAuditPolicyEntities(List<AppAuditPolicyEntity> appAuditPolicyEntities) {
		this.appAuditPolicyEntities = appAuditPolicyEntities;
	}
	
	@Column(name = "TYPE_OF_FINDINGS", length = 2000)
	public String getTypeOfFindings() {
		return this.typeOfFindings;
	}

	public void setTypeOfFindings(String typeOfFindings) {
		this.typeOfFindings = typeOfFindings;
	}

	@Column(name = "OVERALL_RISK_LEVEL", length = 45)
	public String getOverallRiskLevel() {
		return this.overallRiskLevel;
	}

	public void setOverallRiskLevel(String overallRiskLevel) {
		this.overallRiskLevel = overallRiskLevel;
	}

	@Column(name = "FINDING_COMMENTS", length = 65535)
	public String getFindingComments() {
		return this.findingComments;
	}

	public void setFindingComments(String findingComments) {
		this.findingComments = findingComments;
	}

	@Column(name = "RESPONSIBLE_PARTY", length = 1000)
	public String getResponsibleParty() {
		return this.responsibleParty;
	}

	public void setResponsibleParty(String responsibleParty) {
		this.responsibleParty = responsibleParty;
	}

	@Column(name = "RECOMENDED_BY", length = 500)
	public String getRecomendedBy() {
		return this.recomendedBy;
	}

	public void setRecomendedBy(String recomendedBy) {
		this.recomendedBy = recomendedBy;
	}

	@Column(name = "ESTIMATED_COMPLETION_DT", length = 19)
	public Date getEstimatedCompletionDt() {
		return this.estimatedCompletionDt;
	}

	public void setEstimatedCompletionDt(Date estimatedCompletionDt) {
		this.estimatedCompletionDt = estimatedCompletionDt;
	}

	@Column(name = "RESPONSE_BY", length = 500)
	public String getResponseBy() {
		return this.responseBy;
	}

	public void setResponseBy(String responseBy) {
		this.responseBy = responseBy;
	}

	@Column(name = "RESPONSE_DT", length = 19)
	public Date getResponseDt() {
		return this.responseDt;
	}

	public void setResponseDt(Date responseDt) {
		this.responseDt = responseDt;
	}

	@Column(name = "ACTION_PLAN_START_DT", length = 19)
	public Date getActionPlanStartDt() {
		return this.actionPlanStartDt;
	}

	public void setActionPlanStartDt(Date actionPlanStartDt) {
		this.actionPlanStartDt = actionPlanStartDt;
	}

	@Column(name = "ACTION_PLAN_END_DT", length = 19)
	public Date getActionPlanEndDt() {
		return this.actionPlanEndDt;
	}

	public void setActionPlanEndDt(Date actionPlanEndDt) {
		this.actionPlanEndDt = actionPlanEndDt;
	}

	@Column(name = "ACTION_PLAN_ASSIGNED_TO", length = 500)
	public String getActionPlanAssignedTo() {
		return this.actionPlanAssignedTo;
	}

	public void setActionPlanAssignedTo(String actionPlanAssignedTo) {
		this.actionPlanAssignedTo = actionPlanAssignedTo;
	}

	@Column(name = "ACTION_PLAN_SUMMARY", length = 65535)
	public String getActionPlanSummary() {
		return this.actionPlanSummary;
	}

	public void setActionPlanSummary(String actionPlanSummary) {
		this.actionPlanSummary = actionPlanSummary;
	}

	@Column(name = "ACTION_PLAN_TASKS", length = 65535)
	public String getActionPlanTasks() {
		return this.actionPlanTasks;
	}

	public void setActionPlanTasks(String actionPlanTasks) {
		this.actionPlanTasks = actionPlanTasks;
	}

	@Column(name = "ACTION_PLAN_CLOSEOUT_COMMENTS", length = 65535)
	public String getActionPlanCloseoutComments() {
		return this.actionPlanCloseoutComments;
	}

	public void setActionPlanCloseoutComments(String actionPlanCloseoutComments) {
		this.actionPlanCloseoutComments = actionPlanCloseoutComments;
	}
	
	@Column(name = "AUDIT_TYPE_ID")
	public int getAuditTypeId() {
		return auditTypeId;
	}
	public void setAuditTypeId(int auditTypeId) {
		this.auditTypeId = auditTypeId;
	}
	
	
	
	
	@Column(name = "LESSONS_LEARNED_DESCRIPTION")
	public String getLessonsLearnedDescription() {
	return lessonsLearnedDescription;
	}
	public void setLessonsLearnedDescription(String lessonsLearnedDescription) {
	this.lessonsLearnedDescription = lessonsLearnedDescription;
	}
	@Column(name = "LESSONS_ENTERED_BY")
	public String getLessonsEnteredBy() {
	return lessonsEnteredBy;
	}
	public void setLessonsEnteredBy(String lessonsEnteredBy) {
	this.lessonsEnteredBy = lessonsEnteredBy;
	}
	
	
	
	
	@Column(name = "LESSONS_ENTERED_DATE")
	public Date getLessonsEnteredDate() {
	return lessonsEnteredDate;
	}
	public void setLessonsEnteredDate(Date lessonsEnteredDate) {
	this.lessonsEnteredDate = lessonsEnteredDate;
	}
	
	@Column(name = "BUDGET_DESCRIPTIONHTML")
	public String getBudgetDescriptionHTML() {
	return budgetDescriptionHTML;
	}
	public void setBudgetDescriptionHTML(String budgetDescriptionHTML) {
	this.budgetDescriptionHTML = budgetDescriptionHTML;
	}
	

}
