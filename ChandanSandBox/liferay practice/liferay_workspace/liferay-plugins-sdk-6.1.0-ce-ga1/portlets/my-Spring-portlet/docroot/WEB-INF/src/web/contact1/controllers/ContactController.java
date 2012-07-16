package web.contact1.controllers;

import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import web.test.model.Contact;

import com.test.dao.ContactDAO;

@Controller
@RequestMapping("VIEW")
public class ContactController{
	
	@Autowired
	private ContactDAO contactDAO;

	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	@Autowired
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@RenderMapping
	public String handleRenderRequest(Model model){
		// Used for the initial form as well as for redisplaying with errors.
        if (!model.containsAttribute("contact")) {
            model.addAttribute("contact", new Contact());
        }
		return "insert";
	}
	
	@RenderMapping(params ="action=show")
	public String handleRenderRequest1(){
		return "show";
	}
	
	@ActionMapping
	protected void onSubmitAction(@ModelAttribute("contact") Contact command, BindingResult result,
            SessionStatus status, ActionResponse response)
			throws Exception {
		contactDAO.insertContact(command);
		response.setRenderParameter("action", "show");
	}
}
