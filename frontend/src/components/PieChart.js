import React, { useEffect, useRef } from "react";
import Chart from "chart.js/auto";

const PieChart = ({ tourSales }) => {
  const chartRef = useRef(null); // Ref to store the chart instance

  useEffect(() => {
    if (tourSales) {
      const labels1 = tourSales.map((e) => e.tourName);
      const data1 = tourSales.map((e) => e.totalSales);

      if (labels1.length > 4) {
        labels1.splice(4, labels1.length - 4);
        labels1.push("Others");
        var othersSales = 0;
        for (var i = 4; i < data1.length; i++) {
          othersSales += data1[i];
        }
        data1.splice(4, data1.length - 4);
        data1.push(othersSales);
      }

      const data = {
        labels: labels1,
        datasets: [
          {
            label: "Total Sales",
            data: data1,
            backgroundColor: [
              "rgb(255, 205, 86)",
              "rgb(121, 222, 67)",
              "rgb(255, 99, 132)",
              "rgb(54, 162, 235)",
              "rgb(119, 119, 120)",
            ],
            hoverOffset: 4,
          },
        ],
      };

      // Options for the pie chart
      const options = {
        responsive: true,
        maintainAspectRatio: false,
      };

      // Get the chart canvas element
      const ctx = document.getElementById("pieChart");

      // Destroy the existing chart instance if it exists
      if (chartRef.current !== null) {
        chartRef.current.destroy();
      }

      // Create the pie chart
      chartRef.current = new Chart(ctx, {
        // type: 'pie',
        data: data,
        options: options,
        type: "doughnut",
      });

      // Clean up function to destroy the chart instance on component unmount
      return () => {
        if (chartRef.current !== null) {
          chartRef.current.destroy();
        }
      };
    }
  }, [tourSales]);

  return (
    <div
      className="shadow border rounded p-2 d-flex justify-content-center align-items-center"
      style={{ height: "100%", width: "100%" }}
    >
      {tourSales?.length >= 1 ? (
        <canvas id="pieChart"></canvas>
      ) : (
        <div>
          <h5 className="text-uppercase fw-bold text-muted ">
            Zero Sales So Far
          </h5>
        </div>
      )}
    </div>
  );
};

export default PieChart;
