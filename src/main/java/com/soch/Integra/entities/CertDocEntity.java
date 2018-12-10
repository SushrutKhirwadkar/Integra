package com.soch.Integra.entities;
// Generated Apr 23, 2018 2:33:22 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
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

/**
 * CertDocTbl generated by hbm2java
 */
@Entity
@Table(name = "cert_doc_tbl")
public class CertDocEntity implements java.io.Serializable {

	private Integer certDocId;
	private SolutionsEntity solutionsEntity;
	private String fileName;
	private String fileLocation;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private boolean activeFlag;
	private String section;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CERT_DOC_ID", unique = true, nullable = false)
	public Integer getCertDocId() {
		return this.certDocId;
	}

	public void setCertDocId(Integer certDocId) {
		this.certDocId = certDocId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOLUTION_ID")
	public SolutionsEntity getSolutionsEntity() {
		return solutionsEntity;
	}

	public void setSolutionsEntity(SolutionsEntity solutionsEntity) {
		this.solutionsEntity = solutionsEntity;
	}

	
	@Column(name = "FILE_NAME", length = 500)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_LOCATION", length = 500)
	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Column(name = "CREATED_BY", length = 500)
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

	@Column(name = "UPDATED_BY", length = 500)
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

	@Column(name = "ACTIVE_FLAG", length = 1)
	public boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	@Column(name = "SECTION")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
}
