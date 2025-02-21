package com.Proyectochacras.FoodOrganic.service;

import com.Proyectochacras.FoodOrganic.models.Rol;
import com.Proyectochacras.FoodOrganic.models.Usuario;
import com.Proyectochacras.FoodOrganic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncode;

    // Metodo para guardar un usuario
    public Usuario saveUsuario(Usuario usuario) {
        // Encriptar la contraseña
        String encryptedPassword = passwordEncode.encode(usuario.getPassword());
        usuario.setPassword(encryptedPassword);

        // Si no se establece un rol, asignar el rol por defecto
        if (usuario.getRole() == null) {
            usuario.setRole(Rol.USUARIO);
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String email) {
        return usuarioRepository.findByEmail(email); // Devuelve el usuario asociado al email
    }
}