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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ResourcedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ExtWorkFlow service. Represents a row in the &quot;ExtWorkFlow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.mpower.services.model.impl.ExtWorkFlowModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.mpower.services.model.impl.ExtWorkFlowImpl}.
 * </p>
 *
 * @author Meenu
 * @see ExtWorkFlow
 * @see com.mpower.services.model.impl.ExtWorkFlowImpl
 * @see com.mpower.services.model.impl.ExtWorkFlowModelImpl
 * @generated
 */
public interface ExtWorkFlowModel extends AttachedModel, BaseModel<ExtWorkFlow>,
	ResourcedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ext work flow model instance should use the {@link ExtWorkFlow} interface instead.
	 */

	/**
	 * Returns the primary key of this ext work flow.
	 *
	 * @return the primary key of this ext work flow
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ext work flow.
	 *
	 * @param primaryKey the primary key of this ext work flow
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ext workflow ID of this ext work flow.
	 *
	 * @return the ext workflow ID of this ext work flow
	 */
	public long getExtWorkflowId();

	/**
	 * Sets the ext workflow ID of this ext work flow.
	 *
	 * @param extWorkflowId the ext workflow ID of this ext work flow
	 */
	public void setExtWorkflowId(long extWorkflowId);

	/**
	 * Returns the resource prim key of this ext work flow.
	 *
	 * @return the resource prim key of this ext work flow
	 */
	public long getResourcePrimKey();

	/**
	 * Sets the resource prim key of this ext work flow.
	 *
	 * @param resourcePrimKey the resource prim key of this ext work flow
	 */
	public void setResourcePrimKey(long resourcePrimKey);

	public boolean isResourceMain();

	/**
	 * Returns the fully qualified class name of this ext work flow.
	 *
	 * @return the fully qualified class name of this ext work flow
	 */
	public String getClassName();

	/**
	 * Returns the class name ID of this ext work flow.
	 *
	 * @return the class name ID of this ext work flow
	 */
	public long getClassNameId();

	/**
	 * Sets the class name ID of this ext work flow.
	 *
	 * @param classNameId the class name ID of this ext work flow
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this ext work flow.
	 *
	 * @return the class p k of this ext work flow
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this ext work flow.
	 *
	 * @param classPK the class p k of this ext work flow
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the parent resource prim key of this ext work flow.
	 *
	 * @return the parent resource prim key of this ext work flow
	 */
	public long getParentResourcePrimKey();

	/**
	 * Sets the parent resource prim key of this ext work flow.
	 *
	 * @param parentResourcePrimKey the parent resource prim key of this ext work flow
	 */
	public void setParentResourcePrimKey(long parentResourcePrimKey);

	/**
	 * Returns the version of this ext work flow.
	 *
	 * @return the version of this ext work flow
	 */
	public int getVersion();

	/**
	 * Sets the version of this ext work flow.
	 *
	 * @param version the version of this ext work flow
	 */
	public void setVersion(int version);

	/**
	 * Returns the title of this ext work flow.
	 *
	 * @return the title of this ext work flow
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this ext work flow.
	 *
	 * @param title the title of this ext work flow
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this ext work flow.
	 *
	 * @return the content of this ext work flow
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this ext work flow.
	 *
	 * @param content the content of this ext work flow
	 */
	public void setContent(String content);

	/**
	 * Returns the description of this ext work flow.
	 *
	 * @return the description of this ext work flow
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this ext work flow.
	 *
	 * @param description the description of this ext work flow
	 */
	public void setDescription(String description);

	/**
	 * Returns the priority of this ext work flow.
	 *
	 * @return the priority of this ext work flow
	 */
	public int getPriority();

	/**
	 * Sets the priority of this ext work flow.
	 *
	 * @param priority the priority of this ext work flow
	 */
	public void setPriority(int priority);

	/**
	 * Returns the status of this ext work flow.
	 *
	 * @return the status of this ext work flow
	 */
	public int getStatus();

	/**
	 * Sets the status of this ext work flow.
	 *
	 * @param status the status of this ext work flow
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this ext work flow.
	 *
	 * @return the status by user ID of this ext work flow
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this ext work flow.
	 *
	 * @param statusByUserId the status by user ID of this ext work flow
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this ext work flow.
	 *
	 * @return the status by user uuid of this ext work flow
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this ext work flow.
	 *
	 * @param statusByUserUuid the status by user uuid of this ext work flow
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this ext work flow.
	 *
	 * @return the status by user name of this ext work flow
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this ext work flow.
	 *
	 * @param statusByUserName the status by user name of this ext work flow
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this ext work flow.
	 *
	 * @return the status date of this ext work flow
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this ext work flow.
	 *
	 * @param statusDate the status date of this ext work flow
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * @deprecated Renamed to {@link #isApproved()}
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this ext work flow is approved.
	 *
	 * @return <code>true</code> if this ext work flow is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this ext work flow is a draft.
	 *
	 * @return <code>true</code> if this ext work flow is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this ext work flow is expired.
	 *
	 * @return <code>true</code> if this ext work flow is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this ext work flow is pending.
	 *
	 * @return <code>true</code> if this ext work flow is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

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

	public int compareTo(ExtWorkFlow extWorkFlow);

	public int hashCode();

	public CacheModel<ExtWorkFlow> toCacheModel();

	public ExtWorkFlow toEscapedModel();

	public String toString();

	public String toXmlString();
}