<?php
ob_start();
$pageTitle = "PsychoTechnology | Subliminal Software to Access the Power of your Mind";
$pageDescription = "Subliminal software program to unlock your mind's potential. 100% free to download on Windows and Mac. Available now on Android.";
include_once('./MySQL/config.php');
include_once('./php-includes/header.php');
include_once('./php-includes/mindboosterHelper.php');
checkDownload();
?>

<script src="js/jqueryajaxchimp-min.js"></script>
<script src="js/bigSlide-min.js"></script> <!-- Slider -->

<!--Blinking Message Setting Bar-->
<span style="position:fixed;z-index:2000;">
    <a href="#menu" class="menu-link"><img src="images/settings.png" alt="settings" style="margin-top: -20px;"></a>
</span>

<nav id="menu" class="subliminalSidebar">
    <section id="subliminalContainer">
        <div class="row">
            <div class="col-md-12">
                <div id="settingsTitle">
                    <span id="settingsLabel"><i style="padding-right: 3px;" class="fa fa-cog" aria-hidden="true"></i>Settings</span>
                    <span id="settingsSwitcher"><a href="#menu" class="menu-link"><img src="images/back.png" alt="back"></a></span>
                </div>

                <div id="controls">
                    <span>Status :&emsp;</span>
                    <input type="radio" name="messageActivity" value="on" id="messagesOn" checked="checked">&nbsp;On&emsp;
                    <input type="radio" name="messageActivity" value="off" id="messagesOff">&nbsp;Off&emsp;
                    <br><br>
                    <span>Messages :</span>
                    <select id="messageList">
                        <option value="selfEnhancement" selected="selected">Self-enhancement</option>
                        <option value="intelligence">Intelligence</option>
                        <option value="positiveThinking">Positive Thinking</option>
                        <option value="creativity">Creativity</option>
                        <option value="leadership">Leadership</option>
                        <option value="memory">Memory</option>
                        <option value="selfEsteem">Self-esteem</option>
                        <option value="motivation">Motivation</option>
                        <option value="lawOfAttraction">Law of Attraction</option>
                        <option value="relationships">Relationships</option>
                        <option value="quitSmoking">Quit Smoking</option>
                        <option value="quitDrinking">Quit Drinking</option>
                        <option value="quitPorn">Quit Watching Porn</option>
                        <option value="exercise">Exercise</option>
                        <option value="confidence">Confidence</option>
                        <option value="millionaireMindset">Millionaire Mindset</option>
                    </select>
                    <br><br><br>

                    <div id="colorMenu" class="colorMenu">
                        <span>Color :</span>
                        <select>
                            <option id="colorBlack" value="black" selected="selected">Black</option>
                            <option id="colorRed" value="red">Red</option>
                            <option id="colorBlue" value="blue">Blue</option>
                            <option id="colorGreen" value="green">Green</option>
                            <option id="colorPurple" value="purple">Purple</option>
                            <option id="colorOrange" value="orange">Orange</option>
                            <option id="colorYellow" value="yellow">Yellow</option>
                            <option id="colorBrown" value="brown">Brown</option>
                        </select>
                    </div>

                    <div id="sizeMenu">
                        <span>Size :</span>
                        <select>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="14">14</option>
                            <option value="16">16</option>
                            <option value="18" selected="selected">18</option>
                            <option value="20">20</option>
                            <option value="22">22</option>
                            <option value="24">24</option>
                        </select>
                    </div>

                    <br/>
                    <label for="displayEvery">Display Every:</label>
                    <div class="scrollSelector">
                        <input type="range" min="1000" max="5000" value="1000" id="displayEvery" step="1000" oninput="outputUpdate(value)">
                        <output for="displayEvery" id="volume">1000 ms</output>
                    </div>
                    <br/><br/>
                    <label for="duration">Duration:</label>
                    <div class="scrollSelector">
                        <input type="range" min="1" max="501" value="50" id="duration" step="10" oninput="outputUpdate2(value)"/>
                        <output for="duration" id="volume2">50 ms</output>
                    </div>
                </div>
            </div><!--col end-->
        </div><!--row end-->
    </section>
</nav>


<!--Video-->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mbMainContent">
            <h1>Mind Booster</h1>
			<h5>Subliminal Software: Unlock your potential</h5>
            <div id="mbPromoVideo">
                <div class="embed-responsive embed-responsive-16by9">
					<video autoplay>
						<source src="videos/mindbooster2.mp4" type="video/mp4"/>
						<source src="videos/mindbooster2.ogv" type="video/ogg; codecs=theora, vorbis"/>
					</video>
                </div>
            </div>
            <div id="socialButtons"><!--Social Buttons-->
				<a class="post-share facebook" href="https://www.facebook.com/sharer/sharer.php?u=http%3A//www.psychotechnology.com/mindbooster" onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=100,width=200');return false;"><span></span></a>
				<a class="post-share twitter" href="https://twitter.com/home?status=http%3A//www.psychotechnology.com/mindbooster" onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><span></span></a>
				<a class="post-share gplus" href="https://plus.google.com/share?url=http%3A//www.psychotechnology.com/mindbooster" onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><span></span></a>
				<a class="post-share stumble" href="http://www.stumbleupon.com/submit?url=http%3A%2F%2Fwww.psychotechnology.com%2Fmindbooster" onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=800');return false;"><span></span></a>
            </div>
        </div>
    </div>
</div>

<!--Download-->
<div class="container-fluid">
    <div class="row">
        <div id="downloadContainer">
            <div class="mbDownloadBtns">
                <!--Mac Store Button-->
                <button class="macDownloadBtn Btn btn btn-app-store" onClick="location.href = 'download.php?file=MindBooster.dmg';">
                    <i class="fa fa-apple"></i> 
                    <span class="small">Download on</span>
                    <span class="big">MAC</span>
                </button>
                <!--Windows Store Button-->
                <button class="winDownloadBtn Btn btn btn-app-store" onClick="location.href = 'download.php?file=MindBooster.exe';">
                    <i class="fa fa-windows"></i>
                    <span class="small">Download on</span>
                    <span class="big">Windows</span>
                </button>
				<p><?php getDownloadCount(); ?></p>
            </div>
        </div>
    </div>
</div>

<!--Subscription Section-->
<div class="mindbooster container">
    <div class="row subscribePart">
        <div id="mc_embed_signup">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xm-12">
                <h2>Find out about our latest apps<span class="glyphicon glyphicon-chevron-right"></span></h2>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xm-12">
                <form class="form-inline subForm" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
                    <div id="mc_embed_signup_scroll">
                        <div class="form-group">
                            <label for="mce-EMAIL" style="position: absolute; margin-top: -24px;">
                                <span class="asterisk"></span>
                            </label>
                            <input type="email" placeholder="Enter your email (Required)" name="EMAIL" class="required email form-control" id="mce-EMAIL" onfocus="if (this.value == this.defaultValue)
                                        this.value = '';" onblur="if (this.value == '')
                                                    this.value = this.defaultValue;" style= "vertical-align:9px"/>
                        </div>
                        <div class="form-group">
                            <label for="mce-FNAME"></label>
                            <input type="text" placeholder="Enter Your Name" name="FNAME" class="form-control" id="mce-FNAME" onfocus="if (this.value == this.defaultValue)
                                        this.value = '';" onblur="if (this.value == '')
                                                    this.value = this.defaultValue;"  style= "vertical-align:9px"/>
                        </div>
                        <div id="mce-responses" class="clear">
                            <div class="response" id="mce-error-response" style="display:none;"></div>
                            <div class="response" id="mce-success-response" style="display:none;"></div>
                        </div>   <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
                        <div class="clear">
                            <button type="submit" value="Subscribe" name="subscribe" id="mc-embedded-subscribe" class="animated flash">Subscribe</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $('#mc-embedded-subscribe-form').ajaxChimp({
         url: '//psychotechnology.us12.list-manage.com/subscribe/post?u=517995713f5f7e7b705d6c99b&amp;&id=53bd89ba37'
    });
</script>


<!--Slider & Ad Parts-->
<div class="container">
	<div class="row slider3">
		<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<div class="phone">
					<img src="images/phone_image_border.png" alt="Phone Border">
				</div>
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<!--Slider Item-->

					<div class="item active">
						<div class="innerImage">
							<img width="198" height="351" src="images/androidss1.jpg" alt="Main Screen">
						</div>
					</div>

					<!--Slider Item-->
					<div class="item">
						<div class="innerImage">
							<img width="198" height="351" src="images/androidss2.jpg" alt="Settings">
						</div>
					</div>

					<!--Slider Item-->
					<div class="item">
						<div class="innerImage">
							<img width="198" height="351" src="images/androidss3.jpg" alt="Add Category">
						</div>
					</div>
					<!--Slider Item-->
					<div class="item">
						<div class="innerImage">
							<img width="198" height="351" src="images/androidss4.jpg" alt="Select Messages">
						</div>
					</div>
					<!--Slider Item-->
					<div class="item">
						<div class="innerImage">
							<img width="198" height="351" src="images/androidss5.jpg" alt="Subliminal Message">
						</div>
					</div>


					<div>
						<a href="https://play.google.com/store/apps/details?id=com.project.subliminalmessages" target="_blank"><img class="googlePlaybtn" src="images/play.png" alt="Play Store"></a>
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left leftControl carousel-control" href="#myCarousel" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only"></span>
				</a>
				<a class="right rightControl carousel-control" href="#myCarousel" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only"></span>
				</a>
			</div>
		</div>
		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
			<div class="row">
				<div class="adPart col-md-12">
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- Mind Booster -->
					<ins class="adsbygoogle"
						 style="display:block"
						 data-ad-client="ca-pub-1038793067071777"
						 data-ad-slot="7561512646"
						 data-ad-format="auto"></ins>
					<script>
					(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
				</div>
				<div class="adPart col-md-12">
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- Mind Booster 2 -->
					<ins class="adsbygoogle"
						 style="display:block"
						 data-ad-client="ca-pub-1038793067071777"
						 data-ad-slot="6863508643"
						 data-ad-format="auto"></ins>
					<script>
					(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
				</div>
			</div>
		</div>
	</div><!--Row-->
</div><!--Container-->

<canvas id="subliminalMessage" width="650" height="200"></canvas>
<script src="js/messages-min.js"></script> <!-- Subliminal Messages -->

<?php
include 'php-includes/footer.php';
?>

<link rel="stylesheet" type="text/css" href='./css/subscribe.css'/> 

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
								<ul id="poplist">
									<li><b>Think More Positively</b></li>
									<li><b>Improve Confidence</b></li>
									<li><b>Improve Memory</b></li>
								</ul>
							</div>
							<div class="col-xs-4">
								<ul id="poplist">
									<li><b>Exercise More</b></li>
									<li> <b>Stop Bad Habits</b></li>
									<li><b>Be Productive</b></li>
								</ul>
							</div>
							<div class="col-xs-4">
								<ul id="poplist">
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

<script>

$('#mbPromoVideo video').click(function(){
	this.paused ? this.play() : this.pause();
});


$("#mbPromoVideo").on('ended', function(e) {
    console.log('stopped');
    $('#myModal').modal({backdrop: 'static', keyboard: false});
     
});

$("body").on("click","#mc-embedded-subscribe1",function(){

     $('#mc-embedded-subscribe-form1').ajaxChimp({
         url: '//psychotechnology.us12.list-manage.com/subscribe/post?u=517995713f5f7e7b705d6c99b&amp;&id=53bd89ba37'
     });
    
    
});

$('#test').click(function() { 
                $('.modal-content').html("<div class='modal-header' style='padding-bottom:0px;'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Subscribe</h4></div><div class='modal-body' style='padding:0px;'><div class='col-lg-8 col-md-8 col-sm-12 col-xm-12 subscribe_content '><form class='form-inline subForm' id='mc-embedded-subscribe-form1' name='mc-embedded-subscribe-form1' class='validate' target='_blank' novalidate><div id='mc_embed_signup_scroll'><div class='form-group'><label for='mce-EMAIL' margin-top: -24px;left:25px;'><span class='asterisk'></span></label><input type='email' placeholder='Enter your email (Required)' name='EMAIL' class='required email form-control' id='mce-EMAIL'  style= 'vertical-align:9px;color:#000000'></div><div class='form-group' <label for='mce-FNAME'></label><input type='text' placeholder='Enter Your Name' name='FNAME' class='form-control' id='mce-FNAME' onfocus='if (this.value == this.defaultValue) this.value = '';' onblur='if (this.value == '')this.value = this.defaultValue;'  style= 'vertical-align:9px;color:#000000'></div><div id='mce-responses' class='clear'> <div class='response' id='mce-error-response' style='display:none'></div><div class='response' id='mce-success-response' style='display:none'></div></div>   <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups--><div class='clear'><button type='submit' value='Subscribe' name='subscribe' id='mc-embedded-subscribe1' class='animated flash'>Subscribe</button></div> </div></form></div></div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal' id='close'>Closee</button></div>");
                $('#modal-content').addClass('modal_size');
                $('#modal-content').css('background','#fff');
            });

</script>
