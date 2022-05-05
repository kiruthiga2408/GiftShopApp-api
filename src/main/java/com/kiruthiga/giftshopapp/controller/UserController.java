package com.kiruthiga.giftshopapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiruthiga.giftshopapp.model.User;
import com.kiruthiga.giftshopapp.repository.UserRepository;
import com.kiruthiga.giftshopapp.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping("User/save")  
     public ResponseEntity<?> register(@RequestBody User user){
    	
    	try {
    		userService.save(user);
    		return new ResponseEntity<String>("Success",HttpStatus.OK);
    	}
    	catch (Exception e) {
    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    	}
     }

	@DeleteMapping("Users/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}

	@PutMapping("User/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		userRepository.save(user);
	}

	@GetMapping("User/listUser")
	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;

	}

	@GetMapping("User/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User obj = user.get();
			return obj;
		} else {
			return null;

		}

	}

	@PostMapping("users/login")
	public User login(@RequestBody User user) {
		Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (userObj.isPresent()) {
			return userObj.get();
		} else {
			return null;
		}

	}

}
