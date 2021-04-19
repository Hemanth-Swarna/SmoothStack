/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.FlightBookings;

/**
 * @author heman
 *
 */
public class FlightBookingsDAO extends BaseDAO<FlightBookings> {

	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	public Integer addFlightBooking(FlightBookings flightbooking) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO flight_bookings (flight_id, booking_id) values (?,?)",
				new Object[] { flightbooking.getFlight().getId(), flightbooking.getBooking().getId() });
	}

	public void deleteaddFlightBooking(FlightBookings flightbooking) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight_bookings where flight_id = ? and booking_id = ?",
				new Object[] { flightbooking.getFlight().getId(), flightbooking.getBooking().getId() });
	}

	public List<FlightBookings> getAllBookingUsers() throws ClassNotFoundException, SQLException {
		return read("select * from flight_bookings");
	}

	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> bookings = new ArrayList<>();
		while (rs.next()) {
			BookingDAO bookdao = new BookingDAO(conn);
			FlightDAO flightdao = new FlightDAO(conn);
			FlightBookings booking = new FlightBookings();
			booking.setBooking(bookdao.read("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			booking.setFlight(flightdao.read("select * from flight where id = ?", rs.getInt("flight_id")).get(0));
			bookings.add(booking);
		}
		return bookings;
	}

	public List<FlightBookings> getAllBookingUsers(int i) throws ClassNotFoundException, SQLException {
		return this.read("select * from flight_bookings where flight_id = ?", i);
	}

}
