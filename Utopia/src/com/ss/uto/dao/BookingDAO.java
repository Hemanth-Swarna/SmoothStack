/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Booking;

/**
 * @author heman
 *
 */
public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	public Integer addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)",
				new Object[] { booking.isIsActive(), booking.getConfirmationCode() });
	}

	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE booking set is_active = ? where id = ?",
				new Object[] { booking.isIsActive(), booking.getId() });
	}

	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking where id = ?", new Object[] { booking.getId() });
	}

	public List<Booking> getAllBookings() throws ClassNotFoundException, SQLException {
		return read("select * from booking");
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		List<Booking> bookings = new ArrayList<>();
		while (rs.next()) {
			Booking booking = new Booking();
			booking.setIsActive(rs.getBoolean("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			booking.setId(rs.getInt("id"));
			bookings.add(booking);
		}
		return bookings;
	}

}
