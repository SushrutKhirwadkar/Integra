package com.soch.Integra.entities.audit;
// Generated Oct 20, 2017 10:15:53 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AppBusinessOwnerTblAuditId generated by hbm2java
 */
@Entity
@Table(name = "app_business_owner_tbl_audit")
public class AppBusinessOwnerAuditEntity implements java.io.Serializable {
	
	private int appBusinessOwnerAuditId;
	private String operation;
	private Date processDate;
	private int appBusinessOwnerId;
	private Integer appBusinessOwner;
	private Integer application;
	private String activeFlag;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "app_business_owner_audit_id", nullable = false)
	public int getAppBusinessOwnerAuditId() {
		return appBusinessOwnerAuditId;
	}

	public void setAppBusinessOwnerAuditId(int appBusinessOwnerAuditId) {
		this.appBusinessOwnerAuditId = appBusinessOwnerAuditId;
	}

	@Column(name = "operation", length = 100)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name = "process_date", length = 19)
	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	@Column(name = "app_business_owner_id", nullable = false)
	public int getAppBusinessOwnerId() {
		return this.appBusinessOwnerId;
	}

	public void setAppBusinessOwnerId(int appBusinessOwnerId) {
		this.appBusinessOwnerId = appBusinessOwnerId;
	}

	@Column(name = "app_business_owner")
	public Integer getAppBusinessOwner() {
		return this.appBusinessOwner;
	}

	public void setAppBusinessOwner(Integer appBusinessOwner) {
		this.appBusinessOwner = appBusinessOwner;
	}

	@Column(name = "application")
	public Integer getApplication() {
		return this.application;
	}

	public void setApplication(Integer application) {
		this.application = application;
	}

	@Column(name = "active_flag", length = 1)
	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AppBusinessOwnerAuditEntity))
			return false;
		AppBusinessOwnerAuditEntity castOther = (AppBusinessOwnerAuditEntity) other;

		return ((this.getOperation() == castOther.getOperation()) || (this.getOperation() != null
				&& castOther.getOperation() != null && this.getOperation().equals(castOther.getOperation())))
				&& ((this.getProcessDate() == castOther.getProcessDate())
						|| (this.getProcessDate() != null && castOther.getProcessDate() != null
								&& this.getProcessDate().equals(castOther.getProcessDate())))
				&& (this.getAppBusinessOwnerId() == castOther.getAppBusinessOwnerId())
				&& ((this.getAppBusinessOwner() == castOther.getAppBusinessOwner())
						|| (this.getAppBusinessOwner() != null && castOther.getAppBusinessOwner() != null
								&& this.getAppBusinessOwner().equals(castOther.getAppBusinessOwner())))
				&& ((this.getApplication() == castOther.getApplication())
						|| (this.getApplication() != null && castOther.getApplication() != null
								&& this.getApplication().equals(castOther.getApplication())))
				&& ((this.getActiveFlag() == castOther.getActiveFlag())
						|| (this.getActiveFlag() != null && castOther.getActiveFlag() != null
								&& this.getActiveFlag().equals(castOther.getActiveFlag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOperation() == null ? 0 : this.getOperation().hashCode());
		result = 37 * result + (getProcessDate() == null ? 0 : this.getProcessDate().hashCode());
		result = 37 * result + this.getAppBusinessOwnerId();
		result = 37 * result + (getAppBusinessOwner() == null ? 0 : this.getAppBusinessOwner().hashCode());
		result = 37 * result + (getApplication() == null ? 0 : this.getApplication().hashCode());
		result = 37 * result + (getActiveFlag() == null ? 0 : this.getActiveFlag().hashCode());
		return result;
	}

}