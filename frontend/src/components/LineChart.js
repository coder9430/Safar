import React, { useEffect, useRef } from "react";
import Chart from "chart.js/auto"; // Import Chart.js

const LineChart = ({ yearlySales }) => {
  const chartRef = useRef(null); // Ref to store the chart instance

  useEffect(() => {
    if (yearlySales) {
      const labels1 = yearlySales.map((e) => e.year);
      const data1 = yearlySales.map((e) => e.totalSales);

      const labels = labels1;
      const data = {
        labels: labels,
        datasets: [
          {
            label: "Year Wise Sales",
            data: data1,
            fill: false,
            borderColor: "rgb(75, 192, 192)",
            tension: 0.1,
          },
        ],
      };

      // Options for the line chart
      const options = {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          y: {
            beginAtZero: true, // Start the y-axis scale at 0
          },
        },
      };

      // Get the chart canvas element
      const ctx = document.getElementById("lineChart");

      // Destroy the existing chart instance if it exists
      if (chartRef.current !== null) {
        chartRef.current.destroy();
      }

      // Create the line chart
      chartRef.current = new Chart(ctx, {
        type: "line",
        data: data,
        options: options,
      });

      // Clean up function to destroy the chart instance on component unmount
      return () => {
        if (chartRef.current !== null) {
          chartRef.current.destroy();
        }
      };
    }
  }, [yearlySales]);

  return (
    <div className="shadow border rounded p-2">
      <canvas id="lineChart" height="300px"></canvas>
    </div>
  );
};

export default LineChart;
