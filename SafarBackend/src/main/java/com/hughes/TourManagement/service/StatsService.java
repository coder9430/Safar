package com.hughes.TourManagement.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hughes.TourManagement.dto.AdminStatsDTO;
import com.hughes.TourManagement.dto.MonthlySalesDTO;
import com.hughes.TourManagement.dto.TourSalesDTO;
import com.hughes.TourManagement.dto.YearlySalesDTO;
import com.hughes.TourManagement.model.Admin;
import com.hughes.TourManagement.repository.AdminRepository;
import com.hughes.TourManagement.repository.BookingRepository;

@Service
public class StatsService {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private Security security;

	@Autowired
	private BookingRepository bookingRepository;

	public ResponseEntity<AdminStatsDTO> getStats(String token) {
		try {
			int adminId = Integer.parseInt(security.fetchUser(token, jwtSecret));
			Optional<Admin> adminOptional = adminRepository.findById(adminId);
			if (adminOptional.isPresent()) {
				Integer earnings = bookingRepository.getTotalEarningsByAdminId(adminId);
				Integer earningsThisMonth = bookingRepository.getEarningsForCurrentMonth(adminId);
				Integer users = bookingRepository.getTotalUsers(adminId);
				List<Object[]> yearlySalesData = bookingRepository.getYearWiseSales(adminId);
				List<Object[]> tourSalesData = bookingRepository.getTourWiseSales(adminId);
				List<Object[]> monthlySalesData = bookingRepository.getMonthlyWiseSales(adminId);

				List<YearlySalesDTO> yearlySalesDTOList = new ArrayList<>();
				for (Object[] result : yearlySalesData) {
					Integer year = (Integer) result[0];
					BigDecimal totalSales = (BigDecimal) result[1];
					yearlySalesDTOList.add(new YearlySalesDTO(year, totalSales));
				}

				List<TourSalesDTO> tourSalesList = new ArrayList<>();
				for (Object[] result : tourSalesData) {
					String tourname = (String) result[0];
					BigDecimal totalSales = (BigDecimal) result[1];
					tourSalesList.add(new TourSalesDTO(tourname, totalSales));
				}

				List<MonthlySalesDTO> monthlySalesList = new ArrayList<>();
				for (Object[] result : monthlySalesData) {
					String month = (String) result[0];
					Integer year = (Integer) result[1];
					BigDecimal totalSales = (BigDecimal) result[2];
					monthlySalesList.add(new MonthlySalesDTO(month, year, totalSales));
				}

				AdminStatsDTO adminStatsDTO = new AdminStatsDTO();
				adminStatsDTO.setTotalEarnings(earnings != null ? earnings : 0); // Handle null values
				adminStatsDTO.setTotalEarningsThisMonth(earningsThisMonth != null ? earningsThisMonth : 0);
				adminStatsDTO.setTotalUsers(users != null ? users : 0); // Handle null values
				adminStatsDTO.setYearlySales(yearlySalesDTOList != null ? yearlySalesDTOList : new ArrayList<>());
				adminStatsDTO.setTourSales(tourSalesList != null ? tourSalesList : new ArrayList<>());
				adminStatsDTO.setMonthlySales(monthlySalesList != null ? monthlySalesList : new ArrayList<>());

				return ResponseEntity.ok().body(adminStatsDTO);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Internal server error
		}

	}
}
