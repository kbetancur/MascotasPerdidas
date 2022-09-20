
package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson; /*para la conexión web*/
import beans.*;
import connection.DBConnection;


public class DuenioController implements IDuenioController {
    
     
    
    @Override
    public String login(String correo_electronico, String contrasena)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "Select * from tbl_duenio where correo_electronico='"+correo_electronico
                +"'and contrasena='" +contrasena+"'";
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_duenio = rs.getInt("id_duenio");
                String tipo_identificacion = rs.getString("tipo_identificacion");
                String identificacion = rs.getString("identificacion");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");                
                String ciudad = rs.getString("ciudad");
                String barrio = rs.getString("barrio");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                
                Duenio duenio = new Duenio (id_duenio, tipo_identificacion, identificacion, nombre, apellidos, correo_electronico, contrasena, ciudad, barrio, direccion, telefono);
                return gson.toJson(duenio);                

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
            
        }
        return "false";
        
    }
    
    
    @Override
    public String register(String tipo_identificacion,String identificacion, String nombre, String apellidos, String correo_electronico, String contrasena, String ciudad, String barrio, String direccion, String telefono)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        //String sql = "Insert into tbl_duenio values('"+tipo_identificacion+"', '"+identificacion+"', '"+nombre+"', '"+apellidos+"', '"+correo_electronico+"', '"+contrasena+"',+'"+ciudad+"', '"+barrio+"', '"+direccion+"','"+telefono+"')";
        String sql = "Insert into tbl_duenio (tipo_identificacion, identificacion,nombre, apellidos, correo_electronico, contrasena, \n" +
"ciudad, barrio, direccion, telefono) values('"+tipo_identificacion+"', '"+identificacion+"', '"+nombre+"', '"+apellidos+"', '"+correo_electronico+"', '"+contrasena+"',+'"+ciudad+"', '"+barrio+"', '"+direccion+"','"+telefono+"')";
        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            Duenio duenio = new Duenio (tipo_identificacion, identificacion, nombre, apellidos,correo_electronico, contrasena, ciudad, barrio, direccion, telefono);
            st.close();
            
            return gson.toJson(duenio);            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
            
        }
        return "false";
        
    }
    
}
