package pojos;
// Generated 17/02/2019, 2:18:41 p.m. by Hibernate Tools 4.3.1



/**
 * Materia generated by hbm2java
 */
public class Materia  implements java.io.Serializable {


     private int id;
     private String nombre;
     private int horas;
     private boolean laboratorio;
     private String idProfesor;
     private int idGrado;

    public Materia() {
    }

    public Materia(int id, String nombre, int horas, boolean laboratorio, String idProfesor, int idGrado) {
       this.id = id;
       this.nombre = nombre;
       this.horas = horas;
       this.laboratorio = laboratorio;
       this.idProfesor = idProfesor;
       this.idGrado = idGrado;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHoras() {
        return this.horas;
    }
    
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public boolean isLaboratorio() {
        return this.laboratorio;
    }
    
    public void setLaboratorio(boolean laboratorio) {
        this.laboratorio = laboratorio;
    }
    public String getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    public int getIdGrado() {
        return this.idGrado;
    }
    
    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }




}


