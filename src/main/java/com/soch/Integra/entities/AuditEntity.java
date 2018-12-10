package com.soch.Integra.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "audit_tbl")
public class AuditEntity implements java.io.Serializable{
	
	private int auditId;
	private Date lastAudit;
	private Date upComingAudit;
	private String comments;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "AUDIT_ID", unique = true, nullable = false)
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_AUDIT", length = 19)
	public Date getLastAudit() {
		return lastAudit;
	}
	public void setLastAudit(Date lastAudit) {
		this.lastAudit = lastAudit;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPCOMING_AUDIT", length = 19)
	public Date getUpComingAudit() {
		return upComingAudit;
	}
	public void setUpComingAudit(Date upComingAudit) {
		this.upComingAudit = upComingAudit;
	}
	
	
	@Column(name = "COMMENTS")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
