package com.booking.FlightTicket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingBody {


       public Integer ticket_no;
        public String departure;
        public String destination;
        public String date;
        public String time;
        public String flight_name;
        public Integer seat_no;

        public String name;

        // Add getters and setters as needed

}
