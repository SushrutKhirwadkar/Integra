package com.soch.Integra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.soch.Integra.dao.ApplicationDao;
import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.ApplicationUserDTO;
import com.soch.Integra.dto.OfficeDTO;
import com.soch.Integra.dto.UserAppRoleDTO;
import com.soch.Integra.dto.UserReportRequest;
import com.soch.Integra.dto.UserReportResponse;
import com.soch.Integra.entities.AppBusinessOwnerEntity;
import com.soch.Integra.entities.AppProjectManagerEntity;
import com.soch.Integra.entities.ApplicationEntity;
import com.soch.Integra.entities.UserAppRoleEntity;
import com.soch.Integra.entities.UserEntity;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ApplicationDao applicationDao;
	
	 @Autowired
	private Environment environment;

	@Override
	@Transactional
	public List<UserAppRoleDTO> getUserRoles() {
		List<UserAppRoleEntity> userAppRoleEntities = applicationDao.getUserRoles();
		List<UserAppRoleDTO> userAppRoleDTOs = new ArrayList<>(0);
		UserAppRoleDTO userAppRoleDTO = null;
		
		for(UserAppRoleEntity userAppRoleEntity: userAppRoleEntities)
		{
			userAppRoleDTO = new UserAppRoleDTO();
			userAppRoleDTO.setAppRoleId(userAppRoleEntity.getAppRoleId());
			userAppRoleDTO.setName(userAppRoleEntity.getName());
			userAppRoleDTOs.add(userAppRoleDTO);
		}
		return userAppRoleDTOs;
	}

	@Override
	@Transactional
	public List<ApplicationUserDTO> getUsers(Integer role) {
		List<UserEntity> userEntities = applicationDao.getUsersonRole(role);
		List<ApplicationUserDTO> userDTOs = new ArrayList<>();
		ApplicationUserDTO userDTO = null;
		for (UserEntity userEntity : userEntities) {
			userDTO = new ApplicationUserDTO();
			userDTO.setFirstName(userEntity.getFirstName());
			userDTO.setLastName(userEntity.getLastName());
			userDTO.setTitle(userEntity.getTitle());
			userDTO.setUserId(userEntity.getUserId());
			userDTO.setRole(userEntity.getUserAppRoleEntity().getName());
			userDTOs.add(userDTO);

		}
		
		return userDTOs;
	}

	@Override
	@Transactional
	public UserReportResponse getUserApps(UserReportRequest userReportRequest) {
		List<ApplicationEntity> applicationEntities = applicationDao.getUSerApps(userReportRequest);
		UserReportResponse userReportResponse = new UserReportResponse();
		if(applicationEntities != null && applicationEntities.size() > 0)
		{
			List<ApplicationDTO> applicationDTOs = new ArrayList<ApplicationDTO>(0);
			ApplicationDTO applicationDTO = null;
			OfficeDTO officeDTO = null;
			for(ApplicationEntity applicationEntity : applicationEntities)
			{
				applicationDTO = new ApplicationDTO();
				applicationDTO.setAcronym(applicationEntity.getAcronym());
				applicationDTO.setName(applicationEntity.getName());
				if(applicationEntity.getOfficeEntity() != null)
				{
					officeDTO = new OfficeDTO();
					officeDTO.setDescription(applicationEntity.getOfficeEntity().getDescription());
					applicationDTO.setOfficeTbl(officeDTO);
				}
				
				if (applicationEntity.getAppProjectManagerEntities() != null && !applicationEntity.getAppProjectManagerEntities().isEmpty()) 
				{
					Set<AppProjectManagerEntity> appProjectManagerEntities = applicationEntity.getAppProjectManagerEntities();
					StringBuffer names = new StringBuffer();
					for(AppProjectManagerEntity appProjectManagerEntity : appProjectManagerEntities)
					{
						if(names.length() > 0)
							names.append(",");
						names.append(appProjectManagerEntity.getUserEntity().getFirstName()
									+ " " + appProjectManagerEntity.getUserEntity().getLastName());
						System.out.println(applicationEntity.getAcronym()+" "+names.toString());
					}
					applicationDTO
					.setProjectManagerName(names.toString());
				}
				if (applicationEntity.getAppBusinessOwnerEntities() != null && !applicationEntity.getAppBusinessOwnerEntities().isEmpty())
				{
					Set<AppBusinessOwnerEntity> appBusinessOwnerEntities = applicationEntity.getAppBusinessOwnerEntities();
					StringBuffer names = new StringBuffer();
					for(AppBusinessOwnerEntity appBusinessOwnerEntity : appBusinessOwnerEntities)
					{
						if(names.length() > 0)
							names.append(",");
						names.append(appBusinessOwnerEntity.getUserEntity().getFirstName()
									+ " " + appBusinessOwnerEntity.getUserEntity().getLastName());
					}
					applicationDTO
					.setBusinessOwnerName(names.toString());
				}
				
				applicationDTOs.add(applicationDTO);
			}
			userReportResponse.setApplicationDTOs(applicationDTOs);
			userReportResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("USER.REPORT.WITH.APPLICATION.RESPONSE.CODE",null, Locale.getDefault())));
			userReportResponse.setResponseString(messageSource.getMessage("USER.REPORT.WITH.APPLICATION.RESPONSE.STRING",null, Locale.getDefault()));
			
		}
		else
		{
			userReportResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("USER.REPORT.WITH.NO.APPLICATION.RESPONSE.CODE",null, Locale.getDefault())));
			userReportResponse.setResponseString(messageSource.getMessage("USER.REPORT.WITH.NO.APPLICATION.RESPONSE.STRING",null, Locale.getDefault()));		 
		}
		return userReportResponse;
	}

}
