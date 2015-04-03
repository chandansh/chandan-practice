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

package com.slayer.service.persistence;

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

import com.slayer.NoSuchShoppingCartExtException;

import com.slayer.model.ShoppingCartExt;
import com.slayer.model.impl.ShoppingCartExtImpl;
import com.slayer.model.impl.ShoppingCartExtModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping cart ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCartExtPersistence
 * @see ShoppingCartExtUtil
 * @generated
 */
public class ShoppingCartExtPersistenceImpl extends BasePersistenceImpl<ShoppingCartExt>
	implements ShoppingCartExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingCartExtUtil} to access the shopping cart ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingCartExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartExtModelImpl.FINDER_CACHE_ENABLED,
			ShoppingCartExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartExtModelImpl.FINDER_CACHE_ENABLED,
			ShoppingCartExtImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the shopping cart ext in the entity cache if it is enabled.
	 *
	 * @param shoppingCartExt the shopping cart ext
	 */
	public void cacheResult(ShoppingCartExt shoppingCartExt) {
		EntityCacheUtil.putResult(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartExtImpl.class, shoppingCartExt.getPrimaryKey(),
			shoppingCartExt);

		shoppingCartExt.resetOriginalValues();
	}

	/**
	 * Caches the shopping cart exts in the entity cache if it is enabled.
	 *
	 * @param shoppingCartExts the shopping cart exts
	 */
	public void cacheResult(List<ShoppingCartExt> shoppingCartExts) {
		for (ShoppingCartExt shoppingCartExt : shoppingCartExts) {
			if (EntityCacheUtil.getResult(
						ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingCartExtImpl.class,
						shoppingCartExt.getPrimaryKey()) == null) {
				cacheResult(shoppingCartExt);
			}
			else {
				shoppingCartExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all shopping cart exts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShoppingCartExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShoppingCartExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the shopping cart ext.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingCartExt shoppingCartExt) {
		EntityCacheUtil.removeResult(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartExtImpl.class, shoppingCartExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ShoppingCartExt> shoppingCartExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShoppingCartExt shoppingCartExt : shoppingCartExts) {
			EntityCacheUtil.removeResult(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingCartExtImpl.class, shoppingCartExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new shopping cart ext with the primary key. Does not add the shopping cart ext to the database.
	 *
	 * @param recId the primary key for the new shopping cart ext
	 * @return the new shopping cart ext
	 */
	public ShoppingCartExt create(long recId) {
		ShoppingCartExt shoppingCartExt = new ShoppingCartExtImpl();

		shoppingCartExt.setNew(true);
		shoppingCartExt.setPrimaryKey(recId);

		return shoppingCartExt;
	}

	/**
	 * Removes the shopping cart ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the shopping cart ext
	 * @return the shopping cart ext that was removed
	 * @throws com.slayer.NoSuchShoppingCartExtException if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt remove(long recId)
		throws NoSuchShoppingCartExtException, SystemException {
		return remove(Long.valueOf(recId));
	}

	/**
	 * Removes the shopping cart ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping cart ext
	 * @return the shopping cart ext that was removed
	 * @throws com.slayer.NoSuchShoppingCartExtException if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCartExt remove(Serializable primaryKey)
		throws NoSuchShoppingCartExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingCartExt shoppingCartExt = (ShoppingCartExt)session.get(ShoppingCartExtImpl.class,
					primaryKey);

			if (shoppingCartExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShoppingCartExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shoppingCartExt);
		}
		catch (NoSuchShoppingCartExtException nsee) {
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
	protected ShoppingCartExt removeImpl(ShoppingCartExt shoppingCartExt)
		throws SystemException {
		shoppingCartExt = toUnwrappedModel(shoppingCartExt);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingCartExt);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(shoppingCartExt);

		return shoppingCartExt;
	}

	@Override
	public ShoppingCartExt updateImpl(
		com.slayer.model.ShoppingCartExt shoppingCartExt, boolean merge)
		throws SystemException {
		shoppingCartExt = toUnwrappedModel(shoppingCartExt);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingCartExt, merge);

			shoppingCartExt.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCartExtImpl.class, shoppingCartExt.getPrimaryKey(),
			shoppingCartExt);

		return shoppingCartExt;
	}

	protected ShoppingCartExt toUnwrappedModel(ShoppingCartExt shoppingCartExt) {
		if (shoppingCartExt instanceof ShoppingCartExtImpl) {
			return shoppingCartExt;
		}

		ShoppingCartExtImpl shoppingCartExtImpl = new ShoppingCartExtImpl();

		shoppingCartExtImpl.setNew(shoppingCartExt.isNew());
		shoppingCartExtImpl.setPrimaryKey(shoppingCartExt.getPrimaryKey());

		shoppingCartExtImpl.setRecId(shoppingCartExt.getRecId());
		shoppingCartExtImpl.setCartId(shoppingCartExt.getCartId());
		shoppingCartExtImpl.setItemId(shoppingCartExt.getItemId());
		shoppingCartExtImpl.setAmount(shoppingCartExt.getAmount());

		return shoppingCartExtImpl;
	}

	/**
	 * Returns the shopping cart ext with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping cart ext
	 * @return the shopping cart ext
	 * @throws com.liferay.portal.NoSuchModelException if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCartExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shopping cart ext with the primary key or throws a {@link com.slayer.NoSuchShoppingCartExtException} if it could not be found.
	 *
	 * @param recId the primary key of the shopping cart ext
	 * @return the shopping cart ext
	 * @throws com.slayer.NoSuchShoppingCartExtException if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt findByPrimaryKey(long recId)
		throws NoSuchShoppingCartExtException, SystemException {
		ShoppingCartExt shoppingCartExt = fetchByPrimaryKey(recId);

		if (shoppingCartExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + recId);
			}

			throw new NoSuchShoppingCartExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				recId);
		}

		return shoppingCartExt;
	}

	/**
	 * Returns the shopping cart ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping cart ext
	 * @return the shopping cart ext, or <code>null</code> if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingCartExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the shopping cart ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recId the primary key of the shopping cart ext
	 * @return the shopping cart ext, or <code>null</code> if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt fetchByPrimaryKey(long recId)
		throws SystemException {
		ShoppingCartExt shoppingCartExt = (ShoppingCartExt)EntityCacheUtil.getResult(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingCartExtImpl.class, recId);

		if (shoppingCartExt == _nullShoppingCartExt) {
			return null;
		}

		if (shoppingCartExt == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				shoppingCartExt = (ShoppingCartExt)session.get(ShoppingCartExtImpl.class,
						Long.valueOf(recId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (shoppingCartExt != null) {
					cacheResult(shoppingCartExt);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ShoppingCartExtModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingCartExtImpl.class, recId, _nullShoppingCartExt);
				}

				closeSession(session);
			}
		}

		return shoppingCartExt;
	}

	/**
	 * Returns all the shopping cart exts.
	 *
	 * @return the shopping cart exts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCartExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shopping cart exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping cart exts
	 * @param end the upper bound of the range of shopping cart exts (not inclusive)
	 * @return the range of shopping cart exts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCartExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the shopping cart exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of shopping cart exts
	 * @param end the upper bound of the range of shopping cart exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shopping cart exts
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCartExt> findAll(int start, int end,
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

		List<ShoppingCartExt> list = (List<ShoppingCartExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGCARTEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGCARTEXT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingCartExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingCartExt>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the shopping cart exts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingCartExt shoppingCartExt : findAll()) {
			remove(shoppingCartExt);
		}
	}

	/**
	 * Returns the number of shopping cart exts.
	 *
	 * @return the number of shopping cart exts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGCARTEXT);

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
	 * Initializes the shopping cart ext persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.slayer.model.ShoppingCartExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingCartExt>> listenersList = new ArrayList<ModelListener<ShoppingCartExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingCartExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShoppingCartExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ShoppingCartExtPersistence.class)
	protected ShoppingCartExtPersistence shoppingCartExtPersistence;
	@BeanReference(type = ShoppingCategoryExtPersistence.class)
	protected ShoppingCategoryExtPersistence shoppingCategoryExtPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SHOPPINGCARTEXT = "SELECT shoppingCartExt FROM ShoppingCartExt shoppingCartExt";
	private static final String _SQL_COUNT_SHOPPINGCARTEXT = "SELECT COUNT(shoppingCartExt) FROM ShoppingCartExt shoppingCartExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingCartExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingCartExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShoppingCartExtPersistenceImpl.class);
	private static ShoppingCartExt _nullShoppingCartExt = new ShoppingCartExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ShoppingCartExt> toCacheModel() {
				return _nullShoppingCartExtCacheModel;
			}
		};

	private static CacheModel<ShoppingCartExt> _nullShoppingCartExtCacheModel = new CacheModel<ShoppingCartExt>() {
			public ShoppingCartExt toEntityModel() {
				return _nullShoppingCartExt;
			}
		};
}