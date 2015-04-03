(function($){
  $.fn.txtHover = function(newtxt) {
  
  return this.each(function() {
  	if(!newtxt)
  	{
  	newtxt="Mouse Hover";
  	}
  	var oldTxt=$(this).text();
  	$(this).hover(function(){
        $(this).text(newtxt);}
        ,function(){$(this).text(oldTxt);
        });//end of hover function
    });//end of this.each
    
  };//end of txtHover function
})//end of main function

( jQuery );