package com.test;

public class aaa {
	public static void main(String[] args) {
		int networkParamID = 93;
		int tPortVLAN = 315;
		int internetIP1 = 29;
		int internetIP2 = 15;
		int custSubnet = 15;
		int custVLAN = 815;
		String query = "";
		for (int i = 0; i <= 100; i++) {
			networkParamID++;
			tPortVLAN++;
			internetIP1++;
			internetIP2++;
			custSubnet++;
			custVLAN++;
			query = "INSERT INTO [amp_cloud_portal_61].[dbo].[acsNetworkParameters]"
					+ "([networkParamID]"
					+ ",[dataCenterID]"
					+ ",[tPortVLAN]"
					+ ",[internetIP1]"
					+ ",[internetIP2]"
					+ ",[custSubnet]"
					+ ",[mask]"
					+ ",[organizationID]"
					+ ",[custVLAN])"
					+ "VALUES("
					+ networkParamID
					+ ",1,"
					+ tPortVLAN
					+ ",'188.63.70."
					+ internetIP1
					+ "',"
					+ "'195.168."
					+ internetIP2
					+ ".0',"
					+ "'195.168."
					+ custSubnet
					+ ".0',24,0," + custVLAN + ")\nGO";
			System.out.println(query);
		}
	}
}
