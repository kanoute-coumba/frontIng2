var stompClient = null;
//var server = 'http://localhost:9000';
var server = 'http://172.31.249.1:9000';
const Toast = Swal.mixin({
    toast: true,
    position: 'bottom-end',
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
    refreshListener();
    seeListener();
});

function refreshListener() {
    $(".refresh-event").on("click", function() {
        var refresh = $(this);
        refresh.addClass("rotate");
        $.ajax({
            url: server + '/districts',
            type: 'GET',
            success: function(districts) {
                $.ajax({
                    url: server + '/readBuildingsTypeCentral',
                    type: 'GET',
                    success: function(centrals) {
                        $.ajax({
                            url: server + '/smartgrid',
                            type: 'GET',
                            success: function(balance) {
                                console.log("Manual update of the (districts, centrals, city balance)");
                                $(".socket-district").html(districtsHtml(districts));
                                seeListener();
                                $(".socket-central").html(centralsHtml(centrals));
                                $(".socket-city-energy-balance").html(balance + "W");
                                refresh.removeClass("rotate");
                                Toast.fire({
                                    icon: 'success',
                                    title: 'Données mises à jour'
                                });
                                clock();
                            }
                        });
                    }
                });
            }
        });
        /*send("/smartgrid/refresh", "refresh");*/
    });
}

function seeListener() {
    $(".see-event").off();
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
                    title: district.data("name") + ' (' + district.data("balance").toFixed(2) + 'W)',
                    html: buildingsHtml(buildings),
                    width: 600,
                    padding: '20px',
                    color: '#000000',
                    background: '#FDFEFC',
                    backdrop: 'rgba(157, 181, 153, 0.5)',
                    confirmButtonColor: '#326019'
                });
            }
        });
    });
}

function clock() {
    var date = new Date();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    hour = hour < 10 ? "0" + hour : hour;
    minute = minute < 10 ? "0" + minute : minute;
    second = second < 10 ? "0" + second : second;
    document.querySelector('.clock-event').innerHTML = hour + ":" + minute + ":" + second;
    //setTimeout(clock, 500);
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
        html += '<span>' + centrals[i].name + '</span></div><span class="text-dots">' + centrals[i].capacity.toFixed(2) + '/' + centrals[i].maxCapacity.toFixed(2) + 'W</span></div><div class="center-all"><span>' + centrals[i].address + '</span><span class="flash text-dots">' + centrals[i].production.toFixed(2) + 'W</span></div></div></div>';
    }
    return html;
}

function districtsHtml(districts) {
    let html = '';
    for (let i = 0; i < districts.length; i++) {
        html += '<div class="col-md-4 col-sm-4 col-xs-12">' +
                    '<div class="corner item">' +
                        '<div class="center-all item-header">' +
                            '<span class="text-dots">' + districts[i].name + '</span>' +
                            '<i class="cursor see-event fi fi-rr-eye" data-id="' + districts[i].id + '" data-name="'+ districts[i].name +'" data-balance="' + (districts[i].production - districts[i].consumption) + '"></i>' +
                        '</div>' +
                        '<div>' +
                            '<span class="text-dots">Consommation : ' + districts[i].consumption.toFixed(2) + 'W</span>' +
                            '<span class="text-dots">Production : ' + districts[i].production.toFixed(2) + 'W</span>' +
                        '</div>' +
                    '</div>' +
                '</div>';
    }
    return html;
}

function connect() {
    var socket = new SockJS('/citizens');
    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function() {
        stompClient.subscribe('/smartgrid/districts', function(districts) {
            if(districts.body !== undefined && districts.body !== null && districts.body.length > 0) {
                console.log("Automatic update of the districts");
                $(".socket-district").html(districtsHtml(JSON.parse(districts.body)));
                seeListener();
            }
        });
        stompClient.subscribe('/smartgrid/centrals', function(centrals) {
            if(centrals.body !== undefined && centrals.body !== null && centrals.body.length > 0) {
                console.log("Automatic update of the centrals");
                $(".socket-central").html(centralsHtml(JSON.parse(centrals.body)));
                clock();
            }
        });
        stompClient.subscribe('/smartgrid/balance', function(balance) {
            if(balance.body !== undefined && balance.body !== null && balance.body.length > 0) {
                console.log("Automatic update of the city energy balance");
                $(".socket-city-energy-balance").html(balance.body + "W");
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