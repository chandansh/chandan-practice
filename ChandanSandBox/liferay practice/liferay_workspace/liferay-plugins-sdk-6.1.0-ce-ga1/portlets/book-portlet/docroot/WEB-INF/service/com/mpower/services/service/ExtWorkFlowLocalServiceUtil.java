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

package com.mpower.services.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the ext work flow local service. This utility wraps {@link com.mpower.services.service.impl.ExtWorkFlowLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Meenu
 * @see ExtWorkFlowLocalService
 * @see com.mpower.services.service.base.ExtWorkFlowLocalServiceBaseImpl
 * @see com.mpower.services.service.impl.ExtWorkFlowLocalServiceImpl
 * @generated
 */
public class ExtWorkFlowLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.mpower.services.service.impl.ExtWorkFlowLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ext work flow to the database. Also notifies the appropriate model listeners.
	*
	* @param extWorkFlow the ext work flow
	* @return the ext work flow that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow addExtWorkFlow(
		com.mpower.services.model.ExtWorkFlow extWorkFlow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addExtWorkFlow(extWorkFlow);
	}

	/**
	* Creates a new ext work flow with the primary key. Does not add the ext work flow to the database.
	*
	* @param extWorkflowId the primary key for the new ext work flow
	* @return the new ext work flow
	*/
	public static com.mpower.services.model.ExtWorkFlow createExtWorkFlow(
		long extWorkflowId) {
		return getService().createExtWorkFlow(extWorkflowId);
	}

	/**
	* Deletes the ext work flow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @throws PortalException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteExtWorkFlow(long extWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteExtWorkFlow(extWorkflowId);
	}

	/**
	* Deletes the ext work flow from the database. Also notifies the appropriate model listeners.
	*
	* @param extWorkFlow the ext work flow
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteExtWorkFlow(
		com.mpower.services.model.ExtWorkFlow extWorkFlow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteExtWorkFlow(extWorkFlow);
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

	public static com.mpower.services.model.ExtWorkFlow fetchExtWorkFlow(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchExtWorkFlow(extWorkflowId);
	}

	/**
	* Returns the ext work flow with the primary key.
	*
	* @param extWorkflowId the primary key of the ext work flow
	* @return the ext work flow
	* @throws PortalException if a ext work flow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow getExtWorkFlow(
		long extWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getExtWorkFlow(extWorkflowId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.mpower.services.model.ExtWorkFlow> getExtWorkFlows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getExtWorkFlows(start, end);
	}

	/**
	* Returns the number of ext work flows.
	*
	* @return the number of ext work flows
	* @throws SystemException if a system exception occurred
	*/
	public static int getExtWorkFlowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getExtWorkFlowsCount();
	}

	/**
	* Updates the ext work flow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param extWorkFlow the ext work flow
	* @return the ext work flow that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow updateExtWorkFlow(
		com.mpower.services.model.ExtWorkFlow extWorkFlow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateExtWorkFlow(extWorkFlow);
	}

	/**
	* Updates the ext work flow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param extWorkFlow the ext work flow
	* @param merge whether to merge the ext work flow with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ext work flow that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.services.model.ExtWorkFlow updateExtWorkFlow(
		com.mpower.services.model.ExtWorkFlow extWorkFlow, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateExtWorkFlow(extWorkFlow, merge);
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

	public static ExtWorkFlowLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ExtWorkFlowLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ExtWorkFlowLocalService.class.getName(), portletClassLoader);

			_service = new ExtWorkFlowLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ExtWorkFlowLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ExtWorkFlowLocalService.class);
		}

		return _service;
	}

	public void setService(ExtWorkFlowLocalService service) {
		MethodCache.remove(ExtWorkFlowLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ExtWorkFlowLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ExtWorkFlowLocalService.class);
	}

	private static ExtWorkFlowLocalService _service;
}