package com.cg.user.dao;

//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.cg.user.entity.User;




public interface UserDao {
	public boolean adduser(User user);

	public List<User> reterive();

	public User findById(int userId);

	public void deleteuser(int userId);

	public void update(User user);
	
	public int getMaxUserId(int userId);

}
