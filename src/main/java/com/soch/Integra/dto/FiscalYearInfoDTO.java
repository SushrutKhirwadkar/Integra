package com.soch.Integra.dto;

import java.util.Date;


public class FiscalYearInfoDTO {

	private int fyId;
	private Integer fyNumber;
	private String fyContent;
	private String fyMoaTerm;
	private Date createdTs;
	
	public int getFyId() {
		return fyId;
	}
	public Integer getFyNumber() {
		return fyNumber;
	}
	public String getFyContent() {
		return fyContent;
	}
	public String getFyMoaTerm() {
		return fyMoaTerm;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setFyId(int fyId) {
		this.fyId = fyId;
	}
	public void setFyNumber(Integer fyNumber) {
		this.fyNumber = fyNumber;
	}
	public void setFyContent(String fyContent) {
		this.fyContent = fyContent;
	}
	public void setFyMoaTerm(String fyMoaTerm) {
		this.fyMoaTerm = fyMoaTerm;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	
}
