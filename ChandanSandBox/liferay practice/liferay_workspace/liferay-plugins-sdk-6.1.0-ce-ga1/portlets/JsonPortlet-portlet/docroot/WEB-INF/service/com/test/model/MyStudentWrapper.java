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

package com.test.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MyStudent}.
 * </p>
 *
 * @author    Chandan
 * @see       MyStudent
 * @generated
 */
public class MyStudentWrapper implements MyStudent, ModelWrapper<MyStudent> {
	public MyStudentWrapper(MyStudent myStudent) {
		_myStudent = myStudent;
	}

	public Class<?> getModelClass() {
		return MyStudent.class;
	}

	public String getModelClassName() {
		return MyStudent.class.getName();
	}

	/**
	* Returns the primary key of this my student.
	*
	* @return the primary key of this my student
	*/
	public long getPrimaryKey() {
		return _myStudent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this my student.
	*
	* @param primaryKey the primary key of this my student
	*/
	public void setPrimaryKey(long primaryKey) {
		_myStudent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this my student.
	*
	* @return the ID of this my student
	*/
	public long getId() {
		return _myStudent.getId();
	}

	/**
	* Sets the ID of this my student.
	*
	* @param id the ID of this my student
	*/
	public void setId(long id) {
		_myStudent.setId(id);
	}

	/**
	* Returns the name of this my student.
	*
	* @return the name of this my student
	*/
	public java.lang.String getName() {
		return _myStudent.getName();
	}

	/**
	* Sets the name of this my student.
	*
	* @param name the name of this my student
	*/
	public void setName(java.lang.String name) {
		_myStudent.setName(name);
	}

	public boolean isNew() {
		return _myStudent.isNew();
	}

	public void setNew(boolean n) {
		_myStudent.setNew(n);
	}

	public boolean isCachedModel() {
		return _myStudent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_myStudent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _myStudent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _myStudent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_myStudent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myStudent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myStudent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MyStudentWrapper((MyStudent)_myStudent.clone());
	}

	public int compareTo(MyStudent myStudent) {
		return _myStudent.compareTo(myStudent);
	}

	@Override
	public int hashCode() {
		return _myStudent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<MyStudent> toCacheModel() {
		return _myStudent.toCacheModel();
	}

	public MyStudent toEscapedModel() {
		return new MyStudentWrapper(_myStudent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _myStudent.toString();
	}

	public java.lang.String toXmlString() {
		return _myStudent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_myStudent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public MyStudent getWrappedMyStudent() {
		return _myStudent;
	}

	public MyStudent getWrappedModel() {
		return _myStudent;
	}

	public void resetOriginalValues() {
		_myStudent.resetOriginalValues();
	}

	private MyStudent _myStudent;
}