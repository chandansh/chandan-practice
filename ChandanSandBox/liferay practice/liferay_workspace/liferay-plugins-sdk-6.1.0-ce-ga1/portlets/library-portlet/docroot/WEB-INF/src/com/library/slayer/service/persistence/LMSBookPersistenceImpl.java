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
import com.library.slayer.model.LMSBook;
import com.library.slayer.model.impl.LMSBookImpl;
import com.library.slayer.model.impl.LMSBookModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see LMSBookPersistence
 * @see LMSBookUtil
 * @generated
 */
public class LMSBookPersistenceImpl extends BasePersistenceImpl<LMSBook>
	implements LMSBookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSBookUtil} to access the l m s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSBookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LMSBookModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			LMSBookModelImpl.UUID_COLUMN_BITMASK |
			LMSBookModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_BOOK = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBook",
			new String[] { String.class.getName() },
			LMSBookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOK = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBook",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the l m s book in the entity cache if it is enabled.
	 *
	 * @param lmsBook the l m s book
	 */
	public void cacheResult(LMSBook lmsBook) {
		EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey(), lmsBook);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { lmsBook.getUuid(), Long.valueOf(lmsBook.getGroupId()) },
			lmsBook);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOK,
			new Object[] { lmsBook.getBookTitle() }, lmsBook);

		lmsBook.resetOriginalValues();
	}

	/**
	 * Caches the l m s books in the entity cache if it is enabled.
	 *
	 * @param lmsBooks the l m s books
	 */
	public void cacheResult(List<LMSBook> lmsBooks) {
		for (LMSBook lmsBook : lmsBooks) {
			if (EntityCacheUtil.getResult(
						LMSBookModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookImpl.class, lmsBook.getPrimaryKey()) == null) {
				cacheResult(lmsBook);
			}
			else {
				lmsBook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSBookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSBookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSBook lmsBook) {
		EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(lmsBook);
	}

	@Override
	public void clearCache(List<LMSBook> lmsBooks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSBook lmsBook : lmsBooks) {
			EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookImpl.class, lmsBook.getPrimaryKey());

			clearUniqueFindersCache(lmsBook);
		}
	}

	protected void clearUniqueFindersCache(LMSBook lmsBook) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { lmsBook.getUuid(), Long.valueOf(lmsBook.getGroupId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BOOK,
			new Object[] { lmsBook.getBookTitle() });
	}

	/**
	 * Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	 *
	 * @param bookId the primary key for the new l m s book
	 * @return the new l m s book
	 */
	public LMSBook create(long bookId) {
		LMSBook lmsBook = new LMSBookImpl();

		lmsBook.setNew(true);
		lmsBook.setPrimaryKey(bookId);

		String uuid = PortalUUIDUtil.generate();

		lmsBook.setUuid(uuid);

		return lmsBook;
	}

	/**
	 * Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book that was removed
	 * @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook remove(long bookId)
		throws NoSuchBookException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book that was removed
	 * @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook remove(Serializable primaryKey)
		throws NoSuchBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSBook lmsBook = (LMSBook)session.get(LMSBookImpl.class, primaryKey);

			if (lmsBook == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsBook);
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
	protected LMSBook removeImpl(LMSBook lmsBook) throws SystemException {
		lmsBook = toUnwrappedModel(lmsBook);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lmsBook);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lmsBook);

		return lmsBook;
	}

	@Override
	public LMSBook updateImpl(com.library.slayer.model.LMSBook lmsBook,
		boolean merge) throws SystemException {
		lmsBook = toUnwrappedModel(lmsBook);

		boolean isNew = lmsBook.isNew();

		LMSBookModelImpl lmsBookModelImpl = (LMSBookModelImpl)lmsBook;

		if (Validator.isNull(lmsBook.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			lmsBook.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmsBook, merge);

			lmsBook.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LMSBookModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lmsBookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { lmsBookModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { lmsBookModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey(), lmsBook);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					lmsBook.getUuid(), Long.valueOf(lmsBook.getGroupId())
				}, lmsBook);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOK,
				new Object[] { lmsBook.getBookTitle() }, lmsBook);
		}
		else {
			if ((lmsBookModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsBookModelImpl.getOriginalUuid(),
						Long.valueOf(lmsBookModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] {
						lmsBook.getUuid(), Long.valueOf(lmsBook.getGroupId())
					}, lmsBook);
			}

			if ((lmsBookModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BOOK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lmsBookModelImpl.getOriginalBookTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BOOK, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOK,
					new Object[] { lmsBook.getBookTitle() }, lmsBook);
			}
		}

		return lmsBook;
	}

	protected LMSBook toUnwrappedModel(LMSBook lmsBook) {
		if (lmsBook instanceof LMSBookImpl) {
			return lmsBook;
		}

		LMSBookImpl lmsBookImpl = new LMSBookImpl();

		lmsBookImpl.setNew(lmsBook.isNew());
		lmsBookImpl.setPrimaryKey(lmsBook.getPrimaryKey());

		lmsBookImpl.setUuid(lmsBook.getUuid());
		lmsBookImpl.setBookId(lmsBook.getBookId());
		lmsBookImpl.setBookTitle(lmsBook.getBookTitle());
		lmsBookImpl.setAuthor(lmsBook.getAuthor());
		lmsBookImpl.setDescription(lmsBook.getDescription());
		lmsBookImpl.setFileName(lmsBook.getFileName());
		lmsBookImpl.setDownloaded(lmsBook.getDownloaded());
		lmsBookImpl.setStatus(lmsBook.getStatus());
		lmsBookImpl.setCompanyId(lmsBook.getCompanyId());
		lmsBookImpl.setGroupId(lmsBook.getGroupId());
		lmsBookImpl.setCreateDate(lmsBook.getCreateDate());
		lmsBookImpl.setModifiedDate(lmsBook.getModifiedDate());
		lmsBookImpl.setUserId(lmsBook.getUserId());
		lmsBookImpl.setUserName(lmsBook.getUserName());

		return lmsBookImpl;
	}

	/**
	 * Returns the l m s book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book
	 * @throws com.liferay.portal.NoSuchModelException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l m s book with the primary key or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book
	 * @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook findByPrimaryKey(long bookId)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = fetchByPrimaryKey(bookId);

		if (lmsBook == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook fetchByPrimaryKey(long bookId) throws SystemException {
		LMSBook lmsBook = (LMSBook)EntityCacheUtil.getResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookImpl.class, bookId);

		if (lmsBook == _nullLMSBook) {
			return null;
		}

		if (lmsBook == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lmsBook = (LMSBook)session.get(LMSBookImpl.class,
						Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lmsBook != null) {
					cacheResult(lmsBook);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookImpl.class, bookId, _nullLMSBook);
				}

				closeSession(session);
			}
		}

		return lmsBook;
	}

	/**
	 * Returns all the l m s books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @return the range of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<LMSBook> list = (List<LMSBook>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LMSBOOK_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

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

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<LMSBook>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first l m s book in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l m s book
	 * @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchBookException, SystemException {
		List<LMSBook> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBookException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last l m s book in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l m s book
	 * @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchBookException, SystemException {
		int count = countByUuid(uuid);

		List<LMSBook> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBookException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the l m s books before and after the current l m s book in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param bookId the primary key of the current l m s book
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l m s book
	 * @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook[] findByUuid_PrevAndNext(long bookId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			LMSBook[] array = new LMSBookImpl[3];

			array[0] = getByUuid_PrevAndNext(session, lmsBook, uuid,
					orderByComparator, true);

			array[1] = lmsBook;

			array[2] = getByUuid_PrevAndNext(session, lmsBook, uuid,
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

	protected LMSBook getByUuid_PrevAndNext(Session session, LMSBook lmsBook,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LMSBOOK_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

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

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lmsBook);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LMSBook> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the l m s book where uuid = &#63; and groupId = &#63; or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching l m s book
	 * @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook findByUUID_G(String uuid, long groupId)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = fetchByUUID_G(uuid, groupId);

		if (lmsBook == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBookException(msg.toString());
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the l m s book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LMSBOOK_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<LMSBook> list = q.list();

				result = list;

				LMSBook lmsBook = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					lmsBook = list.get(0);

					cacheResult(lmsBook);

					if ((lmsBook.getUuid() == null) ||
							!lmsBook.getUuid().equals(uuid) ||
							(lmsBook.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, lmsBook);
					}
				}

				return lmsBook;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (LMSBook)result;
			}
		}
	}

	/**
	 * Returns the l m s book where bookTitle = &#63; or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	 *
	 * @param bookTitle the book title
	 * @return the matching l m s book
	 * @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook findByBook(String bookTitle)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = fetchByBook(bookTitle);

		if (lmsBook == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookTitle=");
			msg.append(bookTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBookException(msg.toString());
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book where bookTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookTitle the book title
	 * @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook fetchByBook(String bookTitle) throws SystemException {
		return fetchByBook(bookTitle, true);
	}

	/**
	 * Returns the l m s book where bookTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookTitle the book title
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook fetchByBook(String bookTitle, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { bookTitle };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BOOK,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_LMSBOOK_WHERE);

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOK_BOOKTITLE_1);
			}
			else {
				if (bookTitle.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BOOK_BOOKTITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BOOK_BOOKTITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bookTitle != null) {
					qPos.add(bookTitle);
				}

				List<LMSBook> list = q.list();

				result = list;

				LMSBook lmsBook = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOK,
						finderArgs, list);
				}
				else {
					lmsBook = list.get(0);

					cacheResult(lmsBook);

					if ((lmsBook.getBookTitle() == null) ||
							!lmsBook.getBookTitle().equals(bookTitle)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BOOK,
							finderArgs, lmsBook);
					}
				}

				return lmsBook;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BOOK,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (LMSBook)result;
			}
		}
	}

	/**
	 * Returns all the l m s books.
	 *
	 * @return the l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @return the range of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findAll(int start, int end,
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

		List<LMSBook> list = (List<LMSBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSBOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSBOOK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l m s books where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (LMSBook lmsBook : findByUuid(uuid)) {
			remove(lmsBook);
		}
	}

	/**
	 * Removes the l m s book where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = findByUUID_G(uuid, groupId);

		remove(lmsBook);
	}

	/**
	 * Removes the l m s book where bookTitle = &#63; from the database.
	 *
	 * @param bookTitle the book title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBook(String bookTitle)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = findByBook(bookTitle);

		remove(lmsBook);
	}

	/**
	 * Removes all the l m s books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LMSBook lmsBook : findAll()) {
			remove(lmsBook);
		}
	}

	/**
	 * Returns the number of l m s books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSBOOK_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of l m s books where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LMSBOOK_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of l m s books where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @return the number of matching l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBook(String bookTitle) throws SystemException {
		Object[] finderArgs = new Object[] { bookTitle };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BOOK,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LMSBOOK_WHERE);

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOK_BOOKTITLE_1);
			}
			else {
				if (bookTitle.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BOOK_BOOKTITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BOOK_BOOKTITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bookTitle != null) {
					qPos.add(bookTitle);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BOOK,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of l m s books.
	 *
	 * @return the number of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LMSBOOK);

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
	 * Initializes the l m s book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.library.slayer.model.LMSBook")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSBook>> listenersList = new ArrayList<ModelListener<LMSBook>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LMSBook>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSBookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LMSBookPersistence.class)
	protected LMSBookPersistence lmsBookPersistence;
	@BeanReference(type = LMSBookJoinPersistence.class)
	protected LMSBookJoinPersistence lmsBookJoinPersistence;
	@BeanReference(type = MemberAddressPersistence.class)
	protected MemberAddressPersistence memberAddressPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	private static final String _SQL_SELECT_LMSBOOK = "SELECT lmsBook FROM LMSBook lmsBook";
	private static final String _SQL_SELECT_LMSBOOK_WHERE = "SELECT lmsBook FROM LMSBook lmsBook WHERE ";
	private static final String _SQL_COUNT_LMSBOOK = "SELECT COUNT(lmsBook) FROM LMSBook lmsBook";
	private static final String _SQL_COUNT_LMSBOOK_WHERE = "SELECT COUNT(lmsBook) FROM LMSBook lmsBook WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "lmsBook.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "lmsBook.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(lmsBook.uuid IS NULL OR lmsBook.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "lmsBook.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "lmsBook.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(lmsBook.uuid IS NULL OR lmsBook.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "lmsBook.groupId = ?";
	private static final String _FINDER_COLUMN_BOOK_BOOKTITLE_1 = "lmsBook.bookTitle IS NULL";
	private static final String _FINDER_COLUMN_BOOK_BOOKTITLE_2 = "lmsBook.bookTitle = ?";
	private static final String _FINDER_COLUMN_BOOK_BOOKTITLE_3 = "(lmsBook.bookTitle IS NULL OR lmsBook.bookTitle = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsBook.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSBook exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LMSBook exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSBookPersistenceImpl.class);
	private static LMSBook _nullLMSBook = new LMSBookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSBook> toCacheModel() {
				return _nullLMSBookCacheModel;
			}
		};

	private static CacheModel<LMSBook> _nullLMSBookCacheModel = new CacheModel<LMSBook>() {
			public LMSBook toEntityModel() {
				return _nullLMSBook;
			}
		};
}