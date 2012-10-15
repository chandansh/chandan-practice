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

package com.mpower.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.mpower.services.service.BookLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Meenu
 */
public class BookClp extends BaseModelImpl<Book> implements Book {
	public BookClp() {
	}

	public Class<?> getModelClass() {
		return Book.class;
	}

	public String getModelClassName() {
		return Book.class.getName();
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bookId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getBookNumber() {
		return _bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		_bookNumber = bookNumber;
	}

	public String getWriterName() {
		return _writerName;
	}

	public void setWriterName(String writerName) {
		_writerName = writerName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public double getTotalCost() {
		return _totalCost;
	}

	public void setTotalCost(double totalCost) {
		_totalCost = totalCost;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BookLocalServiceUtil.addBook(this);
		}
		else {
			BookLocalServiceUtil.updateBook(this);
		}
	}

	@Override
	public Book toEscapedModel() {
		return (Book)Proxy.newProxyInstance(Book.class.getClassLoader(),
			new Class[] { Book.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookClp clone = new BookClp();

		clone.setBookId(getBookId());
		clone.setBookNumber(getBookNumber());
		clone.setWriterName(getWriterName());
		clone.setCreateDate(getCreateDate());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setQuantity(getQuantity());
		clone.setTotalCost(getTotalCost());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(Book book) {
		long primaryKey = book.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BookClp book = null;

		try {
			book = (BookClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = book.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bookId=");
		sb.append(getBookId());
		sb.append(", bookNumber=");
		sb.append(getBookNumber());
		sb.append(", writerName=");
		sb.append(getWriterName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", totalCost=");
		sb.append(getTotalCost());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.mpower.services.model.Book");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookNumber</column-name><column-value><![CDATA[");
		sb.append(getBookNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writerName</column-name><column-value><![CDATA[");
		sb.append(getWriterName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalCost</column-name><column-value><![CDATA[");
		sb.append(getTotalCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bookId;
	private long _bookNumber;
	private String _writerName;
	private Date _createDate;
	private String _firstName;
	private String _lastName;
	private int _quantity;
	private double _totalCost;
	private String _status;
}