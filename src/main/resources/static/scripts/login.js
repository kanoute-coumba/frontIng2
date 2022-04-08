var server = 'http://172.31.249.1:9000';
var serverFront = 'http://172.31.249.1:9001';

$(function() {
    $(".form-login").submit(function(e) {
        e.preventDefault();
        var login = $(this).find("#login");
        var url = "/usersName=" + login.val();
        console.log(url);
        $.ajax({
            type: "GET",
            url: server + url,
            success: function(data) {
                if(data.length != 1) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Erreur',
                        text: 'Nom d\'utilisateur incorrect',
                        backdrop: 'rgba(157, 181, 153, 0.5)',
                        confirmButtonColor: '#326019'
                    });
                } else {
                    window.location.href = serverFront + "/home?username=" + data[0].username;
                }
                console.log(data);
            }
        });
    });
});