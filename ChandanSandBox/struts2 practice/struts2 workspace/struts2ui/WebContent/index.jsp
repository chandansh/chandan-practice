<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Hello App Engine</title>
</head>

<body>
	<h1>Hello Struts 2</h1>

	<table>
		<tr>
			<td colspan="2" style="font-weight: bold;">Available
				Application:</td>
		</tr>
		<tr>
			<td><a href="populateRegister">register</a></td>
		</tr>
		<tr>
			<td><a href="populateDatatag">data tag</a></td>
		</tr>
		<tr>
			<td><a href="TestLogger">Test Logger Interceptor</a></td>
		</tr>
	</table>
	<s:bean name="mypack.CurrencyConverter">
		<s:param name="dollars" value="100" />
		100 Dollars = <s:property value="rupees" /> Rupees
	</s:bean>

	<s:bean name="mypack.CurrencyConverter" var="converter">
		<s:param name="dollars" value="100"></s:param>
	</s:bean>
	100 Dollars =
	<s:property value="#converter.rupees" /> Rupees
</body>
</html>
