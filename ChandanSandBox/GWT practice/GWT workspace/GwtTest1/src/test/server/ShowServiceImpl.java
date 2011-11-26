package test.server;

import test.client.ShowService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ShowServiceImpl extends RemoteServiceServlet implements
		ShowService {

	@Override
	public String showMsg(String name) throws IllegalArgumentException {
		
		return "Hello "+name;
	}

}
