import React from "react";
import { Link } from "react-router-dom";
import Swal from 'sweetalert2';

export default function EditDelete({ data }) {
  const handleDelete = async () => {
    try {
      // Make API call to delete the element
      const response = await fetch(
        `https://safar-1.onrender.com/api/pin/delete/${data.tourId}`,
        {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
            token: localStorage.getItem("token"),
          },
        }
      );
      if (!response.ok) {
        throw new Error("Failed to delete data");
      }
      Swal.fire({
        icon: 'danger',
        title: 'Deleted!',
        text: 'Tour Deleted Successfully!',
      });
      setTimeout(()=>{
        window.location.href = "/admin/dashboard";
      },1000)
      
    } catch (error) {
      console.error("Error deleting data:", error);
    }
  };
  return (
    <div className="container">
      <div className="d-flex gap-3 justify-content-end">
        <Link
          to={`/edit/${data.tourId}`}
          className="btn text-white fw-bold border-0"
          style={{ minWidth: "90px" }}
        >
          Edit
        </Link>
        <button
          className="btn text-white fw-bold border-0"
          style={{ minWidth: "90px" }}
          onClick={handleDelete}
        >
          Delete
        </button>
      </div>
    </div>
  );
}
