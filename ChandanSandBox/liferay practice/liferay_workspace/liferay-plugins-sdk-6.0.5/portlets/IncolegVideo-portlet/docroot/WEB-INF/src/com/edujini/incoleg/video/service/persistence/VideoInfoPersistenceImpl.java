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

package com.edujini.incoleg.video.service.persistence;

import com.edujini.incoleg.video.NoSuchVideoInfoException;
import com.edujini.incoleg.video.model.VideoInfo;
import com.edujini.incoleg.video.model.impl.VideoInfoImpl;
import com.edujini.incoleg.video.model.impl.VideoInfoModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the video info service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link VideoInfoUtil} to access the video info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see VideoInfoPersistence
 * @see VideoInfoUtil
 * @generated
 */
public class VideoInfoPersistenceImpl extends BasePersistenceImpl<VideoInfo>
	implements VideoInfoPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = VideoInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_FILENAME = new FinderPath(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByFileName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_FILENAME = new FinderPath(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByFileName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the video info in the entity cache if it is enabled.
	 *
	 * @param videoInfo the video info to cache
	 */
	public void cacheResult(VideoInfo videoInfo) {
		EntityCacheUtil.putResult(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoImpl.class, videoInfo.getPrimaryKey(), videoInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILENAME,
			new Object[] { videoInfo.getMappedFileName() }, videoInfo);
	}

	/**
	 * Caches the video infos in the entity cache if it is enabled.
	 *
	 * @param videoInfos the video infos to cache
	 */
	public void cacheResult(List<VideoInfo> videoInfos) {
		for (VideoInfo videoInfo : videoInfos) {
			if (EntityCacheUtil.getResult(
						VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
						VideoInfoImpl.class, videoInfo.getPrimaryKey(), this) == null) {
				cacheResult(videoInfo);
			}
		}
	}

	/**
	 * Clears the cache for all video infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(VideoInfoImpl.class.getName());
		EntityCacheUtil.clearCache(VideoInfoImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the video info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(VideoInfo videoInfo) {
		EntityCacheUtil.removeResult(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoImpl.class, videoInfo.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILENAME,
			new Object[] { videoInfo.getMappedFileName() });
	}

	/**
	 * Creates a new video info with the primary key. Does not add the video info to the database.
	 *
	 * @param videoId the primary key for the new video info
	 * @return the new video info
	 */
	public VideoInfo create(String videoId) {
		VideoInfo videoInfo = new VideoInfoImpl();

		videoInfo.setNew(true);
		videoInfo.setPrimaryKey(videoId);

		return videoInfo;
	}

	/**
	 * Removes the video info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video info to remove
	 * @return the video info that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove((String)primaryKey);
	}

	/**
	 * Removes the video info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video info to remove
	 * @return the video info that was removed
	 * @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo remove(String videoId)
		throws NoSuchVideoInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoInfo videoInfo = (VideoInfo)session.get(VideoInfoImpl.class,
					videoId);

			if (videoInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoId);
				}

				throw new NoSuchVideoInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					videoId);
			}

			return remove(videoInfo);
		}
		catch (NoSuchVideoInfoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoInfo removeImpl(VideoInfo videoInfo)
		throws SystemException {
		videoInfo = toUnwrappedModel(videoInfo);

		Session session = null;

		try {
			session = openSession();

			if (videoInfo.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(VideoInfoImpl.class,
						videoInfo.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(videoInfo);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		VideoInfoModelImpl videoInfoModelImpl = (VideoInfoModelImpl)videoInfo;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILENAME,
			new Object[] { videoInfoModelImpl.getOriginalMappedFileName() });

		EntityCacheUtil.removeResult(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoImpl.class, videoInfo.getPrimaryKey());

		return videoInfo;
	}

	public VideoInfo updateImpl(
		com.edujini.incoleg.video.model.VideoInfo videoInfo, boolean merge)
		throws SystemException {
		videoInfo = toUnwrappedModel(videoInfo);

		boolean isNew = videoInfo.isNew();

		VideoInfoModelImpl videoInfoModelImpl = (VideoInfoModelImpl)videoInfo;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoInfo, merge);

			videoInfo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
			VideoInfoImpl.class, videoInfo.getPrimaryKey(), videoInfo);

		if (!isNew &&
				(!Validator.equals(videoInfo.getMappedFileName(),
					videoInfoModelImpl.getOriginalMappedFileName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILENAME,
				new Object[] { videoInfoModelImpl.getOriginalMappedFileName() });
		}

		if (isNew ||
				(!Validator.equals(videoInfo.getMappedFileName(),
					videoInfoModelImpl.getOriginalMappedFileName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILENAME,
				new Object[] { videoInfo.getMappedFileName() }, videoInfo);
		}

		return videoInfo;
	}

	protected VideoInfo toUnwrappedModel(VideoInfo videoInfo) {
		if (videoInfo instanceof VideoInfoImpl) {
			return videoInfo;
		}

		VideoInfoImpl videoInfoImpl = new VideoInfoImpl();

		videoInfoImpl.setNew(videoInfo.isNew());
		videoInfoImpl.setPrimaryKey(videoInfo.getPrimaryKey());

		videoInfoImpl.setVideoId(videoInfo.getVideoId());
		videoInfoImpl.setFileName(videoInfo.getFileName());
		videoInfoImpl.setMappedFileName(videoInfo.getMappedFileName());
		videoInfoImpl.setFileType(videoInfo.getFileType());
		videoInfoImpl.setFileSize(videoInfo.getFileSize());
		videoInfoImpl.setFileDesc(videoInfo.getFileDesc());
		videoInfoImpl.setUserEmail(videoInfo.getUserEmail());
		videoInfoImpl.setUploadTime(videoInfo.getUploadTime());
		videoInfoImpl.setVurl(videoInfo.getVurl());
		videoInfoImpl.setStatus(videoInfo.getStatus());

		return videoInfoImpl;
	}

	/**
	 * Finds the video info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video info to find
	 * @return the video info
	 * @throws com.liferay.portal.NoSuchModelException if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Finds the video info with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchVideoInfoException} if it could not be found.
	 *
	 * @param videoId the primary key of the video info to find
	 * @return the video info
	 * @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo findByPrimaryKey(String videoId)
		throws NoSuchVideoInfoException, SystemException {
		VideoInfo videoInfo = fetchByPrimaryKey(videoId);

		if (videoInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoId);
			}

			throw new NoSuchVideoInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoId);
		}

		return videoInfo;
	}

	/**
	 * Finds the video info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video info to find
	 * @return the video info, or <code>null</code> if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Finds the video info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video info to find
	 * @return the video info, or <code>null</code> if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo fetchByPrimaryKey(String videoId)
		throws SystemException {
		VideoInfo videoInfo = (VideoInfo)EntityCacheUtil.getResult(VideoInfoModelImpl.ENTITY_CACHE_ENABLED,
				VideoInfoImpl.class, videoId, this);

		if (videoInfo == null) {
			Session session = null;

			try {
				session = openSession();

				videoInfo = (VideoInfo)session.get(VideoInfoImpl.class, videoId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (videoInfo != null) {
					cacheResult(videoInfo);
				}

				closeSession(session);
			}
		}

		return videoInfo;
	}

	/**
	 * Finds the video info where mappedFileName = &#63; or throws a {@link com.edujini.incoleg.video.NoSuchVideoInfoException} if it could not be found.
	 *
	 * @param mappedFileName the mapped file name to search with
	 * @return the matching video info
	 * @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a matching video info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo findByFileName(String mappedFileName)
		throws NoSuchVideoInfoException, SystemException {
		VideoInfo videoInfo = fetchByFileName(mappedFileName);

		if (videoInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mappedFileName=");
			msg.append(mappedFileName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVideoInfoException(msg.toString());
		}

		return videoInfo;
	}

	/**
	 * Finds the video info where mappedFileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mappedFileName the mapped file name to search with
	 * @return the matching video info, or <code>null</code> if a matching video info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo fetchByFileName(String mappedFileName)
		throws SystemException {
		return fetchByFileName(mappedFileName, true);
	}

	/**
	 * Finds the video info where mappedFileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mappedFileName the mapped file name to search with
	 * @return the matching video info, or <code>null</code> if a matching video info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo fetchByFileName(String mappedFileName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { mappedFileName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FILENAME,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_SELECT_VIDEOINFO_WHERE);

				if (mappedFileName == null) {
					query.append(_FINDER_COLUMN_FILENAME_MAPPEDFILENAME_1);
				}
				else {
					if (mappedFileName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_FILENAME_MAPPEDFILENAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_FILENAME_MAPPEDFILENAME_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (mappedFileName != null) {
					qPos.add(mappedFileName);
				}

				List<VideoInfo> list = q.list();

				result = list;

				VideoInfo videoInfo = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILENAME,
						finderArgs, list);
				}
				else {
					videoInfo = list.get(0);

					cacheResult(videoInfo);

					if ((videoInfo.getMappedFileName() == null) ||
							!videoInfo.getMappedFileName().equals(mappedFileName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILENAME,
							finderArgs, videoInfo);
					}
				}

				return videoInfo;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILENAME,
						finderArgs, new ArrayList<VideoInfo>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (VideoInfo)result;
			}
		}
	}

	/**
	 * Finds all the video infos.
	 *
	 * @return the video infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the video infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video infos to return
	 * @param end the upper bound of the range of video infos to return (not inclusive)
	 * @return the range of video infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the video infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video infos to return
	 * @param end the upper bound of the range of video infos to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of video infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoInfo> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<VideoInfo> list = (List<VideoInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_VIDEOINFO);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_VIDEOINFO;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<VideoInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the video info where mappedFileName = &#63; from the database.
	 *
	 * @param mappedFileName the mapped file name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFileName(String mappedFileName)
		throws NoSuchVideoInfoException, SystemException {
		VideoInfo videoInfo = findByFileName(mappedFileName);

		remove(videoInfo);
	}

	/**
	 * Removes all the video infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoInfo videoInfo : findAll()) {
			remove(videoInfo);
		}
	}

	/**
	 * Counts all the video infos where mappedFileName = &#63;.
	 *
	 * @param mappedFileName the mapped file name to search with
	 * @return the number of matching video infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFileName(String mappedFileName) throws SystemException {
		Object[] finderArgs = new Object[] { mappedFileName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILENAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_VIDEOINFO_WHERE);

				if (mappedFileName == null) {
					query.append(_FINDER_COLUMN_FILENAME_MAPPEDFILENAME_1);
				}
				else {
					if (mappedFileName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_FILENAME_MAPPEDFILENAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_FILENAME_MAPPEDFILENAME_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (mappedFileName != null) {
					qPos.add(mappedFileName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the video infos.
	 *
	 * @return the number of video infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOINFO);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the video info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.edujini.incoleg.video.model.VideoInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoInfo>> listenersList = new ArrayList<ModelListener<VideoInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoInfo>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = VideoInfoPersistence.class)
	protected VideoInfoPersistence videoInfoPersistence;
	@BeanReference(type = StoreSettingsPersistence.class)
	protected StoreSettingsPersistence storeSettingsPersistence;
	@BeanReference(type = VOMapPersistence.class)
	protected VOMapPersistence voMapPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VIDEOINFO = "SELECT videoInfo FROM VideoInfo videoInfo";
	private static final String _SQL_SELECT_VIDEOINFO_WHERE = "SELECT videoInfo FROM VideoInfo videoInfo WHERE ";
	private static final String _SQL_COUNT_VIDEOINFO = "SELECT COUNT(videoInfo) FROM VideoInfo videoInfo";
	private static final String _SQL_COUNT_VIDEOINFO_WHERE = "SELECT COUNT(videoInfo) FROM VideoInfo videoInfo WHERE ";
	private static final String _FINDER_COLUMN_FILENAME_MAPPEDFILENAME_1 = "videoInfo.mappedFileName IS NULL";
	private static final String _FINDER_COLUMN_FILENAME_MAPPEDFILENAME_2 = "videoInfo.mappedFileName = ?";
	private static final String _FINDER_COLUMN_FILENAME_MAPPEDFILENAME_3 = "(videoInfo.mappedFileName IS NULL OR videoInfo.mappedFileName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoInfo exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(VideoInfoPersistenceImpl.class);
}