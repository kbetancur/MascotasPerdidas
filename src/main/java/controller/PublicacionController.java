package controller;

import beans.Publicacion;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Mascota;
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
    
    
    
}
    

