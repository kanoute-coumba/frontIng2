function loadTest() {
    $('#test tbody')[0].innerHTML = '';
    let data;
    $.ajax({
        dataType : "json",
        url : 'https://jsonplaceholder.typicode.com/posts',
        type : 'GET',
        crossDomain : true,
        success : function(msg) {
            console.log(msg);
            data = msg;
        }

    }).then(()=>{
        console.log(data);
        for(let i = 0; i < 10; i++) {
            $('#test tbody')[0].innerHTML += '<tr>' +
                '<td>' + data[i].id + '</td>' +
                '<td>' + data[i].title + '</td>' +
                '<td>' + data[i].body + '</td></tr>';
        }
    });
}

loadTest();