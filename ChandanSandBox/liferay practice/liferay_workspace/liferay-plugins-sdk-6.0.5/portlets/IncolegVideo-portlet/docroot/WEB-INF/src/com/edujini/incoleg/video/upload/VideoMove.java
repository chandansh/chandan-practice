/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.incoleg.video.upload;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import com.edujini.incoleg.video.model.VideoInfo;
import com.edujini.incoleg.video.model.impl.VideoInfoImpl;
import com.edujini.incoleg.video.service.VideoInfoLocalService;
import com.edujini.incoleg.video.service.VideoInfoLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * This is a brief description of VideoMove. <br/>
 * This class moves the video files from temporary repository to main video store repository.
 * 
 * @author anand
 * 
 */

public class VideoMove
{
	private String destPath = "/media/Projects/Edujini/Coleg/LiferayVideo/VideoStore/UploadedVideo";
	private File file;

	public VideoMove(File file)
	{
		this.file = file;

		move();
	}

	private void move()
	{

		try
		{

			boolean status = file.renameTo(new File(destPath, file.getName()));
			if(status)
			{
				System.out.println("File moved in video repository");

				if(updateDB())
				{

					System.out.println("Status updated in database");
					startConversion();

				} else
				{

					System.out.println("Status could not be updated in database");
				}

			} else
			{

				System.out.println("file could not moved");
			}

		} catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private boolean updateDB()
	{

		boolean b = false;

		try
		{

			VideoInfoLocalService svc = VideoInfoLocalServiceUtil.getService();
			//FIXME: Get the "real" code
			VideoInfo vinfo = new VideoInfoImpl();
			//vinfo = svc.fetchByFileName(file.getName());
			vinfo.setStatus(3);
			svc.updateVideoInfo(vinfo, true);
			b = true;
		} catch(SystemException se)
		{
			se.printStackTrace();

		} catch(Exception e)
		{

			e.printStackTrace();
		}

		return b;

	}

	private void startConversion()
	{

		new Timer().schedule(new TimerTask()
		{

			@Override
			public void run()
			{
				//new Converter(file);

			}
			
			

		}, 60000);

	}

}
