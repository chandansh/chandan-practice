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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mpower.services.service.http.ExtWorkFlowServiceSoap}.
 *
 * @author    Meenu
 * @see       com.mpower.services.service.http.ExtWorkFlowServiceSoap
 * @generated
 */
public class ExtWorkFlowSoap implements Serializable {
	public static ExtWorkFlowSoap toSoapModel(ExtWorkFlow model) {
		ExtWorkFlowSoap soapModel = new ExtWorkFlowSoap();

		soapModel.setExtWorkflowId(model.getExtWorkflowId());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setParentResourcePrimKey(model.getParentResourcePrimKey());
		soapModel.setVersion(model.getVersion());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setDescription(model.getDescription());
		soapModel.setPriority(model.getPriority());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static ExtWorkFlowSoap[] toSoapModels(ExtWorkFlow[] models) {
		ExtWorkFlowSoap[] soapModels = new ExtWorkFlowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExtWorkFlowSoap[][] toSoapModels(ExtWorkFlow[][] models) {
		ExtWorkFlowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExtWorkFlowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExtWorkFlowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExtWorkFlowSoap[] toSoapModels(List<ExtWorkFlow> models) {
		List<ExtWorkFlowSoap> soapModels = new ArrayList<ExtWorkFlowSoap>(models.size());

		for (ExtWorkFlow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExtWorkFlowSoap[soapModels.size()]);
	}

	public ExtWorkFlowSoap() {
	}

	public long getPrimaryKey() {
		return _extWorkflowId;
	}

	public void setPrimaryKey(long pk) {
		setExtWorkflowId(pk);
	}

	public long getExtWorkflowId() {
		return _extWorkflowId;
	}

	public void setExtWorkflowId(long extWorkflowId) {
		_extWorkflowId = extWorkflowId;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getParentResourcePrimKey() {
		return _parentResourcePrimKey;
	}

	public void setParentResourcePrimKey(long parentResourcePrimKey) {
		_parentResourcePrimKey = parentResourcePrimKey;
	}

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _extWorkflowId;
	private long _resourcePrimKey;
	private long _classNameId;
	private long _classPK;
	private long _parentResourcePrimKey;
	private int _version;
	private String _title;
	private String _content;
	private String _description;
	private int _priority;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}