package com.hughes.TourManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hughes.TourManagement.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
	public List<Tour> findByAdminId(int id);

}
