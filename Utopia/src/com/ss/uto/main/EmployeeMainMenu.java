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

import com.ss.uto.dao.AirplaneDAO;
import com.ss.uto.dao.AirportDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.dao.UserDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;
import com.ss.uto.entity.User;
import com.ss.uto.service.AdminSeatService;
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
		while (choice > flights.size() || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		EMP3(flights.get(choice - 1));

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
		System.out.println("Departure Date: " + f.getDeparture().toString().split(" ")[0] + " | " + "Departure Time: " + f.getDeparture().toString().split(" ")[1] + " |");
		Timestamp stamp = Timestamp.from(f.getDeparture().toInstant().plus(5, ChronoUnit.HOURS));
		System.out.println("Arrival Date: " + stamp.toString().split(" ")[0] + " | " + "Arrival Time: " + stamp.toString().split(" ")[1] + " | ");
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
			EMP3(f);
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}

	static void employeeUpdate(Flight f) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("You have chose to update Flight with Flight ID: " + f.getId() + " and Departure Airport: "
				+ f.getRoute().getOriAirport().getAirportCode() + " and Arrival Airport: "
				+ f.getRoute().getDesAirport().getAirportCode());
		System.out.println();

		System.out.println("Please enter new Origin Airport and City or enter N/A for no change:");
		String ori = sc.nextLine();
		String ori_city = sc.nextLine();
		System.out.println("Please enter new Destination Airport and City or enter N/A for no change:");
		String des = sc.nextLine();
		String des_city = sc.nextLine();

		if (ori.equals("N/A")) {
			ori = f.getRoute().getOriAirport().getAirportCode();
			ori_city = f.getRoute().getOriAirport().getCityName();
		}
		if (des.equals("N/A")) {
			des = f.getRoute().getDesAirport().getAirportCode();
			des_city = f.getRoute().getDesAirport().getCityName();
		}

		Route newroute = new Route();
		Airport oriAirport = new Airport();
		Airport desAirport = new Airport();
		oriAirport.setAirportCode(ori);
		oriAirport.setCityName(ori_city);
		desAirport.setAirportCode(des);
		desAirport.setCityName(des_city);
		newroute.setOriAirport(oriAirport);
		newroute.setDesAirport(desAirport);
		RouteDAO rdao = new RouteDAO((new ConnectionUtil()).getConnection());
		rdao.addRoute(newroute);
		
		System.out.println(newroute.getOriAirport().getAirportCode());
		System.out.println(newroute.getDesAirport().getAirportCode());
		FlightDAO flightdao = new FlightDAO((new ConnectionUtil()).getConnection());
		List<Route> route2 = rdao.read("select * from route where origin_id = ? AND destination_id = ?",
				newroute.getOriAirport().getAirportCode(), newroute.getDesAirport().getAirportCode());
		System.out.println(route2.size());
		f.setRoute(route2.get(0));

		System.out.println("Please enter new Departure Date or enter N/A for no change:");
		String date = sc.nextLine();
		System.out.println("Please enter new Departure Time or enter N/A for no change:");
		String time = sc.nextLine();
		if (date.equals("N/A")) {
			date = f.getDeparture().toString().split(" ")[0];
		}
		if (time.equals("N/A")) {
			time = f.getDeparture().toString().split(" ")[1];
		}
		Timestamp departure = Timestamp.valueOf(date + " " + time);
		f.setDeparture(departure);
		System.out.println("Please enter new Arrival Date or enter N/A for no change:");
		String adate = sc.nextLine();
		System.out.println("Please enter new Arrival Time or enter N/A for no change:");
		String atime = sc.nextLine();

		flightdao.updateFlight(f);
	}

	static void addSeats(Flight f) throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Pick the Seat Class you want to add seats of, to your flight:");
		System.out.println("1) First");
		System.out.println("2) Business");
		System.out.println("3) Economy");
		System.out.println("4) Quit to cancel operation");

		int choice = sc.nextInt();
		while (choice > 4 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			System.out.println("Pick again, no seats avialable");
			addSeats(f);
			break;
		case 2:
			System.out.println("Pick again, no seats avialable");
			addSeats(f);
			break;
		case 3:
			System.out.println("Existing number of seats: "
					+ (f.getAirplane().getType().getMax_capacity() - f.getReservedSeats()));

			System.out.println("Enter new number of seats: ");
			
			int newseats = sc.nextInt();

			if (newseats + f.getReservedSeats() > f.getAirplane().getType().getMax_capacity()) {
				System.out.println("Number too large");
				addSeats(f);
			} else {
				f.setReservedSeats(newseats + f.getReservedSeats());
				
				ConnectionUtil connUtil = new ConnectionUtil();
				Connection conn = null;
				try {
					conn = connUtil.getConnection();
					FlightDAO flightdao = new FlightDAO(conn);
					System.out.println(f.toString());
					flightdao.updateFlight(f);
					conn.commit();
				} catch (Exception e) {
					e.printStackTrace();
					conn.rollback();
				} finally {
					conn.close();
				}
				addSeats(f);
			}
			break;
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

	private static String findCity(String code) throws ClassNotFoundException, SQLException {

		AirportDAO airpdao = new AirportDAO((new ConnectionUtil()).getConnection());
		List<Airport> airports = airpdao.read("select * from airport where iata_id=?", code);

		for (Airport a : airports) {
			return a.getCityName();
		}

		return null;
	}
}
