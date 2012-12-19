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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the car remote service. This utility wraps {@link com.myslayer.service.impl.CarServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Chandan
 * @see CarService
 * @see com.myslayer.service.base.CarServiceBaseImpl
 * @see com.myslayer.service.impl.CarServiceImpl
 * @generated
 */
public class CarServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.myslayer.service.impl.CarServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.myslayer.model.Car insertCar(long carId,
		java.lang.String brand, java.lang.String color)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().insertCar(carId, brand, color);
	}

	public static com.myslayer.model.Car updateCar(long carId,
		java.lang.String brand, java.lang.String color)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCar(carId, brand, color);
	}

	public static void deleteCar(long carId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCar(carId);
	}

	public static com.myslayer.model.Car[] getAllCars()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCars();
	}

	public static void clearService() {
		_service = null;
	}

	public static CarService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CarService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CarService.class.getName(), portletClassLoader);

			_service = new CarServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CarServiceUtil.class, "_service");
			MethodCache.remove(CarService.class);
		}

		return _service;
	}

	public void setService(CarService service) {
		MethodCache.remove(CarService.class);

		_service = service;

		ReferenceRegistry.registerReference(CarServiceUtil.class, "_service");
		MethodCache.remove(CarService.class);
	}

	private static CarService _service;
}