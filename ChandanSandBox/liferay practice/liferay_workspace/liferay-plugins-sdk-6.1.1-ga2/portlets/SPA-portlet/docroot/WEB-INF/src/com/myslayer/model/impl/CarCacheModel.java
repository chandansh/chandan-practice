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

package com.myslayer.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.myslayer.model.Car;

import java.io.Serializable;

/**
 * The cache model class for representing Car in entity cache.
 *
 * @author Chandan
 * @see Car
 * @generated
 */
public class CarCacheModel implements CacheModel<Car>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{carId=");
		sb.append(carId);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", color=");
		sb.append(color);
		sb.append("}");

		return sb.toString();
	}

	public Car toEntityModel() {
		CarImpl carImpl = new CarImpl();

		carImpl.setCarId(carId);

		if (brand == null) {
			carImpl.setBrand(StringPool.BLANK);
		}
		else {
			carImpl.setBrand(brand);
		}

		if (color == null) {
			carImpl.setColor(StringPool.BLANK);
		}
		else {
			carImpl.setColor(color);
		}

		carImpl.resetOriginalValues();

		return carImpl;
	}

	public long carId;
	public String brand;
	public String color;
}