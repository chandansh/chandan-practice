<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/css/jquery-ui-1.9.2.custom.css" />

<link rel="stylesheet" type="text/css" media="screen"
	href="<%=request.getContextPath()%>/css/ui.jqgrid.css" />

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery/jquery-1.7.1.js"></script>

<script
	src="<%=request.getContextPath()%>/js/jquery/grid/grid.locale-en.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery/grid/jquery.jqGrid.min.js"
	type="text/javascript"></script>
<portlet:defineObjects />

This is the
<b>JsonPortlet</b>
portlet.

<script type="text/javascript">
	jQuery(document).ready(function() {
		getCountries();
/*
		jQuery("#list2").jqGrid({
		   	url:"http://localhost:7092/api/secure/jsonws/country/get-countries?",
			datatype: "string",
		   	colNames:['A2','A3', 'Active', 'country Id','Idd','Name','Number', 'Zip'],
		   	colModel:[
		   		{name:'a2',index:'a2', width:55},
		   		{name:'a3',index:'a3', width:90},
		   		{name:'active',index:'active', width:100},
		   		{name:'countryId',index:'countryId', width:80, align:"right"},
		   		{name:'idd',index:'idd', width:80, align:"right"},		
		   		{name:'name',index:'name', width:80,align:"right"},		
		   		{name:'number',index:'number', width:150 },
		   		{name:'zipRequired',index:'zipRequired', width:150}
		   	],
		   	rowNum:10,
		   	rowList:[10,20,30],
		   	pager: '#pager2',
		   	sortname: 'id',
		    viewrecords: true,
		    sortorder: "desc",
		    caption:"JSON Example"
		});
		jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false}); */
		
		//working code
		/*jQuery("#list4").jqGrid({ 
			datatype: "local",
			height: 250,
			colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
			colModel:[ {name:'id',index:'id', width:60, sorttype:"int"},
			           {name:'invdate',index:'invdate', width:90, sorttype:"date"},
			           {name:'name',index:'name', width:100},
			           {name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
			           {name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},
			           {name:'total',index:'total', width:80,align:"right",sorttype:"float"},
			           {name:'note',index:'note', width:150, sortable:false} ],
			multiselect: true,
			caption: "Manipulating Array Data"
			});
		var mydata = [ {id:"1",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
		               {id:"2",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
		               {id:"3",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
		               {id:"4",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
		               {id:"5",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
		               {id:"6",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
		               {id:"7",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
		               {id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
		               {id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
		               ]; 
		for(var i=0;i<=mydata.length;i++)
			jQuery("#list4").jqGrid('addRowData',i+1,mydata[i]);*/
	});

	function getCountries() {
		jQuery.get("http://localhost:8080/api/secure/jsonws/country/get-countries?p_auth=H41Mwmrv",
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
			jQuery("#list4").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:true,
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

