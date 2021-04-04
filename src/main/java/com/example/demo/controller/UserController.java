package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.uservo.User;

@RestController
/*
 * @RequestMapping(path="/api/v1", consumes = MediaType.APPLICATION_JSON_VALUE,
 * produces = MediaType.APPLICATION_JSON_VALUE, method=
 * {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}
 * )
 */
@RequestMapping("/api/v1")
@Transactional
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("/users")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		Optional<User> user = service.getUser(id);
		if(user.isPresent()) {
			return ResponseEntity.ok().body(user.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/users/post")
	public User addUser(@RequestBody User user) {
		//User user = new User();
		return service.addUser(user);
	
	}
	
	@PutMapping("/users/update/{id}")
	public User updateUser(@PathVariable("id") int id) {
		Optional<User> user = service.getUser(id);
		return service.updateUser(user);
			
	}
	
	@DeleteMapping("/users/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		service.deleteUser(id);
	}
}
