/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Aerolinea;
import Entidades.Avion;
import Entidades.Empleado;
import Entidades.Planificacion;
import Entidades.Usuario;
import Sistema.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Homar Herrera
 */
public class MenuPlanificador {
    
    private static boolean control;
    private static String opcion;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(Empleado empleado) {
        control = true;
        opcion = "";
        System.out.printf("BIENVENIDO PLANIFICADOR %s\n",empleado.getNombre().toUpperCase());
        while(control){
            System.out.print("1.-PLANIFICAR VUELO\n2.-REGISTRAR NUEVO AVION\n3.-SALIR\nINGRESE OPCION: ");
            opcion = scanner.next();
            switch (opcion) {
                case "1":
                    crearPlanificacion(empleado);
                    break;
                case "2":
                    registrarAvion(empleado);
                    break;
                case "3":
                    System.out.println("Ha cerrado su sesion con exito");
                    control=false;
                    break;
                default:
                    System.out.println("Ha ingresado una opcion inexistente");
                    break;
            }
        }
    }
    private static void crearPlanificacion(Empleado empleado){
        ArrayList<Avion> aviones= empleado.getAerolinea().getAviones();
        String op="";
        int opcion=-1;
        while(opcion < aviones.size() && opcion< 0){
            System.out.println("Los aviones disponibles son los siguientes: ");
            for(int i = 0; i<aviones.size();i++){ System.out.println(String.valueOf(i+1)+": "+aviones.get(i).getNSerie());}
            System.out.print("Ingrese el numero del avion: ");
            op = scanner.next();
            if(Sistema.comprobarDigito(op)){
                opcion= Integer.parseInt(op) -1;
            }  
        }
        Avion avion= aviones.get(opcion);
        op="";
        while(Planificacion.existeCodigoVuelo(op)){
            System.out.print("Ingrese codigo de vuelo: ");
            op = scanner.next();   
        }
        
        
    }
    private static void registrarAvion(Empleado empleado){
        String n_serie = "";
        String fabricante= "";
        String modelo= "";
        int asientos_prim_clase;
        int asientos_norm_clase;
        int distanciaKm;
        String aerolinea= "";
        String prim;
       while(Avion.comprobarAvion(n_serie)){
            System.out.print("Ingrese n_serie de avion: ");
            n_serie = scanner.next().toUpperCase();
        }
        System.out.print("Ingrese fabricante: ");
        fabricante = scanner.next().toUpperCase();
        System.out.print("Ingrese modelo: ");
        modelo = scanner.next().toUpperCase();
        prim="";
        while(Sistema.comprobarDigito(prim)){
            System.out.print("Ingrese cantidad de asientos en primera clase: ");
            prim = scanner.next();
        }
        asientos_prim_clase = Integer.parseInt(prim);
        prim="";
        while(Sistema.comprobarDigito(prim)){
            System.out.print("Ingrese cantidad de asientos en clase normal: ");
            prim = scanner.next();
        }
        asientos_norm_clase = Integer.parseInt(prim);
        prim="";
        while(Sistema.comprobarDigito(prim)){
            System.out.print("Ingrese cantidad de Km que recorre el avion: ");
            prim = scanner.next();
        }
        distanciaKm = Integer.parseInt(prim);
        aerolinea = empleado.getAerolinea().getNombre();
        Avion avion = new Avion(n_serie,fabricante,modelo,asientos_prim_clase,asientos_norm_clase,distanciaKm,aerolinea);
        Sistema.aviones.add(avion);
        empleado.getAerolinea().getAviones().add(avion);
        System.out.println("Ha registrado el avion con exito");
    }
    
    
}
