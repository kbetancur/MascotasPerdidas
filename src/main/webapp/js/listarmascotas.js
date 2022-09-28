$(document).ready(function (){
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
        getlistarMascotas(false, "ASC");
    });

});

//
function getlistarMascotas(ordenar, orden){
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletListarMascotas",
        data: $.param({
            ordenar:ordenar,
            orden:orden
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !=false){
                mostrarMascotas(parsedResult);
            }else{
                console.log("Error recuperando datos de las mascotas");
            }
        }
    });
}

function mostrarMascotas(listmascotas){
    let contenido = "";
    $.each(listmascotas, function (index, mascota){
        mascota = JSON.parse(mascota);
        contenido += '<tr><th scope="row">' +mascota.id_mascota + '</th>'+
        '<td>' + mascota.id_duenio + '</td>' + 
        '<td>' + mascota.nombre + '</td>' + 
        '<td>' + mascota.especie  + '</td>' + 
        '<td>' + mascota.raza  + '</td>' + 
        '<td>' + mascota.anio_nacimiento  + '</td>' + 
        '<td>' + mascota.color  + '</td>' + 
        '<td>' + mascota.estado  + '</td></tr>';        
    });
$("#mascotas-tbody").html(contenido);
}


