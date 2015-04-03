<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

<script type="text/javascript">

Liferay.bind(
'retrieveValue',
function(event, data) {
			alert("data after triggering >>> "+data);
			var arr = eval("(" + data + ')	');
			alert(arr);
			for(var i=0;i<arr.length;i++){
		var obj = arr[i];
		        alert("in first for loop >>> "+obj);
		for(var key in obj){
		var attrName = key;
		var attrValue = obj[key];
		            alert("attrName >> "+attrName+"  attrValue>>"+attrValue);
		
		            $('#author').append("<h1>"+attrName+"</h1>");
		            $('#authorValue').append("<h1>"+attrValue+"</h1>");
				
		        }
		    }

        }
     );


</script>


<table border="1" id="table">
		<tr id="firstTr">
			<th id="author"></th>
			<td id="authorValue"></td>
		</tr>		
</table>
