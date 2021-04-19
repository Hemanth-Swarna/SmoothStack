/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.entity.Airport;

/**
 * @author heman
 *
 */
public class AdminAirportService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	Scanner sc = new Scanner(System.in);

	public void addNewAirport() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO airdao = new AirportDAO(conn);
			Airport airport = new Airport();
			System.out.println("Enter the three-letter airport code you want to add");
			String code = sc.nextLine();
			airport.setAirportCode(code);
			System.out.println("Enter the city the airport is in");
			String city = sc.nextLine();
			airport.setCityName(city);
			airdao.addAirport(airport);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public void deleteAirport() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO airdao = new AirportDAO(conn);
			List<Airport> airports = airdao.getAllAirports();
			System.out.println("Enter the three-letter airport code you want to delete");
			String input = sc.nextLine();
			for(Airport a: airports) {
				if(a.getAirportCode().equals(input)) {
					airdao.deleteAirport(a);
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
	
	public void updateAirport() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO airdao = new AirportDAO(conn);
			List<Airport> airports = airdao.getAllAirports();
			System.out.println("Enter the three-letter airport code you want to update");
			String input = sc.nextLine();
			System.out.println("What is the new city?");
			String newcity = sc.nextLine();
			for(Airport a: airports) {
				if(a.getAirportCode().equals(input)) {
					a.setCityName(newcity);
					airdao.updateAirport(a);
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

	public void getAirports() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO airdao = new AirportDAO(conn);
			List<Airport> airports = airdao.getAllAirports();
			System.out.println("Listing all airports: ");
			for(Airport a: airports) {
				System.out.println(a.toString());
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
