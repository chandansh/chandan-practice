package com.acs;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Freemarker
 */
public class Freemarker extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		// try {
		// ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
		// .getAttribute(WebKeys.THEME_DISPLAY);
		// DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(
		// themeDisplay.getScopeGroupId(), 0, "recipe");
		// DLFileEntry dlentry = DLFileEntryLocalServiceUtil.getFileEntry(
		// themeDisplay.getScopeGroupId(), dlFolder.getFolderId(),
		// "recipe1.xml");
		// Document doc = SAXReaderUtil.read(dlentry.getContentStream());
		//
		// // System.out.print("Doc xml xml portlet: \n" + doc.asXML());
		// Element element = doc.getRootElement();
		// // System.out.println(element.getName());
		// List<Element> pTimesQList = element.elements();
		//
		// for (Element e : pTimesQList) {
		//
		// }
		//
		// renderRequest.setAttribute("element", element);
		// // System.out.print(element);
		//
		// } catch (PortalException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (SystemException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (DocumentException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		super.doView(renderRequest, renderResponse);
	}

}
