/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.samplehibernate.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Charles May
 */
public class HibernateUtil {

	public static final String COUNT_COLUMN_NAME = "COUNT_VALUE";

	public static String getCountColumnName() {
		return COUNT_COLUMN_NAME;
	}

	public static SessionFactory getSessionFactory() {
		return _instance._sessionFactory;
	}

	public static void closeSession(Session session) {
		try {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}
		catch (HibernateException he) {
			_log.error(he.getMessage());
		}
	}

	public static Session openSession() throws HibernateException {
		return openSession(getSessionFactory());
	}

	public static Session openSession(SessionFactory sessionFactory)
		throws HibernateException {

		return sessionFactory.getCurrentSession();
	}

	private HibernateUtil() {
		try {
			Configuration configuration = new Configuration();

			configuration = configuration.configure();

			_sessionFactory = configuration.buildSessionFactory();
		}
		catch (Exception e) {
		   _log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(HibernateUtil.class);

	private static HibernateUtil _instance = new HibernateUtil();

	private SessionFactory _sessionFactory;

}