package com.hughes.TourManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hughes.TourManagement.model.Booking;
import com.hughes.TourManagement.model.Admin;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	public List<Booking> findByTourid(int id);
	
	@Query(value="SELECT SUM(totalprice) FROM booking b join tour t on b.tourId=t.tour_id join admin a on a.id=t.admin_id where a.id =:adminId ;",nativeQuery=true)
    Integer getTotalEarningsByAdminId(@Param("adminId") Integer adminId);
	
	@Query(value="SELECT SUM(totalprice) FROM booking b join tour t on b.tourId=t.tour_id join admin a on a.id=t.admin_id where a.id =:adminId and MONTH(b.bookingdate)=MONTH(CURRENT_DATE()) and YEAR(b.bookingdate)=YEAR(CURRENT_DATE());",nativeQuery=true)
	Integer getEarningsForCurrentMonth(@Param("adminId") Integer adminId);
	
	@Query(value="SELECT COUNT(DISTINCT(b.clientid)) FROM booking b join tour t on b.tourId=t.tour_id join admin a on a.id=t.admin_id where a.id =:adminId ;",nativeQuery=true)
	Integer getTotalUsers(@Param("adminId") Integer adminId);
	
	@Query(value="SELECT YEAR(b.bookingdate) AS year, SUM(b.TotalPrice) AS totalSales  FROM booking b join tour t on b.tourId=t.tour_id join admin a on a.id=t.admin_id where a.id =:adminId GROUP BY YEAR(b.bookingdate) ORDER BY YEAR(b.bookingdate);",nativeQuery=true)
	List<Object[]> getYearWiseSales(@Param("adminId") Integer adminId);
	
	@Query(value="SELECT t.name as tourname, SUM(b.TotalPrice) AS totalSales  FROM booking b join tour t on b.tourId=t.tour_id join admin a on a.id=t.admin_id where a.id =:adminId GROUP BY t.name ORDER BY SUM(b.totalPrice) DESC;",nativeQuery=true)
	List<Object[]> getTourWiseSales(@Param("adminId") Integer adminId);
	
	@Query(value="SELECT MONTHNAME(b.bookingdate) as month, YEAR(b.bookingdate) as year, SUM(b.TotalPrice) AS totalSales  FROM booking b join tour t on b.tourId=t.tour_id join admin a on a.id=t.admin_id where a.id =:adminId GROUP BY MONTHNAME(b.BookingDate),MONTH(b.bookingdate),YEAR(b.bookingdate) ORDER BY YEAR(b.bookingdate),MONTH(b.bookingdate) LIMIT 5;",nativeQuery=true)
	List<Object[]> getMonthlyWiseSales(@Param("adminId") Integer adminId);
	
	
	
	
}
