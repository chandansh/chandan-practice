/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client.ui.tooltip;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a brief description of Tooltip.
 * <br/>
 * gvaish must provide more details about the type.
 *
 * @author gvaish
 *
 */
public class Tooltip extends Widget implements HasHTML
{
	public Tooltip()
	{
		DivElement e = Document.get().createDivElement();
		setElement(e);
		//setStyleName("tooltip");
	}

	@Override
	public String getText()
	{
		return getElement().getInnerText();
	}

	@Override
	public void setText(String text)
	{
		getElement().setInnerText(text);
	}

	@Override
	public String getHTML()
	{
		return getElement().getInnerHTML();
	}

	@Override
	public void setHTML(String html)
	{
		getElement().setInnerHTML(html);
	}
	
}
