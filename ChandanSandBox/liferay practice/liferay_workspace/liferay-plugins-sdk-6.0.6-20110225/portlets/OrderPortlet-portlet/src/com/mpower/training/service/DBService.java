
package com.mpower.training.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (con == null) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lportal", "root", "root");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection con, Statement stmt) {

		try {
			stmt.close();
			con.close();
			stmt = null;
			con = null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
