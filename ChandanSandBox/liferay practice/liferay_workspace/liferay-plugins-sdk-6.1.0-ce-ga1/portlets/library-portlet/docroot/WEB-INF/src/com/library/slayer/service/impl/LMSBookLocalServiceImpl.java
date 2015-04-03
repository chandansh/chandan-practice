/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.library.slayer.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.LibraryPermission;
import com.library.slayer.model.LMSBook;
import com.library.slayer.model.LMSBookAddressBean;
import com.library.slayer.model.LMSBookJoin;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.library.slayer.service.base.LMSBookLocalServiceBaseImpl;
import com.library.slayer.service.persistence.LMSBookFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.social.LibraryActivityKeys;

/**
 * The implementation of the l m s book local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.library.slayer.service.LMSBookLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ahmed Hasan
 * @see com.library.slayer.service.base.LMSBookLocalServiceBaseImpl
 * @see com.library.slayer.service.LMSBookLocalServiceUtil
 */
public class LMSBookLocalServiceImpl extends LMSBookLocalServiceBaseImpl {

	public static final String[] CLASS_NAMES = { LMSBook.class.getName() };

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#AdvanceSearchAny(long,
	 * long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<LMSBook> AdvanceSearchAny(long companyId, long groupId, String title, String author, String desc) {

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		searchContext.setEntryClassNames(CLASS_NAMES);
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		Hits hits = null;
		try {
			String[] terms = { Field.TITLE, Field.DESCRIPTION, Field.NAME };
			searchQuery.addTerms(terms, getModelClassName());
			searchQuery = createQuery(getModelClassName(), getModelClassName(), searchContext, searchQuery);
			hits = SearchEngineUtil.search(searchContext, searchQuery);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<LMSBook> books = null;

		if (hits != null && hits.getLength() > 0) {
			books = new ArrayList<LMSBook>();
			for (Document document : hits.getDocs()) {

				long bookId = Long.parseLong(document.get(Field.ENTRY_CLASS_PK));
				try {
					LMSBook book = LMSBookLocalServiceUtil.getLMSBook(bookId);
					books.add(book);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return books;

	}

	/**
	 * @param fieldName
	 * @param value
	 * @param searchContext
	 * @param fullQuery
	 * @return
	 */
	private BooleanQuery createQuery(String fieldName, String value, SearchContext searchContext, BooleanQuery fullQuery) {
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		String[] splitValue = value.split(",");
		for (String splitVal : splitValue) {
			try {
				searchQuery.addTerm(fieldName, splitVal.replace(" ", ","));
			} catch (ParseException e) {

			}
		}
		try {
			fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
		} catch (ParseException e) {

		}
		return fullQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#advanceSearchAll(long,
	 * long, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	public List<LMSBook> advanceSearchAll(long companyId, long groupId, String title, String author, String desc,
			String type) {

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		searchContext.setEntryClassNames(CLASS_NAMES);

		BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
		contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
		contextQuery.addRequiredTerm(Field.PORTLET_ID,
				Long.toString(ClassNameLocalServiceUtil.getClassNameId(LMSBook.class)));

		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		fullQuery.setQueryConfig(searchContext.getQueryConfig());
		try {
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		Hits hits = null;

		if (Validator.isNotNull(title)) {
			Sort sort = new Sort(Field.TITLE, true);
			searchContext.setSorts(new Sort[] { sort });

			fullQuery = createQuery(Field.TITLE, title, searchContext, fullQuery);

		}
		if (Validator.isNotNull(author)) {
			fullQuery = createQuery(Field.NAME, author, searchContext, fullQuery);
		}
		if (Validator.isNotNull(desc)) {
			fullQuery = createQuery(Field.DESCRIPTION, desc, searchContext, fullQuery);
		}

		if (searchQuery.clauses().size() > 0) {
			try {
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			hits = SearchEngineUtil.search(searchContext, fullQuery);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<LMSBook> books = new ArrayList<LMSBook>();

		if (hits != null && hits.getLength() > 0) {
			for (Document document : hits.getDocs()) {

				long bookId = Long.parseLong(document.get(Field.ENTRY_CLASS_PK));
				try {
					LMSBook book = LMSBookLocalServiceUtil.getLMSBook(bookId);
					books.add(book);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return books;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.library.slayer.service.LMSBookLocalService#searchBooks(long,
	 * java.lang.String)
	 */
	public List<LMSBook> searchBooks(long companyId, String keywords) {

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		searchContext.setEntryClassNames(CLASS_NAMES);

		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);

		Hits hits = null;

		try {
			String[] terms = { Field.TITLE, Field.DESCRIPTION };
			searchQuery.addTerms(terms, keywords);
			hits = SearchEngineUtil.search(searchContext, searchQuery);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<LMSBook> books = null;

		if (hits != null && hits.getLength() > 0) {
			books = new ArrayList<LMSBook>();
			for (Document document : hits.getDocs()) {

				long bookId = Long.parseLong(document.get(Field.ENTRY_CLASS_PK));
				try {
					LMSBook book = LMSBookLocalServiceUtil.getLMSBook(bookId);
					books.add(book);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return books;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.library.slayer.service.LMSBookLocalService#search(long,
	 * java.lang.String)
	 */
	public Hits search(long companyId, String keywords) {

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		searchContext.setEntryClassNames(CLASS_NAMES);

		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);

		Hits hits = null;

		try {
			searchQuery.addTerm(Field.TITLE, keywords);
			hits = SearchEngineUtil.search(searchContext, searchQuery);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hits;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#addBook(com.library.slayer
	 * .model.LMSBook, com.liferay.portal.service.ServiceContext)
	 */
	public LMSBook addBook(LMSBook lmsBook, ServiceContext serviceContext) {

		lmsBook.setCreateDate(new java.util.Date());
		lmsBook.setUuid(serviceContext.getUuid());
		
		try {
			lmsBook = addLMSBook(lmsBook);
			sendMessage(lmsBook, serviceContext);

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Resources
		try {
			resourceLocalService.addModelResources(lmsBook, serviceContext);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Asset
		try {
			updateAsset(serviceContext.getUserId(), lmsBook, serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), serviceContext.getAssetLinkEntryIds());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lmsBook;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.library.slayer.service.LMSBookLocalService#updateAsset(long,
	 * com.library.slayer.model.LMSBook, long[], java.lang.String[], long[])
	 */
	public void updateAsset(long userId, LMSBook lmsBook, long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, lmsBook.getGroupId(),
				LMSBook.class.getName(), lmsBook.getBookId(), lmsBook.getUuid(), 0, assetCategoryIds, assetTagNames,
				true, null, null, null, null, ContentTypes.TEXT_PLAIN, lmsBook.getUserName(), lmsBook.getBookTitle(),
				null, lmsBook.getAuthor(), null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#getAllBooksWithPermission
	 * ()
	 */
	public List<LMSBook> getAllBooksWithPermission() throws SystemException, PrincipalException, PortalException {
		int count = getLMSBooksCount();
		List<LMSBook> allBooks = getLMSBooks(0, count);
		List<LMSBook> books = new ArrayList<LMSBook>();
		for (LMSBook book : allBooks) {
			if (LibraryPermission.contains(getPermissionChecker(), book, ActionKeys.VIEW)) {
				books.add(book);
			}
		}
		return books;
	}

	/**
	 * @return
	 * @throws PrincipalException
	 */
	private PermissionChecker getPermissionChecker() throws PrincipalException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

		if (permissionChecker == null) {
			throw new PrincipalException("PermissionChecker not initialized");
		}

		return permissionChecker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#getBookByName(java.lang
	 * .String)
	 */
	public LMSBook getBookByName(String bookTitle) {
		LMSBook book = null;

		try {
			book = lmsBookPersistence.fetchByBook(bookTitle);
		} catch (SystemException e) {

		}

		return book;
	}

	public void sendMessage(LMSBook lmsBook, ServiceContext serviceContext) {
		/*
		 * Here we are setting the message that Message Bus will carry to the
		 * Listener class. Here we are setting the id and name of the book that
		 * the user has added into the databse
		 */
		Message message = new Message();
		message.put("bookID", lmsBook.getBookId());
		message.put("bookName", lmsBook.getBookTitle());
		/*
		 * Now we are sending the message to the listener class
		 */
		MessageBusUtil.sendMessage("destinationBus", message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.library.slayer.service.LMSBookLocalService#addEntry(long, long,
	 * long, java.lang.String, java.lang.String, java.lang.String,
	 * com.liferay.portal.service.ServiceContext)
	 */
	public LMSBook addEntry(long userId, long groupId, long companyId, String bookTitle, String author,
			String description, ServiceContext serviceContext) throws PortalException, SystemException {

		LMSBook lmsBook = null;
		long classPK = 0l;

		String userName = userLocalService.getUser(userId).getFullName();
		//lmsBook = super.addLMSBook(lmsBook);

		try {
			classPK = CounterLocalServiceUtil.increment(LMSBook.class.getName());
			lmsBook = LMSBookLocalServiceUtil.createLMSBook(classPK);
			lmsBook.setBookTitle(bookTitle);
			lmsBook.setAuthor(author);
			lmsBook.setCreateDate(new Date());
			lmsBook.setModifiedDate(new Date());
			lmsBook.setCompanyId(companyId);
			lmsBook.setGroupId(groupId);
			lmsBook.setUserId(userId);
			lmsBook.setDescription(description);
			lmsBook.setUserName(userName);
			lmsBook.setStatus(WorkflowConstants.STATUS_DRAFT);
			lmsBook = LMSBookLocalServiceUtil.addLMSBook(lmsBook);
			

			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					lmsBook.getCompanyId(), 
					lmsBook.getUserId(), 
					LMSBook.class.getName(), 
					lmsBook.getBookId(), 
					lmsBook, 
					serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// Resources
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			addEntryResources(lmsBook, userId, groupId, companyId, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		} else {
			addEntryResources(lmsBook, userId, groupId, companyId, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
		// Asset
		updateAsset(userId, groupId, lmsBook, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		// Social Activity
		SocialActivityLocalServiceUtil.addUniqueActivity(userId, groupId, LMSBook.class.getName(), classPK,
				LibraryActivityKeys.ADD_ENTRY, StringPool.BLANK, 0);

		return lmsBook;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#addEntryResources(com.
	 * library.slayer.model.LMSBook, long, long, long, boolean, boolean)
	 */
	public void addEntryResources(LMSBook lmsBook, long userId, long groupId, long companyId,
			boolean addGroupPermissions, boolean addGuestPermissions) throws PortalException, SystemException {

		resourceLocalService.addResources(companyId, groupId, userId, LMSBook.class.getName(), lmsBook.getBookId(),
				false, addGroupPermissions, addGuestPermissions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#addEntryResources(com.
	 * library.slayer.model.LMSBook, long, long, long, java.lang.String[],
	 * java.lang.String[])
	 */
	public void addEntryResources(LMSBook lmsBook, long userId, long groupId, long companyId,
			String[] groupPermissions, String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.addModelResources(companyId, groupId, userId, LMSBook.class.getName(),
				lmsBook.getBookId(), groupPermissions, guestPermissions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.library.slayer.service.LMSBookLocalService#updateAsset(long,
	 * long, com.library.slayer.model.LMSBook, long[], java.lang.String[],
	 * long[])
	 */
	public void updateAsset(long userId, long groupId, LMSBook lmsBook, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;

		String author = lmsBook.getAuthor();
		User user = userLocalService.getUser(userId);

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId, groupId, LMSBook.class.getName(),
				lmsBook.getBookId(), user.getUserUuid(), 0, assetCategoryIds, assetTagNames, visible, null, null,
				new Date(), null, ContentTypes.TEXT_HTML, lmsBook.getBookTitle(), null, author, null, null, 0, 0, null,
				false);

		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.library.slayer.service.LMSBookLocalService#findBook(java.lang.String)
	 */
	public List<LMSBookJoin> findBook(String bookTitle) throws PortalException, SystemException, RemoteException {

		return LMSBookFinderUtil.findBooks("%" + bookTitle + "%");
	}

	public List<LMSBookAddressBean> findBooksByModel(String bookTitle) throws PortalException, SystemException,
			RemoteException {

		return LMSBookFinderUtil.findBooksByModel("%" + bookTitle + "%");
	}
	
	public LMSBook updateWFStatus(long userId, long resourcePrimKey, int status,
			ServiceContext serviceContext)throws PortalException, 	SystemException {
		System.out.println("inside updateWFStatus method of impl class");
		LMSBook lmsBook = getLMSBook(resourcePrimKey);
		lmsBook.setStatus(status);
		updateLMSBook(lmsBook);
		return lmsBook;
	}

}