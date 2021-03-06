package com.soch.Integra.entities;
// Generated Apr 30, 2018 9:16:23 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LabVendorTbl generated by hbm2java
 */
@Entity
@Table(name = "lab_vendor_tbl")
public class LabVendorEntity implements java.io.Serializable {

	private int labVendorId;
	private String name;
	private String firstName;
	private String lastName;
	private String middleName;
	private String suffix;
	private String emailId;
	private String streetName;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;
	private Set<SolutionsEntity> solutionsEntities = new HashSet<SolutionsEntity>(0);

	public LabVendorEntity() {
	}


	@Id

	@Column(name = "LAB_VENDOR_ID", unique = true, nullable = false)
	public int getLabVendorId() {
		return this.labVendorId;
	}

	public void setLabVendorId(int labVendorId) {
		this.labVendorId = labVendorId;
	}

	@Column(name = "NAME", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "FIRST_NAME", length = 200)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 200)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "MIDDLE_NAME", length = 200)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "SUFFIX", length = 5)
	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name = "EMAIL_ID", length = 200)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "STREET_NAME", length = 1000)
	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	@Column(name = "ZIPCODE", length = 45)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "labVendorEntity")
	public Set<SolutionsEntity> getSolutionsEntities() {
		return solutionsEntities;
	}


	public void setSolutionsEntities(Set<SolutionsEntity> solutionsEntities) {
		this.solutionsEntities = solutionsEntities;
	}

	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
