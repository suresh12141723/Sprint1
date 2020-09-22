package com.cg.user.service;

//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.UserDao;
import com.cg.user.entity.User;
import com.cg.user.exception.NoUserFoundException;
import com.cg.user.exception.UserIdNotFoundException;


@Transactional
@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userdao;
	
	
	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a service to add the user details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public void adduser(User user) {
		userdao.adduser(user);
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a service to fetch the user details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public List<User> reterive() {
		if(userdao.reterive().size()>0) {
		List<User> list=userdao.reterive();
		return list;
		}
		throw new NoUserFoundException("No USer is Available");
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a service to find  the user details by ID
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public User findById(int id) {
		User user=userdao.findById(id);
		if(user==null)
		{
			throw new UserIdNotFoundException("User ID not found , please entera valid Id");
		}
		return user;
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a service to delete the User details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public Boolean deleteuser(int id) {
		userdao.deleteuser(id);
		return null;
		
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a service to Update the user details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public void update(int userId,User user) {
		User updatedUser=userdao.findById(userId);
		updatedUser.setUserName(user.getUserName());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
		
		userdao.update(updatedUser);
		
	}

}


