package com.Proyectochacras.FoodOrganic.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreChacra;
    private String descripcion;
    private String ubicacionChacra;

    @Enumerated(EnumType.STRING)
    private EstadoChacra estado; // Estado de la chacra (DISPONIBLE, OCUPADO)

    @Enumerated(EnumType.STRING)
    private EstadoPublicacion estadoPublicacion; // Estado de la publicación (ACTIVA, ELIMINADA)

    @ManyToOne
    @JoinColumn(name = "productor_id")
    @JsonBackReference // Evitar referencia circular con JSON
    private Productor productor; // Relación con Productor

    // Constructor vacío
    public Publicacion() {}

    // Constructor con parámetros
    public Publicacion(String nombreChacra, String descripcion, String ubicacionChacra, EstadoChacra estado, EstadoPublicacion estadoPublicacion, Productor productor) {
        this.nombreChacra = nombreChacra;
        this.descripcion = descripcion;
        this.ubicacionChacra = ubicacionChacra;
        this.estado = estado;
        this.estadoPublicacion = estadoPublicacion; // Se inicializa el estado de publicación
        this.productor = productor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreChacra() {
        return nombreChacra;
    }

    public void setNombreChacra(String nombreChacra) {
        this.nombreChacra = nombreChacra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacionChacra() {
        return ubicacionChacra;
    }

    public void setUbicacionChacra(String ubicacionChacra) {
        this.ubicacionChacra = ubicacionChacra;
    }

    public EstadoChacra getEstado() {
        return estado;
    }

    public void setEstado(EstadoChacra estado) {
        this.estado = estado;
    }

    public EstadoPublicacion getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
}
