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

package com.slayer.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.slayer.model.ShoppingCartExt;

import com.slayer.service.ShoppingCartExtLocalService;
import com.slayer.service.ShoppingCategoryExtLocalService;
import com.slayer.service.persistence.ShoppingCartExtPersistence;
import com.slayer.service.persistence.ShoppingCategoryExtPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the shopping cart ext local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.slayer.service.impl.ShoppingCartExtLocalServiceImpl}.
 * </p>
 *
 * @author ahmedhasan
 * @see com.slayer.service.impl.ShoppingCartExtLocalServiceImpl
 * @see com.slayer.service.ShoppingCartExtLocalServiceUtil
 * @generated
 */
public abstract class ShoppingCartExtLocalServiceBaseImpl
	implements ShoppingCartExtLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.slayer.service.ShoppingCartExtLocalServiceUtil} to access the shopping cart ext local service.
	 */

	/**
	 * Adds the shopping cart ext to the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCartExt the shopping cart ext
	 * @return the shopping cart ext that was added
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt addShoppingCartExt(ShoppingCartExt shoppingCartExt)
		throws SystemException {
		shoppingCartExt.setNew(true);

		shoppingCartExt = shoppingCartExtPersistence.update(shoppingCartExt,
				false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(shoppingCartExt);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return shoppingCartExt;
	}

	/**
	 * Creates a new shopping cart ext with the primary key. Does not add the shopping cart ext to the database.
	 *
	 * @param recId the primary key for the new shopping cart ext
	 * @return the new shopping cart ext
	 */
	public ShoppingCartExt createShoppingCartExt(long recId) {
		return shoppingCartExtPersistence.create(recId);
	}

	/**
	 * Deletes the shopping cart ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the shopping cart ext
	 * @throws PortalException if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteShoppingCartExt(long recId)
		throws PortalException, SystemException {
		ShoppingCartExt shoppingCartExt = shoppingCartExtPersistence.remove(recId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(shoppingCartExt);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the shopping cart ext from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCartExt the shopping cart ext
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteShoppingCartExt(ShoppingCartExt shoppingCartExt)
		throws SystemException {
		shoppingCartExtPersistence.remove(shoppingCartExt);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(shoppingCartExt);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return shoppingCartExtPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return shoppingCartExtPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return shoppingCartExtPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return shoppingCartExtPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public ShoppingCartExt fetchShoppingCartExt(long recId)
		throws SystemException {
		return shoppingCartExtPersistence.fetchByPrimaryKey(recId);
	}

	/**
	 * Returns the shopping cart ext with the primary key.
	 *
	 * @param recId the primary key of the shopping cart ext
	 * @return the shopping cart ext
	 * @throws PortalException if a shopping cart ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt getShoppingCartExt(long recId)
		throws PortalException, SystemException {
		return shoppingCartExtPersistence.findByPrimaryKey(recId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return shoppingCartExtPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<ShoppingCartExt> getShoppingCartExts(int start, int end)
		throws SystemException {
		return shoppingCartExtPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of shopping cart exts.
	 *
	 * @return the number of shopping cart exts
	 * @throws SystemException if a system exception occurred
	 */
	public int getShoppingCartExtsCount() throws SystemException {
		return shoppingCartExtPersistence.countAll();
	}

	/**
	 * Updates the shopping cart ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCartExt the shopping cart ext
	 * @return the shopping cart ext that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt updateShoppingCartExt(
		ShoppingCartExt shoppingCartExt) throws SystemException {
		return updateShoppingCartExt(shoppingCartExt, true);
	}

	/**
	 * Updates the shopping cart ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingCartExt the shopping cart ext
	 * @param merge whether to merge the shopping cart ext with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the shopping cart ext that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCartExt updateShoppingCartExt(
		ShoppingCartExt shoppingCartExt, boolean merge)
		throws SystemException {
		shoppingCartExt.setNew(false);

		shoppingCartExt = shoppingCartExtPersistence.update(shoppingCartExt,
				merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(shoppingCartExt);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return shoppingCartExt;
	}

	/**
	 * Returns the shopping cart ext local service.
	 *
	 * @return the shopping cart ext local service
	 */
	public ShoppingCartExtLocalService getShoppingCartExtLocalService() {
		return shoppingCartExtLocalService;
	}

	/**
	 * Sets the shopping cart ext local service.
	 *
	 * @param shoppingCartExtLocalService the shopping cart ext local service
	 */
	public void setShoppingCartExtLocalService(
		ShoppingCartExtLocalService shoppingCartExtLocalService) {
		this.shoppingCartExtLocalService = shoppingCartExtLocalService;
	}

	/**
	 * Returns the shopping cart ext persistence.
	 *
	 * @return the shopping cart ext persistence
	 */
	public ShoppingCartExtPersistence getShoppingCartExtPersistence() {
		return shoppingCartExtPersistence;
	}

	/**
	 * Sets the shopping cart ext persistence.
	 *
	 * @param shoppingCartExtPersistence the shopping cart ext persistence
	 */
	public void setShoppingCartExtPersistence(
		ShoppingCartExtPersistence shoppingCartExtPersistence) {
		this.shoppingCartExtPersistence = shoppingCartExtPersistence;
	}

	/**
	 * Returns the shopping category ext local service.
	 *
	 * @return the shopping category ext local service
	 */
	public ShoppingCategoryExtLocalService getShoppingCategoryExtLocalService() {
		return shoppingCategoryExtLocalService;
	}

	/**
	 * Sets the shopping category ext local service.
	 *
	 * @param shoppingCategoryExtLocalService the shopping category ext local service
	 */
	public void setShoppingCategoryExtLocalService(
		ShoppingCategoryExtLocalService shoppingCategoryExtLocalService) {
		this.shoppingCategoryExtLocalService = shoppingCategoryExtLocalService;
	}

	/**
	 * Returns the shopping category ext persistence.
	 *
	 * @return the shopping category ext persistence
	 */
	public ShoppingCategoryExtPersistence getShoppingCategoryExtPersistence() {
		return shoppingCategoryExtPersistence;
	}

	/**
	 * Sets the shopping category ext persistence.
	 *
	 * @param shoppingCategoryExtPersistence the shopping category ext persistence
	 */
	public void setShoppingCategoryExtPersistence(
		ShoppingCategoryExtPersistence shoppingCategoryExtPersistence) {
		this.shoppingCategoryExtPersistence = shoppingCategoryExtPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.slayer.model.ShoppingCartExt",
			shoppingCartExtLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.slayer.model.ShoppingCartExt");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return ShoppingCartExt.class;
	}

	protected String getModelClassName() {
		return ShoppingCartExt.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = shoppingCartExtPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ShoppingCartExtLocalService.class)
	protected ShoppingCartExtLocalService shoppingCartExtLocalService;
	@BeanReference(type = ShoppingCartExtPersistence.class)
	protected ShoppingCartExtPersistence shoppingCartExtPersistence;
	@BeanReference(type = ShoppingCategoryExtLocalService.class)
	protected ShoppingCategoryExtLocalService shoppingCategoryExtLocalService;
	@BeanReference(type = ShoppingCategoryExtPersistence.class)
	protected ShoppingCategoryExtPersistence shoppingCategoryExtPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(ShoppingCartExtLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}