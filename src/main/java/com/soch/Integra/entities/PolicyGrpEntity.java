package com.soch.Integra.entities;
// default package
// Generated Dec 26, 2016 4:27:28 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PolicyGrpTb generated by hbm2java
 */
@Entity
@Table(name = "policy_grp_tbl")
public class PolicyGrpEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6353665976745682781L;
	private int policyGrpId;
	private String policyGrpName;
	private String description;
    private String createdBy;
    private Date createdTs;
	private Set<PolicyEntity> policyEntities = new HashSet<PolicyEntity>(0);
	private Set<PolicyReviewEntity> policyReviewEntities = new HashSet<PolicyReviewEntity>(0);
	private Set<PolicyDocumentsEntity> policyDocumentsEntities = new HashSet<PolicyDocumentsEntity>(0);
	//private Set<PolicyGrpEntity> policyGrpEntities;
	//private PolicyTypeEnity policyTypeEnity;
	private List<AppAuditEntity> appAuditEntities;
	private AuditTypeEntity auditTypeEntity;
	
	private PolicyReviewTermEntity policyReviewTermEntity;
	
	private Date reviewDate;
	private String status;
	
	private String owner;
	private Date policyReviewDate;
	private Date lastReviewDate;
	private String updatedBy;
	private Date updatedTs;
	
	private String resourceLinks;
	

	public PolicyGrpEntity() {
	}

	public PolicyGrpEntity(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "POLICY_GRP_ID", unique = true, nullable = false)
	public int getPolicyGrpId() {
		return this.policyGrpId;
	}

	public void setPolicyGrpId(int policyGrpId) {
		this.policyGrpId = policyGrpId;
	}

	@Column(name = "POLICY_GRP_NAME", length = 100)
	public String getPolicyGrpName() {
		return this.policyGrpName;
	}

	public void setPolicyGrpName(String policyGrpName) {
		this.policyGrpName = policyGrpName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "policyGrpEntity",cascade = CascadeType.ALL)
	public Set<PolicyEntity> getPolicyEntities() {
		return policyEntities;
	}

	public void setPolicyEntities(Set<PolicyEntity> policyEntities) {
		this.policyEntities = policyEntities;
	}
	
	@Column(name="CREATED_BY", length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
   

	public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_TS", length=19)
    public Date getCreatedTs() {
        return this.createdTs;
    }
    
    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }
	
    @Column(name="DESCRIPTION", length=500)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUDIT_TYPE_ID")
	public AuditTypeEntity getAuditTypeEntity() {
		return auditTypeEntity;
	}

	public void setAuditTypeEntity(AuditTypeEntity auditTypeEntity) {
		this.auditTypeEntity = auditTypeEntity;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLICY_REVIEW_TERM_ID")
	public PolicyReviewTermEntity getPolicyReviewTermEntity() {
		return policyReviewTermEntity;
	}

	public void setPolicyReviewTermEntity(PolicyReviewTermEntity policyReviewTermEntity) {
		this.policyReviewTermEntity = policyReviewTermEntity;
	}

	@Column(name="REVIEW_DATE")
	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	 @Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "policyGrpEntity")
	public Set<PolicyReviewEntity> getPolicyReviewEntities() {
		return policyReviewEntities;
	}

	public void setPolicyReviewEntities(Set<PolicyReviewEntity> policyReviewEntities) {
		this.policyReviewEntities = policyReviewEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "policyGrpEntity")
	public Set<PolicyDocumentsEntity> getPolicyDocumentsEntities() {
		return policyDocumentsEntities;
	}

	public void setPolicyDocumentsEntities(Set<PolicyDocumentsEntity> policyDocumentsEntities) {
		this.policyDocumentsEntities = policyDocumentsEntities;
	}
	
	 @Column(name="OWNER")
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Column(name = "REVIEW_DT")
	public Date getPolicyReviewDate() {
		return policyReviewDate;
	}

	public void setPolicyReviewDate(Date policyReviewDate) {
		this.policyReviewDate = policyReviewDate;
	}

	@Column(name = "updated_by", length = 100)
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
	
	@Column(name = "LAST_REVIEW_DT")
	public Date getLastReviewDate() {
		return lastReviewDate;
	}

	public void setLastReviewDate(Date lastReviewDate) {
		this.lastReviewDate = lastReviewDate;
	}
	
	@Column(name = "RESOURCE_LINKS")
	public String getResourceLinks() {
		return resourceLinks;
	}

	public void setResourceLinks(String resourceLinks) {
		this.resourceLinks = resourceLinks;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="policyGrpEntity")
	public List<AppAuditEntity> getAppAuditEntities() {
		return appAuditEntities;
	}

	public void setAppAuditEntities(List<AppAuditEntity> appAuditEntities) {
		this.appAuditEntities = appAuditEntities;
	}

	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="policyGrpEntity")
	public Set<PolicyGrpEntity> getPolicyGrpEntities() {
		return policyGrpEntities;
	}

	public void setPolicyGrpEntities(Set<PolicyGrpEntity> policyGrpEntities) {
		this.policyGrpEntities = policyGrpEntities;
	}
	*/
	
	
	
    
	
    

}
