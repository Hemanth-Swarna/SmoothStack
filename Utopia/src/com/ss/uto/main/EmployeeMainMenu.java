/**
 * 
 */
package com.ss.uto.main;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirplaneDAO;
import com.ss.uto.dao.AirportDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.UserDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.User;
import com.ss.uto.service.ConnectionUtil;

/**
 * @author heman
 *
 */
public class EmployeeMainMenu {

	static void EMP1() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) Enter Flights You Manage");
		System.out.println("2) Quit to previous");

		int choice = sc.nextInt();
		while (choice > 2 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			EMP2();
			break;
		case 2:
			MainMenu.menu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}
	}

	static void EMP2() throws ClassNotFoundException, SQLException {

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
		while (choice > flights.size() || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		EMP3(flights.get(choice));

	}

	static void EMP3(Flight f) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) View more details about the flight");
		System.out.println("2) Update the details of the flight");
		System.out.println("3) Add seats to the flight");
		System.out.println("4) Quit to previous");

		int choice = sc.nextInt();
		while (choice > 4 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			viewDetails(f);
			break;
		case 2:
			employeeUpdate(f);
			break;
		case 3:
			addSeats(f);
			break;
		case 4:
			EMP2();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}
	}

	@SuppressWarnings("deprecation")
	static void viewDetails(Flight f) throws ClassNotFoundException, SQLException {
		
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
		
		switch(choice) {
		case 4:
			EMP3(f);
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}
		
		
	}

	static void employeeUpdate(Flight f) {
		System.out.println("You have chose to update Flight with Flight ID: " + f.getId() + " and Departure Airport: "
				+ f.getRoute().getOriAirport().getAirportCode() + " and Arrival Airport: "
				+ f.getRoute().getDesAirport().getAirportCode());
		System.out.println();
	}

	static void addSeats(Flight f) {
		System.out.println("Pick the Seat Class you want to add seats of, to your flight:");
		System.out.println("1) First");
		System.out.println("2) Business");
		System.out.println("3) Economy");
		System.out.println("4) Quit to cancel operation");
		
		System.out.println();
		
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
