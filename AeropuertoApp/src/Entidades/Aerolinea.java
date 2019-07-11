/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Sistema.Sistema;
import java.util.ArrayList;

/**
 *
 * @author Homar Herrera
 */
public class Aerolinea {
    
    private static int contador;
    private String nombre;
    private int id;
    private ArrayList<Avion>aviones;
    private ArrayList<Planificacion> planificaciones;

    public Aerolinea(String nombre) {
        planificaciones= new ArrayList<>();
        aviones= new ArrayList<>();
        this.nombre = nombre;
        id=contador;
        contador++;
    }
    
    public Aerolinea(String nombre,int id) {
        planificaciones= new ArrayList<>();
        aviones= new ArrayList<>();
        this.nombre = nombre;
        this.id =id;
        contador= id;
    }

    public ArrayList<Planificacion> getPlanificaciones() {
        return planificaciones;
    }

    public void setPlanificaciones(ArrayList<Planificacion> planificaciones) {
        this.planificaciones = planificaciones;
    }
    
    public static boolean comprobarAerolinea(String aero){
        boolean a= false;
        for(Aerolinea aerolinea: Sistema.aerolineas){
            if(aerolinea.getNombre().equals(aero)){
                a=true;
            }
        }
        return a;   
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<Avion> aviones) {
        this.aviones = aviones;
    }
    
    
    
}
