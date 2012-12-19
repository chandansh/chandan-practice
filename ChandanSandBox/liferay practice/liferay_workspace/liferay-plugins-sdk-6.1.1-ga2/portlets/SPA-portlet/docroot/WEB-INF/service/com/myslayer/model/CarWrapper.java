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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Car}.
 * </p>
 *
 * @author    Chandan
 * @see       Car
 * @generated
 */
public class CarWrapper implements Car, ModelWrapper<Car> {
	public CarWrapper(Car car) {
		_car = car;
	}

	public Class<?> getModelClass() {
		return Car.class;
	}

	public String getModelClassName() {
		return Car.class.getName();
	}

	/**
	* Returns the primary key of this car.
	*
	* @return the primary key of this car
	*/
	public long getPrimaryKey() {
		return _car.getPrimaryKey();
	}

	/**
	* Sets the primary key of this car.
	*
	* @param primaryKey the primary key of this car
	*/
	public void setPrimaryKey(long primaryKey) {
		_car.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the car ID of this car.
	*
	* @return the car ID of this car
	*/
	public long getCarId() {
		return _car.getCarId();
	}

	/**
	* Sets the car ID of this car.
	*
	* @param carId the car ID of this car
	*/
	public void setCarId(long carId) {
		_car.setCarId(carId);
	}

	/**
	* Returns the brand of this car.
	*
	* @return the brand of this car
	*/
	public java.lang.String getBrand() {
		return _car.getBrand();
	}

	/**
	* Sets the brand of this car.
	*
	* @param brand the brand of this car
	*/
	public void setBrand(java.lang.String brand) {
		_car.setBrand(brand);
	}

	/**
	* Returns the color of this car.
	*
	* @return the color of this car
	*/
	public java.lang.String getColor() {
		return _car.getColor();
	}

	/**
	* Sets the color of this car.
	*
	* @param color the color of this car
	*/
	public void setColor(java.lang.String color) {
		_car.setColor(color);
	}

	public boolean isNew() {
		return _car.isNew();
	}

	public void setNew(boolean n) {
		_car.setNew(n);
	}

	public boolean isCachedModel() {
		return _car.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_car.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _car.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _car.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_car.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _car.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_car.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CarWrapper((Car)_car.clone());
	}

	public int compareTo(com.myslayer.model.Car car) {
		return _car.compareTo(car);
	}

	@Override
	public int hashCode() {
		return _car.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.myslayer.model.Car> toCacheModel() {
		return _car.toCacheModel();
	}

	public com.myslayer.model.Car toEscapedModel() {
		return new CarWrapper(_car.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _car.toString();
	}

	public java.lang.String toXmlString() {
		return _car.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_car.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Car getWrappedCar() {
		return _car;
	}

	public Car getWrappedModel() {
		return _car;
	}

	public void resetOriginalValues() {
		_car.resetOriginalValues();
	}

	private Car _car;
}