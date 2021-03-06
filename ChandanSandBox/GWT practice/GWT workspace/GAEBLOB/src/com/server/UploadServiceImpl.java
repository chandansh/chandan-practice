package com.server;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.model.Picture;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class UploadServiceImpl extends HttpServlet {
	//Start Blobstore and Objectify Sessions
	  BlobstoreService blobstoreService = BlobstoreServiceFactory
	      .getBlobstoreService();
	  Objectify ofy = ObjectifyService.begin();

	  

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Send the meta-data id back to the client in the HttpServletResponse response
	    String id = req.getParameter("id");
	    resp.setHeader("Content-Type", "text/html");
	    resp.getWriter().println(id);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
	    BlobKey blobKey = blobs.get("upload");

	    //Get the paramters from the request to populate the Picture object
	    Picture picture = new Picture();
	    picture.setDescription(req.getParameter("descriptionTextBox"));
	    picture.setTitle(req.getParameter("titleTextBox"));
	    //Map the ImageURL to the blobservice servlet, which will serve the image
	    picture.setImageUrl("/gaeblob/blobservice?blob-key=" + blobKey.getKeyString());

	    ofy.put(picture);

	    //Redirect recursively to this servlet (calls doGet)
	    resp.sendRedirect("/gaeblob/uploadservice?id=" + picture.id);
	}
	  
	  
}
