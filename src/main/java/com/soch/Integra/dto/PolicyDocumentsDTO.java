package com.soch.Integra.dto;

import java.util.Date;

public class PolicyDocumentsDTO {

	private Integer policyDocId;
	private String documentName;
	private String documentPath;
	private boolean activeFlag;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private int policyGrpId;
	private String fileContent;
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public int getPolicyGrpId() {
		return policyGrpId;
	}
	public void setPolicyGrpId(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}
	public void setPolicyDocId(Integer policyDocId) {
		this.policyDocId = policyDocId;
	}
	public Integer getPolicyDocId() {
		return policyDocId;
	}
	public void setPolicyDocumentsTblId(Integer policyDocId) {
		this.policyDocId = policyDocId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
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
	
	
	
}
