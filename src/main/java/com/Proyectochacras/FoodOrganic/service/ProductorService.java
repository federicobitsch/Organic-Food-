package com.Proyectochacras.FoodOrganic.service;

import com.Proyectochacras.FoodOrganic.models.Productor;
import com.Proyectochacras.FoodOrganic.repositories.ProductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductorService {

    @Autowired
    private ProductorRepository productorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Obtener todos los productores
    public List<Productor> obtenerTodosLosProductores() {
        return productorRepository.findAll(); // Devuelve todos los productores
    }

    // Crear un productor
    public Productor crearProductor(Productor productor) {
        // Encriptar la contraseña antes de guardar
        String encryptedPassword = passwordEncoder.encode(productor.getContrasena());
        productor.setContrasena(encryptedPassword);
        return productorRepository.save(productor);
    }

    public void registrarProductor(Productor productor) {
        // Codificar la contraseña antes de guardarla
        productor.setContrasena(passwordEncoder.encode(productor.getContrasena()));
        // Guardar el productor en la base de datos
        productorRepository.save(productor);
    }

    // Metodo para obtener un productor por ID
    public Optional<Productor> obtenerProductorPorId(Long id) {
        return productorRepository.findById(id);
    }

    // Metodo para modificar un productor existente
    public void modificarProductor(Long id, Productor productor) throws Exception {
        Optional<Productor> productorExistente = productorRepository.findById(id);

        if (productorExistente.isEmpty()) {
            throw new Exception("El productor con ID " + id + " no existe");
        }

        Productor productorAModificar = productorExistente.get();

        productorAModificar.setCorreo(productor.getCorreo());
        productorAModificar.setContrasena(productor.getContrasena());
        productorAModificar.setRol(productor.getRol());

        productorRepository.save(productorAModificar);
    }

    // Metodo para eliminar un productor
    public void eliminarProductor(Long id) throws Exception {
        Optional<Productor> productorExistente = productorRepository.findById(id);

        if (productorExistente.isEmpty()) {
            throw new Exception("El productor con ID " + id + " no existe");
        }

        productorRepository.deleteById(id);
    }
}
