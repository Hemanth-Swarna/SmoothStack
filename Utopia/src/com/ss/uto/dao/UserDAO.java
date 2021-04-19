/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.User;

/**
 * @author heman
 *
 */
public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	public Integer addUser(User user) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?,?,?,?,?,?,?)",
				new Object[] { user.getUserrole().getId(), user.getGivenname(), user.getFamilyname(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone() });
	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?", 
				new Object[] { user.getUserrole().getId(), user.getGivenname(), user.getFamilyname(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getId() });
	}

	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("DELETE FROM user where id = ?", new Object[] { user.getId() });
	}

	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		return read("select * from user");
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User();

			user.setId(rs.getInt("id"));
			user.setGivenname(rs.getString("given_name"));
			user.setFamilyname(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));

			UserRoleDAO roledao = new UserRoleDAO(conn);
			user.setUserrole(roledao.read("select * from user_role where id = ?", rs.getInt("role_id")).get(0));

			users.add(user);
		}
		return users;
	}

}
