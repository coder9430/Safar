import React, { useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import SidebarCustom from "../components/SidebarCustom";
import PieChart from "../components/PieChart";
import MyCalendar from "../components/MyCalendar";
import Data from "../components/Data";
import LineChart from "../components/LineChart";

const Stats = () => {
  const [refresh, updateRefresh] = useState(false);
  const [data, setData] = useState({});

  useEffect(() => {
    fetch("https://safar-1.onrender.com/api/stats/earnings", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        token: localStorage.getItem("token"),
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        // Handle any errors that occurred during the fetch
        console.error("Fetch error:", error);
      });
  }, []);

  const handleRefresh = () => {
    updateRefresh(!refresh);
  };

  return (
    <div className="container ">
      <Navbar />

      <div className="row">
        <div className="col-2 col-md-3">
          <SidebarCustom />
        </div>
        <div className="col-10 col-md-9 ">
          <>
            <div className="row">
              <Data
                monthlyEarnings={data.totalEarningsThisMonth}
                totalEarnings={data.totalEarnings}
                totalUsers={data.totalUsers}
              />
            </div>
            <div className="d-flex flex-column gap-1 mb-4">
            <div className="row mb-4">
              <div className="col-12 mb-4 mb-sm-0 col-sm-8">
                <LineChart yearlySales={data.yearlySales} />
              </div>

              <div className=" col-12 mb-4 mb-sm-0 col-sm-4 ">
                <PieChart tourSales={data.tourSales} />
              </div>
            </div>
            <div className="row mt-4">
              <div className="col-12 mb-4 mb-sm-0 col-sm-7">
                <BarChart monthlySales={data.monthlySales} />
              </div>
              <div className="col-12 mb-4 mb-sm-0 col-sm-5">
                <MyCalendar />
              </div>
            </div>
            </div>
            
          </>
        </div>
      </div>
    </div>
  );
};

export default Stats;
