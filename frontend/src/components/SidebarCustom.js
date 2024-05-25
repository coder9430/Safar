import React from "react";
import "./SidebarCustom.css"; // Import CSS for styling
import { RiDashboardFill } from "react-icons/ri";
import { Link } from "react-router-dom";
import { IoAddCircleSharp } from "react-icons/io5";
import { ImStatsBars } from "react-icons/im";

const SidebarCustom = () => {
  return (
    <div className="sidebar sticky-top">
      <ul className="list-group sidebar-items mb-2">
        <Link
          to="/admin/dashboard"
          style={{ textDecoration: "none", color: "inherit" }}
        >
          <li className="list-group-item d-flex gap-2" key={1}>
            <RiDashboardFill className="icons" />

            <h5 className="text-muted">Dashboard</h5>
          </li>
        </Link>
        <Link to="/create" style={{ textDecoration: "none", color: "inherit" }}>
          <li className="list-group-item d-flex gap-2" key={2}>
            <IoAddCircleSharp className="icons" />

            <h5 className="text-muted">Create</h5>
          </li>
        </Link>
        <Link to="/stats" style={{ textDecoration: "none", color: "inherit" }}>
          <li className="list-group-item d-flex gap-2" key={3}>
            <ImStatsBars className="icons" />

            <h5 className="text-muted">Stats</h5>
          </li>
        </Link>
      </ul>
    </div>
  );
};

export default SidebarCustom;
