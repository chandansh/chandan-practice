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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Car service. Represents a row in the &quot;myslayer_Car&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.myslayer.model.impl.CarModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.myslayer.model.impl.CarImpl}.
 * </p>
 *
 * @author Chandan
 * @see Car
 * @see com.myslayer.model.impl.CarImpl
 * @see com.myslayer.model.impl.CarModelImpl
 * @generated
 */
public interface CarModel extends BaseModel<Car> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a car model instance should use the {@link Car} interface instead.
	 */

	/**
	 * Returns the primary key of this car.
	 *
	 * @return the primary key of this car
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this car.
	 *
	 * @param primaryKey the primary key of this car
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the car ID of this car.
	 *
	 * @return the car ID of this car
	 */
	public long getCarId();

	/**
	 * Sets the car ID of this car.
	 *
	 * @param carId the car ID of this car
	 */
	public void setCarId(long carId);

	/**
	 * Returns the brand of this car.
	 *
	 * @return the brand of this car
	 */
	@AutoEscape
	public String getBrand();

	/**
	 * Sets the brand of this car.
	 *
	 * @param brand the brand of this car
	 */
	public void setBrand(String brand);

	/**
	 * Returns the color of this car.
	 *
	 * @return the color of this car
	 */
	@AutoEscape
	public String getColor();

	/**
	 * Sets the color of this car.
	 *
	 * @param color the color of this car
	 */
	public void setColor(String color);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Car car);

	public int hashCode();

	public CacheModel<Car> toCacheModel();

	public Car toEscapedModel();

	public String toString();

	public String toXmlString();
}