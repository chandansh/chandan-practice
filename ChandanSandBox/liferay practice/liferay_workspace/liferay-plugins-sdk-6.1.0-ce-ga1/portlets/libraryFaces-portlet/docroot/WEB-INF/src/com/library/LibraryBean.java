package com.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.library.slayer.model.LIBBook;
import com.library.slayer.service.LIBBookLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
@ManagedBean(name = "libraryBean")
@ViewScoped
public class LibraryBean implements Serializable {
	public String bookTitle;
	public String author;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookTitle() {
		System.out.println("get");
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		
		System.out.println("set");

		this.bookTitle = bookTitle;
	}
	public void add()
	{
		setBookTitle(bookTitle);
		setAuthor(author);
		System.out.println("bookTitle  is"+bookTitle);
		System.out.println("add");
		addBook(bookTitle,author);
	}
	void addBook(String bookTitle,String author)
	{
		Library library=new Library();
		System.out.println(bookTitle);
		library.addBooks(bookTitle, author);
	}
	public List<LibraryBean> list() throws SystemException
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
			System.out.println("hello");
		}
		return list;		
	}
}