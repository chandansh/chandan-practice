package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DBTransaction {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testdb", "root", "root");
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			Random random = new Random();
			int rn = random.nextInt();
//			int i = stmt.executeUpdate("insert into Emp values(" + rn
//					+ ",'abc','job', 2345)");
//			System.out.println(i + "rows inserted");
			con.commit();

			PreparedStatement stmt1 = con.prepareStatement("select * from Emp");
			ResultSet rs = stmt1.executeQuery();
			//con.close();
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
