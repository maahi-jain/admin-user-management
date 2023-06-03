package com.sample.Login.api;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sample.Login.dto.Success;
import com.sample.Login.dto.AdminDTO;
import com.sample.Login.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping(value="/admin")
public class AdminAPI {

	@Autowired
	private AdminService userService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value="/login")
	public ResponseEntity<AdminDTO> authenticateUser(@RequestBody AdminDTO user) throws LoginException
	{
		try {
			AdminDTO response=userService.findByUserName(user);
			return new ResponseEntity<AdminDTO>(response,HttpStatus.ACCEPTED);	
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<Success> registerUser(@RequestBody AdminDTO user) throws LoginException
	{
		try {
			Success s=userService.addUser(user);
			return new ResponseEntity<Success>(s,HttpStatus.CREATED);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
}
