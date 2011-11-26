package com.client;

import com.client.model.Picture;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("blobservice")
public interface BlobService extends RemoteService {
	String getBlobStoreUploadUrl();

	Picture getPicture(String id);
}
