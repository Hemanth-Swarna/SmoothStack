package com.ss.uto.main;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

	static void menu() throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter a value from the list below:");
		System.out.println("1) Employee");
		System.out.println("2) Administrator");
		System.out.println("3) Traveler");

		int choice = sc.nextInt();
		while (choice > 3 || choice < 1) {
			System.out.println("Please enter a valid number.");
			choice = sc.nextInt();
		}

		switch (choice) {
		case 1:
			EmployeeMainMenu.EMP1();
			break;
		case 2:
			AdminMainMenu.menu();
			break;
		case 3:
			TravelerMainMenu.menu();
			break;
		default:
			System.out.println("Invalid choice");
			sc.close();
			System.exit(0);
			break;
		}
	}

}
