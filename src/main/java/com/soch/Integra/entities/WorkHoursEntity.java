package com.soch.Integra.entities;
// Generated Jul 10, 2018 10:29:43 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WorkHoursTbl generated by hbm2java
 */
@Entity
@Table(name = "work_hours_tbl")
public class WorkHoursEntity implements java.io.Serializable {
	
	

	private Integer workHoursId;
	private ApplicationEntity applicationEntity;
	private String openTm;
	private String closeTm;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private String day;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "WORK_HOURS_ID", unique = true, nullable = false)
	public Integer getWorkHoursId() {
		return this.workHoursId;
	}

	public void setWorkHoursId(Integer workHoursId) {
		this.workHoursId = workHoursId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPLICATION_ID")
	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	
	@Column(name = "OPEN_TM", length = 45)
	public String getOpenTm() {
		return this.openTm;
	}

	public void setOpenTm(String openTm) {
		this.openTm = openTm;
	}

	@Column(name = "CLOSE_TM", length = 45)
	public String getCloseTm() {
		return this.closeTm;
	}

	public void setCloseTm(String closeTm) {
		this.closeTm = closeTm;
	}

	@Column(name = "CREATED_BY", length = 65535)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "UPDATED_BY", length = 65535)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TS", length = 19)
	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	@Column(name = "DAY", length = 19)
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	
}
