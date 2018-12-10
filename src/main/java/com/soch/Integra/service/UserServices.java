package com.soch.Integra.service;

import java.util.List;

import com.soch.Integra.dto.ApplicationUserDTO;
import com.soch.Integra.dto.UserAppRoleDTO;
import com.soch.Integra.dto.UserReportRequest;
import com.soch.Integra.dto.UserReportResponse;

public interface UserServices {
	public List<UserAppRoleDTO> getUserRoles();

	public List<ApplicationUserDTO> getUsers(Integer role);

	public UserReportResponse getUserApps(UserReportRequest userReportRequest);
	
}
