package com.Proyectochacras.FoodOrganic.service;

import com.Proyectochacras.FoodOrganic.models.Rol;
import com.Proyectochacras.FoodOrganic.models.Usuario;
import com.Proyectochacras.FoodOrganic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

@Service
public class CustomProductorDetailsService implements UserDetailsService{

    private UsuarioRepository usuarioRepository;

    @Autowired
   CustomProductorDetailsService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;

    }

    //sobreescribe el metodo por default para poder usar un usuario custom
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmailAndRole(email, Rol.USUARIO)
                .orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado: " + email));

        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getPassword(),
                //ademas de los parametros usuario y contraseña de arriba, se pasan estos otros
                //si cualquiera de estos es false entonces no pasa el usuario
                true, // la cuenta esta habilitada
                true, // la cuenta no expiro
                true, // las credenciales no expiraron
                true, // la cuenta no esta bloqueada
                List.of(new SimpleGrantedAuthority("ROL_USUARIO")) // asigna el rol predeterminado
        );
    }


}
