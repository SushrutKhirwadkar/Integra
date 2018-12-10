package com.soch.Integra.history.dto;
// default package
// Generated Sep 7, 2017 10:39:33 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class AppAuditFileHistoryDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8477051165936183846L;
	private Integer appAuditFileId;
	private String fileName;
	private String fileContent;
	private boolean status;
	private String createdBy;
	private Date createdTs;
	
	public Integer getAppAuditFileId() {
		return appAuditFileId;
	}
	public void setAppAuditFileId(Integer appAuditFileId) {
		this.appAuditFileId = appAuditFileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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


}
