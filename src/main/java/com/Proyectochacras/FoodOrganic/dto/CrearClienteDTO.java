package com.Proyectochacras.FoodOrganic.dto;

public class CrearClienteDTO {
    private String nombre;
    private String apellido;
    private String password;
    private String correo;

    public CrearClienteDTO() {}


    public CrearClienteDTO(String nombre,String apellido,String password,String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
