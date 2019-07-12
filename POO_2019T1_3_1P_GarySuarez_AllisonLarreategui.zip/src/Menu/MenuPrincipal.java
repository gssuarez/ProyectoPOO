/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Empleado;
import Entidades.Usuario;
import Sistema.Sistema;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


/**
 *
 * @author Homar Herrera
 */
public class MenuPrincipal {
    
     private static String usuario;
     private static String password;
     private static Usuario user;
     private static Empleado empleado;
     private static boolean control;
    

    /**
     * @param args the command line arguments
     */
     
     //administrador : arnter0847 - password: Tierrita1
     //planificador : garsuar0847 - password: Perrito24
     //cajero : kelsia0847 - password: Juan12345
    public static void main(String[] args) throws UnsupportedEncodingException {
        Sistema.cargarDatos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENIDO Al SISTEMA DE AEROPUERTOS");  
        control=true;
        while(control){
            System.out.print("Ingrese usuario(SALIR PARA CERRAR EL PROGRAMA): ");
            usuario = scanner.next().toUpperCase();
            if(!usuario.equals("SALIR")){
                System.out.print("Ingrese contraseña: ");
                password = scanner.next();
                user = Sistema.obtenerTipoUsuario(usuario,password);
                if(user!=null){
                    switch (user.getRol()) {
                        case "PLANIFICADOR":
                            empleado = (Empleado) user;
                            MenuPlanificador.main(empleado);
                            break;
                        case "CAJERO":
                            empleado = (Empleado) user;
                            MenuCajero.main(empleado);
                            break;
                        case "ADMINISTRADOR":
                            MenuAdministrador.main(user);
                            break;
                        default:
                            break;
                    }
                }else{
                    System.out.println("Datos incorrectos. ingreselos nuevamente");
                }    
            }
            else{
                System.out.println("Tenga buen dia");
                Sistema.guardarDatos();
                control = false;
            }
        }
    }
}
