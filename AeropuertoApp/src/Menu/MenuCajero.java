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
        int opcion=-1;
        while(opcion < planificaciones.size() && opcion< 0){
            System.out.println("Los aviones disponibles son los siguientes: ");
            for(int i = 0; i<planificaciones.size();i++){ System.out.println(String.valueOf(i+1)+": "+planificaciones.get(i).getDestino());}
            System.out.print("Ingrese el numero del destino: ");
            op = scanner.next();
            if(Sistema.comprobarDigito(op)){
                opcion= Integer.parseInt(op) -1;
            }  
        }
    }
    
}
