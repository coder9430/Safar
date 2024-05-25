package com.hughes.TourManagement.dto;

import java.math.BigDecimal;

public class TourSalesDTO {

	private String tourName;
	private BigDecimal totalSales;

	public TourSalesDTO(String tourName, BigDecimal totalSales) {
		super();
		this.tourName = tourName;
		this.totalSales = totalSales;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public BigDecimal getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

}
