<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Chat</title>
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
    
	var senderId = data['sender'];
	
    
    if(senderId!= "me" && senderId.length > 0 && jQuery("#"+senderId).length == 0){
    	//alert(jQuery("#"+senderId).length);
    	createChatBox(senderId);
    	jQuery("#"+senderId).find("textarea").append("\n" + data['sender'] + " : " + data['msg']);
    }else if(senderId.length > 0 && jQuery("#"+senderId).length != 0){
    	jQuery("#"+senderId).find("textarea").append("\n" + data['sender'] + " : " + data['msg']);
    }
    
    if(senderId == "me"){
    	var sendTo = data['sendTo'];
    	jQuery("#"+sendTo).find("textarea").append("\n" + data['sender'] + " : " + data['msg']);
    }
    	
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
	
	jQuery("#logout").click(function(){
		socket.close();
	});
	
});


function send(user, msg){
	 var text = msg;
	 //var nick = $('#nick').attr('value');
	 //alert(text);
	 var channel_id = "${token}";
	 $.ajax({
	     url: '/msg1',
	     type: 'POST',
	     data:{
	         msg:text,
	         //nick:nick,
	         //channel_id:channel_id,
	         sender:"${name}",
	         send_to:user,
	     },
	     success: function(data){
	 	  	var data1 = $.parseJSON(data);
	     	//alert(data1);
	        //$('#center').append(data);
	        //$('#center').animate({scrollTop: $("#center").attr("scrollHeight")}, 500);
	     },complete:function(){
	 	   }
	    });
}

function createChatBox(senderId){
	//alert("create chat box");
	var user = senderId;
	var chatbox = $('<div>').attr("id" , senderId);
	chatbox.html("chatbox for " + senderId + "<br>");
	var txtarea = $('<textarea>').attr("rows","10").attr("cols", "25");
	var txt = $('<input>').attr("type" , "text");
	
	var button = $('<input>').attr("type" , "button").attr("value", "send to " + senderId).click(function(){
	   send(user, txt.val());
	   txt.val("");
	});
	
	txt.keydown(function(event) {
	  	if (event.keyCode == '13') {
		     //event.preventDefault();
		     send(user, txt.val());
		     txt.val("");
		}
	});
	
	chatbox.append(txtarea);
	chatbox.append($('<br>'));
	chatbox.append(txt);
	chatbox.append(button);
	$("#chatboxes").append(chatbox);
}
</script>
 

<div id="center"></div>
<!-- <textarea rows="25" cols="25" id="textarea"></textarea><br> -->
<!-- <input type="text" id="text"> -->
<!-- <input type="button" id="send" value="send">&nbsp; -->
<input type="button" name="" id="logout" value="logout">
<div id="chatboxes"></div>
</body>
</html>