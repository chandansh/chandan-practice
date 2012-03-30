package com.mpower.training.dbutility;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class OrderPortletDAO 
{
	public static boolean saveData(MySalesOrder mySalesOrder) {
		boolean result = false;
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt= con.prepareStatement("insert into sales_order values(?,?,?)");
			pstmt.setString(1, mySalesOrder.getOrderId());
			pstmt.setString(2, mySalesOrder.getCustomer());
			pstmt.setInt(1, mySalesOrder.getAmount());
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
