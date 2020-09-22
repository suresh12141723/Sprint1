package com.cg.user.dao;

//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.cg.user.entity.User;

@Transactional
@Repository
public class UserDaoImp implements UserDao{
	
	@PersistenceContext
	EntityManager entitymanager;
	static int id=4000;
	User user =new User();
	
	/**************************************************************************************************
	 *Method:add User
	 *description:To add the details into the database
	 *userId                -primary Key
	 *@throws UserException -it is raised due to null id
	 *created by               -Javvadi Suresh
	 *created date             -20-SEP-2020
	**************************************************************************************************/
	@Override
	public boolean adduser(User user) {
		if(true)
		{
			int userId = (getMaxUserId(user.getUserId())+1);
			user.setUserId(userId);
			entitymanager.persist(user); 
			return true; 	
		}
		return false;
			

	}
	
	/**************************************************************************************************
	 *Method:view Users
	 *description:To fetch the details from the database
	 *userId                -primary Key
	 *@returns                 -all the user details
	 *@throws UserException - when users not exist
	 *created by               -Javvadi Suresh
	 *created date             -20-SEP-2020
	**************************************************************************************************/
	@Override
	public List<User> reterive() {
		String Qstr="SELECT user from User user";
		TypedQuery<User> query=entitymanager.createQuery(Qstr,User.class);
		return query.getResultList();
	}
	
	
	/**************************************************************************************************
	 *Method:find User
	 *description:To fetch the particular user details from database the database
	 *userId                -primary Key
	 *@returns                 -all the user details
	 *@throws UserException -it is raised when we enter id which not exist
	 *created by               -Javvadi Suresh
	 *created date             -20-SEP-2020
	**************************************************************************************************/
	@Override
	public User findById(int id) {
		return entitymanager.find(User.class, id);
		
	}
	
	
	/**************************************************************************************************
	 *Method:delete User
	 *description:To delete the  user details from database the database
	 *userId                -primary Key
	 *@returns                -deleted Successfully
	 *@throws UserException -it is raised when we enter id which not exist
	 *created by               -Javvadi Suresh
	 *created date             -20-SEP-2020
	**************************************************************************************************/
	@Override
	public void deleteuser(int id) {
		User show=entitymanager.find(User.class, id);
		entitymanager.remove(show);
		
	}
	
	
	
	/**************************************************************************************************
	 *Method:Update User Details
	 *description:To Update the  user details from database the database
	 *userId                -primary Key
	 *@returns                 -Updated values
	 *@throws UserException -it is raised when we enter id which not exist
	 *created by               -Javvadi Suresh
	 *created date             -20-SEP-2020
	**************************************************************************************************/
	@Override
	public void update(User user ) {
	entitymanager.persist(user);
	
	}
	
	@Override
	public int getMaxUserId(int userId) {
		String jpql = "SELECT user from User user ";
		TypedQuery<User> query = entitymanager.createQuery(jpql, User.class);
	    List<User> userList= query.getResultList();
	    if(!userList.isEmpty())
	    {
	    	String str = "SELECT max(userId) from User";
	    	TypedQuery<Integer> userid = entitymanager.createQuery(str,Integer.class);
	    	int num = userid.getSingleResult();
	    	return num;
	    	
	    }
	    else
	    	return id;
	}
}



