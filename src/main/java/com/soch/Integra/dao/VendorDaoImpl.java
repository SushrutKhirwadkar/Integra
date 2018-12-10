package com.soch.Integra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.entities.LabVendorEntity;
import com.soch.Integra.entities.SolutionTypeEntity;
import com.soch.Integra.entities.SolutionsEntity;
import com.soch.Integra.entities.SystemTypeEntity;
import com.soch.Integra.entities.UserAppRoleEntity;
import com.soch.Integra.entities.VendorsEntity;

@Component
public class VendorDaoImpl implements VendorDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveVendor(VendorsEntity vendorsEntity) {
		 this.sessionFactory.getCurrentSession().save(vendorsEntity);
		
	}

	@Override
	public List<VendorsEntity> getVendors() {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(VendorsEntity.class);
		 List<VendorsEntity> vendors = criteria.list();
		return vendors;
	}

	@Override
	public List<SolutionTypeEntity> getSolutionTypes() {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SolutionTypeEntity.class);
		 List<SolutionTypeEntity> solutionTypeEntities =  criteria.list();
		return solutionTypeEntities;
	}

	@Override
	public SolutionTypeEntity getSolutionType(Integer solutionType) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SolutionTypeEntity.class);
		criteria.add(Restrictions.eq("solutionTypeId", solutionType));
		SolutionTypeEntity solutionTypeEntity = (SolutionTypeEntity) criteria.list().get(0);
		return solutionTypeEntity;
	}

	@Override
	public VendorsEntity getVendorEntity(Integer vendorId) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(VendorsEntity.class);
		criteria.add(Restrictions.eq("vendorId", vendorId));
		VendorsEntity vendorsEntity = (VendorsEntity) criteria.list().get(0);
		return vendorsEntity;
	}

	@Override
	public void updateVendor(VendorsEntity vendorsEntity) {
		 this.sessionFactory.getCurrentSession().update(vendorsEntity);		
	}

	@Override
	public List<SystemTypeEntity> getSystemTypes() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SystemTypeEntity.class);
		 List<SystemTypeEntity> systemTypeEntities =  criteria.list();
		return systemTypeEntities;
	}

	@Override
	public List<LabVendorEntity> getLabVendors() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(LabVendorEntity.class);
		 List<LabVendorEntity> labVendorEntities =  criteria.list();
		return labVendorEntities;
	}

	
}
