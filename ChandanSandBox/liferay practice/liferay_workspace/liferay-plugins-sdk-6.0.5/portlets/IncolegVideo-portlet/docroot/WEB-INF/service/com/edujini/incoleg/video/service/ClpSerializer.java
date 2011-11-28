/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.edujini.incoleg.video.service;

import com.edujini.incoleg.video.model.StoreSettingsClp;
import com.edujini.incoleg.video.model.VOMapClp;
import com.edujini.incoleg.video.model.VideoInfoClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "IncolegVideo-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(VideoInfoClp.class.getName())) {
			VideoInfoClp oldCplModel = (VideoInfoClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.edujini.incoleg.video.model.impl.VideoInfoImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setVideoId",
							new Class[] { String.class });

					String value0 = oldCplModel.getVideoId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setFileName",
							new Class[] { String.class });

					String value1 = oldCplModel.getFileName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMappedFileName",
							new Class[] { String.class });

					String value2 = oldCplModel.getMappedFileName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setFileType",
							new Class[] { String.class });

					String value3 = oldCplModel.getFileType();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setFileSize",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getFileSize());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setFileDesc",
							new Class[] { String.class });

					String value5 = oldCplModel.getFileDesc();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setUserEmail",
							new Class[] { String.class });

					String value6 = oldCplModel.getUserEmail();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUploadTime",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getUploadTime();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setVurl",
							new Class[] { String.class });

					String value8 = oldCplModel.getVurl();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getStatus());

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(StoreSettingsClp.class.getName())) {
			StoreSettingsClp oldCplModel = (StoreSettingsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.edujini.incoleg.video.model.impl.StoreSettingsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setStoreId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getStoreId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setInBId",
							new Class[] { String.class });

					String value1 = oldCplModel.getInBId();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPrBId",
							new Class[] { String.class });

					String value2 = oldCplModel.getPrBId();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOutBId",
							new Class[] { String.class });

					String value3 = oldCplModel.getOutBId();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAccessKId",
							new Class[] { String.class });

					String value4 = oldCplModel.getAccessKId();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setSecretAKey",
							new Class[] { String.class });

					String value5 = oldCplModel.getSecretAKey();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(VOMapClp.class.getName())) {
			VOMapClp oldCplModel = (VOMapClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.edujini.incoleg.video.model.impl.VOMapImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setVideoId",
							new Class[] { String.class });

					String value0 = oldCplModel.getVideoId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { String.class });

					String value1 = oldCplModel.getOrgId();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setStoreType",
							new Class[] { String.class });

					String value2 = oldCplModel.getStoreType();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
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
					"com.edujini.incoleg.video.model.impl.VideoInfoImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					VideoInfoClp newModel = new VideoInfoClp();

					Method method0 = oldModelClass.getMethod("getVideoId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setVideoId(value0);

					Method method1 = oldModelClass.getMethod("getFileName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setFileName(value1);

					Method method2 = oldModelClass.getMethod(
							"getMappedFileName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMappedFileName(value2);

					Method method3 = oldModelClass.getMethod("getFileType");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setFileType(value3);

					Method method4 = oldModelClass.getMethod("getFileSize");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setFileSize(value4);

					Method method5 = oldModelClass.getMethod("getFileDesc");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setFileDesc(value5);

					Method method6 = oldModelClass.getMethod("getUserEmail");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setUserEmail(value6);

					Method method7 = oldModelClass.getMethod("getUploadTime");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setUploadTime(value7);

					Method method8 = oldModelClass.getMethod("getVurl");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setVurl(value8);

					Method method9 = oldModelClass.getMethod("getStatus");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.edujini.incoleg.video.model.impl.StoreSettingsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					StoreSettingsClp newModel = new StoreSettingsClp();

					Method method0 = oldModelClass.getMethod("getStoreId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setStoreId(value0);

					Method method1 = oldModelClass.getMethod("getInBId");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setInBId(value1);

					Method method2 = oldModelClass.getMethod("getPrBId");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setPrBId(value2);

					Method method3 = oldModelClass.getMethod("getOutBId");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOutBId(value3);

					Method method4 = oldModelClass.getMethod("getAccessKId");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAccessKId(value4);

					Method method5 = oldModelClass.getMethod("getSecretAKey");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setSecretAKey(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.edujini.incoleg.video.model.impl.VOMapImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					VOMapClp newModel = new VOMapClp();

					Method method0 = oldModelClass.getMethod("getVideoId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setVideoId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1);

					Method method2 = oldModelClass.getMethod("getStoreType");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setStoreType(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
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

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}