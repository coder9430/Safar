package com.hughes.TourManagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hughes.TourManagement.model.Booking;
import com.hughes.TourManagement.model.Client;
import com.hughes.TourManagement.model.Admin;
import com.hughes.TourManagement.repository.BookingRepository;
import com.hughes.TourManagement.repository.ClientRepository;

@Service
public class BookingService {

	@Value("${jwt.expiration}")
	private int jwtExpirationMs;

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Autowired
	private BookingRepository booking_repo;
	@Autowired
	private ClientRepository client_repo;

	private Security sec = new Security();

	public String CustomDate() {
		LocalDate currentDate = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Format the current date
		String formattedDate = currentDate.format(formatter);

		return formattedDate;
	}

	public ResponseEntity<String> placeOrder(Booking booking, String token) {
		try {
			int id = Integer.parseInt(sec.fetchUser(token, jwtSecret));
			Optional<Client> data = client_repo.findById(id);
			if (data.isPresent()) {
				booking.setClientid(id);
				booking.setClientname(data.get().getName());
				booking.setBookingdate(CustomDate());
				booking_repo.save(booking);
				return ResponseEntity.ok().body("{\"message\": \"Tour Added Successfully!\"}");
			} else {
				return ResponseEntity.badRequest().body("{\"message\": \"Data Not Saved!\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("{\"message\": \"Error Occured!\"}");
		}
	}

	public List<Booking> getOrder(int id, String token) {
		try {
			int ID = Integer.parseInt(sec.fetchUser(token, jwtSecret));
			Optional<Client> data = client_repo.findById(ID);
			if (data.isPresent()) {
				List<Booking> bookings = booking_repo.findByTourid(id);
				return bookings;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
