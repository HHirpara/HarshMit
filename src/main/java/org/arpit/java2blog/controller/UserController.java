package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.bean.User;
import org.arpit.java2blog.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers() {
		UserService userService = new UserService();
		List<User> listOfUsers = userService.findAll(getClass());
		return listOfUsers;
	}



	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUser(@PathVariable Long id) {
		UserService userService = new UserService();
		User user = userService.findById(id);
		return user;
	}

}
