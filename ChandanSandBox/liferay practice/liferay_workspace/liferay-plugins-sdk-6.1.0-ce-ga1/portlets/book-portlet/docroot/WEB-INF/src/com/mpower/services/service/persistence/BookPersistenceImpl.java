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

package com.mpower.services.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;

import com.mpower.services.NoSuchBookException;
import com.mpower.services.model.Book;
import com.mpower.services.model.impl.BookImpl;
import com.mpower.services.model.impl.BookModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Meenu
 * @see BookPersistence
 * @see BookUtil
 * @generated
 */
public class BookPersistenceImpl extends BasePersistenceImpl<Book>
	implements BookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKNUMBER =
		new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybookNumber",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKNUMBER =
		new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookNumber",
			new String[] { Long.class.getName() },
			BookModelImpl.BOOKNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKNUMBER = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookNumber",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	public void cacheResult(Book book) {
		EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey(), book);

		book.resetOriginalValues();
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public void cacheResult(List<Book> books) {
		for (Book book : books) {
			if (EntityCacheUtil.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
						BookImpl.class, book.getPrimaryKey()) == null) {
				cacheResult(book);
			}
			else {
				book.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Book book) {
		EntityCacheUtil.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Book> books) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Book book : books) {
			EntityCacheUtil.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
				BookImpl.class, book.getPrimaryKey());
		}
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public Book create(long bookId) {
		Book book = new BookImpl();

		book.setNew(true);
		book.setPrimaryKey(bookId);

		return book;
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws com.mpower.services.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book remove(long bookId) throws NoSuchBookException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book that was removed
	 * @throws com.mpower.services.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Book remove(Serializable primaryKey)
		throws NoSuchBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Book book = (Book)session.get(BookImpl.class, primaryKey);

			if (book == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(book);
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
	protected Book removeImpl(Book book) throws SystemException {
		book = toUnwrappedModel(book);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, book);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(book);

		return book;
	}

	@Override
	public Book updateImpl(com.mpower.services.model.Book book, boolean merge)
		throws SystemException {
		book = toUnwrappedModel(book);

		boolean isNew = book.isNew();

		BookModelImpl bookModelImpl = (BookModelImpl)book;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, book, merge);

			book.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(bookModelImpl.getOriginalBookNumber())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKNUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKNUMBER,
					args);

				args = new Object[] { Long.valueOf(bookModelImpl.getBookNumber()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOKNUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKNUMBER,
					args);
			}
		}

		EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey(), book);

		return book;
	}

	protected Book toUnwrappedModel(Book book) {
		if (book instanceof BookImpl) {
			return book;
		}

		BookImpl bookImpl = new BookImpl();

		bookImpl.setNew(book.isNew());
		bookImpl.setPrimaryKey(book.getPrimaryKey());

		bookImpl.setBookId(book.getBookId());
		bookImpl.setBookNumber(book.getBookNumber());
		bookImpl.setWriterName(book.getWriterName());
		bookImpl.setCreateDate(book.getCreateDate());
		bookImpl.setFirstName(book.getFirstName());
		bookImpl.setLastName(book.getLastName());
		bookImpl.setQuantity(book.getQuantity());
		bookImpl.setTotalCost(book.getTotalCost());
		bookImpl.setStatus(book.getStatus());

		return bookImpl;
	}

	/**
	 * Returns the book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book
	 * @throws com.liferay.portal.NoSuchModelException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Book findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the book with the primary key or throws a {@link com.mpower.services.NoSuchBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws com.mpower.services.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book findByPrimaryKey(long bookId)
		throws NoSuchBookException, SystemException {
		Book book = fetchByPrimaryKey(bookId);

		if (book == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return book;
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Book fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book fetchByPrimaryKey(long bookId) throws SystemException {
		Book book = (Book)EntityCacheUtil.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
				BookImpl.class, bookId);

		if (book == _nullBook) {
			return null;
		}

		if (book == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				book = (Book)session.get(BookImpl.class, Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (book != null) {
					cacheResult(book);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
						BookImpl.class, bookId, _nullBook);
				}

				closeSession(session);
			}
		}

		return book;
	}

	/**
	 * Returns all the books where bookNumber = &#63;.
	 *
	 * @param bookNumber the book number
	 * @return the matching books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findBybookNumber(long bookNumber)
		throws SystemException {
		return findBybookNumber(bookNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books where bookNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookNumber the book number
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findBybookNumber(long bookNumber, int start, int end)
		throws SystemException {
		return findBybookNumber(bookNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the books where bookNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookNumber the book number
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findBybookNumber(long bookNumber, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKNUMBER;
			finderArgs = new Object[] { bookNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKNUMBER;
			finderArgs = new Object[] { bookNumber, start, end, orderByComparator };
		}

		List<Book> list = (List<Book>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_BOOK_WHERE);

			query.append(_FINDER_COLUMN_BOOKNUMBER_BOOKNUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookNumber);

				list = (List<Book>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first book in the ordered set where bookNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookNumber the book number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws com.mpower.services.NoSuchBookException if a matching book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book findBybookNumber_First(long bookNumber,
		OrderByComparator orderByComparator)
		throws NoSuchBookException, SystemException {
		List<Book> list = findBybookNumber(bookNumber, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookNumber=");
			msg.append(bookNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBookException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last book in the ordered set where bookNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookNumber the book number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws com.mpower.services.NoSuchBookException if a matching book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book findBybookNumber_Last(long bookNumber,
		OrderByComparator orderByComparator)
		throws NoSuchBookException, SystemException {
		int count = countBybookNumber(bookNumber);

		List<Book> list = findBybookNumber(bookNumber, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookNumber=");
			msg.append(bookNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBookException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the books before and after the current book in the ordered set where bookNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookId the primary key of the current book
	 * @param bookNumber the book number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws com.mpower.services.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book[] findBybookNumber_PrevAndNext(long bookId, long bookNumber,
		OrderByComparator orderByComparator)
		throws NoSuchBookException, SystemException {
		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getBybookNumber_PrevAndNext(session, book, bookNumber,
					orderByComparator, true);

			array[1] = book;

			array[2] = getBybookNumber_PrevAndNext(session, book, bookNumber,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getBybookNumber_PrevAndNext(Session session, Book book,
		long bookNumber, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOK_WHERE);

		query.append(_FINDER_COLUMN_BOOKNUMBER_BOOKNUMBER_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bookNumber);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(book);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Book> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findAll(int start, int end,
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

		List<Book> list = (List<Book>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the books where bookNumber = &#63; from the database.
	 *
	 * @param bookNumber the book number
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBybookNumber(long bookNumber) throws SystemException {
		for (Book book : findBybookNumber(bookNumber)) {
			remove(book);
		}
	}

	/**
	 * Removes all the books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Book book : findAll()) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books where bookNumber = &#63;.
	 *
	 * @param bookNumber the book number
	 * @return the number of matching books
	 * @throws SystemException if a system exception occurred
	 */
	public int countBybookNumber(long bookNumber) throws SystemException {
		Object[] finderArgs = new Object[] { bookNumber };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOKNUMBER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOK_WHERE);

			query.append(_FINDER_COLUMN_BOOKNUMBER_BOOKNUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookNumber);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOKNUMBER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOK);

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
	 * Returns all the ext work flows associated with the book.
	 *
	 * @param pk the primary key of the book
	 * @return the ext work flows associated with the book
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.mpower.services.model.ExtWorkFlow> getExtWorkFlows(long pk)
		throws SystemException {
		return getExtWorkFlows(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the ext work flows associated with the book.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the book
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of ext work flows associated with the book
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.mpower.services.model.ExtWorkFlow> getExtWorkFlows(
		long pk, int start, int end) throws SystemException {
		return getExtWorkFlows(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_EXTWORKFLOWS = new FinderPath(com.mpower.services.model.impl.ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			com.mpower.services.model.impl.ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED,
			com.mpower.services.model.impl.ExtWorkFlowImpl.class,
			com.mpower.services.service.persistence.ExtWorkFlowPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getExtWorkFlows",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Returns an ordered range of all the ext work flows associated with the book.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the book
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ext work flows associated with the book
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.mpower.services.model.ExtWorkFlow> getExtWorkFlows(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.mpower.services.model.ExtWorkFlow> list = (List<com.mpower.services.model.ExtWorkFlow>)FinderCacheUtil.getResult(FINDER_PATH_GET_EXTWORKFLOWS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETEXTWORKFLOWS.concat(ORDER_BY_CLAUSE)
											  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETEXTWORKFLOWS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ExtWorkFlow",
					com.mpower.services.model.impl.ExtWorkFlowImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.mpower.services.model.ExtWorkFlow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_EXTWORKFLOWS,
						finderArgs);
				}
				else {
					extWorkFlowPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_EXTWORKFLOWS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_EXTWORKFLOWS_SIZE = new FinderPath(com.mpower.services.model.impl.ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			com.mpower.services.model.impl.ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED,
			com.mpower.services.model.impl.ExtWorkFlowImpl.class,
			com.mpower.services.service.persistence.ExtWorkFlowPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getExtWorkFlowsSize", new String[] { Long.class.getName() });

	/**
	 * Returns the number of ext work flows associated with the book.
	 *
	 * @param pk the primary key of the book
	 * @return the number of ext work flows associated with the book
	 * @throws SystemException if a system exception occurred
	 */
	public int getExtWorkFlowsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_EXTWORKFLOWS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETEXTWORKFLOWSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_EXTWORKFLOWS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_EXTWORKFLOW = new FinderPath(com.mpower.services.model.impl.ExtWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
			com.mpower.services.model.impl.ExtWorkFlowModelImpl.FINDER_CACHE_ENABLED,
			com.mpower.services.model.impl.ExtWorkFlowImpl.class,
			com.mpower.services.service.persistence.ExtWorkFlowPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsExtWorkFlow",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the ext work flow is associated with the book.
	 *
	 * @param pk the primary key of the book
	 * @param extWorkFlowPK the primary key of the ext work flow
	 * @return <code>true</code> if the ext work flow is associated with the book; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsExtWorkFlow(long pk, long extWorkFlowPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, extWorkFlowPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_EXTWORKFLOW,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsExtWorkFlow.contains(pk,
							extWorkFlowPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_EXTWORKFLOW,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the book has any ext work flows associated with it.
	 *
	 * @param pk the primary key of the book to check for associations with ext work flows
	 * @return <code>true</code> if the book has any ext work flows associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsExtWorkFlows(long pk) throws SystemException {
		if (getExtWorkFlowsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.mpower.services.model.Book")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Book>> listenersList = new ArrayList<ModelListener<Book>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Book>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsExtWorkFlow = new ContainsExtWorkFlow();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = ExtWorkFlowPersistence.class)
	protected ExtWorkFlowPersistence extWorkFlowPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = RatingsStatsPersistence.class)
	protected RatingsStatsPersistence ratingsStatsPersistence;
	protected ContainsExtWorkFlow containsExtWorkFlow;

	protected class ContainsExtWorkFlow {
		protected ContainsExtWorkFlow() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSEXTWORKFLOW,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long bookId, long extWorkflowId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(bookId), new Long(extWorkflowId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_BOOK = "SELECT book FROM Book book";
	private static final String _SQL_SELECT_BOOK_WHERE = "SELECT book FROM Book book WHERE ";
	private static final String _SQL_COUNT_BOOK = "SELECT COUNT(book) FROM Book book";
	private static final String _SQL_COUNT_BOOK_WHERE = "SELECT COUNT(book) FROM Book book WHERE ";
	private static final String _SQL_GETEXTWORKFLOWS = "SELECT {ExtWorkFlow.*} FROM ExtWorkFlow INNER JOIN Book ON (Book.bookId = ExtWorkFlow.bookId) WHERE (Book.bookId = ?)";
	private static final String _SQL_GETEXTWORKFLOWSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ExtWorkFlow WHERE bookId = ?";
	private static final String _SQL_CONTAINSEXTWORKFLOW = "SELECT COUNT(*) AS COUNT_VALUE FROM ExtWorkFlow WHERE bookId = ? AND extWorkflowId = ?";
	private static final String _FINDER_COLUMN_BOOKNUMBER_BOOKNUMBER_2 = "book.bookNumber = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "book.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Book exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Book exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookPersistenceImpl.class);
	private static Book _nullBook = new BookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Book> toCacheModel() {
				return _nullBookCacheModel;
			}
		};

	private static CacheModel<Book> _nullBookCacheModel = new CacheModel<Book>() {
			public Book toEntityModel() {
				return _nullBook;
			}
		};
}