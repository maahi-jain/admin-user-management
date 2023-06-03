package com.sample.Login.service;

import com.sample.Login.Exception.LoginException;
import com.sample.Login.dto.Success;
import com.sample.Login.dto.UserDTO;

public interface UserService {
	
	public Success deleteUser(Integer empNo) throws LoginException;
	public Success addUser(UserDTO user) throws LoginException;
}
