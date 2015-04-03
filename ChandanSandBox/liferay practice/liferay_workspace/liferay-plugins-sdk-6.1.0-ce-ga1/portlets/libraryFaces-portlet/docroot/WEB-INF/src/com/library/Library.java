package com.library;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.portletfaces.bridge.GenericFacesPortlet;

import com.library.slayer.model.LIBBook;
import com.library.slayer.model.impl.LIBBookImpl;
import com.library.slayer.service.LIBBookLocalServiceUtil;
import com.library.slayer.service.persistence.LIBBookUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class Library extends GenericFacesPortlet {
	public void addBooks(String bookTitle, String author) {
		System.out.println("addBook");
		LIBBook book=new LIBBookImpl();
		long bookId=0L;
		try
		{
			bookId=CounterLocalServiceUtil.increment();
			book.setBookId(bookId);
			book.setBookTitle(bookTitle);
			book.setAuthor(author);
			System.out.println("inside try");
			LIBBookLocalServiceUtil.addLIBBook(book);
			listBooks(bookTitle,author);
		}
		catch(Exception e)
		{
			
		}

	}
	public List<LibraryBean> listBooks(String bookTitle, String author) throws SystemException
	{
		LibraryBean lib=new LibraryBean();
		lib.setBookTitle(bookTitle);
		lib.setAuthor(author);
		List<LibraryBean> list = new ArrayList<LibraryBean>();
		list.add(lib);
		int count = LIBBookLocalServiceUtil.getLIBBooksCount();
		List<LIBBook> books = LIBBookLocalServiceUtil.getLIBBooks(0, count);
		for(LIBBook book:books)
		{
			System.out.println("****************"+book.getBookTitle());
			System.out.println("********************"+book.getAuthor());
		}
		return list;		
	}
	
	/*public void addBook(ActionEvent actionEvent) {
		// clear the title
		FacesContext facesContext = FacesContext.getCurrentInstance();
		LibraryBean bean=new LibraryBean();
		try {
			LIBBookLocalServiceUtil.addBooks(facesContext.getExternalContext().getRemoteUser(),bean.getBookTitle());
		} 
		catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error adding book.", e.toString());	
			facesContext.addMessage(null, message);
			
			e.printStackTrace();
			
			return;
		}*/
		
		public List getAll()throws PortalException, SystemException {
			return LIBBookUtil.findAll();
		}

	}
