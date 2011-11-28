/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.coleg.service;

/**
 * <p>
 * This class is a wrapper for {@link EmpLocalService}.
 * </p>
 *
 * @author    chandan
 * @see       EmpLocalService
 * @generated
 */
public class EmpLocalServiceWrapper implements EmpLocalService {
	public EmpLocalServiceWrapper(EmpLocalService empLocalService) {
		_empLocalService = empLocalService;
	}

	/**
	* Adds the emp to the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp to add
	* @return the emp that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Emp addEmp(com.coleg.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.addEmp(emp);
	}

	/**
	* Creates a new emp with the primary key. Does not add the emp to the database.
	*
	* @param empId the primary key for the new emp
	* @return the new emp
	*/
	public com.coleg.model.Emp createEmp(java.lang.String empId) {
		return _empLocalService.createEmp(empId);
	}

	/**
	* Deletes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the emp to delete
	* @throws PortalException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEmp(java.lang.String empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_empLocalService.deleteEmp(empId);
	}

	/**
	* Deletes the emp from the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEmp(com.coleg.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		_empLocalService.deleteEmp(emp);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the emp with the primary key.
	*
	* @param empId the primary key of the emp to get
	* @return the emp
	* @throws PortalException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Emp getEmp(java.lang.String empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmp(empId);
	}

	/**
	* Gets a range of all the emps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of emps to return
	* @param end the upper bound of the range of emps to return (not inclusive)
	* @return the range of emps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.coleg.model.Emp> getEmps(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmps(start, end);
	}

	/**
	* Gets the number of emps.
	*
	* @return the number of emps
	* @throws SystemException if a system exception occurred
	*/
	public int getEmpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmpsCount();
	}

	/**
	* Updates the emp in the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp to update
	* @return the emp that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Emp updateEmp(com.coleg.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.updateEmp(emp);
	}

	/**
	* Updates the emp in the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp to update
	* @param merge whether to merge the emp with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the emp that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Emp updateEmp(com.coleg.model.Emp emp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.updateEmp(emp, merge);
	}

	public EmpLocalService getWrappedEmpLocalService() {
		return _empLocalService;
	}

	private EmpLocalService _empLocalService;
}