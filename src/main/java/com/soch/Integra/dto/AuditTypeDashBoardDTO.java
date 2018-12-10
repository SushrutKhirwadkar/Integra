package com.soch.Integra.dto;

public class AuditTypeDashBoardDTO {
	
	private String auditTypeName;
	private int inProgress;
	private int completed;
	private int suspended;
	private int auditTypeId;
	
	public String getAuditTypeName() {
		return auditTypeName;
	}
	public void setAuditTypeName(String auditTypeName) {
		this.auditTypeName = auditTypeName;
	}
	public int getInProgress() {
		return inProgress;
	}
	public void setInProgress(int inProgress) {
		this.inProgress = inProgress;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getSuspended() {
		return suspended;
	}
	public void setSuspended(int suspended) {
		this.suspended = suspended;
	}
	public int getAuditTypeId() {
		return auditTypeId;
	}
	public void setAuditTypeId(int auditTypeId) {
		this.auditTypeId = auditTypeId;
	}
}
