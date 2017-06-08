

$(function() {
	var width = 960;
	var speed = 2000;
	var pause = 3000;
	var currentSlide = 1;
	var interval;

	var $slider = $('#slider');
	var $slideContainer = $slider.find('.slides');
	var $slides = $slideContainer.find('.slide');

	function runSlider() {
		interval = setInterval(function() {
			$slideContainer.animate({'margin-left': '-=' + width}, speed, function() {
				currentSlide++;
				if (currentSlide === $slides.length) {
					currentSlide = 1;
					$slideContainer.css('margin-left', 0);
				}
			});
		}, pause);
	}
	
	function stopSlider() {
		clearInterval(interval);
	}

	$slider.on('mouseenter', stopSlider).on('mouseleave', runSlider);
	runSlider();
	});