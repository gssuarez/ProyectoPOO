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
    
    private int contador;
    private int disponibles;
    private int ocupados;
    private int precio;
    
    public Asiento(int asientos){
        disponibles=asientos;
        
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
