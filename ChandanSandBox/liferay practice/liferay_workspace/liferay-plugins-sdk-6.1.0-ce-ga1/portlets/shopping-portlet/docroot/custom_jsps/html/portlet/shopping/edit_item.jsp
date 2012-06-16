<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/shopping/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

ShoppingItem item = (ShoppingItem)request.getAttribute(WebKeys.SHOPPING_ITEM);

long itemId = BeanParamUtil.getLong(item, request, "itemId");

long categoryId = BeanParamUtil.getLong(item, request, "categoryId", ShoppingCategoryConstants.DEFAULT_PARENT_CATEGORY_ID);

// Fields

ShoppingItemField[] itemFields = null;

int fieldsCount = ParamUtil.getInteger(request, "fieldsCount");
String fieldsCountParam = request.getParameter("fieldsCount");
if ((fieldsCountParam == null) || (fieldsCountParam.equals(StringPool.NULL))) {
	if (item != null) {
		itemFields = (ShoppingItemField[])ShoppingItemFieldLocalServiceUtil.getItemFields(itemId).toArray(new ShoppingItemField[0]);
		fieldsCount = itemFields.length;
	}
	else {
		itemFields = new ShoppingItemField[0];
	}
}
else {
	itemFields = new ShoppingItemField[fieldsCount];
}

int fieldId = ParamUtil.getInteger(request, "fieldId", -1);

String fieldsQuantities = "";

if (item != null) {
	fieldsQuantities = GetterUtil.getString(item.getFieldsQuantities());
}

// Prices

ShoppingItemPrice[] itemPrices = null;

int pricesCount = ParamUtil.getInteger(request, "pricesCount", 1);
String pricesCountParam = request.getParameter("pricesCount");
if ((pricesCountParam == null) || (pricesCountParam.equals(StringPool.NULL))) {
	if (item != null) {
		itemPrices = (ShoppingItemPrice[])ShoppingItemPriceLocalServiceUtil.getItemPrices(itemId).toArray(new ShoppingItemPrice[0]);
		pricesCount = itemPrices.length;
	}
	else {
		itemPrices = new ShoppingItemPrice[1];
	}
}
else {
	itemPrices = new ShoppingItemPrice[pricesCount];
}

int priceId = ParamUtil.getInteger(request, "priceId", -1);
%>

<portlet:actionURL var="editItemURL">
	<portlet:param name="struts_action" value="/shopping/edit_item" />
</portlet:actionURL>

<aui:form action="<%= editItemURL %>" enctype="multipart/form-data" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveItem();" %>'>
	<input name="scroll" type="hidden" value="" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="categoryId" type="hidden" value="<%= categoryId %>" />
	<aui:input name="itemId" type="hidden" value="<%= itemId %>" />
	<aui:input name="fieldsCount" type="hidden" value="<%= fieldsCount %>" />
	<aui:input name="fieldId" type="hidden" />
	<aui:input name='<%= "fieldName" + fieldsCount %>' type="hidden" />
	<aui:input name='<%= "fieldValues" + fieldsCount %>' type="hidden" />
	<aui:input name='<%= "fieldDescription" + fieldsCount %>' type="hidden" />
	<aui:input name="fieldsQuantities" type="hidden" value="<%= fieldsQuantities %>" />
	<aui:input name="pricesCount" type="hidden" value="<%= pricesCount %>" />
	<aui:input name="priceId" type="hidden" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="item"
	/>

	<liferay-ui:error exception="<%= DuplicateItemSKUException.class %>" message="the-item-sku-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= ItemNameException.class %>" message="please-enter-a-valid-name" />
	<liferay-ui:error exception="<%= ItemSKUException.class %>" message="please-enter-a-valid-item-sku" />

	<div class="breadcrumbs">
		<%= ShoppingUtil.getBreadcrumbs(categoryId, pageContext, renderRequest, renderResponse) %>
	</div>

	<aui:fieldset>
		<c:if test="<%= item != null %>">
			<aui:field-wrapper label="category">

				<%
				String categoryName = "";

				if (categoryId != ShoppingCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
					ShoppingCategory category = ShoppingCategoryServiceUtil.getCategory(categoryId);

					category = category.toEscapedModel();

					categoryName = category.getName();
				}
				%>

				<portlet:renderURL var="viewCategoryURL">
					<portlet:param name="struts_action" value="/shopping/view" />
					<portlet:param name="categoryId" value="<%= String.valueOf(categoryId) %>" />
				</portlet:renderURL>

				<aui:a href="<%= viewCategoryURL %>" id="categoryName" label="<%= categoryName %>" />

				<portlet:renderURL var="selectCateforyURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="struts_action" value="/shopping/select_category" />
					<portlet:param name="categoryId" value="<%= String.valueOf(categoryId) %>" />
				</portlet:renderURL>

				<%
				String taglibOpenCategoryWindow = "var categoryWindow = window.open('" + selectCateforyURL + "', 'category', 'directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680'); void(''); categoryWindow.focus();";
				%>

				<aui:button onClick="<%= taglibOpenCategoryWindow %>" value="select" />

				<aui:button onClick='<%= renderResponse.getNamespace() + "removeCategory();" %>' value="remove" />
			</aui:field-wrapper>
		</c:if>

		<%-- line commented and replaced by hasan@mpowerglobal.com 
		<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="sku" />
		--%>

		<aui:input type="hidden" value="<%= getSku(item) %>" name="sku"/>

		<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="name" />

		<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="description" />

		<%-- lines commented out by hasan@mpowerglobal.com 
		<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="properties" />

		<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="requiresShipping" />
		--%>

		<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="featured" />

		<c:if test="<%= fieldsCount == 0 %>">
			<%-- commented and replaced by hasan@mpowerglobal.com 
			<aui:input bean="<%= item %>" model="<%= ShoppingItem.class %>" name="stockQuantity" />
			--%>
			<aui:input type="hidden" name="stockQuantity" value="2147483647"/>
		</c:if>

		<c:if test="<%= item == null %>">
			<aui:field-wrapper label="permissions">
				<liferay-ui:input-permissions
					modelName="<%= ShoppingItem.class.getName() %>"
				/>
			</aui:field-wrapper>
		</c:if>
	
		<%
		for (int i = 0; i < pricesCount; i++) {
			int curPriceId = i;
	
			if (priceId > -1 && i >= priceId) {
				curPriceId++;
			}
	
			int minQuantity = ParamUtil.getInteger(request, "minQuantity" + curPriceId, 0);
			String minQuantityParam = request.getParameter("minQuantity" + curPriceId);
			if ((minQuantityParam == null) || (minQuantityParam.equals(StringPool.NULL))) {
				if (itemPrices[curPriceId] != null) {
					minQuantity = itemPrices[curPriceId].getMinQuantity();
				}
			}
	
			int maxQuantity = ParamUtil.getInteger(request, "maxQuantity" + curPriceId);
			String maxQuantityParam = request.getParameter("maxQuantity" + curPriceId);
			if ((maxQuantityParam == null) || (maxQuantityParam.equals(StringPool.NULL))) {
				if (itemPrices[curPriceId] != null) {
					maxQuantity = itemPrices[curPriceId].getMaxQuantity();
				}
			}
	
			double price = ParamUtil.getDouble(request, "price" + curPriceId);
			String priceParam = request.getParameter("price" + curPriceId);
			if ((priceParam == null) || (priceParam.equals(StringPool.NULL))) {
				if (itemPrices[curPriceId] != null) {
					price = itemPrices[curPriceId].getPrice();
				}
			}
			
			%><aui:input field="price" fieldParam='<%= "price" + i %>' format="<%= doubleFormat %>" label="price" model="<%= ShoppingItemPrice.class %>" name="price" value="<%= String.valueOf(price) %>" /><%
		}	
		%>
		</aui:fieldset>
		
		<liferay-ui:error exception="<%= ItemSmallImageNameException.class %>">

			<%
			String[] imageExtensions = PrefsPropsUtil.getStringArray(PropsKeys.SHOPPING_IMAGE_EXTENSIONS, StringPool.COMMA);
			%>

			<liferay-ui:message key="image-names-must-end-with-one-of-the-following-extensions" /> <%= StringUtil.merge(imageExtensions, ", ") %>.
		</liferay-ui:error>

		<liferay-ui:error exception="<%= ItemSmallImageSizeException.class %>">

			<%
			long imageMaxSize = PrefsPropsUtil.getLong(PropsKeys.SHOPPING_IMAGE_SMALL_MAX_SIZE) / 1024;
			%>

			<liferay-ui:message arguments="<%= imageMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
		</liferay-ui:error>

		<aui:fieldset>
			<aui:input label="small-image-url" name="smallImageURL" />

			<span style="font-size: xx-small;">-- <%= LanguageUtil.get(pageContext, "or").toUpperCase() %> --</span> <liferay-ui:message key="small-image" />

			<aui:input label="" name="smallFile" type="file" />
			
			<aui:input type="hidden" name="smallImage" value="<%= true %>"/>
		</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
	
</aui:form>

<aui:script>
	function <portlet:namespace />addField() {
		document.<portlet:namespace />fm.scroll.value = "<portlet:namespace />fields";
		document.<portlet:namespace />fm.<portlet:namespace />fieldsCount.value = <%= fieldsCount + 1 %>;
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />addPrice() {
		document.<portlet:namespace />fm.scroll.value = "<portlet:namespace />prices";
		document.<portlet:namespace />fm.<portlet:namespace />pricesCount.value = <%= pricesCount + 1 %>;
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />deleteField(i) {
		document.<portlet:namespace />fm.scroll.value = "<portlet:namespace />fields";
		document.<portlet:namespace />fm.<portlet:namespace />fieldsCount.value = <%= fieldsCount - 1 %>;
		document.<portlet:namespace />fm.<portlet:namespace />fieldId.value = i;
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />deletePrice(i) {
		if (document.<portlet:namespace />fm.<portlet:namespace />defaultPrice[i].checked) {
			alert("<%= UnicodeLanguageUtil.get(pageContext, "you-cannot-delete-or-deactivate-a-default-price") %>");
		}
		else if (document.<portlet:namespace />fm.<portlet:namespace />pricesCount.value > 1) {
			document.<portlet:namespace />fm.scroll.value = "<portlet:namespace />prices";
			document.<portlet:namespace />fm.<portlet:namespace />pricesCount.value = <%= pricesCount - 1 %>;
			document.<portlet:namespace />fm.<portlet:namespace />priceId.value = i;
			submitForm(document.<portlet:namespace />fm);
		}
	}

	function <portlet:namespace />editItemQuantities() {
		var itemQuantitiesURL = "<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" anchor="false"><portlet:param name="struts_action" value="/shopping/edit_item_quantities" /></liferay-portlet:renderURL>&<portlet:namespace />fieldsQuantities=" + document.<portlet:namespace />fm.<portlet:namespace />fieldsQuantities.value;

		<%
		for (int i = 0; i < fieldsCount; i++) {
		%>

			itemQuantitiesURL += "&<portlet:namespace />n<%= i %>=" + encodeURIComponent(document.<portlet:namespace />fm.<portlet:namespace />fieldName<%= i %>.value);
			itemQuantitiesURL += "&<portlet:namespace />v<%= i %>=" + encodeURIComponent(document.<portlet:namespace />fm.<portlet:namespace />fieldValues<%= i %>.value);

		<%
		}
		%>

		var itemQuantitiesWindow = window.open(itemQuantitiesURL, "itemQuantities", "directories=no,height=400,location=no,menubar=no,resizable=no,scrollbars=yes,status=no,toolbar=no,width=300");

		void("");

		itemQuantitiesWindow.focus();
	}

	function <portlet:namespace />removeCategory() {
		document.<portlet:namespace />fm.<portlet:namespace />categoryId.value = "<%= ShoppingCategoryConstants.DEFAULT_PARENT_CATEGORY_ID %>";

		var nameEl = document.getElementById("<portlet:namespace />categoryName");

		nameEl.href = "";
		nameEl.innerHTML = "";
	}

	function <portlet:namespace />saveItem() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (item == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectCategory(categoryId, categoryName) {
		document.<portlet:namespace />fm.<portlet:namespace />categoryId.value = categoryId;

		var nameEl = document.getElementById("<portlet:namespace />categoryName");

		nameEl.href = "<portlet:renderURL><portlet:param name="struts_action" value="/shopping/view" /></portlet:renderURL>&<portlet:namespace />categoryId=" + categoryId;
		nameEl.innerHTML = categoryName + "&nbsp;";
	}
</aui:script>

<%!
	private static String getSku(ShoppingItem item) {
		
		StringBuilder sb = new StringBuilder();	
	
		if (Validator.isNull(item)) {
			sb.append("HR");
			
			try {
				long index = CounterLocalServiceUtil.increment("com.hoperay.shopping.sku");
				
				String width = "5";
				
				sb.append(String.format("%0" + width + "d", index));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} else {
			sb.append(item.getSku());
		}
	
		return sb.toString();
	}
%>