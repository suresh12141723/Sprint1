package com.cg.user.controller;
//import java.util.List;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.user.entity.User;
import com.cg.user.exception.UserException;
import com.cg.user.service.UserService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a Controller method for adding the user details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
        //showservice.addshow(show);;
		userservice.adduser(user);
        
		return new ResponseEntity<String>("User Added Successfully",HttpStatus.OK);
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a Controller method for getting the user details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/getuser")
    public ResponseEntity<List<User>> getuserlist() {
			List<User> list = userservice.reterive();
					//showservice.reterive();
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a Controller for deleting the user details BY  Id
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id)
	{
		//showservice.deleteshow(id);
		userservice.deleteuser(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	
	
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a Controller mehod for getting the user details By ID
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/view/{id}")
	public ResponseEntity<User> viewUser(@PathVariable("id") int id)
	{
		User user = userservice.findById(id);
				//showservice.findById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		//return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		
	}
	
	

	/********************************************************************************************************************
	*       @author           Javvadi Suresh
	*       Description       It is a Controller method for Updating the user details
	*       version           1.0
	*       created date      20-SEP-2020
	********************************************************************************************************************/
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") int id,@RequestBody User user)
	{
		//showservice.update(id,show);
		userservice.update(id, user);
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
	}

}
