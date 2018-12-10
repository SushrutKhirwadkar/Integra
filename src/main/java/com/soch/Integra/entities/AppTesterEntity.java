package com.soch.Integra.entities;


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


@Entity
@Table(name = "app_testers_tbl")
public class AppTesterEntity implements java.io.Serializable {

	private int appTesterId;
	private ApplicationEntity applicationEntity;
	private UserEntity userEntity;
	private boolean activityFlag;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "APP_TESTER_ID", unique = true, nullable = false)
	public int getAppTesterId() {
		return appTesterId;
	}

	public void setAppTesterId(int appTesterId) {
		this.appTesterId = appTesterId;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "APPLICATION")
	public ApplicationEntity getApplicationEntity() {
		return this.applicationEntity;
	}

	

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "TESTER")
	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	@Column(name = "ACTIVITY_FLAG")
	public boolean isActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(boolean activityFlag) {
		this.activityFlag = activityFlag;
	}

}
