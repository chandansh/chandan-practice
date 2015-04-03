package com.mpower.hook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

public class MyPostLoginEvent extends Action{

	@Override
	public void run(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ActionException {
		System.out.println("in run method -- ---- Neeraj");
	}

}
