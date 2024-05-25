package com.hughes.TourManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hughes.TourManagement.model.Tour;
import com.hughes.TourManagement.service.TourService;

@RestController
@CrossOrigin(origins = "https://safar-seven.vercel.app/")
@RequestMapping("/api/pin")	
public class TourController {
	
	@Autowired
	private TourService tservice;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Tour tour, @RequestHeader("token") String token) {
		tservice.saveTour(tour, token);
		return ResponseEntity.ok().body("{\"message\": \"Tour Added Successfully!\"}");
	}
	
	@GetMapping("/displayAll")
	public List<Tour> displayAll(@RequestHeader("token") String token){
		return tservice.findAll(token);
	}
	
	@GetMapping("/displayAllForClient")
	public List<Tour> displayAllForClient(){
		return tservice.findAllForClient();
	}
	
	@GetMapping("/display/{id}")
	public Optional<Tour> display(@PathVariable int id, @RequestHeader("token") String token){
		return tservice.display(id, token);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id, @RequestHeader("token") String token) {
		tservice.deleteById(id, token);
	}
	
	@PutMapping("/edit/{id}")
	public String update(@RequestBody Tour tour,@PathVariable int id, @RequestHeader("token") String token) {
		tservice.update(tour,id, token);
		return "updated successfully!";
	}
	
	
}
