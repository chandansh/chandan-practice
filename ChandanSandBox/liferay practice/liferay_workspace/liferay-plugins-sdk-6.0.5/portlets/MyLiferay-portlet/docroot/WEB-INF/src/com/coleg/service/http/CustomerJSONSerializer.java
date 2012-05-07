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

package com.coleg.service.http;

import com.coleg.model.Customer;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author    supriya
 * @generated
 */
public class CustomerJSONSerializer {
	public static JSONObject toJSONObject(Customer model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("id", model.getId());
		jsonObj.put("name", model.getName());
		jsonObj.put("company", model.getCompany());
		jsonObj.put("address", model.getAddress());

		return jsonObj;
	}

	public static JSONArray toJSONArray(com.coleg.model.Customer[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Customer model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(com.coleg.model.Customer[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Customer[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(List<com.coleg.model.Customer> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Customer model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}