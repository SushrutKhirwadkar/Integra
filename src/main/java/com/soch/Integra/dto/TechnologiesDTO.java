package com.soch.Integra.dto;
// Generated May 8, 2017 3:15:25 PM by Hibernate Tools 4.3.5.Final

/**
 * TechnologiesTb generated by hbm2java
 */
public class TechnologiesDTO {

	private int technologyId;
	private String name;
	private String technologyVersion;
	private boolean newEntry;
	private boolean active;

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getTechnologyId() {
		return this.technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getTechnologyVersion() {
		return technologyVersion;
	}

	public void setTechnologyVersion(String technologyVersion) {
		this.technologyVersion = technologyVersion;
	}

	public boolean isNewEntry() {
		return newEntry;
	}

	public void setNewEntry(boolean newEntry) {
		this.newEntry = newEntry;
	}

}