
package beans;

public class Duenio {
    private int id_duenio;
    private String tipo_identificacion;
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String correo_electronico;
    private String contrasena;
    private String ciudad;
    private String barrio;
    private String direccion;
    private String telefono;

    public Duenio(int id_duenio, String tipo_identificacion, String identificacion, String nombre, String apellidos, String correo_electronico, String contrasena, String ciudad, String barrio, String direccion, String telefono) {
        this.id_duenio = id_duenio;
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    
    

    /**
     * @return the id_duenio
     */
    public int getId_duenio() {
        return id_duenio;
    }

    /**
     * @param id_duenio the id_duenio to set
     */
    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    /**
     * @return the tipo_identificacion
     */
    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    /**
     * @param tipo_identificacion the tipo_identificacion to set
     */
    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the correo_electronico
     */
    public String getCorreo_electronico() {
        return correo_electronico;
    }

    /**
     * @param correo_electronico the correo_electronico to set
     */
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the barrio
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * @param barrio the barrio to set
     */
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Duenio{" + "id_duenio=" + id_duenio + ", tipo_identificacion=" + tipo_identificacion + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo_electronico=" + correo_electronico + ", contrasena=" + contrasena + ", ciudad=" + ciudad + ", barrio=" + barrio + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
    
    
}
