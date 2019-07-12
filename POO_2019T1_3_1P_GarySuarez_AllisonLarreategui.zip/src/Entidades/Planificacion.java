/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Sistema.Sistema;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Homar Herrera
 */
public class Planificacion {
    
    private static int contador = 0;
    private String avion;
    private String codVuelo;
    private LocalDateTime boardingTime;
    private LocalDateTime departuteTime;
    private String IATAArribo;
    private String IATASalida;
    private String destino;
    private Asiento asientosPrimClase;
    private Asiento asientosNormClase;
    private ArrayList<Reserva> reservas;

    public Planificacion(String avion, String cod_vuelo, LocalDateTime boarding_time, LocalDateTime departute_time, String IATA_arribo, String IATA_salida, int asientos_prim_clase, int asientos_norm_clase,int prim_clase, int norm_clase) {
        reservas= new ArrayList<>();
        this.avion = avion;
        this.codVuelo = cod_vuelo;
        this.boardingTime = boarding_time;
        this.departuteTime = departute_time;
        this.IATAArribo = IATA_arribo;
        this.IATASalida = IATA_salida;
        Asiento primero = new Asiento(cod_vuelo,asientos_prim_clase, prim_clase,Asiento.Tipo.PRIMERA_CLASE);
        this.asientosPrimClase = primero;
        Asiento normal =  new Asiento(cod_vuelo,asientos_norm_clase, norm_clase,Asiento.Tipo.NORMAL_CLASE);
        this.asientosNormClase = normal;
        this.destino = IATA_arribo.split("/")[1];
        Sistema.asientos.add(normal);
        Sistema.asientos.add(primero);
    }
    public Planificacion(String avion, String cod_vuelo, LocalDateTime boarding_time, LocalDateTime departute_time, String IATA_arribo, String IATA_salida) {
        reservas= new ArrayList<>();
        this.avion = avion;
        this.codVuelo = cod_vuelo;
        this.boardingTime = boarding_time;
        this.departuteTime = departute_time;
        this.IATAArribo = IATA_arribo;
        this.IATASalida = IATA_salida;
        this.destino = IATA_arribo.split("/")[1];
    }
    
    
   
    public static boolean existeCodigoVuelo(String cod){
        boolean control=false;
        if( cod.equals("")){
            control=true;
        }
        for(Planificacion planificacion: Sistema.planificaciones){
            if(planificacion.codVuelo.equals(cod)){
                control=true;
            }
        }
        return control;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Planificacion.contador = contador;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public String getCod_vuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String cod_vuelo) {
        this.codVuelo = cod_vuelo;
    }

    public LocalDateTime getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(LocalDateTime boarding_time) {
        this.boardingTime = boarding_time;
    }

    public LocalDateTime getDepartuteTime() {
        return departuteTime;
    }

    public void setDepartuteTime(LocalDateTime departute_time) {
        this.departuteTime = departuteTime;
    }

    public String getIATAArribo() {
        return IATAArribo;
    }

    public void setIATAArribo(String IATA_arribo) {
        this.IATAArribo = IATA_arribo;
    }

    public String getIATASalida() {
        return IATASalida;
    }

    public void setIATASalida(String IATA_salida) {
        this.IATASalida = IATA_salida;
    }

    public Asiento getAsientosPrimClase() {
        return asientosPrimClase;
    }

    public void setAsientosPrimClase(Asiento asientos_prim_clase) {
        this.asientosPrimClase = asientos_prim_clase;
    }

    public Asiento getAsientosNormClase() {
        return asientosNormClase;
    }

    public void setAsientosNormClase(Asiento asientos_norm_clase) {
        this.asientosNormClase = asientos_norm_clase;
    }
    
    public static Planificacion retornarPlanificacion(String codigo){
        Planificacion p = null;
        for(Planificacion plan: Sistema.planificaciones){
            if(plan.codVuelo.equals(codigo)){
                p=plan;
            }
        }
        return p;
    }
}
