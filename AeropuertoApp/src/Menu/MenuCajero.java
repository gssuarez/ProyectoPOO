/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Empleado;
import Entidades.Planificacion;
import Entidades.Usuario;
import Sistema.Sistema;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Homar Herrera
 */
public class MenuCajero {
    
    private static boolean control;
    private static String opcion;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(Empleado empleado) {
        control = true;
        opcion = "";
        while(control){
            System.out.print("1.-VENDER BOLETO\n2.-SALIR\nINGRESE OPCION: ");
            opcion = scanner.next();
            switch (opcion) {
                case "1":
                    venderBoleto(empleado);
                    break;
                case "2":
                    System.out.println("Ha cerrado su sesion con exito");
                    control=false;
                    break;
                default:
                    System.out.println("Ha ingresado una opcion inexistente");
                    break;
            }
        }
    }
    
    private static void venderBoleto(Empleado empleado){
        ArrayList<Planificacion> planificaciones= empleado.getAerolinea().getPlanificaciones();
        String op="";
        String destino;
        int opcion=-1;
        while(opcion < planificaciones.size() && opcion< 0){
            System.out.println("Los destinos disponibles son los siguientes: ");
            for(int i = 0; i<planificaciones.size();i++){ System.out.println(String.valueOf(i+1)+": "+planificaciones.get(i).getDestino());}
            System.out.print("Ingrese el numero del destino: ");
            op = scanner.next();
            if(Sistema.comprobarDigito(op)){
                opcion= Integer.parseInt(op) -1;
            }  
        }
        destino = planificaciones.get(opcion).getDestino();
        ArrayList<Planificacion> planificaciones2 = obtenerArrayDestino(planificaciones,destino);
        opcion=-1;
        while(opcion < planificaciones2.size() && opcion< 0){
            System.out.println("Se tienen los siguientes vuelos: ");
            for(int i = 0; i<planificaciones2.size();i++){ 
                System.out.println(String.valueOf(i+1)+".- Fecha: "+ planificaciones2.get(i).getDepartute_time().toString() +
                       "|Asientos normales: "+planificaciones2.get(i).getAsientos_norm_clase() +  "|Asientos primera clase: "+planificaciones2.get(i).getAsientos_prim_clase());}
            System.out.print("Ingrese el opcion del vuelo escogido: ");
            op = scanner.next();
            if(Sistema.comprobarDigito(op)){
                opcion= Integer.parseInt(op) -1;
            }  
            Planificacion reserva= planificaciones2.get(opcion);
            registroBoleto(reserva);
            
        }
    }
    
    private static ArrayList<Planificacion> obtenerArrayDestino (ArrayList<Planificacion> p, String destino){
        ArrayList<Planificacion> planificacion =  new ArrayList<>();
        for(Planificacion pl: p){
            if(pl.getDestino().equals(destino)){
                planificacion.add(pl);
            }
        }
        return planificacion;
    }
    
    private static void registroBoleto(Planificacion reserva){
        String opcion = "";
        while(!opcion.equals("1") || !opcion.equals("2")){
            System.out.print("Tipos de entrada para comprar\n1.-Primera clase\n2.-Segunda clase\nIngresar opcion: ");
        }
        if (opcion.equals("1")){
            
        }
        else if (opcion.equals("2")){
        
        }
    }
    
}
