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
 * DatabaseTblAudit generated by hbm2java
 */
@Entity
@Table(name = "database_tbl_audit")
public class DatabaseAuditEntity implements java.io.Serializable {
	
	private int databaseAuditId;
	private String operation;
	private Date processDate;
	private int databaseId;
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
	private Integer managedBy;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "database_audit_id", unique = true, nullable = false)
	public int getDatabaseAuditId() {
		return databaseAuditId;
	}

	public void setDatabaseAuditId(int databaseAuditId) {
		this.databaseAuditId = databaseAuditId;
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

	@Column(name = "DATABASE_ID", nullable = false)
	public int getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}

	@Column(name = "HOST_NAME", length = 100)
	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Column(name = "PLATFORM", length = 100)
	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Column(name = "DB_VERSION", length = 45)
	public String getDbVersion() {
		return this.dbVersion;
	}

	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}

	@Column(name = "HARDWARE")
	public String getHardware() {
		return this.hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	@Column(name = "UPDATE_LEVEL")
	public String getUpdateLevel() {
		return this.updateLevel;
	}

	public void setUpdateLevel(String updateLevel) {
		this.updateLevel = updateLevel;
	}

	@Column(name = "ADDRESS_LENGTH")
	public String getAddressLength() {
		return this.addressLength;
	}

	public void setAddressLength(String addressLength) {
		this.addressLength = addressLength;
	}

	@Column(name = "CLOCK_FREQUENCY")
	public String getClockFrequency() {
		return this.clockFrequency;
	}

	public void setClockFrequency(String clockFrequency) {
		this.clockFrequency = clockFrequency;
	}

	@Column(name = "MEMORY_SIZE")
	public String getMemorySize() {
		return this.memorySize;
	}

	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}

	@Column(name = "LOCAL_DISK_SPACE")
	public String getLocalDiskSpace() {
		return this.localDiskSpace;
	}

	public void setLocalDiskSpace(String localDiskSpace) {
		this.localDiskSpace = localDiskSpace;
	}

	@Column(name = "CPU_COUNT")
	public Integer getCpuCount() {
		return this.cpuCount;
	}

	public void setCpuCount(Integer cpuCount) {
		this.cpuCount = cpuCount;
	}

	@Column(name = "PHYSICAL_CPU_COUNT")
	public Integer getPhysicalCpuCount() {
		return this.physicalCpuCount;
	}

	public void setPhysicalCpuCount(Integer physicalCpuCount) {
		this.physicalCpuCount = physicalCpuCount;
	}

	@Column(name = "LOGICAL_CPU_COUNT")
	public Integer getLogicalCpuCount() {
		return this.logicalCpuCount;
	}

	public void setLogicalCpuCount(Integer logicalCpuCount) {
		this.logicalCpuCount = logicalCpuCount;
	}

	@Column(name = "IP_ADDRESS", length = 45)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "DB_SERVER", length = 100)
	public String getDbServer() {
		return this.dbServer;
	}

	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}

	@Column(name = "SERVER_NAME", length = 100)
	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Column(name = "ARCHIVE_LOG_MODE", length = 100)
	public String getArchiveLogMode() {
		return this.archiveLogMode;
	}

	public void setArchiveLogMode(String archiveLogMode) {
		this.archiveLogMode = archiveLogMode;
	}

	@Column(name = "SIZE_GB", length = 10)
	public String getSizeGb() {
		return this.sizeGb;
	}

	public void setSizeGb(String sizeGb) {
		this.sizeGb = sizeGb;
	}

	@Column(name = "PURPOSE")
	public byte[] getPurpose() {
		return this.purpose;
	}

	public void setPurpose(byte[] purpose) {
		this.purpose = purpose;
	}

	@Column(name = "MANAGED_BY")
	public Integer getManagedBy() {
		return this.managedBy;
	}

	public void setManagedBy(Integer managedBy) {
		this.managedBy = managedBy;
	}


}
