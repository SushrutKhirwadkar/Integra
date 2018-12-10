
package com.soch.Integra.dto;
import java.util.Date;

public class AuditTypeDTO {

	private int auditTypeId;
	private String auditTypeName;
	private String createdBy;
	private Date createdTs;
	private boolean active;
	
	
	public int getAuditTypeId() {
		return auditTypeId;
	}
	public void setAuditTypeId(int auditTypeId) {
		this.auditTypeId = auditTypeId;
	}
	public String getAuditTypeName() {
		return auditTypeName;
	}
	public void setAuditTypeName(String auditTypeName) {
		this.auditTypeName = auditTypeName;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
