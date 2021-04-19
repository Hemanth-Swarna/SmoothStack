/**
 * 
 */
package com.ss.uto.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.service.AdminAirportService;
import com.ss.uto.service.AdminEmployeeService;
import com.ss.uto.service.AdminFlightService;
import com.ss.uto.service.AdminSeatService;
import com.ss.uto.service.AdminTicketAndPassengersService;
import com.ss.uto.service.AdminTravelerService;

/**
 * @author heman
 *
 */
public class AdminMainMenu {

	static void menu() throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Hello admin what do you want to work with?");
		System.out.println("0) Return to main menu");
		System.out.println("1) Flights");
		System.out.println("2) Seats");
		System.out.println("3) Tickets and Passengers");
		System.out.println("4) Airports");
		System.out.println("5) Travelers");
		System.out.println("6) Employees");

		int choice = sc.nextInt();
		while (choice > 6 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 0:
			MainMenu.menu();
			break;
		case 1:
			flightMenu();
			break;
		case 2:
			seatMenu();
			break;
		case 3:
			ticketsAndPassengersMenu();
			break;
		case 4:
			airportsMenu();
			break;
		case 5:
			travelersMenu();
			break;
		case 6:
			employeesMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}

	static void flightMenu() throws SQLException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What do you want to do in flights?");
		System.out.println("0) Go back to Admin main menu");
		System.out.println("1) Add flights");
		System.out.println("2) Delete flights");
		System.out.println("3) Update flights");
		System.out.println("4) Read flights");
		
		int choice = sc.nextInt();
		while (choice > 4 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		AdminFlightService flight = new AdminFlightService();
		
		switch (choice) {
		case 0:
			AdminMainMenu.menu();
			break;
		case 1:
			flight.addNewFlight();
			flightMenu();
			break;
		case 2:
			flight.deleteFlight();
			flightMenu();
			break;
		case 3:
			flight.updateFlight();
			flightMenu();
			break;
		case 4:
			flight.getFlights();
			flightMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}

	static void seatMenu() throws SQLException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What do you want to do in seats?");
		System.out.println("0) Go back to Admin main menu");
		System.out.println("1) Add seats");
		System.out.println("2) Delete seats");
		System.out.println("3) Update seats");
		System.out.println("4) Read seats");
		
		int choice = sc.nextInt();
		while (choice > 4 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}
		
		AdminSeatService seat = new AdminSeatService();
		
		switch (choice) {
		case 0:
			AdminMainMenu.menu();
			break;
		case 1:
			seat.addSeats();
			seatMenu();
			break;
		case 2:
			seat.deleteSeats();
			seatMenu();
			break;
		case 3:
			seat.updateSeats();
			seatMenu();
			break;
		case 4:
			seat.getSeats();
			seatMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}
	
	static void ticketsAndPassengersMenu() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What do you want to do in seats?");
		System.out.println("0) Go back to Admin main menu");
		System.out.println("1) Add tickets");
		System.out.println("2) Delete tickets");
		System.out.println("3) Update tickets");
		System.out.println("4) Read tickets");
		System.out.println("5) Add passengers");
		System.out.println("6) Delete passengers");
		System.out.println("7) Update passengers");
		System.out.println("8) Read passengers");
		
		int choice = sc.nextInt();
		while (choice > 8 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}
		
		AdminTicketAndPassengersService ticketsandpassengers = new AdminTicketAndPassengersService();
		
		switch (choice) {
		case 0:
			AdminMainMenu.menu();
			break;
		case 1:
			ticketsandpassengers.addBooking();
			ticketsAndPassengersMenu();
			break;
		case 2:
			ticketsandpassengers.deleteBooking();
			ticketsAndPassengersMenu();
			break;
		case 3:
			ticketsandpassengers.updateBooking();;
			ticketsAndPassengersMenu();
			break;
		case 4:
			ticketsandpassengers.getBookings();
			ticketsAndPassengersMenu();
			break;
		case 5:
			ticketsandpassengers.addPassenger();
			ticketsAndPassengersMenu();
			break;
		case 6:
			ticketsandpassengers.deletePassenger();
			ticketsAndPassengersMenu();
			break;
		case 7:
			ticketsandpassengers.updatePassenger();
			ticketsAndPassengersMenu();
			break;
		case 8:
			ticketsandpassengers.getPassengers();
			ticketsAndPassengersMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}
	
	static void airportsMenu() throws SQLException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What do you want to do in airports?");
		System.out.println("0) Go back to Admin main menu");
		System.out.println("1) Add airports");
		System.out.println("2) Delete airports");
		System.out.println("3) Update airports");
		System.out.println("4) Read airports");
		
		int choice = sc.nextInt();
		while (choice > 4 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		AdminAirportService airport = new AdminAirportService();
		
		switch (choice) {
		case 0:
			AdminMainMenu.menu();
			break;
		case 1:
			airport.addNewAirport();
			airportsMenu();
			break;
		case 2:
			airport.deleteAirport();
			airportsMenu();
			break;
		case 3:
			airport.updateAirport();
			airportsMenu();
			break;
		case 4:
			airport.getAirports();
			airportsMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}
	
	static void travelersMenu() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What do you want to do in travelers?");
		System.out.println("0) Go back to Admin main menu");
		System.out.println("1) Add travelers");
		System.out.println("2) Delete travelers");
		System.out.println("3) Update travelers");
		System.out.println("4) Read travelers");
		
		int choice = sc.nextInt();
		while (choice > 4 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		AdminTravelerService traveler = new AdminTravelerService();
		
		switch (choice) {
		case 0:
			AdminMainMenu.menu();
			break;
		case 1:
			traveler.addTraveler();
			travelersMenu();
			break;
		case 2:
			traveler.deleteTraveler();
			travelersMenu();
			break;
		case 3:
			traveler.updateTraveler();
			travelersMenu();
			break;
		case 4:
			traveler.getTravelers();
			travelersMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}
	
	static void employeesMenu() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What do you want to do in employees?");
		System.out.println("0) Go back to Admin main menu");
		System.out.println("1) Add employees");
		System.out.println("2) Delete employees");
		System.out.println("3) Update employees");
		System.out.println("4) Read employees");
		
		int choice = sc.nextInt();
		while (choice > 4 || choice < 0) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		AdminEmployeeService employee = new AdminEmployeeService();
		
		switch (choice) {
		case 0:
			AdminMainMenu.menu();
			break;
		case 1:
			employee.addEmployee();;
			employeesMenu();
			break;
		case 2:
			employee.deleteEmployee();
			employeesMenu();
			break;
		case 3:
			employee.updateEmployee();
			employeesMenu();
			break;
		case 4:
			employee.getEmployees();
			employeesMenu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}

	}

}
