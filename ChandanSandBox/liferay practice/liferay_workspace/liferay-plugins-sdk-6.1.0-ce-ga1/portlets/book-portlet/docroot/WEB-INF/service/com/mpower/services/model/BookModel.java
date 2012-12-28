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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Book service. Represents a row in the &quot;Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.mpower.services.model.impl.BookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.mpower.services.model.impl.BookImpl}.
 * </p>
 *
 * @author Meenu
 * @see Book
 * @see com.mpower.services.model.impl.BookImpl
 * @see com.mpower.services.model.impl.BookModelImpl
 * @generated
 */
public interface BookModel extends BaseModel<Book> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a book model instance should use the {@link Book} interface instead.
	 */

	/**
	 * Returns the primary key of this book.
	 *
	 * @return the primary key of this book
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this book.
	 *
	 * @param primaryKey the primary key of this book
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the book ID of this book.
	 *
	 * @return the book ID of this book
	 */
	public long getBookId();

	/**
	 * Sets the book ID of this book.
	 *
	 * @param bookId the book ID of this book
	 */
	public void setBookId(long bookId);

	/**
	 * Returns the book number of this book.
	 *
	 * @return the book number of this book
	 */
	public long getBookNumber();

	/**
	 * Sets the book number of this book.
	 *
	 * @param bookNumber the book number of this book
	 */
	public void setBookNumber(long bookNumber);

	/**
	 * Returns the writer name of this book.
	 *
	 * @return the writer name of this book
	 */
	@AutoEscape
	public String getWriterName();

	/**
	 * Sets the writer name of this book.
	 *
	 * @param writerName the writer name of this book
	 */
	public void setWriterName(String writerName);

	/**
	 * Returns the create date of this book.
	 *
	 * @return the create date of this book
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this book.
	 *
	 * @param createDate the create date of this book
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the first name of this book.
	 *
	 * @return the first name of this book
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this book.
	 *
	 * @param firstName the first name of this book
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this book.
	 *
	 * @return the last name of this book
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this book.
	 *
	 * @param lastName the last name of this book
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the quantity of this book.
	 *
	 * @return the quantity of this book
	 */
	public int getQuantity();

	/**
	 * Sets the quantity of this book.
	 *
	 * @param quantity the quantity of this book
	 */
	public void setQuantity(int quantity);

	/**
	 * Returns the total cost of this book.
	 *
	 * @return the total cost of this book
	 */
	public double getTotalCost();

	/**
	 * Sets the total cost of this book.
	 *
	 * @param totalCost the total cost of this book
	 */
	public void setTotalCost(double totalCost);

	/**
	 * Returns the status of this book.
	 *
	 * @return the status of this book
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this book.
	 *
	 * @param status the status of this book
	 */
	public void setStatus(String status);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Book book);

	public int hashCode();

	public CacheModel<Book> toCacheModel();

	public Book toEscapedModel();

	public String toString();

	public String toXmlString();
}