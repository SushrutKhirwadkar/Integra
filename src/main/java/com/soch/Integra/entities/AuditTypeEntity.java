package com.soch.Integra.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "audit_type_tbl")
public class AuditTypeEntity {
	
	private int auditTypeId;
	private String auditTypeName;
	private String createdBy;
	private Date createdTs;
	private boolean active;
	// List<AppAuditEntity> appAuditEntities;
	private List<PolicyGrpEntity> policyGrpEntities;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "AUDIT_TYPE_ID", unique = true, nullable = false)
	public int getAuditTypeId() {
		return auditTypeId;
	}
	public void setAuditTypeId(int auditTypeId) {
		this.auditTypeId = auditTypeId;
	}
	
	@Column(name = "AUDIT_NAME")
	public String getAuditTypeName() {
		return auditTypeName;
	}
	public void setAuditTypeName(String auditTypeName) {
		this.auditTypeName = auditTypeName;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "CREATED_TS")
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	@Column(name = "ACTIVE")
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="auditTypeEntity")
	public List<AppAuditEntity> getAppAuditEntities() {
		return appAuditEntities;
	}
	public void setAppAuditEntities(List<AppAuditEntity> appAuditEntities) {
		this.appAuditEntities = appAuditEntities;
	}*/
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="auditTypeEntity")
	public List<PolicyGrpEntity> getPolicyGrpEntities() {
		return policyGrpEntities;
	}
	public void setPolicyGrpEntities(List<PolicyGrpEntity> policyGrpEntities) {
		this.policyGrpEntities = policyGrpEntities;
	}
	
	
	
	
	
	
}
