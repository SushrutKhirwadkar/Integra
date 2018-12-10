package com.soch.Integra.dao;

import java.util.List;

import com.soch.Integra.entities.ApplicationDatabaseEntity;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.ApplicationServerEntity;
import com.soch.Integra.entities.ApplicationTechnologyEntity;
import com.soch.Integra.entities.DatabaseEntity;
import com.soch.Integra.entities.ServerEntity;
import com.soch.Integra.entities.TechnologiesEntity;

public interface ReportDAO {
	
	public List<DatabaseEntity> getDatabaseReport();
	public List<TechnologiesEntity> getTechnologyReport();
	public 	List<ServerEntity> getServerReport();
	
	public List<ApplicationEntity> getDBOfficeApps(int dbId, int officeID);
	public List<ApplicationEntity> getTechOfficeApps(int techId, int officeID);
	public List<ApplicationEntity> getServerOfficeApps(int serverId , int officeID);
	public List<ApplicationDatabaseEntity> getDatabaseReport(Integer databaseId);
	public List<ApplicationServerEntity> getServerReport(Integer serverId);
	public List<ApplicationTechnologyEntity> getTechnicalReport(Integer techId);
}
