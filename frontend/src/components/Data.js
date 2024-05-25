import React from "react";
import "./Data.css";
import { FcSalesPerformance } from "react-icons/fc";
import { FaUsers } from "react-icons/fa";

export default function Data({ monthlyEarnings, totalEarnings, totalUsers }) {
  return (
    <div className="data d-flex gap-4 mb-3 flex-column flex-sm-row">
      <div className="card">
        <div className="card-body">
          <h5 className="mb-0">
            Earnings(Monthly) <FcSalesPerformance size={30} className="mb-1" />
          </h5>

          <h6 className="mb-0 text-muted">₹ {monthlyEarnings}</h6>
        </div>
      </div>
      <div className="card">
        <div className="card-body">
          <h5 className="mb-0">
            Total Earnings{" "}
            <FcSalesPerformance size={30} color="green" className="mb-1" />
          </h5>

          <h6 className="mb-0 text-muted">₹ {totalEarnings}</h6>
        </div>
      </div>

      <div className="card">
        <div className="card-body">
          <h5 className="mb-0">
            Total Customers {" "}
            <FaUsers size={28} className="mb-1" style={{ color: "#8383f2" }} />
          </h5>

          <h6 className="mb-0 text-muted">{totalUsers}</h6>
        </div>
      </div>
    </div>
  );
}
