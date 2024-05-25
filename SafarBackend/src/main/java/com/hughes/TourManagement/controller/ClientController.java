package com.hughes.TourManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hughes.TourManagement.model.Client;
import com.hughes.TourManagement.model.Admin;
import com.hughes.TourManagement.service.ClientService;

@RestController
@CrossOrigin(origins = "https://safar-seven.vercel.app/")
@RequestMapping("/api/client")	
public class ClientController {

	@Autowired
	private ClientService client_serv;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Client client) {
		return client_serv.login(client);
	}
	
	@RequestMapping(value = "/getclient", method = RequestMethod.GET)
	public Client getUser(@RequestHeader("token") String token) {
		return client_serv.getClient(token);
	}
}
