package com.soch.Integra.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "policy_type_tbl")
public class PolicyTypeEnity {
	
	

	private String typeName;
	private int policyTypeId;
	//private Set<PolicyGrpEntity> policyGrpEntities;

	
	@Id
	@Column(name = "POLICY_TYPE_ID", unique = true, nullable = false)
	public int getPolicyTypeId() {
		return policyTypeId;
	}

	public void setPolicyTypeId(int policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	@Column(name = "TYPE_NAME", length = 100)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "policyTypeEnity")
	public Set<PolicyGrpEntity> getPolicyGrpEntities() {
		return policyGrpEntities;
	}

	public void setPolicyGrpEntities(Set<PolicyGrpEntity> policyGrpEntities) {
		this.policyGrpEntities = policyGrpEntities;
	}
*/

}
