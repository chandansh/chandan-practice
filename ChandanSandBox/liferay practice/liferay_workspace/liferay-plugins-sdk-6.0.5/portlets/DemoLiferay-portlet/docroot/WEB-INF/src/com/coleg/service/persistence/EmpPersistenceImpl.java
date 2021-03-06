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

package com.coleg.service.persistence;

import com.coleg.NoSuchEmpException;

import com.coleg.model.Emp;
import com.coleg.model.impl.EmpImpl;
import com.coleg.model.impl.EmpModelImpl;

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
 * The persistence implementation for the emp service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link EmpUtil} to access the emp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chandan
 * @see EmpPersistence
 * @see EmpUtil
 * @generated
 */
public class EmpPersistenceImpl extends BasePersistenceImpl<Emp>
	implements EmpPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = EmpImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the emp in the entity cache if it is enabled.
	 *
	 * @param emp the emp to cache
	 */
	public void cacheResult(Emp emp) {
		EntityCacheUtil.putResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey(), emp);
	}

	/**
	 * Caches the emps in the entity cache if it is enabled.
	 *
	 * @param emps the emps to cache
	 */
	public void cacheResult(List<Emp> emps) {
		for (Emp emp : emps) {
			if (EntityCacheUtil.getResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
						EmpImpl.class, emp.getPrimaryKey(), this) == null) {
				cacheResult(emp);
			}
		}
	}

	/**
	 * Clears the cache for all emps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(EmpImpl.class.getName());
		EntityCacheUtil.clearCache(EmpImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the emp.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Emp emp) {
		EntityCacheUtil.removeResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey());
	}

	/**
	 * Creates a new emp with the primary key. Does not add the emp to the database.
	 *
	 * @param empId the primary key for the new emp
	 * @return the new emp
	 */
	public Emp create(String empId) {
		Emp emp = new EmpImpl();

		emp.setNew(true);
		emp.setPrimaryKey(empId);

		return emp;
	}

	/**
	 * Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp to remove
	 * @return the emp that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Emp remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove((String)primaryKey);
	}

	/**
	 * Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empId the primary key of the emp to remove
	 * @return the emp that was removed
	 * @throws com.coleg.NoSuchEmpException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Emp remove(String empId) throws NoSuchEmpException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Emp emp = (Emp)session.get(EmpImpl.class, empId);

			if (emp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + empId);
				}

				throw new NoSuchEmpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					empId);
			}

			return remove(emp);
		}
		catch (NoSuchEmpException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Emp removeImpl(Emp emp) throws SystemException {
		emp = toUnwrappedModel(emp);

		Session session = null;

		try {
			session = openSession();

			if (emp.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(EmpImpl.class,
						emp.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(emp);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey());

		return emp;
	}

	public Emp updateImpl(com.coleg.model.Emp emp, boolean merge)
		throws SystemException {
		emp = toUnwrappedModel(emp);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, emp, merge);

			emp.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey(), emp);

		return emp;
	}

	protected Emp toUnwrappedModel(Emp emp) {
		if (emp instanceof EmpImpl) {
			return emp;
		}

		EmpImpl empImpl = new EmpImpl();

		empImpl.setNew(emp.isNew());
		empImpl.setPrimaryKey(emp.getPrimaryKey());

		empImpl.setEmpId(emp.getEmpId());
		empImpl.setUname(emp.getUname());
		empImpl.setAddress(emp.getAddress());

		return empImpl;
	}

	/**
	 * Finds the emp with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp to find
	 * @return the emp
	 * @throws com.liferay.portal.NoSuchModelException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Emp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Finds the emp with the primary key or throws a {@link com.coleg.NoSuchEmpException} if it could not be found.
	 *
	 * @param empId the primary key of the emp to find
	 * @return the emp
	 * @throws com.coleg.NoSuchEmpException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Emp findByPrimaryKey(String empId)
		throws NoSuchEmpException, SystemException {
		Emp emp = fetchByPrimaryKey(empId);

		if (emp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + empId);
			}

			throw new NoSuchEmpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				empId);
		}

		return emp;
	}

	/**
	 * Finds the emp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp to find
	 * @return the emp, or <code>null</code> if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Emp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Finds the emp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empId the primary key of the emp to find
	 * @return the emp, or <code>null</code> if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Emp fetchByPrimaryKey(String empId) throws SystemException {
		Emp emp = (Emp)EntityCacheUtil.getResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
				EmpImpl.class, empId, this);

		if (emp == null) {
			Session session = null;

			try {
				session = openSession();

				emp = (Emp)session.get(EmpImpl.class, empId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (emp != null) {
					cacheResult(emp);
				}

				closeSession(session);
			}
		}

		return emp;
	}

	/**
	 * Finds all the emps.
	 *
	 * @return the emps
	 * @throws SystemException if a system exception occurred
	 */
	public List<Emp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps to return
	 * @param end the upper bound of the range of emps to return (not inclusive)
	 * @return the range of emps
	 * @throws SystemException if a system exception occurred
	 */
	public List<Emp> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps to return
	 * @param end the upper bound of the range of emps to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of emps
	 * @throws SystemException if a system exception occurred
	 */
	public List<Emp> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Emp> list = (List<Emp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_EMP);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_EMP;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Emp>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Emp>)QueryUtil.list(q, getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Emp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the emps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Emp emp : findAll()) {
			remove(emp);
		}
	}

	/**
	 * Counts all the emps.
	 *
	 * @return the number of emps
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

				Query q = session.createQuery(_SQL_COUNT_EMP);

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
	 * Initializes the emp persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.coleg.model.Emp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Emp>> listenersList = new ArrayList<ModelListener<Emp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Emp>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = EmpPersistence.class)
	protected EmpPersistence empPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EMP = "SELECT emp FROM Emp emp";
	private static final String _SQL_COUNT_EMP = "SELECT COUNT(emp) FROM Emp emp";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Emp exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(EmpPersistenceImpl.class);
}