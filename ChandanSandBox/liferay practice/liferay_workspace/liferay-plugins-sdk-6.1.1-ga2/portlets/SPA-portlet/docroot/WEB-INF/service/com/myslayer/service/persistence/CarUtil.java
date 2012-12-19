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

package com.myslayer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.myslayer.model.Car;

import java.util.List;

/**
 * The persistence utility for the car service. This utility wraps {@link CarPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chandan
 * @see CarPersistence
 * @see CarPersistenceImpl
 * @generated
 */
public class CarUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Car car) {
		getPersistence().clearCache(car);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Car update(Car car, boolean merge) throws SystemException {
		return getPersistence().update(car, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Car update(Car car, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(car, merge, serviceContext);
	}

	/**
	* Caches the car in the entity cache if it is enabled.
	*
	* @param car the car
	*/
	public static void cacheResult(com.myslayer.model.Car car) {
		getPersistence().cacheResult(car);
	}

	/**
	* Caches the cars in the entity cache if it is enabled.
	*
	* @param cars the cars
	*/
	public static void cacheResult(java.util.List<com.myslayer.model.Car> cars) {
		getPersistence().cacheResult(cars);
	}

	/**
	* Creates a new car with the primary key. Does not add the car to the database.
	*
	* @param carId the primary key for the new car
	* @return the new car
	*/
	public static com.myslayer.model.Car create(long carId) {
		return getPersistence().create(carId);
	}

	/**
	* Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param carId the primary key of the car
	* @return the car that was removed
	* @throws com.myslayer.NoSuchCarException if a car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car remove(long carId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.myslayer.NoSuchCarException {
		return getPersistence().remove(carId);
	}

	public static com.myslayer.model.Car updateImpl(
		com.myslayer.model.Car car, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(car, merge);
	}

	/**
	* Returns the car with the primary key or throws a {@link com.myslayer.NoSuchCarException} if it could not be found.
	*
	* @param carId the primary key of the car
	* @return the car
	* @throws com.myslayer.NoSuchCarException if a car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car findByPrimaryKey(long carId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.myslayer.NoSuchCarException {
		return getPersistence().findByPrimaryKey(carId);
	}

	/**
	* Returns the car with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param carId the primary key of the car
	* @return the car, or <code>null</code> if a car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.myslayer.model.Car fetchByPrimaryKey(long carId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(carId);
	}

	/**
	* Returns all the cars.
	*
	* @return the cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.myslayer.model.Car> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.myslayer.model.Car> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cars
	* @param end the upper bound of the range of cars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.myslayer.model.Car> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cars from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cars.
	*
	* @return the number of cars
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CarPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CarPersistence)PortletBeanLocatorUtil.locate(com.myslayer.service.ClpSerializer.getServletContextName(),
					CarPersistence.class.getName());

			ReferenceRegistry.registerReference(CarUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CarPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CarUtil.class, "_persistence");
	}

	private static CarPersistence _persistence;
}