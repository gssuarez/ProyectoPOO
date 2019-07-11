/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import Sistema.*;
import java.util.Scanner;

/**
 *
 * @author Homar Herrera
 */
public class Cliente extends Persona {
    
    int añoNacimiento;
    
    public Cliente(String cedula, String nombre, String apellido, int añoNacimiento) {
        super(cedula, nombre, apellido);
        this.añoNacimiento = añoNacimiento;
    }
    
    public static boolean existeCliente(String cedula){
        boolean control=false;
        for(Cliente cliente: Sistema.clientes){
            if(cliente.getCedula().equals(cedula)){
                control = true;
            }
        }
        return control;
    }
    
    public static Cliente crearCliente(){
        Scanner scanner = new Scanner(System.in);
        String cedula="0000000000";
        while(Sistema.ingresarCedula(cedula)){
            System.out.print("Ingrese cedula: ");
            cedula = scanner.next();
        }
        String nombre = "";
        System.out.print("Ingrese nombre: ");
        nombre = scanner.next().toUpperCase();
        String apellido = "";
        System.out.print("Ingrese apellido: ");
        apellido = scanner.next().toUpperCase();
        int año=0;
        String op;
        while(año<1900 || año >2020){
            System.out.print("Ingrese su año de nacimiento: ");
            op = scanner.next();
             if(Sistema.comprobarDigito(op)){
                año= Integer.parseInt(op);
            }  
        }
        return new Cliente(cedula,nombre,apellido,año);
    }
    
    public static Cliente devolverCliente(String c){
        for(Cliente cliente: Sistema.clientes){
            if(cliente.cedula.equals(c)){
                return cliente;
            }
        }
        return null;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }
    
    
}
