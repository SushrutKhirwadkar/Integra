package com.soch.Integra.entities.audit;
// Generated Oct 20, 2017 10:15:53 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AppTechnicalManagerTblAudit generated by hbm2java
 */
@Entity
@Table(name = "app_technical_manager_tbl_audit")
public class AppTechnicalManagerAuditEntity implements java.io.Serializable {

	private Integer appTechnicalManagerTblAuditId;
	private String operation;
	private Date processDate;
	private int appTechnicalManagerId;
	private Integer appTechnicalManager;
	private Integer application;
	private String activeFlag;

	public AppTechnicalManagerAuditEntity() {
	}

	public AppTechnicalManagerAuditEntity(int appTechnicalManagerId) {
		this.appTechnicalManagerId = appTechnicalManagerId;
	}

	public AppTechnicalManagerAuditEntity(String operation, Date processDate, int appTechnicalManagerId,
			Integer appTechnicalManager, Integer application, String activeFlag) {
		this.operation = operation;
		this.processDate = processDate;
		this.appTechnicalManagerId = appTechnicalManagerId;
		this.appTechnicalManager = appTechnicalManager;
		this.application = application;
		this.activeFlag = activeFlag;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "app_technical_manager_tbl_audit_id", unique = true, nullable = false)
	public Integer getAppTechnicalManagerTblAuditId() {
		return this.appTechnicalManagerTblAuditId;
	}

	public void setAppTechnicalManagerTblAuditId(Integer appTechnicalManagerTblAuditId) {
		this.appTechnicalManagerTblAuditId = appTechnicalManagerTblAuditId;
	}

	@Column(name = "operation", length = 100)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "process_date", length = 19)
	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	@Column(name = "app_technical_manager_id", nullable = false)
	public int getAppTechnicalManagerId() {
		return this.appTechnicalManagerId;
	}

	public void setAppTechnicalManagerId(int appTechnicalManagerId) {
		this.appTechnicalManagerId = appTechnicalManagerId;
	}

	@Column(name = "app_technical_manager")
	public Integer getAppTechnicalManager() {
		return this.appTechnicalManager;
	}

	public void setAppTechnicalManager(Integer appTechnicalManager) {
		this.appTechnicalManager = appTechnicalManager;
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
