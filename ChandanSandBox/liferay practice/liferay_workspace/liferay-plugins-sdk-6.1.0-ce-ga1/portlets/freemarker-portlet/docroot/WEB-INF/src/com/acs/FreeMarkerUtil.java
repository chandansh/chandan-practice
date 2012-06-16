package com.acs;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.util.freemarker.FreeMarkerTaglibFactoryUtil;

import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.ext.servlet.ServletContextHashModel;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;

public class FreeMarkerUtil {

	private static Configuration cfg;
	private static Map<String, Object> freeMarkerContext;
	private static File file;

	static {
		cfg = new Configuration();
		freeMarkerContext = new HashMap<String, Object>();
	}

	public static String getHtml(PageContext pageContext,
			RenderRequest renderRequest, String xml) throws ServletException,
			IOException {

		file = new File(renderRequest.getPortletSession().getPortletContext()
				.getRealPath("/")
				+ "templates");
		cfg.setDirectoryForTemplateLoading(file);
		// System.out.println("path 1"+ getPortletContext().getRealPath("/"));
		// System.out.println("path = "+PortalUtil.getHttpServletRequest(renderRequest).getServletContext().getRealPath("/"));

		// Build the data-model

		// Portal JSP tag library factory

		TemplateHashModel portalTaglib = FreeMarkerTaglibFactoryUtil
				.createTaglibFactory(pageContext.getServletContext());

		freeMarkerContext.put("PortalJspTagLibs", portalTaglib);
		// freeMarkerContext.put("message", "Hello Freemarker!");
		// FreeMarker JSP tag library support

		final Servlet servlet = (Servlet) pageContext.getPage();
		GenericServlet genericServlet = null;
		if (servlet instanceof GenericServlet) {
			genericServlet = (GenericServlet) servlet;
		} else {
			genericServlet = new GenericServlet() {

				@Override
				public void service(ServletRequest servletRequest,
						ServletResponse servletResponse)
						throws ServletException, IOException {

					servlet.service(servletRequest, servletResponse);
				}

			};

			genericServlet.init(pageContext.getServletConfig());
		}

		ServletContextHashModel servletContextHashModel = new ServletContextHashModel(
				genericServlet, ObjectWrapper.DEFAULT_WRAPPER);

		freeMarkerContext.put("Application", servletContextHashModel);
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();

		HttpRequestHashModel httpRequestHashModel = new HttpRequestHashModel(
				request, response, ObjectWrapper.DEFAULT_WRAPPER);

		freeMarkerContext.put("Request", httpRequestHashModel);

		response.setContentType("text/html");
		Writer writer = new UnsyncStringWriter();
		
		processTextHtml(writer);

		// processHeadingHtml(element, writer);
		//
		// Element ingradientList = element.element("IngredientList");
		// List<Element> ingradients = ingradientList.elements("Ingredient");
		//
		// Element firstIngradient = ingradients.get(0);
		//
		// List<Element> pTimesListQ = firstIngradient.elements("PtimesListQ");
		//
		// for (Element e : pTimesListQ) {
		// processPTimesListQ(e, writer);
		// }
		//
		// List<Element> pTimesQ = firstIngradient.elements("PtimesQ");
		//
		// for (Element e : pTimesQ) {
		// processPTimesQ(e, writer);
		// }
		//
		// List<Element> optionList = firstIngradient.elements("OptionList");
		//
		// for (Element e : optionList) {
		// processOptionList(e, writer);
		// }

		return writer.toString();

	}

	private static void processOptionList(Element element, Writer writer) {
		try {
			Template t = cfg.getTemplate("optionList.ftl");

			Element core = element.element("Corestructure");
			Element sku = core.element("SKU");

			freeMarkerContext.put("name", sku.getStringValue());

			List<Element> options = element.elements("OptionValue");
			List<String> optList = new ArrayList<String>();
			for (Element e : options) {
				optList.add(e.getStringValue());
			}

			freeMarkerContext.put("optList", optList);
			// Merge the data-model and the template
			try {
				t.process(freeMarkerContext, writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void processPTimesListQ(Element element, Writer writer) {
		try {
			Template t = cfg.getTemplate("pTimesListQ.ftl");

			Element headerElement = element.element("HeaderText");
			freeMarkerContext.put("HeaderText", headerElement.getStringValue());

			List<Element> cores = element.elements("Corestructure");
			List<String> coresList = new ArrayList<String>();
			for (Element core : cores) {
				Element sku = core.element("SKU");
				coresList.add(sku.getStringValue());
			}
			freeMarkerContext.put("coreList", coresList);
			freeMarkerContext.put("name", "quantity");

			// Merge the data-model and the template
			try {
				t.process(freeMarkerContext, writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void processPTimesQ(Element element, Writer writer) {
		try {
			Template t = cfg.getTemplate("pTimesQ.ftl");

			Element core = element.element("Corestructure");
			Element sku = core.element("SKU");

			freeMarkerContext.put("name", sku.getStringValue());

			// Merge the data-model and the template
			try {
				t.process(freeMarkerContext, writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void processHeadingHtml(Element element, Writer writer) {
		try {
			Template t = cfg.getTemplate("heading.ftl");

			Element nameText = element.element("NameText");
			freeMarkerContext.put("NameText", nameText.getStringValue());

			Element descText = element.element("Description");
			freeMarkerContext.put("Description", descText.getStringValue());
			// Merge the data-model and the template
			try {
				t.process(freeMarkerContext, writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void processTextHtml(Writer writer) {
		try {
			Template t = cfg.getTemplate("text.ftl");

			// Element nameText = element.element("NameText");
			// freeMarkerContext.put("NameText", nameText.getStringValue());
			//
			// Element descText = element.element("Description");
			// freeMarkerContext.put("Description", descText.getStringValue());
			// // Merge the data-model and the template
			try {
				t.process(freeMarkerContext, writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
