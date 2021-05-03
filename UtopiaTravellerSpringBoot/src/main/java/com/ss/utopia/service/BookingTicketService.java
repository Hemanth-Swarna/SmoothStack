package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.dao.FlightBookingDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.FlightSeatDAO;
import com.ss.utopia.dao.SeatTypeDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.de.Airport;
import com.ss.utopia.de.Booking;
import com.ss.utopia.de.BookingUser;
import com.ss.utopia.de.Flight;
import com.ss.utopia.de.FlightBooking;
import com.ss.utopia.de.FlightSeat;
import com.ss.utopia.de.SeatType;
import com.ss.utopia.de.User;

@RestController
public class BookingTicketService {

	/*
	 * Gets user_id, origin airport, destination airport, and seat_type from postman
	 * and takes that information to book a ticket.
	 */

	@Autowired
	AirportDAO airportdao;

	@Autowired
	FlightDAO flightdao;

	@Autowired
	UserDAO udao;

	@Autowired
	SeatTypeDAO stdao;

	@Autowired
	FlightSeatDAO seatdao;

	@Autowired
	BookingDAO bdao;
	
	@Autowired
	BookingUserDAO budao;

	@Autowired
	FlightBookingDAO fbdao;

	
	public void bookATicket(int user_id, String ori_airport, String des_airport, String seat_name) {
		if (isTraveler(user_id)) {
			int a = bookTicket(user_id);
			if (a != 0) {
				int b = findFlight(ori_airport, des_airport);
				if (b != 0) {
					boolean c = flightTicket(a, b);
					if (c) {
						seatAssignment(seat_name, b);
					}
				}
			}
		}

	}

	// Validate user as traveler
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

	// Book ticket
//	int booking_id = 0;


	public int bookTicket(int user_id) {
		Booking b = new Booking();
		b.setConfirmationCode(Math.floor((Math.random() * 10000)) + "");
		b.setActive(true);
		int key = 0;
		try {
//			booking_id = bdao.create(b);
//			return booking_id;
			key = bdao.create(b);
			BookingUser bu = new BookingUser();
			bu.setBooking(b);
			User u = udao.get(user_id);
			bu.setUserId(u);
			budao.create(bu);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return key;
	}

	// Find the flight
//	int flight_id = 0;

	public int findFlight(String ori_airport, String des_airport) {
		if (ori_airport.equals(des_airport)) {
			return 0;
		}

		try {
			List<Airport> airports = airportdao.getAll();
			Airport ori = null;
			Airport des = null;
			for (Airport a : airports) {
				if (a.getCode().equals(ori_airport)) {
					ori = a;
				}

				if (a.getCode().equals(des_airport)) {
					des = a;
				}
			}
			List<Flight> flights = flightdao.getAll();

			if (des == null || ori == null) {
				return 0;
			}

			for (Flight f : flights) {
				if (f.getRoute().getOrigin().equals(ori) && f.getRoute().getDestination().equals(des)) {
//					flight_id = f.getId();
//					return flight_id;
					return f.getId();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	// Connect ticket to the flight
	public boolean flightTicket(int booking_id, int flight_id) {
		boolean ret_val = false;
		try {
			FlightBooking fb = new FlightBooking();
			Booking booking = bdao.get(booking_id);
			Flight flight = flightdao.get(flight_id);
			fb.setBooking(booking);
			fb.setFlight(flight);
			if (booking != null && flight != null) {
				fbdao.create(fb);
				ret_val = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ret_val;
	}

	// Address the seat_type in the flight
	public boolean seatAssignment(String type_name, int flight_id) {
		boolean ret_val = false;
		try {
			SeatType seattype = null;
			List<SeatType> seattypes = stdao.getAll();
			for (SeatType st : seattypes) {
				if (st.getName().equals(type_name)) {
					seattype = st;
				}
			}
			if (seattype != null) {
				Flight flight = flightdao.get(flight_id);
				List<FlightSeat> seats = seatdao.getAll();
				if (flight != null && (seats.size() < flight.getPlane().getType().getCapacity())) {
					FlightSeat seat = new FlightSeat();
					seat.setFlight(flight);
					seat.setType(seattype);
					seat.setPrice(599.99F);
					seatdao.create(seat);
					ret_val = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ret_val;

	}

//	@GetMapping("/users")
//	public List<User> getUsers() {
//		try {
//			return udao.getAll();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}
