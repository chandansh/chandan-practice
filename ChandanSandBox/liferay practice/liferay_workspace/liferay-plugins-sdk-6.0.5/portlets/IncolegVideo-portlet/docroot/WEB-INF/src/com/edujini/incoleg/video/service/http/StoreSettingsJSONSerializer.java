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

package com.edujini.incoleg.video.service.http;

import com.edujini.incoleg.video.model.StoreSettings;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author    Edujini
 * @generated
 */
public class StoreSettingsJSONSerializer {
	public static JSONObject toJSONObject(StoreSettings model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("storeId", model.getStoreId());
		jsonObj.put("inBId", model.getInBId());
		jsonObj.put("prBId", model.getPrBId());
		jsonObj.put("outBId", model.getOutBId());
		jsonObj.put("accessKId", model.getAccessKId());
		jsonObj.put("secretAKey", model.getSecretAKey());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.edujini.incoleg.video.model.StoreSettings[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (StoreSettings model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.edujini.incoleg.video.model.StoreSettings[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (StoreSettings[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.edujini.incoleg.video.model.StoreSettings> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (StoreSettings model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}