package com.booking.FlightTicket;

import com.booking.FlightTicket.controller.TicketLog;
import com.booking.FlightTicket.controller.UserLog;
import com.booking.FlightTicket.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping()
@Service
public class FlightTicketApplication {


	 private final CurdUser  cu;
	UserLog ul;
CurdBooking cb;
TicketLog tl;
			 FlightTicketApplication(CurdUser cu, CurdBooking cb){
		 	this.cu=cu;
			  ul=new UserLog(cu);
			  this.cb=cb;
			  tl=new TicketLog(cb,cu);
			 }

	public static void main(String[] args) {
		 SpringApplication.run(FlightTicketApplication.class, args);
	}


	record Res(String Message){}
	@PostMapping("/user")
	public Res create(@RequestBody User user) {
		Res response=new Res("User created");
		if(ul.checkuser(user)){return new Res("Already logged in");}
		ul.addUser(user);
		return  response;
	}
	@GetMapping("/check")
     public Res check(@RequestBody User user){
				 if(ul.checkuser(user)){
					 if(ul.checkpassword(user))
						 return new Res("Verified");
					 else
					 return new Res("Wrong Password");
				 }else {
					 return new Res("User does'nt Exist");
				 }

	}
	@PostMapping("/booking")
	public Res book(@RequestBody BookingBody bookings) throws ParseException {
				 tl.book(bookings);
				 return new Res("Booked successfully");
	}
	@GetMapping("/getTicket/{name}")
	public List<BookingBody> getTicket(@PathVariable String name){
				return tl.getTicket(name);

	}

}
