package com.edujini.ws.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SvcResponse {
	private int code;
	private String message;
	//private Throwable ex;
	
	private Object result;

	public SvcResponse(int code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		//this.ex = ex;
		this.result = result;
	}

	public SvcResponse() {
		super();

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public Throwable getEx() {
//		return ex;
//	}
//
//	public void setEx(Throwable ex) {
//		this.ex = ex;
//	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
