var v1 = document.getElementById("building");
v1.addEventListener('change', function () {
    console.log(v1.options[v1.options.selectedIndex].label);
    var building = v1.options[v1.options.selectedIndex].label;
    $.ajax({
        url: 'http://172.31.249.1:9000/architecture/floors_of/' + building,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#floors")[0].innerHTML = "";
            for (let i = 0; i < data.length; i++) {
                $("#floors")[0].innerHTML += '<option value="' + data[i].name_floor + '">'+ data[i].name_floor + '</option>";'
            }
        }
    });
});

var v2 = document.getElementById("floors");
v2.addEventListener('change', function () {
    console.log(v2.options[v2.options.selectedIndex].label);
    var floors = v2.options[v2.options.selectedIndex].label;
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

