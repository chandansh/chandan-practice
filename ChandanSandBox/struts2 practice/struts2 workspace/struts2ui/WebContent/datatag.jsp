<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style>
.odd{
background-color: lime;
}
.even{
background-color: silver;
}
</style>
<s:head />

<title>Album Details</title>
</head>
<body>
	<div class="content">
		<b>Album Title :</b>
		<s:property value="title" />
		<br> <b>Artist Name :</b>
		<s:property value="artist.name" />
		<br> <b>Artist Bio :</b>
		<s:property value="artist.bio" />
		<br>
	</div>
	<H3>Using &lt; s :set tag</H3>
	<br>
	<s:set name="artistName" value="artist.name" />
	<s:set name="artistBio" value="artist.bio" />
	<b>Album Title :</b>
	<s:property value="title" />
	<br>
	<b>Artist Name :</b>
	<s:property value="#artistName" />
	<br>
	<b>Artist Bio :</b>
	<s:property value="#artistBio" />
	<br>

	<h3>Using &lt;s :set at session scope</h3>
	<br>
	<s:set name="artistName" value="artist.name" scope="session" />
	<s:set name="artistBio" value="artist.bio" scope="session" />
	<b>Album Title :</b>
	<s:property value="title" />
	<br>
	<b>Artist Name :</b>
	<s:property value="#session['artistName']" />
	<br>
	<b>Artist Bio :</b>
	<s:property value="#session['artistBio']" />
	<br>

	<h3>using push tag</h3>
	<b>Album Title :</b>
	<s:property value="title" />
	<br>
	<s:push value="artist">
		<b>Artist Name :</b>
		<s:property value="name" />
		<br>
		<b>Artist Bio :</b>
		<s:property value="bio" />
		<br>
	</s:push>
<h3> Iterator Tag Struts 2</h3>
	<table border="1" class="songTable">
		<tr class="even">
			<td><b>Title</b></td>
			<td><b>Genre</b></td>
		</tr>
		<s:iterator value="songs" status="songStatus">
			<tr
				class="<s:if test="#songStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td>Hello<s:property value="title" /></td>
				<td>Hello1<s:property value="genre" /></td>
			</tr>
		</s:iterator>
	</table>
	
	<h3>Array Usage</h3>
<b>Array Usage Examples</b>
<br><hr>
<b>sampleArray :</b> <s:property value="sampleArray"/> <br>
<b>sampleArray.length :</b> <s:property value="sampleArray.length"/> <br>
<b>sampleArray[0] :</b> <s:property value="sampleArray[0]"/> <br>
<b>[0].sampleArray :</b> <s:property value="[0].sampleArray"/> <br>
<b>top.sampleArray :</b> <s:property value="top.sampleArray"/> <br>
<b>List Usage Examples</b>
<br><hr>
<b>sampleList :</b> <s:property value="sampleList"/> <br>
<b>sampleList.size :</b> <s:property value="sampleList.size"/> <br>
<b>sampleList[0] :</b> <s:property value="sampleList[0]"/> <br>


<b>Map Usage Examples</b>
<br><hr>
<b>myMap :</b> <s:property value="myMap"/> <br>
<b>myMap[1] :</b> <s:property value="myMap[1]"/> <br>
<b>myMap.size :</b> <s:property value="myMap.size"/> <br>
You can also create a map in the jsp page using the following syntax.
<s:select list="#{'make1':'Ford', 'make2':'Honda', 'make3':'Toyota'}" name="carMake" label="Select "></s:select>
<br>
<h3>Method call using OGNL</h3>
<b>welcome() :</b> <s:property value="welcome()"/> <br>
</body>
</html>