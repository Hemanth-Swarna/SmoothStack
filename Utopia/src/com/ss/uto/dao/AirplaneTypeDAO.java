/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.AirplaneType;
import com.ss.uto.entity.Airport;

/**
 * @author heman
 *
 */
public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO airplane_type (max_capacity) VALUES (?)",
				new Object[] { type.getMax_capacity() });
	}

	public void updateAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane_type set max_capacity = ? where id = ?", new Object[] {
				type.getMax_capacity(), type.getId() });
	}

	public void deleteAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airplane_type where id = ?", new Object[] { type.getId() });
	}

	public List<AirplaneType> getAllAirplaneTypes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane_type");
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> types = new ArrayList<>();
		while(rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setId(rs.getInt("id"));
			type.setMax_capacity(rs.getInt("max_capacity"));
			types.add(type);
		}
		return types;
	}

}
