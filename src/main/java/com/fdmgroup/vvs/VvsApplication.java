package com.fdmgroup.vvs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.fdmgroup.vvs.repository.UserRepository;
import com.fdmgroup.vvs.service.UserService;

@SpringBootApplication
public class VvsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VvsApplication.class, args);
	}
//	  @Bean
//	    public PasswordEncoder getPasswordEncoder(){
//	        return new BCryptPasswordEncoder();
//	    } 
//	@Autowired  
//	public void autenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
//		builder.userDetailsService(new UserDetailsService() {
//			
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				// TODO Auto-generated method stub
//				return new CustomUserDetails(repo.findByUsername(username));
//			}
//		});
//	}
}
