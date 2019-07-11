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
    
    private int disponibles;
    private int precio;
    
    public Asiento(int asientos,int precio){
        disponibles=asientos;
        this.precio = precio;
        
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


    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
