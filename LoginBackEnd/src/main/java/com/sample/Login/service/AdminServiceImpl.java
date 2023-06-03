package com.sample.Login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sample.Login.Exception.LoginException;
import com.sample.Login.Validator.AdminValidator;
import com.sample.Login.dto.Success;
import com.sample.Login.dto.UserDTO;
import com.sample.Login.dto.AdminDTO;
import com.sample.Login.entity.Admin;
import com.sample.Login.entity.Users;
import com.sample.Login.repo.AdminRepository;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository userRepository;
	
	@Autowired
	private Environment environment;
	
	
	@Override
	public  AdminDTO findByUserName(AdminDTO adminDTO) throws LoginException {
		Optional<Admin> optional= userRepository.findById(adminDTO.getUserName());
		Admin adminFromDB=optional.orElseThrow(()-> new LoginException("Service.USER_NOT_FOUND"));

		if(adminFromDB.getPassword().equals(adminDTO.getPassword()))
		{
			List<UserDTO> userDTOList=new ArrayList<>();
			for(Users users:adminFromDB.getUsers())
			{
				UserDTO user=new UserDTO(users.getEmpId(), users.getName(), users.getContactNumber(), users.getEmailId(), adminDTO);
				userDTOList.add(user);
			}
			AdminDTO admin=new AdminDTO(adminFromDB.getUserName(),
					adminFromDB.getPassword(),
					adminFromDB.getName(),
					adminFromDB.getContactNumber(),
					adminFromDB.getEmailId(),
					adminFromDB.getDOB(),
					userDTOList);
						
			
			return admin;
		}
		else
		{
			throw new LoginException("Service.INVALID_CREDENTIALS");
		}
	}

	@Override
	public Success addUser(AdminDTO userDTO) throws LoginException{
		// TODO Auto-generated method stub
		AdminValidator.validate(userDTO);
		Optional<Admin> optional=userRepository.findById(userDTO.getUserName());
		if(optional.isPresent())
			throw new LoginException("Service.USER_ALREADY_PRESENT");
		Admin user=new Admin();
		user.setUserName(userDTO.getUserName());
		user.setContactNumber(userDTO.getContactNumber());
		user.setDOB(userDTO.getDOB());
		user.setEmailId(userDTO.getEmailId());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		userRepository.save(user);
		Success s=new Success(environment.getProperty("Service.REGISTRATION_SUCCESSFUL"));
		return s;
	}

}
