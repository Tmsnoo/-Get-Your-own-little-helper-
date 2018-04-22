$(document).ready(function() {
	$('#checkbox1').change(function() {
		if (this.checked)
			$('.tel').fadeIn('slow');
		else
			$('.tel').fadeOut('slow');

	});
});