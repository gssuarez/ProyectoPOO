package Sistema;


import Archivos.Archivo;
import Archivos.Encriptacion;
import Entidades.Aerolinea;
import Entidades.Avion;
import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Planificacion;
import Entidades.Usuario;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Homar Herrera
 */
public class Sistema {
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Avion> aviones =new ArrayList<>();
    public static ArrayList<Aerolinea> aerolineas = new ArrayList<>();
    public static ArrayList<Planificacion> planificaciones = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();


    public static void cargarDatos() throws UnsupportedEncodingException{
        cargarAerolineas();
        cargarUsuarios();
        cargarAviones();
        cargarClientes();
        Planificacion p = new Planificacion("#123235F", "#EDEA", LocalDateTime.of(2019, Month.MARCH, 24, 8, 0),
                LocalDateTime.of(2019, Month.MARCH, 24, 8, 0),  "GYE/Guayaquil","UIO/Quito", 200, 300,120,60);
       aerolineas.get(0).getPlanificaciones().add(p);
    }
    public static Usuario obtenerTipoUsuario(String user, String password) {
        Usuario u=null;
        for(Usuario usuario: usuarios){
            if(usuario.getUsuario().equals(user) && usuario.getPassword().equals(password)){
                u= usuario;
            } 
        }
        return u;
    }
    
    public static boolean ingresarCedula(String cedula){
        boolean control= true;
        if(Sistema.verificarCedula(cedula)){
            control = false;
        }
        for(Usuario usuario: Sistema.usuarios){
            if(usuario.getCedula().equals(cedula)){
                control = true;
            }
        }
        return control;
    }
    
    public static boolean verificarCedula(String c){
        boolean control  =  false;
        ArrayList<Integer> cedula = new ArrayList<>();
        for(int i=0;i<c.length();i++){
            cedula.add(Integer.parseInt(Character.toString(c.charAt(i))));
        }
        if(cedula.get(0)+cedula.get(1)<24 && cedula.get(0)+cedula.get(1)>0){
            if(cedula.get(2)<6){
                    int x = 0;
                    for (int i =0;i<cedula.size()-1;i++){
                        if(i%2 != 0){
                            x = x + cedula.get(i)*1;
                        }else{
                            int num = cedula.get(i)*2;
                            if (num>9){num=num-9;}
                            x = x + num;
                        }
                    }
                    
                    int t = x;
                    while(t%10!=0){
                        t++;}
                    if(t-x<=cedula.get(9)){
                        control = true;
                    }
                }
            }
        return control;
    }
    
    public static boolean comprobarDigito(String c){
        boolean control = true;
        for(int i=0;i<c.length();i++){
            if(!Character.isDigit(c.charAt(i))){
                control=false;
            }
        }
        return control;
    }
    
    
    private static void cargarUsuarios() throws UnsupportedEncodingException{
        for(String s: Archivo.usuarios){
            String [] st = s.split(",");
            if(st[6].equals("ADMINISTRADOR")){
                String password = Encriptacion.desencriptar(st[5]);
                usuarios.add(new Usuario(st[0],st[1],st[2],st[3],st[4],password,st[6],st[7]));
            }
            else if(st[6].equals("PLANIFICADOR") || st[6].equals("CAJERO")){
                String password = Encriptacion.desencriptar(st[5]);
                usuarios.add(new Empleado(st[0],st[1],st[2],st[3],st[4],password,st[6],st[7],st[8]));
            }
        }
    }
    private static void cargarAerolineas(){
        for(String s: Archivo.aerolineas){
            String [] st = s.split(",");
            aerolineas.add(new Aerolinea(st[0],Integer.parseInt(st[1])));
        }
    }
    private static void cargarAviones(){
        for(String s: Archivo.aviones){
            String [] st = s.split(",");
            aviones.add(new Avion(st[0],st[1],st[2],Integer.parseInt(st[3]),Integer.parseInt(st[4]),Integer.parseInt(st[5]),st[6]));
        }
        for(Avion a: aviones){
            for(Aerolinea aerolinea: aerolineas){
                if(a.getAerolinea().equals(aerolinea.getNombre())){
                    aerolinea.getAviones().add(a);
                }
                
            }
        }
    }
    private static void cargarClientes(){
        for(String s: Archivo.clientes){
            String [] st = s.split(",");
            clientes.add(new Cliente(st[0],st[1],st[2],Integer.parseInt(st[3])));
        }
    }
    
    
    public static void guardarDatos(){
        try {
            guardarUsuario();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        guardarAerolinea();
        guardarAvion();
    }
    
    private static void guardarUsuario() throws UnsupportedEncodingException{
        ArrayList<String> total = new ArrayList<>();
        for(Usuario usuario: usuarios){
            String data= usuario.getCedula()+ "," + usuario.getNombre()+ "," + usuario.getApellido() + ","+ usuario.getEmail()+ "," + usuario.getUsuario() + ","+ Encriptacion.encriptar(usuario.getPassword())+ "," + usuario.getRol() + ","+ usuario.getDepartamento();
            if(usuario.getDepartamento().equalsIgnoreCase("COMERCIAL")){
                Empleado e= (Empleado) usuario;
                 data =  data.concat("," + e.getAerolinea().getNombre());
            }
            total.add(data);
        }
        Archivo.guardarArchivo(total, Archivo.direccionUsuario);
    }
    
    private static void guardarAerolinea(){
        ArrayList<String> total = new ArrayList<>();
        for(Aerolinea aerolinea : aerolineas){
            String data = aerolinea.getNombre() + "," + aerolinea.getId();
            total.add(data);
        }
        Archivo.guardarArchivo(total, Archivo.direccionAerolinea);
    }
    private static void guardarCliente(){
        ArrayList<String> total = new ArrayList<>();
        for(Cliente cliente : clientes){
            String data = cliente.getCedula() + "," + cliente.getNombre() + "," + cliente.getApellido() + "," + String.valueOf(cliente.getAñoNacimiento()) ;
            total.add(data);
        }
        Archivo.guardarArchivo(total, Archivo.direccionCliente);
    }
    
    private static void guardarAvion(){
        ArrayList<String> total = new ArrayList<>();
        for(Avion avion : aviones){
            String data = avion.getN_serie() + "," + avion.getFabricante() + "," + avion.getModelo() + "," + String.valueOf(avion.getAsientos_prim_clase()) + "," 
                    + String.valueOf(avion.getAsientos_norm_clase()) + "," +  String.valueOf(avion.getDistanciaKm()) + "," + avion.getAerolinea();
            total.add(data);
        }
        Archivo.guardarArchivo(total, Archivo.direccionAvion);
    }
}
