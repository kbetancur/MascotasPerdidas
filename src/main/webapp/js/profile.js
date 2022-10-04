
var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
//console.log("correo: " + correo_electronico);
var user;
var tmpid_duenio;
var id_mascota;
var id_publicacion;


//función para redireccionar a registro mascotas llevandole el correo del dueño
function redirectRegistroMascotas(){
    document.location.href = "registromascotas.html?correo_electronico=" + correo_electronico;
}



/*Script para validación de duenio, obtener datos del duenio y pintarlos en home en cada uno de los input*/

$(document).ready(function (){
    
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
        
        //Al hacer clic en el botón actualizar llama la función actualizarUsuario
        $("#form-edituser").submit(function (event) {
            event.preventDefault();
            actualizarUsuario();
        });
    });
    
    //llama la función getUsuario() que devuelve unos datos, después le llevo los valores a los input del form:
    getUsuario().then(function()
    {
        
        $("#mi-perfil-btn").attr("href", "profile.html?correo_electronico="+correo_electronico);
        
        //para asignar al input oculto de id_duenio
        document.getElementById("input-id-duenio").setAttribute('value',user.id_duenio);   
        tmpid_duenio = $("#input-id-duenio").val();
        //console.log("id en getUsuario" + tmpid_duenio);
        
        //para asignar a la tabla de detalles de usuario
        $("#user-nombre").html(user.nombre + " " + user.apellidos);
        $("#span-nombre").html(user.nombre);
        $("#span-apellidos").html(user.apellidos);
        $("#span-correoelectronico").html(user.correo_electronico);
        $("#span-telefono").html(user.telefono);
        $("#span-identificacion").html(user.identificacion);
        $("#span-ciudad").html(user.ciudad);
        
        //para asignar a los campos de editar
        document.getElementById("input-correo").setAttribute('value',user.correo_electronico);
        document.getElementById("input-nombre").setAttribute('value',user.nombre);
        document.getElementById("input-apellidos").setAttribute('value',user.apellidos);
        document.getElementById("select-tipoidentificacion").value = user.tipo_identificacion;
        document.getElementById("input-identificacion").setAttribute('value',user.identificacion);
        document.getElementById("input-ciudad").setAttribute('value',user.ciudad);
        document.getElementById("input-barrio").setAttribute('value',user.barrio);
        document.getElementById("input-direccion").setAttribute('value',user.direccion);
        document.getElementById("input-telefono").setAttribute('value',user.telefono);
 

        //para visualizar las mascotas
         getlistarMisMascotas(false, "ASC", tmpid_duenio);
        
        //Para visualizar mis publicaciones
        getlistarMisPublicaciones(tmpid_duenio);
        
    });
    
    
    
    
    
});

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




function actualizarUsuario() {

    let correo_electronico = $("#input-correo").val();
    //let contrasena = $("#contrasenareg").val();
    //let contrasenaConfirmacion = $("#contrasenareg-rep").val();
    let tipo_identificacion = $("#select-tipoidentificacion").val();     
    let identificacion = $("#input-identificacion").val();    
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

                if (parsedResult !== false) {
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

//función para ir al servlet de visualizar mis mascotas
function getlistarMisMascotas(ordenar, orden, id_duenio){
    
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletListarMascotasxDuenio",
        data: $.param({
            ordenar:ordenar,
            orden:orden,
            id_duenio: id_duenio
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !==false){
                mostrarMisMascotas(parsedResult);
            }else{
                console.log("Error recuperando datos de las mascotas");
            }
        }
    });
}

function mostrarMisMascotas(listmismascotas){
    let contenido = "";
    $.each(listmismascotas, function (index, mascota){
        mascota = JSON.parse(mascota);
        contenido += '<tr><th scope="row">' +mascota.id_mascota + '</th>'+        
        '<td>' + mascota.nombre + '</td>' + 
        '<td>' + mascota.especie  + '</td>' + 
        '<td>' + mascota.raza  + '</td>' + 
        '<td>' + mascota.anio_nacimiento  + '</td>' + 
        '<td>' + mascota.color  + '</td>' + 
        '<td>' + mascota.estado  + '</td>'+
        '<td><button class ="btn btn-success" onclick="realizarPublicacion(' + mascota.id_mascota + ')">Publicación</button> </td>'+
        '<td><button class ="btn btn-success" onclick="actualizarMascota(' + mascota.id_mascota + ')">Editar</button> </td></tr>';        
    });
    $("#mascotas-tbody").html(contenido);
}

function realizarPublicacion(id_mascota){
    document.location.href = "registropublicacion.html?correo_electronico=" + correo_electronico+"&"+"id_mascota="+id_mascota;
}

function actualizarMascota(id_mascota){
    document.location.href = "actualizarmascota.html?correo_electronico=" + correo_electronico+"&"+"id_mascota="+id_mascota;
}



//función para ir al servlet de visualizar mis publicaciones
function getlistarMisPublicaciones(id_duenio){
    
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletVerMisPublicaciones",
        data: $.param({            
            id_duenio: id_duenio
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !==false){
                mostrarMisPublicaciones(parsedResult);
            }else{
                console.log("Error recuperando datos de las publicaciones");
            }
        }
    });
}

function mostrarMisPublicaciones(listmispublicaciones){
    let contenido = "";
    $.each(listmispublicaciones, function (index, publicacion){
        publicacion = JSON.parse(publicacion);
        
        contenido += '<tr><th scope="row">' +publicacion.id_publicacion + '</th>'+        
        '<td>' + publicacion.id_mascota + '</td>' + 
        '<td>' + publicacion.nombre_mascota  + '</td>' + 
        '<td>' + publicacion.estado  + '</td>' + 
        '<td>' + publicacion.fecha_publicacion  + '</td>' + 
        '<td>' + publicacion.fecha_perdida  + '</td>' + 
        '<td>' + publicacion.descripcion  + '</td>' +         
        '<td><button class ="btn btn-success" onclick="editarPublicacion(' + publicacion.id_duenio +','+publicacion.id_mascota+','+publicacion.id_publicacion+ ')">Editar</button> </td></tr>';
              
    });
    $("#publicaciones-tbody").html(contenido);
}

function editarPublicacion(id_duenio, id_mascota, id_publicacion){
    document.location.href = "editarpublicacion.html?correo_electronico=" + correo_electronico+"&"+"id_duenio="+id_duenio+"&"+"id_mascota="+id_mascota+"&"+"id_publicacion="+id_publicacion;
}