package com.soch.Integra.vendors.dto;

import java.util.Date;
import java.util.List;


public class ApplicationSolutionDTO {
	
	private Integer appSolutionId;
	private boolean activeFlag;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private List<AppSolutionDevicesDTO> appSolutionDevices;
	private int applicationID;
	private int solutionId;
	private String notes;
	private HostingTypeDTO hostingType;
	private SolutionsDTO solutionsDTO;
	private int hostingTypeId;
	private String applicationName;
	private int noOfUnits;
	private String systemType;
	private String precinctType;
	private String solutionName;
	private String vendorName;
	private String versionNumber;
	
	
	
	
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getPrecinctType() {
		return precinctType;
	}
	public void setPrecinctType(String precinctType) {
		this.precinctType = precinctType;
	}
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public Integer getAppSolutionId() {
		return appSolutionId;
	}
	public void setAppSolutionId(Integer appSolutionId) {
		this.appSolutionId = appSolutionId;
	}
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
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
	public List<AppSolutionDevicesDTO> getAppSolutionDevices() {
		return appSolutionDevices;
	}
	public void setAppSolutionDevices(List<AppSolutionDevicesDTO> appSolutionDevices) {
		this.appSolutionDevices = appSolutionDevices;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public int getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	public SolutionsDTO getSolutionsDTO() {
		return solutionsDTO;
	}
	public void setSolutionsDTO(SolutionsDTO solutionsDTO) {
		this.solutionsDTO = solutionsDTO;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public HostingTypeDTO getHostingType() {
		return hostingType;
	}
	public void setHostingType(HostingTypeDTO hostingType) {
		this.hostingType = hostingType;
	}
	public int getHostingTypeId() {
		return hostingTypeId;
	}
	public void setHostingTypeId(int hostingTypeId) {
		this.hostingTypeId = hostingTypeId;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
}
