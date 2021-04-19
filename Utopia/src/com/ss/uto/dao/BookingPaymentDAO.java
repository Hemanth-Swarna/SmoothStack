/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.BookingPayment;
import com.ss.uto.entity.BookingPayment;

/**
 * @author heman
 *
 */
public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?,?,?)",
				new Object[] { payment.getBooking().getId(), payment.getStripeId(), payment.isRefunded() });
	}

	public void updateBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_payment set stripe_id = ?, refunded = ? where booking_id = ?", new Object[] {
				payment.getStripeId(), payment.isRefunded(), payment.getBooking().getId() });
	}

	public void deleteBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_payment where booking_id = ?", new Object[] { payment.getBooking().getId() });
	}

	public List<BookingPayment> getAllBookingPayments() throws ClassNotFoundException, SQLException {
		return read("select * from booking_payment");
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> payments = new ArrayList<>();
		while(rs.next()) {
			BookingDAO bookdao = new BookingDAO(conn);
			BookingPayment payment = new BookingPayment();
			
			payment.setBooking(bookdao.read("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			payment.setStripeId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getBoolean("refunded"));
			
			payments.add(payment);
			
		}
		return payments;
	}

}
