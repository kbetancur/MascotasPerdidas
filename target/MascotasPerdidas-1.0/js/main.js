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
        getDatosUsuario(false,"ASC");     
        
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


