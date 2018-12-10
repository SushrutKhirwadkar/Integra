package com.soch.Integra.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.soch.Integra.dao.APMHistoryDao;
import com.soch.Integra.dao.ApplicationDao;
import com.soch.Integra.dao.PolicyDao;
import com.soch.Integra.dto.AssessmentAuditDTO;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.AssessmentAuditEntity;
import com.soch.Integra.entities.AuditTypeEntity;
import com.soch.Integra.entities.DatabaseEntity;
import com.soch.Integra.entities.ServerEntity;
import com.soch.Integra.entities.SystemSensitivityEntity;
import com.soch.Integra.entities.TechnologiesEntity;
import com.soch.Integra.entities.UserEntity;
import com.soch.Integra.entities.audit.AppAuditAuditEntity;
import com.soch.Integra.entities.audit.AppBusinessAnalystAuditEntity;
import com.soch.Integra.entities.audit.AppBusinessOwnerAuditEntity;
import com.soch.Integra.entities.audit.AppDataCustodianAuditEntity;
import com.soch.Integra.entities.audit.AppDataOwnerAuditEntity;
import com.soch.Integra.entities.audit.AppDbAdminAuditEntity;
import com.soch.Integra.entities.audit.AppDevelopersAuditEntity;
import com.soch.Integra.entities.audit.AppIsoAuditEntity;
import com.soch.Integra.entities.audit.AppProjectManagerAuditEntity;
import com.soch.Integra.entities.audit.AppSystemAdminAuditEntity;
import com.soch.Integra.entities.audit.AppSystemOwnerAuditEntity;
import com.soch.Integra.entities.audit.AppTestersAuditEntity;
import com.soch.Integra.entities.audit.ApplicationDatabaseAuditEntity;
import com.soch.Integra.entities.audit.ApplicationServerAuditEntity;
import com.soch.Integra.entities.audit.ApplicationTblAudit;
import com.soch.Integra.entities.audit.ApplicationTechnologyAuditEntity;
import com.soch.Integra.entities.audit.CostAuditEntity;
import com.soch.Integra.history.dto.AppAuditHistoryDTO;
import com.soch.Integra.history.dto.ApplicationHistoryDTO;

@Service
public class AAMHistoryServicesImpl implements AAMHistoryServices {

	@Autowired
	APMHistoryDao apmHistoryDao;
	
	@Autowired
	ApplicationDao applicationDao;
	
	@Autowired
	PolicyDao policyDao;
	
	@Autowired
	MessageSource messageSource;

	@Override
	@Transactional
	public List<ApplicationHistoryDTO> getApplicationHistory(String acronym) {
		// TODO Auto-generated method stub
		List<ApplicationTblAudit> applicationTblAudits = apmHistoryDao.getAppllicationHistory(acronym);
		List<ApplicationHistoryDTO> applicationHistoryDTOs = new ArrayList<>();
		ApplicationHistoryDTO applicationHistoryDTO = null, prevApplicationHistoryDTO;
		
		int index = 0;
		String description = null;
		StringBuffer businessOwners = null;
		List<String> businessOwnersList=null;
		StringBuffer dataOwners = null;
		List<String> dataOwnersList = null;
		StringBuffer projectManagers = null;
		List<String> projectManagersList = null;
		StringBuffer isos = null;
		List<String> isosList = null;
		StringBuffer systemowners = null;
		List<String> systemownersList = null;
		StringBuffer datacustodian = null;
		List<String> datacustodianList = null;
		StringBuffer testers = null;
		List<String> testersList = null;
		UserEntity userEntity = null;
		String technologyStatus = null;
		StringBuffer appDatabases = null,appServers = null,appTechnologies = null,
				 appProjectManagers = null, appSystemAdmins = null, appBusinessAnalysts = null,appDBAdmins = null,appDevelopers = null,estimatedAmount = null;
		List<String> appDatabaseList = null,appServersList=null, appTechnologyList = null,
			     appProjectManagerList = null, appSystemAdminList = null,appBusinessAnalystList = null, appDBAdminList = null,appDeveloperList = null;
		
		if(applicationTblAudits != null && !applicationTblAudits.isEmpty())
		{
			for(ApplicationTblAudit applicationTblAudit : applicationTblAudits)
			{
				applicationHistoryDTO = new ApplicationHistoryDTO();
				userEntity = applicationDao.getUserById(applicationTblAudit.getModifiedBy());
				applicationHistoryDTO.setUpdatedBy(userEntity.getFirstName()+ " "+userEntity.getLastName());
				applicationHistoryDTO.setModifiedTs(applicationTblAudit.getProcessDate());
				if(index > 0)
				{
					prevApplicationHistoryDTO = applicationHistoryDTOs.get(index-1);
					
					if(applicationTblAudit.getDescription() != null)
					{
						description = new String(applicationTblAudit.getDescription());
						if(index > 0 && !description.equalsIgnoreCase(prevApplicationHistoryDTO.getDescription()))
								
						{
							applicationHistoryDTO.setDescription(new String(applicationTblAudit.getDescription()));
						}
						
					}
					if(applicationTblAudit.getFiscalYear1() != null && prevApplicationHistoryDTO.getFiscalYear1() != applicationTblAudit.getFiscalYear1() )
						applicationHistoryDTO.setFiscalYear1(applicationTblAudit.getFiscalYear1());
					if(applicationTblAudit.getBoVision1() != null && applicationTblAudit.getBoVision1().equalsIgnoreCase(prevApplicationHistoryDTO.getbOVision1()))
						applicationHistoryDTO.setbOVision1(applicationTblAudit.getBoVision1());
					if(applicationTblAudit.getFiscalYear2() != null  && prevApplicationHistoryDTO.getFiscalYear2() != applicationTblAudit.getFiscalYear2() )
						applicationHistoryDTO.setFiscalYear2(applicationTblAudit.getFiscalYear2());
					if(applicationTblAudit.getBoVision2() != null && applicationTblAudit.getBoVision2().equalsIgnoreCase(prevApplicationHistoryDTO.getbOVision2()))
						applicationHistoryDTO.setbOVision2(applicationTblAudit.getBoVision2());
					if(applicationTblAudit.getFiscalYear3() != null  && prevApplicationHistoryDTO.getFiscalYear3() != applicationTblAudit.getFiscalYear3() )
						applicationHistoryDTO.setFiscalYear3(applicationTblAudit.getFiscalYear3());
					if(applicationTblAudit.getBoVision3() != null  && applicationTblAudit.getBoVision3().equalsIgnoreCase(prevApplicationHistoryDTO.getbOVision3()))
						applicationHistoryDTO.setbOVision3(applicationTblAudit.getBoVision3());
			        applicationHistoryDTOs.add(applicationHistoryDTO);
			        
			        System.out.println("Application Process Date:: "+applicationTblAudit.getProcessDate());
			        
			        //Business Owner
			        List<AppBusinessOwnerAuditEntity> appBusinessOwnerAuditEntities = apmHistoryDao.getAppBusinessOwners(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appBusinessOwnerAuditEntities.isEmpty() )
					{
						businessOwners = new StringBuffer();
						businessOwnersList = new ArrayList<>();
						for(AppBusinessOwnerAuditEntity appBusinessOwnerAuditEntity : appBusinessOwnerAuditEntities)
						{
							if(businessOwners.length() > 0)
								businessOwners.append(",");
							appBusinessOwnerAuditEntity.getAppBusinessOwner();
							userEntity = applicationDao.getUserById(appBusinessOwnerAuditEntity.getAppBusinessOwner());
							businessOwners.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							businessOwnersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!businessOwners.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppBusinessOwners()))
						{
							applicationHistoryDTO.setAppBusinessOwners(businessOwners.toString());
							applicationHistoryDTO.setAppBusinessOwnerList(businessOwnersList);
						}
						
					}
			        
			        
			        //Data Owner
			        List<AppDataOwnerAuditEntity> appDataOwnerAuditEntities = apmHistoryDao.getAppDataOwner(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appDataOwnerAuditEntities.isEmpty() )
					{
						dataOwners = new StringBuffer();
						dataOwnersList = new ArrayList<>();
						for(AppDataOwnerAuditEntity appDataOwnerAuditEntity : appDataOwnerAuditEntities)
						{
							if(dataOwners.length() > 0)
								dataOwners.append(",");
							appDataOwnerAuditEntity.getAppDataOwner();
							userEntity = applicationDao.getUserById(appDataOwnerAuditEntity.getAppDataOwner());
							dataOwners.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							dataOwnersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!dataOwners.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppDataOwner()))
						{
							applicationHistoryDTO.setAppDataOwner(dataOwners.toString());
							applicationHistoryDTO.setAppDataOwnerList(dataOwnersList);
						}
						
					}
			        
			        //Project Manager
			        List<AppProjectManagerAuditEntity> appProjectManagerAuditEntities = apmHistoryDao.getAppProjectManager(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appProjectManagerAuditEntities.isEmpty() )
					{
						projectManagers = new StringBuffer();
						projectManagersList = new ArrayList<>();
						for(AppProjectManagerAuditEntity appProjectManagerAuditEntity : appProjectManagerAuditEntities)
						{
							if(projectManagers.length() > 0)
								projectManagers.append(",");
							appProjectManagerAuditEntity.getAppProjectManager();
							userEntity = applicationDao.getUserById(appProjectManagerAuditEntity.getAppProjectManager());
							projectManagers.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							projectManagersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!projectManagers.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppProjectManager()))
						{
							applicationHistoryDTO.setAppProjectManager(projectManagers.toString());
							applicationHistoryDTO.setAppProjectManagerList(projectManagersList);
						}
						
					}
			        
			        //Information Security Officer
			        List<AppIsoAuditEntity> appIsoAuditEntities = apmHistoryDao.getAppIso(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appIsoAuditEntities.isEmpty() )
					{
						isos = new StringBuffer();
						isosList = new ArrayList<>();
						for(AppIsoAuditEntity appIsoAuditEntity : appIsoAuditEntities)
						{
							if(isos.length() > 0)
								isos.append(",");
							appIsoAuditEntity.getAppIso();
							userEntity = applicationDao.getUserById(appIsoAuditEntity.getAppIso());
							isos.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							isosList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!isos.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppIso()))
						{
							applicationHistoryDTO.setAppIso(isos.toString());
							applicationHistoryDTO.setAppIsoList(isosList);
						}
						
					}  
			      
			        //System Owner
			        List<AppSystemOwnerAuditEntity> appSystemOwnerAuditEntities = apmHistoryDao.getAppSystemOwner(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appSystemOwnerAuditEntities.isEmpty() )
					{
			        	systemowners = new StringBuffer();
			        	systemownersList = new ArrayList<>();
						for(AppSystemOwnerAuditEntity appSystemOwnerAuditEntity : appSystemOwnerAuditEntities)
						{
							if(systemowners.length() > 0)
								systemowners.append(",");
							appSystemOwnerAuditEntity.getAppSystemOwner();
							userEntity = applicationDao.getUserById(appSystemOwnerAuditEntity.getAppSystemOwner());
							systemowners.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							systemownersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!systemowners.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppSystemOnwer()));
						{
							applicationHistoryDTO.setAppSystemOnwer(systemowners.toString());
							applicationHistoryDTO.setAppSystemOwnerList(systemownersList);
						}
						
					}  
			        
			        //Data Custodian
			        List<AppDataCustodianAuditEntity> appDataCustodianAuditEntities = apmHistoryDao.getAppDataCustodian(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appDataCustodianAuditEntities.isEmpty() )
					{
			        	datacustodian = new StringBuffer();
			        	datacustodianList = new ArrayList<>();
						for(AppDataCustodianAuditEntity appDataCustodianAuditEntity : appDataCustodianAuditEntities)
						{
							if(datacustodian.length() > 0)
								datacustodian.append(",");
							userEntity = applicationDao.getUserById(appDataCustodianAuditEntity.getAppDataCustodian());
							datacustodian.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							datacustodianList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!datacustodian.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppDataCustodian()));
						{
							applicationHistoryDTO.setAppDataCustodian(datacustodian.toString());
							applicationHistoryDTO.setAppDataCustodianList(datacustodianList);
						}
						
					}  
			        
			        //Testers
			        List<AppTestersAuditEntity> appTestersAuditEntities = apmHistoryDao.getAppTesters(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
			        if(!appTestersAuditEntities.isEmpty() )
					{
			        	testers = new StringBuffer();
			        	testersList = new ArrayList<>();
						for(AppTestersAuditEntity appTestersAuditEntity : appTestersAuditEntities)
						{
							if(testers.length() > 0)
								testers.append(",");
							userEntity = applicationDao.getUserById(appTestersAuditEntity.getTester());
							testers.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							testersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						if(!testers.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppTesters()));
						{
							applicationHistoryDTO.setAppTesters(testers.toString());
							applicationHistoryDTO.setAppTestersList(testersList);
						}
						
					}  
			        
			        List<ApplicationDatabaseAuditEntity> applicationDatabaseAuditEntities = apmHistoryDao.getAppDatabases(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
					
					if(!applicationDatabaseAuditEntities.isEmpty())
					{
						appDatabases = new StringBuffer();
						appDatabaseList = new ArrayList<>();
						for(ApplicationDatabaseAuditEntity applicationDatabaseAuditEntity :applicationDatabaseAuditEntities)
						{
							if(appDatabases.length() > 0)
								appDatabases.append(",");
							DatabaseEntity databaseEntity = applicationDao.getDatabase(applicationDatabaseAuditEntity.getDatabaseId());
							appDatabases.append(databaseEntity.getHostName());
							appDatabaseList.add(databaseEntity.getHostName());
						}
						if(!appDatabases.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppDatabases()))
						{
						applicationHistoryDTO.setAppDatabases(appDatabaseList.toString());
						applicationHistoryDTO.setAppDatabaseList(appDatabaseList);
						}
					}
					
					List<ApplicationServerAuditEntity> applicationServerAuditEntities = apmHistoryDao.getAppServers(
							applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if (!applicationServerAuditEntities.isEmpty()) {
						ServerEntity serverEntity = null;
						appServersList = new ArrayList<>();
						appServers = new StringBuffer();
						for (ApplicationServerAuditEntity applicationServerAuditEntity : applicationServerAuditEntities) {
							serverEntity = applicationDao.getServer(applicationServerAuditEntity.getServerId());
							if (serverEntity != null) {
								if (appServers.length() > 0)
									appServers.append(",");
								appServers.append(serverEntity.getName());
								appServersList.add(serverEntity.getName());
							}
							serverEntity = null;
						}
						if(!appServers.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppServers()))
						{
						applicationHistoryDTO.setAppServers(appServers.toString());
						applicationHistoryDTO.setAppServerList(appServersList);
						}
					}

					List<ApplicationTechnologyAuditEntity> applicationTechnologyAuditEntities = apmHistoryDao
							.getAppTechnologies(applicationTblAudit.getProcessDate(),
									applicationTblAudit.getApplicationId());

					if (!applicationTechnologyAuditEntities.isEmpty()) {
						TechnologiesEntity technologiesEntity = null;
						appTechnologyList = new ArrayList<>();
						appTechnologies = new StringBuffer();
						for (ApplicationTechnologyAuditEntity applicationTechnologyAuditEntity : applicationTechnologyAuditEntities) {
							technologiesEntity = applicationDao
									.getTechnologyEntity(applicationTechnologyAuditEntity.getTechnologyId());
							if (technologiesEntity != null) {
								if (appTechnologies.length() > 0)
									appTechnologies.append(",");
								appTechnologies.append(technologiesEntity.getName());
								appTechnologyList.add(technologiesEntity.getName());
							}
							if(!appTechnologies.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppTechnologies()))
							{
							applicationHistoryDTO.setAppTechnologies(appTechnologies.toString());
							applicationHistoryDTO.setAppTechnologyList(appTechnologyList);
							technologiesEntity = null;
							}
						}

					}
					
					List<AppSystemAdminAuditEntity> appSystemAdminAuditEntities = apmHistoryDao.getAppSystemAdmins(
							applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if (!appSystemAdminAuditEntities.isEmpty()) {
						appSystemAdmins = new StringBuffer();
						appSystemAdminList = new ArrayList<>();
						for (AppSystemAdminAuditEntity appSystemAdminAuditEntity : appSystemAdminAuditEntities) {
							if (appSystemAdmins.length() > 0)
								appSystemAdmins.append(",");
							userEntity = applicationDao.getUserById(appSystemAdminAuditEntity.getAppSystemAdminId());
							appSystemAdmins.append(userEntity.getFirstName() + " " + userEntity.getLastName());
							appSystemAdminList.add(userEntity.getFirstName() + " " + userEntity.getLastName());
						}
						
						if(!appSystemAdmins.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppSystemAdmins()))
						{
						applicationHistoryDTO.setAppSystemAdmins(appSystemAdmins.toString());
						applicationHistoryDTO.setAppSystemAdminList(appSystemAdminList);
						}

					}

					List<AppBusinessAnalystAuditEntity> appBusinessAnalystAuditEntities = apmHistoryDao
							.getAppBusinessAnalysts(applicationTblAudit.getProcessDate(),
									applicationTblAudit.getApplicationId());
					if (!appBusinessAnalystAuditEntities.isEmpty()) {
						appBusinessAnalysts = new StringBuffer();
						appBusinessAnalystList = new ArrayList<>();
						for (AppBusinessAnalystAuditEntity appBusinessAnalystAuditEntity : appBusinessAnalystAuditEntities) {
							if (appBusinessAnalysts.length() > 0)
								appBusinessAnalysts.append(",");
							userEntity = applicationDao
									.getUserById(appBusinessAnalystAuditEntity.getBusinessAnalystId());
							appBusinessAnalysts.append(userEntity.getFirstName() + " " + userEntity.getLastName());
							appBusinessAnalystList.add(userEntity.getFirstName() + " " + userEntity.getLastName());
						}
						if(!appBusinessAnalysts.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppBusinessAnalysts()))
						{
						applicationHistoryDTO.setAppBusinessAnalysts(appBusinessAnalysts.toString());
						applicationHistoryDTO.setAppBusinessAnalystList(appBusinessAnalystList);
						}
					}

					List<AppDbAdminAuditEntity> appDbAdminAuditEntities = apmHistoryDao.getAppDBAdmins(
							applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if (!appDbAdminAuditEntities.isEmpty()) {
						appDBAdminList = new ArrayList<>();
						appDBAdmins = new StringBuffer();
						for (AppDbAdminAuditEntity appDbAdminAuditEntity : appDbAdminAuditEntities) {
							if (appDBAdmins.length() > 0)
								appDBAdmins.append(",");
							userEntity = applicationDao.getUserById(appDbAdminAuditEntity.getAppDbAdminId());
							appDBAdmins.append(userEntity.getFirstName() + " " + userEntity.getLastName());
							appDBAdminList.add(userEntity.getFirstName() + " " + userEntity.getLastName());
						}
						if(!appDBAdmins.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppBusinessAnalysts()))
						{
						applicationHistoryDTO.setAppDBAdmins(appDBAdmins.toString());
						applicationHistoryDTO.setAppDBAdminList(appDBAdminList);
						}
					}
					
					List<AppDevelopersAuditEntity> appDevelopersAuditEntities = apmHistoryDao.getAppDevelopers(
							applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if (!appDevelopersAuditEntities.isEmpty()) {
						appDeveloperList = new ArrayList<>();
						appDevelopers = new StringBuffer();
						for (AppDevelopersAuditEntity appDevelopersAuditEntity : appDevelopersAuditEntities) {

							if (appDevelopers.length() > 0) {
								userEntity = applicationDao.getUserById(appDevelopersAuditEntity.getDeveloper());
								appDevelopers.append(userEntity.getFirstName() + " " + userEntity.getLastName());
								appDeveloperList.add(userEntity.getFirstName() + " " + userEntity.getLastName());
							}
							if(!appDevelopers.toString().equalsIgnoreCase(prevApplicationHistoryDTO.getAppDevelopers()))
							{
							applicationHistoryDTO.setAppDevelopers(appDevelopers.toString());
							applicationHistoryDTO.setAppDeveloperList(appDeveloperList);
							}
							
						}
					}
					
					if(prevApplicationHistoryDTO.getPhysicalLocation() != null && 
							!prevApplicationHistoryDTO.getPhysicalLocation().equalsIgnoreCase(applicationTblAudit.getPhysicalLocation()))
						applicationHistoryDTO.setPhysicalLocation(applicationTblAudit.getPhysicalLocation() );
					
					
					if(prevApplicationHistoryDTO.getItSystemInterfaces() != null && 
							!prevApplicationHistoryDTO.getItSystemInterfaces().equalsIgnoreCase(applicationTblAudit.getSystemInterfaces()))
					{
						applicationHistoryDTO.setItSystemInterfaces(applicationTblAudit.getSystemInterfaces());
					}
					
					if(prevApplicationHistoryDTO.getiTSystemBoundary() != null && 
							!prevApplicationHistoryDTO.getiTSystemBoundary().equalsIgnoreCase(applicationTblAudit.getSystemBoundary()))
					{
						applicationHistoryDTO.setiTSystemBoundary(applicationTblAudit.getSystemBoundary());
					}
			        
			        //Data Sensitivity
					if(applicationTblAudit.getSystemSensitivityId() != null) {
					SystemSensitivityEntity systemSensitivityEntity = applicationDao.getSystemSensitivityById(applicationTblAudit.getSystemSensitivityId());
					
					if(systemSensitivityEntity != null)
					{
						if(prevApplicationHistoryDTO.getAppSystemSensitivity() != null && prevApplicationHistoryDTO.getAppSystemSensitivity().equalsIgnoreCase(systemSensitivityEntity.getSystemSensitivityValue()))
						{
							applicationHistoryDTO.setSystemSensitivity(systemSensitivityEntity.getSystemSensitivityValue());
						}
						else
						{
							applicationHistoryDTO.setSystemSensitivity(systemSensitivityEntity.getSystemSensitivityValue());
						}
					}
					
				}	
							
			        //Security Risks
			        
			        if(prevApplicationHistoryDTO.getAppSecurityRisks() != null && applicationTblAudit.getRisks() != null)
			        {
			        	String risks = new String(applicationTblAudit.getRisks() );
			        	if(!prevApplicationHistoryDTO.getAppSecurityRisks().equalsIgnoreCase(risks))
			        	{
			        		applicationHistoryDTO.setAppSecurityRisks(risks);
			        	}
			        }
			        else
			        {
			        	if(applicationTblAudit.getRisks() != null)
			        	applicationHistoryDTO.setAppSecurityRisks(new String(applicationTblAudit.getRisks()));
			        }
			        
			        if(prevApplicationHistoryDTO.getConsideration() != null && applicationTblAudit.getConsideration() != null)
			        {
			        	String consideration = new String(applicationTblAudit.getConsideration());
			        	if(!prevApplicationHistoryDTO.getConsideration().equalsIgnoreCase(consideration))
			        	{
			        		applicationHistoryDTO.setConsideration(consideration);
			        	}
			        }
			        else
			        {
			        	if(applicationTblAudit.getConsideration() != null)
			        	applicationHistoryDTO.setConsideration(new String(applicationTblAudit.getConsideration()));
			        }
			        
			        
			        if(prevApplicationHistoryDTO.getAppAssessments() != null && applicationTblAudit.getSecurityAssessments()!= null)
			        {
			        	if(!prevApplicationHistoryDTO.getAppAssessments().equalsIgnoreCase(applicationTblAudit.getSecurityAssessments()))
			        	{
			        		applicationHistoryDTO.setAppAssessments(applicationTblAudit.getSecurityAssessments());
			        	}
			        }
			        else
			        {
			        	applicationHistoryDTO.setAppAssessments(applicationTblAudit.getSecurityAssessments());
			        }
			        
			  
			        

					List<CostAuditEntity> costAuditEntities = apmHistoryDao.getAppCosts(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
					
					if(!costAuditEntities.isEmpty())
					{
						estimatedAmount = new StringBuffer();
						
						for(CostAuditEntity costAuditEntity : costAuditEntities)
						{
							if(estimatedAmount.length() > 0)
							{
								estimatedAmount.append(",");
							}
							estimatedAmount.append(costAuditEntity.getTypeValue());
						}
						if(!prevApplicationHistoryDTO.getEstimatedAmount().equalsIgnoreCase(estimatedAmount.toString()))
						applicationHistoryDTO.setEstimatedAmount(estimatedAmount.toString());
					}
					
					if(applicationTblAudit.getTechnologyStatus() != null)
					{
						if(new String(applicationTblAudit.getTechnologyStatus()).equalsIgnoreCase(technologyStatus))
						{
							technologyStatus = new String(applicationTblAudit.getTechnologyStatus());
							applicationHistoryDTO.setTechnologyStatus(technologyStatus);
						}
					}
			        
				}
				else
				{
					if(applicationTblAudit.getDescription() != null)
					applicationHistoryDTO.setDescription(new String(applicationTblAudit.getDescription()));
					
					if(applicationTblAudit.getFiscalYear1() != null)
						applicationHistoryDTO.setFiscalYear1(applicationTblAudit.getFiscalYear1());
					if(applicationTblAudit.getBoVision1() != null)
						applicationHistoryDTO.setbOVision1(applicationTblAudit.getBoVision1());
					if(applicationTblAudit.getFiscalYear2() != null)
						applicationHistoryDTO.setFiscalYear2(applicationTblAudit.getFiscalYear2());
					if(applicationTblAudit.getBoVision2() != null)
						applicationHistoryDTO.setbOVision2(applicationTblAudit.getBoVision2());
					if(applicationTblAudit.getFiscalYear3() != null)
						applicationHistoryDTO.setFiscalYear3(applicationTblAudit.getFiscalYear3());
					if(applicationTblAudit.getBoVision3() != null)
						applicationHistoryDTO.setbOVision3(applicationTblAudit.getBoVision3());
					
					System.out.println("Application Process Date:: "+applicationTblAudit.getProcessDate());
					
					//Business Owner 
					List<AppBusinessOwnerAuditEntity> appBusinessOwnerAuditEntities = apmHistoryDao.getAppBusinessOwners(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
					if(!appBusinessOwnerAuditEntities.isEmpty() )
					{
						businessOwners = new StringBuffer();
						businessOwnersList = new ArrayList<>();
						for(AppBusinessOwnerAuditEntity appBusinessOwnerAuditEntity : appBusinessOwnerAuditEntities)
						{
							if(businessOwners.length() > 0)
								businessOwners.append(",");
							appBusinessOwnerAuditEntity.getAppBusinessOwner();
							userEntity = applicationDao.getUserById(appBusinessOwnerAuditEntity.getAppBusinessOwner());
							businessOwners.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							businessOwnersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppBusinessOwners(businessOwners.toString());
						applicationHistoryDTO.setAppBusinessOwnerList(businessOwnersList);
					}
					
					//Data Owner
					List<AppDataOwnerAuditEntity> appDataOwnerAuditEntities = apmHistoryDao.getAppDataOwner(applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if(!appDataOwnerAuditEntities.isEmpty() )
					{
						dataOwners = new StringBuffer();
						dataOwnersList = new ArrayList<>();
						for(AppDataOwnerAuditEntity appDataOwnerAuditEntity : appDataOwnerAuditEntities)
						{
							if(dataOwners.length() > 0)
								dataOwners.append(",");
							appDataOwnerAuditEntity.getAppDataOwner();
							userEntity = applicationDao.getUserById(appDataOwnerAuditEntity.getAppDataOwner());
							dataOwners.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							dataOwnersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppBusinessOwners(dataOwners.toString());
						applicationHistoryDTO.setAppBusinessOwnerList(dataOwnersList);
					}
					
					//Project Manager
					List<AppProjectManagerAuditEntity> appProjectManagerAuditEntities = apmHistoryDao.getAppProjectManager(applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if(!appProjectManagerAuditEntities.isEmpty() )
					{
						projectManagers = new StringBuffer();
						projectManagersList = new ArrayList<>();
						for(AppProjectManagerAuditEntity appProjectManagerAuditEntity : appProjectManagerAuditEntities)
						{
							if(projectManagers.length() > 0)
								projectManagers.append(",");
							appProjectManagerAuditEntity.getAppProjectManager();
							userEntity = applicationDao.getUserById(appProjectManagerAuditEntity.getAppProjectManager());
							projectManagers.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							projectManagersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppProjectManager(projectManagers.toString());
						applicationHistoryDTO.setAppProjectManagerList(projectManagersList);
					}
					
					//ISO
					List<AppIsoAuditEntity> appIsoAuditEntities = apmHistoryDao.getAppIso(applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if(!appIsoAuditEntities.isEmpty() )
					{
						isos = new StringBuffer();
						isosList = new ArrayList<>();
						for(AppIsoAuditEntity appIsoAuditEntity : appIsoAuditEntities)
						{
							if(isos.length() > 0)
								isos.append(",");
							appIsoAuditEntity.getAppIso();
							userEntity = applicationDao.getUserById(appIsoAuditEntity.getAppIso());
							isos.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							isosList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppIso(isos.toString());
						applicationHistoryDTO.setAppIsoList(isosList);
					}
					
					//System Owner
					List<AppSystemOwnerAuditEntity> appSystemOwnerAuditEntities = apmHistoryDao.getAppSystemOwner(applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if(!appSystemOwnerAuditEntities.isEmpty() )
					{
						systemowners = new StringBuffer();
						systemownersList = new ArrayList<>();
						for(AppSystemOwnerAuditEntity appSystemOwnerAuditEntity : appSystemOwnerAuditEntities)
						{
							if(systemowners.length() > 0)
								systemowners.append(",");
							appSystemOwnerAuditEntity.getAppSystemOwner();
							userEntity = applicationDao.getUserById(appSystemOwnerAuditEntity.getAppSystemOwner());
							systemowners.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							systemownersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppIso(systemowners.toString());
						applicationHistoryDTO.setAppIsoList(systemownersList);
					}
					
					//Data Custodian
					List<AppDataCustodianAuditEntity> appDataCustodianAuditEntities = apmHistoryDao.getAppDataCustodian(applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if(!appDataCustodianAuditEntities.isEmpty() )
					{
						datacustodian = new StringBuffer();
						datacustodianList = new ArrayList<>();
						for(AppDataCustodianAuditEntity appDataCustodianAuditEntity : appDataCustodianAuditEntities)
						{
							if(datacustodian.length() > 0)
								datacustodian.append(",");
							appDataCustodianAuditEntity.getAppDataCustodian();
							userEntity = applicationDao.getUserById(appDataCustodianAuditEntity.getAppDataCustodian());
							datacustodian.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							datacustodianList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppDataCustodian(datacustodian.toString());
						applicationHistoryDTO.setAppDataCustodianList(datacustodianList);
					}
					
					//Testers
					List<AppTestersAuditEntity> appTestersAuditEntities = apmHistoryDao.getAppTesters(applicationTblAudit.getProcessDate(), applicationTblAudit.getApplicationId());
					if(!appTestersAuditEntities.isEmpty() )
					{
						testers = new StringBuffer();
						testersList = new ArrayList<>();
						for(AppTestersAuditEntity appTestersAuditEntity : appTestersAuditEntities)
						{
							if(testers.length() > 0)
								testers.append(",");
							userEntity = applicationDao.getUserById(appTestersAuditEntity.getTester());
							testers.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							testersList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppTesters(testers.toString());
						applicationHistoryDTO.setAppTestersList(testersList);
					}
					
					if(applicationTblAudit.getSystemSensitivityId() != null)
					{
					SystemSensitivityEntity systemSensitivityEntity = applicationDao.getSystemSensitivityById(applicationTblAudit.getSystemSensitivityId());
					
					applicationHistoryDTO.setSystemSensitivity(systemSensitivityEntity.getSystemSensitivityValue());
					}
					if(applicationTblAudit.getRisks() !=null)
        		applicationHistoryDTO.setAppSecurityRisks(new String(applicationTblAudit.getRisks()));
					if(applicationTblAudit.getConsideration() !=null)
        		applicationHistoryDTO.setConsideration(new String(applicationTblAudit.getConsideration()));
        		applicationHistoryDTO.setAppAssessments(applicationTblAudit.getSecurityAssessments());
				        
					List<ApplicationDatabaseAuditEntity> applicationDatabaseAuditEntities = apmHistoryDao.getAppDatabases(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
					
					if(!applicationDatabaseAuditEntities.isEmpty())
					{
						appDatabases = new StringBuffer();
						appDatabaseList = new ArrayList<>();
						for(ApplicationDatabaseAuditEntity applicationDatabaseAuditEntity :applicationDatabaseAuditEntities)
						{
							if(appDatabases.length() > 0)
								appDatabases.append(",");
							DatabaseEntity databaseEntity = applicationDao.getDatabase(applicationDatabaseAuditEntity.getDatabaseId());
							appDatabases.append(databaseEntity.getHostName());
							appDatabaseList.add(databaseEntity.getHostName());
						}
						
						applicationHistoryDTO.setAppDatabases(appDatabaseList.toString());
						applicationHistoryDTO.setAppDatabaseList(appDatabaseList);
					}
					
					
					List<ApplicationServerAuditEntity> applicationServerAuditEntities = apmHistoryDao.getAppServers(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					if(!applicationServerAuditEntities.isEmpty())
					{
						ServerEntity serverEntity = null;
						appServersList = new ArrayList<>();
						appServers = new StringBuffer();
						for(ApplicationServerAuditEntity applicationServerAuditEntity : applicationServerAuditEntities)
						{
							serverEntity = applicationDao.getServer(applicationServerAuditEntity.getServerId());
							if(serverEntity != null)
							{
								if(appServers.length() > 0)
									appServers.append(",");
								appServers.append(serverEntity.getName());
								appServersList.add(serverEntity.getName());
							}
							serverEntity = null;
						}
						
						applicationHistoryDTO.setAppServers(appServers.toString());
						applicationHistoryDTO.setAppServerList(appServersList);
					}
						
					List<ApplicationTechnologyAuditEntity> applicationTechnologyAuditEntities = apmHistoryDao.getAppTechnologies(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					
					if(!applicationTechnologyAuditEntities.isEmpty())
					{
						TechnologiesEntity technologiesEntity = null;
						appTechnologyList = new ArrayList<>();
						appTechnologies = new StringBuffer();
						for(ApplicationTechnologyAuditEntity applicationTechnologyAuditEntity : applicationTechnologyAuditEntities)
						{
							technologiesEntity = applicationDao.getTechnologyEntity(applicationTechnologyAuditEntity.getTechnologyId());
							if(technologiesEntity != null)
							{
								if(appTechnologies.length() > 0)
									appTechnologies.append(",");
								appTechnologies.append(technologiesEntity.getName());
								appTechnologyList.add(technologiesEntity.getName());
							}
							applicationHistoryDTO.setAppTechnologies(appTechnologies.toString());
							applicationHistoryDTO.setAppTechnologyList(appTechnologyList);
							technologiesEntity = null;
						}
						
					}
					
					 appProjectManagerAuditEntities = apmHistoryDao.getProjectManagers(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					if(!appProjectManagerAuditEntities.isEmpty())
					{
						appProjectManagerList = new ArrayList<>();
						appProjectManagers = new StringBuffer();
						for(AppProjectManagerAuditEntity appProjectManagerAuditEntity : appProjectManagerAuditEntities)
						{
							if(appProjectManagers.length() > 0)
								appProjectManagers.append(",");
							userEntity = applicationDao.getUserById(appProjectManagerAuditEntity.getAppProjectManager());
							appProjectManagers.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							appProjectManagerList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						
						applicationHistoryDTO.setAppProjectManagers(appProjectManagers.toString());
						applicationHistoryDTO.setAppProjectManagerList(appProjectManagerList);
						
					}
					
					List<AppSystemAdminAuditEntity> appSystemAdminAuditEntities = apmHistoryDao.getAppSystemAdmins(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					if(!appSystemAdminAuditEntities.isEmpty())
					{
						appSystemAdmins = new StringBuffer();
						appSystemAdminList = new ArrayList<>();
						for(AppSystemAdminAuditEntity appSystemAdminAuditEntity : appSystemAdminAuditEntities)
						{
							if(appSystemAdmins.length() > 0)
								appSystemAdmins.append(",");
							userEntity = applicationDao.getUserById(appSystemAdminAuditEntity.getAppSystemAdminId());
							appSystemAdmins.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							appSystemAdminList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
							
						applicationHistoryDTO.setAppSystemAdmins(appSystemAdmins.toString());
						applicationHistoryDTO.setAppSystemAdminList(appSystemAdminList);

					}
					
					List<AppBusinessAnalystAuditEntity> appBusinessAnalystAuditEntities = apmHistoryDao.getAppBusinessAnalysts(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					if(!appBusinessAnalystAuditEntities.isEmpty())
					{
						appBusinessAnalysts = new StringBuffer();
						appBusinessAnalystList = new ArrayList<>();
						for(AppBusinessAnalystAuditEntity appBusinessAnalystAuditEntity : appBusinessAnalystAuditEntities)
						{
							if(appBusinessAnalysts.length() > 0)
								appBusinessAnalysts.append(",");
							userEntity = applicationDao.getUserById(appBusinessAnalystAuditEntity.getBusinessAnalystId());
							appBusinessAnalysts.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							appBusinessAnalystList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						applicationHistoryDTO.setAppBusinessAnalysts(appBusinessAnalysts.toString());
						applicationHistoryDTO.setAppBusinessAnalystList(appBusinessAnalystList);
					}
					
					List<AppDbAdminAuditEntity> appDbAdminAuditEntities = apmHistoryDao.getAppDBAdmins(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					if(!appDbAdminAuditEntities.isEmpty())
					{
						appDBAdminList = new ArrayList<>();
						appDBAdmins = new StringBuffer();
						for(AppDbAdminAuditEntity appDbAdminAuditEntity : appDbAdminAuditEntities)
						{
							if(appDBAdmins.length() > 0)
								appDBAdmins.append(",");
							userEntity = applicationDao.getUserById(appDbAdminAuditEntity.getAppDbAdminId());
							appDBAdmins.append(userEntity.getFirstName()+" "+userEntity.getLastName());
							appDBAdminList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
						}
						
						applicationHistoryDTO.setAppDBAdmins(appDBAdmins.toString());
						applicationHistoryDTO.setAppDBAdminList(appDBAdminList);
					}
					
					List<AppDevelopersAuditEntity> appDevelopersAuditEntities = apmHistoryDao.getAppDevelopers(applicationTblAudit.getProcessDate(),  
																						applicationTblAudit.getApplicationId());
					if(!appDevelopersAuditEntities.isEmpty())
					{
						appDeveloperList = new ArrayList<>();
						appDevelopers = new StringBuffer();
						for(AppDevelopersAuditEntity appDevelopersAuditEntity : appDevelopersAuditEntities)
						{
							
							if(appDevelopers.length() > 0 )
							{
								userEntity = applicationDao.getUserById(appDevelopersAuditEntity.getDeveloper());
								appDevelopers.append(userEntity.getFirstName()+" "+userEntity.getLastName());
								appDeveloperList.add(userEntity.getFirstName()+" "+userEntity.getLastName());
							}
							
							applicationHistoryDTO.setAppDevelopers(appDevelopers.toString());
							applicationHistoryDTO.setAppDeveloperList(appDeveloperList);
						}
					}
					
					if(applicationTblAudit.getPhysicalLocation() != null)
						applicationHistoryDTO.setPhysicalLocation(applicationTblAudit.getPhysicalLocation() );
					
					if(applicationTblAudit.getSystemInterfaces() != null)
					{
						applicationHistoryDTO.setItSystemInterfaces(applicationTblAudit.getSystemInterfaces());
					}
					
					if(applicationTblAudit.getSystemBoundary() != null)
					{
						applicationHistoryDTO.setiTSystemBoundary(applicationTblAudit.getSystemBoundary());
					}
					
					if(applicationTblAudit.getTechnologyStatus() != null && applicationTblAudit.getTechnologyStatus().length > 0)
					{
						applicationHistoryDTO.setTechnologyStatus(applicationTblAudit.getTechnologyStatus().toString());
					}
					
					List<CostAuditEntity> costAuditEntities = apmHistoryDao.getAppCosts(applicationTblAudit.getProcessDate(),  
							applicationTblAudit.getApplicationId());
					
					if(!costAuditEntities.isEmpty())
					{
						estimatedAmount = new StringBuffer();
						
						for(CostAuditEntity costAuditEntity : costAuditEntities)
						{
							if(estimatedAmount.length() > 0)
							{
								estimatedAmount.append(",");
							}
							estimatedAmount.append(costAuditEntity.getTypeValue());
						}
						applicationHistoryDTO.setEstimatedAmount(estimatedAmount.toString());
					}
					
					applicationHistoryDTOs.add(applicationHistoryDTO);
					
				}
				index++;
		        
		        
			}
			
		}
		return applicationHistoryDTOs;
	}

	@Override
	@Transactional
	public List<AppAuditHistoryDTO> getApplicationAuditHistory(String acronym) {
		ApplicationEntity applicationEntity = applicationDao.getAcronym(acronym);
 		List<AppAuditAuditEntity> appAuditAuditEntities = apmHistoryDao.getApplicatonAuditHistory(applicationEntity.getApplicationId());
 		AuditTypeEntity auditTypeEntity = null;
 		 String auditFindings = null, typeOfFindings = null,overallRiskLevel = null,findingComments = null,responsibleParty = null, recommendedBy = null, 
 			recomendations = null,managementResponse = null, responseBy = null, actionPlan = null, actionPlanAssignedTo = null, actionPlanCloseoutComments = null,
 			actionPlanSummary = null, actionPlanTasks = null, businessRisk = null, securityRisk = null;
 		 java.util.Date estimatedCompletionDt = null, responseDt = null, actionPlanEndDt = null, actionPlanStartDt =null;
 		if(!appAuditAuditEntities.isEmpty())
 		{
 			List<AppAuditHistoryDTO>  appAuditHistoryDTOs = new ArrayList<>();
 			AppAuditHistoryDTO appAuditHistoryDTO = null, prevAppAuditHistoryDTO = null;
 			int index = 0;
 			for(AppAuditAuditEntity appAuditAuditEntity : appAuditAuditEntities)
 			{
// 					/prevAppAuditHistoryDTO = appAuditHistoryDTOs.get(index-1);
 					appAuditHistoryDTO = new AppAuditHistoryDTO();
 					appAuditHistoryDTO.setUpdatedBy(appAuditAuditEntity.getUpdatedBy());
 					appAuditHistoryDTO.setUpadateTs(appAuditAuditEntity.getUpdatedTs());
 					if(appAuditAuditEntity.getAuditName() != null)
 					{
 						auditTypeEntity = applicationDao.getAuditType(Integer.parseInt(appAuditAuditEntity.getAuditName()));
 						appAuditHistoryDTO.setAuditName(auditTypeEntity.getAuditTypeName());
 						//appAuditHistoryDTO.setPolicyGrpName();
 					}
 					
 					appAuditHistoryDTO.setAuditType(appAuditAuditEntity.getAuditType());
 					appAuditHistoryDTO.setAuditDate(appAuditAuditEntity.getAuditDate());
 					appAuditHistoryDTO.setNextAuditDate(appAuditAuditEntity.getNextAuditDate());
 					appAuditHistoryDTO.setStatus(appAuditAuditEntity.getStatus());
 					
 					if(auditFindings == null)
 					{
 						auditFindings = appAuditAuditEntity.getAuditFindings();
 						appAuditHistoryDTO.setAuditFindings(appAuditAuditEntity.getAuditFindings());
 					}
 					else if(!auditFindings.equalsIgnoreCase(appAuditAuditEntity.getAuditFindings()))
 					{
 						auditFindings = appAuditAuditEntity.getAuditFindings();
 						appAuditHistoryDTO.setAuditFindings(appAuditAuditEntity.getAuditFindings());
 					}
 					
 					if(typeOfFindings == null)
 					{
 						typeOfFindings = appAuditAuditEntity.getTypeOfFindings();
 						appAuditHistoryDTO.setTypeOfFindings(appAuditAuditEntity.getTypeOfFindings());
 					}
 					else if(!typeOfFindings.equalsIgnoreCase(appAuditAuditEntity.getTypeOfFindings()))
 					{
 						typeOfFindings = appAuditAuditEntity.getTypeOfFindings();
 						appAuditHistoryDTO.setTypeOfFindings(appAuditAuditEntity.getTypeOfFindings());
 					}
 					
 					if(overallRiskLevel == null)
 					{
 						overallRiskLevel = appAuditAuditEntity.getOverallRiskLevel();
 						appAuditHistoryDTO.setOverallRiskLevel(appAuditAuditEntity.getOverallRiskLevel());
 					}
 					else if(!overallRiskLevel.equalsIgnoreCase(appAuditAuditEntity.getOverallRiskLevel()))
 					{
 						overallRiskLevel = appAuditAuditEntity.getOverallRiskLevel();
 						appAuditHistoryDTO.setOverallRiskLevel(appAuditAuditEntity.getOverallRiskLevel());
 					}
 					
 					if(findingComments == null)
 					{
 						findingComments = appAuditAuditEntity.getFindingComments();
 						appAuditHistoryDTO.setFindingComments(appAuditAuditEntity.getFindingComments());
 					}
 					else if(!findingComments.equalsIgnoreCase(appAuditAuditEntity.getFindingComments()))
 					{
 						findingComments = appAuditAuditEntity.getFindingComments();
 						appAuditHistoryDTO.setFindingComments(appAuditAuditEntity.getFindingComments());
 					}
 					
 					if(responsibleParty == null)
 					{
 						responsibleParty = appAuditAuditEntity.getResponsibleParty();
 						appAuditHistoryDTO.setResponsibleParty(appAuditAuditEntity.getResponsibleParty());
 					}
 					else if(!responsibleParty.equalsIgnoreCase(appAuditAuditEntity.getResponsibleParty()))
 					{
 						responsibleParty = appAuditAuditEntity.getResponsibleParty();
 						appAuditHistoryDTO.setResponsibleParty(appAuditAuditEntity.getResponsibleParty());
 					}
 					
 					if(recommendedBy == null)
 					{
 						recommendedBy = appAuditAuditEntity.getRecomendedBy();
 						appAuditHistoryDTO.setRecomendedBy(appAuditAuditEntity.getRecomendedBy());
 					}
 					else if(!recommendedBy.equalsIgnoreCase(appAuditAuditEntity.getRecomendedBy()))
 					{
 						recommendedBy = appAuditAuditEntity.getRecomendedBy();
 						appAuditHistoryDTO.setRecomendedBy(appAuditAuditEntity.getRecomendedBy());
 					}
 					
 					if(estimatedCompletionDt == null)
 					{
 						estimatedCompletionDt = appAuditAuditEntity.getEstimatedCompletionDt();
 						appAuditHistoryDTO.setEstimatedCompletionDt(appAuditAuditEntity.getEstimatedCompletionDt());
 					}
 					else if(!estimatedCompletionDt.equals(appAuditAuditEntity.getEstimatedCompletionDt()))
 					{
 						estimatedCompletionDt = appAuditAuditEntity.getEstimatedCompletionDt();
 						appAuditHistoryDTO.setEstimatedCompletionDt(appAuditAuditEntity.getEstimatedCompletionDt());
 					}
 					
 					if(recomendations == null)
 					{
 						recomendations = appAuditAuditEntity.getRecomendations();
 						appAuditHistoryDTO.setRecomendations(appAuditAuditEntity.getRecomendations());
 					}
 					else if(!recomendations.equalsIgnoreCase(appAuditAuditEntity.getRecomendations()))
 					{
 						recomendations = appAuditAuditEntity.getRecomendations();
 						appAuditHistoryDTO.setRecomendations(appAuditAuditEntity.getRecomendations());
 					}
 					
 					if(managementResponse == null)
 					{
 						managementResponse = appAuditAuditEntity.getMenagementResponse();
 						appAuditHistoryDTO.setManagementReponse(appAuditAuditEntity.getMenagementResponse());
 					}
 					else if(!managementResponse.equalsIgnoreCase(appAuditAuditEntity.getMenagementResponse()))
 					{
 						managementResponse = appAuditAuditEntity.getMenagementResponse();
 						appAuditHistoryDTO.setManagementReponse(appAuditAuditEntity.getMenagementResponse());
 					}
 						
 					if(responseBy == null)
 					{
 						responseBy = appAuditAuditEntity.getResponseBy();
 						appAuditHistoryDTO.setResponseBy(appAuditAuditEntity.getResponseBy());
 					}
 					else if(!responseBy.equalsIgnoreCase(appAuditAuditEntity.getResponseBy()))
 					{
 						responseBy = appAuditAuditEntity.getResponseBy();
 						appAuditHistoryDTO.setResponseBy(appAuditAuditEntity.getResponseBy());
 					}
 					
 					if(responseDt == null)
 					{
 						responseDt = appAuditAuditEntity.getResponseDt();
 						appAuditHistoryDTO.setResponseDt(appAuditAuditEntity.getResponseDt());
 					}
 					else if(!responseDt.equals(appAuditAuditEntity.getResponseDt()))
 					{
 						responseDt = appAuditAuditEntity.getResponseDt();
 						appAuditHistoryDTO.setResponseDt(appAuditAuditEntity.getResponseDt());
 					}
 					
 					if(actionPlan == null)
 					{
 						actionPlan = appAuditAuditEntity.getActionPlan();
 						appAuditHistoryDTO.setActionPlan(appAuditAuditEntity.getActionPlan());
 					}
 					else if(!actionPlan.equalsIgnoreCase(appAuditAuditEntity.getActionPlan()))
 					{
 						actionPlan = appAuditAuditEntity.getActionPlan();
 						appAuditHistoryDTO.setActionPlan(appAuditAuditEntity.getActionPlan());
 					}
 					
 					if(actionPlanAssignedTo == null)
 					{
 						actionPlanAssignedTo = appAuditAuditEntity.getActionPlanAssignedTo();
 						appAuditHistoryDTO.setActionPlanAssignedTo(appAuditAuditEntity.getActionPlanAssignedTo());
 					}
 					else if(!actionPlanAssignedTo.equalsIgnoreCase(appAuditAuditEntity.getActionPlanAssignedTo()))
 					{
 						actionPlanAssignedTo = appAuditAuditEntity.getActionPlanAssignedTo();
 						appAuditHistoryDTO.setActionPlanAssignedTo(appAuditAuditEntity.getActionPlanAssignedTo());
 					}
 					
 					if(actionPlanCloseoutComments == null)
 					{
 						actionPlanCloseoutComments = appAuditAuditEntity.getActionPlanCloseoutComments();
 						appAuditHistoryDTO.setActionPlanCloseoutComments(appAuditAuditEntity.getActionPlanCloseoutComments());
 					}
 					else if(!actionPlanCloseoutComments.equalsIgnoreCase(appAuditAuditEntity.getActionPlanCloseoutComments()))
 					{
 						actionPlanCloseoutComments = appAuditAuditEntity.getActionPlanCloseoutComments();
 						appAuditHistoryDTO.setActionPlanCloseoutComments(appAuditAuditEntity.getActionPlanCloseoutComments());
 					}
 					
 					if(actionPlanEndDt == null)
 					{
 						actionPlanEndDt = appAuditAuditEntity.getActionPlanEndDt();
 						appAuditHistoryDTO.setActionPlanEndDt(appAuditAuditEntity.getActionPlanEndDt());
 					}
 					else if(!actionPlanEndDt.equals(appAuditAuditEntity.getActionPlanEndDt()))
 					{
 						actionPlanEndDt = appAuditAuditEntity.getActionPlanEndDt();
 						appAuditHistoryDTO.setActionPlanEndDt(appAuditAuditEntity.getActionPlanEndDt());
 					}
 					
 					if(actionPlanSummary == null)
 					{
 						actionPlanSummary = appAuditAuditEntity.getActionPlanSummary();
 						appAuditHistoryDTO.setActionPlanSummary(appAuditAuditEntity.getActionPlanSummary());
 					}
 					else if(!actionPlanSummary.equalsIgnoreCase(appAuditAuditEntity.getActionPlanSummary()))
 					{
 						actionPlanSummary = appAuditAuditEntity.getActionPlanSummary();
 						appAuditHistoryDTO.setActionPlanSummary(appAuditAuditEntity.getActionPlanSummary());
 					}
 					
 					if(actionPlanStartDt == null)
 					{
 						actionPlanStartDt = appAuditAuditEntity.getActionPlanStartDt();
 						appAuditHistoryDTO.setActionPlanStartDt(appAuditAuditEntity.getActionPlanStartDt());
 					}
 					else if(!actionPlanStartDt.equals(appAuditAuditEntity.getActionPlanStartDt()))
 					{
 						actionPlanStartDt = appAuditAuditEntity.getActionPlanStartDt();
 						appAuditHistoryDTO.setActionPlanStartDt(appAuditAuditEntity.getActionPlanStartDt());
 					}
 					
 					if(actionPlanTasks == null)
 					{
 						actionPlanTasks = appAuditAuditEntity.getActionPlanTasks();
 						appAuditHistoryDTO.setActionPlanTasks(appAuditAuditEntity.getActionPlanTasks());
 					}
 					else if(!actionPlanTasks.equalsIgnoreCase(appAuditAuditEntity.getActionPlanTasks()))
 					{
 						actionPlanTasks = appAuditAuditEntity.getActionPlanTasks();
 						appAuditHistoryDTO.setActionPlanTasks(appAuditAuditEntity.getActionPlanTasks());
 					}
 					
 					if(businessRisk == null)
 					{
 						businessRisk = appAuditAuditEntity.getBusinessRisks();
 						appAuditHistoryDTO.setBusinessRisks(appAuditAuditEntity.getBusinessRisks());
 					}
 					else if(!businessRisk.equalsIgnoreCase(appAuditAuditEntity.getBusinessRisks()))
 					{
 						businessRisk = appAuditAuditEntity.getBusinessRisks();
 						appAuditHistoryDTO.setBusinessRisks(appAuditAuditEntity.getBusinessRisks());
 					}
 					
 					if(securityRisk == null)
 					{
 						securityRisk = appAuditAuditEntity.getSecurityRisks();
 						appAuditHistoryDTO.setSecurityRisks(appAuditAuditEntity.getSecurityRisks());
 					}
 					else if(!securityRisk.equalsIgnoreCase(appAuditAuditEntity.getSecurityRisks()))
 					{
						securityRisk = appAuditAuditEntity.getSecurityRisks();
 						appAuditHistoryDTO.setSecurityRisks(appAuditAuditEntity.getSecurityRisks());
 					}
 					
 					
 					
 					appAuditHistoryDTO.setBudget(appAuditAuditEntity.getBudget());
 					//appAuditAuditEntity.getAuditName();
 					
 					if(prevAppAuditHistoryDTO != null)
 					{
 						
 					}
 					else
 					{
 						
 					}
 					appAuditHistoryDTOs.add(appAuditHistoryDTO);;
 					index++;
 				
 			}
 			
 			return appAuditHistoryDTOs;
 		}
 		else {
 			return null;
 		}
	}

	@Override
	@Transactional
	public List<AssessmentAuditDTO> getApplicationAuditHistory(int assessmentId) {
		List<AssessmentAuditEntity> assessmentAuditEntities = apmHistoryDao.getAssessmentHistory(assessmentId);
		List<AssessmentAuditDTO> assessmentAuditDTOs = new ArrayList<>();
		AssessmentAuditDTO assessmentAuditDTO = null;
		
		for(AssessmentAuditEntity assessmentAuditEntity : assessmentAuditEntities)
		{
			assessmentAuditDTO = new AssessmentAuditDTO();
			try {
				BeanUtils.copyProperties(assessmentAuditDTO, assessmentAuditEntity);
				assessmentAuditDTOs.add(assessmentAuditDTO);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return assessmentAuditDTOs;
	}
	
}
