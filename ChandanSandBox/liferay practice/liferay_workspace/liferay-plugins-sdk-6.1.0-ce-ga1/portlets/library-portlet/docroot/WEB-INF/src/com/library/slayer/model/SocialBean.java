/**
 * 
 */
package com.library.slayer.model;


/**
 * @author meenu
 *
 */
public class SocialBean {
	
	private String firstName;
	private String lastName;
	private String street1;
	private String street2;
	private String city;
	private String zip;
	private String emailAddress;
    private String phoneNumber;
    private String mobileNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "SocialBean [firstName=" + firstName + ", lastName=" + lastName
				+ ", street1=" + street1 + ", street2=" + street2 + ", city="
				+ city + ", zip=" + zip + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", mobileNumber="
				+ mobileNumber + "]";
	}


}
