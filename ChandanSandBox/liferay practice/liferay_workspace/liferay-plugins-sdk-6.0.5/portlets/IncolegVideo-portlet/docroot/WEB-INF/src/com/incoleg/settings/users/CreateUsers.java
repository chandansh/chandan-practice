package com.incoleg.settings.users;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.ControlPanelEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CreateUsers
 */
public class CreateUsers extends MVCPortlet implements ControlPanelEntry
{
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
	{
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Country.class)/*.add(PropertyFactoryUtil.forName("name").eqProperty("abcd"))*/;
//		query.list();
		System.out.println("Hello View &***************************************************");
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException
	{

		System.out.println("Hello Process &***************************************************");
		super.processAction(actionRequest, actionResponse);
		
	}
	
//	MailEngine.send
//	from to true param
	

	@Override
	public boolean isVisible(PermissionChecker checker, Portlet portlet) throws Exception
	{
		return checker.isOmniadmin();
	}

	@Override
	public boolean isVisible(Portlet portlet, String arg1, ThemeDisplay themeDisplay) throws Exception
	{
		return themeDisplay.getPermissionChecker().isOmniadmin();
	}

}
