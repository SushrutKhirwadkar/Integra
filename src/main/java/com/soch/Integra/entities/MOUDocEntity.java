package com.soch.Integra.entities;
// Generated Apr 10, 2018 1:23:39 PM by Hibernate Tools 4.3.5.Final

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

/**
 * MouDocTbl generated by hbm2java
 */
@Entity
@Table(name = "mou_doc_tbl")
public class MOUDocEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mouDocId;
	private MOUEntity mouEntity;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private String location;
	private String fileName;
	private boolean status;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MOU_DOC_ID", unique = true, nullable = false)
	public int getMouDocId() {
		return this.mouDocId;
	}

	public void setMouDocId(int mouDocId) {
		this.mouDocId = mouDocId;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "MOU_ID")
	public MOUEntity getMouEntity() {
		return mouEntity;
	}

	public void setMouEntity(MOUEntity mouEntity) {
		this.mouEntity = mouEntity;
	}
	

	@Column(name = "CREATED_BY", length = 100)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "UPDATED_BY", length = 100)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TS", length = 19)
	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	@Column(name = "LOCATION", length = 500)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "FILE_NAME", length = 500)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "status", length = 500)
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}