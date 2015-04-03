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

package com.library.slayer.service.persistence;

import com.library.slayer.NoSuchBookException;
import com.library.slayer.model.LIBBook;
import com.library.slayer.model.impl.LIBBookImpl;
import com.library.slayer.model.impl.LIBBookModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l i b book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author veena
 * @see LIBBookPersistence
 * @see LIBBookUtil
 * @generated
 */
public class LIBBookPersistenceImpl extends BasePersistenceImpl<LIBBook>
	implements LIBBookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LIBBookUtil} to access the l i b book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LIBBookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
			LIBBookModelImpl.FINDER_CACHE_ENABLED, LIBBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
			LIBBookModelImpl.FINDER_CACHE_ENABLED, LIBBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
			LIBBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the l i b book in the entity cache if it is enabled.
	 *
	 * @param libBook the l i b book
	 */
	public void cacheResult(LIBBook libBook) {
		EntityCacheUtil.putResult(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
			LIBBookImpl.class, libBook.getPrimaryKey(), libBook);

		libBook.resetOriginalValues();
	}

	/**
	 * Caches the l i b books in the entity cache if it is enabled.
	 *
	 * @param libBooks the l i b books
	 */
	public void cacheResult(List<LIBBook> libBooks) {
		for (LIBBook libBook : libBooks) {
			if (EntityCacheUtil.getResult(
						LIBBookModelImpl.ENTITY_CACHE_ENABLED,
						LIBBookImpl.class, libBook.getPrimaryKey()) == null) {
				cacheResult(libBook);
			}
			else {
				libBook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l i b books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LIBBookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LIBBookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l i b book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LIBBook libBook) {
		EntityCacheUtil.removeResult(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
			LIBBookImpl.class, libBook.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LIBBook> libBooks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LIBBook libBook : libBooks) {
			EntityCacheUtil.removeResult(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
				LIBBookImpl.class, libBook.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l i b book with the primary key. Does not add the l i b book to the database.
	 *
	 * @param bookId the primary key for the new l i b book
	 * @return the new l i b book
	 */
	public LIBBook create(long bookId) {
		LIBBook libBook = new LIBBookImpl();

		libBook.setNew(true);
		libBook.setPrimaryKey(bookId);

		return libBook;
	}

	/**
	 * Removes the l i b book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the l i b book
	 * @return the l i b book that was removed
	 * @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LIBBook remove(long bookId)
		throws NoSuchBookException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the l i b book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l i b book
	 * @return the l i b book that was removed
	 * @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LIBBook remove(Serializable primaryKey)
		throws NoSuchBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LIBBook libBook = (LIBBook)session.get(LIBBookImpl.class, primaryKey);

			if (libBook == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(libBook);
		}
		catch (NoSuchBookException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LIBBook removeImpl(LIBBook libBook) throws SystemException {
		libBook = toUnwrappedModel(libBook);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, libBook);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(libBook);

		return libBook;
	}

	@Override
	public LIBBook updateImpl(com.library.slayer.model.LIBBook libBook,
		boolean merge) throws SystemException {
		libBook = toUnwrappedModel(libBook);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, libBook, merge);

			libBook.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
			LIBBookImpl.class, libBook.getPrimaryKey(), libBook);

		return libBook;
	}

	protected LIBBook toUnwrappedModel(LIBBook libBook) {
		if (libBook instanceof LIBBookImpl) {
			return libBook;
		}

		LIBBookImpl libBookImpl = new LIBBookImpl();

		libBookImpl.setNew(libBook.isNew());
		libBookImpl.setPrimaryKey(libBook.getPrimaryKey());

		libBookImpl.setBookId(libBook.getBookId());
		libBookImpl.setBookTitle(libBook.getBookTitle());
		libBookImpl.setAuthor(libBook.getAuthor());

		return libBookImpl;
	}

	/**
	 * Returns the l i b book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l i b book
	 * @return the l i b book
	 * @throws com.liferay.portal.NoSuchModelException if a l i b book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LIBBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l i b book with the primary key or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the l i b book
	 * @return the l i b book
	 * @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LIBBook findByPrimaryKey(long bookId)
		throws NoSuchBookException, SystemException {
		LIBBook libBook = fetchByPrimaryKey(bookId);

		if (libBook == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return libBook;
	}

	/**
	 * Returns the l i b book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l i b book
	 * @return the l i b book, or <code>null</code> if a l i b book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LIBBook fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l i b book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the l i b book
	 * @return the l i b book, or <code>null</code> if a l i b book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LIBBook fetchByPrimaryKey(long bookId) throws SystemException {
		LIBBook libBook = (LIBBook)EntityCacheUtil.getResult(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
				LIBBookImpl.class, bookId);

		if (libBook == _nullLIBBook) {
			return null;
		}

		if (libBook == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				libBook = (LIBBook)session.get(LIBBookImpl.class,
						Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (libBook != null) {
					cacheResult(libBook);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LIBBookModelImpl.ENTITY_CACHE_ENABLED,
						LIBBookImpl.class, bookId, _nullLIBBook);
				}

				closeSession(session);
			}
		}

		return libBook;
	}

	/**
	 * Returns all the l i b books.
	 *
	 * @return the l i b books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LIBBook> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l i b books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l i b books
	 * @param end the upper bound of the range of l i b books (not inclusive)
	 * @return the range of l i b books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LIBBook> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l i b books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l i b books
	 * @param end the upper bound of the range of l i b books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l i b books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LIBBook> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LIBBook> list = (List<LIBBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LIBBOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LIBBOOK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LIBBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LIBBook>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the l i b books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LIBBook libBook : findAll()) {
			remove(libBook);
		}
	}

	/**
	 * Returns the number of l i b books.
	 *
	 * @return the number of l i b books
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LIBBOOK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the l i b book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.library.slayer.model.LIBBook")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LIBBook>> listenersList = new ArrayList<ModelListener<LIBBook>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LIBBook>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LIBBookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LIBBookPersistence.class)
	protected LIBBookPersistence libBookPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LIBBOOK = "SELECT libBook FROM LIBBook libBook";
	private static final String _SQL_COUNT_LIBBOOK = "SELECT COUNT(libBook) FROM LIBBook libBook";
	private static final String _ORDER_BY_ENTITY_ALIAS = "libBook.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LIBBook exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LIBBookPersistenceImpl.class);
	private static LIBBook _nullLIBBook = new LIBBookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LIBBook> toCacheModel() {
				return _nullLIBBookCacheModel;
			}
		};

	private static CacheModel<LIBBook> _nullLIBBookCacheModel = new CacheModel<LIBBook>() {
			public LIBBook toEntityModel() {
				return _nullLIBBook;
			}
		};
}