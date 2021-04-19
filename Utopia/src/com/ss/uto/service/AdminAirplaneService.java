/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirplaneDAO;
import com.ss.uto.dao.AirplaneTypeDAO;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.AirplaneType;

/**
 * @author heman
 *
 */
public class AdminAirplaneService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	Scanner sc = new Scanner(System.in);

	public void addNewAirplane() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO airplanedao = new AirplaneDAO(conn);
			Airplane airplane = new Airplane();
			System.out.println("Enter the type of airplane you want to add");
			int input = sc.nextInt();
			List<AirplaneType> types = (new AirplaneTypeDAO(conn)).getAllAirplaneTypes();
			for(AirplaneType t: types) {
				if(t.getId() == input) {
					airplane.setType(t);
					airplanedao.addAirplane(airplane);
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
	
	public void deleteAirplane() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO airplanedao = new AirplaneDAO(conn);
			List<Airplane> airplanes = airplanedao.getAllAirplanes();
			System.out.println("What is the id of the airplane you want to delete?");
			int input = sc.nextInt();
			for(Airplane a: airplanes) {
				if(input == a.getId()) {
					airplanedao.deleteAirplane(a);
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
	
	public void updateAirplane() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO airplanedao = new AirplaneDAO(conn);
			List<Airplane> airplanes = airplanedao.getAllAirplanes();
			System.out.println("Enter the airplane ID you want to update");
			int input = sc.nextInt();
			Airplane airplane = null;
			for(Airplane a: airplanes) {
				if(a.getId() == input) {
					airplane = a;
				}
			}
			System.out.println("What type do you want to change the airplane to?");
			int type_input = sc.nextInt();
			List<AirplaneType> types = (new AirplaneTypeDAO(conn)).getAllAirplaneTypes();
			for(AirplaneType t: types) {
				if(t.getId() == type_input) {
					airplane.setType(t);
					airplanedao.updateAirplane(airplane);
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

	public void getAirplanes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO airplanedao = new AirplaneDAO(conn);
			List<Airplane> airplanes = airplanedao.getAllAirplanes();
			System.out.println("Listing all airplanes: ");
			for(Airplane a: airplanes) {
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
