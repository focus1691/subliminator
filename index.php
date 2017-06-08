<?php
$pageTitle = "PsychoTechnology | The Online Platform for Psychology Apps, Games and Tools";
$pageDescription = "The Online Platform to Download Psychology Apps and Play Psychology games. Learn More About your Mind Today!";
include './php-includes/header.php';
?>

<!--Banner-->
<div class="psychotechBanner">
	<img src="images/banner.jpg" alt="Psychology Apps">
</div>
<!--End of Banner-->

<!--Information-->
<div class="container">
	<div class="row">
		<div class="informationContainer" style="margin-top:20px;">
			<div class="col-lg-4 col-md-4 col-sm-12 col-xm-12" >
				<div class="siteInfo1">
					<img src="images/content_image1.png" alt="Subliminal Messages">
					<h4>Improve your mind</h4>
					<p>Mind Booster is our free subliminal messaging app that allows you to select from a list of positive messages to target your subconscious mind.
						Achieve your life's goals by using software that works directly with your subconscious mind.</p>
				</div>
			</div>

			<div class="col-lg-4 col-md-4 col-sm-12 col-xm-12" >
				<div class="siteInfo2">
					<img src="images/content_image2.png" alt="Psychology Research">
					<h4>Understand your mind</h4>
					<p>Our apps uses gamification and psychological research to teach you about yor mind.</p>
				</div>
			</div>

			<div class="col-lg-4 col-md-4 col-sm-12 col-xm-12" >
				<div class="siteInfo3">
					<img src="images/content_image3.png" alt="Psychology Game">
					<h4>Attentional task</h4>
					<p>Play our psychology game to learn more about your mind and about the cognitive processes that you are unaware of.
						It will measure your attention and show you how the mechanism works.</p>
				</div>
			</div>
		</div>
	<!--Row-->
	</div>
</div>
<!--Container-->

<!--Mind Booster-->
<div id="apps" class="clearfix">
	<!-- Red overlay for Mind Booster container -->
	<img class="redImage" src="images/red_background.png" alt="Red Border"/>
	<div class="content-wrapper clearfix">
		<div class="container">
			<div class="row">
				<!-- Content on the red overlay -->
				<div class="mindboosterContent">
					<p class="uppercase">Improve the mind</p>
					<h1>Mind Booster</h1>
					<p>Subliminal messages to change your <br> negative thinking patterns.</p>
					<button class="mindBoosterTryBtn">Try it now</button>
					<div class="appAvailability">
						<a>
							<img src="images/globe_icon.png" alt="Subliminal Software Online"/>
							<span>Available Online</span>
						</a>
						<a>
							<img src="images/windows_icon.png" alt="Subliminal Software Windows"/>
							<span>Available on Windows</span>
						</a>
						<a>
							<img src="images/apple_icon.png" alt="Subliminal Software Mac"/>
							<span>Available on Mac</span>
						</a>
						<a>
							<img src="images/android_icon.png" alt="Subliminal Software Android"/>
							<span>Available on Android</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="mindboosterVideo clearfix">
			<div>
				<!-- Mind Booster animation next to the red overlay -->
				<img src="images/mind-booster.gif" alt="Mind Booster">
			</div>
		</div>
	</div>
</div>
	<img class="redImage udp1" src="images/bottom-div.png" alt="image"/>
<!--Row-->

<!--Attentional Network Task-->
<div class="clearfix" id="vi-video">
	<img class="violetImage" src="images/violet_background.png" alt="Violet Border">
	<div class="content-wrapper clearfix">
		<div class="container">
			<div class="row">
				<div class="antContent">
					<p class="uppercase">Understanding the mind</p>
					<h1>Attentional <span> Network task</span></h1>
					<p>Attentional task to measure <span> your attention.</span></p>
					<button class="antTryBtn">Try it now</button>
					<div class="appAvailability">
						<a>
							<img src="images/globe_icon.png" alt="Attention Test"/>
							<span>Available Online</span>
						</a>
						<a>
							<img class="opacityElement" src="images/windows_icon.png" alt="Unavailable on Windows"/>
						</a>
						<a>
							<img class="opacityElement" src="images/apple_icon.png" alt="Unavailable on Mac"/>
						</a>
						<a>
							<img class="opacityElement" src="images/android_icon.png" alt="Unavailable on Android"/>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="antVideo clearfix">
			<img src="images/ant-task.gif" alt="Attentional Network Task">
		</div>
	</div>
</div>
<img class="violetImage udp1" src="images/bottom-div1.png" alt="image">

<!--Testimonials-->
<div class="container">
	<div class="row">
		<div id="testimonials">
			<p>Latest Testimonials</p>
			<h1>What users are saying</h1>
			<div class="underLine"></div>
			<h2>John S. - User</h2>
			<h3>I have been using the Mind Booster app for over 2 weeks now, and I am starting to see the effects now. I use it mainly to keep
			   a positive mind, which helps me to workout and get things done.</h3>
			<div class="star">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</div>
		</div>
	</div>
	<!--Row-->
</div>
<!--Container-->
<!--SLIDER END-->

<script>

jQuery(document).ready(function() {
    $('.mindBoosterTryBtn').on('click touchstart', function() {
		window.location.replace("mind-booster");
    });
	
    $('.antTryBtn').on('click touchstart', function() {
		window.location.replace("attentional-network-task");
    });
});

</script>

<?php
require_once 'php-includes/footer.php';
?>
