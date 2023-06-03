package com.sample.Login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sample.Login.Exception.LoginException;
import com.sample.Login.Validator.UserValidator;
import com.sample.Login.dto.Success;
import com.sample.Login.dto.UserDTO;
import com.sample.Login.entity.Admin;
import com.sample.Login.entity.Users;
import com.sample.Login.repo.AdminRepository;
import com.sample.Login.repo.UserRepository;

@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private Environment environment;
	
	@Override
	public Success addUser(UserDTO userDTO) throws LoginException {
		UserValidator.validate(userDTO);
		Users user=new Users();
		user.setContactNumber(userDTO.getContactNumber());
		user.setEmailId(userDTO.getEmailId());
		user.setName(userDTO.getName());
	
		
		 Optional<Admin> optional=adminRepository.findById(userDTO.getAdmin().getUserName());
		 Admin admin=optional.orElseThrow(()-> new LoginException("Service.USER_NOT_FOUND"));
		 
		 user.setAdmin(admin);
		 userRepository.save(user);
		 
		 
		Success s=new Success(environment.getProperty("Service.USER_CREATED"));
		return s;
	}

	@Override
	public Success deleteUser(Integer empNo) throws LoginException {
		// TODO Auto-generated method stub
		Optional<Users> optional=userRepository.findById(empNo);
		Users user=optional.orElseThrow(()->new LoginException("Service.USER_NOT_FOUND"));
		user.setAdmin(null);
		System.out.println(user);
		
		userRepository.delete(user);
		Success s =new Success(environment.getProperty("Service.DELETE_USER"));
		return s;
	}

}
