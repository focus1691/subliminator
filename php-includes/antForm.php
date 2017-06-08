<?php
	include ('antHelper.php');
	include ('phpValidate.php');
	$testData = removeDelimiters($_POST['RT'], $_POST['condition'], $_POST['response'], $_POST['ansStr'], $_POST['congruency'], $_POST['cueStr']);
	$testID = addTest($_POST['toa'], $_POST['nTrial']);

	if (isset($testID))	{
		for ($i = 0; $i < count($testData["RT"]); $i++) {
			addResponse((int)$testData["RT"][$i], (int)$testData["condition"][$i], $testData["response"][$i], $testData["answer"][$i], $testData["cue"][$i], $testData["congruence"][$i], $testID);
		}
		$results = getCueScores($testID);
		$results = getCongruencyScores($testID, $results);
		$alerting = $results["noCue"] - $results["doubleCue"];
		$orienting = $results["centerCue"] - $results["spatialCue"];
		$executive = $results["incongruent"] - $results["congruent"];

		/* Print alerting result */
		if ($alerting > 0) { /* Alerting effect found */
			echo "<div style='font-size: 15px;'>";
			echo "<h1 style='text-decoration: underline; color: green;'>Alerting Effect&nbsp;</h1>";
			echo " You gave the correct answer&nbsp;" . $alerting . "ms faster with a double cue&nbsp;";
			echo "<img style='height: 90px; width: 15px;' src='images/ant/instructions/debrief2.png' alt='Double Cue'/>";
			echo "&nbsp;than with no cue&nbsp;";
			echo "<img style='height: 20px;' src='images/ant/instructions/debrief1.png' alt='*'/>";
			echo "The double cue brought the target's presence into your attentional spotlight early on, making you react quicker, because you were anticipating it appearing.";
			echo "<hr style='height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'>";
		} else { /* No alerting effect found */
			echo "<div style='font-size: 15px;'>";
			echo "<h1 style='text-decoration: underline; color: red;'>Alerting Effect&nbsp;</h1>";
			echo "&nbsp;You did not show the alerting effect. Normally, people give the correct answer faster with the double cue&nbsp;";
			echo "<img style='height: 90px; width: 15px;' src='images/ant/instructions/debrief2.png' alt='Double Cue'/>";
			echo "&nbsp;than with no cue&nbsp;"; 
			echo "<img style='height: 20px;' src='images/ant/instructions/debrief1.png' alt='*'/>";
			echo "&nbsp;because the double cue gives brings the target's presence into the attentional spotlight early on.";
			echo "<hr style='height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'>";
		}
		
		/* Print orienting result */
		if ($orienting > 0) { /* Orienting effect found */
			echo "<h1 style='text-decoration: underline; color: green;'>Orienting Effect</h1>";
			echo " You gave the correct answer&nbsp;" . $orienting . "ms faster with a bottom cue&nbsp;";
			echo "<img style='height: 90px; width: 15px;' src='images/ant/instructions/debrief5.png' alt='Bottom Cue'/>";
			echo "&nbsp;and top cue&nbsp;";
			echo "<img style='height: *0px; width: 20px;' src='images/ant/instructions/debrief4.png' alt='Top Cue'/>";
			echo "&nbsp;than with the mid cue&nbsp;";
			echo "<img style='height: 20px;' src='images/ant/instructions/debrief3.png' alt='Mid Cue'/>";
			echo "The top and bottom cue predicted where the target would land, and this accelerated the process of orienting to the target, because it drew your attention to it.";
			echo "<hr style='height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'>";
		} else { /* No orienting effect found */
			echo "<h1 style='text-decoration: underline; color: red;'>Orienting Effect&nbsp;</h1>";
			echo " You did not show the orienting effect, as you did not give the correct answer faster with the top cue&nbsp;";
			echo "<img style='height: 90px; width: 15px;' src='images/ant/instructions/debrief4.png' alt='Top Cue'/>";
			echo "&nbsp;and bottom cue&nbsp;";
			echo "<img style='height: *0px; width: 20px;' src='images/ant/instructions/debrief5.png' alt='Bottom Cue'/>";
			echo "&nbsp;than with the mid cue&nbsp;";
			echo "<img style='height: 20px;' src='images/ant/instructions/debrief3.png' alt='Mid Cue'/>";
			echo "&nbsp;People normally react faster with a top or bottom cue because it predicts where the target lands, and this should accelerate the process of orienting to it, because
			it draws your attention to it.";
			echo "<hr style='height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'>";
		}
		
		/* Print executive result */
		if ($executive > 0) { /* Executive effect found */
			echo "<h1 style='text-decoration: underline; color: green;'>Executive Effect</h1>";
			echo "&nbsp;You gave the correct answer&nbsp;" . $executive . "ms faster when the targets were congruent&nbsp;";
			echo "<img style='width: 250px; height: 100px;' src='images/ant/instructions/debrief6.png' alt='congruent target'/>";
			echo "&nbsp;compared to when they were incongruent&nbsp;";
			echo "<img style='width: 250px; height: 100px;' src='images/ant/instructions/debrief7.png' alt='incongruent target'/>";
			echo "&nbsp;Your executive system had to resolve the search conflict of which direction the middle character was pointing in. You found it easier with congruent
			targets, because all the characters were pointing in the same direction. The incongruent targets distracted your attention because the pointing direction of the middle
			character could be mistaken for the pointing direction of the ones that surround it, and this slowed down your reaction time.";
			echo "<hr style='height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'>";
		} else { /* No executive effect found */
			echo "<h1 style='text-decoration: underline; color: red;'>Executive Effect</h1>";
			echo "&nbsp;People normally give the correct answer faster when the target is congruent&nbsp;";
			echo "<img style='width: 250px; height: 100px;' src='images/ant/instructions/debrief6.png' alt='congruent target'/>";
			echo "&nbsp;compared to when the target is incongruent&nbsp;";
			echo "<img style='width: 250px; height: 100px;' src='images/ant/instructions/debrief7.png' alt='incongruent target'/>";
			echo "&nbsp;The incongruent characters typically distract your attention, because the pointing direction of the middle character could be mistaken for the pointing
			direction of the ones that surround it, and this should have slowed down your reaction time.";
			echo "</div>";
			echo "<hr style='height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'>";
		}
	}
?>