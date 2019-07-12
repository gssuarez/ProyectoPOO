/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Homar Herrera
 */


public class Asiento {
    
    public enum Tipo{PRIMERA_CLASE,NORMAL_CLASE;}
    
    private String codVuelo;
    private int disponibles;
    private double precio;
    private Tipo tipo;
    
    public Asiento(String cod_vuelo,int asientos,double precio, Tipo tipo){
        disponibles=asientos;
        this.precio = precio;
        this.tipo = tipo;
        this.codVuelo = cod_vuelo;
        
    }
    public int generarPuesto(){
        disponibles --;
        int puesto= disponibles;
        return disponibles;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String cod_vuelo) {
        this.codVuelo = cod_vuelo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
     public static Tipo obtenerTipo(String c){
        Tipo tipo = null;
        if(c.equals("PRIMERA_CLASE")){
            return tipo = Tipo.PRIMERA_CLASE;
        }
        else if(c.equals("NORMAL_CLASE")){
             return tipo= Tipo.NORMAL_CLASE;
         }
        return tipo;
         
     }
}
