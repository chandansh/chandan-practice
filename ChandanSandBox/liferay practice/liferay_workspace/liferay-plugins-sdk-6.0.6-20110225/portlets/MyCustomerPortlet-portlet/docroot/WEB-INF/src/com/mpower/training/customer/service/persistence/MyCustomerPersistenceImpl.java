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

package com.mpower.training.customer.service.persistence;

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

import com.mpower.training.customer.NoSuchMyCustomerException;
import com.mpower.training.customer.model.MyCustomer;
import com.mpower.training.customer.model.impl.MyCustomerImpl;
import com.mpower.training.customer.model.impl.MyCustomerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the my customer service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link MyCustomerUtil} to access the my customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyCustomerPersistence
 * @see MyCustomerUtil
 * @generated
 */
public class MyCustomerPersistenceImpl extends BasePersistenceImpl<MyCustomer>
	implements MyCustomerPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = MyCustomerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDADDRESS = new FinderPath(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByNameAndAddress",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDADDRESS = new FinderPath(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByNameAndAddress",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the my customer in the entity cache if it is enabled.
	 *
	 * @param myCustomer the my customer to cache
	 */
	public void cacheResult(MyCustomer myCustomer) {
		EntityCacheUtil.putResult(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerImpl.class, myCustomer.getPrimaryKey(), myCustomer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { myCustomer.getName() }, myCustomer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
			new Object[] { myCustomer.getName(), myCustomer.getAddress() },
			myCustomer);
	}

	/**
	 * Caches the my customers in the entity cache if it is enabled.
	 *
	 * @param myCustomers the my customers to cache
	 */
	public void cacheResult(List<MyCustomer> myCustomers) {
		for (MyCustomer myCustomer : myCustomers) {
			if (EntityCacheUtil.getResult(
						MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
						MyCustomerImpl.class, myCustomer.getPrimaryKey(), this) == null) {
				cacheResult(myCustomer);
			}
		}
	}

	/**
	 * Clears the cache for all my customers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(MyCustomerImpl.class.getName());
		EntityCacheUtil.clearCache(MyCustomerImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the my customer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(MyCustomer myCustomer) {
		EntityCacheUtil.removeResult(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerImpl.class, myCustomer.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { myCustomer.getName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
			new Object[] { myCustomer.getName(), myCustomer.getAddress() });
	}

	/**
	 * Creates a new my customer with the primary key. Does not add the my customer to the database.
	 *
	 * @param id the primary key for the new my customer
	 * @return the new my customer
	 */
	public MyCustomer create(long id) {
		MyCustomer myCustomer = new MyCustomerImpl();

		myCustomer.setNew(true);
		myCustomer.setPrimaryKey(id);

		return myCustomer;
	}

	/**
	 * Removes the my customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my customer to remove
	 * @return the my customer that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a my customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the my customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the my customer to remove
	 * @return the my customer that was removed
	 * @throws com.mpower.training.customer.NoSuchMyCustomerException if a my customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer remove(long id)
		throws NoSuchMyCustomerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MyCustomer myCustomer = (MyCustomer)session.get(MyCustomerImpl.class,
					new Long(id));

			if (myCustomer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
				}

				throw new NoSuchMyCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					id);
			}

			return remove(myCustomer);
		}
		catch (NoSuchMyCustomerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MyCustomer removeImpl(MyCustomer myCustomer)
		throws SystemException {
		myCustomer = toUnwrappedModel(myCustomer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, myCustomer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		MyCustomerModelImpl myCustomerModelImpl = (MyCustomerModelImpl)myCustomer;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { myCustomerModelImpl.getName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
			new Object[] {
				myCustomerModelImpl.getName(),
				
			myCustomerModelImpl.getAddress()
			});

		EntityCacheUtil.removeResult(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerImpl.class, myCustomer.getPrimaryKey());

		return myCustomer;
	}

	public MyCustomer updateImpl(
		com.mpower.training.customer.model.MyCustomer myCustomer, boolean merge)
		throws SystemException {
		myCustomer = toUnwrappedModel(myCustomer);

		boolean isNew = myCustomer.isNew();

		MyCustomerModelImpl myCustomerModelImpl = (MyCustomerModelImpl)myCustomer;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, myCustomer, merge);

			myCustomer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
			MyCustomerImpl.class, myCustomer.getPrimaryKey(), myCustomer);

		if (!isNew &&
				(!Validator.equals(myCustomer.getName(),
					myCustomerModelImpl.getOriginalName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { myCustomerModelImpl.getOriginalName() });
		}

		if (isNew ||
				(!Validator.equals(myCustomer.getName(),
					myCustomerModelImpl.getOriginalName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { myCustomer.getName() }, myCustomer);
		}

		if (!isNew &&
				(!Validator.equals(myCustomer.getName(),
					myCustomerModelImpl.getOriginalName()) ||
				!Validator.equals(myCustomer.getAddress(),
					myCustomerModelImpl.getOriginalAddress()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
				new Object[] {
					myCustomerModelImpl.getOriginalName(),
					
				myCustomerModelImpl.getOriginalAddress()
				});
		}

		if (isNew ||
				(!Validator.equals(myCustomer.getName(),
					myCustomerModelImpl.getOriginalName()) ||
				!Validator.equals(myCustomer.getAddress(),
					myCustomerModelImpl.getOriginalAddress()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
				new Object[] { myCustomer.getName(), myCustomer.getAddress() },
				myCustomer);
		}

		return myCustomer;
	}

	protected MyCustomer toUnwrappedModel(MyCustomer myCustomer) {
		if (myCustomer instanceof MyCustomerImpl) {
			return myCustomer;
		}

		MyCustomerImpl myCustomerImpl = new MyCustomerImpl();

		myCustomerImpl.setNew(myCustomer.isNew());
		myCustomerImpl.setPrimaryKey(myCustomer.getPrimaryKey());

		myCustomerImpl.setId(myCustomer.getId());
		myCustomerImpl.setName(myCustomer.getName());
		myCustomerImpl.setAddress(myCustomer.getAddress());

		return myCustomerImpl;
	}

	/**
	 * Finds the my customer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the my customer to find
	 * @return the my customer
	 * @throws com.liferay.portal.NoSuchModelException if a my customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the my customer with the primary key or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	 *
	 * @param id the primary key of the my customer to find
	 * @return the my customer
	 * @throws com.mpower.training.customer.NoSuchMyCustomerException if a my customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer findByPrimaryKey(long id)
		throws NoSuchMyCustomerException, SystemException {
		MyCustomer myCustomer = fetchByPrimaryKey(id);

		if (myCustomer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchMyCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return myCustomer;
	}

	/**
	 * Finds the my customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my customer to find
	 * @return the my customer, or <code>null</code> if a my customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the my customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the my customer to find
	 * @return the my customer, or <code>null</code> if a my customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer fetchByPrimaryKey(long id) throws SystemException {
		MyCustomer myCustomer = (MyCustomer)EntityCacheUtil.getResult(MyCustomerModelImpl.ENTITY_CACHE_ENABLED,
				MyCustomerImpl.class, id, this);

		if (myCustomer == null) {
			Session session = null;

			try {
				session = openSession();

				myCustomer = (MyCustomer)session.get(MyCustomerImpl.class,
						new Long(id));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (myCustomer != null) {
					cacheResult(myCustomer);
				}

				closeSession(session);
			}
		}

		return myCustomer;
	}

	/**
	 * Finds the my customer where name = &#63; or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	 *
	 * @param name the name to search with
	 * @return the matching my customer
	 * @throws com.mpower.training.customer.NoSuchMyCustomerException if a matching my customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer findByName(String name)
		throws NoSuchMyCustomerException, SystemException {
		MyCustomer myCustomer = fetchByName(name);

		if (myCustomer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMyCustomerException(msg.toString());
		}

		return myCustomer;
	}

	/**
	 * Finds the my customer where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Finds the my customer where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MYCUSTOMER_WHERE);

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

			query.append(MyCustomerModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<MyCustomer> list = q.list();

				result = list;

				MyCustomer myCustomer = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					myCustomer = list.get(0);

					cacheResult(myCustomer);

					if ((myCustomer.getName() == null) ||
							!myCustomer.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, myCustomer);
					}
				}

				return myCustomer;
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
				return (MyCustomer)result;
			}
		}
	}

	/**
	 * Finds the my customer where name = &#63; and address = &#63; or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the matching my customer
	 * @throws com.mpower.training.customer.NoSuchMyCustomerException if a matching my customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer findByNameAndAddress(String name, String address)
		throws NoSuchMyCustomerException, SystemException {
		MyCustomer myCustomer = fetchByNameAndAddress(name, address);

		if (myCustomer == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", address=");
			msg.append(address);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMyCustomerException(msg.toString());
		}

		return myCustomer;
	}

	/**
	 * Finds the my customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer fetchByNameAndAddress(String name, String address)
		throws SystemException {
		return fetchByNameAndAddress(name, address, true);
	}

	/**
	 * Finds the my customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MyCustomer fetchByNameAndAddress(String name, String address,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, address };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MYCUSTOMER_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDADDRESS_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_NAME_2);
				}
			}

			if (address == null) {
				query.append(_FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_2);
				}
			}

			query.append(MyCustomerModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (address != null) {
					qPos.add(address);
				}

				List<MyCustomer> list = q.list();

				result = list;

				MyCustomer myCustomer = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
						finderArgs, list);
				}
				else {
					myCustomer = list.get(0);

					cacheResult(myCustomer);

					if ((myCustomer.getName() == null) ||
							!myCustomer.getName().equals(name) ||
							(myCustomer.getAddress() == null) ||
							!myCustomer.getAddress().equals(address)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
							finderArgs, myCustomer);
					}
				}

				return myCustomer;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
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
				return (MyCustomer)result;
			}
		}
	}

	/**
	 * Finds all the my customers.
	 *
	 * @return the my customers
	 * @throws SystemException if a system exception occurred
	 */
	public List<MyCustomer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the my customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of my customers to return
	 * @param end the upper bound of the range of my customers to return (not inclusive)
	 * @return the range of my customers
	 * @throws SystemException if a system exception occurred
	 */
	public List<MyCustomer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the my customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of my customers to return
	 * @param end the upper bound of the range of my customers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of my customers
	 * @throws SystemException if a system exception occurred
	 */
	public List<MyCustomer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<MyCustomer> list = (List<MyCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MYCUSTOMER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MYCUSTOMER.concat(MyCustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MyCustomer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MyCustomer>)QueryUtil.list(q, getDialect(),
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
	 * Removes the my customer where name = &#63; from the database.
	 *
	 * @param name the name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name)
		throws NoSuchMyCustomerException, SystemException {
		MyCustomer myCustomer = findByName(name);

		remove(myCustomer);
	}

	/**
	 * Removes the my customer where name = &#63; and address = &#63; from the database.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNameAndAddress(String name, String address)
		throws NoSuchMyCustomerException, SystemException {
		MyCustomer myCustomer = findByNameAndAddress(name, address);

		remove(myCustomer);
	}

	/**
	 * Removes all the my customers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MyCustomer myCustomer : findAll()) {
			remove(myCustomer);
		}
	}

	/**
	 * Counts all the my customers where name = &#63;.
	 *
	 * @param name the name to search with
	 * @return the number of matching my customers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MYCUSTOMER_WHERE);

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
	 * Counts all the my customers where name = &#63; and address = &#63;.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the number of matching my customers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNameAndAddress(String name, String address)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, address };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAMEANDADDRESS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MYCUSTOMER_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDADDRESS_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_NAME_2);
				}
			}

			if (address == null) {
				query.append(_FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_2);
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

				if (address != null) {
					qPos.add(address);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDADDRESS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the my customers.
	 *
	 * @return the number of my customers
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

				Query q = session.createQuery(_SQL_COUNT_MYCUSTOMER);

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
	 * Initializes the my customer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.mpower.training.customer.model.MyCustomer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MyCustomer>> listenersList = new ArrayList<ModelListener<MyCustomer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MyCustomer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MyCustomerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = MyCustomerPersistence.class)
	protected MyCustomerPersistence myCustomerPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MYCUSTOMER = "SELECT myCustomer FROM MyCustomer myCustomer";
	private static final String _SQL_SELECT_MYCUSTOMER_WHERE = "SELECT myCustomer FROM MyCustomer myCustomer WHERE ";
	private static final String _SQL_COUNT_MYCUSTOMER = "SELECT COUNT(myCustomer) FROM MyCustomer myCustomer";
	private static final String _SQL_COUNT_MYCUSTOMER_WHERE = "SELECT COUNT(myCustomer) FROM MyCustomer myCustomer WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "myCustomer.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "myCustomer.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(myCustomer.name IS NULL OR myCustomer.name = ?)";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_NAME_1 = "myCustomer.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_NAME_2 = "myCustomer.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_NAME_3 = "(myCustomer.name IS NULL OR myCustomer.name = ?) AND ";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_1 = "myCustomer.address IS NULL";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_2 = "myCustomer.address = ?";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_3 = "(myCustomer.address IS NULL OR myCustomer.address = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "myCustomer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MyCustomer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MyCustomer exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(MyCustomerPersistenceImpl.class);
}