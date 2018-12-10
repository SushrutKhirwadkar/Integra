package com.soch.Integra.dto;

import java.util.Date;

public class AssessmentAuditDTO {
	private Integer assessmentTblAuditId;
	private String operation;
	private Date processDate;
	private Integer assessmentId;
	private String name;
	private Date assessmentDt;
	private Date nextAssessmentDt;
	private String status;
	private Integer applicationId;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	public Integer getAssessmentTblAuditId() {
		return assessmentTblAuditId;
	}
	public String getOperation() {
		return operation;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public Integer getAssessmentId() {
		return assessmentId;
	}
	public String getName() {
		return name;
	}
	public Date getAssessmentDt() {
		return assessmentDt;
	}
	public Date getNextAssessmentDt() {
		return nextAssessmentDt;
	}
	public String getStatus() {
		return status;
	}
	public Integer getApplicationId() {
		return applicationId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setAssessmentTblAuditId(Integer assessmentTblAuditId) {
		this.assessmentTblAuditId = assessmentTblAuditId;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAssessmentDt(Date assessmentDt) {
		this.assessmentDt = assessmentDt;
	}
	public void setNextAssessmentDt(Date nextAssessmentDt) {
		this.nextAssessmentDt = nextAssessmentDt;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	
}
