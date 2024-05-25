package com.hughes.TourManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hughes.TourManagement.model.Client;
import com.hughes.TourManagement.model.Tour;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	public Client findByEmail(String email);

}
