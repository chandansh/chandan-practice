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

package com.edujini.incoleg.video.service.persistence;

import com.edujini.incoleg.video.NoSuchVOMapException;
import com.edujini.incoleg.video.model.VOMap;
import com.edujini.incoleg.video.model.impl.VOMapImpl;
import com.edujini.incoleg.video.model.impl.VOMapModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the v o map service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link VOMapUtil} to access the v o map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see VOMapPersistence
 * @see VOMapUtil
 * @generated
 */
public class VOMapPersistenceImpl extends BasePersistenceImpl<VOMap>
	implements VOMapPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = VOMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(VOMapModelImpl.ENTITY_CACHE_ENABLED,
			VOMapModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VOMapModelImpl.ENTITY_CACHE_ENABLED,
			VOMapModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the v o map in the entity cache if it is enabled.
	 *
	 * @param voMap the v o map to cache
	 */
	public void cacheResult(VOMap voMap) {
		EntityCacheUtil.putResult(VOMapModelImpl.ENTITY_CACHE_ENABLED,
			VOMapImpl.class, voMap.getPrimaryKey(), voMap);
	}

	/**
	 * Caches the v o maps in the entity cache if it is enabled.
	 *
	 * @param voMaps the v o maps to cache
	 */
	public void cacheResult(List<VOMap> voMaps) {
		for (VOMap voMap : voMaps) {
			if (EntityCacheUtil.getResult(VOMapModelImpl.ENTITY_CACHE_ENABLED,
						VOMapImpl.class, voMap.getPrimaryKey(), this) == null) {
				cacheResult(voMap);
			}
		}
	}

	/**
	 * Clears the cache for all v o maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(VOMapImpl.class.getName());
		EntityCacheUtil.clearCache(VOMapImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the v o map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(VOMap voMap) {
		EntityCacheUtil.removeResult(VOMapModelImpl.ENTITY_CACHE_ENABLED,
			VOMapImpl.class, voMap.getPrimaryKey());
	}

	/**
	 * Creates a new v o map with the primary key. Does not add the v o map to the database.
	 *
	 * @param videoId the primary key for the new v o map
	 * @return the new v o map
	 */
	public VOMap create(String videoId) {
		VOMap voMap = new VOMapImpl();

		voMap.setNew(true);
		voMap.setPrimaryKey(videoId);

		return voMap;
	}

	/**
	 * Removes the v o map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v o map to remove
	 * @return the v o map that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a v o map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VOMap remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove((String)primaryKey);
	}

	/**
	 * Removes the v o map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the v o map to remove
	 * @return the v o map that was removed
	 * @throws com.edujini.incoleg.video.NoSuchVOMapException if a v o map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VOMap remove(String videoId)
		throws NoSuchVOMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VOMap voMap = (VOMap)session.get(VOMapImpl.class, videoId);

			if (voMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoId);
				}

				throw new NoSuchVOMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					videoId);
			}

			return remove(voMap);
		}
		catch (NoSuchVOMapException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VOMap removeImpl(VOMap voMap) throws SystemException {
		voMap = toUnwrappedModel(voMap);

		Session session = null;

		try {
			session = openSession();

			if (voMap.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(VOMapImpl.class,
						voMap.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(voMap);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(VOMapModelImpl.ENTITY_CACHE_ENABLED,
			VOMapImpl.class, voMap.getPrimaryKey());

		return voMap;
	}

	public VOMap updateImpl(com.edujini.incoleg.video.model.VOMap voMap,
		boolean merge) throws SystemException {
		voMap = toUnwrappedModel(voMap);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, voMap, merge);

			voMap.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(VOMapModelImpl.ENTITY_CACHE_ENABLED,
			VOMapImpl.class, voMap.getPrimaryKey(), voMap);

		return voMap;
	}

	protected VOMap toUnwrappedModel(VOMap voMap) {
		if (voMap instanceof VOMapImpl) {
			return voMap;
		}

		VOMapImpl voMapImpl = new VOMapImpl();

		voMapImpl.setNew(voMap.isNew());
		voMapImpl.setPrimaryKey(voMap.getPrimaryKey());

		voMapImpl.setVideoId(voMap.getVideoId());
		voMapImpl.setOrgId(voMap.getOrgId());
		voMapImpl.setStoreType(voMap.getStoreType());

		return voMapImpl;
	}

	/**
	 * Finds the v o map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v o map to find
	 * @return the v o map
	 * @throws com.liferay.portal.NoSuchModelException if a v o map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VOMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Finds the v o map with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchVOMapException} if it could not be found.
	 *
	 * @param videoId the primary key of the v o map to find
	 * @return the v o map
	 * @throws com.edujini.incoleg.video.NoSuchVOMapException if a v o map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VOMap findByPrimaryKey(String videoId)
		throws NoSuchVOMapException, SystemException {
		VOMap voMap = fetchByPrimaryKey(videoId);

		if (voMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoId);
			}

			throw new NoSuchVOMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoId);
		}

		return voMap;
	}

	/**
	 * Finds the v o map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v o map to find
	 * @return the v o map, or <code>null</code> if a v o map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VOMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Finds the v o map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the v o map to find
	 * @return the v o map, or <code>null</code> if a v o map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VOMap fetchByPrimaryKey(String videoId) throws SystemException {
		VOMap voMap = (VOMap)EntityCacheUtil.getResult(VOMapModelImpl.ENTITY_CACHE_ENABLED,
				VOMapImpl.class, videoId, this);

		if (voMap == null) {
			Session session = null;

			try {
				session = openSession();

				voMap = (VOMap)session.get(VOMapImpl.class, videoId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (voMap != null) {
					cacheResult(voMap);
				}

				closeSession(session);
			}
		}

		return voMap;
	}

	/**
	 * Finds all the v o maps.
	 *
	 * @return the v o maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VOMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the v o maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v o maps to return
	 * @param end the upper bound of the range of v o maps to return (not inclusive)
	 * @return the range of v o maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VOMap> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the v o maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v o maps to return
	 * @param end the upper bound of the range of v o maps to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of v o maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VOMap> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<VOMap> list = (List<VOMap>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_VOMAP);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_VOMAP;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VOMap>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VOMap>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<VOMap>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the v o maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VOMap voMap : findAll()) {
			remove(voMap);
		}
	}

	/**
	 * Counts all the v o maps.
	 *
	 * @return the number of v o maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VOMAP);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the v o map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.edujini.incoleg.video.model.VOMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VOMap>> listenersList = new ArrayList<ModelListener<VOMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VOMap>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = VideoInfoPersistence.class)
	protected VideoInfoPersistence videoInfoPersistence;
	@BeanReference(type = StoreSettingsPersistence.class)
	protected StoreSettingsPersistence storeSettingsPersistence;
	@BeanReference(type = VOMapPersistence.class)
	protected VOMapPersistence voMapPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VOMAP = "SELECT voMap FROM VOMap voMap";
	private static final String _SQL_COUNT_VOMAP = "SELECT COUNT(voMap) FROM VOMap voMap";
	private static final String _ORDER_BY_ENTITY_ALIAS = "voMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VOMap exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(VOMapPersistenceImpl.class);
}