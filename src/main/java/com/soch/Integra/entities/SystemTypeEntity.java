package com.soch.Integra.entities;
// Generated Apr 30, 2018 9:16:23 AM by Hibernate Tools 4.3.5.Final

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
 * SystemTypeTbl generated by hbm2java
 */
@Entity
@Table(name = "system_type_tbl")
public class SystemTypeEntity implements java.io.Serializable {

	private Integer systemTypeId;
	private String name;
	private String description;
	private Set<SolutionsEntity> solutionsEntities = new HashSet<SolutionsEntity>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "SYSTEM_TYPE_ID", unique = true, nullable = false)
	public Integer getSystemTypeId() {
		return this.systemTypeId;
	}

	public void setSystemTypeId(Integer systemTypeId) {
		this.systemTypeId = systemTypeId;
	}

	@Column(name = "NAME", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 5000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "systemTypeEntity")
	public Set<SolutionsEntity> getSolutionsEntities() {
		return solutionsEntities;
	}

	public void setSolutionsEntities(Set<SolutionsEntity> solutionsEntities) {
		this.solutionsEntities = solutionsEntities;
	}

	


}
