
package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson; /*para la conexión web*/
import beans.*;
import connection.DBConnection;
import java.util.ArrayList;
import java.util.List;


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
    
    
    @Override
    public String obtenerDatos (String correo_electronico)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "Select * from tbl_duenio where correo_electronico = '"+correo_electronico+"'";
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_duenio = rs.getInt("id_duenio");
                String contrasena = rs.getString("contrasena");
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
    
/*--------------------------------------------
    Editar usuario
 ---------------------------------------------*/    
    
    @Override
    public String edit(String tipo_identificacion,String identificacion, String nombre, String apellidos,String correo_electronico, String ciudad, String barrio, String direccion, String telefono)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();        
        
        String sql = "Update tbl_duenio set tipo_identificacion = '"+tipo_identificacion+"', identificacion='"+identificacion+"',nombre='"+nombre+"', apellidos='"+apellidos+"', ciudad='"+ciudad+"',barrio='"+barrio+"',direccion='"+direccion+"',telefono='"+telefono+"' where correo_electronico = '"+correo_electronico+"'";
        try {
            
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            Duenio duenio = new Duenio (tipo_identificacion, identificacion, nombre, apellidos, correo_electronico,ciudad, barrio, direccion, telefono);
            st.close();
            
            return gson.toJson(duenio);            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
            
        }
        return "false";
        
    }
    
 /*--------------------------------------------
    listar todos los usuarios 
 ---------------------------------------------*/      
@Override
    public String listar(boolean ordenar, String orden)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "Select * from tbl_duenio";
        
        if (ordenar == true){
            sql += " order by nombre " + orden;
        }
        
        List<String> listduenios = new ArrayList<String>();
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_duenio = rs.getInt("id_duenio");
                String correo_electronico = rs.getString("correo_electronico");
                String contrasena = rs.getString("contrasena");
                String tipo_identificacion = rs.getString("tipo_identificacion");
                String identificacion = rs.getString("identificacion");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");                
                String ciudad = rs.getString("ciudad");
                String barrio = rs.getString("barrio");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                
                Duenio duenio = new Duenio (id_duenio, tipo_identificacion, identificacion, nombre, apellidos, correo_electronico, contrasena, ciudad, barrio, direccion, telefono);
                listduenios.add(gson.toJson(duenio));
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return gson.toJson(listduenios);
        
    }    
    
}
