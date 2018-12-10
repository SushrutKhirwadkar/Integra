package com.soch.Integra.history.dto;

import java.util.Date;


public class CostHistoryDTO {
	private int costId;
	private double typeValue;
	private String typeName;
	private Date createdTs;
	
	
	public int getCostId() {
		return costId;
	}
	
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public double getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(double typeValue) {
		this.typeValue = typeValue;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeNumber) {
		this.typeName = typeNumber;
	}

	
}
