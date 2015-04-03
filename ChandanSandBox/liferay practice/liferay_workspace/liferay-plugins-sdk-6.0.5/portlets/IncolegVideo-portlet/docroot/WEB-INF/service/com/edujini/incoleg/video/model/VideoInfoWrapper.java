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

/**
 * <p>
 * This class is a wrapper for {@link VideoInfo}.
 * </p>
 *
 * @author    Edujini
 * @see       VideoInfo
 * @generated
 */
public class VideoInfoWrapper implements VideoInfo {
	public VideoInfoWrapper(VideoInfo videoInfo) {
		_videoInfo = videoInfo;
	}

	public java.lang.String getPrimaryKey() {
		return _videoInfo.getPrimaryKey();
	}

	public void setPrimaryKey(java.lang.String pk) {
		_videoInfo.setPrimaryKey(pk);
	}

	public java.lang.String getVideoId() {
		return _videoInfo.getVideoId();
	}

	public void setVideoId(java.lang.String videoId) {
		_videoInfo.setVideoId(videoId);
	}

	public java.lang.String getFileName() {
		return _videoInfo.getFileName();
	}

	public void setFileName(java.lang.String fileName) {
		_videoInfo.setFileName(fileName);
	}

	public java.lang.String getMappedFileName() {
		return _videoInfo.getMappedFileName();
	}

	public void setMappedFileName(java.lang.String mappedFileName) {
		_videoInfo.setMappedFileName(mappedFileName);
	}

	public java.lang.String getFileType() {
		return _videoInfo.getFileType();
	}

	public void setFileType(java.lang.String fileType) {
		_videoInfo.setFileType(fileType);
	}

	public double getFileSize() {
		return _videoInfo.getFileSize();
	}

	public void setFileSize(double fileSize) {
		_videoInfo.setFileSize(fileSize);
	}

	public java.lang.String getFileDesc() {
		return _videoInfo.getFileDesc();
	}

	public void setFileDesc(java.lang.String fileDesc) {
		_videoInfo.setFileDesc(fileDesc);
	}

	public java.lang.String getUserEmail() {
		return _videoInfo.getUserEmail();
	}

	public void setUserEmail(java.lang.String userEmail) {
		_videoInfo.setUserEmail(userEmail);
	}

	public java.util.Date getUploadTime() {
		return _videoInfo.getUploadTime();
	}

	public void setUploadTime(java.util.Date uploadTime) {
		_videoInfo.setUploadTime(uploadTime);
	}

	public java.lang.String getVurl() {
		return _videoInfo.getVurl();
	}

	public void setVurl(java.lang.String vurl) {
		_videoInfo.setVurl(vurl);
	}

	public int getStatus() {
		return _videoInfo.getStatus();
	}

	public void setStatus(int status) {
		_videoInfo.setStatus(status);
	}

	public com.edujini.incoleg.video.model.VideoInfo toEscapedModel() {
		return _videoInfo.toEscapedModel();
	}

	public boolean isNew() {
		return _videoInfo.isNew();
	}

	public void setNew(boolean n) {
		_videoInfo.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoInfo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoInfo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoInfo.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_videoInfo.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoInfo.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoInfo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoInfo.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _videoInfo.clone();
	}

	public int compareTo(com.edujini.incoleg.video.model.VideoInfo videoInfo) {
		return _videoInfo.compareTo(videoInfo);
	}

	public int hashCode() {
		return _videoInfo.hashCode();
	}

	public java.lang.String toString() {
		return _videoInfo.toString();
	}

	public java.lang.String toXmlString() {
		return _videoInfo.toXmlString();
	}

	public VideoInfo getWrappedVideoInfo() {
		return _videoInfo;
	}

	private VideoInfo _videoInfo;
}