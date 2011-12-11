package edu.ku.it.si.struts2customthemeexample.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

import edu.ku.it.si.struts2customthemeexample.model.KUClass;
import edu.ku.it.si.struts2customthemeexample.model.Person;

public class Update extends ActionSupport {
	
	
	private Person person ;
	private List<KUClass> kuClasses ;


	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger( Update.class.getName() );
	
	
	@Override
	@Action(value = "update-input")
	public String input() {
		
		logger.debug("In method input of class Update");
		
		initializePerson();
		
		initializeKUClasses();
		
		logger.info("State of Person object is: " + person);
		
		logger.info("State of the kuClasses object is " + kuClasses);
		
		return INPUT;
		
	}
	
	private Person initializePerson() {
		
		person = new Person();
		person.setFirstName("Bruce");
		person.setLastName("Phillips");
		
		List<String> kuClasses = new ArrayList<String>();
		
		kuClasses.add("100A");
		kuClasses.add("200A");

		person.setKuClassIds(kuClasses);
		
		return person;
		
		
	}
	
	
	private List<KUClass> initializeKUClasses() {
		
		
		KUClass kuClass1 = new KUClass();
		kuClass1.setClassId("100A");
		kuClass1.setClassName("Introduction to English");
		
		KUClass kuClass2 = new KUClass();
		kuClass2.setClassId("200A");
		kuClass2.setClassName("Introduction to Calculus");
		
		KUClass kuClass3 = new KUClass();
		kuClass3.setClassId("300A");
		kuClass3.setClassName("Introduction to Art");
		
		KUClass kuClass4 = new KUClass();
		kuClass4.setClassId("400A");
		kuClass4.setClassName("Introduction to Biology");
		
		kuClasses = new ArrayList<KUClass>();
		kuClasses.add(kuClass1);
		kuClasses.add(kuClass2);
		kuClasses.add(kuClass3);		
		kuClasses.add(kuClass4);	
		
		return kuClasses;
		
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<KUClass> getKuClasses() {
		return kuClasses;
	}

	public void setKuClasses(List<KUClass> kuClasses) {
		this.kuClasses = kuClasses;
	}

}
