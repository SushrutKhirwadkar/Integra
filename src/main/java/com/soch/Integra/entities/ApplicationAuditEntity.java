package com.soch.Integra.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "application_audit_tbl")
public class ApplicationAuditEntity implements java.io.Serializable {

	private int applicationAuditId;
	private ApplicationEntity applicationEntity;
	private AuditEntity auditEntity;
	private boolean activityFlag;

	public ApplicationAuditEntity() {
	}

	public ApplicationAuditEntity(int applicationAuditId) {
		this.applicationAuditId = applicationAuditId;
	}

	public ApplicationAuditEntity(int applicationAuditId, ApplicationEntity applicationEntity, AuditEntity auditEntity) {
		this.applicationAuditId = applicationAuditId;
		this.applicationEntity = applicationEntity;
		this.auditEntity = auditEntity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "APP_AUDIT_ID", unique = true, nullable = false)
	public int getApplicationAuditId() {
		return this.applicationAuditId;
	}

	public void setApplicationAuditId(int applicationAuditId) {
		this.applicationAuditId = applicationAuditId;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "APPLICATION_ID")
	public ApplicationEntity getApplicationEntity() {
		return this.applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "AUDIT_ID")
	public AuditEntity getAuditEntity() {
		return this.auditEntity;
	}

	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}
	
	@Column(name = "ACTIVITY_FLAG")
	public boolean isActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(boolean activityFlag) {
		this.activityFlag = activityFlag;
	}

}

