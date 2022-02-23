
startRequestAjax = setInterval(function () { reload(); }, 10000);

function sendMessage()
{

    var p = document.getElementById("msg");
    p = p.value
    console.log(p);
    var time = Date.now();
    console.log("3" + time);
    var sender = document.getElementById("snder").textContent;
    console.log("4" + sender);
    var receiver = document.getElementById("receiver").textContent;
        console.log("5" + receiver);
    receiver = receiver.slice(0, -1);
    console.log(receiver+"1")


//   (async () => {
//     const rawResponse = await fetch('http://localhost:9000/messages', {
//        method: 'POST',
//        headers: {'Content-Type' : 'application/json'},
//        body: JSON.stringify({
//        message: p,
//        sender: sender,
//        receiver: receiver,
//        time: parseInt(time),
//        })
//    });
//    console.log(body);
//
//    const content = await rawResponse.json();
//
//      console.log(content);
//    })();




let request = {
        method: 'POST',
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify({
                message: p,
                sender: sender,
                receiver: receiver,
                time: parseInt(time)
                })

    }
    console.log(request);
    fetch('http://localhost:9000/messages', request)
        .then(res => res.json())
        .then(data => {
            // traitement des données reçues
            console.log(data)
        })
        .catch(err => console.error(err))

        //document.getElementById("msg").value = "";
       setTimeout(reload, 300)



}

function reload(){
    window.location.reload();
}

//    var xhr = new XMLHttpRequest();
//    xhr.open("POST", url, true);
//    xhr.setRequestHeader('Content-Type', 'application/json');
//    xhr.send(JSON.stringify({
//        time: Date.now().getTime();,
//        messages: data,
//        phone: "342234553"
//     }));
//    var xhr = new XMLHttpRequest();
//    var url = "http://localhost:9000/messages"
//    xhr.open("POST", url, true);
//    xhr.setRequestHeader('Content-Type', 'application/json');

//};
