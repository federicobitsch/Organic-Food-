package com.Proyectochacras.FoodOrganic.repositories;

import com.Proyectochacras.FoodOrganic.models.Productor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductorRepository extends JpaRepository<Productor, Long> {
    // Metodo para buscar un productor por correo
    Optional<Productor> findByCorreo(String correo);
}
