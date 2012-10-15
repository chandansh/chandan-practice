package com.library;

	 import java.io.Serializable;
	 import java.util.Locale;
	 import java.util.Map;

import org.apache.log4j.Logger;

import com.library.slayer.model.LMSBook;
import com.library.slayer.service.LMSBookLocalServiceUtil;
	 import com.liferay.portal.kernel.exception.PortalException;
	 import com.liferay.portal.kernel.exception.SystemException;
	 import com.liferay.portal.kernel.language.LanguageUtil;
	 import com.liferay.portal.kernel.util.GetterUtil;
	 import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
	 import com.liferay.portal.kernel.workflow.WorkflowConstants;
	 import com.liferay.portal.security.permission.ResourceActionsUtil;
	 import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
	 

	 public class LibraryWorkflowHandler extends BaseWorkflowHandler {
	     
		 Logger _log = Logger.getLogger(LibraryWorkflowHandler.class);
	     public static final String CLASS_NAME = LMSBook.class.getName();

	     @Override
	     public String getClassName() {
	         return CLASS_NAME;
	     }

	     @Override
	     public String getType(Locale locale) {
	         return ResourceActionsUtil.getModelResource(locale, CLASS_NAME);
	     }

	     @Override
	     public LMSBook updateStatus(int status, Map<String, Serializable> 	workflowContext)
	             throws PortalException, SystemException {
	    	 System.out.println("In the update status method");
	    	 _log.info("In the update status method");
	         long userId = GetterUtil.getLong(
	                 (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	         
	         long resourcePrimKey = GetterUtil.getLong(
	             (String)workflowContext.get(
	                 WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

	         ServiceContext serviceContext = 	(ServiceContext)workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
	         
	         _log.info("status :: "+ status);
	         return LMSBookLocalServiceUtil.updateWFStatus(
	             userId, resourcePrimKey, status, serviceContext);
	     }
	     
	     @Override
	     protected String getIconPath(ThemeDisplay themeDisplay) {
	         return themeDisplay.getPathThemeImages() + "/trees/page.png";
	     }
	     
	     @Override
	     public String getTitle(long classPK, Locale locale) {
	         String title = null;
	     try {
	         LMSBook lmsbook=LMSBookLocalServiceUtil.getLMSBook(classPK);
	          title=lmsbook.getBookTitle();
	     } catch (PortalException e) {
	         e.printStackTrace();
	     } catch (SystemException e) {
	         e.printStackTrace();
	     }
	     return title;
	     }
	 }

