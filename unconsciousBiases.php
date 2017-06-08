<?php
	require_once 'php-includes/header.php';
	include('php-includes/phpValidate.php');
?>

<script type="text/javascript" src="prejs/unconsciousBiases.js"></script>

<style>

#man {
	background:url(animation/1.png);
	width: 545px;
	height: 999px;
	position: relative;
	border: solid 1px black;
	-webkit-animation: playv 6s steps(2) infinite, playh 3s steps(3) infinite;  
}

@-webkit-keyframes playv {
     0% { background-position-y:   0px; }
   100% { background-position-y: -1997px; }
}

@-webkit-keyframes playh {
     0% { background-position-x:   0px; }
   100% { background-position-x: -1635px; }
}

</style>

<div id="man"></div>

<canvas id="canvas" width="640" height="480"
	style="border:1px solid gray; width: 640px; height: 480px;"
></canvas>


<?php
	require_once 'php-includes/footer.php';
?>