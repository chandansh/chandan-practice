package com.library.Asset;

import com.library.slayer.model.LMSBook;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class LMSEntryAssetRendererFactory extends BaseAssetRendererFactory
{
	
	public static final String Class_Name = LMSBook.class.getName();
	public static final String TYPE = "portlet";

	@Override
	public AssetRenderer getAssetRenderer(long bookId, int type)
			throws PortalException, SystemException 
	{
		LMSBook book = LMSBookLocalServiceUtil.getLMSBook(bookId);
		return new LMSEntryAssetRenderer(book);
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Class_Name;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

}
