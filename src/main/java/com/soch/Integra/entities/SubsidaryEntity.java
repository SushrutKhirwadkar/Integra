package com.soch.Integra.entities;
// Generated Apr 25, 2017 12:37:56 PM by Hibernate Tools 4.3.4.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SubsidaryTbl generated by hbm2java
 */
@Entity
@Table(name = "subsidary_tbl")
public class SubsidaryEntity implements java.io.Serializable {

	private int subsidaryId;
	private CorporationEntity corporationEntity;
	private String name;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private Set<OfficeEntity> officeEntities = new HashSet<OfficeEntity>(0);


	@Id
	@Column(name = "SUBSIDARY_ID")
	public int getSubsidaryId() {
		return subsidaryId;
	}

	public void setSubsidaryId(int subsidaryId) {
		this.subsidaryId = subsidaryId;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CORPORATION_TBL_CORPORATION_ID", nullable = false, insertable = false, updatable = false)
	public CorporationEntity getCorporationEntity() {
		return this.corporationEntity;
	}

	public void setCorporationEntity(CorporationEntity corporationEntity) {
		this.corporationEntity = corporationEntity;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PHONE_NUMBER", length = 20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "ADDRESS_LINE1", length = 100)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "ADDRESS_LINE2", length = 100)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "CITY", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE", length = 100)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ZIP_CODE", length = 20)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subsidaryEntity")
	public Set<OfficeEntity> getOfficeEntities() {
		return officeEntities;
	}

	public void setOfficeEntities(Set<OfficeEntity> officeEntities) {
		this.officeEntities = officeEntities;
	}

	
}
