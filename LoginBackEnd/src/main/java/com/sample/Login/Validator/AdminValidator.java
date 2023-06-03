package com.sample.Login.Validator;

import java.time.LocalDate;

import com.sample.Login.Exception.LoginException;
import com.sample.Login.dto.AdminDTO;

public class AdminValidator {
	
	public static void validate(AdminDTO user) throws LoginException
	{
		if(!validatePassword(user.getPassword()))
			throw new LoginException("Validator.INVALID_PASSWORD");
		else if(!validateContact(user.getContactNumber()))
			throw new LoginException("Validator.INVALID_CONTACT");
//		else if(!validateDOB(user.getDOB()))
//			throw new LoginException("Validator.INVALID_DOB");
		
	}
	
	public static Boolean validatePassword(String password) {
		String regex1=".*[A-z].*";
		String regex2=".*[0-9].*";
		String regex3=".*[@!$#%&].*";
		if(password.length()>=8 && password.matches(regex1) && password.matches(regex2) && password.matches(regex3))
		{
			return  true;
		}
		else
			return false;
	}
	
	public static Boolean validateContact(Long contact)
	{
		if(contact.toString().length()==10)
			return true;
		else
			return false;
	}
	
	public static Boolean validateDOB(LocalDate DOB)
	{
		if(DOB.isAfter(LocalDate.now()))
			return false;
		else
			return true;
	}

}
