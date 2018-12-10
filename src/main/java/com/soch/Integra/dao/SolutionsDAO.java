package com.soch.Integra.dao;

import java.util.List;

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

public interface SolutionsDAO {

	public SolutionsEntity saveSolution(SolutionsEntity solutionsEntity);

	public List<SolutionsEntity> getSoltionEntities();

	public SolutionsEntity getSolution(int solutionID);

	public LabVendorEntity getLabVendorEntity(int labVendorId);

	public SystemTypeEntity getSystemTypeEntity(int systemTypeId);

	public AppSolutionEntity saveAppSolution(AppSolutionEntity appSolutionEntity);

	AppSolutionEntity updateAppSolution(AppSolutionEntity appSolutionEntity);

	public List<AppSolutionEntity> getAppSolutions(int applicationId);

	public AppSolutionEntity getAppSolution(int solutionId);

	public List<HostingTypeEntity> getHostingTypes();

	public HostingTypeEntity getHostingTypeEntity(Integer hostingTypeId);

	public CertDocEntity getSolutionFile(int fileID);

	public List<PrecinctTypeEntity> getPrecinctTypes();

	public PrecinctTypeEntity getPrecinctType(int precinctTypeId);
	
	public List<DeviceDocEntity> getDeviceDocs();

	public List<AppSolutionEntity> getAllAppSolutions();

	public List<AppSolutionDeviceEntity> getAllSolDevices();

	 public List<VendorsEntity> getAllVendors();

	
}
