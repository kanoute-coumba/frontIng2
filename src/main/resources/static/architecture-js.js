var elt = document.getElementById("building");
elt.addEventListener('change', function () {
    console.log(elt.options[elt.options.selectedIndex].label);
    var building = elt.options[elt.options.selectedIndex].label;
    $.ajax({
        url: 'http://172.31.249.1:9000/architecture/floors_of/' + building,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#floors")[0].innerHTML = "";
            for (let i = 0; i < data.length; i++) {
                $("#floors")[0].innerHTML += '<option value="' + data[i].name_floor + '">Etage '+ data[i].name_floor + '</option>";'
            }
        }
    });
});

