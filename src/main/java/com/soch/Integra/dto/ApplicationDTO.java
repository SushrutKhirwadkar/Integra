
package com.soch.Integra.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApplicationDTO {

	
	private int applicationId;
	private int office;
	private int division;
	private int systemOwner;
	private int dataOwner;
	private int status;
	private int programmingLanguages[];
	private List<TechnologiesDTO> technologiesDTOs;
	private int server;
	private int database;
	private int sectionNumber;
	private int userId;
	private int statusCount;
	private int activeLocality;
	private String divisionName;
	private String odAcronym;
	Set<Integer> sections;
	
	//newly added
	private int developer;
	private int tester;
	private int systemAdministrator;
	private List<ApplicationUserDTO> developers;
	private List<ApplicationUserDTO> testers;
	private int dataCustodian;
	private int technicalProjectManager;
	private int projectManager;
	private int businessAnalyst;
	private int dbAdministrator;
	
	private int iso;
	private int fiscalYear1;
	private int fiscalYear2;
	private int fiscalYear3;
	private String boVision1;
	private String boVision2;
	private String boVision3;
	private String securityAssessments;
	
	private String developerName;
	private String dbAdministratorName;
	private String dataCustodianName;
	
	
////
	private Set<DatabaseDTO> databaseDTOs;
	private Set<ServerDTO> serverDTOs;
	
	private DivisionDTO divisionTbl;
	private OfficeDTO officeTbl;
	private String statusTbl;
	private String systemSensitivityTbl;
	private String projectManagerName;
	private String createdByName;
	private String isoName;
	private String approvedByName;
	private String technicalProjectManagerName;
	private String updatedByName;
	private String dataOwnerName;
	private String systemOwnerName;
	private String modifiedByName;
	private String acronym;
	private String name;
	private Date updatedTs;
	private String description;
	private String technologyStatus;
	private String risks;
	private String consideration;
	private String decisions;
	private Date approvedDate;
	private String physicalLocation;
	private String itSystemInterfaces;
	private String iTSystemBoundary;
	private String systemAdministratorName;
	private Date createdTs;
	private Date modifiedTs;
	
	private String keyDecision;
	private int systemSensitivity;
	private String costType;
	private Double cost;
	private String recommendation;
	
	private List<AttachmentDTO> attachments;
	
	private int audit;
	
	private Date lastAudit;
 	private Date upcomingAudit;
 	private String auditComments;
	
	
	private int businessOwner;
	private String businessOwnerName;
	
	private CostDTO costDTO = null;
	private List<FiscalYearInfoDTO> fiscalYearInfoDTOs = new ArrayList<FiscalYearInfoDTO>(0);
	private Set<ApplDocDTO> applDocDTOs = new HashSet<ApplDocDTO>(0);
	private Set<ApplicationDatabaseDTO> applicationDatabaseDTOs = new HashSet<ApplicationDatabaseDTO>(0);
	private Set<ApplicationServerDTO> applicationServerDTOs = new HashSet<ApplicationServerDTO>(0);
/*	private Set<AppBusinessAnalystDTO> appBusinessAnalystDTOs = new HashSet<AppBusinessAnalystDTO>(0);
	private Set<AppDevelopersDTO> appDevelopersDTOs = new HashSet<AppDevelopersDTO>(0);*/
	private Set<MoaDTO> moaDTOs = new HashSet<MoaDTO>(0);
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
	
	private List<MOUDTO> moudtos;
	
	private String levelOfEffort;
	
	private String internalInterfaces;
	private String externalInterfaces;
	private Double estimatedCost;
	
	private List<ApplicationSolutionDTO> applicationSolutionDTOs;
	
	private String businessOwnerNameDoe;
	private String systemOwnerNameDoe;
	
	
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
	
	private String updatedBy;
	private String createdBy;
	private String modifiedBy;

	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public DivisionDTO getDivisionTbl() {
		return divisionTbl;
	}
	public void setDivisionTbl(DivisionDTO divisionTbl) {
		this.divisionTbl = divisionTbl;
	}
	public OfficeDTO getOfficeTbl() {
		return officeTbl;
	}
	public void setOfficeTbl(OfficeDTO officeTbl) {
		this.officeTbl = officeTbl;
	}
	public String getStatusTbl() {
		return statusTbl;
	}
	public void setStatusTbl(String statusTbl) {
		this.statusTbl = statusTbl;
	}
	public String getSystemSensitivityTbl() {
		return systemSensitivityTbl;
	}
	public void setSystemSensitivityTbl(String systemSensitivityTbl) {
		this.systemSensitivityTbl = systemSensitivityTbl;
	}
	public String getProjectManagerName() {
		return projectManagerName;
	}
	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public String getIsoName() {
		return isoName;
	}
	public void setIsoName(String isoName) {
		this.isoName = isoName;
	}
	public String getApprovedByName() {
		return approvedByName;
	}
	public void setApprovedByName(String approvedByName) {
		this.approvedByName = approvedByName;
	}
	public String getTechnicalProjectManagerName() {
		return technicalProjectManagerName;
	}
	public void setTechnicalProjectManagerName(String technicalProjectManagerName) {
		this.technicalProjectManagerName = technicalProjectManagerName;
	}
	public String getUpdatedByName() {
		return updatedByName;
	}
	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}
	public String getDataOwnerName() {
		return dataOwnerName;
	}
	public void setDataOwnerName(String dataOwnerName) {
		this.dataOwnerName = dataOwnerName;
	}
	public String getSystemOwnerName() {
		return systemOwnerName;
	}
	public void setSystemOwnerName(String systemOwnerName) {
		this.systemOwnerName = systemOwnerName;
	}
	public String getModifiedByName() {
		return modifiedByName;
	}
	public void setModifiedByName(String modifiedByName) {
		this.modifiedByName = modifiedByName;
	}
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
	public Date getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnologyStatus() {
		return technologyStatus;
	}
	public void setTechnologyStatus(String technologyStatus) {
		this.technologyStatus = technologyStatus;
	}
	public String getRisks() {
		return risks;
	}
	public void setRisks(String risks) {
		this.risks = risks;
	}
	public String getConsideration() {
		return consideration;
	}
	public void setConsideration(String consideration) {
		this.consideration = consideration;
	}
	public String getDecisions() {
		return decisions;
	}
	public void setDecisions(String decisions) {
		this.decisions = decisions;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getPhysicalLocation() {
		return physicalLocation;
	}
	public void setPhysicalLocation(String physicalLocation) {
		this.physicalLocation = physicalLocation;
	}
	
	public String getSystemAdministratorName() {
		return systemAdministratorName;
	}
	public void setSystemAdministratorName(String systemAdministratorName) {
		this.systemAdministratorName = systemAdministratorName;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public Date getModifiedTs() {
		return modifiedTs;
	}
	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}
	
	
	public Set<ApplDocDTO> getApplDocDTOs() {
		return applDocDTOs;
	}
	public void setApplDocDTOs(Set<ApplDocDTO> applDocDTOs) {
		this.applDocDTOs = applDocDTOs;
	}
	public Set<ApplicationDatabaseDTO> getApplicationDatabaseDTOs() {
		return applicationDatabaseDTOs;
	}
	public void setApplicationDatabaseDTOs(Set<ApplicationDatabaseDTO> applicationDatabaseDTOs) {
		this.applicationDatabaseDTOs = applicationDatabaseDTOs;
	}
	public Set<ApplicationServerDTO> getApplicationServerDTOs() {
		return applicationServerDTOs;
	}
	public void setApplicationServerDTOs(Set<ApplicationServerDTO> applicationServerDTOs) {
		this.applicationServerDTOs = applicationServerDTOs;
	}
	public Set<MoaDTO> getMoaDTOs() {
		return moaDTOs;
	}
	public void setMoaDTOs(Set<MoaDTO> moaDTOs) {
		this.moaDTOs = moaDTOs;
	}
	
	
	
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) {
		this.office = office;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
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
	public int[] getProgrammingLanguages() {
		return programmingLanguages;
	}
	public void setProgrammingLanguages(int[] programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public int getDatabase() {
		return database;
	}
	public void setDatabase(int database) {
		this.database = database;
	}
	public int getSystemAdministrator() {
		return systemAdministrator;
	}
	public void setSystemAdministrator(int systemAdministrator) {
		this.systemAdministrator = systemAdministrator;
	}
	public List<ApplicationUserDTO>getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<ApplicationUserDTO> developers) {
		this.developers = developers;
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
	public int getBusinessAnalyst() {
		return businessAnalyst;
	}
	public void setBusinessAnalyst(int businessAnalyst) {
		this.businessAnalyst = businessAnalyst;
	}
	public int getDbAdministrator() {
		return dbAdministrator;
	}
	public void setDbAdministrator(int dbAdministrator) {
		this.dbAdministrator = dbAdministrator;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public String getDataCustodianName() {
		return dataCustodianName;
	}
	public void setDataCustodianName(String dataCustodianName) {
		this.dataCustodianName = dataCustodianName;
	}
	public String getDbAdministratorName() {
		return dbAdministratorName;
	}
	public void setDbAdministratorName(String dbAdministratorName) {
		this.dbAdministratorName = dbAdministratorName;
	}
	public List<ApplicationUserDTO> getTesters() {
		return testers;
	}
	public void setTesters(List<ApplicationUserDTO> testers) {
		this.testers = testers;
	}
	public Set<DatabaseDTO> getDatabaseDTOs() {
		return databaseDTOs;
	}
	public void setDatabaseDTOs(Set<DatabaseDTO> databaseDTOs) {
		this.databaseDTOs = databaseDTOs;
	}
	public Set<ServerDTO> getServerDTOs() {
		return serverDTOs;
	}
	public void setServerDTOs(Set<ServerDTO> serverDTOs) {
		this.serverDTOs = serverDTOs;
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
	public String getKeyDecision() {
		return keyDecision;
	}
	public void setKeyDecision(String keyDecision) {
		this.keyDecision = keyDecision;
	}
	public int getSystemSensitivity() {
		return systemSensitivity;
	}
	public void setSystemSensitivity(int systemSensitivity) {
		this.systemSensitivity = systemSensitivity;
	}
	
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	public int getBusinessOwner() {
		return businessOwner;
	}
	public void setBusinessOwner(int businessOwner) {
		this.businessOwner = businessOwner;
	}
	public String getBusinessOwnerName() {
		return businessOwnerName;
	}
	public void setBusinessOwnerName(String businessOwnerName) {
		this.businessOwnerName = businessOwnerName;
	}
	public List<AttachmentDTO> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AttachmentDTO> attachments) {
		this.attachments = attachments;
	}
	public int getAudit() {
		return audit;
	}
	public void setAudit(int audit) {
		this.audit = audit;
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
	public List<FiscalYearInfoDTO> getFiscalYearInfoDTOs() {
		return fiscalYearInfoDTOs;
	}
	public void setFiscalYearInfoDTOs(List<FiscalYearInfoDTO> fiscalYearInfoDTOs) {
		this.fiscalYearInfoDTOs = fiscalYearInfoDTOs;
	}
	public CostDTO getCostDTO() {
		return costDTO;
	}
	public void setCostDTO(CostDTO costDTO) {
		this.costDTO = costDTO;
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
	public List<AppAuditDTO> getAppAuditDTOs() {
		return appAuditDTOs;
	}
	public void setAppAuditDTOs(List<AppAuditDTO> appAuditDTOs) {
		this.appAuditDTOs = appAuditDTOs;
	}
	public List<TechnologiesDTO> getTechnologiesDTOs() {
		return technologiesDTOs;
	}
	public void setTechnologiesDTOs(List<TechnologiesDTO> technologiesDTOs) {
		this.technologiesDTOs = technologiesDTOs;
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
	public int getDeveloper() {
		return developer;
	}
	public void setDeveloper(int developer) {
		this.developer = developer;
	}
	public int getTester() {
		return tester;
	}
	public void setTester(int tester) {
		this.tester = tester;
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
	public String getLevelOfEffort() {
		return levelOfEffort;
	}
	public void setLevelOfEffort(String levelOfEffort) {
		this.levelOfEffort = levelOfEffort;
	}
	public String getSecurityAssessments() {
		return securityAssessments;
	}
	public void setSecurityAssessments(String securityAssessments) {
		this.securityAssessments = securityAssessments;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getOdAcronym() {
		return odAcronym;
	}
	public void setOdAcronym(String odAcronym) {
		this.odAcronym = odAcronym;
	}
	public String getInternalInterfaces() {
		return internalInterfaces;
	}
	public void setInternalInterfaces(String internalInterfaces) {
		this.internalInterfaces = internalInterfaces;
	}
	public String getExternalInterfaces() {
		return externalInterfaces;
	}
	public void setExternalInterfaces(String externalInterfaces) {
		this.externalInterfaces = externalInterfaces;
	}
	public Double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public List<MOUDTO> getMoudtos() {
		return moudtos;
	}
	public void setMoudtos(List<MOUDTO> moudtos) {
		this.moudtos = moudtos;
	}
	public List<ApplicationSolutionDTO> getApplicationSolutionDTOs() {
		return applicationSolutionDTOs;
	}
	public void setApplicationSolutionDTOs(List<ApplicationSolutionDTO> applicationSolutionDTOs) {
		this.applicationSolutionDTOs = applicationSolutionDTOs;
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
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}