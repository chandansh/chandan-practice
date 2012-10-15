package com.slayer.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.slayer.model.AuthorPost;
import com.slayer.model.Post;
import com.slayer.model.impl.AuthorPostImpl;
import com.slayer.model.impl.PostImpl;

public class PostFinderImpl extends BasePersistenceImpl<Post> implements
		PostFinder {
	public List<AuthorPost> findByTitleContentAuthor(String title, String content,
			String author, int begin, int end) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			/*
			String base = "SELECT me_Post.*, me_Author FROM me_Post me_Author"
					+ "JOIN me_Author "
					+ "ON me_Post.authorId = me_Author.authorId ";
					*/
			String base = "SELECT a.postId AS authorpostid, a.*, b.name, b.specialization FROM me_Post AS a, me_Author AS b WHERE a.authorId = b.authorId";
			StringBuffer sqlBuilder = new StringBuffer(base);
			/*List<String> criteria = new ArrayList<String>();
			if (Validator.isNotNull(title)) {
				criteria.add("me_Post.title like ?");
			}
			if (Validator.isNotNull(content)) {
				criteria.add("me_Post.content like ?");
			}
			if (Validator.isNotNull(author)) {
				criteria.add("me_Author.name like ?");
			}
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}*/
			/*
			 * If all the parameters was given, the "sql" variable content
			 * should be something like SELECT {me_Post.*} FROM
			 * me_Post JOIN me_Author ON
			 * me_Post.authorId = me_Author.authorId WHERE
			 * me_Post.title like ? AND me_Post.content like ?
			 * AND me_Author.name like ?//
			 */
			String sql = sqlBuilder.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("me_AuthorPost", AuthorPostImpl.class);

			/*QueryPos qPos = QueryPos.getInstance(q);
			// Setting the positions
			if (Validator.isNotNull(title)) {
				qPos.add("%" + title + "%");
			}
			if (Validator.isNotNull(content)) {
				qPos.add("%" + content + "%");
			}
			if (Validator.isNotNull(author)) {
				qPos.add("%" + author + "%");
			}*/

			// execute the query and return a list from the db
			return (List<AuthorPost>) QueryUtil.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}

	}

}
