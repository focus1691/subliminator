"use strict";var gunshotSound=new Audio("audio/gunshot.mp3"),sprite=function(n){this.image=null,void 0!=n&&""!=n&&null!=n&&(this.image=new Image,this.src=n)};$(document).ready(function(){var n=document.getElementById("canvas"),t=n.getContext("2d");n.width=934,n.height=622;var e=new Image;e.src="animation/map.jpg",e.onload=function(){t.drawImage(e,0,0)}});