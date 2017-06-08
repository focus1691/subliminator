<?php
if (isset($_GET['file'])) {
    $file = $_GET['file'];
  }
?>

<html>
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
		
        <!--favicon-->
        <link type="image/png" rel="icon" href="favicons/favicon-32x32.png">

		<link rel="stylesheet" type="text/css" href='./css/normalize.css'/>
		<link rel="stylesheet" type="text/css" href='./css/bootstrap.min.css'/>
		<link rel="stylesheet" type="text/css" href='./css/subscribe.css'/>
		<link rel="stylesheet" type="text/css" href='./css/custom-subs.css'/>
		<link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet"/>
		<!-- 27-7-07 -->
		 <link rel="stylesheet" type="text/css" href='./css/font-awesome.min.css'/>
		<!--  -->
	</head>

	<meta property="og:url"           content="http://psychotechnology.com/" />
	<meta property="og:type"          content="website" />
	<meta property="og:title"         content="PsychoTechnology" />
	<meta property="og:description"   content="Your way to better life" />
	<meta property="og:image"         content="http://psychotechnology.com/images/psychoLogo.png" />
	</head>
	<body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script><!-- // JQuery-->
		<script src="js/jqueryajaxchimp-min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
		   <div class="modal-dialog">
		   
		     <!-- Modal content-->
		     	<div class="modal-content" id="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Keep Updated With Our <br/><span>Powerful Mind Technologies</span></h4>
					</div>
					<div class="blue-line"></div>
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col-xs-12"><p><b>Signup Now for Our Free Re-release Of Mind Booster On Android</b></p></div>
							</div>

							<div id="popup-listing">
								<div class="row">
									<div class="col-xs-4">
										<ul id="poplist1">
											<li><b>Think More Positively</b></li>
											<li><b>Improve Confidence</b></li>
											<li><b>Improve Memory</b></li>
										</ul>
									</div>
									<div class="col-xs-4">
										<ul id="poplist2">
											<li><b>Exercise More</b></li>
											<li> <b>Stop Bad Habits</b></li>
											<li><b>Be Productive</b></li>
										</ul>
									</div>
									<div class="col-xs-4">
										<ul id="poplist2">
											<li><b>Attract Friends</b></li>
											<li><b>Be Assertive</b></li>
											<li><b>Take Control</b></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="clear"></div>
							<div id="btn-list">
								<div class="row">
									<div class="col-xs-6">
										<button id="test" type="button" class="btn btn-success "><h1>Yes</h1><p>Unlock my Mind's Potential</p></button>
									</div>
									<div class="col-xs-6">
										<button id="test2" type="button" class="btn btn-info " data-dismiss="modal"><h1>No</h1><p>My Mind is Powerful Enough</p></button>
									</div>
								</div>
							</div>
						</div>
					</div>
		     	</div>
		   </div>
		</div>

		<nav class='navbar navbar-inverse navbar-static-top'>
			<div class='container'>
			<ul class='nav navbar-nav'>
			<li class='nav-item'>
				<a class='nav-link' href='./'>PsychoTechnology</a>
			</li>
			<div id="fb-root"></div>
			<script>(function(d, s, id) {
				  var js, fjs = d.getElementsByTagName(s)[0];
				  if (d.getElementById(id)) return;
				  js = d.createElement(s); js.id = id;
				  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.7&appId=YOURAPPID";
				  fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
			</script>

			 <div id="social" class="row">
				<div class="col-md-2">
					<div class="fb-share-button" data-href="https://psychotechnology.com" data-layout="button" data-size="large" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fpsychotechnology.com%2F&amp;src=sdkpreparse">Share</a></div>
				</div>
				<div class="col-md-4">
					<div class="fb-like" data-href="http://psychotechnology.com/" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="false"></div>
				</div>
			</div>
		</nav>
		<div class="container">
			<div class="row holder">
				<h1><img src="images/ready.png"/> Your download is ready!</h1>
				<hr/>
				<div class="row">
					<div class="col-md-5">
						<img src="images/brainCommunication.jpg"/><br/>
						<hr/>
							<h2>Keep in Touch</h2>
							<h3><span class="green">&#10152;</span>&nbsp;Mind Booster Updates.<br/></h3>
							<h3><span class="green">&#10152;</span>&nbsp;Latest Psychology Apps.<br/></h3>
							<h3><span class="green">&#10152;</span>&nbsp;Self-development Advice.<br/></h3>
						</div>
					<div class="col-md-7">
						<h3>Thank you for choosing to download 
							<?php
							if (isset($_GET['file'])) {
								echo "<span class='green'>" . $file . "." . "</span>";
							  } else {
								echo "our app";
							  }
							?>
							 Subscribe to us for updates on Mind Booster and to find out about our latest apps.
						</h3>
						<!-- Begin MailChimp Signup Form -->
						<div id="mailchimp">
							<div id="mc_embed_signup">
								<form id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
									<div id="mc_embed_signup_scroll">
										<h1>Mind Booster Updates</h1>
										<div class="form-group">
											<label for="mce-EMAIL">
												<span class="asterisk"></span>
											</label>
											<input type="email" placeholder="Enter your email (Required)" name="EMAIL" class="required email form-control" id="mce-EMAIL" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" style= "vertical-align:9px;color:#000000"/>
										</div>
										<div class="form-group">
											<label for="mce-FNAME"></label>
											<input type="text" placeholder="Enter Your Name" name="FNAME" class="form-control" id="mce-FNAME" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"  style= "vertical-align:9px;color:#000000">
										</div>
										<div id="mce-responses" class="clear">
										<div class="response" id="mce-error-response" style="display:none"></div>
										<div class="response" id="mce-success-response" style="display:none"></div>
										</div>   <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
										<div class="clear"><input type="submit" value="Subscribe" name="subscribe" id="mc-embedded-subscribe" class="animated flash"></div>
									</div>
								</form>    
							</div>
						</div>
						<h3>Click Below to Download Mind Booster</h3>
						<a href="mind-booster.php?file=
						<?php
						if (isset($_GET['file'])) {
							echo $file;
						}
						?>
						"><img src="images/download.png"></a>
					</div>
					<script type="text/javascript">
						$('#mc-embedded-subscribe-form').ajaxChimp({
							url: '//psychotechnology.us12.list-manage.com/subscribe/post?u=517995713f5f7e7b705d6c99b&amp;&id=53bd89ba37'
						});
					</script>
						<hr/>
				</div>
				<hr/>
				<div class="row">
					<div class="col-md-6"><h3>Downloads & Apps</h3>
						<ul>
							<li><a href="./mind-booster">Mind Booster</a></li>
							<li><a href="./attentional-network-task">Attentional Network Task</a></li>
						</ul>
					</div>
					<div class="col-md-6"><h3>About Us</h3>
						We are a technology startup company that creates technology for the mind, serving people and businesses.
					</div>
				</div>
				<hr/>
				<div class="centered">
					<?php
						echo "&copy PsychoTechnology " . date('Y') . " | All rights reserved.<br/>";
					?>
				</div>
			</div>
		</div>

		<script>
			setTimeout(function() {
    			$('#myModal').modal({backdrop: 'static', keyboard: false});
			}, 3000);
            
             $("body").on("click","#mc-embedded-subscribe2",function(){

			     $('#mc-embedded-subscribe-form2').ajaxChimp({
			         url: '//psychotechnology.us12.list-manage.com/subscribe/post?u=517995713f5f7e7b705d6c99b&amp;&id=53bd89ba37'
			     });
		     });

			$('#test').click(function() {
			    $('.modal-content').html("<div class='modal-header' style='padding-bottom:0px'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Subscribe</h4></div><div class='modal-body' style='padding:0px'><div class='col-lg-8 col-md-8 col-sm-12 col-xm-12 subscribe_content '><form class='form-inline subForm' id='mc-embedded-subscribe-form2' name='mc-embedded-subscribe-form2' class='validate' target='_blank' novalidate><div id='mc_embed_signup_scroll'><div class='form-group'><label for='mce-EMAIL' style=' margin-top: -24px;left:25px;'><span class='asterisk'></span></label><input type='email' placeholder='Enter your email (Required)' name='EMAIL' class='required email form-control' id='mce-EMAIL'  style= 'vertical-align:9px;color:#000000'></div><div class='form-group' <label for='mce-FNAME'></label><input type='text' placeholder='Enter Your Name' name='FNAME' class='form-control' id='mce-FNAME' onfocus='if (this.value == this.defaultValue) this.value = '';' onblur='if (this.value == '')this.value = this.defaultValue;'  style= 'vertical-align:9px;color:#000000'></div><div id='mce-responses' class='clear'> <div class='response' id='mce-error-response' style='display:none'></div><div class='response' id='mce-success-response' style='display:none'></div></div>   <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups--><div class='clear'><button type='submit' value='Subscribe' name='subscribe' id='mc-embedded-subscribe2' class='animated flash'>Subscribe</button></div> </div></form></div></div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal' id='close'>Close</button></div>");

   			    $('#modal-content').addClass('modal_size');
   			    $('#modal-content').css('background','#fff');
			});
        </script>
	</body>
</html>