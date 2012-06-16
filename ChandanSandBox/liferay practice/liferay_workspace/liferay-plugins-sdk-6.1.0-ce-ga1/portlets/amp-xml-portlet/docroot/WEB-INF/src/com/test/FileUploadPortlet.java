package com.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FileUploadPortlet
 */
public class FileUploadPortlet extends MVCPortlet {
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		
		
		File submissionFile = uploadRequest.getFile("myfile");
		InputStream infile = uploadRequest.getFileAsStream("myfile");
		long size = uploadRequest.getSize("myfile");
		String mimeType = uploadRequest.getContentType("myfile");
		System.out.println("Size : "+ size);
		System.out.println("file Size"+ submissionFile.length());
		String submissionFileName =  uploadRequest.getFileName("myfile");
		System.out.println("file name:"+ submissionFileName);
		try {
			DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), 0, "test");
			System.out.println("Foldername :" + dlFolder.getName());

//			FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
//					dlFolder.getRepositoryId(), dlFolder.getFolderId(),
//					submissionFileName, "", submissionFileName,
//					"upload file description", "", submissionFile,
//					new ServiceContext());
			FileEntry fileEntry = DLAppServiceUtil.addFileEntry(dlFolder.getRepositoryId(),
					dlFolder.getFolderId(), submissionFileName, mimeType, submissionFileName, "my description", "", infile, size, new ServiceContext());

			System.out.println(fileEntry.getFileEntryId());
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		super.processAction(actionRequest, actionResponse);
	}

}
