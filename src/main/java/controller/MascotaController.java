package controller;

import beans.Duenio;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Mascota;
import connection.DBConnection;
import java.util.ArrayList;
import java.util.List;

public class MascotaController implements IMascotaController {

 
    @Override
    public String registrom(int id_duenio, String nombre, String especie, String raza, int anio_nacimiento, String color, String estado) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "Insert into tbl_mascotas (id_duenio, nombre, especie, raza, anio_nacimiento, color, estado) VALUES (" + id_duenio +",'"+ nombre + "','" + especie + "','" + raza + "'," + anio_nacimiento +", '" + color + "','" + estado +"')";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Mascota mascota = new Mascota(id_duenio, nombre, especie, raza, anio_nacimiento, color, estado);
            st.close();
            return gson.toJson(mascota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
    
    
/*--------------------------------------------
    listar todos las mascotas 
 ---------------------------------------------*/      
@Override
    public String listar(boolean ordenar, String orden)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "Select * from tbl_mascotas";
        
        if (ordenar == true){
            sql += " order by nombre " + orden;
        }
        
        List<String> listmascotas = new ArrayList<String>();
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_mascota = rs.getInt("id_mascota");
                int id_duenio = rs.getInt("id_duenio");
                String nombre = rs.getString("nombre");
                String especie = rs.getString("especie");
                String raza = rs.getString("raza");
                int anio_nacimiento = rs.getInt("anio_nacimiento");
                String color = rs.getString("color");
                String estado = rs.getString("estado");
                

                
                Mascota mascota = new Mascota (id_mascota, id_duenio, nombre, especie, raza, anio_nacimiento, color, estado);
                listmascotas.add(gson.toJson(mascota));
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return gson.toJson(listmascotas);
        
    }    
    
    
/*--------------------------------------------
    listar todos las mascotas 
 ---------------------------------------------*/      
@Override
    public String vermismascotas(boolean ordenar, String orden, int id_duenio_param)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "Select * from tbl_mascotas where id_duenio = "+ id_duenio_param;
        
        if (ordenar == true){
            sql += " order by nombre " + orden;
        }
        
        List<String> listmismascotas = new ArrayList<String>();
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_mascota = rs.getInt("id_mascota");
                int id_duenio = rs.getInt("id_duenio");
                String nombre = rs.getString("nombre");
                String especie = rs.getString("especie");
                String raza = rs.getString("raza");
                int anio_nacimiento = rs.getInt("anio_nacimiento");
                String color = rs.getString("color");
                String estado = rs.getString("estado");
                

                
                Mascota mascota = new Mascota (id_mascota, id_duenio, nombre, especie, raza, anio_nacimiento, color, estado);
                listmismascotas.add(gson.toJson(mascota));
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return gson.toJson(listmismascotas);
        
    }      
    
    
/*--------------------------------------------
    obtener datos de una mascota
 ---------------------------------------------*/      
@Override
    public String obtenerDatosMascota(int id_mascotaparam)
    {
        Gson gson = new Gson();        
        DBConnection conn = new DBConnection();
        String sql = "Select m.id_mascota, m.id_duenio,concat(d.nombre, ' ',  d.apellidos) AS 'nombres_duenio' , m.nombre,m.especie,m.raza, m.anio_nacimiento, m.color, m.estado FROM tbl_mascotas AS m INNER JOIN tbl_duenio AS d ON d.id_duenio = m.id_duenio WHERE m.id_mascota = " + id_mascotaparam;
       
       
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int id_mascota = rs.getInt("id_mascota");
                int id_duenio = rs.getInt("id_duenio");
                String nombres_duenio = rs.getString("nombres_duenio");
                String nombre = rs.getString("nombre");
                String especie = rs.getString("especie");
                String raza = rs.getString("raza");
                int anio_nacimiento = rs.getInt("anio_nacimiento");
                String color = rs.getString("color");
                String estado = rs.getString("estado");               

                
                Mascota mascota = new Mascota (id_mascota, id_duenio, nombres_duenio,nombre, especie, raza, anio_nacimiento, color, estado);
                return gson.toJson(mascota);   
                           

            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conn.desconectar();
        }        
        return "false";
        
    }        
    
    
}
    
