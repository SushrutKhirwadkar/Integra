package com.soch.Integra.dto;

import java.util.Date;
import java.util.List;

public class MOUDTO {
	
	private int mouId;
	private String name;
	private boolean signed;
	private Date recertificationDt;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private List<MOUDocDTO> mouDocDTOs;
	private int applicationID;
	private Date receiptDt;
	private String applicationAcronym;
	
	
	public int getMouId() {
		return mouId;
	}
	public void setMouId(int mouId) {
		this.mouId = mouId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getSigned() {
		return signed;
	}
	public void setSigned(boolean signed) {
		this.signed = signed;
	}
	public Date getRecertificationDt() {
		return recertificationDt;
	}
	public void setRecertificationDt(Date recertificationDt) {
		this.recertificationDt = recertificationDt;
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
	public List<MOUDocDTO> getMouDocDTOs() {
		return mouDocDTOs;
	}
	public void setMouDocDTOs(List<MOUDocDTO> mouDocDTOs) {
		this.mouDocDTOs = mouDocDTOs;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public Date getReceiptDt() {
		return receiptDt;
	}
	public void setReceiptDt(Date receiptDt) {
		this.receiptDt = receiptDt;
	}
	public String getApplicationAcronym() {
		return applicationAcronym;
	}
	public void setApplicationAcronym(String applicationAcronym) {
		this.applicationAcronym = applicationAcronym;
	}
	
	
	
}
