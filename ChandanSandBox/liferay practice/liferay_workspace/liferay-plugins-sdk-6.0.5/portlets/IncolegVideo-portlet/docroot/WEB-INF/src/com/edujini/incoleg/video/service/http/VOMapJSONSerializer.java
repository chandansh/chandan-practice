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

import com.edujini.incoleg.video.model.VOMap;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author    Edujini
 * @generated
 */
public class VOMapJSONSerializer {
	public static JSONObject toJSONObject(VOMap model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("videoId", model.getVideoId());
		jsonObj.put("orgId", model.getOrgId());
		jsonObj.put("StoreType", model.getStoreType());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.edujini.incoleg.video.model.VOMap[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (VOMap model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.edujini.incoleg.video.model.VOMap[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (VOMap[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.edujini.incoleg.video.model.VOMap> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (VOMap model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}