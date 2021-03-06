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
 * AppBusinessOwnerTbl generated by hbm2java
 */
@Entity
@Table(name = "app_business_owner_tbl")
public class AppBusinessOwnerEntity implements java.io.Serializable {

	private Integer appBusinessOwnerId;
	private ApplicationEntity applicationEntity;
	private UserEntity userEntity;
	private boolean activeFlag;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "app_business_owner_id", unique = true, nullable = false)
	public Integer getAppBusinessOwnerId() {
		return this.appBusinessOwnerId;
	}

	public void setAppBusinessOwnerId(Integer appBusinessOwnerId) {
		this.appBusinessOwnerId = appBusinessOwnerId;
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
	@JoinColumn(name = "app_business_owner")
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
