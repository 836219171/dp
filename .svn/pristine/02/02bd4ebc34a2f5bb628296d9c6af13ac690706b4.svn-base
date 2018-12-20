// $(document).ready(function () {
	
	// commons.leftQuery({}).then(function(res){
	function mdjfdcqk(res){
		var tjcgl;
		var jsxyl;
		var data = res[0].blockOne.resultOne;
		var date = res[0].blockOne.resultTwo;
		tjcgl = data.sz;
		jsxyl = date.sz;
		var tjcglAngle = -135 + (tjcgl*2.7);
		var jsxylAngle = -135 + (jsxyl*2.7);
		$('.tjcgl .pointer').css({'transform':'rotate('+tjcglAngle+'deg)'});
		$('.jsxyl .pointer').css({'transform':'rotate('+jsxylAngle+'deg)'});
		$('.tjcgl .number').html(tjcgl);
		$('.jsxyl .number').html(jsxyl);
		$('.panel .title1').html(data.mc);
		$('.panel .title2').html(date.mc);
		//指针抖动效果
		function active1(ele,angle) {
			$(ele).animate({
				deg: angle+5
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
			active2(ele,angle);
			active3(ele,angle);
			active4(ele,angle);
			active5(ele,angle);
			active6(ele,angle);
			active7(ele,angle);
		}
		function active2(ele,angle) {
			$(ele).animate({
				deg: angle-5
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
		}

		function active3(ele,angle) {
			$(ele).animate({
				deg: angle+3
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
		}

		function active4(ele,angle) {
			$(ele).animate({
				deg: angle-3
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
		}
		function active5(ele,angle) {
			$(ele).animate({
				deg: angle+1
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
		}
		function active6(ele,angle) {
			$(ele).animate({
				deg: angle-1
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
		}

		function active7(ele,angle) {
			$(ele).animate({
				deg: angle
			}, {
				step: function(n, fx) {
					// console.log(n);
					$(this).css("transform", "rotate(" + n + "deg)");
				},
				duration:500
			});
		}

		setInterval(function () {
			active1('.tjcgl .pointer',tjcglAngle);
		},8000);

		setInterval(function () {
			active1('.jsxyl .pointer',jsxylAngle);
		},12000);
	}	
// })