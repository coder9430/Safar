package com.hughes.TourManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hughes.TourManagement.model.Admin;
import com.hughes.TourManagement.service.AdminService;

@RestController
@CrossOrigin(origins = "https://safar-seven.vercel.app/")
@RequestMapping("/api/auth")	
public class AdminController {
	
	@Autowired
	private AdminService user_serv;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Admin user) {
		return user_serv.login(user);
	}
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public Admin getUser(@RequestHeader("token") String token) {
		return user_serv.getUser(token);
	}

}
