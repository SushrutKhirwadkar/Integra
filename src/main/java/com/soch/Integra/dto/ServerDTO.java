package com.soch.Integra.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.soch.Integra.entities.ApplicationServerEntity;

public class ServerDTO {
	

	private int serverId;
	private String name;
	private String assetTag;
	private String systemType;
	private String equipmentType;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipCode;
	private Date licenseStartDt;
	private Date licenseEndDt;
	private Date licenseRenewDt;
	private String vendorName;
	private String productName;
	//private Set<ApplicationServerEntity> applicationServerEntities = new HashSet<ApplicationServerEntity>(0);
	private Set<ServerContactDTO> serverContactDTOs;
	
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssetTag() {
		return assetTag;
	}
	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Date getLicenseStartDt() {
		return licenseStartDt;
	}
	public void setLicenseStartDt(Date licenseStartDt) {
		this.licenseStartDt = licenseStartDt;
	}
	public Date getLicenseEndDt() {
		return licenseEndDt;
	}
	public void setLicenseEndDt(Date licenseEndDt) {
		this.licenseEndDt = licenseEndDt;
	}
	public Date getLicenseRenewDt() {
		return licenseRenewDt;
	}
	public void setLicenseRenewDt(Date licenseRenewDt) {
		this.licenseRenewDt = licenseRenewDt;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Set<ServerContactDTO> getServerContactDTOs() {
		return serverContactDTOs;
	}
	public void setServerContactDTOs(Set<ServerContactDTO> serverContactDTOs) {
		this.serverContactDTOs = serverContactDTOs;
	}
	

}
