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

import com.library.slayer.NoSuchMemberAddressException;
import com.library.slayer.model.MemberAddress;
import com.library.slayer.model.impl.MemberAddressImpl;
import com.library.slayer.model.impl.MemberAddressModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the member address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see MemberAddressPersistence
 * @see MemberAddressUtil
 * @generated
 */
public class MemberAddressPersistenceImpl extends BasePersistenceImpl<MemberAddress>
	implements MemberAddressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MemberAddressUtil} to access the member address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MemberAddressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
			MemberAddressModelImpl.FINDER_CACHE_ENABLED,
			MemberAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
			MemberAddressModelImpl.FINDER_CACHE_ENABLED,
			MemberAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
			MemberAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the member address in the entity cache if it is enabled.
	 *
	 * @param memberAddress the member address
	 */
	public void cacheResult(MemberAddress memberAddress) {
		EntityCacheUtil.putResult(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
			MemberAddressImpl.class, memberAddress.getPrimaryKey(),
			memberAddress);

		memberAddress.resetOriginalValues();
	}

	/**
	 * Caches the member addresses in the entity cache if it is enabled.
	 *
	 * @param memberAddresses the member addresses
	 */
	public void cacheResult(List<MemberAddress> memberAddresses) {
		for (MemberAddress memberAddress : memberAddresses) {
			if (EntityCacheUtil.getResult(
						MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
						MemberAddressImpl.class, memberAddress.getPrimaryKey()) == null) {
				cacheResult(memberAddress);
			}
			else {
				memberAddress.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all member addresses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MemberAddressImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MemberAddressImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member address.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MemberAddress memberAddress) {
		EntityCacheUtil.removeResult(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
			MemberAddressImpl.class, memberAddress.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MemberAddress> memberAddresses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MemberAddress memberAddress : memberAddresses) {
			EntityCacheUtil.removeResult(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
				MemberAddressImpl.class, memberAddress.getPrimaryKey());
		}
	}

	/**
	 * Creates a new member address with the primary key. Does not add the member address to the database.
	 *
	 * @param userId the primary key for the new member address
	 * @return the new member address
	 */
	public MemberAddress create(long userId) {
		MemberAddress memberAddress = new MemberAddressImpl();

		memberAddress.setNew(true);
		memberAddress.setPrimaryKey(userId);

		return memberAddress;
	}

	/**
	 * Removes the member address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the member address
	 * @return the member address that was removed
	 * @throws com.library.slayer.NoSuchMemberAddressException if a member address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MemberAddress remove(long userId)
		throws NoSuchMemberAddressException, SystemException {
		return remove(Long.valueOf(userId));
	}

	/**
	 * Removes the member address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member address
	 * @return the member address that was removed
	 * @throws com.library.slayer.NoSuchMemberAddressException if a member address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberAddress remove(Serializable primaryKey)
		throws NoSuchMemberAddressException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MemberAddress memberAddress = (MemberAddress)session.get(MemberAddressImpl.class,
					primaryKey);

			if (memberAddress == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(memberAddress);
		}
		catch (NoSuchMemberAddressException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MemberAddress removeImpl(MemberAddress memberAddress)
		throws SystemException {
		memberAddress = toUnwrappedModel(memberAddress);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, memberAddress);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(memberAddress);

		return memberAddress;
	}

	@Override
	public MemberAddress updateImpl(
		com.library.slayer.model.MemberAddress memberAddress, boolean merge)
		throws SystemException {
		memberAddress = toUnwrappedModel(memberAddress);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, memberAddress, merge);

			memberAddress.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
			MemberAddressImpl.class, memberAddress.getPrimaryKey(),
			memberAddress);

		return memberAddress;
	}

	protected MemberAddress toUnwrappedModel(MemberAddress memberAddress) {
		if (memberAddress instanceof MemberAddressImpl) {
			return memberAddress;
		}

		MemberAddressImpl memberAddressImpl = new MemberAddressImpl();

		memberAddressImpl.setNew(memberAddress.isNew());
		memberAddressImpl.setPrimaryKey(memberAddress.getPrimaryKey());

		memberAddressImpl.setUserId(memberAddress.getUserId());
		memberAddressImpl.setFirstName(memberAddress.getFirstName());
		memberAddressImpl.setLastName(memberAddress.getLastName());
		memberAddressImpl.setStreetAddress1(memberAddress.getStreetAddress1());
		memberAddressImpl.setStreetAddress2(memberAddress.getStreetAddress2());
		memberAddressImpl.setCity(memberAddress.getCity());
		memberAddressImpl.setZip(memberAddress.getZip());
		memberAddressImpl.setEmailAddress(memberAddress.getEmailAddress());
		memberAddressImpl.setPhoneNumber(memberAddress.getPhoneNumber());
		memberAddressImpl.setMobileNumber(memberAddress.getMobileNumber());
		memberAddressImpl.setDateAdded(memberAddress.getDateAdded());

		return memberAddressImpl;
	}

	/**
	 * Returns the member address with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the member address
	 * @return the member address
	 * @throws com.liferay.portal.NoSuchModelException if a member address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the member address with the primary key or throws a {@link com.library.slayer.NoSuchMemberAddressException} if it could not be found.
	 *
	 * @param userId the primary key of the member address
	 * @return the member address
	 * @throws com.library.slayer.NoSuchMemberAddressException if a member address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MemberAddress findByPrimaryKey(long userId)
		throws NoSuchMemberAddressException, SystemException {
		MemberAddress memberAddress = fetchByPrimaryKey(userId);

		if (memberAddress == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userId);
			}

			throw new NoSuchMemberAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userId);
		}

		return memberAddress;
	}

	/**
	 * Returns the member address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member address
	 * @return the member address, or <code>null</code> if a member address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberAddress fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the member address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the member address
	 * @return the member address, or <code>null</code> if a member address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MemberAddress fetchByPrimaryKey(long userId)
		throws SystemException {
		MemberAddress memberAddress = (MemberAddress)EntityCacheUtil.getResult(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
				MemberAddressImpl.class, userId);

		if (memberAddress == _nullMemberAddress) {
			return null;
		}

		if (memberAddress == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				memberAddress = (MemberAddress)session.get(MemberAddressImpl.class,
						Long.valueOf(userId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (memberAddress != null) {
					cacheResult(memberAddress);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MemberAddressModelImpl.ENTITY_CACHE_ENABLED,
						MemberAddressImpl.class, userId, _nullMemberAddress);
				}

				closeSession(session);
			}
		}

		return memberAddress;
	}

	/**
	 * Returns all the member addresses.
	 *
	 * @return the member addresses
	 * @throws SystemException if a system exception occurred
	 */
	public List<MemberAddress> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<MemberAddress> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<MemberAddress> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MemberAddress> list = (List<MemberAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERADDRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERADDRESS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MemberAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MemberAddress>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the member addresses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MemberAddress memberAddress : findAll()) {
			remove(memberAddress);
		}
	}

	/**
	 * Returns the number of member addresses.
	 *
	 * @return the number of member addresses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MEMBERADDRESS);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the member address persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.library.slayer.model.MemberAddress")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MemberAddress>> listenersList = new ArrayList<ModelListener<MemberAddress>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MemberAddress>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MemberAddressImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LMSBookPersistence.class)
	protected LMSBookPersistence lmsBookPersistence;
	@BeanReference(type = LMSBookJoinPersistence.class)
	protected LMSBookJoinPersistence lmsBookJoinPersistence;
	@BeanReference(type = MemberAddressPersistence.class)
	protected MemberAddressPersistence memberAddressPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MEMBERADDRESS = "SELECT memberAddress FROM MemberAddress memberAddress";
	private static final String _SQL_COUNT_MEMBERADDRESS = "SELECT COUNT(memberAddress) FROM MemberAddress memberAddress";
	private static final String _ORDER_BY_ENTITY_ALIAS = "memberAddress.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MemberAddress exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MemberAddressPersistenceImpl.class);
	private static MemberAddress _nullMemberAddress = new MemberAddressImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MemberAddress> toCacheModel() {
				return _nullMemberAddressCacheModel;
			}
		};

	private static CacheModel<MemberAddress> _nullMemberAddressCacheModel = new CacheModel<MemberAddress>() {
			public MemberAddress toEntityModel() {
				return _nullMemberAddress;
			}
		};
}