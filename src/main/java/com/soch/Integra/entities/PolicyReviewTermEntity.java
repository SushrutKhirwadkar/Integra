package com.soch.Integra.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "policy_review_term_tbl")
public class PolicyReviewTermEntity {
	
	private int policyReviewTermId;
	private String policyReviewTerm;
	
	private Set<PolicyGrpEntity> policyGrpEntities;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "policy_review_term_id", unique = true, nullable = false)
	public int getPolicyReviewTermId() {
		return policyReviewTermId;
	}
	public void setPolicyReviewTermId(int policyReviewTermId) {
		this.policyReviewTermId = policyReviewTermId;
	}
	
	@Column(name="policy_review_term")
	public String getPolicyReviewTerm() {
		return policyReviewTerm;
	}
	public void setPolicyReviewTerm(String policyReviewTerm) {
		this.policyReviewTerm = policyReviewTerm;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="policyReviewTermEntity")
	public Set<PolicyGrpEntity> getPolicyGrpEntities() {
		return policyGrpEntities;
	}
	public void setPolicyGrpEntities(Set<PolicyGrpEntity> policyGrpEntities) {
		this.policyGrpEntities = policyGrpEntities;
	}
	
	
	
	

}
