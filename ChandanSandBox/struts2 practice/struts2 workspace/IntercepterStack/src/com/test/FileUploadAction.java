package com.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FileUploadAction extends ActionSupport implements
		ServletRequestAware {
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private String title;
	private HttpServletRequest servletRequest;

	public String execute() throws IOException {
		String path = servletRequest.getServletContext().getRealPath("/");
		File toWrite = new File(path, userImageFileName);
		// FileOutputStream fos = new FileOutputStream(toWrite);
		System.out.println("path :" + path);
		//FileUtils.copyFile(userImage, toWrite);
		userImage.renameTo(toWrite);
		// or you may code 
		//FileUtils.copyFile(userImage, toWrite);
		return SUCCESS;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.servletRequest = arg0;

	}

}
