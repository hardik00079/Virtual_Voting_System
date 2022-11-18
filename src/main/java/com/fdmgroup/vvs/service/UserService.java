package com.fdmgroup.vvs.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.vvs.model.Role;
import com.fdmgroup.vvs.model.User;
import com.fdmgroup.vvs.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	@Autowired
//	private PasswordEncoder passwordEncoder;
//	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User addUser(User user)  {
//		if (emailExist(user.getEmail())) {
//	        throw new EmailExistsException(
//	          "There is an account with that email adress:" + user.getEmail());
//	    }
//	    User u = new User();
//	    u.setFirstName(user.getFirstName());
//	    u.setLastName(user.getLastName());
//	    u.setUsername(user.getUsername());
//	    u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//	    
//	    u.setEmail(user.getEmail());
//	    u.setRole(Role.admin);
		return userRepository.save(user);
	}
	
//	private boolean emailExist(String email) {
//		// TODO Auto-generated method stub
//		List<User> users = userRepository.findAll();
//		for(User u : users) {
//			if(u.getEmail().equals(email)) {
//				return true;
//			}
//		}
//		return false;
//	}

	public void deleteUser(int id) {
		userRepository.delete(findUserById(id));
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	
	public User findUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) return user.get();
		
		throw new NullPointerException("User not found.");
	}
	
	public User findUserByFirstName(String firstName) {
		Optional<User> user = userRepository.findByFirstName(firstName);
		
		if(user.isPresent()) return user.get();
		
		throw new NullPointerException("User not found.");
	}
	
	public User findUserByLastName(String lastName) {
		Optional<User> user = userRepository.findByLastName(lastName);
		
		if(user.isPresent()) return user.get();
		
		throw new NullPointerException("User not found.");
	}
	
	public User findUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		
		if(user.isPresent()) return user.get();
		
		throw new NullPointerException("User not found.");
	}
	
	public User findUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		
		if(user.isPresent()) return user.get();
		
		throw new NullPointerException("User not found.");
	}
	
	public List<User> findUserByRole(Role role) {
		return userRepository.findByRole(role);
	}
	
	public boolean validateLogin(String username, String password) {
		if(findUserByUsername(username).getPassword().equals(password)) return true;
		
		return false;
	}


}
