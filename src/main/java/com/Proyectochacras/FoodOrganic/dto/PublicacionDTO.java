package com.Proyectochacras.FoodOrganic.dto;

import com.Proyectochacras.FoodOrganic.models.EstadoChacra;

public class PublicacionDTO {

    private Long id;
    private String nombreChacra;
    private String descripcion;
    private String ubicacionChacra;
    private EstadoChacra estado;
    private Long productorId;

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

    public Long getProductorId() {
        return productorId;
    }

    public void setProductorId(Long productorId) {
        this.productorId = productorId;
    }
}
