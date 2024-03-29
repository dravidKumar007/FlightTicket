package com.booking.FlightTicket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_user")
@Service
public class User {
    @Id
    public String name;
    public String password;
    @OneToMany(mappedBy = "_user")
    public List<Bookings> booking;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bookings> getBooking() {
        return booking;
    }

    public void setBooking(List<Bookings> booking) {
        this.booking = booking;
    }
}
