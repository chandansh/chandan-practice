jQuery.fn.txtHover = function() {
return this.each(function() {
var oldTxt = jQuery(this).text();
jQuery(this).hover(function() {
jQuery(this).text("Mouse hover");
}, function() {
jQuery(this).text(oldTxt);
});
});
};