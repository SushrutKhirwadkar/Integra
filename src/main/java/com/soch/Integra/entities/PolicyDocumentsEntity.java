package com.soch.Integra.entities;
// default package
// Generated Nov 2, 2017 2:25:30 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PolicyDocumentsTbl generated by hbm2java
 */
@Entity
@Table(name = "policy_documents_tbl")
public class PolicyDocumentsEntity implements java.io.Serializable {

	private Integer policyDocId;
	private PolicyGrpEntity policyGrpEntity;
	private String documentName;
	private String documentPath;
	private boolean activeFlag;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private PolicyEntity policyEntity;

	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "policyDocId", unique = true, nullable = false)
	public Integer getPolicyDocId() {
		return this.policyDocId;
	}

	public void setPolicyDocId(Integer policyDocId) {
		this.policyDocId = policyDocId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_grp_id")
	public PolicyGrpEntity getPolicyGrpEntity() {
		return policyGrpEntity;
	}

	public void setPolicyGrpEntity(PolicyGrpEntity policyGrpEntity) {
		this.policyGrpEntity = policyGrpEntity;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
	public PolicyEntity getPolicyEntity() {
		return policyEntity;
	}

	public void setPolicyEntity(PolicyEntity policyEntity) {
		this.policyEntity = policyEntity;
	}

	@Column(name = "document_name", length = 100)
	public String getDocumentName() {
		return this.documentName;
	}

	

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column(name = "document_path", length = 300)
	public String getDocumentPath() {
		return this.documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	@Column(name = "active_flag", length = 1)
	public boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", length = 500)
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

	@Column(name = "updated_by", length = 500)
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
