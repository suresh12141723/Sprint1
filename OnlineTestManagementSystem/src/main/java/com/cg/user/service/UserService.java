package com.cg.user.service;

//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.cg.user.entity.User;



public interface UserService {
	public void adduser(User user);

	public List<User> reterive();

	public User findById(int userId);

	public Boolean deleteuser(int userId);

	public void update(int userId,User user);


}