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
 * The utility for the car local service. This utility wraps {@link com.myslayer.service.impl.CarLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chandan
 * @see CarLocalService
 * @see com.myslayer.service.base.CarLocalServiceBaseImpl
 * @see com.myslayer.service.impl.CarLocalServiceImpl
 * @generated
 */
public class CarLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.myslayer.service.impl.CarLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the car to the database. Also notifies the appropriate model listeners.
	*
	* @param car the car
	* @return the car that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car addCar(com.myslayer.model.Car car)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCar(car);
	}

	/**
	* Creates a new car with the primary key. Does not add the car to the database.
	*
	* @param carId the primary key for the new car
	* @return the new car
	*/
	public static com.myslayer.model.Car createCar(long carId) {
		return getService().createCar(carId);
	}

	/**
	* Deletes the car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param carId the primary key of the car
	* @throws PortalException if a car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCar(long carId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCar(carId);
	}

	/**
	* Deletes the car from the database. Also notifies the appropriate model listeners.
	*
	* @param car the car
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCar(com.myslayer.model.Car car)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCar(car);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.myslayer.model.Car fetchCar(long carId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCar(carId);
	}

	/**
	* Returns the car with the primary key.
	*
	* @param carId the primary key of the car
	* @return the car
	* @throws PortalException if a car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car getCar(long carId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCar(carId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cars
	* @param end the upper bound of the range of cars (not inclusive)
	* @return the range of cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.myslayer.model.Car> getCars(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCars(start, end);
	}

	/**
	* Returns the number of cars.
	*
	* @return the number of cars
	* @throws SystemException if a system exception occurred
	*/
	public static int getCarsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCarsCount();
	}

	/**
	* Updates the car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param car the car
	* @return the car that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car updateCar(com.myslayer.model.Car car)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCar(car);
	}

	/**
	* Updates the car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param car the car
	* @param merge whether to merge the car with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the car that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car updateCar(com.myslayer.model.Car car,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCar(car, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static CarLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CarLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CarLocalService.class.getName(), portletClassLoader);

			_service = new CarLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CarLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CarLocalService.class);
		}

		return _service;
	}

	public void setService(CarLocalService service) {
		MethodCache.remove(CarLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CarLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CarLocalService.class);
	}

	private static CarLocalService _service;
}