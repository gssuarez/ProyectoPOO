/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Sistema.Sistema;

/**
 *
 * @author Homar Herrera
 */
public class Empleado extends Usuario {
    
    private Aerolinea aerolinea;

    public Empleado(String cedula, String nombre, String apellido, String password, String rol,String departamento,String aerolinea) {
        super(cedula, nombre, apellido, password, rol,departamento);
        this.aerolinea = encontrarAerolinea(aerolinea);
        System.out.println(aerolinea);
    }
    
    public Empleado(String cedula, String nombre, String apellido,String password,String email,String usuario,String rol, String departamento,String aerolinea) {
        super( cedula,  nombre,  apellido, password, email, usuario, rol,  departamento);
        this.aerolinea= encontrarAerolinea(aerolinea);

    }
    
    private static Aerolinea encontrarAerolinea(String aero){
        Aerolinea a= null;
        for(Aerolinea aerolinea: Sistema.aerolineas){
            if(aerolinea.getNombre().equals(aero)){
                a=aerolinea;
            }
        }
        return a;   
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    

    
}
