/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Route;

/**
 * @author heman
 *
 */
public class AdminRouteService {

	ConnectionUtil connUtil = new ConnectionUtil();

	Scanner sc = new Scanner(System.in);
	
	public void addNewRoute() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			Route route = new Route();
			List<Airport> airports = (new AirportDAO(conn)).getAllAirports();
			System.out.println("Enter the three letter airport code you want to be the origin");
			String ori = sc.nextLine();
			Airport oriairport = null;
			for(Airport a: airports) {
				if(a.getAirportCode().equals(ori)) {
					oriairport = a;
				}
			}
			System.out.println("Enter the three letter airport code you want to be the destination");
			String des = sc.nextLine();
			Airport desairport = null;
			for(Airport a: airports) {
				if(a.getAirportCode().equals(des)) {
					desairport = a;
				}
			}
			route.setOriAirport(oriairport);
			
			route.setDesAirport(desairport);
			if(oriairport != null && desairport != null) {
				rdao.addRoute(route);
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteRoute() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			List<Route> routes = rdao.getAllRoutes();
			System.out.println("Select which route ID you want to delete");
			int routeNum = sc.nextInt();
			for(Route r: routes) {
				if(routeNum == r.getId()) {
					rdao.deleteRoute(r);
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

	public void updateRoute() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			List<Route> routes = rdao.getAllRoutes();
			System.out.println("Select which route ID you want to update");
			int routeNum = sc.nextInt();
			for(Route r: routes) {
				if(routeNum == r.getId()) {
					List<Airport> airports = (new AirportDAO(conn)).getAllAirports();
					System.out.println("Enter the three letter airport code you want to be the origin");
					String ori = sc.nextLine();
					Airport oriairport = null;
					for(Airport a: airports) {
						if(a.getAirportCode().equals(ori)) {
							oriairport = a;
						}
					}
					System.out.println("Enter the three letter airport code you want to be the destination");
					String des = sc.nextLine();
					Airport desairport = null;
					for(Airport a: airports) {
						System.out.println(a.getAirportCode());
						if(a.getAirportCode().equals(des)) {
							desairport = a;
						}
					}
					r.setOriAirport(oriairport);
					r.setDesAirport(desairport);
					r.setId(r.getId());
					System.out.println(r.toString());
					if(oriairport != null && desairport != null) {
						rdao.updateRoute(r);
					}
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

	public void getRoutes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			System.out.println("Listing all routes: ");
			List<Route> Routes = rdao.getAllRoutes();
			for (Route r : Routes) {
				System.out.println(r.toString());
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
