var v1 = document.getElementById("building");
v1.addEventListener('change', function () {
    var building = v1.options[v1.options.selectedIndex].label;
    console.log(building);
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

