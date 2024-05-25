package com.hughes.TourManagement.dto;

import java.math.BigDecimal;

public class MonthlySalesDTO {
	private String month;
	private int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private BigDecimal totalSales;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public MonthlySalesDTO(String month, int year, BigDecimal totalSales) {
		super();
		this.month = month;
		this.totalSales = totalSales;
		this.year = year;
	}

	public BigDecimal getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

}
