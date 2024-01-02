package com.booking.FlightTicket.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface CurdBooking extends JpaRepository<Bookings,Integer> {

}
