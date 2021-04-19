/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.dao.AirplaneTypeDAO;
import com.ss.uto.dao.AirplaneTypeDAO;
import com.ss.uto.entity.AirplaneType;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.AirplaneType;

/**
 * @author heman
 *
 */
public class AdminAirplaneTypeService {
	
	ConnectionUtil connUtil = new ConnectionUtil();

	public void addNewAirplaneType() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO airtypedao = new AirplaneTypeDAO(conn);
			AirplaneType type = new AirplaneType();
			System.out.println("What would you like the max capacity of this airplane type to be?");
			int capacity = 600;
			type.setMax_capacity(capacity);
			airtypedao.addAirplaneType(type);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public void deleteAirplaneType() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO airtypedao = new AirplaneTypeDAO(conn);
			List<AirplaneType> types = airtypedao.getAllAirplaneTypes();
			System.out.println("Enter the id of the airplane type you want to delete");
			int input = 6;
			for(AirplaneType a: types) {
				if(a.getId() == (input)) {
					airtypedao.deleteAirplaneType(a);
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
	
	public void updateAirplaneType() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO airtypedao = new AirplaneTypeDAO(conn);
			List<AirplaneType> types = airtypedao.getAllAirplaneTypes();
			System.out.println("Enter the id you want to update");
			int input = 6;
			System.out.println("What is the new max capacity?");
			int capacity = 700;
			for(AirplaneType a: types) {
				if(a.getId() == (input)) {
					a.setMax_capacity(capacity);
					airtypedao.updateAirplaneType(a);
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

	public void getAirplaneTypes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO airtypedao = new AirplaneTypeDAO(conn);
			List<AirplaneType> airports = airtypedao.getAllAirplaneTypes();
			System.out.println("Listing all airplane types: ");
			for(AirplaneType a: airports) {
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
