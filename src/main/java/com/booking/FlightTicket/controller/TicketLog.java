package com.booking.FlightTicket.controller;

import com.booking.FlightTicket.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketLog {
    CurdUser cu;
    CurdBooking cb;
    public TicketLog(CurdBooking cb,CurdUser cu) {
        this.cb = cb;
        this.cu = cu;
    }
    public void book(BookingBody bookingBody) throws ParseException {

        Bookings booking=new Bookings();
        booking.setDeparture(bookingBody.departure);
        booking.setDestination(bookingBody.destination);
        booking.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(bookingBody.date));
        booking.setTime( new SimpleDateFormat("HH:mm:ss").parse(bookingBody.time));
        booking.setFlight_name(bookingBody.flight_name);
        booking.setSeat_no(bookingBody.seat_no);
        User user;
        if (cu.findById(bookingBody.name).isPresent()) {
            user= cu.findById(bookingBody.name).get();
        booking.set_user(user);}
        cb.save(booking);

    }

    public List<BookingBody> getTicket(String name) {
List<BookingBody> bookingBody = new ArrayList<BookingBody>();
        List<Bookings> book= cu.findById(name).get().booking;
        int i=0;
        for (Bookings b:book) {
            BookingBody bb=new BookingBody();
        bb.ticket_no= b.getTicket_no();
         bb.name=name;
         bb.date= b.getDate().toString();
         bb.departure= b.getDeparture();
         bb.time= b.getTime().toString();
         bb.seat_no=b.getSeat_no();
         bb.flight_name=b.getFlight_name();
         bb.destination=b.getDestination();
         bookingBody.add(bb);
        }
        return bookingBody;
    }
}
