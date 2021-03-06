<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.util.NavigationUtil"%>
<%@ include file="/html/init.jsp" %>

<%
	String navTree = (String)portletSession.getAttribute("NAV_TREE");
	PortletURL url = renderResponse.createRenderURL();
	if (Validator.isNull(navTree)) {
		navTree = NavigationUtil.getTree(0, themeDisplay, url);
		//portletSession.setAttribute("NAV_TREE", navTree);
		//System.out.println(navTree + "!!!!!");
	}
%>

<div id="markupBoundingBox">
	<ul id="markupContentBox">
		<%= navTree %>
	</ul>
</div>
	
<script>
	AUI().ready('aui-tree-view', function(A) {
		var treeView = new A.TreeView({
			boundingBox: '#markupBoundingBox',
			contentBox: '#markupContentBox'
		}).render();
	});
	
	/*
	function loadProducts(categoryId, categoryCode) {
		Liferay.fire("category-event",
				{
					categoryId:categoryId,
					categoryCode:categoryCode
				}
		);
	}
	*/
</script>