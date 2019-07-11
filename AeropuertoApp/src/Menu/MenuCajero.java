/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Empleado;
import Entidades.Usuario;
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
        
    }
    
}
