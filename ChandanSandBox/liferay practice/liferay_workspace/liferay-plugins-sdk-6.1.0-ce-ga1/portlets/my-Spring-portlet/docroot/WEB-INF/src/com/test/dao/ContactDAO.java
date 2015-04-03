package com.test.dao;

import java.util.List;

import web.test.model.Contact;

public interface ContactDAO {

	public abstract List<Contact> getContactList();

	public abstract Contact getContact(String contactId);

	public abstract int insertContact(Contact contact);

	public abstract int updateContact(Contact contact);

	public abstract int deleteContact(String contactId);

}