package com.test;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.service.HelloWorldServiceStub;
import com.service.SayBye;
import com.service.SayByeResponse;
import com.service.SayHello;
import com.service.SayHelloResponse;

public class Test {

	public static void main(String[] args) {
		try {
			HelloWorldServiceStub stub = new HelloWorldServiceStub();
			// Create the request
			SayHello request = new SayHello();
			request.setName("Chandan Kumar");
			// Invoke the service
			SayHelloResponse response = stub.sayHello(request);
			System.out.println("SayHello Response : " + response.get_return());

			SayBye request1 = new SayBye();
			request1.setName("Chandan Sharma");
			SayByeResponse response1 = stub.sayBye(request1);
			System.out.println("SayBye Response : " + response1.get_return());

		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
