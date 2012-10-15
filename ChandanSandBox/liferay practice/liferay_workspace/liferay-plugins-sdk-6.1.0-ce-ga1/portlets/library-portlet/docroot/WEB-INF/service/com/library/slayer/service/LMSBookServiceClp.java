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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Ahmed Hasan
 */
public class LMSBookServiceClp implements LMSBookService {
	public LMSBookServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addLibraryBookMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLibraryBook", java.lang.String.class,
				java.lang.String.class, java.lang.String.class);
	}

	public com.library.slayer.model.LMSBook addLibraryBook(
		java.lang.String bookTitle, java.lang.String author,
		java.lang.String groupId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLibraryBookMethodKey0,
				ClpSerializer.translateInput(bookTitle),
				ClpSerializer.translateInput(author),
				ClpSerializer.translateInput(groupId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addLibraryBookMethodKey0;
}