/**
 * 
 */
package com.test.struts.newportlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.test.struts.newportlet.actionform.ProfileActionForm;

/**
 * This is a brief description of NewAction.
 * 
 * @author Chandan
 * @Created on Nov 11, 2012
 * 
 */
public class NewAction extends Action {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ProfileActionForm profileForm = (ProfileActionForm) form;
		System.out.println("profile Form" + profileForm);

		return mapping.findForward("success");
	}
}
