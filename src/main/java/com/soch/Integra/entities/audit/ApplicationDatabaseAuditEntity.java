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
 * ApplicationDatabaseTblAudit generated by hbm2java
 */
@Entity
@Table(name = "application_database_tbl_audit")
public class ApplicationDatabaseAuditEntity implements java.io.Serializable {

	private Integer applicationDatabaseTblAuditId;
	private String operation;
	private Date processDate;
	private int applicationDatabaseId;
	private Integer databaseId;
	private Integer applicationId;
	private Integer administrator;
	private Integer dataCustodian;
	private String technologies;
	private Integer createdBy;
	private Date createdTs;
	private String activityFlag;

	public ApplicationDatabaseAuditEntity() {
	}

	public ApplicationDatabaseAuditEntity(int applicationDatabaseId) {
		this.applicationDatabaseId = applicationDatabaseId;
	}

	public ApplicationDatabaseAuditEntity(String operation, Date processDate, int applicationDatabaseId,
			Integer databaseId, Integer applicationId, Integer administrator, Integer dataCustodian,
			String technologies, Integer createdBy, Date createdTs, String activityFlag) {
		this.operation = operation;
		this.processDate = processDate;
		this.applicationDatabaseId = applicationDatabaseId;
		this.databaseId = databaseId;
		this.applicationId = applicationId;
		this.administrator = administrator;
		this.dataCustodian = dataCustodian;
		this.technologies = technologies;
		this.createdBy = createdBy;
		this.createdTs = createdTs;
		this.activityFlag = activityFlag;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "application_database_tbl_audit_id", unique = true, nullable = false)
	public Integer getApplicationDatabaseTblAuditId() {
		return this.applicationDatabaseTblAuditId;
	}

	public void setApplicationDatabaseTblAuditId(Integer applicationDatabaseTblAuditId) {
		this.applicationDatabaseTblAuditId = applicationDatabaseTblAuditId;
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

	@Column(name = "APPLICATION_DATABASE_ID", nullable = false)
	public int getApplicationDatabaseId() {
		return this.applicationDatabaseId;
	}

	public void setApplicationDatabaseId(int applicationDatabaseId) {
		this.applicationDatabaseId = applicationDatabaseId;
	}

	@Column(name = "DATABASE_ID")
	public Integer getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(Integer databaseId) {
		this.databaseId = databaseId;
	}

	@Column(name = "APPLICATION_ID")
	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "ADMINISTRATOR")
	public Integer getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Integer administrator) {
		this.administrator = administrator;
	}

	@Column(name = "DATA_CUSTODIAN")
	public Integer getDataCustodian() {
		return this.dataCustodian;
	}

	public void setDataCustodian(Integer dataCustodian) {
		this.dataCustodian = dataCustodian;
	}

	@Column(name = "TECHNOLOGIES")
	public String getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	@Column(name = "CREATED_BY")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "ACTIVITY_FLAG", length = 1)
	public String getActivityFlag() {
		return this.activityFlag;
	}

	public void setActivityFlag(String activityFlag) {
		this.activityFlag = activityFlag;
	}

}
