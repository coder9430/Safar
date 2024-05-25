import React from "react";
import bg from "../images/bg.jpg";
import intro from "../images/intro.jpg";
import "./Reviews.css";
import ReviewCard from "./ReviewCard";

export default function Reviews() {
  return (
    <div className="bg container " id="reviews">
      <div className="container-header">
        <h4 className="text-uppercase first-heading ">
          Where Adventures Begin:
        </h4>
        <h2 className="brand-name  ms-2 ">Safar</h2>
        <h2 className="second-heading ">Customer Reviews</h2>
      </div>

      <div className="row mt-4 container-body">
        <div className="col-12 col-sm-7" style={{ height: "100%" }}>
          <div
            className="row first-card p-2  ms-sm-2  d-flex  align-items-center"
            style={{ height: "31%" }}
          >
            <ReviewCard
              username={"Bikash Dalai"}
              destination={"Goa Trip"}
              text={`Safar exceeded all expectations! Their exceptional attention to detail made our trip unforgettable. `}
            />
          </div>
          <div
            className="row middle p-2   d-flex justify-content-end align-items-center"
            style={{ height: "31%" }}
          >
            <ReviewCard
              username={"Anshuman Saini"}
              destination={"Sikkim Trip"}
              text={`Safar made our trip unforgettable! Exceptional service and
            breathtaking experiences. Highly recommend!`}
            />
          </div>
          <div
            className="row p-2 d-flex ms-sm-2 align-items-center"
            style={{ height: "31%" }}
          >
            <ReviewCard
              username={"Aakash"}
              destination={"Manali Trip"}
              text={`Our trip was amazing! The experiences they curated for us were truly breathtaking.`}
            />
          </div>
        </div>
      </div>
    </div>
  );
}
