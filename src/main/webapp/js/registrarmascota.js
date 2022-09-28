var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
console.log("correo: " + correo_electronico);

$(document).ready(function (){
      $("#form-registerm").submit(function (event) {
        event.preventDefault();
        registrarMascota();
    });
    
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();        
        
        //llama la función getUsuario() que devuelve unos datos, después le llevo los valores a los input del form:
        getUsuario().then(function()
        {
            document.getElementById("input-id_duenio").setAttribute('value',user.id_duenio);
            document.getElementById("input-nombreduenio").setAttribute('value',user.nombre+" " +user.apellidos);


        });
    });
    
    

});


function registrarMascota() {
    let id_duenio = $("#input-id_duenio").val();
    let nombre = $("#nombre").val();
    let especie = $("#especie").val();
    let raza = $("#raza").val();
    let anio_nacimiento = $("#anio_nacimiento").val();
    let color = $("#color").val();
    let estado = $("#iestado").val();
    //console.log("Estado valor: "+estado);
    //console.log("la longitud de nombre es: " + nombre.length);

    if (nombre.length >= 3) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletRegistroMascota",
            data: $.param({
                id_duenio:id_duenio,
                nombre: nombre,
                especie: especie,
                raza: raza,
                anio_nacimiento: anio_nacimiento,
                color: color,
                estado: estado
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let nombre = parsedResult['nombre'];
                    /**/
                    //window.alert("Los datos de su mascota han sido registrados con éxito!");
                    swal(
                        {
                            title: "Registro Mascota",
                            text: "Los datos de su mascota han sido registrados con éxito!",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonClass: "btn-primary",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false,
                            allowOutsideClick: false
                        },
                        function()
                        {
                            document.location.href = "home.html?nombre=" + nombre;
                        }
                    );
                    
                     


                    //document.location.href = "home.html?nombre=" + nombre;
                } else {
                    $("#registerm-error").removeClass("d-none");
                    $("#registerm-error").html("Error en el registro de la mascota");
                }
            }
        });
    } else {
        $("#registerm-error").removeClass("d-none");
        $("#registerm-error").html("El nombre de la mascota debe tener al menos 3 caracteres");
    }
}


/*Script para validación de duenio, obtener datos del duenio y muestra en el input nombre*/

//va al servlet y devuelve un objeto con los datos del usuario según el correo y los almacena en la var user
async function getUsuario(){
    
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletDuenioGet",
        data: $.param({
            correo_electronico:correo_electronico
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