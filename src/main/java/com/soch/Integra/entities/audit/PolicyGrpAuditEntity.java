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
 * PolicyGrpTblAudit generated by hbm2java
 */
@Entity
@Table(name = "policy_grp_tbl_audit")
public class PolicyGrpAuditEntity implements java.io.Serializable {
	
	private int policyGrpAuditId;
	private String operation;
	private Date processDate;
	private int policyGrpId;
	private String policyGrpName;
	private Integer policyTypeId;
	private String description;
	private String createdBy;
	private Date createdTs;
	private Integer auditTypeId;
	private Date reviewDate;
	private String status;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "policy_grp_audit_id", unique = true, nullable = false)
	public int getPolicyGrpAuditId() {
		return policyGrpAuditId;
	}

	public void setPolicyGrpAuditId(int policyGrpAuditId) {
		this.policyGrpAuditId = policyGrpAuditId;
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

	@Column(name = "POLICY_GRP_ID", nullable = false)
	public int getPolicyGrpId() {
		return this.policyGrpId;
	}

	public void setPolicyGrpId(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}

	@Column(name = "POLICY_GRP_NAME", length = 100)
	public String getPolicyGrpName() {
		return this.policyGrpName;
	}

	public void setPolicyGrpName(String policyGrpName) {
		this.policyGrpName = policyGrpName;
	}

	@Column(name = "POLICY_TYPE_ID")
	public Integer getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(Integer policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	@Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CREATED_BY", length = 100)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "AUDIT_TYPE_ID")
	public Integer getAuditTypeId() {
		return this.auditTypeId;
	}

	public void setAuditTypeId(Integer auditTypeId) {
		this.auditTypeId = auditTypeId;
	}

	@Column(name = "REVIEW_DATE", length = 19)
	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Column(name = "STATUS", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
