package com.liferay.portal.events;

import com.liferay.portal.kernel.events.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.liferay.portal.kernel.events.ActionException;

public class UserCartSyncAction extends Action {
	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#Action()
	 */
	public UserCartSyncAction() {
		super();
	}

	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#run(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	public void run(HttpServletRequest arg0, HttpServletResponse arg1) throws ActionException {
		// TODO Auto-generated method stub
		
		System.out.println("Syncing user cart from session.....");
	}

}