package com.edujini.incoleg.video.settings;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.ControlPanelEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoUploadSettings
 */
public class VideoUploadSettings extends MVCPortlet implements ControlPanelEntry
{

	@Override
	public boolean isVisible(PermissionChecker checker, Portlet portlet) throws Exception
	{
		return checker.isOmniadmin();
	}

	@Override
	public boolean isVisible(Portlet portlet, String arg1, ThemeDisplay themeDisplay) throws Exception
	{
		System.out.println("[VUS(P,S,TD)]");
		return themeDisplay.getPermissionChecker().isOmniadmin();
	}
}
