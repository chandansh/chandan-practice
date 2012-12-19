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

package com.myslayer.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.myslayer.service.CarLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Chandan
 */
public class CarClp extends BaseModelImpl<Car> implements Car {
	public CarClp() {
	}

	public Class<?> getModelClass() {
		return Car.class;
	}

	public String getModelClassName() {
		return Car.class.getName();
	}

	public long getPrimaryKey() {
		return _carId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCarId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_carId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getCarId() {
		return _carId;
	}

	public void setCarId(long carId) {
		_carId = carId;
	}

	public String getBrand() {
		return _brand;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CarLocalServiceUtil.addCar(this);
		}
		else {
			CarLocalServiceUtil.updateCar(this);
		}
	}

	@Override
	public Car toEscapedModel() {
		return (Car)Proxy.newProxyInstance(Car.class.getClassLoader(),
			new Class[] { Car.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CarClp clone = new CarClp();

		clone.setCarId(getCarId());
		clone.setBrand(getBrand());
		clone.setColor(getColor());

		return clone;
	}

	public int compareTo(Car car) {
		long primaryKey = car.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CarClp car = null;

		try {
			car = (CarClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = car.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{carId=");
		sb.append(getCarId());
		sb.append(", brand=");
		sb.append(getBrand());
		sb.append(", color=");
		sb.append(getColor());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.myslayer.model.Car");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>carId</column-name><column-value><![CDATA[");
		sb.append(getCarId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brand</column-name><column-value><![CDATA[");
		sb.append(getBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _carId;
	private String _brand;
	private String _color;
}