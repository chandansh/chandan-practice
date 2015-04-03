/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mpower.services.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.mpower.services.model.Book;
import com.mpower.services.model.ExtWorkFlow;
import com.mpower.services.model.impl.ExtWorkFlowImpl;
import com.mpower.services.service.ExtWorkFlowLocalServiceUtil;
import com.mpower.services.service.base.BookLocalServiceBaseImpl;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.mpower.services.service.BookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Meenu
 * @see com.mpower.services.service.base.BookLocalServiceBaseImpl
 * @see com.mpower.services.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.mpower.services.service.BookLocalServiceUtil} to access the book local service.
	 */
	
	public Book updateStatus(long userId, long resourcePrimKey,
			int status, ServiceContext serviceContext) {

		Book book = null;
		System.out.println("BookLocalServiceImpl:updateStatus");
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			book = bookPersistence.findByPrimaryKey(resourcePrimKey);
			String labelStatus = "";
			
			if(book != null){
				if(status == 2){
					labelStatus = WorkflowConstants.LABEL_DRAFT;
					labelStatus = labelStatus.substring(0,1).toUpperCase() + labelStatus.substring(1);
				} else if(status == 1){
					labelStatus = WorkflowConstants.LABEL_PENDING;
					labelStatus = labelStatus.substring(0,1).toUpperCase() + labelStatus.substring(1);
				} else if(status == 0){
					labelStatus = WorkflowConstants.LABEL_APPROVED;
					labelStatus = labelStatus.substring(0,1).toUpperCase() + labelStatus.substring(1);
				}
				else {
					labelStatus = WorkflowConstants.LABEL_DENIED;
					labelStatus = labelStatus.substring(0,1).toUpperCase() + labelStatus.substring(1);
				}
			
			if(book != null){
				book.setStatus(labelStatus);
				bookPersistence.update(book, true);
				
				
				//update extworkflowtable
				/*ExtWorkFlow extWorkFlow = ExtWorkFlowLocalServiceUtil.getExtWorkFlow(book.getBookId());
				extWorkFlow.setStatus(status);
				ExtWorkFlowLocalServiceUtil.updateExtWorkFlow(extWorkFlow, true);*/
			
			}
			
			if (labelStatus .equalsIgnoreCase(WorkflowConstants.LABEL_APPROVED)) {
				return book;
			}
			
		} 
	}
			catch (Exception e) {
			e.printStackTrace();
			}
		return book;

	}


	public Book addBook(Book book1, long userId, long companyId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		
		Book book = null;
		User user = userPersistence.findByPrimaryKey(userId);
		book = super.addBook(book1);
		
		/*ExtWorkFlow extWorkFlow = new ExtWorkFlowImpl();
		extWorkFlow.setResourcePrimKey(book.getBookId());
		extWorkFlow.setClassNameId(10405);
		extWorkFlow.setClassPK(book.getBookId());
		extWorkFlow.setParentResourcePrimKey(book.getBookId());
		extWorkFlow.setVersion(1);
		extWorkFlow.setTitle("BOOK ITEM");
		extWorkFlow.setContent("BOOKITEMCONTENT");
		extWorkFlow.setDescription("BOOK ITEM DESCRIPTION");
		extWorkFlow.setPriority(1);
		extWorkFlow.setStatus(WorkflowConstants.STATUS_PENDING);
		extWorkFlow.setStatusByUserId(user.getUserId());
		extWorkFlow.setStatusByUserName(user.getFirstName());
		extWorkFlow.setStatusDate(new java.util.Date());
		extWorkFlow.setExtWorkflowId(book.getBookId());
		
		ExtWorkFlowLocalServiceUtil.addExtWorkFlow(extWorkFlow);*/
		
		try{

				assetEntryLocalService.updateEntry(
					userId, user.getGroupId(), Book.class.getName(),
					book.getBookId(), serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());
			}
			catch(Exception e){
					e.printStackTrace();
				}
		
		/*
		String orderApprovalMailSubject = "Book# "+ book.getBookId() +" is Approved.";
		
		serviceContext.setAttribute("bookRegTitle", "Book Registration");
		
		String dealNotificationEmailSubject = "Request for approval of new Book registerd #"+book.getBookId();
		String dealNotificationEmailBody = "Hi, \n\nPlease review the new book registerd. \n\nThanks, \nCustomer Support";		
		serviceContext.setAttribute("dealNotificationEmailBody", dealNotificationEmailBody);
		serviceContext.setAttribute("dealNotificationEmailSubject", dealNotificationEmailSubject);
		
		String dealNotificationRejectEmailSubject = "Deal Approval ATMT review of Deal Reg #"+book.getBookId() +" rejected";
		String dealNotificationRejectEmailBody = "Hi "+user.getFullName()+", \n\n Your deal#"+book.getBookId()+" is rejected by ATMT Review team. Please contact customer support if you have any questions.\n\nRegards\n\nCustomer Support.";
		serviceContext.setAttribute("dealNotificationRejectEmailSubject", dealNotificationRejectEmailSubject);
		serviceContext.setAttribute("dealNotificationRejectEmailBody", dealNotificationRejectEmailBody);
		
		String dealNotificationApprovalEmailSub = "Deal Approval ATMT review of Deal Reg #"+book.getBookId() +" approved";
		String dealNotificationApprovalEmailBody = "Hi "+user.getFullName()+", \n\n Your deal#"+book.getBookId()+" is approved by ATMT Review team. Please contact customer support if you have any questions.\n\nRegards\n\nCustomer Support.";
		serviceContext.setAttribute("dealNotificationApproveEmailSubject", dealNotificationApprovalEmailSub);
		serviceContext.setAttribute("dealNotificationApproveEmailBody", dealNotificationApprovalEmailBody);

		//serviceContext.setAttribute("ATMTTeamEmailAddresses", getAllEmailAddressForARole(user.getCompanyId(), "DEAL_MANAGER"));
		
		serviceContext.setAttribute("noReplyEmailAddress", "noreply@acs-inc.com");*/

		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId,
				user.getGroupId(), userId, Book.class.getName(),
				book.getPrimaryKey(), book, serviceContext);
		
		System.out.println("BookLocalServiceImpl:addBook end");
		try {
			System.out.println("get all the users in a role");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public String getAllEmailAddressForARole(long companyId, String roleName){
		StringBuilder sbUserMailAddress = new StringBuilder();
		try{
			
		Role role=RoleLocalServiceUtil.getRole(companyId, roleName);
		List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		
		for(User oneUser:users){ 
			if(sbUserMailAddress.length() > 0){
				sbUserMailAddress.append(",");
			}
			sbUserMailAddress.append(oneUser.getEmailAddress());
		} 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sbUserMailAddress.toString();
		
	}
	

}