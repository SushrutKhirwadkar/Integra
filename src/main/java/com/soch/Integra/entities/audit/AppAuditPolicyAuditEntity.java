package com.soch.Integra.entities.audit;
// Generated Oct 20, 2017 10:15:53 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AppAuditPolicyTblAudit generated by hbm2java
 */
@Entity
@Table(name = "app_audit_policy_tbl_audit")
public class AppAuditPolicyAuditEntity implements java.io.Serializable {

	private int appAuditPolicyTblAuditId;
	private String operation;
	private Date processDate;
	private int appAuditPolicyId;
	private Integer auditId;
	private Integer policyId;
	private String defaultVal;
	private String status;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;

	public AppAuditPolicyAuditEntity() {
	}

	public AppAuditPolicyAuditEntity(int appAuditPolicyTblAuditId, int appAuditPolicyId) {
		this.appAuditPolicyTblAuditId = appAuditPolicyTblAuditId;
		this.appAuditPolicyId = appAuditPolicyId;
	}

	public AppAuditPolicyAuditEntity(int appAuditPolicyTblAuditId, String operation, Date processDate,
			int appAuditPolicyId, Integer auditId, Integer policyId, String defaultVal, String status, String createdBy,
			Date createdTs, String updatedBy, Date updatedTs) {
		this.appAuditPolicyTblAuditId = appAuditPolicyTblAuditId;
		this.operation = operation;
		this.processDate = processDate;
		this.appAuditPolicyId = appAuditPolicyId;
		this.auditId = auditId;
		this.policyId = policyId;
		this.defaultVal = defaultVal;
		this.status = status;
		this.createdBy = createdBy;
		this.createdTs = createdTs;
		this.updatedBy = updatedBy;
		this.updatedTs = updatedTs;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "app_audit_policy_tbl_audit_id", unique = true, nullable = false)
	public int getAppAuditPolicyTblAuditId() {
		return this.appAuditPolicyTblAuditId;
	}

	public void setAppAuditPolicyTblAuditId(int appAuditPolicyTblAuditId) {
		this.appAuditPolicyTblAuditId = appAuditPolicyTblAuditId;
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

	@Column(name = "app_audit_policy_id", nullable = false)
	public int getAppAuditPolicyId() {
		return this.appAuditPolicyId;
	}

	public void setAppAuditPolicyId(int appAuditPolicyId) {
		this.appAuditPolicyId = appAuditPolicyId;
	}

	@Column(name = "AUDIT_ID")
	public Integer getAuditId() {
		return this.auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	@Column(name = "POLICY_ID")
	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	@Column(name = "default_val", length = 100)
	public String getDefaultVal() {
		return this.defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "created_by", length = 200)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
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

	@Column(name = "updated_by", length = 200)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
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

}
