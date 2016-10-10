package org.controller;

import java.util.Date;
import java.util.List;

import org.bean.User;
import org.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	UserService userService = new UserService();
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers() {
		List<User> listOfUsers = userService.findAll(getClass());
		return listOfUsers;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUser(@PathVariable Long id) {
		User user = userService.findById(id);
		return user;
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public User adduser(@RequestBody User user) {
		Date curerntDate = new Date(System.currentTimeMillis());
		user.setCreated(curerntDate);
		user.setModified(curerntDate);
		if(user.getCreatedBy() == null || user.getCreatedBy() == ""){
			user.setModifiedBy("webservice");
			user.setCreatedBy("webservice");
		}
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		Date curerntDate = new Date(System.currentTimeMillis());
		user.setModified(curerntDate);
		if(user.getModifiedBy() == null || user.getModifiedBy()== "")
			user.setModifiedBy("webservice");
		return userService.updateUser(user);

	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);

	}	

}
