
var correo_electronico = new URL (location.href).searchParams.get("correo_electronico");
console.log("correo: " + correo_electronico);
var user;

//función para redireccionar a registro mascotas llevandole el correo del dueño
function redirectRegistroMascotas(){
    document.location.href = "registromascotas.html?correo_electronico=" + correo_electronico;
}



/*Script para validación de duenio, obtener datos del duenio y pintarlos en home en cada uno de los input*/

$(document).ready(function (){
    
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //llama la función getUsuario() que devuelve unos datos, después le llevo los valores a los input del form:
    getUsuario().then(function()
    {
        $("#mi-perfil-btn").attr("href", "profile.html?correo_electronico="+correo_electronico);
        $("#user-nombre").html(user.nombre + " " + user.apellidos);        
        $("#span-user").html(user.nombre + " " + user.apellidos);        
  
        
    });
    
    
});

//va al servlet y devuelve un objeto con los datos del usuario según el correo y los almacena en la var user
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



