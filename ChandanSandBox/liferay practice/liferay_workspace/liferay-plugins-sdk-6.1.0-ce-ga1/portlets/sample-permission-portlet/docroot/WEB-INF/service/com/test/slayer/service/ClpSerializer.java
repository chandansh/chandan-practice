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

package com.test.slayer.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.test.slayer.model.AddressClp;

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
						"sample-permission-portlet-deployment-context");

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
							"sample-permission-portlet-deployment-context");

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
				_servletContextName = "sample-permission-portlet";
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

		if (oldModelClassName.equals(AddressClp.class.getName())) {
			return translateInputAddress(oldModel);
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

	public static Object translateInputAddress(BaseModel<?> oldModel) {
		AddressClp oldCplModel = (AddressClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.test.slayer.model.impl.AddressImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setAddId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getAddId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCompanyId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserName",
						new Class[] { String.class });

				String value3 = oldCplModel.getUserName();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreateDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value6 = oldCplModel.getAddress();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCity",
						new Class[] { String.class });

				String value7 = oldCplModel.getCity();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setState",
						new Class[] { String.class });

				String value8 = oldCplModel.getState();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPin",
						new Class[] { String.class });

				String value9 = oldCplModel.getPin();

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

		if (oldModelClassName.equals("com.test.slayer.model.impl.AddressImpl")) {
			return translateOutputAddress(oldModel);
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

	public static Object translateOutputAddress(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AddressClp newModel = new AddressClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getAddId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setAddId(value0);

				Method method1 = oldModelClass.getMethod("getCompanyId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getUserName");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setUserName(value3);

				Method method4 = oldModelClass.getMethod("getCreateDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getAddress");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setAddress(value6);

				Method method7 = oldModelClass.getMethod("getCity");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setCity(value7);

				Method method8 = oldModelClass.getMethod("getState");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setState(value8);

				Method method9 = oldModelClass.getMethod("getPin");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setPin(value9);

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