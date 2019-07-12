/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Aerolinea;
import Entidades.Avion;
import Entidades.Empleado;
import Entidades.Usuario;
import java.util.Scanner;
import Sistema.*;

/**
 *
 * @author Homar Herrera
 */
public class MenuAdministrador {
    
    private static boolean control;
    private static String opcion;
    private static String aerolinea;
    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(Usuario user) {
        System.out.printf("BIENVENIDO ADMINSITRADOR %s\n",user.getNombre().toUpperCase());  
        control=true;
        while(control){
            System.out.print("1.-CREAR USUARIO\n2.-CREAR AEROLINEA\n3.-SALIR\nINGRESE OPCION: ");
             opcion = scanner.next();
            switch (opcion) {
                case "1":
                    crearUsuario();
                    break;
                case "2":
                    crearAerolinea();
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
    
    private static void crearUsuario(){
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
        String password = "";
        while(!verificarPassword(password)){
            System.out.print("Ingrese contraseña: ");
            password = scanner.next();
        }
        String rol = "";
        while(!(rol.equals("ADMINISTRADOR") || rol.equals("PLANIFICADOR") || rol.equals("CAJERO"))){
            System.out.print("Ingrese opcion valida(administrador-planificador-cajero): ");
            rol = scanner.next().toUpperCase();
        }
        if(rol.equals("ADMINISTRADOR")){
            Sistema.usuarios.add(new Usuario(cedula,nombre,apellido,password,rol,"SISTEMAS"));
        }
        else{
            String aerolinea = "";
            while(!Aerolinea.comprobarAerolinea(aerolinea)){
                System.out.print("Ingrese aerolinea existente: ");
                aerolinea= scanner.next().toUpperCase();
            }
            Sistema.usuarios.add(new Empleado(cedula,nombre,apellido,password,rol,"COMERCIAL",aerolinea));
        }
        
    }
    private static void crearAerolinea(){
        aerolinea="";
        while(Aerolinea.comprobarAerolinea(aerolinea)){
        System.out.print("Ingrese nombre de aerolinea:");
         aerolinea = scanner.next().toUpperCase();
        }
        Sistema.aerolineas.add(new Aerolinea(aerolinea));
    }
    
    
    private static boolean verificarPassword(String password){
        boolean control= false;
        boolean mayuscula= false;
        boolean digito= false;
        if(password.length()>8){
            for(int i=0; i<password.length();i++){
                if(Character.isDigit(password.charAt(i))){
                    digito = true;
                }
                else if(Character.isUpperCase(password.charAt(i))){
                    mayuscula = true;
                }
            }
        }
        if((mayuscula && digito) == true){
            control = true;
        }
        return control;
    }

    
    
}
