<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Public Chat</title>
<script type="text/javascript" src="/js/jquery.js"></script>
<script src='/_ah/channel/jsapi'></script>
 
 
 
</head>
<body>
<script type="text/javascript">
var chat_token = "${token}";
var channel = new goog.appengine.Channel(chat_token);
var socket = channel.open();
socket.onopen = function(){
	//alert("opend");
};
socket.onmessage = function(m){
	//alert(JSON.stringify(m));
	//alert(m['data']);
	var data = $.parseJSON(m.data);
	jQuery("#textarea").append("\n" + data['sender'] + " : " + data['msg']);
    
    //alert(data['msg'] + " " + data['sender']);
    // $('#center').append(data['html']);
    //$('#center').animate({scrollTop: $("#center").attr("scrollHeight")}, 500);
};
socket.onerror =  function(err){
    //alert("Error => "+err.description);
};
socket.onclose =  function(){
    //alert("channel closed");
    console.log("conecction closed");
    window.location.href = "/";
};

jQuery(document).ready(function(){
	
	jQuery("#center").html("Loggged in as ${name}");
	
	jQuery("#send").click(function(){
	   send();
	});
	
	jQuery("#logout").click(function(){
		socket.close();
	});
	
	jQuery('#text').keydown(function(event) {
		  if (event.keyCode == '13') {
		     //event.preventDefault();
		     send();
		   }
	});

});


function send(){
	 var text = jQuery("#text").val();
	 //var nick = $('#nick').attr('value');
	 //alert(text);
	 var channel_id = "${token}";
	 $.ajax({
	     url: '/msg1',
	     type: 'POST',
	     data:{
	         msg:text,
	         //nick:nick,
	         channel_id:channel_id,
	         sender:"${name}",
	     },
	     success: function(data){
	 	  	var data1 = $.parseJSON(data);
	     	//alert(data1);
	        //$('#center').append(data);
	        //$('#center').animate({scrollTop: $("#center").attr("scrollHeight")}, 500);
	     },complete:function(){
	 	   }
	    });
	 $('#text').val("");
}
</script>
 

<div id="center"></div>
<textarea rows="10" cols="25" id="textarea"></textarea><br>
<input type="text" id="text">
<input type="button" id="send" value="send">&nbsp;
<input type="button" id="logout" value="logout">
</body>
</html>