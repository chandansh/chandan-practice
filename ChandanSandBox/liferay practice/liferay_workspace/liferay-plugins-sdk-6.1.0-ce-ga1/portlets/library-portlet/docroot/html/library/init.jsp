<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@taglib uri="http://alloy.liferay.com/tld/aui" prefix ="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.List"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@page import="com.library.slayer.model.LMSBook"%>
<%@page import="com.library.slayer.model.impl.LMSBookImpl"%>
<%@page import="com.library.slayer.service.LMSBookLocalServiceUtil"%>
<%@page import="com.library.LibraryPermission"%>


<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.util.*" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="javax.portlet.*" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.asset.*" %>
<%@ page import="com.liferay.portal.service.permission.LayoutPermissionUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.library.slayer.BookExistsException"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />