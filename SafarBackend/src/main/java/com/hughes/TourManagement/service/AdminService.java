package com.hughes.TourManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hughes.TourManagement.model.Admin;
import com.hughes.TourManagement.repository.AdminRepository;

@Service
public class AdminService {
	
	@Value("${jwt.expiration}")
	private int jwtExpirationMs;
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Autowired
	private AdminRepository user_repo;
	
	private Security sec=new Security();
	
	public String login(Admin user){
		try
		{
//			System.out.println(user_repo.findByEmail(user.getEmail()).toString());
			if (user_repo.findByEmail(user.getEmail()) == null) {
				user_repo.save(user);
				String token = sec.generateJwtToken(user_repo.findByEmail(user.getEmail()).getId(), jwtExpirationMs, jwtSecret);
				return token;
			} else {
				Admin data = user_repo.findByEmail(user.getEmail());
				String token = sec.generateJwtToken(data.getId(), jwtExpirationMs, jwtSecret);
				return token;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Occured!!!";
		}
		
	}
	
	public Admin getUser(String token) {
	    try {
	        int id = Integer.parseInt(sec.fetchUser(token, jwtSecret));
	        Optional<Admin> data = user_repo.findById(id);
	        return data.orElse(null);
	    } catch (NumberFormatException e) {
	        // Handle invalid token format
	        System.err.println("Invalid token format: " + token);
	        e.printStackTrace();
	        return null;
	    } catch (Exception e) {
	        // Handle other exceptions (e.g., database errors)
	        System.err.println("Error fetching user: " + e.getMessage());
	        return null;
	    }
	}


}
