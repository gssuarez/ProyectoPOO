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
     private int num_vuelo;
     private String user_empleado; //codigo empleado
     private ArrayList<Boleto> boletos;
     private double total;
}
