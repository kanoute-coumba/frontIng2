var stompClient = null;

$(function() {
    connect();

    $(".refresh-event").on("click", function() {
        $(this).addClass("rotate");
        send("/smartgrid/refresh", "refresh");
    });

    $(".see-event").on("click", function() {
        Swal.fire({
            title: 'Custom width, padding, color, background.',
            html: table(),
            width: 600,
            height: 600,
            padding: '20px',
            color: '#000000',
            background: '#FDFEFC',
            backdrop: 'rgba(157, 181, 153, 0.5)',
            confirmButtonColor: '#326019'
        });
    });
});

function table(buildings) {
    let head = '<thead><tr><th>id</th><th>adresse</th><th>nom</th><th>type</th><th>quartier</th></tr></thead>';
    let body = '<tbody>';
    for(let i = 0; i < 10; i++) {
        body += '<tr><td>' + i + '</td><td>40 rue des Boulets, Paris</td><td>Immeuble A</td><td><i class="fi fi-rr-building"></i></td><td>1</td></tr>';;
        body += '<tr><td>' + i + '</td><td>25 rue Cambronne, Paris</td><td>Maison C</td><td><i class="fi fi-rr-home"></i></i></td><td>1</td></tr>';;
    }
    body += '</tbody>';
    return '<table>' + head + body + '</table>';
}

function connect() {
    var socket = new SockJS('/citizens');
    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function() {
        stompClient.subscribe('/smartgrid/districts', function(districts) {
            console.log(JSON.parse(districts.body));
        });
        stompClient.subscribe('/smartgrid/refresh', function(response) {
            if(response.body === "true") {
                console.log("Ok");
                $(".refresh-event").removeClass("rotate");
            }
        });
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