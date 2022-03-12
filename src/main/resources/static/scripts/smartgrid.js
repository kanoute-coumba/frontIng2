var stompClient = null;

$(function() {
    connect();

    $(".cursor").on("click", function() {
        Swal.fire({
            title: 'Custom width, padding, color, background.',
            width: 600,
            padding: '3em',
            color: '#716add',
            background: '#fff url(/images/trees.png)',
            backdrop: `
    rgba(0,0,123,0.4)
    url("/images/nyan-cat.gif")
    left top
    no-repeat
  `
        });
    });
});

function connect() {
    var socket = new SockJS('/citizens');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function() {
        stompClient.subscribe('/smartgrid/districts', function(districts) {
            console.log(JSON.parse(districts.body));
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