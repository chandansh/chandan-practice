package com.social;

import java.util.Collections;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import com.liferay.util.EncryptorException;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import java.util.LinkedHashMap;

public class PortletURLUtil {

	public String getURL (long primaryKey, ThemeDisplay themeDisplay) {

		String portletURL =  null;
		
		try {
			Object[]  plidAndPortletId = getPlidAndPortletId(themeDisplay.getScopeGroupId());

			long plid = (Long)plidAndPortletId[0];
			 
			_plid = plid;
			String portletId = (String)plidAndPortletId[1];
			_portletId = portletId;
			_lifecycle = PortletRequest.RENDER_PHASE;
			
			portletURL = generateToString(themeDisplay, primaryKey);
	 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	 return portletURL;
	}
	
	protected Object[] getPlidAndPortletId(long groupId)
			throws Exception {
			
			String portletId = "libraryportlet_WAR_libraryportlet";
			long plid = PortalUtil.getPlidFromPortletId(groupId, portletId);

			if (plid != LayoutConstants.DEFAULT_PLID) {
				return new Object[] {plid, portletId};
			}

			throw new NoSuchLayoutException();
		}
	
	public Layout getLayout() {
		if (_layout == null) {
			try {
				if (_plid > 0) {
					_layout = LayoutLocalServiceUtil.getLayout(_plid);
				}
			}
			catch (Exception e) {
				 e.printStackTrace();
			}
		}

		return _layout;
	}

	public Map<String, String> getReservedParameterMap(ThemeDisplay themeDisplay) {
		if (_reservedParameters != null) {
			return _reservedParameters;
		}

		_reservedParameters = new LinkedHashMap<String, String>();

		_reservedParameters.put("p_p_id", _portletId);

		if (_lifecycle.equals(PortletRequest.ACTION_PHASE)) {
			_reservedParameters.put("p_p_lifecycle", "1");
		}
		else if (_lifecycle.equals(PortletRequest.RENDER_PHASE)) {
			_reservedParameters.put("p_p_lifecycle", "0");
		}
		else if (_lifecycle.equals(PortletRequest.RESOURCE_PHASE)) {
			_reservedParameters.put("p_p_lifecycle", "2");
		}
 
		if (_portletMode != null) {
			_reservedParameters.put("p_p_mode", _portletMode.toString());
		}

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		if (Validator.isNotNull(portletDisplay.getColumnId())) {
			_reservedParameters.put("p_p_col_id", portletDisplay.getColumnId());
		}

		if (portletDisplay.getColumnPos() > 0) {
			_reservedParameters.put(
				"p_p_col_pos", String.valueOf(portletDisplay.getColumnPos()));
		}

		if (portletDisplay.getColumnCount() > 0) {
			_reservedParameters.put(
				"p_p_col_count",
				String.valueOf(portletDisplay.getColumnCount()));
		}

		_reservedParameters = Collections.unmodifiableMap(_reservedParameters);

		return _reservedParameters;
	}	
	
	public Portlet getPortlet(long companyId) {
		if (_portlet == null) {
			try {
				_portlet = PortletLocalServiceUtil.getPortletById(
						companyId, _portletId);
			}
			catch (SystemException se) {
				_log.error(se.getMessage());
			}
		}

		return _portlet;
	}
	
	public String generateToString(ThemeDisplay themeDisplay, long bookId) {
		
		String portalURL = themeDisplay.getPortalURL();
		
		StringBundler sb = new StringBundler(64);
		try {
			Layout layout = getLayout();

			if (layout != null) {
				_layoutFriendlyURL = GetterUtil.getString(
					PortalUtil.getLayoutFriendlyURL(layout, themeDisplay));
			}
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		
		Key key = null;
		
		if (Validator.isNull(_layoutFriendlyURL)) {
			sb.append(portalURL);
			sb.append(themeDisplay.getPathMain());
			sb.append("/portal/layout?");

			sb.append("p_l_id");
			sb.append(StringPool.EQUAL);
			sb.append(processValue(key, _plid));
			sb.append(StringPool.AMPERSAND);
		}
		else {
			if (themeDisplay.isFacebook()) {
				sb.append(portalURL);
			}
			else {
				if (!_layoutFriendlyURL.startsWith(Http.HTTP_WITH_SLASH) &&
					!_layoutFriendlyURL.startsWith(Http.HTTPS_WITH_SLASH)) {

					sb.append(portalURL);
				}

				sb.append(_layoutFriendlyURL);
			}

			sb.append(StringPool.QUESTION);

			for (Map.Entry<String, String> entry :
				getReservedParameterMap(themeDisplay).entrySet()) {
				String name = entry.getKey();
				sb.append(name);
				sb.append(StringPool.EQUAL);
				sb.append(processValue(key, entry.getValue()));
				sb.append(StringPool.AMPERSAND);
			}
		}
		
		sb.append("bookId=");
		sb.append(bookId);
		sb.append("&jspPage=");
		sb.append( "/html/library/details.jsp");
		
		
		String result = sb.toString();

		if (result.endsWith(StringPool.AMPERSAND) ||
			result.endsWith(StringPool.QUESTION)) {

			result = result.substring(0, result.length() - 1);
		}

		return result;
	}

	protected String processValue(Key key, long value) {
		return processValue(key, String.valueOf(value));
	}
	
	protected String processValue(Key key, String value) {
		if (key == null) {
			return HttpUtil.encodeURL(value);
		}
		else {
			try {
				return HttpUtil.encodeURL(com.liferay.util.Encryptor.encrypt((java.security.Key) key, value));
			}
			catch (EncryptorException ee) {
				return value;
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PortletURLUtil.class);

	private Layout _layout;
	private String _layoutFriendlyURL;
	private String _lifecycle;
	private long _plid;
	private Portlet _portlet;
	private String _portletId;
	private PortletMode _portletMode;
	private Map<String, String> _reservedParameters;
	
}


