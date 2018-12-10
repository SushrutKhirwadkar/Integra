package com.soch.Integra.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.entities.AppAuditPolicyEntity;
import com.soch.Integra.entities.PolicyDocumentsEntity;
import com.soch.Integra.entities.PolicyEntity;
import com.soch.Integra.entities.PolicyGrpEntity;
import com.soch.Integra.entities.PolicyReviewEntity;
import com.soch.Integra.entities.PolicyReviewSessionEntity;
import com.soch.Integra.entities.PolicyReviewTermEntity;
import com.soch.Integra.entities.PolicyTypeEnity;
import com.soch.Integra.entities.SubPolicyEntity;

@Component
public class PolicyDaoImpl implements PolicyDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<PolicyTypeEnity> getPolicyTypes() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyTypeEnity.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public PolicyTypeEnity getPolicyType(int policyTypeId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyTypeEnity.class);
		criteria.add(Restrictions.eq("policyTypeId", policyTypeId));
		PolicyTypeEnity policyTypeEnity = (PolicyTypeEnity) criteria.list().get(0);
		return policyTypeEnity;
	}

	@Override
	public PolicyGrpEntity savePolicyGRP(PolicyGrpEntity policyGrpEntity) {
		this.sessionFactory.getCurrentSession().save(policyGrpEntity);
		return policyGrpEntity;
	}

	@Override
	public List<PolicyGrpEntity> getPolicyGRPEntities(Integer auditTypeId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyGrpEntity.class);
		if(auditTypeId != null)
			criteria.add(Restrictions.eq("auditTypeEntity.auditTypeId", auditTypeId));
		return criteria.list();
	}

	@Override
	public List<PolicyEntity> getPoliciesOnGrpId(Integer policyGrpId) {
		
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyEntity.class);
		criteria.add(Restrictions.eq("policyGrpEntity.policyGrpId", policyGrpId));
		return criteria.list();
	}

	@Override
	public PolicyGrpEntity getPolicyGRPEntity(int policyGrpId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyGrpEntity.class);
		criteria.add(Restrictions.eq("policyGrpId", policyGrpId));
		List<PolicyGrpEntity> policyGrpEntities = criteria.list();
		return policyGrpEntities.get(0);
	}

	@Override
	public PolicyEntity savePolicyEntity(PolicyEntity policyEntity) {
		this.sessionFactory.getCurrentSession().save(policyEntity);
		return policyEntity;
	}

	@Override
	public PolicyEntity getPolicyEntityOnName(String policyName) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyEntity.class);
		criteria.add(Restrictions.eq("policyName", policyName));
		List<PolicyEntity> policyEntities = criteria.list();
		PolicyEntity policyEntity =null;
		if(policyEntities.isEmpty())
			return null;
		else
		{
			policyEntity = policyEntities.get(0);
			return policyEntity;
		}
			
	}

	@Override
	public PolicyEntity updatePolicyEntity(PolicyEntity policyEntity) {
		this.sessionFactory.getCurrentSession().update(policyEntity);
		return policyEntity;
	}

	@Override
	public PolicyEntity getPolicyEntityOnName(String policyName, int policyGrpId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyEntity.class);
		criteria.add(Restrictions.eq("controlNumber", policyName));
		criteria.add(Restrictions.eq("policyGrpEntity.policyGrpId", policyGrpId));
		List<PolicyEntity> policyEntities = criteria.list();
		PolicyEntity policyEntity =null;
		if(policyEntities.isEmpty())
			return null;
		else
		{
			policyEntity = policyEntities.get(0);
			return policyEntity;
		}
	}

	@Override
	public AppAuditPolicyEntity getAppAuditPolicyEntity(int appAuditPolicyId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditPolicyEntity.class);
		criteria.add(Restrictions.eq("appAuditPolicyId", appAuditPolicyId));
		List<AppAuditPolicyEntity> appAuditPolicyEntities = criteria.list();
		if(appAuditPolicyEntities.isEmpty())
		{
			return null;
		}
		else
		{
			return appAuditPolicyEntities.get(0);
		}
	}

	@Override
	public PolicyEntity getPolicyEntity(Integer policyId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyEntity.class);
		criteria.add(Restrictions.eq("policyId", policyId));
		List<PolicyEntity> policyEntities = criteria.list();
		PolicyEntity policyEntity =null;
		if(policyEntities.isEmpty())
			return null;
		else
		{
			policyEntity = policyEntities.get(0);
			return policyEntity;
		}
	}

	@Override
	public List<PolicyEntity> getPolicyEntities() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyEntity.class);
		List<PolicyEntity> policyEntities = criteria.list();
		PolicyEntity policyEntity =null;
		return policyEntities;
	}

	@Override
	public PolicyReviewEntity savePolicyReviewEntity(PolicyReviewEntity policyReviewEntity) {
		this.sessionFactory.getCurrentSession().save(policyReviewEntity);
		return policyReviewEntity;
	}

	@Override
	public List<PolicyReviewEntity> getPolicyReviewEnities(Integer policyGrpId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyReviewEntity.class);
		criteria.add(Restrictions.eq("policyGrpEntity.policyGrpId", policyGrpId));
		return criteria.list();
	}

	@Override
	public PolicyReviewSessionEntity getPolicyReviewSessionEntity(String token) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyReviewSessionEntity.class);
		criteria.add(Restrictions.eq("token", token));
		criteria.add(Restrictions.eq("activeFlag", true));
		List<PolicyReviewSessionEntity> policyReviewSessionEntities = criteria.list();
		if(!policyReviewSessionEntities.isEmpty())
		{
			return policyReviewSessionEntities.get(0);		
		}
		else
		{
			return null;
		}
	}

	@Override
	public PolicyReviewEntity getPolicyReviewEntity(Integer policyReview) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyReviewEntity.class);
		criteria.add(Restrictions.eq("policyReview", policyReview));
		return (PolicyReviewEntity)criteria.list().get(0);
	}

	@Override
	public PolicyReviewEntity updatePolicyReviewEntity(PolicyReviewEntity policyReviewEntity) {
		this.sessionFactory.getCurrentSession().save(policyReviewEntity);
		return policyReviewEntity;
	}

	@Override
	public PolicyReviewSessionEntity updatePolicyReviewSessionEntity(
			PolicyReviewSessionEntity policyReviewSessionEntity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(policyReviewSessionEntity);
		return policyReviewSessionEntity;
	}

	@Override
	public PolicyDocumentsEntity savePolicyDocumentsEntity(PolicyDocumentsEntity policyDocumentsEntity) {
		this.sessionFactory.getCurrentSession().save(policyDocumentsEntity);
		return policyDocumentsEntity;
	}

	@Override
	public PolicyDocumentsEntity getPolicyDocumentEntity(Integer id) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyDocumentsEntity.class);
		criteria.add(Restrictions.eq("policyDocumentsTblId", id));
		return (PolicyDocumentsEntity)criteria.list().get(0);
	}

	@Override
	public List<PolicyReviewTermEntity> getPolicyReviewTermEntities() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyReviewTermEntity.class);
		return criteria.list();
	}

	@Override
	public PolicyReviewTermEntity getPolicyReviewTermEntity(int policyReviewTermId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyReviewTermEntity.class);
		criteria.add(Restrictions.eq("policyReviewTermId", policyReviewTermId));
		List<PolicyReviewTermEntity> policyReviewTermEntities = criteria.list();
		if(policyReviewTermEntities.isEmpty())
		{
			return null;
		}
		else
		{
			return policyReviewTermEntities.get(0);
		}
	}

	@Override
	public PolicyGrpEntity updatePolicyGRP(PolicyGrpEntity policyGrpEntity) {
		this.sessionFactory.getCurrentSession().update(policyGrpEntity);
		return policyGrpEntity;
	}
	
	@Override
	public PolicyDocumentsEntity getPolicyDocumentAttch(Integer policyDocId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyDocumentsEntity.class);
		criteria.add(Restrictions.eq("policyDocId", policyDocId));
		List<PolicyDocumentsEntity> policyDocEntities = criteria.list();
		if(!policyDocEntities.isEmpty())
			return policyDocEntities.get(0);
		else
			return null;
		
	}

	@Override
	public List<SubPolicyEntity> getSubPolicies(int policyId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SubPolicyEntity.class);
		criteria.add(Restrictions.eq("policyEntity.policyId", policyId));
		List<SubPolicyEntity> subPolicyEntities = criteria.list();
		if(!subPolicyEntities.isEmpty())
			return subPolicyEntities;
		else
			return null;
		
	}

	@Override
	public List<PolicyEntity> getPoliciesOnFamily(String familyName) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyEntity.class);
		criteria.add(Restrictions.eq("familyName", familyName));
		List<PolicyEntity> policyEntities = criteria.list();
	
		if(policyEntities.isEmpty())
			return null;
		else
		{
			return policyEntities;
		}
			
	}
	
}
