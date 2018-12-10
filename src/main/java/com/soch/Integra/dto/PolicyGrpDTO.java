package com.soch.Integra.dto;

import java.util.Date;

public class PolicyGrpDTO {
	
	private int policyGrpId;
	private String policyGrpName;
	private String description;
    private String createdBy;
    private Date createdTs;
    private int auditTypeId;
    private Date reviewDate;
    private String status;
    private String auditTypeName;
    private String definitiveSource;
    private String owner;
    private String policyReviewTerm;
    private int policyReviewTermId;
	private Date policyReviewDate;
	private Date lastReviewDate;
	private String updatedBy;
	private Date updatedTs;
	private String resourceLinks;
    
	public int getAuditTypeId() {
		return auditTypeId;
	}
	public void setAuditTypeId(int auditTypeId) {
		this.auditTypeId = auditTypeId;
	}
	public int getPolicyGrpId() {
		return policyGrpId;
	}
	public void setPolicyGrpId(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}
	public String getPolicyGrpName() {
		return policyGrpName;
	}
	public void setPolicyGrpName(String policyGrpName) {
		this.policyGrpName = policyGrpName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuditTypeName() {
		return auditTypeName;
	}
	public void setAuditTypeName(String auditTypeName) {
		this.auditTypeName = auditTypeName;
	}
	public String getDefinitiveSource() {
		return definitiveSource;
	}
	public void setDefinitiveSource(String definitiveSource) {
		this.definitiveSource = definitiveSource;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPolicyReviewTerm() {
		return policyReviewTerm;
	}
	public void setPolicyReviewTerm(String policyReviewTerm) {
		this.policyReviewTerm = policyReviewTerm;
	}
	public int getPolicyReviewTermId() {
		return policyReviewTermId;
	}
	public void setPolicyReviewTermId(int policyReviewTermId) {
		this.policyReviewTermId = policyReviewTermId;
	}
	public Date getPolicyReviewDate() {
		return policyReviewDate;
	}
	public void setPolicyReviewDate(Date policyReviewDate) {
		this.policyReviewDate = policyReviewDate;
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
	public Date getLastReviewDate() {
		return lastReviewDate;
	}
	public void setLastReviewDate(Date lastReviewDate) {
		this.lastReviewDate = lastReviewDate;
	}
	public String getResourceLinks() {
		return resourceLinks;
	}
	public void setResourceLinks(String resourceLinks) {
		this.resourceLinks = resourceLinks;
	}
	
	
}
