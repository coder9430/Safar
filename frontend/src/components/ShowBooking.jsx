import React from "react";
import { useEffect, useState } from "react";
import { useParams } from "react-router";
import Navbar from "./Navbar";
import "./ShowBooking.css";

const ShowBooking = () => {
  const [booking, setBooking] = useState([]);
  const [data, setData] = useState(null);
  const { tourId } = useParams();
  useEffect(() => {
    let currUser = localStorage.getItem("token");

    const fetchData = async () => {
      const response = await fetch(
        `https://safar-1.onrender.com/api/booking/getorder/${tourId}`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            token: currUser,
          },
        }
      );

      const contentType = response.headers.get("content-type");
      if (!contentType || !contentType.includes("application/json")) {
        return;
      }
      if (!response.ok) {
        setBooking({ id: false });
        console.log("this is running");
        return;
      }
      const json = await response.json();

      setBooking(json);
    };

    const fetchUserData = async () => {
      try {
        const response = await fetch(
          `https://safar-1.onrender.com/api/pin/display/${tourId}`,
          {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
              token: localStorage.getItem("token"), // Replace 'your_access_token' with your actual token
            },
          }
        );
        if (!response.ok) {
          throw new Error("Failed to fetch data");
        }
        const jsonData = await response.json();
        setData(jsonData);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
    fetchUserData();
  }, []);

  return (
    <div className="container table-contain">
      <Navbar />

      {booking.length >= 1 ? (
        <div className="table-responsive">
        <table className=" table table-hover ">
          <thead>
            <tr className="table-danger border-1">
              <th scope="col">Booking ID</th>
              <th scope="col">Tour ID</th>
              <th scope="col">Tour Name</th>
              <th scope="col">Client ID</th>
              <th scope="col">Client Name</th>
              <th scope="col">Number of Persons</th>
              <th scope="col">Total Price</th>
              <th scope="col">Booking Date</th>
            </tr>
          </thead>
          <tbody>
            {booking.map((bookingItem, index) => (
              <tr key={index}>
                <th scope="row">{bookingItem.id}</th>
                <td>{bookingItem.tourid}</td>
                <td>{data.name}</td>
                <td>{bookingItem.clientid}</td>
                <td>{bookingItem.clientname}</td>
                <td>{bookingItem.noofperson}</td>
                <td>{bookingItem.totalprice}</td>
                <td>{bookingItem.bookingdate}</td>
              </tr>
            ))}
          </tbody>
        </table>
        </div>
      ) : (
        <>
          <h4 className="text-uppercase text-light not-avail fw-bold text-center mt-4">
            No Bookings Right Now
          </h4>
        </>
      )}
    </div>
  );
};

export default ShowBooking;
