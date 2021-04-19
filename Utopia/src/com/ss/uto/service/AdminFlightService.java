/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirplaneDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.AirplaneType;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;

/**
 * @author heman
 *
 */
public class AdminFlightService {

	ConnectionUtil connUtil = new ConnectionUtil();

	Scanner sc = new Scanner(System.in);

	public void addNewFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			Flight flight = new Flight();
			List<Flight> flights = flightdao.getAllFlights();
			int flight_id = 1;
			for (Flight f : flights) {
				if (flight_id == f.getId()) {
					flight_id++;
				}
			}
			flight.setId(flight_id);
			System.out.println("Enter the type of route you want to add (by id)");
			int route_id_input = sc.nextInt();
			List<Route> routes = (new RouteDAO(conn)).getAllRoutes();
			for (Route r : routes) {
				if (r.getId() == route_id_input) {
					flight.setRoute(r);
				}
			}
			System.out.println("Enter the id of the airplane you want to use");
			int airplane_id_input = sc.nextInt();
			List<Airplane> airplanes = (new AirplaneDAO(conn)).getAllAirplanes();
			for (Airplane a : airplanes) {
				if (a.getId() == airplane_id_input) {
					flight.setAirplane(a);
				}
			}
			System.out.println("Enter a date in the following format (yyyy-mm-dd)");
			String date = sc.nextLine();
			System.out.println("Enter time in the following format (hh:mm:ss)");
			String time = sc.nextLine();
			Timestamp departure = Timestamp.valueOf(date + " " + time);
			flight.setDeparture(departure);
			flight.setReservedSeats(0);

			System.out.println("What is the price for one seat?");
			float price = sc.nextFloat();
			flight.setSeatPrice(price);
			System.out.println(flight.toString());
			flightdao.addFlight(flight);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			List<Flight> flights = flightdao.getAllFlights();
			System.out.println("What is the id of the flight you want to delete?");
			int input = sc.nextInt();
			for (Flight f : flights) {
				if (f.getId() == (input)) {
					flightdao.deleteFlight(f);
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

	public void updateFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			List<Flight> flights = flightdao.getAllFlights();
			System.out.println("Enter the flight ID you want to update");
			int flight_id_input = sc.nextInt();

			for (Flight f : flights) {
				if (f.getId() == flight_id_input) {
//					System.out.println("Do you want to update the route? Submit the char Y or N.");
//					char route_input = 'Y';
//					
////					// Connect to RouteDAO
////					if (route_input == 'Y') {
////						AdminRouteService routeservice = new AdminRouteService();
//////						routeservice.updateRoute();
////					} else if (route_input == 'N') {
////
////					}
////					System.out.println("Do you want to update the airplane? Submit the char Y or N.");
////					char airplane_input = 'Y';
////					
////					//Connect to AirplaneDAO
////					if (airplane_input == 'Y') {
////						AdminAirplaneService airplaneservice = new AdminAirplaneService();
//////						airplaneservice.updateAirplane();
////						
////					} else if (airplane_input == 'N') {
////
////					}
					System.out.println("Do you want to change the departure time?");
					System.out.println("Enter a date in the following format (yyyy-mm-dd)");
					String date = sc.nextLine();
					System.out.println("Enter time in the following format (hh:mm:ss)");
					String time = sc.nextLine();
					Timestamp departure = Timestamp.valueOf(date + " " + time);
					f.setDeparture(departure);

					System.out.println("What is the price of the seat");
					float price = sc.nextFloat();
					f.setSeatPrice(price);

					flightdao.updateFlight(f);
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

	public void getFlights() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO flightdao = new FlightDAO(conn);
			List<Flight> flights = flightdao.getAllFlights();
			System.out.println("Listing all flights: ");
			for (Flight f : flights) {
				System.out.println(f.toString());
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
