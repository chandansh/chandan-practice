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

package com.edujini.incoleg.video.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Edujini
 */
public class VideoInfoClp extends BaseModelImpl<VideoInfo> implements VideoInfo {
	public VideoInfoClp() {
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
		return _videoId;
	}

	public void setVideoId(String videoId) {
		_videoId = videoId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getMappedFileName() {
		return _mappedFileName;
	}

	public void setMappedFileName(String mappedFileName) {
		_mappedFileName = mappedFileName;
	}

	public String getFileType() {
		return _fileType;
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
		return _fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		_fileDesc = fileDesc;
	}

	public String getUserEmail() {
		return _userEmail;
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
		return _vurl;
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
			return this;
		}
		else {
			return (VideoInfo)Proxy.newProxyInstance(VideoInfo.class.getClassLoader(),
				new Class[] { VideoInfo.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		VideoInfoClp clone = new VideoInfoClp();

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

		VideoInfoClp videoInfo = null;

		try {
			videoInfo = (VideoInfoClp)obj;
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
	private String _fileType;
	private double _fileSize;
	private String _fileDesc;
	private String _userEmail;
	private Date _uploadTime;
	private String _vurl;
	private int _status;
}