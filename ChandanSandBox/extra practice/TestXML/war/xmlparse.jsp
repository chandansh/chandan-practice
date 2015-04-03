<%@page import="org.w3c.dom.*,javax.xml.parsers.*"%>
<%
	DocumentBuilderFactory docFactory = DocumentBuilderFactory
			.newInstance();
	docFactory.setCoalescing(true);
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	//Document doc = docBuilder.parse("files/mcq0-50.xml");
	Document doc = docBuilder.parse("http://db.incoleg-qa.appspot.com/db/export/3/0/50");
	
%>
<%!public boolean isTextNode(Node n) {
		return n.getNodeName().equals("#text");
	}%>
<html>
<head>
<title>Parsing of xml using DOM Parser</title>
</head>
<body>
	<h2>
		<font color='green'>XML Parse</font>
	</h2>
	<table border="2">
		<tr>
			<th>Name of Employee</th>
			<th>Address</th>
		</tr>
		<%
			Element element = doc.getDocumentElement();
			NodeList personNodes = element.getChildNodes();
			for (int i = 0; i < personNodes.getLength(); i++) {
				Node emp = personNodes.item(i);
				if (isTextNode(emp))
					continue;
				NodeList nl = emp.getChildNodes();
		%>
		<tr>
			<%
				for (int j = 0; j < nl.getLength(); j++) {
						Node node = nl.item(j);
						if (isTextNode(node))
							continue;
						
			%>
			<td><% 
			//out.print(node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element1 = (Element) node;
				out.println(element1.getChildNodes().item(0).getNodeValue().trim());
			}
			%></td>

			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

