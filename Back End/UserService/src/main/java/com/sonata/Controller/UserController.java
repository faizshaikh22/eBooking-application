package com.sonata.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.Model.User;
import com.sonata.Repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	Optional<User> u;
	
	@GetMapping("")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity getUserById(@PathVariable (value = "userId") Long userId) {
		u = repo.findById(userId);
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity updateUser(@PathVariable (value = "userId") Long userId,
			@Validated @RequestBody User userDetails) {
		u = repo.findById(userId);
		User u2 = u.get();
		
		u2.setUserId(userId);
		u2.setUserName(userDetails.getUserName());
		u2.setUserEmail(userDetails.getUserEmail());
		u2.setUserPassword(userDetails.getUserPassword());
		u2.setContactNumber(userDetails.getContactNumber());
		
		User updateU = repo.save(u2);
		return ResponseEntity.ok(updateU);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity deleteUser(@PathVariable (value = "userId") Long userId) {
		repo.deleteById(userId);
		return ResponseEntity.noContent().build();
	}

}
