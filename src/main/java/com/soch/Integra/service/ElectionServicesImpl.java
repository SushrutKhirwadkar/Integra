package com.soch.Integra.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soch.Integra.dao.ApplicationDao;
import com.soch.Integra.dao.PolicyDao;
import com.soch.Integra.dao.SolutionDevicesDAO;
import com.soch.Integra.dao.SolutionsDAO;
import com.soch.Integra.dao.VendorDao;
import com.soch.Integra.dto.ApplicationResp;
import com.soch.Integra.dto.DeviceDocDTO;
import com.soch.Integra.dto.PrecinctTypeDTO;
import com.soch.Integra.dto.VendorAddressDTO;
import com.soch.Integra.dto.VendorContactDTO;
import com.soch.Integra.dto.VendorsDTO;
import com.soch.Integra.entities.AppSolutionDeviceEntity;
import com.soch.Integra.entities.AppSolutionEntity;
import com.soch.Integra.entities.CertDocEntity;
import com.soch.Integra.entities.DeviceDocEntity;
import com.soch.Integra.entities.HostingTypeEntity;
import com.soch.Integra.entities.LabVendorEntity;
import com.soch.Integra.entities.MOUEntity;
import com.soch.Integra.entities.PolicyDocumentsEntity;
import com.soch.Integra.entities.PrecinctTypeEntity;
import com.soch.Integra.entities.SolutionsEntity;
import com.soch.Integra.entities.SystemTypeEntity;
import com.soch.Integra.entities.VendorsEntity;
import com.soch.Integra.utils.APMUtils;
import com.soch.Integra.vendors.dto.AppSolutionDevicesDTO;
import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;
import com.soch.Integra.vendors.dto.CertDocDTO;
import com.soch.Integra.vendors.dto.HostingTypeDTO;
import com.soch.Integra.vendors.dto.LabVendorsDTO;
import com.soch.Integra.vendors.dto.ReportVendorsDTO;
import com.soch.Integra.vendors.dto.SolutionsDTO;
import com.soch.Integra.vendors.dto.SystemTypeDTO;


@Service
public class ElectionServicesImpl implements ElectionServices {

	@Autowired
	VendorDao vendorDao;

	@Autowired
	SolutionsDAO solutionsDAO;

	@Autowired
	SolutionDevicesDAO solutionDevicesDAO;

	@Autowired
	ApplicationDao applicationDao;

	@Autowired
	private Environment environment;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PolicyDao policyDao;

	@Override
	@Transactional
	public List<SolutionsDTO> getSolutions() {
		List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
		List<SolutionsDTO> solutionsDTOs = new ArrayList<>();
		SolutionsDTO solutionsDTO = null;
		SystemTypeDTO systemTypeDTO = null;
		VendorsDTO vendorsDTO = null;
		for (SolutionsEntity solutionsEntity : solutionsEntities) {
			solutionsDTO = null;
			solutionsDTO = new SolutionsDTO();
			solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
			solutionsDTO.setName(solutionsEntity.getName());
			solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
			solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
			solutionsDTO.setCertDt(solutionsEntity.getCertDt());
			solutionsDTO.setCertRenewalDueDt(solutionsEntity.getCertRenewalDueDt());
			solutionsDTO.setUpdatedBy(solutionsEntity.getUpdatedBy());
			solutionsDTO.setUpdatedTs(solutionsEntity.getUpdatedTs());
			if (solutionsEntity.getVendorsEntity() != null) {
				vendorsDTO = new VendorsDTO();
				vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());
				solutionsDTO.setVendor(vendorsDTO);
			}

			if (solutionsEntity.getSystemTypeEntity() != null) {
				systemTypeDTO = new SystemTypeDTO();
				systemTypeDTO.setDescription(solutionsEntity.getSystemTypeEntity().getDescription());
				systemTypeDTO.setName(solutionsEntity.getSystemTypeEntity().getName());
				solutionsDTO.setSystemTypeDTO(systemTypeDTO);
			}
			solutionsDTOs.add(solutionsDTO);
		}
		return solutionsDTOs;
	}

	private SystemTypeDTO getSystemType(int systemTypeId) {
		SystemTypeDTO systemTypeDTO = new SystemTypeDTO();
		SystemTypeEntity systemTypeEntity = solutionsDAO.getSystemTypeEntity(systemTypeId);
		systemTypeDTO.setDescription(systemTypeEntity.getDescription());
		systemTypeDTO.setName(systemTypeEntity.getName());
		systemTypeDTO.setSystemTypeId(systemTypeEntity.getSystemTypeId());
		return systemTypeDTO;
	}

	@Override
	@Transactional
	public SolutionsDTO getSolution(int solutionID) {
		SolutionsEntity solutionsEntity = solutionsDAO.getSolution(solutionID);
		SolutionsDTO solutionsDTO = new SolutionsDTO();
		VendorsDTO vendorsDTO = new VendorsDTO();
		solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
		solutionsDTO.setCertDt(solutionsEntity.getCertDt());
		solutionsDTO.setCertRenewalDueDt(solutionsEntity.getCertRenewalDueDt());
		solutionsDTO.setCertStadard(solutionsEntity.getCertStadard());
		solutionsDTO.setPatches(solutionsEntity.getPatches());
		solutionsDTO.setName(solutionsEntity.getName());
		solutionsDTO.setNotes(solutionsEntity.getNotes());
		solutionsDTO.setVendorId(solutionsEntity.getVendorsEntity().getVendorId());
		solutionsDTO.setSolutionType(solutionsEntity.getSolutionTypeEntity().getSolutionTypeId());
		solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
		solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
		solutionsDTO.setHostingTypeNotes(solutionsEntity.getHostingTypeNotes());
		solutionsDTO.setPrecinctTypeId(solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId());
		solutionsDTO.setPrecinctTypeName(solutionsEntity.getPrecinctTypeEntity().getTypeName());
		solutionsDTO.setUpdatedBy(solutionsEntity.getUpdatedBy());
		solutionsDTO.setUpdatedTs(solutionsEntity.getUpdatedTs());
		vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());

		if (solutionsEntity.getHostingTypeEntity() != null) {
			HostingTypeDTO hostingTypeDTO = new HostingTypeDTO();
			hostingTypeDTO.setDesc(solutionsEntity.getHostingTypeEntity().getDesc());
			hostingTypeDTO.setHostingTypeId(solutionsEntity.getHostingTypeEntity().getHostingTypeId());
			hostingTypeDTO.setName(solutionsEntity.getHostingTypeEntity().getName());
			solutionsDTO.setHostingTypeDTO(hostingTypeDTO);
		}

		if (solutionsEntity.getSystemTypeEntity() != null) {
			SystemTypeDTO systemTypeDTO = new SystemTypeDTO();
			SystemTypeEntity systemTypeEntity = solutionsEntity.getSystemTypeEntity();
			systemTypeDTO.setDescription(systemTypeEntity.getDescription());
			systemTypeDTO.setName(systemTypeEntity.getName());
			systemTypeDTO.setSystemTypeId(systemTypeEntity.getSystemTypeId());
			solutionsDTO.setSystemTypeDTO(systemTypeDTO);
		}

		if (solutionsEntity.getLabVendorEntity() != null) {
			LabVendorsDTO labVendorsDTO = new LabVendorsDTO();
			LabVendorEntity labVendorEntity = solutionsEntity.getLabVendorEntity();
			try {
				BeanUtils.copyProperties(labVendorsDTO, labVendorEntity);
				solutionsDTO.setLabVendorsDTO(labVendorsDTO);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (solutionsEntity.getCertDocEntities() != null && !solutionsEntity.getCertDocEntities().isEmpty()) {
			Set<CertDocEntity> certDocEntities = solutionsEntity.getCertDocEntities();
			List<CertDocDTO> certDocDTOs = new ArrayList<>();
			CertDocDTO certDocDTO = null;
			for (CertDocEntity certDocEntity : certDocEntities) {
				if (certDocEntity.getActiveFlag()) {
					certDocDTO = new CertDocDTO();
					certDocDTO.setActiveFlag(certDocEntity.getActiveFlag());
					certDocDTO.setCertDocId(certDocEntity.getCertDocId());
					certDocDTO.setFileName(certDocEntity.getFileName());
					certDocDTO.setSection(certDocEntity.getSection());
					certDocDTOs.add(certDocDTO);
				}
			}
			solutionsDTO.setCertDocDTOs(certDocDTOs);
		}
		solutionsDTO.setVendor(vendorsDTO);
		return solutionsDTO;
	}

	@Override
	@Transactional
	public ApplicationResp updateSolution(SolutionsDTO solutionsDTO, MultipartFile[] files) {
		ApplicationResp applicationResp = new ApplicationResp();
		SolutionsEntity solutionsEntity = solutionsDAO.getSolution(solutionsDTO.getSolutionId());
		solutionsEntity.setCertDt(solutionsDTO.getCertDt());
		solutionsEntity.setCertRenewalDueDt(solutionsDTO.getCertRenewalDueDt());
		solutionsEntity.setCertStadard(solutionsDTO.getCertStadard());
		solutionsEntity.setName(solutionsDTO.getName());
		solutionsEntity.setNotes(solutionsDTO.getNotes());
		solutionsEntity.setPatches(solutionsDTO.getPatches());
		solutionsEntity.setVersionNumber(solutionsDTO.getVersionNumber());
		solutionsEntity.setHostingTypeNotes(solutionsDTO.getHostingTypeNotes());
		solutionsEntity.setSolutionTypeEntity(vendorDao.getSolutionType(solutionsDTO.getSolutionType()));
		solutionsEntity.setUpdatedBy(solutionsDTO.getUpdatedBy());

		if (solutionsDTO.getPrecinctTypeId() != solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId())
			solutionsEntity.setPrecinctTypeEntity(solutionsDAO.getPrecinctType(solutionsDTO.getPrecinctTypeId()));

		if (solutionsDTO.getHostingTypeDTO().getHostingTypeId() != solutionsEntity.getHostingTypeEntity()
				.getHostingTypeId())
			solutionsEntity.setHostingTypeEntity(
					solutionsDAO.getHostingTypeEntity(solutionsDTO.getHostingTypeDTO().getHostingTypeId()));

		if (solutionsEntity.getLabVendorEntity().getLabVendorId() != solutionsDTO.getLabVendorsDTO().getLabVendorId()) {
			LabVendorEntity labVendorEntity = solutionsDAO
					.getLabVendorEntity(solutionsDTO.getLabVendorsDTO().getLabVendorId());
			solutionsEntity.setLabVendorEntity(labVendorEntity);
		}
		if (solutionsDTO.getSolutionType() != solutionsEntity.getSolutionTypeEntity().getSolutionTypeId())
			solutionsEntity.setSolutionTypeEntity(
					vendorDao.getSolutionType(solutionsEntity.getSolutionTypeEntity().getSolutionTypeId()));
		if (solutionsDTO.getSystemTypeDTO().getSystemTypeId() != solutionsEntity.getSystemTypeEntity()
				.getSystemTypeId())
			solutionsEntity.setSystemTypeEntity(
					solutionsDAO.getSystemTypeEntity(solutionsEntity.getSystemTypeEntity().getSystemTypeId()));
		solutionsEntity.setUpdatedTs(new Date());
		VendorsEntity vendorsEntity = vendorDao.getVendorEntity(solutionsDTO.getVendorId());
		solutionsEntity.setVendorsEntity(vendorsEntity);
		if (solutionsDTO.getCertDocDTOs() != null && !solutionsDTO.getCertDocDTOs().isEmpty()) {
			List<CertDocDTO> certDocDTOs = solutionsDTO.getCertDocDTOs();
			Set<CertDocEntity> certDocEntities = solutionsEntity.getCertDocEntities();
			CertDocEntity certDocEntity = null;
			for (CertDocDTO certDocDTO : certDocDTOs) {
				if (certDocDTO.getCertDocId() == null) {
					certDocEntity = new CertDocEntity();
					certDocEntity.setFileName(certDocDTO.getFileName());
					certDocEntity.setActiveFlag(true);
					certDocEntity.setCreatedBy(solutionsDTO.getCreatedBy());
					certDocEntity.setUpdatedBy(solutionsDTO.getCreatedBy());
					certDocEntity.setFileLocation(environment.getRequiredProperty("AAMLocation") + "Solutions");
					certDocEntity.setSolutionsEntity(solutionsEntity);
					certDocEntity.setUpdatedTs(new Date());
					certDocEntity.setSection(certDocDTO.getSection());
					certDocEntity.setCreatedTs(new Date());
					certDocEntities.add(certDocEntity);
				} else {
					for (CertDocEntity certDocEntity2 : certDocEntities) {
						if (certDocDTO.getCertDocId().equals(certDocEntity2.getCertDocId())
								&& !certDocDTO.isActiveFlag()) {
							certDocEntity2.setActiveFlag(false);
							certDocEntity2.setUpdatedBy(solutionsDTO.getUpdatedBy());
							certDocEntities.add(certDocEntity2);
						}
					}
				}
			}
			solutionsEntity.setCertDocEntities(certDocEntities);
		}
		solutionsEntity = solutionsDAO.saveSolution(solutionsEntity);
		APMUtils.uploadCertDoc(environment.getRequiredProperty("AAMLocation"), solutionsEntity.getSolutionId(), files);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;
	}

	@Override
	@Transactional
	public VendorsDTO getVendor(int vendorId) {
		VendorsEntity vendorsEntity = vendorDao.getVendorEntity(vendorId);
		VendorsDTO vendorsDTO = new VendorsDTO();
		VendorAddressDTO vendorAddressDTO = new VendorAddressDTO();
		VendorContactDTO vendorContactDTO = new VendorContactDTO();

		vendorsDTO.setVendorId(vendorsEntity.getVendorId());
		vendorsDTO.setName(vendorsEntity.getName());
		vendorsDTO.setUpdatedBy(vendorsEntity.getUpdatedBy());
		vendorsDTO.setUpdatedTs(vendorsEntity.getUpdatedTs());

		if (vendorsEntity.getVendorAddressEntity() != null) {
			vendorAddressDTO.setStreetName(vendorsEntity.getVendorAddressEntity().getStreetName());
			vendorAddressDTO.setCity(vendorsEntity.getVendorAddressEntity().getCity());
			vendorAddressDTO.setState(vendorsEntity.getVendorAddressEntity().getState());
			vendorAddressDTO.setZipcode(vendorsEntity.getVendorAddressEntity().getZipcode());
			vendorsDTO.setVendorAddress(vendorAddressDTO);
		}

		if (vendorsEntity.getVendorContactEntity() != null) {
			vendorContactDTO.setFirstName(vendorsEntity.getVendorContactEntity().getFirstName());
			vendorContactDTO.setLastName(vendorsEntity.getVendorContactEntity().getLastName());
			vendorContactDTO.setMiddleName(vendorsEntity.getVendorContactEntity().getMiddleName());
			vendorContactDTO.setPhoneNumber(vendorsEntity.getVendorContactEntity().getPhoneNumber());
			vendorContactDTO.setEmailId(vendorsEntity.getVendorContactEntity().getEmailId());
			vendorsDTO.setVendorContact(vendorContactDTO);
		}
		return vendorsDTO;
	}

	@Override
	@Transactional
	public List<SystemTypeDTO> getSystemTypes() {
		List<SystemTypeDTO> systemTypeDTOs = new ArrayList<>();
		SystemTypeDTO systemTypeDTO = null;
		List<SystemTypeEntity> systemTypeEntities = vendorDao.getSystemTypes();
		for (SystemTypeEntity systemTypeEntity : systemTypeEntities) {
			systemTypeDTO = new SystemTypeDTO();
			systemTypeDTO.setSystemTypeId(systemTypeEntity.getSystemTypeId());
			systemTypeDTO.setName(systemTypeEntity.getName());
			systemTypeDTO.setDescription(systemTypeEntity.getDescription());
			systemTypeDTOs.add(systemTypeDTO);
		}
		return systemTypeDTOs;
	}

	@Override
	@Transactional
	public List<LabVendorsDTO> getLabVendors() {
		List<LabVendorsDTO> labVendorsDTOs = new ArrayList<>();
		LabVendorsDTO labVendorsDTO = null;
		List<LabVendorEntity> labVendorEntities = vendorDao.getLabVendors();
		for (LabVendorEntity labVendorEntity : labVendorEntities) {
			labVendorsDTO = new LabVendorsDTO();
			try {
				BeanUtils.copyProperties(labVendorsDTO, labVendorEntity);
				labVendorsDTOs.add(labVendorsDTO);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return labVendorsDTOs;
	}

	@Override
	@Transactional
	public ApplicationResp registerSolution(SolutionsDTO solutionsDTO, MultipartFile[] files) {
		ApplicationResp applicationResp = new ApplicationResp();
		SolutionsEntity solutionsEntity = new SolutionsEntity();
		solutionsEntity.setCertDt(solutionsDTO.getCertDt());
		solutionsEntity.setCertRenewalDueDt(solutionsDTO.getCertRenewalDueDt());
		solutionsEntity.setCertStadard(solutionsDTO.getCertStadard());
		solutionsEntity.setName(solutionsDTO.getName());
		solutionsEntity.setNotes(solutionsDTO.getNotes());
		solutionsEntity.setPatches(solutionsDTO.getPatches());
		solutionsEntity.setVersionNumber(solutionsDTO.getVersionNumber());
		solutionsEntity.setSolutionTypeEntity(vendorDao.getSolutionType(solutionsDTO.getSolutionType()));
		solutionsEntity.setHostingTypeNotes(solutionsDTO.getHostingTypeNotes());
		solutionsEntity.setCreatedBy(solutionsDTO.getCreatedBy());
		solutionsEntity.setUpdatedBy(solutionsDTO.getCreatedBy());
		solutionsEntity.setUpdatedTs(new Date());

		solutionsEntity.setPrecinctTypeEntity(solutionsDAO.getPrecinctType(solutionsDTO.getPrecinctTypeId()));

		VendorsEntity vendorsEntity = vendorDao.getVendorEntity(solutionsDTO.getVendorId());
		solutionsEntity.setVendorsEntity(vendorsEntity);
		if (solutionsDTO.getLabVendorsDTO() != null) {
			LabVendorEntity labVendorEntity = solutionsDAO
					.getLabVendorEntity(solutionsDTO.getLabVendorsDTO().getLabVendorId());
			solutionsEntity.setLabVendorEntity(labVendorEntity);
		}
		SystemTypeEntity systemTypeEntity = solutionsDAO
				.getSystemTypeEntity(solutionsDTO.getSystemTypeDTO().getSystemTypeId());
		solutionsEntity.setSystemTypeEntity(systemTypeEntity);
		solutionsEntity.setCreatedTs(new Date());
		if (solutionsDTO.getCertDocDTOs() != null && !solutionsDTO.getCertDocDTOs().isEmpty()) {
			List<CertDocDTO> certDocDTOs = solutionsDTO.getCertDocDTOs();
			Set<CertDocEntity> certDocEntities = new HashSet<>();
			CertDocEntity certDocEntity = null;
			for (CertDocDTO certDocDTO : certDocDTOs) {
				certDocEntity = new CertDocEntity();
				certDocEntity.setFileName(certDocDTO.getFileName());
				certDocEntity.setActiveFlag(true);
				certDocEntity.setCreatedBy(solutionsDTO.getCreatedBy());
				certDocEntity.setUpdatedBy(solutionsDTO.getCreatedBy());
				certDocEntity.setFileLocation(environment.getRequiredProperty("AAMLocation") + "Solutions/");
				certDocEntity.setSolutionsEntity(solutionsEntity);
				certDocEntity.setUpdatedTs(new Date());
				certDocEntity.setSection(certDocDTO.getSection());
				certDocEntity.setCreatedTs(new Date());
				certDocEntities.add(certDocEntity);
			}
			solutionsEntity.setCertDocEntities(certDocEntities);
		}
		if (solutionsDTO.getHostingTypeDTO() != null && solutionsDTO.getHostingTypeDTO().getHostingTypeId() != 0) {
			solutionsEntity.setHostingTypeEntity(
					solutionsDAO.getHostingTypeEntity(solutionsDTO.getHostingTypeDTO().getHostingTypeId()));
		}
		solutionsEntity = solutionsDAO.saveSolution(solutionsEntity);
		APMUtils.uploadCertDoc(environment.getRequiredProperty("AAMLocation"), solutionsEntity.getSolutionId(), files);
		applicationResp.setResponseCode(Integer
				.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
		return applicationResp;
	}

	@Override
	@Transactional
	public List<SolutionsDTO> getSolutionsOnType(int systemTypeId) {
		List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
		List<SolutionsDTO> solutionsDTOs = new ArrayList<>();
		SolutionsDTO solutionsDTO = null;
		VendorsDTO vendorsDTO = null;
		for (SolutionsEntity solutionsEntity : solutionsEntities) {
			if (solutionsEntity.getSystemTypeEntity() != null
					&& solutionsEntity.getSystemTypeEntity().getSystemTypeId() == systemTypeId) {
				solutionsDTO = new SolutionsDTO();
				solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
				solutionsDTO.setName(solutionsEntity.getName());
				solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
				solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
				if (solutionsEntity.getVendorsEntity() != null) {
					vendorsDTO = new VendorsDTO();
					vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());
					solutionsDTO.setVendor(vendorsDTO);
				}
				solutionsDTOs.add(solutionsDTO);
			}
		}
		return solutionsDTOs;
	}

	@Override
	@Transactional
	public ApplicationResp saveAppSolution(ApplicationSolutionDTO applicationSolutionDTO) {
		AppSolutionEntity appSolutionEntity = new AppSolutionEntity();
		AppSolutionDeviceEntity appSolutionDeviceEntity = null;
		ApplicationResp applicationResp = new ApplicationResp();
		Set<AppSolutionDeviceEntity> appSolutionDeviceEntities = new HashSet<AppSolutionDeviceEntity>();
		appSolutionEntity.setActiveFlag(true);
		appSolutionEntity
				.setApplicationEntity(applicationDao.getApplicationOnId(applicationSolutionDTO.getApplicationID()));
		appSolutionEntity.setCreatedBy(applicationSolutionDTO.getCreatedBy());
		appSolutionEntity.setUpdatedBy(applicationSolutionDTO.getCreatedBy());
		appSolutionEntity.setCreatedTs(new Date());
		appSolutionEntity.setUpdatedTs(new Date());
		appSolutionEntity.setSolutionsEntity(solutionsDAO.getSolution(applicationSolutionDTO.getSolutionId()));
		if (applicationSolutionDTO.getHostingType() != null) {
			appSolutionEntity.setHostingTypeEntity(
					solutionsDAO.getHostingTypeEntity(applicationSolutionDTO.getHostingType().getHostingTypeId()));
		}
		List<AppSolutionDevicesDTO> appSolutionDevicesDTOs = applicationSolutionDTO.getAppSolutionDevices();
		for (AppSolutionDevicesDTO appSolutionDevicesDTO : appSolutionDevicesDTOs) {
			appSolutionDeviceEntity = new AppSolutionDeviceEntity();
			appSolutionDeviceEntity.setActiveFlag(true);
			appSolutionDeviceEntity.setModelNumber(appSolutionDevicesDTO.getModelNumber());
			appSolutionDeviceEntity.setSerialNumber(appSolutionDevicesDTO.getSerialNumber());
			appSolutionDeviceEntity.setCreatedBy(applicationSolutionDTO.getCreatedBy());
			appSolutionDeviceEntity.setUpdatedBy(applicationSolutionDTO.getCreatedBy());
			appSolutionDeviceEntity.setCreatedTs(new Date());
			appSolutionDeviceEntity.setUpdatedTs(new Date());
			appSolutionDeviceEntity.setAppSolutionEntity(appSolutionEntity);

			appSolutionDeviceEntity.setFirstName(appSolutionDevicesDTO.getFirstName());
			appSolutionDeviceEntity.setLastName(appSolutionDevicesDTO.getLastName());
			appSolutionDeviceEntity.setStreet1(appSolutionDevicesDTO.getStreet1());
			appSolutionDeviceEntity.setStreet2(appSolutionDevicesDTO.getStreet2());
			appSolutionDeviceEntity.setCity(appSolutionDevicesDTO.getCity());
			appSolutionDeviceEntity.setState(appSolutionDevicesDTO.getState());
			appSolutionDeviceEntity.setZipCode(appSolutionDevicesDTO.getZipCode());
			appSolutionDeviceEntity.setNotes(appSolutionDevicesDTO.getNotes());
			appSolutionDeviceEntity.setNextScanningDt(appSolutionDevicesDTO.getNextScanningDt());
			appSolutionDeviceEntity.setOverallStatus(appSolutionDevicesDTO.getOverallStatus());
			appSolutionDeviceEntities.add(appSolutionDeviceEntity);
		}
		appSolutionEntity.setAppSolutionDeviceEntities(appSolutionDeviceEntities);
		appSolutionEntity = solutionsDAO.saveAppSolution(appSolutionEntity);
		applicationSolutionDTO.setAppSolutionId(appSolutionEntity.getAppSolutionId());
		applicationResp.setApplicationSolutionDTO(applicationSolutionDTO);
		return applicationResp;
	}

	@Override
	@Transactional
	public ApplicationResp saveAppSolutionDevices(AppSolutionDevicesDTO appSolutionDevicesDTO, MultipartFile[] files) {

		ApplicationResp applicationResp = new ApplicationResp();
		String folderPath = null;
		AppSolutionDeviceEntity appSolutionDeviceEntity = new AppSolutionDeviceEntity();
		AppSolutionEntity appSolutionEntity = solutionsDAO.getAppSolution(appSolutionDevicesDTO.getAppSolutionId());
		appSolutionDeviceEntity.setActiveFlag(true);
		appSolutionDeviceEntity
				.setAppSolutionEntity(solutionsDAO.getAppSolution(appSolutionDevicesDTO.getAppSolutionId()));
		// appSolutionEntity.setSolutionsEntity(solutionsDAO.getSolution(applicationSolutionDTO.getSolutionId()));
		appSolutionDeviceEntity.setModelNumber(appSolutionDevicesDTO.getModelNumber());
		appSolutionDeviceEntity.setSerialNumber(appSolutionDevicesDTO.getSerialNumber());
		appSolutionDeviceEntity.setCreatedBy(appSolutionDevicesDTO.getCreatedBy());
		// appSolutionDeviceEntity.setUpdatedBy(applicationSolutionDTO.getCreatedBy());
		appSolutionDeviceEntity.setCreatedTs(new Date());
		appSolutionDeviceEntity.setUpdatedTs(new Date());
		// appSolutionDeviceEntity.setAppSolutionEntity(appSolutionEntity);
		appSolutionDeviceEntity.setFirstName(appSolutionDevicesDTO.getFirstName());
		appSolutionDeviceEntity.setLastName(appSolutionDevicesDTO.getLastName());
		appSolutionDeviceEntity.setStreet1(appSolutionDevicesDTO.getStreet1());
		appSolutionDeviceEntity.setStreet2(appSolutionDevicesDTO.getStreet2());
		appSolutionDeviceEntity.setCity(appSolutionDevicesDTO.getCity());
		appSolutionDeviceEntity.setState(appSolutionDevicesDTO.getState());
		appSolutionDeviceEntity.setZipCode(appSolutionDevicesDTO.getZipCode());
		appSolutionDeviceEntity.setNotes(appSolutionDevicesDTO.getNotes());
		appSolutionDeviceEntity.setNextScanningDt(appSolutionDevicesDTO.getNextScanningDt());
		appSolutionDeviceEntity.setCurrentScanningDt(appSolutionDevicesDTO.getCurrentScanningDt());
		appSolutionDeviceEntity.setOverallStatus(appSolutionDevicesDTO.getOverallStatus());
		if (appSolutionDevicesDTO.getDeviceDocDTO() != null) {
			Set<DeviceDocEntity> deviceDocEntities = new HashSet<>(0);
			DeviceDocEntity deviceDocEntity = null;
			for (DeviceDocDTO deviceDocDTO : appSolutionDevicesDTO.getDeviceDocDTO()) {
				folderPath = environment.getRequiredProperty("AAMLocation") + appSolutionEntity.getAppSolutionId();
				deviceDocEntity = new DeviceDocEntity();
				for (MultipartFile file : files) {
					if (file.getOriginalFilename().equalsIgnoreCase(deviceDocDTO.getFileName()))
						if (!createMOUFile(file, folderPath))
							applicationResp.setResponseCode(Integer.parseInt(messageSource
									.getMessage("APPLICATION.GENERAL,FAIL.CODE", null, Locale.getDefault())));
				}
				deviceDocEntity.setAppSolutionDeviceEntity(appSolutionDeviceEntity);
				deviceDocEntity.setFileName(deviceDocDTO.getFileName());
				deviceDocEntity.setLocation(environment.getRequiredProperty("AAMLocation")
						+ appSolutionEntity.getAppSolutionId() + "/devices");
				deviceDocEntity.setCreatedBy(appSolutionDevicesDTO.getCreatedBy());
				deviceDocEntity.setUpdatedBy(appSolutionDevicesDTO.getUpdatedBy());
				deviceDocEntity.setUpdatedTs(new Date());
				deviceDocEntity.setCreatedTs(new Date());
				deviceDocEntity.setStatus(deviceDocDTO.isStatus());
				deviceDocEntities.add(deviceDocEntity);

			}
			appSolutionDeviceEntity.setDeviceDocEntities(deviceDocEntities);

		}
		appSolutionDeviceEntity = solutionDevicesDAO.saveAppSolutionDevices(appSolutionDeviceEntity);
		// appSolutionDevicesDTO.setDeviceDocDTO(appSolutionDeviceEntity.getDeviceDocEntities());
		appSolutionDevicesDTO.setAppSolutionDevice(appSolutionDeviceEntity.getAppSolutionDevice());
		// appSolutionDevicesDTO.setDeviceDocDTO(appSolutionDeviceEntity.getDeviceDocEntities());
		applicationResp.setAppSolutionDeviceDTO(appSolutionDevicesDTO);
		return applicationResp;
	}

	@Override
	@Transactional
	public ApplicationResp updateAppSolutionDevice(AppSolutionDevicesDTO appSolutionDevicesDTO, MultipartFile[] files) {
		ApplicationResp applicationResp = new ApplicationResp();
		String folderPath = null;
		List<AppSolutionDeviceEntity> appSolutionDeviceEntities = solutionDevicesDAO.getAppSolutionDeviceEntities();
		// System.out.println("checking Entity");
		// for (int i = 0; i < appSolutionDeviceEntities.size(); i++) {
		// System.out.println(appSolutionDeviceEntities.get(i).getAppSolutionDevice());
		// }

		// System.out.println("checking DTO");
		// System.out.println(appSolutionDevicesDTO.getAppSolutionDevice());

		for (AppSolutionDeviceEntity appSolutionDeviceEntity : appSolutionDeviceEntities) {

			if (appSolutionDeviceEntity.getAppSolutionDevice().equals(appSolutionDevicesDTO.getAppSolutionDevice())) {

				// System.out.println("check for update");

				// appSolutionEntity.setSolutionsEntity(solutionsDAO.getSolution(applicationSolutionDTO.getSolutionId()));
				appSolutionDeviceEntity.setModelNumber(appSolutionDevicesDTO.getModelNumber());
				appSolutionDeviceEntity.setSerialNumber(appSolutionDevicesDTO.getSerialNumber());
				// appSolutionDeviceEntity.setCreatedBy(applicationSolutionDTO.getCreatedBy());
				appSolutionDeviceEntity.setUpdatedBy(appSolutionDevicesDTO.getCreatedBy());
				appSolutionDeviceEntity.setCreatedTs(new Date());
				appSolutionDeviceEntity.setUpdatedTs(new Date());
				// appSolutionDeviceEntity.setAppSolutionEntity(appSolutionEntity);
				appSolutionDeviceEntity.setFirstName(appSolutionDevicesDTO.getFirstName());
				appSolutionDeviceEntity.setLastName(appSolutionDevicesDTO.getLastName());
				appSolutionDeviceEntity.setStreet1(appSolutionDevicesDTO.getStreet1());
				appSolutionDeviceEntity.setStreet2(appSolutionDevicesDTO.getStreet2());
				appSolutionDeviceEntity.setCity(appSolutionDevicesDTO.getCity());
				appSolutionDeviceEntity.setState(appSolutionDevicesDTO.getState());
				appSolutionDeviceEntity.setZipCode(appSolutionDevicesDTO.getZipCode());
				appSolutionDeviceEntity.setNotes(appSolutionDevicesDTO.getNotes());
				appSolutionDeviceEntity.setNextScanningDt(appSolutionDevicesDTO.getNextScanningDt());
				appSolutionDeviceEntity.setCurrentScanningDt(appSolutionDevicesDTO.getCurrentScanningDt());
				appSolutionDeviceEntity.setOverallStatus(appSolutionDevicesDTO.getOverallStatus());

				if (appSolutionDevicesDTO.getDeviceDocDTO() != null) {
					Set<DeviceDocEntity> deviceDocEntities = new HashSet<>(0);
					DeviceDocEntity deviceDocEntity = null;

					for (DeviceDocDTO deviceDocDTO : appSolutionDevicesDTO.getDeviceDocDTO()) {
						if (deviceDocDTO.isNewFile()) {
							folderPath = environment.getRequiredProperty("AAMLocation")
									+ appSolutionDeviceEntity.getAppSolutionEntity().getAppSolutionId();
							deviceDocEntity = new DeviceDocEntity();
							for (MultipartFile file : files) {
								if (file.getOriginalFilename().equalsIgnoreCase(deviceDocDTO.getFileName()))
									if (!createMOUFile(file, folderPath))
										applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage(
												"APPLICATION.GENERAL.FAIL.CODE", null, Locale.getDefault())));
							}
							deviceDocEntity.setAppSolutionDeviceEntity(appSolutionDeviceEntity);
							deviceDocEntity.setFileName(deviceDocDTO.getFileName());

							deviceDocEntity.setLocation(environment.getRequiredProperty("AAMLocation")
									+ appSolutionDeviceEntity.getAppSolutionEntity().getAppSolutionId() + "/devices");
							deviceDocEntity.setCreatedBy(appSolutionDevicesDTO.getCreatedBy());
							deviceDocEntity.setUpdatedBy(appSolutionDevicesDTO.getUpdatedBy());
							deviceDocEntity.setUpdatedTs(new Date());
							deviceDocEntity.setCreatedTs(new Date());
							deviceDocEntity.setStatus(deviceDocDTO.isStatus());

							deviceDocEntities.add(deviceDocEntity);
						} else {
							for (DeviceDocEntity deviceDocEntity2 : appSolutionDeviceEntity.getDeviceDocEntities()) {
								if (deviceDocEntity2.getDeviceDocId() == deviceDocDTO.getDeviceDocId()
										&& deviceDocEntity2.isStatus()) {
									deviceDocEntity2.setStatus(deviceDocDTO.isStatus());
									deviceDocEntity2.setUpdatedBy(appSolutionDevicesDTO.getCreatedBy());
									deviceDocEntity2.setUpdatedTs(new Date());
									deviceDocEntities.add(deviceDocEntity2);
								}
							}

						}
					}
					appSolutionDeviceEntity.setDeviceDocEntities(deviceDocEntities);
				}

				appSolutionDeviceEntity = solutionDevicesDAO.saveAppSolutionDevices(appSolutionDeviceEntity);
				// System.out.println("check for update entity" +
				// appSolutionDeviceEntity.getCity());
				// appSolutionDevicesDTO.setAppSolutionDevice(appSolutionDeviceEntity.getAppSolutionDevice());

				// System.out.println("out og loop");

			}

		}
		applicationResp.setAppSolutionDeviceDTO(appSolutionDevicesDTO);
		return applicationResp;

	}

	@Override
	@Transactional
	public ApplicationResp updateAppSolution(ApplicationSolutionDTO applicationSolutionDTO) {
		AppSolutionEntity appSolutionEntity = solutionsDAO.getAppSolution(applicationSolutionDTO.getAppSolutionId());
		AppSolutionDeviceEntity appSolutionDeviceEntity = null;
		Set<AppSolutionDeviceEntity> appSolutionDeviceEntities = new HashSet<AppSolutionDeviceEntity>();
		appSolutionEntity.setActiveFlag(applicationSolutionDTO.isActiveFlag());
		appSolutionEntity
				.setApplicationEntity(applicationDao.getApplicationOnId(applicationSolutionDTO.getApplicationID()));
		appSolutionEntity.setUpdatedBy(applicationSolutionDTO.getUpdatedBy());
		appSolutionEntity.setUpdatedTs(new Date());
		if (appSolutionEntity.getSolutionsEntity().getSolutionId() != applicationSolutionDTO.getSolutionId())
			appSolutionEntity.setSolutionsEntity(solutionsDAO.getSolution(applicationSolutionDTO.getSolutionId()));

		if (applicationSolutionDTO.getHostingType() != null && (applicationSolutionDTO.getHostingType()
				.getHostingTypeId() != appSolutionEntity.getHostingTypeEntity().getHostingTypeId())) {
			appSolutionEntity.setHostingTypeEntity(
					solutionsDAO.getHostingTypeEntity(applicationSolutionDTO.getHostingType().getHostingTypeId()));
		}
		List<AppSolutionDevicesDTO> appSolutionDevicesDTOs = applicationSolutionDTO.getAppSolutionDevices();
		appSolutionDeviceEntities = appSolutionEntity.getAppSolutionDeviceEntities();
		if (appSolutionDevicesDTOs != null)
			for (AppSolutionDevicesDTO appSolutionDevicesDTO : appSolutionDevicesDTOs) {
				if (appSolutionDevicesDTO.getAppSolutionDevice() == null) {
					appSolutionDeviceEntity = new AppSolutionDeviceEntity();
					appSolutionDeviceEntity.setActiveFlag(true);
					appSolutionDeviceEntity.setModelNumber(appSolutionDevicesDTO.getModelNumber());
					appSolutionDeviceEntity.setSerialNumber(appSolutionDevicesDTO.getSerialNumber());
					appSolutionDeviceEntity.setCreatedBy(applicationSolutionDTO.getCreatedBy());
					appSolutionDeviceEntity.setUpdatedBy(applicationSolutionDTO.getCreatedBy());
					appSolutionDeviceEntity.setCreatedTs(new Date());
					appSolutionDeviceEntity.setUpdatedTs(new Date());
					appSolutionDeviceEntity.setAppSolutionEntity(appSolutionEntity);

					appSolutionDeviceEntity.setFirstName(appSolutionDevicesDTO.getFirstName());
					appSolutionDeviceEntity.setLastName(appSolutionDevicesDTO.getLastName());
					appSolutionDeviceEntity.setStreet1(appSolutionDevicesDTO.getStreet1());
					appSolutionDeviceEntity.setStreet2(appSolutionDevicesDTO.getStreet2());
					appSolutionDeviceEntity.setCity(appSolutionDevicesDTO.getCity());
					appSolutionDeviceEntity.setState(appSolutionDevicesDTO.getState());
					appSolutionDeviceEntity.setZipCode(appSolutionDevicesDTO.getZipCode());
					appSolutionDeviceEntity.setNotes(appSolutionDevicesDTO.getNotes());
					appSolutionDeviceEntity.setNextScanningDt(appSolutionDevicesDTO.getNextScanningDt());
					appSolutionDeviceEntity.setOverallStatus(appSolutionDevicesDTO.getOverallStatus());

					appSolutionDeviceEntities.add(appSolutionDeviceEntity);
				} else {
					for (AppSolutionDeviceEntity appSolutionDeviceEntity2 : appSolutionDeviceEntities) {
						if (appSolutionDeviceEntity2.getAppSolutionDevice() != null && appSolutionDeviceEntity2
								.getAppSolutionDevice() == appSolutionDevicesDTO.getAppSolutionDevice()) {
							appSolutionDeviceEntity2.setActiveFlag(applicationSolutionDTO.isActiveFlag());
							appSolutionDeviceEntity2.setModelNumber(appSolutionDevicesDTO.getModelNumber());
							appSolutionDeviceEntity2.setSerialNumber(appSolutionDevicesDTO.getSerialNumber());
							appSolutionDeviceEntity2.setUpdatedBy(applicationSolutionDTO.getCreatedBy());
							appSolutionDeviceEntity2.setUpdatedTs(new Date());
							appSolutionDeviceEntity2.setAppSolutionEntity(appSolutionEntity);

							appSolutionDeviceEntity2.setFirstName(appSolutionDevicesDTO.getFirstName());
							appSolutionDeviceEntity2.setLastName(appSolutionDevicesDTO.getLastName());
							appSolutionDeviceEntity2.setStreet1(appSolutionDevicesDTO.getStreet1());
							appSolutionDeviceEntity2.setStreet2(appSolutionDevicesDTO.getStreet2());
							appSolutionDeviceEntity2.setCity(appSolutionDevicesDTO.getCity());
							appSolutionDeviceEntity2.setState(appSolutionDevicesDTO.getState());
							appSolutionDeviceEntity2.setZipCode(appSolutionDevicesDTO.getZipCode());
							appSolutionDeviceEntity.setNotes(appSolutionDevicesDTO.getNotes());
							appSolutionDeviceEntity.setNextScanningDt(appSolutionDevicesDTO.getNextScanningDt());
							appSolutionDeviceEntity.setOverallStatus(appSolutionDevicesDTO.getOverallStatus());
							appSolutionDeviceEntities.add(appSolutionDeviceEntity2);
						}
					}
				}

			}
		appSolutionEntity.setAppSolutionDeviceEntities(appSolutionDeviceEntities);
		appSolutionEntity = solutionsDAO.saveAppSolution(appSolutionEntity);
		return null;
	}

	@Override
	@Transactional
	public List<ApplicationSolutionDTO> getAppSolutions(int applicationId) {
		List<AppSolutionEntity> appSolutionEntities = solutionsDAO.getAppSolutions(applicationId);
		List<ApplicationSolutionDTO> applicationSolutionDTOs = new ArrayList<>();
		ApplicationSolutionDTO applicationSolutionDTO = null;
		SolutionsEntity solutionsEntity = null;
		SystemTypeDTO systemTypeDTO = null;
		SolutionsDTO solutionsDTO = null;
		AppSolutionDevicesDTO appSolutionDevicesDTO = new AppSolutionDevicesDTO();
		List<AppSolutionDevicesDTO> appSolutionDevicesDTOs = new ArrayList<>();
		for (AppSolutionEntity appSolutionEntity : appSolutionEntities) {
			applicationSolutionDTO = new ApplicationSolutionDTO();

			solutionsEntity = appSolutionEntity.getSolutionsEntity();
			solutionsDTO = null;
			solutionsDTO = new SolutionsDTO();
			solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
			solutionsDTO.setName(solutionsEntity.getName());
			solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
			solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());

			if (solutionsEntity.getSystemTypeEntity() != null) {
				systemTypeDTO = new SystemTypeDTO();
				systemTypeDTO.setDescription(solutionsEntity.getSystemTypeEntity().getDescription());
				systemTypeDTO.setName(solutionsEntity.getSystemTypeEntity().getName());
			}

			if (appSolutionEntity.getAppSolutionDeviceEntities() != null
					&& !appSolutionEntity.getAppSolutionDeviceEntities().isEmpty()) {
				Set<AppSolutionDeviceEntity> appSolutionDeviceEntities = appSolutionEntity
						.getAppSolutionDeviceEntities();

				for (AppSolutionDeviceEntity appSolutionDeviceEntity : appSolutionDeviceEntities) {
					if (appSolutionDeviceEntity.getActiveFlag()) {
						appSolutionDevicesDTO = new AppSolutionDevicesDTO();
						appSolutionDevicesDTO.setActiveFlag(true);
						appSolutionDevicesDTO.setModelNumber(appSolutionDeviceEntity.getModelNumber());
						appSolutionDevicesDTO.setSerialNumber(appSolutionDeviceEntity.getSerialNumber());
						appSolutionDevicesDTO.setCreatedBy(appSolutionDeviceEntity.getCreatedBy());
						appSolutionDevicesDTO.setUpdatedBy(appSolutionDeviceEntity.getCreatedBy());

						appSolutionDevicesDTO.setFirstName(appSolutionDeviceEntity.getFirstName());
						appSolutionDevicesDTO.setLastName(appSolutionDeviceEntity.getLastName());
						appSolutionDevicesDTO.setStreet1(appSolutionDeviceEntity.getStreet1());
						appSolutionDevicesDTO.setStreet2(appSolutionDeviceEntity.getStreet2());
						appSolutionDevicesDTO.setCity(appSolutionDeviceEntity.getCity());
						appSolutionDevicesDTO.setState(appSolutionDeviceEntity.getState());
						appSolutionDevicesDTO.setZipCode(appSolutionDeviceEntity.getZipCode());
						appSolutionDevicesDTO.setOverallStatus(appSolutionDeviceEntity.getOverallStatus());
						appSolutionDevicesDTO.setNotes(appSolutionDeviceEntity.getNotes());
						appSolutionDevicesDTO.setNextScanningDt(appSolutionDeviceEntity.getNextScanningDt());
						appSolutionDevicesDTOs.add(appSolutionDevicesDTO);
					}

				}
			}
			applicationSolutionDTO.setAppSolutionDevices(appSolutionDevicesDTOs);
			applicationSolutionDTO.setSolutionsDTO(solutionsDTO);
			applicationSolutionDTOs.add(applicationSolutionDTO);
		}
		return applicationSolutionDTOs;
	}

	@Override
	@Transactional
	public List<ApplicationSolutionDTO> getAppSolutions(Set<AppSolutionEntity> appSolutionEntities) {
		List<ApplicationSolutionDTO> applicationSolutionDTOs = new ArrayList<>();
		ApplicationSolutionDTO applicationSolutionDTO = null;
		SolutionsEntity solutionsEntity = null;
		SystemTypeDTO systemTypeDTO = null;
		SolutionsDTO solutionsDTO = null;
		VendorsDTO vendorsDTO = null;
		for (AppSolutionEntity appSolutionEntity : appSolutionEntities) {
			applicationSolutionDTO = new ApplicationSolutionDTO();

			solutionsEntity = appSolutionEntity.getSolutionsEntity();
			applicationSolutionDTO.setAppSolutionId(appSolutionEntity.getAppSolutionId());
			applicationSolutionDTO.setUpdatedBy(appSolutionEntity.getUpdatedBy());
			applicationSolutionDTO.setUpdatedTs(appSolutionEntity.getUpdatedTs());
			solutionsDTO = null;
			solutionsDTO = new SolutionsDTO();
			solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
			solutionsDTO.setName(solutionsEntity.getName());
			solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
			solutionsDTO.setPrecinctTypeId(solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId());
			solutionsDTO.setPrecinctTypeName(solutionsEntity.getPrecinctTypeEntity().getTypeName());
			solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
			if (solutionsEntity.getVendorsEntity() != null) {
				vendorsDTO = new VendorsDTO();
				vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());
				solutionsDTO.setVendor(vendorsDTO);
			}

			if (solutionsEntity.getSystemTypeEntity() != null) {
				systemTypeDTO = new SystemTypeDTO();
				systemTypeDTO.setDescription(solutionsEntity.getSystemTypeEntity().getDescription());
				systemTypeDTO.setName(solutionsEntity.getSystemTypeEntity().getName());
			}
			applicationSolutionDTO.setSolutionsDTO(solutionsDTO);
			applicationSolutionDTOs.add(applicationSolutionDTO);
		}
		return applicationSolutionDTOs;

	}

	@Override
	@Transactional
	public ApplicationSolutionDTO getAppSolution(int solutionId) {
		AppSolutionEntity appSolutionEntity = solutionsDAO.getAppSolution(solutionId);
		ApplicationSolutionDTO applicationSolutionDTO = null;
		SolutionsEntity solutionsEntity = null;
		SystemTypeDTO systemTypeDTO = null;
		SolutionsDTO solutionsDTO = null;
		List<AppSolutionDevicesDTO> appSolutionDevicesDTOs = new ArrayList<>();
		// List<DeviceDocDTO> devicesDocDTOs = new ArrayList<>();
		AppSolutionDevicesDTO appSolutionDevicesDTO = null;
		DeviceDocDTO deviceDTO = null;
		applicationSolutionDTO = new ApplicationSolutionDTO();
		applicationSolutionDTO.setNotes(appSolutionEntity.getNotes());
		applicationSolutionDTO.setActiveFlag(appSolutionEntity.getActiveFlag());
		applicationSolutionDTO.setAppSolutionId(appSolutionEntity.getAppSolutionId());
		applicationSolutionDTO.setApplicationID(appSolutionEntity.getApplicationEntity().getApplicationId());
		VendorsDTO vendorsDTO = new VendorsDTO();

		solutionsEntity = appSolutionEntity.getSolutionsEntity();
		solutionsDTO = null;
		solutionsDTO = new SolutionsDTO();
		solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
		solutionsDTO.setName(solutionsEntity.getName());
		solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
		solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());

		solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
		solutionsDTO.setCertDt(solutionsEntity.getCertDt());
		solutionsDTO.setCertRenewalDueDt(solutionsEntity.getCertRenewalDueDt());
		solutionsDTO.setCertStadard(solutionsEntity.getCertStadard());
		solutionsDTO.setPatches(solutionsEntity.getPatches());
		solutionsDTO.setName(solutionsEntity.getName());
		solutionsDTO.setNotes(solutionsEntity.getNotes());
		solutionsDTO.setVendorId(solutionsEntity.getVendorsEntity().getVendorId());
		solutionsDTO.setSolutionType(solutionsEntity.getSolutionTypeEntity().getSolutionTypeId());
		solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
		solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
		solutionsDTO.setPrecinctTypeId(solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId());
		solutionsDTO.setPrecinctTypeName(solutionsEntity.getPrecinctTypeEntity().getTypeName());
		vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());
		solutionsDTO.setVendor(vendorsDTO);
		if (appSolutionEntity.getHostingTypeEntity() != null) {
			HostingTypeDTO hostingTypeDTO = new HostingTypeDTO();
			hostingTypeDTO.setHostingTypeId(appSolutionEntity.getHostingTypeEntity().getHostingTypeId());
			hostingTypeDTO.setName(appSolutionEntity.getHostingTypeEntity().getName());
			applicationSolutionDTO.setHostingType(hostingTypeDTO);
			;
		}
		if (solutionsEntity.getSystemTypeEntity() != null) {
			systemTypeDTO = new SystemTypeDTO();
			SystemTypeEntity systemTypeEntity = solutionsEntity.getSystemTypeEntity();
			systemTypeDTO.setDescription(systemTypeEntity.getDescription());
			systemTypeDTO.setName(systemTypeEntity.getName());
			systemTypeDTO.setSystemTypeId(systemTypeEntity.getSystemTypeId());
			solutionsDTO.setSystemTypeDTO(systemTypeDTO);
		}

		if (appSolutionEntity.getAppSolutionDeviceEntities() != null
				&& !appSolutionEntity.getAppSolutionDeviceEntities().isEmpty()) {
			Set<AppSolutionDeviceEntity> appSolutionDeviceEntities = appSolutionEntity.getAppSolutionDeviceEntities();

			for (AppSolutionDeviceEntity appSolutionDeviceEntity : appSolutionDeviceEntities) {

				if (appSolutionEntity.getActiveFlag()) {

					appSolutionDevicesDTO = new AppSolutionDevicesDTO();

					appSolutionDevicesDTO.setAppSolutionDevice(appSolutionDeviceEntity.getAppSolutionDevice());
					appSolutionDevicesDTO.setActiveFlag(true);
					appSolutionDevicesDTO.setModelNumber(appSolutionDeviceEntity.getModelNumber());
					appSolutionDevicesDTO.setSerialNumber(appSolutionDeviceEntity.getSerialNumber());
					appSolutionDevicesDTO.setCreatedBy(appSolutionDeviceEntity.getCreatedBy());
					appSolutionDevicesDTO.setUpdatedBy(appSolutionDeviceEntity.getCreatedBy());

					appSolutionDevicesDTO.setFirstName(appSolutionDeviceEntity.getFirstName());
					appSolutionDevicesDTO.setLastName(appSolutionDeviceEntity.getLastName());
					appSolutionDevicesDTO.setStreet1(appSolutionDeviceEntity.getStreet1());
					appSolutionDevicesDTO.setStreet2(appSolutionDeviceEntity.getStreet2());
					appSolutionDevicesDTO.setCity(appSolutionDeviceEntity.getCity());
					appSolutionDevicesDTO.setState(appSolutionDeviceEntity.getState());
					appSolutionDevicesDTO.setZipCode(appSolutionDeviceEntity.getZipCode());
					appSolutionDevicesDTO.setOverallStatus(appSolutionDeviceEntity.getOverallStatus());
					appSolutionDevicesDTO.setNotes(appSolutionDeviceEntity.getNotes());
					appSolutionDevicesDTO.setNextScanningDt(appSolutionDeviceEntity.getNextScanningDt());
					appSolutionDevicesDTO.setCurrentScanningDt(appSolutionDeviceEntity.getCurrentScanningDt());
					Set<DeviceDocEntity> deviceDocEntities = appSolutionDeviceEntity.getDeviceDocEntities();
					if (!deviceDocEntities.isEmpty()) {
						List<DeviceDocDTO> deviceDocDTOs = new ArrayList<DeviceDocDTO>();
						DeviceDocDTO deviceDocDTO = null;
						for (DeviceDocEntity deviceDocEntity : deviceDocEntities) {
							if (deviceDocEntity.isStatus()) {
								deviceDocDTO = new DeviceDocDTO();
								deviceDocDTO.setDeviceDocId(deviceDocEntity.getDeviceDocId());
								deviceDocDTO.setFileName(deviceDocEntity.getFileName());
								deviceDocDTO.setStatus(deviceDocEntity.isStatus());
								deviceDocDTOs.add(deviceDocDTO);
							}
						}
						appSolutionDevicesDTO.setDeviceDocDTO(deviceDocDTOs);
					}
					//
					appSolutionDevicesDTOs.add(appSolutionDevicesDTO);
				}

			}
			applicationSolutionDTO.setAppSolutionDevices(appSolutionDevicesDTOs);
		}
		applicationSolutionDTO.setSolutionsDTO(solutionsDTO);

		return applicationSolutionDTO;
	}

	@Override
	@Transactional
	public List<HostingTypeDTO> getHostingTypes() {
		List<HostingTypeEntity> hostingTypeEntities = solutionsDAO.getHostingTypes();
		List<HostingTypeDTO> hostingTypeDTOs = new ArrayList<>();
		HostingTypeDTO hostingTypeDTO = null;
		for (HostingTypeEntity hostingTypeEntity : hostingTypeEntities) {
			hostingTypeDTO = new HostingTypeDTO();
			hostingTypeDTO.setDesc(hostingTypeEntity.getDesc());
			hostingTypeDTO.setHostingTypeId(hostingTypeEntity.getHostingTypeId());
			hostingTypeDTO.setName(hostingTypeEntity.getName());
			hostingTypeDTOs.add(hostingTypeDTO);
		}
		return hostingTypeDTOs;
	}

	@Override
	@Transactional
	public String getSolutionFile(int fileID) {
		CertDocEntity certDocEntity = solutionsDAO.getSolutionFile(fileID);
		return certDocEntity.getFileLocation() + "//" + certDocEntity.getSolutionsEntity().getSolutionId() + "//"
				+ certDocEntity.getFileName();
	}

	@Override
	@Transactional
	public List<PrecinctTypeDTO> getPrecinctTypes() {
		List<PrecinctTypeDTO> precinctTypeDTOs = new ArrayList<>();
		PrecinctTypeDTO precinctTypeDTO = null;
		List<PrecinctTypeEntity> precinctTypeEntities = solutionsDAO.getPrecinctTypes();

		for (PrecinctTypeEntity precinctTypeEntity : precinctTypeEntities) {
			precinctTypeDTO = new PrecinctTypeDTO();
			precinctTypeDTO.setPrecinctTypeId(precinctTypeEntity.getPrecinctTypeId());
			precinctTypeDTO.setTypeName(precinctTypeEntity.getTypeName());
			precinctTypeDTOs.add(precinctTypeDTO);
		}

		return precinctTypeDTOs;
	}

	@Override
	@Transactional
	public List<SolutionsDTO> getSolutionsOnType(int systemTypeId, int precinctTypeId) {
		List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
		List<SolutionsDTO> solutionsDTOs = new ArrayList<>();
		SolutionsDTO solutionsDTO = null;
		VendorsDTO vendorsDTO = null;
		for (SolutionsEntity solutionsEntity : solutionsEntities) {
			if (solutionsEntity.getSystemTypeEntity() != null
					&& (solutionsEntity.getSystemTypeEntity().getSystemTypeId() == systemTypeId
							&& solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId() == precinctTypeId)) {
				solutionsDTO = new SolutionsDTO();
				solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
				solutionsDTO.setName(solutionsEntity.getName());
				solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
				solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
				if (solutionsEntity.getVendorsEntity() != null) {
					vendorsDTO = new VendorsDTO();
					vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());
					solutionsDTO.setVendor(vendorsDTO);
				}
				solutionsDTOs.add(solutionsDTO);
			}
		}
		return solutionsDTOs;
	}
	//////////////////////////////////////////// Reports//////////////////////////////////////////

	/*
	 * @Override
	 * 
	 * @Transactional public Set<String> getLocOnTypeForReports(int systemTypeId) {
	 * List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
	 * List<SolutionsDTO> solutionsDTOs = new ArrayList<>();
	 * 
	 * List<AppSolutionEntity> appSolutionEntities =
	 * solutionsDAO.getAllAppSolutions(); Set<String> acronyms = new HashSet<>();
	 * 
	 * for (SolutionsEntity solutionsEntity : solutionsEntities) { if
	 * (solutionsEntity.getSystemTypeEntity() != null &&
	 * (solutionsEntity.getSystemTypeEntity().getSystemTypeId() == systemTypeId)) {
	 * 
	 * int a = solutionsEntity.getSolutionId();
	 * 
	 * for(AppSolutionEntity appSolutionEntity : appSolutionEntities) {
	 * if(appSolutionEntity.getSolutionsEntity().getSolutionId() == a) {
	 * appSolutionEntity.getApplicationEntity().getAcronym();
	 * System.out.println("SysLoc"+appSolutionEntity.getApplicationEntity().
	 * getAcronym()); }
	 * acronyms.add(appSolutionEntity.getApplicationEntity().getAcronym()); }
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * return acronyms; }
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional
	public Set<String> getLocOnTypeForReports(Integer solutionId) {
		System.out.println("Solution ID----" + solutionId);
		List<AppSolutionEntity> appSolutionEntities = solutionsDAO.getAllAppSolutions();
		System.out.println("temp");
		Set<String> acronyms = new HashSet<>();
		for (AppSolutionEntity appSolutionEntity : appSolutionEntities) {
			System.out.println("temp2--" + appSolutionEntity.getSolutionsEntity().getSolutionId());
			if (appSolutionEntity.getSolutionsEntity().getSolutionId().intValue() == (solutionId.intValue())) {
				System.out.println("sold ID--" + appSolutionEntity.getSolutionsEntity().getName());
				System.out.println("app sol id--" + appSolutionEntity.getAppSolutionId());

				System.out.println("SysLoc--" + appSolutionEntity.getApplicationEntity().getAcronym());
				appSolutionEntity.getApplicationEntity().getAcronym();
				acronyms.add(appSolutionEntity.getApplicationEntity().getAcronym());
			}

		}

		return acronyms;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional
	public List<AppSolutionDevicesDTO> getLocForDevices() {
		List<AppSolutionDeviceEntity> appSolutionDevicesEntities = solutionsDAO.getAllSolDevices();
		List<AppSolutionDevicesDTO> appSolutionDeviceDTOs = new ArrayList<>();
		for (AppSolutionDeviceEntity appSolutionDeviceEntity : appSolutionDevicesEntities) {

			AppSolutionDevicesDTO appSolutionDeviceDTO = new AppSolutionDevicesDTO();
			appSolutionDeviceDTO
					.setAppName(appSolutionDeviceEntity.getAppSolutionEntity().getApplicationEntity().getAcronym());
			appSolutionDeviceDTO
					.setSolutionName(appSolutionDeviceEntity.getAppSolutionEntity().getSolutionsEntity().getName());
			appSolutionDeviceDTO.setCurrentScanningDt(appSolutionDeviceEntity.getCurrentScanningDt());
			appSolutionDeviceDTO.setNextScanningDt(appSolutionDeviceEntity.getNextScanningDt());
			appSolutionDeviceDTO.setModelNumber(appSolutionDeviceEntity.getModelNumber());
			appSolutionDeviceDTO.setSerialNumber(appSolutionDeviceEntity.getSerialNumber());
			appSolutionDeviceDTO.setOverallStatus(appSolutionDeviceEntity.getOverallStatus());

			appSolutionDeviceDTOs.add(appSolutionDeviceDTO);
		}

		return appSolutionDeviceDTOs;

	}

	@Override
	@Transactional
	public List<Integer> getAllTotals() {

		List<Integer> AllTotals = new ArrayList<>();
		int totalDevices = solutionsDAO.getAllSolDevices().size();
		int totalSolutions = solutionsDAO.getSoltionEntities().size();
		int totalVendors = solutionsDAO.getAllVendors().size();
		int totalLegal = applicationDao.getAllMous().size();
		
		List<MOUEntity> mouEntities = applicationDao.getAllMous();
		int signedMousLegal = 0;
		int unSignedMousLegal = 0;
		int signedMousSystem = 0;
		int unSignedMousSystem=0;
		int devicePassed = 0;
		int devicePending = 0;
		int deviceFailed = 0;
		int crapData = 0;
		
		
		List<AppSolutionDeviceEntity> SolDeviceEntities = solutionsDAO.getAllSolDevices();
		
		for(AppSolutionDeviceEntity appSolutionDeviceEntity : SolDeviceEntities)	{
			if(appSolutionDeviceEntity.getOverallStatus()!= null && appSolutionDeviceEntity.getOverallStatus().equals("Passed"))
					devicePassed++;
			
			else if(appSolutionDeviceEntity.getOverallStatus()!= null && appSolutionDeviceEntity.getOverallStatus().equals("Pending"))
					devicePending++;
			
			else if(appSolutionDeviceEntity.getOverallStatus()!= null && appSolutionDeviceEntity.getOverallStatus().equals("Failed"))
					deviceFailed++;
			
			else
				crapData++;
			
			
		}
		
		for(MOUEntity mouEntity : mouEntities) {
			if(mouEntity.getApplicationEntity().getActiveLocality()==1) {
				if(mouEntity.getSigned())
					signedMousLegal++;
				else
					unSignedMousLegal++;
			}
			
			else {
				
				if(mouEntity.getSigned())
					signedMousSystem++;
				else
					unSignedMousSystem++;
				
			}
				
				
		}
		AllTotals.add(totalDevices);
		AllTotals.add(totalSolutions);
		AllTotals.add(totalVendors);
		AllTotals.add(totalLegal);
		AllTotals.add(signedMousLegal);
		AllTotals.add(unSignedMousLegal);
		AllTotals.add(signedMousSystem);
		AllTotals.add(unSignedMousSystem);
		AllTotals.add(devicePassed);
		AllTotals.add(devicePending);
		AllTotals.add(deviceFailed);
		

		return AllTotals;

	}

	////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional
	public List<ApplicationSolutionDTO> getLocOnTypeForSystem(Integer solutionId) {
		System.out.println("Solution ID----" + solutionId);
		List<AppSolutionEntity> appSolutionEntities = solutionsDAO.getAllAppSolutions();
		System.out.println("temp");
		List<ApplicationSolutionDTO> appSolutionDTOs = new ArrayList<>();

		for (AppSolutionEntity appSolutionEntity : appSolutionEntities) {
			System.out.println("temp2--" + appSolutionEntity.getSolutionsEntity().getSolutionId());
			if (appSolutionEntity.getSolutionsEntity().getSolutionId().intValue() == (solutionId.intValue())) {
				System.out.println("sold ID--" + appSolutionEntity.getSolutionsEntity().getName());
				System.out.println("app sol id--" + appSolutionEntity.getAppSolutionId());
				ApplicationSolutionDTO appSolutionDTO = new ApplicationSolutionDTO();
				System.out.println("SysLoc--" + appSolutionEntity.getApplicationEntity().getAcronym());
				appSolutionDTO.setApplicationName(appSolutionEntity.getApplicationEntity().getAcronym());
				appSolutionDTO.setSystemType(appSolutionEntity.getSolutionsEntity().getSystemTypeEntity().getName());
				appSolutionDTO
						.setPrecinctType(appSolutionEntity.getSolutionsEntity().getPrecinctTypeEntity().getTypeName());
				appSolutionDTO.setSolutionName(appSolutionEntity.getSolutionsEntity().getName());
				appSolutionDTO.setVendorName(appSolutionEntity.getSolutionsEntity().getVendorsEntity().getName());
				appSolutionDTO.setVersionNumber(appSolutionEntity.getSolutionsEntity().getVersionNumber());
				appSolutionDTOs.add(appSolutionDTO);
			}

		}

		return appSolutionDTOs;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional
	public List<SolutionsDTO> getSolOnTypeForPrecinct(int precinctTypeId) {
		List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
		List<SolutionsDTO> solutionsDTOs = new ArrayList<>();
		SolutionsDTO solutionsDTO = null;
		VendorsDTO vendorsDTO = null;
		for (SolutionsEntity solutionsEntity : solutionsEntities) {
			if (solutionsEntity.getSystemTypeEntity() != null
					&& (solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId() == precinctTypeId)) {
				solutionsDTO = new SolutionsDTO();
				solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
				solutionsDTO.setName(solutionsEntity.getName());
				solutionsDTO.setVersionNumber(solutionsEntity.getVersionNumber());
				solutionsDTO.setSolutionTypeName(solutionsEntity.getSolutionTypeEntity().getTypeName());
				if (solutionsEntity.getVendorsEntity() != null) {
					vendorsDTO = new VendorsDTO();
					vendorsDTO.setName(solutionsEntity.getVendorsEntity().getName());
					solutionsDTO.setVendor(vendorsDTO);
				}
				solutionsDTOs.add(solutionsDTO);
			}
		}
		return solutionsDTOs;
	}

	@Override
	@Transactional
	public Set<String> getLocOnTypeForPrecinct(int precinctTypeId) {
		List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
		List<SolutionsDTO> solutionsDTOs = new ArrayList<>();

		List<AppSolutionEntity> appSolutionEntities = solutionsDAO.getAllAppSolutions();
		Set<String> acronyms = new HashSet<>();

		for (SolutionsEntity solutionsEntity : solutionsEntities) {
			if (solutionsEntity.getSystemTypeEntity() != null
					&& (solutionsEntity.getPrecinctTypeEntity().getPrecinctTypeId() == precinctTypeId)) {

				int a = solutionsEntity.getSolutionId();

				for (AppSolutionEntity appSolutionEntity : appSolutionEntities) {
					if (appSolutionEntity.getSolutionsEntity().getSolutionId() == a) {
						appSolutionEntity.getApplicationEntity().getAcronym();
						System.out.println("SysLoc" + appSolutionEntity.getApplicationEntity().getAcronym());
					}
					acronyms.add(appSolutionEntity.getApplicationEntity().getAcronym());
				}

			}
		}

		return acronyms;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional
	public List<SolutionsDTO> getSolOnTypeForReports(int systemTypeId) {
		List<SolutionsEntity> solutionsEntities = solutionsDAO.getSoltionEntities();
		List<SolutionsDTO> solutionsDTOs = new ArrayList<>();
		SolutionsDTO solutionsDTO = null;
		VendorsDTO vendorsDTO = null;
		for (SolutionsEntity solutionsEntity : solutionsEntities) {
			if (solutionsEntity.getSystemTypeEntity() != null
					&& (solutionsEntity.getSystemTypeEntity().getSystemTypeId() == systemTypeId)) {
				solutionsDTO = new SolutionsDTO();
				solutionsDTO.setSolutionId(solutionsEntity.getSolutionId());
				solutionsDTO.setName(solutionsEntity.getName());
				System.out.println(solutionsEntity.getName() + "SolutionNames");
				solutionsDTOs.add(solutionsDTO);
			}
		}
		return solutionsDTOs;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////

	private boolean createMOUFile(MultipartFile mouFile, String fodlerPath) {
		// data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64,

		File folder = new File(fodlerPath);

		if (!folder.exists()) {
			folder.mkdir();
		}
		fodlerPath = fodlerPath + "/devices";
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
	public String getPolicyDocumentAttch(Integer policyDocId) {
		PolicyDocumentsEntity policyDocEntity = policyDao.getPolicyDocumentAttch(policyDocId);
		return policyDocEntity.getDocumentPath();
	}

	@Override
	@Transactional
	public List<ReportVendorsDTO> getLocOnVendor(Integer vendorId) {

		List<SolutionsEntity> solutionEntities = solutionsDAO.getSoltionEntities();
		System.out.println("temp");
		List<ReportVendorsDTO> reportVendorDTOs = new ArrayList<ReportVendorsDTO>();

		for (SolutionsEntity solutionsEntity : solutionEntities) {
			System.out.println("SolutionName--" + solutionsEntity.getName());
			if (solutionsEntity.getVendorsEntity().getVendorId().intValue() == vendorId.intValue()) {
				System.out.println("VendorId----" + solutionsEntity.getVendorsEntity().getVendorId().intValue());
				ReportVendorsDTO reportVendorsDTO = new ReportVendorsDTO();
				List<ApplicationSolutionDTO> appSolutionDTO = new ArrayList<ApplicationSolutionDTO>();
				reportVendorsDTO
						.setAppSolutionDTOs(appSolutionDTO = getLocOnTypeForSystem(solutionsEntity.getSolutionId()));
				reportVendorsDTO.setSolutionName(solutionsEntity.getName());
				reportVendorsDTO.setSolutionVersionName(solutionsEntity.getVersionNumber());
				reportVendorsDTO
						.setVendorFirstName(solutionsEntity.getVendorsEntity().getVendorContactEntity().getFirstName());
				reportVendorsDTO
						.setVendorLastName(solutionsEntity.getVendorsEntity().getVendorContactEntity().getLastName());
				reportVendorsDTO.setVendorId
				(solutionsEntity.getVendorsEntity().getVendorId());
				reportVendorDTOs.add(reportVendorsDTO);
			}

		}

		return reportVendorDTOs;
	}

}
