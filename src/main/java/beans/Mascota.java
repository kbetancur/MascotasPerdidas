
package beans;

public class Mascota {
    private int id_mascota;
    private int id_duenio;
    private String nombre;
    private String especie;
    private String raza;
    private int anio_nacimiento;
    private String color;
    private String estado;
    private String nombres_duenio;

    public Mascota(int id_mascota, int id_duenio, String nombre, String especie, String raza, int anio_nacimiento, String color, String estado) {
        this.id_mascota = id_mascota;
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.anio_nacimiento = anio_nacimiento;
        this.color = color;
        this.estado = estado;
    }
    
    //Constructor para el registro de mascota
        public Mascota(String nombre, String especie, String raza, int anio_nacimiento, String color, String estado) 
        {
            this.nombre = nombre;
            this.especie = especie;
            this.raza = raza;
            this.anio_nacimiento = anio_nacimiento;
            this.color = color;
            this.estado = estado;
    }
        
    //Constructor para el registro de mascota con dueño
        public Mascota(int id_duenio, String nombre, String especie, String raza, int anio_nacimiento, String color, String estado) 
        {
            this.id_duenio = id_duenio;
            this.nombre = nombre;
            this.especie = especie;
            this.raza = raza;
            this.anio_nacimiento = anio_nacimiento;
            this.color = color;
            this.estado = estado;
    }     
        
        /* Constructor para consulta con inner join a dueño*/
        public Mascota(int id_mascota, int id_duenio, String nombres_duenio,String nombre, String especie, String raza, int anio_nacimiento, String color, String estado) {
        this.id_mascota = id_mascota;
        this.id_duenio = id_duenio;
        this.nombres_duenio = nombres_duenio;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.anio_nacimiento = anio_nacimiento;
        this.color = color;
        this.estado = estado;
    }

    //Constructor para actualizar el estado de la mascota
    public Mascota(int id_mascota, String estado) {
        this.id_mascota = id_mascota; 
        this.estado = estado;

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
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the anio_nacimiento
     */
    public int getAnio_nacimiento() {
        return anio_nacimiento;
    }

    /**
     * @param anio_nacimiento the anio_nacimiento to set
     */
    public void setAnio_nacimiento(int anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombres_duenio() {
        return nombres_duenio;
    }

    public void setNombres_duenio(String nombres_duenio) {
        this.nombres_duenio = nombres_duenio;
    }
    
    

    @Override
    public String toString() {
        return "Mascota{" + "id_mascota=" + id_mascota + ", id_duenio=" + id_duenio + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza + ", anio_nacimiento=" + anio_nacimiento + ", color=" + color + ", estado=" + estado + '}';
    }
    
    
    
    
}
