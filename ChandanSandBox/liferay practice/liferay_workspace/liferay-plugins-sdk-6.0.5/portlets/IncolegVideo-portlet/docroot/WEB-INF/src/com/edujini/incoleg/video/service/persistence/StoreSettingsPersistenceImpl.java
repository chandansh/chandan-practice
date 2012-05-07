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

import com.edujini.incoleg.video.NoSuchStoreSettingsException;
import com.edujini.incoleg.video.model.StoreSettings;
import com.edujini.incoleg.video.model.impl.StoreSettingsImpl;
import com.edujini.incoleg.video.model.impl.StoreSettingsModelImpl;

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
 * The persistence implementation for the store settings service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link StoreSettingsUtil} to access the store settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see StoreSettingsPersistence
 * @see StoreSettingsUtil
 * @generated
 */
public class StoreSettingsPersistenceImpl extends BasePersistenceImpl<StoreSettings>
	implements StoreSettingsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = StoreSettingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
			StoreSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
			StoreSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the store settings in the entity cache if it is enabled.
	 *
	 * @param storeSettings the store settings to cache
	 */
	public void cacheResult(StoreSettings storeSettings) {
		EntityCacheUtil.putResult(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
			StoreSettingsImpl.class, storeSettings.getPrimaryKey(),
			storeSettings);
	}

	/**
	 * Caches the store settingses in the entity cache if it is enabled.
	 *
	 * @param storeSettingses the store settingses to cache
	 */
	public void cacheResult(List<StoreSettings> storeSettingses) {
		for (StoreSettings storeSettings : storeSettingses) {
			if (EntityCacheUtil.getResult(
						StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
						StoreSettingsImpl.class, storeSettings.getPrimaryKey(),
						this) == null) {
				cacheResult(storeSettings);
			}
		}
	}

	/**
	 * Clears the cache for all store settingses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(StoreSettingsImpl.class.getName());
		EntityCacheUtil.clearCache(StoreSettingsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the store settings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(StoreSettings storeSettings) {
		EntityCacheUtil.removeResult(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
			StoreSettingsImpl.class, storeSettings.getPrimaryKey());
	}

	/**
	 * Creates a new store settings with the primary key. Does not add the store settings to the database.
	 *
	 * @param storeId the primary key for the new store settings
	 * @return the new store settings
	 */
	public StoreSettings create(long storeId) {
		StoreSettings storeSettings = new StoreSettingsImpl();

		storeSettings.setNew(true);
		storeSettings.setPrimaryKey(storeId);

		return storeSettings;
	}

	/**
	 * Removes the store settings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the store settings to remove
	 * @return the store settings that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a store settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StoreSettings remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the store settings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param storeId the primary key of the store settings to remove
	 * @return the store settings that was removed
	 * @throws com.edujini.incoleg.video.NoSuchStoreSettingsException if a store settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StoreSettings remove(long storeId)
		throws NoSuchStoreSettingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StoreSettings storeSettings = (StoreSettings)session.get(StoreSettingsImpl.class,
					new Long(storeId));

			if (storeSettings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + storeId);
				}

				throw new NoSuchStoreSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					storeId);
			}

			return remove(storeSettings);
		}
		catch (NoSuchStoreSettingsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoreSettings removeImpl(StoreSettings storeSettings)
		throws SystemException {
		storeSettings = toUnwrappedModel(storeSettings);

		Session session = null;

		try {
			session = openSession();

			if (storeSettings.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(StoreSettingsImpl.class,
						storeSettings.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(storeSettings);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
			StoreSettingsImpl.class, storeSettings.getPrimaryKey());

		return storeSettings;
	}

	public StoreSettings updateImpl(
		com.edujini.incoleg.video.model.StoreSettings storeSettings,
		boolean merge) throws SystemException {
		storeSettings = toUnwrappedModel(storeSettings);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, storeSettings, merge);

			storeSettings.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
			StoreSettingsImpl.class, storeSettings.getPrimaryKey(),
			storeSettings);

		return storeSettings;
	}

	protected StoreSettings toUnwrappedModel(StoreSettings storeSettings) {
		if (storeSettings instanceof StoreSettingsImpl) {
			return storeSettings;
		}

		StoreSettingsImpl storeSettingsImpl = new StoreSettingsImpl();

		storeSettingsImpl.setNew(storeSettings.isNew());
		storeSettingsImpl.setPrimaryKey(storeSettings.getPrimaryKey());

		storeSettingsImpl.setStoreId(storeSettings.getStoreId());
		storeSettingsImpl.setInBId(storeSettings.getInBId());
		storeSettingsImpl.setPrBId(storeSettings.getPrBId());
		storeSettingsImpl.setOutBId(storeSettings.getOutBId());
		storeSettingsImpl.setAccessKId(storeSettings.getAccessKId());
		storeSettingsImpl.setSecretAKey(storeSettings.getSecretAKey());

		return storeSettingsImpl;
	}

	/**
	 * Finds the store settings with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the store settings to find
	 * @return the store settings
	 * @throws com.liferay.portal.NoSuchModelException if a store settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StoreSettings findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the store settings with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchStoreSettingsException} if it could not be found.
	 *
	 * @param storeId the primary key of the store settings to find
	 * @return the store settings
	 * @throws com.edujini.incoleg.video.NoSuchStoreSettingsException if a store settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StoreSettings findByPrimaryKey(long storeId)
		throws NoSuchStoreSettingsException, SystemException {
		StoreSettings storeSettings = fetchByPrimaryKey(storeId);

		if (storeSettings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + storeId);
			}

			throw new NoSuchStoreSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				storeId);
		}

		return storeSettings;
	}

	/**
	 * Finds the store settings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the store settings to find
	 * @return the store settings, or <code>null</code> if a store settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StoreSettings fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the store settings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param storeId the primary key of the store settings to find
	 * @return the store settings, or <code>null</code> if a store settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StoreSettings fetchByPrimaryKey(long storeId)
		throws SystemException {
		StoreSettings storeSettings = (StoreSettings)EntityCacheUtil.getResult(StoreSettingsModelImpl.ENTITY_CACHE_ENABLED,
				StoreSettingsImpl.class, storeId, this);

		if (storeSettings == null) {
			Session session = null;

			try {
				session = openSession();

				storeSettings = (StoreSettings)session.get(StoreSettingsImpl.class,
						new Long(storeId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (storeSettings != null) {
					cacheResult(storeSettings);
				}

				closeSession(session);
			}
		}

		return storeSettings;
	}

	/**
	 * Finds all the store settingses.
	 *
	 * @return the store settingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<StoreSettings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the store settingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of store settingses to return
	 * @param end the upper bound of the range of store settingses to return (not inclusive)
	 * @return the range of store settingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<StoreSettings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the store settingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of store settingses to return
	 * @param end the upper bound of the range of store settingses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of store settingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<StoreSettings> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<StoreSettings> list = (List<StoreSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_STORESETTINGS);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_STORESETTINGS;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<StoreSettings>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<StoreSettings>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<StoreSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the store settingses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (StoreSettings storeSettings : findAll()) {
			remove(storeSettings);
		}
	}

	/**
	 * Counts all the store settingses.
	 *
	 * @return the number of store settingses
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

				Query q = session.createQuery(_SQL_COUNT_STORESETTINGS);

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
	 * Initializes the store settings persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.edujini.incoleg.video.model.StoreSettings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StoreSettings>> listenersList = new ArrayList<ModelListener<StoreSettings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StoreSettings>)InstanceFactory.newInstance(
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
	private static final String _SQL_SELECT_STORESETTINGS = "SELECT storeSettings FROM StoreSettings storeSettings";
	private static final String _SQL_COUNT_STORESETTINGS = "SELECT COUNT(storeSettings) FROM StoreSettings storeSettings";
	private static final String _ORDER_BY_ENTITY_ALIAS = "storeSettings.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StoreSettings exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(StoreSettingsPersistenceImpl.class);
}