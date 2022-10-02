var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
var id_mascota = new URL (location.href).searchParams.get("id_mascota");
var mascota;


$(document).ready(function (){
    var fechapublicacion = new Date();
    var fechapublicacionformat = fechapublicacion.getFullYear()+"-"+(fechapublicacion.getMonth()+1)+"-"+ fechapublicacion.getDate();
    document.getElementById("input-fechap").setAttribute('value',fechapublicacionformat);
    
    $("#form-registerm").submit(function (event) {
        event.preventDefault();
        registrarPublicacion();
    });
    
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //llama la función getDatosMascota() que devuelve un list con los datos de la mascota, después le llevo los valores a los input del form:
    getDatosMascota().then(function()
    {
        $("#mi-perfil-btn").attr("href", "profile.html?correo_electronico="+correo_electronico);
  
        document.getElementById("input-id_mascota").setAttribute('value',mascota.id_mascota);
        document.getElementById("input-nombre_mascota").setAttribute('value',mascota.nombre);
        document.getElementById("input-especie").setAttribute('value',mascota.especie);
        document.getElementById("input-raza").setAttribute('value',mascota.raza);
        document.getElementById("input-anio_nacimiento").setAttribute('value',mascota.anio_nacimiento);
        document.getElementById("input-color").setAttribute('value',mascota.color);
        
        document.getElementById("input-id_duenio").setAttribute('value',mascota.id_duenio);
        document.getElementById("input-nombreduenio").setAttribute('value',mascota.nombres_duenio);
        
  
        
    });
    
    
});


//va al servlet y devuelve un objeto con los datos del usuario según el correo y los almacena en la var user
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

//Registrar una publicación
function registrarPublicacion() {
    let id_mascota = $("#input-id_mascota").val();
    let fecha_publicacion = $("#input-fechap").val();
    let fecha_perdida = $("#input-fechaper").val();
    let descripcion = $("#input-descripcion").val();
    let comentarios = "";   
   

    if (id_mascota !=="") {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletRegistroPublicacion",
            data: $.param({
                id_mascota:id_mascota,
                fecha_publicacion: fecha_publicacion,
                fecha_perdida: fecha_perdida,
                descripcion: descripcion,
                comentarios: comentarios
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let id_mascota = parsedResult['id_mascota'];

                    swal(
                        {
                            title: "Registro Publicación",
                            text: "Los datos de su publicación han sido guardados con éxito!",
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
                    $("#registerp-error").removeClass("d-none");
                    $("#registerp-error").html("Error en el registro de la publicación");
                }
            }
        });
    } else {
        $("#registerp-error").removeClass("d-none");
        $("#registerp-error").html("El id_mascota no debe estar vacío");
    }
}