package com.soch.Integra.entities;

// default package
// Generated Sep 22, 2017 2:31:09 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AppSystemAdminTbl generated by hbm2java
 */
@Entity
@Table(name = "app_system_admin_tbl")
public class AppSystemAdminEntity implements java.io.Serializable {

	private Integer appSystemAdminId;
	private ApplicationEntity applicationEntity;
	private UserEntity userEntity;
	private boolean activeFlag;


	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "app_system_admin_id", unique = true, nullable = false)
	public Integer getAppSystemAdminId() {
		return this.appSystemAdminId;
	}

	public void setAppSystemAdminId(Integer appSystemAdminId) {
		this.appSystemAdminId = appSystemAdminId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application")
	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_system_admin")
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Column(name = "active_flag", length = 1)
	public boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}