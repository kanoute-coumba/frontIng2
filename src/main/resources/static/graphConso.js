console.log('je suis le js');
console.log(conso);
const dataP = [];
for(let i=0;i<conso.length;i++){
    dataP[dataP.length] = { x: conso[i].date_time*1000, y : conso[i].value};
    console.log(conso[i].date_time);
}

var chart = new CanvasJS.Chart("chartContainer", {
    animationEnabled: true,
    title: {
        text: "Historique de la Puissance"
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
        xValueType: "dateTime",
        xValueFormatString: "YYYY MM DD HH:mm ss TT",
        yValueFormatString: "#,##0.##\" W\"",
        dataPoints: dataP}]
});
chart.render();