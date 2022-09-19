$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

   

});

function autenticarUsuario() {

    let correo_electronico = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletDuenioLogin",
        data: $.param({
            correo_electronico: correo_electronico,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let correo_electronico = parsedResult['correo_electronico'];
                document.location.href = "home.html?correo_electronico=" + correo_electronico;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}


