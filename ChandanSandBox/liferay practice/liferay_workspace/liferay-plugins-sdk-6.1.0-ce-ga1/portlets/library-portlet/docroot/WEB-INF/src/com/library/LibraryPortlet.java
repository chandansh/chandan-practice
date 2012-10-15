package com.library;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.library.slayer.BookExistsException;
import com.library.slayer.model.LMSBook;
import com.library.slayer.model.LMSBookAddressBean;
import com.library.slayer.model.LMSBookJoin;
import com.library.slayer.model.MemberAddress;
import com.library.slayer.model.SocialBean;
import com.library.slayer.service.LMSBookJoinLocalServiceUtil;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.library.slayer.service.MemberAddressLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LibraryPortlet
 */
public class LibraryPortlet extends MVCPortlet {
	 private static final Log _log = LogFactoryUtil.getLog(LibraryPortlet.class);

	public void updateBook(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		
		_log.info("LibraryPortlet updateBook method ...");
		
		String bookTitle = ParamUtil.getString(actionRequest, "bookTitle");
		String author = ParamUtil.getString(actionRequest, "author");
		String description = ParamUtil.getString(actionRequest, "description");
		long bookId = ParamUtil.getLong(actionRequest, "bookId", 0l);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LMSBook book = null;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				LMSBook.class.getName(), actionRequest);
		
		// Duplicate check
		 
		book = LMSBookLocalServiceUtil.getBookByName(bookTitle);
		if(Validator.isNotNull(book)) throw new BookExistsException("Book is available in database");
		 
		 
		if (bookId > 0L) {
			try {
				book = LMSBookLocalServiceUtil.getLMSBook(bookId);
				book.setAuthor(author);
				book.setDescription(description);
				book.setBookTitle(bookTitle);
				
				LMSBookLocalServiceUtil.updateLMSBook(book);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else {
			
			LMSBookLocalServiceUtil.addEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					themeDisplay.getCompanyId(), bookTitle, author, description, serviceContext);
			
		}

		// gracefully redirecting to the default portlet view
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		actionResponse.sendRedirect(redirectURL);

	}

	public void deleteBook(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long bookId = ParamUtil.getLong(actionRequest, "bookId");

		if (bookId > 0L) {
			try {
				LMSBookLocalServiceUtil.deleteLMSBook(bookId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// gracefully redirecting to the default portlet view
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		actionResponse.sendRedirect(redirectURL);
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		System.out.println("hello this is ResourceRequest");
		
		long bookId = ParamUtil.getLong(resourceRequest, "bookId", 0l);
		LMSBook book=null;
		try {
			book =LMSBookLocalServiceUtil.getLMSBook(bookId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		book.setDownloaded(1);
		
		try {
			LMSBookLocalServiceUtil.updateLMSBook(book);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,"max-age=3600, must-revalidate");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		String fileName =resourceRequest.getParameter("fileName");
		String dirName = "LMSBook_Details_Hide";
		long repositoryId = CompanyConstants.SYSTEM;
		long companyId = themeDisplay.getCompanyId();
		
		byte[] bytes=null;

		try {
				
			 bytes = DLStoreUtil.getFileAsBytes(companyId, repositoryId, dirName
					+ "/" + fileName);
			 File f = DLStoreUtil.getFile(companyId, repositoryId, dirName +"/"+ fileName);
			 String mimeType = new MimetypesFileTypeMap().getContentType(f);
			
			 resourceResponse.setContentType(mimeType);
			 OutputStream out = resourceResponse.getPortletOutputStream();
			 out.write(bytes);
			 out.flush();
			 out.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		JSONObject jsonObj;
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		if(cmd.equals("get-book-details"))
		{
			try {
				book =LMSBookLocalServiceUtil.getLMSBook(bookId);
				 jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put("author",book.getAuthor());
				jsonObj.put("bookTitle",book.getBookTitle());
				jsonObj.put("createdDate",book.getCreateDate());
				jsonArr.put(jsonObj);
				PrintWriter pw;
				HttpServletResponse servletResponse = PortalUtil
			            .getHttpServletResponse(resourceResponse);
			try {
			       pw = servletResponse.getWriter();
			       pw.write(jsonArr.toString());
			       pw.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}

	public void invokeTaglibDiscussion(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
 
		PortletConfig portletConfig = getPortletConfig();

		PortalClassInvoker.invoke(true,
				"com.liferay.portlet.messageboards.action.EditDiscussionAction", "processAction",
				new String[] { "org.apache.struts.action.ActionMapping",
						"org.apache.struts.action.ActionForm", PortletConfig.class.getName(),
						ActionRequest.class.getName(), ActionResponse.class.getName() }, null,
				null, portletConfig, actionRequest, actionResponse);
		
		ThemeDisplay themedisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themedisplay.getUserId();
		long groupId = themedisplay.getScopeGroupId();
        String className = LMSBook.class.getName();
        
        long classPK = ParamUtil.getLong(actionRequest, "classPK");
        
	    try {
			SocialActivityLocalServiceUtil.addActivity(userId, groupId, className, classPK, 1, "book", classPK);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void firstForm(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception
	{
		SocialBean socialBean = new SocialBean();
		PortletSession portletSession = actionRequest.getPortletSession();
		
		String cmd = ParamUtil.getString(actionRequest, "form");
		
		if("formone".equalsIgnoreCase(cmd))
		{
			socialBean.setFirstName(ParamUtil.getString(actionRequest, "firstName"));
			socialBean.setLastName(ParamUtil.getString(actionRequest, "lastName") );
			socialBean.setStreet1(ParamUtil.getString(actionRequest, "streetAddress1"));
			socialBean.setStreet2(ParamUtil.getString(actionRequest, "streetAddress2"));
			socialBean.setCity(ParamUtil.getString(actionRequest, "city"));
			socialBean.setZip(ParamUtil.getString(actionRequest, "zip"));
			portletSession.setAttribute("bean", socialBean, PortletSession.APPLICATION_SCOPE);
			
			actionResponse.setRenderParameter("jspPage", "/html/library/userInfoSecond.jsp");
		} else if("formtwo".equalsIgnoreCase(cmd))
		{
			socialBean.setEmailAddress(ParamUtil.getString(actionRequest, "emailAddress"));
			socialBean.setPhoneNumber(ParamUtil.getString(actionRequest, "phoneNumber"));
			socialBean.setMobileNumber(ParamUtil.getString(actionRequest, "mobileNumber"));
			portletSession.setAttribute("beanTwo", socialBean, PortletSession.APPLICATION_SCOPE);
			
			actionResponse.setRenderParameter("jspPage", "/html/library/userInfo.jsp");
		}
	}

	public void formSubmit(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
	{
		PortletSession portletSession = actionRequest.getPortletSession();
		SocialBean socialBeanOne = (SocialBean) portletSession.getAttribute("bean", PortletSession.APPLICATION_SCOPE);
		SocialBean socialBeanTwo = (SocialBean) portletSession.getAttribute("beanTwo", PortletSession.APPLICATION_SCOPE);
		
		if(Validator.isNull(socialBeanTwo)) {
			socialBeanTwo = new SocialBean();
			socialBeanTwo.setEmailAddress(ParamUtil.getString(actionRequest, "emailAddress"));
			socialBeanTwo.setPhoneNumber(ParamUtil.getString(actionRequest, "phoneNumber"));
			socialBeanTwo.setMobileNumber(ParamUtil.getString(actionRequest, "mobileNumber"));
		}
		 
		MemberAddress memberAddress = null;
		try{
			long userId = PortalUtil.getUserId(actionRequest);
			
			memberAddress = MemberAddressLocalServiceUtil.fetchMemberAddress(userId);
			
			if(Validator.isNull(memberAddress)) {
				memberAddress = MemberAddressLocalServiceUtil.createMemberAddress(userId);
				
				memberAddress.setFirstName(socialBeanOne.getFirstName());
				memberAddress.setLastName(socialBeanOne.getLastName());
				memberAddress.setStreetAddress1(socialBeanOne.getStreet1());
				memberAddress.setStreetAddress2(socialBeanOne.getStreet2());
				memberAddress.setCity(socialBeanOne.getCity());
				memberAddress.setZip(socialBeanOne.getZip());
				memberAddress.setEmailAddress(socialBeanTwo.getEmailAddress());
				memberAddress.setPhoneNumber(socialBeanTwo.getPhoneNumber());
				memberAddress.setMobileNumber(socialBeanTwo.getMobileNumber());
				memberAddress.setDateAdded(new Date());
				MemberAddressLocalServiceUtil.addMemberAddress(memberAddress);
				
			} else {
				
				memberAddress.setFirstName(socialBeanOne.getFirstName());
				memberAddress.setLastName(socialBeanOne.getLastName());
				memberAddress.setStreetAddress1(socialBeanOne.getStreet1());
				memberAddress.setStreetAddress2(socialBeanOne.getStreet2());
				memberAddress.setCity(socialBeanOne.getCity());
				memberAddress.setZip(socialBeanOne.getZip());
				memberAddress.setEmailAddress(socialBeanTwo.getEmailAddress());
				memberAddress.setPhoneNumber(socialBeanTwo.getPhoneNumber());
				memberAddress.setMobileNumber(socialBeanTwo.getMobileNumber());
				MemberAddressLocalServiceUtil.updateMemberAddress(memberAddress);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}		

	public void findBooks(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

		String bookTitle = ParamUtil.getString(actionRequest, "bookTitle");

		try {
			List<LMSBookAddressBean> books = LMSBookLocalServiceUtil.findBooksByModel(bookTitle);
			System.out.println(books.size());
			actionRequest.setAttribute("result", books);
			actionResponse.setRenderParameter("jspPage", "/html/library/result.jsp");
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	

    
	
}
