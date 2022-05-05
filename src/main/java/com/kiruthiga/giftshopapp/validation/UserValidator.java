package com.kiruthiga.giftshopapp.validation;

import org.springframework.stereotype.Component;

import com.kiruthiga.giftshopapp.model.User;

@Component
public class UserValidator {

	
	public void userValidation(User user)throws Exception{
		
		String contact = String.valueOf(user.getContactNumber());
		
		if(user.getName()==null ||(user.getName()).trim()=="") {
			throw new Exception("INVALID Name,Enter VALID NAME !!");
		}
		if(user.getEmail()==null || !user.getEmail().contains("@")||  !user.getEmail().contains(".") || user.getEmail().endsWith(".")){
			throw new Exception("INVALID Email Id");
		}
		if(user.getPassword().length()<8 || user.getPassword().length()>15 ) {
			throw new Exception("Invalid Password");
			
		}
		if(contact.length()!=10 || contact.isBlank()||contact.isEmpty()) {
			throw new Exception ("Invalid  Contact Number");
		}
		
	}
}
