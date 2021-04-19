/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.UserDAO;
import com.ss.uto.dao.UserRoleDAO;
import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.User;
import com.ss.uto.entity.UserRole;

/**
 * @author heman
 *
 */
public class AdminTravelerService {
	
	Scanner sc = new Scanner(System.in);

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addTraveler() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<UserRole> roles = (new UserRoleDAO(conn)).getAllUserRoles();
			for (UserRole r : roles) {
				if (r.getId() == 2) {
					User traveler = new User();
					traveler.setUserrole(r);
					System.out.println("What is the given name of the traveler");
					String givenname = sc.nextLine();
					traveler.setGivenname(givenname);
					System.out.println("What is the family name of the traveler");
					String familyname = sc.nextLine();
					traveler.setFamilyname(familyname);
					System.out.println("What is the username of the traveler");
					String username = sc.nextLine();
					traveler.setUsername(username);
					System.out.println("What is the email of the traveler");
					String email = sc.nextLine();
					traveler.setEmail(email);
					System.out.println("What is the password of the traveler");
					String password = sc.nextLine();
					traveler.setPassword(password);
					System.out.println("What is the phone number of the traveler");
					String phone = sc.nextLine();
					traveler.setPhone(phone);
					userdao.addUser(traveler);
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

	public void updateTraveler() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<User> travelers = userdao.read("select * from user where role_id = ?", 2);
			System.out.println("What is the traveler id you want to update?");
			int input = sc.nextInt();
			for(User traveler: travelers) {
				if(traveler.getId() == input) {
					System.out.println("What is the given name of the traveler");
					String givenname = sc.nextLine();
					traveler.setGivenname(givenname);
					System.out.println("What is the family name of the traveler");
					String familyname = sc.nextLine();
					traveler.setFamilyname(familyname);;
					System.out.println("What is the username of the traveler");
					String username = sc.nextLine();
					traveler.setUsername(username);
					System.out.println("What is the email of the traveler");
					String email = sc.nextLine();
					traveler.setEmail(email);
					System.out.println("What is the password of the traveler");
					String password = sc.nextLine();
					traveler.setPassword(password);
					System.out.println("What is the phone number of the traveler");
					String phone = sc.nextLine();
					traveler.setPhone(phone);
					userdao.updateUser(traveler);
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

	public void deleteTraveler() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<User> travelers = userdao.read("select * from user where role_id = ?", 2);
			System.out.println("What is the traveler id you want to delete?");
			int input = sc.nextInt();
			for (User u : travelers) {
				if (u.getId() == input) {
					userdao.deleteUser(u);
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

	public void getTravelers() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<User> travelers = userdao.read("select * from user where role_id = ?", 2);
			System.out.println("Printing all travelers");
			for (User u : travelers) {
				System.out.println(u.toString());
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
