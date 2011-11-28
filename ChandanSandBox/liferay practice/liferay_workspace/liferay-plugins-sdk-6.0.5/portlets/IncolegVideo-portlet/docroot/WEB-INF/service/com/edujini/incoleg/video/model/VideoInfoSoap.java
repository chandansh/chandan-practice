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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.edujini.incoleg.video.service.http.VideoInfoServiceSoap}.
 * </p>
 *
 * @author    Edujini
 * @see       com.edujini.incoleg.video.service.http.VideoInfoServiceSoap
 * @generated
 */
public class VideoInfoSoap implements Serializable {
	public static VideoInfoSoap toSoapModel(VideoInfo model) {
		VideoInfoSoap soapModel = new VideoInfoSoap();

		soapModel.setVideoId(model.getVideoId());
		soapModel.setFileName(model.getFileName());
		soapModel.setMappedFileName(model.getMappedFileName());
		soapModel.setFileType(model.getFileType());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setFileDesc(model.getFileDesc());
		soapModel.setUserEmail(model.getUserEmail());
		soapModel.setUploadTime(model.getUploadTime());
		soapModel.setVurl(model.getVurl());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VideoInfoSoap[] toSoapModels(VideoInfo[] models) {
		VideoInfoSoap[] soapModels = new VideoInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoInfoSoap[][] toSoapModels(VideoInfo[][] models) {
		VideoInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoInfoSoap[] toSoapModels(List<VideoInfo> models) {
		List<VideoInfoSoap> soapModels = new ArrayList<VideoInfoSoap>(models.size());

		for (VideoInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoInfoSoap[soapModels.size()]);
	}

	public VideoInfoSoap() {
	}

	public String getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(String pk) {
		setVideoId(pk);
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