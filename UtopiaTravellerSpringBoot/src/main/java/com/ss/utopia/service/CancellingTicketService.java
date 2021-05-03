package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.dao.FlightBookingDAO;
import com.ss.utopia.dao.FlightSeatDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.de.Booking;
import com.ss.utopia.de.BookingUser;
import com.ss.utopia.de.Flight;
import com.ss.utopia.de.FlightBooking;
import com.ss.utopia.de.FlightSeat;
import com.ss.utopia.de.User;

@RestController
public class CancellingTicketService {
	
	@Autowired
	UserDAO udao;
	
	@Autowired
	BookingUserDAO budao;
	
	@Autowired
	FlightBookingDAO fbdao;
	
	@Autowired
	BookingDAO bdao;
	
	@Autowired
	FlightSeatDAO fsdao;

	public void cancelATicket(int user_id, int booking_id, int seat_id) {
		if(isTraveler(user_id)) {
			if(bookingExists(booking_id)) {
				if(cancelSeat(booking_id, seat_id)) {
					cancelBooking(booking_id);
				}
			}
		}
	}
	
	public boolean isTraveler(int user_id) {
		boolean ret_val = false;
		try {
			System.out.println(udao.get(user_id));
			User user = udao.get(user_id);
			if (user != null && user.getRole().getId() == 2) {
				ret_val = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return ret_val;
	}
	
	public boolean bookingExists(int booking_id) {
		boolean ret_val = false;
		try {
			Booking booking = bdao.get(booking_id);
			if (booking != null) {
				ret_val = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return ret_val;
	}
	
	public boolean cancelSeat(int booking_id, int seat_id) {
		boolean ret_val = false;
		try {
			FlightBooking flightbooking = fbdao.get(booking_id);
			Flight f = flightbooking.getFlight();
			if(f != null) {
				List<FlightSeat> seats = fsdao.getAll();
				for(FlightSeat s: seats) {
					if(s.getFlight().getId().equals(f.getId()) && (s.getId() == seat_id)) {
						fsdao.delete(s);
						ret_val = true;
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ret_val;
	}
	
	public boolean cancelBooking(int booking_id) {
		boolean ret_val = false;
		try {
			Booking booking = bdao.get(booking_id);
			FlightBooking fb = fbdao.get(booking_id);
			BookingUser buser = budao.get(booking_id);
			fbdao.delete(fb);
			budao.delete(buser);
			bdao.delete(booking);
			ret_val = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ret_val;
	}
	
}
