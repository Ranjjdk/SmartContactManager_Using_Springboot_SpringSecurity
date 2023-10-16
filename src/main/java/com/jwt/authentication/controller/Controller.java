package com.jwt.authentication.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.entity.AuthRequest;
import com.jwt.authentication.service.CustomUserDetailService;
import com.jwt.authentication.service.JwtService;

@RestController
public class Controller {
	
	  
//	    @Autowired
//	    private AuthenticationManager authenticationManager;
//	  @Autowired
//	  CustomUserDetailService customUserDetailService
//	   
	    @Autowired
        private JwtService jwtService;
	    
	      @Autowired   
		  private CustomUserDetailService customUserDetailService;
		
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String welcomePage() {
		
		String text="this is secure page only can access by authorized users";
		
		return text;
		
	}
	
	
	
	@PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest auth) {
		
		
		System.out.println("generate token+++++++++++++++++++++");
		
		
		 
//		Authentication authentication = authenticationManager
//		        .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);

		
//		System.out.println("ajkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//		System.out.println("authRequest.getUsername()"+authRequest.getUsername());
//		System.out.println("authRequest.getPassword()"+authRequest.getPassword());
//		 
//		User loadUserByUsername = (User)customUserDetailService.loadUserByUsername(authRequest.getUsername());
		
	  
		
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
       
		UserDetails loadUserByUsername = customUserDetailService.loadUserByUsername(auth.getUsername());
		String username = loadUserByUsername.getUsername();
		
		if(username.equals(auth.getUsername())){
        
        	System.out.println("trueRRRRRRRRRRRRRRRRRRRRRRRRR");
            return jwtService.generateToken(auth.getUsername());
              }
              else {
      
            throw new UsernameNotFoundException("invalid user request !");
              }
        
    }
	
}
