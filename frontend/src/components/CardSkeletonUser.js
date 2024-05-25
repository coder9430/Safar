import React from "react";
import Skeleton from "react-loading-skeleton";
import "react-loading-skeleton/dist/skeleton.css";

export default function CardSkeletonUser({ number }) {
  return (
    <div>
      <div className="card my-3  " style={{ maxWidth: "100vw" }}>
        <div className="row g-0">
          <div className="col-md-4 p-2" style={{ height: "250px" }}>
            <Skeleton height={"96%"} width={"100%"} />
          </div>
          <div className="col-md-8 " style={{ height: "250px" }}>
            <div className="card-body d-flex flex-column gap-2">
              <Skeleton height={30} width={"80%"} />
              <Skeleton height={20} />
              <Skeleton height={15} count={3} />
              <div className="d-flex justify-content-between flex-row">
                <Skeleton height={15} width={50} />
                <Skeleton height={15} width={50} />
                <Skeleton height={15} width={50} />
              </div>
              <div className="d-flex justify-content-end">
                <Skeleton height={20} width={200} />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
