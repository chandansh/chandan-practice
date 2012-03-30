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

package com.mpoer.training.customer.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.mpoer.training.customer.NoSuchCustomerException;
import com.mpoer.training.customer.model.Customer;
import com.mpoer.training.customer.service.base.CustomerLocalServiceBaseImpl;

/**
 * The implementation of the customer local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.mpoer.training.customer.service.CustomerLocalService} interface.
 * </p> <p> Never reference this interface directly. Always use
 * {@link com.mpoer.training.customer.service.CustomerLocalServiceUtil} to
 * access the customer local service. </p> <p> This is a local service. Methods	
 * of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM. </p>
 * 
 * @author Brian Wing Shun Chan
 * @see com.mpoer.training.customer.service.base.CustomerLocalServiceBaseImpl
 * @see com.mpoer.training.customer.service.CustomerLocalServiceUtil
 */
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {

	public void deactivateCustomer(long id) {

		System.out.println("deactivating customer.. id:" + id);
	}

	public Customer findByName(String name)
		throws NoSuchCustomerException, SystemException {

		return customerPersistence.findByName(name);
	}

	public Customer findByNameAndAddress(String name, String address)
		throws SystemException {

		return customerPersistence.fetchByNameAndAddress(name, address);
	}
}
