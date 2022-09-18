package test;

import beans.*;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesDB {

    public static void main(String[] args) {
        //listarDuenios();
        actualizarDuenio(1,"Niver");

    }

    public static void actualizarDuenio(int id_duenio, String nombre) {
        DBConnection conn = new DBConnection();
        
        String sql = "UPDATE tbl_duenio SET nombre = '" + nombre + "'WHERE id_duenio=" + id_duenio;
        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            System.out.println("Después de ejecutar el update - " + "Filas afectadas: " + st.getUpdateCount());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            conn.desconectar();
        }

    }

    public static void listarDuenios() {
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM tbl_duenio";
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_duenio = rs.getInt("id_duenio");
                String tipo_identificacion = rs.getString("tipo_identificacion");
                String identificacion = rs.getString("identificacion");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String correo_electronico = rs.getString("correo_electronico");
                String contrasena = rs.getString("contrasena");
                String ciudad = rs.getString("ciudad");
                String barrio = rs.getString("barrio");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                
                Duenio duenio = new Duenio (id_duenio, tipo_identificacion, identificacion, nombre, apellidos, correo_electronico, contrasena, ciudad, barrio, direccion, telefono);
                System.out.println(duenio.toString());

            }
            st.execute(sql);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            conn.desconectar();
        }

    }

}
