package com.soch.Integra.dao;

import java.util.List;

import com.soch.Integra.entities.AppAuditPolicyEntity;
import com.soch.Integra.entities.PolicyDocumentsEntity;
import com.soch.Integra.entities.PolicyEntity;
import com.soch.Integra.entities.PolicyGrpEntity;
import com.soch.Integra.entities.PolicyReviewEntity;
import com.soch.Integra.entities.PolicyReviewSessionEntity;
import com.soch.Integra.entities.PolicyReviewTermEntity;
import com.soch.Integra.entities.PolicyTypeEnity;
import com.soch.Integra.entities.SubPolicyEntity;

public interface PolicyDao {

	List<PolicyTypeEnity> getPolicyTypes();

	PolicyTypeEnity getPolicyType(int policyTypeId);

	PolicyGrpEntity savePolicyGRP(PolicyGrpEntity policyGrpEntity);

	List<PolicyGrpEntity> getPolicyGRPEntities(Integer policyGrpId);

	List<PolicyEntity> getPoliciesOnGrpId(Integer policyGrpId);

	PolicyGrpEntity getPolicyGRPEntity(int policyGrpId);

	PolicyEntity savePolicyEntity(PolicyEntity policyEntity);

	PolicyEntity getPolicyEntityOnName(String policyName);

	PolicyEntity updatePolicyEntity(PolicyEntity policyEntity);

	PolicyEntity getPolicyEntityOnName(String stringCellValue, int policyGrpId);

	AppAuditPolicyEntity getAppAuditPolicyEntity(int appAuditPolicyId);

	PolicyEntity getPolicyEntity(Integer policyId);

	List<PolicyEntity> getPolicyEntities();

	PolicyReviewEntity savePolicyReviewEntity(PolicyReviewEntity policyReviewEntity);

	List<PolicyReviewEntity> getPolicyReviewEnities(Integer policyGrpId);

	PolicyReviewSessionEntity getPolicyReviewSessionEntity(String token);

	PolicyReviewEntity getPolicyReviewEntity(Integer policyReview);

	PolicyReviewEntity updatePolicyReviewEntity(PolicyReviewEntity policyReviewEntity);

	PolicyReviewSessionEntity updatePolicyReviewSessionEntity(PolicyReviewSessionEntity policyReviewSessionEntity);

	PolicyDocumentsEntity savePolicyDocumentsEntity(PolicyDocumentsEntity policyDocumentsEntity);

	PolicyDocumentsEntity getPolicyDocumentEntity(Integer id);

	List<PolicyReviewTermEntity> getPolicyReviewTermEntities();

	PolicyReviewTermEntity getPolicyReviewTermEntity(int policyReviewTermId);

	PolicyGrpEntity updatePolicyGRP(PolicyGrpEntity policyGrpEntity);

	PolicyDocumentsEntity getPolicyDocumentAttch(Integer policyDocId);

	List<SubPolicyEntity> getSubPolicies(int policyId);

	List<PolicyEntity> getPoliciesOnFamily(String familyName);

}
