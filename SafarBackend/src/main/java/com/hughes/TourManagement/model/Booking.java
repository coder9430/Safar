package com.hughes.TourManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tourid")
	private int tourid;
	@Column(name = "noofperson")
	private int noofperson;
	@Column(name = "clientname")
	private String clientname;
	@Column(name = "clientid")
	private int clientid;
	@Column(name = "totalprice")
	private int totalprice;
	@Column(name = "bookingdate")
	private String bookingdate;
	
	@ManyToOne
    @JoinColumn(name = "tourid",referencedColumnName="tourId", insertable=false, updatable=false)
    private Tour tour;
	

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	Booking() {

	}

	public int getId() {
		return id;
	}

	public Booking(int tourid, int noofperson, String clientname, int clientid, int totalprice) {
		super();
		this.tourid = tourid;
		this.noofperson = noofperson;
		this.clientname = clientname;
		this.clientid = clientid;
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", tourid=" + tourid + ", noofperson=" + noofperson + ", clientname=" + clientname
				+ ", clientid=" + clientid + ", totalprice=" + totalprice + "]";
	}

	public int getTourid() {
		return tourid;
	}

	public void setTourid(int tourid) {
		this.tourid = tourid;
	}

	public int getNoofperson() {
		return noofperson;
	}

	public void setNoofperson(int noofperson) {
		this.noofperson = noofperson;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

}
