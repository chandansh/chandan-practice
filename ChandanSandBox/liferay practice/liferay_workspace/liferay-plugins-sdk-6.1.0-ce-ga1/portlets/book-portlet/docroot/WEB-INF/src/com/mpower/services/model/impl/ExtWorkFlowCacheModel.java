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

package com.mpower.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.mpower.services.model.ExtWorkFlow;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ExtWorkFlow in entity cache.
 *
 * @author Meenu
 * @see ExtWorkFlow
 * @generated
 */
public class ExtWorkFlowCacheModel implements CacheModel<ExtWorkFlow>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{extWorkflowId=");
		sb.append(extWorkflowId);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", parentResourcePrimKey=");
		sb.append(parentResourcePrimKey);
		sb.append(", version=");
		sb.append(version);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", description=");
		sb.append(description);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public ExtWorkFlow toEntityModel() {
		ExtWorkFlowImpl extWorkFlowImpl = new ExtWorkFlowImpl();

		extWorkFlowImpl.setExtWorkflowId(extWorkflowId);
		extWorkFlowImpl.setResourcePrimKey(resourcePrimKey);
		extWorkFlowImpl.setClassNameId(classNameId);
		extWorkFlowImpl.setClassPK(classPK);
		extWorkFlowImpl.setParentResourcePrimKey(parentResourcePrimKey);
		extWorkFlowImpl.setVersion(version);

		if (title == null) {
			extWorkFlowImpl.setTitle(StringPool.BLANK);
		}
		else {
			extWorkFlowImpl.setTitle(title);
		}

		if (content == null) {
			extWorkFlowImpl.setContent(StringPool.BLANK);
		}
		else {
			extWorkFlowImpl.setContent(content);
		}

		if (description == null) {
			extWorkFlowImpl.setDescription(StringPool.BLANK);
		}
		else {
			extWorkFlowImpl.setDescription(description);
		}

		extWorkFlowImpl.setPriority(priority);
		extWorkFlowImpl.setStatus(status);
		extWorkFlowImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			extWorkFlowImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			extWorkFlowImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			extWorkFlowImpl.setStatusDate(null);
		}
		else {
			extWorkFlowImpl.setStatusDate(new Date(statusDate));
		}

		extWorkFlowImpl.resetOriginalValues();

		return extWorkFlowImpl;
	}

	public long extWorkflowId;
	public long resourcePrimKey;
	public long classNameId;
	public long classPK;
	public long parentResourcePrimKey;
	public int version;
	public String title;
	public String content;
	public String description;
	public int priority;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}