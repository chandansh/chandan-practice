/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.mpower.training.order.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.mpower.training.order.NoSuchMyOrderException;
import com.mpower.training.order.model.MyOrder;
import com.mpower.training.order.model.impl.MyOrderImpl;
import com.mpower.training.order.model.impl.MyOrderModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the my order service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link MyOrderUtil} to access the my order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyOrderPersistence
 * @see MyOrderUtil
 * @generated
 */
public class MyOrderPersistenceImpl extends BasePersistenceImpl<MyOrder>
	implements MyOrderPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = MyOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_IDANDNAME = new FinderPath(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByIdAndName",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_IDANDNAME = new FinderPath(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByIdAndName",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the my order in the entity cache if it is enabled.
	 *
	 * @param myOrder the my order to cache
	 */
	public void cacheResult(MyOrder myOrder) {
		EntityCacheUtil.putResult(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderImpl.class, myOrder.getPrimaryKey(), myOrder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { myOrder.getName() }, myOrder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDNAME,
			new Object[] { new Long(myOrder.getId()), myOrder.getName() },
			myOrder);
	}

	/**
	 * Caches the my orders in the entity cache if it is enabled.
	 *
	 * @param myOrders the my orders to cache
	 */
	public void cacheResult(List<MyOrder> myOrders) {
		for (MyOrder myOrder : myOrders) {
			if (EntityCacheUtil.getResult(
						MyOrderModelImpl.ENTITY_CACHE_ENABLED,
						MyOrderImpl.class, myOrder.getPrimaryKey(), this) == null) {
				cacheResult(myOrder);
			}
		}
	}

	/**
	 * Clears the cache for all my orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(MyOrderImpl.class.getName());
		EntityCacheUtil.clearCache(MyOrderImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the my order.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(MyOrder myOrder) {
		EntityCacheUtil.removeResult(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderImpl.class, myOrder.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { myOrder.getName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDNAME,
			new Object[] { new Long(myOrder.getId()), myOrder.getName() });
	}

	/**
	 * Creates a new my order with the primary key. Does not add the my order to the database.
	 *
	 * @param id the primary key for the new my order
	 * @return the new my order
	 */
	public MyOrder create(long id) {
		MyOrder myOrder = new MyOrderImpl();

		myOrder.setNew(true);
		myOrder.setPrimaryKey(id);

		return myOrder;
	}

	/**
	 * Removes the my order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my order to remove
	 * @return the my order that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a my order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the my order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the my order to remove
	 * @return the my order that was removed
	 * @throws com.mpower.training.order.NoSuchMyOrderException if a my order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder remove(long id)
		throws NoSuchMyOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MyOrder myOrder = (MyOrder)session.get(MyOrderImpl.class,
					new Long(id));

			if (myOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
				}

				throw new NoSuchMyOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					id);
			}

			return remove(myOrder);
		}
		catch (NoSuchMyOrderException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MyOrder removeImpl(MyOrder myOrder) throws SystemException {
		myOrder = toUnwrappedModel(myOrder);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, myOrder);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		MyOrderModelImpl myOrderModelImpl = (MyOrderModelImpl)myOrder;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { myOrderModelImpl.getName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDNAME,
			new Object[] {
				new Long(myOrderModelImpl.getId()),
				
			myOrderModelImpl.getName()
			});

		EntityCacheUtil.removeResult(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderImpl.class, myOrder.getPrimaryKey());

		return myOrder;
	}

	public MyOrder updateImpl(com.mpower.training.order.model.MyOrder myOrder,
		boolean merge) throws SystemException {
		myOrder = toUnwrappedModel(myOrder);

		boolean isNew = myOrder.isNew();

		MyOrderModelImpl myOrderModelImpl = (MyOrderModelImpl)myOrder;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, myOrder, merge);

			myOrder.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
			MyOrderImpl.class, myOrder.getPrimaryKey(), myOrder);

		if (!isNew &&
				(!Validator.equals(myOrder.getName(),
					myOrderModelImpl.getOriginalName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { myOrderModelImpl.getOriginalName() });
		}

		if (isNew ||
				(!Validator.equals(myOrder.getName(),
					myOrderModelImpl.getOriginalName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { myOrder.getName() }, myOrder);
		}

		if (!isNew &&
				((myOrder.getId() != myOrderModelImpl.getOriginalId()) ||
				!Validator.equals(myOrder.getName(),
					myOrderModelImpl.getOriginalName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDNAME,
				new Object[] {
					new Long(myOrderModelImpl.getOriginalId()),
					
				myOrderModelImpl.getOriginalName()
				});
		}

		if (isNew ||
				((myOrder.getId() != myOrderModelImpl.getOriginalId()) ||
				!Validator.equals(myOrder.getName(),
					myOrderModelImpl.getOriginalName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDNAME,
				new Object[] { new Long(myOrder.getId()), myOrder.getName() },
				myOrder);
		}

		return myOrder;
	}

	protected MyOrder toUnwrappedModel(MyOrder myOrder) {
		if (myOrder instanceof MyOrderImpl) {
			return myOrder;
		}

		MyOrderImpl myOrderImpl = new MyOrderImpl();

		myOrderImpl.setNew(myOrder.isNew());
		myOrderImpl.setPrimaryKey(myOrder.getPrimaryKey());

		myOrderImpl.setId(myOrder.getId());
		myOrderImpl.setName(myOrder.getName());
		myOrderImpl.setDescription(myOrder.getDescription());

		return myOrderImpl;
	}

	/**
	 * Finds the my order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the my order to find
	 * @return the my order
	 * @throws com.liferay.portal.NoSuchModelException if a my order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the my order with the primary key or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	 *
	 * @param id the primary key of the my order to find
	 * @return the my order
	 * @throws com.mpower.training.order.NoSuchMyOrderException if a my order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder findByPrimaryKey(long id)
		throws NoSuchMyOrderException, SystemException {
		MyOrder myOrder = fetchByPrimaryKey(id);

		if (myOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchMyOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return myOrder;
	}

	/**
	 * Finds the my order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my order to find
	 * @return the my order, or <code>null</code> if a my order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the my order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the my order to find
	 * @return the my order, or <code>null</code> if a my order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder fetchByPrimaryKey(long id) throws SystemException {
		MyOrder myOrder = (MyOrder)EntityCacheUtil.getResult(MyOrderModelImpl.ENTITY_CACHE_ENABLED,
				MyOrderImpl.class, id, this);

		if (myOrder == null) {
			Session session = null;

			try {
				session = openSession();

				myOrder = (MyOrder)session.get(MyOrderImpl.class, new Long(id));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (myOrder != null) {
					cacheResult(myOrder);
				}

				closeSession(session);
			}
		}

		return myOrder;
	}

	/**
	 * Finds the my order where name = &#63; or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	 *
	 * @param name the name to search with
	 * @return the matching my order
	 * @throws com.mpower.training.order.NoSuchMyOrderException if a matching my order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder findByName(String name)
		throws NoSuchMyOrderException, SystemException {
		MyOrder myOrder = fetchByName(name);

		if (myOrder == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMyOrderException(msg.toString());
		}

		return myOrder;
	}

	/**
	 * Finds the my order where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching my order, or <code>null</code> if a matching my order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Finds the my order where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching my order, or <code>null</code> if a matching my order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MYORDER_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			query.append(MyOrderModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<MyOrder> list = q.list();

				result = list;

				MyOrder myOrder = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					myOrder = list.get(0);

					cacheResult(myOrder);

					if ((myOrder.getName() == null) ||
							!myOrder.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, myOrder);
					}
				}

				return myOrder;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
				return (MyOrder)result;
			}
		}
	}

	/**
	 * Finds the my order where id = &#63; and name = &#63; or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	 *
	 * @param id the id to search with
	 * @param name the name to search with
	 * @return the matching my order
	 * @throws com.mpower.training.order.NoSuchMyOrderException if a matching my order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder findByIdAndName(long id, String name)
		throws NoSuchMyOrderException, SystemException {
		MyOrder myOrder = fetchByIdAndName(id, name);

		if (myOrder == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMyOrderException(msg.toString());
		}

		return myOrder;
	}

	/**
	 * Finds the my order where id = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the id to search with
	 * @param name the name to search with
	 * @return the matching my order, or <code>null</code> if a matching my order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder fetchByIdAndName(long id, String name)
		throws SystemException {
		return fetchByIdAndName(id, name, true);
	}

	/**
	 * Finds the my order where id = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the id to search with
	 * @param name the name to search with
	 * @return the matching my order, or <code>null</code> if a matching my order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyOrder fetchByIdAndName(long id, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { id, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDANDNAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MYORDER_WHERE);

			query.append(_FINDER_COLUMN_IDANDNAME_ID_2);

			if (name == null) {
				query.append(_FINDER_COLUMN_IDANDNAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_IDANDNAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_IDANDNAME_NAME_2);
				}
			}

			query.append(MyOrderModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				if (name != null) {
					qPos.add(name);
				}

				List<MyOrder> list = q.list();

				result = list;

				MyOrder myOrder = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDNAME,
						finderArgs, list);
				}
				else {
					myOrder = list.get(0);

					cacheResult(myOrder);

					if ((myOrder.getId() != id) || (myOrder.getName() == null) ||
							!myOrder.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDNAME,
							finderArgs, myOrder);
					}
				}

				return myOrder;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDNAME,
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
				return (MyOrder)result;
			}
		}
	}

	/**
	 * Finds all the my orders.
	 *
	 * @return the my orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<MyOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the my orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of my orders to return
	 * @param end the upper bound of the range of my orders to return (not inclusive)
	 * @return the range of my orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<MyOrder> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the my orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of my orders to return
	 * @param end the upper bound of the range of my orders to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of my orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<MyOrder> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<MyOrder> list = (List<MyOrder>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MYORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MYORDER.concat(MyOrderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MyOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MyOrder>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the my order where name = &#63; from the database.
	 *
	 * @param name the name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name)
		throws NoSuchMyOrderException, SystemException {
		MyOrder myOrder = findByName(name);

		remove(myOrder);
	}

	/**
	 * Removes the my order where id = &#63; and name = &#63; from the database.
	 *
	 * @param id the id to search with
	 * @param name the name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIdAndName(long id, String name)
		throws NoSuchMyOrderException, SystemException {
		MyOrder myOrder = findByIdAndName(id, name);

		remove(myOrder);
	}

	/**
	 * Removes all the my orders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MyOrder myOrder : findAll()) {
			remove(myOrder);
		}
	}

	/**
	 * Counts all the my orders where name = &#63;.
	 *
	 * @param name the name to search with
	 * @return the number of matching my orders
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MYORDER_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the my orders where id = &#63; and name = &#63;.
	 *
	 * @param id the id to search with
	 * @param name the name to search with
	 * @return the number of matching my orders
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIdAndName(long id, String name) throws SystemException {
		Object[] finderArgs = new Object[] { id, name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IDANDNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MYORDER_WHERE);

			query.append(_FINDER_COLUMN_IDANDNAME_ID_2);

			if (name == null) {
				query.append(_FINDER_COLUMN_IDANDNAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_IDANDNAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_IDANDNAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDANDNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the my orders.
	 *
	 * @return the number of my orders
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

				Query q = session.createQuery(_SQL_COUNT_MYORDER);

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
	 * Initializes the my order persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.mpower.training.order.model.MyOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MyOrder>> listenersList = new ArrayList<ModelListener<MyOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MyOrder>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MyOrderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = MyOrderPersistence.class)
	protected MyOrderPersistence myOrderPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MYORDER = "SELECT myOrder FROM MyOrder myOrder";
	private static final String _SQL_SELECT_MYORDER_WHERE = "SELECT myOrder FROM MyOrder myOrder WHERE ";
	private static final String _SQL_COUNT_MYORDER = "SELECT COUNT(myOrder) FROM MyOrder myOrder";
	private static final String _SQL_COUNT_MYORDER_WHERE = "SELECT COUNT(myOrder) FROM MyOrder myOrder WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "myOrder.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "myOrder.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(myOrder.name IS NULL OR myOrder.name = ?)";
	private static final String _FINDER_COLUMN_IDANDNAME_ID_2 = "myOrder.id = ? AND ";
	private static final String _FINDER_COLUMN_IDANDNAME_NAME_1 = "myOrder.name IS NULL";
	private static final String _FINDER_COLUMN_IDANDNAME_NAME_2 = "myOrder.name = ?";
	private static final String _FINDER_COLUMN_IDANDNAME_NAME_3 = "(myOrder.name IS NULL OR myOrder.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "myOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MyOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MyOrder exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(MyOrderPersistenceImpl.class);
}