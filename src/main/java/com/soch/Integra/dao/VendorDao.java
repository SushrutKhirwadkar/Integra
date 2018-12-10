package com.soch.Integra.dao;

import java.util.List;

import com.soch.Integra.entities.LabVendorEntity;
import com.soch.Integra.entities.SolutionTypeEntity;
import com.soch.Integra.entities.SystemTypeEntity;
import com.soch.Integra.entities.VendorsEntity;

public interface VendorDao {
	
	public void saveVendor(VendorsEntity vendorsEntity);

	public List<VendorsEntity> getVendors();

	public List<SolutionTypeEntity> getSolutionTypes();

	public SolutionTypeEntity getSolutionType(Integer solutionType);

	public VendorsEntity getVendorEntity(Integer vendorId);

	public void updateVendor(VendorsEntity vendorsEntity);

	public List<SystemTypeEntity> getSystemTypes();

	public List<LabVendorEntity> getLabVendors();

}
