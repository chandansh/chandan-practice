package com.acs.portlet.parser;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.liferay.portal.kernel.freemarker.FreeMarkerContext;
import com.liferay.portal.kernel.freemarker.FreeMarkerEngineUtil;
import com.liferay.portal.kernel.freemarker.FreeMarkerVariablesUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Attribute;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateConstants;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.freemarker.FreeMarkerTaglibFactoryUtil;

import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.ext.servlet.ServletContextHashModel;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateHashModel;

/**
 * Portlet implementation class freemarkerparser
 */
public class freemarkerparser extends MVCPortlet {
 
	private static final String _DEFAULT_NAMESPACE = "alloy";

	private static final String _DEFAULT_READ_ONLY_NAMESPACE = "readonly";

	private static final String _TPL_DEFAULT_PATH =
		"com/liferay/portlet/dynamicdatamapping/dependencies/alloy/text.ftl";

	private static final String _TPL_DEFAULT_READ_ONLY_PATH =
		"com/liferay/portlet/dynamicdatamapping/dependencies/readonly/" +
			"default.ftl";

	private static final String _TPL_EXT = ".ftl";

	private static final String _TPL_PATH =
		"com/liferay/portlet/dynamicdatamapping/dependencies/";

	private static final String _TYPE_CHECKBOX = "checkbox";

	private static final String _TYPE_DDM_FILEUPLOAD = "ddm-fileupload";

	private static final String _TYPE_RADIO = "radio";

	private static final String _TYPE_SELECT = "select";

	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String downloadUrl = "";
		DLFolder dlFolder = null;
		DLFileEntry dlentry = null;
		Document doc =null;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			dlFolder = DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), 0, "recipees");

// 			dlentry = DLFileEntryLocalServiceUtil.getFileEntryByName(
// 					themeDisplay.getScopeGroupId(), dlFolder.getFolderId(),
// 					"test");
			//dlentry = DLFileEntryLocalServiceUtil.getFileEntry(10522);
			//doc = SAXReaderUtil.read(dlentry.getContentStream());
			
			//Element element = doc.getRootElement();
			
//			FreeMarkerContext freeMarkerContext = freemarkerparser.getFreeMarkerContext(
//					element, PortalUtil.getLocale(renderRequest));
//			System.out.print("freeMarkerContext:"+freeMarkerContext);
//			getHTML(
//					renderRequest, renderResponse, element, null,
//					_DEFAULT_NAMESPACE, null, _DEFAULT_READ_ONLY_NAMESPACE, PortalUtil.getLocale(renderRequest));
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
	
//	public static FreeMarkerContext getFreeMarkerContext(
//			Element dynamicElementElement, Locale locale) {
//
//			FreeMarkerContext freeMarkerContext =
//				FreeMarkerEngineUtil.getWrappedStandardToolsContext();
//
//			Map<String, Object> fieldContext = getFieldContext(
//				dynamicElementElement, locale);
//
//			Map<String, Object> parentFieldContext = new HashMap<String, Object>();
//
//			Element parentElement = dynamicElementElement.getParent();
//
//			if (parentElement != null) {
//				parentFieldContext = getFieldContext(parentElement, locale);
//			}
//
//			freeMarkerContext.put("fieldStructure", fieldContext);
//			freeMarkerContext.put("parentFieldStructure", parentFieldContext);
//
//			return freeMarkerContext;
//		}
//	
//	public static  Map<String, Object> getFieldContext(
//			Element dynamicElementElement, Locale locale) {
//
//			Document document = dynamicElementElement.getDocument();
//
//			String[] availableLocales = LocalizationUtil.getAvailableLocales(
//				document.asXML());
//
//			String defaultLanguageId = LocalizationUtil.getDefaultLocale(
//				document.asXML());
//
//			String languageId = LocaleUtil.toLanguageId(locale);
//
//			if (!ArrayUtil.contains(availableLocales, languageId)) {
//				languageId = defaultLanguageId;
//			}
//
//			Element metadataElement =
//				(Element)dynamicElementElement.selectSingleNode(
//					"meta-data[@locale='" + languageId + "']");
//
//			Map<String, Object> field = new HashMap<String, Object>();
//
//			if (metadataElement != null) {
//				for (Element metadataEntry : metadataElement.elements()) {
//					field.put(
//						metadataEntry.attributeValue("name"),
//						metadataEntry.getText());
//				}
//			}
//
//			for (Attribute attribute : dynamicElementElement.attributes()) {
//				field.put(attribute.getName(), attribute.getValue());
//			}
//
//			return field;
//		}
//	
//	public String getHTML(
//			RenderRequest renderRequest, RenderResponse renderResponse, Element element, Fields fields,
//			String namespace, String mode, boolean readOnly, Locale locale)
//		throws Exception {
//
//		StringBundler sb = new StringBundler();
//
//		HttpServletRequest request =
//			(HttpServletRequest)PortalUtil.getHttpServletRequest(renderRequest);
//
//		String portletId = PortalUtil.getPortletId(request);
//
//		String portletNamespace = PortalUtil.getPortletNamespace(portletId);
//
//		List<Element> dynamicElementElements = element.elements(
//			"PtimesListQ");
//
//		for (Element dynamicElementElement : dynamicElementElements) {
//			FreeMarkerContext freeMarkerContext = getFreeMarkerContext(
//				dynamicElementElement, locale);
//
//			freeMarkerContext.put("portletNamespace", portletNamespace);
//			freeMarkerContext.put("namespace", namespace);
//
//			if (fields != null) {
//				freeMarkerContext.put("fields", fields);
//			}
//
//			Map<String, Object> field =
//				(Map<String, Object>)freeMarkerContext.get("fieldStructure");
//
//			String childrenHTML = getHTML(
//					renderRequest, renderResponse, dynamicElementElement, fields, namespace, mode,
//				readOnly, locale);
//
//			field.put("children", childrenHTML);
//
//			String fieldNamespace = dynamicElementElement.attributeValue(
//				"fieldNamespace", _DEFAULT_NAMESPACE);
//
//			String defaultResourcePath = _TPL_DEFAULT_PATH;
//
//			boolean fieldReadOnly = GetterUtil.getBoolean(
//				field.get("readOnly"));
//
//			if ((fieldReadOnly && Validator.isNotNull(mode) &&
//				 mode.equalsIgnoreCase(
//					DDMTemplateConstants.TEMPLATE_MODE_EDIT)) || readOnly) {
//
//				fieldNamespace = _DEFAULT_READ_ONLY_NAMESPACE;
//
//				defaultResourcePath = _TPL_DEFAULT_READ_ONLY_PATH;
//			}
//
//			String type = dynamicElementElement.attributeValue("type");
//
//			String templateName = StringUtil.replaceFirst(
//				type, fieldNamespace.concat(StringPool.DASH), StringPool.BLANK);
//
//			StringBundler resourcePath = new StringBundler(5);
//
//			resourcePath.append(_TPL_PATH);
//			resourcePath.append(fieldNamespace.toLowerCase());
//			resourcePath.append(CharPool.SLASH);
//			resourcePath.append(templateName);
//			resourcePath.append(_TPL_EXT);
//
//			sb.append(
//				processFTL(
//						renderRequest, renderResponse, freeMarkerContext, resourcePath.toString(),
//					defaultResourcePath));
//		}
//
//		return sb.toString();
//	}	
//	
//	/**
//	 * @see com.liferay.taglib.util.ThemeUtil#includeFTL
//	 */
//	protected String processFTL(
//			RenderRequest renderRequest, RenderResponse renderResponse, FreeMarkerContext freeMarkerContext,
//			String resourcePath, String defaultResourcePath)
//		throws Exception {
//
//		if (!FreeMarkerEngineUtil.resourceExists(resourcePath)) {
//			resourcePath = defaultResourcePath;
//		}
//
//		HttpServletRequest request =
//			(HttpServletRequest)PortalUtil.getHttpServletRequest(renderRequest);;
//
//		// FreeMarker variables
//
//		FreeMarkerVariablesUtil.insertVariables(freeMarkerContext, request);
//
//		// Tag libraries
//
//		HttpServletResponse response =
//			(HttpServletResponse)PortalUtil.getHttpServletResponse(renderResponse);
//
//		Writer writer = new UnsyncStringWriter();
//
//		// Portal JSP tag library factory
//
//		TemplateHashModel portalTaglib =
//			FreeMarkerTaglibFactoryUtil.createTaglibFactory(
//				request.getServletContext());
//
//		freeMarkerContext.put("PortalJspTagLibs", portalTaglib);
//
//		// FreeMarker JSP tag library support
//
//		final Servlet servlet = (Servlet)pageContext.getPage();
//
//		GenericServlet genericServlet = null;
//
//		if (servlet instanceof GenericServlet) {
//			genericServlet = (GenericServlet)servlet;
//		}
//		else {
//			genericServlet = new GenericServlet() {
//
//				@Override
//				public void service(
//						ServletRequest servletRequest,
//						ServletResponse servletResponse)
//					throws ServletException, IOException {
//
//					servlet.service(servletRequest, servletResponse);
//				}
//
//			};
//
//			genericServlet.init(pageContext.getServletConfig());
//		}
//
//		ServletContextHashModel servletContextHashModel =
//			new ServletContextHashModel(
//				genericServlet, ObjectWrapper.DEFAULT_WRAPPER);
//
//		freeMarkerContext.put("Application", servletContextHashModel);
//
//		HttpRequestHashModel httpRequestHashModel = new HttpRequestHashModel(
//			request, response, ObjectWrapper.DEFAULT_WRAPPER);
//
//		freeMarkerContext.put("Request", httpRequestHashModel);
//
//		// Merge templates
//
//		FreeMarkerEngineUtil.mergeTemplate(
//			resourcePath, freeMarkerContext, writer);
//
//		return writer.toString();
//	}	
}
