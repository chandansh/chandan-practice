package com.library;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;

public class HTTPClientDemonstration {

	public static void main(String[] args)
	{
		String uri ="http://localhost:8080/library-portlet/api/secure/jsonws/lmsbook/add-library-book";
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		String userName = "test@liferay.com";
		String password = "test";
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		
		Credentials credentials = new UsernamePasswordCredentials(userName,password);
		HttpClient client = new HttpClient();
		client.getState().setCredentials(AuthScope.ANY, credentials);
		client.getParams().setParameter("http.useragent", "Test Client");
		client.getParams().setAuthenticationPreemptive(true);
		PostMethod method = new PostMethod(uri);
		method.addParameter("bookTitle", "Liferay1 Advanced");
		method.addParameter("author", "Ahmed Hasan");
		method.addParameter("groupId", "10180");
		try
		{
		      int returnCode = client.executeMethod(method);
		      
		      if(returnCode == HttpStatus.SC_OK)
		      {
		    	  method.getResponseBodyAsString();
		      }
		      else
		      {
		    	  System.out.println("Auth "+returnCode+" ");
		    	  
			  }
	    }
	    catch (Exception e)
	    {
		      System.err.println(e);
	    }
	    finally
	    {
		      method.releaseConnection();
	    }
 	}
}
