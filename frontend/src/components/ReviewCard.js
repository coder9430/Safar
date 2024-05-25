import React from "react";
import "./ReviewCard.css";

export default function ReviewCard({ username, destination, text }) {
  return (
    <div className="card review-card">
      <div className="card-body">
        <h6 className="card-title heading-text">{destination}</h6>
        <h6 className="card-text body-text">{text}</h6>
      </div>
      <footer className="blockquote-footer footer-text me-3 mt-1 justify-content-end d-flex">
        {username}
      </footer>
    </div>
  );
}
