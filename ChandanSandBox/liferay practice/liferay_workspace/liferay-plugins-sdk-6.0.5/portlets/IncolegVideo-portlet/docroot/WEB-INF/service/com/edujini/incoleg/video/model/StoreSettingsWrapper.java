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

/**
 * <p>
 * This class is a wrapper for {@link StoreSettings}.
 * </p>
 *
 * @author    Edujini
 * @see       StoreSettings
 * @generated
 */
public class StoreSettingsWrapper implements StoreSettings {
	public StoreSettingsWrapper(StoreSettings storeSettings) {
		_storeSettings = storeSettings;
	}

	public long getPrimaryKey() {
		return _storeSettings.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_storeSettings.setPrimaryKey(pk);
	}

	public long getStoreId() {
		return _storeSettings.getStoreId();
	}

	public void setStoreId(long storeId) {
		_storeSettings.setStoreId(storeId);
	}

	public java.lang.String getInBId() {
		return _storeSettings.getInBId();
	}

	public void setInBId(java.lang.String inBId) {
		_storeSettings.setInBId(inBId);
	}

	public java.lang.String getPrBId() {
		return _storeSettings.getPrBId();
	}

	public void setPrBId(java.lang.String prBId) {
		_storeSettings.setPrBId(prBId);
	}

	public java.lang.String getOutBId() {
		return _storeSettings.getOutBId();
	}

	public void setOutBId(java.lang.String outBId) {
		_storeSettings.setOutBId(outBId);
	}

	public java.lang.String getAccessKId() {
		return _storeSettings.getAccessKId();
	}

	public void setAccessKId(java.lang.String accessKId) {
		_storeSettings.setAccessKId(accessKId);
	}

	public java.lang.String getSecretAKey() {
		return _storeSettings.getSecretAKey();
	}

	public void setSecretAKey(java.lang.String secretAKey) {
		_storeSettings.setSecretAKey(secretAKey);
	}

	public com.edujini.incoleg.video.model.StoreSettings toEscapedModel() {
		return _storeSettings.toEscapedModel();
	}

	public boolean isNew() {
		return _storeSettings.isNew();
	}

	public void setNew(boolean n) {
		_storeSettings.setNew(n);
	}

	public boolean isCachedModel() {
		return _storeSettings.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_storeSettings.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _storeSettings.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_storeSettings.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _storeSettings.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _storeSettings.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_storeSettings.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _storeSettings.clone();
	}

	public int compareTo(
		com.edujini.incoleg.video.model.StoreSettings storeSettings) {
		return _storeSettings.compareTo(storeSettings);
	}

	public int hashCode() {
		return _storeSettings.hashCode();
	}

	public java.lang.String toString() {
		return _storeSettings.toString();
	}

	public java.lang.String toXmlString() {
		return _storeSettings.toXmlString();
	}

	public StoreSettings getWrappedStoreSettings() {
		return _storeSettings;
	}

	private StoreSettings _storeSettings;
}