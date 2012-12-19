<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/jquery-ui-1.9.2.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/ui.jqgrid.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.7.1.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery/grid/grid.locale-en.js" type="text/javascript"></script>
<script	src="<%=request.getContextPath()%>/js/jquery/grid/jquery.jqGrid.min.js"	type="text/javascript"></script>
<portlet:defineObjects />

This is the<b>JsonPortlet</b>portlet.

<script type="text/javascript">
	jQuery(document).ready(function() {
		getCountries();
	});

	function getCountries() {
		jQuery.get("http://localhost:8084/api/secure/jsonws/country/get-countries",
						function(data) {
							//alert("Data Loaded: " + data);
							var mydata = JSON.parse(data);
							/* for (var k in mydata) {
								jQuery("#mydata").append("<p>" + mydata[k] + "</p>");
							} */
							//jQuery("#mydata").html("<p>" + mydata + "</p>");

							jQuery("#list4").jqGrid(
									{
										datatype : "local",
										height : 250,
										colNames:['A2','A3', 'Active', 'country Id','Idd','Name','Number', 'Zip'],
									   	colModel:[
									   		{name:'a2',index:'a2', width:55, editable:true,editoptions:{size:10}},
									   		{name:'a3',index:'a3', width:90, editable:true,editoptions:{size:10}},
									   		{name:'active',index:'active', width:100,editable:true,edittype:"checkbox",editoptions:{value:"Yes:No"}},
									   		{name:'countryId',index:'countryId', width:80, align:"right", editable:true,editoptions:{size:10}},
									   		{name:'idd',index:'idd', width:80, align:"right", editable:true,editoptions:{size:10}},		
									   		{name:'name',index:'name', width:80,align:"right", editable:true,editoptions:{size:10}},		
									   		{name:'number',index:'number', width:150, editable:true,editoptions:{size:10} },
									   		{name:'zipRequired',index:'zipRequired', width:150,editable:true,edittype:"checkbox",editoptions:{value:"Yes:No"}}
									   	],
										//multiselect : true,
										rowNum:10,
									   	rowList:[10,20,30],
									   	pager: '#pager4',
										caption : "Manipulating Array Data",
										editurl:"home"
									});
							jQuery("#list4").jqGrid('navGrid','#pager4',{edit:false,add:false,del:false}); 
							for ( var i = 0; i <= mydata.length; i++)
								jQuery("#list4").jqGrid('addRowData', i+1,mydata[i]);
						});
		$("#bedata").click(function(){ 
			jQuery("#list4").jqGrid('editGridRow',"new",{height:350,reloadAfterSubmit:true,
				beforeSubmit : function(postdata, formid) {
					alert(JSON.stringify(postdata));
					return[true,"sumitted"];
				} ,
				afterSubmit : function(response, postdata)
				{
				return [true,"Hello",12];
				} 
			});
			//alert(data);
		});
	}
</script>
<div id="mydata"></div>

<table id="list2"></table>
<div id="pager2"></div>

<table id="list4"></table>
<div id="pager4"></div>
<input type="BUTTON" id="bedata" value="Add" />

