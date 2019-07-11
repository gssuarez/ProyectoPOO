/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Sistema.Sistema;
import java.time.LocalDateTime;

/**
 *
 * @author Homar Herrera
 */
public class Planificacion {
    
    private static int contador = 0;
    private String avion;
    private String cod_vuelo;
    private LocalDateTime boarding_time;
    private LocalDateTime departute_time;
    private String IATA_arribo;
    private String IATA_salida;
    private int asientos_prim_clase;
    private int asientos_norm_clase;
    
    
    
    public static boolean existeCodigoVuelo(String cod){
        boolean control=false;
        if( cod.equals("")){
            control=true;
        }
        for(Planificacion planificacion: Sistema.planificaciones){
            if(planificacion.cod_vuelo.equals(cod)){
                control=true;
            }
        }
        return control;
    }
    
}
