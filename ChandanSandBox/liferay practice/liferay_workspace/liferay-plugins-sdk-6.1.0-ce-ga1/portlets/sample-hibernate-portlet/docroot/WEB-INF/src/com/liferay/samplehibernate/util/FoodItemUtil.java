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

import com.liferay.samplehibernate.model.FoodItem;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * @author Charles May
 */
public class FoodItemUtil {

	public static void addFoodItem(FoodItem foodItem) throws Exception {
		Session session = null;

		try {
			session = HibernateUtil.openSession();

			session.beginTransaction();

			session.save(foodItem);

			session.flush();

			session.getTransaction().commit();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	public static void deleteFoodItem(long foodItemId) throws Exception {
		Session session = null;

		try {
			session = HibernateUtil.openSession();

			session.beginTransaction();

			FoodItem foodItem = (FoodItem)session.get(
				FoodItem.class, new Long(foodItemId));

			if (foodItem != null) {
				session.delete(foodItem);

				session.flush();
			}

			session.getTransaction().commit();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	public static FoodItem getFoodItem(long foodItemId) throws Exception {
		Session session = null;

		try {
			session = HibernateUtil.openSession();

			session.beginTransaction();

			FoodItem foodItem = (FoodItem)session.get(
				FoodItem.class, new Long(foodItemId));

			session.getTransaction().commit();

			return foodItem;
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	public static List getFoodItems() throws Exception {
		Session session = null;

		try {
			session = HibernateUtil.openSession();

			session.beginTransaction();

			SQLQuery q = session.createSQLQuery(_GET_FOOD_ITEMS);

			q.addEntity("FoodItem", FoodItem.class);

			List list = q.list();

			session.getTransaction().commit();

			return list;
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	public static void updateFoodItem(FoodItem foodItem) throws Exception {
		Session session = null;

		try {
			session = HibernateUtil.openSession();

			session.beginTransaction();

			session.update(foodItem);

			session.flush();

			session.getTransaction().commit();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	private static final String _GET_FOOD_ITEMS =
		"SELECT {FoodItem.*} FROM FoodItem ORDER BY name_ ASC";

}