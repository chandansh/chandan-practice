<%@ include file="/html/init.jsp"%>
<tiles:useAttribute id="tilesPortletContent" name="portlet_content"
	classname="java.lang.String" ignore="true" />
<table width="100%" style="border: 1px solid blue;">
	<tr>
		<td width="200" valign="top">
			<h2>Menu</h2>
		</td>

		<td width="400">
			<div>
				<liferay-util:include page="<%=tilesPortletContent %>"
					servletContext="<%=application %>" />
			</div>
		</td>
	</tr>

</table>
