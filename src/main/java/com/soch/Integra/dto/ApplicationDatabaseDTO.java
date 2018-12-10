package com.soch.Integra.dto;

import java.util.Date;

public class ApplicationDatabaseDTO {
	
	private int applicationDatabaseId;
	private String databaseName;
	private String  administratorName;
	private String custodian;
	private String technologies;
	private Date createdTs;
	private int databaseId;
//	private UserTbl userTbl;
	private String hostName;
	private String platform;
	private String dbVersion;
	private String hardware;
	private String updateLevel;
	private String addressLength;
	private String clockFrequency;
	private String memorySize;
	private String localDiskSpace;
	private Integer cpuCount;
	private Integer physicalCpuCount;
	private Integer logicalCpuCount;
	private String ipAddress;
	private String dbServer;
	private String serverName;
	private String archiveLogMode;
	private String sizeGb;
	private byte[] purpose;
	private boolean newEntry;
	private boolean active;
	private String osVersion;
	private String createdBy;
	private String updatedBy;
	private Date updatedTs;
	private String systemTag;
	
	
	
	
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public int getApplicationDatabaseId() {
		return applicationDatabaseId;
	}
	public void setApplicationDatabaseId(int applicationDatabaseId) {
		this.applicationDatabaseId = applicationDatabaseId;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public String getCustodian() {
		return custodian;
	}
	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public int getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getDbVersion() {
		return dbVersion;
	}
	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}
	public String getHardware() {
		return hardware;
	}
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}
	public String getUpdateLevel() {
		return updateLevel;
	}
	public void setUpdateLevel(String updateLevel) {
		this.updateLevel = updateLevel;
	}
	public String getAddressLength() {
		return addressLength;
	}
	public void setAddressLength(String addressLength) {
		this.addressLength = addressLength;
	}
	public String getClockFrequency() {
		return clockFrequency;
	}
	public void setClockFrequency(String clockFrequency) {
		this.clockFrequency = clockFrequency;
	}
	public String getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	public String getLocalDiskSpace() {
		return localDiskSpace;
	}
	public void setLocalDiskSpace(String localDiskSpace) {
		this.localDiskSpace = localDiskSpace;
	}
	public Integer getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(Integer cpuCount) {
		this.cpuCount = cpuCount;
	}
	public Integer getPhysicalCpuCount() {
		return physicalCpuCount;
	}
	public void setPhysicalCpuCount(Integer physicalCpuCount) {
		this.physicalCpuCount = physicalCpuCount;
	}
	public Integer getLogicalCpuCount() {
		return logicalCpuCount;
	}
	public void setLogicalCpuCount(Integer logicalCpuCount) {
		this.logicalCpuCount = logicalCpuCount;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getDbServer() {
		return dbServer;
	}
	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getArchiveLogMode() {
		return archiveLogMode;
	}
	public void setArchiveLogMode(String archiveLogMode) {
		this.archiveLogMode = archiveLogMode;
	}
	public String getSizeGb() {
		return sizeGb;
	}
	public void setSizeGb(String sizeGb) {
		this.sizeGb = sizeGb;
	}
	public byte[] getPurpose() {
		return purpose;
	}
	public void setPurpose(byte[] purpose) {
		this.purpose = purpose;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isNewEntry() {
		return newEntry;
	}
	public void setNewEntry(boolean newEntry) {
		this.newEntry = newEntry;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public String getSystemTag() {
		return systemTag;
	}
	public void setSystemTag(String systemTag) {
		this.systemTag = systemTag;
	}
}
