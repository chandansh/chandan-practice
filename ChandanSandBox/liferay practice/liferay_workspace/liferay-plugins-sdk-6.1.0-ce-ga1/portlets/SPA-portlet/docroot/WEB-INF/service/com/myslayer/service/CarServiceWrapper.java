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

package com.myslayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CarService}.
 * </p>
 *
 * @author    Chandan
 * @see       CarService
 * @generated
 */
public class CarServiceWrapper implements CarService,
	ServiceWrapper<CarService> {
	public CarServiceWrapper(CarService carService) {
		_carService = carService;
	}

	public com.myslayer.model.Car insertCar(long carId, java.lang.String brand,
		java.lang.String color)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _carService.insertCar(carId, brand, color);
	}

	public com.myslayer.model.Car updateCar(long carId, java.lang.String brand,
		java.lang.String color)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _carService.updateCar(carId, brand, color);
	}

	public void deleteCar(long carId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_carService.deleteCar(carId);
	}

	public com.myslayer.model.Car[] getAllCars()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _carService.getAllCars();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CarService getWrappedCarService() {
		return _carService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCarService(CarService carService) {
		_carService = carService;
	}

	public CarService getWrappedService() {
		return _carService;
	}

	public void setWrappedService(CarService carService) {
		_carService = carService;
	}

	private CarService _carService;
}