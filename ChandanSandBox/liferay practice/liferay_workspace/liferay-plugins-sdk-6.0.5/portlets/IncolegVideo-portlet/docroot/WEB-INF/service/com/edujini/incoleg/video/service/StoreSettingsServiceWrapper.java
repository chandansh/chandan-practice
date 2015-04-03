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

package com.edujini.incoleg.video.service;

/**
 * <p>
 * This class is a wrapper for {@link StoreSettingsService}.
 * </p>
 *
 * @author    Edujini
 * @see       StoreSettingsService
 * @generated
 */
public class StoreSettingsServiceWrapper implements StoreSettingsService {
	public StoreSettingsServiceWrapper(
		StoreSettingsService storeSettingsService) {
		_storeSettingsService = storeSettingsService;
	}

	public StoreSettingsService getWrappedStoreSettingsService() {
		return _storeSettingsService;
	}

	private StoreSettingsService _storeSettingsService;
}