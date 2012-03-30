package com.mpower.training.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbUtil
{
	private static Connection con = null;
	
	public static Connection getConnection() {

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
	public static void closeDbResources(Connection con, Statement stmt, ResultSet rs) {
		try {
			stmt.close();
			con.close();
			rs.close();
			stmt = null;
			con = null;
			rs= null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
