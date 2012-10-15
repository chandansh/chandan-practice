package com.library.Asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.library.slayer.model.LMSBook;
import com.liferay.portlet.asset.model.BaseAssetRenderer;


public class LMSEntryAssetRenderer extends BaseAssetRenderer
{
	
	private LMSBook _book;
	
	public LMSEntryAssetRenderer(LMSBook book)
	{
		_book = book;
	}

	public long getClassPK() {
		
		return _book.getPrimaryKey();
	}
	
	public long getUserId() {
		// TODO Auto-generated method stub
		return _book.getUserId();
	}
	
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template)
			throws Exception {
		if (template.equals(TEMPLATE_ABSTRACT) || (template.equals(TEMPLATE_FULL_CONTENT))) {
			renderRequest.setAttribute("LMS_ENTRY", _book);

			return "/html/library/full_content.jsp";
		} else {
			return null;
		}
	}

// ........i used a diff updateEntry() so these parameters were nevea used...
	
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long getGroupId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSummary(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
