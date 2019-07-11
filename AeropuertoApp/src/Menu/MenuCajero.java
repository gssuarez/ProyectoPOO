/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Entidades.Asiento;
import Entidades.Boleto;
import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Planificacion;
import Entidades.Reserva;
import Entidades.Usuario;
import Sistema.Sistema;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                System.out.println(String.valueOf(i+1)+".- Fecha: "+ planificaciones2.get(i).getDepartute_time().toString() 
           +  " | Asientos primera clase: "+planificaciones2.get(i).getAsientos_prim_clase().getDisponibles() + " | Asientos normales: "+planificaciones2.get(i).getAsientos_norm_clase().getDisponibles());}
            System.out.print("Ingrese el opcion del vuelo escogido: ");
            op = scanner.next();
            if(Sistema.comprobarDigito(op)){
                opcion= Integer.parseInt(op) -1;
            }         
        }
        Planificacion reserva= planificaciones2.get(opcion);
        op = "";
        Asiento asiento = null;
        while(!op.equals("1") && !op.equals("2")){
            System.out.print("Tipos de entrada para comprar\n1.-Primera clase\n2.-Segunda clase\nIngresar opcion: ");
            op = scanner.next();
        }
        if (op.equals("1")){
            asiento = reserva.getAsientos_prim_clase();  
        }    
        else if (op.equals("2")){
            asiento = reserva.getAsientos_norm_clase();  
        
        }
        System.out.printf("Existen %d asiento disponibles\n",asiento.getDisponibles());
            int boletos=1000;
            while(boletos >0 && boletos > asiento.getDisponibles()){
                System.out.print("Ingrese cantidad de boletos a comprar: ");
                op  = scanner.next();
                if(Sistema.comprobarDigito(op )){
                   boletos = Integer.parseInt(op);
                }    
            }
            op="";
            String cliente;
            Cliente client;
            while(!op.equals("SI") && !op.equals("NO") && !op.equals("SALIR")){
                System.out.print("Tiene cuenta de cliente(SI / NO/ SALIR SI QUIERE ABORAR OPERACION): ");
                op = scanner.next().toUpperCase();
            }
            if(op.equals("SI")){
                cliente ="";
                while(Cliente.existeCliente(cliente) && !cliente.equals("SALIR")){
                    System.out.println("Ingrese cedula(SALIR SI QUIERE ABORAR OPERACION): ");
                    cliente = scanner.next().toUpperCase();}
                client = Cliente.devolverCliente(cliente);
            }
            else{ 
                client = Cliente.crearCliente();
            }
            int total = boletos * asiento.getPrecio() ;
            if(LocalDate.now().getDayOfYear() - client.getAñoNacimiento() < 2){
                System.out.println("Usted ha aplicado a un descuento de edad");
                total=total/2;
            }
            System.out.printf("El total es: %d\n dolares",total);
            op="";
            while(!op.equals("SI") && !op.equals("NO")){
                System.out.print("Desea aceptar la transaccion(SI / NO): ");
                op = scanner.next().toUpperCase();
            }
            if (op.equals("SI")){    
                Reserva r = new Reserva(reserva.getCod_vuelo(), LocalDate.now(),empleado.getUsuario(),total, boletos);
                while(boletos!=0){
                    r.getBoletos().add(new Boleto(client,asiento.generarPuesto()));
                    boletos--;
                }
                
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
    
    
    
    
}
