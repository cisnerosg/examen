package com.cash.examen.controllers;


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
import org.springframework.web.server.ResponseStatusException;

import com.cash.examen.dto.UserDto;
import com.cash.examen.exceptions.UserException;
import com.cash.examen.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	 
	@GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
		UserDto user;
		try {
			user = userService.findById(id);
	        return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (UserException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	//Creación de nuevo usuario, no incluye Loans
	@PostMapping()
	@ResponseBody
	public UserDto createUser(@RequestBody UserDto user)  {
		try {
			return userService.create(user);
		} catch (UserException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	} 
	
	//Borrado en cascada de usuario
	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable("id") Long id){
		userService.delete(id);
	}

}
