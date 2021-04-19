/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Route;

/**
 * @author heman
 *
 */
public class RouteDAO extends BaseDAO<Route> {
	
	public RouteDAO(Connection conn) {
		super(conn);
	}

	public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO route (origin_id, destination_id) VALUES (?, ?)",
				new Object[] { route.getOriAirport().getAirportCode(), route.getDesAirport().getAirportCode() });
	}

	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("UPDATE route set origin_id = ?, destination_id = ? where id = ?", new Object[] {
				route.getOriAirport().getAirportCode(), route.getDesAirport().getAirportCode(), route.getId() });
	}

	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("DELETE FROM route where id = ?", new Object[] { route.getId() });
	}

	public List<Route> getAllRoutes() throws ClassNotFoundException, SQLException {
		return read("select * from route");
	}
	
	public List<Route> getAllRoutesByAirport(String airportCode) throws ClassNotFoundException, SQLException {
		return read("select * from route where origin_id = ? OR destination_id = ?", new Object[] {airportCode, airportCode});
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		while (rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			route.getOriAirport().setAirportCode(rs.getString("origin_id"));
			route.getDesAirport().setAirportCode(rs.getString("destination_id"));
			routes.add(route);
		}
		return routes;
	}

}
