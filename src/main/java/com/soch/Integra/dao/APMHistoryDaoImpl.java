package com.soch.Integra.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.entities.ApplicationAuditEntity;
import com.soch.Integra.entities.ApplicationEntity;
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
import com.soch.Integra.entities.audit.ApplicationAuditAuditEntity;
import com.soch.Integra.entities.audit.ApplicationDatabaseAuditEntity;
import com.soch.Integra.entities.audit.ApplicationServerAuditEntity;
import com.soch.Integra.entities.audit.ApplicationTblAudit;
import com.soch.Integra.entities.audit.SystemSensitivityAuditEntity;
import com.soch.Integra.entities.audit.ApplicationTechnologyAuditEntity;
import com.soch.Integra.entities.audit.CostAuditEntity;

@Component
public class APMHistoryDaoImpl implements APMHistoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ApplicationTblAudit> getAppllicationHistory(String acronym) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationTblAudit.class);
		criteria.add(Restrictions.eq("acronym", acronym));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppBusinessOwnerAuditEntity> getAppBusinessOwners(Date processDate, Integer appId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppBusinessOwnerAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", appId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}	
	@Override
		public List<AppDataOwnerAuditEntity> getAppDataOwner(Date processDate, Integer appId) {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppDataOwnerAuditEntity.class);
			criteria.add(Restrictions.eq("processDate", processDate));
			criteria.add(Restrictions.eq("application", appId));
			criteria.addOrder(Order.asc("processDate"));
			return criteria.list();
	}

	@Override
	public List<AppProjectManagerAuditEntity> getAppProjectManager(Date processDate, Integer appId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppProjectManagerAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", appId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}
	@Override
	public List<AppIsoAuditEntity> getAppIso(Date processDate, Integer appId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppIsoAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", appId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
		}
	@Override
	public List<AppSystemOwnerAuditEntity> getAppSystemOwner(Date processDate, Integer appId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSystemOwnerAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", appId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}	
	@Override
	public List<AppDataCustodianAuditEntity> getAppDataCustodian(Date processDate, Integer appId) {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppDataCustodianAuditEntity.class);
			criteria.add(Restrictions.eq("processDate", processDate));
			criteria.add(Restrictions.eq("application", appId));
			criteria.addOrder(Order.asc("processDate"));
			return criteria.list();
	}
	
	@Override
	public List<AppTestersAuditEntity> getAppTesters(Date processDate, Integer appId) {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppTestersAuditEntity.class);
			criteria.add(Restrictions.eq("processDate", processDate));
			criteria.add(Restrictions.eq("application", appId));
			criteria.addOrder(Order.asc("processDate"));
			return criteria.list();
}
	/*@Override
	public List<SystemSensitivityAuditEntity> getAppSystemSensitivity(Date processDate, Integer appId) {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SystemSensitivityAuditEntity.class);
			criteria.add(Restrictions.eq("processDate", processDate));
			criteria.add(Restrictions.eq("application", appId));
			criteria.addOrder(Order.asc("processDate"));
			return criteria.list();
}*/
	
	@Override
	public List<ApplicationDatabaseAuditEntity> getAppDatabases(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationDatabaseAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("applicationId", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<ApplicationServerAuditEntity> getAppServers(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationServerAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("applicationId", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<ApplicationTechnologyAuditEntity> getAppTechnologies(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ApplicationTechnologyAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("applicationId", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppProjectManagerAuditEntity> getProjectManagers(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppProjectManagerAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppSystemAdminAuditEntity> getAppSystemAdmins(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSystemAdminAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppBusinessAnalystAuditEntity> getAppBusinessAnalysts(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppBusinessAnalystAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("applicationId", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppDbAdminAuditEntity> getAppDBAdmins(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppDbAdminAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppDevelopersAuditEntity> getAppDevelopers(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppDevelopersAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("application", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}
	
	@Override
	public List<CostAuditEntity> getAppCosts(Date processDate, int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CostAuditEntity.class);
		criteria.add(Restrictions.eq("processDate", processDate));
		criteria.add(Restrictions.eq("applicationId", applicationId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AppAuditAuditEntity> getApplicatonAuditHistory(int appId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppAuditAuditEntity.class);
		criteria.add(Restrictions.eq("applicationId", appId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}

	@Override
	public List<AssessmentAuditEntity> getAssessmentHistory(int assessmentId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssessmentAuditEntity.class);
		criteria.add(Restrictions.eq("assessmentId", assessmentId));
		criteria.addOrder(Order.asc("processDate"));
		return criteria.list();
	}
	
}
