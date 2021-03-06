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

package com.test.slayer.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.test.slayer.model.Address;
import com.test.slayer.model.AddressModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the Address service. Represents a row in the &quot;cks_Address&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.test.slayer.model.AddressModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AddressImpl}.
 * </p>
 *
 * @author Chandan
 * @see AddressImpl
 * @see com.test.slayer.model.Address
 * @see com.test.slayer.model.AddressModel
 * @generated
 */
public class AddressModelImpl extends BaseModelImpl<Address>
	implements AddressModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a address model instance should use the {@link com.test.slayer.model.Address} interface instead.
	 */
	public static final String TABLE_NAME = "cks_Address";
	public static final Object[][] TABLE_COLUMNS = {
			{ "addId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "address", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "state", Types.VARCHAR },
			{ "pin", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table cks_Address (addId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,address VARCHAR(75) null,city VARCHAR(75) null,state VARCHAR(75) null,pin VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cks_Address";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.test.slayer.model.Address"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.test.slayer.model.Address"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.test.slayer.model.Address"));

	public AddressModelImpl() {
	}

	public long getPrimaryKey() {
		return _addId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAddId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_addId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Address.class;
	}

	public String getModelClassName() {
		return Address.class.getName();
	}

	public long getAddId() {
		return _addId;
	}

	public void setAddId(long addId) {
		_addId = addId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		if (_state == null) {
			return StringPool.BLANK;
		}
		else {
			return _state;
		}
	}

	public void setState(String state) {
		_state = state;
	}

	public String getPin() {
		if (_pin == null) {
			return StringPool.BLANK;
		}
		else {
			return _pin;
		}
	}

	public void setPin(String pin) {
		_pin = pin;
	}

	@Override
	public Address toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Address)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Address.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddId(getAddId());
		addressImpl.setCompanyId(getCompanyId());
		addressImpl.setUserId(getUserId());
		addressImpl.setUserName(getUserName());
		addressImpl.setCreateDate(getCreateDate());
		addressImpl.setModifiedDate(getModifiedDate());
		addressImpl.setAddress(getAddress());
		addressImpl.setCity(getCity());
		addressImpl.setState(getState());
		addressImpl.setPin(getPin());

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	public int compareTo(Address address) {
		long primaryKey = address.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Address address = null;

		try {
			address = (Address)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = address.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Address> toCacheModel() {
		AddressCacheModel addressCacheModel = new AddressCacheModel();

		addressCacheModel.addId = getAddId();

		addressCacheModel.companyId = getCompanyId();

		addressCacheModel.userId = getUserId();

		addressCacheModel.userName = getUserName();

		String userName = addressCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			addressCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			addressCacheModel.createDate = createDate.getTime();
		}
		else {
			addressCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			addressCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			addressCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		addressCacheModel.address = getAddress();

		String address = addressCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			addressCacheModel.address = null;
		}

		addressCacheModel.city = getCity();

		String city = addressCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			addressCacheModel.city = null;
		}

		addressCacheModel.state = getState();

		String state = addressCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			addressCacheModel.state = null;
		}

		addressCacheModel.pin = getPin();

		String pin = addressCacheModel.pin;

		if ((pin != null) && (pin.length() == 0)) {
			addressCacheModel.pin = null;
		}

		return addressCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{addId=");
		sb.append(getAddId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", pin=");
		sb.append(getPin());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.test.slayer.model.Address");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addId</column-name><column-value><![CDATA[");
		sb.append(getAddId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pin</column-name><column-value><![CDATA[");
		sb.append(getPin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Address.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Address.class
		};
	private long _addId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _address;
	private String _city;
	private String _state;
	private String _pin;
	private transient ExpandoBridge _expandoBridge;
	private Address _escapedModelProxy;
}