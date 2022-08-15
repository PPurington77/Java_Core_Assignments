package com.purington.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.purington.bookclub.models.LoginUser;
import com.purington.bookclub.models.User;
import com.purington.bookclub.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//CREATE
	//user registration
	public User register(User newUser, BindingResult result) {
		
		//check if email is already in db
		if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "unique", "Email is already in use");
		}
		
		//make sure passwords match
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Paswords must match");
		}
		
		//final check for any other errors
		if(result.hasErrors()) {
			return null;
		}
		
		//hash and set password
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return userRepository.save(newUser);
	}
	
	//login user
	public User login(LoginUser newLogin, BindingResult result) {
		
		//check for errors
		if(result.hasErrors()) {
			return null;
		}
		
		//check if email is in the db
		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "Invalid Credentials");
			
			return null;
		}
		
		//check if password matches password in the db
		User user = potentialUser.get(); //gets user object from the optional user
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Invalid Credentials");
		}
		
		return user;
		
		}
	//Rest of Crud BELOW
		
	//Read User
	public User getOne(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//find all
	public List<User> allUsers() {
		return this.userRepository.findAll();
	}
		
	//Update
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	//Delete
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
