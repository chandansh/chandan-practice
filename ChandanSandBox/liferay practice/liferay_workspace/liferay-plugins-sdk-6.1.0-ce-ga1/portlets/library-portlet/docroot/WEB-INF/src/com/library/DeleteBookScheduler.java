package com.library;

import java.util.Date;
import java.util.List;

import com.library.slayer.model.LMSBook;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;

public class DeleteBookScheduler implements MessageListener {

	@Override
	public void receive(Message arg0) throws MessageListenerException {
		// TODO Auto-generated method stub
		
		int delete = 5;
		int createDate  =0	;
		int todaysDate = new Date().getDate();
		int resultDate = 0;
		String fileName=null;
		List<LMSBook> lms=null;
		String dirName ="LMSBook_Details_Hide";
		long companyId = 10154l;
		long repositoryId = CompanyConstants.SYSTEM;
		
		try {
			lms = LMSBookLocalServiceUtil.getLMSBooks(0, -1);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lms.isEmpty())
		{
			System.out.println("There is no book in the library");
		}
		else{
			for(LMSBook l:lms)
			{
				delete = l.getDownloaded();
				createDate = l.getCreateDate().getDate();
				resultDate = todaysDate-createDate;
				fileName = l.getFileName();
				
				
				if((delete==0)&&(resultDate>=30))
				{
					try {
						LMSBookLocalServiceUtil.deleteLMSBook(l);
						DLStoreUtil.deleteFile(companyId,repositoryId, dirName+"/"+fileName);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

