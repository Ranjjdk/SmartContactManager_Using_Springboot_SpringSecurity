package com.smartcontact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartcontact.entities.User;
import com.smartcontact.helper.Message;
import com.smartcontact.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@org.springframework.stereotype.Controller
public class HomeController {
	
	@Autowired
	private UserServiceImpl  userServiceImpl;
	
	
	@GetMapping("/")
	public String home(Model model) {
		
		
		model.addAttribute("title","home smart contact manager");
		
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		
		model.addAttribute("title","about smart contact manager");
		
		return "about";
	}
	@GetMapping("/signup")
	public String signup(Model model) {
		
		
		model.addAttribute("title","about smart contact manager");
		model.addAttribute("user",new User());		
		return "signup";
	 }
   
	@PostMapping("/do-register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,@RequestParam(value ="agreement",defaultValue ="false")
	                              boolean agreement,Model model,HttpSession session) {
		  
		
		
		System.out.println("++++++++++++++/do-register+++++++++++++++++++++");
		
		try {
			
			System.out.println("BindingResult----------------------"+result);
			
			if(!agreement) {
				
				System.out.println("Not agree");
				 throw new Exception("You have not agree terms and condition");
				
			}
			
			if(result.hasErrors()) {
				
				System.out.println("result+++"+result);
				model.addAttribute("user",user);
				
				return "signup";
			}
			
			user.setEnabled(true);
			user.setImageUrl("image.jpgs");
//			user.setContacts(null);
//			
			
			System.out.println("cccsdsd+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("A:"+agreement);
			System.out.println("User:"+user);
			model.addAttribute("user",user);
			Integer id = userServiceImpl.saveUser(user);
			model.addAttribute("result",id);
			session.setAttribute("message",new Message("Successfully registred","success"));
				
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message("somthing went wrong"+":"+e.getMessage(),"dancer"));
			
		}
		return "signup";
	}
	
	
	@GetMapping("/admin")
	@ResponseBody
	public String adminHandler(Model model) {
		
		
		
		return "This is admin Panel ";
	 }
	@RequestMapping("/loginPage")
	public String loginPage(Model model) {
		
		System.out.println("LoginPage+++++++++++++++++++++++++++++++");
		
		return "loginPage";
	 }
	
	
	@PostMapping("/loginProcessing")
	@ResponseBody
	public String loginProccessing(@RequestParam("username") String username,@RequestParam("password") String password) {

		System.out.println("loginProcessing+++++++++++++++++++++++++++++++");
		
		
//		userServiceImpl.loadUserByUsername(username);
		
		return "loginSuccessPage";
	 }
	
	@RequestMapping("/loginSuccessPage")
	@ResponseBody
	public String loginSuccessPage(Model model) {
		
		System.out.println("loginSuccessPage+++++++++++++++++++++++++++++++");
		
		return "SuccessFull login";
	 }
	
	@RequestMapping("/failure")
	@ResponseBody
	public String loginFail(Model model) {
		
		System.out.println("loginSuccessPage+++++++++++++++++++++++++++++++");
		
		return " login failed";
	 }
	

	
}
