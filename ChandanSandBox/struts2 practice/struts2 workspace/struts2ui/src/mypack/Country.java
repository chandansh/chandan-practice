package mypack;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Country implements Serializable {
	private int countryId;
	private String countryName;

	public Country() {

	}

	public Country(int countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
