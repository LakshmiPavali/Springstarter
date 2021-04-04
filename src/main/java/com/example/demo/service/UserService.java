package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepo;
import com.example.demo.uservo.User;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUser(int id) {
		return userRepo.findById(id);
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(Optional<User> user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}

}
