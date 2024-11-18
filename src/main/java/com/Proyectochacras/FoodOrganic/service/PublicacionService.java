package com.Proyectochacras.FoodOrganic.service;

import com.Proyectochacras.FoodOrganic.models.EstadoChacra;
import com.Proyectochacras.FoodOrganic.models.EstadoPublicacion;
import com.Proyectochacras.FoodOrganic.models.Publicacion;
import com.Proyectochacras.FoodOrganic.models.Productor;
import com.Proyectochacras.FoodOrganic.repositories.ProductorRepository;
import com.Proyectochacras.FoodOrganic.repositories.PublicacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private ProductorRepository productorRepository;  // Inyectamos el repositorio de Productor

    // Crear una nueva publicación
    public void crearPublicacion(Long productorId, String nombreChacra, String descripcion, String ubicacionChacra, String estado) throws Exception {
        Productor productor = productorRepository.findById(productorId).orElseThrow(() -> new Exception("Productor no encontrado"));
        Publicacion publicacion = new Publicacion();
        publicacion.setNombreChacra(nombreChacra);
        publicacion.setDescripcion(descripcion);
        publicacion.setUbicacionChacra(ubicacionChacra);
        publicacion.setEstado(EstadoChacra.valueOf(estado));
        publicacion.setProductor(productor);

        publicacionRepository.save(publicacion);
    }


    // Obtener todas las publicaciones
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAll();
    }

    // Obtener una publicación por ID
    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }


    // Modificar una publicación existente
    public Publicacion modificarPublicacion(Long id, Publicacion publicacion) {
        Optional<Publicacion> publicacionOpt = publicacionRepository.findById(id);
        if (publicacionOpt.isPresent()) {
            Publicacion publicacionExistente = publicacionOpt.get();
            publicacionExistente.setNombreChacra(publicacion.getNombreChacra());
            publicacionExistente.setDescripcion(publicacion.getDescripcion());
            publicacionExistente.setUbicacionChacra(publicacion.getUbicacionChacra());
            publicacionExistente.setEstado(publicacion.getEstado());
            return publicacionRepository.save(publicacionExistente);
        }
        return null; // Devuelve null si la publicación no existe
    }


//    // Eliminar una publicación por ID
//    //public boolean eliminarPublicacion(Long id) {
//        Optional<Publicacion> publicacionOpt = publicacionRepository.findById(id);
//        if (publicacionOpt.isPresent()) {
//            publicacionRepository.deleteById(id);
//            return true;
//        }
//        return false; // Si no se encuentra la publicación
//    }

    //Eliminar (soft delete) una publicación (cambiar el estado a ELIMINADA)
    public boolean eliminarPublicacion(Long id) {
     Publicacion publicacion = publicacionRepository.findById(id).orElse(null);
      if (publicacion != null) {
          publicacion.setEstadoPublicacion(EstadoPublicacion.ELIMINADA); // Cambiar el estado
          publicacionRepository.save(publicacion); // Guardar la publicación con el estado actualizado
          return true;
      }
      return false;
  }
}



//Login simple
//registro y login hacerlo 

