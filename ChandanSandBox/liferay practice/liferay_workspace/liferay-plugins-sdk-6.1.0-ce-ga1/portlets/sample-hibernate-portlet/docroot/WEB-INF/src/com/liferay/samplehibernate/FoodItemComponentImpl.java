/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.samplehibernate;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.samplehibernate.model.FoodItem;
import com.liferay.samplehibernate.util.FoodItemUtil;
import com.liferay.util.xml.BeanToXMLUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Charles May
 */
public class FoodItemComponentImpl {

	public String process(HttpServletRequest req) {
		String result = null;

		try {
			String cmd = ParamUtil.getString(req, "cmd");

			if (cmd.equals("getFoodItemXml")) {
				long foodItemId = ParamUtil.getLong(req, "foodItemId", 0);

				result = getFoodItemXml(foodItemId);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		if (Validator.isNull(result)) {
			result = "<result />";
		}

		return result;
	}

	public String getFoodItemXml(long foodItemId) throws Exception {
		List foodItems = null;

		if (foodItemId > 0) {
			FoodItem foodItem = FoodItemUtil.getFoodItem(foodItemId);

			if (foodItem != null) {
				foodItems = new ArrayList();

				foodItems.add(foodItem);
			}
		}
		else {
			foodItems = FoodItemUtil.getFoodItems();
		}

		return getXml(foodItems);
	}

	public String getXml(List list) {
		Document doc = SAXReaderUtil.createDocument();

		Element root = doc.addElement("result");

		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			Object obj = itr.next();

			BeanToXMLUtil.addBean(obj, root);
		}

		return doc.asXML();
	}

	private static Log _log = LogFactoryUtil.getLog(
		FoodItemComponentImpl.class);

}