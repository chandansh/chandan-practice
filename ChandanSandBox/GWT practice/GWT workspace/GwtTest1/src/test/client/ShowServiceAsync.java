package test.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ShowServiceAsync {
	void showMsg(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
