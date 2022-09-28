package controller;

import java.util.Map;

public interface IMascotaController {
    public String registrom(int id_duenio,String nombre, String especie, String raza, int anio_nacimiento, String color, String estado);
    
     public String listar(boolean ordenar, String orden);
    
}
