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

package com.test.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the my student local service. This utility wraps {@link com.test.service.impl.MyStudentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chandan
 * @see MyStudentLocalService
 * @see com.test.service.base.MyStudentLocalServiceBaseImpl
 * @see com.test.service.impl.MyStudentLocalServiceImpl
 * @generated
 */
public class MyStudentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.test.service.impl.MyStudentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the my student to the database. Also notifies the appropriate model listeners.
	*
	* @param myStudent the my student
	* @return the my student that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.test.model.MyStudent addMyStudent(
		com.test.model.MyStudent myStudent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMyStudent(myStudent);
	}

	/**
	* Creates a new my student with the primary key. Does not add the my student to the database.
	*
	* @param id the primary key for the new my student
	* @return the new my student
	*/
	public static com.test.model.MyStudent createMyStudent(long id) {
		return getService().createMyStudent(id);
	}

	/**
	* Deletes the my student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my student
	* @throws PortalException if a my student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMyStudent(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyStudent(id);
	}

	/**
	* Deletes the my student from the database. Also notifies the appropriate model listeners.
	*
	* @param myStudent the my student
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMyStudent(com.test.model.MyStudent myStudent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyStudent(myStudent);
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

	public static com.test.model.MyStudent fetchMyStudent(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMyStudent(id);
	}

	/**
	* Returns the my student with the primary key.
	*
	* @param id the primary key of the my student
	* @return the my student
	* @throws PortalException if a my student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.test.model.MyStudent getMyStudent(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyStudent(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the my students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of my students
	* @param end the upper bound of the range of my students (not inclusive)
	* @return the range of my students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.test.model.MyStudent> getMyStudents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyStudents(start, end);
	}

	/**
	* Returns the number of my students.
	*
	* @return the number of my students
	* @throws SystemException if a system exception occurred
	*/
	public static int getMyStudentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyStudentsCount();
	}

	/**
	* Updates the my student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param myStudent the my student
	* @return the my student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.test.model.MyStudent updateMyStudent(
		com.test.model.MyStudent myStudent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMyStudent(myStudent);
	}

	/**
	* Updates the my student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param myStudent the my student
	* @param merge whether to merge the my student with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the my student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.test.model.MyStudent updateMyStudent(
		com.test.model.MyStudent myStudent, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMyStudent(myStudent, merge);
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

	public static MyStudentLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MyStudentLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					MyStudentLocalService.class.getName(), portletClassLoader);

			_service = new MyStudentLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(MyStudentLocalServiceUtil.class,
				"_service");
			MethodCache.remove(MyStudentLocalService.class);
		}

		return _service;
	}

	public void setService(MyStudentLocalService service) {
		MethodCache.remove(MyStudentLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(MyStudentLocalServiceUtil.class,
			"_service");
		MethodCache.remove(MyStudentLocalService.class);
	}

	private static MyStudentLocalService _service;
}