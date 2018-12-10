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
import com.soch.Integra.entities.DeviceDocEntity;
import com.soch.Integra.entities.HostingTypeEntity;
import com.soch.Integra.entities.LabVendorEntity;
import com.soch.Integra.entities.PrecinctTypeEntity;
import com.soch.Integra.entities.SolutionsEntity;
import com.soch.Integra.entities.SystemTypeEntity;
import com.soch.Integra.entities.VendorsEntity;

@Component
public class SolutionDaoImpl implements SolutionsDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public SolutionsEntity saveSolution(SolutionsEntity solutionsEntity) {
		this.sessionFactory.getCurrentSession().save(solutionsEntity);
		return solutionsEntity;
	}

	@Override
	public List<SolutionsEntity> getSoltionEntities() {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SolutionsEntity.class);
		 List<SolutionsEntity> solutionsEntities =  criteria.list();
		return solutionsEntities;
	}

	@Override
	public SolutionsEntity getSolution(int solutionID) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SolutionsEntity.class);
		criteria.add(Restrictions.eq("solutionId", solutionID));
		SolutionsEntity solutionsEntity = (SolutionsEntity)criteria.list().get(0);
		return solutionsEntity;
	}

	@Override
	public LabVendorEntity getLabVendorEntity(int labVendorId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(LabVendorEntity.class);
		criteria.add(Restrictions.eq("labVendorId", labVendorId));
		LabVendorEntity labVendorEntity = (LabVendorEntity)criteria.list().get(0);
		return labVendorEntity;
	}

	@Override
	public SystemTypeEntity getSystemTypeEntity(int systemTypeId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SystemTypeEntity.class);
		criteria.add(Restrictions.eq("systemTypeId", systemTypeId));
		SystemTypeEntity systemTypeEntity = (SystemTypeEntity)criteria.list().get(0);
		return systemTypeEntity;
	}

	@Override
	public AppSolutionEntity saveAppSolution(AppSolutionEntity appSolutionEntity) {
		this.sessionFactory.getCurrentSession().save(appSolutionEntity);
		return appSolutionEntity;
	}
	

	
	@Override
	public AppSolutionEntity updateAppSolution(AppSolutionEntity appSolutionEntity) {
		this.sessionFactory.getCurrentSession().update(appSolutionEntity);
		return appSolutionEntity;
	}

	@Override
	public List<AppSolutionEntity> getAppSolutions(int applicationId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSolutionEntity.class);
		criteria.add(Restrictions.eq("applicationEntity.applicationId", applicationId));
		List<AppSolutionEntity> appSolutionEntities = criteria.list();
		return appSolutionEntities;
	}

	@Override
	public AppSolutionEntity getAppSolution(int solutionId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSolutionEntity.class);
		criteria.add(Restrictions.eq("appSolutionId", solutionId));
		AppSolutionEntity appSolutionEntity = (AppSolutionEntity) criteria.list().get(0);

		return appSolutionEntity;
	}

	@Override
	public List<HostingTypeEntity> getHostingTypes() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(HostingTypeEntity.class);
		List<HostingTypeEntity> hostingTypeEntities = criteria.list();
		return hostingTypeEntities;
	}

	@Override
	public HostingTypeEntity getHostingTypeEntity(Integer hostingTypeId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(HostingTypeEntity.class);
		criteria.add(Restrictions.eq("hostingTypeId", hostingTypeId));
		HostingTypeEntity hostingTypeEntity = (HostingTypeEntity) criteria.list().get(0);
		return hostingTypeEntity;
	}

	@Override
	public CertDocEntity getSolutionFile(int fileID) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CertDocEntity.class);
		criteria.add(Restrictions.eq("certDocId", fileID));
		List<CertDocEntity> certDocEntities = criteria.list();
		if(certDocEntities.isEmpty())
			return null;
		else
		{
			return certDocEntities.get(0);
		}
	}

	@Override
	public List<PrecinctTypeEntity> getPrecinctTypes() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PrecinctTypeEntity.class);
		return criteria.list();
	}

	@Override
	public PrecinctTypeEntity getPrecinctType(int precinctTypeId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PrecinctTypeEntity.class);
		criteria.add(Restrictions.eq("precinctTypeId", precinctTypeId));
		return (PrecinctTypeEntity) criteria.list().get(0);
	}
	@Override
	public List<DeviceDocEntity> getDeviceDocs() {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DeviceDocEntity.class);
		 List<DeviceDocEntity> deviceDocEntities =  criteria.list();
		return deviceDocEntities;
	}
	
	@Override
	public List<AppSolutionEntity> getAllAppSolutions() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSolutionEntity.class);
		return criteria.list();
	}

	@Override
	public List<AppSolutionDeviceEntity> getAllSolDevices() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AppSolutionDeviceEntity.class);
		return criteria.list();
		
	}
	
	@Override
	public List<VendorsEntity> getAllVendors() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(VendorsEntity.class);
		return criteria.list();
		}
}
