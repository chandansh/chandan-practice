<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<aui:button-row id='<%= renderResponse.getNamespace() + "btnRows" %>'></aui:button-row>

<aui:script use='aui-toolbar'>
	var inst = new A.Toolbar({
		boundingBox: '<portlet:namespace />btnRows',
		children: [
			{icon: 'plus', label: 'Add'},
			{icon: 'minus', label: 'Delete'}
	]}).render();
	//inst.render();
	//alert('Instance: ' + inst);
</aui:script>


