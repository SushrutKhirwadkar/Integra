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
 * AppStatusTblAudit generated by hbm2java
 */
@Entity
@Table(name = "app_status_tbl_audit")
public class AppStatusAuditEntity implements java.io.Serializable {

	private Integer appStatusTblAuditId;
	private String operation;
	private Date processDate;
	private int appStatusTblId;
	private Integer updatedSection;
	private Integer applicationId;
	private Integer updatedBy;
	private Date updatedTs;
	private Integer createdBy;
	private Date createdTs;
	private String comments;

	public AppStatusAuditEntity() {
	}

	public AppStatusAuditEntity(int appStatusTblId) {
		this.appStatusTblId = appStatusTblId;
	}

	public AppStatusAuditEntity(String operation, Date processDate, int appStatusTblId, Integer updatedSection,
			Integer applicationId, Integer updatedBy, Date updatedTs, Integer createdBy, Date createdTs,
			String comments) {
		this.operation = operation;
		this.processDate = processDate;
		this.appStatusTblId = appStatusTblId;
		this.updatedSection = updatedSection;
		this.applicationId = applicationId;
		this.updatedBy = updatedBy;
		this.updatedTs = updatedTs;
		this.createdBy = createdBy;
		this.createdTs = createdTs;
		this.comments = comments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "app_status_tbl_audit_id", unique = true, nullable = false)
	public Integer getAppStatusTblAuditId() {
		return this.appStatusTblAuditId;
	}

	public void setAppStatusTblAuditId(Integer appStatusTblAuditId) {
		this.appStatusTblAuditId = appStatusTblAuditId;
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

	@Column(name = "app_status_tbl_id", nullable = false)
	public int getAppStatusTblId() {
		return this.appStatusTblId;
	}

	public void setAppStatusTblId(int appStatusTblId) {
		this.appStatusTblId = appStatusTblId;
	}

	@Column(name = "updated_section")
	public Integer getUpdatedSection() {
		return this.updatedSection;
	}

	public void setUpdatedSection(Integer updatedSection) {
		this.updatedSection = updatedSection;
	}

	@Column(name = "application_id")
	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_ts", length = 19)
	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_ts", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "comments")
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}