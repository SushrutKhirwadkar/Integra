package com.soch.Integra.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.AuditPolicyDTO;
import com.soch.Integra.dto.PolicyDTO;
import com.soch.Integra.dto.PolicyDocumentsDTO;
import com.soch.Integra.dto.PolicyGrpDTO;
import com.soch.Integra.dto.PolicyResponse;
import com.soch.Integra.dto.PolicyReviewDTO;
import com.soch.Integra.dto.PolicyReviewTermDTO;
import com.soch.Integra.dto.PolicyTypeDTO;
import com.soch.Integra.dto.SubPolicyDTO;
import com.soch.Integra.entities.PolicyReviewTermEntity;

public interface PolicyServices {

	List<PolicyTypeDTO> getPolicyTypes();

	PolicyGrpDTO addPolicyGrp(PolicyGrpDTO policyGrpDTO);

	List<PolicyGrpDTO> fetchPolicyGroup(Integer policyGrpId);

	List<PolicyDTO> fetchPolicies(Integer policyGrpId);

	PolicyResponse uploadPolicyFile(MultipartFile[] files, PolicyGrpDTO policyGrpDTO);

	PolicyResponse updatePolicy(PolicyDTO policyDTO, MultipartFile[] files);

	PolicyResponse comparePolicyFile(MultipartFile[] files, PolicyGrpDTO policyGrpDTO, List<AuditPolicyDTO> auditPolicyDTOs);

	PolicyResponse savePolicy(PolicyDTO policyDTO, MultipartFile[] files);

	PolicyResponse sendNotifications(List<AuditPolicyDTO> auditPolicyDTOs);

	PolicyDTO getPolicy(Integer policyId);
	
	String downloadPolicyFile(int policyGrpId);

	String generatePolicyComppareFile(List<AuditPolicyDTO> appAuditPolicyDTOs);
	
	List<PolicyDTO> getAllPolicies();
	
	List<PolicyGrpDTO> getAllPolicyGrps();

	List<PolicyReviewDTO> assignReviewers(List<PolicyReviewDTO> policyReviewDTOs);

	List<PolicyReviewDTO> getPolicyReviewDTOs(int policyGrpId);

	PolicyReviewDTO getReviewPolicies(String token);

	PolicyReviewDTO savePolicyReview(PolicyReviewDTO policyReviewDTO);

	PolicyReviewDTO getPolicyReviewDetails(Integer reviewId);

	PolicyResponse uploadPolicyDocuments(List<PolicyDocumentsDTO> policyDocDTOs);

	List<PolicyDocumentsDTO> getPolicyDocuments(Integer policyGrpId);

	String getPolicyDocument(Integer id);

	PolicyGrpDTO getPolicyGroupDTO(Integer policyGrpId);
	
	List<PolicyReviewTermDTO> getPolicyReviewTerms();

	PolicyGrpDTO updatePolicyGrp(PolicyGrpDTO policyGrpDTO);

	List<ApplicationDTO> getAppsOnPolicyGrp(Integer policyGrpId);

	SubPolicyDTO getSubPolicy(String subControlNumber, int policyId);

	List<PolicyDTO> fetchPoliciesByFamily(String familyName);

	Set<String> getFamiliaOfPolicies(int policyGrpId);
}
