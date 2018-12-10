package com.soch.Integra.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApplicationViewDTO {
	
	private String acronym;
	private Integer applicationId;
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
	private List<FiscalYearInfoDTO> fiscalYearInfoDTOs;
	List<ApplicationDatabaseDTO> applicationDatabaseDTOs;
	private List<AppAuditDTO> appAuditDTOs;
	private List<ApplicationUserDTO> appDBAdmins;
	private List<ApplicationUserDTO> appBusinessOwners;
	private List<ApplicationUserDTO> appSystemAdminsters;
	private List<ApplicationUserDTO> appProjectManagers;
	private List<ApplicationUserDTO> appTechnicalManagers;
	private List<ApplicationUserDTO> appSystemOwners;
	private List<ApplicationUserDTO> appDataOwners;
	private List<ApplicationUserDTO> appISOs;
	private List<ApplicationUserDTO> appBusinessAnalysts;
	private List<ApplicationUserDTO> appDataCustodians;
	private List<ApplicationUserDTO> developers;
	private List<ApplicationUserDTO> testers;
	private List<TechnologiesDTO> technologiesDTOs;
	private List<AttachmentDTO> attachments;
	private List<AssessmentDTO> assessmentDTOs;
	private Integer technologyId;
	
	private String typeValue;
	
	private String dataCustodianName;
 	private List<TechnologiesDTO> technologies;
 	private String databaseName;
 	private String databaseTechnologies;
 	private String serverName;
 	private String physicalLocation;
 	private String itSystemInterfaces;
 	private String iTSystemBoundary;
 	private String technologyStatus;
 	private String appStatus;
 	private String dbAdministratorName;
 	
	private Set<ApplicationUserDTO> developerName;
 	private List<String> developersName;
 	private Integer systemSensitivity;
 	private String risks;
	private Integer database;
	
 	private String systemAdministratorName;
 	private Integer businessAnalyst;
 	private String decisions;
 	
 	private String costType;
 	private String cost;
 	private String consideration;
 	private String updatedBy;
 	private Date updatedTime;
 	
 	private List<ApplDocDTO> file;
 	private List<ApplDocDTO> fileContent;
 	
 	private Date lastAudit;
 	private Date upcomingAudit;
 	private String auditComments;
 	
 	private String businessOwnerNameDoe;
	private String systemOwnerNameDoe;

	private Integer systemOwner;
	private Integer dataOwner;
	private Integer status;
	private List<Integer> programmingLanguages;
	private Integer server;
	private Integer databaseId;
	private Integer sectionNumber;
	private Integer userId;
	private Integer statusCount;
	
	Set<Integer> sections;
	
	private String keyDecision;
	
	//newly added
	private Integer systemAdministrator;
	private List<Integer> developer;
	private List<Integer> tester;
	private Integer dataCustodian;
	private Integer technicalProjectManager;
	private Integer projectManager;
	private String businessAnalystName;
	private Integer dbAdministrator;
	private Integer projectManagement;
	private Integer iso;
	private Integer fiscalYear1;
	private Integer fiscalYear2;
	private Integer fiscalYear3;

	private Integer businessOwner;
	private String systemSensitivityName;
	private Integer auditId;
	private Integer costId;
	private Integer division;
	private Integer office;
	private String modifiedByName;
	private Date modifiedTs;
	
	private String boVision1;
	private String boVision2;
	private String boVision3;
	private String securityAssessments;
	
	private CostDTO costDTO;
	
	private List<CostDTO> costDTOs ;
	
	private List<ApplicationServerDTO> applicationServerDTOs;
 	
 	private String levelOfEffort;
 	private String internalInterfaces;
	private String externalInterfaces;
 	
	private Set<ApplDocDTO> applDocDTOs = new HashSet<ApplDocDTO>(0);
	
	private List<MOUDTO> moudtos;
	
	private List<ApplicationSolutionDTO> applicationSolutionDTOs;
	
	private String localityCd;
	private String fipsCd;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private String website;
	private String verisId;
	private boolean capInd;
	private boolean bailoutInd;
	private String penality;
	private boolean vebaRegion;
	private boolean vravRegion;
	private boolean paperPollbook;
	private boolean electronicPollbook;
	private String notes;
	private List<WorkHoursDTO> workHoursDTOs;
	private int activeLocality;
	
	
	
	
	public List<ApplicationSolutionDTO> getApplicationSolutionDTOs() {
		return applicationSolutionDTOs;
	}
	public void setApplicationSolutionDTOs(List<ApplicationSolutionDTO> applicationSolutionDTOs) {
		this.applicationSolutionDTOs = applicationSolutionDTOs;
	}
	public List<MOUDTO> getMoudtos() {
		return moudtos;
	}
	public void setMoudtos(List<MOUDTO> moudtos) {
		this.moudtos = moudtos;
	}
	private Double estimatedCost;
	
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
	public List<FiscalYearInfoDTO> getFiscalYearInfoDTOs() {
		return fiscalYearInfoDTOs;
	}
	public void setFiscalYearInfoDTOs(List<FiscalYearInfoDTO> fiscalYearInfoDTOs) {
		this.fiscalYearInfoDTOs = fiscalYearInfoDTOs;
	}
	public String getDataCustodianName() {
		return dataCustodianName;
	}
	public void setDataCustodianName(String dataCustodianName) {
		this.dataCustodianName = dataCustodianName;
	}
	
	public List<TechnologiesDTO> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<TechnologiesDTO> technologies) {
		this.technologies = technologies;
	}
	public Set<ApplicationUserDTO> getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(Set<ApplicationUserDTO> developerName) {
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
	
	
	public Integer getSystemSensitivity() {
		return systemSensitivity;
	}
	public void setSystemSensitivity(int systemSensitivity) {
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
	public List<ApplDocDTO> getFile() {
		return file;
	}
	public void setFile(List<ApplDocDTO> file) {
		this.file = file;
	}
	public List<ApplDocDTO> getFileContent() {
		return fileContent;
	}
	public void setFileContent(List<ApplDocDTO> fileContent) {
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
	public Integer getSystemOwner() {
		return systemOwner;
	}
	public void setSystemOwner(int systemOwner) {
		this.systemOwner = systemOwner;
	}
	public Integer getDataOwner() {
		return dataOwner;
	}
	public void setDataOwner(int dataOwner) {
		this.dataOwner = dataOwner;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Integer getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public Integer getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(int databaseId) {
		this.databaseId = databaseId;
	}
	public Integer getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Integer getStatusCount() {
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
	public Integer getSystemAdministrator() {
		return systemAdministrator;
	}
	public void setSystemAdministrator(int systemAdministrator) {
		this.systemAdministrator = systemAdministrator;
	}
	
	
	public Integer getDataCustodian() {
		return dataCustodian;
	}
	public void setDataCustodian(int dataCustodian) {
		this.dataCustodian = dataCustodian;
	}
	public Integer getTechnicalProjectManager() {
		return technicalProjectManager;
	}
	public void setTechnicalProjectManager(int technicalProjectManager) {
		this.technicalProjectManager = technicalProjectManager;
	}
	public Integer getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}
	
	public Integer getDbAdministrator() {
		return dbAdministrator;
	}
	public void setDbAdministrator(int dbAdministrator) {
		this.dbAdministrator = dbAdministrator;
	}
	public Integer getProjectManagement() {
		return projectManagement;
	}
	public void setProjectManagement(int projectManagement) {
		this.projectManagement = projectManagement;
	}
	public Integer getIso() {
		return iso;
	}
	public void setIso(int iso) {
		this.iso = iso;
	}
	public Integer getFiscalYear1() {
		return fiscalYear1;
	}
	public void setFiscalYear1(int fiscalYear1) {
		this.fiscalYear1 = fiscalYear1;
	}
	public Integer getFiscalYear2() {
		return fiscalYear2;
	}
	public void setFiscalYear2(int fiscalYear2) {
		this.fiscalYear2 = fiscalYear2;
	}
	public Integer getFiscalYear3() {
		return fiscalYear3;
	}
	public void setFiscalYear3(int fiscalYear3) {
		this.fiscalYear3 = fiscalYear3;
	}
	public Integer getBusinessOwner() {
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
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}

	
	public Integer getOffice() {
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
	public Integer getBusinessAnalyst() {
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
	public Integer getDivision() {
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

	public CostDTO getCostDTO() {
		return costDTO;
	}
	public void setCostDTO(CostDTO costDTO) {
		this.costDTO = costDTO;
	}
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public List<AppAuditDTO> getAppAuditDTOs() {
		return appAuditDTOs;
	}
	public void setAppAuditDTOs(List<AppAuditDTO> appAuditDTOs) {
		this.appAuditDTOs = appAuditDTOs;
	}
	public List<ApplicationUserDTO> getAppDBAdmins() {
		return appDBAdmins;
	}
	public void setAppDBAdmins(List<ApplicationUserDTO> appDBAdmins) {
		this.appDBAdmins = appDBAdmins;
	}
	public List<ApplicationUserDTO> getAppBusinessOwners() {
		return appBusinessOwners;
	}
	public void setAppBusinessOwners(List<ApplicationUserDTO> appBusinessOwners) {
		this.appBusinessOwners = appBusinessOwners;
	}
	public List<ApplicationUserDTO> getAppSystemAdminsters() {
		return appSystemAdminsters;
	}
	public void setAppSystemAdminsters(List<ApplicationUserDTO> appSystemAdminsters) {
		this.appSystemAdminsters = appSystemAdminsters;
	}
	public List<ApplicationUserDTO> getAppProjectManagers() {
		return appProjectManagers;
	}
	public void setAppProjectManagers(List<ApplicationUserDTO> appProjectManagers) {
		this.appProjectManagers = appProjectManagers;
	}
	public List<ApplicationUserDTO> getAppTechnicalManagers() {
		return appTechnicalManagers;
	}
	public void setAppTechnicalManagers(List<ApplicationUserDTO> appTechnicalManagers) {
		this.appTechnicalManagers = appTechnicalManagers;
	}
	public List<ApplicationUserDTO> getAppSystemOwners() {
		return appSystemOwners;
	}
	public void setAppSystemOwners(List<ApplicationUserDTO> appSystemOwners) {
		this.appSystemOwners = appSystemOwners;
	}
	public List<ApplicationUserDTO> getAppDataOwners() {
		return appDataOwners;
	}
	public void setAppDataOwners(List<ApplicationUserDTO> appDataOwners) {
		this.appDataOwners = appDataOwners;
	}
	public List<ApplicationUserDTO> getAppISOs() {
		return appISOs;
	}
	public void setAppISOs(List<ApplicationUserDTO> appISOs) {
		this.appISOs = appISOs;
	}
	public List<ApplicationUserDTO> getAppBusinessAnalysts() {
		return appBusinessAnalysts;
	}
	public void setAppBusinessAnalysts(List<ApplicationUserDTO> appBusinessAnalysts) {
		this.appBusinessAnalysts = appBusinessAnalysts;
	}
	public List<ApplicationUserDTO> getAppDataCustodians() {
		return appDataCustodians;
	}
	public void setAppDataCustodians(List<ApplicationUserDTO> appDataCustodians) {
		this.appDataCustodians = appDataCustodians;
	}
	public List<ApplicationUserDTO> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<ApplicationUserDTO> developers) {
		this.developers = developers;
	}
	public List<ApplicationUserDTO> getTesters() {
		return testers;
	}
	public void setTesters(List<ApplicationUserDTO> testers) {
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
	public List<TechnologiesDTO> getTechnologiesDTOs() {
		return technologiesDTOs;
	}
	public void setTechnologiesDTOs(List<TechnologiesDTO> technologiesDTOs) {
		this.technologiesDTOs = technologiesDTOs;
	}
	public List<CostDTO> getCostDTOs() {
		return costDTOs;
	}
	public void setCostDTOs(List<CostDTO> costDTOs) {
		this.costDTOs = costDTOs;
	}
	public List<ApplicationDatabaseDTO> getApplicationDatabaseDTOs() {
		return applicationDatabaseDTOs;
	}
	public void setApplicationDatabaseDTOs(List<ApplicationDatabaseDTO> applicationDatabaseDTOs) {
		this.applicationDatabaseDTOs = applicationDatabaseDTOs;
	}
	public List<ApplicationServerDTO> getApplicationServerDTOs() {
		return applicationServerDTOs;
	}
	public void setApplicationServerDTOs(List<ApplicationServerDTO> applicationServerDTOs) {
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
	public String getLevelOfEffort() {
		return levelOfEffort;
	}
	public void setLevelOfEffort(String levelOfEffort) {
		this.levelOfEffort = levelOfEffort;
	}
	public String getBoVision1() {
		return boVision1;
	}
	public void setBoVision1(String boVision1) {
		this.boVision1 = boVision1;
	}
	public String getBoVision2() {
		return boVision2;
	}
	public void setBoVision2(String boVision2) {
		this.boVision2 = boVision2;
	}
	public String getBoVision3() {
		return boVision3;
	}
	public void setBoVision3(String boVision3) {
		this.boVision3 = boVision3;
	}
	public String getSecurityAssessments() {
		return securityAssessments;
	}
	public void setSecurityAssessments(String securityAssessments) {
		this.securityAssessments = securityAssessments;
	}
	public Set<ApplDocDTO> getApplDocDTOs() {
		return applDocDTOs;
	}
	public void setApplDocDTOs(Set<ApplDocDTO> applDocDTOs) {
		this.applDocDTOs = applDocDTOs;
	}
	public List<AttachmentDTO> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AttachmentDTO> attachments) {
		this.attachments = attachments;
	}
	public Integer getDatabase() {
		return database;
	}
	public void setDatabase(int database) {
		this.database = database;
	}
	public Integer getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public String getExternalInterfaces() {
		return externalInterfaces;
	}
	public void setExternalInterfaces(String externalInterfaces) {
		this.externalInterfaces = externalInterfaces;
	}
	public String getInternalInterfaces() {
		return internalInterfaces;
	}
	public void setInternalInterfaces(String internalInterfaces) {
		this.internalInterfaces = internalInterfaces;
	}
	public Double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public List<AssessmentDTO> getAssessmentDTOs() {
		return assessmentDTOs;
	}
	public void setAssessmentDTOs(List<AssessmentDTO> assessmentDTOs) {
		this.assessmentDTOs = assessmentDTOs;
	}
	public String getLocalityCd() {
		return localityCd;
	}
	public void setLocalityCd(String localityCd) {
		this.localityCd = localityCd;
	}
	public String getFipsCd() {
		return fipsCd;
	}
	public void setFipsCd(String fipsCd) {
		this.fipsCd = fipsCd;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getVerisId() {
		return verisId;
	}
	public void setVerisId(String verisId) {
		this.verisId = verisId;
	}
	public boolean isCapInd() {
		return capInd;
	}
	public void setCapInd(boolean capInd) {
		this.capInd = capInd;
	}
	public boolean isBailoutInd() {
		return bailoutInd;
	}
	public void setBailoutInd(boolean bailoutInd) {
		this.bailoutInd = bailoutInd;
	}
	public String getPenality() {
		return penality;
	}
	public void setPenality(String penality) {
		this.penality = penality;
	}
	public boolean isVebaRegion() {
		return vebaRegion;
	}
	public void setVebaRegion(boolean vebaRegion) {
		this.vebaRegion = vebaRegion;
	}
	public boolean isVravRegion() {
		return vravRegion;
	}
	public void setVravRegion(boolean vravRegion) {
		this.vravRegion = vravRegion;
	}
	public boolean isPaperPollbook() {
		return paperPollbook;
	}
	public void setPaperPollbook(boolean paperPollbook) {
		this.paperPollbook = paperPollbook;
	}
	public boolean isElectronicPollbook() {
		return electronicPollbook;
	}
	public void setElectronicPollbook(boolean electronicPollbook) {
		this.electronicPollbook = electronicPollbook;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public List<WorkHoursDTO> getWorkHoursDTOs() {
		return workHoursDTOs;
	}
	public void setWorkHoursDTOs(List<WorkHoursDTO> workHoursDTOs) {
		this.workHoursDTOs = workHoursDTOs;
	}
	
	public int getActiveLocality() {
		return activeLocality;
	}
	public void setActiveLocality(int activeLocality) {
		this.activeLocality = activeLocality;
	}
	public String getBusinessOwnerNameDoe() {
		return businessOwnerNameDoe;
	}
	public void setBusinessOwnerNameDoe(String businessOwnerNameDoe) {
		this.businessOwnerNameDoe = businessOwnerNameDoe;
	}
	public String getSystemOwnerNameDoe() {
		return systemOwnerNameDoe;
	}
	public void setSystemOwnerNameDoe(String systemOwnerNameDoe) {
		this.systemOwnerNameDoe = systemOwnerNameDoe;
	}
	
	
}