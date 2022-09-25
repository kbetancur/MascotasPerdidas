$(document).ready(function () {

    $("#form-registerm").submit(function (event) {
        event.preventDefault();
        registrarMascota();
    });
});
function registrarMascota() {
    let nombre = $("#nombre").val();
    let especie = $("#especie").val();
    let raza = $("#raza").val();
    let anio_nacimiento = $("#anio_nacimiento").val();
    let color = $("#color").val();
    let estado = $("#iestado").val();
    console.log("Estado valor: "+estado);
    //console.log("la longitud de nombre es: " + nombre.length);

    if (nombre.length >= 3) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletRegistroMascota",
            data: $.param({
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

