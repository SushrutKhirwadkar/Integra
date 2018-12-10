package com.soch.Integra.entities;
// Generated Apr 25, 2017 12:37:56 PM by Hibernate Tools 4.3.4.Final

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
 * ApplDocTbl generated by hbm2java
 */
@Entity
@Table(name = "appl_doc_tbl")
public class ApplDocEntity implements java.io.Serializable {

	private int documentId;
	private ApplicationEntity applicationEntity;
	private UserEntity userEntity;
	private String workflowDiagramFilename;
	private byte[] workflowDiagramContent;
	private String systemDiagramFilename;
	private byte[] systemDiagramContent;
	private String riskAssessmentFilename;
	private byte[] riskAssessmentContent;
	private String businessImpactFilename;
	private byte[] businessImpactContent;
	private String auditFindingsFilename;
	private byte[] auditFindingsContent;
	private Date createdTs;
	
	private UserEntity updatedBy;
	private Date updatedTs;
	
	private String fileName;
	private byte[] fileContent;
	private String fileType;
	
	private String fileLocation;
	private String attachmentName;
	private String sectionName;
	private boolean activeFlag;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "DOCUMENT_ID", unique = true, nullable = false)
	public int getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "APPLICATION_ID")
	public ApplicationEntity getApplicationEntity() {
		return this.applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "CREATED_BY")
	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Column(name = "WORKFLOW_DIAGRAM_FILENAME", length = 100)
	public String getWorkflowDiagramFilename() {
		return this.workflowDiagramFilename;
	}

	public void setWorkflowDiagramFilename(String workflowDiagramFilename) {
		this.workflowDiagramFilename = workflowDiagramFilename;
	}

	@Column(name = "WORKFLOW_DIAGRAM_CONTENT")
	public byte[] getWorkflowDiagramContent() {
		return this.workflowDiagramContent;
	}

	public void setWorkflowDiagramContent(byte[] workflowDiagramContent) {
		this.workflowDiagramContent = workflowDiagramContent;
	}

	@Column(name = "SYSTEM_DIAGRAM_FILENAME", length = 100)
	public String getSystemDiagramFilename() {
		return this.systemDiagramFilename;
	}

	public void setSystemDiagramFilename(String systemDiagramFilename) {
		this.systemDiagramFilename = systemDiagramFilename;
	}

	@Column(name = "SYSTEM_DIAGRAM_CONTENT")
	public byte[] getSystemDiagramContent() {
		return this.systemDiagramContent;
	}

	public void setSystemDiagramContent(byte[] systemDiagramContent) {
		this.systemDiagramContent = systemDiagramContent;
	}

	@Column(name = "RISK_ASSESSMENT_FILENAME", length = 100)
	public String getRiskAssessmentFilename() {
		return this.riskAssessmentFilename;
	}

	public void setRiskAssessmentFilename(String riskAssessmentFilename) {
		this.riskAssessmentFilename = riskAssessmentFilename;
	}

	@Column(name = "RISK_ASSESSMENT_CONTENT")
	public byte[] getRiskAssessmentContent() {
		return this.riskAssessmentContent;
	}

	public void setRiskAssessmentContent(byte[] riskAssessmentContent) {
		this.riskAssessmentContent = riskAssessmentContent;
	}

	@Column(name = "BUSINESS_IMPACT_FILENAME", length = 100)
	public String getBusinessImpactFilename() {
		return this.businessImpactFilename;
	}

	public void setBusinessImpactFilename(String businessImpactFilename) {
		this.businessImpactFilename = businessImpactFilename;
	}

	@Column(name = "BUSINESS_IMPACT_CONTENT")
	public byte[] getBusinessImpactContent() {
		return this.businessImpactContent;
	}

	public void setBusinessImpactContent(byte[] businessImpactContent) {
		this.businessImpactContent = businessImpactContent;
	}

	@Column(name = "AUDIT_FINDINGS_FILENAME", length = 100)
	public String getAuditFindingsFilename() {
		return this.auditFindingsFilename;
	}

	public void setAuditFindingsFilename(String auditFindingsFilename) {
		this.auditFindingsFilename = auditFindingsFilename;
	}

	@Column(name = "AUDIT_FINDINGS_CONTENT")
	public byte[] getAuditFindingsContent() {
		return this.auditFindingsContent;
	}

	public void setAuditFindingsContent(byte[] auditFindingsContent) {
		this.auditFindingsContent = auditFindingsContent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "FILE_CONTENT")
	public byte[] getFileContent() {
		return fileContent;
	}
	
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
	@Column(name = "FILE_TYPE")
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	@Column(name = "FILE_LOCATION")
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	@Column(name = "ATTACHMENT_NAME")
	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	@Column(name = "SECTION_NAME")
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	@Column(name = "ACTIVE_FLAG")
	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "UPDATED_BY")
	public UserEntity getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UserEntity updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "UPDATED_TS")
	public Date getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	
	
}