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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.mpower.services.NoSuchExtWorkFlowException;
import com.mpower.services.model.ExtWorkFlow;
import com.mpower.services.model.impl.ExtWorkFlowImpl;
import com.mpower.services.model.impl.ExtWorkFlowModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ext work flow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Meenu
 * @see ExtWorkFlowPersistence
 * @see ExtWorkFlowUtil
 * @generated
 */
public class ExtWorkFlowPersistenceImpl extends BasePersistenceImpl<ExtWorkFlow>
	implements ExtWorkFlowPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExtWorkFlowUtil} to access the ext work flow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExtWorkFlowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_S_EXTWORKFLOW =
		new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, ExtWorkFlowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_S_ExtWorkflow",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_S_EXTWORKFLOW =
		new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, ExtWorkFlowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_S_ExtWorkflow",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			ExtWorkFlowModelImpl.RESOURCEPRIMKEY_COLUMN_BITMASK |
			ExtWorkFlowModelImpl.STATUS_COLUMN_BITMASK |
			ExtWorkFlowModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			ExtWorkFlowModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_S_EXTWORKFLOW = new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByR_S_ExtWorkflow",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_WORKFLOWDETAILS = new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, ExtWorkFlowImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByworkFlowDetails",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ExtWorkFlowModelImpl.RESOURCEPRIMKEY_COLUMN_BITMASK |
			ExtWorkFlowModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			ExtWorkFlowModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOWDETAILS = new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByworkFlowDetails",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, ExtWorkFlowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, ExtWorkFlowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ext work flow in the entity cache if it is enabled.
	 *
	 * @param extWorkFlow the ext work flow
	 */
	public void cacheResult(ExtWorkFlow extWorkFlow) {
		EntityCacheUtil.putResult(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowImpl.class, extWorkFlow.getPrimaryKey(), extWorkFlow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
			new Object[] {
				Long.valueOf(extWorkFlow.getResourcePrimKey()),
				Long.valueOf(extWorkFlow.getClassNameId()),
				Long.valueOf(extWorkFlow.getClassPK())
			}, extWorkFlow);

		extWorkFlow.resetOriginalValues();
	}

	/**
	 * Caches the ext work flows in the entity cache if it is enabled.
	 *
	 * @param extWorkFlows the ext work flows
	 */
	public void cacheResult(List<ExtWorkFlow> extWorkFlows) {
		for (ExtWorkFlow extWorkFlow : extWorkFlows) {
			if (EntityCacheUtil.getResult(
						ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
						ExtWorkFlowImpl.class, extWorkFlow.getPrimaryKey()) == null) {
				cacheResult(extWorkFlow);
			}
			else {
				extWorkFlow.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ext work flows.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExtWorkFlowImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExtWorkFlowImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ext work flow.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExtWorkFlow extWorkFlow) {
		EntityCacheUtil.removeResult(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowImpl.class, extWorkFlow.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(extWorkFlow);
	}

	@Override
	public void clearCache(List<ExtWorkFlow> extWorkFlows) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExtWorkFlow extWorkFlow : extWorkFlows) {
			EntityCacheUtil.removeResult(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
				ExtWorkFlowImpl.class, extWorkFlow.getPrimaryKey());

			clearUniqueFindersCache(extWorkFlow);
		}
	}

	protected void clearUniqueFindersCache(ExtWorkFlow extWorkFlow) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
			new Object[] {
				Long.valueOf(extWorkFlow.getResourcePrimKey()),
				Long.valueOf(extWorkFlow.getClassNameId()),
				Long.valueOf(extWorkFlow.getClassPK())
			});
	}

	/**
	 * Creates a new ext work flow with the primary key. Does not add the ext work flow to the database.
	 *
	 * @param extWorkflowId the primary key for the new ext work flow
	 * @return the new ext work flow
	 */
	public ExtWorkFlow create(long extWorkflowId) {
		ExtWorkFlow extWorkFlow = new ExtWorkFlowImpl();

		extWorkFlow.setNew(true);
		extWorkFlow.setPrimaryKey(extWorkflowId);

		return extWorkFlow;
	}

	/**
	 * Removes the ext work flow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param extWorkflowId the primary key of the ext work flow
	 * @return the ext work flow that was removed
	 * @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExtWorkFlow remove(long extWorkflowId)
		throws NoSuchExtWorkFlowException, SystemException {
		return remove(Long.valueOf(extWorkflowId));
	}

	/**
	 * Removes the ext work flow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ext work flow
	 * @return the ext work flow that was removed
	 * @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtWorkFlow remove(Serializable primaryKey)
		throws NoSuchExtWorkFlowException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExtWorkFlow extWorkFlow = (ExtWorkFlow)session.get(ExtWorkFlowImpl.class,
					primaryKey);

			if (extWorkFlow == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExtWorkFlowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(extWorkFlow);
		}
		catch (NoSuchExtWorkFlowException nsee) {
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
	protected ExtWorkFlow removeImpl(ExtWorkFlow extWorkFlow)
		throws SystemException {
		extWorkFlow = toUnwrappedModel(extWorkFlow);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, extWorkFlow);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(extWorkFlow);

		return extWorkFlow;
	}

	@Override
	public ExtWorkFlow updateImpl(
		com.mpower.services.model.ExtWorkFlow extWorkFlow, boolean merge)
		throws SystemException {
		extWorkFlow = toUnwrappedModel(extWorkFlow);

		boolean isNew = extWorkFlow.isNew();

		ExtWorkFlowModelImpl extWorkFlowModelImpl = (ExtWorkFlowModelImpl)extWorkFlow;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, extWorkFlow, merge);

			extWorkFlow.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExtWorkFlowModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((extWorkFlowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_S_EXTWORKFLOW.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(extWorkFlowModelImpl.getOriginalResourcePrimKey()),
						Integer.valueOf(extWorkFlowModelImpl.getOriginalStatus()),
						Long.valueOf(extWorkFlowModelImpl.getOriginalClassNameId()),
						Long.valueOf(extWorkFlowModelImpl.getOriginalClassPK())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_S_EXTWORKFLOW,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_S_EXTWORKFLOW,
					args);

				args = new Object[] {
						Long.valueOf(extWorkFlowModelImpl.getResourcePrimKey()),
						Integer.valueOf(extWorkFlowModelImpl.getStatus()),
						Long.valueOf(extWorkFlowModelImpl.getClassNameId()),
						Long.valueOf(extWorkFlowModelImpl.getClassPK())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_S_EXTWORKFLOW,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_S_EXTWORKFLOW,
					args);
			}
		}

		EntityCacheUtil.putResult(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			ExtWorkFlowImpl.class, extWorkFlow.getPrimaryKey(), extWorkFlow);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
				new Object[] {
					Long.valueOf(extWorkFlow.getResourcePrimKey()),
					Long.valueOf(extWorkFlow.getClassNameId()),
					Long.valueOf(extWorkFlow.getClassPK())
				}, extWorkFlow);
		}
		else {
			if ((extWorkFlowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WORKFLOWDETAILS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(extWorkFlowModelImpl.getOriginalResourcePrimKey()),
						Long.valueOf(extWorkFlowModelImpl.getOriginalClassNameId()),
						Long.valueOf(extWorkFlowModelImpl.getOriginalClassPK())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWDETAILS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
					new Object[] {
						Long.valueOf(extWorkFlow.getResourcePrimKey()),
						Long.valueOf(extWorkFlow.getClassNameId()),
						Long.valueOf(extWorkFlow.getClassPK())
					}, extWorkFlow);
			}
		}

		return extWorkFlow;
	}

	protected ExtWorkFlow toUnwrappedModel(ExtWorkFlow extWorkFlow) {
		if (extWorkFlow instanceof ExtWorkFlowImpl) {
			return extWorkFlow;
		}

		ExtWorkFlowImpl extWorkFlowImpl = new ExtWorkFlowImpl();

		extWorkFlowImpl.setNew(extWorkFlow.isNew());
		extWorkFlowImpl.setPrimaryKey(extWorkFlow.getPrimaryKey());

		extWorkFlowImpl.setExtWorkflowId(extWorkFlow.getExtWorkflowId());
		extWorkFlowImpl.setResourcePrimKey(extWorkFlow.getResourcePrimKey());
		extWorkFlowImpl.setClassNameId(extWorkFlow.getClassNameId());
		extWorkFlowImpl.setClassPK(extWorkFlow.getClassPK());
		extWorkFlowImpl.setParentResourcePrimKey(extWorkFlow.getParentResourcePrimKey());
		extWorkFlowImpl.setVersion(extWorkFlow.getVersion());
		extWorkFlowImpl.setTitle(extWorkFlow.getTitle());
		extWorkFlowImpl.setContent(extWorkFlow.getContent());
		extWorkFlowImpl.setDescription(extWorkFlow.getDescription());
		extWorkFlowImpl.setPriority(extWorkFlow.getPriority());
		extWorkFlowImpl.setStatus(extWorkFlow.getStatus());
		extWorkFlowImpl.setStatusByUserId(extWorkFlow.getStatusByUserId());
		extWorkFlowImpl.setStatusByUserName(extWorkFlow.getStatusByUserName());
		extWorkFlowImpl.setStatusDate(extWorkFlow.getStatusDate());

		return extWorkFlowImpl;
	}

	/**
	 * Returns the ext work flow with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext work flow
	 * @return the ext work flow
	 * @throws com.liferay.portal.NoSuchModelException if a ext work flow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtWorkFlow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ext work flow with the primary key or throws a {@link com.mpower.services.NoSuchExtWorkFlowException} if it could not be found.
	 *
	 * @param extWorkflowId the primary key of the ext work flow
	 * @return the ext work flow
	 * @throws com.mpower.services.NoSuchExtWorkFlowException if a ext work flow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExtWorkFlow findByPrimaryKey(long extWorkflowId)
		throws NoSuchExtWorkFlowException, SystemException {
		ExtWorkFlow extWorkFlow = fetchByPrimaryKey(extWorkflowId);

		if (extWorkFlow == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + extWorkflowId);
			}

			throw new NoSuchExtWorkFlowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				extWorkflowId);
		}

		return extWorkFlow;
	}

	/**
	 * Returns the ext work flow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext work flow
	 * @return the ext work flow, or <code>null</code> if a ext work flow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtWorkFlow fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ext work flow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param extWorkflowId the primary key of the ext work flow
	 * @return the ext work flow, or <code>null</code> if a ext work flow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExtWorkFlow fetchByPrimaryKey(long extWorkflowId)
		throws SystemException {
		ExtWorkFlow extWorkFlow = (ExtWorkFlow)EntityCacheUtil.getResult(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
				ExtWorkFlowImpl.class, extWorkflowId);

		if (extWorkFlow == _nullExtWorkFlow) {
			return null;
		}

		if (extWorkFlow == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				extWorkFlow = (ExtWorkFlow)session.get(ExtWorkFlowImpl.class,
						Long.valueOf(extWorkflowId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (extWorkFlow != null) {
					cacheResult(extWorkFlow);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
						ExtWorkFlowImpl.class, extWorkflowId, _nullExtWorkFlow);
				}

				closeSession(session);
			}
		}

		return extWorkFlow;
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
	public List<ExtWorkFlow> findByR_S_ExtWorkflow(long resourcePrimKey,
		int status, long classNameId, long classPK) throws SystemException {
		return findByR_S_ExtWorkflow(resourcePrimKey, status, classNameId,
			classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ExtWorkFlow> findByR_S_ExtWorkflow(long resourcePrimKey,
		int status, long classNameId, long classPK, int start, int end)
		throws SystemException {
		return findByR_S_ExtWorkflow(resourcePrimKey, status, classNameId,
			classPK, start, end, null);
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
	public List<ExtWorkFlow> findByR_S_ExtWorkflow(long resourcePrimKey,
		int status, long classNameId, long classPK, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_S_EXTWORKFLOW;
			finderArgs = new Object[] {
					resourcePrimKey, status, classNameId, classPK
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_S_EXTWORKFLOW;
			finderArgs = new Object[] {
					resourcePrimKey, status, classNameId, classPK,
					
					start, end, orderByComparator
				};
		}

		List<ExtWorkFlow> list = (List<ExtWorkFlow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EXTWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_RESOURCEPRIMKEY_2);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_STATUS_2);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimKey);

				qPos.add(status);

				qPos.add(classNameId);

				qPos.add(classPK);

				list = (List<ExtWorkFlow>)QueryUtil.list(q, getDialect(),
						start, end);
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
	public ExtWorkFlow findByR_S_ExtWorkflow_First(long resourcePrimKey,
		int status, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchExtWorkFlowException, SystemException {
		List<ExtWorkFlow> list = findByR_S_ExtWorkflow(resourcePrimKey, status,
				classNameId, classPK, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("resourcePrimKey=");
			msg.append(resourcePrimKey);

			msg.append(", status=");
			msg.append(status);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchExtWorkFlowException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public ExtWorkFlow findByR_S_ExtWorkflow_Last(long resourcePrimKey,
		int status, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchExtWorkFlowException, SystemException {
		int count = countByR_S_ExtWorkflow(resourcePrimKey, status,
				classNameId, classPK);

		List<ExtWorkFlow> list = findByR_S_ExtWorkflow(resourcePrimKey, status,
				classNameId, classPK, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("resourcePrimKey=");
			msg.append(resourcePrimKey);

			msg.append(", status=");
			msg.append(status);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchExtWorkFlowException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public ExtWorkFlow[] findByR_S_ExtWorkflow_PrevAndNext(long extWorkflowId,
		long resourcePrimKey, int status, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchExtWorkFlowException, SystemException {
		ExtWorkFlow extWorkFlow = findByPrimaryKey(extWorkflowId);

		Session session = null;

		try {
			session = openSession();

			ExtWorkFlow[] array = new ExtWorkFlowImpl[3];

			array[0] = getByR_S_ExtWorkflow_PrevAndNext(session, extWorkFlow,
					resourcePrimKey, status, classNameId, classPK,
					orderByComparator, true);

			array[1] = extWorkFlow;

			array[2] = getByR_S_ExtWorkflow_PrevAndNext(session, extWorkFlow,
					resourcePrimKey, status, classNameId, classPK,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExtWorkFlow getByR_S_ExtWorkflow_PrevAndNext(Session session,
		ExtWorkFlow extWorkFlow, long resourcePrimKey, int status,
		long classNameId, long classPK, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTWORKFLOW_WHERE);

		query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_RESOURCEPRIMKEY_2);

		query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_STATUS_2);

		query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resourcePrimKey);

		qPos.add(status);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(extWorkFlow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExtWorkFlow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public ExtWorkFlow findByworkFlowDetails(long resourcePrimKey,
		long classNameId, long classPK)
		throws NoSuchExtWorkFlowException, SystemException {
		ExtWorkFlow extWorkFlow = fetchByworkFlowDetails(resourcePrimKey,
				classNameId, classPK);

		if (extWorkFlow == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("resourcePrimKey=");
			msg.append(resourcePrimKey);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchExtWorkFlowException(msg.toString());
		}

		return extWorkFlow;
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
	public ExtWorkFlow fetchByworkFlowDetails(long resourcePrimKey,
		long classNameId, long classPK) throws SystemException {
		return fetchByworkFlowDetails(resourcePrimKey, classNameId, classPK,
			true);
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
	public ExtWorkFlow fetchByworkFlowDetails(long resourcePrimKey,
		long classNameId, long classPK, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { resourcePrimKey, classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EXTWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_WORKFLOWDETAILS_RESOURCEPRIMKEY_2);

			query.append(_FINDER_COLUMN_WORKFLOWDETAILS_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDETAILS_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimKey);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<ExtWorkFlow> list = q.list();

				result = list;

				ExtWorkFlow extWorkFlow = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
						finderArgs, list);
				}
				else {
					extWorkFlow = list.get(0);

					cacheResult(extWorkFlow);

					if ((extWorkFlow.getResourcePrimKey() != resourcePrimKey) ||
							(extWorkFlow.getClassNameId() != classNameId) ||
							(extWorkFlow.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
							finderArgs, extWorkFlow);
					}
				}

				return extWorkFlow;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORKFLOWDETAILS,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ExtWorkFlow)result;
			}
		}
	}

	/**
	 * Returns all the ext work flows.
	 *
	 * @return the ext work flows
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExtWorkFlow> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ExtWorkFlow> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ExtWorkFlow> findAll(int start, int end,
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

		List<ExtWorkFlow> list = (List<ExtWorkFlow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXTWORKFLOW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTWORKFLOW;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ExtWorkFlow>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ExtWorkFlow>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ext work flows where resourcePrimKey = &#63; and status = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByR_S_ExtWorkflow(long resourcePrimKey, int status,
		long classNameId, long classPK) throws SystemException {
		for (ExtWorkFlow extWorkFlow : findByR_S_ExtWorkflow(resourcePrimKey,
				status, classNameId, classPK)) {
			remove(extWorkFlow);
		}
	}

	/**
	 * Removes the ext work flow where resourcePrimKey = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByworkFlowDetails(long resourcePrimKey, long classNameId,
		long classPK) throws NoSuchExtWorkFlowException, SystemException {
		ExtWorkFlow extWorkFlow = findByworkFlowDetails(resourcePrimKey,
				classNameId, classPK);

		remove(extWorkFlow);
	}

	/**
	 * Removes all the ext work flows from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ExtWorkFlow extWorkFlow : findAll()) {
			remove(extWorkFlow);
		}
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
	public int countByR_S_ExtWorkflow(long resourcePrimKey, int status,
		long classNameId, long classPK) throws SystemException {
		Object[] finderArgs = new Object[] {
				resourcePrimKey, status, classNameId, classPK
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_R_S_EXTWORKFLOW,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EXTWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_RESOURCEPRIMKEY_2);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_STATUS_2);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimKey);

				qPos.add(status);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_R_S_EXTWORKFLOW,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByworkFlowDetails(long resourcePrimKey, long classNameId,
		long classPK) throws SystemException {
		Object[] finderArgs = new Object[] { resourcePrimKey, classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKFLOWDETAILS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EXTWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_WORKFLOWDETAILS_RESOURCEPRIMKEY_2);

			query.append(_FINDER_COLUMN_WORKFLOWDETAILS_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDETAILS_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimKey);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKFLOWDETAILS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ext work flows.
	 *
	 * @return the number of ext work flows
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXTWORKFLOW);

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
	 * Initializes the ext work flow persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.mpower.services.model.ExtWorkFlow")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExtWorkFlow>> listenersList = new ArrayList<ModelListener<ExtWorkFlow>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExtWorkFlow>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExtWorkFlowImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = ExtWorkFlowPersistence.class)
	protected ExtWorkFlowPersistence extWorkFlowPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EXTWORKFLOW = "SELECT extWorkFlow FROM ExtWorkFlow extWorkFlow";
	private static final String _SQL_SELECT_EXTWORKFLOW_WHERE = "SELECT extWorkFlow FROM ExtWorkFlow extWorkFlow WHERE ";
	private static final String _SQL_COUNT_EXTWORKFLOW = "SELECT COUNT(extWorkFlow) FROM ExtWorkFlow extWorkFlow";
	private static final String _SQL_COUNT_EXTWORKFLOW_WHERE = "SELECT COUNT(extWorkFlow) FROM ExtWorkFlow extWorkFlow WHERE ";
	private static final String _FINDER_COLUMN_R_S_EXTWORKFLOW_RESOURCEPRIMKEY_2 =
		"extWorkFlow.resourcePrimKey = ? AND ";
	private static final String _FINDER_COLUMN_R_S_EXTWORKFLOW_STATUS_2 = "extWorkFlow.status = ? AND ";
	private static final String _FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSNAMEID_2 = "extWorkFlow.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_R_S_EXTWORKFLOW_CLASSPK_2 = "extWorkFlow.classPK = ?";
	private static final String _FINDER_COLUMN_WORKFLOWDETAILS_RESOURCEPRIMKEY_2 =
		"extWorkFlow.resourcePrimKey = ? AND ";
	private static final String _FINDER_COLUMN_WORKFLOWDETAILS_CLASSNAMEID_2 = "extWorkFlow.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_WORKFLOWDETAILS_CLASSPK_2 = "extWorkFlow.classPK = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "extWorkFlow.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExtWorkFlow exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExtWorkFlow exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExtWorkFlowPersistenceImpl.class);
	private static ExtWorkFlow _nullExtWorkFlow = new ExtWorkFlowImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExtWorkFlow> toCacheModel() {
				return _nullExtWorkFlowCacheModel;
			}
		};

	private static CacheModel<ExtWorkFlow> _nullExtWorkFlowCacheModel = new CacheModel<ExtWorkFlow>() {
			public ExtWorkFlow toEntityModel() {
				return _nullExtWorkFlow;
			}
		};
}