package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.slayer.model.Author;
import com.slayer.service.AuthorLocalServiceUtil;

/**
 * Portlet implementation class CreateAuthorPortlet
 */
public class CreateAuthorPortlet extends MVCPortlet {

	public void createAuthor(ActionRequest request, ActionResponse response) {
		try {
			Author author = AuthorLocalServiceUtil
					.createAuthor(CounterLocalServiceUtil
							.increment(Author.class.getName()));
			String name = ParamUtil.getString(request, "name");
			String specialization = ParamUtil.getString(request,
					"specialization");
			author.setName(name);
			author.setSpecialization(specialization);

			AuthorLocalServiceUtil.addAuthor(author);

		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

}
