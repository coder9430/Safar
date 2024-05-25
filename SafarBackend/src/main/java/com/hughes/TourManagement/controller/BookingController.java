package com.hughes.TourManagement.controller;

import java.awt.SystemColor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hughes.TourManagement.model.Booking;
import com.hughes.TourManagement.model.Client;
import com.hughes.TourManagement.service.BookingService;

@RestController
@CrossOrigin(origins = "https://safar-seven.vercel.app/")
@RequestMapping("/api/booking")
public class BookingController {

	@Autowired
	private BookingService booking_serv;

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<String> placeOrder(@RequestHeader("token") String token, @RequestBody Booking booking) {

		return booking_serv.placeOrder(booking, token);
	}

	@RequestMapping(value = "/getorder/{id}", method = RequestMethod.GET)
	public List<Booking> getOrder(@RequestHeader("token") String token, @PathVariable("id") int id) {
		return booking_serv.getOrder(id, token);
	}

}
