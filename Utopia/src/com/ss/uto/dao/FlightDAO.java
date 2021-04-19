/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Flight;

/**
 * @author heman
 *
 */
public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}
	
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?,?,?,?,?,?)",
				new Object[] { flight.getId(), flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDeparture(), flight.getReservedSeats(), flight.getSeatPrice() });
	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", new Object[] {
				flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDeparture(), flight.getReservedSeats(), flight.getSeatPrice(), flight.getId() });
	}

	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight where id = ?", new Object[] { flight.getId() });
	}

	public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException {
		return read("select * from flight");
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		while (rs.next()) {
			Flight flight = new Flight();

			flight.setId(rs.getInt("id"));
			flight.setDeparture(rs.getTimestamp("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			
			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO airplanedao = new AirplaneDAO(conn);
			flight.setRoute( rdao.read("select * from route where id = ?", rs.getInt("route_id")).get(0) );
			flight.setAirplane( airplanedao.read("select * from airplane where id = ?", rs.getInt("route_id")).get(0));
			

			flights.add(flight);
		}
		return flights;
	}

}
