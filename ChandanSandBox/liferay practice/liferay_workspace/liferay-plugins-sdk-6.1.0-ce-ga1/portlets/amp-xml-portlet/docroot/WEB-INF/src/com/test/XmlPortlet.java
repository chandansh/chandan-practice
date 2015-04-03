package com.test;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.freemarker.FreeMarkerTaglibFactoryUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;

/**
 * Portlet implementation class XmlPortlet
 */
public class XmlPortlet extends MVCPortlet {

	private Configuration cfg;

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), 0, "recipe");
			DLFileEntry dlentry = DLFileEntryLocalServiceUtil.getFileEntry(
					themeDisplay.getScopeGroupId(), dlFolder.getFolderId(),
					"recipe1.xml");
			Document doc = SAXReaderUtil.read(dlentry.getContentStream());

			// System.out.print("Doc xml xml portlet: \n" + doc.asXML());
			Element element = doc.getRootElement();
			//System.out.println(element.getName());
			List<Element> pTimesQList = element.elements();
			
			for (Element e : pTimesQList) {
				
			}

			renderRequest.setAttribute("element", element);
			//System.out.print(element);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

}
