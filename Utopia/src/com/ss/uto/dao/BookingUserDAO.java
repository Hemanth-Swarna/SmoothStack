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
import com.ss.uto.entity.BookingUser;

/**
 * @author heman
 *
 */
public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookingUser(BookingUser user) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking_user (booking_id, user_id) VALUES (?,?)",
				new Object[] { user.getBooking().getId(), user.getUser().getId() });
	}

	public void updateBookingUser(BookingUser user) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_user booking_id = ? where user_id = ?", new Object[] {
				user.getBooking().getId(), user.getUser().getId() });
	}

	public void deleteBookingUser(BookingUser user) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_user where user_id = ?", new Object[] { user.getUser().getId() });
	}

	public List<BookingUser> getAllBookingUsers() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user");
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> users = new ArrayList<>();
		while (rs.next()) {
			BookingUser user = new BookingUser();
			BookingDAO bookingdao = new BookingDAO(conn);
			UserDAO userdao = new UserDAO(conn);
			
			user.setUser(userdao.read("select * from user where id = ?", rs.getInt("user_id")).get(0));
			user.setBooking(bookingdao.read("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			
			users.add(user);
		}
		return users;
	}

}
