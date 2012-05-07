/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.incoleg.video.bl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.edujini.incoleg.video.model.impl.VideoInfoImpl;

/**
 * This is a brief description of VideoUploadHandler. <br/>
 * This class will extract all the information (data of form fields, attached files etc.) comes from
 * request object.
 * 
 * @author anand
 * 
 */

public class UploadHandler
{

	private Hashtable<Object, Object> ht = null;
	private String randomID = "", path = "", filename = "", type = "", conttype = "", mapedName = "";
	private InputStream is = null;
	private int size = 0;
	private ArrayList<VideoInfoImpl> avi = new ArrayList<VideoInfoImpl>();

	@SuppressWarnings("deprecation")
	public ArrayList<VideoInfoImpl> processRequest(HttpServletRequest request) throws ServletException, IOException
	{

		ht = new Hashtable<Object, Object>();

		try
		{

			path = request.getRealPath("../../../../VideoStore");

			randomID = getFileID(15);
			ht.put("fileID", randomID);
			// HttpSession session = request.getSession();
			// ht.put("uid", session.getAttribute("uid"));
			// ht.put("uemail", session.getAttribute("uemail"));

			System.out.println("Random ID is : " + randomID);

			if(ServletFileUpload.isMultipartContent(request))
			{

				List<?> fileItem = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				Iterator<?> itr = fileItem.iterator();

				while(itr.hasNext())
				{
					FileItem fi = (FileItem) itr.next();
					if(fi.isFormField())
					{
						StringTokenizer st = new StringTokenizer(fi.getFieldName(), "_");
						System.out.println("This is Form Field: " + fi.getFieldName());
						Vector<String> v = new Vector<String>();
						while(st.hasMoreTokens())
						{
							v.addElement(st.nextToken());
						}

						ht.put(v.lastElement(), fi.getString());

					} else
					{

						if(!fi.getName().equals(""))
						{

							fileField(fi);

						} else
						{
							System.out.println("File Not Found!!!!!!");
						}
					}

				}

				// Process proc =
				// Runtime.getRuntime().exec("java -jar /home/ubuntu/codebase/videoConverter.jar");

			}

		} catch(Exception me)
		{

			me.printStackTrace();
		}
		return (avi);
	}

	private void fileField(FileItem fi) throws IOException
	{
		filename = fi.getName();
		StringTokenizer st = new StringTokenizer(filename, ".");
		Vector<String> v = new Vector<String>();

		while(st.hasMoreTokens())
		{
			v.addElement(st.nextToken());
		}
		type = (String) v.lastElement();

		is = fi.getInputStream();
		size = is.available();
		conttype = fi.getContentType();
		System.out.println("Content Type is: " + conttype);

		try
		{

			mapedName = randomID + "." + type;
			File filePath = new File(path);
			if(!filePath.exists())
				filePath.mkdir();

			File file = new File(filePath, mapedName);

			FileOutputStream fos = new FileOutputStream(file);
			for(int i = 0; i < size; i++)
			{

				fos.write(is.read());

			}

			fos.close();
			System.out.println("***********File Uploaded Successfully*********");

			VideoInfoImpl vi = new VideoInfoImpl();
			vi.setVideoId(randomID);
			vi.setFileName(filename);
			vi.setFileSize(size);
			vi.setMappedFileName(mapedName);
			vi.setFileType(type);
			avi.add(vi);

		} catch(Exception e)
		{

			e.printStackTrace();
		}

	}

	private String getFileID(int length)
	{
		final String GUID_CHARS = "0123456789abcdef";
		final int GUID_NUM_CHARS = GUID_CHARS.length();

		Random r = new Random();
		char[] v = new char[length];

		int idx;
		for(int i = 0; i < length; i++)
		{
			idx = r.nextInt(GUID_NUM_CHARS);
			v[i] = GUID_CHARS.charAt(idx);
		}

		return new String(v);

	}

}
