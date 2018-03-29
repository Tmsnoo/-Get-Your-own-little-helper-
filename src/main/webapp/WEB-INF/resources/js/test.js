document.addEventListener("DOMContentLoaded", function() {

	var array1 = [ "dolnośląskie", "kujawsko-pomorskie", "lubelskie",
			"lubuskie", "łódzkie", "małopolskie", "mazowieckie", "opolskie",
			"podkarpackie", "podlaskie", "pomorskie", "śląskie",
			"świętokrzyskie", "warmińsko-mazurskie", "wielkopolskie",
			"zachodniopomorskie" ];

	array1.forEach(function(element) {
		$('#' + element).change(function() {
			var elem = '.' + this.id;
			if (this.checked)
				$(elem).fadeIn('slow');
			else
				$(elem).fadeOut('slow');
		});
	});

});