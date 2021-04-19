/**
 * 
 */
package com.ss.uto.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.UserDAO;
import com.ss.uto.entity.User;
import com.ss.uto.service.AdminTicketAndPassengersService;
import com.ss.uto.service.ConnectionUtil;

/**
 * @author heman
 *
 */
public class TravelerMainMenu {
	
	static void menu() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your membership number");
		int choice = sc.nextInt();
		
		UserDAO userdao = new UserDAO((new ConnectionUtil()).getConnection());
		List<User> travelers = userdao.read("select * from user where role_id = ?", 2);
		for(User t: travelers) {
			if(choice == t.getId()) {
				trav1();
			}
		}
		
		
	}
	
	static void trav1() throws SQLException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1) Book a ticket");
		System.out.println("2) Cancel and upcoming trip");
		System.out.println("3) Quit to Previous");
		
		int choice = sc.nextInt();
		while (choice > 3 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}
		
		switch (choice) {
		case 1:
			trav2();
			break;
		case 2:
			MainMenu.menu();
			break;
		case 3:
			MainMenu.menu();
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}
		
		
	}
	
	static void trav2() {
		
	}

}
