package com.soch.Integra.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.soch.Integra.dto.ApplicationResp;
import com.soch.Integra.dto.ApplicationServerDTO;
import com.soch.Integra.dto.PrecinctTypeDTO;
import com.soch.Integra.vendors.dto.ReportVendorsDTO;
import com.soch.Integra.dto.VendorsDTO;
import com.soch.Integra.entities.AppSolutionEntity;
import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;
import com.soch.Integra.vendors.dto.HostingTypeDTO;
import com.soch.Integra.vendors.dto.LabVendorsDTO;
import com.soch.Integra.vendors.dto.SolutionsDTO;
import com.soch.Integra.vendors.dto.SystemTypeDTO;
import com.soch.Integra.vendors.dto.AppSolutionDevicesDTO;

public interface ElectionServices {

	List<SolutionsDTO> getSolutions();

	SolutionsDTO getSolution(int solutionID);

	ApplicationResp updateSolution(SolutionsDTO solutionsDTO, MultipartFile[] files);

	VendorsDTO getVendor(int vendorId);

	List<SystemTypeDTO> getSystemTypes();

	List<LabVendorsDTO> getLabVendors();

	ApplicationResp registerSolution(SolutionsDTO solutionsDTO, MultipartFile[] files);

	List<SolutionsDTO> getSolutionsOnType(int systemTypeId);

	ApplicationResp saveAppSolution(ApplicationSolutionDTO applicationSolutionDTO);
	
	ApplicationResp saveAppSolutionDevices(AppSolutionDevicesDTO appSolutionDevicesDTO, MultipartFile[] files);
	
	ApplicationResp updateAppSolution(ApplicationSolutionDTO applicationSolutionDTO);
	
	List<ApplicationSolutionDTO>  getAppSolutions(int applicationId);

	List<ApplicationSolutionDTO> getAppSolutions(Set<AppSolutionEntity> appSolutionEntities);

	ApplicationSolutionDTO getAppSolution(int solutionId);

	List<HostingTypeDTO> getHostingTypes();

	String getSolutionFile(int fileID);

	List<PrecinctTypeDTO> getPrecinctTypes();

	List<SolutionsDTO> getSolutionsOnType(int systemTypeId, int precinctTypeId);

	ApplicationResp updateAppSolutionDevice(AppSolutionDevicesDTO appSolutionDevicesDTO, MultipartFile[] files);

	String getPolicyDocumentAttch(Integer policyDocId);

//	Set<String> getLocOnTypeForReports(int solutionId);

	List<SolutionsDTO> getSolOnTypeForReports(int systemTypeId);

	List<SolutionsDTO> getSolOnTypeForPrecinct(int precinctTypeId);

	Set<String> getLocOnTypeForPrecinct(int precinctTypeId);

	Set<String> getLocOnTypeForReports(Integer solutionId);

	List<ApplicationSolutionDTO> getLocOnTypeForSystem(Integer solutionId);

	List<ReportVendorsDTO> getLocOnVendor(Integer vendorId);
	
	List<AppSolutionDevicesDTO> getLocForDevices();

	List<Integer> getAllTotals();

}
