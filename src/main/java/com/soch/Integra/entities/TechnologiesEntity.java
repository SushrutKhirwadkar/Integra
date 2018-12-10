package com.soch.Integra.entities;
// Generated May 8, 2017 3:15:25 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TechnologiesTb generated by hbm2java
 */
@Entity
@Table(name = "technologies_tb")
public class TechnologiesEntity implements java.io.Serializable {

	private int technologyId;
	private String name;
	private String technologyVersion;
	private Set<ApplicationTechnologyEntity> applicationTechnologyEntities = new HashSet<ApplicationTechnologyEntity>(0);

	
	@Id
	
	@Column(name = "technology_id", unique = true, nullable = false)
	public int getTechnologyId() {
		return this.technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}

	@Column(name = "name", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "technologiesEntity",cascade=CascadeType.ALL)
	public Set<ApplicationTechnologyEntity> getApplicationTechnologyEntities() {
		return applicationTechnologyEntities;
	}

	public void setApplicationTechnologyEntities(Set<ApplicationTechnologyEntity> applicationTechnologyEntities) {
		this.applicationTechnologyEntities = applicationTechnologyEntities;
	}
	
	@Column(name="technology_version")
	public String getTechnologyVersion() {
		return technologyVersion;
	}

	public void setTechnologyVersion(String technologyVersion) {
		this.technologyVersion = technologyVersion;
	}

	
	
	
	

}
