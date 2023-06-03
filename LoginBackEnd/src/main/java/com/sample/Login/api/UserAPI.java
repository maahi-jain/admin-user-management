package com.sample.Login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sample.Login.dto.Success;
import com.sample.Login.dto.UserDTO;
import com.sample.Login.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="user")
public class UserAPI {

	@Autowired
	private UserService userService;
	
	@PostMapping("add")
	public ResponseEntity<Success> addUser(@RequestBody UserDTO user)
	{
		try {
			Success s=userService.addUser(user);
			return new ResponseEntity<Success>(s, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
		}
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Success> deleteUser(@RequestBody Integer empNo)
	{
		try {
			System.out.println(empNo);
			Success s=userService.deleteUser(empNo);
			return new ResponseEntity<Success>(s, HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
		}
	}
}
