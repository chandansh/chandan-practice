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

package com.edujini.incoleg.video.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.edujini.incoleg.video.service.http.VOMapServiceSoap}.
 * </p>
 *
 * @author    Edujini
 * @see       com.edujini.incoleg.video.service.http.VOMapServiceSoap
 * @generated
 */
public class VOMapSoap implements Serializable {
	public static VOMapSoap toSoapModel(VOMap model) {
		VOMapSoap soapModel = new VOMapSoap();

		soapModel.setVideoId(model.getVideoId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setStoreType(model.getStoreType());

		return soapModel;
	}

	public static VOMapSoap[] toSoapModels(VOMap[] models) {
		VOMapSoap[] soapModels = new VOMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VOMapSoap[][] toSoapModels(VOMap[][] models) {
		VOMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VOMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VOMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VOMapSoap[] toSoapModels(List<VOMap> models) {
		List<VOMapSoap> soapModels = new ArrayList<VOMapSoap>(models.size());

		for (VOMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VOMapSoap[soapModels.size()]);
	}

	public VOMapSoap() {
	}

	public String getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(String pk) {
		setVideoId(pk);
	}

	public String getVideoId() {
		return _videoId;
	}

	public void setVideoId(String videoId) {
		_videoId = videoId;
	}

	public String getOrgId() {
		return _orgId;
	}

	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	public String getStoreType() {
		return _StoreType;
	}

	public void setStoreType(String StoreType) {
		_StoreType = StoreType;
	}

	private String _videoId;
	private String _orgId;
	private String _StoreType;
}