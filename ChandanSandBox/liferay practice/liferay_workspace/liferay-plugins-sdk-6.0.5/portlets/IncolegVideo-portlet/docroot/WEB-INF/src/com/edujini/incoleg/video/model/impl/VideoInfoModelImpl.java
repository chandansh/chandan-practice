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

package com.edujini.incoleg.video.model.impl;

import com.edujini.incoleg.video.model.VideoInfo;
import com.edujini.incoleg.video.model.VideoInfoModel;
import com.edujini.incoleg.video.model.VideoInfoSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the VideoInfo service. Represents a row in the &quot;video_VideoInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.edujini.incoleg.video.model.VideoInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VideoInfoImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a video info model instance should use the {@link com.edujini.incoleg.video.model.VideoInfo} interface instead.
 * </p>
 *
 * @author Edujini
 * @see VideoInfoImpl
 * @see com.edujini.incoleg.video.model.VideoInfo
 * @see com.edujini.incoleg.video.model.VideoInfoModel
 * @generated
 */
public class VideoInfoModelImpl extends BaseModelImpl<VideoInfo>
	implements VideoInfoModel {
	public static final String TABLE_NAME = "video_VideoInfo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "videoId", new Integer(Types.VARCHAR) },
			{ "fileName", new Integer(Types.VARCHAR) },
			{ "mappedFileName", new Integer(Types.VARCHAR) },
			{ "fileType", new Integer(Types.VARCHAR) },
			{ "fileSize", new Integer(Types.DOUBLE) },
			{ "fileDesc", new Integer(Types.VARCHAR) },
			{ "userEmail", new Integer(Types.VARCHAR) },
			{ "uploadTime", new Integer(Types.TIMESTAMP) },
			{ "vurl", new Integer(Types.VARCHAR) },
			{ "status", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table video_VideoInfo (videoId VARCHAR(75) not null primary key,fileName VARCHAR(75) null,mappedFileName VARCHAR(75) null,fileType VARCHAR(75) null,fileSize DOUBLE,fileDesc VARCHAR(75) null,userEmail VARCHAR(75) null,uploadTime DATE null,vurl VARCHAR(75) null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table video_VideoInfo";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.edujini.incoleg.video.model.VideoInfo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.edujini.incoleg.video.model.VideoInfo"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VideoInfo toModel(VideoInfoSoap soapModel) {
		VideoInfo model = new VideoInfoImpl();

		model.setVideoId(soapModel.getVideoId());
		model.setFileName(soapModel.getFileName());
		model.setMappedFileName(soapModel.getMappedFileName());
		model.setFileType(soapModel.getFileType());
		model.setFileSize(soapModel.getFileSize());
		model.setFileDesc(soapModel.getFileDesc());
		model.setUserEmail(soapModel.getUserEmail());
		model.setUploadTime(soapModel.getUploadTime());
		model.setVurl(soapModel.getVurl());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VideoInfo> toModels(VideoInfoSoap[] soapModels) {
		List<VideoInfo> models = new ArrayList<VideoInfo>(soapModels.length);

		for (VideoInfoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.edujini.incoleg.video.model.VideoInfo"));

	public VideoInfoModelImpl() {
	}

	public String getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(String pk) {
		setVideoId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _videoId;
	}

	public String getVideoId() {
		if (_videoId == null) {
			return StringPool.BLANK;
		}
		else {
			return _videoId;
		}
	}

	public void setVideoId(String videoId) {
		_videoId = videoId;
	}

	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getMappedFileName() {
		if (_mappedFileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappedFileName;
		}
	}

	public void setMappedFileName(String mappedFileName) {
		_mappedFileName = mappedFileName;

		if (_originalMappedFileName == null) {
			_originalMappedFileName = mappedFileName;
		}
	}

	public String getOriginalMappedFileName() {
		return GetterUtil.getString(_originalMappedFileName);
	}

	public String getFileType() {
		if (_fileType == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileType;
		}
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	public double getFileSize() {
		return _fileSize;
	}

	public void setFileSize(double fileSize) {
		_fileSize = fileSize;
	}

	public String getFileDesc() {
		if (_fileDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileDesc;
		}
	}

	public void setFileDesc(String fileDesc) {
		_fileDesc = fileDesc;
	}

	public String getUserEmail() {
		if (_userEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _userEmail;
		}
	}

	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;
	}

	public Date getUploadTime() {
		return _uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		_uploadTime = uploadTime;
	}

	public String getVurl() {
		if (_vurl == null) {
			return StringPool.BLANK;
		}
		else {
			return _vurl;
		}
	}

	public void setVurl(String vurl) {
		_vurl = vurl;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public VideoInfo toEscapedModel() {
		if (isEscapedModel()) {
			return (VideoInfo)this;
		}
		else {
			return (VideoInfo)Proxy.newProxyInstance(VideoInfo.class.getClassLoader(),
				new Class[] { VideoInfo.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		VideoInfoImpl clone = new VideoInfoImpl();

		clone.setVideoId(getVideoId());
		clone.setFileName(getFileName());
		clone.setMappedFileName(getMappedFileName());
		clone.setFileType(getFileType());
		clone.setFileSize(getFileSize());
		clone.setFileDesc(getFileDesc());
		clone.setUserEmail(getUserEmail());
		clone.setUploadTime(getUploadTime());
		clone.setVurl(getVurl());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(VideoInfo videoInfo) {
		String pk = videoInfo.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VideoInfo videoInfo = null;

		try {
			videoInfo = (VideoInfo)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = videoInfo.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{videoId=");
		sb.append(getVideoId());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", mappedFileName=");
		sb.append(getMappedFileName());
		sb.append(", fileType=");
		sb.append(getFileType());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", fileDesc=");
		sb.append(getFileDesc());
		sb.append(", userEmail=");
		sb.append(getUserEmail());
		sb.append(", uploadTime=");
		sb.append(getUploadTime());
		sb.append(", vurl=");
		sb.append(getVurl());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.edujini.incoleg.video.model.VideoInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappedFileName</column-name><column-value><![CDATA[");
		sb.append(getMappedFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileType</column-name><column-value><![CDATA[");
		sb.append(getFileType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileSize</column-name><column-value><![CDATA[");
		sb.append(getFileSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileDesc</column-name><column-value><![CDATA[");
		sb.append(getFileDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userEmail</column-name><column-value><![CDATA[");
		sb.append(getUserEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadTime</column-name><column-value><![CDATA[");
		sb.append(getUploadTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vurl</column-name><column-value><![CDATA[");
		sb.append(getVurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _videoId;
	private String _fileName;
	private String _mappedFileName;
	private String _originalMappedFileName;
	private String _fileType;
	private double _fileSize;
	private String _fileDesc;
	private String _userEmail;
	private Date _uploadTime;
	private String _vurl;
	private int _status;
}