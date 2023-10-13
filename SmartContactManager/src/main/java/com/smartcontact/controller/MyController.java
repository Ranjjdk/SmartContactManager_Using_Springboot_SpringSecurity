//package com.smartcontact.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class MyController {
//	
//	@GetMapping("/home")
//	public String getHomePage() {
//		return "homePage";
//	}
//	
//	@GetMapping("/welcome")
//	public String getWelcomePage() {
//		return "welcomePage";
//	}
//	
//	@GetMapping("/admin")
//	public String getAdminPage() {
//		
//		
//		
//		System.out.println("Now request reach on controller++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		return "adminPage";
//	}
//	
//	@GetMapping("/emp")
//	public String getEmployeePage() {
//		return "empPage";
//	}
//	
//	@GetMapping("/mgr")
//	public String getManagerPage() {
//		return "mgrPage";
//	}
//	
//	@GetMapping("/hr")
//	public String getHrPage() {
//		return "hrPage";
//	}
//	
//	@GetMapping("/common")
//	public String getCommonPage() {
//		return "commonPage";
//	}
//	
//	@GetMapping("/accessDenied")
//	public String getAccessDeniedPage() {
//		return "accessDeniedPage";
//	}
//	
//	@GetMapping("/save")
//	@ResponseBody
//	public String save(
//			
//			) 
//	
//	{
//		
//		return "registhhh";
//	}
//}