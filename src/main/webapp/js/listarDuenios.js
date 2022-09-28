$(document).ready(function (){
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
        getlistarDuenios(false, "ASC");
    });

});

function getlistarDuenios(ordenar, orden){
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletDuenioListar",
        data: $.param({
            ordenar:ordenar,
            orden:orden
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !=false){
                mostrarDuenios(parsedResult);
            }else{
                console.log("Error recuperando datos de los duenios");
            }
        }
    });
}

function mostrarDuenios(listduenios){
    let contenido = "";
    $.each(listduenios, function (index, duenio){
        duenio = JSON.parse(duenio);
        contenido += '<tr><th scope="row">' +duenio.id_duenio + '</th>'+
        '<td>' + duenio.tipo_identificacion + '</td>' + 
        '<td>' + duenio.identificacion + '</td>' + 
        '<td>' + duenio.nombre + '</td>' + 
        '<td>' + duenio.apellidos + '</td>' + 
        '<td>' + duenio.correo_electronico + '</td>' + 
        '<td>' + duenio.ciudad + '</td>' + 
        '<td>' + duenio.barrio + '</td>' + 
        '<td>' + duenio.direccion + '</td>' + 
        '<td>' + duenio.telefono + '</td></tr>' ;        
    });
$("#duenios-tbody").html(contenido);
}


