package com.soch.Integra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.entities.AppSolutionDeviceEntity;
import com.soch.Integra.entities.AppSolutionEntity;
import com.soch.Integra.entities.CertDocEntity;
import com.soch.Integra.entities.HostingTypeEntity;
import com.soch.Integra.entities.LabVendorEntity;
import com.soch.Integra.entities.PrecinctTypeEntity;
import com.soch.Integra.entities.SolutionsEntity;
import com.soch.Integra.entities.SystemTypeEntity;
import com.soch.Integra.entities.VendorsEntity;

import com.soch.Integra.entities.AppSolutionDeviceEntity;

@Component
public class SolutionDevicesDAOImpl implements SolutionDevicesDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public AppSolutionDeviceEntity saveAppSolutionDevices(AppSolutionDeviceEntity appSolutionDeviceEntity) {
		this.sessionFactory.getCurrentSession().save(appSolutionDeviceEntity);
		return appSolutionDeviceEntity;
	}

	@Override
	public List<AppSolutionDeviceEntity> getAppSolutionDeviceEntities() {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSolutionDeviceEntity.class);
		 List<AppSolutionDeviceEntity> appsolutionDeviceEntities =  criteria.list();
		return appsolutionDeviceEntities;
	}

	
	
	

}
