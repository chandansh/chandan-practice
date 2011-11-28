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

import com.coleg.NoSuchFooException;

import com.coleg.model.Foo;
import com.coleg.model.impl.FooImpl;
import com.coleg.model.impl.FooModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the foo service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link FooUtil} to access the foo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author supriya
 * @see FooPersistence
 * @see FooUtil
 * @generated
 */
public class FooPersistenceImpl extends BasePersistenceImpl<Foo>
	implements FooPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = FooImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_FIELD2 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByField2",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELD2 = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByField2", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the foo in the entity cache if it is enabled.
	 *
	 * @param foo the foo to cache
	 */
	@Override
	public void cacheResult(Foo foo) {
		EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooImpl.class, foo.getPrimaryKey(), foo);
	}

	/**
	 * Caches the foos in the entity cache if it is enabled.
	 *
	 * @param foos the foos to cache
	 */
	@Override
	public void cacheResult(List<Foo> foos) {
		for (Foo foo : foos) {
			if (EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
						FooImpl.class, foo.getPrimaryKey(), this) == null) {
				cacheResult(foo);
			}
		}
	}

	/**
	 * Clears the cache for all foos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		CacheRegistryUtil.clear(FooImpl.class.getName());
		EntityCacheUtil.clearCache(FooImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the foo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Foo foo) {
		EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooImpl.class, foo.getPrimaryKey());
	}

	/**
	 * Creates a new foo with the primary key. Does not add the foo to the database.
	 *
	 * @param fooId the primary key for the new foo
	 * @return the new foo
	 */
	@Override
	public Foo create(long fooId) {
		Foo foo = new FooImpl();

		foo.setNew(true);
		foo.setPrimaryKey(fooId);

		return foo;
	}

	/**
	 * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the foo to remove
	 * @return the foo that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the foo to remove
	 * @return the foo that was removed
	 * @throws com.coleg.NoSuchFooException if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo remove(long fooId) throws NoSuchFooException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Foo foo = (Foo)session.get(FooImpl.class, new Long(fooId));

			if (foo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + fooId);
				}

				throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					fooId);
			}

			return remove(foo);
		}
		catch (NoSuchFooException nsee) {
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
	protected Foo removeImpl(Foo foo) throws SystemException {
		foo = toUnwrappedModel(foo);

		Session session = null;

		try {
			session = openSession();

			if (foo.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(FooImpl.class,
						foo.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(foo);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooImpl.class, foo.getPrimaryKey());

		return foo;
	}

	@Override
	public Foo updateImpl(com.coleg.model.Foo foo, boolean merge)
		throws SystemException {
		foo = toUnwrappedModel(foo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, foo, merge);

			foo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
			FooImpl.class, foo.getPrimaryKey(), foo);

		return foo;
	}

	protected Foo toUnwrappedModel(Foo foo) {
		if (foo instanceof FooImpl) {
			return foo;
		}

		FooImpl fooImpl = new FooImpl();

		fooImpl.setNew(foo.isNew());
		fooImpl.setPrimaryKey(foo.getPrimaryKey());

		fooImpl.setFooId(foo.getFooId());
		fooImpl.setCompanyId(foo.getCompanyId());
		fooImpl.setUserId(foo.getUserId());
		fooImpl.setUserName(foo.getUserName());
		fooImpl.setCreateDate(foo.getCreateDate());
		fooImpl.setModifiedDate(foo.getModifiedDate());
		fooImpl.setField1(foo.getField1());
		fooImpl.setField2(foo.isField2());
		fooImpl.setField3(foo.getField3());
		fooImpl.setField4(foo.getField4());
		fooImpl.setField5(foo.getField5());

		return fooImpl;
	}

	/**
	 * Finds the foo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the foo to find
	 * @return the foo
	 * @throws com.liferay.portal.NoSuchModelException if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the foo with the primary key or throws a {@link com.coleg.NoSuchFooException} if it could not be found.
	 *
	 * @param fooId the primary key of the foo to find
	 * @return the foo
	 * @throws com.coleg.NoSuchFooException if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo findByPrimaryKey(long fooId)
		throws NoSuchFooException, SystemException {
		Foo foo = fetchByPrimaryKey(fooId);

		if (foo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + fooId);
			}

			throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				fooId);
		}

		return foo;
	}

	/**
	 * Finds the foo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the foo to find
	 * @return the foo, or <code>null</code> if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the foo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the foo to find
	 * @return the foo, or <code>null</code> if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo fetchByPrimaryKey(long fooId) throws SystemException {
		Foo foo = (Foo)EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
				FooImpl.class, fooId, this);

		if (foo == null) {
			Session session = null;

			try {
				session = openSession();

				foo = (Foo)session.get(FooImpl.class, new Long(fooId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (foo != null) {
					cacheResult(foo);
				}

				closeSession(session);
			}
		}

		return foo;
	}

	/**
	 * Finds all the foos where field2 = &#63;.
	 *
	 * @param field2 the field2 to search with
	 * @return the matching foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Foo> findByField2(boolean field2) throws SystemException {
		return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the foos where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param field2 the field2 to search with
	 * @param start the lower bound of the range of foos to return
	 * @param end the upper bound of the range of foos to return (not inclusive)
	 * @return the range of matching foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Foo> findByField2(boolean field2, int start, int end)
		throws SystemException {
		return findByField2(field2, start, end, null);
	}

	/**
	 * Finds an ordered range of all the foos where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param field2 the field2 to search with
	 * @param start the lower bound of the range of foos to return
	 * @param end the upper bound of the range of foos to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Foo> findByField2(boolean field2, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				field2,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Foo> list = (List<Foo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIELD2,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_FOO_WHERE);

				query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(FooModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				list = (List<Foo>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Foo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIELD2,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first foo in the ordered set where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param field2 the field2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching foo
	 * @throws com.coleg.NoSuchFooException if a matching foo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo findByField2_First(boolean field2,
		OrderByComparator orderByComparator)
		throws NoSuchFooException, SystemException {
		List<Foo> list = findByField2(field2, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("field2=");
			msg.append(field2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFooException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last foo in the ordered set where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param field2 the field2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching foo
	 * @throws com.coleg.NoSuchFooException if a matching foo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo findByField2_Last(boolean field2,
		OrderByComparator orderByComparator)
		throws NoSuchFooException, SystemException {
		int count = countByField2(field2);

		List<Foo> list = findByField2(field2, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("field2=");
			msg.append(field2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFooException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the foos before and after the current foo in the ordered set where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fooId the primary key of the current foo
	 * @param field2 the field2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next foo
	 * @throws com.coleg.NoSuchFooException if a foo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Foo[] findByField2_PrevAndNext(long fooId, boolean field2,
		OrderByComparator orderByComparator)
		throws NoSuchFooException, SystemException {
		Foo foo = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			Foo[] array = new FooImpl[3];

			array[0] = getByField2_PrevAndNext(session, foo, field2,
					orderByComparator, true);

			array[1] = foo;

			array[2] = getByField2_PrevAndNext(session, foo, field2,
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

	protected Foo getByField2_PrevAndNext(Session session, Foo foo,
		boolean field2, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FOO_WHERE);

		query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
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

		else {
			query.append(FooModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(field2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(foo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Foo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the foos.
	 *
	 * @return the foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Foo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the foos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of foos to return
	 * @param end the upper bound of the range of foos to return (not inclusive)
	 * @return the range of foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Foo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the foos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of foos to return
	 * @param end the upper bound of the range of foos to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Foo> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Foo> list = (List<Foo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_FOO);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_FOO.concat(FooModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Foo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Foo>)QueryUtil.list(q, getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Foo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the foos where field2 = &#63; from the database.
	 *
	 * @param field2 the field2 to search with
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByField2(boolean field2) throws SystemException {
		for (Foo foo : findByField2(field2)) {
			remove(foo);
		}
	}

	/**
	 * Removes all the foos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Foo foo : findAll()) {
			remove(foo);
		}
	}

	/**
	 * Counts all the foos where field2 = &#63;.
	 *
	 * @param field2 the field2 to search with
	 * @return the number of matching foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByField2(boolean field2) throws SystemException {
		Object[] finderArgs = new Object[] { field2 };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIELD2,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_FOO_WHERE);

				query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELD2,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the foos.
	 *
	 * @return the number of foos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FOO);

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
	 * Initializes the foo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.coleg.model.Foo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Foo>> listenersList = new ArrayList<ModelListener<Foo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Foo>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = FooPersistence.class)
	protected FooPersistence fooPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FOO = "SELECT foo FROM Foo foo";
	private static final String _SQL_SELECT_FOO_WHERE = "SELECT foo FROM Foo foo WHERE ";
	private static final String _SQL_COUNT_FOO = "SELECT COUNT(foo) FROM Foo foo";
	private static final String _SQL_COUNT_FOO_WHERE = "SELECT COUNT(foo) FROM Foo foo WHERE ";
	private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 = "foo.field2 = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "foo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Foo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Foo exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(FooPersistenceImpl.class);
}