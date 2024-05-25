import React from "react";
import Navbar from "../components/Navbar";
import "./AdminPortal.css";
import TourCard from "../components/TourCard";
import SidebarCustom from "../components/SidebarCustom";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import EditDelete from "../components/EditDelete";
import CardSkeletonUser from "../components/CardSkeletonUser"

export default function AdminPortal() {
  const navigate = useNavigate();
  const [userData, setUserData] = useState(null);
  const [Tour, setTour] = useState(null);

  useEffect(() => {
    let currUser = localStorage.getItem("token");
    const fetchData = async () => {
      const response = await fetch("https://safar-1.onrender.com/api/auth/getuser", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          token: currUser,
        },
      });
      const contentType = response.headers.get("content-type");
      if (!contentType || !contentType.includes("application/json")) {
        return;
      }
      if (!response.ok) {
        setUserData({ id: false });
        navigate("/login");
        console.log("this is running");
        return;
      }
      const json = await response.json();
      setUserData(json);
    };
    if (currUser) fetchData();

    const fetchPin = async () => {
      const response = await fetch(`https://safar-1.onrender.com/api/pin/displayAll`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          token: currUser,
        },
      });
      // console.log(response);
      const contentType = response.headers.get("content-type");
      if (!contentType || !contentType.includes("application/json")) {
        return;
      }
      if (!response.ok) {
        setTour({ tourId: false });
        console.log("this is running");
        return;
      }
      const json = await response.json();
      setTour(json);
    };
    fetchPin();
  }, []);

  return (
    <div className="container d-flex flex-column">
      <Navbar />
      {userData!=null ? (
        <div className="row">
          <div className="col-3">
            <SidebarCustom />
          </div>
          <div className="col-9">
            <div className="welcome-user">
              {userData ? (
                <h4 className="welcome-text pt-0 pt-md-3 text-muted">
                  Welcome {userData.name}
                </h4>
              ) : (
                <h4 className="welcome-text pt-3 text-muted">Welcome User</h4>
              )}
            </div>
            <h4 className="mt-4">All Packages</h4>
            <hr></hr>
            {Tour?.map((data,index) => (
              <>
              <Link
                to={`/tour/${data.tourId}`}
                style={{ textDecoration: "none", color: "inherit" }}
                
              >
                <TourCard data={data} key={index} />
              </Link>
              <EditDelete data={data}/>
              </>
            ))}
          </div>
        </div>
      ): (<h3 className="text-center text-danger">Loading {"  "} <div className="spinner-border text-danger" role="status">
       <span className="sr-only">Loading...</span>
    </div></h3>)}
    </div>
  );
}
