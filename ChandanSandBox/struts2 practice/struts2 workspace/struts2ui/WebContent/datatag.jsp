<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
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

</body>
</html>