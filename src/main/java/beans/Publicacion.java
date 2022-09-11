
package beans;

import java.sql.Date;


public class Publicacion {
    
    private int id_publicacion;
    private int id_mascota;
    private Date fecha_publicacion;
    private Date fecha_perdida;
    private String descripcion;
    private String comentarios;

    public Publicacion(int id_publicacion, int id_mascota, Date fecha_publicacion, Date fecha_perdida, String descripcion, String comentarios) {
        this.id_publicacion = id_publicacion;
        this.id_mascota = id_mascota;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_perdida = fecha_perdida;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
    }
    
    
    

    /**
     * @return the id_publicacion
     */
    public int getId_publicacion() {
        return id_publicacion;
    }

    /**
     * @param id_publicacion the id_publicacion to set
     */
    public void setId_publicacion(int id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    /**
     * @return the id_mascota
     */
    public int getId_mascota() {
        return id_mascota;
    }

    /**
     * @param id_mascota the id_mascota to set
     */
    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    /**
     * @return the fecha_publicacion
     */
    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    /**
     * @param fecha_publicacion the fecha_publicacion to set
     */
    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    /**
     * @return the fecha_perdida
     */
    public Date getFecha_perdida() {
        return fecha_perdida;
    }

    /**
     * @param fecha_perdida the fecha_perdida to set
     */
    public void setFecha_perdida(Date fecha_perdida) {
        this.fecha_perdida = fecha_perdida;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id_publicacion=" + id_publicacion + ", id_mascota=" + id_mascota + ", fecha_publicacion=" + fecha_publicacion + ", fecha_perdida=" + fecha_perdida + ", descripcion=" + descripcion + ", comentarios=" + comentarios + '}';
    }
    
    
}
