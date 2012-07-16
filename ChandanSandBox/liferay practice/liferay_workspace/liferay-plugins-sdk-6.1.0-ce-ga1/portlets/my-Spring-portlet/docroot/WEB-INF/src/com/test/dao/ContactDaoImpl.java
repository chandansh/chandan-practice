package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import web.test.model.Contact;

public class ContactDaoImpl implements ContactDAO {
	/* (non-Javadoc)
	 * @see com.test.dao.ContactDao#getContactList()
	 */
	@Override
	public List<Contact> getContactList() {
		return new ArrayList<Contact>();
	}

	/* (non-Javadoc)
	 * @see com.test.dao.ContactDao#getContact(java.lang.String)
	 */
	@Override
	public Contact getContact(String contactId) {
		return new Contact();
	}

	/* (non-Javadoc)
	 * @see com.test.dao.ContactDao#insertContact(web.test.model.Contact)
	 */
	@Override
	public int insertContact(Contact contact) {
		System.out.println("insert contact called.. from dao");
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.test.dao.ContactDao#updateContact(web.test.model.Contact)
	 */
	@Override
	public int updateContact(Contact contact) {
		System.out.println("update contact called..");
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.test.dao.ContactDao#deleteContact(java.lang.String)
	 */
	@Override
	public int deleteContact(String contactId) {
		System.out.println("delete contact called..");
		return 0;
	}
}
