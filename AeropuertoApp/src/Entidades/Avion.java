/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import Sistema.*;

/**
 *
 * @author Homar Herrera
 */
public class Avion {
    
    private String n_serie;
    private String fabricante;
    private String modelo;
    private int asientos_prim_clase;
    private int asientos_norm_clase;
    private int distanciaKm;
    private String Aerolinea;

    public Avion(String n_serie, String fabricante, String modelo, int asientos_prim_clase, int asientos_norm_clase, int distanciaKm, String aerolinea) {
        this.n_serie = n_serie;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.asientos_prim_clase = asientos_prim_clase;
        this.asientos_norm_clase = asientos_norm_clase;
        this.distanciaKm = distanciaKm;
        this.Aerolinea = aerolinea;
    }
    
    public static boolean comprobarAvion(String avion){
        boolean control = false;
        if(avion.equals("")){
            control=true;
        }
        for(Avion a: Sistema.aviones){
            if(a.n_serie.equals(avion) ){
                control = true;
            }
        }
        return control;
    }
    
    
    public String getN_serie() {
        return n_serie;
    }

    public void setN_serie(String n_serie) {
        this.n_serie = n_serie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAsientos_prim_clase() {
        return asientos_prim_clase;
    }

    public void setAsientos_prim_clase(int asientos_prim_clase) {
        this.asientos_prim_clase = asientos_prim_clase;
    }

    public int getAsientos_norm_clase() {
        return asientos_norm_clase;
    }

    public void setAsientos_norm_clase(int asientos_norm_clase) {
        this.asientos_norm_clase = asientos_norm_clase;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public String getAerolinea() {
        return Aerolinea;
    }

    public void setAerolinea(String Aerolinea) {
        this.Aerolinea = Aerolinea;
    }
    
    
}
