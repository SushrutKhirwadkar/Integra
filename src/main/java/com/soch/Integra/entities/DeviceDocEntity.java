package com.soch.Integra.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "solDevice_file_tbl")
public class DeviceDocEntity implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deviceDocId;
	private AppSolutionDeviceEntity appSolutionDeviceEntity;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private String location;
	private String fileName;
	private boolean status;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "solDevice_file_id", unique = true, nullable =  false)
	public int getDeviceDocId() {
		return deviceDocId;
	}
	public void setDeviceDocId(int deviceDocId) {
		this.deviceDocId = deviceDocId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "solDevice_ID")
	public AppSolutionDeviceEntity getAppSolutionDeviceEntity() {
		return appSolutionDeviceEntity;
	}
	public void setAppSolutionDeviceEntity(AppSolutionDeviceEntity appSolutionDeviceEntity) {
		this.appSolutionDeviceEntity = appSolutionDeviceEntity;
	}
	@Column(name = "CREATED_BY", length = 100)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	@Column(name = "UPDATED_BY", length = 100)
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TS", length = 19)
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	@Column(name ="file_location", length = 500)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "file_name", length = 500)
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Column(name ="STATUS", length = 500)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
