package com.soch.Integra.entities;
// Generated Apr 25, 2017 12:37:56 PM by Hibernate Tools 4.3.4.Final

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
 * AppDevelopersTbl generated by hbm2java
 */
@Entity
@Table(name = "app_developers_tbl")
public class AppDevelopersEntity implements java.io.Serializable {

	private int appDevelopersid;
	private ApplicationEntity applicationEntity;
	private UserEntity userEntity;
	private String status;
	private boolean activityFlag;

	public AppDevelopersEntity() {
	}

	public AppDevelopersEntity(int appDevelopersid) {
		this.appDevelopersid = appDevelopersid;
	}

	public AppDevelopersEntity(int appDevelopersid, ApplicationEntity applicationEntity, UserEntity userEntity, String status) {
		this.appDevelopersid = appDevelopersid;
		this.applicationEntity = applicationEntity;
		this.userEntity = userEntity;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "APP_DEVELOPERSID", unique = true, nullable = false)
	public int getAppDevelopersid() {
		return this.appDevelopersid;
	}

	public void setAppDevelopersid(int appDevelopersid) {
		this.appDevelopersid = appDevelopersid;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "APPLICATION")
	public ApplicationEntity getApplicationEntity() {
		return this.applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEVELOPER")
	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	@Column(name = "ACTIVITY_FLAG")
	public boolean isActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(boolean activityFlag) {
		this.activityFlag = activityFlag;
	}

}
