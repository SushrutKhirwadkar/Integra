package com.soch.Integra.dto;

public class AuditDashBoardDTO {
	
	private String applicationAcronym;
	private int inProgress;
	private int completed;
	private int suspended;
	
	public String getApplicationAcronym() {
		return applicationAcronym;
	}
	public void setApplicationAcronym(String applicationAcronym) {
		this.applicationAcronym = applicationAcronym;
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
	
	

}
