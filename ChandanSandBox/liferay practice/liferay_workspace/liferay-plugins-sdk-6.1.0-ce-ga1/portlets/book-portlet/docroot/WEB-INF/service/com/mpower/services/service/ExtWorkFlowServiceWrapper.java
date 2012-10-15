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

package com.mpower.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExtWorkFlowService}.
 * </p>
 *
 * @author    Meenu
 * @see       ExtWorkFlowService
 * @generated
 */
public class ExtWorkFlowServiceWrapper implements ExtWorkFlowService,
	ServiceWrapper<ExtWorkFlowService> {
	public ExtWorkFlowServiceWrapper(ExtWorkFlowService extWorkFlowService) {
		_extWorkFlowService = extWorkFlowService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ExtWorkFlowService getWrappedExtWorkFlowService() {
		return _extWorkFlowService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedExtWorkFlowService(
		ExtWorkFlowService extWorkFlowService) {
		_extWorkFlowService = extWorkFlowService;
	}

	public ExtWorkFlowService getWrappedService() {
		return _extWorkFlowService;
	}

	public void setWrappedService(ExtWorkFlowService extWorkFlowService) {
		_extWorkFlowService = extWorkFlowService;
	}

	private ExtWorkFlowService _extWorkFlowService;
}