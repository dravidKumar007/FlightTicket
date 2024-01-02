package com.booking.FlightTicket.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;


@Data
@Service
@Builder

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Bookings {
    @Id
    @SequenceGenerator(
            name = "ticket_seq",
            sequenceName = "ticket_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_seq"
    )
    Integer ticket_no;
    @Column(name = "departure")
    String departure;
    String destination;
    @Temporal(TemporalType.DATE)
    Date date;
    @Temporal(TemporalType.TIME)
    Date time;
    String flight_name;
    Integer seat_no;
    @ManyToOne
    @JoinColumn(name = "_user")
    User _user;

    public Integer getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(Integer ticket_no) {
        this.ticket_no = ticket_no;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public Integer getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(Integer seat_no) {
        this.seat_no = seat_no;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }
}
