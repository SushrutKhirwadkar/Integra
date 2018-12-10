package com.soch.Integra.dto;

import java.util.Date;


public class MoaDTO {
	private int moaId;
	private String createdBy;
	private byte[] moa;
	private String moaName;
	private Date moaSignedDate;
	private Date createdTs;
	
	public int getMoaId() {
		return moaId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public byte[] getMoa() {
		return moa;
	}
	public String getMoaName() {
		return moaName;
	}
	public Date getMoaSignedDate() {
		return moaSignedDate;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setMoaId(int moaId) {
		this.moaId = moaId;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setMoa(byte[] moa) {
		this.moa = moa;
	}
	public void setMoaName(String moaName) {
		this.moaName = moaName;
	}
	public void setMoaSignedDate(Date moaSignedDate) {
		this.moaSignedDate = moaSignedDate;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
}
