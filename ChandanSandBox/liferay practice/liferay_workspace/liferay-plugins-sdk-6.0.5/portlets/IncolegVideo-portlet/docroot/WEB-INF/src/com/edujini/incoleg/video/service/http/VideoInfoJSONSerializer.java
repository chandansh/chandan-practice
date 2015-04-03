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

import com.edujini.incoleg.video.model.VideoInfo;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;

/**
 * @author    Edujini
 * @generated
 */
public class VideoInfoJSONSerializer {
	public static JSONObject toJSONObject(VideoInfo model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("videoId", model.getVideoId());
		jsonObj.put("fileName", model.getFileName());
		jsonObj.put("mappedFileName", model.getMappedFileName());
		jsonObj.put("fileType", model.getFileType());
		jsonObj.put("fileSize", model.getFileSize());
		jsonObj.put("fileDesc", model.getFileDesc());
		jsonObj.put("userEmail", model.getUserEmail());

		Date uploadTime = model.getUploadTime();

		String uploadTimeJSON = StringPool.BLANK;

		if (uploadTime != null) {
			uploadTimeJSON = String.valueOf(uploadTime.getTime());
		}

		jsonObj.put("uploadTime", uploadTimeJSON);
		jsonObj.put("vurl", model.getVurl());
		jsonObj.put("status", model.getStatus());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.edujini.incoleg.video.model.VideoInfo[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (VideoInfo model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.edujini.incoleg.video.model.VideoInfo[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (VideoInfo[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.edujini.incoleg.video.model.VideoInfo> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (VideoInfo model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}