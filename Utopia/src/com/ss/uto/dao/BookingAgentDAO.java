/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.BookingAgent;
import com.ss.uto.entity.BookingAgent;

/**
 * @author heman
 *
 */
public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addBookingAgent(BookingAgent agent) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?,?)",
				new Object[] { agent.getBooking().getId(), agent.getAgent().getId() });
	}

	public void updateBookingAgent(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_agent booking_id = ? where agent_id = ?", new Object[] {
				agent.getBooking().getId(), agent.getAgent().getId() });
	}

	public void deleteBookingAgent(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_agent where agent_id = ?", new Object[] { agent.getAgent().getId() });
	}

	public List<BookingAgent> getAllBookingAgents() throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent");
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> agents = new ArrayList<>();
		while (rs.next()) {
			BookingAgent agent = new BookingAgent();
			BookingDAO bookingdao = new BookingDAO(conn);
			UserDAO userdao = new UserDAO(conn);
			
			agent.setAgent(userdao.read("select * from user where id = ?", rs.getInt("agent_id")).get(0));
			agent.setBooking(bookingdao.read("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			
			agents.add(agent);
		}
		return agents;
	}

}
