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
    
    private String nSerie;
    private String fabricante;
    private String modelo;
    private int asientosPrimClase;
    private int asientosNormClase;
    private int distanciaKm;
    private String Aerolinea;

    public Avion(String n_serie, String fabricante, String modelo, int asientos_prim_clase, int asientos_norm_clase, int distanciaKm, String aerolinea) {
        this.nSerie = n_serie;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.asientosPrimClase = asientos_prim_clase;
        this.asientosNormClase = asientos_norm_clase;
        this.distanciaKm = distanciaKm;
        this.Aerolinea = aerolinea;
    }
    
    public static boolean comprobarAvion(String avion){
        boolean control = false;
        if(avion.equals("")){
            control=true;
        }
        for(Avion a: Sistema.aviones){
            if(a.nSerie.equals(avion) ){
                control = true;
            }
        }
        return control;
    }
    
    
    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String n_serie) {
        this.nSerie = n_serie;
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

    public int getAsientosPrimClase() {
        return asientosPrimClase;
    }

    public void setAsientos_prim_clase(int asientos_prim_clase) {
        this.asientosPrimClase = asientos_prim_clase;
    }

    public int getAsientos_norm_clase() {
        return asientosNormClase;
    }

    public void setAsientosNormClase(int asientos_norm_clase) {
        this.asientosNormClase = asientos_norm_clase;
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
