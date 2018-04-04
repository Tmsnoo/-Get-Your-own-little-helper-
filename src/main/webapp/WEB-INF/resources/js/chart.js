window.onload = function () {

var options = {
	animationEnabled: true,
	title: {
		text: "Experienced"
	},
	axisY: {
		title: "Positive feedback",
		suffix: "Stars",
		includeZero: false
	},
	axisX: {
		title: "Categories"
	},
	data: [{
		type: "column",
		yValueFormatString: "#,###.##",
		dataPoints: [
			{ label: "Malowanie", y: 10.00 },	
			{ label: "Remontowe", y: 9.00 },	
			{ label: "Ogrodowe", y: 8.00 },
			{ label: "Transportowe", y: 7.00 },	
			{ label: "Inne", y: 2.00 },
			
		]
	}]
};
$("#chartContainer").CanvasJSChart(options);

}