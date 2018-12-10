package com.soch.Integra.entities.audit;
// Generated Oct 20, 2017 10:15:53 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AppAuditTblAudit generated by hbm2java
 */
@Entity
@Table(name = "app_audit_tbl_audit")
public class AppAuditAuditEntity implements java.io.Serializable {

	private int appAuditTblAuditId;
	private String operation;
	private Date processDate;
	private int auditId;
	private Integer applicationId;
	private String auditName;
	private String auditBy;
	private String auditType;
	private String auditDetails;
	private String auditFindings;
	private String recomendations;
	private String actionPlan;
	private Double budget;
	private String status;
	private Date nextAuditDate;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private Date auditDate;
	private String menagementResponse;
	private String businessRisks;
	private String securityRisks;
	private Integer auditTypeId;
	
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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "app_audit_tbl_audit_id", unique = true, nullable = false)
	public int getAppAuditTblAuditId() {
		return this.appAuditTblAuditId;
	}

	public void setAppAuditTblAuditId(int appAuditTblAuditId) {
		this.appAuditTblAuditId = appAuditTblAuditId;
	}

	@Column(name = "operation", length = 100)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "process_date", length = 19)
	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	@Column(name = "AUDIT_ID", nullable = false)
	public int getAuditId() {
		return this.auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	@Column(name = "APPLICATION_ID")
	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "AUDIT_NAME", length = 1000)
	public String getAuditName() {
		return this.auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	@Column(name = "AUDIT_BY", length = 1000)
	public String getAuditBy() {
		return this.auditBy;
	}

	public void setAuditBy(String auditBy) {
		this.auditBy = auditBy;
	}

	@Column(name = "AUDIT_TYPE", length = 2000)
	public String getAuditType() {
		return this.auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	@Column(name = "AUDIT_DETAILS", length = 2000)
	public String getAuditDetails() {
		return this.auditDetails;
	}

	public void setAuditDetails(String auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Column(name = "AUDIT_FINDINGS", length = 65535)
	public String getAuditFindings() {
		return this.auditFindings;
	}

	public void setAuditFindings(String auditFindings) {
		this.auditFindings = auditFindings;
	}

	@Column(name = "RECOMENDATIONS", length = 2000)
	public String getRecomendations() {
		return this.recomendations;
	}

	public void setRecomendations(String recomendations) {
		this.recomendations = recomendations;
	}

	@Column(name = "ACTION_PLAN", length = 2000)
	public String getActionPlan() {
		return this.actionPlan;
	}

	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}

	@Column(name = "BUDGET", precision = 10)
	public Double getBudget() {
		return this.budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	@Column(name = "STATUS", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NEXT_AUDIT_DATE", length = 10)
	public Date getNextAuditDate() {
		return this.nextAuditDate;
	}

	public void setNextAuditDate(Date nextAuditDate) {
		this.nextAuditDate = nextAuditDate;
	}

	@Column(name = "CREATED_BY", length = 500)
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

	@Column(name = "UPDATED_BY", length = 500)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "AUDIT_DATE", length = 10)
	public Date getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	@Column(name = "MENAGEMENT_RESPONSE", length = 2000)
	public String getMenagementResponse() {
		return this.menagementResponse;
	}

	public void setMenagementResponse(String menagementResponse) {
		this.menagementResponse = menagementResponse;
	}

	@Column(name = "BUSINESS_RISKS", length = 3000)
	public String getBusinessRisks() {
		return this.businessRisks;
	}

	public void setBusinessRisks(String businessRisks) {
		this.businessRisks = businessRisks;
	}

	@Column(name = "SECURITY_RISKS", length = 3000)
	public String getSecurityRisks() {
		return this.securityRisks;
	}

	public void setSecurityRisks(String securityRisks) {
		this.securityRisks = securityRisks;
	}

	@Column(name = "AUDIT_TYPE_ID")
	public Integer getAuditTypeId() {
		return this.auditTypeId;
	}

	public void setAuditTypeId(Integer auditTypeId) {
		this.auditTypeId = auditTypeId;
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

}