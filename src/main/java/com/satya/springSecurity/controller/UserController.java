package com.satya.springSecurity.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.springSecurity.model.User;
import com.satya.springSecurity.service.UserService;

@RestController
public class UserController {
	
	@Autowired private UserService userservice;

	@GetMapping(value="/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>>getAllusers() {
		
		List<User> users = userservice.findAll(); 
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value="/getuser")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User>getUser(Principal principal) {
		
		User user = userservice.getUserByEmail(principal.getName()); 
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
