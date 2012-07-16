package web.contact.controllers;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.validation.BindException;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.SimpleFormController;

import web.test.model.Contact;

import com.test.dao.ContactDAO;

@SuppressWarnings("deprecation")
public class ContactController extends SimpleFormController {
	private ContactDAO contactDAO;

	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	// @Override
	// public ModelAndView handleRenderRequest(RenderRequest request,
	// RenderResponse response) throws Exception {
	//
	// return new ModelAndView("list");
	// }

	protected void onSubmitAction(ActionRequest request,
			ActionResponse response, Object command, BindException errors)
			throws Exception {
		contactDAO.insertContact((Contact) command);
		// response.setRenderParameter("action", "list");
	}
}
