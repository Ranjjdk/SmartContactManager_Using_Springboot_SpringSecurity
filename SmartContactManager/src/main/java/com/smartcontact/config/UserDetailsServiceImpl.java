////package com.smartcontact.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.smartcontact.dao.UserRepository;
//
//
//@Component
//public class UserDetailsServiceImpl  implements UserDetailsService{
//	
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	public UserDetailsServiceImpl() {}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	
////		User user = userRepository.getUserByUsername(username);
////		
////		if(user==null) {
////			
////			throw new UsernameNotFoundException("Could not found user");
////		}
////		CutomUserDetails cutomUserDetails=new CutomUserDetails(user);
////		
////		return cutomUserDetails;
//		return null;
//	}
//
//}
