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
 * SubsidaryTblAudit generated by hbm2java
 */
@Entity
@Table(name = "subsidary_tbl_audit")
public class SubsidaryAuditEntity implements java.io.Serializable {

	private int subsidaryAuditId;
	private String operation;
	private Date processDate;
	private int subsidaryId;
	private String name;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private int corporationTblCorporationId;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "subsidary_audit_id", unique = true, nullable = false)
	public int getSubsidaryAuditId() {
		return subsidaryAuditId;
	}

	public void setSubsidaryAuditId(int subsidaryAuditId) {
		this.subsidaryAuditId = subsidaryAuditId;
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

	@Column(name = "SUBSIDARY_ID", nullable = false)
	public int getSubsidaryId() {
		return this.subsidaryId;
	}

	public void setSubsidaryId(int subsidaryId) {
		this.subsidaryId = subsidaryId;
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

	@Column(name = "CORPORATION_TBL_CORPORATION_ID", nullable = false)
	public int getCorporationTblCorporationId() {
		return this.corporationTblCorporationId;
	}

	public void setCorporationTblCorporationId(int corporationTblCorporationId) {
		this.corporationTblCorporationId = corporationTblCorporationId;
	}

}