package com.soch.Integra.entities.audit;
// Generated Oct 20, 2017 10:15:53 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StatusTblAudit generated by hbm2java
 */
@Entity
@Table(name = "status_tbl_audit")
public class StatusAuditEntity implements java.io.Serializable {
	
	private int statusAuditId;
	private String operation;
	private Date processDate;
	private int statusId;
	private String name;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "status_audit_id", unique = true, nullable = false)
	public int getStatusAuditId() {
		return statusAuditId;
	}

	public void setStatusAuditId(int statusAuditId) {
		this.statusAuditId = statusAuditId;
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

	@Column(name = "STATUS_ID", nullable = false)
	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
