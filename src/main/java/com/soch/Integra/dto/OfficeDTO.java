package com.soch.Integra.dto;

import java.util.HashSet;
import java.util.Set;
//
//import apm.ApplicationTbl;
//import apm.DivisionTbl;
//import apm.OfficeTblId;
//import apm.SubsidaryTbl;
//import apm.UserTbl;

public class OfficeDTO {
	
	private int id;
	private String acronym;
	private String description;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private int divisionId;
	
	
	
	public int getId() {
		return id;
	}
	public String getAcronym() {
		return acronym;
	}
	public String getDescription() {
		return description;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	
	
	
}
