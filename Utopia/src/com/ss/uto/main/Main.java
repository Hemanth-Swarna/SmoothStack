/**
 * 
 */
package com.ss.uto.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.ss.uto.dao.FlightBookingsDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.FlightBookings;
import com.ss.uto.service.AdminAirplaneService;
import com.ss.uto.service.AdminAirplaneTypeService;
import com.ss.uto.service.AdminAirportService;
import com.ss.uto.service.AdminEmployeeService;
import com.ss.uto.service.AdminFlightService;
import com.ss.uto.service.AdminRouteService;
import com.ss.uto.service.AdminSeatService;
import com.ss.uto.service.AdminTicketAndPassengersService;
import com.ss.uto.service.AdminTravelerService;
import com.ss.uto.service.ConnectionUtil;

/**
 * @author heman
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		MainMenu main = new MainMenu();
		main.menu();
		
		
	}

}
