import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import { FaCalendarAlt } from "react-icons/fa";

const MyCalendar = () => {
  // State to store the selected date
  const [date, setDate] = useState(new Date());

  // Function to handle date change
  const handleDateChange = (newDate) => {
    setDate(newDate);
  };

  return (
    <div className='shadow border rounded p-2'>
      <h6 className='text-uppercase text-center my-3 mb-2'> <FaCalendarAlt size={20} style={{color:"#8383f2"}} className='mb-1'/>  Calendar </h6>
      <div className='calendar'>
        <Calendar onChange={handleDateChange} value={date} />
      </div>
    </div>
  );
};

export default MyCalendar;
