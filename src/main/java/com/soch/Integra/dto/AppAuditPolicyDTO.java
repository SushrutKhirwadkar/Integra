package com.soch.Integra.dto;

import java.util.Date;

public class AppAuditPolicyDTO {
	
	private Integer appAuditPolicyId;
	private String defaultVal;
	private String status;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private int policyId;
	
	
	public Integer getAppAuditPolicyId() {
		return appAuditPolicyId;
	}
	public void setAppAuditPolicyId(Integer appAuditPolicyId) {
		this.appAuditPolicyId = appAuditPolicyId;
	}
	public String getDefaultVal() {
		return defaultVal;
	}
	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	
	
	

}
