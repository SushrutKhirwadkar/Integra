package com.soch.Integra.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.OfficeDTO;
import com.soch.Integra.dto.ReportDTO;
import com.soch.Integra.dto.UserReportRequest;
import com.soch.Integra.entities.*;

public interface ApplicationDao {
	
	public ApplicationEntity getAcronym(String Acronym);
	public ApplicationEntity setApplicationName(String applicationName);
	
	//Dropdowns
	public List<DivisionEntity> getDivisions();
	public List<OfficeEntity> getOffices();
	public List<StatusEntity> getStatus();
	//Save 
	public ApplicationEntity saveApplication(ApplicationEntity applicationEntity);
	public List<OfficeEntity> saveOffices(List<OfficeEntity> officeEntity);
	public List<DivisionEntity> saveDivisions(List<DivisionEntity> divisionEntity);
	
	//check
	public List<FiscalYearInfoEntity> saveFiscalYear(List<FiscalYearInfoEntity> fiscalYearInfoEntity);
	public List<FiscalYearInfoEntity> getFiscalYear();
	public List<UserEntity> getUsers();
	public OfficeEntity getofficebyId(int officeId);
	public DivisionEntity getdivisionbyId(int division);
	public UserEntity getUserById(int dataOwner);
	public StatusEntity getStatusById(int status);
	public List<DatabaseEntity> getDatabase();
	public List<ServerEntity> getServers();
	public ServerEntity getServer(int serverId);
	public List<TechnologiesEntity> getTechnologies();
	public DatabaseEntity getDatabase(int id);
	public TechnologiesEntity getTechnologyEntity(int i);
	public void updateApplication(ApplicationEntity applicationEntity);
	public List<ApplicationEntity> searchApplicationOnCriteria(ReportDTO reportDTO);
	public List<ApplicationEntity> getAllApplications();
	public UserEntity getUserByIAMId(int userId);
	public List<SystemSensitivityEntity> getSystemSensitivity();
	public SystemSensitivityEntity getSystemSensitivityById(int systemSensitivity);
	public List<ApplicationEntity>  getApps(String rowName, String colName, String tech);
	OfficeEntity getofficebyAcronym(String acronym);
	public List<ApplDocEntity> getApplDoc(int id);
	public List<ApplDocEntity> getAllApplDoc();
	
	
	public AuditEntity getAudit(int AuditId);
	public List<AppDevelopersEntity> getAppDevelopers(String acronym);
	List<AppTesterEntity> getAppTesters(String acronym);
	
	
	public List<AuditTypeEntity> getAuditTypes();
	public AuditTypeEntity saveAuditTypeEntity(AuditTypeEntity auditTypeEntity);
	
	public ApplicationEntity getApplicationOnId(int appId);
	public AuditTypeEntity getAuditType(int appAuditId);
	public AppAuditEntity getAppAudit(int appAuditId);
	public void updateAppAudit(AppAuditEntity appAuditEntity);
	public List<AppAuditEntity> upComingAudits();
	public AppAuditFileEntity applicationDao(Integer fileId);
	public List<AppAuditEntity> getAuditsOnType(int auditTypeId);
	public List<UserAppRoleEntity> getUserRoles();
	public List<UserEntity> getUsersonRole(Integer role);
	public List<ApplicationEntity> getUSerApps(UserReportRequest userReportRequest);
	public List<AppAuditEntity> allAudits();
	public DatabaseEntity saveDatabaseServer(DatabaseEntity databaseEntity);
	public DatabaseEntity updateDatabaseServer(DatabaseEntity databaseEntity);
	public AssessmentEntity saveAssessment(AssessmentEntity assessmentEntity);
	public AssessmentEntity getAssessmentEntity(int assessmentID);
	public AssessmentPolicyEntity getAppAssessmentPolicy(int assessmentPolicyID);
	public AssessmentPolicyEntity updateAssessment(AssessmentPolicyEntity assessmentPolicyEntity);
	public AssessmentEntity upadateAssessment(AssessmentEntity assessmentEntity);
	public List<AssessmentEntity> getAllAssessments();
	public AssessmentFileEntity getAssessmentFileEntity(int id);
	public void saveMou(MOUEntity mouEntity);
	public MOUEntity getMou(int mouId);
	void updateMou(MOUEntity mouEntity);
	public MOUDocEntity getMOUDocEntity(Integer fileId);
	
	public DeviceDocEntity getDeviceDocEntity(Integer fileId);
	public PolicyDocumentsEntity getPolicyDocument(Integer policyDocId);
	public void saveServerContact(ServerContactEntity serverContactEntity);
	 public List<MOUEntity> getAllMous();

}
