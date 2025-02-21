package com.Proyectochacras.FoodOrganic.controllers;

import com.Proyectochacras.FoodOrganic.models.Usuario;
import com.Proyectochacras.FoodOrganic.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {

    private final UsuarioService usuariosService;

    @Autowired
    public IndexController(UsuarioService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/index")
    //model es un objeto de spring que se utiliza para pasar informacion a la vista actual
    //es como cuando se pasa el contexto

    //principal es un objeto de spring que trae la info del
    //usuario que esta logeado
    public String indexPage(Model model, Principal principal) {

        if (principal != null) { //si es distinto a null obtenemos el nombre de usuario
            String email = principal.getName();

            //El email es tambien el nombre de usuario
            // utilizo el servicio para sacar la info del usuario a partir del mail
            Usuario usuario = usuariosService.autenticarUsuario(email);
            if (usuario != null) {
                // el atributo del nombre de usuario lo pasamos al "contexto"
                // en caso de que queramos mostrarlo en la pagina

                //informacion de usuario
                model.addAttribute("usuario", usuario.getEmail());
            }
        }
        //me redirecciona a templates/index.html
        return "index.html";
    }
}