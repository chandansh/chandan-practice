<#include "init.ftl">

<@aui.layout>
<@aui.column>
	<@aui.select label="${HeaderText}" name="${HeaderText}" >
	 	<#list coreList as coreValue>
	    	<@aui.option value="${coreValue}">${coreValue}</@aui.option>
	  	</#list>
	</@aui.select>
</@aui.column>

<@aui.column>
	<@aui.input label="${name}" name="${name}" type="text" value="0">
		<@aui.validator name="required" />
	</@aui.input>
</@aui.column>
</@aui.layout>

