package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Mascota;
import connection.DBConnection;

public class MascotaController implements IMascotaController {

 
    @Override
    public String registrom( String nombre, String especie, String raza, int anio_nacimiento, String color, String estado) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "Insert into tbl_mascotas (nombre, especie, raza, anio_nacimiento, color, estado) VALUES ('"+ nombre + "','" + especie + "','" + raza + "'," + anio_nacimiento +", '" + color + "','" + estado +"')";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Mascota mascota = new Mascota( nombre, especie, raza, anio_nacimiento, color, estado);
            st.close();
            return gson.toJson(mascota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
}
    
