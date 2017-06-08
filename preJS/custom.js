//Make the body margin top the same as the navbar height

function bodyBottom () {

var footerHeight = $('.footer').height();
$('body').css('margin-bottom', footerHeight + 30 + 'px');

}


window.onresize=function() {
			
	bodyBottom ();
	
};

window.onload = function() {
 
bodyBottom();

};

