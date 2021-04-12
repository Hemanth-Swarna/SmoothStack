/**
 * 
 */
package com.ss.weeklyassignment.singleton;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author heman
 *
 */

//I got rid of illegal static modifier
public class SampleSingleton {
	// Defined Connection "conn" and made it static so that it could properly be
	// used in the static method.
	private static Connection conn;

	// Changed it to volatile to ensure proper synchronization
	volatile public static SampleSingleton instance = null;

	// We need a private Singleton constructor for it to work properly
	private SampleSingleton() {

	}

	public static SampleSingleton getInstance() {
		// double-checked locking to ensure we don't test the lock before acquiring it.
		synchronized (instance) {
			//
			if (instance == null) {
				// We use this because we can't synch on null
				synchronized (SampleSingleton.class) {
					if (instance == null) {
						instance = new SampleSingleton();
					}
				}
			}
			return instance;
		}
	}

	public static void databaseQuery(BigDecimal input) {
		// Surround with try/catch block to catch exceptions
		try {
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			int x = 0;
			while (rs.next()) {
				x = rs.getInt(1) * input.intValue(); // We need to make the decimal an int value
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
