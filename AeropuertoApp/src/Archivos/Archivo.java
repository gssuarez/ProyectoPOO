/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Entidades.Asiento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Homar Herrera
 */
public class Archivo {
    
    public final static String direccionUsuario = "src/Archivos/usuarios.txt";
    public final static String direccionAerolinea = "src/Archivos/aerolineas.txt";
    public final static String direccionAvion = "src/Archivos/aviones.txt";
    public final static String direccionCliente = "src/Archivos/clientes.txt";
    public final static String direccionAsiento = "src/Archivos/asientos.txt";
    public static ArrayList<String> usuarios = Archivo.leerArchivo(direccionUsuario);
    public static ArrayList<String> aerolineas = Archivo.leerArchivo(direccionAerolinea);
    public static ArrayList<String> aviones = Archivo.leerArchivo(direccionAvion);
    public static ArrayList<String> clientes = Archivo.leerArchivo(direccionCliente);
    public static ArrayList<String> asientos = Archivo.leerArchivo(direccionAsiento);


    
    
    public static ArrayList<String> leerArchivo (String arc){
        ArrayList<String> archivos= new ArrayList<>();
        File archivo = new File (arc);
        FileReader fr = null;
        try {
            fr = new FileReader (archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        String linea;
        try {
             while((linea=br.readLine())!=null){archivos.add(linea);}
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return archivos;
    }
    
    public static void guardarArchivo (ArrayList<String> a,String arc){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(arc);
            pw = new PrintWriter(fichero);
            for(String string: a){
                pw.println(string);
            }

 
        } catch (Exception e) {
        	e.printStackTrace();
        } 
        finally {
            try {
                if (null != fichero)
                    fichero.close();
            } 
            catch (Exception e2) {
                    e2.printStackTrace();
            }
        }
    }
}

