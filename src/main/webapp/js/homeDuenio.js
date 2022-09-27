//para editar usuario
$(document).ready(function () {

    $("#form-edituser").submit(function (event) {

        event.preventDefault();
        actualizarUsuario();
    });


});


function actualizarUsuario() {

    let correo_electronico = $("#input-correo").val();
    //let contrasena = $("#contrasenareg").val();
    //let contrasenaConfirmacion = $("#contrasenareg-rep").val();
    let tipo_identificacion = $("#select-tipoidentificacion").val();     
    let identificacion = $("#input-identificacion").val();
    console.log("identificación: "+identificacion);
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let ciudad = $("#input-ciudad").val();
    let barrio = $("#input-barrio").val();
    let direccion = $("#input-direccion").val();
    let telefono = $("#input-telefono").val();

    if (nombre !== "") {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletDuenioEdit",
            data: $.param({        
                correo_electronico: correo_electronico,
                tipo_identificacion: tipo_identificacion,
                identificacion: identificacion,
                nombre: nombre,
                apellidos: apellidos,
                ciudad: ciudad,
                barrio: barrio,
                direccion: direccion,
                telefono: telefono
            }),

            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#edit-error").addClass("d-none");
                    let correo_electronico = parsedResult['correo_electronico'];
                    swal(
                        {
                            title: "Edición de Usuario",
                            text: "Su usuario fue actualizado exitosamente!",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonClass: "btn-primary",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false,
                            allowOutsideClick: false
                        },
                        function()
                        {
                            document.location.href = "home.html?correo_electronico=" + correo_electronico;
                        }
                    );
                    

                    
                } else {

                    $("#edit-error").removeClass("d-none");
                    $("#edit-error").html("Error en la actualización del usuario");
                }
            }
        });
    } else {
        $("#edit-error").removeClass("d-none");
        $("#edit-error").html("El nombre no debe estar vacío");
    }



}



/*Script para validación de duenio, obtener datos del duenio y pintarlos en home*/

var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
var user;

$(document).ready(function (){
    
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    getUsuario().then(function()
    {
        $("#mi-perfil-btn").attr("href", "profile.html?correo_electronico="+correo_electronico);
        $("#user-nombre").html(user.nombre + " " + user.apellidos);
        document.getElementById("input-correo").setAttribute('value',user.correo_electronico);
        document.getElementById("input-nombre").setAttribute('value',user.nombre);
        document.getElementById("input-apellidos").setAttribute('value',user.apellidos);
        document.getElementById("select-tipoidentificacion").value = user.tipo_identificacion;
        document.getElementById("input-identificacion").setAttribute('value',user.identificacion);
        document.getElementById("input-ciudad").setAttribute('value',user.ciudad);
        document.getElementById("input-barrio").setAttribute('value',user.barrio);
        document.getElementById("input-direccion").setAttribute('value',user.direccion);
        document.getElementById("input-telefono").setAttribute('value',user.telefono);
        //getDatosUsuario(false,"ASC");     
        
    });
    
    
});

async function getUsuario(){
    
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletDuenioGet",
        data: $.param({
            correo_electronico:correo_electronico,
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !=false){
                user = parsedResult;
            }else{
                console.log("Error recuperando datos del usuario");
            }
        }
    });
}
    

function getDatosUsuario(correo_electronico){
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletDuenioGet",
        data: $.param({
            correo_electronico:correo_electronico,
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !=false){
                mostrarDatos(parsedResult);
            }else{
                console.log("Error recuperando datos del usuario");
            }
        }
    });
}

