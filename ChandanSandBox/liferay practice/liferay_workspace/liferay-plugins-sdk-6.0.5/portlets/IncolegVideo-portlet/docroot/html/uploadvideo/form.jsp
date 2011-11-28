<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />

<portlet:actionURL var="submitAction"></portlet:actionURL>

<portlet:resourceURL var="uploadURL"></portlet:resourceURL>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>InColeg Pvt. Ltd.</title>


<link rel="stylesheet" media="screen" type="text/css"
	href=<%=renderRequest.getContextPath()
					+ "/css/custom-theme/jquery-ui-1.8.1.custom.css"%> />

<script type="text/javascript"
	src=<%=renderRequest.getContextPath()
					+ "/js/jquery-1.4.2.min.js"%>></script>
<script type="text/javascript"
	src=<%=renderRequest.getContextPath()
					+ "/js/jquery-ui-1.8.1.custom.min.js"%>></script>


<script type="text/javascript"
	src=<%=renderRequest.getContextPath()
					+ "/js/swfupload/Flash/swfupload.js"%>></script>
<script type="text/javascript"
	src=<%=renderRequest.getContextPath()
					+ "/js/swfupload/plugins/swfupload.queue.js"%>></script>
<script type="text/javascript"
	src=<%=renderRequest.getContextPath()
					+ "/js/swfupload/handlers.js"%>></script>
<script type="text/javascript"
	src=<%=renderRequest.getContextPath()
					+ "/js/swfupload/fileprogress.js"%>></script>



<script type="text/javascript">
    
    //If don't have firebug (can remove, just so using Firebug's console.log() doesnt give error in IE)
    if(typeof(console) === "undefined" || typeof(console.log) === "undefined")
	  var console = { log: function() { } };
    

    function destroy_all_swfupload(){ //not needed, dont need to destroy if using positioning and couldnt get destroy to work anyway. 
      var movie = swfu.getMovieElement();      
      var placeHolder = document.createElement("span");
      placeHolder.id = "dialog_file_upload_btn";
      movie.parentNode.replaceChild(placeHolder, movie);
      //swfu.destroy();
     	 
    }
    
    function closeDialog(){
      $('.ui-dialog').css('top', -5000);
      $('.ui-widget-overlay').css('display','none');
    }
          
    var swfu;
    var dialog;
    var orig_top_css;
    
    $(document).ready (function()
    {
        
       
        dialog = $('popup').dialog({ // add #popup for pop up window 
          width: 500,
          closeOnEscape: false,
          modal: true,
          title: 'Upload File(s) related to Row'
        }).bind('dialogbeforeclose', function(event, ui) { 
          closeDialog();
          swfu.setPostParams({});
          return false;
        });
          
        orig_top_css = $('.ui-dialog').css('top'); //get after dialog created, possibly see if oncomplete function

        //set once
        var settings =
        {
          flash_url: '<%=renderRequest.getContextPath()+ "/js/swfupload/Flash/swfupload.swf?"%>'+Math.random(), //not sure if needed, left in just in case (prevent_swf_caching also turned on)
          flash9_url : '<%=renderRequest.getContextPath()+ "/js/swfupload/Flash/swfupload_fp9.swf?"%>'+Math.random(),
							upload_url : '<%=uploadURL%>',
							button_placeholder_id : 'dialog_file_upload_btn',
							button_width : 160,
							button_height : 20,
							button_text : "<span class='theFont'>Click Here to Upload Videos</span>",
							button_text_style : '.theFont {text-decoration: underline; color: #336699; font-size: 13; font-family: Arial,Helvetica,Tahoma,Geneva,sans-serif }',
							file_post_name : 'file',
							button_cursor : SWFUpload.CURSOR.HAND,
							button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
							file_queue_limit : 0,
							file_upload_limit : 100,
							file_size_limit : "25 MB",
							file_types : "*.*",
							file_types_description : "All Files",

							custom_settings : {
								progressTarget : "fsUploadProgress",
								cancelButtonId : "btnCancel"
							},

							/*
							file_dialog_complete_handler: function() { swfu.startUpload (); },          
							upload_start_handler: function() { console.log ('start'); },            
							upload_error_handler: function() { console.log ('error'); },
							upload_success_handler: function() { console.log ('success'); alert('You have successfully uploaded the file(s).'); },
							upload_complete_handler: function() { console.log ('complete'); dialog.dialog('close'); },
							upload_progress_handler: function(file, complete, total) { console.log ('progress' + file + " " + complete + " " + total); }
							 */

							// The event handler functions are defined in handlers.js
							file_queued_handler : fileQueued,
							file_queue_error_handler : fileQueueError,
							file_dialog_complete_handler : fileDialogComplete,
							upload_start_handler : uploadStart,
							upload_progress_handler : uploadProgress,
							upload_error_handler : uploadError,
							upload_success_handler : uploadSuccess,
							upload_complete_handler : uploadComplete,
							queue_complete_handler : queueComplete, // Queue plugin event

							prevent_swf_caching : true

						// ,post_params: {row_id_key: 'default'}
						// ,debug : true,
						};

						swfu = new SWFUpload(settings);

						$('.upload_file').click(
								function() {
									orig_top_css_wopx = parseInt(orig_top_css
											.replace('px', ''), 10);

									$('.ui-dialog').css('top',
											orig_top_css_wopx);
									$('.ui-widget-overlay').css('display',
											'block');

									var row_id = $(this).attr('id').replace(
											'attach_', '');
									row_id = parseInt(row_id, 10);

									//alert(row_id);

									if (row_id && row_id > 0) {
										swfu.setPostParams({
											row_id_key : row_id
										}); //this should dynamically set the post param
									} else {
										alert('Error getting id');
									}

									// prevent the default action, e.g., following a link
									return false;
								});

						$('.ui-dialog').css('top', -5000);
					});
</script>

<link rel="stylesheet" media="screen,projection" type="text/css"
	href=<%=renderRequest.getContextPath()
					+ "/css/overlay_custom.css"%> />

</head>

<body id="ptpayment">
	<aui:form action="<%=submitAction%>" method="post">
		<div id="popup">
			<!--  Please upload the files:-->
			<div class="fieldset flash" id="fsUploadProgress">
				<!--  <span class="legend">Upload Queue</span> -->
			</div>
			<span id="dialog_file_upload_btn"></span>
			<div id="divStatus">0 Files Uploaded</div>
		</div>


		<div id="page">
			<!--  <span id="row1"> <a id="attach_1" href="#" class="upload_file">Attach
				File(s)</a> </span>-->
			<br></br>
			<aui:input type="textarea" label="Add Text" title="File description"
				name="fDesc"></aui:input>
			<br></br>
			<aui:button value="Upload" type="submit" tabindex="0" />
			&nbsp;&nbsp;&nbsp;&nbsp; <input id="btnCancel" type="button"
				value="Cancel" onclick="swfu.cancelQueue();" disabled="disabled"
				style="margin-left: 2px; font-size: 8pt; height: 29px;" tabindex="1" />
			&nbsp;&nbsp;&nbsp;&nbsp;
			<aui:button value="Reset" type="reset" tabindex="2" />
		</div>

	</aui:form>

</body>
</html>


