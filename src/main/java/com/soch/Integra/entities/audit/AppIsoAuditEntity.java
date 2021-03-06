package com.soch.Integra.entities.audit;
// Generated Oct 20, 2017 10:15:53 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AppIsoTblAudit generated by hbm2java
 */
@Entity
@Table(name = "app_iso_tbl_audit")
public class AppIsoAuditEntity implements java.io.Serializable {
	
	private int appIsoAuditId;
	private String operation;
	private Date processDate;
	private int appIsoId;
	private Integer appIso;
	private Integer application;
	private String activeFlag;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "app_iso_audit_id", unique = true, nullable = false)
	public int getAppIsoAuditId() {
		return appIsoAuditId;
	}

	public void setAppIsoAuditId(int appIsoAuditId) {
		this.appIsoAuditId = appIsoAuditId;
	}

	@Column(name = "operation", length = 100)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name = "process_date", length = 19)
	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	@Column(name = "app_iso_id", nullable = false)
	public int getAppIsoId() {
		return this.appIsoId;
	}

	public void setAppIsoId(int appIsoId) {
		this.appIsoId = appIsoId;
	}

	@Column(name = "app_iso")
	public Integer getAppIso() {
		return this.appIso;
	}

	public void setAppIso(Integer appIso) {
		this.appIso = appIso;
	}
	
	
	@Column(name = "application")
	public Integer getApplication() {
		return this.application;
	}

	public void setApplication(Integer application) {
		this.application = application;
	}

	@Column(name = "active_flag", length = 1)
	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	

}
