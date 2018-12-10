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
 * PolicySrcTblAudit generated by hbm2java
 */
@Entity
@Table(name = "policy_src_tbl_audit")
public class PolicySrcAuditEntity implements java.io.Serializable {
	
	private int policySrcAuditId;
	private String operation;
	private Date processDate;
	private int policyId;
	private Integer policyConfigId;
	private String policyName;
	private int policyGrpId;
	private String policyDesc;
	private String vitaVal;
	private String cmsVal;
	private String customVal;
	private String createdBy;
	private Date createdTs;
	private String modifiedBy;
	private Date modifiedTs;
	private String notes;
	private byte[] fileContent;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "policy_src_audit_id", unique = true, nullable = false)
	public int getPolicySrcAuditId() {
		return policySrcAuditId;
	}

	public void setPolicySrcAuditId(int policySrcAuditId) {
		this.policySrcAuditId = policySrcAuditId;
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

	@Column(name = "POLICY_ID", nullable = false)
	public int getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	@Column(name = "POLICY_CONFIG_ID")
	public Integer getPolicyConfigId() {
		return this.policyConfigId;
	}

	public void setPolicyConfigId(Integer policyConfigId) {
		this.policyConfigId = policyConfigId;
	}

	@Column(name = "POLICY_NAME", length = 200)
	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	@Column(name = "POLICY_GRP_ID", nullable = false)
	public int getPolicyGrpId() {
		return this.policyGrpId;
	}

	public void setPolicyGrpId(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}

	@Column(name = "POLICY_DESC", length = 500)
	public String getPolicyDesc() {
		return this.policyDesc;
	}

	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}

	@Column(name = "VITA_VAL", length = 45)
	public String getVitaVal() {
		return this.vitaVal;
	}

	public void setVitaVal(String vitaVal) {
		this.vitaVal = vitaVal;
	}

	@Column(name = "CMS_VAL", length = 45)
	public String getCmsVal() {
		return this.cmsVal;
	}

	public void setCmsVal(String cmsVal) {
		this.cmsVal = cmsVal;
	}

	@Column(name = "CUSTOM_VAL", length = 45)
	public String getCustomVal() {
		return this.customVal;
	}

	public void setCustomVal(String customVal) {
		this.customVal = customVal;
	}

	@Column(name = "CREATED_BY", length = 45)
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

	@Column(name = "MODIFIED_BY", length = 45)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "MODIFIED_TS", length = 19)
	public Date getModifiedTs() {
		return this.modifiedTs;
	}

	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	@Column(name = "NOTES", length = 500)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "fileContent")
	public byte[] getFileContent() {
		return this.fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	

}
