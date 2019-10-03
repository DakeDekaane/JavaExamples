/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatetest;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dakedekaane
 */
public class HibernateTest {
    
    public void create(int prebe_id,String nombre, int edad) {
        
        try {
            //Crear objeto
            Prebes pr = new Prebes();
            pr.setPrebeId(prebe_id);
            pr.setNombre(nombre);
            pr.setEdad(edad);
            
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            
            //Guardar datos            
            s.save(pr);
            tr.commit();
            System.out.println("Datos guardados.");
            
            //Cerrar conexión
            s.close();
            tr = null;;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void readById(int prebe_id) {
        
        try {
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            
            //Realizar consulta
            Prebes pr = (Prebes)s.load(Prebes.class, prebe_id);
            System.out.println("Datos obtenidos: ");
            System.out.println("No.: " + pr.getPrebeId());
            System.out.println("Nombre: " + pr.getNombre());
            System.out.println("Edad: " + pr.getEdad());
            
            //Cerrar conexión
            s.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void readAll() {
        
        try {
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            
            //Realizar consulta en HQL (Hibernate Query Language)
            Criteria c = s.createCriteria(Prebes.class);
            List<Prebes> result = c.list();
            
            //Mostrar resultados
            System.out.println("Datos obtenidos: ");
            for (Prebes pr : result ){
                System.out.println("No.: " + pr.getPrebeId());
                System.out.println("Nombre: " + pr.getNombre());
                System.out.println("Edad: " + pr.getEdad());
            }
            
            //Cerrar conexión
            s.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void readByName(String nombre) {
        
        try {
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            
            //Realizar consulta en HQL (Hibernate Query Language)
            Criteria c = s.createCriteria(Prebes.class);
            //Restriction eq (igual a)
            c.add(Restrictions.eq("nombre", nombre));
            //Puede haber más restricciones...
            List<Prebes> result = c.list();
            
            //Mostrar resultados
            System.out.println("Datos obtenidos: ");
            for (Prebes pr : result ){
                System.out.println("No.: " + pr.getPrebeId());
                System.out.println("Nombre: " + pr.getNombre());
                System.out.println("Edad: " + pr.getEdad());
            }
            
            //Cerrar conexión
            s.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void readByAge(int edad) {
        
        try {
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            
            //Realizar consulta en HQL (Hibernate Query Language)
            Criteria c = s.createCriteria(Prebes.class);
            //Restriction lt (menor que)
            c.add(Restrictions.lt("edad", edad));
            //Puede haber más restricciones...
            List<Prebes> result = c.list();
            
            //Mostrar resultados
            System.out.println("Datos obtenidos: ");
            for (Prebes pr : result ){
                System.out.println("No.: " + pr.getPrebeId());
                System.out.println("Nombre: " + pr.getNombre());
                System.out.println("Edad: " + pr.getEdad());
            }
            
            //Cerrar conexión
            s.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateById(int prebe_id,String nombre,int edad) {
        
        try {
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            
            //Realizar consulta y modificar datos
            Prebes pr = (Prebes)s.load(Prebes.class, prebe_id);
            pr.setNombre(nombre);
            pr.setEdad(edad);
            
            //Actualizar datos            
            s.update(pr);
            tr.commit();
            System.out.println("Datos actualizados.");
            
            //Cerrar conexión
            s.close();
            tr = null;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteById(int prebe_id) {
        
        try {
            //Abrir conexión
            Session s = Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            
            //Realizar consulta
            Prebes pr = (Prebes)s.load(Prebes.class, prebe_id);
            
            //Borrar
            s.delete(pr);
            tr.commit();
            System.out.println("Datos eliminados.");
            
            //Cerrar conexión
            s.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        HibernateTest ht = new HibernateTest();
        
        //Crear registros (cambiar el ejemplo con datos de los prebes :v)
        ht.create(2, "Yaxkin", 25);
        
        //Leer todo
        ht.readAll();
        
        //Leer al prebe X (2 en este caso)
        ht.readById(2);
        
        //Actualizar prebe X
        ht.updateById(2, "Yaxkin", 27);
        
        //Borrar prebe (no me borren pls)
        ht.deleteById(2);
        
    }
    
}
