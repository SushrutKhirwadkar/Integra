package com.soch.Integra.dto;

import java.util.Date;

//import com.soch.Integra.ApplicationTbl;
//import com.soch.Integra.UserTbl;

public class ApplDocDTO {
	
	private int documentId;
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
	
	private String fileName;
	private String fileContent;
	private String fileType;
	
	private String fileLocation;
	private String attachmentName;
	private String sectionName;
	private boolean activeFlag;
	private String action;
	
	
	
	public int getDocumentId() {
		return documentId;
	}
	public String getWorkflowDiagramFilename() {
		return workflowDiagramFilename;
	}
	public byte[] getWorkflowDiagramContent() {
		return workflowDiagramContent;
	}
	public String getSystemDiagramFilename() {
		return systemDiagramFilename;
	}
	public byte[] getSystemDiagramContent() {
		return systemDiagramContent;
	}
	public String getRiskAssessmentFilename() {
		return riskAssessmentFilename;
	}
	public byte[] getRiskAssessmentContent() {
		return riskAssessmentContent;
	}
	public String getBusinessImpactFilename() {
		return businessImpactFilename;
	}
	public byte[] getBusinessImpactContent() {
		return businessImpactContent;
	}
	public String getAuditFindingsFilename() {
		return auditFindingsFilename;
	}
	public byte[] getAuditFindingsContent() {
		return auditFindingsContent;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public void setWorkflowDiagramFilename(String workflowDiagramFilename) {
		this.workflowDiagramFilename = workflowDiagramFilename;
	}
	public void setWorkflowDiagramContent(byte[] workflowDiagramContent) {
		this.workflowDiagramContent = workflowDiagramContent;
	}
	public void setSystemDiagramFilename(String systemDiagramFilename) {
		this.systemDiagramFilename = systemDiagramFilename;
	}
	public void setSystemDiagramContent(byte[] systemDiagramContent) {
		this.systemDiagramContent = systemDiagramContent;
	}
	public void setRiskAssessmentFilename(String riskAssessmentFilename) {
		this.riskAssessmentFilename = riskAssessmentFilename;
	}
	public void setRiskAssessmentContent(byte[] riskAssessmentContent) {
		this.riskAssessmentContent = riskAssessmentContent;
	}
	public void setBusinessImpactFilename(String businessImpactFilename) {
		this.businessImpactFilename = businessImpactFilename;
	}
	public void setBusinessImpactContent(byte[] businessImpactContent) {
		this.businessImpactContent = businessImpactContent;
	}
	public void setAuditFindingsFilename(String auditFindingsFilename) {
		this.auditFindingsFilename = auditFindingsFilename;
	}
	public void setAuditFindingsContent(byte[] auditFindingsContent) {
		this.auditFindingsContent = auditFindingsContent;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	
	
}
