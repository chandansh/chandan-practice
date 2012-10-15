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

package com.slayer.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.slayer.model.AuthorPost;

import java.io.Serializable;

/**
 * The cache model class for representing AuthorPost in entity cache.
 *
 * @author Chandan
 * @see AuthorPost
 * @generated
 */
public class AuthorPostCacheModel implements CacheModel<AuthorPost>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{authorPostId=");
		sb.append(authorPostId);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", specialization=");
		sb.append(specialization);
		sb.append("}");

		return sb.toString();
	}

	public AuthorPost toEntityModel() {
		AuthorPostImpl authorPostImpl = new AuthorPostImpl();

		authorPostImpl.setAuthorPostId(authorPostId);
		authorPostImpl.setPostId(postId);

		if (title == null) {
			authorPostImpl.setTitle(StringPool.BLANK);
		}
		else {
			authorPostImpl.setTitle(title);
		}

		if (content == null) {
			authorPostImpl.setContent(StringPool.BLANK);
		}
		else {
			authorPostImpl.setContent(content);
		}

		authorPostImpl.setAuthorId(authorId);

		if (name == null) {
			authorPostImpl.setName(StringPool.BLANK);
		}
		else {
			authorPostImpl.setName(name);
		}

		if (specialization == null) {
			authorPostImpl.setSpecialization(StringPool.BLANK);
		}
		else {
			authorPostImpl.setSpecialization(specialization);
		}

		authorPostImpl.resetOriginalValues();

		return authorPostImpl;
	}

	public long authorPostId;
	public long postId;
	public String title;
	public String content;
	public long authorId;
	public String name;
	public String specialization;
}