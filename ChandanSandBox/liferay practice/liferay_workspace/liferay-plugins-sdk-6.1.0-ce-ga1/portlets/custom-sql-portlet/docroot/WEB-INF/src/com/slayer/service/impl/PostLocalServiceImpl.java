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

package com.slayer.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.slayer.model.AuthorPost;
import com.slayer.model.Post;
import com.slayer.service.base.PostLocalServiceBaseImpl;
import com.slayer.service.persistence.PostFinderUtil;

/**
 * The implementation of the post local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.slayer.service.PostLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Chandan
 * @see com.slayer.service.base.PostLocalServiceBaseImpl
 * @see com.slayer.service.PostLocalServiceUtil
 */
public class PostLocalServiceImpl extends PostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.slayer.service.PostLocalServiceUtil} to access the post local
	 * service.
	 */

	public List<AuthorPost> findByTitleContentAuthor(String title,
			String content, String author, int begin, int end)
			throws SystemException {
		return PostFinderUtil.findByTitleContentAuthor(title, content, author,
				begin, end);
	}
}