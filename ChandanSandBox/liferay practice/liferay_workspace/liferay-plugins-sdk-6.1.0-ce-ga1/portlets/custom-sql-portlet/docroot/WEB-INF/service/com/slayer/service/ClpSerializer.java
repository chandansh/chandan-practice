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

package com.slayer.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.slayer.model.AuthorClp;
import com.slayer.model.AuthorPostClp;
import com.slayer.model.PostClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
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
						"custom-sql-portlet-deployment-context");

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
							"custom-sql-portlet-deployment-context");

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
				_servletContextName = "custom-sql-portlet";
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

		if (oldModelClassName.equals(AuthorClp.class.getName())) {
			return translateInputAuthor(oldModel);
		}

		if (oldModelClassName.equals(AuthorPostClp.class.getName())) {
			return translateInputAuthorPost(oldModel);
		}

		if (oldModelClassName.equals(PostClp.class.getName())) {
			return translateInputPost(oldModel);
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

	public static Object translateInputAuthor(BaseModel<?> oldModel) {
		AuthorClp oldCplModel = (AuthorClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.slayer.model.impl.AuthorImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setAuthorId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getAuthorId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSpecialization",
						new Class[] { String.class });

				String value2 = oldCplModel.getSpecialization();

				method2.invoke(newModel, value2);

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

	public static Object translateInputAuthorPost(BaseModel<?> oldModel) {
		AuthorPostClp oldCplModel = (AuthorPostClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.slayer.model.impl.AuthorPostImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setAuthorPostId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getAuthorPostId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setPostId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getPostId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value2 = oldCplModel.getTitle();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value3 = oldCplModel.getContent();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setAuthorId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getAuthorId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value5 = oldCplModel.getName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setSpecialization",
						new Class[] { String.class });

				String value6 = oldCplModel.getSpecialization();

				method6.invoke(newModel, value6);

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

	public static Object translateInputPost(BaseModel<?> oldModel) {
		PostClp oldCplModel = (PostClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.slayer.model.impl.PostImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPostId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getPostId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value1 = oldCplModel.getTitle();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value2 = oldCplModel.getContent();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setAuthorId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getAuthorId());

				method3.invoke(newModel, value3);

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

		if (oldModelClassName.equals("com.slayer.model.impl.AuthorImpl")) {
			return translateOutputAuthor(oldModel);
		}

		if (oldModelClassName.equals("com.slayer.model.impl.AuthorPostImpl")) {
			return translateOutputAuthorPost(oldModel);
		}

		if (oldModelClassName.equals("com.slayer.model.impl.PostImpl")) {
			return translateOutputPost(oldModel);
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

	public static Object translateOutputAuthor(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AuthorClp newModel = new AuthorClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getAuthorId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setAuthorId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getSpecialization");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setSpecialization(value2);

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

	public static Object translateOutputAuthorPost(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				AuthorPostClp newModel = new AuthorPostClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getAuthorPostId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setAuthorPostId(value0);

				Method method1 = oldModelClass.getMethod("getPostId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setPostId(value1);

				Method method2 = oldModelClass.getMethod("getTitle");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTitle(value2);

				Method method3 = oldModelClass.getMethod("getContent");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setContent(value3);

				Method method4 = oldModelClass.getMethod("getAuthorId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setAuthorId(value4);

				Method method5 = oldModelClass.getMethod("getName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setName(value5);

				Method method6 = oldModelClass.getMethod("getSpecialization");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setSpecialization(value6);

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

	public static Object translateOutputPost(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				PostClp newModel = new PostClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPostId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setPostId(value0);

				Method method1 = oldModelClass.getMethod("getTitle");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTitle(value1);

				Method method2 = oldModelClass.getMethod("getContent");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setContent(value2);

				Method method3 = oldModelClass.getMethod("getAuthorId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setAuthorId(value3);

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