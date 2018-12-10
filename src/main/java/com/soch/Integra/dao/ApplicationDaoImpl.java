package com.soch.Integra.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.dto.ReportDTO;
import com.soch.Integra.dto.UserReportRequest;
import com.soch.Integra.entities.AppAuditEntity;
import com.soch.Integra.entities.AppAuditFileEntity;
import com.soch.Integra.entities.AppDevelopersEntity;
import com.soch.Integra.entities.AppTesterEntity;
import com.soch.Integra.entities.ApplDocEntity;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.AssessmentEntity;
import com.soch.Integra.entities.AssessmentFileEntity;
import com.soch.Integra.entities.AssessmentPolicyEntity;
import com.soch.Integra.entities.AuditEntity;
import com.soch.Integra.entities.AuditTypeEntity;
import com.soch.Integra.entities.DatabaseEntity;
import com.soch.Integra.entities.DeviceDocEntity;
import com.soch.Integra.entities.DivisionEntity;
import com.soch.Integra.entities.FiscalYearInfoEntity;
import com.soch.Integra.entities.MOUDocEntity;
import com.soch.Integra.entities.MOUEntity;
import com.soch.Integra.entities.OfficeEntity;
import com.soch.Integra.entities.PolicyDocumentsEntity;
import com.soch.Integra.entities.ServerContactEntity;
import com.soch.Integra.entities.ServerEntity;
import com.soch.Integra.entities.StatusEntity;
import com.soch.Integra.entities.SystemSensitivityEntity;
import com.soch.Integra.entities.TechnologiesEntity;
import com.soch.Integra.entities.UserAppRoleEntity;
import com.soch.Integra.entities.UserEntity;
import com.soch.Integra.entities.VendorsEntity;
import com.soch.Integra.utils.ApplicationConstants;
import com.soch.Integra.utils.ApplicationConstatns;;

@Component
public class ApplicationDaoImpl implements ApplicationDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ApplicationEntity getAcronym(String acronym) {
		ApplicationEntity applicationEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class);
		criteria.add(Restrictions.eq("acronym", acronym));
		// criteria.add(Restrictions.eq("loginId", userID));
		List<ApplicationEntity> applicationEntities = criteria.list();
		if (applicationEntities.size() > 0) {
			applicationEntity = applicationEntities.get(0);
		}
		return applicationEntity;
	}

	@Override
	public ApplicationEntity setApplicationName(String applicationName) {

		ApplicationEntity applicationEntity = null;

		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class);
		criteria.add(Restrictions.eq("APPLICATION_Name", applicationName));
		// criteria.add(Restrictions.eq("loginId", userID));
		List<ApplicationEntity> applicationEntities = criteria.list();
		if (applicationEntities.size() > 0) {
			applicationEntity = applicationEntities.get(0);
		}
		return applicationEntity;
	}

	@Override
	public List<DivisionEntity> getDivisions() {
		ApplicationEntity applicationEntity = null;
		DivisionEntity divisionEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DivisionEntity.class);
		// criteria.add(Restrictions.eq("loginId", userID));
		List<DivisionEntity> divisionEntities = criteria.list();

		return divisionEntities;
	}
	
	

	@Override
	public List<OfficeEntity> getOffices() {
		ApplicationEntity applicationEntity = null;
		OfficeEntity officeEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(OfficeEntity.class);
		criteria.addOrder(Order.asc("officeId"));
		// criteria.add(Restrictions.eq("loginId", userID));
		List<OfficeEntity> officeEntities = criteria.list();
		return officeEntities;
	}

	@Override
	public List<StatusEntity> getStatus() {
		StatusEntity statusEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StatusEntity.class);
		List<StatusEntity> statusEntities = criteria.list();
		return statusEntities;
	}

	@Override

	public ApplicationEntity saveApplication(ApplicationEntity applicationEntity) {
		this.sessionFactory.getCurrentSession().save(applicationEntity);
		return applicationEntity;
	}

	@Override
	public List<OfficeEntity> saveOffices(List<OfficeEntity> officeEntity) {
		this.sessionFactory.getCurrentSession().save(officeEntity);
		return null;
	}

	@Override
	public List<DivisionEntity> saveDivisions(List<DivisionEntity> divisionEntity) {
		this.sessionFactory.getCurrentSession().save(divisionEntity);
		return null;
	}

	@Override
	public List<FiscalYearInfoEntity> saveFiscalYear(List<FiscalYearInfoEntity> fiscalYearInfoEntity) {
		this.sessionFactory.getCurrentSession().save(fiscalYearInfoEntity);
		return null;
	}

	@Override
	public List<FiscalYearInfoEntity> getFiscalYear() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StatusEntity.class);
		List<FiscalYearInfoEntity> fiscalYearInfoEntities = criteria.list();
		return null;
	}

	@Override
	public List<UserEntity> getUsers() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		return criteria.list();
	}

	@Override
	public OfficeEntity getofficebyId(int office) {
		OfficeEntity officeEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(OfficeEntity.class);
		criteria.add(Restrictions.eq("officeId", office));
		List<OfficeEntity> officeEntities = criteria.list();
		if (officeEntities.size() > 0) {
			officeEntity = officeEntities.get(0);
		}
		return officeEntity;
	}
	
	@Override
	public OfficeEntity getofficebyAcronym(String acronym) {
		OfficeEntity officeEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(OfficeEntity.class);
		criteria.add(Restrictions.eq("acronym", acronym));
		List<OfficeEntity> officeEntities = criteria.list();
		if (officeEntities.size() > 0) {
			officeEntity = officeEntities.get(0);
		}
		return officeEntity;
	}

	@Override
	public DivisionEntity getdivisionbyId(int division) {
		DivisionEntity divisionEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DivisionEntity.class);
		criteria.add(Restrictions.eq("id", division));
		List<DivisionEntity> divisionEntities = criteria.list();
		if (divisionEntities.size() > 0) {
			divisionEntity = divisionEntities.get(0);
		}
		return divisionEntity;
	}

	@Override
	public UserEntity getUserById(int userId) {
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<UserEntity> userEntities = criteria.list();
		if (userEntities.size() > 0) {
			userEntity = userEntities.get(0);
		}
		return userEntity;
	}

	@Override
	public StatusEntity getStatusById(int status) {

		StatusEntity statusEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StatusEntity.class);
		criteria.add(Restrictions.eq("statusId", status));
		List<StatusEntity> statusEntities = criteria.list();
		if (statusEntities.size() > 0) {
			statusEntity = statusEntities.get(0);
		}
		return statusEntity;
	}

	@Override
	public List<DatabaseEntity> getDatabase() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DatabaseEntity.class);
		List<DatabaseEntity> databaseEntities = criteria.list();
		return databaseEntities;
	}

	@Override
	public List<ServerEntity> getServers() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ServerEntity.class);
		List<ServerEntity> serverEntities = criteria.list();
		return serverEntities;
	}

	@Override
	public List<TechnologiesEntity> getTechnologies() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TechnologiesEntity.class);
		return criteria.list();
	}

	@Override
	public DatabaseEntity getDatabase(int id) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DatabaseEntity.class);
		criteria.add(Restrictions.eq("databaseId", id));
		List<DatabaseEntity> databaseEntities = criteria.list();
		return databaseEntities.get(0);
	}

	@Override
	public ServerEntity getServer(int serverId) {
		ServerEntity serverEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ServerEntity.class);
		criteria.add(Restrictions.eq("serverId", serverId));
		List<ServerEntity> serverEntities = criteria.list();
		if(!serverEntities.isEmpty())
		{
			serverEntity = serverEntities.get(0);
		}
		return serverEntity;
	}
	
	
	@Override
	public List<ApplDocEntity> getApplDoc(int id) {
		ApplDocEntity applDocEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplDocEntity.class);
		criteria.add(Restrictions.eq("documentId", id));
		List<ApplDocEntity> applDocEntities =  criteria.list();
			return applDocEntities;
	}

	@Override
	public TechnologiesEntity getTechnologyEntity(int id) {
		TechnologiesEntity technologiesEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TechnologiesEntity.class);
		criteria.add(Restrictions.eq("technologyId", id));
		List<TechnologiesEntity> technologiesEntities =  criteria.list();
		
		if(!technologiesEntities.isEmpty())
		{
			technologiesEntity = technologiesEntities.get(0);
		}
		
		return technologiesEntity;
	}

	@Override
	public void updateApplication(ApplicationEntity applicationEntity) {
		this.sessionFactory.getCurrentSession().update(applicationEntity);
	}

	@Override
	public List<ApplicationEntity> searchApplicationOnCriteria(ReportDTO reportDTO) {
		
		
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class,"application");
		if(reportDTO.getDatabaseId() !=0 )
		{
			criteria.createAlias("application.applicationDatabaseEntities", "databaseEntities");
            criteria.add(Restrictions.eq("databaseEntities.databaseEntity.databaseId", reportDTO.getDatabaseId()));
		}
		
	
		if(reportDTO.getServerId() !=0 )
		{
			criteria.createAlias("application.applicationServerEntities", "serverEntities");
            criteria.add(Restrictions.eq("serverEntities.serverEntity.serverId", reportDTO.getServerId()));
		}
		
		if(reportDTO.getTechnologyId() !=0 )
		{
			criteria.createAlias("application.applicationTechnologyEntities", "technologyEntities");
            criteria.add(Restrictions.eq("technologyEntities.technologiesEntity.technologyId", reportDTO.getTechnologyId()));
		}
		
		if(reportDTO.getFyId() !=0 )
		{
			criteria.createAlias("application.fyEntities" , "fyEntities");
			criteria.add(Restrictions.eq("fyEntities.fyNumber", reportDTO.getFyId()));
		}
		
		return criteria.list();
	}

	@Override
	public List<ApplicationEntity> getAllApplications() {
		ApplicationEntity applicationEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class);
		List<ApplicationEntity> applicationEntities = criteria.list();
		return applicationEntities;	
		}

	@Override
	public UserEntity getUserByIAMId(int userId) {
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("IAMId", userId));
		List<UserEntity> userEntities = criteria.list();
		if (userEntities.size() > 0) {
			userEntity = userEntities.get(0);
		}
		return userEntity;
	}
	
	@Override
	public List<SystemSensitivityEntity> getSystemSensitivity() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SystemSensitivityEntity.class);
		criteria.addOrder(Order.asc("systemSensitivityValue"));
		List<SystemSensitivityEntity> systemSensitivityEntities = criteria.list();
		return systemSensitivityEntities;
	}

	@Override
	public SystemSensitivityEntity getSystemSensitivityById(int systemSensitivity) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SystemSensitivityEntity.class);
		criteria.add(Restrictions.eq("systemSensitivityId", systemSensitivity));
		List<SystemSensitivityEntity> systemSensitivityEntities = criteria.list();
		if(!systemSensitivityEntities.isEmpty())
			return systemSensitivityEntities.get(0);
		else
			return null;
	}

	@Override
	public List<ApplicationEntity> getApps(String rowName, String colName, String tech) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class,"application");
		
		if(tech.equalsIgnoreCase(ApplicationConstants.DATABASE) )
		{
			criteria.createAlias("application.applicationDatabaseEntities", "databaseEntities");
            criteria.add(Restrictions.eq("databaseEntities.databaseEntity.databaseId", new Integer(rowName)));
            criteria.add(Restrictions.eq("databaseEntities.activityFlag", true));
		}
		
	
		if(tech.equalsIgnoreCase(ApplicationConstants.APPSERVER)  )
		{
			criteria.createAlias("application.applicationServerEntities", "serverEntities");
            criteria.add(Restrictions.eq("serverEntities.serverEntity.serverId", new Integer(rowName)));
            criteria.add(Restrictions.eq("serverEntities.activityFlag", true));
		}
		
		if(tech.equalsIgnoreCase(ApplicationConstants.TECHNOLOGY) )
		{
			criteria.createAlias("application.applicationTechnologyEntities", "technologyEntities");
            criteria.add(Restrictions.eq("technologyEntities.technologiesEntity.technologyId", new Integer(rowName)));
            criteria.add(Restrictions.eq("technologyEntities.activityFlag", true));
		}
		
		
            criteria.add(Restrictions.eq("application.officeEntity.officeId", getofficebyAcronym(colName).getOfficeId()));
		return criteria.list();
	}

	@Override
	public List<ApplDocEntity> getAllApplDoc() {
		
		ApplDocEntity applDocEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplDocEntity.class);
		List<ApplDocEntity> applDocEntities = criteria.list();
		return applDocEntities;	
	}
	
	
	@Override
	public AuditEntity getAudit(int auditId) {
		AuditEntity auditEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AuditEntity.class);
		criteria.add(Restrictions.eq("auditId", auditId));
		List<AuditEntity> auditEntities = criteria.list();
		if(!auditEntities.isEmpty())
		{
			auditEntity = auditEntities.get(0);
		}
		return null;
	}

	@Override
	public List<AppDevelopersEntity> getAppDevelopers(String acronym) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppDevelopersEntity.class);
		criteria.add(Restrictions.eq("applicationEntity.acronym", acronym));
		return criteria.list();
	}
	
	@Override
	public List<AppTesterEntity> getAppTesters(String acronym) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppTesterEntity.class);
		criteria.add(Restrictions.eq("applicationEntity.acronym", acronym));
		return criteria.list();
	}

	@Override
	public List<AuditTypeEntity> getAuditTypes() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AuditTypeEntity.class);
		criteria.add(Restrictions.eq("active", true ));
		return criteria.list();
	}
	
	@Override
	public AuditTypeEntity getAuditType(int appAuditId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AuditTypeEntity.class);
		criteria.add(Restrictions.eq("auditTypeId", appAuditId ));
		List<AuditTypeEntity> auditTypeEntities = criteria.list();
		return auditTypeEntities.get(0);
	}

	@Override
	public AuditTypeEntity saveAuditTypeEntity(AuditTypeEntity auditTypeEntity) {
		 this.sessionFactory.getCurrentSession().save(auditTypeEntity);
		return auditTypeEntity;
	}

	@Override
	public ApplicationEntity getApplicationOnId(int appId) {
		ApplicationEntity applicationEntity = null;

		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class);
		 criteria.add(Restrictions.eq("applicationId", appId));
		List<ApplicationEntity> applicationEntities = criteria.list();
		if (applicationEntities.size() > 0) {
			applicationEntity = applicationEntities.get(0);
		}
		return applicationEntity;
	}

	@Override
	public AppAuditEntity getAppAudit(int appAuditId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditEntity.class);
		criteria.add(Restrictions.eq("appAuditId", appAuditId ));
		List<AppAuditEntity> appAuditEntity = criteria.list();
		return appAuditEntity.get(0);
	}

	@Override
	public void updateAppAudit(AppAuditEntity appAuditEntity) {
		 this.sessionFactory.getCurrentSession().update(appAuditEntity);
		
	}

	@Override
	public List<AppAuditEntity> upComingAudits() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditEntity.class);
		criteria.add(Restrictions.ge("nextAuditDate", new Date()));
		List<AppAuditEntity> appAuditEntity = criteria.list();
		return appAuditEntity;
	}

	@Override
	public AppAuditFileEntity applicationDao(Integer fileId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditFileEntity.class);
		criteria.add(Restrictions.ge("appAuditFileId", fileId));
		List<AppAuditFileEntity> appAuditFileEntities = criteria.list();
		return appAuditFileEntities.get(0);
	}

	@Override
	public List<AppAuditEntity> getAuditsOnType(int auditTypeId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditEntity.class);
		criteria.add(Restrictions.eq("auditTypeId", auditTypeId));
		List<AppAuditEntity> appAuditEntities = criteria.list();
		return appAuditEntities;
	}

	@Override
	public List<UserAppRoleEntity> getUserRoles() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserAppRoleEntity.class);
		List<UserAppRoleEntity> userAppRoleEntities = criteria.list();
		return userAppRoleEntities;
	}

	@Override
	public List<UserEntity> getUsersonRole(Integer role) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("userAppRoleEntity.appRoleId", role));
		return criteria.list();
	}

	@Override
	public List<ApplicationEntity> getUSerApps(UserReportRequest userReportRequest) {
		
      Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class,"application");
		
      if(userReportRequest.getAppRoleId() == ApplicationConstatns.SYSTEM_OWNER)
      {
    	  criteria.createAlias("application.appSystemOwnerEntities", "appSystemOwnerEntities");
    	  criteria.add(Restrictions.eq("appSystemOwnerEntities.userEntity.userId", userReportRequest.getUserId()));
      }else if(userReportRequest.getAppRoleId() == ApplicationConstatns.DATA_OWNER)
      {
    	  criteria.createAlias("application.appDataOwnerEntities", "appDataOwnerEntities");
    	  criteria.add(Restrictions.eq("appDataOwnerEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.BUSINESS_OWNER)
      {
    	  criteria.createAlias("application.appBusinessOwnerEntities", "appBusinessOwnerEntities");
    	  criteria.add(Restrictions.eq("appBusinessOwnerEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.ISO)
      {
    	  criteria.createAlias("application.appISoEntities", "appISoEntities");
    	  criteria.add(Restrictions.eq("appISoEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.PROJECT_MANAGER)
      {
    	  criteria.createAlias("application.appProjectManagerEntities", "appProjectManagerEntities");
    	  criteria.add(Restrictions.eq("appProjectManagerEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.TECHPROJECT_MANAGER)
      {
    	  criteria.createAlias("application.applicationTechnicalManagerEntities", "applicationTechnicalManagerEntities");
    	  criteria.add(Restrictions.eq("applicationTechnicalManagerEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.DB_ADMINISTRATOR)
      {
    	  criteria.createAlias("application.appDbAdminEntities", "appDbAdminEntities");
    	  criteria.add(Restrictions.eq("appDbAdminEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.SYSTEM_ADMINISTRATOR)
      {
    	  criteria.createAlias("application.appSystemAdminEntities", "appSystemAdminEntities");
    	  criteria.add(Restrictions.eq("appSystemAdminEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.DATA_CUSTODIAN)
      {
    	  criteria.createAlias("application.appDataCustodianEntities", "appDataCustodianEntities");
    	  criteria.add(Restrictions.eq("appDataCustodianEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.BUSINESS_ANALYST)
      {
    	  criteria.createAlias("application.appBusinessAnalystEntities", "appBusinessAnalystEntities");
    	  criteria.add(Restrictions.eq("appBusinessAnalystEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.DEVELOPER)
      {
    	  criteria.createAlias("application.appDevelopersEntities", "appDevelopersEntities");
    	  criteria.add(Restrictions.eq("appDevelopersEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      else if(userReportRequest.getAppRoleId() == ApplicationConstatns.TESTER)
      {
    	  criteria.createAlias("application.appTesterEntities", "appTesterEntities");
    	  criteria.add(Restrictions.eq("appTesterEntities.userEntity.userId", userReportRequest.getUserId()));
      }
      
		return criteria.list();
	}

	@Override
	public List<AppAuditEntity> allAudits() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditEntity.class);
		List<AppAuditEntity> appAuditEntities = criteria.list();
		return appAuditEntities;
	}

	@Override
	public DatabaseEntity saveDatabaseServer(DatabaseEntity databaseEntity) {
		this.sessionFactory.getCurrentSession().save(databaseEntity);
		return databaseEntity;
	}

	@Override
	public DatabaseEntity updateDatabaseServer(DatabaseEntity databaseEntity) {
		this.sessionFactory.getCurrentSession().update(databaseEntity);
		return databaseEntity;
	}

	@Override
	public AssessmentEntity saveAssessment(AssessmentEntity assessmentEntity) {
		this.sessionFactory.getCurrentSession().save(assessmentEntity);
		return assessmentEntity;
	}

	@Override
	public AssessmentEntity getAssessmentEntity(int assessmentID) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssessmentEntity.class);
		criteria.add(Restrictions.eq("assessmentId", assessmentID));
		List<AssessmentEntity> assessmentEntities = criteria.list();
		AssessmentEntity assessmentEntity = null;
		if(assessmentEntities.size() > 0)
		{
			assessmentEntity = assessmentEntities.get(0);
		}
		return assessmentEntity;
	}

	@Override
	public AssessmentPolicyEntity getAppAssessmentPolicy(int assessmentPolicyID) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssessmentPolicyEntity.class);
		criteria.add(Restrictions.eq("assessmentPolicyId", assessmentPolicyID));
		List<AssessmentPolicyEntity> assessmentPolicyEntities = criteria.list();
		AssessmentPolicyEntity assessmentPolicyEntity = null;
		if(!assessmentPolicyEntities.isEmpty())
			 assessmentPolicyEntity = assessmentPolicyEntities.get(0);
		return assessmentPolicyEntity;
	}

	@Override
	public AssessmentPolicyEntity updateAssessment(AssessmentPolicyEntity assessmentPolicyEntity) {
		this.sessionFactory.getCurrentSession().update(assessmentPolicyEntity);
		return assessmentPolicyEntity;
	}

	@Override
	public AssessmentEntity upadateAssessment(AssessmentEntity assessmentEntity) {
		this.sessionFactory.getCurrentSession().update(assessmentEntity);
		return assessmentEntity;
	}

	@Override
	public List<AssessmentEntity> getAllAssessments() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssessmentEntity.class);
		criteria.addOrder(Order.desc("updatedTs"));
		return criteria.list();
	}

	@Override
	public AssessmentFileEntity getAssessmentFileEntity(int id) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssessmentFileEntity.class);
		criteria.add(Restrictions.eq("assessmentFileId", id));
		List<AssessmentFileEntity> assessmentFileEntities = criteria.list();
		if(!assessmentFileEntities.isEmpty())
			return assessmentFileEntities.get(0);
		else
			return null;
	}

	@Override
	public void saveMou(MOUEntity mouEntity) {
		this.sessionFactory.getCurrentSession().save(mouEntity);
		
	}
	@Override
	public void updateMou(MOUEntity mouEntity) {
		this.sessionFactory.getCurrentSession().update(mouEntity);
		
	}

	@Override
	public MOUEntity getMou(int mouId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MOUEntity.class);
		criteria.add(Restrictions.eq("mouId", mouId));
		List<MOUEntity> mouEntities = criteria.list();
		if(!mouEntities.isEmpty())
			return mouEntities.get(0);
		else
			return null;
	}

	@Override
	public MOUDocEntity getMOUDocEntity(Integer fileId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MOUDocEntity.class);
		criteria.add(Restrictions.eq("mouDocId", fileId));
		List<MOUDocEntity> mouDocEntities = criteria.list();
		if(!mouDocEntities.isEmpty())
			return mouDocEntities.get(0);
		else
			return null;
		
	}
	
	@Override
	public PolicyDocumentsEntity getPolicyDocument(Integer policyDocId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PolicyDocumentsEntity.class);
		criteria.add(Restrictions.eq("policyDocId", policyDocId));
		List<PolicyDocumentsEntity> policyDocEntities = criteria.list();
		if(!policyDocEntities.isEmpty())
			return policyDocEntities.get(0);
		else
			return null;
		
	}
	
	@Override
	public DeviceDocEntity getDeviceDocEntity(Integer fileId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DeviceDocEntity.class);
		criteria.add(Restrictions.eq("deviceDocId", fileId));
		List<DeviceDocEntity> deviceDocEntities = criteria.list();
		if(!deviceDocEntities.isEmpty())
			return deviceDocEntities.get(0);
		else
			return null;
		
	}

	@Override
	public void saveServerContact(ServerContactEntity serverContactEntity) {
		this.sessionFactory.getCurrentSession().save(serverContactEntity);
		
	}
	
	@Override
	public List<MOUEntity> getAllMous() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MOUEntity.class);
		return criteria.list();
		}

	}


