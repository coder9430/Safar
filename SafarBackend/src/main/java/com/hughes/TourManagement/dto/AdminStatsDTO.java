package com.hughes.TourManagement.dto;

import java.util.List;

public class AdminStatsDTO {
	private Integer totalEarnings;
	private Integer totalEarningsThisMonth;
	private Integer totalUsers;
	private List<YearlySalesDTO> yearlySales;
	private List<TourSalesDTO> tourSales;
	private List<MonthlySalesDTO> monthlySales;

	public List<MonthlySalesDTO> getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(List<MonthlySalesDTO> monthlySales) {
		this.monthlySales = monthlySales;
	}

	public Integer getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Integer totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Integer getTotalEarningsThisMonth() {
		return totalEarningsThisMonth;
	}

	public void setTotalEarningsThisMonth(Integer totalEarningsThisMonth) {
		this.totalEarningsThisMonth = totalEarningsThisMonth;
	}

	public Integer getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(Integer totalUsers) {
		this.totalUsers = totalUsers;
	}

	public List<YearlySalesDTO> getYearlySales() {
		return yearlySales;
	}

	public void setYearlySales(List<YearlySalesDTO> yearlySales) {
		this.yearlySales = yearlySales;
	}

	public List<TourSalesDTO> getTourSales() {
		return tourSales;
	}

	public void setTourSales(List<TourSalesDTO> tourSales) {
		this.tourSales = tourSales;
	}
}
