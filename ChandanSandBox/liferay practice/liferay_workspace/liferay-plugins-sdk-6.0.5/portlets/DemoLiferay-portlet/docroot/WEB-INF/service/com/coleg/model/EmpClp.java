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

package com.coleg.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author chandan
 */
public class EmpClp extends BaseModelImpl<Emp> implements Emp {
	public EmpClp() {
	}

	public String getPrimaryKey() {
		return _empId;
	}

	public void setPrimaryKey(String pk) {
		setEmpId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _empId;
	}

	public String getEmpId() {
		return _empId;
	}

	public void setEmpId(String empId) {
		_empId = empId;
	}

	public String getUname() {
		return _uname;
	}

	public void setUname(String uname) {
		_uname = uname;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Emp toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Emp)Proxy.newProxyInstance(Emp.class.getClassLoader(),
				new Class[] { Emp.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		EmpClp clone = new EmpClp();

		clone.setEmpId(getEmpId());
		clone.setUname(getUname());
		clone.setAddress(getAddress());

		return clone;
	}

	public int compareTo(Emp emp) {
		String pk = emp.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EmpClp emp = null;

		try {
			emp = (EmpClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = emp.getPrimaryKey();

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

		sb.append("{empId=");
		sb.append(getEmpId());
		sb.append(", uname=");
		sb.append(getUname());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.coleg.model.Emp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uname</column-name><column-value><![CDATA[");
		sb.append(getUname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _empId;
	private String _uname;
	private String _address;
}