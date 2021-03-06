package com.test.blob;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class ReadBlob extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/plain");
		//TestABC a = new TestABC();
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		BlobInfoFactory bif = new BlobInfoFactory(ds);
		Entity entity = new Entity(BlobInfoFactory.KIND, "cksdata");
		entity.setProperty(bif.CONTENT_TYPE, "text/plain");
		entity.setProperty(bif.CREATION, new Date());
		entity.setProperty(bif.FILENAME, "cksfile");
		entity.setProperty(bif.SIZE, 1000L);
		entity.setProperty("data", new Blob(
				new byte[] { 87, 79, 87, 46, 46, 46 }));
		bif.createBlobInfo(entity);

		Iterator<BlobInfo> infos = bif.queryBlobInfos();
		BlobstoreService blobStoreService = BlobstoreServiceFactory
				.getBlobstoreService();

		while (infos.hasNext()) {
			BlobInfo binfo = infos.next();
			// out.println("\n-------------------------------------------");
			// out.println("content type: " + binfo.getContentType());
			// out.println("key :" + binfo.getBlobKey());
			// out.println("size :" + binfo.getSize());
			// out.println("file name :" + binfo.getFilename());
			// out.println("creation time :" + binfo.getCreation());
			byte[] readData = blobStoreService.fetchData(binfo.getBlobKey(), 0,
					binfo.getSize());

			String path = req.getRealPath("/data");
			try {

				File newFile = new File("somefilname");
				// FileOutputStream fos = new FileOutputStream(newFile);
				out.println("path : " + path);
				ByteArrayOutputStream o = new ByteArrayOutputStream();
				o.write(readData);

			} catch (Exception e) {
				// TODO: handle exception
			}

			String s = "";

			String respoValue = new String(readData, "UTF-8");
			// out.println("data :"+respoValue);
			out.println("-------------------------------------------\n");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
