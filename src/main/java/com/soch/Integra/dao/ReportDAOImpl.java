package com.soch.Integra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.entities.ApplicationDatabaseEntity;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.ApplicationServerEntity;
import com.soch.Integra.entities.ApplicationTechnologyEntity;
import com.soch.Integra.entities.DatabaseEntity;
import com.soch.Integra.entities.ServerEntity;
import com.soch.Integra.entities.TechnologiesEntity;

@Component
public class ReportDAOImpl implements ReportDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<DatabaseEntity> getDatabaseReport() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DatabaseEntity.class);
		return criteria.list();
	}

	@Override
	public List<TechnologiesEntity> getTechnologyReport() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TechnologiesEntity.class);
		return criteria.list();
	}

	@Override
	public List<ServerEntity> getServerReport() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ServerEntity.class);
		return criteria.list();
	}
	@Override
	public List<ApplicationEntity> getDBOfficeApps(int dbId, int officeID) {
		// TODO Auto-generated method stub
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class,"application");
		
		criteria.add(Restrictions.eq("officeEntity.officeId", officeID));
		
		if(dbId !=0 )
		{
			criteria.createAlias("application.applicationDatabaseEntities", "databaseEntities");
            criteria.add(Restrictions.eq("databaseEntities.databaseEntity.databaseId", dbId));
            criteria.add(Restrictions.eq("databaseEntities.activityFlag", true));
		}
		
		return criteria.list();
	}
	
	@Override
	public List<ApplicationEntity> getTechOfficeApps(int technologyId, int officeID) {
		// TODO Auto-generated method stub
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class,"application");
		
		criteria.add(Restrictions.eq("officeEntity.officeId", officeID));
		
		if(technologyId !=0 )
		{
			criteria.createAlias("application.applicationTechnologyEntities", "technologyEntities");
            criteria.add(Restrictions.eq("technologyEntities.technologiesEntity.technologyId", technologyId));
            criteria.add(Restrictions.eq("technologyEntities.activityFlag", true));
		}
		return criteria.list();
	}

	
	@Override
	public List<ApplicationEntity> getServerOfficeApps(int serverId, int officeID) {
		// TODO Auto-generated method stub
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationEntity.class,"application");
		
		criteria.add(Restrictions.eq("officeEntity.officeId", officeID));
		
		if(serverId !=0 )
		{
			criteria.createAlias("application.applicationServerEntities", "serverEntities");
            criteria.add(Restrictions.eq("serverEntities.serverEntity.serverId", serverId));
            criteria.add(Restrictions.eq("serverEntities.activityFlag", true));
		}
		
		return criteria.list();
	}

	@Override
	public List<ApplicationDatabaseEntity> getDatabaseReport(Integer databaseId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationDatabaseEntity.class);
		criteria.add(Restrictions.eq("databaseEntity.databaseId", databaseId));
		criteria.add(Restrictions.eq("activityFlag", true));
		return criteria.list();
	}

	@Override
	public List<ApplicationServerEntity> getServerReport(Integer serverId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationServerEntity.class);
		criteria.add(Restrictions.eq("serverEntity.serverId", serverId));
		criteria.add(Restrictions.eq("activityFlag", true));
		return criteria.list();
	}

	@Override
	public List<ApplicationTechnologyEntity> getTechnicalReport(Integer techId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationTechnologyEntity.class);
		criteria.add(Restrictions.eq("technologiesEntity.technologyId", techId));
		criteria.add(Restrictions.eq("activityFlag", true));
		return criteria.list();
	}
}
	


