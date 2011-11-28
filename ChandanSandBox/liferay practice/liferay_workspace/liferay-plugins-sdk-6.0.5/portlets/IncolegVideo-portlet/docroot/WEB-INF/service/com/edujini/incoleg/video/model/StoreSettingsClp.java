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
public class StoreSettingsClp extends BaseModelImpl<StoreSettings>
	implements StoreSettings {
	public StoreSettingsClp() {
	}

	public long getPrimaryKey() {
		return _storeId;
	}

	public void setPrimaryKey(long pk) {
		setStoreId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_storeId);
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

	public StoreSettings toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (StoreSettings)Proxy.newProxyInstance(StoreSettings.class.getClassLoader(),
				new Class[] { StoreSettings.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		StoreSettingsClp clone = new StoreSettingsClp();

		clone.setStoreId(getStoreId());
		clone.setInBId(getInBId());
		clone.setPrBId(getPrBId());
		clone.setOutBId(getOutBId());
		clone.setAccessKId(getAccessKId());
		clone.setSecretAKey(getSecretAKey());

		return clone;
	}

	public int compareTo(StoreSettings storeSettings) {
		long pk = storeSettings.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StoreSettingsClp storeSettings = null;

		try {
			storeSettings = (StoreSettingsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = storeSettings.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{storeId=");
		sb.append(getStoreId());
		sb.append(", inBId=");
		sb.append(getInBId());
		sb.append(", prBId=");
		sb.append(getPrBId());
		sb.append(", outBId=");
		sb.append(getOutBId());
		sb.append(", accessKId=");
		sb.append(getAccessKId());
		sb.append(", secretAKey=");
		sb.append(getSecretAKey());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.edujini.incoleg.video.model.StoreSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>storeId</column-name><column-value><![CDATA[");
		sb.append(getStoreId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inBId</column-name><column-value><![CDATA[");
		sb.append(getInBId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prBId</column-name><column-value><![CDATA[");
		sb.append(getPrBId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outBId</column-name><column-value><![CDATA[");
		sb.append(getOutBId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessKId</column-name><column-value><![CDATA[");
		sb.append(getAccessKId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secretAKey</column-name><column-value><![CDATA[");
		sb.append(getSecretAKey());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _storeId;
	private String _inBId;
	private String _prBId;
	private String _outBId;
	private String _accessKId;
	private String _secretAKey;
}