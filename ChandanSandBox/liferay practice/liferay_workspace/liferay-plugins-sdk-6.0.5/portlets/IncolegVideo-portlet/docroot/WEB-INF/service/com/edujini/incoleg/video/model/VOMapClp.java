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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Edujini
 */
public class VOMapClp extends BaseModelImpl<VOMap> implements VOMap {
	public VOMapClp() {
	}

	public String getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(String pk) {
		setVideoId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _videoId;
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

	public VOMap toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (VOMap)Proxy.newProxyInstance(VOMap.class.getClassLoader(),
				new Class[] { VOMap.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		VOMapClp clone = new VOMapClp();

		clone.setVideoId(getVideoId());
		clone.setOrgId(getOrgId());
		clone.setStoreType(getStoreType());

		return clone;
	}

	public int compareTo(VOMap voMap) {
		String pk = voMap.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VOMapClp voMap = null;

		try {
			voMap = (VOMapClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = voMap.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoId=");
		sb.append(getVideoId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", StoreType=");
		sb.append(getStoreType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.edujini.incoleg.video.model.VOMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>StoreType</column-name><column-value><![CDATA[");
		sb.append(getStoreType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _videoId;
	private String _orgId;
	private String _StoreType;
}