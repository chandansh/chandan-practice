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

package com.library.slayer.service.impl;

import java.util.Date;

import com.library.slayer.model.LMSBook;
import com.library.slayer.model.impl.LMSBookImpl;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.library.slayer.service.base.LMSBookServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l m s book remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.library.slayer.service.LMSBookService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ahmed Hasan
 * @see com.library.slayer.service.base.LMSBookServiceBaseImpl
 * @see com.library.slayer.service.LMSBookServiceUtil
 */
public class LMSBookServiceImpl extends LMSBookServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.library.slayer.service.LMSBookServiceUtil} to access the l m s book remote service.
	 */

	/*public LMSBook addBook(LMSBook lmsBook, ServiceContext serviceContext) throws SystemException{
		  return lmsBookLocalService.addBook(lmsBook, serviceContext);
		}*/
	public LMSBook addLibraryBook(String bookTitle, String author,String groupId)
	{
		System.out.println("Service Impl....");
		LMSBook lmsBook = new LMSBookImpl();
		long bookId = 0L;
		long userId = Long.parseLong(groupId);
		try {
			bookId = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lmsBook.setBookId(bookId);
		lmsBook.setBookTitle(bookTitle);
		lmsBook.setAuthor(author);
		lmsBook.setGroupId(userId);
		lmsBook.setCreateDate(new Date());
		try {
			LMSBookLocalServiceUtil.addLMSBook(lmsBook);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lmsBook;
	}
}

