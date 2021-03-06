package com.soch.Integra.entities;
// Generated May 8, 2017 3:15:25 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ApplicationTechnologyTb generated by hbm2java
 */
@Entity
@Table(name = "application_technology_tb")
public class ApplicationTechnologyEntity implements java.io.Serializable {

	private int applicationTechnologyId;
	private ApplicationEntity applicationEntity;
	private TechnologiesEntity technologiesEntity;
	private boolean activityFlag;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "application_technology_id", unique = true, nullable = false)
	public int getApplicationTechnologyId() {
		return this.applicationTechnologyId;
	}

	public void setApplicationTechnologyId(int applicationTechnologyId) {
		this.applicationTechnologyId = applicationTechnologyId;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "application_id")
	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "technology_id")
	public TechnologiesEntity getTechnologiesEntity() {
		return technologiesEntity;
	}

	public void setTechnologiesEntity(TechnologiesEntity technologiesEntity) {
		this.technologiesEntity = technologiesEntity;
	}

	
	@Column(name = "ACTIVITY_FLAG")
	public boolean isActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(boolean activityFlag) {
		this.activityFlag = activityFlag;
	}
	
	

}
