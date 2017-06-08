</div><!--Header Row-->
</div><!--Header COntainer-Fluid-->
</body>

<div class="container-fluid">
    <div class="row">
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <!--Footer Main Menu-->
                    <nav class="footerMenu">
                        <ul>
                            <li><a href="register">Login / Signup</a></li>
                            <li><a href="./">Home</a></li>
                            <li><a href="about">About</a></li>
                            <li><a href="mind-booster">Mind Booster</a></li>
                            <li><a href="attentional-network-task">Attentional Network Task</a></li>
                        </ul>
                    </nav>

                    <div class="footerIcon">
						<a href="https://twitter.com/PsyTechnology"><img class="footerIcon" src="images/footer_twitter_icon.png" alt="Twitter"></a>
                        <a href="https://www.facebook.com/psyctechnology/"><img class="footerIcon" src="images/footer_fb_icon.png" alt="Facebook"></a>
                    </div>
                </div>
                <hr style="width: 100%; opacity: .2;">
                <!--Footer Right Part-->
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xm-12">
                        <p class="">&COPY; <?php echo date('Y'); ?> PsychologyTechnology Ltd.</p>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <nav style="float: right;" class="footerMenu2 ">
                            <ul>
                                <li><a href="privacy">Privacy Policy</a></li>
                                <li><a href="terms">Terms of Use</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </nav>
                    </div>

                </div>
            </div>
        </footer>
    </div><!--Footer Row-->
</div><!--Footer Container-->

<script type="text/javascript">
$.when(
    $.getScript( "js/bootstrap.min.js" ), <!--Bootstrap Js-->
    $.getScript( "js/custom-min.js" ), <!--custom js-->
	$.getScript( "js/slider-min.js" ), <!--slider-->
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function(){
    //console.log("Finished loading JavaScript");
});
</script>

</body>
</html>
