package com.client;

import com.client.model.Picture;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BlobServiceAsync {

	void getBlobStoreUploadUrl(AsyncCallback<String> callback);

	void getPicture(String id, AsyncCallback<Picture> callback);

}
