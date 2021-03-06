package com.soch.Integra.entities;
// Generated May 3, 2018 9:28:38 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * HostingTypeTbl generated by hbm2java
 */
@Entity
@Table(name = "hosting_type_tbl")
public class HostingTypeEntity implements java.io.Serializable {

	private Integer hostingTypeId;
	private String name;
	private String desc;
	private Set<AppSolutionEntity> appSolutionEntities = new HashSet<AppSolutionEntity>(0);
	private Set<SolutionsEntity> solutionsEntities = new HashSet<SolutionsEntity>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "HOSTING_TYPE_ID", unique = true, nullable = false)
	public Integer getHostingTypeId() {
		return this.hostingTypeId;
	}

	public void setHostingTypeId(Integer hostingTypeId) {
		this.hostingTypeId = hostingTypeId;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESC", length = 100)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hostingTypeEntity")
	public Set<AppSolutionEntity> getAppSolutionEntities() {
		return appSolutionEntities;
	}

	public void setAppSolutionEntities(Set<AppSolutionEntity> appSolutionEntities) {
		this.appSolutionEntities = appSolutionEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hostingTypeEntity")
	public Set<SolutionsEntity> getSolutionsEntities() {
		return solutionsEntities;
	}

	public void setSolutionsEntities(Set<SolutionsEntity> solutionsEntities) {
		this.solutionsEntities = solutionsEntities;
	}
}
