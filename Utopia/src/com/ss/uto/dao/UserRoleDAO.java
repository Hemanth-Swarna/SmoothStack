/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.UserRole;

/**
 * @author heman
 *
 */
public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addUserRole(UserRole userrole) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO user_role (name) VALUES (?)",
				new Object[] { userrole.getName() });
	}

	public void updateUserRole(UserRole userrole) throws ClassNotFoundException, SQLException {
		save("UPDATE user_role set name = ? where id = ?",
				new Object[] { userrole.getName(), userrole.getId() });
	}

	public void deleteUserRole(UserRole userrole) throws ClassNotFoundException, SQLException {
		save("DELETE FROM user_role where id = ?", new Object[] { userrole.getId() });
	}

	public List<UserRole> getAllUserRoles() throws ClassNotFoundException, SQLException {
		return read("select * from user_role");
	}
	

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> roles = new ArrayList<>();
		while (rs.next()) {
			UserRole role = new UserRole();
			role.setName(rs.getString("name"));
			role.setId(rs.getInt("id"));
			roles.add(role);
		}
		return roles;
	}
	
	

}
