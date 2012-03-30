
package com.mpower.training.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mpower.training.model.SalesOrder;
import com.mpower.training.service.DBService;

public class SalesOrderUtil {

	public static boolean save(SalesOrder salesOrder) {

		boolean result = false;
		Connection con = DBService.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("insert into sales_order values(?,?,?)");
			pstmt.setString(1, salesOrder.getOrderId());
			pstmt.setString(2, salesOrder.getCustomer());
			pstmt.setInt(3, salesOrder.getAmount());
			if (pstmt.executeUpdate() > 0) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			// DBService.closeConnection(con, pstmt);
			try {
				pstmt.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public static List<SalesOrder> getAll() {

		List<SalesOrder> list = new ArrayList<SalesOrder>();
		Connection con = DBService.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from sales_order");
			while (rs.next()) {
				SalesOrder order =
					new SalesOrder(rs.getString("orderId"), rs.getString("customer"), rs.getInt("amount"));
				list.add(order);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			// DBService.closeConnection(con, stmt);
			try {
				stmt.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}

}
