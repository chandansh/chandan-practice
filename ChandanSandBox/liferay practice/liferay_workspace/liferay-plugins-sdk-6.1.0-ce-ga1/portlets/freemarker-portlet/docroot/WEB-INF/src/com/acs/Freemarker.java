package com.acs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
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

		try {
			// File file = new File(
			// "/home/mpower/Desktop/extra/Iaas-Intel-Multi-Data-Center.xml");
			// System.out.println(file.length());
			String xml = readFileAsString("/home/mpower/Desktop/extra/Iaas-Intel-Multi-Data-Center.xml");
			//System.out.println("old xml : " + xml);
			int idx = xml.indexOf("<recipe");
			int lastIdx = xml.indexOf(">", idx);
			String subStr = xml.substring(idx, lastIdx);
			//System.out.println("subStr : " + subStr);
			String newXml = xml.replace(subStr, "<recipe");
			//System.out.println("new XMl" + newXml);
			Document doc = SAXReaderUtil.read(newXml);
			// Document doc = SAXReaderUtil.read(file);

			// System.out.println(doc.asXML());
			// Map<String, String> namespaces = new HashMap<String, String>();
			// namespaces.put("", "http://cloud.xerox.com/services/qe");
			// namespaces.put("xsi",
			// "http://www.w3.org/2001/XMLSchema-instance");
			// namespaces.put("xsi:schemaLocation",
			// "http://cloud.xerox.com/services/qe recipe.xsd ");
			//XPath xPath = SAXReaderUtil.createXPath("//recipe/ingredientList[1]/pTimesListQ[1]/coreStructure[2]/sku");

			XPath xPath = SAXReaderUtil
					.createXPath("/*[name()='recipe']/*[name()='ingredientList'][1]/*[name()='pTimesQ'][2]/*[name()='coreStructure'][1]");

			Node node = xPath.selectSingleNode(doc);
			if (node != null) {
				// System.out.println(node.size());
				Element element = (Element) node;
				System.out.println("uniquePath : "+element.getUniquePath());
				System.out.println("node xml"+node.asXML());
				System.out.println(getXPath(element));

			}
			Element rootEle = doc.getRootElement();
			Element ele = rootEle.elements("ingredientList").get(0).elements("pTimesListQ").get(0).elements("coreStructure").get(1).element("sku");
			System.out.println("element unique : ==== "+ele.getUniquePath());
			
			super.doView(renderRequest, renderResponse);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String readFileAsString(String filePath)
			throws java.io.IOException {
		String results = "";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		line = reader.readLine();
		while (line != null) {
			results += line;
			line = reader.readLine();
		}
		reader.close();
		return results;
	}

	public static String getXPath(Element element) {
		String xPath = "/" + element.getName();
		Node node = element;
		Element parent = element.getParent();
		int idx = parent.indexOf(node);
		xPath += "[" + idx + "]";
		System.out.println("parent index : " + idx);
		if (!parent.isRootElement()) {
			xPath = getXPath(parent) + xPath;
		}
		return xPath;
	}

}
