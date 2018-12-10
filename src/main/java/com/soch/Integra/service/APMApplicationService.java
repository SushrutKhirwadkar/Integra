package com.soch.Integra.service;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.soch.Integra.dto.ALLReportDTO;
import com.soch.Integra.dto.AppAuditDTO;
import com.soch.Integra.dto.AppAuditFileDTO;
import com.soch.Integra.dto.AppDisp;
import com.soch.Integra.dto.ApplDocDTO;
import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.ApplicationResp;
import com.soch.Integra.dto.ApplicationUserDTO;
import com.soch.Integra.dto.ApplicationViewDTO;
import com.soch.Integra.dto.AssessmentDTO;
import com.soch.Integra.dto.AssessmentPolicyDTO;
import com.soch.Integra.dto.AuditDashBoardDTO;
import com.soch.Integra.dto.AuditTypeDTO;
import com.soch.Integra.dto.AuditTypeDashBoardDTO;
import com.soch.Integra.dto.DatabaseDTO;
import com.soch.Integra.dto.DivisionDTO;
import com.soch.Integra.dto.FiscalYearInfoDTO;
import com.soch.Integra.dto.MOUDTO;
import com.soch.Integra.dto.MOUDocDTO;
import com.soch.Integra.dto.OfficeDTO;
import com.soch.Integra.dto.ReportDTO;
import com.soch.Integra.dto.ReportDTO2;
import com.soch.Integra.dto.ServerDTO;
import com.soch.Integra.dto.StatusDTO;
import com.soch.Integra.dto.SystemSensitivityDTO;
import com.soch.Integra.dto.TechnologiesDTO;
import com.soch.Integra.dto.VendorsDTO;
import com.soch.Integra.entities.DivisionEntity;
import com.soch.Integra.entities.FiscalYearInfoEntity;
import com.soch.Integra.entities.OfficeEntity;
import com.soch.Integra.vendors.dto.AppSolutionDevicesDTO;
import com.soch.Integra.vendors.dto.SolutionTypeDTO;
import com.soch.Integra.vendors.dto.SolutionsDTO;

import java.util.List;

public interface APMApplicationService {
	 public void signIn(String userID);

	public ApplicationDTO getApplicationInfo(String acronym);
	// Dropdowns
	public Set<DivisionDTO> getDivisions();
	public Set<OfficeDTO> getOffices();
	public Set<StatusDTO> getStatus();

	//Save
	public ApplicationDTO saveApplicationInfo(ApplicationDTO applicationDTO,MultipartFile[] files);
	public List<OfficeEntity> saveOfficesInfo(Set<OfficeDTO> officeDTO);
	public List<DivisionEntity> saveDivisionsInfo(Set<DivisionDTO> divisionDTO);
	
	
	//check
	public List<FiscalYearInfoEntity> saveFiscalYearInfo(Set<FiscalYearInfoDTO> fiscalYearInfoDTO);
	public Set<FiscalYearInfoDTO> getFiscalYearInfo();

	public Set<ApplicationUserDTO> getDataOwner();

	public Set<ApplicationUserDTO> getSystem_Site_Data_Owner();

	public Set<ApplicationUserDTO> getUsers();

	public Set<DatabaseDTO> getDatabase();

	public Set<ServerDTO> getServer();
	
	public List<TechnologiesDTO> getTechnologies();

	public DatabaseDTO getDatabaseDetails(int id);

	public ApplicationViewDTO updateApplicationInfo(ApplicationViewDTO applicationDTO,MultipartFile[] files);

	public ReportDTO2 createReport(ReportDTO reportDTO);

	public Set<ApplicationDTO> getAllApplications();

	public Set<ApplicationDTO> getPendingApplications();

	public Set<SystemSensitivityDTO> getSystemSensitivity();

	ApplicationViewDTO getApplicationForView(String acronym);

	

	public Set<ApplicationUserDTO> getBusiness_Owner();

	public int getIAMUserId(int iamId);

	ALLReportDTO getReportData();

	public List<String> getOfficeAcronyms();

	public List<AppDisp> getApps(String rowName, String colName, String tech);

	Set<ApplDocDTO> getApplDoc(int id);

	Set<ApplicationUserDTO> getDbAdmin();

	Set<ApplicationUserDTO> getProjectManager();

	Set<ApplicationUserDTO> getSystemAdministrator();

	Set<ApplicationUserDTO> getTechProjectManager();

	Set<ApplicationUserDTO> getISO();

	Set<ApplicationUserDTO> getDevelopers();

	Set<ApplicationUserDTO> getTesters();

	Set<ApplicationUserDTO> getDataCustodian();

	Set<ApplicationUserDTO> getBusinessAnalyst();

	List<AuditTypeDTO> getAuditTypes();

	public AuditTypeDTO addAuditType(AuditTypeDTO auditTypeDTO);

	public ApplicationResp saveAppAuditInfo(AppAuditDTO appAuditDTO); 

	public ApplicationResp updateAppAuditInfo(AppAuditDTO appAuditDTO);
	
	public List<AppAuditDTO> upComingAudits();

	public AppAuditFileDTO getAppAuditFile(Integer fileId);

	List<AuditDashBoardDTO> getApplicationAudits(Integer year);

	List<AuditTypeDashBoardDTO> getAuditTypeAudits(Integer year);

	public ApplicationUserDTO getUser(Integer userId);

	public ApplicationUserDTO addUser(ApplicationUserDTO applicationUserDTO);

	public TechnologiesDTO getTechnology(Integer technologyId);

	public List<AppAuditDTO> getAudits();

	public Set<ApplicationUserDTO> getUseronName(String userName);

	public ReportDTO getDatabaseReport(Integer databaseId);

	public ReportDTO getTechReport(Integer techId);

	public ReportDTO getServerReport(Integer serverId);

	public DatabaseDTO saveDBServerInfo(DatabaseDTO databaseDTO);

	public DatabaseDTO updateDBServerInfo(DatabaseDTO databaseDTO);

	public ServerDTO getServerDetails(Integer a);

	public Set<ApplicationDTO> getAuditTypeReport(int id, String status,int year);

	public ApplicationResp saveAppAssessment(AssessmentDTO assessmentDTO);
	
	public AssessmentDTO getAppAssessment(int assessmentID);

	public AssessmentPolicyDTO getAppAssessmentPolicy(int assessmentPolicyID);

	public AssessmentPolicyDTO saveAssessment(AssessmentPolicyDTO assessmentPolicyDTO);

	public ApplicationResp updateAppAssessment(AssessmentDTO assessmentDTO);
	
	public List<AssessmentDTO> getAllAssessments();

	public String getAssessmentPolicyFile(int assessmentID);
	
	public String getAssessmentFile(int id);
	
	public List<String> getAppAcronyms();

	public Set<OfficeDTO> getOfficesOnDept(int deptId);

	public ApplicationResp saveMOU(MOUDTO moudto);

	public ApplicationResp updateMou(MOUDTO moudto);

	public String getMOUFile(Integer fileId);
	
	public String getDeviceFile(Integer fileId);

	public ApplicationResp saveMOU(MOUDTO moudto, MultipartFile[] files);

	ApplicationResp updateMOU(MOUDTO moudto, MultipartFile[] files);

	public VendorsDTO addNewVendor(VendorsDTO vendorsDTO);

	public List<VendorsDTO> getVendors();

	public List<SolutionTypeDTO> getSolutionTypes();

	VendorsDTO updateVendor(VendorsDTO vendorsDTO);

	List<MOUDTO> getMOUs(int applicationID);

	public ApplicationResp uploadPolicyDocuments(MultipartFile[] files, AppSolutionDevicesDTO appSolutionDevicesDTO);

	List<String> getBusinessOwnerNameDoe();

	List<String> getSystemOwnerNameDoe();

	//public String getPolicyDocument(int policyDocId);

	public String getPolicyDocumentAttachment(Integer policyDocId);

	public int getLocalityTotal();

	public List<String> getLocalityAcronyms();

	List<ApplicationViewDTO> getLocationForView();

	public List<MOUDTO> getAllMOUs();

	public List<MOUDTO> getLocForMous();

	public List<MOUDTO> getSysForMous();

	
	
}
