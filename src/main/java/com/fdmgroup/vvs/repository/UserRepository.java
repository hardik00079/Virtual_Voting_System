package com.fdmgroup.vvs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.vvs.model.Role;
import com.fdmgroup.vvs.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByFirstName(String firstName);
	Optional<User> findByLastName(String lastName);
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	List<User> findByRole(Role role);
}
