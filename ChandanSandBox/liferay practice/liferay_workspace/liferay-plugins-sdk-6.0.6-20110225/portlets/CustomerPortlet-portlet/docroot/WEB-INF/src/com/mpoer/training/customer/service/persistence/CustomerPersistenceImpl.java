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

package com.mpoer.training.customer.service.persistence;

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

import com.mpoer.training.customer.NoSuchCustomerException;
import com.mpoer.training.customer.model.Customer;
import com.mpoer.training.customer.model.impl.CustomerImpl;
import com.mpoer.training.customer.model.impl.CustomerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the customer service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link CustomerUtil} to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerPersistence
 * @see CustomerUtil
 * @generated
 */
public class CustomerPersistenceImpl extends BasePersistenceImpl<Customer>
	implements CustomerPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CustomerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDADDRESS = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByNameAndAddress",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDADDRESS = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByNameAndAddress",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer to cache
	 */
	public void cacheResult(Customer customer) {
		EntityCacheUtil.putResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImpl.class, customer.getPrimaryKey(), customer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { customer.getName() }, customer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
			new Object[] { customer.getName(), customer.getAddress() }, customer);
	}

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers to cache
	 */
	public void cacheResult(List<Customer> customers) {
		for (Customer customer : customers) {
			if (EntityCacheUtil.getResult(
						CustomerModelImpl.ENTITY_CACHE_ENABLED,
						CustomerImpl.class, customer.getPrimaryKey(), this) == null) {
				cacheResult(customer);
			}
		}
	}

	/**
	 * Clears the cache for all customers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(CustomerImpl.class.getName());
		EntityCacheUtil.clearCache(CustomerImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the customer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Customer customer) {
		EntityCacheUtil.removeResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImpl.class, customer.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { customer.getName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
			new Object[] { customer.getName(), customer.getAddress() });
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param id the primary key for the new customer
	 * @return the new customer
	 */
	public Customer create(long id) {
		Customer customer = new CustomerImpl();

		customer.setNew(true);
		customer.setPrimaryKey(id);

		return customer;
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer to remove
	 * @return the customer that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the customer to remove
	 * @return the customer that was removed
	 * @throws com.mpoer.training.customer.NoSuchCustomerException if a customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer remove(long id)
		throws NoSuchCustomerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Customer customer = (Customer)session.get(CustomerImpl.class,
					new Long(id));

			if (customer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
				}

				throw new NoSuchCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					id);
			}

			return remove(customer);
		}
		catch (NoSuchCustomerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Customer removeImpl(Customer customer) throws SystemException {
		customer = toUnwrappedModel(customer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, customer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		CustomerModelImpl customerModelImpl = (CustomerModelImpl)customer;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { customerModelImpl.getName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
			new Object[] {
				customerModelImpl.getName(),
				
			customerModelImpl.getAddress()
			});

		EntityCacheUtil.removeResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImpl.class, customer.getPrimaryKey());

		return customer;
	}

	public Customer updateImpl(
		com.mpoer.training.customer.model.Customer customer, boolean merge)
		throws SystemException {
		customer = toUnwrappedModel(customer);

		boolean isNew = customer.isNew();

		CustomerModelImpl customerModelImpl = (CustomerModelImpl)customer;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, customer, merge);

			customer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImpl.class, customer.getPrimaryKey(), customer);

		if (!isNew &&
				(!Validator.equals(customer.getName(),
					customerModelImpl.getOriginalName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { customerModelImpl.getOriginalName() });
		}

		if (isNew ||
				(!Validator.equals(customer.getName(),
					customerModelImpl.getOriginalName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { customer.getName() }, customer);
		}

		if (!isNew &&
				(!Validator.equals(customer.getName(),
					customerModelImpl.getOriginalName()) ||
				!Validator.equals(customer.getAddress(),
					customerModelImpl.getOriginalAddress()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
				new Object[] {
					customerModelImpl.getOriginalName(),
					
				customerModelImpl.getOriginalAddress()
				});
		}

		if (isNew ||
				(!Validator.equals(customer.getName(),
					customerModelImpl.getOriginalName()) ||
				!Validator.equals(customer.getAddress(),
					customerModelImpl.getOriginalAddress()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
				new Object[] { customer.getName(), customer.getAddress() },
				customer);
		}

		return customer;
	}

	protected Customer toUnwrappedModel(Customer customer) {
		if (customer instanceof CustomerImpl) {
			return customer;
		}

		CustomerImpl customerImpl = new CustomerImpl();

		customerImpl.setNew(customer.isNew());
		customerImpl.setPrimaryKey(customer.getPrimaryKey());

		customerImpl.setId(customer.getId());
		customerImpl.setName(customer.getName());
		customerImpl.setAddress(customer.getAddress());
		customerImpl.setInductionDate(customer.getInductionDate());

		return customerImpl;
	}

	/**
	 * Finds the customer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer to find
	 * @return the customer
	 * @throws com.liferay.portal.NoSuchModelException if a customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the customer with the primary key or throws a {@link com.mpoer.training.customer.NoSuchCustomerException} if it could not be found.
	 *
	 * @param id the primary key of the customer to find
	 * @return the customer
	 * @throws com.mpoer.training.customer.NoSuchCustomerException if a customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer findByPrimaryKey(long id)
		throws NoSuchCustomerException, SystemException {
		Customer customer = fetchByPrimaryKey(id);

		if (customer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return customer;
	}

	/**
	 * Finds the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer to find
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the customer to find
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer fetchByPrimaryKey(long id) throws SystemException {
		Customer customer = (Customer)EntityCacheUtil.getResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
				CustomerImpl.class, id, this);

		if (customer == null) {
			Session session = null;

			try {
				session = openSession();

				customer = (Customer)session.get(CustomerImpl.class,
						new Long(id));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (customer != null) {
					cacheResult(customer);
				}

				closeSession(session);
			}
		}

		return customer;
	}

	/**
	 * Finds the customer where name = &#63; or throws a {@link com.mpoer.training.customer.NoSuchCustomerException} if it could not be found.
	 *
	 * @param name the name to search with
	 * @return the matching customer
	 * @throws com.mpoer.training.customer.NoSuchCustomerException if a matching customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer findByName(String name)
		throws NoSuchCustomerException, SystemException {
		Customer customer = fetchByName(name);

		if (customer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCustomerException(msg.toString());
		}

		return customer;
	}

	/**
	 * Finds the customer where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching customer, or <code>null</code> if a matching customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Finds the customer where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching customer, or <code>null</code> if a matching customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CUSTOMER_WHERE);

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

			query.append(CustomerModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<Customer> list = q.list();

				result = list;

				Customer customer = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					customer = list.get(0);

					cacheResult(customer);

					if ((customer.getName() == null) ||
							!customer.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, customer);
					}
				}

				return customer;
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
				return (Customer)result;
			}
		}
	}

	/**
	 * Finds the customer where name = &#63; and address = &#63; or throws a {@link com.mpoer.training.customer.NoSuchCustomerException} if it could not be found.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the matching customer
	 * @throws com.mpoer.training.customer.NoSuchCustomerException if a matching customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer findByNameAndAddress(String name, String address)
		throws NoSuchCustomerException, SystemException {
		Customer customer = fetchByNameAndAddress(name, address);

		if (customer == null) {
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

			throw new NoSuchCustomerException(msg.toString());
		}

		return customer;
	}

	/**
	 * Finds the customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the matching customer, or <code>null</code> if a matching customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer fetchByNameAndAddress(String name, String address)
		throws SystemException {
		return fetchByNameAndAddress(name, address, true);
	}

	/**
	 * Finds the customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the matching customer, or <code>null</code> if a matching customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Customer fetchByNameAndAddress(String name, String address,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, address };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CUSTOMER_WHERE);

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

			query.append(CustomerModelImpl.ORDER_BY_JPQL);

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

				List<Customer> list = q.list();

				result = list;

				Customer customer = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
						finderArgs, list);
				}
				else {
					customer = list.get(0);

					cacheResult(customer);

					if ((customer.getName() == null) ||
							!customer.getName().equals(name) ||
							(customer.getAddress() == null) ||
							!customer.getAddress().equals(address)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDADDRESS,
							finderArgs, customer);
					}
				}

				return customer;
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
				return (Customer)result;
			}
		}
	}

	/**
	 * Finds all the customers.
	 *
	 * @return the customers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Customer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers to return
	 * @param end the upper bound of the range of customers to return (not inclusive)
	 * @return the range of customers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Customer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers to return
	 * @param end the upper bound of the range of customers to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of customers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Customer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Customer> list = (List<Customer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CUSTOMER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMER.concat(CustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Customer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Customer>)QueryUtil.list(q, getDialect(),
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
	 * Removes the customer where name = &#63; from the database.
	 *
	 * @param name the name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name)
		throws NoSuchCustomerException, SystemException {
		Customer customer = findByName(name);

		remove(customer);
	}

	/**
	 * Removes the customer where name = &#63; and address = &#63; from the database.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNameAndAddress(String name, String address)
		throws NoSuchCustomerException, SystemException {
		Customer customer = findByNameAndAddress(name, address);

		remove(customer);
	}

	/**
	 * Removes all the customers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Customer customer : findAll()) {
			remove(customer);
		}
	}

	/**
	 * Counts all the customers where name = &#63;.
	 *
	 * @param name the name to search with
	 * @return the number of matching customers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CUSTOMER_WHERE);

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
	 * Counts all the customers where name = &#63; and address = &#63;.
	 *
	 * @param name the name to search with
	 * @param address the address to search with
	 * @return the number of matching customers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNameAndAddress(String name, String address)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, address };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAMEANDADDRESS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CUSTOMER_WHERE);

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
	 * Counts all the customers.
	 *
	 * @return the number of customers
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

				Query q = session.createQuery(_SQL_COUNT_CUSTOMER);

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
	 * Initializes the customer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.mpoer.training.customer.model.Customer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Customer>> listenersList = new ArrayList<ModelListener<Customer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Customer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CustomerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = CustomerPersistence.class)
	protected CustomerPersistence customerPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CUSTOMER = "SELECT customer FROM Customer customer";
	private static final String _SQL_SELECT_CUSTOMER_WHERE = "SELECT customer FROM Customer customer WHERE ";
	private static final String _SQL_COUNT_CUSTOMER = "SELECT COUNT(customer) FROM Customer customer";
	private static final String _SQL_COUNT_CUSTOMER_WHERE = "SELECT COUNT(customer) FROM Customer customer WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "customer.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "customer.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(customer.name IS NULL OR customer.name = ?)";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_NAME_1 = "customer.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_NAME_2 = "customer.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_NAME_3 = "(customer.name IS NULL OR customer.name = ?) AND ";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_1 = "customer.address IS NULL";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_2 = "customer.address = ?";
	private static final String _FINDER_COLUMN_NAMEANDADDRESS_ADDRESS_3 = "(customer.address IS NULL OR customer.address = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Customer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Customer exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(CustomerPersistenceImpl.class);
}