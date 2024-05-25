package com.hughes.TourManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hughes.TourManagement.model.Tour;
import com.hughes.TourManagement.model.Admin;
import com.hughes.TourManagement.repository.TourRepository;
import com.hughes.TourManagement.repository.AdminRepository;

@Service
public class TourService {

	@Value("${jwt.expiration}")
	private int jwtExpirationMs;

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Autowired
	private TourRepository repo;

	@Autowired
	private AdminRepository user_repo;
	private Security sec = new Security();

	public void saveTour(Tour t, String token) {
		try {
			int id = Integer.parseInt(sec.fetchUser(token, jwtSecret));
			Optional<Admin> data = user_repo.findById(id);
			if (data.isPresent()) {
				t.setAdminId(id);
				repo.save(t);
				System.out.println("Saved Successfuly");
			} else {
				System.out.println("Not Saved!!!!");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Tour> findAll(String token) {
		int ID = Integer.parseInt(sec.fetchUser(token, jwtSecret));
		Optional<Admin> data = user_repo.findById(ID);
		if (data.isPresent()) {
			List<Tour> tour = repo.findByAdminId(ID);
			return tour;
		} else
			return null;

	}

	public List<Tour> findAllForClient() {
		return repo.findAll();

	}

	public Optional<Tour> display(int id, String token) {
		return repo.findById(id);

	}

	public void deleteById(int id, String token) {
		int ID = Integer.parseInt(sec.fetchUser(token, jwtSecret));
		Optional<Admin> data = user_repo.findById(ID);
		if (data.isPresent()) {
			repo.deleteById(id);
		} else {
			System.out.println("Not deleted!!!");
			return;
		}
	}

	public void update(Tour tour, int id, String token) {
		int ID = Integer.parseInt(sec.fetchUser(token, jwtSecret));
		Optional<Admin> data = user_repo.findById(ID);
		if (data.isPresent()) {
			Tour previousTour = repo.findById(id).orElse(null);
			previousTour.setDescription(tour.getDescription());
			previousTour.setDays(tour.getDays());
			previousTour.setName(tour.getName());
			previousTour.setPrice(tour.getPrice());
			previousTour.setImage(tour.getImage());
			previousTour.setTimestamp(tour.getTimestamp());
			previousTour.setDestination(tour.getDestination());
			previousTour.setStartDate(tour.getStartDate());
			previousTour.setEndDate(tour.getEndDate());

			repo.save(previousTour);
		} else {
			System.out.println("Error Updating!!!");
			return;
		}
	}

}
