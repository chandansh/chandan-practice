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

package com.library.slayer.service.persistence;

import com.library.slayer.model.MemberAddress;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the member address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see MemberAddressPersistenceImpl
 * @see MemberAddressUtil
 * @generated
 */
public interface MemberAddressPersistence extends BasePersistence<MemberAddress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberAddressUtil} to access the member address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the member address in the entity cache if it is enabled.
	*
	* @param memberAddress the member address
	*/
	public void cacheResult(
		com.library.slayer.model.MemberAddress memberAddress);

	/**
	* Caches the member addresses in the entity cache if it is enabled.
	*
	* @param memberAddresses the member addresses
	*/
	public void cacheResult(
		java.util.List<com.library.slayer.model.MemberAddress> memberAddresses);

	/**
	* Creates a new member address with the primary key. Does not add the member address to the database.
	*
	* @param userId the primary key for the new member address
	* @return the new member address
	*/
	public com.library.slayer.model.MemberAddress create(long userId);

	/**
	* Removes the member address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the member address
	* @return the member address that was removed
	* @throws com.library.slayer.NoSuchMemberAddressException if a member address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.MemberAddress remove(long userId)
		throws com.library.slayer.NoSuchMemberAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.library.slayer.model.MemberAddress updateImpl(
		com.library.slayer.model.MemberAddress memberAddress, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member address with the primary key or throws a {@link com.library.slayer.NoSuchMemberAddressException} if it could not be found.
	*
	* @param userId the primary key of the member address
	* @return the member address
	* @throws com.library.slayer.NoSuchMemberAddressException if a member address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.MemberAddress findByPrimaryKey(long userId)
		throws com.library.slayer.NoSuchMemberAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the member address
	* @return the member address, or <code>null</code> if a member address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.MemberAddress fetchByPrimaryKey(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the member addresses.
	*
	* @return the member addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.MemberAddress> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.library.slayer.model.MemberAddress> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the member addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of member addresses
	* @param end the upper bound of the range of member addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of member addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.MemberAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the member addresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of member addresses.
	*
	* @return the number of member addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}