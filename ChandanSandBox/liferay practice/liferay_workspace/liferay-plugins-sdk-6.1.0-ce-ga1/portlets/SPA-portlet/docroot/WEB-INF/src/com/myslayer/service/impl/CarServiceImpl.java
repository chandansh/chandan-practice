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

package com.myslayer.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.myslayer.model.Car;
import com.myslayer.service.CarLocalServiceUtil;
import com.myslayer.service.base.CarServiceBaseImpl;

/**
 * The implementation of the car remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.myslayer.service.CarService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Chandan
 * @see com.myslayer.service.base.CarServiceBaseImpl
 * @see com.myslayer.service.CarServiceUtil
 */
public class CarServiceImpl extends CarServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.myslayer.service.CarServiceUtil} to access the car remote service.
	 */

	public Car insertCar(long carId, String brand, String color)
			throws SystemException {
		Car car = carLocalService.createCar(carId);
		car.setBrand(brand);
		car.setColor(color);
		System.out.println("car added " + car);
		return carLocalService.addCar(car);
	}

	public Car updateCar(long carId, String brand, String color)
			throws SystemException {
		Car car = null;
		try {
			car = carLocalService.getCar(carId);
			car.setBrand(brand);
			car.setColor(color);
			car = carLocalService.updateCar(car);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return car;
	}

	public void deleteCar(long carId) throws PortalException, SystemException {
		carLocalService.deleteCar(carId);
	}

	public Car[] getAllCars() throws SystemException {
		List<Car> carList = carLocalService.getCars(0, -1);
		Car[] cars = new Car[carList.size()];
		int i=0;
		for(Car car: carList){
			cars[i] = car;
			//System.out.println(car);
			i++;
		}
		return cars;
	}
}