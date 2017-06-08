<?php
$pageTitle = "PsychoTechnology | Attentional Network Task | Cognitive Psychology";
$pageDescription = "Play our Cognitive Psychology Game Today! Learn About Attention and the Cognitive Processes that takes Place in your Mind";
require_once 'php-includes/header.php';
include ('php-includes/antHelper.php');
?>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- // JQuery -->

<div class="container">
    <div class="row">
        <section>
            <div class="container">
                <div class="row">
					<div class="col-xs-9 col-md-7">
						<div id="antGame">
							<div id="stimuliContainer">
								<div id="antDebrief"></div>
								<img id="stimuli" src="images/antImage.png"/>
							</div>
							<div id="errorMsg">
								<div id="errorTitle">
									<span>Error:</span>
									<span id="errorType"></span>
								</div>
								<div id="rewardTitle">
									<span>Correct:</span>
									<span id="rewardType"></span>
								</div>
								<button id="startAnt" type="button" name="startANT">Get Started<span>&rsaquo;</span></button>
								<button id="restartAnt" type="button" name="restartANT">Restart</button>
								<button id="submitAnt" type="button" name="submitANT">Submit</button>
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-md-5">
						<div id="antInstruct">
							<div id="antHeader">
								<span>Attentional Network Task</span>
							</div>
							<div id="antTabs">
								
								<ul class="tab">
									<li><a href="javascript:void(0)" id="antFeedbackInstruct">Instructions</a></li>
									<li><a href="javascript:void(0)" id="antFeedbackResults">Feedback</a></li>
								</ul>
							</div>
							<div id="antFeedback">
								<div id="mKey">
									<span>You have to press</span>
									<img src="images/ant/instructions/mKey.png">
									<span>when Freud in the center is pointing right</span>
								</div>
								<div id="zKey">
									<span>You have to press</span>
									<img src="images/ant/instructions/zKey.png">
									<span>when Freud in the center is pointing left</span>
								</div>
								<div id="bothKeys">
									<span>You have to press</span>
									<img src="images/ant/instructions/zKey.png">
									<span>when Freud in the center is pointing left</span>
									<span>and</span>
									<img src="images/ant/instructions/mKey.png">
									<span>when Freud in the center is pointing right</span>
								</div>
									<h1 id="cueTitle"></h1>
									<span class="instructText" id="cueMsg"></span>
							</div>
						</div>
					</div>

                    <input type="hidden" name="rspStr" value=""/>
                    <input type="hidden" name="RTStr" value=""/>
                    <input type="hidden" name="nTrial" value=""/>
                    <input type="hidden" name="toa" value=""/>
                    <input type="hidden" name="condition" value=""/>
                    <input type="hidden" name="ansStr" value=""/>
                    <input type="hidden" name="congruency" value=""/>
                    <input type="hidden" name="cueStr" value=""/>
                </div>
            </div>
        </section>
    </div>
</div>

<article id="antBlog">
	<br>
	<h1 style="text-align: center;">3 structures of attention</h1>
	<h2>Alerting</h2>
	<br>
	<p>Attention can only be directed to one target at a time. Right now, you are probably not thinking about the sensation in your toes, or what you ate today, but now these
		things have been brought to the forefront of your mind. That is how alerting works. Anything that grabs your attention is brought to the forefront of your mind.</p>
	<br>
	<p>Attention is limited to only one target at a time. We attend to many things subconsciously, but only one target can be focused on at a given moment in time. Attention has
		been compared to a spotlight that can switch between different targets.</p>
	<br>
	<h2>Orienting</h2>
	<br>
	<p>Orienting is the part of attention that occurs immediately after alerting. Right after something grabs our attention, we are drawn to the source of the arousal it
		generates.</p>
	<br>
	<p>Picture this: you are listening to your friend tell an interesting story about his childhood, while holding an icecream in your hand. At this moment, the icecream is
		unimportant to you, as you want to learn more about your friend. Then, unexpectedly, the icecream slips from under your grip and topples to the ground, leaving a
		great big mess. Your attention immediately switches from the story your friend is telling to the icecream being dropped. Right after your attention switches, you
		look down at the ground to see the mess you made. This stage is described as orienting, and it occurs right after alerting, where the attentional spotlight shifts. This
		stage is where we search for the source of what has captured our attention. In this case, it would be the icecream toppling to the floor.</p>
	<br>
	<h2>Executive</h2>
	<br>
	<p>Alerting and orienting are performed so often. It is like blinking: we do it so much that we don't think about it. The executive part of
		attention is quite different because it is much more active. Imagine you are searching through a deck of cards for the queen of hearts. You flicker through the
		cards rapidly, but you slow down whenever you find a red or a heart card. These cards capture your attention because they are similar to the target. This causes a conflict because
		they draw your attention towards it. These cards resemble the queen of heart's. This is your executive system at work. It involves consciously resolving conflict and
		employing strategies to do so.<p>
</article>

<script type="text/javascript">
$.when(
    $.getScript( "js/antTask-min.js" ), <!--ANT Js-->
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function(){
});
</script>

<?php
require_once 'php-includes/footer.php';
?>