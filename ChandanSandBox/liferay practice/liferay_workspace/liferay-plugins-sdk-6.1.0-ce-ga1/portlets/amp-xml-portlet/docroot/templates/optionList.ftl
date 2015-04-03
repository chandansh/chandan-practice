<#include "init.ftl">

<@aui.select label="${name}" name="${name}" >
 	<#list optList as opt>
    	<@aui.option value="${opt}">${opt}</@aui.option>
  	</#list>
</@aui.select>