
package controller;
import java.util.Map;

public interface IDuenioController {
    public String login(String correo_electronico, String contrasena);
    
    public String register(String tipo_identificacion,String identificacion, String nombre, String apellidos, String correo_electronico, String contrasena, String ciudad, String barrio, String direccion, String telefono);
    
    public String obtenerDatos(String correo_electronico);
    
    public String edit(String tipo_identificacion,String identificacion, String nombre, String apellidos, String correo_electronico,String ciudad, String barrio, String direccion, String telefono);
}
