package edu.ku.it.si.struts2customthemeexample.model;

import java.util.List;

public class Person {
	
	private String firstName;
	private String lastName;
	private List<String> kuClassIds ;
	
	
	public String toString() {
		
		String tempString =  firstName + " " + lastName ;
		
		for (String kuClassId : kuClassIds) {
			
			tempString = tempString + " " + kuClassId ;
			
		}
		
		return tempString;
		
	}
	
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

	public List<String> getKuClassIds() {
		return kuClassIds;
	}

	public void setKuClassIds(List<String> kuClassIds) {
		this.kuClassIds = kuClassIds;
	}

	
	

}
