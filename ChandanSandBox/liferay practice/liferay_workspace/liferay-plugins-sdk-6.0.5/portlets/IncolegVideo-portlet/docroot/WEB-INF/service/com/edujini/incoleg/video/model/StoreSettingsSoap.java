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
 * {@link com.edujini.incoleg.video.service.http.StoreSettingsServiceSoap}.
 * </p>
 *
 * @author    Edujini
 * @see       com.edujini.incoleg.video.service.http.StoreSettingsServiceSoap
 * @generated
 */
public class StoreSettingsSoap implements Serializable {
	public static StoreSettingsSoap toSoapModel(StoreSettings model) {
		StoreSettingsSoap soapModel = new StoreSettingsSoap();

		soapModel.setStoreId(model.getStoreId());
		soapModel.setInBId(model.getInBId());
		soapModel.setPrBId(model.getPrBId());
		soapModel.setOutBId(model.getOutBId());
		soapModel.setAccessKId(model.getAccessKId());
		soapModel.setSecretAKey(model.getSecretAKey());

		return soapModel;
	}

	public static StoreSettingsSoap[] toSoapModels(StoreSettings[] models) {
		StoreSettingsSoap[] soapModels = new StoreSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StoreSettingsSoap[][] toSoapModels(StoreSettings[][] models) {
		StoreSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StoreSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StoreSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StoreSettingsSoap[] toSoapModels(List<StoreSettings> models) {
		List<StoreSettingsSoap> soapModels = new ArrayList<StoreSettingsSoap>(models.size());

		for (StoreSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StoreSettingsSoap[soapModels.size()]);
	}

	public StoreSettingsSoap() {
	}

	public long getPrimaryKey() {
		return _storeId;
	}

	public void setPrimaryKey(long pk) {
		setStoreId(pk);
	}

	public long getStoreId() {
		return _storeId;
	}

	public void setStoreId(long storeId) {
		_storeId = storeId;
	}

	public String getInBId() {
		return _inBId;
	}

	public void setInBId(String inBId) {
		_inBId = inBId;
	}

	public String getPrBId() {
		return _prBId;
	}

	public void setPrBId(String prBId) {
		_prBId = prBId;
	}

	public String getOutBId() {
		return _outBId;
	}

	public void setOutBId(String outBId) {
		_outBId = outBId;
	}

	public String getAccessKId() {
		return _accessKId;
	}

	public void setAccessKId(String accessKId) {
		_accessKId = accessKId;
	}

	public String getSecretAKey() {
		return _secretAKey;
	}

	public void setSecretAKey(String secretAKey) {
		_secretAKey = secretAKey;
	}

	private long _storeId;
	private String _inBId;
	private String _prBId;
	private String _outBId;
	private String _accessKId;
	private String _secretAKey;
}