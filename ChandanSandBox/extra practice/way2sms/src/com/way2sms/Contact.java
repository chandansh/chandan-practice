package com.way2sms;

import java.io.Serializable;

/**
 * Bean to represent contact.
 * 
 * @author Shailesh K Soliwal
 */

public class Contact implements Serializable{
	
	private static final long serialVersionUID = 8263744218104663887L;

	private Boolean selected = false;
	
	private String name = null;
	
	private String mobileNo = null;
	
	private String group = null;
	
	
	
	/**
	 * @param selected
	 * @param name
	 * @param mobileNo
	 * @param group
	 */
	public Contact(Boolean selected, String name, String mobileNo, String group) {
		super();
		this.selected = selected;
		this.name = name;
		this.mobileNo = mobileNo;
		this.group = group;
	}

	/**
	 * Gets the group.
	 * 
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}
	
	/**
	 * Sets the group.
	 * 
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	
	/**
	 * Instantiates a new contact.
	 * 
	 * @param selected the selected
	 * @param name the name
	 * @param mobileNo the mobile no
	 * @param group the group
	 */
	public Contact(boolean selected, String name, String mobileNo, String group) {
		this.selected = selected;
		this.name = name;
		this.mobileNo = mobileNo;
		this.group = group;
		
	}
	
	/**
	 * Checks if is selected.
	 * 
	 * @return true, if is selected
	 */
	public boolean isSelected() {
		return selected;
	}
	
	/**
	 * Sets the selected.
	 * 
	 * @param selected the new selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the mobile no.
	 * 
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	
	/**
	 * Sets the mobile no.
	 * 
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}