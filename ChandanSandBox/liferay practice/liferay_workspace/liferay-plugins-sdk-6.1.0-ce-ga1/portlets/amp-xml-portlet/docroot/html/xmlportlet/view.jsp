<%@page import="com.liferay.portal.kernel.xml.Element"%>
<%@page import="com.liferay.portal.kernel.xml.Document"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.acs.FreeMarkerUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.util.DDMXSDUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.acs.portlet.parser.freemarkerparser"%>

<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>


<portlet:defineObjects />
<theme:defineObjects/>
<portlet:actionURL var ="actionUrl"></portlet:actionURL>
<aui:form name="form1" action="<%=actionUrl %>" method="post">
<%
		String downloadUrl = "";
		DLFolder dlFolder = null;
		DLFileEntry dlentry = null;
		Document doc =null;
		try {
			dlFolder = DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), 0, "test");
			
			
			//System.out.println(DLFileEntryLocalServiceUtil.getDLFileEntries(0, 10));
// 			dlentry = DLFileEntryLocalServiceUtil.getFileEntryByName(
// 					themeDisplay.getScopeGroupId(), dlFolder.getFolderId(),
// 					"test");
			//dlentry = DLFileEntryLocalServiceUtil.getFileEntry(13212);
			//System.out.println(dlentry.getTitle());
			
			
			
			//dlentry = DLFileEntryLocalServiceUtil.getFileEntry(13029);
			//doc = SAXReaderUtil.read(dlentry.getContentStream());
			
			//System.out.print("Doc xml xml portlet: \n"+doc.asXML());
			//System.out.print(SAXReaderUtil.createElement(doc.asXML()));
			
			//DDMXSD ddmxsd = new DDMXSD();
			
			//System.out.println( ddmxsd.getHTML(pageContext, doc.asXML(), locale));
			//out.println( ddmxsd.getHTML(pageContext, doc.asXML(), locale));
			//Element element = doc.getRootElement();

            

//             FreeMarkerContext freeMarkerContext = freemarkerparser.getFreeMarkerContext(

//                          element, PortalUtil.getLocale(renderRequest));

//             System.out.print("freeMarkerContext:"+freeMarkerContext);
			
// 			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
// 			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
// 			Document doc = dBuilder.parse(dlentry.getContentStream());
			
			//System.out.println(doc.getDocumentElement());
			/*
			 * downloadURL= themeDisplay.getPortalURL() +
			 * themeDisplay.getPathContext() + "/documents/" +
			 * themeDisplay.getScopeGroupId() + StringPool.SLASH +
			 * dlentry.getFolderId() + StringPool.SLASH +
			 * HttpUtil.encodeURL(HtmlUtil
			 * .unescape(String.valueOf(dlentry.getTitle()))) + "?version=" +
			 * dlentry.getLatestFileVersion(true).getVersion();
			 */

			/* +"/documents/10179/113801/NARS CREDIT APP.PDF"; */
// 			downloadUrl = themeDisplay.getPortalURL()
// 					+ themeDisplay.getPathContext() + "/documents/"
// 					+ dlFolder.getGroupId() + StringPool.SLASH
// 					+ dlFolder.getFolderId() + StringPool.SLASH
// 					+ "test.xml";
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

%>
	
<%

//out.print(writer.toString());
//System.out.print(writer.toString());
Element element = (Element)renderRequest.getAttribute("element");


%>

<%= FreeMarkerUtil.getHtml(pageContext, renderRequest, element) %>
<aui:button type="submit" value="Add to Cart"/>
</aui:form>	
	
	
