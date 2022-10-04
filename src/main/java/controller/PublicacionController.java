package controller;


import beans.Mascota;
import beans.Publicacion;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import connection.DBConnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PublicacionController implements IPublicacionController {

    
/*--------------------------------------------
    Registrar publicacion
 ---------------------------------------------*/    
    
    @Override
    public String registrop(int id_mascota,Date fecha_publicacion, Date fecha_perdida, String descripcion,  String comentarios) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "Insert into tbl_publicaciones (id_mascota, fecha_publicacion, fecha_perdida, descripcion, comentarios) VALUES (" + id_mascota +",'"+ fecha_publicacion + "','" + fecha_perdida + "','" + descripcion + "', '" + comentarios + "')";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Publicacion publicacion = new Publicacion(id_mascota, fecha_publicacion, fecha_perdida, descripcion, comentarios);
            st.close();
            return gson.toJson(publicacion);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
    
/*--------------------------------------------
    listar todos las publicaciones 
 ---------------------------------------------*/      
@Override
    public String listarp()
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "SELECT p.id_publicacion, p.id_mascota,p.fecha_publicacion,p.fecha_perdida,p.descripcion,  "
                + "p.comentarios,m.nombre AS 'nombre_mascota' ,m.especie,"
                + " m.raza," + "m.anio_nacimiento, m.color, m.estado,m.id_duenio "
                +"FROM tbl_publicaciones AS p INNER JOIN tbl_mascotas AS m ON m.id_mascota = p.id_mascota "
                + "ORDER BY fecha_publicacion desc";
        
        List<String> listpublicaciones = new ArrayList<String>();
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_duenio = rs.getInt("id_duenio");
                int id_publicacion = rs.getInt("id_publicacion");
                int id_mascota = rs.getInt("id_mascota");
                Date fecha_publicacion = rs.getDate("fecha_publicacion");
                Date fecha_perdida = rs.getDate("fecha_perdida");
                String descripcion = rs.getString("descripcion");
                String comentarios = rs.getString("comentarios");
                String nombre_mascota = rs.getString("nombre_mascota");
                String especie = rs.getString("especie");
                String raza = rs.getString("raza");
                int anio_nacimiento = rs.getInt("anio_nacimiento");
                String color = rs.getString("color");
                String estado = rs.getString("estado"); 
                Publicacion publicacion = new Publicacion (id_publicacion, id_mascota, id_duenio,fecha_publicacion, fecha_perdida, descripcion,comentarios,nombre_mascota, especie, raza, anio_nacimiento, color, estado);
                listpublicaciones.add(gson.toJson(publicacion));
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return gson.toJson(listpublicaciones);
        
    }  
    

/*--------------------------------------------
    listar todas las publicaciones x duenio
 ---------------------------------------------*/      
@Override
    public String vermisPublicaciones(int id_duenioparam)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "SELECT p.id_publicacion, p.id_mascota, m.nombre AS 'nombre_mascota', m.raza, "
                + "m.color, m.especie,m.anio_nacimiento,m.estado,m.id_duenio,p.fecha_publicacion,"
                + "p.fecha_perdida,p.descripcion, p.comentarios "
                +"FROM tbl_publicaciones AS p INNER JOIN tbl_mascotas AS m ON m.id_mascota = p.id_mascota "
                +"WHERE m.id_duenio="+id_duenioparam+ 
                " ORDER BY fecha_publicacion desc";
        
        List<String> listmispublicaciones = new ArrayList<String>();
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_publicacion = rs.getInt("id_publicacion");
                int id_mascota = rs.getInt("id_mascota");
                String nombre_mascota = rs.getString("nombre_mascota");
                String raza = rs.getString("raza");
                String color = rs.getString("color");
                 String especie = rs.getString("especie");
                 int anio_nacimiento = rs.getInt("anio_nacimiento");
                String estado = rs.getString("estado");
                int id_duenio = rs.getInt("id_duenio");
                Date fecha_publicacion = rs.getDate("fecha_publicacion");
                Date fecha_perdida = rs.getDate("fecha_perdida");
                String descripcion = rs.getString("descripcion");
                String comentarios = rs.getString("comentarios");
                
                Publicacion publicacion = new Publicacion (id_publicacion, id_mascota, id_duenio, fecha_publicacion,  fecha_perdida,  descripcion,  comentarios,  nombre_mascota,  especie,  raza,  anio_nacimiento,  color,  estado);
                listmispublicaciones.add(gson.toJson(publicacion));
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return gson.toJson(listmispublicaciones);
        
    }      
    
/*--------------------------------------------
    obtener datos de una publicación
 ---------------------------------------------*/      
@Override
    public String obtenerDatosPublicacion(int id_publicacionparam)
    {
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        DBConnection conn = new DBConnection();
        String sql = "SELECT p.id_publicacion, p.id_mascota, m.nombre AS 'nombre_mascota', m.raza, "
                + "m.color, m.especie,m.anio_nacimiento,m.estado,m.id_duenio,p.fecha_publicacion,"
                + "p.fecha_perdida,p.descripcion, p.comentarios "
                +"FROM tbl_publicaciones AS p INNER JOIN tbl_mascotas AS m ON m.id_mascota = p.id_mascota "
                +"WHERE p.id_publicacion="+id_publicacionparam+ 
                " ORDER BY fecha_publicacion desc";
       
       
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                 int id_publicacion= rs.getInt("id_publicacion");
                int id_mascota = rs.getInt("id_mascota");
                int id_duenio = rs.getInt("id_duenio");                
                String nombre_mascota = rs.getString("nombre_mascota");
                String especie = rs.getString("especie");
                String raza = rs.getString("raza");
                int anio_nacimiento = rs.getInt("anio_nacimiento");
                String color = rs.getString("color");
                String estado = rs.getString("estado");       
                Date fecha_publicacion = rs.getDate("fecha_publicacion");
                //System.out.println("Fecha Publicación: "+fecha_publicacion);
                Date fecha_perdida = rs.getDate("fecha_perdida");
                //System.out.println("Fecha Perdida: "+fecha_perdida);
                String descripcion = rs.getString("descripcion");
                String comentarios = rs.getString("comentarios");

                
               Publicacion publicacion = new Publicacion (id_publicacion, id_mascota, id_duenio, fecha_publicacion,  fecha_perdida,  descripcion,  comentarios,  nombre_mascota,  especie,  raza,  anio_nacimiento,  color,  estado);
                //System.out.println("objeto "+publicacion); 
                //System.out.println("JSON: " + gson.toJson(publicacion));
               return gson.toJson(publicacion);   
               
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return "false";
        
    }      
    
/*---------------------------------------
    Actualiza una publicacion
 ----------------------------------------*/    
    
    @Override
    public String actualizarPublicacion(int id_publicacion,int id_mascota, Date fecha_publicacion, Date fecha_perdida, String descripcion)
    {
        String comentarios = "";
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();        
        
        String sql = "Update tbl_publicaciones   set id_mascota="+id_mascota+", fecha_publicacion = '"+fecha_publicacion+"' , fecha_perdida='"+fecha_perdida+"', descripcion='"+descripcion+"' where id_publicacion="+id_publicacion;
        try {
            
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            Publicacion publicacion = new Publicacion (id_mascota, fecha_publicacion, fecha_perdida, descripcion, comentarios);
            st.close();
            
            return gson.toJson(publicacion);            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
            
        }
        return "false";
        
    }    
        
    
    
}
    

