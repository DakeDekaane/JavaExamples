package hibernatetest;
// Generated 3/10/2019 01:34:48 AM by Hibernate Tools 4.3.1



/**
 * Prebes generated by hbm2java
 */
public class Prebes  implements java.io.Serializable {


     private int prebeId;
     private String nombre;
     private int edad;

    public Prebes() {
    }

    public Prebes(int prebeId, String nombre, int edad) {
       this.prebeId = prebeId;
       this.nombre = nombre;
       this.edad = edad;
    }
   
    public int getPrebeId() {
        return this.prebeId;
    }
    
    public void setPrebeId(int prebeId) {
        this.prebeId = prebeId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }




}

