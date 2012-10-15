package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.slayer.model.Post;
import com.slayer.service.PostLocalServiceUtil;

/**
 * Portlet implementation class CreatePostPortlet
 */
public class CreatePostPortlet extends MVCPortlet {

	public void createPost(ActionRequest request, ActionResponse response) {
		try {
			Post post = PostLocalServiceUtil.createPost(CounterLocalServiceUtil
					.increment(Post.class.getName()));
			String title = ParamUtil.getString(request, "title");
			String content = ParamUtil.getString(request, "content");
			long authorId = ParamUtil.getLong(request, "authorId");
			post.setTitle(title);
			post.setContent(content);
			post.setAuthorId(authorId);

			PostLocalServiceUtil.addPost(post);

		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

}
