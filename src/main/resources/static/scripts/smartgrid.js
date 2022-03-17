var stompClient = null;
var server = 'http://localhost:9000';
const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
});

$(function() {
    connect();

    clock();

    $(".refresh-event").on("click", function() {
        var refresh = $(this);
        refresh.addClass("rotate");
        $.ajax({
            url: server + '/readBuildingsTypeCentral',
            type: 'GET',
            success: function(centrals) {
                console.log("Manual update of the centrals");
                $(".box-central").html(centralsHtml(centrals));
                refresh.removeClass("rotate");
                Toast.fire({
                    icon: 'success',
                    title: 'Centrales mis à jour'
                });
            }
        });
        /*send("/smartgrid/refresh", "refresh");*/
    });

    $(".see-event").on("click", function() {
        var district = $(this);
        $.ajax({
            url: server + '/readBuildingsByDistrict?district=' + district.data("id"),
            type: "GET",
            beforeSend: function() {
                Swal.showLoading();
            },
            success: function(buildings) {
                Swal.fire({
                    title: district.data("name"),
                    html: buildingsHtml(buildings),
                    width: 600,
                    height: 600,
                    padding: '20px',
                    color: '#000000',
                    background: '#FDFEFC',
                    backdrop: 'rgba(157, 181, 153, 0.5)',
                    confirmButtonColor: '#326019'
                });
            }
        });
    });
});

function clock() {
    var date = new Date();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? "0" + minute : minute;
    second = second < 10 ? "0" + second : second;
    document.querySelector('.clock-event').innerHTML = hour + ":" + minute + ":" + second;
    setTimeout(clock, 500);
}

function buildingsHtml(buildings) {
    let html = '<table><thead><tr><th>type</th><th>nom</th><th>adresse</th><th>consommation</th><th>production</th></thead><tbody>';
    for(let i = 0; i < buildings.length; i++) {
        html += '<tr><td>';
        switch (buildings[i].type) {
            case 'Maison':
                html += '<i class="fi fi-rr-home"></i></i>';
                break;
            case 'Immeuble':
            case 'Entreprise':
                html += '<i class="fi fi-rr-building"></i>';
                break;
        }
        html += '</td><td>' + buildings[i].name + '</td><td>' + buildings[i].address + '</td><td>' + buildings[i].consumption.toFixed(2) + 'W</td><td>' + buildings[i].production.toFixed(2) + 'W</td></tr>';
    }
    html += '</tbody></table>';
    return html;
}

function centralsHtml(centrals) {
    let html = '';
    for (let i = 0; i < centrals.length; i++) {
        html += '<div class="col-md-12 col-sm-12 col-xs-12"><div class="corner item"><div class="center-all item-central"><div class="center-all">';
        switch (centrals[i].type) {
            case 'solaire':
                html += '<i class="fi fi-rr-sun"></i>';
                break;
            case 'eolienne':
                html += '<i class="fi fi-rr-wind"></i>';
                break;
            case 'hydraulique':
                html += '<i class="fi fi-rr-raindrops"></i>';
                break;
            case 'thermique':
                html += '<i class="fi fi-rr-flame"></i>';
                break;
        }
        html += '<span>' + centrals[i].name + '</span></div><span>' + centrals[i].capacity + '/' + centrals[i].maxCapacity + 'W</span></div><div class="center-all"><span>' + centrals[i].address + '</span><span class="flash">' + centrals[i].production + 'W</span></div></div></div>';
    }
    return html;
}

function connect() {
    var socket = new SockJS('/citizens');
    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function() {
        stompClient.subscribe('/smartgrid/centrals', function(centrals) {
            if(centrals.body !== undefined && centrals.body !== null && centrals.body.length > 0) {
                console.log("Automatic update of the centrals");
                $(".socket-central").html(centralsHtml(JSON.parse(centrals.body)));
            }
        });
        stompClient.subscribe('/smartgrid/city', function(data) {
            if(data.body !== undefined && data.body !== null && data.body.length > 0) {
                console.log("Automatic update of the city energy balance");
                $(".socket-city-energy-balance").html(data.body + "W");
            }
        });
        /*stompClient.subscribe('/smartgrid/refresh', function(response) {
            if(response.body === "true") {
                console.log("Ok");
                $(".refresh-event").removeClass("rotate");
            }
        });*/
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log('disconnected');
}

function send(url, message) {
    if (stompClient !== null) {
        stompClient.send(url, {}, JSON.stringify(message));
    }
    console.log('message sent');
}