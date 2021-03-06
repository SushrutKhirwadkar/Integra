package com.soch.Integra.entities;
// Generated Sep 30, 2016 10:01:12 PM by Hibernate Tools 4.3.4.Final

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PolicyConfigTb generated by hbm2java
 */
@Entity
@Table(name = "policy_config_tbl")
public class PolicyConfigEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3982154297541085882L;
	
	private String policyName;
	
	private int policyConfigId;
	
	private String federal;
	private String state;
	
	 private Set<PolicySrcEntity> PolicyConfigEntity;
	/*
	private String value;
	private String createdBy;
	private Date createdTs;
	private String modifiedBy;
	private Date modifiedTs;
	private String notes;
	private UserTypeEntity userTypeEntity;
	 private PolicySrcEntity policySrcEntity;*/
	@Column(name = "POLICY_NAME")
	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	
	@Id
	@Column(name = "POLICY_CONFIG_ID", unique = true, nullable = false)
	public int getPolicyConfigId() {
		return this.policyConfigId;
	}

	public void setPolicyConfigId(int policyConfigId) {
		this.policyConfigId = policyConfigId;
	}
	
	@Column(name = "FEDERAL", length = 45)
	public String getFederal() {
		return this.federal;
	}

	public void setFederal(String federal) {
		this.federal = federal;
	}

	@Column(name = "STATE", length = 45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="policyConfigEntity")
	public Set<PolicySrcEntity> getPolicyConfigEntity() {
		return PolicyConfigEntity;
	}

	public void setPolicyConfigEntity(Set<PolicySrcEntity> policyConfigEntity) {
		PolicyConfigEntity = policyConfigEntity;
	}
	
	
	
	/*public PolicyConfigEntity() {
	}

	public PolicyConfigEntity(String policyName) {
		this.policyName = policyName;
	}
	
	
	
	
	@Column(name = "VALUE", length = 100)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	@Column(name = "CREATED_BY", length = 45)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
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

	@Column(name = "MODIFIED_BY", length = 45)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_TS", length = 19)
	public Date getModifiedTs() {
		return this.modifiedTs;
	}

	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}
	
	@Column(name = "NOTES", length = 500)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_TYPE_ID")
	public UserTypeEntity getUserTypeEntity() {
		return userTypeEntity;
	}

	public void setUserTypeEntity(UserTypeEntity userTypeEntity) {
		this.userTypeEntity = userTypeEntity;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="POLICY_SRC_ID", nullable = false)
	public PolicySrcEntity getPolicySrcEntity() {
		return policySrcEntity;
	}

	public void setPolicySrcEntity(PolicySrcEntity policySrcEntity) {
		this.policySrcEntity = policySrcEntity;
	}
	
	*/
	
	
}
