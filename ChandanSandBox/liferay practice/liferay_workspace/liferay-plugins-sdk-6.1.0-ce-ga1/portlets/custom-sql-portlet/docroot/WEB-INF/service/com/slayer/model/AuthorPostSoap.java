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

package com.slayer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Chandan
 * @generated
 */
public class AuthorPostSoap implements Serializable {
	public static AuthorPostSoap toSoapModel(AuthorPost model) {
		AuthorPostSoap soapModel = new AuthorPostSoap();

		soapModel.setAuthorPostId(model.getAuthorPostId());
		soapModel.setPostId(model.getPostId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setName(model.getName());
		soapModel.setSpecialization(model.getSpecialization());

		return soapModel;
	}

	public static AuthorPostSoap[] toSoapModels(AuthorPost[] models) {
		AuthorPostSoap[] soapModels = new AuthorPostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorPostSoap[][] toSoapModels(AuthorPost[][] models) {
		AuthorPostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorPostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorPostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorPostSoap[] toSoapModels(List<AuthorPost> models) {
		List<AuthorPostSoap> soapModels = new ArrayList<AuthorPostSoap>(models.size());

		for (AuthorPost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorPostSoap[soapModels.size()]);
	}

	public AuthorPostSoap() {
	}

	public long getPrimaryKey() {
		return _authorPostId;
	}

	public void setPrimaryKey(long pk) {
		setAuthorPostId(pk);
	}

	public long getAuthorPostId() {
		return _authorPostId;
	}

	public void setAuthorPostId(long authorPostId) {
		_authorPostId = authorPostId;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSpecialization() {
		return _specialization;
	}

	public void setSpecialization(String specialization) {
		_specialization = specialization;
	}

	private long _authorPostId;
	private long _postId;
	private String _title;
	private String _content;
	private long _authorId;
	private String _name;
	private String _specialization;
}