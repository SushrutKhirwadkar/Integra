package com.soch.Integra.dto;

import java.util.Date;

import com.soch.Integra.entities.ServerEntity;

public class ServerContactDTO {
	private Integer serverContactId;
	private ServerEntity serverEntity;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private Boolean isPrimary;
	private String divisionName;
	private String cost;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	//private Integer databaseId;
	public Integer getServerContactId() {
		return serverContactId;
	}
	public void setServerContactId(Integer serverContactId) {
		this.serverContactId = serverContactId;
	}
	public ServerEntity getServerEntity() {
		return serverEntity;
	}
	public void setServerEntity(ServerEntity serverEntity) {
		this.serverEntity = serverEntity;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
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
	/*public Integer getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(Integer databaseId) {
		this.databaseId = databaseId;
	}*/
	
	
	
	
}
