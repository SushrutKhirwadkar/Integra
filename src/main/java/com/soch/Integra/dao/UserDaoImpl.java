package com.soch.Integra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soch.Integra.entities.UserAppRoleEntity;
import com.soch.Integra.entities.UserEntity;


@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UserEntity getUser(String userID) {
		 UserEntity userEntity = null;
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
         
         //criteria.add(Restrictions.eq("loginId", userID));
        List<UserEntity> userEntities =  criteria.list();
        if(userEntities.size() > 0)
        {
        	userEntity = userEntities.get(0);
        }
		return userEntity;
	}
	
	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		 this.sessionFactory.getCurrentSession().save(userEntity);
		return userEntity;
	}

	@Override
	public UserAppRoleEntity getUserRoleEntityOnRoleName(String role) {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserAppRoleEntity.class);
		 criteria.add(Restrictions.eq("name", role));
		  List<UserAppRoleEntity> userAppRoleEntities =  criteria.list();
		  UserAppRoleEntity userAppRoleEntity = null;
	        if(userAppRoleEntities.size() > 0)
	        {
	        	userAppRoleEntity = userAppRoleEntities.get(0);
	        }
	        
		return userAppRoleEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUseronName(String fname, String lname) {
		
		UserEntity userEntity = null;
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		if(fname != null)
		{
			criteria.add(Restrictions.ilike("firstName", fname));
		}
		if(lname != null)
		{
			criteria.add(Restrictions.ilike("lastName", lname));
		}
		List<UserEntity> userEntities = criteria.list();
		return userEntities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsersOnRole(int appRoleId) {
		 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		 criteria.add(Restrictions.eq("userAppRoleEntity.appRoleId", appRoleId));
		 List<UserEntity> userEntities = criteria.list();
		return userEntities;
	}

}
