var id_duenioparam = new URL (location.href).searchParams.get("id_duenio");
var id_publicacionparam = new URL (location.href).searchParams.get("id_publicacion");
var usertemp;


/*Script para validación de duenio, obtener datos del duenio y pintarlos en cada uno de los input*/

$(document).ready(function (){
    
    $(function ()
    {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //llama la función getUsuario() que devuelve unos datos, después le llevo los valores a los input del form:
    getDatosxId().then(function()
    {
        document.getElementById("input-correo").setAttribute('value',usertemp.correo_electronico);
        document.getElementById("input-nombre").setAttribute('value',usertemp.nombre);
        document.getElementById("input-apellidos").setAttribute('value',usertemp.apellidos);
        document.getElementById("input-ciudad").setAttribute('value',usertemp.ciudad);
        document.getElementById("input-barrio").setAttribute('value',usertemp.barrio);
        document.getElementById("input-telefono").setAttribute('value',usertemp.telefono);      
  
        
    });
    
    
});

//va al servlet y devuelve un objeto con los datos del usuario según el correo y los almacena en la var user
async function getDatosxId(){
    console.log("idpara" + id_duenioparam);
    
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletDuenioGetxId",
        data: $.param({
            id_duenio:id_duenioparam
            
        }),
        
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult !==false){
                usertemp = parsedResult;
                console.log("usertemp: " + usertemp);
            }else{
                console.log("id_duenio : " + id_duenioparam);
                console.log("Error recuperando datos del usuario");
            }
        }
    });
}




