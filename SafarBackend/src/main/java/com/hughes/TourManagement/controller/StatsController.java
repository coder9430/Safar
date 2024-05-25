package com.hughes.TourManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hughes.TourManagement.dto.AdminStatsDTO;
import com.hughes.TourManagement.service.StatsService;

@RestController
@CrossOrigin(origins = "https://safar-seven.vercel.app/")
@RequestMapping("/api/stats")
public class StatsController {
	
	@Autowired
	private StatsService stats;
	
	@GetMapping("/earnings")
	public ResponseEntity<AdminStatsDTO> getStats(@RequestHeader("token") String token){
		return stats.getStats(token);
	}

}
