import React, { useEffect, useRef } from "react";
import Chart from "chart.js/auto";

const BarChart = ({ monthlySales }) => {
  const chartRef = useRef(null);

  useEffect(() => {
    if (monthlySales) {
      const labels1 = monthlySales.map((e) => {
        return e.month + " " + e.year;
      });

      const data1 = monthlySales.map((e) => e.totalSales);
      const ctx = chartRef.current.getContext("2d");
      const chart = new Chart(ctx, {
        type: "bar",
        data: {
          labels: labels1,
          datasets: [
            {
              label: "Month Wise Sales",
              data: data1,
              backgroundColor: "rgba(75, 192, 192, 0.2)",
              borderColor: "rgba(75, 192, 192, 1)",
              borderWidth: 1,
            },
          ],
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });

      return () => {
        chart.destroy();
      };
    }
  }, [monthlySales]);

  return (
    <div className="shadow border rounded p-2" style={{height:"100%",width:"100%"}}>
      <canvas ref={chartRef} width="100%" height="73px" />
    </div>
  );
};

export default BarChart;
