/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.BookingGuest;
import com.ss.uto.entity.BookingGuest;

/**
 * @author heman
 *
 */
public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookingGuest(BookingGuest guest) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) values (?,?,?)",
				new Object[] { guest.getBooking().getId(), guest.getContactemail(), guest.getContactphone() });
	}

	public void updateBookingGuest(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_guest set contact_email = ?, contact_phone = ? where booking_id = ?", new Object[] {
				guest.getContactemail(), guest.getContactphone(), guest.getBooking().getId() });
	}

	public void deleteBookingGuest(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_guest where booking_id = ?", new Object[] { guest.getBooking().getId() });
	}

	public List<BookingGuest> getAllBookingGuests() throws ClassNotFoundException, SQLException {
		return read("select * from booking_guest");
	}
	
	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> guests = new ArrayList<>();
		while (rs.next()) {
			BookingGuest guest = new BookingGuest();
			BookingDAO bookdao = new BookingDAO(conn);
			guest.setBooking(bookdao.read("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			guest.setContactemail(rs.getString("contact_email"));
			guest.setContactphone(rs.getString("contact_phone"));

			guests.add(guest);
		}
		return guests;
	}
	
	

}
