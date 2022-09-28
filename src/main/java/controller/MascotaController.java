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
    
    
}
    
