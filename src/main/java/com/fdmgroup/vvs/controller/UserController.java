package com.fdmgroup.vvs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.vvs.model.Role;
import com.fdmgroup.vvs.model.User;
import com.fdmgroup.vvs.service.EmailExistsException;
import com.fdmgroup.vvs.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody User user) throws EmailExistsException{
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user){
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable int id){
		userService.deleteUser(id);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(userService.findAllUser());
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<User> findById(@PathVariable int id){
		return ResponseEntity.ok(userService.findUserById(id));
	}
	
	@RequestMapping("/firstName/{firstName}")
	public ResponseEntity<User> findByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok(userService.findUserByFirstName(firstName));
	}
	
	@RequestMapping("/lastName/{lastName}")
	public ResponseEntity<User> findByLastName(@PathVariable String lastName){
		return ResponseEntity.ok(userService.findUserByLastName(lastName));
	}
	
	@RequestMapping("/email/{email}")
	public ResponseEntity<User> findByEmail(@PathVariable String email){
		return ResponseEntity.ok(userService.findUserByEmail(email));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/username/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.findUserByUsername(username));
	}
	
	@RequestMapping("/role/{role}")
	public ResponseEntity<List<User>> findByRole(@PathVariable Role role){
		return ResponseEntity.ok(userService.findUserByRole(role));
	}
	
	@PostMapping("/loginValidation")
	public ResponseEntity<Boolean> loginValidation(@RequestBody User user){
		return ResponseEntity.ok(userService.validateLogin(user.getUsername(), user.getPassword()));
	}
}
