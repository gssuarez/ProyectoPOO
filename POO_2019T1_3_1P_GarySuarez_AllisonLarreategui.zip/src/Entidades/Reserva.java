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
    
    private String codVuelo;
    private LocalDate fecha;
    private String userEmpleado; //codigo empleado
    private ArrayList<Boleto> boletos;
    private double total;
    private int cantidadPasajeros;

    public Reserva(String cod_vuelo, LocalDate fecha, String user_empleado, double total, int cantidadPasajeros) {
        boletos = new ArrayList<>();
        this.codVuelo = cod_vuelo;
        this.fecha = fecha;
        this.userEmpleado = user_empleado;
        this.total = total;
        this.cantidadPasajeros = cantidadPasajeros;
    }
    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String cod_vuelo) {
        this.codVuelo = cod_vuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUserEmpleado() {
        return userEmpleado;
    }

    public void setUserEmpleado(String user_empleado) {
        this.userEmpleado = user_empleado;
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

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
    
    
    
    
}
