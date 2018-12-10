package com.soch.Integra.dto;

import java.util.Date;

public class AuditDTO {
	private int auditId;
	private Date lastAudit;
	private Date upComingAudit;
	private String comments;
	
	
	
	
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public Date getLastAudit() {
		return lastAudit;
	}
	public void setLastAudit(Date lastAudit) {
		this.lastAudit = lastAudit;
	}
	public Date getUpComingAudit() {
		return upComingAudit;
	}
	public void setUpComingAudit(Date upComingAudit) {
		this.upComingAudit = upComingAudit;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
	
}
