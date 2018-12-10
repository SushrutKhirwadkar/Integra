package com.soch.Integra.entities;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * ApplicationEntity generated by hbm2java
 */
@Entity
@Table(name = "application_tbl")
public class ApplicationEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3601225137381670676L;
	private int applicationId;
	private DivisionEntity divisionEntity;
	private OfficeEntity officeEntity;
	private StatusEntity statusEntity;
	private SystemSensitivityEntity systemSensitivityEntity;
	private String acronym;
	private String name;
	private Date updatedTs;
	private byte[] description;
	private byte[] technologyStatus;
	private byte[] risks;
	private byte[] consideration;
	private String decisions;
	private Date approvedDate;
	private String physicalLocation;
	private String systemInterfaces;
	private String systemBoundary;
	private UserEntity systemAdministrator;
	private Date createdTs;
	private String levelOfEffort;
	private String securityAssessments;
	private String boVision1;
	private String boVision2;
	private String boVision3;
	private int fiscalYear1;
	private int fiscalYear2;
	private int fiscalYear3;
	
	

	private UserEntity userEntityByProjectManager;
	private UserEntity userEntityByIso;
	private UserEntity userEntityByApprovedBy;
	private UserEntity userEntityByTechnicalProjectManager;
	private UserEntity userEntityBySystemOwner;
	private UserEntity userEntityByDataOwner;
	private UserEntity userEntityByBusinessOwner;
	private UserEntity userEntityByDbAdministrator;
	private UserEntity userEntityByDataCustodian;
	
	private String updatedBy;
	private String createdBy;
	private String modifiedBy;
	
	private Set<AppStatusEntity> appStatusEntities;
	
	private Set<CostEntity> costEntities= new HashSet<CostEntity>(0);
	private List<FiscalYearInfoEntity> fiscalYearInfoEntities = new ArrayList<FiscalYearInfoEntity>(0);
	private Set<ApplDocEntity> applDocEntities = new HashSet<ApplDocEntity>(0);
	private Set<ApplicationDatabaseEntity> applicationDatabaseEntities = new HashSet<ApplicationDatabaseEntity>(0);
	private Set<ApplicationServerEntity> applicationServerEntities = new HashSet<ApplicationServerEntity>(0);
	private Set<AppBusinessAnalystEntity> appBusinessAnalystEntities = new HashSet<AppBusinessAnalystEntity>(0);
	private Set<AppDevelopersEntity> appDevelopersEntities = new HashSet<AppDevelopersEntity>(0);
	private Set<AppTesterEntity> appTesterEntities = new HashSet<AppTesterEntity>(0);
	private Set<MoaEntity> moaEntities = new HashSet<MoaEntity>(0);
	private Set<ApplicationTechnologyEntity> applicationTechnologyEntities = new HashSet<ApplicationTechnologyEntity>(0);
	
	private Set<ApplicationAuditEntity> applicationAuditEntities = new HashSet<ApplicationAuditEntity>(0);
	private Set<AppAuditEntity> appAuditEntities = new HashSet<AppAuditEntity>(0);
	
	private Set<AppDbAdminEntity> appDbAdminEntities;
	private Set<AppBusinessOwnerEntity> appBusinessOwnerEntities;
	private Set<AppSystemAdminEntity> appSystemAdminEntities;
	private Set<AppProjectManagerEntity> appProjectManagerEntities;
	private Set<AppTechnicalManagerEntity> applicationTechnicalManagerEntities;
	private Set<AppSystemOwnerEntity> appSystemOwnerEntities;
	private Set<AppDataOwnerEntity> appDataOwnerEntities;
	private Set<AppIsoEntity> appISoEntities;
	private Set<AppDataCustodianEntity> appDataCustodianEntities;
	private String internalInterfaces;
	private String externalInterfaces;
	private Double estimatedCost;
	private Set<AssessmentEntity> assessmentEntities = new HashSet<AssessmentEntity>(0);
	private Set<MOUEntity> mouEntities = new HashSet<MOUEntity>(0);
	private Set<AppSolutionEntity> appSolutionEntities = new HashSet<AppSolutionEntity>(0);
	
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
	private String businessOwnerNameDoe;
	private String systemOwnerNameDoe;

	private int activeLocality;
	
	private Set<WorkHoursEntity> workHoursEntities = new HashSet<WorkHoursEntity>(0);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "APPLICATION_ID", nullable = false)
	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "DIVISION_TBL_DIVISION_ID")
	public DivisionEntity getDivisionEntity() {
		return divisionEntity;
	}

	public void setDivisionEntity(DivisionEntity divisionEntity) {
		this.divisionEntity = divisionEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "OFFICE_TBL_OFFICE_ID")
	public OfficeEntity getOfficeEntity() {
		return officeEntity;
	}

	public void setOfficeEntity(OfficeEntity officeEntity) {
		this.officeEntity = officeEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "APPLICATION_STATUS")
	public StatusEntity getStatusEntity() {
		return statusEntity;
	}

	public void setStatusEntity(StatusEntity statusEntity) {
		this.statusEntity = statusEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYSTEM_SENSITIVITY_ID")
	public SystemSensitivityEntity getSystemSensitivityEntity() {
		return systemSensitivityEntity;
	}

	

	public void setSystemSensitivityEntity(SystemSensitivityEntity systemSensitivityEntity) {
		this.systemSensitivityEntity = systemSensitivityEntity;
	}

	@Column(name = "ACRONYM", length = 45)
	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TS", length = 19)
	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	
	@Column(name = "DESCRIPTION")
	public byte[] getDescription() {
		return this.description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
	}

	@Column(name = "TECHNOLOGY_STATUS")
	public byte[] getTechnologyStatus() {
		return this.technologyStatus;
	}

	public void setTechnologyStatus(byte[] technologyStatus) {
		this.technologyStatus = technologyStatus;
	}

	@Column(name = "RISKS")
	public byte[] getRisks() {
		return this.risks;
	}

	public void setRisks(byte[] risks) {
		this.risks = risks;
	}

	@Column(name = "CONSIDERATION")
	public byte[] getConsideration() {
		return this.consideration;
	}

	public void setConsideration(byte[] consideration) {
		this.consideration = consideration;
	}

	@Column(name = "DECISIONS")
	public String getDecisions() {
		return this.decisions;
	}

	public void setDecisions(String decisions) {
		this.decisions = decisions;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPROVED_DATE", length = 19)
	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	@Column(name = "PHYSICAL_LOCATION")
	public String getPhysicalLocation() {
		return this.physicalLocation;
	}

	public void setPhysicalLocation(String physicalLocation) {
		this.physicalLocation = physicalLocation;
	}

	@Column(name = "SYSTEM_INTERFACES")
	public String getSystemInterfaces() {
		return this.systemInterfaces;
	}

	public void setSystemInterfaces(String systemInterfaces) {
		this.systemInterfaces = systemInterfaces;
	}

	@Column(name = "SYSTEM_BOUNDARY")
	public String getSystemBoundary() {
		return this.systemBoundary;
	}

	public void setSystemBoundary(String systemBoundary) {
		this.systemBoundary = systemBoundary;
	}

	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS", length = 19)
	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	@OrderBy("costId")
	public Set<CostEntity> getCostEntities() {
		return costEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public List<FiscalYearInfoEntity> getFiscalYearInfoEntities() {
		return fiscalYearInfoEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<ApplDocEntity> getApplDocEntities() {
		return applDocEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<ApplicationDatabaseEntity> getApplicationDatabaseEntities() {
		return applicationDatabaseEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<ApplicationServerEntity> getApplicationServerEntities() {
		return applicationServerEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppBusinessAnalystEntity> getAppBusinessAnalystEntities() {
		return appBusinessAnalystEntities;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppTesterEntity> getAppTesterEntities() {
		return appTesterEntities;
	}
	
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppDevelopersEntity> getAppDevelopersEntities() {
		return appDevelopersEntities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<MoaEntity> getMoaEntities() {
		return moaEntities;
	}

	public void setCostEntities(Set<CostEntity> costEntities) {
		this.costEntities = costEntities;
	}

	public void setFiscalYearInfoEntities(List<FiscalYearInfoEntity> fiscalYearInfoEntities) {
		this.fiscalYearInfoEntities = fiscalYearInfoEntities;
	}

	public void setApplDocEntities(Set<ApplDocEntity> applDocEntities) {
		this.applDocEntities = applDocEntities;
	}

	public void setApplicationDatabaseEntities(Set<ApplicationDatabaseEntity> applicationDatabaseEntities) {
		this.applicationDatabaseEntities = applicationDatabaseEntities;
	}

	public void setApplicationServerEntities(Set<ApplicationServerEntity> applicationServerEntities) {
		this.applicationServerEntities = applicationServerEntities;
	}

	public void setAppBusinessAnalystEntities(Set<AppBusinessAnalystEntity> appBusinessAnalystEntities) {
		this.appBusinessAnalystEntities = appBusinessAnalystEntities;
	}
	
	public void setAppTesterEntities(Set<AppTesterEntity> appTesterEntities){
		this.appTesterEntities = appTesterEntities;
	}

	public void setAppDevelopersEntities(Set<AppDevelopersEntity> appDevelopersEntities) {
		this.appDevelopersEntities = appDevelopersEntities;
	}

	public void setMoaEntities(Set<MoaEntity> moaEntities) {
		this.moaEntities = moaEntities;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "PROJECT_MANAGER")
	public UserEntity getuserEntityByProjectManager() {
		return userEntityByProjectManager;
	}

	public void setuserEntityByProjectManager(UserEntity userEntityByProjectManager) {
		this.userEntityByProjectManager = userEntityByProjectManager;
	}
	

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "DATA_CUSTODIAN")
	public UserEntity getuserEntityByDataCustodian() {
		return userEntityByDataCustodian;
	}

	public void setuserEntityByDataCustodian(UserEntity userEntityByDataCustodian) {
		this.userEntityByDataCustodian = userEntityByDataCustodian;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "DB_ADMINISTRATOR")
	public UserEntity getuserEntityByDbAdministrator() {
		return userEntityByDbAdministrator;
	}

	public void setuserEntityByDbAdministrator(UserEntity userEntityByDbAdministrator) {
		this.userEntityByDbAdministrator = userEntityByDbAdministrator;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "ISO")
	public UserEntity getuserEntityByIso() {
		return userEntityByIso;
	}
	
	public void setuserEntityByIso(UserEntity userEntityByIso) {
		this.userEntityByIso = userEntityByIso;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "APPROVED_BY")
	public UserEntity getuserEntityByApprovedBy() {
		return userEntityByApprovedBy;
	}

	public void setuserEntityByApprovedBy(UserEntity userEntityByApprovedBy) {
		this.userEntityByApprovedBy = userEntityByApprovedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "TECHNICAL_PROJECT_MANAGER")
	public UserEntity getuserEntityByTechnicalProjectManager() {
		return userEntityByTechnicalProjectManager;
	}

	public void setuserEntityByTechnicalProjectManager(UserEntity userEntityByTechnicalProjectManager) {
		this.userEntityByTechnicalProjectManager = userEntityByTechnicalProjectManager;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "SYSTEM_OWNER")
	public UserEntity getuserEntityBySystemOwner() {
		return userEntityBySystemOwner;
	}

	public void setuserEntityBySystemOwner(UserEntity userEntityBySystemOwner) {
		this.userEntityBySystemOwner = userEntityBySystemOwner;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "DATA_OWNER")
	public UserEntity getuserEntityByDataOwner() {
		return userEntityByDataOwner;
	}

	public void setuserEntityByDataOwner(UserEntity userEntityByDataOwner) {
		this.userEntityByDataOwner = userEntityByDataOwner;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "BUSINESS_OWNER")
	public UserEntity getuserEntityByBusinessOwner() {
		return userEntityByBusinessOwner;
	}

	public void setuserEntityByBusinessOwner(UserEntity userEntityByBusinessOwner) {
		this.userEntityByBusinessOwner = userEntityByBusinessOwner;
	}
	
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "MODIFIED_BY")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<ApplicationTechnologyEntity> getApplicationTechnologyEntities() {
		return applicationTechnologyEntities;
	}

	
	public void setApplicationTechnologyEntities(Set<ApplicationTechnologyEntity> applicationTechnologyEntities) {
		this.applicationTechnologyEntities = applicationTechnologyEntities;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "SYSTEM_ADMINISTRATOR")
	public UserEntity getSystemAdministrator() {
		return systemAdministrator;
	}

	public void setSystemAdministrator(UserEntity systemAdministrator) {
		this.systemAdministrator = systemAdministrator;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppStatusEntity> getAppStatusEntities() {
		return appStatusEntities;
	}

	public void setAppStatusEntities(Set<AppStatusEntity> appStatusEntities) {
		this.appStatusEntities = appStatusEntities;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<ApplicationAuditEntity> getApplicationAuditEntities() {
		return applicationAuditEntities;
	}
	
	
	public void setApplicationAuditEntities(Set<ApplicationAuditEntity> applicationAuditEntities) {
		this.applicationAuditEntities = applicationAuditEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	@OrderBy("createdBy DESC")
	public Set<AppAuditEntity> getAppAuditEntities() {
		return appAuditEntities;
	}

	public void setAppAuditEntities(Set<AppAuditEntity> appAuditEntities) {
		this.appAuditEntities = appAuditEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppDbAdminEntity> getAppDbAdminEntities() {
		return appDbAdminEntities;
	}

	public void setAppDbAdminEntities(Set<AppDbAdminEntity> appDbAdminEntities) {
		this.appDbAdminEntities = appDbAdminEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppBusinessOwnerEntity> getAppBusinessOwnerEntities() {
		return appBusinessOwnerEntities;
	}

	public void setAppBusinessOwnerEntities(Set<AppBusinessOwnerEntity> appBusinessOwnerEntities) {
		this.appBusinessOwnerEntities = appBusinessOwnerEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppSystemAdminEntity> getAppSystemAdminEntities() {
		return appSystemAdminEntities;
	}

	public void setAppSystemAdminEntities(Set<AppSystemAdminEntity> appSystemAdminEntities) {
		this.appSystemAdminEntities = appSystemAdminEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppProjectManagerEntity> getAppProjectManagerEntities() {
		return appProjectManagerEntities;
	}

	public void setAppProjectManagerEntities(Set<AppProjectManagerEntity> appProjectManagerEntities) {
		this.appProjectManagerEntities = appProjectManagerEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppTechnicalManagerEntity> getApplicationTechnicalManagerEntities() {
		return applicationTechnicalManagerEntities;
	}

	public void setApplicationTechnicalManagerEntities(Set<AppTechnicalManagerEntity> applicationTechnicalManagerEntities) {
		this.applicationTechnicalManagerEntities = applicationTechnicalManagerEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppSystemOwnerEntity> getAppSystemOwnerEntities() {
		return appSystemOwnerEntities;
	}

	public void setAppSystemOwnerEntities(Set<AppSystemOwnerEntity> appSystemOwnerEntities) {
		this.appSystemOwnerEntities = appSystemOwnerEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppDataOwnerEntity> getAppDataOwnerEntities() {
		return appDataOwnerEntities;
	}

	public void setAppDataOwnerEntities(Set<AppDataOwnerEntity> appDataOwnerEntities) {
		this.appDataOwnerEntities = appDataOwnerEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppIsoEntity> getAppISoEntities() {
		return appISoEntities;
	}

	public void setAppISoEntities(Set<AppIsoEntity> appISoEntities) {
		this.appISoEntities = appISoEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AppDataCustodianEntity> getAppDataCustodianEntities() {
		return appDataCustodianEntities;
	}

	public void setAppDataCustodianEntities(Set<AppDataCustodianEntity> appDataCustodianEntities) {
		this.appDataCustodianEntities = appDataCustodianEntities;
	}
	
	@Column(name = "LEVEL_OF_EFFORT")
	public String getLevelOfEffort() {
		return levelOfEffort;
	}

	public void setLevelOfEffort(String levelOfEffort) {
		this.levelOfEffort = levelOfEffort;
	}
	
	@Column(name = "SECURITY_ASSESSMENTS")
	public String getSecurityAssessments() {
		return securityAssessments;
	}

	public void setSecurityAssessments(String securityAssessments) {
		this.securityAssessments = securityAssessments;
	}
	
	@Column(name = "BO_VISION1")
	public String getBoVision1() {
		return boVision1;
	}

	public void setBoVision1(String boVision1) {
		this.boVision1 = boVision1;
	}
	
	@Column(name = "BO_VISION2")	
	public String getBoVision2() {
		return boVision2;
	}

	public void setBoVision2(String boVision2) {
		this.boVision2 = boVision2;
	}
	
	@Column(name = "BO_VISION3")
	public String getBoVision3() {
		return boVision3;
	}

	public void setBoVision3(String boVision3) {
		this.boVision3 = boVision3;
	}
	
	@Column(name = "FISCAL_YEAR_1")
	public int getFiscalYear1() {
		return fiscalYear1;
	}

	public void setFiscalYear1(int fiscalYear1) {
		this.fiscalYear1 = fiscalYear1;
	}
	
	@Column(name = "FISCAL_YEAR_2")
	public int getFiscalYear2() {
		return fiscalYear2;
	}

	public void setFiscalYear2(int fiscalYear2) {
		this.fiscalYear2 = fiscalYear2;
	}
	
	@Column(name = "FISCAL_YEAR_3")
	public int getFiscalYear3() {
		return fiscalYear3;
	}

	public void setFiscalYear3(int fiscalYear3) {
		this.fiscalYear3 = fiscalYear3;
	}
	
	@Column(name = "INTERNAL_INTERFACES")
	public String getInternalInterfaces() {
		return internalInterfaces;
	}

	public void setInternalInterfaces(String internalInterfaces) {
		this.internalInterfaces = internalInterfaces;
	}
	
	@Column(name = "EXTERNAL_INTERFACES")
	public String getExternalInterfaces() {
		return externalInterfaces;
	}

	public void setExternalInterfaces(String externalInterfaces) {
		this.externalInterfaces = externalInterfaces;
	}
	
	@Column(name = "ESTIMATED_COST")
	public Double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity",cascade=CascadeType.ALL)
	public Set<AssessmentEntity> getAssessmentEntities() {
		return assessmentEntities;
	}

	public void setAssessmentEntities(Set<AssessmentEntity> assessmentEntities) {
		this.assessmentEntities = assessmentEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity")
	public Set<MOUEntity> getMouEntities() {
		return mouEntities;
	}

	public void setMouEntities(Set<MOUEntity> mouEntities) {
		this.mouEntities = mouEntities;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationEntity")
	public Set<AppSolutionEntity> getAppSolutionEntities() {
		return appSolutionEntities;
	}

	public void setAppSolutionEntities(Set<AppSolutionEntity> appSolutionEntities) {
		this.appSolutionEntities = appSolutionEntities;
	}
	
	@Column(name = "LOCALITY_CD", length = 45)
	public String getLocalityCd() {
		return localityCd;
	}

	public void setLocalityCd(String localityCd) {
		this.localityCd = localityCd;
	}
	
	@Column(name = "FIPS_CD", length = 45)
	public String getFipsCd() {
		return fipsCd;
	}
	
	
	public void setFipsCd(String fipsCd) {
		this.fipsCd = fipsCd;
	}
	
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name = "WEBSITE")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Column(name = "VERIS_ID")
	public String getVerisId() {
		return verisId;
	}

	public void setVerisId(String verisId) {
		this.verisId = verisId;
	}
	
	@Column(name = "CAP_IND")
	public boolean getCapInd() {
		return capInd;
	}

	public void setCapInd(boolean capInd) {
		this.capInd = capInd;
	}
	
	@Column(name = "BAILOUT_IND")
	public boolean isBailoutInd() {
		return bailoutInd;
	}

	public void setBailoutInd(boolean bailoutInd) {
		this.bailoutInd = bailoutInd;
	}
	
	@Column(name = "PENALITY")
	public String getPenality() {
		return penality;
	}

	public void setPenality(String penality) {
		this.penality = penality;
	}
	
	@Column(name = "VEBA_REGION")
	public boolean isVebaRegion() {
		return vebaRegion;
	}

	public void setVebaRegion(boolean vebaRegion) {
		this.vebaRegion = vebaRegion;
	}
	
	@Column(name = "VRAV_REGION")
	public boolean isVravRegion() {
		return vravRegion;
	}

	public void setVravRegion(boolean vravRegion) {
		this.vravRegion = vravRegion;
	}
	
	@Column(name = "PAPER_POLLBOOK")
	public boolean isPaperPollbook() {
		return paperPollbook;
	}
	

	
	public void setPaperPollbook(boolean paperPollbook) {
		this.paperPollbook = paperPollbook;
	}
	
	@Column(name = "ELECTRONIC_POLLBOOK")
	public boolean isElectronicPollbook() {
		return electronicPollbook;
	}

	public void setElectronicPollbook(boolean electronicPollbook) {
		this.electronicPollbook = electronicPollbook;
	}
	
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="applicationEntity",cascade=CascadeType.ALL)
	@OrderBy("workHoursId")
	public Set<WorkHoursEntity> getWorkHoursEntities() {
		return workHoursEntities;
	}

	public void setWorkHoursEntities(Set<WorkHoursEntity> workHoursEntities) {
		this.workHoursEntities = workHoursEntities;
	}
	
	@Column(name = "ACTIVELOCALITY")
	public int getActiveLocality() {
		return activeLocality;
	}

	public void setActiveLocality(int activeLocality) {
		this.activeLocality = activeLocality;
	}

	@Column(name = "BUSINESS_OWNER_NAME_DOE")
	public String getBusinessOwnerNameDoe() {
		return businessOwnerNameDoe;
	}

	public void setBusinessOwnerNameDoe(String businessOwnerNameDoe) {
		this.businessOwnerNameDoe = businessOwnerNameDoe;
	}

	@Column(name = "SYS_OWNER_NAME_DOE")
	public String getSystemOwnerNameDoe() {
		return systemOwnerNameDoe;
	}

	public void setSystemOwnerNameDoe(String systemOwnerNameDoe) {
		this.systemOwnerNameDoe = systemOwnerNameDoe;
	}
	
	
	
}
