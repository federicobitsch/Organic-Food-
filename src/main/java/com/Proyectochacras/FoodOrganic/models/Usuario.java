package com.Proyectochacras.FoodOrganic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    private String email; // Cambia de 'username' a 'email'

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol role = Rol.USUARIO; // Asignar USUARIO por defecto


    //private boolean estado = true; // Por defecto, activo

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    //public boolean isEstado() {
    //    return estado;
    //}

    //public void setEstado(boolean estado) {
    //    this.estado = estado;
    //}
}
