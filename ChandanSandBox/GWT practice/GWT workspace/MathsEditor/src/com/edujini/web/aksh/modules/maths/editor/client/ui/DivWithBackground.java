/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a brief description of DivWithBackground.
 * <br/>
 * gvaish must provide more details about the type.
 *
 * @author gvaish
 *
 */
public class DivWithBackground extends Widget
{
	public DivWithBackground()
	{
		setElement(Document.get().createDivElement());
	}

	public void setBackgroundImage(String url)
	{
		getElement().getStyle().setBackgroundImage(url);
	}
}
