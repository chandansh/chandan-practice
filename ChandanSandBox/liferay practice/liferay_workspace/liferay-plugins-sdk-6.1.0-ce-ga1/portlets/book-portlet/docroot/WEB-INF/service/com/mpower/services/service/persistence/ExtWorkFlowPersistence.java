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

import com.liferay.portal.service.persistence.BasePersistence;

import com.mpower.services.model.ExtWorkFlow;

/**
 * The persistence interface for the ext work flow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Meenu
 * @see ExtWorkFlowPersistenceImpl
 * @see ExtWorkFlowUtil
 * @generated
 */
public interface ExtWorkFlowPersistence extends BasePersistence<ExtWorkFlow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtWorkFlowUtil} to access the ext work flow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ext work flow in the entity cache if it is enabled.
	*
	* @param extWorkFlow the ext work flow
	*/
	public void cacheResult(com.mpower.services.model.ExtWorkFlow extWorkFlow);

	/**
	* Caches the ext work flows in the entity cache if it is enabled.
	*
	* @param extWorkFlows the ext work flows
	*/
	public void cacheResult(
		java.util.List<com.mpower.services.model.ExtWorkFlow> extWorkFlows);

	/**
	* Creates a new ext work flow with the primary key. Does not add the ext work flow to the database.
	*
	* @param extWorkflowId the primary key for the new ext work flow
	* @return the new ext work flow
	*/
	public com.mpower.services.model.ExtWorkFlow create(long extWorkflowId);

	/**
	* Removes the ext work flow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow that was removed
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.services.model.ExtWorkFlow remove(long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

	public com.mpower.services.model.ExtWorkFlow updateImpl(
		com.mpower.services.model.ExtWorkFlow extWorkFlow, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ext work flow with the primary key or throws a {@link com.mpower.services.NoSuchExtWorkFlowException} if it could not be found.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow
	* @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.services.model.ExtWorkFlow findByPrimaryKey(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

	/**
	* Returns the ext work flow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow, or <code>null</code> if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.services.model.ExtWorkFlow fetchByPrimaryKey(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.services.model.ExtWorkFlow> findByR_S_ExtWorkflow(
		long resourcePrimKey, int status, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.services.model.ExtWorkFlow> findByR_S_ExtWorkflow(
		long resourcePrimKey, int status, long classNameId, long classPK,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.services.model.ExtWorkFlow> findByR_S_ExtWorkflow(
		long resourcePrimKey, int status, long classNameId, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.mpower.services.model.ExtWorkFlow findByR_S_ExtWorkflow_First(
		long resourcePrimKey, int status, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

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
	public com.mpower.services.model.ExtWorkFlow findByR_S_ExtWorkflow_Last(
		long resourcePrimKey, int status, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

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
	public com.mpower.services.model.ExtWorkFlow[] findByR_S_ExtWorkflow_PrevAndNext(
		long extWorkflowId, long resourcePrimKey, int status, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

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
	public com.mpower.services.model.ExtWorkFlow findByworkFlowDetails(
		long resourcePrimKey, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

	/**
	* Returns the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching ext work flow, or <code>null</code> if a matching ext work flow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.services.model.ExtWorkFlow fetchByworkFlowDetails(
		long resourcePrimKey, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.mpower.services.model.ExtWorkFlow fetchByworkFlowDetails(
		long resourcePrimKey, long classNameId, long classPK,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ext work flows.
	*
	* @return the ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.services.model.ExtWorkFlow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.services.model.ExtWorkFlow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.services.model.ExtWorkFlow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_S_ExtWorkflow(long resourcePrimKey, int status,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByworkFlowDetails(long resourcePrimKey, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.services.NoSuchExtWorkFlowException;

	/**
	* Removes all the ext work flows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByR_S_ExtWorkflow(long resourcePrimKey, int status,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ext work flows where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public int countByworkFlowDetails(long resourcePrimKey, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ext work flows.
	*
	* @return the number of ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}