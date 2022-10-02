package controller;

import java.sql.Date;
import java.util.Map;

public interface IPublicacionController {
    public String registrop(int id_mascota,Date fecha_publicacion, Date fecha_perdida, String descripcion,  String comentarios);
    

}