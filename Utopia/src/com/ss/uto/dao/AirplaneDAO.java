/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.AirplaneType;
import com.ss.uto.entity.Airplane;

/**
 * @author heman
 *
 */
public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO airplane (type_id) VALUES (?)",
				new Object[] { airplane.getType().getId() });
	}

	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane set type_id = ? where id = ?", new Object[] {
				airplane.getType().getId(), airplane.getId() });
	}

	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airplane where id = ?", new Object[] { airplane.getId() });
	}

	public List<Airplane> getAllAirplanes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane");
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		List<Airplane> airplanes = new ArrayList<>();
		while(rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			
			AirplaneTypeDAO airtypedao = new AirplaneTypeDAO(conn);
			AirplaneType type = airtypedao.read("select * from airplane_type where id = ?", rs.getInt("type_id")).get(0);
			
			airplane.setType(type);			
			airplanes.add(airplane);
		}
		return airplanes;
		
	}

	
}
