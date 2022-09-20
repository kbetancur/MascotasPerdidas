
package controller;
import java.util.Map;

public interface IDuenioController {
    public String login(String correo_electronico, String contrasena);
    
    public String register(String tipo_identificacion,String identificacion, String nombre, String apellidos, String correo_electronico, String contrasena, String ciudad, String barrio, String direccion, String telefono);
    
}
