package com.test;


import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mpower.services.model.Book;
import com.mpower.services.model.impl.BookImpl;
import com.mpower.services.service.BookLocalServiceUtil;

/**
 * Portlet implementation class BookPortlet
 */
public class BookPortletAction extends MVCPortlet {
	
	public void addBook(ActionRequest request, ActionResponse response)
			throws Exception {
			
			ThemeDisplay themeDisplay =(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Book book1 = bookFromRequest(request);
			User user = themeDisplay.getUser();
			
			List<WorkflowHandler> list = WorkflowHandlerRegistryUtil.getWorkflowHandlers();
			ServiceContext context = ServiceContextFactory.getInstance(Book.class.getName(), request);
			context.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
			Book book = BookLocalServiceUtil.addBook(book1, user.getUserId(), themeDisplay.getCompanyId() , context);
			SessionMessages.add(request, "book-saved-successfully");
		}
 
	private Book bookFromRequest(ActionRequest request){
		
		Book book = new BookImpl();
		ThemeDisplay themeDisplay =(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		book.setBookNumber(ParamUtil.getLong(request, "bookNumber"));
		book.setWriterName(ParamUtil.getString(request, "writerName"));
		book.setCreateDate(new Date());
		book.setFirstName(ParamUtil.getString(request, "firstName"));
		book.setLastName(ParamUtil.getString(request, "lastName"));
		book.setQuantity(ParamUtil.getInteger(request, "quantity"));
		book.setTotalCost(ParamUtil.getDouble(request, "totalCost"));
		
		User user = themeDisplay.getUser();
		
		book.setStatus(WorkflowConstants.LABEL_PENDING);

		return book;
	}

}
