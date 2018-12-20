package com.cash.examen.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cash.examen.models.User;
import com.cash.examen.services.UserService;

@RestController
@RequestMapping("users/")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping()
	@ResponseBody
	public User createUser(@RequestBody User user) throws SQLException {
		return userService.create(user);
	} 
	
	@DeleteMapping(value = "{id}")
	public void deleteUser(@PathVariable("id") Long id){
		userService.delete(id);
	}

}
