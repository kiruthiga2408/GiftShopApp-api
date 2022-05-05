package com.kiruthiga.giftshopapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kiruthiga.giftshopapp.model.User;
import com.kiruthiga.giftshopapp.repository.UserRepository;

import com.kiruthiga.giftshopapp.validation.UserValidator;

@Component
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserValidator userValidator;
	
	public void save(User user) throws Exception{
		try {
			userValidator.userValidation(user);
			userRepository.save(user);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void updateName(int id,String name)throws Exception{
		try {
			User user=userRepository.getById(id);
			if(user==null) {
				throw new Exception("User Not Found");
			}
			else {
				userRepository.changeName(id, name);
			}
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
