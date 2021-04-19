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
import com.ss.uto.entity.Passenger;

/**
 * @author heman
 *
 */
public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?,?,?,?,?,?)",
				new Object[] { passenger.getBooking().getId(), passenger.getGivenname(), passenger.getFamilyname(), passenger.getDob(),
						passenger.getGender(), passenger.getAddress() });
	}

	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger set booking_id = ?, given_name = ?, family_name= ?, dob = ?, gender = ?, address = ? where id = ?", 
				new Object[] { passenger.getBooking().getId(), passenger.getGivenname(), passenger.getFamilyname(), passenger.getDob(),
						passenger.getGender(), passenger.getAddress(), passenger.getId() });
	}

	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("DELETE FROM passenger where id = ?", new Object[] { passenger.getId() });
	}

	public List<Passenger> getAllPassengers() throws ClassNotFoundException, SQLException {
		return read("select * from passenger");
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setAddress(rs.getString("address"));
			passenger.setFamilyname(rs.getString("family_name"));
			passenger.setGivenname(rs.getString("given_name"));
			passenger.setDob(rs.getDate("dob"));
			passenger.setGender(rs.getString("gender"));
			
			BookingDAO bdao = new BookingDAO(conn);
			Booking booking = bdao.read("select * from booking where id = ?", rs.getInt("booking_id")).get(0);

			passenger.setBooking(booking);

			passengers.add(passenger);
		}
		return passengers;
	}
	
	

}
