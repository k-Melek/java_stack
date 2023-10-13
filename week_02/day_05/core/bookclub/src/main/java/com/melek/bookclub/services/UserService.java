package com.melek.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.melek.bookclub.models.LoginUser;
import com.melek.bookclub.models.User;
import com.melek.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	// Register Method -----------------------------------
	
	public User register(User newUser, BindingResult result) {
		// Check if mail exists = validation
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "Email is taken");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registerError", "Passwords DONT match!");
		}
		if(result.hasErrors()) {
			return null;
		} else {
			// No errors >>> Hash password and Save user
			String hashPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashPW);
			return userRepo.save(newUser);
		}
	}
	
	// Login Method ---------------------------------------
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		// Check if Mail found in database
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "Email / Password incorrect Email");
		} else {
			// Grab user to check Password = validation
			User user = potentialUser.get();
			if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginError", "Email / Password incorrect pass");
			}
			if(result.hasErrors()) {
				return null;
			} else {
				return user;
			}
		}
		return null;
	}
	
	
	// Find USER by ID --------------------------------------
	
	public User findById(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		} else {
			return null;
		}
	}
	
	
	
}
