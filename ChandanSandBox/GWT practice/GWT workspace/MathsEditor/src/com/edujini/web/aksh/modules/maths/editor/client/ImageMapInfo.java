/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client;

/**
 * This is a brief description of MapCoordyInfo. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class ImageMapInfo
{
	public int left;
	public int top;
	public int right;
	public int bottom;

	public String value;

	public ImageMapInfo(int left, int top, int right, int bottom, String value)
	{
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.value = value;
	}

	public static ImageMapInfo createInfo(int left, int top, int right, int bottom, String value)
	{
		return new ImageMapInfo(left, top, right, bottom, value);
	}
}
