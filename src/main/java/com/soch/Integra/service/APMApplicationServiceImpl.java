package com.soch.Integra.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
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
import com.soch.Integra.dao.ReportDAO;
import com.soch.Integra.dao.SolutionsDAO;
import com.soch.Integra.dao.UserDao;
import com.soch.Integra.dao.VendorDao;
import com.soch.Integra.dto.ALLReportDTO;
import com.soch.Integra.dto.AppAuditDTO;
import com.soch.Integra.dto.AppAuditFileDTO;
import com.soch.Integra.dto.AppCount;
import com.soch.Integra.dto.AppDisp;
import com.soch.Integra.dto.ApplDocDTO;
import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.ApplicationDatabaseDTO;
import com.soch.Integra.dto.ApplicationResp;
import com.soch.Integra.dto.ApplicationServerDTO;
import com.soch.Integra.dto.ApplicationUserDTO;
import com.soch.Integra.dto.ApplicationViewDTO;
import com.soch.Integra.dto.AssessmentDTO;
import com.soch.Integra.dto.AssessmentFileDTO;
import com.soch.Integra.dto.AssessmentPolicyDTO;
import com.soch.Integra.dto.AttachmentDTO;
import com.soch.Integra.dto.AuditDashBoardDTO;
import com.soch.Integra.dto.AuditPolicyDTO;
import com.soch.Integra.dto.AuditTypeDTO;
import com.soch.Integra.dto.AuditTypeDashBoardDTO;
import com.soch.Integra.dto.CostDTO;
import com.soch.Integra.dto.DatabaseDTO;
import com.soch.Integra.dto.DivisionDTO;
import com.soch.Integra.dto.FiscalYearInfoDTO;
import com.soch.Integra.dto.MOUDTO;
import com.soch.Integra.dto.MOUDocDTO;
import com.soch.Integra.dto.OfficeDTO;
import com.soch.Integra.dto.PolicyDTO;
import com.soch.Integra.dto.ReportDTO;
import com.soch.Integra.dto.ReportDTO2;
import com.soch.Integra.dto.ServerContactDTO;
import com.soch.Integra.dto.ServerDTO;
import com.soch.Integra.dto.StatusDTO;
import com.soch.Integra.dto.SystemSensitivityDTO;
import com.soch.Integra.dto.TechnologiesDTO;
import com.soch.Integra.dto.VendorAddressDTO;
import com.soch.Integra.dto.VendorContactDTO;
import com.soch.Integra.dto.VendorsDTO;
import com.soch.Integra.dto.WorkHoursDTO;
import com.soch.Integra.entities.AppAuditEntity;
import com.soch.Integra.entities.AppAuditFileEntity;
import com.soch.Integra.entities.AppAuditPolicyEntity;
import com.soch.Integra.entities.AppBusinessAnalystEntity;
import com.soch.Integra.entities.AppBusinessOwnerEntity;
import com.soch.Integra.entities.AppDataCustodianEntity;
import com.soch.Integra.entities.AppDataOwnerEntity;
import com.soch.Integra.entities.AppDbAdminEntity;
import com.soch.Integra.entities.AppDevelopersEntity;
import com.soch.Integra.entities.AppIsoEntity;
import com.soch.Integra.entities.AppProjectManagerEntity;
import com.soch.Integra.entities.AppStatusEntity;
import com.soch.Integra.entities.AppSystemAdminEntity;
import com.soch.Integra.entities.AppSystemOwnerEntity;
import com.soch.Integra.entities.AppTechnicalManagerEntity;
import com.soch.Integra.entities.AppTesterEntity;
import com.soch.Integra.entities.ApplDocEntity;
import com.soch.Integra.entities.ApplicationAuditEntity;
import com.soch.Integra.entities.ApplicationDatabaseEntity;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.ApplicationServerEntity;
import com.soch.Integra.entities.ApplicationTechnologyEntity;
import com.soch.Integra.entities.AssessmentEntity;
import com.soch.Integra.entities.AssessmentFileEntity;
import com.soch.Integra.entities.AssessmentPolicyEntity;
import com.soch.Integra.entities.AuditEntity;
import com.soch.Integra.entities.AuditTypeEntity;
import com.soch.Integra.entities.CertDocEntity;
import com.soch.Integra.entities.CostEntity;
import com.soch.Integra.entities.DatabaseEntity;
import com.soch.Integra.entities.DeviceDocEntity;
import com.soch.Integra.entities.DivisionEntity;
import com.soch.Integra.entities.FiscalYearInfoEntity;
import com.soch.Integra.entities.LabVendorEntity;
import com.soch.Integra.entities.MOUDocEntity;
import com.soch.Integra.entities.MOUEntity;
import com.soch.Integra.entities.OfficeEntity;
import com.soch.Integra.entities.PolicyDocumentsEntity;
import com.soch.Integra.entities.PolicyEntity;
import com.soch.Integra.entities.PolicyGrpEntity;
import com.soch.Integra.entities.ServerContactEntity;
import com.soch.Integra.entities.ServerEntity;
import com.soch.Integra.entities.SolutionTypeEntity;
import com.soch.Integra.entities.SolutionsEntity;
import com.soch.Integra.entities.StatusEntity;
import com.soch.Integra.entities.SystemSensitivityEntity;
import com.soch.Integra.entities.SystemTypeEntity;
import com.soch.Integra.entities.TechnologiesEntity;
import com.soch.Integra.entities.UserAppRoleEntity;
import com.soch.Integra.entities.UserEntity;
import com.soch.Integra.entities.VendorAddressEntity;
import com.soch.Integra.entities.VendorContactEntity;
import com.soch.Integra.entities.VendorsEntity;
import com.soch.Integra.entities.WorkHoursEntity;
import com.soch.Integra.exception.APMException;
import com.soch.Integra.utils.APMMailUtility;
import com.soch.Integra.utils.APMUtils;
import com.soch.Integra.utils.ApplicationConstants;
import com.soch.Integra.vendors.dto.AppSolutionDevicesDTO;
import com.soch.Integra.vendors.dto.CertDocDTO;
//import com.soch.Integra.utils.ApplicationConstatns;
import com.soch.Integra.vendors.dto.SolutionTypeDTO;
import com.soch.Integra.vendors.dto.SolutionsDTO;
import com.soch.Integra.vendors.dto.SystemTypeDTO;

@Service
public class APMApplicationServiceImpl implements APMApplicationService {

	private static final long serialVersionUID = 1L;

	@Autowired
	UserDao userDao;

	@Autowired
	MessageSource messageSource;

	@Autowired
	ApplicationDao applicationDao;

	@Autowired
	ReportDAO reportDAO;

	@Autowired
	PolicyServices policyServices;

	@Autowired
	ElectionServices electionServices;

	@Autowired
	PolicyDao policyDao;

	@Autowired
	VendorDao vendorDao;

	@Autowired
	SolutionsDAO solutionsDAO;

	@Autowired
	private Environment environment;

	@Override
	@Transactional
	public void signIn(String userID) {
		UserEntity userEntity = userDao.getUser(userID);
	}

	@Override
	@Transactional
	public ApplicationDTO getApplicationInfo(String acronym) {

		ApplicationEntity applicationEntity = applicationDao.getAcronym(acronym);
		ApplicationDTO applicationDTO = null;

		Set<Integer> sectionSet = new HashSet<Integer>(0);
		if (applicationEntity != null) {
			applicationDTO = new ApplicationDTO();
			applicationDTO.setAcronym(applicationEntity.getAcronym());
			applicationDTO.setName(applicationEntity.getName());
			applicationDTO.setBusinessOwnerNameDoe(applicationEntity.getBusinessOwnerNameDoe());
			applicationDTO.setSystemOwnerNameDoe(applicationEntity.getSystemOwnerNameDoe());
			if (applicationEntity.getDescription() != null)
				applicationDTO.setDescription(new String(applicationEntity.getDescription()));

			Set<AppStatusEntity> appStatusEntities = applicationEntity.getAppStatusEntities();
			int status = 0;
			for (AppStatusEntity appStatusEntity : appStatusEntities) {

				status = appStatusEntity.getUpdatedSection();
			}
			sectionSet.add(status);
			applicationDTO.setSections(sectionSet);

		}

		return applicationDTO;

	}

	@Override
	@Transactional
	public Set<DivisionDTO> getDivisions() {
		Set<DivisionDTO> divisionDTOs = new HashSet<>(0);
		DivisionDTO divisionDTO = null;
		List<DivisionEntity> divisionEntities = applicationDao.getDivisions();

		for (DivisionEntity divisionEntity : divisionEntities) {
			divisionDTO = new DivisionDTO();
			divisionDTO.setDivisionName(divisionEntity.getDivisionName());
			divisionDTO.setId(divisionEntity.getId());
			divisionDTOs.add(divisionDTO);
		}
		return divisionDTOs;
	}

	@Override
	@Transactional
	public Set<OfficeDTO> getOffices() {
		List<OfficeEntity> officeEntities = applicationDao.getOffices();
		Set<OfficeDTO> officeDTOs = new HashSet<>(0);
		OfficeDTO officeDTO = null;
		try {
			BeanUtils.copyProperties(officeDTOs, officeEntities);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		for (OfficeEntity officeEntity : officeEntities) {
			officeDTO = new OfficeDTO();
			if (officeEntity.getAcronym() != null)
				officeDTO.setAcronym(officeEntity.getAcronym());
			officeDTO.setDescription(officeEntity.getDescription());
			officeDTO.setId(officeEntity.getOfficeId());
			officeDTO.setDivisionId(officeEntity.getDivisionEntity().getId());
			officeDTOs.add(officeDTO);
		}
		return officeDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getDataOwner() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Data Owner")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getDbAdmin() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("DB Administrator")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getProjectManager() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Project Manager")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getSystemAdministrator() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("System Administrator")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getTechProjectManager() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("TechProject Manager")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getISO() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("ISO")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getDevelopers() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Developer")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getTesters() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Tester")) {

				userDTO = new ApplicationUserDTO();

				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getSystem_Site_Data_Owner() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("System Owner")) {

				userDTO = new ApplicationUserDTO();
				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getBusiness_Owner() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Business Owner")) {

				userDTO = new ApplicationUserDTO();
				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getDataCustodian() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Data Custodian")) {

				userDTO = new ApplicationUserDTO();
				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getBusinessAnalyst() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			if (userEntity.getUserAppRoleEntity() != null
					&& userEntity.getUserAppRoleEntity().getName().equalsIgnoreCase("Business Analyst")) {

				userDTO = new ApplicationUserDTO();
				userDTO.setFirstName(userEntity.getFirstName());
				userDTO.setLastName(userEntity.getLastName());
				userDTO.setTitle(userEntity.getTitle());
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
				userDTOs.add(userDTO);
			}

		}
		return userDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getUsers() {
		List<UserEntity> userEntities = applicationDao.getUsers();
		Set<ApplicationUserDTO> userDTOs = new HashSet<>(0);
		ApplicationUserDTO userDTO = null;

		for (UserEntity userEntity : userEntities) {
			userDTO = new ApplicationUserDTO();
			userDTO.setFirstName(userEntity.getFirstName());
			userDTO.setLastName(userEntity.getLastName());
			userDTO.setTitle(userEntity.getTitle());
			userDTO.setUserId(userEntity.getUserId());
			userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
			userDTOs.add(userDTO);

		}
		return userDTOs;
	}

	//// check

	@Override
	@Transactional
	public Set<FiscalYearInfoDTO> getFiscalYearInfo() {
		List<FiscalYearInfoEntity> fiscalYearInfoEntities = applicationDao.getFiscalYear();
		Set<FiscalYearInfoDTO> fiscalYearInfoDTOs = new HashSet<>(0);
		FiscalYearInfoDTO fiscalYearInfoDTO = null;
		try {
			BeanUtils.copyProperties(fiscalYearInfoDTOs, fiscalYearInfoEntities);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		for (FiscalYearInfoEntity fiscalYearInfoEntity : fiscalYearInfoEntities) {
			fiscalYearInfoDTO = new FiscalYearInfoDTO();
			fiscalYearInfoDTO.setFyNumber(fiscalYearInfoEntity.getFyNumber());
			fiscalYearInfoDTO.setFyMoaTerm(fiscalYearInfoEntity.getFyMoaTerm());
			fiscalYearInfoDTO.setFyContent(fiscalYearInfoEntity.getFyContent());
			fiscalYearInfoDTO.setFyId(fiscalYearInfoEntity.getFyId());
			fiscalYearInfoDTOs.add(fiscalYearInfoDTO);
		}
		return fiscalYearInfoDTOs;
	}

	///////// check
	@Override
	@Transactional
	public Set<StatusDTO> getStatus() {
		Set<StatusDTO> statusDTOs = new HashSet<>(0);
		StatusDTO statusDTO = null;
		List<StatusEntity> statusEntities = applicationDao.getStatus();

		for (StatusEntity statusEntity : statusEntities) {
			statusDTO = new StatusDTO();
			statusDTO.setName(statusEntity.getName());
			statusDTO.setStatusId(statusEntity.getStatusId());
			statusDTOs.add(statusDTO);
		}
		return statusDTOs;
	}

	@Override

	@Transactional

	public ApplicationDTO saveApplicationInfo(ApplicationDTO applicationDTO, MultipartFile[] files) {
		ApplicationEntity applicationEntity = null;
		FiscalYearInfoEntity fiscalYearInfoEntity = null;
		ApplDocEntity applicationDocEntity = null;
		Set<ApplDocEntity> applDocEntities = new HashSet<ApplDocEntity>(0);
		AppDevelopersEntity appDevelopersEntity = null;
		List<FiscalYearInfoEntity> fiscalYearInfoEntities = null;
		UserEntity projectManager = null;
		UserEntity businessOwner = null;
		UserEntity iso = null;
		AppStatusEntity appStatusEntity = new AppStatusEntity();
		Set<AppStatusEntity> appStatusEntities = new HashSet<AppStatusEntity>(0);
		if (applicationDTO != null)
			applicationEntity = new ApplicationEntity();

		UserEntity createdByserEntity = applicationDao.getUserById(applicationDTO.getUserId());

		applicationEntity.setAcronym(applicationDTO.getAcronym());
		applicationEntity.setName(applicationDTO.getName());
		applicationEntity.setOfficeEntity(applicationDao.getofficebyId(applicationDTO.getOffice()));
		applicationEntity.setDivisionEntity(applicationDao.getdivisionbyId(applicationDTO.getDivision()));
		applicationEntity.setuserEntityByDataOwner(applicationDao.getUserById(applicationDTO.getDataOwner()));
		applicationEntity.setuserEntityBySystemOwner(applicationDao.getUserById(applicationDTO.getSystemOwner()));
		applicationEntity.setStatusEntity(applicationDao.getStatusById(applicationDTO.getStatus()));

		applicationEntity.setLocalityCd(applicationDTO.getLocalityCd());
		applicationEntity.setFipsCd(applicationDTO.getFipsCd());
		applicationEntity.setFirstName(applicationDTO.getFirstName());
		applicationEntity.setLastName(applicationDTO.getLastName());
		applicationEntity.setEmailId(applicationDTO.getEmailId());
		applicationEntity.setPhoneNumber(applicationDTO.getPhoneNumber());
		applicationEntity.setWebsite(applicationDTO.getWebsite());
		applicationEntity.setVerisId(applicationDTO.getVerisId());
		applicationEntity.setCapInd(applicationDTO.isCapInd());
		applicationEntity.setBailoutInd(applicationDTO.isBailoutInd());
		applicationEntity.setPenality(applicationDTO.getPenality());
		applicationEntity.setVebaRegion(applicationDTO.isVebaRegion());
		applicationEntity.setVravRegion(applicationDTO.isVravRegion());
		applicationEntity.setPaperPollbook(applicationDTO.isPaperPollbook());
		applicationEntity.setElectronicPollbook(applicationDTO.isElectronicPollbook());
		applicationEntity.setNotes(applicationDTO.getNotes());
		applicationEntity.setBusinessOwnerNameDoe(applicationDTO.getBusinessOwnerNameDoe());
		applicationEntity.setSystemOwnerNameDoe(applicationDTO.getSystemOwnerNameDoe());
		applicationEntity.setActiveLocality(applicationDTO.getActiveLocality());

		if (applicationDTO.getDescription() != null)
			applicationEntity.setDescription(applicationDTO.getDescription().getBytes());

		if (applicationDTO.getWorkHoursDTOs() != null && !applicationDTO.getWorkHoursDTOs().isEmpty()) {
			Set<WorkHoursEntity> workHoursEntities = new HashSet<>();
			WorkHoursEntity workHoursEntity = null;
			for (WorkHoursDTO workHoursDTO : applicationDTO.getWorkHoursDTOs()) {
				workHoursEntity = new WorkHoursEntity();
				workHoursEntity.setApplicationEntity(applicationEntity);
				workHoursEntity.setCloseTm(workHoursDTO.getCloseTm());
				workHoursEntity.setOpenTm(workHoursDTO.getOpenTm());
				workHoursEntity.setCreatedTs(new Date());
				workHoursEntity.setUpdatedTs(new Date());
				workHoursEntity.setDay(workHoursDTO.getDay());
				if (createdByserEntity != null) {
					workHoursEntity
							.setCreatedBy(createdByserEntity.getFirstName() + " " + createdByserEntity.getLastName());
					workHoursEntity
							.setUpdatedBy(createdByserEntity.getFirstName() + " " + createdByserEntity.getLastName());
				}
				workHoursEntities.add(workHoursEntity);
			}
			applicationEntity.setWorkHoursEntities(workHoursEntities);
		}

		// Create Fiscal Year
		if (applicationDTO.getFiscalYear1() != 0) {
			fiscalYearInfoEntities = new ArrayList<FiscalYearInfoEntity>();
			fiscalYearInfoEntity = new FiscalYearInfoEntity();
			fiscalYearInfoEntity.setActivityFlag(true);
			fiscalYearInfoEntity.setApplicationEntity(applicationEntity);
			fiscalYearInfoEntity.setFyNumber(applicationDTO.getFiscalYear1());
			fiscalYearInfoEntity.setFyContent(applicationDTO.getBoVision1());
			fiscalYearInfoEntity.setCreatedTs(new Date());
			fiscalYearInfoEntities.add(fiscalYearInfoEntity);
			fiscalYearInfoEntity = new FiscalYearInfoEntity();
			fiscalYearInfoEntity.setActivityFlag(true);
			fiscalYearInfoEntity.setApplicationEntity(applicationEntity);
			fiscalYearInfoEntity.setFyNumber(applicationDTO.getFiscalYear2());
			fiscalYearInfoEntity.setFyContent(applicationDTO.getBoVision2());
			fiscalYearInfoEntity.setCreatedTs(new Date());
			fiscalYearInfoEntities.add(fiscalYearInfoEntity);
			fiscalYearInfoEntity = new FiscalYearInfoEntity();
			fiscalYearInfoEntity.setActivityFlag(true);
			fiscalYearInfoEntity.setApplicationEntity(applicationEntity);
			fiscalYearInfoEntity.setFyNumber(applicationDTO.getFiscalYear3());
			fiscalYearInfoEntity.setFyContent(applicationDTO.getBoVision3());
			fiscalYearInfoEntity.setCreatedTs(new Date());
			fiscalYearInfoEntities.add(fiscalYearInfoEntity);
			applicationEntity.setFiscalYearInfoEntities(fiscalYearInfoEntities);
		}
		applicationEntity.setUpdatedTs(new Date());
		applicationEntity.setCreatedTs(new Date());
		applicationEntity.setUpdatedBy(applicationDTO.getCreatedBy());
		applicationEntity.setCreatedBy(applicationDTO.getCreatedBy());
		applicationEntity.setModifiedBy(applicationDTO.getCreatedBy());
		applicationEntity.setAppStatusEntities(appStatusEntities);

		List<AttachmentDTO> attachmentDTOs = applicationDTO.getAttachments();
		if (attachmentDTOs != null)
			for (AttachmentDTO attachmentDTO : attachmentDTOs) {
				applicationDocEntity = new ApplDocEntity();
				applicationDocEntity.setFileContent((attachmentDTO.getContent().split("base64,")[1]).getBytes());
				applicationDocEntity.setFileName(attachmentDTO.getFileName());
				if (attachmentDTO.getFileType().contains(ApplicationConstants.RISK_ATTACHMENT)) {
					applicationDocEntity.setFileType(ApplicationConstants.RISK_ATTACHMENT);
				} else if (attachmentDTO.getFileType().toUpperCase().contains(ApplicationConstants.AUDIT_ATTACHMENT)) {
					applicationDocEntity.setFileType(ApplicationConstants.AUDIT_ATTACHMENT);
				} else if (attachmentDTO.getFileType().toUpperCase()
						.contains(ApplicationConstants.BUSINESS_ATTACHMENT)) {
					applicationDocEntity.setFileType(ApplicationConstants.BUSINESS_ATTACHMENT);
				} else if (attachmentDTO.getFileType().contains(ApplicationConstants.WORKFLOW_ATTACHMENT)) {
					applicationDocEntity.setFileType(ApplicationConstants.WORKFLOW_ATTACHMENT);
				} else {
					applicationDocEntity.setFileType(ApplicationConstants.OTHER);
				}
				applicationDocEntity.setCreatedTs(new Date());
				applicationDocEntity.setUserEntity(createdByserEntity);
				applicationDocEntity.setApplicationEntity(applicationEntity);
				applDocEntities.add(applicationDocEntity);
			}
		applicationEntity.setApplDocEntities(applDocEntities);

		ApplicationDatabaseEntity applicationDatabaseEntity = null;
		UserEntity createbyUserEntity = applicationDao.getUserById(applicationDTO.getUserId());
		applicationEntity.setCreatedBy(applicationDTO.getUpdatedBy());
		if (applicationEntity != null) {
			if (applicationDTO.getPhysicalLocation() != null)
				applicationEntity.setPhysicalLocation(applicationDTO.getPhysicalLocation());
			if (applicationDTO.getItSystemInterfaces() != null)
				applicationEntity.setSystemInterfaces(applicationDTO.getItSystemInterfaces());
			if (applicationDTO.getiTSystemBoundary() != null)
				applicationEntity.setSystemBoundary(applicationDTO.getiTSystemBoundary());
			if (applicationDTO.getRisks() != null)
				applicationEntity.setRisks((applicationDTO.getRisks().getBytes()));

			if (applicationDTO.getTechnologyStatus() != null)
				applicationEntity.setTechnologyStatus(applicationDTO.getTechnologyStatus().getBytes());

			if (applicationDTO.getDatabase() != 0 && applicationDTO.getDatabase() > 0) {
				Set<ApplicationDatabaseEntity> applicationDatabaseEntities = new HashSet<ApplicationDatabaseEntity>(0);
				applicationDatabaseEntities = applicationEntity.getApplicationDatabaseEntities();
				applicationDatabaseEntity = new ApplicationDatabaseEntity();
				applicationDatabaseEntity.setDatabaseEntity(applicationDao.getDatabase(applicationDTO.getDatabase()));
				applicationDatabaseEntity.setApplicationEntity(applicationEntity);
				applicationDatabaseEntity.setActivityFlag(true);
				applicationDatabaseEntities.add(applicationDatabaseEntity);
				applicationEntity.setApplicationDatabaseEntities(applicationDatabaseEntities);
			}

			if (applicationDTO.getServer() != 0 && applicationDTO.getServer() > 0) {
				Set<ApplicationServerEntity> applicationServerEntities = new HashSet<ApplicationServerEntity>(0);
				ApplicationServerEntity applicationServerEntity = new ApplicationServerEntity();
				applicationServerEntity.setServerEntity(applicationDao.getServer(applicationDTO.getServer()));
				applicationServerEntity.setApplicationEntity(applicationEntity);
				applicationServerEntity.setActivityFlag(true);
				applicationServerEntities.add(applicationServerEntity);
				applicationEntity.setApplicationServerEntities(applicationServerEntities);
			}

			if (applicationDTO.getProgrammingLanguages() != null
					&& applicationDTO.getProgrammingLanguages().length > 0) {
				Set<ApplicationTechnologyEntity> applicationTechnologyEntities = new HashSet<ApplicationTechnologyEntity>(
						0);
				ApplicationTechnologyEntity applicationTechnologyEntity = null;
				int length = applicationDTO.getProgrammingLanguages().length;
				for (int i = 0; i < length; i++) {
					applicationTechnologyEntity = new ApplicationTechnologyEntity();
					applicationTechnologyEntity.setTechnologiesEntity(
							applicationDao.getTechnologyEntity(applicationDTO.getProgrammingLanguages()[i]));
					applicationTechnologyEntity.setApplicationEntity(applicationEntity);
					applicationTechnologyEntity.setActivityFlag(true);
					applicationTechnologyEntities.add(applicationTechnologyEntity);
				}
				applicationEntity.setApplicationTechnologyEntities(applicationTechnologyEntities);
			}

			if (applicationDTO.getTesters() != null && applicationDTO.getTesters().size() > 0) {
				Set<AppTesterEntity> applicationTesterEntities = new HashSet<AppTesterEntity>(0);
				List<ApplicationUserDTO> testers = applicationDTO.getTesters();
				AppTesterEntity applicationTesterEntity = null;
				for (ApplicationUserDTO applicationUserDTO : testers) {
					applicationTesterEntity = new AppTesterEntity();
					applicationTesterEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					applicationTesterEntity.setApplicationEntity(applicationEntity);
					applicationTesterEntity.setActivityFlag(true);
					applicationTesterEntities.add(applicationTesterEntity);
				}
				applicationEntity.setAppTesterEntities(applicationTesterEntities);
			}
			if (applicationDTO.getDevelopers() != null && !applicationDTO.getDevelopers().isEmpty()) {

				Set<AppDevelopersEntity> appDevelopersEntities = new HashSet<AppDevelopersEntity>();
				List<ApplicationUserDTO> developers = applicationDTO.getTesters();
				for (ApplicationUserDTO applicationUserDTO : developers) {
					appDevelopersEntity = new AppDevelopersEntity();
					appDevelopersEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appDevelopersEntity.setApplicationEntity(applicationEntity);
					appDevelopersEntity.setActivityFlag(true);
					appDevelopersEntities.add(appDevelopersEntity);
				}
				applicationEntity.setAppDevelopersEntities(appDevelopersEntities);
			}

			if (applicationDTO.getKeyDecision() != null)
				applicationEntity.setDecisions(applicationDTO.getKeyDecision());
			if (applicationDTO.getSystemSensitivity() != 0) {
				SystemSensitivityEntity systemSensitivityEntity = applicationDao
						.getSystemSensitivityById(applicationDTO.getSystemSensitivity());

				if (systemSensitivityEntity != null) {
					applicationEntity.setSystemSensitivityEntity(systemSensitivityEntity);
				}
			}

			if (applicationDTO.getCostType() != null && applicationDTO.getCost() != null) {
				Set<CostEntity> costEntities = new HashSet<>(0);
				CostEntity costEntity = new CostEntity();
				costEntity.setTypeName(applicationDTO.getCostType());
				costEntity.setTypeValue(applicationDTO.getCost());
				costEntity.setCreatedTs(new Date());
				costEntity.setCreatedBy(applicationDTO.getUpdatedBy());
				costEntity.setApplicationEntity(applicationEntity);
				costEntities.add(costEntity);
				applicationEntity.setCostEntities(costEntities);
			}

			if (applicationDTO.getRisks() != null) {
				applicationEntity.setRisks(applicationDTO.getRisks().getBytes());
			}
			if (applicationDTO.getConsideration() != null) {
				applicationEntity.setConsideration(applicationDTO.getConsideration().getBytes());
			}

			appStatusEntity.setApplicationEntity(applicationEntity);
			appStatusEntity.setUpdatedSection(applicationDTO.getSectionNumber());
			appStatusEntity.setCreatedTs(new Date());
			// appStatusEntity.setCreatedBy(userEntity);
			// appStatusEntity.setUpdatedBy(userEntity);
			appStatusEntity.setUpdatedTs(new Date());
			appStatusEntities.add(appStatusEntity);
			applicationEntity.setModifiedBy(applicationDTO.getCreatedBy());
			applicationEntity.setUpdatedBy(applicationDTO.getCreatedBy());
			applicationEntity.setCreatedBy(applicationDTO.getCreatedBy());
			applicationEntity.setAppStatusEntities(appStatusEntities);
			/*
			 * for (AttachmentDTO attachmentDTO : attachmentDTOs) {
			 * 
			 * applicationDocEntity = new ApplDocEntity();
			 * 
			 * applicationDocEntity.setFileContent((attachmentDTO.getContent().split(
			 * "base64,")[1]).getBytes());
			 * 
			 * applicationDocEntity.setFileName(attachmentDTO.getFileName());
			 * 
			 * applicationDocEntity.setFileType(attachmentDTO.getFileType());
			 * 
			 * applicationDocEntity.setCreatedTs(new Date());
			 * 
			 * applicationDocEntity.setUserEntity(createbyUserEntity);
			 * 
			 * applicationDocEntity.setApplicationEntity(applicationEntity);
			 * 
			 * applDocEntities.add(applicationDocEntity);
			 * 
			 * }
			 * 
			 * applicationEntity.setApplDocEntities(applDocEntities);
			 */

			if (applicationDTO.getLastAudit() != null) {
				Set<ApplicationAuditEntity> applicationAuditEntities = new HashSet<ApplicationAuditEntity>(0);
				ApplicationAuditEntity applicationAuditEntity = new ApplicationAuditEntity();
				AuditEntity auditEntity = new AuditEntity();
				auditEntity.setLastAudit(applicationDTO.getLastAudit());
				auditEntity.setUpComingAudit(applicationDTO.getUpcomingAudit());
				auditEntity.setComments(applicationDTO.getAuditComments());
				applicationAuditEntity.setAuditEntity(auditEntity);
				applicationAuditEntity.setApplicationEntity(applicationEntity);
				applicationAuditEntity.setActivityFlag(true);
				applicationAuditEntities.add(applicationAuditEntity);
				applicationEntity.setApplicationAuditEntities(applicationAuditEntities);
			}

			if (applicationDTO.getAppDBAdmins() != null && !applicationDTO.getAppDBAdmins().isEmpty()) {
				Set<AppDbAdminEntity> appDbAdminEntities = new HashSet<>();
				List<ApplicationUserDTO> appDBAdminDTOS = applicationDTO.getAppDBAdmins();
				AppDbAdminEntity appDbAdminEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appDBAdminDTOS) {
					appDbAdminEntity = new AppDbAdminEntity();
					appDbAdminEntity.setActiveFlag(true);
					appDbAdminEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appDbAdminEntity.setApplicationEntity(applicationEntity);
					appDbAdminEntities.add(appDbAdminEntity);
				}
				applicationEntity.setAppDbAdminEntities(appDbAdminEntities);
			}

			if (applicationDTO.getAppBusinessAnalysts() != null && !applicationDTO.getAppBusinessAnalysts().isEmpty()) {
				Set<AppBusinessAnalystEntity> appBusinessOwnerEntities = new HashSet<>();
				List<ApplicationUserDTO> appBusinessOwnsers = applicationDTO.getAppBusinessAnalysts();
				AppBusinessAnalystEntity appBusinessAnalystEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appBusinessOwnsers) {
					appBusinessAnalystEntity = new AppBusinessAnalystEntity();
					appBusinessAnalystEntity.setActiveFlag(true);
					appBusinessAnalystEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appBusinessAnalystEntity.setApplicationEntity(applicationEntity);
					appBusinessOwnerEntities.add(appBusinessAnalystEntity);
				}
				applicationEntity.setAppBusinessAnalystEntities(appBusinessOwnerEntities);
			}

			if (applicationDTO.getAppBusinessOwners() != null && !applicationDTO.getAppBusinessOwners().isEmpty()) {
				Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = new HashSet<>();
				List<ApplicationUserDTO> appBusinessOwnsers = applicationDTO.getAppBusinessOwners();
				AppBusinessOwnerEntity appBusinessOwnerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appBusinessOwnsers) {
					appBusinessOwnerEntity = new AppBusinessOwnerEntity();
					appBusinessOwnerEntity.setActiveFlag(true);
					appBusinessOwnerEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appBusinessOwnerEntity.setApplicationEntity(applicationEntity);
					appBusinessOwnerEntities.add(appBusinessOwnerEntity);
				}
				applicationEntity.setAppBusinessOwnerEntities(appBusinessOwnerEntities);
			}

			if (applicationDTO.getAppSystemAdminsters() != null && !applicationDTO.getAppSystemAdminsters().isEmpty()) {
				Set<AppSystemAdminEntity> appSystemAdminEntities = new HashSet<>();
				List<ApplicationUserDTO> appSystemAdminsters = applicationDTO.getAppSystemAdminsters();
				AppSystemAdminEntity appSystemAdminEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appSystemAdminsters) {
					appSystemAdminEntity = new AppSystemAdminEntity();
					appSystemAdminEntity.setActiveFlag(true);
					appSystemAdminEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appSystemAdminEntity.setApplicationEntity(applicationEntity);
					appSystemAdminEntities.add(appSystemAdminEntity);
				}
				applicationEntity.setAppSystemAdminEntities(appSystemAdminEntities);
			}

			if (applicationDTO.getAppProjectManagers() != null && !applicationDTO.getAppProjectManagers().isEmpty()) {
				Set<AppProjectManagerEntity> appProjectManagerEntities = new HashSet<>();
				List<ApplicationUserDTO> appProjectManagers = applicationDTO.getAppProjectManagers();
				AppProjectManagerEntity appSystemAdminEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appProjectManagers) {
					appSystemAdminEntity = new AppProjectManagerEntity();
					appSystemAdminEntity.setActiveFlag(true);
					appSystemAdminEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appSystemAdminEntity.setApplicationEntity(applicationEntity);
					appProjectManagerEntities.add(appSystemAdminEntity);
				}
				applicationEntity.setAppProjectManagerEntities(appProjectManagerEntities);
			}

			if (applicationDTO.getAppTechnicalManagers() != null
					&& !applicationDTO.getAppTechnicalManagers().isEmpty()) {
				Set<AppTechnicalManagerEntity> appTechnicalManagerEntities = new HashSet<>();
				List<ApplicationUserDTO> appTechnicalManagers = applicationDTO.getAppTechnicalManagers();
				AppTechnicalManagerEntity appTechnicalManagerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appTechnicalManagers) {
					appTechnicalManagerEntity = new AppTechnicalManagerEntity();
					appTechnicalManagerEntity.setActiveFlag(true);
					appTechnicalManagerEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appTechnicalManagerEntity.setApplicationEntity(applicationEntity);
					appTechnicalManagerEntities.add(appTechnicalManagerEntity);
				}
				applicationEntity.setApplicationTechnicalManagerEntities(appTechnicalManagerEntities);
			}

			if (applicationDTO.getAppSystemOwners() != null && !applicationDTO.getAppSystemOwners().isEmpty()) {
				Set<AppSystemOwnerEntity> appSystemOwnerEntities = new HashSet<>();
				List<ApplicationUserDTO> appSystemOwners = applicationDTO.getAppSystemOwners();
				AppSystemOwnerEntity appSystemOwnerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appSystemOwners) {
					appSystemOwnerEntity = new AppSystemOwnerEntity();
					appSystemOwnerEntity.setActiveFlag(true);
					appSystemOwnerEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appSystemOwnerEntity.setApplicationEntity(applicationEntity);
					appSystemOwnerEntities.add(appSystemOwnerEntity);
				}
				applicationEntity.setAppSystemOwnerEntities(appSystemOwnerEntities);
			}

			if (applicationDTO.getAppDataOwners() != null && !applicationDTO.getAppDataOwners().isEmpty()) {
				Set<AppDataOwnerEntity> appDataOwnerEntities = new HashSet<>();
				List<ApplicationUserDTO> appDataOwners = applicationDTO.getAppDataOwners();
				AppDataOwnerEntity appDataOwnerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appDataOwners) {
					appDataOwnerEntity = new AppDataOwnerEntity();
					appDataOwnerEntity.setActiveFlag(true);
					appDataOwnerEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appDataOwnerEntity.setApplicationEntity(applicationEntity);
					appDataOwnerEntities.add(appDataOwnerEntity);
				}
				applicationEntity.setAppDataOwnerEntities(appDataOwnerEntities);
			}

			if (applicationDTO.getAppISOs() != null && !applicationDTO.getAppISOs().isEmpty()) {
				Set<AppIsoEntity> appIsoEntities = new HashSet<>();
				List<ApplicationUserDTO> appISOs = applicationDTO.getAppISOs();
				AppIsoEntity appIsoEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appISOs) {
					appIsoEntity = new AppIsoEntity();
					appIsoEntity.setActiveFlag(true);
					appIsoEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appIsoEntity.setApplicationEntity(applicationEntity);
					appIsoEntities.add(appIsoEntity);
				}
				applicationEntity.setAppISoEntities(appIsoEntities);
			}

			if (applicationDTO.getAppDataCustodians() != null && !applicationDTO.getAppDataCustodians().isEmpty()) {
				Set<AppDataCustodianEntity> appDataCustodianEntities = new HashSet<>();
				List<ApplicationUserDTO> appISOs = applicationDTO.getAppDataCustodians();
				AppDataCustodianEntity appDataCustodianEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appISOs) {
					appDataCustodianEntity = new AppDataCustodianEntity();
					appDataCustodianEntity.setActiveFlag(true);
					appDataCustodianEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
					appDataCustodianEntity.setApplicationEntity(applicationEntity);
					appDataCustodianEntities.add(appDataCustodianEntity);
				}
				applicationEntity.setAppDataCustodianEntities(appDataCustodianEntities);
			}
		}

		ApplicationEntity applicationEntities = null;

		applicationEntities = applicationDao.saveApplication(applicationEntity);
		applicationDTO.setApplicationId(applicationEntities.getApplicationId());

		return applicationDTO;

	}

	@Override
	@Transactional
	public List<OfficeEntity> saveOfficesInfo(Set<OfficeDTO> officeDTO) {
		List<OfficeEntity> officeEntity = null;

		try {
			BeanUtils.copyProperties(officeEntity, officeDTO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		List<OfficeEntity> officeEntities = applicationDao.saveOffices(officeEntity);

		return officeEntities;

	}

	///// check

	@Override
	@Transactional
	public List<DivisionEntity> saveDivisionsInfo(Set<DivisionDTO> divisionDTO) {
		List<DivisionEntity> divisionEntity = null;

		try {
			BeanUtils.copyProperties(divisionEntity, divisionDTO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		List<DivisionEntity> divisionEntities = applicationDao.saveDivisions(divisionEntity);

		return divisionEntities;

	}

	/// check

	@Override
	@Transactional
	public List<FiscalYearInfoEntity> saveFiscalYearInfo(Set<FiscalYearInfoDTO> fiscalYearInfoDTO) {
		List<FiscalYearInfoEntity> fiscalYearInfoEntity = null;

		try {
			BeanUtils.copyProperties(fiscalYearInfoEntity, fiscalYearInfoDTO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		List<FiscalYearInfoEntity> fiscalYearInfoEntities = applicationDao.saveFiscalYear(fiscalYearInfoEntity);

		return fiscalYearInfoEntities;
	}

	@Override
	@Transactional
	public Set<DatabaseDTO> getDatabase() {
		Set<DatabaseDTO> databaseDTOs = new HashSet<>(0);
		DatabaseDTO databaseDTO = null;
		List<DatabaseEntity> databaseEntities = applicationDao.getDatabase();

		for (DatabaseEntity databaseEntity : databaseEntities) {
			databaseDTO = new DatabaseDTO();
			databaseDTO.setDbServer(databaseEntity.getDbServer());
			databaseDTO.setHostName(databaseEntity.getHostName());
			databaseDTO.setServerName(databaseEntity.getServerName());
			databaseDTO.setDatabaseId(databaseEntity.getDatabaseId());
			databaseDTO.setCreatedTs(databaseEntity.getCreatedTs());
			databaseDTO.setUpdatedTs(databaseEntity.getUpdatedTs());
			databaseDTO.setUpdatedBy(databaseEntity.getUpdatedBy());
			databaseDTO.setProductName(databaseEntity.getProductName());
			databaseDTO.setLicenseRenewDt(databaseEntity.getLicenseRenewDt());
			databaseDTOs.add(databaseDTO);
		}
		return databaseDTOs;
	}

	@Override
	@Transactional
	public Set<ServerDTO> getServer() {
		Set<ServerDTO> serverDTOs = new HashSet<>(0);
		ServerDTO serverDTO = null;
		List<ServerEntity> serverEntities = applicationDao.getServers();

		for (ServerEntity serverEntity : serverEntities) {
			serverDTO = new ServerDTO();
			serverDTO.setName(serverEntity.getName());
			serverDTO.setServerId(serverEntity.getServerId());
			serverDTO.setAddressLine1(serverEntity.getAddressLine1());
			serverDTO.setAddressLine2(serverEntity.getAddressLine2());
			serverDTO.setZipCode(serverEntity.getZipCode());
			serverDTO.setCity(serverEntity.getCity());
			serverDTOs.add(serverDTO);
		}
		return serverDTOs;
	}

	public static Comparator<TechnologiesDTO> TechNameComparator = new Comparator<TechnologiesDTO>() {

		public int compare(TechnologiesDTO t1, TechnologiesDTO t2) {
			String TechnologyName1 = t1.getName().toUpperCase();
			String TechnologyName2 = t2.getName().toUpperCase();

			return TechnologyName1.compareTo(TechnologyName2);

		}
	};

	@Override
	@Transactional
	public List<TechnologiesDTO> getTechnologies() {
		List<TechnologiesDTO> technologiesDTOs = new ArrayList<TechnologiesDTO>(0);
		TechnologiesDTO technologiesDTO = null;
		List<TechnologiesEntity> technologiesEntities = applicationDao.getTechnologies();

		for (TechnologiesEntity technologiesEntity : technologiesEntities) {
			technologiesDTO = new TechnologiesDTO();
			technologiesDTO.setName(technologiesEntity.getName());
			technologiesDTO.setTechnologyVersion(technologiesEntity.getTechnologyVersion());
			technologiesDTO.setTechnologyId(technologiesEntity.getTechnologyId());
			technologiesDTOs.add(technologiesDTO);
			Collections.sort(technologiesDTOs, TechNameComparator);
		}
		return technologiesDTOs;
	}

	@Override
	@Transactional
	public Set<ApplDocDTO> getApplDoc(int id) {
		Set<ApplDocDTO> applDocDTOs = new HashSet<ApplDocDTO>(0);
		ApplDocDTO applDocDTO = null;
		List<ApplDocEntity> applDocEntities = applicationDao.getApplDoc(id);

		for (ApplDocEntity applDocEntity : applDocEntities) {
			applDocDTO = new ApplDocDTO();
			applDocDTO.setFileName(applDocEntity.getFileName());
			/*
			 * if(applDocEntity.getFileContent() != null) applDocDTO.setFileContent(new
			 * String(applDocEntity.getFileContent()));
			 */
			applDocDTO.setFileType(applDocEntity.getFileType());
			applDocDTO.setFileLocation(applDocEntity.getFileLocation());
			applDocDTOs.add(applDocDTO);
		}
		return applDocDTOs;
	}

	@Override
	@Transactional
	public DatabaseDTO getDatabaseDetails(int id) {
		DatabaseEntity databaseEntity = applicationDao.getDatabase(id);
		DatabaseDTO databaseDTO = null;
		if (databaseEntity != null) {
			databaseDTO = new DatabaseDTO();
			/*
			 * databaseDTO.setDatabaseId(databaseEntity.getDatabaseId());
			 * databaseDTO.setDbServer(databaseEntity.getDbServer());
			 * databaseDTO.setHostName(databaseEntity.getHostName());
			 * databaseDTO.setServerName(databaseEntity.getServerName());
			 * databaseDTO.setDbVersion(databaseEntity.getDbVersion());
			 */
			databaseDTO.setDatabaseId(databaseEntity.getDatabaseId());
			// databaseDTO.setServerContactDTOs(databaseEntity.getServerContactEntities());

			Set<ServerContactEntity> serverContactEntities = databaseEntity.getServerContactEntities();
			Set<ServerContactDTO> serverContactDTOs = new HashSet<>();
			ServerContactDTO serverContactDTO = null;
			try {
				for (ServerContactEntity serverContactEntity : serverContactEntities) {
					serverContactDTO = new ServerContactDTO();
					BeanUtils.copyProperties(serverContactDTO, serverContactEntity);
					serverContactDTOs.add(serverContactDTO);
				}

				BeanUtils.copyProperties(databaseDTO, databaseEntity);
				databaseDTO.setServerContactDTOs(serverContactDTOs);
				return databaseDTO;
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}

		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public ApplicationViewDTO updateApplicationInfo(ApplicationViewDTO applicationDTO, MultipartFile[] files) {
		ApplicationEntity applicationEntity = null;
		AppStatusEntity appStatusEntity = new AppStatusEntity();
		Set<AppStatusEntity> appStatusEntities = new HashSet<AppStatusEntity>(0);
		ApplicationDatabaseEntity applicationDatabaseEntity = null;
		applicationEntity = applicationDao.getAcronym(applicationDTO.getAcronym());
		UserEntity createbyUserEntity = null;
		if (applicationDTO.getUserId() != null)
			createbyUserEntity = applicationDao.getUserById(applicationDTO.getUserId());
		if (applicationEntity != null) {
			applicationEntity.setName(applicationDTO.getName());
			if (applicationDTO.getDivision() != null)
				applicationEntity.setDivisionEntity(applicationDao.getdivisionbyId(applicationDTO.getDivision()));
			if (applicationDTO.getOffice() != null)
				applicationEntity.setOfficeEntity(applicationDao.getofficebyId(applicationDTO.getOffice()));
			if (applicationDTO.getDataOwner() != null)
				applicationEntity.setuserEntityByDataOwner(applicationDao.getUserById(applicationDTO.getDataOwner()));
			if (applicationDTO.getSystemOwner() != null)
				applicationEntity
						.setuserEntityBySystemOwner(applicationDao.getUserById(applicationDTO.getSystemOwner()));
			if (applicationDTO.getStatus() != null)
				applicationEntity.setStatusEntity(applicationDao.getStatusById(applicationDTO.getStatus()));
			applicationEntity.setLevelOfEffort(applicationDTO.getLevelOfEffort());
			applicationEntity.setModifiedBy(applicationDTO.getUpdatedBy());
			applicationEntity.setUpdatedTs(new Date());
			applicationEntity.setLevelOfEffort(applicationDTO.getLevelOfEffort());
			applicationEntity.setSecurityAssessments(applicationDTO.getSecurityAssessments());
			applicationEntity.setBoVision1(applicationDTO.getBoVision1());
			applicationEntity.setBoVision2(applicationDTO.getBoVision2());
			applicationEntity.setBoVision3(applicationDTO.getBoVision3());
			applicationEntity.setFiscalYear1(applicationDTO.getFiscalYear1());
			applicationEntity.setFiscalYear2(applicationDTO.getFiscalYear2());
			applicationEntity.setFiscalYear3(applicationDTO.getFiscalYear3());
			applicationEntity.setEstimatedCost(applicationDTO.getEstimatedCost());

			applicationEntity.setLocalityCd(applicationDTO.getLocalityCd());
			applicationEntity.setFipsCd(applicationDTO.getFipsCd());
			applicationEntity.setFirstName(applicationDTO.getFirstName());
			applicationEntity.setLastName(applicationDTO.getLastName());
			applicationEntity.setEmailId(applicationDTO.getEmailId());
			applicationEntity.setPhoneNumber(applicationDTO.getPhoneNumber());
			applicationEntity.setWebsite(applicationDTO.getWebsite());
			applicationEntity.setVerisId(applicationDTO.getVerisId());
			applicationEntity.setCapInd(applicationDTO.isCapInd());
			applicationEntity.setBailoutInd(applicationDTO.isBailoutInd());
			applicationEntity.setPenality(applicationDTO.getPenality());
			applicationEntity.setVebaRegion(applicationDTO.isVebaRegion());
			applicationEntity.setVravRegion(applicationDTO.isVravRegion());
			applicationEntity.setPaperPollbook(applicationDTO.isPaperPollbook());
			applicationEntity.setElectronicPollbook(applicationDTO.isElectronicPollbook());
			applicationEntity.setNotes(applicationDTO.getNotes());

			applicationEntity.setBusinessOwnerNameDoe(applicationDTO.getBusinessOwnerNameDoe());
			applicationEntity.setSystemOwnerNameDoe(applicationDTO.getSystemOwnerNameDoe());

			if (applicationDTO.getWorkHoursDTOs() != null && !applicationDTO.getWorkHoursDTOs().isEmpty()) {
				Set<WorkHoursEntity> workHoursEntities = applicationEntity.getWorkHoursEntities();
				WorkHoursEntity workHoursEntity = null;
				for (WorkHoursDTO workHoursDTO : applicationDTO.getWorkHoursDTOs()) {
					if (workHoursDTO.getWorkHoursId() == null) {
						workHoursEntity = new WorkHoursEntity();
						workHoursEntity.setApplicationEntity(applicationEntity);
						workHoursEntity.setCloseTm(workHoursDTO.getCloseTm());
						workHoursEntity.setOpenTm(workHoursDTO.getOpenTm());
						workHoursEntity.setUpdatedTs(new Date());
						workHoursEntity.setDay(workHoursDTO.getDay());
						workHoursEntity.setCreatedTs(new Date());
						if (createbyUserEntity != null) {
							workHoursEntity.setCreatedBy(
									createbyUserEntity.getFirstName() + " " + createbyUserEntity.getLastName());
							workHoursEntity.setUpdatedBy(
									createbyUserEntity.getFirstName() + " " + createbyUserEntity.getLastName());
						}

						workHoursEntities.add(workHoursEntity);
					} else {
						for (WorkHoursEntity workHoursEntity2 : workHoursEntities) {
							if (workHoursEntity2.getWorkHoursId().equals(workHoursDTO.getWorkHoursId())) {
								workHoursEntity2.setCloseTm(workHoursDTO.getCloseTm());
								workHoursEntity2.setOpenTm(workHoursDTO.getOpenTm());
								workHoursEntity2.setUpdatedTs(new Date());
								if (createbyUserEntity != null)
									workHoursEntity2.setUpdatedBy(
											createbyUserEntity.getFirstName() + " " + createbyUserEntity.getLastName());
								workHoursEntities.add(workHoursEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setWorkHoursEntities(workHoursEntities);
			}

			if (applicationDTO.getInternalInterfaces() != null)
				applicationEntity.setInternalInterfaces(applicationDTO.getInternalInterfaces());

			if (applicationDTO.getExternalInterfaces() != null)
				applicationEntity.setExternalInterfaces(applicationDTO.getExternalInterfaces());

			if (applicationDTO.getDescription() != null)
				applicationEntity.setDescription(applicationDTO.getDescription().getBytes());

			if (applicationDTO.getRisks() != null)
				applicationEntity.setRisks((applicationDTO.getRisks().getBytes()));

			if (applicationDTO.getIso() != null) {
				applicationEntity.setuserEntityByIso(applicationDao.getUserById(applicationDTO.getIso()));

			}

			if (applicationDTO.getConsideration() != null) {
				applicationEntity.setConsideration(applicationDTO.getConsideration().getBytes());
			}

			if (applicationDTO.getBusinessOwner() != null) {
				applicationEntity
						.setuserEntityByBusinessOwner(applicationDao.getUserById(applicationDTO.getBusinessOwner()));

			}

			if (applicationDTO.getPhysicalLocation() != null)
				applicationEntity.setPhysicalLocation(applicationDTO.getPhysicalLocation());
			if (applicationDTO.getItSystemInterfaces() != null)
				applicationEntity.setSystemInterfaces(applicationDTO.getItSystemInterfaces());
			if (applicationDTO.getiTSystemBoundary() != null)
				applicationEntity.setSystemBoundary(applicationDTO.getiTSystemBoundary());

			if (applicationDTO.getRisks() != null)
				applicationEntity.setRisks((applicationDTO.getRisks().getBytes()));

			if (applicationDTO.getProjectManager() != null) {
				// getuser from table assign to application entity.
				applicationEntity
						.setuserEntityByProjectManager(applicationDao.getUserById(applicationDTO.getProjectManager()));
			}

			if (applicationDTO.getTechnicalProjectManager() != null) {
				applicationEntity.setuserEntityByTechnicalProjectManager(
						applicationDao.getUserById(applicationDTO.getTechnicalProjectManager()));
			}

			if (applicationDTO.getSystemAdministrator() != null) {
				applicationEntity
						.setSystemAdministrator(applicationDao.getUserById(applicationDTO.getSystemAdministrator()));
			}

			if (applicationDTO.getTechnologyStatus() != null)
				applicationEntity.setTechnologyStatus(applicationDTO.getTechnologyStatus().getBytes());

			if (applicationDTO.getApplicationDatabaseDTOs() != null
					&& applicationDTO.getApplicationDatabaseDTOs().size() > 0) {

				Set<ApplicationDatabaseEntity> applicationDatabaseEntities = applicationEntity
						.getApplicationDatabaseEntities();

				for (ApplicationDatabaseDTO databaseDTO : applicationDTO.getApplicationDatabaseDTOs()) {
					if (!databaseDTO.isActive()) {
						for (ApplicationDatabaseEntity applicationDatabaseEntity2 : applicationDatabaseEntities) {
							if (applicationDatabaseEntity2.getDatabaseEntity().getDatabaseId() == databaseDTO
									.getDatabaseId()) {
								applicationDatabaseEntity2.setActivityFlag(false);
								applicationDatabaseEntities.add(applicationDatabaseEntity2);
								break;
							}
						}
					}
					if (databaseDTO.isNewEntry()) {
						applicationDatabaseEntity = new ApplicationDatabaseEntity();
						applicationDatabaseEntity
								.setDatabaseEntity(applicationDao.getDatabase(databaseDTO.getDatabaseId()));
						applicationDatabaseEntity.setApplicationEntity(applicationEntity);
						applicationDatabaseEntity.setActivityFlag(true);
						applicationDatabaseEntities.add(applicationDatabaseEntity);
					}
				}
				/*
				 * for (ApplicationDatabaseEntity applicationDatabaseEntity2 :
				 * applicationDatabaseEntities) { if
				 * (applicationDatabaseEntity2.isActivityFlag()) {
				 * applicationDatabaseEntity2.setActivityFlag(false);
				 * applicationDatabaseEntities.add(applicationDatabaseEntity2); } }
				 */

				applicationEntity.setApplicationDatabaseEntities(applicationDatabaseEntities);
			}

			if (applicationDTO.getApplicationServerDTOs() != null
					&& applicationDTO.getApplicationServerDTOs().size() > 0) {
				Set<ApplicationServerEntity> applicationServerEntities = applicationEntity
						.getApplicationServerEntities();
				//

				for (ApplicationServerDTO applicationServerDTO : applicationDTO.getApplicationServerDTOs()) {
					if (!applicationServerDTO.isActive())
						for (ApplicationServerEntity applicationServerEntity2 : applicationServerEntities) {
							if (applicationServerEntity2.getApplicationServerId() == applicationServerDTO
									.getApplicationServerId()) {
								applicationServerEntity2.setActivityFlag(false);
								applicationServerEntities.add(applicationServerEntity2);
								break;
							}
						}
					if (applicationServerDTO.isNewEntry()) {
						ApplicationServerEntity applicationServerEntity = new ApplicationServerEntity();
						applicationServerEntity
								.setServerEntity(applicationDao.getServer(applicationServerDTO.getServerId()));
						applicationServerEntity.setApplicationEntity(applicationEntity);
						applicationServerEntity.setActivityFlag(true);
						applicationServerEntities.add(applicationServerEntity);
					}
				}

				applicationEntity.setApplicationServerEntities(applicationServerEntities);

			}

			if (applicationDTO.getFiscalYearInfoDTOs() != null && applicationDTO.getFiscalYearInfoDTOs().size() > 0) {
				List<FiscalYearInfoEntity> fiscalYearInfoEntities = new ArrayList<FiscalYearInfoEntity>();
				FiscalYearInfoEntity fiscalYearInfoEntity = new FiscalYearInfoEntity();
				List<FiscalYearInfoEntity> fiscalYearInfoEntities2 = applicationEntity.getFiscalYearInfoEntities();
				for (FiscalYearInfoEntity fiscalYearInfoEntity2 : fiscalYearInfoEntities2) {

					if (fiscalYearInfoEntity2.isActivityFlag()) {
						fiscalYearInfoEntity2.setActivityFlag(false);
						fiscalYearInfoEntities.add(fiscalYearInfoEntity2);
					}
				}

				for (int i = 0; i < 3; i++) {

					fiscalYearInfoEntity = new FiscalYearInfoEntity();
					fiscalYearInfoEntity.setApplicationEntity(applicationEntity);
					fiscalYearInfoEntity.setFyNumber(applicationDTO.getFiscalYearInfoDTOs().get(i).getFyNumber());
					fiscalYearInfoEntity.setFyContent(applicationDTO.getFiscalYearInfoDTOs().get(i).getFyContent());
					fiscalYearInfoEntity.setCreatedTs(new Date());
					fiscalYearInfoEntity.setActivityFlag(true);
					fiscalYearInfoEntities.add(fiscalYearInfoEntity);

				}

				applicationEntity.setFiscalYearInfoEntities(fiscalYearInfoEntities);

			}

			if (applicationDTO.getTechnologiesDTOs() != null && !applicationDTO.getTechnologiesDTOs().isEmpty()) {
				Set<ApplicationTechnologyEntity> applicationTechnologyEntities = applicationEntity
						.getApplicationTechnologyEntities();
				ApplicationTechnologyEntity applicationTechnologyEntity = null;
				List<TechnologiesDTO> technologiesDTOs = applicationDTO.getTechnologiesDTOs();

				for (TechnologiesDTO technologiesDTO : technologiesDTOs) {
					if (technologiesDTO.isNewEntry()) {
						applicationTechnologyEntity = new ApplicationTechnologyEntity();
						applicationTechnologyEntity.setApplicationEntity(applicationEntity);
						applicationTechnologyEntity.setTechnologiesEntity(
								applicationDao.getTechnologyEntity(technologiesDTO.getTechnologyId()));
						applicationTechnologyEntity.setActivityFlag(true);
						applicationTechnologyEntities.add(applicationTechnologyEntity);
					}

					if (!technologiesDTO.isActive()) {
						for (ApplicationTechnologyEntity applicationTechnologyEntity2 : applicationTechnologyEntities) {
							if (applicationTechnologyEntity2.getApplicationTechnologyId() == technologiesDTO
									.getTechnologyId()) {
								applicationTechnologyEntity2.setActivityFlag(false);
							}
						}
					}
				}
				applicationEntity.setApplicationTechnologyEntities(applicationTechnologyEntities);
			}

			if (applicationDTO.getKeyDecision() != null)
				applicationEntity.setDecisions(applicationDTO.getKeyDecision());

			if (applicationDTO.getSystemSensitivity() != null) {

				SystemSensitivityEntity systemSensitivityEntity = applicationDao
						.getSystemSensitivityById(applicationDTO.getSystemSensitivity());
				if (systemSensitivityEntity != null) {
					applicationEntity.setSystemSensitivityEntity(systemSensitivityEntity);
				}
			}

			if (applicationDTO.getCostDTO() != null) {
				Set<CostEntity> costEntities = new HashSet<>(0);
				CostEntity costEntity = new CostEntity();
				costEntity.setTypeName(applicationDTO.getCostDTO().getTypeName());
				costEntity.setTypeValue(applicationDTO.getCostDTO().getTypeValue());
				costEntity.setCreatedTs(new Date());
				costEntity.setCreatedBy(applicationDTO.getUpdatedBy());
				costEntity.setApplicationEntity(applicationEntity);
				costEntities.add(costEntity);
				applicationEntity.setCostEntities(costEntities);

			}

			if (applicationDTO.getRisks() != null) {
				applicationEntity.setRisks(applicationDTO.getRisks().getBytes());
			}

			if (applicationDTO.getConsideration() != null) {
				applicationEntity.setConsideration(applicationDTO.getConsideration().getBytes());
			}

			/*
			 * appStatusEntity.setApplicationEntity(applicationEntity);
			 * //appStatusEntity.setUpdatedSection(applicationDTO.getSectionNumber());
			 * appStatusEntity.setCreatedTs(new Date());
			 * appStatusEntity.setCreatedBy(createbyUserEntity);
			 * 
			 * // appStatusEntity.setCreatedBy(userEntity);
			 * appStatusEntity.setUpdatedBy(createbyUserEntity);
			 * appStatusEntity.setUpdatedTs(new Date());
			 * appStatusEntities.add(appStatusEntity);
			 */
			applicationEntity.setModifiedBy(applicationDTO.getUpdatedBy());
			applicationEntity.setUpdatedBy(applicationDTO.getUpdatedBy());
			applicationEntity.setUpdatedTs(new Date());
			// applicationEntity.setAppStatusEntities(appStatusEntities);

			List<AttachmentDTO> attachmentDTOs = applicationDTO.getAttachments();
			ApplDocEntity applicationDocEntity = new ApplDocEntity();
			Set<ApplDocEntity> applDocEntities = applicationEntity.getApplDocEntities();

			if (applDocEntities == null) {
				applDocEntities = new HashSet<ApplDocEntity>(0);
			}

			Set<ApplDocDTO> applDocDTOs = applicationDTO.getApplDocDTOs();
			String filePath = null;
			for (ApplDocDTO applDocDTO : applDocDTOs) {
				if (applDocDTO.getAction() != null
						&& applDocDTO.getAction().equalsIgnoreCase(ApplicationConstants.ADD_DOCUMENT)) {
					for (MultipartFile file : files) {
						if (applDocDTO.getFileName().equalsIgnoreCase(file.getOriginalFilename())) {
							applicationDocEntity = new ApplDocEntity();
							applicationDocEntity.setFileName(file.getOriginalFilename());
							applicationDocEntity.setSectionName(applDocDTO.getSectionName());
							applicationDocEntity.setAttachmentName(applDocDTO.getAttachmentName());
							applicationDocEntity.setApplicationEntity(applicationEntity);
							applicationDocEntity.setCreatedTs(new Date());
							applicationDocEntity.setUserEntity(createbyUserEntity);
							applicationDocEntity.setActiveFlag(true);
							filePath = environment.getRequiredProperty("AAMLocation") + "/"
									+ applicationEntity.getApplicationId() + "/" + file.getOriginalFilename();
							applicationDocEntity.setFileLocation(filePath);
							applicationDocEntity.setUpdatedBy(createbyUserEntity);
							applicationDocEntity.setUpdatedTs(new Date());
							applDocEntities.add(applicationDocEntity);
							try {
								APMMailUtility.createFile(environment.getRequiredProperty("AAMLocation") + "/"
										+ applicationEntity.getApplicationId(), file);
							} catch (APMException e) {
								APMMailUtility.deleteFile(filePath);
								return null;
							}
						}
					}
				} else if (applDocDTO.getAction() != null
						&& applDocDTO.getAction().equalsIgnoreCase(ApplicationConstants.DELETE_DOCUMENT)) {
					for (ApplDocEntity applDocEntity : applDocEntities) {
						if (applDocEntity.getDocumentId() == applDocDTO.getDocumentId()) {
							applDocEntity.setActiveFlag(false);
							applicationDocEntity.setCreatedTs(new Date());
							applicationDocEntity.setUpdatedBy(createbyUserEntity);
							applicationDocEntity.setUpdatedTs(new Date());
						}
					}
				}
			}
			applicationEntity.setApplDocEntities(applDocEntities);
			if (attachmentDTOs != null)
				for (AttachmentDTO attachmentDTO : attachmentDTOs) {

					applicationDocEntity = new ApplDocEntity();
					applicationDocEntity.setFileContent((attachmentDTO.getContent().split("base64,")[1]).getBytes());
					applicationDocEntity.setFileName(attachmentDTO.getFileName());
					applicationDocEntity.setFileType(attachmentDTO.getFileType());

					applicationDocEntity.setCreatedTs(new Date());
					applicationDocEntity.setUserEntity(createbyUserEntity);
					applicationDocEntity.setApplicationEntity(applicationEntity);
					applDocEntities.add(applicationDocEntity);
				}

			applicationEntity.setApplDocEntities(applDocEntities);

			/*
			 * if (applicationDTO.getLastAudit() != null) { Set<ApplicationAuditEntity>
			 * applicationAuditEntities = new HashSet<ApplicationAuditEntity>(0);
			 * ApplicationAuditEntity applicationAuditEntity = new ApplicationAuditEntity();
			 * 
			 * for (ApplicationAuditEntity applicationAuditEntity2 :
			 * applicationEntity.getApplicationAuditEntities()) { if
			 * (applicationAuditEntity2.isActivityFlag()) {
			 * applicationAuditEntity2.setActivityFlag(false);
			 * applicationAuditEntities.add(applicationAuditEntity2); } }
			 * 
			 * AuditEntity auditEntity = new AuditEntity(); //
			 * auditEntity.setAuditId(applicationDTO.getAudit());
			 * auditEntity.setLastAudit(applicationDTO.getLastAudit());
			 * 
			 * auditEntity.setUpComingAudit(applicationDTO.getUpcomingAudit());
			 * auditEntity.setComments(applicationDTO.getAuditComments());
			 * 
			 * applicationAuditEntity.setAuditEntity(auditEntity);
			 * applicationAuditEntity.setApplicationEntity(applicationEntity);
			 * applicationAuditEntity.setActivityFlag(true);
			 * applicationAuditEntities.add(applicationAuditEntity);
			 * applicationEntity.setApplicationAuditEntities(applicationAuditEntities);
			 * 
			 * }
			 */
			if (applicationDTO.getAppDBAdmins() != null && !applicationDTO.getAppDBAdmins().isEmpty()) {
				Set<AppDbAdminEntity> appDbAdminEntities = new HashSet<>();
				List<ApplicationUserDTO> appDBAdminDTOS = applicationDTO.getAppDBAdmins();
				AppDbAdminEntity appDbAdminEntity = null;
				appDbAdminEntities = applicationEntity.getAppDbAdminEntities();
				for (ApplicationUserDTO applicationUserDTO : appDBAdminDTOS) {
					if (applicationUserDTO.isNewEntry()) {
						appDbAdminEntity = new AppDbAdminEntity();
						appDbAdminEntity.setActiveFlag(true);
						appDbAdminEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appDbAdminEntity.setApplicationEntity(applicationEntity);
						appDbAdminEntities.add(appDbAdminEntity);
					} else {
						for (AppDbAdminEntity appDbAdminEntity2 : appDbAdminEntities) {
							if (appDbAdminEntity2.getAppDbAdminId() == applicationUserDTO.getApplicationUserId()
									&& !applicationUserDTO.isActive()) {
								appDbAdminEntity.setActiveFlag(applicationUserDTO.isActive());
								appDbAdminEntities.add(appDbAdminEntity);
								break;
							}
						}
					}
				}
				applicationEntity.setAppDbAdminEntities(appDbAdminEntities);
			}

			if (applicationDTO.getAppBusinessOwners() != null && !applicationDTO.getAppBusinessOwners().isEmpty()) {
				Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity.getAppBusinessOwnerEntities();
				List<ApplicationUserDTO> appBusinessOwnsers = applicationDTO.getAppBusinessOwners();
				AppBusinessOwnerEntity appBusinessOwnerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appBusinessOwnsers) {
					if (applicationUserDTO.isNewEntry()) {
						appBusinessOwnerEntity = new AppBusinessOwnerEntity();
						appBusinessOwnerEntity.setActiveFlag(true);
						appBusinessOwnerEntity
								.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appBusinessOwnerEntity.setApplicationEntity(applicationEntity);
						appBusinessOwnerEntities.add(appBusinessOwnerEntity);
					} else {
						for (AppBusinessOwnerEntity appBusinessOwnerEntity2 : appBusinessOwnerEntities) {
							if (appBusinessOwnerEntity2.getAppBusinessOwnerId() == applicationUserDTO
									.getApplicationUserId() && !applicationUserDTO.isActive()) {
								appBusinessOwnerEntity2.setActiveFlag(applicationUserDTO.isActive());
								appBusinessOwnerEntities.add(appBusinessOwnerEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setAppBusinessOwnerEntities(appBusinessOwnerEntities);
			}

			if (applicationDTO.getAppSystemAdminsters() != null && !applicationDTO.getAppSystemAdminsters().isEmpty()) {
				Set<AppSystemAdminEntity> appSystemAdminEntities = applicationEntity.getAppSystemAdminEntities();
				List<ApplicationUserDTO> appSystemAdminsters = applicationDTO.getAppSystemAdminsters();
				AppSystemAdminEntity appSystemAdminEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appSystemAdminsters) {
					if (applicationUserDTO.isNewEntry()) {
						appSystemAdminEntity = new AppSystemAdminEntity();
						appSystemAdminEntity.setActiveFlag(true);
						appSystemAdminEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appSystemAdminEntity.setApplicationEntity(applicationEntity);
						appSystemAdminEntities.add(appSystemAdminEntity);
					} else {
						for (AppSystemAdminEntity appSystemAdminEntity2 : appSystemAdminEntities) {
							if (appSystemAdminEntity2.getAppSystemAdminId() == applicationUserDTO.getApplicationUserId()
									&& !applicationUserDTO.isActive()) {
								appSystemAdminEntity2.setActiveFlag(applicationUserDTO.isActive());
								appSystemAdminEntities.add(appSystemAdminEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setAppSystemAdminEntities(appSystemAdminEntities);
			}

			if (applicationDTO.getAppProjectManagers() != null && !applicationDTO.getAppProjectManagers().isEmpty()) {
				Set<AppProjectManagerEntity> appProjectManagerEntities = applicationEntity
						.getAppProjectManagerEntities();
				List<ApplicationUserDTO> appProjectManagers = applicationDTO.getAppProjectManagers();
				AppProjectManagerEntity appSystemAdminEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appProjectManagers) {
					if (applicationUserDTO.isNewEntry()) {
						appSystemAdminEntity = new AppProjectManagerEntity();
						appSystemAdminEntity.setActiveFlag(true);
						appSystemAdminEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appSystemAdminEntity.setApplicationEntity(applicationEntity);
						appProjectManagerEntities.add(appSystemAdminEntity);
					} else {
						for (AppProjectManagerEntity appProjectManagerEntity : appProjectManagerEntities) {
							if (appProjectManagerEntity.getAppProjectManagerId() == applicationUserDTO
									.getApplicationUserId() && !applicationUserDTO.isActive()) {
								appProjectManagerEntity.setActiveFlag(applicationUserDTO.isActive());
								appProjectManagerEntities.add(appProjectManagerEntity);
								break;
							}
						}
					}
				}
				applicationEntity.setAppProjectManagerEntities(appProjectManagerEntities);
			}

			if (applicationDTO.getAppTechnicalManagers() != null
					&& !applicationDTO.getAppTechnicalManagers().isEmpty()) {
				Set<AppTechnicalManagerEntity> appTechnicalManagerEntities = applicationEntity
						.getApplicationTechnicalManagerEntities();
				List<ApplicationUserDTO> appTechnicalManagers = applicationDTO.getAppTechnicalManagers();
				AppTechnicalManagerEntity appTechnicalManagerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appTechnicalManagers) {
					if (applicationUserDTO.isNewEntry()) {
						appTechnicalManagerEntity = new AppTechnicalManagerEntity();
						appTechnicalManagerEntity.setActiveFlag(true);
						appTechnicalManagerEntity
								.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appTechnicalManagerEntity.setApplicationEntity(applicationEntity);
						appTechnicalManagerEntities.add(appTechnicalManagerEntity);
					} else {
						for (AppTechnicalManagerEntity appTechnicalManagerEntity2 : appTechnicalManagerEntities) {
							if (appTechnicalManagerEntity2.getAppTechnicalManagerId() == applicationUserDTO
									.getApplicationUserId() && !applicationUserDTO.isActive()) {
								appTechnicalManagerEntity2.setActiveFlag(applicationUserDTO.isActive());
								appTechnicalManagerEntities.add(appTechnicalManagerEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setApplicationTechnicalManagerEntities(appTechnicalManagerEntities);
			}

			if (applicationDTO.getAppSystemOwners() != null && !applicationDTO.getAppSystemOwners().isEmpty()) {
				Set<AppSystemOwnerEntity> appSystemOwnerEntities = applicationEntity.getAppSystemOwnerEntities();
				List<ApplicationUserDTO> appSystemOwners = applicationDTO.getAppSystemOwners();
				AppSystemOwnerEntity appSystemOwnerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appSystemOwners) {
					if (applicationUserDTO.isNewEntry()) {
						appSystemOwnerEntity = new AppSystemOwnerEntity();
						appSystemOwnerEntity.setActiveFlag(true);
						appSystemOwnerEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appSystemOwnerEntity.setApplicationEntity(applicationEntity);
						appSystemOwnerEntities.add(appSystemOwnerEntity);
					} else {
						for (AppSystemOwnerEntity appSystemOwnerEntity2 : appSystemOwnerEntities) {
							if (appSystemOwnerEntity2.getAppSystemOwnerTblId() == applicationUserDTO
									.getApplicationUserId() && !applicationUserDTO.isActive()) {
								appSystemOwnerEntity2.setActiveFlag(applicationUserDTO.isActive());
								appSystemOwnerEntities.add(appSystemOwnerEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setAppSystemOwnerEntities(appSystemOwnerEntities);
			}

			if (applicationDTO.getAppDataOwners() != null && !applicationDTO.getAppDataOwners().isEmpty()) {
				Set<AppDataOwnerEntity> appDataOwnerEntities = applicationEntity.getAppDataOwnerEntities();
				List<ApplicationUserDTO> appDataOwners = applicationDTO.getAppDataOwners();
				AppDataOwnerEntity appDataOwnerEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appDataOwners) {
					if (applicationUserDTO.isNewEntry()) {
						appDataOwnerEntity = new AppDataOwnerEntity();
						appDataOwnerEntity.setActiveFlag(true);
						appDataOwnerEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appDataOwnerEntity.setApplicationEntity(applicationEntity);
						appDataOwnerEntities.add(appDataOwnerEntity);
					} else {
						for (AppDataOwnerEntity appDataOwnerEntity2 : appDataOwnerEntities) {
							if (appDataOwnerEntity2.getAppDataOwnerId() == applicationUserDTO.getApplicationUserId()
									&& !applicationUserDTO.isActive()) {
								appDataOwnerEntity2.setActiveFlag(applicationUserDTO.isActive());
								appDataOwnerEntities.add(appDataOwnerEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setAppDataOwnerEntities(appDataOwnerEntities);
			}

			if (applicationDTO.getAppISOs() != null && !applicationDTO.getAppISOs().isEmpty()) {
				Set<AppIsoEntity> appIsoEntities = applicationEntity.getAppISoEntities();
				List<ApplicationUserDTO> appISOs = applicationDTO.getAppISOs();
				AppIsoEntity appIsoEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appISOs) {
					if (applicationUserDTO.isNewEntry()) {
						appIsoEntity = new AppIsoEntity();
						appIsoEntity.setActiveFlag(true);
						appIsoEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appIsoEntity.setApplicationEntity(applicationEntity);
						appIsoEntities.add(appIsoEntity);
					} else {
						for (AppIsoEntity appIsoEntity2 : appIsoEntities) {
							if (appIsoEntity2.getAppIsoId() == applicationUserDTO.getApplicationUserId()
									&& !applicationUserDTO.isActive()) {
								appIsoEntity2.setActiveFlag(applicationUserDTO.isActive());
								appIsoEntities.add(appIsoEntity2);
								break;
							}
						}
					}

				}
				applicationEntity.setAppISoEntities(appIsoEntities);
			}

			if (applicationDTO.getAppDataCustodians() != null && !applicationDTO.getAppDataCustodians().isEmpty()) {
				Set<AppDataCustodianEntity> appDataCustodianEntities = applicationEntity.getAppDataCustodianEntities();
				List<ApplicationUserDTO> appISOs = applicationDTO.getAppDataCustodians();
				AppDataCustodianEntity appDataCustodianEntity = null;
				for (ApplicationUserDTO applicationUserDTO : appISOs) {
					if (applicationUserDTO.isNewEntry()) {
						appDataCustodianEntity = new AppDataCustodianEntity();
						appDataCustodianEntity.setActiveFlag(true);
						appDataCustodianEntity
								.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appDataCustodianEntity.setApplicationEntity(applicationEntity);
						appDataCustodianEntities.add(appDataCustodianEntity);
					} else {
						for (AppDataCustodianEntity appDataCustodianEntity2 : appDataCustodianEntities) {
							if (appDataCustodianEntity2.getAppDataCustodianId() == applicationUserDTO
									.getApplicationUserId() && !applicationUserDTO.isActive()) {
								appDataCustodianEntity2.setActiveFlag(applicationUserDTO.isActive());
								appDataCustodianEntities.add(appDataCustodianEntity2);
								break;
							}
						}
					}
				}
				applicationEntity.setAppDataCustodianEntities(appDataCustodianEntities);
			}

			if (applicationDTO.getAppBusinessAnalysts() != null && applicationDTO.getAppBusinessAnalysts().size() > 0) {
				Set<AppBusinessAnalystEntity> appBusinessAnalystEntities = applicationEntity
						.getAppBusinessAnalystEntities();
				AppBusinessAnalystEntity appBusinessAnalystEntity = null;

				for (ApplicationUserDTO applicationUserDTO : applicationDTO.getAppBusinessAnalysts()) {
					if (applicationUserDTO.isNewEntry()) {
						appBusinessAnalystEntity = new AppBusinessAnalystEntity();
						appBusinessAnalystEntity
								.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appBusinessAnalystEntity.setApplicationEntity(applicationEntity);
						appBusinessAnalystEntity.setActiveFlag(true);
						appBusinessAnalystEntities.add(appBusinessAnalystEntity);
					} else {
						for (AppBusinessAnalystEntity appBusinessAnalystEntity2 : appBusinessAnalystEntities) {
							if (appBusinessAnalystEntity2.getAppBusinessAnalyst() == applicationUserDTO
									.getApplicationUserId() && !applicationUserDTO.isActive()) {
								appBusinessAnalystEntity2.setActiveFlag(applicationUserDTO.isActive());
								appBusinessAnalystEntities.add(appBusinessAnalystEntity2);
								break;
							}
						}
					}

				}

				applicationEntity.setAppBusinessAnalystEntities(appBusinessAnalystEntities);
			}

			if (applicationDTO.getTesters() != null && applicationDTO.getTesters().size() > 0) {
				Set<AppTesterEntity> applicationTesterEntities = applicationEntity.getAppTesterEntities();
				List<ApplicationUserDTO> testers = applicationDTO.getTesters();
				AppTesterEntity applicationTesterEntity = null;
				for (ApplicationUserDTO applicationUserDTO : testers) {
					if (applicationUserDTO.isNewEntry()) {
						applicationTesterEntity = new AppTesterEntity();
						applicationTesterEntity
								.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						applicationTesterEntity.setApplicationEntity(applicationEntity);
						applicationTesterEntity.setActivityFlag(true);
						applicationTesterEntities.add(applicationTesterEntity);
					} else {
						for (AppTesterEntity appTesterEntity : applicationTesterEntities) {
							if (appTesterEntity.getAppTesterId() == applicationUserDTO.getApplicationUserId()
									&& !applicationUserDTO.isActive()) {
								appTesterEntity.setActivityFlag(applicationUserDTO.isActive());
								applicationTesterEntities.add(appTesterEntity);
								break;
							}
						}
					}

				}
				applicationEntity.setAppTesterEntities(applicationTesterEntities);
			}
			if (applicationDTO.getDevelopers() != null && !applicationDTO.getDevelopers().isEmpty()) {

				Set<AppDevelopersEntity> appDevelopersEntities = applicationEntity.getAppDevelopersEntities();
				List<ApplicationUserDTO> developers = applicationDTO.getDevelopers();
				AppDevelopersEntity appDevelopersEntity = null;
				for (ApplicationUserDTO applicationUserDTO : developers) {
					if (applicationUserDTO.isNewEntry()) {

						appDevelopersEntity = new AppDevelopersEntity();
						appDevelopersEntity.setUserEntity(applicationDao.getUserById(applicationUserDTO.getUserId()));
						appDevelopersEntity.setApplicationEntity(applicationEntity);
						appDevelopersEntity.setActivityFlag(true);
						appDevelopersEntities.add(appDevelopersEntity);
					} else {
						for (AppDevelopersEntity appDevelopersEntity2 : appDevelopersEntities) {
							if (appDevelopersEntity2.getAppDevelopersid() == applicationUserDTO.getApplicationUserId()
									&& !applicationUserDTO.isActive()) {
								appDevelopersEntity2.setActivityFlag(applicationUserDTO.isActive());
								appDevelopersEntities.add(appDevelopersEntity2);
								break;
							}
						}
					}

				}

				applicationEntity.setAppDevelopersEntities(appDevelopersEntities);

			}

			applicationDao.updateApplication(applicationEntity);

		}

		ApplicationViewDTO applicationViewDTO = getApplicationForView(applicationEntity.getAcronym());
		return applicationViewDTO;

	}

	@Override
	@Transactional
	public ReportDTO2 createReport(ReportDTO reportDTO) {
		String dnName;
		String odAcronym;

		ApplicationEntity applicationEntity = null;

		ReportDTO2 reportDTO2 = new ReportDTO2();
		AppCount appCount = new AppCount();
		ApplicationDTO applicationDTO = new ApplicationDTO();
		Set<ApplicationDTO> applicationDTOs = new HashSet<>(0);

		Map<String, Set<ApplicationDTO>> odMap = new HashMap<String, Set<ApplicationDTO>>(0);

		Map<String, Map<String, Set<ApplicationDTO>>> dbMap = new HashMap<String, Map<String, Set<ApplicationDTO>>>(0);

		Set<ApplicationDTO> applicationDTOs2 = new HashSet<ApplicationDTO>(0);

		List<DatabaseEntity> databaseEntities = reportDAO.getDatabaseReport();
		List<OfficeEntity> officeEntities = applicationDao.getOffices();

		for (DatabaseEntity databaseEntity : databaseEntities) {
			for (OfficeEntity officeEntity : officeEntities) {
				appCount = new AppCount();
				List<ApplicationEntity> applicationEntities = reportDAO.getDBOfficeApps(databaseEntity.getDatabaseId(),
						officeEntity.getOfficeId());
				appCount.setOfficeAcronym(officeEntity.getAcronym());
				appCount.setAppCount(applicationEntities.size());

				reportDTO2.setAppCount(appCount);
				reportDTO2.setDbReportKeyString(databaseEntity.getHostName());
				reportDTO2.setReportKey(databaseEntity.getDatabaseId());
			}

		}

		return reportDTO2;

	}

	@Override
	@Transactional
	public ALLReportDTO getReportData() {

		ALLReportDTO allReportDTO = new ALLReportDTO();
		ReportDTO2 reportDTO2 = new ReportDTO2();
		AppCount appCount = new AppCount();
		List<ReportDTO2> reportDTO2s = new ArrayList<ReportDTO2>(0);

		List<DatabaseEntity> databaseEntities = reportDAO.getDatabaseReport();
		List<OfficeEntity> officeEntities = applicationDao.getOffices();
		List<TechnologiesEntity> technologiesEntities = reportDAO.getTechnologyReport();
		List<ServerEntity> serverEntities = reportDAO.getServerReport();
		AppCount[] appCounts = new AppCount[officeEntities.size()];
		AppDisp[] appDisps = new AppDisp[officeEntities.size()];
		AppDisp appDisp = null;
		Integer[] counts = new Integer[officeEntities.size()];
		int index = 0;
		for (DatabaseEntity databaseEntity : databaseEntities) {
			index = 0;
			counts = new Integer[officeEntities.size()];
			appCounts = new AppCount[officeEntities.size()];
			appDisps = new AppDisp[officeEntities.size()];

			reportDTO2 = new ReportDTO2();
			for (OfficeEntity officeEntity : officeEntities) {
				appCount = new AppCount();
				appDisp = new AppDisp();
				List<ApplicationEntity> applicationEntities = reportDAO.getDBOfficeApps(databaseEntity.getDatabaseId(),
						officeEntity.getOfficeId());
				appCount.setOfficeAcronym(officeEntity.getAcronym());
				appCount.setAppCount(applicationEntities.size());
				for (ApplicationEntity applicationEntity : applicationEntities) {
					appDisp.setAcronym(applicationEntity.getAcronym());
					appDisp.setName(applicationEntity.getName());
				}

				appCounts[index] = appCount;
				counts[index++] = appCount.getAppCount();
			}

			reportDTO2.setDbCount(counts);
			reportDTO2.setAppCounts(appCounts);
			reportDTO2.setDbReportKey(databaseEntity.getDatabaseId());
			reportDTO2.setDbReportKeyString(databaseEntity.getHostName());

			reportDTO2s.add(reportDTO2);
		}
		allReportDTO.setDbReport(reportDTO2s);
		reportDTO2.setAppDisp(appDisps);
		reportDTO2s = new ArrayList<ReportDTO2>(0);
		reportDTO2 = new ReportDTO2();

		for (TechnologiesEntity technologiesEntity : technologiesEntities) {
			index = 0;
			counts = new Integer[officeEntities.size()];
			appDisps = new AppDisp[officeEntities.size()];

			appCounts = new AppCount[officeEntities.size()];
			reportDTO2 = new ReportDTO2();
			for (OfficeEntity officeEntity : officeEntities) {
				appDisp = new AppDisp();
				appCount = new AppCount();
				List<ApplicationEntity> applicationEntities = reportDAO
						.getTechOfficeApps(technologiesEntity.getTechnologyId(), officeEntity.getOfficeId());
				appCount.setOfficeAcronym(officeEntity.getAcronym());
				appCount.setAppCount(applicationEntities.size());

				for (ApplicationEntity applicationEntity : applicationEntities) {
					appDisp.setAcronym(applicationEntity.getAcronym());
					appDisp.setName(applicationEntity.getName());
				}
				appDisps[index] = appDisp;
				appCounts[index] = appCount;
				counts[index++] = appCount.getAppCount();
			}

			reportDTO2.setTechCount(counts);
			reportDTO2.setAppCounts(appCounts);
			reportDTO2.setAppDisp(appDisps);
			reportDTO2.setTechReportKeyString(technologiesEntity.getName());
			reportDTO2.setTechReportKey(technologiesEntity.getTechnologyId());
			reportDTO2s.add(reportDTO2);
		}
		allReportDTO.setTechReport(reportDTO2s);
		reportDTO2s = new ArrayList<ReportDTO2>(0);
		reportDTO2 = new ReportDTO2();
		for (ServerEntity serverEntity : serverEntities) {
			index = 0;
			counts = new Integer[officeEntities.size()];
			appCounts = new AppCount[officeEntities.size()];
			reportDTO2 = new ReportDTO2();
			for (OfficeEntity officeEntity : officeEntities) {
				appCount = new AppCount();
				List<ApplicationEntity> applicationEntities = reportDAO.getServerOfficeApps(serverEntity.getServerId(),
						officeEntity.getOfficeId());
				appCount.setOfficeAcronym(officeEntity.getAcronym());
				appCount.setAppCount(applicationEntities.size());

				for (ApplicationEntity applicationEntity : applicationEntities) {
					appDisp.setAcronym(applicationEntity.getAcronym());
					appDisp.setName(applicationEntity.getName());
				}

				appDisps[index] = appDisp;
				appCounts[index] = appCount;
				counts[index++] = appCount.getAppCount();
			}

			reportDTO2.setServerCount(counts);
			reportDTO2.setTechAppDisp(appDisps);
			reportDTO2.setAppCounts(appCounts);
			reportDTO2.setServerReportKeyString(serverEntity.getName());
			reportDTO2.setServerReportKey(serverEntity.getServerId());
			reportDTO2s.add(reportDTO2);
		}
		allReportDTO.setAppServerReport(reportDTO2s);

		return allReportDTO;
	}

	@Override
	@Transactional
	public ApplicationViewDTO getApplicationForView(String acronym) {
		ApplicationEntity applicationEntity = applicationDao.getAcronym(acronym);
		ApplicationViewDTO applicationViewDTO = null;
		if (applicationEntity != null) {
			applicationViewDTO = new ApplicationViewDTO();
			applicationViewDTO.setApplicationId(applicationEntity.getApplicationId());
			applicationViewDTO.setAcronym(applicationEntity.getAcronym());
			applicationViewDTO.setName(applicationEntity.getName());
			applicationViewDTO.setUpdatedBy(applicationEntity.getUpdatedBy());
				applicationViewDTO.setModifiedByName(applicationEntity.getModifiedBy());
			applicationViewDTO.setModifiedTs(applicationEntity.getUpdatedTs());
			applicationViewDTO.setLevelOfEffort(applicationEntity.getLevelOfEffort());
			applicationViewDTO.setSecurityAssessments(applicationEntity.getSecurityAssessments());
			applicationViewDTO.setBoVision1(applicationEntity.getBoVision1());
			applicationViewDTO.setBoVision2(applicationEntity.getBoVision2());
			applicationViewDTO.setBoVision3(applicationEntity.getBoVision3());

			applicationViewDTO.setFiscalYear1(applicationEntity.getFiscalYear1());
			applicationViewDTO.setFiscalYear2(applicationEntity.getFiscalYear2());
			applicationViewDTO.setFiscalYear3(applicationEntity.getFiscalYear3());
			applicationViewDTO.setInternalInterfaces(applicationEntity.getInternalInterfaces());
			applicationViewDTO.setExternalInterfaces(applicationEntity.getExternalInterfaces());

			applicationViewDTO.setLocalityCd(applicationEntity.getLocalityCd());
			applicationViewDTO.setFipsCd(applicationEntity.getFipsCd());
			applicationViewDTO.setFirstName(applicationEntity.getFirstName());
			applicationViewDTO.setLastName(applicationEntity.getLastName());
			applicationViewDTO.setEmailId(applicationEntity.getEmailId());
			applicationViewDTO.setPhoneNumber(applicationEntity.getPhoneNumber());
			applicationViewDTO.setWebsite(applicationEntity.getWebsite());
			applicationViewDTO.setVerisId(applicationEntity.getVerisId());
			applicationViewDTO.setCapInd(applicationEntity.getCapInd());
			applicationViewDTO.setBailoutInd(applicationEntity.isBailoutInd());
			applicationViewDTO.setPenality(applicationEntity.getPenality());
			applicationViewDTO.setVebaRegion(applicationEntity.isVebaRegion());
			applicationViewDTO.setVravRegion(applicationEntity.isVravRegion());
			applicationViewDTO.setPaperPollbook(applicationEntity.isPaperPollbook());
			applicationViewDTO.setElectronicPollbook(applicationEntity.isElectronicPollbook());
			applicationViewDTO.setNotes(applicationEntity.getNotes());
			applicationViewDTO.setActiveLocality(applicationEntity.getActiveLocality());
			applicationViewDTO.setBusinessOwnerNameDoe(applicationEntity.getBusinessOwnerNameDoe());
			applicationViewDTO.setSystemOwnerNameDoe(applicationEntity.getSystemOwnerNameDoe());

			if (applicationEntity.getDivisionEntity() != null)
				applicationViewDTO.setDivision(applicationEntity.getDivisionEntity().getId());
			if (applicationEntity.getEstimatedCost() != null)
				applicationViewDTO.setEstimatedCost(applicationEntity.getEstimatedCost());
			if (applicationEntity.getDescription() != null)
				applicationViewDTO.setDescription(new String(applicationEntity.getDescription()));

			/*
			 * if (applicationEntity.getDivisionEntity() != null) {
			 * applicationViewDTO.setDivisionName(applicationEntity.getDivisionEntity().
			 * getDivisionName());
			 * applicationViewDTO.setDivision(applicationEntity.getDivisionEntity().getId())
			 * ; }
			 */

			if (applicationEntity.getTechnologyStatus() != null)
				applicationViewDTO.setTechnologyStatus(new String(applicationEntity.getTechnologyStatus()));

			if (applicationEntity.getOfficeEntity() != null) {
				applicationViewDTO.setOdAcronym(applicationEntity.getOfficeEntity().getAcronym());
				applicationViewDTO.setOffice(applicationEntity.getOfficeEntity().getOfficeId());
			}

			if (applicationEntity.getApplicationTechnologyEntities() != null
					&& !applicationEntity.getApplicationTechnologyEntities().isEmpty()) {
				List<TechnologiesDTO> technologiesDTOs = new ArrayList<>();
				TechnologiesDTO technologiesDTO = null;
				Set<ApplicationTechnologyEntity> technologiesEntities = applicationEntity
						.getApplicationTechnologyEntities();

				for (ApplicationTechnologyEntity applicationTechnologyEntity : technologiesEntities) {
					technologiesDTO = new TechnologiesDTO();
					technologiesDTO.setName(applicationTechnologyEntity.getTechnologiesEntity().getName());
					technologiesDTO.setTechnologyVersion(
							applicationTechnologyEntity.getTechnologiesEntity().getTechnologyVersion());
					technologiesDTO.setTechnologyId(applicationTechnologyEntity.getApplicationTechnologyId());
					technologiesDTO.setActive(applicationTechnologyEntity.isActivityFlag());
					technologiesDTO.setNewEntry(false);
					technologiesDTOs.add(technologiesDTO);
				}
				applicationViewDTO.setTechnologiesDTOs(technologiesDTOs);

			}
			if (applicationEntity.getAppDbAdminEntities() != null) {

			}
			if (applicationEntity.getAppDataOwnerEntities() != null
					&& !applicationEntity.getAppDataOwnerEntities().isEmpty()) {
				Set<AppDataOwnerEntity> appDataOwnerEntities = applicationEntity.getAppDataOwnerEntities();
				List<ApplicationUserDTO> appDataOwners = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				for (AppDataOwnerEntity appDataOwnerEntity : appDataOwnerEntities) {
					if (appDataOwnerEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appDataOwnerEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appDataOwnerEntity.getAppDataOwnerId());
						applicationUserDTO.setFirstName(appDataOwnerEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appDataOwnerEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appDataOwnerEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appDataOwnerEntity.getActiveFlag());
						appDataOwners.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppDataOwners(appDataOwners);
			}

			if (applicationEntity.getAppISoEntities() != null && !applicationEntity.getAppISoEntities().isEmpty()) {

				List<ApplicationUserDTO> appISOs = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppIsoEntity> appIsoEntities = applicationEntity.getAppISoEntities();
				for (AppIsoEntity appIsoEntity : appIsoEntities) {
					if (appIsoEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appIsoEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appIsoEntity.getAppIsoId());
						applicationUserDTO.setFirstName(appIsoEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appIsoEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appIsoEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appIsoEntity.getActiveFlag());
						appISOs.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppISOs(appISOs);
			}
			if (applicationEntity.getAppProjectManagerEntities() != null
					&& !applicationEntity.getAppProjectManagerEntities().isEmpty()) {
				List<ApplicationUserDTO> appProgrammingManagers = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppProjectManagerEntity> appProjectManagerEntities = applicationEntity
						.getAppProjectManagerEntities();
				for (AppProjectManagerEntity appProjectManagerEntity : appProjectManagerEntities) {
					if (appProjectManagerEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appProjectManagerEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appProjectManagerEntity.getAppProjectManagerId());
						applicationUserDTO.setFirstName(appProjectManagerEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appProjectManagerEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appProjectManagerEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appProjectManagerEntity.getActiveFlag());
						appProgrammingManagers.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppProjectManagers(appProgrammingManagers);

			}
			if (applicationEntity.getAppSystemOwnerEntities() != null
					&& !applicationEntity.getAppSystemOwnerEntities().isEmpty()) {
				List<ApplicationUserDTO> appSystemOwners = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppSystemOwnerEntity> appSystemOwnerEntities = applicationEntity.getAppSystemOwnerEntities();

				for (AppSystemOwnerEntity appSystemOwnerEntity : appSystemOwnerEntities) {
					if (appSystemOwnerEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appSystemOwnerEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appSystemOwnerEntity.getAppSystemOwnerTblId());
						applicationUserDTO.setFirstName(appSystemOwnerEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appSystemOwnerEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appSystemOwnerEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appSystemOwnerEntity.getActiveFlag());
						appSystemOwners.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppSystemOwners(appSystemOwners);

			}
			if (applicationEntity.getAppSystemAdminEntities() != null
					&& !applicationEntity.getAppSystemAdminEntities().isEmpty()) {
				List<ApplicationUserDTO> appSystemAdminsters = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppSystemAdminEntity> appSystemAdminEntities = applicationEntity.getAppSystemAdminEntities();
				for (AppSystemAdminEntity appSystemAdminEntity : appSystemAdminEntities) {
					if (appSystemAdminEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appSystemAdminEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appSystemAdminEntity.getAppSystemAdminId());
						applicationUserDTO.setFirstName(appSystemAdminEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appSystemAdminEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appSystemAdminEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appSystemAdminEntity.getActiveFlag());
						appSystemAdminsters.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppSystemAdminsters(appSystemAdminsters);
			}

			if (applicationEntity.getAppBusinessAnalystEntities() != null
					&& !applicationEntity.getAppBusinessAnalystEntities().isEmpty()) {
				List<ApplicationUserDTO> appBusinessAnalysts = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppBusinessAnalystEntity> appBusinessAnalystEntities = applicationEntity
						.getAppBusinessAnalystEntities();

				for (AppBusinessAnalystEntity appBusinessAnalystEntity : appBusinessAnalystEntities) {
					if (appBusinessAnalystEntity.isActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appBusinessAnalystEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appBusinessAnalystEntity.getAppBusinessAnalyst());
						applicationUserDTO.setFirstName(appBusinessAnalystEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appBusinessAnalystEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appBusinessAnalystEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appBusinessAnalystEntity.isActiveFlag());
						appBusinessAnalysts.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppBusinessAnalysts(appBusinessAnalysts);
			}

			if (applicationEntity.getApplicationTechnicalManagerEntities() != null
					&& !applicationEntity.getApplicationTechnicalManagerEntities().isEmpty()) {
				List<ApplicationUserDTO> appTechnologyProjectManagers = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppTechnicalManagerEntity> appTechnicalManagerEntities = applicationEntity
						.getApplicationTechnicalManagerEntities();

				for (AppTechnicalManagerEntity appTechnicalManagerEntity : appTechnicalManagerEntities) {
					if (appTechnicalManagerEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appTechnicalManagerEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appTechnicalManagerEntity.getAppTechnicalManagerId());
						applicationUserDTO.setFirstName(appTechnicalManagerEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appTechnicalManagerEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appTechnicalManagerEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appTechnicalManagerEntity.getActiveFlag());
						appTechnologyProjectManagers.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppTechnicalManagers(appTechnologyProjectManagers);

			}

			if (applicationEntity.getAppBusinessOwnerEntities() != null
					&& !applicationEntity.getAppBusinessOwnerEntities().isEmpty()) {
				List<ApplicationUserDTO> applicationUserDTOs = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity.getAppBusinessOwnerEntities();

				for (AppBusinessOwnerEntity appBusinessOwnerEntity : appBusinessOwnerEntities) {
					if (appBusinessOwnerEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setApplicationUserId(appBusinessOwnerEntity.getAppBusinessOwnerId());
						applicationUserDTO.setUserId(appBusinessOwnerEntity.getUserEntity().getUserId());
						applicationUserDTO.setFirstName(appBusinessOwnerEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appBusinessOwnerEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appBusinessOwnerEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appBusinessOwnerEntity.getActiveFlag());
						applicationUserDTOs.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppBusinessOwners(applicationUserDTOs);

			}

			if (applicationEntity.getAppDbAdminEntities() != null
					&& !applicationEntity.getAppDbAdminEntities().isEmpty()) {
				List<ApplicationUserDTO> applicationUserDTOs = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppDbAdminEntity> appDbAdminEntities = applicationEntity.getAppDbAdminEntities();

				for (AppDbAdminEntity appDbAdminEntity : appDbAdminEntities) {
					if (appDbAdminEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appDbAdminEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appDbAdminEntity.getAppDbAdminId());
						applicationUserDTO.setFirstName(appDbAdminEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appDbAdminEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appDbAdminEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appDbAdminEntity.getActiveFlag());
						applicationUserDTOs.add(applicationUserDTO);
					}
				}

				applicationViewDTO.setAppDBAdmins(applicationUserDTOs);
			}

			if (applicationEntity.getAppDataCustodianEntities() != null
					&& !applicationEntity.getAppDataCustodianEntities().isEmpty()) {
				List<ApplicationUserDTO> applicationUserDTOs = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;
				Set<AppDataCustodianEntity> appDataCustodianEntities = applicationEntity.getAppDataCustodianEntities();

				for (AppDataCustodianEntity appDataCustodianEntity : appDataCustodianEntities) {
					if (appDataCustodianEntity.getActiveFlag()) {
						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appDataCustodianEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appDataCustodianEntity.getAppDataCustodianId());
						applicationUserDTO.setFirstName(appDataCustodianEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appDataCustodianEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appDataCustodianEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appDataCustodianEntity.getActiveFlag());
						applicationUserDTOs.add(applicationUserDTO);
					}
				}
				applicationViewDTO.setAppDataCustodians(applicationUserDTOs);

			}

			if (applicationEntity.getAppDevelopersEntities().size() > 0) {

				Set<AppDevelopersEntity> appDevelopersEntities = applicationEntity.getAppDevelopersEntities();

				List<ApplicationUserDTO> applicationUserDTOs = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;

				for (AppDevelopersEntity appDevelopersEntity : appDevelopersEntities) {

					if (appDevelopersEntity.isActivityFlag()) {

						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appDevelopersEntity.getUserEntity().getUserId());
						applicationUserDTO.setApplicationUserId(appDevelopersEntity.getAppDevelopersid());
						applicationUserDTO.setFirstName(appDevelopersEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appDevelopersEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appDevelopersEntity.getUserEntity().getEmailId());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTO.setActive(appDevelopersEntity.isActivityFlag());
						applicationUserDTOs.add(applicationUserDTO);
					}
					applicationViewDTO.setDevelopers(applicationUserDTOs);

				}
			}

			if (applicationEntity.getApplDocEntities().size() > 0) {

				Set<ApplDocDTO> applDocDTOs = new HashSet<ApplDocDTO>(0);
				ApplDocDTO applDocDTO = null;
				Set<ApplDocEntity> applDocEntities = applicationEntity.getApplDocEntities();

				for (ApplDocEntity applDocEntity : applDocEntities) {
					applDocDTO = new ApplDocDTO();
					if (applDocEntity.isActiveFlag()) {
						applDocDTO.setFileName(applDocEntity.getFileName());
						applDocDTO.setActiveFlag(applDocEntity.isActiveFlag());
						applDocDTO.setDocumentId(applDocEntity.getDocumentId());
						applDocDTO.setFileType(applDocEntity.getFileType());
						applDocDTO.setSectionName(applDocEntity.getSectionName());
						applDocDTO.setAttachmentName(applDocEntity.getAttachmentName());
						applDocDTOs.add(applDocDTO);
					}
				}
				// applicationViewDTO.setFile(applDocDTOs);
				applicationViewDTO.setApplDocDTOs(applDocDTOs);
			}

			if (applicationEntity.getAppTesterEntities().size() > 0) {

				Set<AppTesterEntity> appTesterEntities = applicationEntity.getAppTesterEntities();
				List<ApplicationUserDTO> applicationUserDTOs = new ArrayList<>();
				ApplicationUserDTO applicationUserDTO = null;

				for (AppTesterEntity appTesterEntity : appTesterEntities) {

					if (appTesterEntity.isActivityFlag()) {

						applicationUserDTO = new ApplicationUserDTO();
						applicationUserDTO.setUserId(appTesterEntity.getUserEntity().getUserId());
						applicationUserDTO.setFirstName(appTesterEntity.getUserEntity().getFirstName());
						applicationUserDTO.setLastName(appTesterEntity.getUserEntity().getLastName());
						applicationUserDTO.setEmailId(appTesterEntity.getUserEntity().getEmailId());
						applicationUserDTO.setActive(appTesterEntity.isActivityFlag());
						applicationUserDTO.setNewEntry(false);
						applicationUserDTOs.add(applicationUserDTO);

					}
				}
				applicationViewDTO.setTesters(applicationUserDTOs);
			}

				applicationViewDTO.setUpdatedBy(applicationEntity.getUpdatedBy());

			if (applicationEntity.getPhysicalLocation() != null)
				applicationViewDTO.setPhysicalLocation(applicationEntity.getPhysicalLocation());

			if (applicationEntity.getSystemInterfaces() != null)
				applicationViewDTO.setItSystemInterfaces(applicationEntity.getSystemInterfaces());

			if (applicationEntity.getSystemBoundary() != null)
				applicationViewDTO.setiTSystemBoundary(applicationEntity.getSystemBoundary());

			if (applicationEntity.getSystemSensitivityEntity() != null) {
				applicationViewDTO.setSystemSensitivityName(
						applicationEntity.getSystemSensitivityEntity().getSystemSensitivityValue());

				applicationViewDTO
						.setSystemSensitivity(applicationEntity.getSystemSensitivityEntity().getSystemSensitivityId());
			}

			if (applicationEntity.getRisks() != null) {
				applicationViewDTO.setRisks(new String(applicationEntity.getRisks()));
			}

			if (applicationEntity.getDecisions() != null)
				applicationViewDTO.setDecisions(applicationEntity.getDecisions());

			if (applicationEntity.getDecisions() != null)
				applicationViewDTO.setKeyDecision(applicationEntity.getDecisions());

				applicationViewDTO.setUpdatedBy(applicationEntity.getUpdatedBy());

			applicationViewDTO.setUpdatedTime(applicationEntity.getUpdatedTs());
			if (applicationEntity.getStatusEntity() != null)
				applicationViewDTO.setAppStatus(applicationEntity.getStatusEntity().getName());

			if (applicationEntity.getConsideration() != null)
				applicationViewDTO.setConsideration(new String(applicationEntity.getConsideration()));

			if (applicationEntity.getApplicationTechnologyEntities().size() > 0) {
				Set<ApplicationTechnologyEntity> applicationTechnologyEntities = applicationEntity
						.getApplicationTechnologyEntities();
				List<TechnologiesDTO> applicationTechnologyDTOs = new ArrayList<TechnologiesDTO>(0);
				TechnologiesDTO applicationTechnologyDTO = null;

				for (ApplicationTechnologyEntity applicationTechnologyEntity : applicationTechnologyEntities) {
					applicationTechnologyDTO = new TechnologiesDTO();

					if (applicationTechnologyEntity.isActivityFlag()) {

						if (applicationTechnologyEntity.getTechnologiesEntity() != null) {
							applicationTechnologyDTO
									.setName(applicationTechnologyEntity.getTechnologiesEntity().getName());
							applicationTechnologyDTO.setTechnologyVersion(
									applicationTechnologyEntity.getTechnologiesEntity().getTechnologyVersion());

							applicationTechnologyDTO.setTechnologyId(
									applicationTechnologyEntity.getTechnologiesEntity().getTechnologyId());
							applicationTechnologyDTO.setNewEntry(false);

							applicationTechnologyDTOs.add(applicationTechnologyDTO);
						}
					}

					Collections.sort(applicationTechnologyDTOs, TechNameComparator);
					applicationViewDTO.setTechnologies(applicationTechnologyDTOs);

				}
			}

			if (applicationEntity.getAppBusinessAnalystEntities().size() > 0) {
				Set<AppBusinessAnalystEntity> appBusinessAnalystEntities = applicationEntity
						.getAppBusinessAnalystEntities();

				for (AppBusinessAnalystEntity appBusinessAnalystEntity : appBusinessAnalystEntities) {

					if (appBusinessAnalystEntity.isActiveFlag()) {

						applicationViewDTO
								.setBusinessAnalystName(appBusinessAnalystEntity.getUserEntity().getFirstName() + " "
										+ appBusinessAnalystEntity.getUserEntity().getLastName());

						applicationViewDTO.setBusinessAnalyst(appBusinessAnalystEntity.getUserEntity().getUserId());
					}

				}

			}

			if (applicationEntity.getApplicationServerEntities().size() > 0) {
				Set<ApplicationServerEntity> applicationServerEntities = applicationEntity
						.getApplicationServerEntities();
				List<ApplicationServerDTO> applicationServerDTOs = new ArrayList<>();
				ApplicationServerDTO applicationServerDTO = null;

				for (ApplicationServerEntity applicationServerEntity : applicationServerEntities) {

					if (applicationServerEntity.isActivityFlag()) {
						applicationServerDTO = new ApplicationServerDTO();
						applicationServerDTO.setName(applicationServerEntity.getServerEntity().getName());
						applicationServerDTO.setServerId(applicationServerEntity.getServerEntity().getServerId());
						applicationServerDTO.setNewEntry(false);
						applicationServerDTO.setApplicationServerId(applicationServerEntity.getApplicationServerId());
						applicationServerDTO.setActive(applicationServerEntity.isActivityFlag());
						applicationServerDTOs.add(applicationServerDTO);
					}
				}
				applicationViewDTO.setApplicationServerDTOs(applicationServerDTOs);
			}

			if (applicationEntity.getApplicationAuditEntities().size() > 0) {
				Set<ApplicationAuditEntity> applicationAuditEntities = applicationEntity.getApplicationAuditEntities();

				for (ApplicationAuditEntity applicationAuditEntity : applicationAuditEntities) {

					if (applicationAuditEntity.isActivityFlag()) {

						applicationViewDTO.setLastAudit(applicationAuditEntity.getAuditEntity().getLastAudit());
						applicationViewDTO.setUpcomingAudit(applicationAuditEntity.getAuditEntity().getUpComingAudit());
						applicationViewDTO.setAuditComments(applicationAuditEntity.getAuditEntity().getComments());
						applicationViewDTO.setAuditId(applicationAuditEntity.getAuditEntity().getAuditId());

					}
				}

			}

			if (applicationEntity.getCostEntities() != null && applicationEntity.getCostEntities().size() > 0) {
				Set<CostEntity> costEntities = applicationEntity.getCostEntities();
				CostDTO costDTO = new CostDTO();
				;
				List<CostDTO> costDTOs = new ArrayList<>();

				for (CostEntity costEntity : costEntities) {
					/*
					 * applicationViewDTO.setCostType(costEntity.getTypeName());
					 * applicationViewDTO.setCost(Double.toString(costEntity.getTypeValue()));
					 * applicationViewDTO.setCostId(costEntity.getCostId());
					 * applicationViewDTO.setTypeValue(Double.toString(costEntity.getTypeValue()));
					 */

					costDTO.setTypeName(costEntity.getTypeName());
					costDTO.setTypeValue(costEntity.getTypeValue());
				}

				applicationViewDTO.setCostDTO(costDTO);

			}

			if (applicationEntity.getApplicationDatabaseEntities().size() > 0) {
				Set<ApplicationDatabaseEntity> applicationDatabaseEntities = applicationEntity
						.getApplicationDatabaseEntities();
				List<ApplicationDatabaseDTO> applicationDatabaseDTOs = new ArrayList<>();
				ApplicationDatabaseDTO applicationDatabaseDTO = null;
				for (ApplicationDatabaseEntity applicationDatabaseEntity : applicationDatabaseEntities) {
					if (applicationDatabaseEntity.isActivityFlag()) {
						applicationDatabaseDTO = new ApplicationDatabaseDTO();
						applicationDatabaseDTO.setHostName(applicationDatabaseEntity.getDatabaseEntity().getHostName());
						applicationDatabaseDTO.setNewEntry(false);
						applicationDatabaseDTO.setActive(applicationDatabaseEntity.isActivityFlag());
						applicationDatabaseDTO
								.setDatabaseId(applicationDatabaseEntity.getDatabaseEntity().getDatabaseId());
						applicationDatabaseDTOs.add(applicationDatabaseDTO);
					}
				}
				applicationViewDTO.setApplicationDatabaseDTOs(applicationDatabaseDTOs);
			}

			if (applicationEntity.getFiscalYearInfoEntities().size() > 0) {
				List<FiscalYearInfoEntity> fiscalYearInfoEntities = applicationEntity.getFiscalYearInfoEntities();
				List<FiscalYearInfoDTO> fiscalYearInfoDTOs = new ArrayList<FiscalYearInfoDTO>(0);
				FiscalYearInfoDTO fiscalYearInfoDTO = null;

				for (FiscalYearInfoEntity fiscalYearInfoEntity : fiscalYearInfoEntities) {
					if (fiscalYearInfoEntity.isActivityFlag()) {
						fiscalYearInfoDTO = new FiscalYearInfoDTO();
						fiscalYearInfoDTO.setFyNumber(fiscalYearInfoEntity.getFyNumber());
						fiscalYearInfoDTO.setFyContent(fiscalYearInfoEntity.getFyContent());
						fiscalYearInfoDTO.setFyId(fiscalYearInfoEntity.getFyId());
						fiscalYearInfoDTOs.add(fiscalYearInfoDTO);
					}

				}

				applicationViewDTO.setFiscalYearInfoDTOs(fiscalYearInfoDTOs);
			}

			if (applicationEntity.getAppAuditEntities() != null && applicationEntity.getAppAuditEntities().size() > 0) {
				List<AppAuditDTO> appAuditDTOs = new ArrayList<>();
				AppAuditDTO appAuditDTO = null;
				Set<AppAuditEntity> appAuditEntities = applicationEntity.getAppAuditEntities();
				for (AppAuditEntity appAuditEntity : appAuditEntities) {
					appAuditDTO = new AppAuditDTO();
					try {
						BeanUtils.copyProperties(appAuditDTO, appAuditEntity);
						appAuditDTO.setPolicyGrpId(appAuditEntity.getPolicyGrpEntity().getPolicyGrpId());
						appAuditDTO.setAuditTypeName(
								appAuditEntity.getPolicyGrpEntity().getAuditTypeEntity().getAuditTypeName());
					} catch (IllegalAccessException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (appAuditEntity.getAppAuditFileEntities().size() > 0) {
						List<AppAuditFileEntity> appAuditFileEntities = appAuditEntity.getAppAuditFileEntities();
						AppAuditFileDTO appAuditFileDTO = null;

						List<AppAuditFileDTO> appAuditFileDTOs = new ArrayList<>();

						for (AppAuditFileEntity appAuditFileEntity : appAuditFileEntities) {
							appAuditFileDTO = new AppAuditFileDTO();
							appAuditFileDTO.setAppAuditFileId(appAuditFileEntity.getAppAuditFileId());
							appAuditFileDTO.setStatus(appAuditFileEntity.getStatus());
							appAuditFileDTO.setFileName(appAuditFileEntity.getFileName());
							appAuditFileDTOs.add(appAuditFileDTO);
						}
						appAuditDTO.setAppAuditFileDTOs(appAuditFileDTOs);
					}

					if (appAuditEntity.getAppAuditPolicyEntities().size() > 0) {
						List<AuditPolicyDTO> auditPolicyDTOs = new ArrayList<>(0);
						AuditPolicyDTO auditPolicyDTO = null;
						List<AppAuditPolicyEntity> appAuditPolicyEntities = appAuditEntity.getAppAuditPolicyEntities();
						for (AppAuditPolicyEntity appAuditPolicyEntity : appAuditPolicyEntities) {
							auditPolicyDTO = new AuditPolicyDTO();
							auditPolicyDTO.setDefaultVal(appAuditPolicyEntity.getDefaultVal());
							auditPolicyDTO.setStatus(appAuditPolicyEntity.getStatus());
							auditPolicyDTO.setPolicyId(appAuditPolicyEntity.getPolicyEntity().getPolicyId());
							auditPolicyDTO.setControlNumber(appAuditPolicyEntity.getPolicyEntity().getControlNumber());
							auditPolicyDTO.setPolicyName(appAuditPolicyEntity.getPolicyEntity().getPolicyName());
							auditPolicyDTO.setDescription(appAuditPolicyEntity.getPolicyEntity().getDescription());
							auditPolicyDTO.setPolicyGrpId(
									appAuditPolicyEntity.getPolicyEntity().getPolicyGrpEntity().getPolicyGrpId());
							auditPolicyDTO.setPolicyVal(appAuditPolicyEntity.getPolicyEntity().getPolicyVal());
							auditPolicyDTO.setAppAuditPolicyId(appAuditPolicyEntity.getAppAuditPolicyId());
							auditPolicyDTO.setPriority(appAuditPolicyEntity.getPolicyEntity().getPriority());
							auditPolicyDTO.setProcedures(appAuditPolicyEntity.getPolicyEntity().getProcedures());
							auditPolicyDTO.setGuidelines(appAuditPolicyEntity.getPolicyEntity().getGuidelines());
							auditPolicyDTOs.add(auditPolicyDTO);
						}
						appAuditDTO.setAuditPolicyDTOs(auditPolicyDTOs);
					}

					appAuditDTOs.add(appAuditDTO);
				}
				applicationViewDTO.setAppAuditDTOs(appAuditDTOs);
			}

			if (applicationEntity.getMouEntities() != null && !applicationEntity.getMouEntities().isEmpty()) {
				List<MOUDTO> moudtos = new ArrayList<>();
				MOUDTO moudto = null;
				for (MOUEntity mouEntity : applicationEntity.getMouEntities()) {
					moudto = new MOUDTO();
					moudto.setMouId(mouEntity.getMouId());
					moudto.setName(mouEntity.getName());
					moudto.setReceiptDt(mouEntity.getReceiptDt());
					moudto.setRecertificationDt(mouEntity.getRecertificationDt());
					moudto.setSigned(mouEntity.getSigned());
					moudto.setUpdatedBy(mouEntity.getUpdatedBy());
					moudto.setUpdatedTs(mouEntity.getUpdatedTs());
					if (!mouEntity.getMouDocEntities().isEmpty()) {
						List<MOUDocDTO> mouDocDTOs = new ArrayList<>();
						MOUDocDTO mouDocDTO = null;
						for (MOUDocEntity mouDocEntity : mouEntity.getMouDocEntities()) {
							if (mouDocEntity.isStatus()) {
								mouDocDTO = new MOUDocDTO();
								mouDocDTO.setMouDocId(mouDocEntity.getMouDocId());
								mouDocDTO.setFileName(mouDocEntity.getFileName());
								mouDocDTO.setStatus(mouDocEntity.isStatus());
								mouDocDTOs.add(mouDocDTO);
							}
						}
						moudto.setMouDocDTOs(mouDocDTOs);
					}
					moudtos.add(moudto);
				}
				applicationViewDTO.setMoudtos(moudtos);
			}

			if (applicationEntity.getAssessmentEntities() != null
					&& applicationEntity.getAssessmentEntities().size() > 0) {
				List<AssessmentDTO> assessmentDTOs = new ArrayList<>();
				AssessmentDTO assessmentDTO = null;
				Set<AssessmentEntity> assessmentEntities = applicationEntity.getAssessmentEntities();
				for (AssessmentEntity assessmentEntity : assessmentEntities) {
					Set<AssessmentPolicyEntity> assessmentPolicyEntities = assessmentEntity
							.getAssessmentPolicyEntities();
					AssessmentPolicyEntity assessmentPolicyEntity = null;
					if (assessmentPolicyEntities.size() > 0)
						assessmentPolicyEntity = assessmentPolicyEntities.iterator().next();
					assessmentDTO = new AssessmentDTO();
					assessmentDTO.setUpdatedBy(assessmentEntity.getUpdatedBy());
					assessmentDTO.setUpdatedTs(assessmentEntity.getUpdatedTs());
					assessmentDTO.setAssessmentDt(assessmentEntity.getAssessmentDt());
					assessmentDTO.setPolicyGrpId(
							assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity().getPolicyGrpId());
					assessmentDTO.setAuditId(assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity()
							.getAuditTypeEntity().getAuditTypeId());
					assessmentDTO.setAuditName(assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity()
							.getAuditTypeEntity().getAuditTypeName());
					assessmentDTO.setAssessmentId(assessmentEntity.getAssessmentId());
					assessmentDTO.setName(assessmentEntity.getName());
					assessmentDTO.setStatus(assessmentEntity.getStatus());
					assessmentDTO.setNextAssessmentDt(assessmentEntity.getNextAssessmentDt());
					
					assessmentDTOs.add(assessmentDTO);
				}
				applicationViewDTO.setAssessmentDTOs(assessmentDTOs);
			}

			if (applicationEntity.getWorkHoursEntities() != null
					&& applicationEntity.getWorkHoursEntities().size() > 0) {
				List<WorkHoursDTO> workHoursDTOs = new ArrayList<>();
				WorkHoursDTO workHoursDTO = null;

				for (WorkHoursEntity workHoursEntity : applicationEntity.getWorkHoursEntities()) {
					workHoursDTO = new WorkHoursDTO();
					workHoursDTO.setWorkHoursId(workHoursEntity.getWorkHoursId());
					workHoursDTO.setCloseTm(workHoursEntity.getCloseTm());
					workHoursDTO.setOpenTm(workHoursEntity.getOpenTm());
					workHoursDTO.setDay(workHoursEntity.getDay());
					workHoursDTOs.add(workHoursDTO);
				}
				applicationViewDTO.setWorkHoursDTOs(workHoursDTOs);
			}

			if (applicationEntity.getAppSolutionEntities() != null
					&& !applicationEntity.getAppSolutionEntities().isEmpty()) {
				applicationViewDTO.setApplicationSolutionDTOs(
						electionServices.getAppSolutions(applicationEntity.getAppSolutionEntities()));
			}
		}

		return applicationViewDTO;
	}

	@Override
	@Transactional
	public int getIAMUserId(int iamId) {
		UserEntity userEntity = applicationDao.getUserByIAMId(iamId);
		int userId = 0;
		if (userEntity != null)
			userId = userEntity.getUserId();
		return userId;
	}

	@Override
	@Transactional
	public List<String> getOfficeAcronyms() {
		List<String> acronyms = new ArrayList<String>();
		List<OfficeEntity> officeEntities = applicationDao.getOffices();
		for (OfficeEntity officeEntity : officeEntities) {
			acronyms.add(officeEntity.getAcronym());
		}
		return acronyms;
	}

	@Override
	@Transactional
	public List<AppDisp> getApps(String rowName, String colName, String tech) {
		List<AppDisp> appDisps = new ArrayList<AppDisp>(0);
		AppDisp appDisp = null;

		List<ApplicationEntity> applicationEntities = applicationDao.getApps(rowName, colName, tech);
		for (ApplicationEntity applicationEntity : applicationEntities) {
			appDisp = new AppDisp();
			appDisp.setAcronym(applicationEntity.getAcronym());
			appDisp.setName(applicationEntity.getName());
			appDisps.add(appDisp);
		}
		return appDisps;
	}

	private DatabaseDTO convertDBEntityToDTO(DatabaseEntity databaseEntity) {
		DatabaseDTO databaseDTO = null;
		databaseDTO.setDatabaseId(databaseEntity.getDatabaseId());

		return databaseDTO;
	}

	private ServerDTO convertServerEntityToDTO(ServerEntity serverEntity) {
		ServerDTO serverDTO = null;
		serverDTO.setServerId(serverEntity.getServerId());

		return serverDTO;
	}

	private FiscalYearInfoDTO convertFyEntitytoDTO(FiscalYearInfoEntity fyEntity) {

		FiscalYearInfoDTO fyDTO = null;
		fyDTO.setFyId(fyEntity.getFyId());

		return fyDTO;
	}

	@Override
	@Transactional
	public Set<ApplicationDTO> getAllApplications() {
		Set<ApplicationDTO> applicationDTOs = new HashSet<>(0);
		ApplicationDTO applicationDTO = null;
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getAppStatusEntities().size() == 4) {
				applicationDTO = new ApplicationDTO();
				applicationDTO.setAcronym(applicationEntity.getAcronym());
				applicationDTO.setName(applicationEntity.getName());
				applicationDTO.setApplicationId(applicationEntity.getApplicationId());
				applicationDTO.setBusinessOwnerNameDoe(applicationEntity.getBusinessOwnerNameDoe());
				applicationDTO.setSystemOwnerNameDoe(applicationEntity.getSystemOwnerNameDoe());
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
					Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity
							.getAppBusinessOwnerEntities();
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
		}
		return applicationDTOs;
	}

	@Override
	@Transactional
	public List<AuditDashBoardDTO> getApplicationAudits(Integer year) {
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();
		List<AuditDashBoardDTO> auditDashBoardDTOs = new ArrayList<>();
		AuditDashBoardDTO auditDashBoardDTO = null;
		Calendar cal = Calendar.getInstance();
		for (ApplicationEntity applicationEntity : applicationEntities) {
			int inProgress = 0, completed = 0, suspended = 0;
			auditDashBoardDTO = new AuditDashBoardDTO();

			auditDashBoardDTO.setApplicationAcronym(applicationEntity.getAcronym());
			Set<AppAuditEntity> appAuditEntities = applicationEntity.getAppAuditEntities();
			if (!appAuditEntities.isEmpty()) {
				for (AppAuditEntity appAuditEntity : appAuditEntities) {

					if (appAuditEntity.getAuditDate() != null) {
						cal.setTime(appAuditEntity.getAuditDate());
						if (cal.get(Calendar.YEAR) == year) {

							if (appAuditEntity.getStatus().equalsIgnoreCase("Open")) {
								inProgress++;
								// completed++;
							} else if (appAuditEntity.getStatus().equalsIgnoreCase("Close")) {
								// inProgress++;
								completed++;
							} else if (appAuditEntity.getStatus().equalsIgnoreCase("Suspended")) {
								// inProgress++;
								suspended++;
							}
						}

					}
				}
				auditDashBoardDTO.setCompleted(completed);
				auditDashBoardDTO.setInProgress(inProgress);
				auditDashBoardDTO.setSuspended(suspended);
				auditDashBoardDTOs.add(auditDashBoardDTO);
			}
		}
		return auditDashBoardDTOs;
	}

	@Override
	@Transactional
	public List<AuditTypeDashBoardDTO> getAuditTypeAudits(Integer year) {
		List<AuditTypeDashBoardDTO> auditTypeDashBoardDTOs = new ArrayList<>();
		AuditTypeDashBoardDTO auditTypeDashBoardDTO = null;
		List<AuditTypeEntity> auditTypeEntities = applicationDao.getAuditTypes();

		for (AuditTypeEntity auditTypeEntity : auditTypeEntities) {
			int inProgress = 0, completed = 0, suspended = 0;
			Calendar cal = Calendar.getInstance();
			auditTypeDashBoardDTO = new AuditTypeDashBoardDTO();
			auditTypeDashBoardDTO.setAuditTypeName(auditTypeEntity.getAuditTypeName());
			List<AppAuditEntity> appAuditEntities = applicationDao.getAuditsOnType(auditTypeEntity.getAuditTypeId());
			int id = 0;
			for (AppAuditEntity appAuditEntity : appAuditEntities) {
				if (id == 0) {
					id = auditTypeEntity.getAuditTypeId();
				}
				if (appAuditEntity.getAuditDate() != null) {
					cal = Calendar.getInstance();
					cal.setTime(appAuditEntity.getAuditDate());

					if (cal.get(Calendar.YEAR) == year) {
						if (appAuditEntity.getStatus().equalsIgnoreCase("Open")) {
							inProgress++;
							// completed++;
						} else if (appAuditEntity.getStatus().equalsIgnoreCase("Close")) {
							// inProgress++;
							completed++;
						} else if (appAuditEntity.getStatus().equalsIgnoreCase("Suspended")) {
							// inProgress++;
							suspended++;
						}
					}
				}
			}
			auditTypeDashBoardDTO.setCompleted(completed);
			auditTypeDashBoardDTO.setSuspended(suspended);
			auditTypeDashBoardDTO.setInProgress(inProgress);
			auditTypeDashBoardDTO.setAuditTypeId(id);
			auditTypeDashBoardDTOs.add(auditTypeDashBoardDTO);
		}
		return auditTypeDashBoardDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationDTO> getPendingApplications() {
		Set<ApplicationDTO> applicationDTOs = new HashSet<>(0);
		ApplicationDTO applicationDTO = null;
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 0) {

				applicationDTO = new ApplicationDTO();
				// statusCount
				applicationDTO.setStatusCount(applicationEntity.getAppStatusEntities().size());

				applicationDTO.setBusinessOwnerNameDoe(applicationEntity.getBusinessOwnerNameDoe());
				applicationDTO.setSystemOwnerNameDoe(applicationEntity.getSystemOwnerNameDoe());
				applicationDTO.setAcronym(applicationEntity.getAcronym());
				applicationDTO.setUpdatedTs(applicationEntity.getUpdatedTs());
				applicationDTO.setUpdatedBy(applicationEntity.getUpdatedBy());
				// applicationDTO.setName(applicationEntity.getName());
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
					Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity
							.getAppBusinessOwnerEntities();
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
		}
		return applicationDTOs;
	}

	@Override
	@Transactional
	public Set<SystemSensitivityDTO> getSystemSensitivity() {
		Set<SystemSensitivityDTO> systemSensitivityDTOs = new HashSet<SystemSensitivityDTO>(0);
		SystemSensitivityDTO systemSensitivityDTO = null;
		List<SystemSensitivityEntity> systemSensitivityEntities = applicationDao.getSystemSensitivity();

		for (SystemSensitivityEntity systemSensitivityEntity : systemSensitivityEntities) {
			systemSensitivityDTO = new SystemSensitivityDTO();
			systemSensitivityDTO.setSystemSensitivityValue(systemSensitivityEntity.getSystemSensitivityValue());
			systemSensitivityDTO.setSystemSensitivityId(systemSensitivityEntity.getSystemSensitivityId());
			systemSensitivityDTOs.add(systemSensitivityDTO);
		}
		return systemSensitivityDTOs;
	}

	@Override
	@Transactional
	public List<AuditTypeDTO> getAuditTypes() {

		List<AuditTypeDTO> auditTypeDTOs = new ArrayList<AuditTypeDTO>();
		AuditTypeDTO auditTypeDTO = null;

		List<AuditTypeEntity> auditTypeEntities = applicationDao.getAuditTypes();

		for (AuditTypeEntity auditTypeEntity : auditTypeEntities) {
			auditTypeDTO = new AuditTypeDTO();
			auditTypeDTO.setAuditTypeId(auditTypeEntity.getAuditTypeId());
			auditTypeDTO.setAuditTypeName(auditTypeEntity.getAuditTypeName());
			auditTypeDTOs.add(auditTypeDTO);
		}

		return auditTypeDTOs;
	}

	@Override
	@Transactional
	public List<ApplicationViewDTO> getLocationForView() {

		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();
		List<ApplicationViewDTO> applicationViewDTOs = new ArrayList<>(0);
		ApplicationViewDTO applicationViewDTO = null;
		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 1) {

				if (applicationEntity != null) {
					applicationViewDTO = new ApplicationViewDTO();
					applicationViewDTO.setApplicationId(applicationEntity.getApplicationId());
					applicationViewDTO.setAcronym(applicationEntity.getAcronym());
					// applicationViewDTO.setName(applicationEntity.getName());
					// if (applicationEntity.getuserEntityByModifiedBy() != null)
					// applicationViewDTO.setModifiedByName(applicationEntity.getuserEntityByModifiedBy().getFirstName()
					// + " "
					// + applicationEntity.getuserEntityByModifiedBy().getLastName());
					// applicationViewDTO.setModifiedTs(applicationEntity.getUpdatedTs());
					// applicationViewDTO.setLevelOfEffort(applicationEntity.getLevelOfEffort());

					applicationViewDTO.setLocalityCd(applicationEntity.getLocalityCd());
					applicationViewDTO.setFipsCd(applicationEntity.getFipsCd());
					applicationViewDTO.setFirstName(applicationEntity.getFirstName());
					applicationViewDTO.setLastName(applicationEntity.getLastName());
					applicationViewDTO.setEmailId(applicationEntity.getEmailId());
					applicationViewDTO.setPhoneNumber(applicationEntity.getPhoneNumber());
					applicationViewDTO.setWebsite(applicationEntity.getWebsite());
					applicationViewDTO.setVerisId(applicationEntity.getVerisId());
					applicationViewDTO.setCapInd(applicationEntity.getCapInd());
					applicationViewDTO.setBailoutInd(applicationEntity.isBailoutInd());
					applicationViewDTO.setPenality(applicationEntity.getPenality());
					applicationViewDTO.setVebaRegion(applicationEntity.isVebaRegion());
					applicationViewDTO.setVravRegion(applicationEntity.isVravRegion());
					applicationViewDTO.setPaperPollbook(applicationEntity.isPaperPollbook());
					applicationViewDTO.setElectronicPollbook(applicationEntity.isElectronicPollbook());
					applicationViewDTO.setNotes(applicationEntity.getNotes());
					applicationViewDTO.setActiveLocality(applicationEntity.getActiveLocality());
					applicationViewDTO.setBusinessOwnerNameDoe(applicationEntity.getBusinessOwnerNameDoe());
					applicationViewDTO.setSystemOwnerNameDoe(applicationEntity.getSystemOwnerNameDoe());

					//
					// if (applicationEntity.getuserEntityByUpdatedBy() != null)
					// applicationViewDTO.setUpdatedBy(applicationEntity.getuserEntityByUpdatedBy().getFirstName()
					// + " "
					// + applicationEntity.getuserEntityByUpdatedBy().getLastName());

					//
					// if (applicationEntity.getApplicationServerEntities().size() > 0) {
					// Set<ApplicationServerEntity> applicationServerEntities = applicationEntity
					// .getApplicationServerEntities();
					// List<ApplicationServerDTO> applicationServerDTOs = new ArrayList<>();
					// ApplicationServerDTO applicationServerDTO = null;
					//
					// for (ApplicationServerEntity applicationServerEntity :
					// applicationServerEntities) {
					//
					// if (applicationServerEntity.isActivityFlag()) {
					// applicationServerDTO = new ApplicationServerDTO();
					// applicationServerDTO.setName(applicationServerEntity.getServerEntity().getName());
					// applicationServerDTO.setServerId(applicationServerEntity.getServerEntity().getServerId());
					// applicationServerDTO.setNewEntry(false);
					// applicationServerDTO.setApplicationServerId(applicationServerEntity.getApplicationServerId());
					// applicationServerDTO.setActive(applicationServerEntity.isActivityFlag());
					// applicationServerDTOs.add(applicationServerDTO);
					// }
					// }
					// applicationViewDTO.setApplicationServerDTOs(applicationServerDTOs);
					// }
					//
					// if (applicationEntity.getApplicationAuditEntities().size() > 0) {
					// Set<ApplicationAuditEntity> applicationAuditEntities =
					// applicationEntity.getApplicationAuditEntities();
					//
					// for (ApplicationAuditEntity applicationAuditEntity :
					// applicationAuditEntities) {
					//
					// if (applicationAuditEntity.isActivityFlag()) {
					//
					// applicationViewDTO.setLastAudit(applicationAuditEntity.getAuditEntity().getLastAudit());
					// applicationViewDTO.setUpcomingAudit(applicationAuditEntity.getAuditEntity().getUpComingAudit());
					// applicationViewDTO.setAuditComments(applicationAuditEntity.getAuditEntity().getComments());
					// applicationViewDTO.setAuditId(applicationAuditEntity.getAuditEntity().getAuditId());
					//
					// }
					// }
					//
					// }

					//
					// if (applicationEntity.getApplicationDatabaseEntities().size() > 0) {
					// Set<ApplicationDatabaseEntity> applicationDatabaseEntities =
					// applicationEntity
					// .getApplicationDatabaseEntities();
					// List<ApplicationDatabaseDTO> applicationDatabaseDTOs = new ArrayList<>();
					// ApplicationDatabaseDTO applicationDatabaseDTO = null;
					// for (ApplicationDatabaseEntity applicationDatabaseEntity :
					// applicationDatabaseEntities) {
					// if (applicationDatabaseEntity.isActivityFlag()) {
					// applicationDatabaseDTO = new ApplicationDatabaseDTO();
					// applicationDatabaseDTO.setHostName(applicationDatabaseEntity.getDatabaseEntity().getHostName());
					// applicationDatabaseDTO.setNewEntry(false);
					// applicationDatabaseDTO.setActive(applicationDatabaseEntity.isActivityFlag());
					// applicationDatabaseDTO
					// .setDatabaseId(applicationDatabaseEntity.getDatabaseEntity().getDatabaseId());
					// applicationDatabaseDTOs.add(applicationDatabaseDTO);
					// }
					// }
					// applicationViewDTO.setApplicationDatabaseDTOs(applicationDatabaseDTOs);
					// }

					//
					// if (applicationEntity.getAppAuditEntities() != null &&
					// applicationEntity.getAppAuditEntities().size() > 0) {
					// List<AppAuditDTO> appAuditDTOs = new ArrayList<>();
					// AppAuditDTO appAuditDTO = null;
					// Set<AppAuditEntity> appAuditEntities =
					// applicationEntity.getAppAuditEntities();
					// for (AppAuditEntity appAuditEntity : appAuditEntities) {
					// appAuditDTO = new AppAuditDTO();
					// try {
					// BeanUtils.copyProperties(appAuditDTO, appAuditEntity);
					// appAuditDTO.setPolicyGrpId(appAuditEntity.getPolicyGrpEntity().getPolicyGrpId());
					// appAuditDTO.setAuditTypeName(
					// appAuditEntity.getPolicyGrpEntity().getAuditTypeEntity().getAuditTypeName());
					// } catch (IllegalAccessException | InvocationTargetException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// if (appAuditEntity.getAppAuditFileEntities().size() > 0) {
					// List<AppAuditFileEntity> appAuditFileEntities =
					// appAuditEntity.getAppAuditFileEntities();
					// AppAuditFileDTO appAuditFileDTO = null;
					//
					// List<AppAuditFileDTO> appAuditFileDTOs = new ArrayList<>();
					//
					// for (AppAuditFileEntity appAuditFileEntity : appAuditFileEntities) {
					// appAuditFileDTO = new AppAuditFileDTO();
					// appAuditFileDTO.setAppAuditFileId(appAuditFileEntity.getAppAuditFileId());
					// appAuditFileDTO.setStatus(appAuditFileEntity.getStatus());
					// appAuditFileDTO.setFileName(appAuditFileEntity.getFileName());
					// appAuditFileDTOs.add(appAuditFileDTO);
					// }
					// appAuditDTO.setAppAuditFileDTOs(appAuditFileDTOs);
					// }
					//
					// if (appAuditEntity.getAppAuditPolicyEntities().size() > 0) {
					// List<AuditPolicyDTO> auditPolicyDTOs = new ArrayList<>(0);
					// AuditPolicyDTO auditPolicyDTO = null;
					// List<AppAuditPolicyEntity> appAuditPolicyEntities =
					// appAuditEntity.getAppAuditPolicyEntities();
					// for (AppAuditPolicyEntity appAuditPolicyEntity : appAuditPolicyEntities) {
					// auditPolicyDTO = new AuditPolicyDTO();
					// auditPolicyDTO.setDefaultVal(appAuditPolicyEntity.getDefaultVal());
					// auditPolicyDTO.setStatus(appAuditPolicyEntity.getStatus());
					// auditPolicyDTO.setPolicyId(appAuditPolicyEntity.getPolicyEntity().getPolicyId());
					// auditPolicyDTO.setControlNumber(appAuditPolicyEntity.getPolicyEntity().getControlNumber());
					// auditPolicyDTO.setPolicyName(appAuditPolicyEntity.getPolicyEntity().getPolicyName());
					// auditPolicyDTO.setDescription(appAuditPolicyEntity.getPolicyEntity().getDescription());
					// auditPolicyDTO.setPolicyGrpId(
					// appAuditPolicyEntity.getPolicyEntity().getPolicyGrpEntity().getPolicyGrpId());
					// auditPolicyDTO.setPolicyVal(appAuditPolicyEntity.getPolicyEntity().getPolicyVal());
					// auditPolicyDTO.setAppAuditPolicyId(appAuditPolicyEntity.getAppAuditPolicyId());
					// auditPolicyDTO.setPriority(appAuditPolicyEntity.getPolicyEntity().getPriority());
					// auditPolicyDTO.setProcedures(appAuditPolicyEntity.getPolicyEntity().getProcedures());
					// auditPolicyDTO.setGuidelines(appAuditPolicyEntity.getPolicyEntity().getGuidelines());
					// auditPolicyDTOs.add(auditPolicyDTO);
					// }
					// appAuditDTO.setAuditPolicyDTOs(auditPolicyDTOs);
					// }
					//
					// appAuditDTOs.add(appAuditDTO);
					// }
					// applicationViewDTO.setAppAuditDTOs(appAuditDTOs);
					// }

					if (applicationEntity.getMouEntities() != null && !applicationEntity.getMouEntities().isEmpty()) {
						List<MOUDTO> moudtos = new ArrayList<>();
						MOUDTO moudto = null;
						for (MOUEntity mouEntity : applicationEntity.getMouEntities()) {
							moudto = new MOUDTO();
							moudto.setMouId(mouEntity.getMouId());
							moudto.setApplicationAcronym(applicationEntity.getAcronym());
							moudto.setName(mouEntity.getName());
							moudto.setReceiptDt(mouEntity.getReceiptDt());
							moudto.setRecertificationDt(mouEntity.getRecertificationDt());
							moudto.setSigned(mouEntity.getSigned());
							// if (!mouEntity.getMouDocEntities().isEmpty()) {
							// List<MOUDocDTO> mouDocDTOs = new ArrayList<>();
							// MOUDocDTO mouDocDTO = null;
							// for (MOUDocEntity mouDocEntity : mouEntity.getMouDocEntities()) {
							// if (mouDocEntity.isStatus()) {
							// mouDocDTO = new MOUDocDTO();
							// mouDocDTO.setMouDocId(mouDocEntity.getMouDocId());
							// mouDocDTO.setFileName(mouDocEntity.getFileName());
							// mouDocDTO.setStatus(mouDocEntity.isStatus());
							// mouDocDTOs.add(mouDocDTO);
							// }
							// }
							// moudto.setMouDocDTOs(mouDocDTOs);
							// }
							moudtos.add(moudto);
						}
						applicationViewDTO.setMoudtos(moudtos);
					}

					// if (applicationEntity.getAppSolutionEntities() != null
					// && !applicationEntity.getAppSolutionEntities().isEmpty()) {
					// applicationViewDTO.setApplicationSolutionDTOs(
					// electionServices.getAppSolutions(applicationEntity.getAppSolutionEntities()));
					// }
				}
			}
			applicationViewDTOs.add(applicationViewDTO);
		}

		return applicationViewDTOs;
	}
	////////////////////////////////

	@Override
	@Transactional
	public AuditTypeDTO addAuditType(AuditTypeDTO auditTypeDTO) {
		AuditTypeEntity auditTypeEntity = new AuditTypeEntity();
		auditTypeEntity.setAuditTypeName(auditTypeDTO.getAuditTypeName());
		auditTypeEntity.setActive(true);
		auditTypeEntity.setCreatedBy(auditTypeDTO.getCreatedBy());
		auditTypeEntity.setCreatedTs(new Date());
		auditTypeEntity = applicationDao.saveAuditTypeEntity(auditTypeEntity);
		auditTypeDTO.setAuditTypeId(auditTypeEntity.getAuditTypeId());
		return auditTypeDTO;
	}

	@Override
	@Transactional
	public ApplicationResp saveAppAuditInfo(AppAuditDTO appAuditDTO) {
		AppAuditEntity appAuditEntity = new AppAuditEntity();
		ApplicationResp applicationResp = new ApplicationResp();

		try {
			BeanUtils.copyProperties(appAuditEntity, appAuditDTO);

			PolicyGrpEntity policyGrpEntity = policyDao.getPolicyGRPEntity(appAuditDTO.getPolicyGrpId());
			AuditTypeEntity auditTypeEntity = policyGrpEntity.getAuditTypeEntity();
			ApplicationEntity applicationEntity = applicationDao.getApplicationOnId(appAuditDTO.getApplicationID());
			if (applicationEntity != null) {
				List<AppAuditEntity> appAuditEntityList = policyGrpEntity.getAppAuditEntities();

				// appAuditEntity.setAuditTypeEntity(auditTypeEntity);
				appAuditEntity.setPolicyGrpEntity(policyGrpEntity);
				appAuditEntity.setAuditTypeId(policyGrpEntity.getAuditTypeEntity().getAuditTypeId());
				appAuditEntity.setStatus("Open");
				appAuditEntity.setActionPlanCloseoutComments(appAuditDTO.getActionPlanCloseoutComments());
				appAuditEntity.setActionPlanTasks(appAuditDTO.getActionPlanTasks());
				appAuditEntity.setCreatedTs(new Date());
				appAuditEntity.setUpadateTs(new Date());
				appAuditEntity.setUpdatedBy(appAuditDTO.getCreatedBy());
				appAuditEntity.setCreatedBy(appAuditDTO.getCreatedBy());

				if (appAuditDTO.getAppAuditFileDTOs() != null && appAuditDTO.getAppAuditFileDTOs().size() > 0) {
					AppAuditFileEntity appAuditFileEntity = null;
					List<AppAuditFileEntity> appAuditFileEntities = new ArrayList<>(0);

					List<AppAuditFileDTO> appAuditFileDTOs = appAuditDTO.getAppAuditFileDTOs();
					for (AppAuditFileDTO appAuditFileDTO : appAuditFileDTOs) {
						appAuditFileEntity = new AppAuditFileEntity();
						appAuditFileEntity.setFileName(appAuditFileDTO.getFileName());
						appAuditFileEntity
								.setFileContent((appAuditFileDTO.getFileContent().split("base64,")[1]).getBytes());
						appAuditFileEntity.setCreatedBy(appAuditDTO.getCreatedBy());
						appAuditFileEntity.setAppAuditEntity(appAuditEntity);
						appAuditFileEntity.setCreatedTs(new Date());
						appAuditFileEntity.setStatus(true);
						appAuditFileEntities.add(appAuditFileEntity);
					}
					appAuditEntity.setAppAuditFileEntities(appAuditFileEntities);
				}

				if (appAuditDTO.getAuditPolicyDTOs() != null && !appAuditDTO.getAuditPolicyDTOs().isEmpty()) {
					List<AuditPolicyDTO> auditPolicyDTOs = appAuditDTO.getAuditPolicyDTOs();
					List<AppAuditPolicyEntity> appAuditPolicyEntities = new ArrayList<>();
					AppAuditPolicyEntity appAuditPolicyEntity = null;
					for (AuditPolicyDTO auditPolicyDTO : auditPolicyDTOs) {
						appAuditPolicyEntity = new AppAuditPolicyEntity();
						appAuditPolicyEntity.setStatus(auditPolicyDTO.getStatus());
						appAuditPolicyEntity.setPolicyEntity(policyDao.getPolicyEntityOnName(
								auditPolicyDTO.getControlNumber(), auditPolicyDTO.getPolicyGrpId()));
						appAuditPolicyEntity.setAppAuditEntity(appAuditEntity);
						appAuditPolicyEntities.add(appAuditPolicyEntity);
					}
					appAuditEntity.setAppAuditPolicyEntities(appAuditPolicyEntities);
				}

				appAuditEntity.setApplicationEntity(applicationEntity);
				appAuditEntityList.add(appAuditEntity);
				policyGrpEntity.setAppAuditEntities(appAuditEntityList);
				Set<AppAuditEntity> appAuditEntities = applicationEntity.getAppAuditEntities();
				appAuditEntities.add(appAuditEntity);
				applicationEntity.setAppAuditEntities(appAuditEntities);
				applicationDao.updateApplication(applicationEntity);
				applicationResp.setResponseCode(Integer.parseInt(
						messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			applicationResp.setResponseCode(Integer
					.parseInt(messageSource.getMessage("APPLICATION.GENERAL.FAIL.CODE", null, Locale.getDefault())));
			return applicationResp;
		}
		return applicationResp;
	}

	@Override
	@Transactional
	public ApplicationResp updateAppAuditInfo(AppAuditDTO appAuditDTO) {
		AppAuditEntity appAuditEntity = applicationDao.getAppAudit(appAuditDTO.getAppAuditId());
		ApplicationResp applicationResp = new ApplicationResp();
		try {
			BeanUtils.copyProperties(appAuditEntity, appAuditDTO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		appAuditEntity.setActionPlan(appAuditDTO.getActionPlan());
		appAuditEntity.setAuditBy(appAuditDTO.getAuditBy());
		appAuditEntity.setAuditDate(appAuditDTO.getAuditDate());
		appAuditEntity.setAuditFindings(appAuditDTO.getAuditFindings());
		appAuditEntity.setAuditType(appAuditDTO.getAuditType());
		appAuditEntity.setAuditDetails(appAuditDTO.getAuditDetails());
		appAuditEntity.setBudget(appAuditDTO.getBudget());
		appAuditEntity.setBusinessRisks(appAuditDTO.getBusinessRisks());
		appAuditEntity.setManagementReponse(appAuditDTO.getManagementReponse());
		appAuditEntity.setNextAuditDate(appAuditDTO.getNextAuditDate());
		appAuditEntity.setRecomendations(appAuditDTO.getRecomendations());
		appAuditEntity.setStatus(appAuditDTO.getStatus());
		appAuditEntity.setSecurityRisks(appAuditDTO.getSecurityRisks());
		appAuditEntity.setActionPlanCloseoutComments(appAuditDTO.getActionPlanCloseoutComments());
		appAuditEntity.setActionPlanTasks(appAuditDTO.getActionPlanTasks());
		appAuditEntity.setUpadateTs(new Date());
		appAuditEntity.setUpdatedBy(appAuditDTO.getUpdatedBy());
		if (appAuditDTO.getAppAuditFileDTOs() != null && appAuditDTO.getAppAuditFileDTOs().size() > 0) {
			AppAuditFileEntity appAuditFileEntity = null;
			List<AppAuditFileEntity> appAuditFileEntities = null;
			if (!appAuditEntity.getAppAuditFileEntities().isEmpty())
				appAuditFileEntities = appAuditEntity.getAppAuditFileEntities();
			else
				appAuditFileEntities = new ArrayList<>();

			List<AppAuditFileDTO> appAuditFileDTOs = appAuditDTO.getAppAuditFileDTOs();

			for (AppAuditFileDTO appAuditFileDTO : appAuditFileDTOs) {
				if (appAuditFileDTO.getAppAuditFileId() != null) {
					for (AppAuditFileEntity appAuditFileEntity2 : appAuditFileEntities) {
						if (appAuditFileEntity2.getAppAuditFileId().equals(appAuditFileDTO.getAppAuditFileId())
								&& !appAuditFileDTO.getStatus()) {
							appAuditFileEntity2.setStatus(false);
						}
					}
				} else {
					appAuditFileEntity = new AppAuditFileEntity();
					appAuditFileEntity.setFileName(appAuditFileDTO.getFileName());
					appAuditFileEntity
							.setFileContent((appAuditFileDTO.getFileContent().split("base64,")[1]).getBytes());
					appAuditFileEntity.setCreatedBy(appAuditDTO.getUpdatedBy());
					appAuditFileEntity.setAppAuditEntity(appAuditEntity);
					appAuditFileEntity.setCreatedTs(new Date());
					appAuditFileEntity.setStatus(true);
					appAuditFileEntities.add(appAuditFileEntity);
				}
			}
			appAuditEntity.setAppAuditFileEntities(appAuditFileEntities);
		}

		if (appAuditDTO.getAuditPolicyDTOs() != null && !appAuditDTO.getAuditPolicyDTOs().isEmpty()) {
			List<AuditPolicyDTO> auditPolicyDTOs = appAuditDTO.getAuditPolicyDTOs();
			List<AppAuditPolicyEntity> appAuditPolicyEntities = new ArrayList<>();
			AppAuditPolicyEntity appAuditPolicyEntity = null;
			for (AuditPolicyDTO auditPolicyDTO : auditPolicyDTOs) {
				if (auditPolicyDTO.getAppAuditPolicyId() != 0) {
					appAuditPolicyEntity = policyDao.getAppAuditPolicyEntity(auditPolicyDTO.getAppAuditPolicyId());
					if (appAuditPolicyEntity != null) {
						if (!appAuditPolicyEntity.getStatus().equalsIgnoreCase(auditPolicyDTO.getStatus())) {
							appAuditPolicyEntity.setStatus(auditPolicyDTO.getStatus());
							appAuditPolicyEntity.setUpdatedBy(appAuditDTO.getUpdatedBy());
							appAuditPolicyEntity.setUpdatedTs(new Date());
							appAuditPolicyEntities.add(appAuditPolicyEntity);
						}
					}
				} else {
					appAuditPolicyEntity = new AppAuditPolicyEntity();
					appAuditPolicyEntity.setStatus(auditPolicyDTO.getStatus());
					appAuditPolicyEntity.setPolicyEntity(policyDao
							.getPolicyEntityOnName(auditPolicyDTO.getControlNumber(), auditPolicyDTO.getPolicyGrpId()));
					appAuditPolicyEntity.setAppAuditEntity(appAuditEntity);
					appAuditPolicyEntities.add(appAuditPolicyEntity);
				}

			}
			appAuditEntity.setAppAuditPolicyEntities(appAuditPolicyEntities);
		}

		applicationDao.updateAppAudit(appAuditEntity);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));

		return applicationResp;
	}

	@Override
	@Transactional
	public AppAuditFileDTO getAppAuditFile(Integer fileId) {
		AppAuditFileEntity appAuditFileEntity = applicationDao.applicationDao(fileId);
		AppAuditFileDTO appAuditFileDTO = null;
		if (appAuditFileEntity != null) {
			appAuditFileDTO = new AppAuditFileDTO();
			appAuditFileDTO.setFileContent(new String(appAuditFileEntity.getFileContent()));
			appAuditFileDTO.setFileName(appAuditFileEntity.getFileName());

		}
		return appAuditFileDTO;
	}

	@Override
	@Transactional
	public ApplicationUserDTO getUser(Integer userId) {
		ApplicationUserDTO applicationUserDTO = null;
		UserEntity userEntity = applicationDao.getUserById(userId);
		if (userEntity != null) {
			applicationUserDTO = new ApplicationUserDTO();
			applicationUserDTO.setUserId(userEntity.getUserId());
			applicationUserDTO.setFirstName(userEntity.getFirstName());
			applicationUserDTO.setLastName(userEntity.getLastName());
		}

		return applicationUserDTO;
	}

	@Override
	@Transactional
	public ApplicationUserDTO addUser(ApplicationUserDTO applicationUserDTO) {
		UserAppRoleEntity userAppRoleEntity = userDao.getUserRoleEntityOnRoleName(applicationUserDTO.getRole());
		List<UserEntity> userEntities = userDao.getUsersOnRole(userAppRoleEntity.getAppRoleId());

		for (UserEntity userEntity1 : userEntities) {
			if (userEntity1.getFirstName().equalsIgnoreCase(applicationUserDTO.getFirstName())
					&& userEntity1.getLastName().equalsIgnoreCase(applicationUserDTO.getLastName())
					&& userEntity1.getEmailId().equalsIgnoreCase(applicationUserDTO.getEmailId()))
				return null;
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(applicationUserDTO.getFirstName());
		userEntity.setLastName(applicationUserDTO.getLastName());
		userEntity.setEmailId(applicationUserDTO.getEmailId());

		userEntity.setUserAppRoleEntity(userAppRoleEntity);
		userEntity = userDao.saveUser(userEntity);
		applicationUserDTO.setUserId(userEntity.getUserId());
		return applicationUserDTO;
	}

	@Override
	@Transactional
	public TechnologiesDTO getTechnology(Integer technologyId) {
		TechnologiesDTO technologiesDTO = null;
		TechnologiesEntity technologiesEntity = applicationDao.getTechnologyEntity(technologyId);
		if (technologiesEntity != null) {
			technologiesDTO = new TechnologiesDTO();
			technologiesDTO.setTechnologyId(technologiesEntity.getTechnologyId());
			technologiesDTO.setName(technologiesEntity.getName());
			technologiesDTO.setTechnologyVersion(technologiesEntity.getTechnologyVersion());
		}
		return technologiesDTO;
	}

	@Override
	@Transactional
	public List<AppAuditDTO> getAudits() {
		List<AppAuditDTO> audAppAuditDTOs = new ArrayList<>();
		AppAuditDTO appAuditDTO = null;
		List<AppAuditEntity> auditEntities = applicationDao.allAudits();

		for (AppAuditEntity appAuditEntity : auditEntities) {
			appAuditDTO = new AppAuditDTO();
			try {
				BeanUtils.copyProperties(appAuditDTO, appAuditEntity);
				appAuditDTO.setApplicationID(appAuditEntity.getApplicationEntity().getApplicationId());
				appAuditDTO.setAppAcronym(appAuditEntity.getApplicationEntity().getAcronym());
				AuditTypeEntity auditTypeEntity = applicationDao
						.getAuditType(Integer.parseInt(appAuditEntity.getAuditName()));
				appAuditDTO.setAuditName(auditTypeEntity.getAuditTypeName());
				if (appAuditEntity.getPolicyGrpEntity() == null) {
					appAuditDTO.setAuditType("");
				} else {
					appAuditDTO.setAuditType(appAuditEntity.getPolicyGrpEntity().getPolicyGrpName());
				}
				// appAuditDTO.setAuditType(appAuditEntity.getAuditType());
				audAppAuditDTOs.add(appAuditDTO);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		return audAppAuditDTOs;
	}

	@Override
	@Transactional
	public List<AppAuditDTO> upComingAudits() {
		List<AppAuditDTO> audAppAuditDTOs = new ArrayList<>();
		AppAuditDTO appAuditDTO = null;
		List<AppAuditEntity> auditEntities = applicationDao.upComingAudits();

		for (AppAuditEntity appAuditEntity : auditEntities) {
			appAuditDTO = new AppAuditDTO();
			try {
				BeanUtils.copyProperties(appAuditDTO, appAuditEntity);
				appAuditDTO.setApplicationID(appAuditEntity.getApplicationEntity().getApplicationId());
				appAuditDTO.setAppAcronym(appAuditEntity.getApplicationEntity().getAcronym());
				AuditTypeEntity auditTypeEntity = applicationDao
						.getAuditType(Integer.parseInt(appAuditEntity.getAuditName()));
				appAuditDTO.setAuditName(auditTypeEntity.getAuditTypeName());
				if (appAuditEntity.getAppAuditPolicyEntities().isEmpty()) {
					appAuditDTO.setAuditType("");
				} else {
					appAuditDTO.setAuditType(appAuditEntity.getAppAuditPolicyEntities().get(0).getPolicyEntity()
							.getPolicyGrpEntity().getPolicyGrpName());
				}
				// appAuditDTO.setAuditType(appAuditEntity.getAuditType());
				audAppAuditDTOs.add(appAuditDTO);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		return audAppAuditDTOs;
	}

	@Override
	@Transactional
	public Set<ApplicationUserDTO> getUseronName(String userName) {
		Set<ApplicationUserDTO> userDTOs = new HashSet<ApplicationUserDTO>();
		ApplicationUserDTO applicationUserDTO = null;
		String[] name = null;
		String fname = null, lname = null;
		if (userName != null) {
			name = userName.split(" ");
			fname = name[0] + "%";
			if (name.length > 1)
				lname = name[1] + "%";
		}

		List<UserEntity> userEntities = userDao.getUseronName(fname, lname);
		for (UserEntity userEntity : userEntities) {
			applicationUserDTO = new ApplicationUserDTO();
			applicationUserDTO.setFirstName(userEntity.getFirstName());
			applicationUserDTO.setLastName(userEntity.getLastName());
			applicationUserDTO.setTitle(userEntity.getTitle());
			applicationUserDTO.setUserId(userEntity.getUserId());
			applicationUserDTO.setRole(userEntity.getUserAppRoleEntity().getName());
			userDTOs.add(applicationUserDTO);

		}

		return userDTOs;
	}

	@Override
	@Transactional
	public ReportDTO getDatabaseReport(Integer databaseId) {
		List<ApplicationDatabaseEntity> applicationDatabaseEntities = reportDAO.getDatabaseReport(databaseId);
		ApplicationDTO applicationDTO = null;
		List<ApplicationDTO> applicationDTOs = new ArrayList<>();
		ApplicationEntity applicationEntity = null;
		ReportDTO reportDTO = new ReportDTO();
		OfficeDTO officeDTO = null;
		for (ApplicationDatabaseEntity applicationDatabaseEntity : applicationDatabaseEntities) {
			applicationEntity = applicationDatabaseEntity.getApplicationEntity();

			applicationDTO = new ApplicationDTO();
			// statusCount
			applicationDTO.setStatusCount(applicationEntity.getAppStatusEntities().size());
			;
			applicationDTO.setAcronym(applicationEntity.getAcronym());
			applicationDTO.setName(applicationEntity.getName());
			applicationDTO.setApplicationId(applicationEntity.getApplicationId());
			if (applicationEntity.getOfficeEntity() != null) {
				officeDTO = new OfficeDTO();
				officeDTO.setDescription(applicationEntity.getOfficeEntity().getDescription());
				applicationDTO.setOfficeTbl(officeDTO);
			}
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
		reportDTO.setApplicationDTOs(applicationDTOs);
		return reportDTO;
	}

	@Override
	@Transactional
	public ReportDTO getTechReport(Integer techId) {
		List<ApplicationTechnologyEntity> applicationTechnologyEntities = reportDAO.getTechnicalReport(techId);
		ApplicationDTO applicationDTO = null;
		List<ApplicationDTO> applicationDTOs = new ArrayList<>();
		ApplicationEntity applicationEntity = null;
		ReportDTO reportDTO = new ReportDTO();
		for (ApplicationTechnologyEntity applicationTechnologyEntity : applicationTechnologyEntities) {
			applicationEntity = applicationTechnologyEntity.getApplicationEntity();

			applicationDTO = new ApplicationDTO();
			// statusCount
			applicationDTO.setStatusCount(applicationEntity.getAppStatusEntities().size());
			;
			applicationDTO.setAcronym(applicationEntity.getAcronym());
			applicationDTO.setName(applicationEntity.getName());
			applicationDTO.setApplicationId(applicationEntity.getApplicationId());
			OfficeDTO officeDTO = null;
			if (applicationEntity.getOfficeEntity() != null) {
				officeDTO = new OfficeDTO();
				officeDTO.setDescription(applicationEntity.getOfficeEntity().getDescription());
				applicationDTO.setOfficeTbl(officeDTO);
			}
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
		reportDTO.setApplicationDTOs(applicationDTOs);
		return reportDTO;
	}

	@Override
	@Transactional
	public ReportDTO getServerReport(Integer serverId) {
		List<ApplicationServerEntity> applicationServerEntities = reportDAO.getServerReport(serverId);
		ApplicationDTO applicationDTO = null;
		List<ApplicationDTO> applicationDTOs = new ArrayList<>();
		ApplicationEntity applicationEntity = null;
		ReportDTO reportDTO = new ReportDTO();
		for (ApplicationServerEntity applicationServerEntity : applicationServerEntities) {
			applicationEntity = applicationServerEntity.getApplicationEntity();

			applicationDTO = new ApplicationDTO();
			// statusCount
			applicationDTO.setStatusCount(applicationEntity.getAppStatusEntities().size());
			;
			applicationDTO.setAcronym(applicationEntity.getAcronym());
			applicationDTO.setName(applicationEntity.getName());
			applicationDTO.setApplicationId(applicationEntity.getApplicationId());
			OfficeDTO officeDTO = null;
			if (applicationEntity.getOfficeEntity() != null) {
				officeDTO = new OfficeDTO();
				officeDTO.setDescription(applicationEntity.getOfficeEntity().getDescription());
				applicationDTO.setOfficeTbl(officeDTO);
			}
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
		reportDTO.setApplicationDTOs(applicationDTOs);
		return reportDTO;
	}

	@Override
	@Transactional
	public DatabaseDTO saveDBServerInfo(DatabaseDTO databaseDTO) {
		DatabaseEntity databaseEntity = new DatabaseEntity();
		ServerContactEntity serverContactEntity = null;

		Set<ServerContactEntity> serverContactEntities = new HashSet<>();
		try {
			BeanUtils.copyProperties(databaseEntity, databaseDTO);
			for (ServerContactDTO serverContactDTO : databaseDTO.getServerContactDTOs()) {
				serverContactEntity = new ServerContactEntity();
				serverContactEntity.setDatabaseEntity(databaseEntity);
				BeanUtils.copyProperties(serverContactEntity, serverContactDTO);

				serverContactEntities.add(serverContactEntity);
			}
			if (!serverContactEntities.isEmpty())
				databaseEntity.setServerContactEntities(serverContactEntities);
			databaseEntity.setCreatedTs(new Date());
			databaseEntity.setUpdatedTs(new Date());
			// Set<ServerContactEntity> serverContactEntities2 = new HashSet<>();
			// serverContactEntity.setDatabaseEntity(databaseEntity);
			// serverContactEntities2.add(serverContactEntity);
			// databaseEntity.setServerContactEntities(serverContactEntities2);
			databaseEntity = applicationDao.saveDatabaseServer(databaseEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	@Transactional
	public DatabaseDTO updateDBServerInfo(DatabaseDTO databaseDTO) {
		DatabaseEntity databaseEntity = applicationDao.getDatabase(databaseDTO.getDatabaseId());
		Set<ServerContactEntity> serverContactEntities1 = new HashSet<>();
		try {
			BeanUtils.copyProperties(databaseEntity, databaseDTO);
			databaseEntity.setUpdatedTs(new Date());
			if(databaseDTO.getServerContactDTOs() != null)
			{
				Set<ServerContactEntity> serverContactEntities = new HashSet<>(0);
				//ServerContactEntity serverContactEntity = null;
				 serverContactEntities1=databaseEntity.getServerContactEntities();
				for(ServerContactDTO serverContactDTO: databaseDTO.getServerContactDTOs())
			{
				  
				   for(ServerContactEntity serverContactEntity1: serverContactEntities1)
				   {
					   if(serverContactEntity1.getServerContactId() == serverContactDTO.getServerContactId())
					   {
//						   serverContactEntity.setFirstName(serverContactDTO.getFirstName());
//						   serverContactEntity.setLastName(serverContactDTO.getLastName());
//						   serverContactEntity.setEmailId(serverContactDTO.getEmailId());
//						   serverContactEntity.setPhoneNumber(serverContactDTO.getPhoneNumber());
//						   serverCo
						   BeanUtils.copyProperties(serverContactEntity1, serverContactDTO);
						   serverContactEntities.add(serverContactEntity1);
						   
					   }
				   }
				  
			}
				databaseEntity.setServerContactEntities(serverContactEntities);
				 
			}
			databaseEntity = applicationDao.updateDatabaseServer(databaseEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	@Transactional
	public ServerDTO getServerDetails(Integer a) {
		ServerEntity serverEntity = applicationDao.getServer(a);
		ServerDTO serverDTO = new ServerDTO();
		try {
			BeanUtils.copyProperties(serverDTO, serverEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return serverDTO;
	}

	@Override
	@Transactional
	public Set<ApplicationDTO> getAuditTypeReport(int id, String status, int year) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		ApplicationDTO applicationDTO = null;
		ApplicationEntity applicationEntity = null;
		List<AppAuditEntity> appAuditEntities = applicationDao.getAuditsOnType(id);
		Set<ApplicationDTO> applicationDTOs = new HashSet<>(0);
		for (AppAuditEntity appAuditEntity : appAuditEntities) {
			if (appAuditEntity.getAuditDate() != null) {
				cal.setTime(appAuditEntity.getAuditDate());
				if (cal.get(Calendar.YEAR) == year) {
					if (appAuditEntity.getStatus().equalsIgnoreCase(status)) {
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
							Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity
									.getAppBusinessOwnerEntities();
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
				}
			}
		}
		return applicationDTOs;
	}

	@Override
	@Transactional
	public ApplicationResp saveAppAssessment(AssessmentDTO assessmentDTO) {
		AssessmentEntity assessmentEntity = new AssessmentEntity();
		ApplicationResp applicationResp = new ApplicationResp();
		Set<AssessmentPolicyEntity> assessmentPolicyEntities = new HashSet<>();
		AssessmentPolicyEntity assessmentPolicyEntity = null;
		ApplicationEntity applicationEntity = applicationDao.getApplicationOnId(assessmentDTO.getApplicationID());
		try {
			BeanUtils.copyProperties(assessmentEntity, assessmentDTO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assessmentEntity.setApplicationEntity(applicationEntity);
		assessmentEntity.setAssessmentDt(assessmentDTO.getAssessmentDt());
		assessmentEntity.setNextAssessmentDt(assessmentDTO.getNextAssessmentDt());
		assessmentEntity.setName(assessmentDTO.getName());
		assessmentEntity.setStatus(assessmentDTO.getStatus());
		assessmentEntity.setCreatedBy(assessmentDTO.getCreatedBy());
		assessmentEntity.setCreatedTs(new Date());
		assessmentEntity.setUpdatedBy(assessmentDTO.getCreatedBy());
		assessmentEntity.setUpdatedTs(new Date());
		List<AssessmentFileDTO> assessmentFileDTOs = assessmentDTO.getAssessmentFileDTOs();
		Set<AssessmentFileEntity> assessmentFileEntities = new HashSet<AssessmentFileEntity>();
		for (AssessmentFileDTO assessmentFileDTO : assessmentFileDTOs) {

			// New file
			if (assessmentFileDTO.getAssessmentFileId() == null) {
				byte content[] = Base64.getDecoder().decode(assessmentFileDTO.getFileContent().split("base64,")[1]);
				try {
					APMMailUtility.createFile(
							environment.getRequiredProperty("AAMLocation") + applicationEntity.getApplicationId(),
							assessmentFileDTO.getFileName(), content);
				} catch (IllegalStateException | APMException e) {
					e.printStackTrace();
				}
				AssessmentFileEntity assessmentFileEntity = new AssessmentFileEntity();
				assessmentFileEntity.setAssessmentEntity(assessmentEntity);
				assessmentFileEntity.setFileLocation(
						environment.getRequiredProperty("AAMLocation") + applicationEntity.getApplicationId());
				assessmentFileEntity.setFileName(assessmentFileDTO.getFileName());
				assessmentFileEntity.setStatus(assessmentFileDTO.getStatus());
				assessmentFileEntity.setCreatedTs(new Date());
				assessmentFileEntity.setCreatedBy(assessmentDTO.getCreatedBy());
				assessmentFileEntities.add(assessmentFileEntity);
			}
		}

		List<PolicyEntity> policyEntities = policyDao.getPoliciesOnGrpId(assessmentDTO.getPolicyGrpId());

		for (PolicyEntity policyEntity : policyEntities) {
			assessmentPolicyEntity = new AssessmentPolicyEntity();
			assessmentPolicyEntity.setPolicyEntity(policyEntity);
			assessmentPolicyEntity.setConfidentiality(false);
			assessmentPolicyEntity.setIntegrity(false);
			assessmentPolicyEntity.setAvailability(false);
			assessmentPolicyEntity.setCreatedBy(assessmentDTO.getCreatedBy());
			assessmentPolicyEntity.setCreatedTs(new Date());
			assessmentPolicyEntity.setUpdatedBy(assessmentDTO.getCreatedBy());
			assessmentPolicyEntity.setUpdatedTs(new Date());
			assessmentPolicyEntity.setAssessmentEntity(assessmentEntity);
			assessmentPolicyEntity.setStatus("Open");
			assessmentPolicyEntities.add(assessmentPolicyEntity);

		}
		assessmentEntity.setAssessmentPolicyEntities(assessmentPolicyEntities);
		assessmentEntity = applicationDao.saveAssessment(assessmentEntity);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;
	}

	@Override
	@Transactional
	public AssessmentDTO getAppAssessment(int assessmentID) {
		AssessmentEntity assessmentEntity = applicationDao.getAssessmentEntity(assessmentID);
		AssessmentDTO assessmentDTO = null;
		if (assessmentEntity != null) {
			assessmentDTO = new AssessmentDTO();

			Set<AssessmentPolicyEntity> assessmentPolicyEntities = assessmentEntity.getAssessmentPolicyEntities();
			AssessmentPolicyEntity assessmentPolicyEntity = null;
			try {
				BeanUtils.copyProperties(assessmentDTO, assessmentEntity);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assessmentDTO.setAssessmentDt(assessmentEntity.getAssessmentDt());

			assessmentDTO.setAssessmentId(assessmentEntity.getAssessmentId());
			assessmentDTO.setName(assessmentEntity.getName());
			assessmentDTO.setStatus(assessmentEntity.getStatus());
			assessmentDTO.setNextAssessmentDt(assessmentEntity.getNextAssessmentDt());
			assessmentDTO.setStatus(assessmentEntity.getStatus());
			Set<AssessmentFileEntity> assessmentFileEntities = assessmentEntity.getAssessmentFileEntities();

			if (!assessmentFileEntities.isEmpty()) {
				List<AssessmentFileDTO> assessmentFileDTOs = new ArrayList<AssessmentFileDTO>();
				AssessmentFileDTO assessmentFileDTO = null;
				for (AssessmentFileEntity assessmentFileEntity : assessmentFileEntities) {
					if (assessmentFileEntity.getStatus()) {
						assessmentFileDTO = new AssessmentFileDTO();
						assessmentFileDTO.setFileName(assessmentFileEntity.getFileName());
						assessmentFileDTO.setAssessmentFileId(assessmentFileEntity.getAssessmentFileId());
						assessmentFileDTO.setStatus(assessmentFileEntity.getStatus());
						assessmentFileDTOs.add(assessmentFileDTO);
					}
				}
				assessmentDTO.setAssessmentFileDTOs(assessmentFileDTOs);
			}

			if (assessmentPolicyEntities.size() > 0) {
				List<AssessmentPolicyDTO> assessmentPolicyDTOs = new ArrayList<>();
				AssessmentPolicyDTO assessmentPolicyDTO = null;
				PolicyDTO policyDTO = null;
				assessmentPolicyEntity = assessmentPolicyEntities.iterator().next();
				assessmentDTO
						.setPolicyGrpId(assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity().getPolicyGrpId());
				assessmentDTO.setAuditId(assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity()
						.getAuditTypeEntity().getAuditTypeId());
				assessmentDTO.setAuditName(assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity()
						.getAuditTypeEntity().getAuditTypeName());
				for (AssessmentPolicyEntity assessmentPolicyEntity2 : assessmentPolicyEntities) {
					policyDTO = new PolicyDTO();
					assessmentPolicyDTO = new AssessmentPolicyDTO();
					// PolicyEntity policyEntity =
					// policyDao.getPolicyEntity(assessmentPolicyEntity2.getAssessmentPolicyId());
					policyDTO = policyServices.getPolicy(assessmentPolicyEntity2.getPolicyEntity().getPolicyId());
					assessmentPolicyDTO.setAssessmentPolicyId(assessmentPolicyEntity2.getAssessmentPolicyId());
					assessmentPolicyDTO.setPolicyDTO(policyDTO);
					assessmentPolicyDTO.setStatus(assessmentPolicyEntity2.getStatus());
					assessmentPolicyDTOs.add(assessmentPolicyDTO);
				}
				assessmentDTO.setAssessmentPolicyDTOs(assessmentPolicyDTOs);
			}

		}

		return assessmentDTO;
	}

	@Override
	@Transactional
	public AssessmentPolicyDTO getAppAssessmentPolicy(int assessmentPolicyID) {
		AssessmentPolicyEntity assessmentPolicyEntity = applicationDao.getAppAssessmentPolicy(assessmentPolicyID);
		AssessmentPolicyDTO assessmentPolicyDTO = null;
		if (assessmentPolicyEntity != null) {
			assessmentPolicyDTO = new AssessmentPolicyDTO();
			try {
				BeanUtils.copyProperties(assessmentPolicyDTO, assessmentPolicyEntity);
				assessmentPolicyDTO.setApplicationName(
						assessmentPolicyEntity.getAssessmentEntity().getApplicationEntity().getAcronym() + " "
								+ assessmentPolicyEntity.getAssessmentEntity().getApplicationEntity().getName());
				assessmentPolicyDTO
						.setPolicyDTO(policyServices.getPolicy(assessmentPolicyEntity.getPolicyEntity().getPolicyId()));
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				return assessmentPolicyDTO;
			}
		}
		return assessmentPolicyDTO;
	}

	@Override
	@Transactional
	public AssessmentPolicyDTO saveAssessment(AssessmentPolicyDTO assessmentPolicyDTO) {

		AssessmentPolicyEntity assessmentPolicyEntity = applicationDao
				.getAppAssessmentPolicy(assessmentPolicyDTO.getAssessmentPolicyId());

		assessmentPolicyEntity.setAvailability(assessmentPolicyDTO.getAvailability());
		assessmentPolicyEntity.setCompletionDt(assessmentPolicyDTO.getCompletionDt());
		assessmentPolicyEntity.setConfidentiality(assessmentPolicyDTO.getConfidentiality());
		assessmentPolicyEntity.setControlsInPlace(assessmentPolicyDTO.getControlsInPlace());
		assessmentPolicyEntity.setImpactMagnitude(assessmentPolicyDTO.getImpactMagnitude());
		assessmentPolicyEntity.setIntegrity(assessmentPolicyDTO.getIntegrity());
		assessmentPolicyEntity.setRiskSummary(assessmentPolicyDTO.getRiskSummary());
		assessmentPolicyEntity.setRiskThreat(assessmentPolicyDTO.getRiskThreat());
		assessmentPolicyEntity.setRiskVulnerability(assessmentPolicyDTO.getRiskVulnerability());
		assessmentPolicyEntity.setUpdatedBy(assessmentPolicyDTO.getUpdatedBy());
		assessmentPolicyEntity.setStatus(assessmentPolicyDTO.getStatus());
		assessmentPolicyEntity.setUpdatedTs(new Date());
		assessmentPolicyEntity.setVulnerabilityFamily(assessmentPolicyDTO.getVulnerabilityFamily());

		assessmentPolicyEntity = applicationDao.updateAssessment(assessmentPolicyEntity);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ApplicationResp updateAppAssessment(AssessmentDTO assessmentDTO) {
		ApplicationResp applicationResp = new ApplicationResp();
		AssessmentEntity assessmentEntity = applicationDao.getAssessmentEntity(assessmentDTO.getAssessmentId());
		assessmentEntity.setAssessmentDt(assessmentDTO.getAssessmentDt());
		assessmentEntity.setNextAssessmentDt(assessmentDTO.getNextAssessmentDt());
		assessmentEntity.setName(assessmentDTO.getName());
		assessmentEntity.setStatus(assessmentDTO.getStatus());
		assessmentEntity.setUpdatedBy(assessmentDTO.getCreatedBy());
		assessmentEntity.setUpdatedTs(new Date());
		assessmentEntity.setBudget(assessmentDTO.getBudget());
		assessmentEntity.setBusinessRisks(assessmentDTO.getBusinessRisks());
		assessmentEntity.setManagementReponse(assessmentDTO.getManagementReponse());
		assessmentEntity.setRecomendations(assessmentDTO.getRecomendations());
		assessmentEntity.setStatus(assessmentDTO.getStatus());
		assessmentEntity.setSecurityRisks(assessmentDTO.getSecurityRisks());
		assessmentEntity.setActionPlanCloseoutComments(assessmentDTO.getActionPlanCloseoutComments());
		assessmentEntity.setActionPlanTasks(assessmentDTO.getActionPlanTasks());
		assessmentEntity.setRecomendations(assessmentDTO.getRecomendations());
		assessmentEntity.setRecomendedBy(assessmentDTO.getRecomendedBy());
		assessmentEntity.setEstimatedCompletionDt(assessmentDTO.getEstimatedCompletionDt());
		assessmentEntity.setResponseBy(assessmentDTO.getResponseBy());
		assessmentEntity.setResponseDt(assessmentDTO.getResponseDt());
		assessmentEntity.setActionPlanStartDt(assessmentDTO.getActionPlanStartDt());
		assessmentEntity.setActionPlanEndDt(assessmentDTO.getActionPlanEndDt());
		assessmentEntity.setActionPlanAssignedTo(assessmentDTO.getActionPlanAssignedTo());
		assessmentEntity.setActionPlanSummary(assessmentDTO.getActionPlanSummary());
		assessmentEntity.setActionPlanTasks(assessmentDTO.getActionPlanTasks());
		assessmentEntity.setActionPlanCloseoutComments(assessmentDTO.getActionPlanCloseoutComments());
		assessmentEntity.setBusinessRisks(assessmentDTO.getBusinessRisks());
		assessmentEntity.setSecurityRisks(assessmentDTO.getSecurityRisks());
		assessmentEntity.setBudgetDescription(assessmentDTO.getBudgetDescription());
		assessmentEntity.setFindingComments(assessmentDTO.getFindingComments());
		assessmentEntity.setFindingDescription(assessmentDTO.getFindingDescription());
		assessmentEntity.setResponsibleParty(assessmentDTO.getResponsibleParty());
		assessmentEntity.setTypeOfFindings(assessmentDTO.getTypeOfFindings());
		assessmentEntity.setOverallRiskLevel(assessmentDTO.getOverallRiskLevel());
		assessmentEntity.setLessonsEnteredBy(assessmentDTO.getLessonsEnteredBy());
		assessmentEntity.setLessonsEnteredDate(assessmentDTO.getLessonsEnteredDate());
		assessmentEntity.setLessonsLearnedDescription(assessmentDTO.getLessonsLearnedDescription());
		List<AssessmentFileDTO> assessmentFileDTOs = assessmentDTO.getAssessmentFileDTOs();
		Set<AssessmentFileEntity> assessmentFileEntities = assessmentEntity.getAssessmentFileEntities();
		if (assessmentFileDTOs != null)
			for (AssessmentFileDTO assessmentFileDTO : assessmentFileDTOs) {

				// New file
				if (assessmentFileDTO.getAssessmentFileId() == null) {
					byte content[] = Base64.getDecoder().decode(assessmentFileDTO.getFileContent().split("base64,")[1]);
					try {
						APMMailUtility.createFile(
								environment.getRequiredProperty("AAMLocation")
										+ assessmentEntity.getApplicationEntity().getApplicationId(),
								assessmentFileDTO.getFileName(), content);
					} catch (IllegalStateException | APMException e) {
						e.printStackTrace();
					}
					AssessmentFileEntity assessmentFileEntity = new AssessmentFileEntity();
					assessmentFileEntity.setAssessmentEntity(assessmentEntity);
					assessmentFileEntity.setFileLocation(environment.getRequiredProperty("AAMLocation")
							+ assessmentEntity.getApplicationEntity().getApplicationId() + "/");
					assessmentFileEntity.setFileName(assessmentFileDTO.getFileName());
					assessmentFileEntity.setStatus(assessmentFileDTO.getStatus());
					assessmentFileEntity.setCreatedTs(new Date());
					assessmentFileEntity.setCreatedBy(assessmentDTO.getCreatedBy());
					assessmentFileEntities.add(assessmentFileEntity);
				} else {
					for (AssessmentFileEntity assessmentFileEntity : assessmentFileEntities) {
						if (assessmentFileEntity.getAssessmentFileId() == assessmentFileDTO.getAssessmentFileId()
								&& !(assessmentFileDTO.getStatus())) {
							assessmentFileEntity.setStatus(false);
							assessmentFileEntities.add(assessmentFileEntity);
						}
					}
				}
			}

		assessmentEntity = applicationDao.upadateAssessment(assessmentEntity);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;
	}

	@Override
	@Transactional
	public List<AssessmentDTO> getAllAssessments() {
		List<AssessmentEntity> assessmentEntities = applicationDao.getAllAssessments();
		List<AssessmentDTO> assessmentDTOs = new ArrayList<>();
		AssessmentDTO assessmentDTO = null;

		for (AssessmentEntity assessmentEntity : assessmentEntities) {
			assessmentDTO = new AssessmentDTO();
			assessmentDTO.setAssessmentId(assessmentEntity.getAssessmentId());
			assessmentDTO.setName(assessmentEntity.getName());
			assessmentDTO.setStatus(assessmentEntity.getStatus());
			assessmentDTO.setAppAcronym(assessmentEntity.getApplicationEntity().getAcronym());
			assessmentDTO.setAppId(assessmentEntity.getApplicationEntity().getApplicationId());
			assessmentDTO.setNextAssessmentDt(assessmentEntity.getNextAssessmentDt());
			assessmentDTO.setAssessmentDt(assessmentEntity.getAssessmentDt());
			for (AssessmentPolicyEntity assessmentPolicyEntity : assessmentEntity.getAssessmentPolicyEntities()) {
				assessmentDTO.setPolicyName(
						assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity().getPolicyGrpName());
				break;
			}

			assessmentDTOs.add(assessmentDTO);
		}

		return assessmentDTOs;
	}

	@Override
	@Transactional
	public String getAssessmentPolicyFile(int assessmentID) {
		AssessmentEntity assessmentEntity = applicationDao.getAssessmentEntity(assessmentID);
		Set<AssessmentPolicyEntity> assessmentPolicyEntities = assessmentEntity.getAssessmentPolicyEntities();

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Assessments");

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
		cell.setCellValue("Application Name");

		cell = rowhead.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("ID");

		cell = rowhead.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Confidentiality");

		cell = rowhead.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Integrity");

		cell = rowhead.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("Availability");

		cell = rowhead.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("Completion Date");

		cell = rowhead.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("Risk Vulnerability Family");

		cell = rowhead.createCell(7);
		cell.setCellStyle(style);
		cell.setCellValue("Control ID");

		cell = rowhead.createCell(8);
		cell.setCellStyle(style);
		cell.setCellValue("Cyber Security Framework");

		cell = rowhead.createCell(9);
		cell.setCellStyle(style);
		cell.setCellValue("Risk  Vulnerability");

		cell = rowhead.createCell(10);
		cell.setCellStyle(style);
		cell.setCellValue("Risk Threat");

		cell = rowhead.createCell(11);
		cell.setCellStyle(style);
		cell.setCellValue("Risk Summary");

		cell = rowhead.createCell(12);
		cell.setCellStyle(style);
		cell.setCellValue("Magnitude of Impact");

		cell = rowhead.createCell(12);
		cell.setCellStyle(style);
		cell.setCellValue("Controls in Place");

		int i = 1;
		String fileName = null;
		for (AssessmentPolicyEntity assessmentPolicyEntity : assessmentPolicyEntities) {
			XSSFRow row = sheet.createRow((short) i++);
			cell = row.createCell(0);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentEntity.getApplicationEntity().getName());

			cell = row.createCell(1);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getAssessmentPolicyId());

			cell = row.createCell(2);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getConfidentiality());

			cell = row.createCell(3);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getIntegrity());

			cell = row.createCell(4);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getAvailability());

			cell = row.createCell(5);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getCompletionDt());

			cell = row.createCell(6);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getPolicyEntity().getPolicyGrpEntity().getPolicyGrpName());

			cell = row.createCell(7);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getPolicyEntity().getControlNumber());

			cell = row.createCell(8);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getCyberSecurityFramework());

			cell = row.createCell(9);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getRiskVulnerability());

			cell = row.createCell(10);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getRiskThreat());

			cell = row.createCell(11);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getRiskThreat());

			cell = row.createCell(12);
			style.setWrapText(false);
			cell.setCellStyle(style);
			cell.setCellValue(assessmentPolicyEntity.getControlsInPlace());
		}
		Row row = sheet.getRow(0);
		Iterator cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			XSSFCell cell2 = (XSSFCell) cellIterator.next();
			int columnIndex = cell2.getColumnIndex();
			sheet.autoSizeColumn(columnIndex);
		}
		fileName = environment.getRequiredProperty("AAMLocation") + assessmentEntity.getName();
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
	public List<String> getAppAcronyms() {
		List<String> acronyms = new ArrayList<>();
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 0)
				acronyms.add(applicationEntity.getAcronym());
		}
		return acronyms;
	}

	@Override
	@Transactional
	public List<String> getLocalityAcronyms() {
		List<String> acronyms = new ArrayList<>();
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 1)
				acronyms.add(applicationEntity.getAcronym());
		}
		return acronyms;
	}

	@Override
	@Transactional
	public int getLocalityTotal() {
		int localities = 0;
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 1)
				localities++;
		}
		return localities;
	}

	@Override
	@Transactional
	public List<String> getBusinessOwnerNameDoe() {
		List<String> BusinessOwnerNameDoe = new ArrayList<>();
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 0)
				BusinessOwnerNameDoe.add(applicationEntity.getBusinessOwnerNameDoe());
		}
		return BusinessOwnerNameDoe;
	}

	@Override
	@Transactional
	public List<String> getSystemOwnerNameDoe() {
		List<String> systemOwnerNameDoe = new ArrayList<>();
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 0)
				systemOwnerNameDoe.add(applicationEntity.getSystemOwnerNameDoe());
		}
		return systemOwnerNameDoe;
	}

	@Override
	@Transactional
	public String getAssessmentFile(int id) {
		AssessmentFileEntity assessmentFileEntity = applicationDao.getAssessmentFileEntity(id);
		if (assessmentFileEntity != null)
			return assessmentFileEntity.getFileLocation() + assessmentFileEntity.getFileName();
		else
			return null;
	}

	@Override
	@Transactional
	public Set<OfficeDTO> getOfficesOnDept(int deptId) {

		List<OfficeEntity> officeEntities = applicationDao.getOffices();
		Set<OfficeDTO> officeDTOs = new HashSet<>(0);
		OfficeDTO officeDTO = null;
		try {
			BeanUtils.copyProperties(officeDTOs, officeEntities);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		for (OfficeEntity officeEntity : officeEntities) {
			if (officeEntity.getDivisionEntity().getId() == deptId) {
				officeDTO = new OfficeDTO();
				if (officeEntity.getAcronym() != null)
					officeDTO.setAcronym(officeEntity.getAcronym());
				officeDTO.setDescription(officeEntity.getDescription());
				officeDTO.setId(officeEntity.getOfficeId());
				officeDTO.setDivisionId(officeEntity.getDivisionEntity().getId());
				officeDTOs.add(officeDTO);
			}
		}
		return officeDTOs;

	}

	@Override
	@Transactional
	public ApplicationResp saveMOU(MOUDTO moudto) {
		ApplicationResp applicationResp = new ApplicationResp();
		String folderPath = null;
		MOUEntity mouEntity = new MOUEntity();
		ApplicationEntity applicationEntity = applicationDao.getApplicationOnId(moudto.getApplicationID());
		mouEntity.setName(moudto.getName());
		mouEntity.setRecertificationDt(moudto.getRecertificationDt());
		mouEntity.setSigned(moudto.getSigned());
		mouEntity.setCreatedBy(moudto.getCreatedBy());
		mouEntity.setCreatedTs(new Date());
		mouEntity.setUpdatedBy(moudto.getCreatedBy());
		mouEntity.setUpdatedTs(new Date());
		mouEntity.setApplicationEntity(applicationEntity);
		if (!moudto.getMouDocDTOs().isEmpty()) {
			Set<MOUDocEntity> mouDocEntities = new HashSet<>(0);
			MOUDocEntity mouDocEntity = null;

			for (MOUDocDTO mouDocDTO : moudto.getMouDocDTOs()) {
				folderPath = environment.getRequiredProperty("AAMLocation") + applicationEntity.getApplicationId();
				mouDocEntity = new MOUDocEntity();
				if (!createMOUFile(mouDocDTO.getFileContent(), folderPath, mouDocDTO.getFileName()))
					applicationResp.setResponseCode(Integer.parseInt(
							messageSource.getMessage("APPLICATION.GENERAL.FAIL.CODE", null, Locale.getDefault())));
				mouDocEntity.setMouEntity(mouEntity);
				mouDocEntity.setFileName(mouDocDTO.getFileName());

				mouDocEntity.setLocation(
						environment.getRequiredProperty("AAMLocation") + applicationEntity.getApplicationId());
				mouDocEntity.setCreatedBy(moudto.getCreatedBy());
				mouDocEntity.setUpdatedBy(moudto.getCreatedBy());
				mouDocEntity.setUpdatedTs(new Date());
				mouDocEntity.setCreatedTs(new Date());
				mouDocEntity.setStatus(mouDocDTO.isStatus());

				mouDocEntities.add(mouDocEntity);
			}
			mouEntity.setMouDocEntities(mouDocEntities);
		}
		applicationDao.saveMou(mouEntity);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;
	}

	@Override
	public ApplicationResp updateMou(MOUDTO moudto) {
		ApplicationResp applicationResp = new ApplicationResp();
		MOUEntity mouEntity = applicationDao.getMou(moudto.getMouId());
		if (mouEntity != null) {
			mouEntity.setName(moudto.getName());
			mouEntity.setRecertificationDt(moudto.getRecertificationDt());
			mouEntity.setSigned(moudto.getSigned());
			mouEntity.setUpdatedBy(moudto.getCreatedBy());
			mouEntity.setReceiptDt(moudto.getReceiptDt());
			mouEntity.setUpdatedTs(new Date());
			if (!moudto.getMouDocDTOs().isEmpty()) {
				Set<MOUDocEntity> mouDocEntities = new HashSet<>(0);
				MOUDocEntity mouDocEntity = null;

				for (MOUDocDTO mouDocDTO : moudto.getMouDocDTOs()) {
					mouDocEntity = new MOUDocEntity();
					mouDocEntity.setMouEntity(mouEntity);
					mouDocEntity.setFileName(mouDocDTO.getFileName());
					mouDocEntity.setUpdatedBy(moudto.getCreatedBy());
					mouDocEntity.setUpdatedTs(new Date());
					mouDocEntity.setMouDocId(mouDocDTO.getMouDocId());
					mouDocEntity.setStatus(mouDocDTO.isStatus());
					mouDocEntities.add(mouDocEntity);
				}
				mouEntity.setMouDocEntities(mouDocEntities);
			}
			applicationDao.updateMou(mouEntity);
			applicationResp.setResponseCode(Integer
					.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));

		} else {
			applicationResp.setResponseCode(Integer
					.parseInt(messageSource.getMessage("APPLICATION.GENERAL.FAIL.CODE", null, Locale.getDefault())));
		}

		return applicationResp;
	}

	@Override
	@Transactional
	public String getMOUFile(Integer fileId) {
		MOUDocEntity mouDocEntity = applicationDao.getMOUDocEntity(fileId);
		return mouDocEntity.getLocation() + "/" + mouDocEntity.getFileName();
	}

	@Override
	@Transactional
	public String getPolicyDocumentAttachment(Integer policyDocId) {
		PolicyDocumentsEntity policyDocEntity = applicationDao.getPolicyDocument(policyDocId);
		return policyDocEntity.getDocumentPath() + "/" + policyDocEntity.getDocumentName();
	}

	@Override
	@Transactional
	public String getDeviceFile(Integer fileId) {
		DeviceDocEntity deviceDocEntity = applicationDao.getDeviceDocEntity(fileId);
		return deviceDocEntity.getLocation() + "/" + deviceDocEntity.getFileName();
	}

	private boolean createMOUFile(String fileContent, String fodlerPath, String fileName) {
		// data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64,
		byte[] content = fileContent.split("base64,")[1].getBytes();

		File folder = new File(fodlerPath);

		if (!folder.exists()) {
			folder.mkdir();
		}
		fodlerPath = fodlerPath + "/MOUs";
		folder = new File(fodlerPath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		File file = new File(fodlerPath + "/" + fileName);
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			out.write(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean createMOUFile(MultipartFile mouFile, String fodlerPath) {
		// data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64,

		File folder = new File(fodlerPath);

		if (!folder.exists()) {
			folder.mkdir();
		}
		fodlerPath = fodlerPath + "/MOUs";
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

	@Override
	@Transactional
	public ApplicationResp saveMOU(MOUDTO moudto, MultipartFile[] files) {

		ApplicationResp applicationResp = new ApplicationResp();
		String folderPath = null;
		MOUEntity mouEntity = new MOUEntity();
		ApplicationEntity applicationEntity = applicationDao.getApplicationOnId(moudto.getApplicationID());
		mouEntity.setName(moudto.getName());
		mouEntity.setRecertificationDt(moudto.getRecertificationDt());
		mouEntity.setReceiptDt(moudto.getReceiptDt());
		mouEntity.setSigned(moudto.getSigned());
		mouEntity.setCreatedBy(moudto.getCreatedBy());
		mouEntity.setCreatedTs(new Date());
		mouEntity.setUpdatedBy(moudto.getCreatedBy());
		mouEntity.setUpdatedTs(new Date());
		mouEntity.setApplicationEntity(applicationEntity);
		if (moudto.getMouDocDTOs() != null) {
			Set<MOUDocEntity> mouDocEntities = new HashSet<>(0);
			MOUDocEntity mouDocEntity = null;

			for (MOUDocDTO mouDocDTO : moudto.getMouDocDTOs()) {
				folderPath = environment.getRequiredProperty("AAMLocation") + applicationEntity.getApplicationId();
				mouDocEntity = new MOUDocEntity();
				for (MultipartFile file : files) {
					if (file.getOriginalFilename().equalsIgnoreCase(mouDocDTO.getFileName()))
						if (!createMOUFile(file, folderPath))
							applicationResp.setResponseCode(Integer.parseInt(messageSource
									.getMessage("APPLICATION.GENERAL.FAIL.CODE", null, Locale.getDefault())));
				}
				/*
				 * if(!createMOUFile(mouDocDTO.getFileContent(),folderPath,mouDocDTO.getFileName
				 * ()))
				 * applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage(
				 * "APPLICATION.GENERAL.FAIL.CODE",null, Locale.getDefault())));
				 */
				mouDocEntity.setMouEntity(mouEntity);
				mouDocEntity.setFileName(mouDocDTO.getFileName());

				mouDocEntity.setLocation(environment.getRequiredProperty("AAMLocation")
						+ applicationEntity.getApplicationId() + "/MOUs");
				mouDocEntity.setCreatedBy(moudto.getCreatedBy());
				mouDocEntity.setUpdatedBy(moudto.getCreatedBy());
				mouDocEntity.setUpdatedTs(new Date());
				mouDocEntity.setCreatedTs(new Date());
				mouDocEntity.setStatus(mouDocDTO.isStatus());

				mouDocEntities.add(mouDocEntity);
			}
			mouEntity.setMouDocEntities(mouDocEntities);
		}
		applicationDao.saveMou(mouEntity);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;

	}

	@Override
	@Transactional
	public ApplicationResp updateMOU(MOUDTO moudto, MultipartFile[] files) {

		ApplicationResp applicationResp = new ApplicationResp();
		String folderPath = null;
		MOUEntity mouEntity = applicationDao.getMou(moudto.getMouId());
		mouEntity.setName(moudto.getName());
		mouEntity.setRecertificationDt(moudto.getRecertificationDt());
		mouEntity.setReceiptDt(moudto.getReceiptDt());
		mouEntity.setSigned(moudto.getSigned());
		mouEntity.setUpdatedBy(moudto.getUpdatedBy());
		mouEntity.setUpdatedTs(new Date());

		if (moudto.getMouDocDTOs() != null && !moudto.getMouDocDTOs().isEmpty()) {
			Set<MOUDocEntity> mouDocEntities = new HashSet<>(0);
			MOUDocEntity mouDocEntity = null;

			for (MOUDocDTO mouDocDTO : moudto.getMouDocDTOs()) {
				if (mouDocDTO.isNewFile()) {
					folderPath = environment.getRequiredProperty("AAMLocation")
							+ mouEntity.getApplicationEntity().getApplicationId();
					mouDocEntity = new MOUDocEntity();
					for (MultipartFile file : files) {
						if (file.getOriginalFilename().equalsIgnoreCase(mouDocDTO.getFileName()))
							if (!createMOUFile(file, folderPath))
								applicationResp.setResponseCode(Integer.parseInt(messageSource
										.getMessage("APPLICATION.GENERAL.FAIL.CODE", null, Locale.getDefault())));
					}
					/*
					 * if(!createMOUFile(mouDocDTO.getFileContent(),folderPath,mouDocDTO.getFileName
					 * ()))
					 * applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage(
					 * "APPLICATION.GENERAL.FAIL.CODE",null, Locale.getDefault())));
					 */
					mouDocEntity.setMouEntity(mouEntity);
					mouDocEntity.setFileName(mouDocDTO.getFileName());

					mouDocEntity.setLocation(environment.getRequiredProperty("AAMLocation")
							+ mouEntity.getApplicationEntity().getApplicationId() + "/MOUs");
					mouDocEntity.setCreatedBy(moudto.getCreatedBy());
					mouDocEntity.setUpdatedBy(moudto.getCreatedBy());
					mouDocEntity.setUpdatedTs(new Date());
					mouDocEntity.setCreatedTs(new Date());
					mouDocEntity.setStatus(mouDocDTO.isStatus());

					mouDocEntities.add(mouDocEntity);
				} else {
					for (MOUDocEntity mouDocEntity2 : mouEntity.getMouDocEntities()) {
						if (mouDocEntity2.getMouDocId() == mouDocDTO.getMouDocId() && mouDocEntity2.isStatus()) {
							mouDocEntity2.setStatus(mouDocDTO.isStatus());
							mouDocEntity2.setUpdatedBy(moudto.getUpdatedBy());
							mouDocEntity2.setUpdatedTs(new Date());
							mouDocEntities.add(mouDocEntity2);
						}
					}

				}
			}
			mouEntity.setMouDocEntities(mouDocEntities);
		}
		applicationDao.updateMou(mouEntity);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;

	}

	@Override
	@Transactional
	public VendorsDTO addNewVendor(VendorsDTO vendorsDTO) {
		VendorsEntity vendorsEntity = new VendorsEntity();
		VendorAddressEntity vendorAddressEntity = new VendorAddressEntity();
		VendorContactEntity vendorContactEntity = new VendorContactEntity();
		vendorsEntity.setName(vendorsDTO.getName());
		vendorsEntity.setCreatedBy(vendorsDTO.getCreatedBy());
		vendorsEntity.setUpdatedBy(vendorsDTO.getCreatedBy());
		vendorsEntity.setCreatedTs(new Date());
		vendorsEntity.setUpdatedTs(new Date());
		// Address
		vendorAddressEntity.setState(vendorsDTO.getVendorAddress().getState());
		vendorAddressEntity.setCity(vendorsDTO.getVendorAddress().getCity());
		vendorAddressEntity.setZipcode(vendorsDTO.getVendorAddress().getZipcode());
		vendorAddressEntity.setStreetName(vendorsDTO.getVendorAddress().getStreetName());
		vendorAddressEntity.setCreatedBy(vendorsDTO.getCreatedBy());
		vendorAddressEntity.setUpdatedBy(vendorsDTO.getCreatedBy());
		vendorAddressEntity.setVendorsEntity(vendorsEntity);
		vendorAddressEntity.setCreatedTs(new Date());
		vendorAddressEntity.setUpdatedTs(new Date());
		vendorsEntity.setVendorAddressEntity(vendorAddressEntity);
		// Contact
		vendorContactEntity.setFirstName(vendorsDTO.getVendorContact().getFirstName());
		vendorContactEntity.setLastName(vendorsDTO.getVendorContact().getLastName());
		vendorContactEntity.setEmailId(vendorsDTO.getVendorContact().getEmailId());
		vendorContactEntity.setPhoneNumber(vendorsDTO.getVendorContact().getPhoneNumber());
		vendorAddressEntity.setStreetName(vendorsDTO.getVendorAddress().getStreetName());
		vendorContactEntity.setCreatedBy(vendorsDTO.getCreatedBy());
		vendorContactEntity.setUpdatedBy(vendorsDTO.getCreatedBy());
		vendorContactEntity.setVendorsEntity(vendorsEntity);
		vendorContactEntity.setCreatedTs(new Date());
		vendorContactEntity.setUpdatedTs(new Date());
		vendorsEntity.setVendorContactEntity(vendorContactEntity);
		vendorDao.saveVendor(vendorsEntity);

		return null;
	}

	@Override
	@Transactional
	public VendorsDTO updateVendor(VendorsDTO vendorsDTO) {
		VendorsEntity vendorsEntity = vendorDao.getVendorEntity(vendorsDTO.getVendorId());
		VendorAddressEntity vendorAddressEntity = vendorsEntity.getVendorAddressEntity();
		VendorContactEntity vendorContactEntity = vendorsEntity.getVendorContactEntity();
		vendorsEntity.setName(vendorsDTO.getName());
		vendorsEntity.setUpdatedBy(vendorsDTO.getUpdatedBy());
		vendorsEntity.setUpdatedTs(new Date());
		// Address
		vendorAddressEntity.setState(vendorsDTO.getVendorAddress().getState());
		vendorAddressEntity.setCity(vendorsDTO.getVendorAddress().getCity());
		vendorAddressEntity.setZipcode(vendorsDTO.getVendorAddress().getZipcode());
		vendorAddressEntity.setStreetName(vendorsDTO.getVendorAddress().getStreetName());
		vendorAddressEntity.setUpdatedBy(vendorsDTO.getUpdatedBy());
		vendorAddressEntity.setVendorsEntity(vendorsEntity);
		vendorAddressEntity.setUpdatedTs(new Date());
		vendorsEntity.setVendorAddressEntity(vendorAddressEntity);
		// Contact
		vendorContactEntity.setFirstName(vendorsDTO.getVendorContact().getFirstName());
		vendorContactEntity.setLastName(vendorsDTO.getVendorContact().getLastName());
		vendorContactEntity.setEmailId(vendorsDTO.getVendorContact().getEmailId());
		vendorContactEntity.setPhoneNumber(vendorsDTO.getVendorContact().getPhoneNumber());
		vendorAddressEntity.setStreetName(vendorsDTO.getVendorAddress().getStreetName());
		vendorContactEntity.setUpdatedBy(vendorsDTO.getUpdatedBy());
		vendorContactEntity.setVendorsEntity(vendorsEntity);
		vendorContactEntity.setUpdatedTs(new Date());
		vendorsEntity.setVendorContactEntity(vendorContactEntity);
		vendorDao.updateVendor(vendorsEntity);

		return null;
	}

	@Override
	@Transactional
	public List<VendorsDTO> getVendors() {
		List<VendorsEntity> vendorsEntities = vendorDao.getVendors();
		List<VendorsDTO> vendorsDTOs = new ArrayList<>();
		VendorsDTO vendorsDTO = null;
		VendorContactDTO vendorContactDTO = null;
		VendorAddressDTO vendorAddressDTO = null;
		for (VendorsEntity vendorsEntity : vendorsEntities) {
			vendorsDTO = new VendorsDTO();
			vendorContactDTO = new VendorContactDTO();
			vendorAddressDTO = new VendorAddressDTO();
			vendorsDTO.setVendorId(vendorsEntity.getVendorId());
			vendorsDTO.setName(vendorsEntity.getName());
			vendorsDTO.setUpdatedBy(vendorsEntity.getUpdatedBy());
			vendorsDTO.setUpdatedTs(vendorsEntity.getUpdatedTs());
			if (vendorsEntity.getVendorContactEntity() != null) {
				vendorContactDTO.setFirstName(vendorsEntity.getVendorContactEntity().getFirstName());
				vendorContactDTO.setLastName(vendorsEntity.getVendorContactEntity().getLastName());
				vendorContactDTO.setEmailId(vendorsEntity.getVendorContactEntity().getEmailId());
				vendorContactDTO.setPhoneNumber(vendorsEntity.getVendorContactEntity().getPhoneNumber());
				vendorsDTO.setVendorContact(vendorContactDTO);
			}
			if (vendorsEntity.getVendorAddressEntity() != null) {
				vendorAddressDTO.setStreetName(vendorsEntity.getVendorAddressEntity().getStreetName());
				vendorAddressDTO.setCity(vendorsEntity.getVendorAddressEntity().getCity());
				vendorAddressDTO.setZipcode(vendorsEntity.getVendorAddressEntity().getZipcode());
				vendorAddressDTO.setState(vendorsEntity.getVendorAddressEntity().getState());
				vendorsDTO.setVendorAddress(vendorAddressDTO);
			}
			vendorsDTOs.add(vendorsDTO);
		}

		return vendorsDTOs;
	}

	@Override
	@Transactional
	public List<SolutionTypeDTO> getSolutionTypes() {
		List<SolutionTypeEntity> solutionTypeEntities = vendorDao.getSolutionTypes();
		List<SolutionTypeDTO> solutionTypeDTOs = new ArrayList<>();
		SolutionTypeDTO solutionTypeDTO = null;
		for (SolutionTypeEntity solutionTypeEntity : solutionTypeEntities) {
			solutionTypeDTO = new SolutionTypeDTO();
			solutionTypeDTO.setSolutionTypeId(solutionTypeEntity.getSolutionTypeId());
			solutionTypeDTO.setTypeName(solutionTypeEntity.getTypeName());
			solutionTypeDTOs.add(solutionTypeDTO);
		}
		return solutionTypeDTOs;
	}

	@Override
	@Transactional
	public List<MOUDTO> getMOUs(int applicationID) {
		List<MOUDTO> moudtos = new ArrayList<>();
		ApplicationEntity applicationEntity = applicationDao.getApplicationOnId(applicationID);
		if (applicationEntity.getMouEntities() != null && !applicationEntity.getMouEntities().isEmpty()) {

			MOUDTO moudto = null;
			for (MOUEntity mouEntity : applicationEntity.getMouEntities()) {
				moudto = new MOUDTO();
				moudto.setMouId(mouEntity.getMouId());
				moudto.setName(mouEntity.getName());
				moudto.setReceiptDt(mouEntity.getReceiptDt());
				moudto.setRecertificationDt(mouEntity.getRecertificationDt());
				moudto.setSigned(mouEntity.getSigned());
				moudto.setUpdatedBy(mouEntity.getUpdatedBy());
				moudto.setUpdatedTs(mouEntity.getUpdatedTs());
				if (!mouEntity.getMouDocEntities().isEmpty()) {
					List<MOUDocDTO> mouDocDTOs = new ArrayList<>();
					MOUDocDTO mouDocDTO = null;
					for (MOUDocEntity mouDocEntity : mouEntity.getMouDocEntities()) {
						if (mouDocEntity.isStatus()) {
							mouDocDTO = new MOUDocDTO();
							mouDocDTO.setMouDocId(mouDocEntity.getMouDocId());
							mouDocDTO.setFileName(mouDocEntity.getFileName());
							mouDocDTO.setStatus(mouDocEntity.isStatus());
							mouDocDTOs.add(mouDocDTO);
						}
					}
					moudto.setMouDocDTOs(mouDocDTOs);
				}
				moudtos.add(moudto);
			}
		}
		return moudtos;
	}

	@Override
	@Transactional
	public List<MOUDTO> getAllMOUs() {
		List<MOUDTO> moudtos = new ArrayList<>();
		List<ApplicationEntity> applicationEntities = applicationDao.getAllApplications();
		for (ApplicationEntity applicationEntity : applicationEntities) {
			if (applicationEntity.getActiveLocality() == 1) {
				if (applicationEntity.getMouEntities() != null && !applicationEntity.getMouEntities().isEmpty()) {

					MOUDTO moudto = null;
					for (MOUEntity mouEntity : applicationEntity.getMouEntities()) {
						moudto = new MOUDTO();
						moudto.setMouId(mouEntity.getMouId());
						moudto.setName(mouEntity.getName());
						moudto.setReceiptDt(mouEntity.getReceiptDt());
						moudto.setRecertificationDt(mouEntity.getRecertificationDt());
						moudto.setSigned(mouEntity.getSigned());
						moudto.setApplicationAcronym(applicationEntity.getAcronym());
						// moudto.setCreatedBy(createdBy);

						if (!mouEntity.getMouDocEntities().isEmpty()) {
							List<MOUDocDTO> mouDocDTOs = new ArrayList<>();
							MOUDocDTO mouDocDTO = null;
							for (MOUDocEntity mouDocEntity : mouEntity.getMouDocEntities()) {
								if (mouDocEntity.isStatus()) {
									mouDocDTO = new MOUDocDTO();
									mouDocDTO.setMouDocId(mouDocEntity.getMouDocId());
									mouDocDTO.setFileName(mouDocEntity.getFileName());
									mouDocDTO.setStatus(mouDocEntity.isStatus());
									mouDocDTOs.add(mouDocDTO);
								}
							}
							moudto.setMouDocDTOs(mouDocDTOs);
						}
						moudtos.add(moudto);
					}
				}
			}
		}
		return moudtos;
	}
	
	
	
	
	
	
	///////////////////////////////////////
	
	@Override
	@Transactional
	public List<MOUDTO> getLocForMous() {
		
		List<MOUEntity> mouEntities = applicationDao.getAllMous();
		List<MOUDTO> moudtos = new ArrayList<>();
		for(MOUEntity mouEntity : mouEntities) {
			if(mouEntity.getApplicationEntity().getActiveLocality()==1) {
				
				MOUDTO moudto = new MOUDTO();
				moudto.setMouId(mouEntity.getMouId());
				moudto.setName(mouEntity.getName());
				moudto.setReceiptDt(mouEntity.getReceiptDt());
				moudto.setRecertificationDt(mouEntity.getRecertificationDt());
				moudto.setSigned(mouEntity.getSigned());
				moudto.setApplicationAcronym(mouEntity.getApplicationEntity().getAcronym());
				moudtos.add(moudto);
			}
				
		}
		
		return moudtos;
		
		
	}
	
	@Override
	@Transactional
	public List<MOUDTO> getSysForMous() {
		
		List<MOUEntity> mouEntities = applicationDao.getAllMous();
		List<MOUDTO> moudtos = new ArrayList<>();
		for(MOUEntity mouEntity : mouEntities) {
			if(mouEntity.getApplicationEntity().getActiveLocality()==0) {
				
				MOUDTO moudto = new MOUDTO();
				moudto.setMouId(mouEntity.getMouId());
				moudto.setName(mouEntity.getName());
				moudto.setReceiptDt(mouEntity.getReceiptDt());
				moudto.setRecertificationDt(mouEntity.getRecertificationDt());
				moudto.setSigned(mouEntity.getSigned());
				moudto.setApplicationAcronym(mouEntity.getApplicationEntity().getAcronym());
				moudtos.add(moudto);
			}
				
		}
		
		return moudtos;
		
		
	}
	
	
	
	
	
	
	///////////////////////////////////////

	@Override
	public ApplicationResp uploadPolicyDocuments(MultipartFile[] files, AppSolutionDevicesDTO appSolutionDevicesDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
