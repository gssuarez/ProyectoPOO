/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author Homar Herrera
 */
public class Boleto {
    
     private Cliente cliente;
     private int puesto;
     private String codVuelo;

    public Boleto(Cliente cliente, int puesto, String cod_vuelo) {
        this.cliente = cliente;
        this.puesto = puesto;
        this.codVuelo = cod_vuelo;
    }
     
}
