/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.FlightBookingsDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.PassengerDAO;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.FlightBookings;
import com.ss.uto.entity.Passenger;

/**
 * @author heman
 * 
 *         Due to this table being unavailable this suffers greatly as I am just
 *         able to manipulate the seat number in Flight
 *
 */
public class AdminSeatService {

	ConnectionUtil connUtil = new ConnectionUtil();

	Scanner sc = new Scanner(System.in);

	public void addSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			List<Flight> flights = flightdao.getAllFlights();
			System.out.println("Select flight id that you want to add seats to: ");
			int flight_id = sc.nextInt();
			for (Flight f : flights) {
				if (f.getId() == flight_id) {
					System.out.println("How many seats do you want to add?");
					int seats_added = sc.nextInt();
					if ((f.getReservedSeats() + seats_added) <= f.getAirplane().getType().getMax_capacity()) {
						f.setReservedSeats(f.getReservedSeats() + seats_added);
						flightdao.updateFlight(f);
					}
					System.out.println(f.toString());
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

	public void deleteSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			List<Flight> flights = flightdao.getAllFlights();
			System.out.println("Select flight id that you want to delete seats from: ");
			int flight_id = sc.nextInt();
			for (Flight f : flights) {
				if (f.getId() == flight_id) {
					System.out.println("How many seats do you want to remove?");
					int seats_removed = sc.nextInt();
					if ((f.getReservedSeats() - seats_removed) >= 0) {
						f.setReservedSeats(f.getReservedSeats() - seats_removed);
						flightdao.updateFlight(f);
					}
					System.out.println(f.toString());
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

	public void updateSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			System.out.println("Press Y to add seats or N to delete seats");
			String input = sc.nextLine();
			if (input.equals("Y")) {
				addSeats();
			} else if (input.equals("N")) {
				deleteSeats();
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void getSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			List<Flight> flights = flightdao.getAllFlights();
			System.out.println("Select flight id that you want to see the seats for: ");
			int flight_id = sc.nextInt();
			for (Flight f : flights) {
				if (f.getId() == flight_id) {

					FlightBookingsDAO flbkdao = new FlightBookingsDAO(conn);
					List<FlightBookings> flightbookings = flbkdao.getAllBookingUsers();
					for(int i =0; i < flightbookings.size(); i++) {
						if(flightbookings.get(i).getFlight().getId() == flight_id) {
							List<Integer> booking_ids = new ArrayList<>();
							int booking_id = flightbookings.get(i).getBooking().getId();
							booking_ids.add(booking_id);
							for(Integer id: booking_ids) {
								PassengerDAO pdao = new PassengerDAO(conn);
								List<Passenger> passengers = pdao.read("select * from passenger where booking_id = ?", id);
								f.setReservedSeats(f.getReservedSeats()+passengers.size());
								flightdao.updateFlight(f);
							}
						}
					}


					System.out.println(f.getReservedSeats());
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

}
