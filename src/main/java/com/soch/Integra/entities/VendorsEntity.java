package com.soch.Integra.entities;
// Generated Apr 20, 2018 1:01:13 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.engine.internal.Cascade;

/**
 * VendorsTbl generated by hbm2java
 */
@Entity
@Table(name = "vendors_tbl")
public class VendorsEntity implements java.io.Serializable {

	private Integer vendorId;
	private String name;
	private String createdBy;
	private Date createdTs;
	private String updatedBy;
	private Date updatedTs;
	private VendorAddressEntity vendorAddressEntity;
	private VendorContactEntity vendorContactEntity;
	private Set<SolutionsEntity> solutionsEntities = new HashSet<SolutionsEntity>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "vendor_id", unique = true, nullable = false)
	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	@Column(name = "name", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "created_by", length = 200)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_ts", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	@Column(name = "updated_by", length = 200)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_ts", length = 19)
	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "vendorsEntity",cascade=CascadeType.ALL)
	public VendorAddressEntity getVendorAddressEntity() {
		return vendorAddressEntity;
	}

	public void setVendorAddressEntity(VendorAddressEntity vendorAddressEntity) {
		this.vendorAddressEntity = vendorAddressEntity;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "vendorsEntity",cascade=CascadeType.ALL)
	public VendorContactEntity getVendorContactEntity() {
		return vendorContactEntity;
	}

	public void setVendorContactEntity(VendorContactEntity vendorContactEntity) {
		this.vendorContactEntity = vendorContactEntity;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorsEntity",cascade=CascadeType.ALL)
	public Set<SolutionsEntity> getSolutionsEntities() {
		return solutionsEntities;
	}

	public void setSolutionsEntities(Set<SolutionsEntity> solutionsEntities) {
		this.solutionsEntities = solutionsEntities;
	}
	
	
}
