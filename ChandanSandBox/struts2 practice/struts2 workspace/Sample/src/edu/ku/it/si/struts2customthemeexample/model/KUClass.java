package edu.ku.it.si.struts2customthemeexample.model;

public class KUClass {
	
	private String classId;
	private String className;
	
	public String toString() {
		
		return classId + " - " + className;
		
	}
	

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}


	public String getClassId() {
		return classId;
	}


	public void setClassId(String classId) {
		this.classId = classId;
	}
	

}
