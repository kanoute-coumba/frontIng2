console.log('je suis le js');
console.log(conso);
const dataP = [];
for(let i=0;i<conso.length;i++){
    dataP[dataP.length] = { x: conso[i].date_time, y : conso[i].value};
}
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	title: {
		text: "Puissance de l'équipement"
	},
	axisX: {
		title: "Temps"
	},
	axisY: {
		title: "Puissance",
		suffix: " Watt",
		includeZero: true
	},
	data: [{
		type: "line",
		name: "CPU Utilization",
		connectNullData: true,
		//nullDataLineDashType: "solid",
		xValueType: "dateTime",
		xValueFormatString: "DD MMM hh:mm TT",
		yValueFormatString: "#,##0.##\" W\"",
		dataPoints: dataP}]
});
chart.render();

