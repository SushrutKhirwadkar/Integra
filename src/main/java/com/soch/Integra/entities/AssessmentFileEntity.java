package com.soch.Integra.entities;
// default package
// Generated Feb 22, 2018 3:06:29 PM by Hibernate Tools 4.3.5.Final

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
 * AssessmentFileTbl generated by hbm2java
 */
@Entity
@Table(name = "assessment_file_tbl")
public class AssessmentFileEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -763780294873052681L;
	private Integer assessmentFileId;
	private AssessmentEntity assessmentEntity;
	private String fileName;
	private String fileLocation;
	private boolean status;
	private String createdBy;
	private Date createdTs;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "assessment_file_id", unique = true, nullable = false)
	public Integer getAssessmentFileId() {
		return this.assessmentFileId;
	}

	public void setAssessmentFileId(Integer assessmentFileId) {
		this.assessmentFileId = assessmentFileId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSESSMENT_ID")
	public AssessmentEntity getAssessmentEntity() {
		return assessmentEntity;
	}

	public void setAssessmentEntity(AssessmentEntity assessmentEntity) {
		this.assessmentEntity = assessmentEntity;
	}


	@Column(name = "file_name", length = 500)
	public String getFileName() {
		return this.fileName;
	}

	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_location", length = 500)
	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Column(name = "STATUS", length = 1)
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "CREATED_BY", length = 200)
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

}
