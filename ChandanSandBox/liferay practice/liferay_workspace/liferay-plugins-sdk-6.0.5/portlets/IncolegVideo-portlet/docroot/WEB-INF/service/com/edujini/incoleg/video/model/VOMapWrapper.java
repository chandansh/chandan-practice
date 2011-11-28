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
 * This class is a wrapper for {@link VOMap}.
 * </p>
 *
 * @author    Edujini
 * @see       VOMap
 * @generated
 */
public class VOMapWrapper implements VOMap {
	public VOMapWrapper(VOMap voMap) {
		_voMap = voMap;
	}

	public java.lang.String getPrimaryKey() {
		return _voMap.getPrimaryKey();
	}

	public void setPrimaryKey(java.lang.String pk) {
		_voMap.setPrimaryKey(pk);
	}

	public java.lang.String getVideoId() {
		return _voMap.getVideoId();
	}

	public void setVideoId(java.lang.String videoId) {
		_voMap.setVideoId(videoId);
	}

	public java.lang.String getOrgId() {
		return _voMap.getOrgId();
	}

	public void setOrgId(java.lang.String orgId) {
		_voMap.setOrgId(orgId);
	}

	public java.lang.String getStoreType() {
		return _voMap.getStoreType();
	}

	public void setStoreType(java.lang.String StoreType) {
		_voMap.setStoreType(StoreType);
	}

	public com.edujini.incoleg.video.model.VOMap toEscapedModel() {
		return _voMap.toEscapedModel();
	}

	public boolean isNew() {
		return _voMap.isNew();
	}

	public void setNew(boolean n) {
		_voMap.setNew(n);
	}

	public boolean isCachedModel() {
		return _voMap.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_voMap.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _voMap.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_voMap.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _voMap.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _voMap.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_voMap.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _voMap.clone();
	}

	public int compareTo(com.edujini.incoleg.video.model.VOMap voMap) {
		return _voMap.compareTo(voMap);
	}

	public int hashCode() {
		return _voMap.hashCode();
	}

	public java.lang.String toString() {
		return _voMap.toString();
	}

	public java.lang.String toXmlString() {
		return _voMap.toXmlString();
	}

	public VOMap getWrappedVOMap() {
		return _voMap;
	}

	private VOMap _voMap;
}