(function($) {
	
	function xyz() {
		
	}
	
	$.fn.txtClick = function(newtxt) {

		return this.each(function() {
			if (!newtxt) {
				newtxt = "Mouse Clicked..";
			}
			var oldTxt = $(this).text();
			$(this).click(function() {
				$(this).text(newtxt);
			});// end of click function
		});// end of this.each

	};// end of txtClick function
})(jQuery);// end of main function

(function($){
$.fn.bgcolor = function(color) {
	return this.each(function(i) {
		alert(i+"obj "+this);
		$(this).css("background-color", color);
	});
};
})(jQuery);

(function($){
	$.fn.bgcolor1 = function(options) {
		var settings={
				bcolor : 'yellow',
				fcolor : 'red',
				font : 'Arial'
		};
		
		return this.each(function(i) {
			if(options)
			{
			$(this).extend(settings,options);
			}
			alert(i+"obj "+this);
			$(this).css("background-color", settings.bcolor);
			$(this).css({"color": settings.fcolor, "font-family": settings.font});
		});
	};
	})(jQuery);
