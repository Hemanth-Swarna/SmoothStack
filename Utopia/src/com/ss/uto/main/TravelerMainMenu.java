/**
 * 
 */
package com.ss.uto.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.dao.BookingDAO;
import com.ss.uto.dao.FlightBookingsDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.UserDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.FlightBookings;
import com.ss.uto.entity.User;
import com.ss.uto.service.AdminTicketAndPassengersService;
import com.ss.uto.service.ConnectionUtil;

/**
 * @author heman
 *
 */
public class TravelerMainMenu {

	static void menu() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your membership number");
		int choice = sc.nextInt();

		UserDAO userdao = new UserDAO((new ConnectionUtil()).getConnection());
		List<User> travelers = userdao.read("select * from user where role_id = ?", 2);
		for (User t : travelers) {
			if (choice == t.getId()) {
				trav1();
			}
		}

	}

	static void trav1() throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) Book a ticket");
		System.out.println("2) Cancel and upcoming trip");
		System.out.println("3) Quit to Previous");

		int choice = sc.nextInt();
		while (choice > 3 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			trav2();
			break;
		case 2:
			trav3();
			break;
		case 3:
			MainMenu.menu();
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}

	static void trav2() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		List<Flight> flights = new FlightDAO((new ConnectionUtil()).getConnection()).getAllFlights();

		for (Flight f : flights) {
			System.out.println(f.getId() + ") " + f.getRoute().getOriAirport().getAirportCode() + ", "
					+ findCity(f.getRoute().getOriAirport().getAirportCode()) + " -> "
					+ f.getRoute().getDesAirport().getAirportCode() + ", "
					+ findCity(f.getRoute().getDesAirport().getAirportCode()));
		}

		System.out.println("Please enter which flight you would like to observe");
		int choice = sc.nextInt();
		while (choice > flights.size() || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		trav2a(flights.get(choice - 1));
	}

	static void trav2a(Flight f) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) View Flight Details");
		System.out.println("2) Book a Seat");
		System.out.println("3) Quit");

		int choice = sc.nextInt();
		while (choice > 3 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			viewDetails(f);
			break;
		case 2:
			bookASeat(f);
			break;
		case 3:
			trav2();
			break;
		}

	}

	static void trav3() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		List<Flight> flights = new FlightDAO((new ConnectionUtil()).getConnection()).getAllFlights();

		for (Flight f : flights) {
			System.out.println(f.getId() + ") " + f.getRoute().getOriAirport().getAirportCode() + ", "
					+ findCity(f.getRoute().getOriAirport().getAirportCode()) + " -> "
					+ f.getRoute().getDesAirport().getAirportCode() + ", "
					+ findCity(f.getRoute().getDesAirport().getAirportCode()));
		}

		System.out.println("Please enter which flight you would like to observe");
		int choice = sc.nextInt();
		while (choice > flights.size() || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		trav3a(flights.get(choice - 1));
	}

	private static void trav3a(Flight f) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) View Flight Details");
		System.out.println("2) Book a Seat");
		System.out.println("3) Quit");

		int choice = sc.nextInt();
		while (choice > 3 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			viewDetails(f);
			break;
		case 2:
			cancelASeat(f);
			break;
		case 3:
			trav3();
			break;
		}

	}

	private static void cancelASeat(Flight f) throws ClassNotFoundException, SQLException {

		AdminTicketAndPassengersService admin = new AdminTicketAndPassengersService();
		admin.deleteBooking();
		f.setReservedSeats(f.getReservedSeats()-1);
		FlightDAO fdao = new FlightDAO((new ConnectionUtil()).getConnection());
		fdao.updateFlight(f);
		
		
	}

	private static void bookASeat(Flight f) throws ClassNotFoundException, SQLException {

		AdminTicketAndPassengersService admin = new AdminTicketAndPassengersService();

		admin.addBooking();
		f.setReservedSeats(f.getReservedSeats()+1);
		FlightDAO fdao = new FlightDAO((new ConnectionUtil()).getConnection());
		fdao.updateFlight(f);
		
	}

	private static void viewDetails(Flight f) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("You have chose to view Flight with Flight ID: " + f.getId() + " and Departure Airport: "
				+ f.getRoute().getOriAirport().getAirportCode() + " and Arrival Airport: "
				+ f.getRoute().getDesAirport().getAirportCode());
		System.out.println();
		System.out.println("Departure Airport: " + f.getRoute().getOriAirport().getAirportCode() + " | Arrival Airport:"
				+ f.getRoute().getDesAirport().getAirportCode() + " | ");
		System.out.println("Departure: " + f.getDeparture());
		System.out.println("Arrival: " + Timestamp.from(f.getDeparture().toInstant().plus(5, ChronoUnit.HOURS)));
		System.out.println("Available Seats by Class:");
		System.out.println("1) First -> 0");
		System.out.println("2) Business -> 0");
		System.out.println("3) Economy -> " + (f.getAirplane().getType().getMax_capacity() - f.getReservedSeats()));
		System.out.println("4) Go back");

		int choice = sc.nextInt();

		while (choice != 4) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		System.out.println("Press 4 to go back");

		switch (choice) {
		case 4:
			trav2a(f);
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}

	private static String findCity(String code) throws ClassNotFoundException, SQLException {

		AirportDAO airpdao = new AirportDAO((new ConnectionUtil()).getConnection());
		List<Airport> airports = airpdao.read("select * from airport where iata_id=?", code);

		for (Airport a : airports) {
			return a.getCityName();
		}

		return null;
	}

}
