var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
var id_mascota = new URL (location.href).searchParams.get("id_mascota");

$(document).ready(function (){   
    
    $("#form-actualizarm").submit(function (event) {
        event.preventDefault();
        actualizarMascota();
    });

    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //llama la función getDatosMascota() que devuelve un list con los datos de la mascota, después le llevo los valores a los input del form:
    getDatosMascota().then(function() {
        document.getElementById("input-id_duenio").setAttribute('value',mascota.id_duenio);
        document.getElementById("input-id_mascota").setAttribute('value',mascota.id_mascota);
        document.getElementById("nombre").setAttribute('value',mascota.nombre);
        document.getElementById("especie").setAttribute('value',mascota.especie);
        document.getElementById("raza").setAttribute('value',mascota.raza);
        document.getElementById("anio_nacimiento").setAttribute('value',mascota.anio_nacimiento);
        document.getElementById("color").setAttribute('value',mascota.color);        
        document.getElementById("iestado").value = mascota.estado;       
  
        
    });
    
    
});


//va al servlet y devuelve un objeto con los datos de la mascota según el id y los almacena en la var mascota
async function getDatosMascota(){
    
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletGetDatosMascota",
        data: $.param({
            id_mascota:id_mascota
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !==false){
                mascota = parsedResult;
            }else{
                console.log("Error recuperando datos de la mascota");
            }
        }
    });
}


//al hacer clic en el botón de actualizar mascota 
function actualizarMascota() {
    
    let id_duenio = $("#input-id_duenio").val();
    //console.log("id_duenio"+id_duenio);
    let id_mascota = $("#input-id_mascota").val();
    let estado = $("#iestado").val();     
    let nombre = $("#nombre").val();    
    let especie = $("#especie").val();
    let raza = $("#raza").val();
    let anio_nacimiento = $("#anio_nacimiento").val();
    let color = $("#color").val();
    
    if (nombre !== "") {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletActualizarMascota",
            data: $.param({        
                id_duenio: id_duenio,
                id_mascota: id_mascota,
                estado: estado,
                nombre: nombre,
                especie: especie,
                raza: raza,
                anio_nacimiento: anio_nacimiento,
                color: color
            }),

            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult !== false) {
                    $("#edit-error").addClass("d-none");
                    let id_mascota = parsedResult['id_mascota'];
                    swal(
                        {
                            title: "Edición de Mascota",
                            text: "Su mascota fue actualizada exitosamente!",
                            type: "success",
                            showCancelButton: false,
                            confirmButtonClass: "btn-primary",
                            confirmButtonText: "Ok",
                            closeOnConfirm: false,
                            allowOutsideClick: false
                        },
                        function()
                        {
                            document.location.href = "profile.html?correo_electronico=" + correo_electronico;
                        }
                    );
                    

                    
                } else {

                    $("#edit-error").removeClass("d-none");
                    $("#edit-error").html("Error en la actualización de la mascota");
                }
            }
        });
    } else {
        $("#edit-error").removeClass("d-none");
        $("#edit-error").html("El nombre no debe estar vacío");
    }



}