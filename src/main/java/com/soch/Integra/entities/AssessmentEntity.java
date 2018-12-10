package com.soch.Integra.entities;
import static javax.persistence.GenerationType.IDENTITY;

// default package
// Generated Dec 16, 2017 11:08:41 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AssessmentTbl generated by hbm2java
 */
@Entity
@Table(name = "assessment_tbl")
public class AssessmentEntity implements java.io.Serializable {

	private Integer assessmentId;
	private ApplicationEntity applicationEntity;
	private String name;
	private Date assessmentDt;
	private Date nextAssessmentDt;
	private String status;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private Set<AssessmentPolicyEntity> assessmentPolicyEntities;
	private Set<AssessmentFileEntity> assessmentFileEntities;
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
	private String findingDescription;
	private String comments;
	private String recomendations;
	private String managementReponse;
	private String closeOutComments;
	private String securityRisks;
	private String budgetDescription;
	
	private String businessRisks;
	private String actionPlan;
	private double budget;
	private String lessonsLearnedDescription;
	private String lessonsEnteredBy;
	private Date lessonsEnteredDate;
	
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ASSESSMENT_ID", unique = true, nullable = false)
	public Integer getAssessmentId() {
		return this.assessmentId;
	}

	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPLICATION_ID")
	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}


	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ASSESSMENT_DT", length = 19)
	public Date getAssessmentDt() {
		return this.assessmentDt;
	}

	public void setAssessmentDt(Date assessmentDt) {
		this.assessmentDt = assessmentDt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NEXT_ASSESSMENT_DT", length = 19)
	public Date getNextAssessmentDt() {
		return this.nextAssessmentDt;
	}

	public void setNextAssessmentDt(Date nextAssessmentDt) {
		this.nextAssessmentDt = nextAssessmentDt;
	}

	@Column(name = "STATUS", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CREATED_BY", length = 300)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "UPDATED_BY", length = 300)
	
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TS", length = 19)
	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assessmentEntity",cascade=CascadeType.ALL)
	@OrderBy("assessmentPolicyId")
	public Set<AssessmentPolicyEntity> getAssessmentPolicyEntities() {
		return assessmentPolicyEntities;
	}

	public void setAssessmentPolicyEntities(Set<AssessmentPolicyEntity> assessmentPolicyEntities) {
		this.assessmentPolicyEntities = assessmentPolicyEntities;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assessmentEntity",cascade=CascadeType.ALL)
	public Set<AssessmentFileEntity> getAssessmentFileEntities() {
		return assessmentFileEntities;
	}

	public void setAssessmentFileEntities(Set<AssessmentFileEntity> assessmentFileEntities) {
		this.assessmentFileEntities = assessmentFileEntities;
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
	
	@Column(name = "FINDING_DESCRIPTION",length = 2000)
	public String getFindingDescription() {
		return findingDescription;
	}

	public void setFindingDescription(String findingDescription) {
		this.findingDescription = findingDescription;
	}
	@Column(name = "BUDGET_DESCRIPTION",length = 2000)
	public String getBudgetDescription() {
		return budgetDescription;
	}

	public void setBudgetDescription(String budgetDescription) {
		this.budgetDescription = budgetDescription;
	}
	
	
	
	
	
	
	
	
	

}