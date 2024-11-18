package com.Proyectochacras.FoodOrganic.service;

import com.Proyectochacras.FoodOrganic.models.Usuario;
import com.Proyectochacras.FoodOrganic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Metodo para guardar un usuario
    public void saveUsuario(Usuario usuario) {
        // Aquí puedes agregar lógica adicional, como encriptar la contraseña si es necesario
        usuarioRepository.save(usuario); // Guardar el usuario en la base de datos
    }


    public boolean autenticarUsuario(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return true; // Usuario autenticado con éxito
        }
        return false; // Credenciales incorrectas
    }
}