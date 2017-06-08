"use strict";

var start;
var settingsLoadTime = 1500;
var pixels = "px";
var messageDelay = 1000;
var messageDuration = 1;
var messageInterval;	  
var drawing = document.getElementById("subliminalMessage");
drawing.style.left = ($(window).width() / 2) + pixels;
drawing.style.top = ($(window).height() / 2) + pixels;
drawing.style.position = "fixed";
var con = drawing.getContext("2d");
var screenPositionsXY = [[$(window).width() / 5, $(window).height() / 2], [$(window).width() / 5,
						  $(window).height() / 4], [$(window).width() / 5, $(window).height() / 1]];

var messages = {}; // Construct a messages object

messages.selfEnhancement = [ "I never give up", "I am strong", "I don't care what others think about me",
							 "I stand out from the crowd", "I will be successful",
							 "I have the power to achieve all of my dreams", "I can do anything if I set my mind to it",
							 "I am the best at everything I do", "I am strong-minded person" ];

messages.intelligence = [ "You are smart", "You are an intelligent person", "You have intellectual potential",
						  "You focus easily", "You can succeed at anything", "Intelligence fills your mind",
						  "You learn rapidly and easily", "You are bright and capable", "You communicate intelligently",
						  "You have a brilliant mind" ];

messages.positiveThinking = [ "Today is beautiful", "I am in peace", "I refuse negativity", "I am full of potential",
							  "I choose to be happy", "I am courageous", "I am grateful for what I have",
							  "I feel better each day", "I live in the present", "I have a healthy mind"];
				  
messages.creativity = [ "I am talented and creative", "I find inspiration everywhere", "I have a vivid imagination",
						"I am an artistic person", "I can create anything", "I have a lot of creative ideas",
						"I am inventive", "I am a visionary", "I have a powerful creative energy", "My ideas are artistic" ];

messages.leadership = [ "I am an alpha male", "People look up to me", "I am a leader", "I inspire people",
						"I have strong leadership skills", "No goal is unreachable for me",
						"I am focused and determined", "I am a great visionary", "I have a magnetic personality",
						"I bring out the best in people" ];
		
messages.memory = [ "I have a strong visual memory", "I recall information quickly", "I have a clear mind",
					"I have a clear memory", "I have a reliable memory", "I store new facts efficiently",
					"I remember names and faces easily", "I always remember important details",
					"My memory is sharp", "Recalling information is easy for me", "I have a photographic memory" ];
				  
messages.selfEsteem = [ "I am worthy", "I have beautiful qualities", "I am smart", "I deserve the best", "I believe in myself",
						"I love myself", "I am talented", "I am lovable", "I am appreciated", "I am at peace with myself"];
				  
messages.motivation = [ "I will do what needs to be done", "I am goal-oriented", "I am focused", "I can and will do it",
						"I have mental strength", "I am highly motivated to succeed", "I am determined to succeed",
						"I am capable of doing it", "I have perseverance", "I am driven" ];

messages.lawOfAttraction = [ "I am a positive individual", "I attract positivity", "My beliefs manifests in reality",
							 "I have the power to change things", "I can achieve anything I want", "I think positively",
							 "I am in control of my life", "I attract success", "I have a positive mindset",
							 "I attract good experiences" ];
				  
messages.relationships = [ "I have strong social skills", "I am a likeable person", "I have a lot of friends", "I am loved",
						   "I have healthy relationships", "I have quality relationships", "I can communicate with anyone",
						   "I can befriend anyone", "My presence is enjoyable", "People respect me" ];
				  
messages.quitSmoking = [ "I can quit smoking and I will", "I have the strength to quit", "I do not need to smoke",
						 "I choose a healthy life", "I do not crave nicotine", "I choose health", "I am free",
						 "I refuse dependency", "I have mental strength", "I will never smoke again" ];
				  
messages.quitDrinking = [ "I can quit drinking and I will", "My health is important", "I choose a healthy life",
						  "I am free", "I have mental strength", "I refuse dependency", "I will never drink again",
						  "I do not need to drink", "I do not crave drinking", "I refuse dependency" ];
				  
messages.quitPorn = [ "I choose a healthy lifestyle", "I have the mental strength to quit", "I refuse dependency",
					  "I choose to be free", "I do not crave porn", "I can have a healthy sexual life",
					  "I know too much porn is unhealthy", "I control my sexual urges", "My attitude toward sex is healthy",
					  "My willpower is stronger" ];

messages.exercise = [ "I can and will exercise", "I have strength and motivation", "I have will power",
					  "I choose a healthy lifestyle", "I choose to live in a healthy body", "I can do it",
					  "I feel accomplished when I exercise", "My body is strong", "I am determined", "I am focused" ];
				  
messages.confidence = [ "I am confident in my abilities", "I know who I am and what I want", "I am worthy",
						"I am a strong individual", "I have potential", "I can overcome any challenge",
						"I exude confidence", "I am bold and assertive", "I am fierce", "I have courage" ];
				  
messages.millionaireMindset = [ "I am goal oriented", "I am driven", "I am successful", "I can achieve anything",
								"I attract abundance", "I am wealthy", "I have power", "I have business potential",
								"I overcome financial obstacles", "I have financial success" ];
				  
		jQuery(document).ready(function() {
			get_social_counts();
			$('.menu-link').bigSlide();
			setup(messages.selfEnhancement);
			
			$(window).resize(function() {
				if(this.resizeTO) clearTimeout(this.resizeTO);
					this.resizeTO = setTimeout(function() {
					  $(this).trigger('windowResize');
					}, 500); 
				});
				$(window).on('windowResize', function() {
					setCoordinates();
				});

			$("#messageList").val("selfEnhancement");
			
			$("#messageList").on('change', function() {
				clearMessage();
				stopMessages();
				setup(eval("messages." + $("#messageList").val()));
			});
			
			$('#displayEvery').change(function() {
				clearMessage();
				stopMessages();
				setup(eval("messages." + $("#messageList").val()));
			});
			
			$("#messagesOn").on('change', function() {
				if ($("#messagesOn").is(":checked")) {
					setup(eval("messages." + $("#messageList").val()));
				}
			});
			
			$("#messagesOff").on('change', function() {
				clearMessage();
                stopMessages();
			});
		});
		

function setup(messages) {
	var messageSelection = messages.slice(0);
	messageInterval = setInterval( function() { displayMessages(messageSelection); }, $('#displayEvery').val());
}

function calculateMessagePosition() {
	var pos = Math.floor(Math.random() * 2) + 0; /* Randomly select one of the 3 positions */
	var width = screenPositionsXY[pos][0]; /* Get the width in index 0 for the position */
	var height = screenPositionsXY[pos][1]; /* Get the height in index 1 for the position */
	drawing.style.left = width + pixels;
	drawing.style.top = height + pixels;
}

function get_social_counts() {
	var thisUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
	$.ajax({
		type: "GET",
		url: 'http://www.psychotechnology.com/php-includes/get_social_counts.php?thisurl='+thisUrl,
		dataType: "json",
		success: function (data){
			$('a.post-share.twitter span').html(data.twitter);
			$('a.post-share.facebook span').html(data.facebook);
			$('a.post-share.gplus span').html(data.gplus);
			$('a.post-share.stumble span').html(data.stumble);
		}, error: function(xhr, status, error) {
			var err = eval("(" + xhr.responseText + ")");
	}
	});
}

function outputUpdate(vol) {
	document.querySelector('#volume').value = vol + " ms";
}

function outputUpdate2(vol) {
	document.querySelector('#volume2').value = vol + " ms";
}

function stopMessages() {
    clearInterval(messageInterval);
}

function displayMessages(m) {
	calculateMessagePosition();
	draw(m);
    setTimeout ( function() { clearMessage(); }, $('#duration').val() );
}

function setCoordinates() {
	screenPositionsXY[0][0] = $(window).width() / 5;
	screenPositionsXY[0][1] = $(window).height() / 2;
	screenPositionsXY[1][0] = $(window).width() / 5;
	screenPositionsXY[1][1] = $(window).height() / 4;
	screenPositionsXY[2][0] = $(window).width() / 5;
	screenPositionsXY[2][1] = $(window).height() / 1;
	
drawing.style.left = ($(window).width() / 2) + pixels;
drawing.style.top = ($(window).height() / 2) + pixels;
}

function draw(messages) {
	var trial = Math.floor(Math.random() * messages.length) + 0;
	//clear background

	con.fillStyle = $("#colorMenu select").val();
	var size = $("#sizeMenu select").val();
	con.font = "bold " + size + pixels + " sans-serif";
	con.fillText(messages[trial], 80, 80);
}

function clearMessage() {
    con.clearRect(0, 0, 2000, 4000);
}