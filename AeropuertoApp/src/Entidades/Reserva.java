/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Homar Herrera
 */
public class Reserva {
    
    private String cod_vuelo;
    private LocalDate fecha;
    private String user_empleado; //codigo empleado
    private ArrayList<Boleto> boletos;
    private double total;
    private double cantidadPasajeros;

    public Reserva(String cod_vuelo, LocalDate fecha, String user_empleado, double total, int cantidadPasajeros) {
        boletos = new ArrayList<>();
        this.cod_vuelo = cod_vuelo;
        this.fecha = fecha;
        this.user_empleado = user_empleado;
        this.total = total;
        this.cantidadPasajeros = cantidadPasajeros;
    }
    public String getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(String cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUser_empleado() {
        return user_empleado;
    }

    public void setUser_empleado(String user_empleado) {
        this.user_empleado = user_empleado;
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<Boleto> boletos) {
        this.boletos = boletos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
