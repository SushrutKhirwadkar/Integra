package com.soch.Integra.dao;

import java.util.Date;
import java.util.List;

import com.soch.Integra.entities.AssessmentAuditEntity;
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
import com.soch.Integra.entities.audit.SystemSensitivityAuditEntity;
import com.soch.Integra.entities.audit.ApplicationTechnologyAuditEntity;
import com.soch.Integra.entities.audit.CostAuditEntity;

public interface APMHistoryDao {

	List<ApplicationTblAudit> getAppllicationHistory(String acronym);

	List<AppBusinessOwnerAuditEntity> getAppBusinessOwners(Date processDate, Integer appId);
	
	List<AppDataOwnerAuditEntity> getAppDataOwner(Date processDate, Integer appId);

	List<AppProjectManagerAuditEntity> getAppProjectManager(Date processDate, Integer appId);

	List<AppIsoAuditEntity> getAppIso(Date processDate,  Integer appId);

	List<AppSystemOwnerAuditEntity> getAppSystemOwner(Date processDate, Integer appId);

	List<AppDataCustodianAuditEntity> getAppDataCustodian(Date processDate, Integer appId);

	List<AppTestersAuditEntity> getAppTesters(Date processDate,Integer appId);
	
	List<ApplicationDatabaseAuditEntity> getAppDatabases(Date processDate, int applicationId);

	//List<SystemSensitivityAuditEntity> getAppSystemSensitivity(Date processDate,Integer appId);

	List<ApplicationServerAuditEntity> getAppServers(Date processDate, int applicationId);

	List<ApplicationTechnologyAuditEntity> getAppTechnologies(Date processDate, int applicationId);

	List<AppProjectManagerAuditEntity> getProjectManagers(Date processDate, int applicationId);

	List<AppSystemAdminAuditEntity> getAppSystemAdmins(Date processDate, int applicationId);

	List<AppBusinessAnalystAuditEntity> getAppBusinessAnalysts(Date processDate, int applicationId);

	List<AppDbAdminAuditEntity> getAppDBAdmins(Date processDate, int applicationId);

	List<AppDevelopersAuditEntity> getAppDevelopers(Date processDate, int applicationId);
	
	List<CostAuditEntity> getAppCosts(Date processDate, int applicationId);

	List<AppAuditAuditEntity> getApplicatonAuditHistory(int appId);

	List<AssessmentAuditEntity> getAssessmentHistory(int assessmentId);
	


}
