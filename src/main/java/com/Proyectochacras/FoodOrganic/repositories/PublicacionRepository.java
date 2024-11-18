package com.Proyectochacras.FoodOrganic.repositories;

import com.Proyectochacras.FoodOrganic.models.Publicacion;
import com.Proyectochacras.FoodOrganic.models.EstadoPublicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    // Metodo para encontrar publicaciones que no estén eliminadas

    List<Publicacion> findByEstadoPublicacionNot(EstadoPublicacion estadoPublicacion);
}
