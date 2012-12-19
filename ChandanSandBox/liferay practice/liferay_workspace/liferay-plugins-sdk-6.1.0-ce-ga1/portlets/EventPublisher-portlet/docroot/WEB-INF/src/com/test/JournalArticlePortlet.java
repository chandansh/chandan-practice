package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class JournalArticlePortlet
 */
public class JournalArticlePortlet extends MVCPortlet {
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					JournalArticle.class.getName(), actionRequest);
			

			Company defaultComapny = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());
			
			
			String languageId = LanguageUtil.getLanguageId(actionRequest);
			serviceContext.setAttribute("defaultLanguageId", languageId);

			String content = "<?xml version=\"1.0\"?><root available-locales=\"en_US\"" +
					" default-locale=\"en_US\"><static-content language-id=\"en_US\">&lt;p&gt; " +
					"hello test web content from code&lt;/p&gt;</static-content></root>";
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			JournalArticle article = JournalArticleLocalServiceUtil.createJournalArticle(CounterLocalServiceUtil.increment());
			article.setContent(content);
			article.setDescription("hello description");
			article.setNew(true);
			article.setGroupId(themeDisplay.getScopeGroupId());
			article.setArticleId(""+ CounterLocalServiceUtil.increment());
			article.setVersion(1.0);
			//JournalArticleLocalServiceUtil.addJournalArticle(article);
			
			System.out.println("updated....");
			
			Map<Locale, String> titleMap = new HashMap<Locale, String>();
			titleMap.put(themeDisplay.getLocale(), "test Title");
			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
			descriptionMap.put(themeDisplay.getLocale(), "test Description");
			
			Calendar today = Calendar.getInstance();
			today.add(Calendar.DAY_OF_MONTH, -1);
		     
			Group group = GroupLocalServiceUtil.getGroup(10154, "Guest");
		        
			/*JournalArticle article1 = JournalArticleServiceUtil.addArticle(
					group.getGroupId(), 0l, 0l, "0", true,
					titleMap, descriptionMap, content, "general", "",
					"", "", 1 + today.get(Calendar.MONTH) -1, today.get(Calendar.DAY_OF_MONTH),
					today.get(Calendar.YEAR), today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE),
					0, 0, 0,
					0, 0, true,
					0, 0, 0, 0,
					0, true, true, false,
					"", new File("c:/hello"), new HashMap<String, byte[]>(), "test-title", serviceContext);*/
			//JournalStructureLocalServiceUtil.addStructure(userId, groupId, structureId, autoStructureId, parentStructureId, nameMap, descriptionMap, xsd, serviceContext);
			//JournalTemplateLocalServiceUtil.addTemplate(userId, groupId, templateId, autoTemplateId, structureId, nameMap, descriptionMap, xsl, formatXsl, langType, cacheable, smallImage, smallImageURL, smallImageFile, serviceContext)
				
			JournalArticle article2 =  JournalArticleLocalServiceUtil.addArticle(14828l, group.getGroupId(), 0l, 0l, "0",
					true, 1.0, titleMap, descriptionMap, content, "general", "", "", 
					"",  today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.YEAR), today.get(Calendar.HOUR_OF_DAY),
					today.get(Calendar.MINUTE), 0, 0, 0,
					0, 0, true, 0, 0, 0, 0, 0, true, true, false,
					"", new File("c:/hello"), new HashMap<String, byte[]>(), "test-title", serviceContext);
			
			Role guestRole = RoleLocalServiceUtil.getRole(10154, RoleConstants.GUEST);
			ResourcePermissionLocalServiceUtil.setResourcePermissions(10154, "com.liferay.portlet.journal.model.JournalArticle", 4, ""+article2.getResourcePrimKey(), guestRole.getRoleId(), new String[] 
					{ActionKeys.VIEW} );
			
			System.out.println(article2 + "\n :: added" );
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.processAction(actionRequest, actionResponse);
	}

}
