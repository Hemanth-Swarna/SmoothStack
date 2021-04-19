/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.BookingDAO;
import com.ss.uto.dao.PassengerDAO;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.Passenger;

/**
 * @author heman
 *
 */
public class AdminTicketAndPassengersService {
	
	Scanner sc = new Scanner(System.in);
	
	ConnectionUtil connUtil = new ConnectionUtil();

	public void addBooking() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bookdao = new BookingDAO(conn);
			Booking booking = new Booking();
			System.out.println("Is the ticket active? (Y/N)");
			String input = sc.nextLine();
			boolean isactive = true;
			if(input.equals("Y")) {
				isactive = true;
			} else {
				isactive = false;
			}
			booking.setIsActive(isactive);
			System.out.println("What is the confirmation code?");
			String code = sc.nextLine();
			booking.setConfirmationCode(code);
			bookdao.addBooking(booking);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateBooking() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bookdao = new BookingDAO(conn);
			List<Booking> bookings = bookdao.getAllBookings();
			System.out.println("What ticket id do you want to update?");
			int id = sc.nextInt();
			for(Booking b: bookings) {
				if(b.getId() == id) {
					System.out.println("Is the ticket active? (Y/N)");
					String input = sc.nextLine();
					boolean isactive = true;
					if(input.equals("Y")) {
						isactive = true;
					} else {
						isactive = false;
					}
					b.setIsActive(isactive);
					bookdao.updateBooking(b);
				}
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteBooking() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bookdao = new BookingDAO(conn);
			List<Booking> bookings = bookdao.getAllBookings();
			System.out.println("What ticket id do you want to delete");
			int input = sc.nextInt();
			for(Booking b: bookings) {
				if(b.getId() == input) {
					bookdao.deleteBooking(b);
				}
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void getBookings() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bookdao = new BookingDAO(conn);
			List<Booking> bookings = bookdao.getAllBookings();
			System.out.println("Listing all tickets: ");
			for(Booking b: bookings) {
				System.out.println(b.toString());
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addPassenger() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO passdao = new PassengerDAO(conn);
			Passenger passenger = new Passenger();
			Booking booking = null;
			BookingDAO bookdao = new BookingDAO(conn);
			List<Booking> bookings = bookdao.getAllBookings();
			System.out.println("What is the ticket id?");
			int input = sc.nextInt();
			for(Booking b: bookings) {
				if(b.getId() == input) {
					booking = b;
				}
			}
			passenger.setBooking(booking);
			System.out.println("What is the given name of the passenger");
			String givenname = sc.nextLine();
			passenger.setGivenname(givenname);
			System.out.println("What is the family name of the passenger");
			String familyname = sc.nextLine();
			passenger.setFamilyname(familyname);
			System.out.println("What is the dob of the passenger (YYYY-MM-DD)");
			String dob = sc.nextLine();
			Date dateofbirth = Date.valueOf(dob);
			passenger.setDob(dateofbirth);
			System.out.println("What is the gender of the passenger");
			String gender = sc.nextLine();
			passenger.setGender(gender);
			System.out.println("What is the address of the passenger");
			String address = sc.nextLine();
			passenger.setAddress(address);
			passdao.addPassenger(passenger);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updatePassenger() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO passdao = new PassengerDAO(conn);
			List<Passenger> passengers = passdao.getAllPassengers();
			System.out.println("What passenger id do you want to update?");
			int input = sc.nextInt();
			for(Passenger p: passengers) {
				if(p.getId() == input) {
					System.out.println("What is the given name of the passenger");
					String givenname = sc.nextLine();
					p.setGivenname(givenname);
					System.out.println("What is the family name of the passenger");
					String familyname = sc.nextLine();
					p.setFamilyname(familyname);
					System.out.println("What is the dob of the passenger (YYYY-MM-DD)");
					String dob = sc.nextLine();
					Date dateofbirth = Date.valueOf(dob);
					p.setDob(dateofbirth);
					System.out.println("What is the gender of the passenger");
					String gender = sc.nextLine();
					p.setGender(gender);
					System.out.println("What is the address of the passenger");
					String address = sc.nextLine();
					p.setAddress(address);
					passdao.updatePassenger(p);
				}
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deletePassenger() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO passdao = new PassengerDAO(conn);
			List<Passenger> passengers = passdao.getAllPassengers();
			System.out.println("What passenger id do you want to delete?");
			int input = sc.nextInt();
			for(Passenger p: passengers) {
				if(p.getId() == input) {
					passdao.deletePassenger(p);
				}
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void getPassengers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO passdao = new PassengerDAO(conn);
			List<Passenger> passengers = passdao.getAllPassengers();
			for(Passenger p: passengers) {
				System.out.println(p);
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

}
