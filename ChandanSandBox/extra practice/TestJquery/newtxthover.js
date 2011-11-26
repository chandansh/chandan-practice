(function(j) {
	j.fn.txtHover = function(newtxt) {
		var _this = this;
		alert ("This :"+this);
		//alert('This: ' + this.length);
		return this.each(function() {
			alert('Are same? ' + (_this == this)+ "this refer to :"+this);
			var __this = this;
			if (!newtxt) {
				newtxt = "Mouse Hover";
			}

			var oldTxt = $(this).text();

			$(this).hover(function() {
				//_this
				//__this
				$(this).text(newtxt);
			}, function() {
				$(this).text(oldTxt);
			});// end of hover function
		});// end of this.each

	};// end of txtHover function
})(jQuery);// end of main function

