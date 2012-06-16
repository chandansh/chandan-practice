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

package com.liferay.samplehibernate.model;

/**
 * @author Brian Wing Shun Chan
 */
public class FoodItem {

	public long getFoodItemId() {
		return _foodItemId;
	}

	public void setFoodItemId(long foodItemId) {
		_foodItemId = foodItemId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getPoints() {
		return _points;
	}

	public void setPoints(int points) {
		_points = points;
	}

	private long _foodItemId;
	private String _name;
	private int _points;

}