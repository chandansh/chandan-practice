package com.test.blob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;

@SuppressWarnings("serial")
public class WriteFile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		// Get a file service
		FileService fileService = FileServiceFactory.getFileService();

		// Create a new Blob file with mime-type "text/plain"
		AppEngineFile file = fileService.createNewBlobFile("text/plain","abc.txt");
		

		// Open a channel to write to it
		boolean lock = false;
		FileWriteChannel writeChannel = fileService
				.openWriteChannel(file, lock);

		// Different standard Java ways of writing to the channel
		// are possible. Here we use a PrintWriter:
		PrintWriter out = new PrintWriter(Channels.newWriter(writeChannel,
				"UTF8"));

		// PrintWriter out = resp.getWriter();
		out.println("The woods are lovely dark and deep.");
		out.println("But I have promises to keep.");

		// Close without finalizing and save the file path for writing later
		out.close();
		String path = file.getFullPath();

		// Write more to the file in a separate request:
		file = new AppEngineFile(path);

		// This time lock because we intend to finalize
		lock = true;
		writeChannel = fileService.openWriteChannel(file, lock);

		// This time we write to the channel using standard Java
		writeChannel.write(ByteBuffer.wrap("And miles to go before I sleep."
				.getBytes()));

		// Now finalize
		writeChannel.closeFinally();

		// Later, read from the file using the file API
		lock = false; // Let other people read at the same time
		FileReadChannel readChannel = fileService.openReadChannel(file, false);

		// Again, different standard Java ways of reading from the channel.
		BufferedReader reader = new BufferedReader(Channels.newReader(
				readChannel, "UTF8"));
		String line = reader.readLine();
		// line = "The woods are lovely dark and deep."

		PrintWriter out1 = resp.getWriter();
		out1.println("string are :" + line);
		readChannel.close();

		// Now read from the file using the Blobstore API
		BlobKey blobKey = fileService.getBlobKey(file);
		BlobstoreService blobStoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		//String segment = new String(blobStoreService.fetchData(blobKey, 30, 40));
		
		//out1.println("<br>String segment are: "+segment);
		
		//blobStoreService.serve(blobKey, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
