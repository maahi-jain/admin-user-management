package com.sample.Login.service;

import com.sample.Login.Exception.LoginException;
import com.sample.Login.dto.Success;
import com.sample.Login.dto.AdminDTO;

public interface AdminService {
	public AdminDTO findByUserName(AdminDTO user) throws LoginException;
	public Success addUser(AdminDTO user) throws LoginException;
	
}
