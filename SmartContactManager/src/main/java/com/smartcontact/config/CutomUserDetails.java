//package com.smartcontact.config;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import com.smartcontact.entities.User;
//
//@Component
//public class CutomUserDetails implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//
//	private User user;
//	
//	public CutomUserDetails() {
//		
//	}
//	
//	public CutomUserDetails(User user) {
//		super();
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
//		return List.of(simpleGrantedAuthority);
//	}
//
//	@Override
//	public String getPassword() {
//		user.getPassword();
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		
//		return user.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		
//		return true;
//	}
//
//}
