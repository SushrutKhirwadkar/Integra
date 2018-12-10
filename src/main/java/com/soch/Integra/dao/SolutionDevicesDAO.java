package com.soch.Integra.dao;

import java.util.List;

import com.soch.Integra.entities.AppSolutionDeviceEntity;

public interface SolutionDevicesDAO {
	
	public  AppSolutionDeviceEntity saveAppSolutionDevices(AppSolutionDeviceEntity appSolutionDeviceEntity);

	/*public AppSolutionDeviceEntity getAppSolutionDevices(int appSolutionDevice);*/

	public List<AppSolutionDeviceEntity> getAppSolutionDeviceEntities();


}
