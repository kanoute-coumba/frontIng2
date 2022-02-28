var v2 = document.getElementById("floors");
v2.addEventListener('change', function () {
    var floors = v2.options[v2.options.selectedIndex].label;
    console.log(floors);
    $.ajax({
        url: 'http://172.31.249.1:9000/architecture/spaces_of_floor/' + floors,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#spaces")[0].innerHTML = "";
            for (let i = 0; i < data.length; i++) {
                $("#spaces")[0].innerHTML += '<option value="' + data[i].name_space + '">'+ data[i].name_space + '</option>";'
            }
        }
    });
});

