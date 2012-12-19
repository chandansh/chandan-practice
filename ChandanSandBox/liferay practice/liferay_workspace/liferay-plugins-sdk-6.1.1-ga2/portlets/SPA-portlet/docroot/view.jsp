<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/jquery-ui-1.9.2.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/ui.jqgrid.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.7.1.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery/grid/grid.locale-en.js" type="text/javascript"></script>
<script	src="<%=request.getContextPath()%>/js/jquery/grid/jquery.jqGrid.min.js"	type="text/javascript"></script>
<portlet:defineObjects />

This is the<b>Single Page Application</b>portlet.

<script type="text/javascript">
	jQuery(document).ready(function() {
		getCars();
		$("#bedata").click(function(){ 
			jQuery("#list4").jqGrid('editGridRow',"new",{height:150,reloadAfterSubmit:true,
				beforeSubmit : function(postdata, formid) {
					var id = Math.floor(Math.random()*10001);
					var b = postdata['brand'];
					var c = postdata['color'];
					postdata['carId'] = id;
					var payLoad = { 
							carId: id,
							brand: b,
							color: c
							};
					//var myPayload = payLoad;
					//alert(JSON.stringify(myPayload));
					Liferay.Service.myslayer.Car.insertCar(payLoad, function(data, status){
						//alert(JSON.stringify(data) + JSON.stringify(status));
						//postdata['carId'] = data['carId'];
						//alert(JSON.stringify(postdata));
					});
					
					return[true,"sumitted"];
				} ,
				afterSubmit : function(response, postdata){
					return [true,"Hello",12];
				},
				afterComplete : function (response, postdata, formid){
					getCars();
				}
			});
		});
		
		$("#dedata").click(function(){
				var gr = jQuery("#list4").jqGrid('getGridParam','selrow');
				if( gr != null ) {
					jQuery("#list4").jqGrid('delGridRow',gr,{reloadAfterSubmit:true,
						beforeSubmit : function(postdata, formid) {
							var rowdata = jQuery("#list4").jqGrid("getRowData",gr);
							//alert(JSON.stringify(rowdata));
							var id = rowdata['carId'];
							//alert("carId : " + id);
							var payLoad = {carId: id};
							/* var myPayload = payLoad;
							alert(JSON.stringify(myPayload)); */
							Liferay.Service.myslayer.Car.deleteCar(payLoad, function(data, status){
								//alert(JSON.stringify(data) + JSON.stringify(status));
								//postdata['carId'] = data['carId'];
								//alert(JSON.stringify(postdata));
								
							});
							
							return[true,"sumitted"];
						},
						afterSubmit : function(response, postdata){
							return [true,"Hello",12];
						},
						afterComplete : function (response, postdata, formid){
							getCars();
						}
					});
				}
				else 
					alert("Please Select Row to delete!"); 
			});
		
		$("#eddata").click(function(){
				var gr = jQuery("#list4").jqGrid('getGridParam','selrow'); 
				if( gr != null ){
					jQuery("#list4").jqGrid('editGridRow',gr,{height:150,reloadAfterSubmit:true,
						beforeSubmit : function(postdata, formid) {
							var rowdata = jQuery("#list4").jqGrid("getRowData",gr);
							//alert(JSON.stringify(rowdata));
							var id = rowdata['carId'];
							var b = postdata['brand'];
							var c = postdata['color'];
							//alert("carId : " + id);
							var payLoad = {
									carId: id,
									brand: b,
									color: c
							};
							Liferay.Service.myslayer.Car.updateCar(payLoad, function(data, status){
							
							});
							return[true,"sumitted"];
						},
						afterSubmit : function(response, postdata){
							return [true,"Hello",12];
						},
						afterComplete : function (response, postdata, formid){
							getCars();
						}
					});
					//alert(JSON.stringify(gr));
				}	
				else
					alert("Please Select Row"); 
			});
			
		
	}); // end of document .ready

	function getCars() {
		$("#list4").jqGrid("clearGridData", true).trigger("reloadGrid");
		//alert(location.host);
		jQuery.get("http://" + location.host + "/SPA-portlet/api/secure/jsonws/car/get-all-cars",
						function(data) {
							var mydata = JSON.parse(data);
							jQuery("#list4").jqGrid(
									{
										datatype : "local",
										height : 140,
										colNames:['Car Id','Brand', 'Color'],
									   	colModel:[
									   		{name:'carId',index:'a2', width:55, editable:false,editoptions:{readonly:true, size:10}},
									   		{name:'brand',index:'brand', width:90, editable:true,editoptions:{size:20}},
									   		{name:'color',index:'color', width:100,editable:true,editoptions:{size:20}}
									   	],
										rowNum:10,
									   	rowList:[10,20,30],
									   	pager : '#pager4',
										caption : "Display All Cars",
										editurl : "http://" + location.host + "/SPA-portlet/api/secure/jsonws/car/get-all-cars"
									});
							//jQuery("#list4").jqGrid('navGrid','#pager4',{edit:false,add:false,del:false}); 
							for ( var i = 0; i <= mydata.length; i++)
								jQuery("#list4").jqGrid('addRowData', i+1,mydata[i]);
						});
		
	}
	
</script>
<table id="list4"></table>

<br>
<input type="BUTTON" id="bedata" value="Add New Car" />
<input type="BUTTON" id="dedata" value="Delete Selected Car" />
<input type="BUTTON" id="eddata" value="Edit Selected Car" />
