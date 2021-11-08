var dataChartSalleRes = {
    labels: ['Réservées','Non réservées'],
    datasets: [
        {
            label: 'Dataset 1',
            data: [75, 25],
            backgroundColor: ['#19C2D8','#D5D5D5']
        },
    ]
};
var ctxChartSalleRes = document.getElementById("chartSalleRes");
var chartSalleRes = new Chart(ctxChartSalleRes, {
    type: 'doughnut',
    data: dataChartSalleRes,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Proportion totale des salles de réunion réservées (en %)'
            }
        }
    }
});


// ========================================

var dataChartResaParSalle = {
    labels: ['Salle 1','Salle 2','Salle 3','Salle 4','Salle 5','Salle 6'],
    datasets: [
        {
            label: 'Réservées',
            data: [75,68,81,65,60,70],
            backgroundColor: ['#19C2D8','#19C2D8','#19C2D8','#19C2D8','#19C2D8','#19C2D8']
        },
        {
            label: 'Non réservées',
            data: [25,32,19,35,40,30],
            backgroundColor: ['#D5D5D5','#D5D5D5','#D5D5D5','#D5D5D5','#D5D5D5','#D5D5D5']
        },
    ]
};
var ctxChartResaParSalle = document.getElementById("chartResaParSalle");
var chartResaParSalle = new Chart(ctxChartResaParSalle, {
    type: 'bar',
    data: dataChartResaParSalle,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Proportion des salles de réunion réservées (en %)'
            }
        },
        scales: {
            x: {
                stacked: true,
            },
            y: {
                stacked: true
            }
        }
    }
});

// ========================================

$('body').on('click', '.action-salle .btn', function(e) {
    $('#exampleModal').modal('show');
});

$('body').on('click', '#exampleModal .close', function(e) {
    $('#exampleModal').modal('hide');
});