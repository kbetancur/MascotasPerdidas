package controller;

import java.sql.Date;
import java.util.Map;

public interface IPublicacionController {
    public String registrop(int id_mascota,Date fecha_publicacion, Date fecha_perdida, String descripcion,  String comentarios);
    public String listarp();
    public String vermisPublicaciones(int id_duenio);
    public String obtenerDatosPublicacion(int id_publicacion);
    public String actualizarPublicacion(int id_publicacion,int id_mascota, Date fecha_publicacion, Date fecha_perdida, String descripcion);

}