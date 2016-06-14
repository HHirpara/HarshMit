package org.controller;

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
		return userService.findById(id);
		 
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public User adduser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);

	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);

	}	

}
