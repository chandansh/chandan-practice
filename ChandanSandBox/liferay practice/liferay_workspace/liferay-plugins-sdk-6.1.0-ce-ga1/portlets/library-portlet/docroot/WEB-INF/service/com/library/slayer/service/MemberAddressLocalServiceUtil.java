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

package com.library.slayer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the member address local service. This utility wraps {@link com.library.slayer.service.impl.MemberAddressLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ahmed Hasan
 * @see MemberAddressLocalService
 * @see com.library.slayer.service.base.MemberAddressLocalServiceBaseImpl
 * @see com.library.slayer.service.impl.MemberAddressLocalServiceImpl
 * @generated
 */
public class MemberAddressLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.library.slayer.service.impl.MemberAddressLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the member address to the database. Also notifies the appropriate model listeners.
	*
	* @param memberAddress the member address
	* @return the member address that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.MemberAddress addMemberAddress(
		com.library.slayer.model.MemberAddress memberAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMemberAddress(memberAddress);
	}

	/**
	* Creates a new member address with the primary key. Does not add the member address to the database.
	*
	* @param userId the primary key for the new member address
	* @return the new member address
	*/
	public static com.library.slayer.model.MemberAddress createMemberAddress(
		long userId) {
		return getService().createMemberAddress(userId);
	}

	/**
	* Deletes the member address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the member address
	* @throws PortalException if a member address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMemberAddress(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMemberAddress(userId);
	}

	/**
	* Deletes the member address from the database. Also notifies the appropriate model listeners.
	*
	* @param memberAddress the member address
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMemberAddress(
		com.library.slayer.model.MemberAddress memberAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMemberAddress(memberAddress);
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

	public static com.library.slayer.model.MemberAddress fetchMemberAddress(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMemberAddress(userId);
	}

	/**
	* Returns the member address with the primary key.
	*
	* @param userId the primary key of the member address
	* @return the member address
	* @throws PortalException if a member address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.MemberAddress getMemberAddress(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberAddress(userId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the member addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of member addresses
	* @param end the upper bound of the range of member addresses (not inclusive)
	* @return the range of member addresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.MemberAddress> getMemberAddresses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberAddresses(start, end);
	}

	/**
	* Returns the number of member addresses.
	*
	* @return the number of member addresses
	* @throws SystemException if a system exception occurred
	*/
	public static int getMemberAddressesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberAddressesCount();
	}

	/**
	* Updates the member address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param memberAddress the member address
	* @return the member address that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.MemberAddress updateMemberAddress(
		com.library.slayer.model.MemberAddress memberAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMemberAddress(memberAddress);
	}

	/**
	* Updates the member address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param memberAddress the member address
	* @param merge whether to merge the member address with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the member address that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.MemberAddress updateMemberAddress(
		com.library.slayer.model.MemberAddress memberAddress, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMemberAddress(memberAddress, merge);
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

	public static MemberAddressLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MemberAddressLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					MemberAddressLocalService.class.getName(),
					portletClassLoader);

			_service = new MemberAddressLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(MemberAddressLocalServiceUtil.class,
				"_service");
			MethodCache.remove(MemberAddressLocalService.class);
		}

		return _service;
	}

	public void setService(MemberAddressLocalService service) {
		MethodCache.remove(MemberAddressLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(MemberAddressLocalServiceUtil.class,
			"_service");
		MethodCache.remove(MemberAddressLocalService.class);
	}

	private static MemberAddressLocalService _service;
}