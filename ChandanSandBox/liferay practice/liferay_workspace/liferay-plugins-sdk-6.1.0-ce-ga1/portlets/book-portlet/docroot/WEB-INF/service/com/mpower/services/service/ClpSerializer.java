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

package com.mpower.services.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.mpower.services.model.BookClp;
import com.mpower.services.model.ExtWorkFlowClp;

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
						"book-portlet-deployment-context");

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
							"book-portlet-deployment-context");

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
				_servletContextName = "book-portlet";
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

		if (oldModelClassName.equals(BookClp.class.getName())) {
			return translateInputBook(oldModel);
		}

		if (oldModelClassName.equals(ExtWorkFlowClp.class.getName())) {
			return translateInputExtWorkFlow(oldModel);
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

	public static Object translateInputBook(BaseModel<?> oldModel) {
		BookClp oldCplModel = (BookClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.mpower.services.model.impl.BookImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setBookId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getBookId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setBookNumber",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getBookNumber());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setWriterName",
						new Class[] { String.class });

				String value2 = oldCplModel.getWriterName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreateDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setFirstName",
						new Class[] { String.class });

				String value4 = oldCplModel.getFirstName();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setLastName",
						new Class[] { String.class });

				String value5 = oldCplModel.getLastName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setQuantity",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getQuantity());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTotalCost",
						new Class[] { Double.TYPE });

				Double value7 = new Double(oldCplModel.getTotalCost());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setStatus",
						new Class[] { String.class });

				String value8 = oldCplModel.getStatus();

				method8.invoke(newModel, value8);

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

	public static Object translateInputExtWorkFlow(BaseModel<?> oldModel) {
		ExtWorkFlowClp oldCplModel = (ExtWorkFlowClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.mpower.services.model.impl.ExtWorkFlowImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setExtWorkflowId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getExtWorkflowId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setResourcePrimKey",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getResourcePrimKey());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setClassNameId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getClassNameId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setClassPK",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getClassPK());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setParentResourcePrimKey",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getParentResourcePrimKey());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setVersion",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getVersion());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value6 = oldCplModel.getTitle();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value7 = oldCplModel.getContent();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value8 = oldCplModel.getDescription();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPriority",
						new Class[] { Integer.TYPE });

				Integer value9 = new Integer(oldCplModel.getPriority());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getStatus());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setStatusByUserId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getStatusByUserId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setStatusByUserName",
						new Class[] { String.class });

				String value12 = oldCplModel.getStatusByUserName();

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setStatusDate",
						new Class[] { Date.class });

				Date value13 = oldCplModel.getStatusDate();

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

		if (oldModelClassName.equals("com.mpower.services.model.impl.BookImpl")) {
			return translateOutputBook(oldModel);
		}

		if (oldModelClassName.equals(
					"com.mpower.services.model.impl.ExtWorkFlowImpl")) {
			return translateOutputExtWorkFlow(oldModel);
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

	public static Object translateOutputBook(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				BookClp newModel = new BookClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getBookId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setBookId(value0);

				Method method1 = oldModelClass.getMethod("getBookNumber");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setBookNumber(value1);

				Method method2 = oldModelClass.getMethod("getWriterName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setWriterName(value2);

				Method method3 = oldModelClass.getMethod("getCreateDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value3);

				Method method4 = oldModelClass.getMethod("getFirstName");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setFirstName(value4);

				Method method5 = oldModelClass.getMethod("getLastName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setLastName(value5);

				Method method6 = oldModelClass.getMethod("getQuantity");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setQuantity(value6);

				Method method7 = oldModelClass.getMethod("getTotalCost");

				Double value7 = (Double)method7.invoke(oldModel, (Object[])null);

				newModel.setTotalCost(value7);

				Method method8 = oldModelClass.getMethod("getStatus");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setStatus(value8);

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

	public static Object translateOutputExtWorkFlow(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ExtWorkFlowClp newModel = new ExtWorkFlowClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getExtWorkflowId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setExtWorkflowId(value0);

				Method method1 = oldModelClass.getMethod("getResourcePrimKey");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setResourcePrimKey(value1);

				Method methodIsResourceMain = oldModelClass.getMethod(
						"isResourceMain");

				Boolean resourceMain = (Boolean)methodIsResourceMain.invoke(oldModel,
						(Object[])null);

				newModel.setResourceMain(resourceMain);

				Method method2 = oldModelClass.getMethod("getClassNameId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setClassNameId(value2);

				Method method3 = oldModelClass.getMethod("getClassPK");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setClassPK(value3);

				Method method4 = oldModelClass.getMethod(
						"getParentResourcePrimKey");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setParentResourcePrimKey(value4);

				Method method5 = oldModelClass.getMethod("getVersion");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setVersion(value5);

				Method method6 = oldModelClass.getMethod("getTitle");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setTitle(value6);

				Method method7 = oldModelClass.getMethod("getContent");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setContent(value7);

				Method method8 = oldModelClass.getMethod("getDescription");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setDescription(value8);

				Method method9 = oldModelClass.getMethod("getPriority");

				Integer value9 = (Integer)method9.invoke(oldModel,
						(Object[])null);

				newModel.setPriority(value9);

				Method method10 = oldModelClass.getMethod("getStatus");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value10);

				Method method11 = oldModelClass.getMethod("getStatusByUserId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setStatusByUserId(value11);

				Method method12 = oldModelClass.getMethod("getStatusByUserName");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setStatusByUserName(value12);

				Method method13 = oldModelClass.getMethod("getStatusDate");

				Date value13 = (Date)method13.invoke(oldModel, (Object[])null);

				newModel.setStatusDate(value13);

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