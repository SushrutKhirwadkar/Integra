package com.soch.Integra.history.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApplicationHistoryDTO {
	
	private String acronym;
	private int applicationId;
	private String name;
	private String divisionName;
	private String odAcronym;
	private String systemOwnerName;
	private String dataOwnerName;
	private String projectManagerName;
	private String isoName;
	private String description;
	private String technicalProjectManagerName;
	private String businessOwnerName;
	private List<String> testerName;
	private List<FiscalYearInfoHistoryDTO> fiscalYearInfoDTOs;
	List<ApplicationDatabaseHistoryDTO> applicationDatabaseDTOs;
	private List<AppAuditHistoryDTO> appAuditDTOs;
	
	private List<ApplicationUserHistoryDTO> appSystemAdminsters;
	private List<ApplicationUserHistoryDTO> appTechnicalManagers;
	private List<ApplicationUserHistoryDTO> appSystemOwners;
	private List<ApplicationUserHistoryDTO> appDataOwners;
	private List<ApplicationUserHistoryDTO> appISOs;
	private List<ApplicationUserHistoryDTO> appDataCustodians;
	private List<ApplicationUserHistoryDTO> developers;
	private List<ApplicationUserHistoryDTO> testers;
	private List<TechnologiesHistoryDTO> technologiesDTOs;
	
	
	private String typeValue;
	
	private String dataCustodianName;
 	private List<TechnologiesHistoryDTO> technologies;
 	private String databaseName;
 	private String databaseTechnologies;
 	private String serverName;
 	private String physicalLocation;
 	private String itSystemInterfaces;
 	private String iTSystemBoundary;
 	private String technologyStatus;
 	private String appStatus;
 	private String dbAdministratorName;
 	
	private Set<ApplicationUserHistoryDTO> developerName;
 	private List<String> developersName;
 	private String systemSensitivity;
 	private String risks;
	
 	private String systemAdministratorName;
 	private int businessAnalyst;
 	private String decisions;
 	
 	private String costType;
 	private String cost;
 	private String consideration;
 	private String updatedBy;
 	private Date updatedTime;
 	
 	private List<ApplDocHistoryDTO> file;
 	private List<ApplDocHistoryDTO> fileContent;
 	
 	private Date lastAudit;
 	private Date upcomingAudit;
 	private String auditComments;
 	
 	

	private int systemOwner;
	private int dataOwner;
	private int status;
	private List<Integer> programmingLanguages;
	private int server;
	private int databaseId;
	private int sectionNumber;
	private int userId;
	private int statusCount;
	
	Set<Integer> sections;
	
	private String keyDecision;
	
	//newly added
	private int systemAdministrator;
	private List<Integer> developer;
	private List<Integer> tester;
	private int dataCustodian;
	private int technicalProjectManager;
	private int projectManager;
	private String businessAnalystName;
	private int dbAdministrator;
	private int projectManagement;
	private int iso;
	private int fiscalYear1;
	private int fiscalYear2;
	private int fiscalYear3;
	private String bOVision1;
	private String bOVision2;
	private String bOVision3;
	private int businessOwner;
	private String systemSensitivityName;
	private int auditId;
	private int costId;
	private int division;
	private int office;
	private String modifiedByName;
	private Date modifiedTs;
	
	private CostHistoryDTO costDTO;
	
	private List<CostHistoryDTO> costDTOs ;
	
	private List<ApplicationServerHistoryDTO> applicationServerDTOs;
 	
	private List<String> appBusinessOwnerList;
 	private String appBusinessOwners;
 	
 	private List<String> appDataOwnerList;
 	private String appDataOwner;
 	
 	private List<String> appProjectManagerList;
 	private String appProjectManager;
 	
 	private List<String> appIsoList;
 	private String appIso;
	
 	private List<String> appSystemOwnerList;
 	private String appSystemOnwer;
 	
 	private List<String> appDataCustodianList;
 	private String appDataCustodian;
	
 	private List<String> appTestersList;
 	private String appTesters;
 	
	
 	private String appDatabases;
 	private List<String> appDatabaseList;
 	
 	
 	private String appServers;
 	private List<String> appServerList;
 	
 	
 	private String appTechnologies;
 	private List<String> appTechnologyList;
 	
	private String appProjectManagers;
 	//Sprivate List<String> appProjectManagerList;
 	
 	private String appSystemAdmins;
 	private List<String> appSystemAdminList;
 	
 	private String appBusinessAnalysts;
 	private List<String> appBusinessAnalystList;
 	
 	private List<String>appDBAdminList;
 	private String  appDBAdmins;
 	
 	private List<String>appDeveloperList;
 	private String  appDevelopers;
 	
 	private List<String> appSecurityRisksList;
 	private String appSecurityRisks;
 	
 	private List<String> appSystemSensitivityList;
 	private String appSystemSensitivity;
 	
 	private List<String> appConsiderationsList;
 	private String appConsiderations;
 	
 	private List<String> appAssessmentsList;
 	private String appAssessments;
 	
 	private String estimatedAmount;
 	
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOdAcronym() {
		return odAcronym;
	}
	public void setOdAcronym(String odAcronym) {
		this.odAcronym = odAcronym;
	}
	public String getSystemOwnerName() {
		return systemOwnerName;
	}
	public void setSystemOwnerName(String systemOwnerName) {
		this.systemOwnerName = systemOwnerName;
	}
	public String getDataOwnerName() {
		return dataOwnerName;
	}
	public void setDataOwnerName(String dataOwnerName) {
		this.dataOwnerName = dataOwnerName;
	}
	public String getProjectManagerName() {
		return projectManagerName;
	}
	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}
	public String getIsoName() {
		return isoName;
	}
	public void setIsoName(String isoName) {
		this.isoName = isoName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<FiscalYearInfoHistoryDTO> getFiscalYearInfoDTOs() {
		return fiscalYearInfoDTOs;
	}
	public void setFiscalYearInfoDTOs(List<FiscalYearInfoHistoryDTO> fiscalYearInfoDTOs) {
		this.fiscalYearInfoDTOs = fiscalYearInfoDTOs;
	}
	public String getDataCustodianName() {
		return dataCustodianName;
	}
	public void setDataCustodianName(String dataCustodianName) {
		this.dataCustodianName = dataCustodianName;
	}
	
	public List<TechnologiesHistoryDTO> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<TechnologiesHistoryDTO> technologies) {
		this.technologies = technologies;
	}
	public Set<ApplicationUserHistoryDTO> getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(Set<ApplicationUserHistoryDTO> developerName) {
		this.developerName = developerName;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getDatabaseTechnologies() {
		return databaseTechnologies;
	}
	public void setDatabaseTechnologies(String databaseTechnologies) {
		this.databaseTechnologies = databaseTechnologies;
	}
	public String getPhysicalLocation() {
		return physicalLocation;
	}
	public void setPhysicalLocation(String physicalLocation) {
		this.physicalLocation = physicalLocation;
	}
	public String getItSystemInterfaces() {
		return itSystemInterfaces;
	}
	public void setItSystemInterfaces(String itSystemInterfaces) {
		this.itSystemInterfaces = itSystemInterfaces;
	}
	public String getiTSystemBoundary() {
		return iTSystemBoundary;
	}
	public void setiTSystemBoundary(String iTSystemBoundary) {
		this.iTSystemBoundary = iTSystemBoundary;
	}
	public String getTechnologyStatus() {
		return technologyStatus;
	}
	public void setTechnologyStatus(String technologyStatus) {
		this.technologyStatus = technologyStatus;
	}
	
	
	public String getSystemSensitivity() {
		return systemSensitivity;
	}
	public void setSystemSensitivity(String systemSensitivity) {
		this.systemSensitivity = systemSensitivity;
	}
	public String getRisks() {
		return risks;
	}
	public void setRisks(String risks) {
		this.risks = risks;
	}
	public String getSystemAdministratorName() {
		return systemAdministratorName;
	}
	public void setSystemAdministratorName(String systemAdministratorName) {
		this.systemAdministratorName = systemAdministratorName;
	}

	public String getDecisions() {
		return decisions;
	}
	public void setDecisions(String decisions) {
		this.decisions = decisions;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getConsideration() {
		return consideration;
	}
	public void setConsideration(String consideration) {
		this.consideration = consideration;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getTechnicalProjectManagerName() {
		return technicalProjectManagerName;
	}
	public void setTechnicalProjectManagerName(String technicalProjectManagerName) {
		this.technicalProjectManagerName = technicalProjectManagerName;
	}
	
	public String getBusinessOwnerName() {
		return businessOwnerName;
	}
	public void setBusinessOwnerName(String businessOwnerName) {
		this.businessOwnerName = businessOwnerName;
	}
	public List<String> getTesterName() {
		return testerName;
	}
	public void setTesterName(List<String> testerName) {
		this.testerName = testerName;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public List<String> getDevelopersName() {
		return developersName;
	}
	public void setDevelopersName(List<String> developersName) {
		this.developersName = developersName;
	}
	public List<ApplDocHistoryDTO> getFile() {
		return file;
	}
	public void setFile(List<ApplDocHistoryDTO> file) {
		this.file = file;
	}
	public List<ApplDocHistoryDTO> getFileContent() {
		return fileContent;
	}
	public void setFileContent(List<ApplDocHistoryDTO> fileContent) {
		this.fileContent = fileContent;
	}
	public Date getLastAudit() {
		return lastAudit;
	}
	public void setLastAudit(Date lastAudit) {
		this.lastAudit = lastAudit;
	}
	public Date getUpcomingAudit() {
		return upcomingAudit;
	}
	public void setUpcomingAudit(Date upcomingAudit) {
		this.upcomingAudit = upcomingAudit;
	}
	public String getAuditComments() {
		return auditComments;
	}
	public void setAuditComments(String auditComments) {
		this.auditComments = auditComments;
	}
	public int getSystemOwner() {
		return systemOwner;
	}
	public void setSystemOwner(int systemOwner) {
		this.systemOwner = systemOwner;
	}
	public int getDataOwner() {
		return dataOwner;
	}
	public void setDataOwner(int dataOwner) {
		this.dataOwner = dataOwner;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public int getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}
	public int getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatusCount() {
		return statusCount;
	}
	public void setStatusCount(int statusCount) {
		this.statusCount = statusCount;
	}
	public Set<Integer> getSections() {
		return sections;
	}
	public void setSections(Set<Integer> sections) {
		this.sections = sections;
	}
	public int getSystemAdministrator() {
		return systemAdministrator;
	}
	public void setSystemAdministrator(int systemAdministrator) {
		this.systemAdministrator = systemAdministrator;
	}
	
	
	public int getDataCustodian() {
		return dataCustodian;
	}
	public void setDataCustodian(int dataCustodian) {
		this.dataCustodian = dataCustodian;
	}
	public int getTechnicalProjectManager() {
		return technicalProjectManager;
	}
	public void setTechnicalProjectManager(int technicalProjectManager) {
		this.technicalProjectManager = technicalProjectManager;
	}
	public int getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}
	
	public int getDbAdministrator() {
		return dbAdministrator;
	}
	public void setDbAdministrator(int dbAdministrator) {
		this.dbAdministrator = dbAdministrator;
	}
	public int getProjectManagement() {
		return projectManagement;
	}
	public void setProjectManagement(int projectManagement) {
		this.projectManagement = projectManagement;
	}
	public int getIso() {
		return iso;
	}
	public void setIso(int iso) {
		this.iso = iso;
	}
	public int getFiscalYear1() {
		return fiscalYear1;
	}
	public void setFiscalYear1(int fiscalYear1) {
		this.fiscalYear1 = fiscalYear1;
	}
	public int getFiscalYear2() {
		return fiscalYear2;
	}
	public void setFiscalYear2(int fiscalYear2) {
		this.fiscalYear2 = fiscalYear2;
	}
	public int getFiscalYear3() {
		return fiscalYear3;
	}
	public void setFiscalYear3(int fiscalYear3) {
		this.fiscalYear3 = fiscalYear3;
	}
	public int getBusinessOwner() {
		return businessOwner;
	}
	public void setBusinessOwner(int businessOwner) {
		this.businessOwner = businessOwner;
	}
	public List<Integer> getProgrammingLanguages() {
		return programmingLanguages;
	}
	public void setProgrammingLanguages(List<Integer> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}

	
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) {
		this.office = office;
	}
	public String getSystemSensitivityName() {
		return systemSensitivityName;
	}
	public void setSystemSensitivityName(String systemSensitivityName) {
		this.systemSensitivityName = systemSensitivityName;
	}
	public int getBusinessAnalyst() {
		return businessAnalyst;
	}
	public void setBusinessAnalyst(int businessAnalyst) {
		this.businessAnalyst = businessAnalyst;
	}
	public String getBusinessAnalystName() {
		return businessAnalystName;
	}
	public void setBusinessAnalystName(String businessAnalystName) {
		this.businessAnalystName = businessAnalystName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	
	public String getDbAdministratorName() {
		return dbAdministratorName;
	}
	public void setDbAdministratorName(String dbAdministratorName) {
		this.dbAdministratorName = dbAdministratorName;
	}
	public String getKeyDecision() {
		return keyDecision;
	}
	public void setKeyDecision(String keyDecision) {
		this.keyDecision = keyDecision;
	}
	public String getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	public String getbOVision1() {
		return bOVision1;
	}
	public void setbOVision1(String bOVision1) {
		this.bOVision1 = bOVision1;
	}
	public String getbOVision2() {
		return bOVision2;
	}
	public void setbOVision2(String bOVision2) {
		this.bOVision2 = bOVision2;
	}
	public String getbOVision3() {
		return bOVision3;
	}
	public void setbOVision3(String bOVision3) {
		this.bOVision3 = bOVision3;
	}
	public CostHistoryDTO getCostDTO() {
		return costDTO;
	}
	public void setCostDTO(CostHistoryDTO costDTO) {
		this.costDTO = costDTO;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public List<AppAuditHistoryDTO> getAppAuditDTOs() {
		return appAuditDTOs;
	}
	public void setAppAuditDTOs(List<AppAuditHistoryDTO> appAuditDTOs) {
		this.appAuditDTOs = appAuditDTOs;
	}
	
	
	public List<ApplicationUserHistoryDTO> getAppSystemAdminsters() {
		return appSystemAdminsters;
	}
	public void setAppSystemAdminsters(List<ApplicationUserHistoryDTO> appSystemAdminsters) {
		this.appSystemAdminsters = appSystemAdminsters;
	}
	
	public List<ApplicationUserHistoryDTO> getAppTechnicalManagers() {
		return appTechnicalManagers;
	}
	public void setAppTechnicalManagers(List<ApplicationUserHistoryDTO> appTechnicalManagers) {
		this.appTechnicalManagers = appTechnicalManagers;
	}
	public List<ApplicationUserHistoryDTO> getAppSystemOwners() {
		return appSystemOwners;
	}
	public void setAppSystemOwners(List<ApplicationUserHistoryDTO> appSystemOwners) {
		this.appSystemOwners = appSystemOwners;
	}
	public List<ApplicationUserHistoryDTO> getAppDataOwners() {
		return appDataOwners;
	}
	public void setAppDataOwners(List<ApplicationUserHistoryDTO> appDataOwners) {
		this.appDataOwners = appDataOwners;
	}
	public List<ApplicationUserHistoryDTO> getAppISOs() {
		return appISOs;
	}
	public void setAppISOs(List<ApplicationUserHistoryDTO> appISOs) {
		this.appISOs = appISOs;
	}
	
	public List<ApplicationUserHistoryDTO> getAppDataCustodians() {
		return appDataCustodians;
	}
	public void setAppDataCustodians(List<ApplicationUserHistoryDTO> appDataCustodians) {
		this.appDataCustodians = appDataCustodians;
	}
	public List<ApplicationUserHistoryDTO> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<ApplicationUserHistoryDTO> developers) {
		this.developers = developers;
	}
	public List<ApplicationUserHistoryDTO> getTesters() {
		return testers;
	}
	public void setTesters(List<ApplicationUserHistoryDTO> testers) {
		this.testers = testers;
	}
	public List<Integer> getDeveloper() {
		return developer;
	}
	public void setDeveloper(List<Integer> developer) {
		this.developer = developer;
	}
	public List<Integer> getTester() {
		return tester;
	}
	public void setTester(List<Integer> tester) {
		this.tester = tester;
	}
	public List<TechnologiesHistoryDTO> getTechnologiesDTOs() {
		return technologiesDTOs;
	}
	public void setTechnologiesDTOs(List<TechnologiesHistoryDTO> technologiesDTOs) {
		this.technologiesDTOs = technologiesDTOs;
	}
	public List<CostHistoryDTO> getCostDTOs() {
		return costDTOs;
	}
	public void setCostDTOs(List<CostHistoryDTO> costDTOs) {
		this.costDTOs = costDTOs;
	}
	public List<ApplicationDatabaseHistoryDTO> getApplicationDatabaseDTOs() {
		return applicationDatabaseDTOs;
	}
	public void setApplicationDatabaseDTOs(List<ApplicationDatabaseHistoryDTO> applicationDatabaseDTOs) {
		this.applicationDatabaseDTOs = applicationDatabaseDTOs;
	}
	public List<ApplicationServerHistoryDTO> getApplicationServerDTOs() {
		return applicationServerDTOs;
	}
	public void setApplicationServerDTOs(List<ApplicationServerHistoryDTO> applicationServerDTOs) {
		this.applicationServerDTOs = applicationServerDTOs;
	}
	public String getModifiedByName() {
		return modifiedByName;
	}
	public void setModifiedByName(String modifiedByName) {
		this.modifiedByName = modifiedByName;
	}
	public Date getModifiedTs() {
		return modifiedTs;
	}
	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}
	public List<String> getAppBusinessOwnerList() {
		return appBusinessOwnerList;
	}
	public void setAppBusinessOwnerList(List<String> appBusinessOwnerList) {
		this.appBusinessOwnerList = appBusinessOwnerList;
	}
	public String getAppBusinessOwners() {
		return appBusinessOwners;
	}
	public void setAppBusinessOwners(String appBusinessOwners) {
		this.appBusinessOwners = appBusinessOwners;
	}
	public List<String> getAppDataOwnerList() {
		return appDataOwnerList;
	}
	public void setAppDataOwnerList(List<String> appDataOwnerList) {
		this.appDataOwnerList = appDataOwnerList;
	}
	public String getAppDataOwner() {
		return appDataOwner;
	}
	public void setAppDataOwner(String appDataOwner) {
		this.appDataOwner = appDataOwner;
	}
	public List<String> getAppProjectManagerList() {
		return appProjectManagerList;
	}
	public void setAppProjectManagerList(List<String> appProjectManagerList) {
		this.appProjectManagerList = appProjectManagerList;
	}
	public String getAppProjectManager() {
		return appProjectManager;
	}
	public void setAppProjectManager(String appProjectManager) {
		this.appProjectManager = appProjectManager;
	}
	public List<String> getAppIsoList() {
		return appIsoList;
	}
	public void setAppIsoList(List<String> appIsoList) {
		this.appIsoList = appIsoList;
	}
	public String getAppIso() {
		return appIso;
	}
	public void setAppIso(String appIso) {
		this.appIso = appIso;
	}
	public List<String> getAppSystemOwnerList() {
		return appSystemOwnerList;
	}
	public void setAppSystemOwnerList(List<String> appSystemOwnerList) {
		this.appSystemOwnerList = appSystemOwnerList;
	}
	public String getAppSystemOnwer() {
		return appSystemOnwer;
	}
	public void setAppSystemOnwer(String appSystemOnwer) {
		this.appSystemOnwer = appSystemOnwer;
	}
	public List<String> getAppDataCustodianList() {
		return appDataCustodianList;
	}
	public void setAppDataCustodianList(List<String> appDataCustodianList) {
		this.appDataCustodianList = appDataCustodianList;
	}
	public String getAppDataCustodian() {
		return appDataCustodian;
	}
	public void setAppDataCustodian(String appDataCustodian) {
		this.appDataCustodian = appDataCustodian;
	}
	public List<String> getAppTestersList() {
		return appTestersList;
	}
	public void setAppTestersList(List<String> appTestersList) {
		this.appTestersList = appTestersList;
	}
	public String getAppTesters() {
		return appTesters;
	}
	public void setAppTesters(String appTesters) {
		this.appTesters = appTesters;
	}
	public List<String> getAppSystemSensitivityList() {
		return appSystemSensitivityList;
	}
	public void setAppSystemSensitivityList(List<String> appSystemSensitivityList) {
		this.appSystemSensitivityList = appSystemSensitivityList;
	}
	public String getAppSystemSensitivity() {
		return appSystemSensitivity;
	}
	public void setAppSystemSensitivity(String appSystemSensitivity) {
		this.appSystemSensitivity = appSystemSensitivity;
	}
	public List<String> getAppSecurityRisksList() {
		return appSecurityRisksList;
	}
	public void setAppSecurityRisksList(List<String> appSecurityRisksList) {
		this.appSecurityRisksList = appSecurityRisksList;
	}
	public String getAppSecurityRisks() {
		return appSecurityRisks;
	}
	public void setAppSecurityRisks(String appSecurityRisks) {
		this.appSecurityRisks = appSecurityRisks;
	}
	public List<String> getAppConsiderationsList() {
		return appConsiderationsList;
	}
	public void setAppConsiderationsList(List<String> appConsiderationsList) {
		this.appConsiderationsList = appConsiderationsList;
	}
	public String getAppConsiderations() {
		return appConsiderations;
	}
	public void setAppConsiderations(String appConsiderations) {
		this.appConsiderations = appConsiderations;
	}
	public List<String> getAppAssessmentsList() {
		return appAssessmentsList;
	}
	public void setAppAssessmentsList(List<String> appAssessmentsList) {
		this.appAssessmentsList = appAssessmentsList;
	}
	public String getAppAssessments() {
		return appAssessments;
	}
	public void setAppAssessments(String appAssessments) {
		this.appAssessments = appAssessments;
	}
	
	public String getAppDatabases() {
		return appDatabases;
	}
	public void setAppDatabases(String appDatabases) {
		this.appDatabases = appDatabases;
	}
	public List<String> getAppDatabaseList() {
		return appDatabaseList;
	}
	public void setAppDatabaseList(List<String> appDatabaseList) {
		this.appDatabaseList = appDatabaseList;
	}
	public String getAppServers() {
		return appServers;
	}
	public void setAppServers(String appServers) {
		this.appServers = appServers;
	}
	public List<String> getAppServerList() {
		return appServerList;
	}
	public void setAppServerList(List<String> appServerList) {
		this.appServerList = appServerList;
	}
	public String getAppTechnologies() {
		return appTechnologies;
	}
	public void setAppTechnologies(String appTechnologies) {
		this.appTechnologies = appTechnologies;
	}
	public List<String> getAppTechnologyList() {
		return appTechnologyList;
	}
	public void setAppTechnologyList(List<String> appTechnologyList) {
		this.appTechnologyList = appTechnologyList;
	}
	public String getAppProjectManagers() {
		return appProjectManagers;
	}
	public void setAppProjectManagers(String appProjectManagers) {
		this.appProjectManagers = appProjectManagers;
	}
	public String getAppSystemAdmins() {
		return appSystemAdmins;
	}
	public void setAppSystemAdmins(String appSystemAdmins) {
		this.appSystemAdmins = appSystemAdmins;
	}
	public List<String> getAppSystemAdminList() {
		return appSystemAdminList;
	}
	public void setAppSystemAdminList(List<String> appSystemAdminList) {
		this.appSystemAdminList = appSystemAdminList;
	}
	public String getAppBusinessAnalysts() {
		return appBusinessAnalysts;
	}
	public void setAppBusinessAnalysts(String appBusinessAnalysts) {
		this.appBusinessAnalysts = appBusinessAnalysts;
	}
	public List<String> getAppBusinessAnalystList() {
		return appBusinessAnalystList;
	}
	public void setAppBusinessAnalystList(List<String> appBusinessAnalystList) {
		this.appBusinessAnalystList = appBusinessAnalystList;
	}
	public List<String> getAppDBAdminList() {
		return appDBAdminList;
	}
	public void setAppDBAdminList(List<String> appDBAdminList) {
		this.appDBAdminList = appDBAdminList;
	}
	public String getAppDBAdmins() {
		return appDBAdmins;
	}
	public void setAppDBAdmins(String appDBAdmins) {
		this.appDBAdmins = appDBAdmins;
	}
	public List<String> getAppDeveloperList() {
		return appDeveloperList;
	}
	public void setAppDeveloperList(List<String> appDeveloperList) {
		this.appDeveloperList = appDeveloperList;
	}
	public String getAppDevelopers() {
		return appDevelopers;
	}
	public void setAppDevelopers(String appDevelopers) {
		this.appDevelopers = appDevelopers;
	}
	public String getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}
}