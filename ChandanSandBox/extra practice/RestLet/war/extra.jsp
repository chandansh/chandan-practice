<%@ page session="false"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String style = "simple";
		String position = "both";
		String index = "center";
		int maxPageItems = 10;
		int maxIndexPages = 10;
		
	%>
<pg:pager items="<%= webPalette.length %>" index="<%= index %>"
				maxPageItems="<%= maxPageItems %>"
				maxIndexPages="<%= maxIndexPages %>" isOffset="<%= true %>"
				export="offset,currentPageNumber=pageNumber" scope="request">
				<%-- keep track of preference --%>
				<pg:param name="style" />
				<pg:param name="position" />
				<pg:param name="index" />
				<pg:param name="maxPageItems" />
				<pg:param name="maxIndexPages" />

				<%-- save pager offset during form changes --%>
				<input type="hidden" name="pager.offset" value="<%=offset%>">

				<%-- warn if offset is not a multiple of maxPageItems --%>
				<%
					if (offset.intValue() % maxPageItems != 0
								&& ("alltheweb".equals(style) || "lycos".equals(style))) {
				%>
				<p>
					Warning: The current page offset is not a multiple of Max. Page
					Items. <br>Please
					<pg:first>
						<a href="<%=pageUrl%>">return to the first page</a>
					</pg:first>
					if any displayed range numbers appear incorrect.
				</p>
				<%
					}
				%>

				<%-- the pg:pager items attribute must be set to the total number of
       items for index before items to work properly --%>
				<%
					if ("top".equals(position) || "both".equals(position)) {
				%>
				<br>
				<pg:index>
					<%
						if ("texticon".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/texticon.jsp" flush="true" />
					<%
						} else if ("jsptags".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/jsptags.jsp" flush="true" />
					<%
						} else if ("google".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/google.jsp" flush="true" />
					<%
						} else if ("altavista".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/altavista.jsp" flush="true" />
					<%
						} else if ("lycos".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/lycos.jsp" flush="true" />
					<%
						} else if ("yahoo".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/yahoo.jsp" flush="true" />
					<%
						} else if ("alltheweb".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/alltheweb.jsp" flush="true" />
					<%
						} else {
					%>
					<jsp:include page="/WEB-INF/jsp/simple.jsp" flush="true" />
					<%
						}
					%>
				</pg:index>
				<%
					}
				%>

				<hr>
				<table width="90%" cellspacing="4" cellpadding="4">
					<%--
    Since the data source is static, it's easy to offset and limit the
    loop for efficiency. If the data set size is not known or cannot
    be easily offset, the pager tag library can count the items and display
    the correct subset for you.

    The following is an example using an enumeration data source of
    unknown size. The pg:pager items and isOffset attributes must
    not be set for this example:

    <% while (enumeration.hasMoreElements()) { %>
	<pg:item><%= enumeration.nextElement() %><br></pg:item>
    <% } %>

   --%>
					<%
						for (int i = offset.intValue(), l = Math.min(i + maxPageItems,
									webPalette.length); i < l; i++) {
					%><pg:item>
						<tr>
							<th bgcolor="<%=webPalette[i][0]%>"><font
								color="<%=webPalette[i][1]%>"><%=i + 1%></font></th>
						</tr>
					</pg:item>
					<%
						}
					%>
				</table>
				<hr>

				<%
					if ("bottom".equals(position) || "both".equals(position)) {
				%>
				<pg:index>
					<%
						if ("texticon".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/texticon.jsp" flush="true" />
					<%
						} else if ("jsptags".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/jsptags.jsp" flush="true" />
					<%
						} else if ("google".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/google.jsp" flush="true" />
					<%
						} else if ("altavista".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/altavista.jsp" flush="true" />
					<%
						} else if ("lycos".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/lycos.jsp" flush="true" />
					<%
						} else if ("yahoo".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/yahoo.jsp" flush="true" />
					<%
						} else if ("alltheweb".equals(style)) {
					%>
					<jsp:include page="/WEB-INF/jsp/alltheweb.jsp" flush="true" />
					<%
						} else {
					%>
					<jsp:include page="/WEB-INF/jsp/simple.jsp" flush="true" />
					<%
						}
					%>
				</pg:index>
				<%
					}
				%>
			</pg:pager>
</body>
</html>
<%!private static final String BLACK = "#000000", WHITE = "#ffffff";
	private static final String[][] webPalette = { { WHITE, BLACK },
			{ "#cccccc", BLACK }, { "#999999", BLACK }, { "#666666", WHITE },
			{ "#333333", WHITE }, { BLACK, WHITE }, { "#ffcc00", BLACK },
			{ "#ff9900", BLACK }, { "#ff6600", BLACK }, { "#ff3300", WHITE },
			{ "#99cc00", BLACK }, { "#cc9900", BLACK }, { "#ffcc33", BLACK },
			{ "#ffcc66", BLACK }, { "#ff9966", BLACK }, { "#ff6633", BLACK },
			{ "#cc3300", WHITE }, { "#cc0033", WHITE }, { "#ccff00", BLACK },
			{ "#ccff33", BLACK }, { "#333300", WHITE }, { "#666600", WHITE },
			{ "#999900", BLACK }, { "#cccc00", BLACK }, { "#ffff00", BLACK },
			{ "#cc9933", BLACK }, { "#cc6633", WHITE }, { "#330000", WHITE },
			{ "#660000", WHITE }, { "#990000", WHITE }, { "#cc0000", WHITE },
			{ "#ff0000", WHITE }, { "#ff3366", WHITE }, { "#ff0033", WHITE },
			{ "#99ff00", BLACK }, { "#ccff66", BLACK }, { "#99cc33", BLACK },
			{ "#666633", WHITE }, { "#999933", BLACK }, { "#cccc33", BLACK },
			{ "#ffff33", BLACK }, { "#996600", WHITE }, { "#993300", WHITE },
			{ "#663333", WHITE }, { "#993333", WHITE }, { "#cc3333", WHITE },
			{ "#ff3333", WHITE }, { "#cc3366", WHITE }, { "#ff6699", BLACK },
			{ "#ff0066", WHITE }, { "#66ff00", BLACK }, { "#99ff66", BLACK },
			{ "#66cc33", BLACK }, { "#669900", WHITE }, { "#999966", BLACK },
			{ "#cccc66", BLACK }, { "#ffff66", BLACK }, { "#996633", WHITE },
			{ "#663300", WHITE }, { "#996666", WHITE }, { "#cc6666", BLACK },
			{ "#ff6666", BLACK }, { "#990033", WHITE }, { "#cc3399", WHITE },
			{ "#ff66cc", BLACK }, { "#ff0099", WHITE }, { "#33ff00", BLACK },
			{ "#66ff33", BLACK }, { "#339900", WHITE }, { "#66cc00", BLACK },
			{ "#99ff33", BLACK }, { "#cccc99", BLACK }, { "#ffff99", BLACK },
			{ "#cc9966", BLACK }, { "#cc6600", WHITE }, { "#cc9999", BLACK },
			{ "#ff9999", BLACK }, { "#ff3399", WHITE }, { "#cc0066", WHITE },
			{ "#990066", WHITE }, { "#ff33cc", BLACK }, { "#ff00cc", WHITE },
			{ "#00cc00", WHITE }, { "#33cc00", BLACK }, { "#336600", WHITE },
			{ "#669933", WHITE }, { "#99cc66", BLACK }, { "#ccff99", BLACK },
			{ "#ffffcc", BLACK }, { "#ffcc99", BLACK }, { "#ff9933", BLACK },
			{ "#ffcccc", BLACK }, { "#ff99cc", BLACK }, { "#cc6699", BLACK },
			{ "#993366", WHITE }, { "#660033", WHITE }, { "#cc0099", WHITE },
			{ "#330033", WHITE }, { "#33cc33", BLACK }, { "#66cc66", BLACK },
			{ "#00ff00", BLACK }, { "#33ff33", BLACK }, { "#66ff66", BLACK },
			{ "#99ff99", BLACK }, { "#ccffcc", BLACK }, { "#cc99cc", BLACK },
			{ "#996699", WHITE }, { "#993399", WHITE }, { "#990099", WHITE },
			{ "#663366", WHITE }, { "#660066", WHITE }, { "#006600", WHITE },
			{ "#336633", WHITE }, { "#009900", WHITE }, { "#339933", WHITE },
			{ "#669966", BLACK }, { "#99cc99", BLACK }, { "#ffccff", BLACK },
			{ "#ff99ff", BLACK }, { "#ff66ff", BLACK }, { "#ff33ff", BLACK },
			{ "#ff00ff", WHITE }, { "#cc66cc", BLACK }, { "#cc33cc", WHITE },
			{ "#003300", WHITE }, { "#00cc33", WHITE }, { "#006633", WHITE },
			{ "#339966", WHITE }, { "#66cc99", BLACK }, { "#99ffcc", BLACK },
			{ "#ccffff", BLACK }, { "#3399ff", BLACK }, { "#99ccff", BLACK },
			{ "#ccccff", BLACK }, { "#cc99ff", BLACK }, { "#9966cc", BLACK },
			{ "#663399", WHITE }, { "#330066", WHITE }, { "#9900cc", WHITE },
			{ "#cc00cc", WHITE }, { "#00ff33", BLACK }, { "#33ff66", BLACK },
			{ "#009933", WHITE }, { "#00cc66", BLACK }, { "#33ff99", BLACK },
			{ "#99ffff", BLACK }, { "#99cccc", BLACK }, { "#0066cc", WHITE },
			{ "#6699cc", BLACK }, { "#9999ff", BLACK }, { "#9999cc", BLACK },
			{ "#9933ff", WHITE }, { "#6600cc", WHITE }, { "#660099", WHITE },
			{ "#cc33ff", WHITE }, { "#cc00ff", WHITE }, { "#00ff66", BLACK },
			{ "#66ff99", BLACK }, { "#33cc66", BLACK }, { "#009966", WHITE },
			{ "#66ffff", BLACK }, { "#66cccc", BLACK }, { "#669999", BLACK },
			{ "#003366", WHITE }, { "#336699", WHITE }, { "#6666ff", WHITE },
			{ "#6666cc", WHITE }, { "#666699", WHITE }, { "#330099", WHITE },
			{ "#9933cc", WHITE }, { "#cc66ff", BLACK }, { "#9900ff", WHITE },
			{ "#00ff99", BLACK }, { "#66ffcc", BLACK }, { "#33cc99", BLACK },
			{ "#33ffff", BLACK }, { "#33cccc", BLACK }, { "#339999", WHITE },
			{ "#336666", WHITE }, { "#006699", WHITE }, { "#003399", WHITE },
			{ "#3333ff", WHITE }, { "#3333cc", WHITE }, { "#333399", WHITE },
			{ "#333366", WHITE }, { "#6633cc", WHITE }, { "#9966ff", BLACK },
			{ "#6600ff", WHITE }, { "#00ffcc", BLACK }, { "#33ffcc", BLACK },
			{ "#00ffff", BLACK }, { "#00cccc", BLACK }, { "#009999", WHITE },
			{ "#006666", WHITE }, { "#003333", WHITE }, { "#3399cc", BLACK },
			{ "#3366cc", WHITE }, { "#0000ff", WHITE }, { "#0000cc", WHITE },
			{ "#000099", WHITE }, { "#000066", WHITE }, { "#000033", WHITE },
			{ "#6633ff", WHITE }, { "#3300ff", WHITE }, { "#00cc99", BLACK },
			{ "#0099cc", WHITE }, { "#33ccff", BLACK }, { "#66ccff", BLACK },
			{ "#6699ff", BLACK }, { "#3366ff", WHITE }, { "#0033cc", WHITE },
			{ "#3300cc", WHITE }, { "#00ccff", BLACK }, { "#0099ff", WHITE },
			{ "#0066ff", WHITE }, { "#0033ff", WHITE } };

	%>