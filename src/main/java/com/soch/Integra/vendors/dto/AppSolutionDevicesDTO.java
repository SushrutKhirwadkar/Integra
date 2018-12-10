package com.soch.Integra.vendors.dto;

import java.util.Date;
import java.util.List;

import com.soch.Integra.dto.DeviceDocDTO;

public class AppSolutionDevicesDTO {
	
	private Integer appSolutionDevice;
	private String modelNumber;
	private String serialNumber;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private boolean activeFlag;
	private Integer appSolutionId;
	//private int applicationID;
	private String firstName;
	private String lastName;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zipCode;
	private String scanningStatus;
	private Date nextScanningDt;
	private Date currentScanningDt;
	private String overallStatus;
	private String notes;
	private List<DeviceDocDTO> deviceDocDTO;
	private String solutionName;
	private String AppName;

	
	
	public Integer getAppSolutionDevice() {
		return appSolutionDevice;
	}
	public void setAppSolutionDevice(Integer appSolutionDevice) {
		this.appSolutionDevice = appSolutionDevice;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getScanningStatus() {
		return scanningStatus;
	}
	public void setScanningStatus(String scanningStatus) {
		this.scanningStatus = scanningStatus;
	}
	public Date getNextScanningDt() {
		return nextScanningDt;
	}
	public void setNextScanningDt(Date nextScanningDt) {
		this.nextScanningDt = nextScanningDt;
	}
	public String getOverallStatus() {
		return overallStatus;
	}
	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Integer getAppSolutionId() {
		return appSolutionId;
	}

	public void setAppSolutionId(Integer appSolutionId) {
		this.appSolutionId = appSolutionId;
	}
	public List<DeviceDocDTO> getDeviceDocDTO() {
		return deviceDocDTO;
	}
	public void setDeviceDocDTO(List<DeviceDocDTO> deviceDocDTO) {
		this.deviceDocDTO = deviceDocDTO;
	}
//	public int getApplicationID() {
//		return applicationID;
//	}
//	public void setApplicationID(int applicationID) {
//		this.applicationID = applicationID;
//	}
	public Date getCurrentScanningDt() {
		return currentScanningDt;
	}
	public void setCurrentScanningDt(Date currentScanningDt) {
		this.currentScanningDt = currentScanningDt;
	}
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getAppName() {
		return AppName;
	}
	public void setAppName(String appName) {
		AppName = appName;
	}
	
	
}
