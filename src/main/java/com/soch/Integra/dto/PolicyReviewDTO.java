package com.soch.Integra.dto;

import java.util.Date;
import java.util.List;


public class PolicyReviewDTO {
	private Integer policyReview;
	private Integer policyGrpId;
	private String policyGrpName;
	private String assignedTo;
	private String comments;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private String status;
	private Date dueDate;
	
	private String definitiveSourceName;
	
	List<PolicyDTO> policyDTOs;
	
	public Integer getPolicyReview() {
		return policyReview;
	}
	public void setPolicyReview(Integer policyReview) {
		this.policyReview = policyReview;
	}
	public Integer getPolicyGrpId() {
		return policyGrpId;
	}
	public void setPolicyGrpId(Integer policyGrpId) {
		this.policyGrpId = policyGrpId;
	}
	public String getPolicyGrpName() {
		return policyGrpName;
	}
	public void setPolicyGrpName(String policyGrpName) {
		this.policyGrpName = policyGrpName;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getDefinitiveSourceName() {
		return definitiveSourceName;
	}
	public void setDefinitiveSourceName(String definitiveSourceName) {
		this.definitiveSourceName = definitiveSourceName;
	}
	public List<PolicyDTO> getPolicyDTOs() {
		return policyDTOs;
	}
	public void setPolicyDTOs(List<PolicyDTO> policyDTOs) {
		this.policyDTOs = policyDTOs;
	}
	
	
}
