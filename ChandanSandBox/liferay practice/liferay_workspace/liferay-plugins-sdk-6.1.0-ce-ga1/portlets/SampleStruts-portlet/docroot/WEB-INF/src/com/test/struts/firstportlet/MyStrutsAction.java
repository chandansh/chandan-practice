/**
 * 
 */
package com.test.struts.firstportlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * This is a brief description of MyNewAction.
 * @author Chandan
 * @Created on Nov 11, 2012
 * 
 */
public class MyStrutsAction extends Action {
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("name :: "+ request.getParameter("name"));
		System.out.println("address :: "+ request.getParameter("address"));
		System.out.println("action executed.. ");
		return mapping.findForward("success");
	}
}
