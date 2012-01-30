<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello Cloud Foundry
	<br>
	<%
		String vcap_services = System.getenv("VCAP_SERVICES");
		out.print(vcap_services);

		// 		Statement stmt = con.createStatement();
		// 		boolean result = stmt
		// 				.execute("create table student(id varchar(10), name varchar(15), password varchar(15))");
		// 		out.print(result);
		// 		DatabaseMetaData mData = con.getMetaData();
		// 		ResultSet rs = mData.getSchemas();
		// 		while (rs.next()) {
		// 			out.print(rs.getString(0) + " " + rs.getString(1) + "<br>");
		// 		}

		Connection connection = null;

		try {

			// establish connection to MySQL Service
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://172.30.48.25:3306/d66c9968e6db64f93b38e547da0db0194",
							"u1oU5brmPJtfs", "piobcAws5k7vD");

			if (connection != null && !connection.isClosed()) {

				out.println("<p>Successfully connected to MySQL service</p>");

				// creating a database table and populating some values

				Statement s = connection.createStatement();

				int count;

				s.executeUpdate("DROP TABLE IF EXISTS animal");

				s.executeUpdate("CREATE TABLE animal ("

				+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT,"

				+ "PRIMARY KEY (id),"

				+ "name CHAR(40), category CHAR(40))");

				out.println("<p>[1] Table successfully created.</p>");

				count = s
						.executeUpdate("INSERT INTO animal (name, category)"

								+ " VALUES"

								+ "('snake', 'reptile'),"

								+ "('frog', 'amphibian'),"

								+ "('tuna', 'fish'),"

								+ "('racoon', 'mammal')");

				out.println("<p>[2] " + count + " rows were inserted.</p>");

				count = 0;

				ResultSet rs = s.executeQuery("select * from animal");

				while (rs.next()) {

					out.print(rs.getString(1) + "  " + rs.getString(2)
							+ " " + rs.getString(3) + "<br>");
					count++;

				}

				out.println("<p>[3] " + count + " rows were fetched.</p>");

				s.close();

				DatabaseMetaData mData = connection.getMetaData();
				String[] types = {"TABLE"};
				ResultSet rs1=mData.getTables(null, null, "%", types);
				while (rs1.next()) {
					out.print(rs1.getString("TABLE_NAME") + " " + rs1.getString("TABLE_NAME")
							+ "<br>");
				}

			}

		} catch (Exception e) {

			out.println(e.getMessage());

		} finally {

			if (connection != null && !connection.isClosed()) {

				connection.close();

			}

			connection = null;

		}
	%>
</body>
</html>