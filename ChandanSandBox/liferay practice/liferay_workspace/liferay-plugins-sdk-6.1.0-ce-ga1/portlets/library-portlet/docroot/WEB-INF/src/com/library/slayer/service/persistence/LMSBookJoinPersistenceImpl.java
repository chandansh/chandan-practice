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

import com.library.slayer.NoSuchBookJoinException;
import com.library.slayer.model.LMSBookJoin;
import com.library.slayer.model.impl.LMSBookJoinImpl;
import com.library.slayer.model.impl.LMSBookJoinModelImpl;

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
 * The persistence implementation for the l m s book join service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see LMSBookJoinPersistence
 * @see LMSBookJoinUtil
 * @generated
 */
public class LMSBookJoinPersistenceImpl extends BasePersistenceImpl<LMSBookJoin>
	implements LMSBookJoinPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSBookJoinUtil} to access the l m s book join persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSBookJoinImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookJoinModelImpl.FINDER_CACHE_ENABLED, LMSBookJoinImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookJoinModelImpl.FINDER_CACHE_ENABLED, LMSBookJoinImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookJoinModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the l m s book join in the entity cache if it is enabled.
	 *
	 * @param lmsBookJoin the l m s book join
	 */
	public void cacheResult(LMSBookJoin lmsBookJoin) {
		EntityCacheUtil.putResult(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookJoinImpl.class, lmsBookJoin.getPrimaryKey(), lmsBookJoin);

		lmsBookJoin.resetOriginalValues();
	}

	/**
	 * Caches the l m s book joins in the entity cache if it is enabled.
	 *
	 * @param lmsBookJoins the l m s book joins
	 */
	public void cacheResult(List<LMSBookJoin> lmsBookJoins) {
		for (LMSBookJoin lmsBookJoin : lmsBookJoins) {
			if (EntityCacheUtil.getResult(
						LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookJoinImpl.class, lmsBookJoin.getPrimaryKey()) == null) {
				cacheResult(lmsBookJoin);
			}
			else {
				lmsBookJoin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s book joins.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSBookJoinImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSBookJoinImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s book join.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSBookJoin lmsBookJoin) {
		EntityCacheUtil.removeResult(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookJoinImpl.class, lmsBookJoin.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LMSBookJoin> lmsBookJoins) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSBookJoin lmsBookJoin : lmsBookJoins) {
			EntityCacheUtil.removeResult(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookJoinImpl.class, lmsBookJoin.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l m s book join with the primary key. Does not add the l m s book join to the database.
	 *
	 * @param joinId the primary key for the new l m s book join
	 * @return the new l m s book join
	 */
	public LMSBookJoin create(long joinId) {
		LMSBookJoin lmsBookJoin = new LMSBookJoinImpl();

		lmsBookJoin.setNew(true);
		lmsBookJoin.setPrimaryKey(joinId);

		return lmsBookJoin;
	}

	/**
	 * Removes the l m s book join with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joinId the primary key of the l m s book join
	 * @return the l m s book join that was removed
	 * @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBookJoin remove(long joinId)
		throws NoSuchBookJoinException, SystemException {
		return remove(Long.valueOf(joinId));
	}

	/**
	 * Removes the l m s book join with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s book join
	 * @return the l m s book join that was removed
	 * @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBookJoin remove(Serializable primaryKey)
		throws NoSuchBookJoinException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSBookJoin lmsBookJoin = (LMSBookJoin)session.get(LMSBookJoinImpl.class,
					primaryKey);

			if (lmsBookJoin == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookJoinException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsBookJoin);
		}
		catch (NoSuchBookJoinException nsee) {
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
	protected LMSBookJoin removeImpl(LMSBookJoin lmsBookJoin)
		throws SystemException {
		lmsBookJoin = toUnwrappedModel(lmsBookJoin);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lmsBookJoin);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lmsBookJoin);

		return lmsBookJoin;
	}

	@Override
	public LMSBookJoin updateImpl(
		com.library.slayer.model.LMSBookJoin lmsBookJoin, boolean merge)
		throws SystemException {
		lmsBookJoin = toUnwrappedModel(lmsBookJoin);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmsBookJoin, merge);

			lmsBookJoin.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookJoinImpl.class, lmsBookJoin.getPrimaryKey(), lmsBookJoin);

		return lmsBookJoin;
	}

	protected LMSBookJoin toUnwrappedModel(LMSBookJoin lmsBookJoin) {
		if (lmsBookJoin instanceof LMSBookJoinImpl) {
			return lmsBookJoin;
		}

		LMSBookJoinImpl lmsBookJoinImpl = new LMSBookJoinImpl();

		lmsBookJoinImpl.setNew(lmsBookJoin.isNew());
		lmsBookJoinImpl.setPrimaryKey(lmsBookJoin.getPrimaryKey());

		lmsBookJoinImpl.setJoinId(lmsBookJoin.getJoinId());
		lmsBookJoinImpl.setBookId(lmsBookJoin.getBookId());
		lmsBookJoinImpl.setUserId(lmsBookJoin.getUserId());
		lmsBookJoinImpl.setBookTitle(lmsBookJoin.getBookTitle());
		lmsBookJoinImpl.setAuthor(lmsBookJoin.getAuthor());
		lmsBookJoinImpl.setFirstName(lmsBookJoin.getFirstName());
		lmsBookJoinImpl.setLastName(lmsBookJoin.getLastName());
		lmsBookJoinImpl.setCity(lmsBookJoin.getCity());
		lmsBookJoinImpl.setZip(lmsBookJoin.getZip());
		lmsBookJoinImpl.setEmailAddress(lmsBookJoin.getEmailAddress());

		return lmsBookJoinImpl;
	}

	/**
	 * Returns the l m s book join with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book join
	 * @return the l m s book join
	 * @throws com.liferay.portal.NoSuchModelException if a l m s book join with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBookJoin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l m s book join with the primary key or throws a {@link com.library.slayer.NoSuchBookJoinException} if it could not be found.
	 *
	 * @param joinId the primary key of the l m s book join
	 * @return the l m s book join
	 * @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBookJoin findByPrimaryKey(long joinId)
		throws NoSuchBookJoinException, SystemException {
		LMSBookJoin lmsBookJoin = fetchByPrimaryKey(joinId);

		if (lmsBookJoin == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + joinId);
			}

			throw new NoSuchBookJoinException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				joinId);
		}

		return lmsBookJoin;
	}

	/**
	 * Returns the l m s book join with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book join
	 * @return the l m s book join, or <code>null</code> if a l m s book join with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBookJoin fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l m s book join with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joinId the primary key of the l m s book join
	 * @return the l m s book join, or <code>null</code> if a l m s book join with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBookJoin fetchByPrimaryKey(long joinId) throws SystemException {
		LMSBookJoin lmsBookJoin = (LMSBookJoin)EntityCacheUtil.getResult(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookJoinImpl.class, joinId);

		if (lmsBookJoin == _nullLMSBookJoin) {
			return null;
		}

		if (lmsBookJoin == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lmsBookJoin = (LMSBookJoin)session.get(LMSBookJoinImpl.class,
						Long.valueOf(joinId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lmsBookJoin != null) {
					cacheResult(lmsBookJoin);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LMSBookJoinModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookJoinImpl.class, joinId, _nullLMSBookJoin);
				}

				closeSession(session);
			}
		}

		return lmsBookJoin;
	}

	/**
	 * Returns all the l m s book joins.
	 *
	 * @return the l m s book joins
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBookJoin> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s book joins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s book joins
	 * @param end the upper bound of the range of l m s book joins (not inclusive)
	 * @return the range of l m s book joins
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBookJoin> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s book joins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s book joins
	 * @param end the upper bound of the range of l m s book joins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s book joins
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBookJoin> findAll(int start, int end,
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

		List<LMSBookJoin> list = (List<LMSBookJoin>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSBOOKJOIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSBOOKJOIN;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LMSBookJoin>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LMSBookJoin>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l m s book joins from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LMSBookJoin lmsBookJoin : findAll()) {
			remove(lmsBookJoin);
		}
	}

	/**
	 * Returns the number of l m s book joins.
	 *
	 * @return the number of l m s book joins
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LMSBOOKJOIN);

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
	 * Initializes the l m s book join persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.library.slayer.model.LMSBookJoin")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSBookJoin>> listenersList = new ArrayList<ModelListener<LMSBookJoin>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSBookJoin>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSBookJoinImpl.class.getName());
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
	private static final String _SQL_SELECT_LMSBOOKJOIN = "SELECT lmsBookJoin FROM LMSBookJoin lmsBookJoin";
	private static final String _SQL_COUNT_LMSBOOKJOIN = "SELECT COUNT(lmsBookJoin) FROM LMSBookJoin lmsBookJoin";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsBookJoin.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSBookJoin exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSBookJoinPersistenceImpl.class);
	private static LMSBookJoin _nullLMSBookJoin = new LMSBookJoinImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSBookJoin> toCacheModel() {
				return _nullLMSBookJoinCacheModel;
			}
		};

	private static CacheModel<LMSBookJoin> _nullLMSBookJoinCacheModel = new CacheModel<LMSBookJoin>() {
			public LMSBookJoin toEntityModel() {
				return _nullLMSBookJoin;
			}
		};
}