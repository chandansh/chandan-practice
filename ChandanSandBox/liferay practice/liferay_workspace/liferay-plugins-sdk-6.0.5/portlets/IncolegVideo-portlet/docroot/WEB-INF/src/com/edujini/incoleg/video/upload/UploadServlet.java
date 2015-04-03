package com.edujini.incoleg.video.upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.edujini.incoleg.video.bl.UploadHandler;
import com.edujini.incoleg.video.model.impl.VideoInfoImpl;
import com.edujini.incoleg.video.service.VideoInfoLocalService;
import com.edujini.incoleg.video.service.VideoInfoLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UploadVideo
 */

public class UploadServlet extends MVCPortlet
{

	private VideoInfoLocalService svc = VideoInfoLocalServiceUtil.getService();
	ArrayList<VideoInfoImpl> avi;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
	{

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException
	{

		try
		{

			if(avi != null)
			{

				for(VideoInfoImpl vi : avi)
				{
					vi.setFileDesc(actionRequest.getParameter("fDesc"));
					vi.setUploadTime(new Date());
					if(PortalUtil.getUser(actionRequest) != null)
					{
						vi.setUserEmail(PortalUtil.getUser(actionRequest).getEmailAddress());
					}

					svc.updateVideoInfo(vi, true);
				}

				avi = null;
				System.out.println("**File descrption added**");
			}

		} catch(Exception e)
		{
			e.printStackTrace();
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException
	{

		try
		{
			avi = new UploadHandler().processRequest(PortalUtil.getHttpServletRequest(resourceRequest));

			for(VideoInfoImpl vi : avi)
			{

				svc.addVideoInfo(vi);

			}

			System.out.println("**File information added in database**");

		} catch(Exception e)
		{
			System.out.println("could not call UploadHandler:  " + e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

}
