package com.soch.Integra.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soch.Integra.entities.UserAppRoleEntity;
import com.soch.Integra.entities.UserEntity;


public interface UserDao {
	
	public UserEntity getUser(String userID);

	UserEntity saveUser(UserEntity userEntity);

	public UserAppRoleEntity getUserRoleEntityOnRoleName(String role);

	public List<UserEntity> getUseronName(String fname, String lname);

	public List<UserEntity> getUsersOnRole(int appRoleId);

}