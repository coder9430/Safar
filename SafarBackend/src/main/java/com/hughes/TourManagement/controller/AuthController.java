package com.hughes.TourManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hughes.TourManagement.service.AuthService;

@RestController
@CrossOrigin(origins = "https://safar-seven.vercel.app/")
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ResponseEntity<String> check(@RequestHeader("token") String token, @RequestHeader("role") String role) {
		return authService.check(token, role);
	}

}
