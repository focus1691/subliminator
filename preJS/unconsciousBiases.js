"use strict";
var gunshotSound = new Audio('audio/gunshot.mp3');

var sprite = function(filename) {
	this.image = null;
	if (filename != undefined && filename != "" && filename != null) {
		this.image = new Image();
		this.src = filename;
	}
}

$(document).ready(function() {

var canvas = document.getElementById("canvas"),
    context = canvas.getContext("2d");

canvas.width = 934;
canvas.height = 622;


var background = new Image();
background.src = "animation/map.jpg";

background.onload = function(){
    context.drawImage(background,0,0);   
}
});