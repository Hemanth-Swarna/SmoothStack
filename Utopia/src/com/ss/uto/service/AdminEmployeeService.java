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
import com.ss.uto.entity.User;
import com.ss.uto.entity.UserRole;

/**
 * @author heman
 *
 */
public class AdminEmployeeService {

	Scanner sc = new Scanner(System.in);

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addEmployee() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<UserRole> roles = (new UserRoleDAO(conn)).getAllUserRoles();
			for (UserRole r : roles) {
				if (r.getId() == 1) {
					User employee = new User();
					employee.setUserrole(r);
					System.out.println("What is the given name of the employee");
					String givenname = sc.nextLine();
					employee.setGivenname(givenname);
					System.out.println("What is the family name of the employee");
					String familyname = sc.nextLine();
					employee.setFamilyname(familyname);
					System.out.println("What is the username of the employee");
					String username = sc.nextLine();
					employee.setUsername(username);
					System.out.println("What is the email of the employee");
					String email = sc.nextLine();
					employee.setEmail(email);
					System.out.println("What is the password of the employee");
					String password = sc.nextLine();
					employee.setPassword(password);
					System.out.println("What is the phone number of the employee");
					String phone = sc.nextLine();
					employee.setPhone(phone);
					userdao.addUser(employee);
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

	public void updateEmployee() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<User> employees = userdao.read("select * from user where role_id = ?", 1);
			System.out.println("What is the employee id you want to update?");
			int input = sc.nextInt();
			for (User employee : employees) {
				if (employee.getId() == input) {
					System.out.println("What is the given name of the employee");
					String givenname = sc.nextLine();
					employee.setGivenname(givenname);
					System.out.println("What is the family name of the employee");
					String familyname = sc.nextLine();
					employee.setFamilyname(familyname);
					System.out.println("What is the username of the employee");
					String username = sc.nextLine();
					employee.setUsername(username);
					System.out.println("What is the email of the employee");
					String email = sc.nextLine();
					employee.setEmail(email);
					System.out.println("What is the password of the employee");
					String password = sc.nextLine();
					employee.setPassword(password);
					System.out.println("What is the phone number of the employee");
					String phone = sc.nextLine();
					employee.setPhone(phone);
					userdao.updateUser(employee);
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

	public void deleteEmployee() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<User> employees = userdao.read("select * from user where role_id = ?", 1);
			System.out.println("What is the employee id you want to delete?");
			int input = sc.nextInt();
			for (User u : employees) {
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

	public void getEmployees() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO userdao = new UserDAO(conn);
			List<User> employees = userdao.read("select * from user where role_id = ?", 1);
			System.out.println("Printing all employees");
			for (User u : employees) {
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
