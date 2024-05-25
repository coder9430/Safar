package com.hughes.TourManagement.dto;

import java.math.BigDecimal;

public class YearlySalesDTO {
	private Integer year;
    private BigDecimal totalSales;
	public Integer getYear() {
		return year;
	}
	public YearlySalesDTO(Integer year, BigDecimal totalSales) {
		super();
		this.year = year;
		this.totalSales = totalSales;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public BigDecimal getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

}
