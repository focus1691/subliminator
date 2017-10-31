<?php
$pageTitle = "PsychoTechnology | Contact Us";
$pageDescription = "Contact Us if you need help with any of our online psychology apps";
	require_once 'php-includes/header.php';
?>
<div class="container-fluid">
	<div class="row">
		<div id="world_map">
			<img src="images/world_map.png" alt="Location">
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div>
				<h1>Contact Us For Help</h1>
				<p>If you need help with anything on our site then please send us a message below</p>
			</div>
		</div>
	</div>

	<div id="contactForm">
		<form>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					Subject *
					<br>
					<input type="text" name="Subject" placeholder="Enter your subject">
				</div>

				<div class="col-md-6 ">
					Issue
					<br>
					<input type="text" name="Issue" placeholder="Enter your issue">
				</div>
			</div>
			<br>
			<div class="col-md-6 ttt">
				Enter your name *
				<br>
				<input type="text" name="name" placeholder="Enter your full name">
			</div>
			<div class="col-md-6 rrr">
				Your Email *
				<br>
				<input type="text" name="name" placeholder="Enter your email address">
				<br>
			</div>
			<br>
			<div class="col-sm-9 col-md-6 col-lg-8">
				<input style="height: 200px;" type="text" name="name">Message
			</div>
			<input type="submit" name="submitBtn">
		</form>
	</div>
</div><!--row end-->
	
	
<?php
	require_once 'php-includes/footer.php';
?>