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

package com.library.slayer.service;

import com.library.slayer.model.LMSBookClp;
import com.library.slayer.model.LMSBookJoinClp;
import com.library.slayer.model.MemberAddressClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"library-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"library-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "library-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LMSBookClp.class.getName())) {
			return translateInputLMSBook(oldModel);
		}

		if (oldModelClassName.equals(LMSBookJoinClp.class.getName())) {
			return translateInputLMSBookJoin(oldModel);
		}

		if (oldModelClassName.equals(MemberAddressClp.class.getName())) {
			return translateInputMemberAddress(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputLMSBook(BaseModel<?> oldModel) {
		LMSBookClp oldCplModel = (LMSBookClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.library.slayer.model.impl.LMSBookImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setBookId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getBookId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setBookTitle",
						new Class[] { String.class });

				String value2 = oldCplModel.getBookTitle();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setAuthor",
						new Class[] { String.class });

				String value3 = oldCplModel.getAuthor();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value4 = oldCplModel.getDescription();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setFileName",
						new Class[] { String.class });

				String value5 = oldCplModel.getFileName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDownloaded",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getDownloaded());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getStatus());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getCompanyId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getGroupId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getCreateDate();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getModifiedDate();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getUserId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setUserName",
						new Class[] { String.class });

				String value13 = oldCplModel.getUserName();

				method13.invoke(newModel, value13);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputLMSBookJoin(BaseModel<?> oldModel) {
		LMSBookJoinClp oldCplModel = (LMSBookJoinClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.library.slayer.model.impl.LMSBookJoinImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setJoinId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getJoinId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setBookId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getBookId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setBookTitle",
						new Class[] { String.class });

				String value3 = oldCplModel.getBookTitle();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setAuthor",
						new Class[] { String.class });

				String value4 = oldCplModel.getAuthor();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setFirstName",
						new Class[] { String.class });

				String value5 = oldCplModel.getFirstName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLastName",
						new Class[] { String.class });

				String value6 = oldCplModel.getLastName();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCity",
						new Class[] { String.class });

				String value7 = oldCplModel.getCity();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setZip",
						new Class[] { String.class });

				String value8 = oldCplModel.getZip();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setEmailAddress",
						new Class[] { String.class });

				String value9 = oldCplModel.getEmailAddress();

				method9.invoke(newModel, value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputMemberAddress(BaseModel<?> oldModel) {
		MemberAddressClp oldCplModel = (MemberAddressClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.library.slayer.model.impl.MemberAddressImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getUserId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setFirstName",
						new Class[] { String.class });

				String value1 = oldCplModel.getFirstName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setLastName",
						new Class[] { String.class });

				String value2 = oldCplModel.getLastName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setStreetAddress1",
						new Class[] { String.class });

				String value3 = oldCplModel.getStreetAddress1();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setStreetAddress2",
						new Class[] { String.class });

				String value4 = oldCplModel.getStreetAddress2();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCity",
						new Class[] { String.class });

				String value5 = oldCplModel.getCity();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setZip",
						new Class[] { String.class });

				String value6 = oldCplModel.getZip();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setEmailAddress",
						new Class[] { String.class });

				String value7 = oldCplModel.getEmailAddress();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setPhoneNumber",
						new Class[] { String.class });

				String value8 = oldCplModel.getPhoneNumber();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setMobileNumber",
						new Class[] { String.class });

				String value9 = oldCplModel.getMobileNumber();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setDateAdded",
						new Class[] { Date.class });

				Date value10 = oldCplModel.getDateAdded();

				method10.invoke(newModel, value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.library.slayer.model.impl.LMSBookImpl")) {
			return translateOutputLMSBook(oldModel);
		}

		if (oldModelClassName.equals(
					"com.library.slayer.model.impl.LMSBookJoinImpl")) {
			return translateOutputLMSBookJoin(oldModel);
		}

		if (oldModelClassName.equals(
					"com.library.slayer.model.impl.MemberAddressImpl")) {
			return translateOutputMemberAddress(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputLMSBook(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LMSBookClp newModel = new LMSBookClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getBookId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setBookId(value1);

				Method method2 = oldModelClass.getMethod("getBookTitle");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setBookTitle(value2);

				Method method3 = oldModelClass.getMethod("getAuthor");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setAuthor(value3);

				Method method4 = oldModelClass.getMethod("getDescription");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setDescription(value4);

				Method method5 = oldModelClass.getMethod("getFileName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setFileName(value5);

				Method method6 = oldModelClass.getMethod("getDownloaded");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setDownloaded(value6);

				Method method7 = oldModelClass.getMethod("getStatus");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value7);

				Method method8 = oldModelClass.getMethod("getCompanyId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value8);

				Method method9 = oldModelClass.getMethod("getGroupId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value9);

				Method method10 = oldModelClass.getMethod("getCreateDate");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value10);

				Method method11 = oldModelClass.getMethod("getModifiedDate");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value11);

				Method method12 = oldModelClass.getMethod("getUserId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setUserId(value12);

				Method method13 = oldModelClass.getMethod("getUserName");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setUserName(value13);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputLMSBookJoin(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LMSBookJoinClp newModel = new LMSBookJoinClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getJoinId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setJoinId(value0);

				Method method1 = oldModelClass.getMethod("getBookId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setBookId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getBookTitle");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setBookTitle(value3);

				Method method4 = oldModelClass.getMethod("getAuthor");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setAuthor(value4);

				Method method5 = oldModelClass.getMethod("getFirstName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setFirstName(value5);

				Method method6 = oldModelClass.getMethod("getLastName");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setLastName(value6);

				Method method7 = oldModelClass.getMethod("getCity");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setCity(value7);

				Method method8 = oldModelClass.getMethod("getZip");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setZip(value8);

				Method method9 = oldModelClass.getMethod("getEmailAddress");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setEmailAddress(value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputMemberAddress(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				MemberAddressClp newModel = new MemberAddressClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUserId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setUserId(value0);

				Method method1 = oldModelClass.getMethod("getFirstName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setFirstName(value1);

				Method method2 = oldModelClass.getMethod("getLastName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setLastName(value2);

				Method method3 = oldModelClass.getMethod("getStreetAddress1");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setStreetAddress1(value3);

				Method method4 = oldModelClass.getMethod("getStreetAddress2");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setStreetAddress2(value4);

				Method method5 = oldModelClass.getMethod("getCity");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setCity(value5);

				Method method6 = oldModelClass.getMethod("getZip");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setZip(value6);

				Method method7 = oldModelClass.getMethod("getEmailAddress");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setEmailAddress(value7);

				Method method8 = oldModelClass.getMethod("getPhoneNumber");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setPhoneNumber(value8);

				Method method9 = oldModelClass.getMethod("getMobileNumber");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setMobileNumber(value9);

				Method method10 = oldModelClass.getMethod("getDateAdded");

				Date value10 = (Date)method10.invoke(oldModel, (Object[])null);

				newModel.setDateAdded(value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}