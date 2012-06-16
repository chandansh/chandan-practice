
<#include "init.ftl">

<@aui.input label="Name" name="name" type="text" value="val">
		<@aui.validator name="required" />
</@aui.input>
<@aui.select label="city" name="city1" >
	<@aui.option value="dynamic1">dynamic1</@aui.option>
	<@aui.option value="dynamic2">dynamic2</@aui.option>
	<@aui.option value="dynamic3">dynamic3</@aui.option>
	<@aui.option value="dynamic4">dynamic4</@aui.option>
</@aui.select>

	<@aui.fieldset label="field Set">
		<@aui.input label="Name" name="name1" type="text" value="val">
			<@aui.validator name="required" />
		</@aui.input>
		<@aui.select label="city" name="city2" >
			<@aui.option value="dynamic1">dynamic1</@aui.option>
			<@aui.option value="dynamic2">dynamic2</@aui.option>
			<@aui.option value="dynamic3">dynamic3</@aui.option>
			<@aui.option value="dynamic4">dynamic4</@aui.option>
		</@aui.select>
	</@aui.fieldset>

	