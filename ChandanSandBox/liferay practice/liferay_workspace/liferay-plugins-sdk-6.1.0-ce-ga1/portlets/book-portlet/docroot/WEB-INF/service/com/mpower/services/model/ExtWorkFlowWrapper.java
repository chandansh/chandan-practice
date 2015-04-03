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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExtWorkFlow}.
 * </p>
 *
 * @author    Meenu
 * @see       ExtWorkFlow
 * @generated
 */
public class ExtWorkFlowWrapper implements ExtWorkFlow,
	ModelWrapper<ExtWorkFlow> {
	public ExtWorkFlowWrapper(ExtWorkFlow extWorkFlow) {
		_extWorkFlow = extWorkFlow;
	}

	public Class<?> getModelClass() {
		return ExtWorkFlow.class;
	}

	public String getModelClassName() {
		return ExtWorkFlow.class.getName();
	}

	/**
	* Returns the primary key of this ext work flow.
	*
	* @return the primary key of this ext work flow
	*/
	public long getPrimaryKey() {
		return _extWorkFlow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ext work flow.
	*
	* @param primaryKey the primary key of this ext work flow
	*/
	public void setPrimaryKey(long primaryKey) {
		_extWorkFlow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ext workflow ID of this ext work flow.
	*
	* @return the ext workflow ID of this ext work flow
	*/
	public long getExtWorkflowId() {
		return _extWorkFlow.getExtWorkflowId();
	}

	/**
	* Sets the ext workflow ID of this ext work flow.
	*
	* @param extWorkflowId the ext workflow ID of this ext work flow
	*/
	public void setExtWorkflowId(long extWorkflowId) {
		_extWorkFlow.setExtWorkflowId(extWorkflowId);
	}

	/**
	* Returns the resource prim key of this ext work flow.
	*
	* @return the resource prim key of this ext work flow
	*/
	public long getResourcePrimKey() {
		return _extWorkFlow.getResourcePrimKey();
	}

	/**
	* Sets the resource prim key of this ext work flow.
	*
	* @param resourcePrimKey the resource prim key of this ext work flow
	*/
	public void setResourcePrimKey(long resourcePrimKey) {
		_extWorkFlow.setResourcePrimKey(resourcePrimKey);
	}

	public boolean isResourceMain() {
		return _extWorkFlow.isResourceMain();
	}

	/**
	* Returns the fully qualified class name of this ext work flow.
	*
	* @return the fully qualified class name of this ext work flow
	*/
	public java.lang.String getClassName() {
		return _extWorkFlow.getClassName();
	}

	/**
	* Returns the class name ID of this ext work flow.
	*
	* @return the class name ID of this ext work flow
	*/
	public long getClassNameId() {
		return _extWorkFlow.getClassNameId();
	}

	/**
	* Sets the class name ID of this ext work flow.
	*
	* @param classNameId the class name ID of this ext work flow
	*/
	public void setClassNameId(long classNameId) {
		_extWorkFlow.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this ext work flow.
	*
	* @return the class p k of this ext work flow
	*/
	public long getClassPK() {
		return _extWorkFlow.getClassPK();
	}

	/**
	* Sets the class p k of this ext work flow.
	*
	* @param classPK the class p k of this ext work flow
	*/
	public void setClassPK(long classPK) {
		_extWorkFlow.setClassPK(classPK);
	}

	/**
	* Returns the parent resource prim key of this ext work flow.
	*
	* @return the parent resource prim key of this ext work flow
	*/
	public long getParentResourcePrimKey() {
		return _extWorkFlow.getParentResourcePrimKey();
	}

	/**
	* Sets the parent resource prim key of this ext work flow.
	*
	* @param parentResourcePrimKey the parent resource prim key of this ext work flow
	*/
	public void setParentResourcePrimKey(long parentResourcePrimKey) {
		_extWorkFlow.setParentResourcePrimKey(parentResourcePrimKey);
	}

	/**
	* Returns the version of this ext work flow.
	*
	* @return the version of this ext work flow
	*/
	public int getVersion() {
		return _extWorkFlow.getVersion();
	}

	/**
	* Sets the version of this ext work flow.
	*
	* @param version the version of this ext work flow
	*/
	public void setVersion(int version) {
		_extWorkFlow.setVersion(version);
	}

	/**
	* Returns the title of this ext work flow.
	*
	* @return the title of this ext work flow
	*/
	public java.lang.String getTitle() {
		return _extWorkFlow.getTitle();
	}

	/**
	* Sets the title of this ext work flow.
	*
	* @param title the title of this ext work flow
	*/
	public void setTitle(java.lang.String title) {
		_extWorkFlow.setTitle(title);
	}

	/**
	* Returns the content of this ext work flow.
	*
	* @return the content of this ext work flow
	*/
	public java.lang.String getContent() {
		return _extWorkFlow.getContent();
	}

	/**
	* Sets the content of this ext work flow.
	*
	* @param content the content of this ext work flow
	*/
	public void setContent(java.lang.String content) {
		_extWorkFlow.setContent(content);
	}

	/**
	* Returns the description of this ext work flow.
	*
	* @return the description of this ext work flow
	*/
	public java.lang.String getDescription() {
		return _extWorkFlow.getDescription();
	}

	/**
	* Sets the description of this ext work flow.
	*
	* @param description the description of this ext work flow
	*/
	public void setDescription(java.lang.String description) {
		_extWorkFlow.setDescription(description);
	}

	/**
	* Returns the priority of this ext work flow.
	*
	* @return the priority of this ext work flow
	*/
	public int getPriority() {
		return _extWorkFlow.getPriority();
	}

	/**
	* Sets the priority of this ext work flow.
	*
	* @param priority the priority of this ext work flow
	*/
	public void setPriority(int priority) {
		_extWorkFlow.setPriority(priority);
	}

	/**
	* Returns the status of this ext work flow.
	*
	* @return the status of this ext work flow
	*/
	public int getStatus() {
		return _extWorkFlow.getStatus();
	}

	/**
	* Sets the status of this ext work flow.
	*
	* @param status the status of this ext work flow
	*/
	public void setStatus(int status) {
		_extWorkFlow.setStatus(status);
	}

	/**
	* Returns the status by user ID of this ext work flow.
	*
	* @return the status by user ID of this ext work flow
	*/
	public long getStatusByUserId() {
		return _extWorkFlow.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this ext work flow.
	*
	* @param statusByUserId the status by user ID of this ext work flow
	*/
	public void setStatusByUserId(long statusByUserId) {
		_extWorkFlow.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this ext work flow.
	*
	* @return the status by user uuid of this ext work flow
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _extWorkFlow.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this ext work flow.
	*
	* @param statusByUserUuid the status by user uuid of this ext work flow
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_extWorkFlow.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this ext work flow.
	*
	* @return the status by user name of this ext work flow
	*/
	public java.lang.String getStatusByUserName() {
		return _extWorkFlow.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this ext work flow.
	*
	* @param statusByUserName the status by user name of this ext work flow
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_extWorkFlow.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this ext work flow.
	*
	* @return the status date of this ext work flow
	*/
	public java.util.Date getStatusDate() {
		return _extWorkFlow.getStatusDate();
	}

	/**
	* Sets the status date of this ext work flow.
	*
	* @param statusDate the status date of this ext work flow
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_extWorkFlow.setStatusDate(statusDate);
	}

	/**
	* @deprecated Renamed to {@link #isApproved()}
	*/
	public boolean getApproved() {
		return _extWorkFlow.getApproved();
	}

	/**
	* Returns <code>true</code> if this ext work flow is approved.
	*
	* @return <code>true</code> if this ext work flow is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _extWorkFlow.isApproved();
	}

	/**
	* Returns <code>true</code> if this ext work flow is a draft.
	*
	* @return <code>true</code> if this ext work flow is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _extWorkFlow.isDraft();
	}

	/**
	* Returns <code>true</code> if this ext work flow is expired.
	*
	* @return <code>true</code> if this ext work flow is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _extWorkFlow.isExpired();
	}

	/**
	* Returns <code>true</code> if this ext work flow is pending.
	*
	* @return <code>true</code> if this ext work flow is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _extWorkFlow.isPending();
	}

	public boolean isNew() {
		return _extWorkFlow.isNew();
	}

	public void setNew(boolean n) {
		_extWorkFlow.setNew(n);
	}

	public boolean isCachedModel() {
		return _extWorkFlow.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_extWorkFlow.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _extWorkFlow.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _extWorkFlow.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_extWorkFlow.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _extWorkFlow.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_extWorkFlow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExtWorkFlowWrapper((ExtWorkFlow)_extWorkFlow.clone());
	}

	public int compareTo(com.mpower.services.model.ExtWorkFlow extWorkFlow) {
		return _extWorkFlow.compareTo(extWorkFlow);
	}

	@Override
	public int hashCode() {
		return _extWorkFlow.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.mpower.services.model.ExtWorkFlow> toCacheModel() {
		return _extWorkFlow.toCacheModel();
	}

	public com.mpower.services.model.ExtWorkFlow toEscapedModel() {
		return new ExtWorkFlowWrapper(_extWorkFlow.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _extWorkFlow.toString();
	}

	public java.lang.String toXmlString() {
		return _extWorkFlow.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_extWorkFlow.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ExtWorkFlow getWrappedExtWorkFlow() {
		return _extWorkFlow;
	}

	public ExtWorkFlow getWrappedModel() {
		return _extWorkFlow;
	}

	public void resetOriginalValues() {
		_extWorkFlow.resetOriginalValues();
	}

	private ExtWorkFlow _extWorkFlow;
}