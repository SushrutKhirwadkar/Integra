package com.soch.Integra.dto;

//import apm.ApplicationTbl;
//import apm.ServerTbl;

public class ApplicationServerDTO {
	private int applicationServerId;
	private String name;
	private String assetTag;
	private String systemType;
	private String equipmentType;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipCode;
	private boolean newEntry;
	private boolean active;
	private int serverId;
	
	
	
	public int getApplicationServerId() {
		return applicationServerId;
	}
	public String getName() {
		return name;
	}
	public String getAssetTag() {
		return assetTag;
	}
	public String getSystemType() {
		return systemType;
	}
	public String getEquipmentType() {
		return equipmentType;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setApplicationServerId(int applicationServerId) {
		this.applicationServerId = applicationServerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
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
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isNewEntry() {
		return newEntry;
	}
	public void setNewEntry(boolean newEntry) {
		this.newEntry = newEntry;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	
	
}	
