package com.social;

import com.library.slayer.model.LMSBook;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.social.PortletURLUtil;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;

public class LibraryActivityInterpreter extends BaseSocialActivityInterpreter{

	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected SocialActivityFeedEntry doInterpret(SocialActivity activity,
			ThemeDisplay themeDisplay) throws Exception {

		String groupName = StringPool.BLANK;

		if (activity.getGroupId() != themeDisplay.getScopeGroupId()) {
			groupName = getGroupName(activity.getGroupId(), themeDisplay);
		}

		String creatorUserName = getUserName(
			activity.getUserId(), themeDisplay);
		
		LMSBook book = LMSBookLocalServiceUtil.getLMSBook(activity.getClassPK());
		String receiverUserName = book.getAuthor();
		
		PortletURLUtil portletURLUtil = new PortletURLUtil();

		String link = portletURLUtil.getURL(activity.getClassPK(), themeDisplay);
		String entryTitle = wrapLink(
				link, HtmlUtil.escape(cleanContent( book.getAuthor())));

			Object[] titleArguments = new Object[] {
				groupName, creatorUserName, receiverUserName, entryTitle
			};
		
		String titlePattern = "activity-book-add-comment";
			
		String title = themeDisplay.translate(titlePattern, titleArguments);

		// Body
		String body = StringPool.BLANK;
			
		return new SocialActivityFeedEntry(link, title, body);

	}
	
	private static final String[] _CLASS_NAMES = new String[] { LMSBook.class
			.getName() };

}




