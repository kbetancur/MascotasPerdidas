var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
var id_mascota = new URL (location.href).searchParams.get("id_mascota");
var id_duenio = new URL (location.href).searchParams.get("id_duenio");
var id_publicacionparam = new URL (location.href).searchParams.get("id_publicacion");






$(document).ready(function (){   
    /*var fechapublicacion = new Date();
    var fechapublicacionformat = fechapublicacion.getFullYear()+"-"+(fechapublicacion.getMonth()+1)+"-"+ fechapublicacion.getDate();
    document.getElementById("input-fechap").setAttribute('value',fechapublicacionformat);*/
    
    $("#form-editarp").submit(function (event) {
        event.preventDefault();
        actualizarPublicacion();
    });

    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    
    
    //llama la función getDatosPublicacion() que devuelve un objeto con los datos de la publicacion, después le llevo los valores a los input del form:
    getDatosPublicacion().then(function() {
        document.getElementById("input-id_publicacion").setAttribute('value',publicacion.id_publicacion);
        document.getElementById("input-id_duenio").setAttribute('value',publicacion.id_duenio);
        document.getElementById("input-id_mascota").setAttribute('value',publicacion.id_mascota);
        document.getElementById("input-nombre_mascota").setAttribute('value',publicacion.nombre_mascota);
        document.getElementById("input-especie").setAttribute('value',publicacion.especie);
        document.getElementById("input-raza").setAttribute('value',publicacion.raza);
        document.getElementById("input-anio_nacimiento").setAttribute('value',publicacion.anio_nacimiento);
        document.getElementById("input-color").setAttribute('value',publicacion.color);        
        document.getElementById("select-iestado").value = publicacion.estado;
        document.getElementById("input-fechap").setAttribute('value',publicacion.fecha_publicacion);
        document.getElementById("input-fechaper").setAttribute('value',publicacion.fecha_perdida);
        document.getElementById("textarea-descripcion").value = publicacion.descripcion; 
        
    });
    
    
});




//va al servlet y devuelve un objeto con los datos de la publicación según el id 
async function getDatosPublicacion(){
    
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletGetDatosPublicacion",
        data: $.param({
            id_publicacion:id_publicacionparam
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !==false){
                publicacion = parsedResult;
            }else{
                console.log("Error recuperando datos de la publicación");
            }
        }
    });
}



//al hacer clic en el botón de actualizar publicación 
function actualizarPublicacion() {
    
    let id_mascota = $("#input-id_mascota").val();
    //console.log("id_duenio"+id_duenio);
    let id_publicacion = $("#input-id_publicacion").val();
    let fecha_publicacion = $("#input-fechap").val();
    let fecha_perdida = $("#input-fechaper").val();  
    let descripcion = $("#textarea-descripcion").val();  
  
    
    if (fecha_perdida !== "") {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletActualizarPublicacion",
            data: $.param({        
                id_publicacion: id_publicacion,
                id_mascota: id_mascota,
                fecha_publicacion: fecha_publicacion,
                fecha_perdida: fecha_perdida,
                descripcion: descripcion
            }),

            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult !== false) {
                    $("#edit-error").addClass("d-none");
                    let id_publicacion = parsedResult['id_publicacion'];
                    swal(
                        {
                            title: "Edición de Publicación",
                            text: "Su publicación fue actualizada exitosamente!",
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
                    $("#edit-error").html("Error en la actualización de la publicación");
                }
            }
        });
    } else {
        $("#edit-error").removeClass("d-none");
        $("#edit-error").html("Debes ingrear una fecha de perdida");
    }



}