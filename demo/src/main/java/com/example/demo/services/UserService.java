package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;

@Service
public class UserService {
    static UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	public static void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}

	public static List<User> getAllUsers(){
    	return userRepository.findAll();
    }
	public static User saveOneUser(User newUser) {

		return userRepository.save(newUser);
	}
	public static User getOneUser(Long userId) {

		return userRepository.findById(userId).orElse(null);
	}
	public static Optional<User> findById(Long userId) {
		
		return userRepository.findById(userId);
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = UserService.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}
}
