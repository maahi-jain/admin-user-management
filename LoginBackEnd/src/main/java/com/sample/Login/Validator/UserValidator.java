package com.sample.Login.Validator;

import com.sample.Login.Exception.LoginException;
import com.sample.Login.dto.UserDTO;

public class UserValidator {
	
	public static void validate(UserDTO userDTO) throws LoginException
	{
		if(!validateContactNumber(userDTO.getContactNumber()))
			throw new LoginException("Validator.INVALID_CONTACT");
		
	}
	
	public static boolean validateContactNumber(Long contactNumber) {
		
		if(contactNumber!=null && contactNumber.toString().length()==10)
			return true;
		else
			return false;
	}

}
