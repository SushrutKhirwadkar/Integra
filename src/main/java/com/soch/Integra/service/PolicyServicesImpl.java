package com.soch.Integra.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soch.Integra.dao.ApplicationDao;
import com.soch.Integra.dao.PolicyDao;
import com.soch.Integra.dao.UserDao;
import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.ApplicationUserDTO;
import com.soch.Integra.dto.AuditPolicyDTO;
import com.soch.Integra.dto.PolicyDTO;
import com.soch.Integra.dto.PolicyDocumentsDTO;
import com.soch.Integra.dto.PolicyGrpDTO;
import com.soch.Integra.dto.PolicyResponse;
import com.soch.Integra.dto.PolicyReviewDTO;
import com.soch.Integra.dto.PolicyReviewTermDTO;
import com.soch.Integra.dto.PolicyTypeDTO;
import com.soch.Integra.dto.SubPolicyDTO;
import com.soch.Integra.entities.AppAuditEntity;
import com.soch.Integra.entities.AppAuditPolicyEntity;
import com.soch.Integra.entities.AppBusinessOwnerEntity;
import com.soch.Integra.entities.AppProjectManagerEntity;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.MOUDocEntity;
import com.soch.Integra.entities.PolicyDocumentsEntity;
import com.soch.Integra.entities.PolicyEntity;
import com.soch.Integra.entities.PolicyGrpEntity;
import com.soch.Integra.entities.PolicyLinkEntity;
import com.soch.Integra.entities.PolicyReviewEntity;
import com.soch.Integra.entities.PolicyReviewSessionEntity;
import com.soch.Integra.entities.PolicyReviewTermEntity;
import com.soch.Integra.entities.PolicyReviewerCommentsEntity;
import com.soch.Integra.entities.PolicyTypeEnity;
import com.soch.Integra.entities.SubPolicyEntity;
import com.soch.Integra.entities.UserEntity;
import com.soch.Integra.exception.APMException;
import com.soch.Integra.utils.APMMailUtility;
import com.soch.Integra.utils.ApplicationConstants;

@Service
public class PolicyServicesImpl implements PolicyServices {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PolicyDao policyDao;

	@Autowired
	UserDao userDao;

	@Autowired
	ApplicationDao applicationDao;

	@Autowired
	private Environment environment;

	@Override
	@Transactional
	public List<PolicyTypeDTO> getPolicyTypes() {

		List<PolicyTypeDTO> policyTypeDTOs = new ArrayList<PolicyTypeDTO>();
		PolicyTypeDTO policyTypeDTO = null;
		List<PolicyTypeEnity> policyTypeEnities = policyDao.getPolicyTypes();
		for (PolicyTypeEnity policyTypeEnity : policyTypeEnities) {
			policyTypeDTO = new PolicyTypeDTO();
			policyTypeDTO.setPolicyTypeId(policyTypeEnity.getPolicyTypeId());
			policyTypeDTO.setTypeName(policyTypeEnity.getTypeName());
			policyTypeDTOs.add(policyTypeDTO);
		}
		return policyTypeDTOs;
	}

	@Override
	@Transactional
	public PolicyGrpDTO addPolicyGrp(PolicyGrpDTO policyGrpDTO) {

		PolicyGrpEntity policyGrpEntity = new PolicyGrpEntity();
		policyGrpEntity.setPolicyGrpName(policyGrpDTO.getPolicyGrpName());
		policyGrpEntity.setDescription(policyGrpDTO.getDescription());
		policyGrpEntity.setAuditTypeEntity(applicationDao.getAuditType(policyGrpDTO.getAuditTypeId()));
		policyGrpEntity.setCreatedTs(new Date());
		policyGrpEntity.setCreatedBy(policyGrpDTO.getCreatedBy());
		policyGrpEntity.setUpdatedTs(new Date());
		policyGrpEntity.setUpdatedBy(policyGrpDTO.getCreatedBy());
		policyGrpEntity = policyDao.savePolicyGRP(policyGrpEntity);
		policyGrpDTO.setPolicyGrpId(policyGrpEntity.getPolicyGrpId());
		return policyGrpDTO;
	}

	@Override
	@Transactional
	public PolicyGrpDTO updatePolicyGrp(PolicyGrpDTO policyGrpDTO) {
		PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyGrpDTO.getPolicyGrpId());

		if (policyGrpEntity != null) {
			policyGrpEntity.setDescription(policyGrpDTO.getDescription());
			policyGrpEntity.setUpdatedTs(new Date());
			policyGrpEntity.setUpdatedBy(policyGrpDTO.getUpdatedBy());
			policyGrpEntity.setLastReviewDate(policyGrpDTO.getLastReviewDate());
			policyGrpEntity.setPolicyReviewDate(policyGrpDTO.getPolicyReviewDate());
			policyGrpEntity.setOwner(policyGrpDTO.getOwner());
			policyGrpEntity.setPolicyReviewTermEntity(
					policyDao.getPolicyReviewTermEntity(policyGrpDTO.getPolicyReviewTermId()));
			policyGrpEntity.setStatus(policyGrpDTO.getStatus());
			policyGrpEntity.setResourceLinks(policyGrpDTO.getResourceLinks());
			policyGrpEntity = policyDao.updatePolicyGRP(policyGrpEntity);

		}
		return policyGrpDTO;
	}

	@Override
	@Transactional
	public List<PolicyGrpDTO> fetchPolicyGroup(Integer auditTypeId) {
		PolicyGrpDTO policyGrpDTO = new PolicyGrpDTO();
		List<PolicyGrpDTO> policyGrpDTOs = new ArrayList<>();
		List<PolicyGrpEntity> policyGrpEntities = policyDao.getPolicyGRPEntities(auditTypeId);
		for (PolicyGrpEntity policyGrpEntity : policyGrpEntities) {
			policyGrpDTO = new PolicyGrpDTO();
			policyGrpDTO.setPolicyGrpId(policyGrpEntity.getPolicyGrpId());
			policyGrpDTO.setPolicyGrpName(policyGrpEntity.getPolicyGrpName());
			policyGrpDTOs.add(policyGrpDTO);
		}
		return policyGrpDTOs;
	}

	@Override
	@Transactional
	public List<PolicyDTO> fetchPolicies(Integer policyGrpId) {
		List<PolicyDTO> policyDTOs = new ArrayList<>();
		PolicyDTO policyDTO = null;
		List<PolicyEntity> policyEntities = policyDao.getPoliciesOnGrpId(policyGrpId);
		for (PolicyEntity policyEntity : policyEntities) {
			policyDTO = new PolicyDTO();
			policyDTO.setPolicyId(policyEntity.getPolicyId());
			policyDTO.setControlNumber(policyEntity.getControlNumber());
			policyDTO.setDescription(policyEntity.getDescription());
			policyDTO.setPolicyName(policyEntity.getPolicyName());
			policyDTO.setPolicyVal(policyEntity.getPolicyVal());
			policyDTO.setPriority(policyEntity.getPriority());
			policyDTO.setProcedures(policyEntity.getProcedures());
			policyDTO.setGuidelines(policyEntity.getGuidelines());
			policyDTO.setPolicyGrpId(policyGrpId);
			policyDTO.setAssignedBy(policyEntity.getAssignedBy());
			policyDTO.setAssignedTo(policyEntity.getAssignedTo());
			policyDTO.setEndDate(policyEntity.getEndDate());
			policyDTO.setStartDate(policyEntity.getStartDate());
			policyDTO.setClassType(policyEntity.getClassType());
			policyDTO.setStatus(policyEntity.getStatus());
			policyDTO.setFamilyName(policyEntity.getFamilyName());
			if (policyEntity.getPolicyDocumentsEntities() != null
					&& !policyEntity.getPolicyDocumentsEntities().isEmpty()) {
				PolicyDocumentsDTO policyDocumentsDTO = null;
				List<PolicyDocumentsDTO> policyDocumentsDTOs = new ArrayList<>();
				for (PolicyDocumentsEntity policyDocumentsEntity : policyEntity.getPolicyDocumentsEntities()) {
					if (policyDocumentsEntity.getActiveFlag()) {
						policyDocumentsDTO = new PolicyDocumentsDTO();
						policyDocumentsDTO.setDocumentName(policyDocumentsEntity.getDocumentName());
						policyDocumentsDTO.setPolicyDocumentsTblId(policyDocumentsEntity.getPolicyDocId());
						policyDocumentsDTOs.add(policyDocumentsDTO);
					}

				}
				policyDTO.setPolicyDocumentsDTOs(policyDocumentsDTOs);
			}

			if (policyEntity.getSubPolicyEntities() != null && !policyEntity.getSubPolicyEntities().isEmpty()) {
				SubPolicyDTO subPolicyDTO = null;
				List<SubPolicyDTO> subPolicyDTOs = new ArrayList<>();
				for (SubPolicyEntity subPolicyEntity : policyEntity.getSubPolicyEntities()) {

					subPolicyDTO = new SubPolicyDTO();
					try {
						BeanUtils.copyProperties(subPolicyDTO, subPolicyEntity);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					subPolicyDTOs.add(subPolicyDTO);

				}
				policyDTO.setSubPolicyDTOs(subPolicyDTOs);
			}
			policyDTOs.add(policyDTO);

		}
		return policyDTOs;
	}

	@Override
	@Transactional
	public Set<String> getFamiliaOfPolicies(int policyGrpId) {
		Set<String> families = new HashSet<>();
		List<PolicyEntity> policyEntities = policyDao.getPoliciesOnGrpId(policyGrpId);
		if (policyEntities != null && !policyEntities.isEmpty()) {
			for (PolicyEntity policyEntity : policyEntities) {
				if (policyEntity.getFamilyName() != null) {
					String family = new String();
					family = policyEntity.getFamilyName();
					families.add(family);
				}
			}

		}

		return families;

	}

	@Override
	@Transactional
	public List<PolicyDTO> fetchPoliciesByFamily(String familyName) {
		List<PolicyDTO> policyDTOs = new ArrayList<>();
		PolicyDTO policyDTO = null;
		List<PolicyEntity> policyEntities = policyDao.getPoliciesOnFamily(familyName);
		for (PolicyEntity policyEntity : policyEntities) {
			policyDTO = new PolicyDTO();
			policyDTO.setPolicyId(policyEntity.getPolicyId());
			policyDTO.setControlNumber(policyEntity.getControlNumber());
			policyDTO.setDescription(policyEntity.getDescription());
			policyDTO.setPolicyName(policyEntity.getPolicyName());
			policyDTO.setPolicyVal(policyEntity.getPolicyVal());
			policyDTO.setPriority(policyEntity.getPriority());
			policyDTO.setProcedures(policyEntity.getProcedures());
			policyDTO.setGuidelines(policyEntity.getGuidelines());
			policyDTO.setPolicyGrpId(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
			policyDTO.setAssignedBy(policyEntity.getAssignedBy());
			policyDTO.setAssignedTo(policyEntity.getAssignedTo());
			policyDTO.setEndDate(policyEntity.getEndDate());
			policyDTO.setStartDate(policyEntity.getStartDate());
			policyDTO.setClassType(policyEntity.getClassType());
			policyDTO.setStatus(policyEntity.getStatus());
			policyDTO.setFamilyName(policyEntity.getFamilyName());
			if (policyEntity.getPolicyDocumentsEntities() != null
					&& !policyEntity.getPolicyDocumentsEntities().isEmpty()) {
				PolicyDocumentsDTO policyDocumentsDTO = null;
				List<PolicyDocumentsDTO> policyDocumentsDTOs = new ArrayList<>();
				for (PolicyDocumentsEntity policyDocumentsEntity : policyEntity.getPolicyDocumentsEntities()) {
					if (policyDocumentsEntity.getActiveFlag()) {
						policyDocumentsDTO = new PolicyDocumentsDTO();
						policyDocumentsDTO.setDocumentName(policyDocumentsEntity.getDocumentName());
						policyDocumentsDTO.setPolicyDocumentsTblId(policyDocumentsEntity.getPolicyDocId());
						policyDocumentsDTOs.add(policyDocumentsDTO);
					}

				}
				policyDTO.setPolicyDocumentsDTOs(policyDocumentsDTOs);
			}

			if (policyEntity.getSubPolicyEntities() != null && !policyEntity.getSubPolicyEntities().isEmpty()) {
				SubPolicyDTO subPolicyDTO = null;
				List<SubPolicyDTO> subPolicyDTOs = new ArrayList<>();
				for (SubPolicyEntity subPolicyEntity : policyEntity.getSubPolicyEntities()) {

					subPolicyDTO = new SubPolicyDTO();
					try {
						BeanUtils.copyProperties(subPolicyDTO, subPolicyEntity);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					subPolicyDTOs.add(subPolicyDTO);

				}
				policyDTO.setSubPolicyDTOs(subPolicyDTOs);
			}
			policyDTOs.add(policyDTO);

		}
		return policyDTOs;
	}

	@Override
	@Transactional
	public PolicyResponse uploadPolicyFile(MultipartFile[] files, PolicyGrpDTO policyGrpDTO) {

		MultipartFile policyFile = files[0];
		FileInputStream excelFile;
		PolicyResponse policyResponse = new PolicyResponse();
		try {
			File inputFile = new File(
					environment.getRequiredProperty("AAMLocation") + policyFile.getOriginalFilename());
			policyFile.transferTo(inputFile);
			excelFile = new FileInputStream(inputFile);
			HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			HSSFRow row = sheet.getRow(0);
			// Non empty Last cell Number or index return
			Iterator cellIterator = row.cellIterator();
			int column = 0;
			String coulmnNames[] = messageSource.getMessage("policySheetColumnNames", null, Locale.getDefault())
					.split(",");
			while (cellIterator.hasNext()) {
				HSSFCell cell = (HSSFCell) cellIterator.next();
				/* System.out.println(cell.getStringCellValue()+" "+coulmnNames[column]); */

				if (!cell.getStringCellValue().toUpperCase().contentEquals(coulmnNames[column].toUpperCase())) {
					policyResponse.setResponseCode(Integer.parseInt(messageSource
							.getMessage("APPLICATION.INVALID.POLICY.FILE.CODE", null, Locale.getDefault())));
					policyResponse.setResponseString(messageSource.getMessage("APPLICATION.INVALID.POLICY.FILE.STRING",
							null, Locale.getDefault()));
					return policyResponse;
				}
				List<String> columnsList = Arrays.asList(coulmnNames);
				/*
				 * if(!columnsList.contains(cell.getStringCellValue())) {
				 * policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage(
				 * "APPLICATION.INVALID.POLICY.FILE.CODE",null, Locale.getDefault())));
				 * policyResponse.setResponseString(messageSource.getMessage(
				 * "APPLICATION.INVALID.POLICY.FILE.STRING",null, Locale.getDefault()))); }
				 */
				column++;
			}

			int lastRowNum = sheet.getLastRowNum();
			PolicyEntity policyEntity = null;

			PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyGrpDTO.getPolicyGrpId());

			for (int i = 1; i < lastRowNum; i++) {

				row = sheet.getRow(i);
				policyEntity = policyDao.getPolicyEntityOnName(row.getCell(0).getStringCellValue(),
						policyGrpDTO.getPolicyGrpId());
				if (policyEntity == null) {
					policyEntity = new PolicyEntity();
					policyEntity.setControlNumber(row.getCell(0).getStringCellValue());
					policyEntity.setFamilyName(row.getCell(1).getStringCellValue());
					policyEntity.setClassType(row.getCell(2).getStringCellValue());
					policyEntity.setPolicyName(row.getCell(3).getStringCellValue());
					if (row.getCell(4) != null)
						policyEntity.setDescription(row.getCell(4).getStringCellValue());
					else
						policyEntity.setDescription("No description");
					if (row.getCell(5) != null)
						policyEntity.setPolicyVal(row.getCell(5).getStringCellValue());
					policyEntity.setPolicyGrpEntity(policyGrpEntity);
					policyEntity.setCreatedBy(policyGrpDTO.getCreatedBy());
					policyEntity.setUpdatedBy(policyGrpDTO.getCreatedBy());
					policyEntity.setCreatedTs(new Date());
					policyEntity.setUpdatedTs(new Date());
					if (row.getCell(6) != null)
						policyEntity.setProcedures(row.getCell(6).getStringCellValue());
					if (row.getCell(8) != null)
						policyEntity.setPriority(row.getCell(8).getStringCellValue());
					if (row.getCell(7) != null)
						policyEntity.setGuidelines(row.getCell(7).getStringCellValue());

					if (row.getCell(6) != null)
						policyEntity.setProcedures(row.getCell(6).getStringCellValue());
					if (row.getCell(8) != null)
						policyEntity.setPriority(row.getCell(8).getStringCellValue());
					if (row.getCell(7) != null)
						policyEntity.setGuidelines(row.getCell(7).getStringCellValue());

					/*
					 * policyEntity = new PolicyEntity();
					 * policyEntity.setControlNumber(row.getCell(0).getStringCellValue());
					 * policyEntity.setFamilyName(row.getCell(1).getStringCellValue());
					 * if(row.getCell(2) != null)
					 * policyEntity.setPolicyName(row.getCell(2).getStringCellValue());
					 * if(row.getCell(3) != null)
					 * policyEntity.setProcedures(row.getCell(3).getStringCellValue());
					 * if(row.getCell(4) != null)
					 * policyEntity.setIsDesignDocument(row.getCell(4).getStringCellValue());
					 * 
					 * if(row.getCell(5) != null)
					 * policyEntity.setSecurityPlan(row.getCell(5).getStringCellValue());
					 * if(row.getCell(6) != null)
					 * policyEntity.setIsConfigSettings(row.getCell(6).getStringCellValue());
					 * 
					 * if(row.getCell(7) != null)
					 * policyEntity.setConfigBaseline(row.getCell(7).getStringCellValue());
					 * 
					 * if(row.getCell(8) != null)
					 * policyEntity.setAuditRecords(row.getCell(8).getStringCellValue());
					 * 
					 * if(row.getCell(9) != null)
					 * policyEntity.setArtifacts(row.getCell(9).getStringCellValue());
					 * 
					 * if(row.getCell(10) != null)
					 * policyEntity.setNonCov(row.getCell(10).getStringCellValue());
					 */

					policyEntity.setPolicyGrpEntity(policyGrpEntity);
					policyEntity.setCreatedBy(policyGrpDTO.getCreatedBy());
					policyEntity.setUpdatedBy(policyGrpDTO.getCreatedBy());
					policyEntity.setCreatedTs(new Date());
					policyEntity.setUpdatedTs(new Date());

					policyDao.savePolicyEntity(policyEntity);
					policyEntity = policyDao.savePolicyEntity(policyEntity);
				} else {
					policyEntity.setControlNumber(row.getCell(0).getStringCellValue());
					policyEntity.setFamilyName(row.getCell(1).getStringCellValue());
					policyEntity.setClassType(row.getCell(2).getStringCellValue());
					policyEntity.setPolicyName(row.getCell(3).getStringCellValue());
					policyEntity.setDescription(row.getCell(4).getStringCellValue());
					if (row.getCell(5) != null)
						policyEntity.setPolicyVal(row.getCell(5).getStringCellValue());
					policyEntity.setUpdatedBy(policyGrpDTO.getCreatedBy());
					policyEntity.setUpdatedTs(new Date());
					if (row.getCell(6) != null)
						policyEntity.setProcedures(row.getCell(6).getStringCellValue());
					if (row.getCell(8) != null)
						policyEntity.setPriority(row.getCell(8).getStringCellValue());
					if (row.getCell(7) != null)
						policyEntity.setGuidelines(row.getCell(7).getStringCellValue());

					/*
					 * policyEntity.setControlNumber(row.getCell(0).getStringCellValue());
					 * policyEntity.setFamilyName(row.getCell(1).getStringCellValue());
					 * if(row.getCell(2) != null)
					 * policyEntity.setPolicyName(row.getCell(2).getStringCellValue());
					 * if(row.getCell(3) != null)
					 * policyEntity.setProcedures(row.getCell(3).getStringCellValue());
					 * if(row.getCell(4) != null)
					 * policyEntity.setIsDesignDocument(row.getCell(4).getStringCellValue());
					 * 
					 * if(row.getCell(5) != null)
					 * policyEntity.setSecurityPlan(row.getCell(5).getStringCellValue());
					 * if(row.getCell(6) != null)
					 * policyEntity.setIsConfigSettings(row.getCell(6).getStringCellValue());
					 * 
					 * if(row.getCell(7) != null)
					 * policyEntity.setConfigBaseline(row.getCell(7).getStringCellValue());
					 * 
					 * if(row.getCell(8) != null)
					 * policyEntity.setAuditRecords(row.getCell(8).getStringCellValue());
					 * 
					 * if(row.getCell(9) != null)
					 * policyEntity.setArtifacts(row.getCell(9).getStringCellValue());
					 * 
					 * if(row.getCell(10) != null)
					 * policyEntity.setNonCov(row.getCell(10).getStringCellValue());
					 */

					policyEntity.setUpdatedBy(policyGrpDTO.getCreatedBy());
					policyEntity.setUpdatedTs(new Date());
					policyEntity = policyDao.updatePolicyEntity(policyEntity);
				}

			}
			List<PolicyDTO> policyDTOs = fetchPolicies(policyGrpDTO.getPolicyGrpId());
			policyResponse.setResponseCode(Integer.parseInt(
					messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.CODE", null, Locale.getDefault())));
			policyResponse.setResponseString(
					messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.STRING", null, Locale.getDefault()));
			policyResponse.setPolicyDTOs(policyDTOs);
			inputFile.delete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			policyResponse.setResponseCode(Integer.parseInt(messageSource
					.getMessage("APPLICATION.VALID.POLICY.FILE.MISSING.REQUIRED.CODE", null, Locale.getDefault())));
			policyResponse.setResponseString(messageSource
					.getMessage("APPLICATION.VALID.POLICY.FILE.MISSING.REQUIRED.STRING", null, Locale.getDefault()));
			return policyResponse;
		} catch (Exception e) {
			policyResponse.setResponseCode(Integer.parseInt(
					messageSource.getMessage("APPLICATION.INVALID.POLICY.FILE.CODE", null, Locale.getDefault())));
			policyResponse.setResponseString(
					messageSource.getMessage("APPLICATION.INVALID.POLICY.FILE.STRING", null, Locale.getDefault()));
			return policyResponse;
		}
		return policyResponse;
	}

	@Override
	@Transactional
	public PolicyResponse updatePolicy(PolicyDTO policyDTO, MultipartFile[] files) {
		PolicyResponse policyResponse = new PolicyResponse();
		Set<PolicyLinkEntity> policyLinkEntities = null;
		PolicyEntity policyEntity = policyDao.getPolicyEntity(policyDTO.getPolicyId());
		policyEntity.setControlNumber(policyDTO.getControlNumber());
		policyEntity.setPolicyName(policyDTO.getPolicyName());
		policyEntity.setDescription(policyDTO.getDescription());
		policyEntity.setPolicyVal(policyDTO.getPolicyVal());
		policyEntity.setUpdatedBy(policyDTO.getUpdatedBy());
		policyEntity.setProcedures(policyDTO.getProcedures());
		policyEntity.setPriority(policyDTO.getPriority());
		policyEntity.setStatus(policyDTO.isStatus());
		policyEntity.setGuidelines(policyDTO.getGuidelines());
		if (policyDTO.getAssignedTo() != null)
			if (!policyDTO.getAssignedTo().equalsIgnoreCase(policyEntity.getAssignedTo())) {
				policyEntity.setAssignedTo(policyDTO.getAssignedTo());
				policyEntity.setEndDate(policyDTO.getEndDate());
				policyEntity.setStartDate(new Date());
				policyEntity.setAssignedBy(policyDTO.getUpdatedBy());
			}

		if (policyDTO.getPolicyDocumentsDTOs() != null && !policyDTO.getPolicyDocumentsDTOs().isEmpty()) {
			PolicyDocumentsEntity policyDocumentsEntity = null;
			Set<PolicyDocumentsEntity> policyDocumentsEntities = policyEntity.getPolicyDocumentsEntities();
			if (policyDocumentsEntities == null) {
				policyDocumentsEntities = new HashSet<>();
			}
			String filePath = null;
			for (PolicyDocumentsDTO policyDocumentsDTO : policyDTO.getPolicyDocumentsDTOs()) {
				if (policyDocumentsDTO.getPolicyDocId() == null) {
					for (MultipartFile file : files) {
						if (file.getOriginalFilename().equalsIgnoreCase(policyDocumentsDTO.getDocumentName())) {
							filePath = environment.getRequiredProperty("AAMLocation") + "policy/"
									+ policyEntity.getPolicyGrpEntity().getPolicyGrpId();
							File inputFile = new File(filePath);
							if (!inputFile.exists()) {
								inputFile.mkdir();
							}
							filePath = filePath + "/" + policyEntity.getControlNumber();
							inputFile = new File(filePath);
							if (!inputFile.exists()) {
								inputFile.mkdir();
							}
							filePath = filePath + "/" + file.getOriginalFilename();
							try {
								inputFile = new File(filePath);

								file.transferTo(inputFile);

								policyDocumentsEntity = new PolicyDocumentsEntity();
								policyDocumentsEntity.setPolicyEntity(policyEntity);
								policyDocumentsEntity.setDocumentPath(filePath);
								policyDocumentsEntity.setDocumentName(file.getOriginalFilename());
								policyDocumentsEntity.setCreatedBy(policyDTO.getCreatedBy());
								policyDocumentsEntity.setActiveFlag(true);
								policyDocumentsEntity.setCreatedTs(new Date());
								policyDocumentsEntity.setUpdatedBy(policyDTO.getCreatedBy());
								policyDocumentsEntity.setUpdatedTs(new Date());
							} catch (IllegalStateException | IOException e) {
								e.printStackTrace();
							}
							policyDocumentsEntities.add(policyDocumentsEntity);
						}
					}
				} else {
					for (PolicyDocumentsEntity policyDocumentsEntity2 : policyDocumentsEntities) {
						if (policyDocumentsEntity2.getPolicyDocId() == policyDocumentsDTO.getPolicyDocId()
								&& policyDocumentsEntity2.getActiveFlag() != policyDocumentsDTO.isActiveFlag()) {
							policyDocumentsEntity2.setActiveFlag(policyDocumentsDTO.isActiveFlag());
							policyDocumentsEntity2.setUpdatedBy(policyDTO.getCreatedBy());
							policyDocumentsEntity2.setUpdatedTs(new Date());
							policyDocumentsEntities.add(policyDocumentsEntity2);
							break;
						}
					}
				}

			}
			policyEntity.getPolicyDocumentsEntities().addAll(policyDocumentsEntities);
		}

		if (policyDTO.getLinkedPolicies() != null && !policyDTO.getLinkedPolicies().isEmpty()) {
			if (policyEntity.getPolicyLinkEntitysForPolicyId() != null
					&& !policyEntity.getPolicyLinkEntitysForPolicyId().isEmpty())
				policyLinkEntities = policyEntity.getPolicyLinkEntitysForPolicyId();
			else {
				policyLinkEntities = new HashSet<>();
			}
			PolicyLinkEntity policyLinkEntity = null;

			for (PolicyDTO policyDTO2 : policyDTO.getLinkedPolicies()) {
				if (policyDTO2.getLinkType() != null && policyDTO2.getLinkType().equalsIgnoreCase("ADD")) {
					policyLinkEntity = new PolicyLinkEntity();
					policyLinkEntity.setPolicyEntityByPolicyId(policyEntity);
					policyLinkEntity.setActiveFlag(true);
					policyLinkEntity.setCreatedBy(policyDTO.getUpdatedBy());
					policyLinkEntity.setUpdatedBy(policyDTO.getUpdatedBy());
					policyLinkEntity.setUpdatedTs(new Date());
					policyLinkEntity.setUpdatedTs(new Date());
					policyLinkEntity.setPolicyEntityByLinkPolicyId(policyDao.getPolicyEntity(policyDTO2.getPolicyId()));
					policyLinkEntities.add(policyLinkEntity);
				} else if (policyDTO2.getLinkType() != null && policyDTO2.getLinkType().equalsIgnoreCase("UPDATE")) {
					for (PolicyLinkEntity policyLinkEntity2 : policyLinkEntities) {
						if (policyDTO2.getPolicyId()
								.equals(policyLinkEntity2.getPolicyEntityByLinkPolicyId().getPolicyId())
								&& policyLinkEntity2.getActiveFlag()) {
							policyLinkEntity2.setActiveFlag(false);
							policyLinkEntity2.setUpdatedBy(policyDTO.getUpdatedBy());
							policyLinkEntity2.setUpdatedTs(new Date());
							policyLinkEntities.add(policyLinkEntity2);
							break;
						}
					}
				}
			}
			policyEntity.setPolicyLinkEntitysForPolicyId(policyLinkEntities);
		}

		if (policyDTO.getLinkedPoliciesString() != null) {
			policyEntity.setLinkString(policyDTO.getLinkedPoliciesString());
		}

		if (policyDTO.getSubPolicyDTOs() != null && !policyDTO.getSubPolicyDTOs().isEmpty()) {
			SubPolicyEntity subPolicyEntity = null;
			List<SubPolicyEntity> subPolicyEntities = policyDao.getSubPolicies(policyDTO.getPolicyId());
			List<SubPolicyEntity> subPolicyEntitys = new ArrayList<>();
			
			for (SubPolicyDTO subPolicyDTO : policyDTO.getSubPolicyDTOs()) {
				int check = 0;
				if(subPolicyEntities != null && !(subPolicyEntities.isEmpty()))
				for (SubPolicyEntity subPolicyEntity1 : subPolicyEntities) {
					
					if ( subPolicyDTO.getSubPolicyId() != null && subPolicyDTO.getSubPolicyId().intValue() == subPolicyEntity1.getSubPolicyId().intValue()) {

						try {
							subPolicyEntity1.setSubControlNumber(subPolicyDTO.getSubControlNumber());
							subPolicyEntity1.setSubPolicyName(subPolicyDTO.getSubPolicyName());
							subPolicyEntity1.setAssignedTo(subPolicyDTO.getAssignedTo());
							subPolicyEntity1.setEndDate(subPolicyDTO.getEndDate());
							subPolicyEntity1.setGuidelines(subPolicyDTO.getGuidelines());
							subPolicyEntity1.setSubprocedure(subPolicyDTO.getSubprocedure());
							subPolicyEntity1.setSubstatus(subPolicyDTO.getsubstatus());
							check++;
							subPolicyEntitys.add(subPolicyEntity1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						

					}
					else {
						continue;
					}

				}

				if (check == 0) {

					subPolicyEntity = new SubPolicyEntity();
					subPolicyEntity.setPolicyEntity(policyEntity);
					subPolicyEntity.setSubControlNumber(subPolicyDTO.getSubControlNumber());
					subPolicyEntity.setSubPolicyName(subPolicyDTO.getSubPolicyName());
					subPolicyEntity.setAssignedTo(subPolicyDTO.getAssignedTo());
					subPolicyEntity.setEndDate(subPolicyDTO.getEndDate());
					subPolicyEntity.setGuidelines(subPolicyDTO.getGuidelines());
					subPolicyEntity.setSubprocedure(subPolicyDTO.getSubprocedure());
					subPolicyEntity.setSubstatus(subPolicyDTO.getsubstatus());
					subPolicyEntitys.add(subPolicyEntity);

				}
			}
			policyEntity.setSubPolicyEntities(subPolicyEntitys);
		}

		policyDao.updatePolicyEntity(policyEntity);
		List<PolicyDTO> policyDTOs = fetchPolicies(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
		policyResponse.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.CODE", null, Locale.getDefault())));
		policyResponse.setResponseString(
				messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.STRING", null, Locale.getDefault()));
		policyResponse.setPolicyDTOs(policyDTOs);
		return policyResponse;
	}

	@Override
	@Transactional
	public PolicyResponse savePolicy(PolicyDTO policyDTO, MultipartFile[] files) {
		PolicyResponse policyResponse = new PolicyResponse();
		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setPolicyVal(policyDTO.getPolicyVal());
		policyEntity.setControlNumber(policyDTO.getControlNumber());
		policyEntity.setPolicyName(policyDTO.getPolicyName());
		policyEntity.setDescription(policyDTO.getDescription());
		policyEntity.setCreatedBy(policyDTO.getUpdatedBy());
		policyEntity.setPolicyGrpEntity(policyDao.getPolicyGRPEntity(policyDTO.getPolicyGrpId()));
		policyEntity.setUpdatedBy(policyDTO.getUpdatedBy());
		policyEntity.setProcedures(policyDTO.getProcedures());
		policyEntity.setPriority(policyDTO.getPriority());
		policyEntity.setClassType(policyDTO.getClassType());
		policyEntity.setFamilyName(policyDTO.getFamilyName());
		policyEntity.setStatus(policyDTO.isStatus());
		policyEntity.setGuidelines(policyDTO.getGuidelines());

		if (policyDTO.getAssignedTo() != null) {
			policyEntity.setAssignedTo(policyDTO.getAssignedTo());
			policyEntity.setEndDate(policyDTO.getEndDate());
			policyEntity.setStartDate(new Date());
			policyEntity.setAssignedBy(policyDTO.getUpdatedBy());
		}

		if (policyDTO.getPolicyDocumentsDTOs() != null && !policyDTO.getPolicyDocumentsDTOs().isEmpty()) {
			PolicyDocumentsEntity policyDocumentsEntity = null;
			Set<PolicyDocumentsEntity> policyDocumentsEntities = new HashSet<>();
			String filePath = null;
			for (PolicyDocumentsDTO policyDocumentsDTO : policyDTO.getPolicyDocumentsDTOs()) {
				for (MultipartFile file : files) {
					if (file.getOriginalFilename().equalsIgnoreCase(policyDocumentsDTO.getDocumentName())) {
						filePath = environment.getRequiredProperty("AAMLocation") + "policy/"
								+ policyEntity.getPolicyGrpEntity().getPolicyGrpId();
						File inputFile = new File(filePath);
						if (!inputFile.exists()) {
							inputFile.mkdir();
						}
						filePath = filePath + "/" + policyEntity.getControlNumber();
						inputFile = new File(filePath);
						if (!inputFile.exists()) {
							inputFile.mkdir();
						}
						filePath = filePath + "/" + file.getOriginalFilename();
						try {
							inputFile = new File(filePath);

							file.transferTo(inputFile);

							policyDocumentsEntity = new PolicyDocumentsEntity();
							policyDocumentsEntity.setPolicyEntity(policyEntity);
							policyDocumentsEntity.setDocumentPath(filePath);
							policyDocumentsEntity.setDocumentName(file.getOriginalFilename());
							policyDocumentsEntity.setCreatedBy(policyDTO.getCreatedBy());
							policyDocumentsEntity.setActiveFlag(true);
							policyDocumentsEntity.setCreatedTs(new Date());
							policyDocumentsEntity.setUpdatedBy(policyDTO.getCreatedBy());
							policyDocumentsEntity.setUpdatedTs(new Date());
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						policyDocumentsEntities.add(policyDocumentsEntity);
					}
				}

			}

			if (!policyDocumentsEntities.isEmpty())
				policyEntity.setPolicyDocumentsEntities(policyDocumentsEntities);
		}

		if (policyDTO.getSubPolicyDTOs() != null && !policyDTO.getSubPolicyDTOs().isEmpty()) {
			SubPolicyEntity subPolicyEntity = null;
			List<SubPolicyEntity> subPolicyEntitys = new ArrayList<>();
			for (SubPolicyDTO subPolicyDTO : policyDTO.getSubPolicyDTOs()) {

				subPolicyEntity = new SubPolicyEntity();
				try {
					BeanUtils.copyProperties(subPolicyEntity, subPolicyDTO);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				subPolicyEntitys.add(subPolicyEntity);

			}
			policyEntity.setSubPolicyEntities(subPolicyEntitys);
		}

		policyDao.savePolicyEntity(policyEntity);
		List<PolicyDTO> policyDTOs = fetchPolicies(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
		policyResponse.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.CODE", null, Locale.getDefault())));
		policyResponse.setResponseString(
				messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.STRING", null, Locale.getDefault()));
		policyResponse.setPolicyDTOs(policyDTOs);
		return policyResponse;
	}

	@Override
	@Transactional
	public PolicyResponse comparePolicyFile(MultipartFile[] files, PolicyGrpDTO policyGrpDTO,
			List<AuditPolicyDTO> auditPolicyDTOs) {
		MultipartFile policyFile = files[0];
		FileInputStream excelFile;
		PolicyResponse policyResponse = new PolicyResponse();
		auditPolicyDTOs = new ArrayList<>(0);
		// List<AuditPolicyDTO> auditPolicyDTOs = new ArrayList<>(0);
		AuditPolicyDTO auditPolicyDTO = null;
		try {
			File inputFile = new File(
					environment.getRequiredProperty("AAMLocation") + policyFile.getOriginalFilename());
			policyFile.transferTo(inputFile);
			excelFile = new FileInputStream(inputFile);
			HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			HSSFRow row = sheet.getRow(0);
			// Non empty Last cell Number or index return
			Iterator cellIterator = row.cellIterator();
			int column = 0;
			while (cellIterator.hasNext()) {
				HSSFCell cell = (HSSFCell) cellIterator.next();
				String coulmnNames[] = messageSource.getMessage("policySheetColumnNames", null, Locale.getDefault())
						.split(",");
				System.out.println(cell.getStringCellValue() + " " + coulmnNames[column]);
				if (!cell.getStringCellValue().toUpperCase().contentEquals(coulmnNames[column].toUpperCase())) {
					policyResponse.setResponseCode(Integer.parseInt(messageSource
							.getMessage("APPLICATION.INVALID.POLICY.FILE.CODE", null, Locale.getDefault())));
					policyResponse.setResponseString(messageSource.getMessage("APPLICATION.INVALID.POLICY.FILE.STRING",
							null, Locale.getDefault()));
					return policyResponse;
				}
				List<String> columnsList = Arrays.asList(coulmnNames);
				column++;
			}

			int lastRowNum = sheet.getLastRowNum();
			PolicyEntity policyEntity = null;

			PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyGrpDTO.getPolicyGrpId());
			Set<PolicyEntity> policyEntities = policyGrpEntity.getPolicyEntities();

			for (int i = 1; i <= lastRowNum; i++) {

				row = sheet.getRow(i);

				for (PolicyEntity policyEntity2 : policyEntities) {
					String ctrl = row.getCell(0).getStringCellValue().toString();
					if (row.getCell(0).getStringCellValue() != null
							&& policyEntity2.getControlNumber().equalsIgnoreCase(row.getCell(0).getStringCellValue())) {
						auditPolicyDTO = new AuditPolicyDTO();
						if (policyEntity2.getPolicyVal() != null && row.getCell(5) != null
								&& policyEntity2.getPolicyVal().equalsIgnoreCase(row.getCell(5).getStringCellValue())) {
							auditPolicyDTO.setStatus("Close");
						} else {
							auditPolicyDTO.setStatus("Open");
						}
						auditPolicyDTO.setPolicyId(policyEntity2.getPolicyId());
						auditPolicyDTO.setControlNumber(policyEntity2.getControlNumber());
						auditPolicyDTO.setDescription(policyEntity2.getDescription());
						auditPolicyDTO.setPolicyName(policyEntity2.getPolicyName());
						auditPolicyDTO.setPolicyVal(policyEntity2.getPolicyVal());
						if (row.getCell(5) != null)
							auditPolicyDTO.setDefaultVal(row.getCell(5).getStringCellValue());
						auditPolicyDTO.setPolicyGrpId(policyGrpDTO.getPolicyGrpId());
						auditPolicyDTOs.add(auditPolicyDTO);
					}
				}

			}
			policyResponse.setResponseCode(Integer.parseInt(
					messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.CODE", null, Locale.getDefault())));
			policyResponse.setResponseString(
					messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.STRING", null, Locale.getDefault()));
			policyResponse.setAuditPolicyDTOs(auditPolicyDTOs);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return policyResponse;
	}

	@Override
	@Transactional
	public PolicyResponse sendNotifications(List<AuditPolicyDTO> auditPolicyDTOs) {
		PolicyResponse policyResponse = new PolicyResponse();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Compare Sheet");

		HSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		style.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);

		HSSFFont font = workbook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setFontHeightInPoints((short) 15);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.BLACK.index);
		style.setFont(font);

		HSSFRow rowhead = sheet.createRow((short) 0);
		HSSFCell cell = rowhead.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("CONTROL_NUMBER");

		cell = rowhead.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("POLICY_NAME");

		cell = rowhead.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("DESCRIPTION");

		cell = rowhead.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("POLICY_VALUE");

		cell = rowhead.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("DEFAULT_VALUE");

		style = workbook.createCellStyle();
		style.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		style.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);

		font = workbook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.BLACK.index);
		style.setFont(font);

		int i = 1;
		for (AuditPolicyDTO auditPolicyDTO : auditPolicyDTOs) {
			/*
			 * if(auditPolicyDTO.getStatus().equalsIgnoreCase("open")) {
			 */
			HSSFRow row = sheet.createRow((short) i++);
			cell = row.createCell(0);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getControlNumber());

			cell = row.createCell(1);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getPolicyName());

			cell = row.createCell(2);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getDescription());

			cell = row.createCell(3);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getPolicyVal());

			cell = row.createCell(4);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getDefaultVal());
			/* } */

		}
		/* String fileName = "/opt/bitnami/nfs/AuditComparision.xlx"; */
		String fileName = environment.getRequiredProperty("AAMLocation") + "AuditComparision.xls";
		File file = new File(fileName);
		try {

			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.flush();
			fos.close();
			StringBuffer toAddresses = new StringBuffer();
			List<UserEntity> userEntities = applicationDao.getUsers();
			Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
			ApplicationUserDTO userDTO = null;

			for (UserEntity userEntity : userEntities) {
				if (userEntity.getUserAppRoleEntity() != null
						&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("ISO")) {
					toAddresses.append(userEntity.getEmailId() + ",");
				}
			}
			APMMailUtility.sendEmailAttachment(fileName, toAddresses.toString());
			file.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		policyResponse.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.CODE", null, Locale.getDefault())));
		policyResponse.setResponseString(
				messageSource.getMessage("APPLICATION.VALID.POLICY.FILE.STRING", null, Locale.getDefault()));

		return policyResponse;
	}

	@Override
	@Transactional
	public PolicyDTO getPolicy(Integer policyId) {
		PolicyEntity policyEntity = policyDao.getPolicyEntity(policyId);

		PolicyDTO policyDTO = new PolicyDTO();
		/*
		 * policyDTO.setPolicyId(policyEntity.getPolicyId());
		 * policyDTO.setControlNumber(policyEntity.getControlNumber());
		 * policyDTO.setDescription(policyEntity.getDescription());
		 * policyDTO.setPolicyName(policyEntity.getPolicyName());
		 * policyDTO.setPolicyVal(policyEntity.getPolicyVal());
		 * policyDTO.setPriority(policyEntity.getPriority());
		 * policyDTO.setProcedures(policyEntity.getProcedures());
		 * policyDTO.setGuidelines(policyEntity.getGuidelines());
		 * 
		 * policyDTO.setAssignedBy(policyEntity.getAssignedBy());
		 * policyDTO.setAssignedTo(policyEntity.getAssignedTo());
		 * policyDTO.setEndDate(policyEntity.getEndDate());
		 * policyDTO.setStartDate(policyEntity.getStartDate());
		 * policyDTO.setClassType(policyEntity.getClassType());
		 * policyDTO.setFamilyName(policyEntity.getFamilyName());
		 * policyDTO.setStatus(policyEntity.getStatus());
		 */

		try {
			BeanUtils.copyProperties(policyDTO, policyEntity);
			policyDTO.setLinkedPoliciesString(policyEntity.getLinkString());
			policyDTO.setPolicyGrpId(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
			if (policyEntity.getPolicyDocumentsEntities() != null
					&& !policyEntity.getPolicyDocumentsEntities().isEmpty()) {
				PolicyDocumentsDTO policyDocumentsDTO = null;
				List<PolicyDocumentsDTO> policyDocumentsDTOs = new ArrayList<>();
				for (PolicyDocumentsEntity policyDocumentsEntity : policyEntity.getPolicyDocumentsEntities()) {
					if (policyDocumentsEntity.getActiveFlag()) {
						policyDocumentsDTO = new PolicyDocumentsDTO();
						policyDocumentsDTO.setActiveFlag(policyDocumentsEntity.getActiveFlag());
						policyDocumentsDTO.setPolicyDocumentsTblId(policyDocumentsEntity.getPolicyDocId());
						policyDocumentsDTO.setDocumentName(policyDocumentsEntity.getDocumentName());
						policyDocumentsDTOs.add(policyDocumentsDTO);
					}
				}
				policyDTO.setPolicyDocumentsDTOs(policyDocumentsDTOs);

			}
			List<SubPolicyDTO> subPolicyDTOs = new ArrayList<>();
			if (policyEntity.getSubPolicyEntities() != null && !policyEntity.getSubPolicyEntities().isEmpty()) {

				for (SubPolicyEntity subPolicyEntity : policyEntity.getSubPolicyEntities()) {
					SubPolicyDTO subPolicyDTO = new SubPolicyDTO();
					subPolicyDTO.setSubControlNumber(subPolicyEntity.getSubControlNumber());
					subPolicyDTO.setAssignedTo(subPolicyEntity.getAssignedTo());
					subPolicyDTO.setEndDate(subPolicyEntity.getEndDate());
					subPolicyDTO.setGuidelines(subPolicyEntity.getGuidelines());
					subPolicyDTO.setSubprocedure(subPolicyEntity.getSubprocedure());
					subPolicyDTO.setSubPolicyName(subPolicyEntity.getSubPolicyName());
					subPolicyDTO.setSubstatus(subPolicyEntity.getSubstatus());
					subPolicyDTO.setSubPolicyId(subPolicyEntity.getSubPolicyId());
					subPolicyDTOs.add(subPolicyDTO);
				}
			}

			policyDTO.setSubPolicyDTOs(subPolicyDTOs);

			if (policyEntity.getPolicyLinkEntitysForPolicyId() != null
					&& !policyEntity.getPolicyLinkEntitysForPolicyId().isEmpty()) {
				List<PolicyDTO> poliicyLinkDTOs = new ArrayList<>();
				PolicyDTO linkPolicy = null;
				PolicyEntity linkPolicyEntity = null;
				for (PolicyLinkEntity policyLinkEntity : policyEntity.getPolicyLinkEntitysForPolicyId()) {
					linkPolicyEntity = policyDao
							.getPolicyEntity(policyLinkEntity.getPolicyEntityByLinkPolicyId().getPolicyId());
					if (policyLinkEntity.getActiveFlag()) {
						linkPolicy = new PolicyDTO();
						linkPolicy.setPolicyId(linkPolicyEntity.getPolicyId());
						linkPolicy.setStatus(policyLinkEntity.getActiveFlag());
						linkPolicy.setControlNumber(linkPolicyEntity.getControlNumber());
						linkPolicy.setPolicyGrpId(linkPolicyEntity.getPolicyGrpEntity().getPolicyGrpId());
						poliicyLinkDTOs.add(linkPolicy);
					}
				}
				policyDTO.setLinkedPolicies(poliicyLinkDTOs);
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return policyDTO;
	}

	@Override
	@Transactional
	public String downloadPolicyFile(int policyGrpId) {
		List<PolicyEntity> policyEntities = policyDao.getPoliciesOnGrpId(policyGrpId);

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Compare Sheet");

		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);

		XSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 15);
		font.setBold(true);
		style.setFont(font);

		XSSFRow rowhead = sheet.createRow((short) 0);
		XSSFCell cell = rowhead.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("CONTROL_NUMBER");

		cell = rowhead.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("POLICY_NAME");

		cell = rowhead.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("DESCRIPTION");

		cell = rowhead.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("PROCEDURES");

		cell = rowhead.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("GUIDELINES");

		cell = rowhead.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("PRIORITY");

		cell = rowhead.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("POLICY_VALUE");

		style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);

		font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		font.setBold(false);
		style.setFont(font);

		XSSFCellStyle descriptionCell = workbook.createCellStyle();
		descriptionCell.setBorderTop(BorderStyle.THIN);
		descriptionCell.setBorderBottom(BorderStyle.THIN);
		descriptionCell.setBorderLeft(BorderStyle.THIN);
		descriptionCell.setBorderRight(BorderStyle.THIN);

		font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		font.setBold(false);
		descriptionCell.setFont(font);

		descriptionCell.setWrapText(true);

		int i = 1;
		String fileName = null;
		for (PolicyEntity policyEntity : policyEntities) {
			if (fileName == null) {
				fileName = policyEntity.getPolicyGrpEntity().getPolicyGrpName() + ".xlsx";
			}
			XSSFRow row = sheet.createRow((short) i++);
			cell = row.createCell(0);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(policyEntity.getControlNumber());

			cell = row.createCell(1);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(policyEntity.getPolicyName());

			cell = row.createCell(2);
			cell.setCellStyle(descriptionCell);
			cell.setCellValue(policyEntity.getDescription());

			cell = row.createCell(3);
			cell.setCellStyle(descriptionCell);
			cell.setCellValue(policyEntity.getProcedures());

			cell = row.createCell(4);
			cell.setCellStyle(descriptionCell);
			cell.setCellValue(policyEntity.getGuidelines());

			cell = row.createCell(5);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(policyEntity.getPriority());

			cell = row.createCell(6);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(policyEntity.getPolicyVal());
		}

		Row row = sheet.getRow(0);
		Iterator cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			XSSFCell cell2 = (XSSFCell) cellIterator.next();
			int columnIndex = cell2.getColumnIndex();
			sheet.autoSizeColumn(columnIndex);
		}

		fileName = environment.getRequiredProperty("AAMLocation") + fileName;
		File file = new File(fileName);
		FileOutputStream fos;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return fileName;
	}

	@Override
	public String generatePolicyComppareFile(List<AuditPolicyDTO> appAuditPolicyDTOs) {
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Compare Sheet");

		XSSFCellStyle style = workbook.createCellStyle();
		XSSFCellStyle descriptionCell = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);

		XSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 15);
		font.setBold(true);
		style.setFont(font);

		XSSFRow rowhead = sheet.createRow((short) 0);
		XSSFCell cell = rowhead.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("CONTROL_NUMBER");

		cell = rowhead.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("POLICY_NAME");

		cell = rowhead.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("DESCRIPTION");

		cell = rowhead.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("PROCEDURES");

		cell = rowhead.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("GUIDELINES");

		cell = rowhead.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("PRIORITY");

		cell = rowhead.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("POLICY_VALUE");

		cell = rowhead.createCell(7);
		cell.setCellStyle(style);
		cell.setCellValue("DEFAULT_VALUE");

		cell = rowhead.createCell(8);
		cell.setCellStyle(style);
		cell.setCellValue("CPMPARE_STATUS");

		style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);

		font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		font.setBold(false);
		style.setFont(font);

		descriptionCell = workbook.createCellStyle();
		descriptionCell.setBorderTop(BorderStyle.THIN);
		descriptionCell.setBorderBottom(BorderStyle.THIN);
		descriptionCell.setBorderLeft(BorderStyle.THIN);
		descriptionCell.setBorderRight(BorderStyle.THIN);

		font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		font.setBold(false);
		descriptionCell.setFont(font);

		descriptionCell.setWrapText(true);

		int i = 1;
		String fileName = null;
		for (AuditPolicyDTO auditPolicyDTO : appAuditPolicyDTOs) {
			if (fileName == null) {
				fileName = "Test.xlsx";
			}

			AppAuditPolicyEntity appAuditPolicyEntity = policyDao
					.getAppAuditPolicyEntity(auditPolicyDTO.getAppAuditPolicyId());
			XSSFRow row = sheet.createRow((short) i++);
			cell = row.createCell(0);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getControlNumber());

			cell = row.createCell(1);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getPolicyName());

			cell = row.createCell(2);
			cell.setCellStyle(descriptionCell);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getDescription());

			cell = row.createCell(3);
			cell.setCellStyle(descriptionCell);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getProcedures());

			cell = row.createCell(4);
			cell.setCellStyle(descriptionCell);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getGuidelines());

			cell = row.createCell(5);
			style.setWrapText(true);
			cell.setCellStyle(style);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getPriority());

			cell = row.createCell(6);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(appAuditPolicyEntity.getPolicyEntity().getPolicyVal());

			cell = row.createCell(7);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getDefaultVal());

			cell = row.createCell(8);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(auditPolicyDTO.getStatus());

		}

		Row row = sheet.getRow(0);
		Iterator cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			XSSFCell cell2 = (XSSFCell) cellIterator.next();
			int columnIndex = cell2.getColumnIndex();
			sheet.autoSizeColumn(columnIndex);
		}

		fileName = environment.getRequiredProperty("AAMLocation") + fileName;
		File file = new File(fileName);
		FileOutputStream fos;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return fileName;
	}

	@Override
	@Transactional
	public List<PolicyDTO> getAllPolicies() {
		List<PolicyEntity> policyEntities = policyDao.getPolicyEntities();
		List<PolicyDTO> policyDTOs = new ArrayList<PolicyDTO>();
		PolicyDTO policyDTO = null;
		if (policyEntities != null && !policyEntities.isEmpty()) {
			for (PolicyEntity policyEntity : policyEntities) {
				policyDTO = new PolicyDTO();
				policyDTO.setPolicyId(policyEntity.getPolicyId());
				policyDTO.setControlNumber(policyEntity.getControlNumber());
				policyDTO.setDescription(policyEntity.getDescription());
				policyDTO.setPolicyName(policyEntity.getPolicyName());
				policyDTO.setPolicyVal(policyEntity.getPolicyVal());
				policyDTO.setPriority(policyEntity.getPriority());
				policyDTO.setProcedures(policyEntity.getProcedures());
				policyDTO.setGuidelines(policyEntity.getGuidelines());
				policyDTO.setPolicyGrpId(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
				policyDTO.setAssignedBy(policyEntity.getAssignedBy());
				policyDTO.setAssignedTo(policyEntity.getAssignedTo());
				policyDTO.setEndDate(policyEntity.getEndDate());
				policyDTO.setStartDate(policyEntity.getStartDate());
				policyDTO.setClassType(policyEntity.getClassType());
				policyDTO.setFamilyName(policyEntity.getFamilyName());
				policyDTO.setStatus(policyEntity.getStatus());
				policyDTOs.add(policyDTO);
			}
		}
		return policyDTOs;
	}

	@Override
	@Transactional
	public SubPolicyDTO getSubPolicy(String subControlNumber, int policyId) {
		List<SubPolicyEntity> subPolicyEntities = policyDao.getSubPolicies(policyId);
		SubPolicyDTO subPolicyDTO = new SubPolicyDTO();
		for (SubPolicyEntity subPolicyEntity : subPolicyEntities) {
			if (subPolicyEntity.getSubControlNumber().equals(subControlNumber)) {
				try {
					BeanUtils.copyProperties(subPolicyDTO, subPolicyEntity);

					return subPolicyDTO;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return null;
	}

	@Override
	@Transactional
	public List<PolicyGrpDTO> getAllPolicyGrps() {
		List<PolicyGrpEntity> policyGrpEntities = policyDao.getPolicyGRPEntities(null);

		PolicyGrpDTO policyGrpDTO = null;
		List<PolicyGrpDTO> policyGrpDTOs = new ArrayList<>();
		for (PolicyGrpEntity policyGrpEntity : policyGrpEntities) {
			policyGrpDTO = new PolicyGrpDTO();
			policyGrpDTO.setPolicyGrpId(policyGrpEntity.getPolicyGrpId());
			policyGrpDTO.setPolicyGrpName(policyGrpEntity.getPolicyGrpName());
			policyGrpDTO.setStatus(policyGrpEntity.getStatus());
			policyGrpDTO.setLastReviewDate(policyGrpEntity.getLastReviewDate());
			if (policyGrpEntity.getAuditTypeEntity() != null)
				policyGrpDTO.setAuditTypeName(policyGrpEntity.getAuditTypeEntity().getAuditTypeName());
			policyGrpDTOs.add(policyGrpDTO);
		}

		return policyGrpDTOs;
	}

	@Override
	@Transactional
	public List<PolicyReviewDTO> assignReviewers(List<PolicyReviewDTO> policyReviewDTOs) {

		PolicyReviewEntity policyReviewEntity = null;

		PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyReviewDTOs.get(0).getPolicyGrpId());
		PolicyReviewerCommentsEntity policyReviewerCommentsEntity = null;
		Set<PolicyReviewerCommentsEntity> policyReviewerCommentsEntities = new HashSet<>();
		PolicyReviewSessionEntity policyReviewSessionEntity = null;
		Set<PolicyReviewSessionEntity> policyReviewSessionEntities = new HashSet<>();

		Calendar cal = Calendar.getInstance();
		for (PolicyReviewDTO policyReviewDTO : policyReviewDTOs) {
			policyReviewEntity = new PolicyReviewEntity();
			policyReviewEntity.setAssignedTo(policyReviewDTO.getAssignedTo());
			policyReviewEntity.setDueDate(policyReviewDTO.getDueDate());
			policyReviewEntity.setCreatedBy(policyReviewDTO.getCreatedBy());
			policyReviewEntity.setCreatedTs(new Date());
			policyReviewEntity.setUpdatedBy(policyReviewDTO.getCreatedBy());
			policyReviewEntity.setUpdatedTs(new Date());
			policyReviewEntity.setPolicyGrpEntity(policyGrpEntity);
			policyReviewEntity.setStatus(policyReviewDTO.getStatus());

			List<PolicyEntity> policyEntities = policyDao.getPoliciesOnGrpId(policyReviewDTOs.get(0).getPolicyGrpId());

			for (PolicyEntity policyEntity : policyEntities) {
				policyReviewerCommentsEntity = new PolicyReviewerCommentsEntity();
				policyReviewerCommentsEntity.setPolicyEntity(policyEntity);
				policyReviewerCommentsEntity.setPolicyReviewEntity(policyReviewEntity);
				policyReviewerCommentsEntity.setCreatedBy(policyReviewDTO.getCreatedBy());
				policyReviewerCommentsEntity.setCreatedTs(new Date());
				policyReviewerCommentsEntity.setUpdatedBy(policyReviewDTO.getCreatedBy());
				policyReviewerCommentsEntity.setUpdatedTs(new Date());
				policyReviewerCommentsEntities.add(policyReviewerCommentsEntity);
			}
			policyReviewEntity.setPolicyReviewerCommentsEntities(policyReviewerCommentsEntities);
			String authtokenID = UUID.randomUUID().toString().replaceAll("-", "");
			policyReviewSessionEntity = new PolicyReviewSessionEntity();
			policyReviewSessionEntity.setPolicyReviewEntity(policyReviewEntity);
			cal.setTime(policyReviewDTO.getDueDate());
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			policyReviewSessionEntity.setExpiryTs(cal.getTime());
			policyReviewSessionEntity.setActiveFlag(true);
			policyReviewSessionEntity.setToken(authtokenID);
			policyReviewSessionEntities.add(policyReviewSessionEntity);

			policyReviewEntity.setPolicyReviewSessionEntity(policyReviewSessionEntities);

			policyReviewEntity = policyDao.savePolicyReviewEntity(policyReviewEntity);

			// sendReviewNotification(policyReviewEntity.getAssignedTo(), authtokenID);
		}

		List<PolicyReviewEntity> policyReviewEntities = policyDao
				.getPolicyReviewEnities(policyReviewDTOs.get(0).getPolicyGrpId());
		policyReviewDTOs = new ArrayList<>();
		PolicyReviewDTO policyReviewDTO = null;
		for (PolicyReviewEntity policyReviewEntity2 : policyReviewEntities) {
			policyReviewDTO = new PolicyReviewDTO();
			policyReviewDTO.setAssignedTo(policyReviewEntity2.getAssignedTo());
			policyReviewDTO.setDueDate(policyReviewEntity2.getDueDate());
			policyReviewDTO.setCreatedBy(policyReviewEntity2.getCreatedBy());
			policyReviewDTO.setCreatedTs(policyReviewEntity2.getCreatedTs());
			policyReviewDTO.setUpdatedBy(policyReviewEntity2.getUpdatedBy());
			policyReviewDTO.setUpdatedTs(policyReviewEntity2.getUpdatedTs());
			policyReviewDTO.setStatus(policyReviewEntity2.getStatus());
			policyReviewDTO.setPolicyGrpName(policyReviewEntity2.getPolicyGrpEntity().getPolicyGrpName());
			policyReviewDTOs.add(policyReviewDTO);
		}
		return policyReviewDTOs;
	}

	private boolean sendReviewNotification(String userName, String authtokenID) {
		String fname = null, lname = null, name[];
		if (userName != null) {
			name = userName.split(" ");
			fname = name[0] + "%";
			if (name.length > 1)
				lname = name[1] + "%";
		}

		List<UserEntity> userEntities = userDao.getUseronName(fname, lname);

		UserEntity userEntity = userEntities.get(0);

		String linkStr = environment.getRequiredProperty("hostName") + ApplicationConstants.POLICY_REVIEW_LINK;
		linkStr = linkStr.replaceAll("token", authtokenID);
		String msgBody = ApplicationConstants.POLICY_REVIEW_EMAIL_BODY;
		msgBody = msgBody.replaceAll("url", linkStr);
		APMMailUtility.sendHTMLEmail(userEntity.getEmailId(), ApplicationConstants.POLICY_REVIEW_EMAIL_SUBJECT,
				msgBody);

		// UserEntity userEntity = applicationDao.getUserOnName(name);

		return true;
	}

	@Override
	@Transactional
	public List<PolicyReviewDTO> getPolicyReviewDTOs(int policyGrpId) {
		List<PolicyReviewDTO> policyReviewDTOs = new ArrayList<>();
		PolicyReviewDTO policyReviewDTO = null;
		List<PolicyReviewEntity> policyReviewEntities = policyDao.getPolicyReviewEnities(policyGrpId);
		for (PolicyReviewEntity policyReviewEntity2 : policyReviewEntities) {
			policyReviewDTO = new PolicyReviewDTO();
			policyReviewDTO.setPolicyReview(policyReviewEntity2.getPolicyReview());
			policyReviewDTO.setAssignedTo(policyReviewEntity2.getAssignedTo());
			policyReviewDTO.setDueDate(policyReviewEntity2.getDueDate());
			policyReviewDTO.setCreatedBy(policyReviewEntity2.getCreatedBy());
			policyReviewDTO.setCreatedTs(policyReviewEntity2.getCreatedTs());
			policyReviewDTO.setUpdatedBy(policyReviewEntity2.getUpdatedBy());
			policyReviewDTO.setUpdatedTs(policyReviewEntity2.getUpdatedTs());
			policyReviewDTO.setStatus(policyReviewEntity2.getStatus());
			policyReviewDTO.setPolicyGrpName(policyReviewEntity2.getPolicyGrpEntity().getPolicyGrpName());
			policyReviewDTOs.add(policyReviewDTO);
		}
		return policyReviewDTOs;
	}

	@SuppressWarnings("unused")
	@Override
	@Transactional
	public PolicyReviewDTO getReviewPolicies(String token) {
		PolicyReviewSessionEntity policyReviewSessionEntity = policyDao.getPolicyReviewSessionEntity(token);
		Calendar cal = Calendar.getInstance();

		if (policyReviewSessionEntity == null) {
			return null;
		} else {
			Calendar expDt = Calendar.getInstance();
			expDt.setTime(policyReviewSessionEntity.getExpiryTs());
			expDt.set(Calendar.HOUR_OF_DAY, 23);
			expDt.set(Calendar.MINUTE, 59);
			expDt.set(Calendar.SECOND, 59);
			if (cal.getTime().after(expDt.getTime())) {
				policyReviewSessionEntity.setActiveFlag(false);
				policyReviewSessionEntity = policyDao.updatePolicyReviewSessionEntity(policyReviewSessionEntity);
				return null;
			} else {
				List<PolicyDTO> policyDTOs = new ArrayList<>();
				PolicyDTO policyDTO = null;
				PolicyEntity policyEntity = null;
				PolicyReviewDTO policyReviewDTO = new PolicyReviewDTO();

				PolicyReviewEntity policyReviewEntity = policyReviewSessionEntity.getPolicyReviewEntity();
				Set<PolicyReviewerCommentsEntity> policyReviewerCommentsEntities = policyReviewEntity
						.getPolicyReviewerCommentsEntities();

				for (PolicyReviewerCommentsEntity policyReviewerCommentsEntity : policyReviewerCommentsEntities) {
					policyDTO = new PolicyDTO();
					policyEntity = policyReviewerCommentsEntity.getPolicyEntity();
					policyDTO.setControlNumber(policyEntity.getControlNumber());
					policyDTO.setPolicyId(policyEntity.getPolicyId());
					policyDTO.setDescription(policyEntity.getDescription());
					policyDTO.setPolicyName(policyEntity.getPolicyName());
					policyDTO.setPolicyVal(policyEntity.getPolicyVal());
					policyDTO.setPriority(policyEntity.getPriority());
					policyDTO.setProcedures(policyEntity.getProcedures());
					policyDTO.setGuidelines(policyEntity.getGuidelines());
					policyDTO.setPolicyGrpId(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
					policyDTO.setClassType(policyEntity.getClassType());
					policyDTO.setFamilyName(policyEntity.getFamilyName());
					policyDTO.setComments(policyReviewerCommentsEntity.getComments());
					policyDTOs.add(policyDTO);
				}
				policyReviewDTO.setPolicyDTOs(policyDTOs);
				policyReviewDTO.setPolicyReview(policyReviewEntity.getPolicyReview());
				policyReviewDTO.setDefinitiveSourceName(
						policyReviewEntity.getPolicyGrpEntity().getAuditTypeEntity().getAuditTypeName());
				policyReviewDTO.setPolicyGrpName(policyReviewEntity.getPolicyGrpEntity().getPolicyGrpName());
				policyReviewDTO.setStatus(policyReviewEntity.getStatus());
				policyReviewDTO.setComments(policyReviewEntity.getComments());
				policyReviewDTO.setDueDate(policyReviewEntity.getDueDate());
				return policyReviewDTO;
			}
		}

	}

	@Override
	@Transactional
	public PolicyReviewDTO savePolicyReview(PolicyReviewDTO policyReviewDTO) {

		PolicyReviewEntity policyReviewEntity = policyDao.getPolicyReviewEntity(policyReviewDTO.getPolicyReview());
		policyReviewEntity.setComments(policyReviewDTO.getComments());
		policyReviewEntity.setStatus(policyReviewDTO.getStatus());
		List<PolicyDTO> policyDTOs = policyReviewDTO.getPolicyDTOs();
		policyReviewEntity.setUpdatedBy(policyReviewEntity.getAssignedTo());
		policyReviewEntity.setUpdatedTs(new Date());
		Set<PolicyReviewerCommentsEntity> policyReviewerCommentsEntities = policyReviewEntity
				.getPolicyReviewerCommentsEntities();
		for (PolicyDTO policyDTO : policyDTOs) {
			for (PolicyReviewerCommentsEntity policyReviewerCommentsEntity : policyReviewerCommentsEntities) {
				if (policyReviewerCommentsEntity.getPolicyEntity().getPolicyId().intValue() == policyDTO.getPolicyId()
						.intValue()) {
					System.out.println(policyReviewerCommentsEntity.getPolicyEntity().getPolicyId() + " "
							+ policyDTO.getPolicyId());
					policyReviewerCommentsEntity.setComments(policyDTO.getComments());
					/*
					 * policyReviewerCommentsEntity.setUpdatedBy(policyReviewEntity.getAssignedTo())
					 * ; policyReviewerCommentsEntity.setUpdatedTs(new Date());
					 */
					break;
				}
			}
		}

		policyReviewEntity = policyDao.updatePolicyReviewEntity(policyReviewEntity);
		return policyReviewDTO;
	}

	@Override
	@Transactional
	public PolicyReviewDTO getPolicyReviewDetails(Integer reviewId) {
		PolicyReviewEntity policyReviewEntity = policyDao.getPolicyReviewEntity(reviewId);
		PolicyDTO policyDTO = null;
		PolicyReviewDTO policyReviewDTO = null;
		PolicyEntity policyEntity = null;
		List<PolicyDTO> policyDTOs = new ArrayList<>();
		if (policyReviewEntity != null) {
			policyReviewDTO = new PolicyReviewDTO();
			Set<PolicyReviewerCommentsEntity> policyReviewerCommentsEntities = policyReviewEntity
					.getPolicyReviewerCommentsEntities();

			for (PolicyReviewerCommentsEntity policyReviewerCommentsEntity : policyReviewerCommentsEntities) {
				policyDTO = new PolicyDTO();
				policyEntity = policyReviewerCommentsEntity.getPolicyEntity();
				policyDTO.setControlNumber(policyEntity.getControlNumber());
				policyDTO.setPolicyId(policyEntity.getPolicyId());
				policyDTO.setDescription(policyEntity.getDescription());
				policyDTO.setPolicyName(policyEntity.getPolicyName());
				policyDTO.setPolicyVal(policyEntity.getPolicyVal());
				policyDTO.setPriority(policyEntity.getPriority());
				policyDTO.setProcedures(policyEntity.getProcedures());
				policyDTO.setGuidelines(policyEntity.getGuidelines());
				policyDTO.setPolicyGrpId(policyEntity.getPolicyGrpEntity().getPolicyGrpId());
				policyDTO.setClassType(policyEntity.getClassType());
				policyDTO.setFamilyName(policyEntity.getFamilyName());
				policyDTO.setComments(policyReviewerCommentsEntity.getComments());
				policyDTOs.add(policyDTO);
			}
			policyReviewDTO.setPolicyDTOs(policyDTOs);
			policyReviewDTO.setPolicyReview(policyReviewEntity.getPolicyReview());
			policyReviewDTO.setDefinitiveSourceName(
					policyReviewEntity.getPolicyGrpEntity().getAuditTypeEntity().getAuditTypeName());
			policyReviewDTO.setPolicyGrpName(policyReviewEntity.getPolicyGrpEntity().getPolicyGrpName());
			policyReviewDTO.setStatus(policyReviewEntity.getStatus());
			policyReviewDTO.setComments(policyReviewEntity.getComments());
			policyReviewDTO.setDueDate(policyReviewEntity.getDueDate());
			return policyReviewDTO;
		}
		return null;
	}

	@Override
	@Transactional
	public PolicyResponse uploadPolicyDocuments(List<PolicyDocumentsDTO> polDocuments) {
		PolicyResponse policyResponse = new PolicyResponse();
		String filePath = null;
		PolicyGrpEntity policyGrpEntity = null;
		int polGrpId = 0;
		Set<PolicyDocumentsEntity> policyDocEntities = new HashSet<>(0);
		PolicyDocumentsEntity policyDocumentsEntity = null;
		for (PolicyDocumentsDTO polDoc : polDocuments) {
			polGrpId = polDoc.getPolicyGrpId();
			policyGrpEntity = policyDao.getPolicyGRPEntity(polDoc.getPolicyGrpId());
			if (polDoc.getPolicyDocId() == null) {

				filePath = environment.getRequiredProperty("AAMLocation") + "policy/" + polDoc.getPolicyGrpId();
				policyDocumentsEntity = new PolicyDocumentsEntity();
				byte content[] = Base64.getDecoder().decode(polDoc.getFileContent().split("base64,")[1]);
				try {
					APMMailUtility.createFile(
							environment.getRequiredProperty("AAMLocation") + "policy/" + polDoc.getPolicyGrpId(),
							polDoc.getDocumentName(), content);
				} catch (IllegalStateException | APMException e) {
					e.printStackTrace();
				}
				filePath = filePath + "/" + polDoc.getDocumentName();
				policyDocumentsEntity.setActiveFlag(true);
				policyDocumentsEntity.setCreatedBy(polDoc.getCreatedBy());
				policyDocumentsEntity.setPolicyGrpEntity(policyGrpEntity);
				policyDocumentsEntity.setDocumentPath(filePath);
				policyDocumentsEntity.setDocumentName(polDoc.getDocumentName());
				policyDocumentsEntity.setCreatedTs(new Date());
				policyDao.savePolicyDocumentsEntity(policyDocumentsEntity);
			} else {
				for (PolicyDocumentsEntity policyDocEntity2 : policyGrpEntity.getPolicyDocumentsEntities()) {
					if (policyDocEntity2.getPolicyDocId() == polDoc.getPolicyDocId()
							&& policyDocEntity2.getActiveFlag()) {
						policyDocEntity2.setActiveFlag(polDoc.isActiveFlag());
						policyDocEntity2.setUpdatedBy(polDoc.getUpdatedBy());
						policyDocEntity2.setUpdatedTs(new Date());
						// policyDocEntities.add(policyDocEntity2);
						policyDao.savePolicyDocumentsEntity(policyDocEntity2);
					}
				}

			}
		}

		// policyDocumentsEntity =
		// policyDao.savePolicyDocumentsEntity(policyDocEntities);
		policyResponse.setPolicyDocumentsDTOs(getPolicyDocuments(polGrpId));
		return policyResponse;

	}

	@Override
	@Transactional
	public List<PolicyDocumentsDTO> getPolicyDocuments(Integer policyGrpId) {
		PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyGrpId);

		if (!policyGrpEntity.getPolicyDocumentsEntities().isEmpty()) {
			List<PolicyDocumentsDTO> policyDocumentsDTOs = new ArrayList<>();
			PolicyDocumentsDTO policyDocumentsDTO = null;
			Set<PolicyDocumentsEntity> policyDocumentsEntities = policyGrpEntity.getPolicyDocumentsEntities();

			for (PolicyDocumentsEntity policyDocumentsEntity : policyDocumentsEntities) {
				if (policyDocumentsEntity.getActiveFlag()) {
					policyDocumentsDTO = new PolicyDocumentsDTO();
					policyDocumentsDTO.setPolicyDocumentsTblId(policyDocumentsEntity.getPolicyDocId());
					policyDocumentsDTO.setDocumentName(policyDocumentsEntity.getDocumentName());
					policyDocumentsDTO.setActiveFlag(policyDocumentsEntity.getActiveFlag());
					policyDocumentsDTO.setPolicyGrpId(policyGrpId);
					policyDocumentsDTOs.add(policyDocumentsDTO);
				}
			}
			return policyDocumentsDTOs;
		}
		return null;
	}

	@Override
	@Transactional
	public String getPolicyDocument(Integer id) {
		PolicyDocumentsEntity policyDocumentsEntity = policyDao.getPolicyDocumentEntity(id);
		return policyDocumentsEntity.getDocumentPath();
	}

	@Override
	@Transactional
	public PolicyGrpDTO getPolicyGroupDTO(Integer policyGrpId) {
		PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyGrpId);

		PolicyGrpDTO policyGrpDTO = new PolicyGrpDTO();
		policyGrpDTO.setPolicyGrpId(policyGrpEntity.getPolicyGrpId());
		policyGrpDTO.setPolicyGrpName(policyGrpEntity.getPolicyGrpName());
		policyGrpDTO.setDefinitiveSource(policyGrpEntity.getAuditTypeEntity().getAuditTypeName());
		policyGrpDTO.setDescription(policyGrpEntity.getDescription());
		policyGrpDTO.setUpdatedBy(policyGrpEntity.getUpdatedBy());
		policyGrpDTO.setUpdatedTs(policyGrpEntity.getUpdatedTs());
		policyGrpDTO.setOwner(policyGrpEntity.getOwner());
		policyGrpDTO.setStatus(policyGrpEntity.getStatus());
		if (policyGrpEntity.getPolicyReviewTermEntity() != null) {
			policyGrpDTO.setPolicyReviewTerm(policyGrpEntity.getPolicyReviewTermEntity().getPolicyReviewTerm());
			policyGrpDTO.setPolicyReviewTermId(policyGrpEntity.getPolicyReviewTermEntity().getPolicyReviewTermId());
		}
		policyGrpDTO.setPolicyReviewDate(policyGrpEntity.getPolicyReviewDate());
		policyGrpDTO.setLastReviewDate(policyGrpEntity.getLastReviewDate());
		policyGrpDTO.setResourceLinks(policyGrpEntity.getResourceLinks());
		return policyGrpDTO;
	}

	@Override
	@Transactional
	public List<PolicyReviewTermDTO> getPolicyReviewTerms() {
		List<PolicyReviewTermEntity> policyReviewTermEntities = policyDao.getPolicyReviewTermEntities();
		List<PolicyReviewTermDTO> policyReviewTermDTOs = new ArrayList<>();
		PolicyReviewTermDTO policyReviewTermDTO = null;
		for (PolicyReviewTermEntity policyReviewTermEntity : policyReviewTermEntities) {
			policyReviewTermDTO = new PolicyReviewTermDTO();
			policyReviewTermDTO.setPolicyReviewTermId(policyReviewTermEntity.getPolicyReviewTermId());
			policyReviewTermDTO.setPolicyReviewTerm(policyReviewTermEntity.getPolicyReviewTerm());
			policyReviewTermDTOs.add(policyReviewTermDTO);
		}
		return policyReviewTermDTOs;
	}

	@Override
	@Transactional
	public List<ApplicationDTO> getAppsOnPolicyGrp(Integer policyGrpId) {
		PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(policyGrpId);
		List<AppAuditEntity> applicationAuditEntities = policyGrpEntity.getAppAuditEntities();
		ApplicationEntity applicationEntity;
		List<ApplicationDTO> applicationDTOs = new ArrayList<>();
		ApplicationDTO applicationDTO = null;
		for (AppAuditEntity appAuditEntity : applicationAuditEntities) {
			applicationEntity = appAuditEntity.getApplicationEntity();
			applicationDTO = new ApplicationDTO();
			applicationDTO.setAcronym(applicationEntity.getAcronym());
			applicationDTO.setName(applicationEntity.getName());
			applicationDTO.setApplicationId(applicationEntity.getApplicationId());
			if (applicationEntity.getAppProjectManagerEntities() != null
					&& !applicationEntity.getAppProjectManagerEntities().isEmpty()) {
				Set<AppProjectManagerEntity> appProjectManagerEntities = applicationEntity
						.getAppProjectManagerEntities();
				StringBuffer names = new StringBuffer();
				for (AppProjectManagerEntity appProjectManagerEntity : appProjectManagerEntities) {
					if (names.length() > 0)
						names.append(",");
					names.append(appProjectManagerEntity.getUserEntity().getFirstName() + " "
							+ appProjectManagerEntity.getUserEntity().getLastName());
				}
				applicationDTO.setProjectManagerName(names.toString());
			}
			if (applicationEntity.getAppBusinessOwnerEntities() != null
					&& !applicationEntity.getAppBusinessOwnerEntities().isEmpty()) {
				Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity.getAppBusinessOwnerEntities();
				StringBuffer names = new StringBuffer();
				for (AppBusinessOwnerEntity appBusinessOwnerEntity : appBusinessOwnerEntities) {
					if (names.length() > 0)
						names.append(",");
					names.append(appBusinessOwnerEntity.getUserEntity().getFirstName() + " "
							+ appBusinessOwnerEntity.getUserEntity().getLastName());
				}
				applicationDTO.setBusinessOwnerName(names.toString());
			}
			applicationDTOs.add(applicationDTO);
		}
		return applicationDTOs;
	}

	private boolean createPolicyDocFile(MultipartFile mouFile, String fodlerPath) {
		// data:application/vnd. xmlformats-officedocument.wordprocessingml.document;base64,

		File folder = new File(fodlerPath);

		if (!folder.exists()) {
			folder.mkdir();
		}
		folder = new File(fodlerPath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		fodlerPath = fodlerPath + "/" + mouFile.getOriginalFilename();
		File inputFile = new File(fodlerPath);
		inputFile = new File(fodlerPath);

		try {
			mouFile.transferTo(inputFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			inputFile = null;
		}
		return true;
	}

}
