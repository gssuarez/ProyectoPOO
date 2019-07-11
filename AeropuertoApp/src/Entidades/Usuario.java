/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Homar Herrera
 */
public class Usuario extends Persona{
    
    private String password;
    private String usuario;   //3 primeras letras de nombre + 3 primeras letras de apellido + 4 ultimos digitos de la cedula
    private String email;
    private String rol;
    private String departamento;

    public Usuario(String cedula, String nombre, String apellido,String password,String rol,String departamento) {
        super(cedula, nombre, apellido);
        this.password=password;
        this.rol=rol;
        this.departamento = departamento;
        crearUsuario();
        crearCorreo();
    }
    
    public Usuario(String cedula, String nombre, String apellido,String email,String usuario,String password,String rol, String departamento) {
        super(cedula, nombre, apellido);
        this.password=password;
        this.rol=rol;
        this.departamento = departamento;
        this.usuario = usuario;
        this.email = email;
    }
    

    public void crearUsuario(){
        usuario=nombre.substring(0, 3)+ apellido.substring(0,3) + cedula.substring(6);
        System.out.printf("Su usuario es %s\n",usuario);
    }
    
    public void crearCorreo(){
        email= usuario + "@aeropuertoespol.com";
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    
    
    
}

