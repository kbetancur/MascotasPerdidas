
$(document).ready(function (){
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
        getlistarPublicaciones();
    });

});

//
function getlistarPublicaciones(){
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletVerPublicaciones",
        data: $.param({
            
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !==false){
                mostrarPublicaciones(parsedResult);
            }else{
                console.log("Error recuperando datos de las publicaciones");
            }
        }
    });
}

function mostrarPublicaciones(listpublicaciones){
    let contenido = "";
    $.each(listpublicaciones, function (index, publicacion){
        publicacion = JSON.parse(publicacion);
        contenido +=' <div class="col"> <div class="card"> <h3 class="card-header text-center text-uppercase">' 
         + publicacion.nombre_mascota+ '</h3>'+'<div class="card-body"><h4 class="card-title"> Perdida el '
        +publicacion.fecha_perdida+'</h4><p class="card-text">'+publicacion.descripcion+ 
        '</p></div>'+ 
        '<ul class="list-group list-group-flush">'+'<li class="list-group-item">Especie: '+publicacion.especie + '</li>'
        +'<li class="list-group-item">Raza: ' +publicacion.raza+'</li>'+
        '<li class="list-group-item">Color: '+ publicacion.color+'</li>'+
        '<li class="list-group-item">Año de Nacimiento: '+ publicacion.anio_nacimiento+'</li>'
        +' </ul>' + '<div class="d-grid gap-2 d-md-flex justify-content-md-end">'+
        '<button class ="btn btn-primary" onclick="verContacto(' + publicacion.id_publicacion +','+publicacion.id_duenio    + ')">Contacto</button></div>'
        +'<div class="card-footer text-muted">Fecha de Publicación: '+publicacion.fecha_publicacion+'</div>'+
        ' </div>' +' </div>';        
    });
    $("#mascotas-divpublicacion").html(contenido);
}


function verContacto(id_publicacion, id_duenio){
    document.location.href = "contactousuario.html?id_publicacion=" + id_publicacion+"&"+"id_duenio="+id_duenio;
}
