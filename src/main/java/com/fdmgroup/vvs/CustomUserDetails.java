//package com.fdmgroup.vvs;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fdmgroup.vvs.model.Role;
//import com.fdmgroup.vvs.model.User;
//
//public class CustomUserDetails implements UserDetails {
//	private String username;
//	private String password;
//	Collection<? extends GrantedAuthority> auth;
//	public CustomUserDetails(User byUsername) {
//		this.username = byUsername.getUsername();
//		this.password = byUsername.getPassword();
//		
//		List<Role> auths = new ArrayList<>();
//		auths.addAll(new SimpleGrantedAuthority(byUsername.getRole()));
//	
//		
//	}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
