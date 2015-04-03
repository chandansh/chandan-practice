package com.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;


import com.library.slayer.model.LMSBook;
import com.library.slayer.service.LMSBookLocalServiceUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

/**
 * @author Veena
 *
 */
public class LibraryIndex extends BaseIndexer {

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.Indexer#getClassNames()
	 */
	
	public static final String[] CLASS_NAMES = { LMSBook.class.getName() };
	
	@Override
	public String[] getClassNames()
	{
		return CLASS_NAMES;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.Indexer#getPortletId()
	 */
	@Override
	public String getPortletId()
	{
		return Long.toString(ClassNameLocalServiceUtil.getClassNameId(LMSBook.class)) ;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#doDelete(java.lang.Object)
	 */
	@Override
	protected void doDelete(Object arg0) throws Exception
	{

	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#doGetDocument(java.lang.Object)
	 */
	@Override
	protected Document doGetDocument(Object obj) throws Exception
	{		
		LMSBook entry = (LMSBook) obj;
		
		Document document = getBaseModelDocument(getPortletId(), entry); 
		
		document.addKeyword(Field.ENTRY_CLASS_PK, entry.getPrimaryKey());
		document.addKeyword(Field.TITLE, entry.getBookTitle());
		document.addKeyword(Field.DESCRIPTION, entry.getDescription());
		document.addKeyword(Field.NAME, entry.getAuthor());
		document.addKeyword(Field.COMPANY_ID, entry.getCompanyId());
		
        document.addText(Field.TITLE,  entry.getBookTitle());
        document.addText(Field.DESCRIPTION, entry.getDescription());
        document.addText(Field.NAME, entry.getAuthor());
        
		return document;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#doGetSummary(com.liferay.portal.kernel.search.Document, java.util.Locale, java.lang.String, javax.portlet.PortletURL)
	 */
	@Override
	protected Summary doGetSummary(Document document, Locale arg1, String arg2,
			PortletURL portletURL) throws Exception {

        String title = document.get(Field.TITLE);
        //String description = document.get(Field.DESCRIPTION);
        String url = document.get(Field.URL);
        String entryId = document.get(Field.ENTRY_CLASS_PK);
        portletURL.setParameter("entryId", entryId);
         
        return new Summary(title, url, portletURL);

	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#doReindex(java.lang.Object)
	 */
	@Override
	protected void doReindex(Object obj) throws Exception
	{
		LMSBook entry = (LMSBook) obj;
        Document document = getDocument(entry);
        SearchEngineUtil.updateDocument(entry.getCompanyId(), document);
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#doReindex(java.lang.String[])
	 */
	@Override
	protected void doReindex(String[] arg0) throws Exception
	{
		long companyId = GetterUtil.getLong(arg0[0]);
		List<LMSBook> entries = LMSBookLocalServiceUtil.getLMSBooks(0, -1);
        if (entries.isEmpty())
        {
            return;
        }
        Collection<Document> documents = new ArrayList<Document>();
        for (LMSBook entry : entries)
        {
            Document document = getDocument(entry);
            documents.add(document);
        }
        SearchEngineUtil.updateDocuments(companyId, documents);
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#doReindex(java.lang.String, long)
	 */
	@Override
	protected void doReindex(String arg0, long classPK) throws Exception
	{
		LMSBook entry = LMSBookLocalServiceUtil.getLMSBook(classPK);
        doReindex(entry);
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.BaseIndexer#getPortletId(com.liferay.portal.kernel.search.SearchContext)
	 */
	@Override
	protected String getPortletId(SearchContext arg0) {
		// TODO Auto-generated method stub
		return getPortletId();
	}

}
