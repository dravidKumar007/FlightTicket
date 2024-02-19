package com.booking.FlightTicket.controller;

import com.booking.FlightTicket.model.CurdUser;
import com.booking.FlightTicket.model.User;

public class UserLog {

    public CurdUser cu ;

    public UserLog(CurdUser cu) {
        this.cu = cu;
    }
    public void addUser(User user) {
        cu.save(user);
    }

    public boolean checkuser(User user) {
        return cu.findById(user.name).isPresent();
    }

    public boolean checkpassword(User user) {
       return cu.findById(user.name).get().password.equals(user.password);
    }
}
