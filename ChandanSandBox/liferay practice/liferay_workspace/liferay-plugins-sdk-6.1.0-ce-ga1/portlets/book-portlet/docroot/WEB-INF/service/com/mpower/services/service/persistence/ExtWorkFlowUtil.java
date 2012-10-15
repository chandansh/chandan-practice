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

package com.mpower.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.mpower.services.model.ExtWorkFlow;

import java.util.List;

/**
 * The persistence utility for the ext work flow service. This utility wraps {@link ExtWorkFlowPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Meenu
 * @see ExtWorkFlowPersistence
 * @see ExtWorkFlowPersistenceImpl
 * @generated
 */
public class ExtWorkFlowUtil {
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
	public static void clearCache(ExtWorkFlow extWorkFlow) {
		getPersistence().clearCache(extWorkFlow);
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
	public static List<ExtWorkFlow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExtWorkFlow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExtWorkFlow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ExtWorkFlow update(ExtWorkFlow extWorkFlow, boolean merge)
		throws SystemException {
		return getPersistence().update(extWorkFlow, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ExtWorkFlow update(ExtWorkFlow extWorkFlow, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(extWorkFlow, merge, serviceContext);
	}

	/**
	* Caches the ext work flow in the entity cache if it is enabled.
	*
	* @param extWorkFlow the ext work flow
	*/
	public static void cacheResult(
		com.mpower.services.model.ExtWorkFlow extWorkFlow) {
		getPersistence().cacheResult(extWorkFlow);
	}

	/**
	* Caches the ext work flows in the entity cache if it is enabled.
	*
	* @param extWorkFlows the ext work flows
	*/
	public static void cacheResult(
		java.util.List<com.mpower.services.model.ExtWorkFlow> extWorkFlows) {
		getPersistence().cacheResult(extWorkFlows);
	}

	/**
	* Creates a new ext work flow with the primary key. Does not add the ext work flow to the database.
	*
	* @param extWorkflowId the primary key for the new ext work flow
	* @return the new ext work flow
	*/
	public static com.mpower.services.model.ExtWorkFlow create(
		long extWorkflowId) {
		return getPersistence().create(extWorkflowId);
	}

	/**
	* Removes the ext work flow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow that was removed
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow remove(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		return getPersistence().remove(extWorkflowId);
	}

	public static com.mpower.services.model.ExtWorkFlow updateImpl(
		com.mpower.services.model.ExtWorkFlow extWorkFlow, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(extWorkFlow, merge);
	}

	/**
	* Returns the ext work flow with the primary key or throws a {@link com.mpower.services.NoSuchExtWorkFlowException} if it could not be found.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow findByPrimaryKey(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		return getPersistence().findByPrimaryKey(extWorkflowId);
	}

	/**
	* Returns the ext work flow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow, or <code>null</code> if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow fetchByPrimaryKey(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(extWorkflowId);
	}

	/**
	* Returns all the ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> findByR_S_ExtWorkflow(
		long resourcePrimKey, int status, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByR_S_ExtWorkflow(resourcePrimKey, status, classNameId,
			classPK);
	}

	/**
	* Returns a range of all the ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of ext work flows
	* @param end the upper bound of the range of ext work flows (not inclusive)
	* @return the range of matching ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> findByR_S_ExtWorkflow(
		long resourcePrimKey, int status, long classNameId, long classPK,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByR_S_ExtWorkflow(resourcePrimKey, status, classNameId,
			classPK, start, end);
	}

	/**
	* Returns an ordered range of all the ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of ext work flows
	* @param end the upper bound of the range of ext work flows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> findByR_S_ExtWorkflow(
		long resourcePrimKey, int status, long classNameId, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByR_S_ExtWorkflow(resourcePrimKey, status, classNameId,
			classPK, start, end, orderByComparator);
	}

	/**
	* Returns the first ext work flow in the ordered set where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ext work flow
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a matching ext work flow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow findByR_S_ExtWorkflow_First(
		long resourcePrimKey, int status, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		return getPersistence()
				   .findByR_S_ExtWorkflow_First(resourcePrimKey, status,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the last ext work flow in the ordered set where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ext work flow
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a matching ext work flow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow findByR_S_ExtWorkflow_Last(
		long resourcePrimKey, int status, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		return getPersistence()
				   .findByR_S_ExtWorkflow_Last(resourcePrimKey, status,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the ext work flows before and after the current ext work flow in the ordered set where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param extWorkflowId the primary key of the current ext work flow
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ext work flow
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow[] findByR_S_ExtWorkflow_PrevAndNext(
		long extWorkflowId, long resourcePrimKey, int status, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		return getPersistence()
				   .findByR_S_ExtWorkflow_PrevAndNext(extWorkflowId,
			resourcePrimKey, status, classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.mpower.services.NoSuchExtWorkFlowException} if it could not be found.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching ext work flow
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a matching ext work flow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow findByworkFlowDetails(
		long resourcePrimKey, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		return getPersistence()
				   .findByworkFlowDetails(resourcePrimKey, classNameId, classPK);
	}

	/**
	* Returns the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching ext work flow, or <code>null</code> if a matching ext work flow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow fetchByworkFlowDetails(
		long resourcePrimKey, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByworkFlowDetails(resourcePrimKey, classNameId, classPK);
	}

	/**
	* Returns the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ext work flow, or <code>null</code> if a matching ext work flow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow fetchByworkFlowDetails(
		long resourcePrimKey, long classNameId, long classPK,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByworkFlowDetails(resourcePrimKey, classNameId,
			classPK, retrieveFromCache);
	}

	/**
	* Returns all the ext work flows.
	*
	* @return the ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ext work flows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ext work flows
	* @param end the upper bound of the range of ext work flows (not inclusive)
	* @return the range of ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ext work flows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ext work flows
	* @param end the upper bound of the range of ext work flows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByR_S_ExtWorkflow(long resourcePrimKey,
		int status, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByR_S_ExtWorkflow(resourcePrimKey, status, classNameId,
			classPK);
	}

	/**
	* Removes the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByworkFlowDetails(long resourcePrimKey,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException {
		getPersistence()
			.removeByworkFlowDetails(resourcePrimKey, classNameId, classPK);
	}

	/**
	* Removes all the ext work flows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByR_S_ExtWorkflow(long resourcePrimKey, int status,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByR_S_ExtWorkflow(resourcePrimKey, status,
			classNameId, classPK);
	}

	/**
	* Returns the number of ext work flows where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByworkFlowDetails(long resourcePrimKey,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByworkFlowDetails(resourcePrimKey, classNameId, classPK);
	}

	/**
	* Returns the number of ext work flows.
	*
	* @return the number of ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExtWorkFlowPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExtWorkFlowPersistence)PortletBeanLocatorUtil.locate(com.mpower.services.service.ClpSerializer.getServletContextName(),
					ExtWorkFlowPersistence.class.getName());

			ReferenceRegistry.registerReference(ExtWorkFlowUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ExtWorkFlowPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ExtWorkFlowUtil.class,
			"_persistence");
	}

	private static ExtWorkFlowPersistence _persistence;
}