package com.soch.Integra.entities;
// default package
// Generated Dec 21, 2017 11:04:44 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AssessmentPolicyTblAudit generated by hbm2java
 */
@Entity
@Table(name = "assessment_policy_tbl_audit")
public class AssessmentPolicyAuditEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2992999790345875803L;
	private Integer assessmentPolicyTblAuditId;
	private String operation;
	private Date processDate;
	private Integer assessmentPolicyId;
	private Integer policyId;
	private String confidentiality;
	private String integrity;
	private String availability;
	private Date completionDt;
	private String vulnerabilityFamily;
	private String riskVulnerability;
	private String riskThreat;
	private String riskSummary;
	private String impactMagnitude;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private Integer assessmentId;
	private String cybersecurityFramework;
	private String controlsInPlace;

	public AssessmentPolicyAuditEntity() {
	}

	public AssessmentPolicyAuditEntity(String operation, Date processDate, Integer assessmentPolicyId, Integer policyId,
			String confidentiality, String integrity, String availability, Date completionDt,
			String vulnerabilityFamily, String riskVulnerability, String riskThreat, String riskSummary,
			String impactMagnitude, String createdBy, Date createdTs, String updatedBy, Date updatedTs,
			Integer assessmentId, String cybersecurityFramework, String controlsInPlace) {
		this.operation = operation;
		this.processDate = processDate;
		this.assessmentPolicyId = assessmentPolicyId;
		this.policyId = policyId;
		this.confidentiality = confidentiality;
		this.integrity = integrity;
		this.availability = availability;
		this.completionDt = completionDt;
		this.vulnerabilityFamily = vulnerabilityFamily;
		this.riskVulnerability = riskVulnerability;
		this.riskThreat = riskThreat;
		this.riskSummary = riskSummary;
		this.impactMagnitude = impactMagnitude;
		this.createdBy = createdBy;
		this.createdTs = createdTs;
		this.updatedBy = updatedBy;
		this.updatedTs = updatedTs;
		this.assessmentId = assessmentId;
		this.cybersecurityFramework = cybersecurityFramework;
		this.controlsInPlace = controlsInPlace;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "assessment_policy_tbl_audit_id", unique = true, nullable = false)
	public Integer getAssessmentPolicyTblAuditId() {
		return this.assessmentPolicyTblAuditId;
	}

	public void setAssessmentPolicyTblAuditId(Integer assessmentPolicyTblAuditId) {
		this.assessmentPolicyTblAuditId = assessmentPolicyTblAuditId;
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

	@Column(name = "ASSESSMENT_POLICY_ID")
	public Integer getAssessmentPolicyId() {
		return this.assessmentPolicyId;
	}

	public void setAssessmentPolicyId(Integer assessmentPolicyId) {
		this.assessmentPolicyId = assessmentPolicyId;
	}

	@Column(name = "POLICY_ID")
	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	@Column(name = "CONFIDENTIALITY", length = 1)
	public String getConfidentiality() {
		return this.confidentiality;
	}

	public void setConfidentiality(String confidentiality) {
		this.confidentiality = confidentiality;
	}

	@Column(name = "INTEGRITY", length = 1)
	public String getIntegrity() {
		return this.integrity;
	}

	public void setIntegrity(String integrity) {
		this.integrity = integrity;
	}

	@Column(name = "AVAILABILITY", length = 1)
	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMPLETION_dt", length = 19)
	public Date getCompletionDt() {
		return this.completionDt;
	}

	public void setCompletionDt(Date completionDt) {
		this.completionDt = completionDt;
	}

	@Column(name = "VULNERABILITY_FAMILY", length = 65535)
	public String getVulnerabilityFamily() {
		return this.vulnerabilityFamily;
	}

	public void setVulnerabilityFamily(String vulnerabilityFamily) {
		this.vulnerabilityFamily = vulnerabilityFamily;
	}

	@Column(name = "RISK_VULNERABILITY", length = 65535)
	public String getRiskVulnerability() {
		return this.riskVulnerability;
	}

	public void setRiskVulnerability(String riskVulnerability) {
		this.riskVulnerability = riskVulnerability;
	}

	@Column(name = "RISK_THREAT", length = 65535)
	public String getRiskThreat() {
		return this.riskThreat;
	}

	public void setRiskThreat(String riskThreat) {
		this.riskThreat = riskThreat;
	}

	@Column(name = "RISK_SUMMARY", length = 65535)
	public String getRiskSummary() {
		return this.riskSummary;
	}

	public void setRiskSummary(String riskSummary) {
		this.riskSummary = riskSummary;
	}

	@Column(name = "IMPACT_MAGNITUDE", length = 200)
	public String getImpactMagnitude() {
		return this.impactMagnitude;
	}

	public void setImpactMagnitude(String impactMagnitude) {
		this.impactMagnitude = impactMagnitude;
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

	@Column(name = "ASSESSMENT_ID")
	public Integer getAssessmentId() {
		return this.assessmentId;
	}

	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	@Column(name = "CYBERSECURITY_FRAMEWORK", length = 1000)
	public String getCybersecurityFramework() {
		return this.cybersecurityFramework;
	}

	public void setCybersecurityFramework(String cybersecurityFramework) {
		this.cybersecurityFramework = cybersecurityFramework;
	}

	@Column(name = "CONTROLS_IN_PLACE", length = 1000)
	public String getControlsInPlace() {
		return this.controlsInPlace;
	}

	public void setControlsInPlace(String controlsInPlace) {
		this.controlsInPlace = controlsInPlace;
	}

}
