"use strict";
var fixationPath = 'images/ant/cues/fixPlus.png';
var freudStimuliPath = 'images/ant/freud/';
var cuePath = 'images/ant/cues/';
var instructPath = 'images/ant/help/';
var imgExtension = '.png';
var toa = 5000; // Trial Onset Asynchrony
var preFixTime = 500;
var loadTime = [500, 600, 700, 800, 900, 1000, 1100, 1200]; // The central plus sign
var cueTime = 1000; // The cue
var postCueFixTime = 400
var maxTgTime = 1500; // The maximum time to respond after stimulus presentation
var trialCounter;
var trials = 47;
var cue = ["fixPlus", "midCue", "botCue", "topCue", "bothCue"]; // The cues
var activeCue = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4];
var condition = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47];
var stImage = ['T_L_N', 'T_L_C', 'T_L_I', 'T_R_N', 'T_R_C', 'T_R_I', 'B_L_N', 'B_L_C', 'B_L_I', 'B_R_N', 'B_R_C', 'B_R_I']; // The stimuli
var stType = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11];
var ansKey = ['Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M', 'Z', 'Z', 'Z', 'M', 'M', 'M'];
var theTask;
var rspArr = [];
var RTArr = [];
var condArr = [];
var ansArr = [];
var cueArr = [];
var congruenceArr = [];
var inputRecorded;
var stStart, stEnd, RT;
var correctAnswer = new Audio('audio/correctAnswer.mp3');
var errorMsg = [ "Incorrect key pressed", "Time elapsed (> 2 secs)" ];
var cueInstruct = [ "A 'fixation' will appear before and after each cue.",
					"The 'mid cue' tells you when the stimulus will appear. It does not tell you where on the screen it will show up.",
					"The 'bottom' cue means that the target will appear at the bottom.",
					"The 'top' cue means that the target will appear at the top.",
					"Sometimes, both top and bottom cues will appear at the same time. This means that that the stimulus can appear on top or bottom." ];

	$(document).ready(function() {
		$("#restartAnt").hide();
		$("#submitAnt").hide();
		$("#antDebrief").hide();
		$('.tab li #antFeedbackInstruct').addClass('activeTab');
		
		$("#startAnt").click(function() {
			clearStimulus(0);
			clearKeyboardInstructions(0);
			clearFeedbackInfo();
			$("#startAnt").hide();
			$("#restartAnt").show();
			$("#stimuliContainer").css("background-color", "#eee");
			displayCueInformation();
		});
		
		$("#restartAnt").click(function() {
			restartTrial();
			$("#restartAnt").hide();
			$("#startAnt").show();
			$("#stimuliContainer").css("background-color", "#fff");
			$("#stimuli").attr("src", "images/antImage.png");
		});

			$("#submitAnt").click(function() {
				$.post("php-includes/antForm.php", {
					response : $("input[name=rspStr]").val(), 
					RT : $("input[name=RTStr]").val(),
					nTrial : $("input[name=nTrial]").val(),
					toa : $("input[name=toa]").val(),
					condition : $("input[name=condition]").val(), 
					ansStr : $("input[name=ansStr]").val(), 
					cueStr : $("input[name=cueStr]").val(),
					congruency : $("input[name=congruency]").val()
				},
				function(data) {
					$('.tab li #antFeedbackInstruct').removeClass('activeTab');
					$('.tab li #antFeedbackResults').addClass('activeTab');
					$("#errorMsg").hide();
					$("#stimuliContainer").css("background-color", "#eee");
					$("#antDebrief").css("visibility", "visible");
					$("#antDebrief").show();
					$('#antDebrief').html(data);
					$("#submitAnt").hide();
				});
			});
	});
	
function displayCueInformation() {
	var elapsedTime = 0;
	var i = 0;

	/* Fixation */
	showCue(cue[i], instructPath, elapsedTime);
	showCueInfo(cue[i], cueInstruct[i], elapsedTime);
	
	/* Middle Cue */
	showCue(cue[++i], instructPath, elapsedTime += 3500);
	showCueInfo(cue[i], cueInstruct[i], elapsedTime);
	
	/* Bottom Cue */
	showCue(cue[++i], instructPath, elapsedTime += 3500);
	showCueInfo(cue[i], cueInstruct[i], elapsedTime);
	showStimulus(freudStimuliPath, stImage[6], elapsedTime += 3500);
	
	/* Top Cue */
	showCue(cue[++i], instructPath, elapsedTime += 3500);
	showCueInfo(cue[i], cueInstruct[i], elapsedTime);
	showStimulus(freudStimuliPath, stImage[0], elapsedTime += 3500);
	
	/* Double Cue */
	showCue(cue[++i], instructPath, elapsedTime += 3500);
	showCueInfo(cue[i], cueInstruct[i], elapsedTime);
	showStimulus(freudStimuliPath, stImage[0], elapsedTime += 3500);
	showStimulus(freudStimuliPath, stImage[6], elapsedTime += 1500);
	clearStimulus(elapsedTime += 1500);
	clearCueInstruction(elapsedTime);
	
	instructUser("M", elapsedTime += 5000);
	showStimulus(freudStimuliPath, stImage[0], elapsedTime);
	showStimulus(instructPath, stImage[0], elapsedTime += 1000);
	clearKeyboardInstructions(elapsedTime += 3500);
	clearStimulus(elapsedTime);
	
	instructUser("Z", elapsedTime += 250);
	showStimulus(freudStimuliPath, stImage[9], elapsedTime);
	showStimulus(instructPath, stImage[9], elapsedTime += 1000);
	clearKeyboardInstructions(elapsedTime += 5000);
	clearStimulus(elapsedTime);
	runTrialBlock(elapsedTime += 500);
}

function runTrialBlock(delay) {
	trialCounter = 0;
	shuffle(condition); // The 48 conditions are shuffled in runTrialBlock
	setTimeout (function() {
		theTask = setInterval(function(){runTrial();}, toa); // runTrial is called every 4 seconds
	}, delay);
}

function responseInfo() {
	var elapsedTime = 0;
}

function runTrial() {
	if (trialCounter < trials) {
		clearFeedbackInfo();
		clearKeyboardInstructions();
		shuffle(loadTime); //Random time selected from loadTime
		if (trialCounter == 0) {
			$('.tab li #antFeedbackResults').addClass('activeTab');
			$('.tab li #antFeedbackInstruct').removeClass('activeTab');
		}
		var currC = condition[++trialCounter];
		updateTrialInfo(currC);
		showFixation(currC, 0);
		clearCueInstruction(0);
		loadTime[0] = 100;
		showCue(cue[activeCue[currC]], cuePath, loadTime[0]); // Freud stimulus
		findCueInfo(cue[activeCue[currC]], loadTime[0]);
		showFixation(currC, loadTime[0] + cueTime);
		clearCueInstruction(loadTime[0] + cueTime);
		getKeypress(currC, loadTime[0] + cueTime + postCueFixTime);
		checkResponse(loadTime[0] + cueTime + postCueFixTime + maxTgTime, currC);
	} else {
		clearInterval(theTask);
		submitData();
	}
}

function clearKeyboardInstructions(delay) {
	setTimeout (function() {
		if ($("#zKey").css("visibility") == "visible") {
			$("#zKey").css("visibility", "hidden");
		}
		if ($("#mKey").css("visibility") == "visible") {
			$("#mKey").css("visibility", "hidden");
		}
		if ($("#bothKeys").css("visibility") == "visible") {
			$("#bothKeys").css("visibility", "hidden");
		}
	}, delay);
}

function clearFeedbackInfo() {
	if ($("#errorTitle").css("visibility") == "visible") {
		$("#errorTitle").css("visibility", "hidden");
	}
	if ($("#rewardTitle").css("visibility") == "visible") {
		$("#rewardTitle").css("visibility", "hidden");
	}
}

function clearStimulus(delay) {
	setTimeout (function() {
		$("#stimuli").attr("src", "images/ant/cues/blank.png");
	}, delay);
}

//clear interval after 24 trials for one practice block and after 48 for 6 experimental blocks.
function shuffle(array) {
    var counter = array.length, temp, index;
	while (counter > 0) {
		index = Math.floor(Math.random() * counter);
		counter--;
		temp = array[counter];
        array[counter] = array[index];
        array[index] = temp;
    }
	return array;
}

function updateTrialInfo(currC) {
	addTrialCue(currC);
	addTrialAnswer(currC);
	addTrialCondition(currC);
	addTrialCongruency(stType[currC], congruenceArr);
}

function addTrialCue(currC) {
	cueArr.push(cue[activeCue[currC]]);
}

function addTrialAnswer(currC) {
	ansArr.push(ansKey[currC]);
}

function addTrialCondition(currC) {
	condArr.push(currC);
}

/**
* This function adds the congruency of the stimulus for the current trial
* @param {Char} stimulus - Congruency of the stimulus (c = congruent, i = incongruent or n = neutral)
* @param {Array[]} congArr - Array containing the congruency of all trials thus far
*/
function addTrialCongruency(stimulus, congArr) {
	congArr.push(0);
	switch (stimulus) {
		case 0: congArr[congArr.length - 1] = 'n'; break;
		case 1: congArr[congArr.length - 1] = 'c'; break;
		case 2: congArr[congArr.length - 1] = 'i'; break;
		case 3: congArr[congArr.length - 1] = 'n'; break;
		case 4: congArr[congArr.length - 1] = 'c'; break;
		case 5: congArr[congArr.length - 1] = 'i'; break;
		case 6: congArr[congArr.length - 1] = 'n'; break;
		case 7: congArr[congArr.length - 1] = 'c'; break;
		case 8: congArr[congArr.length - 1] = 'i'; break;
		case 9: congArr[congArr.length - 1] = 'n'; break;
		case 10: congArr[congArr.length - 1] = 'c'; break;
		case 11: congArr[congArr.length - 1] = 'i'; break;
	}
}

/**
* This function displays the fixation
* @param {int} currC -  Current trial
* @param {int} delay - Delay till the fixation is shown
*/
function showFixation(currC, delay) {
	setTimeout (function() {
		$("#stimuli").attr("src", fixationPath);
	}, delay); // 500-1200ms + 100ms
}

/**
* This function removes the cue instruction text in the right-hand panel
*/
function clearCueInstruction(delay) {
	setTimeout (function() {
		if ($("#cueMsg").css("visibility") == "visible") {
			$("#cueMsg").css("visibility", "hidden");
		}
	}, delay);
}

/**
* This function displays a cue image in the game screen
* @param {String} cue - Name of the cue
* @param {String} path - Cue image folder
* @param {Integer} delay - Time to wait until displaying the cue
*/
function showCue(cue, path, delay) {
	setTimeout (function() {
		$("#stimuli").attr("src", path + cue + imgExtension);
		$("#cueMsg").css("visibility", "visible");
	}, delay); // 500-1200ms
}

function spatialCueInfo(path, cue, delay) {
	setTimeout (function() {
		$("#cueMsg").text(cue);
	}, delay);
}

/**
* This function displays the stimulus in the game screen
* @param {String} stimulus - Name/type of stimulus
* @param {String} path - Directory containing stimulus
* @param {int} delay - Time to wait till stimulus is displayed
*/
function showStimulus(path, stimulus, delay) {
	setTimeout (function() {
		$("#stimuli").attr("src", path + stimulus + imgExtension);
	}, delay);
}

function getKeypress(currC, delayTime) {
	setTimeout (function() {
		stStart = new Date();
		showStimulus(freudStimuliPath, stImage[stType[currC]], 0);
		rspArr.push(0);
		RTArr.push(0);
		inputRecorded = false;
		document.onkeydown = function (e) {
			if (inputRecorded) {
				return;
			}
			inputRecorded = true;
			e = e || window.event;
			var keyPressed = String.fromCharCode(e.keyCode);
			var regex = /[MZ]/;
			stEnd = new Date();
			RT = stEnd.getTime() - stStart.getTime();
			addResponse(keyPressed, currC, RT, rspArr, RTArr);
			if (keyPressed != ansKey[currC]) {
				showErrorMsg(errorMsg[0]);
				instructUser(keyPressed, 0);
				reinforceLearning(currC);
			} else {
				$("#rewardTitle").css("visibility", "visible");
				$("#rewardType").text(RT + "ms"); // Wrong key
				$("#stimuli").attr("src", "images/ant/cues/blank.png");
			}
		};
	}, delayTime); // 500-1200ms + 100ms + 400ms
}

/**
* This function displays error messages if a response was not given
* @param {int} delay - The time till the error messages are shown
* @param {int} currC - The current trial
*/
function checkResponse(delay, currC) {
	setTimeout (function() {
		if (!inputRecorded) {
			inputRecorded = true; // Stop further key presses after this point
			showErrorMsg(errorMsg[1]); // Too slow message
			instructUser(0, 0); // pass a null key and 0ms delay
			reinforceLearning(currC); // Red circle over stimulus
		}
	}, delay); // 500-1200ms + 100ms + 400ms + 1500ms
}

function showErrorMsg(message) {
	$("#errorTitle").css("visibility", "visible");
	$("#errorType").text(message); // Wrong key
	$("#errorMsg").css("visibility", "visible");
}

/**
* This function displays specific keyboard instructions.
* The correct key instruction is given if the key press was in the opposite
* direction ("Z" for "M", and vice versa), or both are shown if an illegal key was pressed.
* @param {Char} keyPressed - The key that was pressed
*/
function instructUser(keyPressed, delay) {
	setTimeout (function() {
		switch(keyPressed) {
			case "M":
				$("#zKey").css("visibility", "visible");
				break;
			case "Z":
				$("#mKey").css("visibility", "visible");
				break;
			default:
				$("#bothKeys").css("visibility", "visible");
				break;
		}
	}, delay);
}

/**
* This function displays the stimulus with a red circle around the middle
* image of Freud.
* @param {int} currC - The current trial number
*/
function reinforceLearning(currC) {
	$("#stimuli").attr("src", instructPath + stImage[stType[currC]] + imgExtension);
}

/**
* This function changes the cue text on the right panel, depending
* on the cue present.
* @param {String} cue - The name of the cue
* @param {int} delay - The time till the text is changed
*/
function showCueInfo(cue, message, delay) {
	setTimeout (function() {
		$("#cueMsg").text(message);
	}, delay);
}

function findCueInfo(cue, delay) {
	setTimeout (function() {
		switch(cue) {
			case "fixPlus":
				$("#cueMsg").text(cueInstruct[0]);
				break;
			case "midCue":
				$("#cueMsg").text(cueInstruct[1]);
				break;
			case "botCue":
				$("#cueMsg").text(cueInstruct[2]);
				break;
			case "topCue":
				$("#cueMsg").text(cueInstruct[3]);
				break;
			case "bothCue":
				$("#cueMsg").text(cueInstruct[4]);
				break;
		}
	}, delay);
}

function restartTrial() {
	clearInterval(theTask);
	clearKeyboardInstructions(0);
	clearFeedbackInfo();
}

/**
* This function evaluates the key pressed against the correct response.
* Keys and RTs are added at the end of the array for the current set of trials.
* @param {Char} keyPressed - The key that was pressed
* @param {int} currC - The current trial
* @param {int} RT - The reaction time of the response
* @param {array[]} rspArr - The array containing the responses
* @param {array[]} RTArr - The array containing the reaction times
*/
function addResponse(keyPressed, currC, RT, rspArr, RTArr) {
	var regex = /[MZ]/;
	if (keyPressed.search(regex) > -1 && keyPressed === ansKey[currC]) {
		correctAnswer.play();
		rspArr[rspArr.length - 1] = keyPressed;
		RTArr [RTArr.length - 1] = RT;
		
	} else {
		rspArr[rspArr.length - 1] = 0;
		RTArr [RTArr.length - 1] = 0;
	}	
}

function submitData() {
	trialCounter = 0;

	var rspStr = rspArr.join(',');
	var RTStr = RTArr.join(',');
	var condStr = condArr.join(',');
	var ansStr = ansArr.join(',');
	var cuesStr = cueArr.join(',');
	var congStr = congruenceArr.join(',');

	$("input[name=rspStr]").val(rspStr);
	$("input[name=RTStr]").val(RTStr);
	$("input[name=nTrial]").val(trials);
	$("input[name=toa]").val(toa);	
	$("input[name=condition]").val(condStr);
	$("input[name=ansStr]").val(ansStr);
	$("input[name=cueStr]").val(cuesStr);
	$("input[name=congruency]").val(congStr);
	$("#restartAnt").hide();
	$("#submitAnt").show();
}