package com.hughes.TourManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hughes.TourManagement.model.Tour;
import com.hughes.TourManagement.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByEmail(String email);

}
