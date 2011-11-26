/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client.ui;

import com.edujini.web.aksh.modules.maths.editor.client.MathsEditor;
import com.edujini.web.aksh.modules.maths.editor.client.ui.tooltip.TooltipManager;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a brief description of SymbolImage. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class SymbolImage extends Image implements IHasTooltip
{
	private String symbol;
	private String tooltip;
	private MathsEditor editor;

	public SymbolImage()
	{
		super();
		initialize();
	}

	protected SymbolImage(Element element)
	{
		super(element);
		initialize();
	}

	public SymbolImage(ImageResource resource)
	{
		super(resource);
		initialize();
	}

	public SymbolImage(String url, int left, int top, int width, int height)
	{
		super(url, left, top, width, height);
		initialize();
	}

	public SymbolImage(String url)
	{
		super(url);
		initialize();
	}

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	protected void onAttach()
	{
		super.onAttach();
		TooltipManager.getInstance().register(this);
		Widget parent = getParent();
		while(parent != null && !(parent instanceof MathsEditor))
		{
			parent = parent.getParent();
		}
		if(parent != null)
		{
			editor = (MathsEditor) parent;
		}
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onDetach()
	 */
	@Override
	protected void onDetach()
	{
		TooltipManager.getInstance().unregister(this);
		super.onDetach();
	}
	
	private void initialize()
	{
		addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				if(editor != null)
				{
					editor.insertSymbol(symbol);
				}
			}
		});
	}

	public MathsEditor getEditor()
	{
		return editor;
	}

	public void setEditor(MathsEditor editor)
	{
		this.editor = editor;
	}

	@Override
	public String getTooltip()
	{
		return tooltip;
	}

	@Override
	public void setTooltip(String tooltip)
	{
		this.tooltip = tooltip;
	}
}
