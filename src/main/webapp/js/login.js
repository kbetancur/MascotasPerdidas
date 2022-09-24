$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
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
                
                $("#bienvenido").removeClass("d-none");
                $("#bienvenido").html("Prueba ");
                
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}


function registrarUsuario() {

    let correo_electronico = $("#usuarioreg").val();
    let contrasena = $("#contrasenareg").val();
    let contrasenaConfirmacion = $("#contrasenareg-rep").val();    
    let tipo_identificacion = $("#tipoidentificacion").val();
    let identificacion = $("#identificacion").val();
    let nombre = $("#nombre").val();
    let apellidos = $("#apellidos").val();
    let ciudad = $("#ciudad").val();
    let barrio = $("#barrio").val();
    let direccion = $("#direccion").val();
    let telefono = $("#telefono").val();

    if (contrasena == contrasenaConfirmacion) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletDuenioRegister",
            data: $.param({
                correo_electronico: correo_electronico,
                contrasena: contrasena,
                tipo_identificacion: tipo_identificacion,
                identificacion: identificacion,
                nombre: nombre,
                apellidos: apellidos,
                ciudad:ciudad,
                barrio: barrio,
                direccion:direccion,
                telefono:telefono
            }),

            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let correo_electronico = parsedResult['correo_electronico'];
                    document.location.href = "home.html?correo_electronico=" + correo_electronico;
                } else {

                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }



}




